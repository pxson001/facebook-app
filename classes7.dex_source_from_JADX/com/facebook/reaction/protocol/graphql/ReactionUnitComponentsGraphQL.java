package com.facebook.reaction.protocol.graphql;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionMoreSubComponentsResultModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: fetch_time */
public final class ReactionUnitComponentsGraphQL {

    /* compiled from: fetch_time */
    public class ReactionMoreSubComponentsQueryString extends TypedGraphQlQueryString<ReactionMoreSubComponentsResultModel> {
        public ReactionMoreSubComponentsQueryString() {
            super(ReactionMoreSubComponentsResultModel.class, false, "ReactionMoreSubComponentsQuery", "93d7aed51abfbd85c411af9cebd1a64c", "node", "10154688433276729", RegularImmutableSet.a);
        }

        public final TriState m16688g() {
            return TriState.NO;
        }

        public final String m16686a(String str) {
            switch (str.hashCode()) {
                case -2018573478:
                    return "23";
                case -1982982801:
                    return "20";
                case -1831222590:
                    return "18";
                case -1780769805:
                    return "31";
                case -1777441434:
                    return "10";
                case -1773565470:
                    return "40";
                case -1745741354:
                    return "30";
                case -1700233621:
                    return "2";
                case -1663499699:
                    return "34";
                case -1651445858:
                    return "50";
                case -1485026109:
                    return "21";
                case -1469598440:
                    return "5";
                case -1460262781:
                    return "47";
                case -1363693170:
                    return "12";
                case -1362584798:
                    return "38";
                case -1332654029:
                    return "15";
                case -1284189600:
                    return "22";
                case -1150725321:
                    return "29";
                case -1101600581:
                    return "1";
                case -1091844130:
                    return "51";
                case -1012194872:
                    return "52";
                case -986526968:
                    return "24";
                case -799736697:
                    return "48";
                case -783752827:
                    return "14";
                case -631654088:
                    return "39";
                case -561505403:
                    return "43";
                case -493674687:
                    return "49";
                case -461877888:
                    return "35";
                case -378761310:
                    return "17";
                case -317710003:
                    return "37";
                case -291906585:
                    return "26";
                case -19268531:
                    return "53";
                case -11314776:
                    return "13";
                case 25209764:
                    return "9";
                case 109250890:
                    return "3";
                case 169846802:
                    return "33";
                case 388662790:
                    return "19";
                case 421050507:
                    return "41";
                case 447915951:
                    return "45";
                case 557908192:
                    return "36";
                case 580042479:
                    return "42";
                case 651215103:
                    return "44";
                case 689802720:
                    return "4";
                case 996172250:
                    return "6";
                case 1037267417:
                    return "16";
                case 1139691781:
                    return "46";
                case 1408059794:
                    return "27";
                case 1414179291:
                    return "25";
                case 1423926404:
                    return "11";
                case 1598177384:
                    return "8";
                case 1642411190:
                    return "28";
                case 1795944947:
                    return "0";
                case 1911442659:
                    return "7";
                case 1939875509:
                    return "32";
                default:
                    return str;
            }
        }

        protected final boolean m16687a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 53:
                    if (str.equals("5")) {
                        z = true;
                        break;
                    }
                    break;
                case 1569:
                    if (str.equals("12")) {
                        z = true;
                        break;
                    }
                    break;
                case 1637:
                    if (str.equals("38")) {
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
                case 1666:
                    if (str.equals("46")) {
                        z = true;
                        break;
                    }
                    break;
                case 1667:
                    if (str.equals("47")) {
                        z = true;
                        break;
                    }
                    break;
                case 1668:
                    if (str.equals("48")) {
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
                case 1692:
                    if (str.equals("51")) {
                        z = true;
                        break;
                    }
                    break;
                case 1693:
                    if (str.equals("52")) {
                        z = true;
                        break;
                    }
                    break;
                case 1694:
                    if (str.equals("53")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "video_channels".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "MPEG_DASH".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "VIDEO_HOME".equals(obj);
                    }
                    return false;
                case true:
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
