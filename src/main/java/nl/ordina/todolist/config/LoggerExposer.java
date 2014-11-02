package nl.ordina.todolist.config;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

public class LoggerExposer {

    @Produces
    public Logger loggerExposer(final InjectionPoint ip) {
        return getLogger(ip.getMember()
                           .getDeclaringClass()
                           .getName());
    }


}
