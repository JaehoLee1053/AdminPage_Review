package com.example.study_review.controller.model;

// 여러개의 parameter를 하나씩 getParameter 어노테이션을 안 쓰고 받아오도록
public class SearchParam {
    private String account;
    private String email;
    private int page;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
