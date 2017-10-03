package entity;

import org.json.JSONObject;

public class GistFile {
    private int size;
    private String raw_url;
    private String type;
    private String language;
    private boolean truncated;
    private String content;

    public void setParameters(JSONObject jsonObject) {
        if(jsonObject.get("size") != null) {
            this.setSize(Integer.parseInt(jsonObject.get("size").toString()));
        }

        if(jsonObject.get("raw_url") != null) {
            this.setRaw_url(jsonObject.get("raw_url").toString());
        }

        if(jsonObject.get("type") != null) {
            this.setType(jsonObject.get("type").toString());
        }

        if(jsonObject.get("language") != null) {
            this.setLanguage(jsonObject.get("language").toString());
        }

        if(jsonObject.get("truncated") != null) {
            this.setTruncated(Boolean.parseBoolean(jsonObject.get("truncated").toString()));
        }

        if(jsonObject.get("content") != null) {
            this.setContent(jsonObject.get("content").toString());
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getRaw_url() {
        return raw_url;
    }

    public void setRaw_url(String raw_url) {
        this.raw_url = raw_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}