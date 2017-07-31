package com.spring81.bbs.model;

public class ModelArticleRecommend {
    
    private String  userid    = ""  ; //   userid    VARCHAR
    private Integer articleno = null; // , articleno INTEGER
    private Boolean good      = null; // , good      TINYINT
    private Boolean bad       = null; // , bad       TINYINT
    
    // getter & setter
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public Integer getArticleno() {
        return articleno;
    }
    public void setArticleno(Integer articleno) {
        this.articleno = articleno;
    }    
    public Boolean getGood() {
        return good;
    }
    public void setGood(Boolean good) {
        this.good = good;
    }
    public Boolean getBad() {
        return bad;
    }
    public void setBad(Boolean bad) {
        this.bad = bad;
    }
    // toString 
    @Override
    public String toString() {
        return "ModelArticleRecommend [userid=" + userid + ", articleno="
                + articleno + ", good=" + good + ", bad=" + bad + "]";
    }
    
    // constructor
    public ModelArticleRecommend() {
        super();
    }
    
    
    
}
