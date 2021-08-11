package fr.humanbooster.fx.espace_client.servlets;


import fr.humanbooster.fx.espace_client.business.CarteBancaire;
import fr.humanbooster.fx.espace_client.business.Client;
import fr.humanbooster.fx.espace_client.business.Facture;
import fr.humanbooster.fx.espace_client.service.CarteBancaireService;
import fr.humanbooster.fx.espace_client.service.FactureService;
import fr.humanbooster.fx.espace_client.service.PaiementService;
import fr.humanbooster.fx.espace_client.service.impl.CarteBancaireServiceImpl;
import fr.humanbooster.fx.espace_client.service.impl.FactureServiceImpl;
import fr.humanbooster.fx.espace_client.service.impl.PaiementServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ReglerFactureServlet", value = "/reglerFacture")
public class ReglerFactureServlet extends HttpServlet {
    private FactureService factureService = new FactureServiceImpl();
    private CarteBancaireService carteBancaireService = new CarteBancaireServiceImpl();
    private PaiementService paiementService = new PaiementServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Long id = Long.parseLong(request.getParameter("id"));
       Client client = (Client) request.getSession().getAttribute("client");
       Facture facture = factureService.recupererFacture(id);
       request.setAttribute("facture", facture);

       List<CarteBancaire> cartes = carteBancaireService.recupererCartesBancaires(client.getId());
       request.setAttribute("cartes", cartes);

       request.getRequestDispatcher("WEB-INF/reglerFacture.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Long idCarte = Long.parseLong(request.getParameter("idCarte"));
        float montant = Float.parseFloat(request.getParameter("montant"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateEffective = null;
        try{
            dateEffective = sdf.parse(request.getParameter("dateEffective"));
        }catch (Exception e){
            e.printStackTrace();
        }

        paiementService.ajouterPaiement(id,idCarte,montant,dateEffective);

        response.sendRedirect("tableauDeBord");
    }

}
