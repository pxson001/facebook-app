package com.facebook.katana.activity;

/* compiled from: free_facebook_launch_push */
public enum AnimationType {
    SLIDE_LEFT_IN(2130968751),
    SLIDE_RIGHT_OUT(2130968766),
    DROP_OUT(2130968615),
    RISE_IN(2130968725);
    
    public final int resource;

    private AnimationType(int i) {
        this.resource = i;
    }
}
