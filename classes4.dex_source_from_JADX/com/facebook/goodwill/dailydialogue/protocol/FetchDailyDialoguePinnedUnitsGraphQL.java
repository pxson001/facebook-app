package com.facebook.goodwill.dailydialogue.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: qe_last_fetch_ids_hash */
public final class FetchDailyDialoguePinnedUnitsGraphQL {

    /* compiled from: qe_last_fetch_ids_hash */
    public class DailyDialoguePinnedStoryQueryString extends TypedGraphQlQueryString<GraphQLViewer> {
        public DailyDialoguePinnedStoryQueryString() {
            super(GraphQLViewer.class, false, "DailyDialoguePinnedStoryQuery", "3b0a208c9a516d773b19ab3ee30410f3", "viewer", "10154680606716729", RegularImmutableSet.a);
        }

        public final TriState m4400g() {
            return TriState.NO;
        }

        public final String m4399a(String str) {
            switch (str.hashCode()) {
                case 109250890:
                    return "1";
                case 113126854:
                    return "2";
                case 1148345668:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final FBDailyDialogueUpdateString m4398b() {
        return new FBDailyDialogueUpdateString();
    }
}
