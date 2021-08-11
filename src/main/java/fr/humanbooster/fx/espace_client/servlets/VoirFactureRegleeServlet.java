package fr.humanbooster.fx.espace_client.servlets;

import fr.humanbooster.fx.espace_client.business.Facture;
import fr.humanbooster.fx.espace_client.service.FactureService;
import fr.humanbooster.fx.espace_client.service.impl.FactureServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "VoirFactureRegleeServlet", value = "/voirFactureReglee")
public class VoirFactureRegleeServlet extends HttpServlet {
    private FactureService factureService = new FactureServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Facture facture = factureService.recupererFacture(id);
        request.setAttribute("facture", facture);
        request.getRequestDispatcher("WEB-INF/voirFactureReglee.jsp").forward(request,response);
    }
}
