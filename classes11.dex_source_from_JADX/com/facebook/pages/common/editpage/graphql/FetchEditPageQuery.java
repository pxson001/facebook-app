package com.facebook.pages.common.editpage.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.common.editpage.graphql.FetchEditPageQueryModels.FetchEditPageQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: show_search_bar */
public final class FetchEditPageQuery {

    /* compiled from: show_search_bar */
    public class FetchEditPageQueryString extends TypedGraphQlQueryString<FetchEditPageQueryModel> {
        public FetchEditPageQueryString() {
            super(FetchEditPageQueryModel.class, false, "FetchEditPageQuery", "443958fbac219b760ef69a08cb966ad1", "node", "10154688030561729", RegularImmutableSet.a);
        }

        public final String m2261a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                case 461053147:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
