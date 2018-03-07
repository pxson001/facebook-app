package com.facebook.feedplugins.storyset.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: SHOWING_REAL_TIME_ACTIVITY */
public final class FetchPaginatedStorySetItemsGraphQL {

    /* compiled from: SHOWING_REAL_TIME_ACTIVITY */
    public class FetchPaginatedStorySetItemsQueryString extends TypedGraphQlQueryString<GraphQLViewer> {
        public FetchPaginatedStorySetItemsQueryString() {
            super(GraphQLViewer.class, false, "FetchPaginatedStorySetItemsQuery", "c58e3deeeb1fa8e881a9aac5d2930860", "viewer", "10154686761161729", RegularImmutableSet.a);
        }

        public final TriState m25977g() {
            return TriState.NO;
        }

        public final String m25975a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "25";
                case -1966188374:
                    return "36";
                case -1849402738:
                    return "9";
                case -1780769805:
                    return "18";
                case -1778558196:
                    return "32";
                case -1745741354:
                    return "17";
                case -1663499699:
                    return "27";
                case -1651445858:
                    return "48";
                case -1469598440:
                    return "26";
                case -1460262781:
                    return "57";
                case -1397293948:
                    return "38";
                case -1363693170:
                    return "39";
                case -1362584798:
                    return "43";
                case -1150725321:
                    return "16";
                case -1101600581:
                    return "6";
                case -1091844130:
                    return "45";
                case -1012194872:
                    return "56";
                case -971327749:
                    return "51";
                case -817257615:
                    return "33";
                case -799736697:
                    return "46";
                case -790388762:
                    return "37";
                case -631654088:
                    return "12";
                case -621921156:
                    return "49";
                case -561505403:
                    return "20";
                case -538773735:
                    return "31";
                case -493674687:
                    return "47";
                case -461877888:
                    return "28";
                case -317710003:
                    return "30";
                case -230346670:
                    return "4";
                case -92787706:
                    return "14";
                case -19268531:
                    return "42";
                case 25209764:
                    return "8";
                case 43089941:
                    return "3";
                case 94851343:
                    return "5";
                case 169846802:
                    return "15";
                case 293932680:
                    return "53";
                case 447915951:
                    return "41";
                case 557908192:
                    return "29";
                case 580042479:
                    return "19";
                case 609122022:
                    return "11";
                case 651215103:
                    return "21";
                case 656444234:
                    return "55";
                case 689802720:
                    return "24";
                case 797640206:
                    return "35";
                case 810737919:
                    return "50";
                case 988849032:
                    return "1";
                case 1091074225:
                    return "52";
                case 1108260124:
                    return "23";
                case 1139691781:
                    return "58";
                case 1145249444:
                    return "44";
                case 1250156604:
                    return "0";
                case 1420616515:
                    return "54";
                case 1520778617:
                    return "40";
                case 1542046293:
                    return "2";
                case 1585010628:
                    return "22";
                case 1598177384:
                    return "7";
                case 1673542407:
                    return "13";
                case 1939875509:
                    return "10";
                case 1963391292:
                    return "34";
                default:
                    return str;
            }
        }

        protected final boolean m25976a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1600:
                    if (str.equals("22")) {
                        z = true;
                        break;
                    }
                    break;
                case 1603:
                    if (str.equals("25")) {
                        z = true;
                        break;
                    }
                    break;
                case 1604:
                    if (str.equals("26")) {
                        z = true;
                        break;
                    }
                    break;
                case 1663:
                    if (str.equals("43")) {
                        z = true;
                        break;
                    }
                    break;
                case 1666:
                    if (str.equals("46")) {
                        z = true;
                        break;
                    }
                    break;
                case 1669:
                    if (str.equals("49")) {
                        z = true;
                        break;
                    }
                    break;
                case 1691:
                    if (str.equals("50")) {
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
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
