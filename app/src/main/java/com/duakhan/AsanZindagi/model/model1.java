package com.duakhan.AsanZindagi.model;

import android.net.Uri;

public class model1 {
    private String imageUrl;
    public model1(Uri imageUri){

    }
    public model1(String imageUrl){
        this.imageUrl=imageUrl;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
