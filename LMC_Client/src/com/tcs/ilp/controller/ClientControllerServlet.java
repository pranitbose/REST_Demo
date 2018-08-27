package com.tcs.ilp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

@WebServlet("/ClientControllerServlet")
public class ClientControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClientControllerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcessRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcessRequest(request, response);
	}
	
	protected void doProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());
		String jsonResponse = target.path("api").path("sales").path("allRegion").path("2018").path("jul").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		PrintWriter out = response.getWriter();
		out.println(jsonResponse);
	}
	
	private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/LMC").build();
    }
}
