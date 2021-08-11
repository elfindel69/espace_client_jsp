package fr.humanbooster.fx.espace_client.servlets;

import fr.humanbooster.fx.espace_client.business.CarteBancaire;
import fr.humanbooster.fx.espace_client.service.CarteBancaireService;
import fr.humanbooster.fx.espace_client.service.ClientService;
import fr.humanbooster.fx.espace_client.service.impl.CarteBancaireServiceImpl;
import fr.humanbooster.fx.espace_client.service.impl.ClientServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AjouterCarteServlet", value = "/ajouterCarte")
public class AjouterCarteServlet extends HttpServlet {
    private ClientService clientService = new ClientServiceImpl();
    private CarteBancaireService carteBancaireService = new CarteBancaireServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        System.out.println(id);
        List<Integer> moisList = new ArrayList<>();
        for (int i=1;i<13;i++){
            moisList.add(i);
        }
        request.setAttribute("moisList",moisList);
        int annee = Year.now().getValue();;
        List<Integer> annees = new ArrayList<>();
        for (int i=0;i<6;i++){
            annees.add((annee + i));
        }
        request.setAttribute("annees",annees);
        request.setAttribute("id",id);
        request.getRequestDispatcher("WEB-INF/ajouterCarte.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String numero = request.getParameter("numero");
        int moisExpiration = Integer.parseInt(request.getParameter("moisExpiration"));
        int anneeExpiration = Integer.parseInt(request.getParameter("anneeExpiration"));
        String cryptogramme = request.getParameter("cryptogramme");

        CarteBancaire carteBancaire = carteBancaireService.ajouterCarteBancaire(numero,anneeExpiration,moisExpiration,cryptogramme,id);
        response.sendRedirect("tableauDeBord");
    }
}
