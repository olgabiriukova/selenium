package org.example;

public class ArticleInfObj {
    private String name;
    private String date;
    private String doi;

    public ArticleInfObj(String name, String doi, String date) {
        this.name = name;
        this.date = date;
        this.doi = doi;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }
}
