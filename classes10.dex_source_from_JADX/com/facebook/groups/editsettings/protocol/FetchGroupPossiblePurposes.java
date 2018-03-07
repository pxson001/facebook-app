package com.facebook.groups.editsettings.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.editsettings.protocol.FetchGroupPossiblePurposesModels.FetchGroupPossiblePurposesModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: Unable to respond to get install data request */
public final class FetchGroupPossiblePurposes {

    /* compiled from: Unable to respond to get install data request */
    public class FetchGroupPossiblePurposesString extends TypedGraphQlQueryString<FetchGroupPossiblePurposesModel> {
        public FetchGroupPossiblePurposesString() {
            super(FetchGroupPossiblePurposesModel.class, false, "FetchGroupPossiblePurposes", "2d267b3ee4e237b0bc7fd22a7cd8d3d9", "group", "10154429038911729", RegularImmutableSet.a);
        }

        public final String m22688a(String str) {
            switch (str.hashCode()) {
                case 506361563:
                    return "0";
                case 614886837:
                    return "1";
                case 1708927385:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
