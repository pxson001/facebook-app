package com.facebook.friends.protocol;

import com.facebook.friends.protocol.FetchDailyDialogueContactImporterModels.DailyDialogueContactImporterQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: match_confidence */
public final class FetchDailyDialogueContactImporter {

    /* compiled from: match_confidence */
    public class DailyDialogueContactImporterQueryString extends TypedGraphQlQueryString<DailyDialogueContactImporterQueryModel> {
        public DailyDialogueContactImporterQueryString() {
            super(DailyDialogueContactImporterQueryModel.class, false, "DailyDialogueContactImporterQuery", "2af772ab2fd27796a52fe3235dc45889", "viewer", "10154429038736729", RegularImmutableSet.a);
        }

        public final String m16874a(String str) {
            switch (str.hashCode()) {
                case -1777441434:
                    return "2";
                case -785864030:
                    return "4";
                case 97440432:
                    return "1";
                case 1234304744:
                    return "0";
                case 1939875509:
                    return "3";
                default:
                    return str;
            }
        }
    }
}
