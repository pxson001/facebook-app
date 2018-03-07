package com.facebook.timeline.header.intro.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.timeline.header.intro.protocol.BioGraphQLModels.BioQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: fetch_inviter_proifile */
public final class BioGraphQL {

    /* compiled from: fetch_inviter_proifile */
    public class BioQueryString extends TypedGraphQlQueryString<BioQueryModel> {
        public BioQueryString() {
            super(BioQueryModel.class, false, "BioQuery", "1a3ac95fbfe855aee44ec497ed693909", "user", "10154485611356729", RegularImmutableSet.a);
        }

        public final String m11895a(String str) {
            switch (str.hashCode()) {
                case -1102636175:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
