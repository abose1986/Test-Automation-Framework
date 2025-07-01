package com.ui.pojo;

public class Environment {
    private String url;
    private int MAX_NUMBER_OF_ATTEMPTS;

    public Environment(String url) {
        this.url = url;
    }

    public int getMaxNumberOfAttempts() {
        return MAX_NUMBER_OF_ATTEMPTS;
    }

    public void setMaxNumberOfAttempts(int MAX_NUMBER_OF_ATTEMPTS) {
        this.MAX_NUMBER_OF_ATTEMPTS = MAX_NUMBER_OF_ATTEMPTS;
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
