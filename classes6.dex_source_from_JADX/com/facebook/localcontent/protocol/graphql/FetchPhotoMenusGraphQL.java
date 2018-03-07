package com.facebook.localcontent.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.localcontent.protocol.graphql.FetchPhotoMenusGraphQLModels.PhotoMenusDataModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: last_update_time_ms */
public final class FetchPhotoMenusGraphQL {

    /* compiled from: last_update_time_ms */
    public class PhotoMenusDataString extends TypedGraphQlQueryString<PhotoMenusDataModel> {
        public PhotoMenusDataString() {
            super(PhotoMenusDataModel.class, false, "PhotoMenusData", "842621bed65a1aa5075e0cb4339a3925", "page", "10154429039106729", RegularImmutableSet.a);
        }

        public final String m18393a(String str) {
            switch (str.hashCode()) {
                case -1442803611:
                    return "3";
                case -803548981:
                    return "0";
                case 16907033:
                    return "1";
                case 94851343:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
