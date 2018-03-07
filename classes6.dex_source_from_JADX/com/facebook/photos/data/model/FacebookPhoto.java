package com.facebook.photos.data.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = FacebookPhotoDeserializer.class)
/* compiled from: hostName */
public class FacebookPhoto {
    @JsonProperty("aid")
    private String mAlbumId = null;
    @JsonProperty("can_tag")
    private final boolean mCanTag = false;
    @JsonProperty("caption")
    private String mCaption = null;
    @JsonProperty("created")
    private final long mCreated = -1;
    @JsonProperty("object_id")
    private final long mObjectId = -1;
    @JsonProperty("owner")
    private final long mOwner = -1;
    @JsonProperty("pid")
    private final String mPhotoId = null;
    @JsonProperty("position")
    private final long mPosition = -1;
    @JsonProperty("src")
    private final String mSrcUrl = null;
    @JsonProperty("src_big")
    private final String mSrcUrlBig = null;
    @JsonProperty("src_big_webp")
    private final String mSrcUrlBigWebp = null;
    @JsonProperty("src_small")
    private final String mSrcUrlSmall = null;
    @JsonProperty("src_small_webp")
    private final String mSrcUrlSmallWebp = null;
    @JsonProperty("src_webp")
    private final String mSrcUrlWebp = null;

    private FacebookPhoto() {
    }
}
