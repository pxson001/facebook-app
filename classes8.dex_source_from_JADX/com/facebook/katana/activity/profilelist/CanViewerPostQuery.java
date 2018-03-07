package com.facebook.katana.activity.profilelist;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.katana.activity.profilelist.CanViewerPostQueryModels.FetchCanViewerPostModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: unhandled text view attribute =  */
public final class CanViewerPostQuery {

    /* compiled from: unhandled text view attribute =  */
    public class FetchCanViewerPostString extends TypedGraphQlQueryString<FetchCanViewerPostModel> {
        public FetchCanViewerPostString() {
            super(FetchCanViewerPostModel.class, false, "FetchCanViewerPost", "3175e97c580524c8dc202bde83fa72fc", "me", "10154341704801729", RegularImmutableSet.a);
        }

        public final String m1401a(String str) {
            switch (str.hashCode()) {
                case 549659792:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
