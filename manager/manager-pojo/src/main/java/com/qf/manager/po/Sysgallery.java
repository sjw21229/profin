package com.qf.manager.po;

public class Sysgallery {
    private int id;
    private int parentid;
    private String pic_url;
    private int categoryid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public Sysgallery() {
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    @Override
    public String toString() {
        return "Sysgallery{" +
                "id=" + id +
                ", parentid=" + parentid +
                ", pic_url='" + pic_url + '\'' +
                '}';
    }
}
