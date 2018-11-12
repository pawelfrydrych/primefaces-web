package pl.pawelfrydrych.config;

import pl.pawelfrydrych.controllers.BookRestController;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class JAXRSConfiguration  extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<>();
		classes.add(BookRestController.class);
        return classes;
    }
}
