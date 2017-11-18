package br.com.ardaexperience.service;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.ardaexperience.service.CORSFilter.class);
        resources.add(br.com.ardaexperience.service.ClientesResource.class);
        resources.add(br.com.ardaexperience.service.LoginResource.class);
        resources.add(br.com.ardaexperience.service.PedidosResource.class);
        resources.add(br.com.ardaexperience.service.RoteirosResource.class);
 }

}
