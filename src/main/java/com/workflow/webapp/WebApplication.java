package com.workflow.webapp;

import com.workflow.webapp.core.Job;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by skaliappan on 1/9/17.
 */
public class WebApplication extends Application<WebAppConfiguration> {

    private final HibernateBundle<WebAppConfiguration> hibernate = new HibernateBundle<WebAppConfiguration>(Job.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(WebAppConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };



    @Override
    public void run(WebAppConfiguration webAppConfiguration, Environment environment) throws Exception {
        environment.getApplicationContext().getMimeTypes().addMimeMapping("tff","application/font-sfnt");
        environment.getApplicationContext().getMimeTypes().addMimeMapping("woff","application/font-woff");
    }

    @Override
    public void initialize(Bootstrap<WebAppConfiguration> bootstrap) {
        super.initialize(bootstrap);
        bootstrap.addBundle(hibernate);
        bootstrap.addBundle(new AssetsBundle("/assets/app","/app"));
    }

    public static void main(String[] args) throws Exception {
        new WebApplication().run(args);
    }
}
