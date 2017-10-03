package entity;

import org.json.JSONObject;

public class GistChangeStatus {
    private int deletions;
    private int additions;
    private int total;

    public void setParameters(JSONObject jsonObject) {
        if(jsonObject.get("deletions") != null) {
            this.setDeletions(Integer.parseInt(jsonObject.get("deletions").toString()));
        }

        if(jsonObject.get("additions") != null) {
            this.setAdditions(Integer.parseInt(jsonObject.get("additions").toString()));
        }

        if(jsonObject.get("total") != null) {
            this.setTotal(Integer.parseInt(jsonObject.get("total").toString()));
        }
    }

    public int getDeletions() {
        return deletions;
    }

    public void setDeletions(int deletions) {
        this.deletions = deletions;
    }

    public int getAdditions() {
        return additions;
    }

    public void setAdditions(int additions) {
        this.additions = additions;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
