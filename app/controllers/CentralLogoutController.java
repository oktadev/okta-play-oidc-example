package controllers;

import com.typesafe.config.Config;
import javax.inject.Inject;
import org.pac4j.play.LogoutController;

public class CentralLogoutController extends LogoutController {

    @Inject
    public CentralLogoutController(Config config) {
        String baseUrl = config.getString("baseUrl");
        setDefaultUrl(baseUrl + "/?defaulturlafterlogoutafteridp");
        setLocalLogout(true);
        setCentralLogout(true);
        setLogoutUrlPattern(baseUrl + "/.*");
    }
}
