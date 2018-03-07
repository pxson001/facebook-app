package com.facebook.crowdsourcing.protocol.graphql;

import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsHeaderModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsSectionsModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: tabs_count_ */
public final class SuggestEdits {

    /* compiled from: tabs_count_ */
    public class SuggestEditsHeaderQueryString extends TypedGraphQlQueryString<SuggestEditsHeaderModel> {
        public SuggestEditsHeaderQueryString() {
            super(SuggestEditsHeaderModel.class, false, "SuggestEditsHeaderQuery", "2f2dc2360942ce670a19f2b594f7244f", "page", "10154658544906729", RegularImmutableSet.a);
        }

        public final String m2499a(String str) {
            switch (str.hashCode()) {
                case -1442803611:
                    return "1";
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: tabs_count_ */
    public class SuggestEditsSectionsQueryString extends TypedGraphQlQueryString<SuggestEditsSectionsModel> {
        public SuggestEditsSectionsQueryString() {
            super(SuggestEditsSectionsModel.class, false, "SuggestEditsSectionsQuery", "047df2c4274038735f6a922ec4ed3fc8", "page", "10154661257981729", RegularImmutableSet.a);
        }

        public final String m2500a(String str) {
            switch (str.hashCode()) {
                case -1442803611:
                    return "1";
                case -803548981:
                    return "0";
                case 109250890:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
