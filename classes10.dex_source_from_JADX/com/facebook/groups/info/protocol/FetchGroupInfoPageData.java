package com.facebook.groups.info.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.info.protocol.FetchGroupInfoPageDataModels.FetchGroupInfoPageDataModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: The update did not succeed */
public final class FetchGroupInfoPageData {

    /* compiled from: The update did not succeed */
    public class FetchGroupInfoPageDataString extends TypedGraphQlQueryString<FetchGroupInfoPageDataModel> {
        public FetchGroupInfoPageDataString() {
            super(FetchGroupInfoPageDataModel.class, false, "FetchGroupInfoPageData", "bf72ce643066c5e150eb92b94768dea1", "group_address", "10154686241866729", RegularImmutableSet.a);
        }

        public final String m23725a(String str) {
            switch (str.hashCode()) {
                case -2065642848:
                    return "10";
                case -1780769805:
                    return "20";
                case -1745741354:
                    return "22";
                case -1663499699:
                    return "18";
                case -1150725321:
                    return "21";
                case -1101600581:
                    return "3";
                case -1052112784:
                    return "13";
                case -461877888:
                    return "19";
                case -449237922:
                    return "2";
                case -317710003:
                    return "24";
                case -147799178:
                    return "1";
                case 25209764:
                    return "16";
                case 169846802:
                    return "17";
                case 506361563:
                    return "0";
                case 557908192:
                    return "23";
                case 689802720:
                    return "14";
                case 810737919:
                    return "4";
                case 1262925297:
                    return "5";
                case 1282232523:
                    return "7";
                case 1450828235:
                    return "11";
                case 1598177384:
                    return "15";
                case 1639748947:
                    return "8";
                case 1831224761:
                    return "9";
                case 1939875509:
                    return "6";
                case 2084690949:
                    return "12";
                default:
                    return str;
            }
        }

        protected final boolean m23726a(String str, Object obj) {
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
