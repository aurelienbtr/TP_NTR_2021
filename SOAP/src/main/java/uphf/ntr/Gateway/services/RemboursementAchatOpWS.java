package uphf.ntr.Gateway.services;

import java.io.StringReader;

import javax.jws.WebService;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import uphf.ntr.Gateway.Operation;
import org.xml.sax.InputSource;

@WebService(endpointInterface = "uphf.ntr.Gateway.services.RemboursementAchatOpeImp")
public class RemboursementAchatOpWS implements RemboursementAchatOpeInterface {

	
	//test service hello world
	//@Override
	public String testHello(String nom) {
		
		return "Hello " + nom;
	}
	

	public String remboursement(int idOrigin, int somme) {
		String retour = "";
		String uri = "http://localhost:8080/BanqueNTR/utilisateurs" + idOrigin +"/credit/" + somme; 
		try {
			Client clientWeb = ClientBuilder.newBuilder().register(Operation.class).build();
			WebTarget webTarget = clientWeb.target(uri);
			Response reponse = webTarget.request().accept("application/xml").post(Entity.xml(new Operation(idOrigin,1 ,somme)));
			if(reponse.getStatusInfo().equals(Response.Status.OK)) {
				XPathFactory xpathFactory = XPathFactory.newInstance();
				XPath xpath = xpathFactory.newXPath();

				InputSource source = new InputSource(new StringReader(reponse.readEntity(String.class)));
				String status = "Remboursement effectué\n(" + xpath.evaluate("/message", source) + ")";
				retour = status;
			}else {
				XPathFactory xpathFactory = XPathFactory.newInstance();
				XPath xpath = xpathFactory.newXPath();

				InputSource source = new InputSource(new StringReader(reponse.readEntity(String.class)));
				String status = xpath.evaluate("/erreur", source);
				retour = "Erreur: " + status;
			}
			reponse.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retour;
	}
	
	
	public String achat(int idOrigin, int somme) {
		String retour = "";
    	String uri = "http://localhost:8080/BanqueNTR/utilisateurs/" + idOrigin +"/debit/" + somme; 
		try {
			javax.ws.rs.client.Client clientWeb = ClientBuilder.newBuilder().register(Operation.class).build();
			WebTarget webTarget = clientWeb.target(uri);
			Response reponse = webTarget.request().accept("application/xml").post(Entity.xml(new Operation(idOrigin,0,somme)));
			if(reponse.getStatusInfo().equals(Response.Status.OK)) {
				XPathFactory xpathFactory = XPathFactory.newInstance();
				XPath xpath = xpathFactory.newXPath();

				InputSource source = new InputSource(new StringReader(reponse.readEntity(String.class)));
				String status = "Achat effectué\n(" + xpath.evaluate("/message", source) + ")";
				retour = status;
			} else  {
				XPathFactory xpathFactory = XPathFactory.newInstance();
				XPath xpath = xpathFactory.newXPath();

				InputSource source = new InputSource(new StringReader(reponse.readEntity(String.class)));
				String status = xpath.evaluate("/erreur", source);
				retour = "Erreur: " + status;
			}
			reponse.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retour;
	}
}
