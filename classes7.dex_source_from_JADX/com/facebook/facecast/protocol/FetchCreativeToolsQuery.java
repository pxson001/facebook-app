package com.facebook.facecast.protocol;

import com.facebook.facecast.protocol.FetchCreativeToolsQueryModels.FetchCreativeToolsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: background_location_update_settings */
public final class FetchCreativeToolsQuery {

    /* compiled from: background_location_update_settings */
    public class FetchCreativeToolsQueryString extends TypedGraphQlQueryString<FetchCreativeToolsQueryModel> {
        public FetchCreativeToolsQueryString() {
            super(FetchCreativeToolsQueryModel.class, false, "FetchCreativeToolsQuery", "d42892a0f1e0b919561d213608382987", "video", "10154572860726729", RegularImmutableSet.a);
        }

        public final String m22324a(String str) {
            switch (str.hashCode()) {
                case 102976443:
                    return "1";
                case 452782806:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
