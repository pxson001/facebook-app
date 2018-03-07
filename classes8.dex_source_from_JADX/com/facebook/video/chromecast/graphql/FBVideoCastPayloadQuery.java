package com.facebook.video.chromecast.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.video.chromecast.graphql.FBVideoCastPayloadQueryModels.FBVideoCastPayloadQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: long_pressed_text */
public final class FBVideoCastPayloadQuery {

    /* compiled from: long_pressed_text */
    public class FBVideoCastPayloadQueryString extends TypedGraphQlQueryString<FBVideoCastPayloadQueryModel> {
        public FBVideoCastPayloadQueryString() {
            super(FBVideoCastPayloadQueryModel.class, false, "FBVideoCastPayloadQuery", "6c93a89cb25a9f8ebb94e0529b4932ef", "video", "10154461612621729", RegularImmutableSet.a);
        }

        public final String m11417a(String str) {
            switch (str.hashCode()) {
                case -441951636:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final FBVideoCastPayloadQueryString m11418a() {
        return new FBVideoCastPayloadQueryString();
    }
}
