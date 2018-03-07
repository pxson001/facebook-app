package com.facebook.groups.memberlist.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.memberlist.protocol.FetchGroupAdminIdsModels.FetchGroupAdminIdsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: extra_link_menu_url */
public final class FetchGroupAdminIds {

    /* compiled from: extra_link_menu_url */
    public class FetchGroupAdminIdsString extends TypedGraphQlQueryString<FetchGroupAdminIdsModel> {
        public FetchGroupAdminIdsString() {
            super(FetchGroupAdminIdsModel.class, false, "FetchGroupAdminIds", "2d6b1f1e3e5d78fe98e08decd258e3f0", "group_address", "10154584337461729", RegularImmutableSet.a);
        }

        public final String m15989a(String str) {
            switch (str.hashCode()) {
                case -77796550:
                    return "1";
                case -59350230:
                    return "2";
                case 506361563:
                    return "0";
                case 1927787727:
                    return "3";
                default:
                    return str;
            }
        }

        protected final boolean m15990a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 51:
                    if (str.equals("3")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }
}
