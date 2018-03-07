package com.facebook.crowdsourcing.protocol.graphql;

import com.facebook.crowdsourcing.protocol.graphql.FeatherQueriesModels.FeatherQuestionsQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: taggable_object_pp_size */
public final class FeatherQueries {

    /* compiled from: taggable_object_pp_size */
    public class FeatherQuestionsQueryString extends TypedGraphQlQueryString<FeatherQuestionsQueryModel> {
        public FeatherQuestionsQueryString() {
            super(FeatherQuestionsQueryModel.class, false, "FeatherQuestionsQuery", "76203583533e78494d705d31016f7249", "page", "10154517480841729", RegularImmutableSet.a);
        }

        public final String m2376a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                case -799136893:
                    return "1";
                case 692733304:
                    return "4";
                case 860214447:
                    return "3";
                case 1741102485:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
