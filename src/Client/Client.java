package Client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;
import br.com.correios.bsb.sigep.master.bean.cliente.SQLException_Exception;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;

public class Client {

	public static void main(String[] args) throws MalformedURLException, SQLException_Exception, SigepClienteException {
		// TODO Auto-generated method stub
		 URL url = new URL("https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl");
	
		 QName qname = new QName("http://cliente.bean.master.sigep.bsb.correios.com.br/", "AtendeClienteService");
	
		 Service ws = Service.create(url, qname);
		 
		 AtendeCliente client = ws.getPort(AtendeCliente.class);
		 
		 EnderecoERP address = client.consultaCEP("18550029");
		 
		 System.out.println("Endereço: " + address.getEnd());
		 System.out.println("Bairro: " + address.getBairro());
		 System.out.println("Cidade: " + address.getCidade());
		 System.out.println("Cep: " + address.getCep());

	}

}
