package com.facebook.friendsharing.souvenirs.protocols;

import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsDetailsFieldsModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: REGISTER */
public final class FetchSouvenirs {

    /* compiled from: REGISTER */
    public class FetchSouvenirsString extends TypedGraphQlQueryString<SouvenirsDetailsFieldsModel> {
        public FetchSouvenirsString() {
            super(SouvenirsDetailsFieldsModel.class, false, "FetchSouvenirs", "6bcf6ae6437bd0935d3a84bcee7acbf3", "node", "10154658545211729", RegularImmutableSet.a);
        }

        public final String m26264a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "5";
                case -1745741354:
                    return "7";
                case -1663499699:
                    return "3";
                case -1150725321:
                    return "6";
                case -461877888:
                    return "4";
                case -317710003:
                    return "9";
                case 169846802:
                    return "2";
                case 338501707:
                    return "0";
                case 557908192:
                    return "8";
                case 692733304:
                    return "10";
                case 1939875509:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
