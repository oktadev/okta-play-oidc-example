# OIDC Authentication with Play, Pac4j, and Okta

<div style="vertical-align: top">
  <a href="https://www.playframework.com/assets/images/logos/play_full_color.png">
    <img src="https://www.playframework.com/assets/images/logos/play_full_color.png" width="300"></a>
  <a href="https://pac4j.github.io">
    <img src="http://www.pac4j.org/img/logo-play.png" width="200"></a>
  <a href="https://developer.okta.com/">
    <img src="https://devforum.okta.com/uploads/oktadev/original/1X/bf54a16b5fda189e4ad2706fb57cbb7a1e5b8deb.png" width="500"></a>
</div>

This `okta-play-oidc-example` project is a Java Play Framework app that shows how to use the [play-pac4j-java](https://github.com/pac4j/play-pac4j) security library with OpenID Connect (OIDC) and Okta.

## Create an OIDC App in Okta

Create an OIDC App in Okta to get a `{clientId}` and `{clientSecret}`. To do this, log in to your [Okta Developer](https://developer.okta.com/) account and navigate to **Applications** > **Add Application**. Click **Web** and click the **Next** button. Give the app a name you’ll remember, specify `http://localhost:9000` as a Base URI, as well as the following values:
 
 * Login redirect URIs: `http://localhost:9000/callback?client_name=OidcClient`
 * Logout redirect URIs: `http://localhost:9000/?forcepostlogouturlafteridp`

Click **Done** and copy the client ID and secret into your `application.conf` file. While you're in there, modify the `oidc.discoveryUri` to match your Okta domain. For example:

```typescript
oidc.discoveryUri = "https://{yourOktaDomain}.com/oauth2/default/.well-known/openid-configuration"
```

You can also create groups and include them as claims. For example, create `ROLE_ADMIN` and `ROLE_USER` groups and add users into them.

Navigate to **API** > **Authorization Servers**, click the **Authorization Servers** tab and edit the `default` one. Click the **Claims** tab and **Add Claim**. Name it "groups" or "roles", and include it in the ID Token. Set the value type to "Groups" and set the filter to be a Regex of `.*`.

After making these changes, you should be good to go! 

## Build and Run

Build the project and launch the Play app on [http://localhost:9000](http://localhost:9000):

    sbt run


If you have any issues, please create an issue in this project and I'll do my best to help.
