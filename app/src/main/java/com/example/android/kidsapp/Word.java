package com.example.android.kidsapp;

public class Word {
    private String mDefaultTranslation;
    private String mUrduTranslation;
    private int mimageResourceId = NO_IMAGE_PROVIDED;
    private int mAudioResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;
    //now making a parameterized constructor or values of these properties will be assigned here
    public Word(String defaultTranslation,String miwokTranslation,int audioResourceId){
        mDefaultTranslation =defaultTranslation;
        mAudioResourceId=audioResourceId;
        mUrduTranslation =miwokTranslation;


    }
    public Word(String defaultTranslation,String miwokTranslation,int imageResourceId,int audioResourceId){
        mimageResourceId=imageResourceId;
        mAudioResourceId=audioResourceId;
        mDefaultTranslation =defaultTranslation;
        mUrduTranslation =miwokTranslation;


    }
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getMiwokTranslation(){
        return mUrduTranslation;
    }
    public int getImageResourceId(){ return mimageResourceId; }
    public boolean hasImage() {
        return mimageResourceId != NO_IMAGE_PROVIDED;
    }
    public int getAudioResourceId(){return mAudioResourceId;}
}



