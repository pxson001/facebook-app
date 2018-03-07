package com.facebook.ufiservices.qe;

/* compiled from: currentPromoTitle */
public enum PerAttachmentMessageTruncatorQuickExperiment$AttachmentType {
    PHOTO("photo_attachment_length"),
    ALBUM("album_attachment_length"),
    VIDEO("video_attachment_length"),
    PAGE("page_attachment_length"),
    EXTERNAL_URL("url_attachment_length"),
    IS_NESTED_STORY("is_nested_story_length"),
    WITH_NESTED_STORY("with_nested_story_length"),
    SPONSORED_PHOTO("sponsored_photo_attachment_length"),
    SPONSORED_ALBUM("sponsored_album_attachment_length"),
    SPONSORED_VIDEO("sponsored_video_attachment_length"),
    SPONSORED_PAGE("sponsored_page_attachment_length"),
    SPONSORED_EXTERNAL_URL("sponsored_url_attachment_length"),
    IS_SPONSORED_NESTED_STORY("is_sponsored_nested_story_length"),
    SPONSORED_WITH_NESTED_STORY("sponsored_with_nested_story_length");
    
    private final String mQEParam;

    private PerAttachmentMessageTruncatorQuickExperiment$AttachmentType(String str) {
        this.mQEParam = str;
    }

    public final String toString() {
        return this.mQEParam;
    }
}
