package com.facebook.facecastdisplay.protocol;

import com.facebook.facecastdisplay.protocol.FetchMomentsOfInterestQueryModels.FetchMomentsOfInterestQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: stickered_media_item */
public final class FetchMomentsOfInterestQuery {

    /* compiled from: stickered_media_item */
    public class FetchMomentsOfInterestQueryString extends TypedGraphQlQueryString<FetchMomentsOfInterestQueryModel> {
        public FetchMomentsOfInterestQueryString() {
            super(FetchMomentsOfInterestQueryModel.class, false, "FetchMomentsOfInterestQuery", "814c04d4c0d311d7dd20d68692d60db6", "video", "10154490902356729", RegularImmutableSet.a);
        }

        public final String m3997a(String str) {
            switch (str.hashCode()) {
                case -441951636:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
