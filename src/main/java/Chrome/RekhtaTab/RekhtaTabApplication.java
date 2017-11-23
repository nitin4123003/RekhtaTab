package Chrome.RekhtaTab;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import Chrome.RekhtaTab.resources.SherResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RekhtaTabApplication extends Application<RekhtaTabConfiguration> {

    public static void main(final String[] args) throws Exception {
        new RekhtaTabApplication().run(args);
    }

    @Override
    public String getName() {
        return "RekhtaTab";
    }

    @Override
    public void initialize(final Bootstrap<RekhtaTabConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final RekhtaTabConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        DateFormat eventDateFormat = new SimpleDateFormat(configuration.getDateFormat());
        environment.getObjectMapper().setDateFormat(eventDateFormat);
        
        SherResource eventResource = new SherResource();
        environment.jersey().register(eventResource);
    }

}
