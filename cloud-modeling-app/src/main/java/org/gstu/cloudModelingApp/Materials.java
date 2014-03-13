package org.gstu.cloudModelingApp;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gstu.TestModel.AbstractMaterial;
import org.gstu.TestModel.IMaterial;
import org.gstu.domainmodel.MaterialService;

@Path("materials")
public class Materials {
  
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<IMaterial> getDefaultUserInJSON() {
	        MaterialService materialServ = new MaterialService();
	        return materialServ.getAll();
	    }
}