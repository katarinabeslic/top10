package com.example.top10.domen;

public class Tracks {

    int position;
    String imageURL;
    String title;
    String artistName;
    String link;

    public Tracks() {
    }

    public Tracks(int position, String imageURL, String title, String artistName, String link) {
        this.position = position;
        this.imageURL = imageURL;
        this.title = title;
        this.artistName = artistName;
        this.link = link;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
