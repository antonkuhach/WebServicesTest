package entity;

import org.json.JSONObject;

public class GistForks {
    private User user;
    private String url;
    private String id;
    private String created_at;
    private String updated_at;

    public void setParameters(JSONObject jsonObject) {
        if(jsonObject.getJSONObject("user") != null) {
            this.getUser().setParameters(jsonObject.getJSONObject("user"));
        }

        if(jsonObject.get("url") != null) {
            this.setUrl(jsonObject.get("url").toString());
        }

        if(jsonObject.get("id") != null) {
            this.setId(jsonObject.get("id").toString());
        }

        if(jsonObject.get("created_at") != null) {
            this.setCreated_at(jsonObject.get("created_at").toString());
        }

        if(jsonObject.get("updated_at") != null) {
            this.setUpdated_at(jsonObject.get("updated_at").toString());
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
