package com.facebook.feed.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.ImmutableSet;

/* compiled from: mobile_android_tagger */
public final class FetchPageFeedGraphQL {

    /* compiled from: mobile_android_tagger */
    public class FetchPageFeedString extends TypedGraphQlQueryString<GraphQLViewer> {
        public FetchPageFeedString() {
            super(GraphQLViewer.class, false, "FetchPageFeed", "1fca945b27df741493395da606ef5970", "viewer", "10154686760866729", ImmutableSet.of("end_cursor"));
        }

        public final TriState m16265g() {
            return TriState.NO;
        }

        public final String m16263a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "22";
                case -2096998877:
                    return "0";
                case -1966188374:
                    return "33";
                case -1849402738:
                    return "6";
                case -1780769805:
                    return "15";
                case -1778558196:
                    return "29";
                case -1745741354:
                    return "14";
                case -1663499699:
                    return "24";
                case -1651445858:
                    return "45";
                case -1469598440:
                    return "23";
                case -1460262781:
                    return "54";
                case -1397293948:
                    return "35";
                case -1363693170:
                    return "36";
                case -1362584798:
                    return "40";
                case -1150725321:
                    return "13";
                case -1101600581:
                    return "3";
                case -1091844130:
                    return "42";
                case -1012194872:
                    return "53";
                case -971327749:
                    return "48";
                case -817257615:
                    return "30";
                case -799736697:
                    return "43";
                case -790388762:
                    return "34";
                case -781030638:
                    return "2";
                case -631654088:
                    return "9";
                case -621921156:
                    return "46";
                case -561505403:
                    return "17";
                case -538773735:
                    return "28";
                case -493674687:
                    return "44";
                case -461877888:
                    return "25";
                case -317710003:
                    return "27";
                case -92787706:
                    return "11";
                case -19268531:
                    return "39";
                case 25209764:
                    return "5";
                case 169846802:
                    return "12";
                case 293932680:
                    return "50";
                case 299464038:
                    return "1";
                case 447915951:
                    return "38";
                case 557908192:
                    return "26";
                case 580042479:
                    return "16";
                case 609122022:
                    return "8";
                case 651215103:
                    return "18";
                case 656444234:
                    return "52";
                case 689802720:
                    return "21";
                case 797640206:
                    return "32";
                case 810737919:
                    return "47";
                case 1091074225:
                    return "49";
                case 1108260124:
                    return "20";
                case 1139691781:
                    return "55";
                case 1145249444:
                    return "41";
                case 1420616515:
                    return "51";
                case 1520778617:
                    return "37";
                case 1585010628:
                    return "19";
                case 1598177384:
                    return "4";
                case 1673542407:
                    return "10";
                case 1939875509:
                    return "7";
                case 1963391292:
                    return "31";
                default:
                    return str;
            }
        }

        protected final boolean m16264a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1576:
                    if (str.equals("19")) {
                        z = true;
                        break;
                    }
                    break;
                case 1600:
                    if (str.equals("22")) {
                        z = true;
                        break;
                    }
                    break;
                case 1601:
                    if (str.equals("23")) {
                        z = true;
                        break;
                    }
                    break;
                case 1660:
                    if (str.equals("40")) {
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
                case 1667:
                    if (str.equals("47")) {
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
