package controllers;

import com.google.inject.Inject;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.profile.ProfileManager;
import org.pac4j.play.PlayWebContext;
import org.pac4j.play.java.Secure;
import org.pac4j.play.store.PlaySessionStore;
import play.mvc.*;

import java.util.List;

public class HomeController extends Controller {

    public Result index() {
        return ok(views.html.index.render());
    }

    @Secure(clients = "OidcClient")
    public Result oidcIndex() { return protectedIndexView(); }

    @Secure
    public Result protectedIndex() {
        return protectedIndexView();
    }

    private Result protectedIndexView() {
        return ok(views.html.protectedIndex.render(getProfiles()));
    }

    @Inject
    private PlaySessionStore playSessionStore;

    @SuppressWarnings("unchecked")
    private List<CommonProfile> getProfiles() {
        final PlayWebContext context = new PlayWebContext(ctx(), playSessionStore);
        final ProfileManager<CommonProfile> profileManager = new ProfileManager(context);
        return profileManager.getAll(true);
    }
}