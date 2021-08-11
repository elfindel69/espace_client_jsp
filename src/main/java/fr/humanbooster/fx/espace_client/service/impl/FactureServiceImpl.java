package fr.humanbooster.fx.espace_client.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.espace_client.business.Client;
import fr.humanbooster.fx.espace_client.business.Facture;
import fr.humanbooster.fx.espace_client.service.ClientService;
import fr.humanbooster.fx.espace_client.service.FactureService;

public class FactureServiceImpl implements FactureService {

	private static List<Facture> factures = new ArrayList<>();
	private ClientService clientService = new ClientServiceImpl();
	
	@Override
	public Facture ajouterFacture(Long idClient, Date dateEcheance, float montantEnEuros) {
		Client client = clientService.recupererClient(idClient);
		Facture facture = new Facture(client);
		facture.setDateEcheance(dateEcheance);
		facture.setMontantEnEuros(montantEnEuros);
		factures.add(facture);
		return facture;
	}

	@Override
	public List<Facture> recupererFactures() {
		return factures;
	}

	@Override
	public Facture recupererFacture(Long id) {
		for (Facture facture : factures) {
			if (facture.getId() == id)
				return facture;
		}
		return null;
	}

	@Override
	public List<Facture> recupererFacturesARegler(Long idClient) {
		List<Facture> facturesARegler = new ArrayList<>();
		for (Facture facture : factures) {
			if (facture.getClient().getId()==idClient) {
				if (facture.getTotalPaiementsRecus()<facture.getMontantEnEuros()) {
					facturesARegler.add(facture);
				}
			}
		}
		return facturesARegler;
	}

	@Override
	public List<Facture> recupererFacturesReglees(Long idClient) {
		List<Facture> facturesReglees = new ArrayList<>();
		for (Facture facture : factures) {
			if (facture.getClient().getId()==idClient) {
				if (facture.getTotalPaiementsRecus()==facture.getMontantEnEuros()) {
					facturesReglees.add(facture);
				}
			}
		}
		return facturesReglees;
	}

}