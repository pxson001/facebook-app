package com.facebook.messaging.contextbanner.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.contextbanner.graphql.PageContextQueryModels.PageContextQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: suggested_media_uri */
public final class PageContextQuery {

    /* compiled from: suggested_media_uri */
    public class PageContextQueryString extends TypedGraphQlQueryString<PageContextQueryModel> {
        public PageContextQueryString() {
            super(PageContextQueryModel.class, false, "PageContextQuery", "339eb38d2ecbe274b5638e4dbefcd50e", "page", "10154668017556729", RegularImmutableSet.a);
        }

        public final String m2015a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
