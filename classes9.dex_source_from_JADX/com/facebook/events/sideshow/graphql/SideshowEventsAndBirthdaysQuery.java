package com.facebook.events.sideshow.graphql;

import com.facebook.events.sideshow.graphql.SideshowEventsAndBirthdaysQueryModels.SideshowEventsBirthdaysQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: TYPE_FIXED64 */
public final class SideshowEventsAndBirthdaysQuery {

    /* compiled from: TYPE_FIXED64 */
    public class SideshowEventsBirthdaysQueryString extends TypedGraphQlQueryString<SideshowEventsBirthdaysQueryModel> {
        public SideshowEventsBirthdaysQueryString() {
            super(SideshowEventsBirthdaysQueryModel.class, false, "SideshowEventsBirthdaysQuery", "6b40db8b541ecd635c1c5524af7c3493", "me", "10154405017771729", RegularImmutableSet.a);
        }

        public final String m26302a(String str) {
            switch (str.hashCode()) {
                case -1487362413:
                    return "1";
                case -1101600581:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
