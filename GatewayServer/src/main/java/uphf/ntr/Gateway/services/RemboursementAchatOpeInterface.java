package uphf.ntr.Gateway.services;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface RemboursementAchatOpeInterface {
	@WebMethod
	public String testHello(String nom);
	
	@WebMethod
	public String remboursement(int idOrigin, int somme);
	
	@WebMethod
	public String achat(int idOrigin, int somme);
	
}