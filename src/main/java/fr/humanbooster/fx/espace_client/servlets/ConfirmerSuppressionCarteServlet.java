package fr.humanbooster.fx.espace_client.servlets;

import fr.humanbooster.fx.espace_client.business.Client;
import fr.humanbooster.fx.espace_client.service.CarteBancaireService;
import fr.humanbooster.fx.espace_client.service.impl.CarteBancaireServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ConfirmerSuppressionCarteServlet", value = "/confirmerSuppressionCarte")
public class ConfirmerSuppressionCarteServlet extends HttpServlet {

    private CarteBancaireService carteBancaireService = new CarteBancaireServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idCarte = Long.parseLong(request.getParameter("idCarte"));
        Client client = (Client) request.getSession().getAttribute("client");
       carteBancaireService.supprimerCarteBancaire(idCarte, client.getId());
       response.sendRedirect("tableauDeBord");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
