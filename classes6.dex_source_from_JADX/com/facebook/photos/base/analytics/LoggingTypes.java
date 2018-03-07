package com.facebook.photos.base.analytics;

/* compiled from: intent_photo_tag */
public class LoggingTypes {

    /* compiled from: intent_photo_tag */
    public enum SourceType {
        LOCAL,
        VAULT,
        UNKNOWN
    }

    /* compiled from: intent_photo_tag */
    public enum UploadMethodType {
        NOT_RELEVANT("none"),
        NON_CHUNKED("non_chunked"),
        CHUNKED("chunked"),
        PARALLEL_CHUNKED("parallel_chunked");
        
        public final String value;

        private UploadMethodType(String str) {
            this.value = str;
        }
    }

    /* compiled from: intent_photo_tag */
    public enum VideoProductType {
        NOT_RELEVANT("none"),
        PROFILE_VIDEO("profile_video"),
        FACECAST_LIVE_VIDEO("facecast_live_video"),
        GIF("gif"),
        COMPOSER("composer");
        
        public final String value;

        private VideoProductType(String str) {
            this.value = str;
        }
    }
}
