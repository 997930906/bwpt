package bwpt.webservice;

import javax.jws.WebService;

@WebService
public interface WsService {
	public String exportE(String jsonStr) throws Exception;
}
