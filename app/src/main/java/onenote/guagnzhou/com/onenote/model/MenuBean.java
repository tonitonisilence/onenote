package onenote.guagnzhou.com.onenote.model;

import java.io.Serializable;

public class MenuBean implements Serializable {
    private String title;//标题
    private String id;//id
    private boolean isCheck;//是否选中

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }

}
