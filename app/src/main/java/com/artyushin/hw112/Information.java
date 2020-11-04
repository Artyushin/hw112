package com.artyushin.hw112;

public class Information {
    private int imgId;
    private String mainTitle;
    private String subTitle;
    private int nameButton;;

    public Information(int imgId, String mainTitle, String subTitle, int nameButton) {
        this.imgId = imgId;
        this.mainTitle = mainTitle;
        this.subTitle = subTitle;
        this.nameButton = nameButton;
    }

    public int getImgId() {
        return imgId;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public int getNameButton() {
        return nameButton;
    }
}
