package com.facebook.messaging.sharedimage.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.sharedimage.graphql.SharedImageHistoryQueryModels.SubsequentSharedPhotosModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: confirmAccount/?normalized_contactpoint=%s&contactpoint_type=%s&iso_country_code=%s&for_phone_number_confirmation=%s&quick_promotion_id=%s */
public final class SharedImageHistoryQuery {

    /* compiled from: confirmAccount/?normalized_contactpoint=%s&contactpoint_type=%s&iso_country_code=%s&for_phone_number_confirmation=%s&quick_promotion_id=%s */
    public class SubsequentPhotosQueryString extends TypedGraphQlQueryString<SubsequentSharedPhotosModel> {
        public SubsequentPhotosQueryString() {
            super(SubsequentSharedPhotosModel.class, false, "SubsequentPhotosQuery", "4ea63dbaa389774f4e76b6d9a1546283", "message_thread", "10154626203641729", RegularImmutableSet.a);
        }

        public final String m17196a(String str) {
            switch (str.hashCode()) {
                case -1562235024:
                    return "0";
                case -1221029593:
                    return "2";
                case -508009276:
                    return "4";
                case 113126854:
                    return "1";
                case 305968742:
                    return "5";
                case 759954292:
                    return "3";
                default:
                    return str;
            }
        }
    }
}
