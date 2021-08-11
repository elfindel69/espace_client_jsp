package fr.humanbooster.fx.espace_client.servlets;

import fr.humanbooster.fx.espace_client.business.Client;
import fr.humanbooster.fx.espace_client.service.ClientService;
import fr.humanbooster.fx.espace_client.service.impl.ClientServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ConnexionServlet", value = "/connexion")
public class ConnexionServlet extends HttpServlet {

    private ClientService clientService = new ClientServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Client client = clientService.recupererClient(email,password);
        if(client != null){
            request.getSession().setAttribute("client",client);
            response.sendRedirect("tableauDeBord");
        }else{
            request.setAttribute("erreur","email ou mot de passe incorrect");
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
        }
    }
}
