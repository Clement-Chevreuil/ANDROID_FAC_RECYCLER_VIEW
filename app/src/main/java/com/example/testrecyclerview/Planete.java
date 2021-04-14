package com.example.testrecyclerview;

import android.widget.ImageView;

public class Planete {

    private String principal;
    private String auxiliaire;
    private int image;

    Planete(String text1, String text2, int image){
        principal = text1;
        auxiliaire = text2;
        this.image = image;
    }
    public String getPrincipal() {
        return principal;
    }
    public String getAuxiliaire() {
        return auxiliaire;
    }
    public int getImage() { return image; }

    public void setImage(int image) { this.image = image; }
    public void setAuxiliaire(String auxiliaire) { this.auxiliaire = auxiliaire; }
    public void setPrincipal(String principal) { this.principal = principal; }
}
