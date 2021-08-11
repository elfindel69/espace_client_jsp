package fr.humanbooster.fx.espace_client.servlets;

import fr.humanbooster.fx.espace_client.service.CarteBancaireService;
import fr.humanbooster.fx.espace_client.service.ClientService;
import fr.humanbooster.fx.espace_client.service.FactureService;
import fr.humanbooster.fx.espace_client.service.impl.CarteBancaireServiceImpl;
import fr.humanbooster.fx.espace_client.service.impl.ClientServiceImpl;
import fr.humanbooster.fx.espace_client.service.impl.FactureServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@WebServlet(urlPatterns = { "/init"}, loadOnStartup = 1)
public class InitServlet extends HttpServlet {
    private ClientService clientService = new ClientServiceImpl();
    private FactureService factureService = new FactureServiceImpl();
    private CarteBancaireService carteBancaireService = new CarteBancaireServiceImpl();

    public void init(){
        if(clientService.recupererClients().isEmpty()){
            for(int i=1;i<11;i++){
                clientService.ajouterClient("Client"+i,"Client"+i,"client"+i+"@hb.fr","client"+i);
            }
        }

        if(carteBancaireService.recupererCartesBancaires(1L).isEmpty()){
            for (int i=1;i<21;i++){
                Long rand = ThreadLocalRandom.current().nextLong(1, 11);
                String nbCarteString = "0";
                if(i<10){
                    nbCarteString = "497784844200400"+i;
                }else{
                    nbCarteString = "49778484420040"+i;
                }

                carteBancaireService.ajouterCarteBancaire(nbCarteString,2022,rand.intValue(),"123",rand);
            }
        }

        if(factureService.recupererFactures().isEmpty()){
            for (int i=1;i<101;i++){
                Long rand = ThreadLocalRandom.current().nextLong(1, 11);
                factureService.ajouterFacture(rand,new Date(),20);
            }
        }

    }
}
