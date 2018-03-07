package com.facebook.facecast.protocol;

import com.facebook.facecast.protocol.FetchBroadcastCopyrightsStateModels.FetchBroadcastCopyrightsStateQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: backstage_friend_reacted */
public final class FetchBroadcastCopyrightsState {

    /* compiled from: backstage_friend_reacted */
    public class FetchBroadcastCopyrightsStateQueryString extends TypedGraphQlQueryString<FetchBroadcastCopyrightsStateQueryModel> {
        public FetchBroadcastCopyrightsStateQueryString() {
            super(FetchBroadcastCopyrightsStateQueryModel.class, false, "FetchBroadcastCopyrightsStateQuery", "d2a192990d68eeaa98f71958874edf6e", "video", "10154481720766729", RegularImmutableSet.a);
        }

        public final String m22316a(String str) {
            switch (str.hashCode()) {
                case -441951636:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
