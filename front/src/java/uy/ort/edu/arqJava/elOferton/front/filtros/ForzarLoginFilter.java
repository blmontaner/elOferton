/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.ort.edu.arqJava.elOferton.front.filtros;

import java.io.IOException;
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

/**
 *
 * @author Rodrigo
 */
public class ForzarLoginFilter implements Filter{
    
     private static final String PAGINA_LOGIN = "login.xhtml";

    public ForzarLoginFilter() {
    }

    private static boolean chequearEstadoLogin(ServletRequest request,
            ServletResponse response) throws IOException, ServletException {

        boolean usuarioLogueado = false;

        HttpSession session = ((HttpServletRequest) request).getSession(false);

        if(session != null && session.getAttribute("nombreUsuario") != null) {
            usuarioLogueado = true;
        }

        return usuarioLogueado;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        boolean estaLogueado = chequearEstadoLogin(request, response);

        if (esRedireccion((HttpServletRequest) request) && !estaLogueado) {

            String loginURI = PAGINA_LOGIN;

            RequestDispatcher requestDispatcher = request
                    .getRequestDispatcher(loginURI);

            requestDispatcher.forward(request, response);

            //((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath() + "http://localhost/front/index.xhtml");
                       
        } else {
            try {
                chain.doFilter(request, response);
            } catch (Throwable t) {
                System.out.println(t.getMessage());
            }
        }
    }

    private boolean esRedireccion(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return (!requestURI.contains(PAGINA_LOGIN));
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    
    }

    @Override
    public void destroy() {
   
    }
    
}
