package com.example.ws.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import calculator.wsdl.Add;
import calculator.wsdl.AddResponse;

public class CalculatorClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CalculatorClient.class);

	public int add(int a, int b) {
		Add request = new Add();
		request.setIntA(a);
		request.setIntB(b);

		AddResponse response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://www.dneonline.com/calculator.asmx", request,
				new SoapActionCallback("http://tempuri.org/Add"));
		return response.getAddResult();
	}

}
