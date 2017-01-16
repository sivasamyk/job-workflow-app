package com.workflow.webapp;

/**
 * Created by skaliappan on 1/16/17.
 */

import io.dropwizard.testing.ConfigOverride;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class IntegrationTest {

    private static final String TMP_FILE = createTempFile();
    private static final String CONFIG_PATH = ResourceHelpers.resourceFilePath("test-example.yml");

    @ClassRule
    public static final DropwizardAppRule<WebAppConfiguration> RULE = new DropwizardAppRule<>(
            WebAppConfiguration.class, CONFIG_PATH,
            ConfigOverride.config("database.url", "jdbc:h2:" + TMP_FILE));

    private Client client;

    @BeforeClass
    public static void migrateDb() throws Exception {
        RULE.getApplication().run("db", "migrate", CONFIG_PATH);
    }

    @Before
    public void setUp() throws Exception {
        client = ClientBuilder.newClient();
    }

    @After
    public void tearDown() throws Exception {
        client.close();
    }

    private static String createTempFile() {
        try {
            return File.createTempFile("test-example", null).getAbsolutePath();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void testHelloWorld() throws Exception {
        final Optional<String> name = Optional.of("Dr. IntegrationTest");
//        final Saying saying = client.target("http://localhost:" + RULE.getLocalPort() + "/hello-world")
//                .queryParam("name", name.get())
//                .request()
//                .get(Saying.class);
//        assertThat(saying.getContent()).isEqualTo(RULE.getConfiguration().buildTemplate().render(name));
    }

    @Test
    public void testPostClient() throws Exception {
        final com.workflow.webapp.core.Client c = new com.workflow.webapp.core.Client();
        final com.workflow.webapp.core.Client newC = client.target("http://localhost:" + RULE.getLocalPort() + "/clients")
                .request()
                .post(Entity.entity(c, MediaType.APPLICATION_JSON_TYPE))
                .readEntity(com.workflow.webapp.core.Client.class);

    }
}
