package com.example.ws.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import calculator.wsdl.Add;
import calculator.wsdl.AddResponse;
import calculator.wsdl.Divide;
import calculator.wsdl.DivideResponse;
import calculator.wsdl.Multiply;
import calculator.wsdl.MultiplyResponse;
import calculator.wsdl.Subtract;
import calculator.wsdl.SubtractResponse;

public class CalculatorClient extends WebServiceGatewaySupport {

	private static final String url = "http://www.dneonline.com/calculator.asmx";
	private static final Logger log = LoggerFactory.getLogger(CalculatorClient.class);

	private Object callWebService(Object request, String soapAction) {
		return getWebServiceTemplate().marshalSendAndReceive(url, request,
				new SoapActionCallback(soapAction));
	}

	public int add(int a, int b) {
		Add request = new Add();
		request.setIntA(a);
		request.setIntB(b);

		AddResponse response = (AddResponse) callWebService(request, "http://tempuri.org/Add");
		return response.getAddResult();
	}

	public int divide(int a, int b) {
		Divide request = new Divide();
		request.setIntA(a);
		request.setIntB(b);

		DivideResponse response = (DivideResponse) callWebService(request,
				"http://tempuri.org/Divide");
		return response.getDivideResult();

	}

	public int multiply(int a, int b) {
		Multiply request = new Multiply();
		request.setIntA(a);
		request.setIntB(b);

		MultiplyResponse response = (MultiplyResponse) callWebService(request,
				"http://tempuri.org/Multiply");
		return response.getMultiplyResult();

	}

	public int subtract(int a, int b) {
		Subtract request = new Subtract();
		request.setIntA(a);
		request.setIntB(b);

		SubtractResponse response = (SubtractResponse) callWebService(request,
				"http://tempuri.org/Subtract");
		return response.getSubtractResult();

	}

}
