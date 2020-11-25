package com.teaminvento.smartinvestor;

public class Video {
    private String title;
    private String id;

    public Video()
    {

    }

    public Video(String title, String id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        id = id;
    }


    @Override
    public String toString() {
        return this.title;
    }

    public String getThumbnailLink()
    {
        return "https://img.youtube.com/vi/" + this.id + "/default.jpg";
    }
}
