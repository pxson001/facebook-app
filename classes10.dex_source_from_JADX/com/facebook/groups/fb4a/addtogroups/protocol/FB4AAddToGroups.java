package com.facebook.groups.fb4a.addtogroups.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.fb4a.addtogroups.protocol.FB4AAddToGroupsModels.FetchUserGroupsForProfileAddToGroupsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: writeFullResultToDatabase */
public final class FB4AAddToGroups {

    /* compiled from: writeFullResultToDatabase */
    public class FetchUserGroupsForProfileAddToGroupsString extends TypedGraphQlQueryString<FetchUserGroupsForProfileAddToGroupsModel> {
        public FetchUserGroupsForProfileAddToGroupsString() {
            super(FetchUserGroupsForProfileAddToGroupsModel.class, false, "FetchUserGroupsForProfileAddToGroups", "bf0636eedf250571aac47fe4c4f85841", "node", "10154358997671729", RegularImmutableSet.a);
        }

        public final String m325a(String str) {
            switch (str.hashCode()) {
                case -1205127252:
                    return "3";
                case -1165034916:
                    return "1";
                case -1035838378:
                    return "0";
                case -620205220:
                    return "5";
                case -283133711:
                    return "4";
                case 1066675265:
                    return "2";
                default:
                    return str;
            }
        }
    }
}
