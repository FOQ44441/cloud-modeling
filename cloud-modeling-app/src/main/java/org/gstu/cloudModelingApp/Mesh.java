package org.gstu.cloudModelingApp;

import java.io.BufferedWriter;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import by.nesterenya.fem.element.Element;
import by.nesterenya.fem.element.Node;
import by.nesterenya.fem.element.Node.Axis;
import by.nesterenya.fem.mesh.BoxMesher;
import by.nesterenya.fem.mesh.MeshBox;
import by.nesterenya.fem.primitives.Box;


@Path("mesh")
public class Mesh {

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMesh(@QueryParam("xc") int xc, @QueryParam("yc") int yc, @QueryParam("zc") int zc ) {
		
		if(xc<2||yc<2||zc<2) return "";
		
		
		Box box = new Box(1, 1, 1);
		BoxMesher bm = new BoxMesher(box, xc, yc, zc);
		MeshBox mesh = null;
		try {
			mesh = (MeshBox)bm.formMesh();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    List<Node> nodes = mesh.getNodes();
	    
	    StringBuilder ver = new StringBuilder();
	    ver.append("\"vertices\": [");
		for(Node node :nodes) {
			ver.append(node.getPosition(Axis.X));
			ver.append(',');
			ver.append(node.getPosition(Axis.Y));
			ver.append(',');
			ver.append(node.getPosition(Axis.Z));
			ver.append(',');
		}
		ver.replace(ver.length()-1, ver.length(), "]");
		
		StringBuilder faces = new StringBuilder();
		List<Element> elements = mesh.getElements();
		faces.append("\"faces\": [");
		
		int[] orderNodesTet = {0,1,2, 0,1,3, 1,2,3, 0,2,3};
		
		try {
			for(Element element:elements) {
			
			int n0 = element.getNode(0).getGlobalIndex();
			int n1 =  element.getNode(1).getGlobalIndex();
			int n2 =  element.getNode(2).getGlobalIndex();
			int n3 =  element.getNode(3).getGlobalIndex();
			
			faces.append(0);
			faces.append(',');
			faces.append(n0);
			faces.append(',');
			faces.append(n1);
			faces.append(',');
			faces.append(n2);
			faces.append(',');
			
			faces.append(0);
			faces.append(',');
			faces.append(n0);
			faces.append(',');
			faces.append(n1);
			faces.append(',');
			faces.append(n3);
			faces.append(',');
			
			faces.append(0);
			faces.append(',');
			faces.append(n1);
			faces.append(',');
			faces.append(n2);
			faces.append(',');
			faces.append(n3);
			faces.append(',');
			
			faces.append(0);
			faces.append(',');
			faces.append(n0);
			faces.append(',');
			faces.append(n2);
			faces.append(',');
			faces.append(n3);
			faces.append(',');
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		faces.replace(faces.length()-1, faces.length(), "]");
		
		//TODO создать объект под это
		String heder = "{ \"metadata\": { \"formatVersion\" : 3 }, ";
		//System.out.format(">>> %d %d %d \n",xc, yc, zc);
		
        //String ver = " \"vertices\": [0,0,0,  1,0,0,  1,1,0,   0,1,0,   0,0,0.5,  1,0,0.5,   1,1,0.5,  0,1,0.5,  0,1,0,  1,1,0,  1,2,0,   0,2,0,   0,1,0.5,  1,1,0.5,   1,2,0.5,  0,2,0.5]";
        String body = ", \"normals\":  [],  \"colors\":   [], \"uvs\":      [ [ 0,0, 0,0, 0,0, 0,0 ]],";
        //+" \"faces\": [128, 0,3,1, 0,3,1,   128, 3,2,1, 3,2,1,    128, 0,4,7,0,4,7,    128, 0,7,3,0,7,3,     128,5,7,4,5,7,4,     128,5,6,7,5,6,7,     128,1,6,5,1,6,5,    128,1,2,6,1,2,6,    128,2,7,6,2,7,6,     128,2,3,7,2,3,7,     128,1,5,4,1,5,4,    128,1,4,0,1,4,0   ]"                            
        //String faces = " \"faces\": [2, 0,3,1,0,    2, 3,2,1,0,    2, 0,4,7,0,    2, 0,7,3,0,     2,5,7,4,0,    2,5,6,7,0,     2,1,6,5,0,    2,1,2,6,0,    2,2,7,6,0,     2,2,3,7,0,    2,1,5,4,0,    2,1,4,0,0   ]" ;                           
        String footer = " }";
        
        return heder + ver.toString()+ body + faces.toString() + footer;
    }
}
