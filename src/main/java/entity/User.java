package entity;

import org.json.JSONObject;

public class User {
    private String login;
    private int id;
    private String avatar_url;
    private String gravatar_id;
    private String url;
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private String site_admin;

    public void setParameters(JSONObject jsonObject) {
        if(jsonObject.get("login") != null) {
            this.setLogin(jsonObject.get("login").toString());
        }

        if(jsonObject.get("id") != null) {
            this.setId(Integer.parseInt(jsonObject.get("id").toString()));
        }

        if(jsonObject.get("avatar_url") != null) {
            this.setAvatar_url(jsonObject.get("avatar_url").toString());
        }

        if(jsonObject.get("gravatar_id") != null) {
            this.setGravatar_id(jsonObject.get("gravatar_id").toString());
        }

        if(jsonObject.get("url") != null) {
            this.setUrl(jsonObject.get("url").toString());
        }

        if(jsonObject.get("html_url") != null) {
            this.setHtml_url(jsonObject.get("html_url").toString());
        }

        if(jsonObject.get("followers_url") != null) {
            this.setFollowers_url(jsonObject.get("followers_url").toString());
        }

        if(jsonObject.get("following_url") != null) {
            this.setFollowing_url(jsonObject.get("following_url").toString());
        }

        if(jsonObject.get("gists_url") != null) {
            this.setGists_url(jsonObject.get("gists_url").toString());
        }

        if(jsonObject.get("starred_url") != null) {
            this.setStarred_url(jsonObject.get("starred_url").toString());
        }

        if(jsonObject.get("subscriptions_url") != null) {
            this.setSubscriptions_url(jsonObject.get("subscriptions_url").toString());
        }

        if(jsonObject.get("organizations_url") != null) {
            this.setOrganizations_url(jsonObject.get("organizations_url").toString());
        }

        if(jsonObject.get("repos_url") != null) {
            this.setRepos_url(jsonObject.get("repos_url").toString());
        }

        if(jsonObject.get("events_url") != null) {
            this.setEvents_url(jsonObject.get("events_url").toString());
        }

        if(jsonObject.get("received_events_url") != null) {
            this.setReceived_events_url(jsonObject.get("received_events_url").toString());
        }

        if(jsonObject.get("type") != null) {
            this.setType(jsonObject.get("type").toString());
        }

        if(jsonObject.get("site_admin") != null) {
            this.setSite_admin(jsonObject.get("site_admin").toString());
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public void setGravatar_id(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }

    public String getFollowing_url() {
        return following_url;
    }

    public void setFollowing_url(String following_url) {
        this.following_url = following_url;
    }

    public String getGists_url() {
        return gists_url;
    }

    public void setGists_url(String gists_url) {
        this.gists_url = gists_url;
    }

    public String getStarred_url() {
        return starred_url;
    }

    public void setStarred_url(String starred_url) {
        this.starred_url = starred_url;
    }

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public void setSubscriptions_url(String subscriptions_url) {
        this.subscriptions_url = subscriptions_url;
    }

    public String getOrganizations_url() {
        return organizations_url;
    }

    public void setOrganizations_url(String organizations_url) {
        this.organizations_url = organizations_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    public String getEvents_url() {
        return events_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public String getReceived_events_url() {
        return received_events_url;
    }

    public void setReceived_events_url(String received_events_url) {
        this.received_events_url = received_events_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSite_admin() {
        return site_admin;
    }

    public void setSite_admin(String site_admin) {
        this.site_admin = site_admin;
    }
}