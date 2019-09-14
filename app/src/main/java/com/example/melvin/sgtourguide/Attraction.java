package com.example.melvin.sgtourguide;

/**
 * Created by Melvin on 29/10/2017.
 */

public class Attraction {

    /** Name of the attraction */
    private int mAttractionName;

    /** Description of the attraction */
    private int mAttractionDescription;

    /** Image resource ID for the Attraction */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this attraction */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Attraction object.
     *
     * @param attraction is the name of the attraction in Singapore
     */
    public Attraction(int attraction, int description) {

        mAttractionName = attraction;
        mAttractionDescription = description;
    }

    /**
     * Create a new Attraction object.
     *
     * @param attraction is the name of the attraction in Singapore
     * @param imageResourceId is the drawable resource ID for the image associated with the attraction
     *
     */
    public Attraction(int attraction, int description,int imageResourceId) {
        mAttractionName = attraction;
        mAttractionDescription = description;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the attraction.
     */
    public int getAttractionName() {
        return
                mAttractionName;
    }

    /**
     * Get the description of the attraction.
     */
    public int getAttractionDescription() {
        return
                mAttractionDescription;
    }
    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this attraction.
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
