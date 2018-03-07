package com.facebook.pages.data.graphql.pageheader;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: confirmation_confirm_contactpoint */
public final class FetchPageHeaderGraphQL {

    /* compiled from: confirmation_confirm_contactpoint */
    public class FetchPageHeaderQueryString extends TypedGraphQlQueryString<FetchPageHeaderQueryModel> {
        public FetchPageHeaderQueryString() {
            super(FetchPageHeaderQueryModel.class, false, "FetchPageHeaderQuery", "1897892caac9d0d49025121ad9caa2f3", "node", "10154676365881729", RegularImmutableSet.a);
        }

        public final String m20870a(String str) {
            switch (str.hashCode()) {
                case -1941579093:
                    return "23";
                case -1780769805:
                    return "20";
                case -1745741354:
                    return "28";
                case -1700233621:
                    return "1";
                case -1663499699:
                    return "25";
                case -1484664976:
                    return "9";
                case -1330156701:
                    return "7";
                case -1179760273:
                    return "3";
                case -1150725321:
                    return "27";
                case -1101600581:
                    return "12";
                case -991011993:
                    return "16";
                case -803548981:
                    return "0";
                case -461877888:
                    return "26";
                case -317710003:
                    return "30";
                case -194679286:
                    return "8";
                case -189589080:
                    return "15";
                case 20000209:
                    return "19";
                case 109250890:
                    return "2";
                case 169846802:
                    return "22";
                case 456344540:
                    return "5";
                case 461053147:
                    return "6";
                case 557908192:
                    return "29";
                case 586730728:
                    return "13";
                case 677812415:
                    return "4";
                case 689802720:
                    return "11";
                case 810737919:
                    return "18";
                case 1562287303:
                    return "10";
                case 1773334990:
                    return "24";
                case 1933778741:
                    return "14";
                case 1939875509:
                    return "21";
                case 2033669637:
                    return "17";
                default:
                    return str;
            }
        }

        protected final boolean m20871a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1575:
                    if (str.equals("18")) {
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
