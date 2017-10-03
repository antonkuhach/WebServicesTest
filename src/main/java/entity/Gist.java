package entity;

import com.google.gson.annotations.SerializedName;

public class Gist {
    private String url;
    private String forks_url;
    private String commits_url;
    private String id;
    private String description;
    @SerializedName("public")
    private boolean a;
    private User owner;
    private User user;


}
