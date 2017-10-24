package controllers;

import com.typesafe.config.Config;
import org.pac4j.play.LogoutController;

public class CentralLogoutController extends LogoutController {

    public CentralLogoutController(Config config) {
        String baseUrl = config.getString("baseUrl");
        setDefaultUrl(baseUrl + "/?defaulturlafterlogoutafteridp");
        setLocalLogout(true);
        setCentralLogout(true);
        setLogoutUrlPattern(baseUrl + "/.*");
    }
}
