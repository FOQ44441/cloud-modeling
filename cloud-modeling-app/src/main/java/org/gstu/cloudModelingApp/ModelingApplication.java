package org.gstu.cloudModelingApp;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;

public class ModelingApplication extends Application {
	@Override
    public final Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<Class<?>>(1);
        set.add(JacksonFeature.class);
        return set;
    }
}
