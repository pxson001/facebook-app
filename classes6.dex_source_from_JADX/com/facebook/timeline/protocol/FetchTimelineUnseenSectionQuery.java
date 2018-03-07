package com.facebook.timeline.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: decode persisted file */
public final class FetchTimelineUnseenSectionQuery {

    /* compiled from: decode persisted file */
    public class TimelineUnseenStoriesQueryString extends TypedGraphQlQueryString<GraphQLUser> {
        public TimelineUnseenStoriesQueryString() {
            super(GraphQLUser.class, false, "TimelineUnseenStoriesQuery", "f9aeff96777d6f91e22a74a1d090cc0c", "user", "10154686761711729", RegularImmutableSet.a);
        }

        public final TriState m26224g() {
            return TriState.NO;
        }

        public final String m26222a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "21";
                case -1966188374:
                    return "32";
                case -1849402738:
                    return "4";
                case -1780769805:
                    return "13";
                case -1778558196:
                    return "28";
                case -1745741354:
                    return "12";
                case -1663499699:
                    return "23";
                case -1651445858:
                    return "44";
                case -1469598440:
                    return "22";
                case -1460262781:
                    return "53";
                case -1397293948:
                    return "34";
                case -1363693170:
                    return "35";
                case -1362584798:
                    return "39";
                case -1150725321:
                    return "11";
                case -1102636175:
                    return "0";
                case -1101600581:
                    return "1";
                case -1091844130:
                    return "41";
                case -1012194872:
                    return "52";
                case -971327749:
                    return "47";
                case -817257615:
                    return "29";
                case -799736697:
                    return "42";
                case -790388762:
                    return "33";
                case -672731075:
                    return "18";
                case -631654088:
                    return "7";
                case -621921156:
                    return "45";
                case -561505403:
                    return "15";
                case -538773735:
                    return "27";
                case -493674687:
                    return "43";
                case -461877888:
                    return "24";
                case -317710003:
                    return "26";
                case -92787706:
                    return "9";
                case -19268531:
                    return "38";
                case 25209764:
                    return "3";
                case 169846802:
                    return "10";
                case 293932680:
                    return "49";
                case 447915951:
                    return "37";
                case 557908192:
                    return "25";
                case 580042479:
                    return "14";
                case 609122022:
                    return "6";
                case 651215103:
                    return "16";
                case 656444234:
                    return "51";
                case 689802720:
                    return "20";
                case 797640206:
                    return "31";
                case 810737919:
                    return "46";
                case 1091074225:
                    return "48";
                case 1108260124:
                    return "19";
                case 1139691781:
                    return "54";
                case 1145249444:
                    return "40";
                case 1420616515:
                    return "50";
                case 1520778617:
                    return "36";
                case 1585010628:
                    return "17";
                case 1598177384:
                    return "2";
                case 1673542407:
                    return "8";
                case 1939875509:
                    return "5";
                case 1963391292:
                    return "30";
                default:
                    return str;
            }
        }

        protected final boolean m26223a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1574:
                    if (str.equals("17")) {
                        z = true;
                        break;
                    }
                    break;
                case 1599:
                    if (str.equals("21")) {
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
                case 1638:
                    if (str.equals("39")) {
                        z = true;
                        break;
                    }
                    break;
                case 1662:
                    if (str.equals("42")) {
                        z = true;
                        break;
                    }
                    break;
                case 1665:
                    if (str.equals("45")) {
                        z = true;
                        break;
                    }
                    break;
                case 1666:
                    if (str.equals("46")) {
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
