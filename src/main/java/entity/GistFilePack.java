package entity;

import org.json.JSONObject;

public class GistFilePack {
    private GistFile file;

    public GistFile getFile() {
        return file;
    }

    public void setFile(GistFile file) {
        this.file = file;
    }

    public void setFile(JSONObject jsonObject) {
        this.file.setParameters(jsonObject);
    }
}
