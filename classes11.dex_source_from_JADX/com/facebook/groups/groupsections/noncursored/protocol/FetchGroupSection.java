package com.facebook.groups.groupsections.noncursored.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.groupsections.noncursored.protocol.FetchGroupSectionModels.FetchGroupSectionModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: [I */
public final class FetchGroupSection {

    /* compiled from: [I */
    public class FetchGroupSectionString extends TypedGraphQlQueryString<FetchGroupSectionModel> {
        public FetchGroupSectionString() {
            super(FetchGroupSectionModel.class, false, "FetchGroupSection", "1f434401dbd60ddb67a8ec38e29cb28a", "viewer", "10154645376821729", RegularImmutableSet.a);
        }

        public final String m10670a(String str) {
            switch (str.hashCode()) {
                case -1817310054:
                    return "8";
                case -1480249367:
                    return "0";
                case -283181341:
                    return "1";
                case -153718306:
                    return "4";
                case -77796550:
                    return "6";
                case 94851343:
                    return "7";
                case 106006350:
                    return "5";
                case 140963625:
                    return "2";
                case 1858717423:
                    return "3";
                default:
                    return str;
            }
        }

        protected final boolean m10671a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 52:
                    if (str.equals("4")) {
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
