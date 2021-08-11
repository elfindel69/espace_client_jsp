package fr.humanbooster.fx.espace_client.servlets;

import fr.humanbooster.fx.espace_client.business.CarteBancaire;
import fr.humanbooster.fx.espace_client.business.Facture;
import fr.humanbooster.fx.espace_client.business.Paiement;
import fr.humanbooster.fx.espace_client.service.CarteBancaireService;
import fr.humanbooster.fx.espace_client.service.FactureService;
import fr.humanbooster.fx.espace_client.service.impl.CarteBancaireServiceImpl;
import fr.humanbooster.fx.espace_client.service.impl.FactureServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SupprimerCarteServlet", value = "/supprimerCarte")
public class SupprimerCarteServlet extends HttpServlet {

    private CarteBancaireService carteBancaireService = new CarteBancaireServiceImpl();
    private FactureService factureService = new FactureServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idCarte = Long.parseLong(request.getParameter("idCarte"));

        CarteBancaire carteBancaire = carteBancaireService.recupererCarteBancaire(idCarte);
        boolean used = false;
        for (Facture facture: factureService.recupererFactures()) {
            for (Paiement paiement: facture.getPaiements()) {
                if(paiement.getCarteBancaire().getId() == idCarte){
                    used = true;
                }
            }
        }
        if(used){
            request.setAttribute("erreur","Cette carte ne peut pas être supprimée car elle a été utilisée \n" +
                    "pour des paiements");
        }
        request.setAttribute("numero",carteBancaire.getNumero());
        request.setAttribute("idCarte",carteBancaire.getId());
        request.getRequestDispatcher("WEB-INF/supprimerCarte.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
