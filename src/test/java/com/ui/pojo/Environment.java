package com.ui.pojo;

public class Environment {
    private String url;

    public Environment(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Environment{" +
                "url='" + url + '\'' +
                '}';
    }
}
