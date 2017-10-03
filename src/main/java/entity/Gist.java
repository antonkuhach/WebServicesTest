package entity;

import com.google.gson.annotations.SerializedName;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

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
    private GistFilePack files;
    private boolean truncated;
    private int comments;
    private String comments_url;
    private String html_url;
    private String git_pull_url;
    private String git_push_url;
    private String created_at;
    private String updated_at;
    private GistForks forks;
    private GistChangeStatus change_status;
    private String committed_at;

    public void setParameters(HttpResponse httpResponse) throws IOException {
        JSONObject jsonObject;
        String jsonString;

        jsonString = EntityUtils.toString(httpResponse.getEntity());
        jsonObject = new JSONObject(jsonString);

        if(jsonObject.get("url") != null) {
            this.setUrl(jsonObject.get("url").toString());
        }

        if(jsonObject.get("forks_url") != null) {
            this.setForks_url(jsonObject.get("forks_url").toString());
        }

        if(jsonObject.get("commits_url") != null) {
            this.setComments_url(jsonObject.get("commits_url").toString());
        }

        if(jsonObject.get("id") != null) {
            this.setId(jsonObject.get("id").toString());
        }

        if(jsonObject.get("description") != null) {
            this.setDescription(jsonObject.get("description").toString());
        }

        if(jsonObject.get("public") != null) {
            this.setA(Boolean.parseBoolean(jsonObject.get("public").toString()));
        }

        if(jsonObject.getJSONObject("owner") != null) {
            this.getOwner().setParameters(jsonObject.getJSONObject("owner"));
        }

        if(jsonObject.getJSONObject("user") != null) {
            this.getUser().setParameters(jsonObject.getJSONObject("user"));
        }

        if(jsonObject.getJSONObject("files") != null) {
            this.getFiles().setFile(jsonObject.getJSONObject("files"));
        }

        if(jsonObject.get("truncated") != null) {
            this.setTruncated(Boolean.parseBoolean(jsonObject.get("truncated").toString()));
        }

        if(jsonObject.get("comments") != null) {
            this.setComments(Integer.parseInt(jsonObject.get("comments").toString()));
        }

        if(jsonObject.get("comments_url") != null) {
            this.setComments_url(jsonObject.get("comments_url").toString());
        }

        if(jsonObject.get("html_url") != null) {
            this.setHtml_url(jsonObject.get("html_url").toString());
        }

        if(jsonObject.get("git_pull_url") != null) {
            this.setGit_pull_url(jsonObject.get("git_pull_url").toString());
        }

        if(jsonObject.get("git_push_url") != null) {
            this.setGit_push_url(jsonObject.get("git_push_url").toString());
        }

        if(jsonObject.get("created_at") != null) {
            this.setCreated_at(jsonObject.get("created_at").toString());
        }

        if(jsonObject.get("updated_at") != null) {
            this.setUpdated_at(jsonObject.get("updated_at").toString());
        }

        if(jsonObject.getJSONObject("forks") != null) {
            this.getForks().setParameters(jsonObject.getJSONObject("forks"));
        }

        if(jsonObject.getJSONObject("change_status") != null) {
            this.getChange_status().setParameters(jsonObject.getJSONObject("change_status"));
        }

        if(jsonObject.get("committed_at") != null) {
            this.setCommitted_at(jsonObject.get("committed_at").toString());
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getForks_url() {
        return forks_url;
    }

    public void setForks_url(String forks_url) {
        this.forks_url = forks_url;
    }

    public String getCommits_url() {
        return commits_url;
    }

    public void setCommits_url(String commits_url) {
        this.commits_url = commits_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isA() {
        return a;
    }

    public void setA(boolean a) {
        this.a = a;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GistFilePack getFiles() {
        return files;
    }

    public void setFiles(GistFilePack files) {
        this.files = files;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getComments_url() {
        return comments_url;
    }

    public void setComments_url(String comments_url) {
        this.comments_url = comments_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getGit_pull_url() {
        return git_pull_url;
    }

    public void setGit_pull_url(String git_pull_url) {
        this.git_pull_url = git_pull_url;
    }

    public String getGit_push_url() {
        return git_push_url;
    }

    public void setGit_push_url(String git_push_url) {
        this.git_push_url = git_push_url;
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

    public GistForks getForks() {
        return forks;
    }

    public void setForks(GistForks forks) {
        this.forks = forks;
    }

    public GistChangeStatus getChange_status() {
        return change_status;
    }

    public void setChange_status(GistChangeStatus change_status) {
        this.change_status = change_status;
    }

    public String getCommitted_at() {
        return committed_at;
    }

    public void setCommitted_at(String committed_at) {
        this.committed_at = committed_at;
    }
}