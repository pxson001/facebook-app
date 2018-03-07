package com.facebook.photos.upload.protocol;

/* compiled from: genie_sender */
public class UploadServerResponse {
    public final String f14135a;
    public final String f14136b;
    public final ResponseType f14137c;

    /* compiled from: genie_sender */
    public enum ResponseType {
        TARGET_POST,
        SINGLE_PHOTO,
        PHOTO_STORY,
        PHOTO_REVIEW
    }

    public UploadServerResponse(ResponseType responseType, String str, String str2) {
        this.f14135a = str;
        this.f14136b = str2;
        this.f14137c = responseType;
    }
}
