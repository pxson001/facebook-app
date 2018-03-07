package com.facebook.localcontent.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.localcontent.protocol.graphql.StructuredMenuGraphQLModels.AvailableMenusQueryModel;
import com.facebook.localcontent.protocol.graphql.StructuredMenuGraphQLModels.PhotosQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: keywords_pages(%s) */
public final class StructuredMenuGraphQL {

    /* compiled from: keywords_pages(%s) */
    public class AvailableMenusQueryString extends TypedGraphQlQueryString<AvailableMenusQueryModel> {
        public AvailableMenusQueryString() {
            super(AvailableMenusQueryModel.class, false, "AvailableMenusQuery", "048b301c84f7c71ecae3ee0adb7abe78", "page", "10154405445416729", RegularImmutableSet.a);
        }

        public final String m18709a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: keywords_pages(%s) */
    public class PhotosQueryString extends TypedGraphQlQueryString<PhotosQueryModel> {
        public PhotosQueryString() {
            super(PhotosQueryModel.class, false, "PhotosQuery", "20dcb1c2a61e27073d42ab016a493009", "page", "10154429039096729", RegularImmutableSet.a);
        }

        public final String m18710a(String str) {
            switch (str.hashCode()) {
                case -1442803611:
                    return "4";
                case -803548981:
                    return "0";
                case -230346670:
                    return "1";
                case 50511102:
                    return "2";
                case 94851343:
                    return "3";
                default:
                    return str;
            }
        }
    }
}
