package com.facebook.ipc.slideshow;

/* compiled from: unhandled view stub attribute =  */
public enum SlideshowEditConfigurationSpec$Source {
    SLIDESHOW_ATTACHMENT_EDIT("composer_attachment"),
    SIMPLE_PICKER("photo_picker");
    
    private final String analyticsName;

    private SlideshowEditConfigurationSpec$Source(String str) {
        this.analyticsName = str;
    }

    public final String toString() {
        return this.analyticsName;
    }
}
