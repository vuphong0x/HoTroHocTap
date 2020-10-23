package com.example.hotrohoctap.news;

public class News {
    private String Title;
    private String PubDate;
    private String Content;

    public News() {
    }

    public News(String title, String pubDate, String content) {
        Title = title;
        PubDate = pubDate;
        Content = content;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPubDate() {
        return PubDate;
    }

    public void setPubDate(String pubDate) {
        PubDate = pubDate;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
