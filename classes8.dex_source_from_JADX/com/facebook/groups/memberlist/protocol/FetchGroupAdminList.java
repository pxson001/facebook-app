package com.facebook.groups.memberlist.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.memberlist.protocol.FetchGroupAdminListModels.FetchGroupAdminListModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: extra_invite_action_mechanism */
public final class FetchGroupAdminList {

    /* compiled from: extra_invite_action_mechanism */
    public class FetchGroupAdminListString extends TypedGraphQlQueryString<FetchGroupAdminListModel> {
        public FetchGroupAdminListString() {
            super(FetchGroupAdminListModel.class, false, "FetchGroupAdminList", "833c3389761ec1d8371b328b6274253d", "group_address", "10154583598721729", RegularImmutableSet.a);
        }

        public final String m16054a(String str) {
            switch (str.hashCode()) {
                case -1284128427:
                    return "7";
                case -1101600581:
                    return "5";
                case -539238237:
                    return "2";
                case -158875617:
                    return "4";
                case 465004074:
                    return "3";
                case 506361563:
                    return "0";
                case 1418180276:
                    return "6";
                case 1927787727:
                    return "1";
                default:
                    return str;
            }
        }

        protected final boolean m16055a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
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

    public static final FetchGroupAdminListString m16056a() {
        return new FetchGroupAdminListString();
    }
}
