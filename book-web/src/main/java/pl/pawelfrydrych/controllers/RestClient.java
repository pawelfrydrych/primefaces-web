package pl.pawelfrydrych.controllers;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
 
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
 
@ManagedBean
@SessionScoped
public class RestClient implements Serializable {
 
    private transient Client client;
 
    private String SERVICE_BASE_URI;
 
    @PostConstruct
    protected void initialize() {
        FacesContext fc = FacesContext.getCurrentInstance();
        SERVICE_BASE_URI = fc.getExternalContext().getInitParameter("metadata.serviceBaseURI");
 
        client = Client.create();
    }
 
    public WebResource getWebResource(String relativeUrl) {
        if (client == null) {
            initialize();
        }
 
        return client.resource(SERVICE_BASE_URI + relativeUrl);
    }
 
    public ClientResponse clientGetResponse(String relativeUrl) {
        WebResource webResource = client.resource(SERVICE_BASE_URI + relativeUrl);
        return webResource.accept("application/json").get(ClientResponse.class);
    }
}