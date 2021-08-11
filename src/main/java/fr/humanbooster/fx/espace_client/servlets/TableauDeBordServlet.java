package fr.humanbooster.fx.espace_client.servlets;

import fr.humanbooster.fx.espace_client.business.CarteBancaire;
import fr.humanbooster.fx.espace_client.business.Client;
import fr.humanbooster.fx.espace_client.business.Facture;
import fr.humanbooster.fx.espace_client.service.CarteBancaireService;
import fr.humanbooster.fx.espace_client.service.ClientService;
import fr.humanbooster.fx.espace_client.service.FactureService;
import fr.humanbooster.fx.espace_client.service.impl.CarteBancaireServiceImpl;
import fr.humanbooster.fx.espace_client.service.impl.ClientServiceImpl;
import fr.humanbooster.fx.espace_client.service.impl.FactureServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "TableauDeBordServlet", value = "/tableauDeBord")
public class TableauDeBordServlet extends HttpServlet {
    private ClientService clientService = new ClientServiceImpl();
    private FactureService factureService = new FactureServiceImpl();
    private CarteBancaireService carteBancaireService = new CarteBancaireServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client client = (Client)request.getSession().getAttribute("client");
        System.out.println("client: "+client);
        List<Facture> facturesARegler = factureService.recupererFacturesARegler(client.getId());
        request.setAttribute("facturesARegler",facturesARegler);
        List<Facture> facturesReglees = factureService.recupererFacturesReglees(client.getId());
        request.setAttribute("facturesReglees",facturesReglees);
        List<CarteBancaire> carteBancaires = carteBancaireService.recupererCartesBancaires(client.getId());
        request.setAttribute("cartesBancaires",carteBancaires);

        request.getRequestDispatcher("WEB-INF/tableauDeBord.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
