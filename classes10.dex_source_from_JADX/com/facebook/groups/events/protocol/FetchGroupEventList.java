package com.facebook.groups.events.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.events.protocol.FetchGroupEventListModels.FetchGroupEventListModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: UNKNOWN_LISTENER */
public final class FetchGroupEventList {

    /* compiled from: UNKNOWN_LISTENER */
    public class FetchGroupEventListString extends TypedGraphQlQueryString<FetchGroupEventListModel> {
        public FetchGroupEventListString() {
            super(FetchGroupEventListModel.class, false, "FetchGroupEventList", "80c2e4823bea7f238c0f551d9b82f845", "group_address", "10154686241856729", RegularImmutableSet.a);
        }

        public final String m22981a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "4";
                case -77796550:
                    return "2";
                case 25209764:
                    return "13";
                case 43060928:
                    return "1";
                case 506361563:
                    return "0";
                case 689802720:
                    return "11";
                case 810737919:
                    return "5";
                case 1262925297:
                    return "6";
                case 1282232523:
                    return "8";
                case 1450828235:
                    return "3";
                case 1598177384:
                    return "12";
                case 1639748947:
                    return "9";
                case 1831224761:
                    return "10";
                case 1939875509:
                    return "7";
                default:
                    return str;
            }
        }

        protected final boolean m22982a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 53:
                    if (str.equals("5")) {
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
