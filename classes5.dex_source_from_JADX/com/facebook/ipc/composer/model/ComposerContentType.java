package com.facebook.ipc.composer.model;

/* compiled from: TOKEN */
public enum ComposerContentType {
    NO_ATTACHMENTS,
    SINGLE_PHOTO,
    MULTIPLE_PHOTOS,
    VIDEO,
    GIF_VIDEO,
    STICKER,
    SHARE_ATTACHMENT,
    SLIDESHOW,
    MULTIMEDIA,
    FACECAST,
    MINUTIAE,
    CHECKIN;

    /* compiled from: TOKEN */
    public interface ProvidesContentType {
        ComposerContentType m23296c();
    }
}
