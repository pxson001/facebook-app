package com.facebook.messaging.graphql.threads;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.graphql.threads.AppAttributionQueriesModels.AppAttributionInfoModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: video_file_chunk */
public final class AppAttributionQueries {

    /* compiled from: video_file_chunk */
    public class AppAttributionQueryString extends TypedGraphQlQueryString<AppAttributionInfoModel> {
        public AppAttributionQueryString() {
            super(AppAttributionInfoModel.class, false, "AppAttributionQuery", "431f85df53a8099a44cc26dfc6ff13b8", "node", "10154427700986729", RegularImmutableSet.a);
        }

        public final String m758a(String str) {
            switch (str.hashCode()) {
                case -1540093218:
                    return "1";
                case 148527022:
                    return "2";
                case 1167410741:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
