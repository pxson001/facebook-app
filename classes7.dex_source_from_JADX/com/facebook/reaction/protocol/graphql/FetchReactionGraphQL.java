package com.facebook.reaction.protocol.graphql;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionMoreAttachmentsResultModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionQueryFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionSuggestedEventsQueryModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionMoreComponentsResultModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: filter must not be null */
public final class FetchReactionGraphQL {

    /* compiled from: filter must not be null */
    public class ReactionMoreAttachmentsQueryString extends TypedGraphQlQueryString<ReactionMoreAttachmentsResultModel> {
        public ReactionMoreAttachmentsQueryString() {
            super(ReactionMoreAttachmentsResultModel.class, false, "ReactionMoreAttachmentsQuery", "dd2d98cd9ea82f6e6f56e81e80d88f63", "node", "10154686761641729", RegularImmutableSet.a);
        }

        public final TriState m15298g() {
            return TriState.NO;
        }

        public final String m15296a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "20";
                case -2069553567:
                    return "59";
                case -1982982801:
                    return "62";
                case -1966188374:
                    return "37";
                case -1849402738:
                    return "4";
                case -1831222590:
                    return "66";
                case -1780769805:
                    return "13";
                case -1778558196:
                    return "33";
                case -1773565470:
                    return "75";
                case -1745741354:
                    return "12";
                case -1663499699:
                    return "28";
                case -1651445858:
                    return "50";
                case -1485026109:
                    return "63";
                case -1469598440:
                    return "21";
                case -1460262781:
                    return "73";
                case -1397293948:
                    return "39";
                case -1363693170:
                    return "40";
                case -1362584798:
                    return "45";
                case -1333184300:
                    return "42";
                case -1150725321:
                    return "11";
                case -1101600581:
                    return "1";
                case -1091844130:
                    return "47";
                case -1012194872:
                    return "72";
                case -971327749:
                    return "56";
                case -817257615:
                    return "34";
                case -799736697:
                    return "48";
                case -790388762:
                    return "38";
                case -783752827:
                    return "53";
                case -631654088:
                    return "7";
                case -621921156:
                    return "51";
                case -561505403:
                    return "15";
                case -538773735:
                    return "32";
                case -493674687:
                    return "49";
                case -461877888:
                    return "29";
                case -317710003:
                    return "31";
                case -217290325:
                    return "64";
                case -164645908:
                    return "60";
                case -164083748:
                    return "65";
                case -92787706:
                    return "9";
                case -19268531:
                    return "44";
                case -11314776:
                    return "52";
                case 25209764:
                    return "3";
                case 169846802:
                    return "10";
                case 169997180:
                    return "69";
                case 293932680:
                    return "58";
                case 421050507:
                    return "76";
                case 447915951:
                    return "43";
                case 485031261:
                    return "61";
                case 557908192:
                    return "30";
                case 580042479:
                    return "14";
                case 609122022:
                    return "6";
                case 651215103:
                    return "16";
                case 656444234:
                    return "71";
                case 689802720:
                    return "19";
                case 692733304:
                    return "55";
                case 797640206:
                    return "36";
                case 810737919:
                    return "23";
                case 860214447:
                    return "54";
                case 996172250:
                    return "22";
                case 1037267417:
                    return "67";
                case 1091074225:
                    return "57";
                case 1108260124:
                    return "18";
                case 1139691781:
                    return "74";
                case 1145249444:
                    return "46";
                case 1262925297:
                    return "24";
                case 1282232523:
                    return "25";
                case 1420616515:
                    return "70";
                case 1520778617:
                    return "41";
                case 1585010628:
                    return "17";
                case 1598177384:
                    return "2";
                case 1639748947:
                    return "26";
                case 1642411190:
                    return "68";
                case 1673542407:
                    return "8";
                case 1831224761:
                    return "27";
                case 1939875509:
                    return "5";
                case 1963391292:
                    return "35";
                case 2094370299:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m15297a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1574:
                    if (str.equals("17")) {
                        z = true;
                        break;
                    }
                    break;
                case 1598:
                    if (str.equals("20")) {
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
                case 1601:
                    if (str.equals("23")) {
                        z = false;
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
                case 1668:
                    if (str.equals("48")) {
                        z = true;
                        break;
                    }
                    break;
                case 1692:
                    if (str.equals("51")) {
                        z = true;
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

    /* compiled from: filter must not be null */
    public class ReactionMoreComponentsQueryString extends TypedGraphQlQueryString<ReactionMoreComponentsResultModel> {
        public ReactionMoreComponentsQueryString() {
            super(ReactionMoreComponentsResultModel.class, false, "ReactionMoreComponentsQuery", "1c98998fbeb5ea0e2fdbd9a4462e9b5f", "node", "10154688433341729", RegularImmutableSet.a);
        }

        public final TriState m15301g() {
            return TriState.NO;
        }

        public final String m15299a(String str) {
            switch (str.hashCode()) {
                case -2018573478:
                    return "23";
                case -1982982801:
                    return "20";
                case -1831222590:
                    return "18";
                case -1780769805:
                    return "32";
                case -1777441434:
                    return "10";
                case -1773565470:
                    return "41";
                case -1745741354:
                    return "31";
                case -1700233621:
                    return "2";
                case -1663499699:
                    return "35";
                case -1651445858:
                    return "51";
                case -1485026109:
                    return "21";
                case -1469598440:
                    return "5";
                case -1460262781:
                    return "48";
                case -1363693170:
                    return "12";
                case -1362584798:
                    return "39";
                case -1332654029:
                    return "15";
                case -1284189600:
                    return "22";
                case -1150725321:
                    return "30";
                case -1101600581:
                    return "1";
                case -1091844130:
                    return "52";
                case -1012194872:
                    return "53";
                case -986526968:
                    return "24";
                case -799736697:
                    return "49";
                case -783752827:
                    return "14";
                case -631654088:
                    return "40";
                case -561505403:
                    return "44";
                case -493674687:
                    return "50";
                case -461877888:
                    return "36";
                case -378761310:
                    return "17";
                case -317710003:
                    return "38";
                case -291906585:
                    return "26";
                case -19268531:
                    return "54";
                case -11314776:
                    return "13";
                case 25209764:
                    return "9";
                case 109250890:
                    return "3";
                case 169846802:
                    return "34";
                case 388662790:
                    return "19";
                case 421050507:
                    return "42";
                case 447915951:
                    return "46";
                case 557908192:
                    return "37";
                case 580042479:
                    return "43";
                case 651215103:
                    return "45";
                case 689802720:
                    return "4";
                case 996172250:
                    return "6";
                case 1037267417:
                    return "16";
                case 1139691781:
                    return "47";
                case 1408059794:
                    return "28";
                case 1414179291:
                    return "25";
                case 1423926404:
                    return "11";
                case 1598177384:
                    return "8";
                case 1642411190:
                    return "29";
                case 1675091374:
                    return "27";
                case 1795944947:
                    return "0";
                case 1911442659:
                    return "7";
                case 1939875509:
                    return "33";
                default:
                    return str;
            }
        }

        protected final boolean m15300a(String str, Object obj) {
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
                case 1638:
                    if (str.equals("39")) {
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
                        z = true;
                        break;
                    }
                    break;
                case 1692:
                    if (str.equals("51")) {
                        z = false;
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
                case 1695:
                    if (str.equals("54")) {
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

    /* compiled from: filter must not be null */
    public class ReactionQueryString extends TypedGraphQlQueryString<ReactionQueryFragmentModel> {
        public ReactionQueryString() {
            super(ReactionQueryFragmentModel.class, false, "ReactionQuery", "db95ea2e40f4bc2223a7086014d90a63", "reaction_trigger", "10154688433446729", RegularImmutableSet.a);
        }

        public final TriState m15304g() {
            return TriState.NO;
        }

        public final String m15302a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "22";
                case -2069553567:
                    return "68";
                case -2018573478:
                    return "75";
                case -1982982801:
                    return "90";
                case -1966188374:
                    return "40";
                case -1849402738:
                    return "4";
                case -1831222590:
                    return "71";
                case -1780769805:
                    return "13";
                case -1778558196:
                    return "35";
                case -1777441434:
                    return "43";
                case -1773565470:
                    return "100";
                case -1745741354:
                    return "12";
                case -1700233621:
                    return "19";
                case -1663499699:
                    return "30";
                case -1651445858:
                    return "55";
                case -1624555481:
                    return "0";
                case -1488256876:
                    return "84";
                case -1485026109:
                    return "91";
                case -1482123462:
                    return "83";
                case -1469598440:
                    return "23";
                case -1460262781:
                    return "98";
                case -1397293948:
                    return "42";
                case -1363693170:
                    return "45";
                case -1362584798:
                    return "50";
                case -1333184300:
                    return "47";
                case -1332962213:
                    return "66";
                case -1332654029:
                    return "64";
                case -1284189600:
                    return "74";
                case -1150725321:
                    return "11";
                case -1101600581:
                    return "1";
                case -1091844130:
                    return "52";
                case -1012194872:
                    return "97";
                case -986526968:
                    return "76";
                case -971327749:
                    return "61";
                case -817257615:
                    return "36";
                case -799736697:
                    return "53";
                case -790388762:
                    return "41";
                case -783752827:
                    return "58";
                case -631654088:
                    return "7";
                case -621921156:
                    return "56";
                case -561505403:
                    return "15";
                case -538773735:
                    return "34";
                case -493674687:
                    return "54";
                case -461877888:
                    return "31";
                case -378761310:
                    return "67";
                case -317710003:
                    return "33";
                case -291906585:
                    return "80";
                case -217290325:
                    return "73";
                case -164645908:
                    return "69";
                case -164083748:
                    return "79";
                case -92787706:
                    return "9";
                case -27697749:
                    return "89";
                case -19268531:
                    return "49";
                case -11314776:
                    return "57";
                case 20000209:
                    return "78";
                case 25209764:
                    return "3";
                case 109250890:
                    return "20";
                case 169846802:
                    return "10";
                case 169997180:
                    return "94";
                case 293265700:
                    return "88";
                case 293932680:
                    return "63";
                case 388662790:
                    return "72";
                case 421050507:
                    return "101";
                case 447915951:
                    return "48";
                case 485031261:
                    return "70";
                case 557908192:
                    return "32";
                case 580042479:
                    return "14";
                case 609122022:
                    return "6";
                case 651215103:
                    return "16";
                case 656444234:
                    return "96";
                case 689802720:
                    return "21";
                case 692733304:
                    return "60";
                case 797640206:
                    return "39";
                case 810737919:
                    return "25";
                case 860214447:
                    return "59";
                case 996172250:
                    return "24";
                case 1006797910:
                    return "86";
                case 1028378801:
                    return "82";
                case 1037267417:
                    return "65";
                case 1091074225:
                    return "62";
                case 1108260124:
                    return "18";
                case 1139691781:
                    return "99";
                case 1145249444:
                    return "51";
                case 1262925297:
                    return "26";
                case 1282232523:
                    return "27";
                case 1408059794:
                    return "92";
                case 1414179291:
                    return "77";
                case 1420616515:
                    return "95";
                case 1423926404:
                    return "44";
                case 1478964448:
                    return "85";
                case 1520778617:
                    return "46";
                case 1585010628:
                    return "17";
                case 1598177384:
                    return "2";
                case 1639748947:
                    return "28";
                case 1642411190:
                    return "93";
                case 1673542407:
                    return "8";
                case 1675091374:
                    return "81";
                case 1753718039:
                    return "87";
                case 1831224761:
                    return "29";
                case 1911442659:
                    return "38";
                case 1939875509:
                    return "5";
                case 1963391292:
                    return "37";
                default:
                    return str;
            }
        }

        protected final boolean m15303a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1574:
                    if (str.equals("17")) {
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
                case 1603:
                    if (str.equals("25")) {
                        z = false;
                        break;
                    }
                    break;
                case 1665:
                    if (str.equals("45")) {
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
                case 1691:
                    if (str.equals("50")) {
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
                case 1697:
                    if (str.equals("56")) {
                        z = true;
                        break;
                    }
                    break;
                case 1791:
                    if (str.equals("87")) {
                        z = true;
                        break;
                    }
                    break;
                case 1792:
                    if (str.equals("88")) {
                        z = true;
                        break;
                    }
                    break;
                case 1793:
                    if (str.equals("89")) {
                        z = true;
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
                    return obj instanceof String ? "undefined".equals(obj) : false;
                case true:
                    return obj instanceof String ? "undefined".equals(obj) : false;
                case true:
                    return obj instanceof String ? "undefined".equals(obj) : false;
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

    /* compiled from: filter must not be null */
    public class ReactionSuggestedEventsQueryString extends TypedGraphQlQueryString<ReactionSuggestedEventsQueryModel> {
        public ReactionSuggestedEventsQueryString() {
            super(ReactionSuggestedEventsQueryModel.class, false, "ReactionSuggestedEventsQuery", "80e67f3d6333f18dbf42e6b5b909d0be", "viewer", "10154688433326729", RegularImmutableSet.a);
        }

        public final TriState m15307g() {
            return TriState.NO;
        }

        public final String m15305a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "23";
                case -2069553567:
                    return "69";
                case -2018573478:
                    return "76";
                case -1982982801:
                    return "87";
                case -1966188374:
                    return "41";
                case -1849402738:
                    return "5";
                case -1831222590:
                    return "72";
                case -1780769805:
                    return "14";
                case -1778558196:
                    return "36";
                case -1777441434:
                    return "44";
                case -1773565470:
                    return "94";
                case -1745741354:
                    return "13";
                case -1700233621:
                    return "20";
                case -1663499699:
                    return "31";
                case -1651445858:
                    return "56";
                case -1485026109:
                    return "88";
                case -1469598440:
                    return "24";
                case -1460262781:
                    return "92";
                case -1397293948:
                    return "43";
                case -1391624807:
                    return "1";
                case -1363693170:
                    return "46";
                case -1362584798:
                    return "51";
                case -1333184300:
                    return "48";
                case -1332962213:
                    return "67";
                case -1332654029:
                    return "65";
                case -1284189600:
                    return "75";
                case -1150725321:
                    return "12";
                case -1101600581:
                    return "2";
                case -1091844130:
                    return "53";
                case -1012194872:
                    return "91";
                case -986526968:
                    return "77";
                case -971327749:
                    return "62";
                case -817257615:
                    return "37";
                case -799736697:
                    return "54";
                case -790388762:
                    return "42";
                case -783752827:
                    return "59";
                case -631654088:
                    return "8";
                case -621921156:
                    return "57";
                case -561505403:
                    return "16";
                case -538773735:
                    return "35";
                case -493674687:
                    return "55";
                case -461877888:
                    return "32";
                case -378761310:
                    return "68";
                case -317710003:
                    return "34";
                case -291906585:
                    return "81";
                case -217290325:
                    return "74";
                case -164645908:
                    return "70";
                case -164083748:
                    return "80";
                case -92787706:
                    return "10";
                case -19268531:
                    return "50";
                case -11314776:
                    return "58";
                case 20000209:
                    return "79";
                case 25209764:
                    return "4";
                case 109250890:
                    return "21";
                case 169846802:
                    return "11";
                case 169997180:
                    return "86";
                case 293932680:
                    return "64";
                case 388662790:
                    return "73";
                case 421050507:
                    return "95";
                case 447915951:
                    return "49";
                case 485031261:
                    return "71";
                case 557908192:
                    return "33";
                case 580042479:
                    return "15";
                case 609122022:
                    return "7";
                case 651215103:
                    return "17";
                case 656444234:
                    return "90";
                case 689802720:
                    return "22";
                case 692733304:
                    return "61";
                case 797640206:
                    return "40";
                case 810737919:
                    return "26";
                case 860214447:
                    return "60";
                case 996172250:
                    return "25";
                case 1028378801:
                    return "83";
                case 1037267417:
                    return "66";
                case 1091074225:
                    return "63";
                case 1108260124:
                    return "19";
                case 1139691781:
                    return "93";
                case 1145249444:
                    return "52";
                case 1246913140:
                    return "0";
                case 1262925297:
                    return "27";
                case 1282232523:
                    return "28";
                case 1408059794:
                    return "84";
                case 1414179291:
                    return "78";
                case 1420616515:
                    return "89";
                case 1423926404:
                    return "45";
                case 1520778617:
                    return "47";
                case 1585010628:
                    return "18";
                case 1598177384:
                    return "3";
                case 1639748947:
                    return "29";
                case 1642411190:
                    return "85";
                case 1673542407:
                    return "9";
                case 1675091374:
                    return "82";
                case 1831224761:
                    return "30";
                case 1911442659:
                    return "39";
                case 1939875509:
                    return "6";
                case 1963391292:
                    return "38";
                default:
                    return str;
            }
        }

        protected final boolean m15306a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1575:
                    if (str.equals("18")) {
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
                case 1602:
                    if (str.equals("24")) {
                        z = true;
                        break;
                    }
                    break;
                case 1604:
                    if (str.equals("26")) {
                        z = false;
                        break;
                    }
                    break;
                case 1668:
                    if (str.equals("48")) {
                        z = true;
                        break;
                    }
                    break;
                case 1692:
                    if (str.equals("51")) {
                        z = true;
                        break;
                    }
                    break;
                case 1695:
                    if (str.equals("54")) {
                        z = true;
                        break;
                    }
                    break;
                case 1698:
                    if (str.equals("57")) {
                        z = true;
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

    public static final ReactionMoreAttachmentsQueryString m15308c() {
        return new ReactionMoreAttachmentsQueryString();
    }
}
