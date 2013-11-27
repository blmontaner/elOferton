/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.front.filtros;

import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.render.Renderer;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Rodrigo
 */
public class ForzarLoginFilter implements Filter {

    private static final String PAGINA_LOGIN = "login.xhtml";
    private static final String PAGINA_INDEX = "index.xhtml";

    public ForzarLoginFilter() {
    }

    private static boolean chequearEstadoLogin(ServletRequest request,
            ServletResponse response) throws IOException, ServletException {

        boolean usuarioLogueado = false;

        HttpSession session = ((HttpServletRequest) request).getSession(false);

        if (session != null && session.getAttribute("nombreUsuario") != null) {
            usuarioLogueado = true;
        }

        return usuarioLogueado;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        if (necesitaRedireccion((HttpServletRequest) request)) {

            boolean estaLogueado = chequearEstadoLogin(request, response);

            if (esRedireccion((HttpServletRequest) request) && !estaLogueado) {

                String loginURI = PAGINA_LOGIN;

                RequestDispatcher requestDispatcher = request
                        .getRequestDispatcher(loginURI);

                requestDispatcher.forward(request, response);

                //((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath() + "http://localhost/front/index.xhtml");

            } else {
                try {
                    if (esPaginaPdf((HttpServletRequest) request)) {
                        ContentCaptureServletResponse capContent = new ContentCaptureServletResponse((HttpServletResponse)response);  
                        chain.doFilter(request, capContent);
                        StringReader contentReader = new StringReader(capContent.getContent());
                        InputSource source = new InputSource(contentReader);
                        
                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
                        Document xhtmlContent =  (Document) documentBuilder.parse(source);
                        
                        ITextRenderer renderer = new ITextRenderer();
                        renderer.setDocument( xhtmlContent, "");
                        renderer.layout();
                        response.setContentType("application/pdf");
                        OutputStream browserStream = response.getOutputStream();
                        renderer.createPDF(browserStream);
                    }else{
                        chain.doFilter(request, response);
                    }
                } catch (IOException | ServletException | ParserConfigurationException | SAXException | DocumentException t) {
                    System.out.println(t.getMessage());
                }
            }
        }
    }

    private boolean necesitaRedireccion(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return !(requestURI.contains(PAGINA_INDEX) || requestURI.contains(PAGINA_LOGIN) || requestURI.isEmpty());
    }

    private boolean esRedireccion(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return (!requestURI.contains(PAGINA_LOGIN));
    }

    private boolean esPaginaPdf(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return (requestURI.contains("compraPdf"));
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
