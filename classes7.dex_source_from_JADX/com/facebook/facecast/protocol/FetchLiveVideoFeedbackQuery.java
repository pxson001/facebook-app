package com.facebook.facecast.protocol;

import com.facebook.facecast.protocol.FetchLiveVideoFeedbackQueryModels.FetchLiveVideoFeedbackQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: background-location-update-settings */
public final class FetchLiveVideoFeedbackQuery {

    /* compiled from: background-location-update-settings */
    public class FetchLiveVideoFeedbackQueryString extends TypedGraphQlQueryString<FetchLiveVideoFeedbackQueryModel> {
        public FetchLiveVideoFeedbackQueryString() {
            super(FetchLiveVideoFeedbackQueryModel.class, false, "FetchLiveVideoFeedbackQuery", "273204832fe6b7e1054a5fcd60a2a6b9", "video", "10154575798311729", RegularImmutableSet.a);
        }

        public final String m22375a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "1";
                case -441951636:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
