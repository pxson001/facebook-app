package com.facebook.camera.utils;

/* compiled from: all_icons */
public enum Orientation {
    LANDSCAPE(90, 0),
    PORTRAIT(0, 90),
    REVERSE_LANDSCAPE(270, 180),
    REVERSE_PORTRAIT(180, 270);
    
    public final int mReverseRotation;
    public final int mRotation;

    private Orientation(int i, int i2) {
        this.mRotation = i;
        this.mReverseRotation = i2;
    }
}
