package com.facebook.proxygen;

/* compiled from: src_small */
public class ConnectionParams {
    public String clientId;
    public boolean enableTopicEncoding;
    public int keepaliveSecs;
    public PublishFormat publishFormat;

    /* compiled from: src_small */
    public enum PublishFormat {
        NONE(0),
        ZLIB(1),
        ZLIB_OPTIONAL(2);
        
        private final int value;

        private PublishFormat(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }
}
