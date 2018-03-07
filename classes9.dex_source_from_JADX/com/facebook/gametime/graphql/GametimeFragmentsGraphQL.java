package com.facebook.gametime.graphql;

import com.facebook.common.util.TriState;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeDashboardReactionTailLoadFragmentModel;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeFanFavoriteAddVoteMutationModel;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderQueryModel;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderUpdateSubscriptionModel;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimePlaySubscriptionModel;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeReactionHeadLoadFragmentModel;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeReactionTailLoadFragmentModel;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeSportsPlaysQueryModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.graphql.query.TypedGraphQLSubscriptionString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: TEXT DEFAULT 'private' */
public final class GametimeFragmentsGraphQL {

    /* compiled from: TEXT DEFAULT 'private' */
    public class GametimeDashboardReactionTailLoadQueryString extends TypedGraphQlQueryString<GametimeDashboardReactionTailLoadFragmentModel> {
        public GametimeDashboardReactionTailLoadQueryString() {
            super(GametimeDashboardReactionTailLoadFragmentModel.class, false, "GametimeDashboardReactionTailLoadQuery", "e372f8803435d8f82035c8bd1f10a982", "gametime_reaction_units", "10154688433481729", RegularImmutableSet.a);
        }

        public final TriState m26776g() {
            return TriState.NO;
        }

        public final String m26774a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "22";
                case -2069553567:
                    return "77";
                case -2018573478:
                    return "84";
                case -1966188374:
                    return "49";
                case -1849402738:
                    return "4";
                case -1831222590:
                    return "80";
                case -1807695521:
                    return "40";
                case -1780769805:
                    return "13";
                case -1778558196:
                    return "35";
                case -1777441434:
                    return "52";
                case -1773565470:
                    return "100";
                case -1745741354:
                    return "12";
                case -1700233621:
                    return "19";
                case -1663499699:
                    return "30";
                case -1651445858:
                    return "64";
                case -1469598440:
                    return "23";
                case -1460262781:
                    return "98";
                case -1397293948:
                    return "51";
                case -1397104088:
                    return "44";
                case -1363693170:
                    return "54";
                case -1362584798:
                    return "59";
                case -1333184300:
                    return "56";
                case -1332962213:
                    return "75";
                case -1332654029:
                    return "73";
                case -1284189600:
                    return "83";
                case -1150725321:
                    return "11";
                case -1101600581:
                    return "1";
                case -1091844130:
                    return "61";
                case -1012194872:
                    return "97";
                case -986526968:
                    return "85";
                case -971327749:
                    return "70";
                case -817257615:
                    return "36";
                case -799736697:
                    return "62";
                case -790388762:
                    return "50";
                case -783752827:
                    return "67";
                case -631654088:
                    return "7";
                case -621921156:
                    return "65";
                case -561505403:
                    return "15";
                case -538773735:
                    return "34";
                case -493674687:
                    return "63";
                case -461877888:
                    return "31";
                case -378761310:
                    return "76";
                case -317710003:
                    return "33";
                case -291906585:
                    return "89";
                case -260248031:
                    return "42";
                case -230346670:
                    return "45";
                case -217290325:
                    return "82";
                case -192656628:
                    return "41";
                case -164645908:
                    return "78";
                case -164083748:
                    return "88";
                case -92787706:
                    return "9";
                case -19268531:
                    return "58";
                case -11314776:
                    return "66";
                case 20000209:
                    return "87";
                case 25209764:
                    return "3";
                case 94851343:
                    return "46";
                case 109250890:
                    return "20";
                case 169846802:
                    return "10";
                case 169997180:
                    return "94";
                case 293932680:
                    return "72";
                case 375334353:
                    return "0";
                case 388662790:
                    return "81";
                case 421050507:
                    return "101";
                case 447915951:
                    return "57";
                case 485031261:
                    return "79";
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
                    return "69";
                case 797640206:
                    return "48";
                case 810737919:
                    return "25";
                case 860214447:
                    return "68";
                case 996172250:
                    return "24";
                case 1028378801:
                    return "91";
                case 1037267417:
                    return "74";
                case 1091074225:
                    return "71";
                case 1092457133:
                    return "43";
                case 1108260124:
                    return "18";
                case 1139691781:
                    return "99";
                case 1141422913:
                    return "38";
                case 1145249444:
                    return "60";
                case 1232347828:
                    return "39";
                case 1262925297:
                    return "26";
                case 1282232523:
                    return "27";
                case 1408059794:
                    return "92";
                case 1414179291:
                    return "86";
                case 1420616515:
                    return "95";
                case 1423926404:
                    return "53";
                case 1520778617:
                    return "55";
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
                    return "90";
                case 1831224761:
                    return "29";
                case 1911442659:
                    return "47";
                case 1939875509:
                    return "5";
                case 1963391292:
                    return "37";
                default:
                    return str;
            }
        }

        protected final boolean m26775a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 54:
                    if (str.equals("6")) {
                        z = true;
                        break;
                    }
                    break;
                case 55:
                    if (str.equals("7")) {
                        z = true;
                        break;
                    }
                    break;
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
                case 1635:
                    if (str.equals("36")) {
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
                case 1697:
                    if (str.equals("56")) {
                        z = true;
                        break;
                    }
                    break;
                case 1699:
                    if (str.equals("58")) {
                        z = true;
                        break;
                    }
                    break;
                case 1700:
                    if (str.equals("59")) {
                        z = true;
                        break;
                    }
                    break;
                case 1723:
                    if (str.equals("61")) {
                        z = true;
                        break;
                    }
                    break;
                case 1724:
                    if (str.equals("62")) {
                        z = true;
                        break;
                    }
                    break;
                case 1725:
                    if (str.equals("63")) {
                        z = true;
                        break;
                    }
                    break;
                case 1727:
                    if (str.equals("65")) {
                        z = true;
                        break;
                    }
                    break;
                case 1822:
                    if (str.equals("97")) {
                        z = true;
                        break;
                    }
                    break;
                case 1824:
                    if (str.equals("99")) {
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

    /* compiled from: TEXT DEFAULT 'private' */
    public class GametimeFanFavoriteAddVoteMutationString extends TypedGraphQLMutationString<GametimeFanFavoriteAddVoteMutationModel> {
        public GametimeFanFavoriteAddVoteMutationString() {
            super(GametimeFanFavoriteAddVoteMutationModel.class, false, "GametimeFanFavoriteAddVoteMutation", "2c9c260a7ee259ed94f113aa3e21ffc6", "reaction_gametime_fan_favorite_add_vote", "0", "10154551758686729", RegularImmutableSet.a);
        }

        public final String m26777a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: TEXT DEFAULT 'private' */
    public class GametimeMatchHeaderQueryString extends TypedGraphQlQueryString<GametimeMatchHeaderQueryModel> {
        public GametimeMatchHeaderQueryString() {
            super(GametimeMatchHeaderQueryModel.class, false, "GametimeMatchHeaderQuery", "4f683dd06d2bd5f6d704555f53b3a649", "node", "10154643645396729", RegularImmutableSet.a);
        }

        public final String m26778a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: TEXT DEFAULT 'private' */
    public class GametimeMatchHeaderUpdateSubscriptionString extends TypedGraphQLSubscriptionString<GametimeMatchHeaderUpdateSubscriptionModel> {
        public GametimeMatchHeaderUpdateSubscriptionString() {
            super(GametimeMatchHeaderUpdateSubscriptionModel.class, false, "GametimeMatchHeaderUpdateSubscription", "1e1a9cf6fbd4f1c1cada96f848e5a2b7", "gametime_match_data_update_subscribe", "0", "10154609072861729", RegularImmutableSet.a);
        }

        public final String m26779a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: TEXT DEFAULT 'private' */
    public class GametimePlaySubscriptionString extends TypedGraphQLSubscriptionString<GametimePlaySubscriptionModel> {
        public GametimePlaySubscriptionString() {
            super(GametimePlaySubscriptionModel.class, false, "GametimePlaySubscription", "45e4ffc2068525e450c3fd896629c525", "gametime_match_play_create_subscribe", "0", "10154641828786729", RegularImmutableSet.a);
        }

        public final String m26780a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "1";
                case 100358090:
                    return "0";
                case 109250890:
                    return "3";
                case 1911442659:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: TEXT DEFAULT 'private' */
    public class GametimeReactionHeadLoadQueryString extends TypedGraphQlQueryString<GametimeReactionHeadLoadFragmentModel> {
        public GametimeReactionHeadLoadQueryString() {
            super(GametimeReactionHeadLoadFragmentModel.class, false, "GametimeReactionHeadLoadQuery", "09dc9ed7cf264d79b0208577dbc9b362", "gametime_match_reaction_units", "10154688433456729", RegularImmutableSet.a);
        }

        public final TriState m26783g() {
            return TriState.NO;
        }

        public final String m26781a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "22";
                case -2069553567:
                    return "77";
                case -2018573478:
                    return "84";
                case -1966188374:
                    return "49";
                case -1849402738:
                    return "4";
                case -1831222590:
                    return "80";
                case -1807695521:
                    return "41";
                case -1780769805:
                    return "13";
                case -1778558196:
                    return "35";
                case -1777441434:
                    return "52";
                case -1773565470:
                    return "100";
                case -1745741354:
                    return "12";
                case -1700233621:
                    return "19";
                case -1663499699:
                    return "30";
                case -1651445858:
                    return "64";
                case -1469598440:
                    return "23";
                case -1460262781:
                    return "98";
                case -1397293948:
                    return "51";
                case -1397104088:
                    return "45";
                case -1363693170:
                    return "54";
                case -1362584798:
                    return "59";
                case -1333184300:
                    return "56";
                case -1332962213:
                    return "75";
                case -1332654029:
                    return "73";
                case -1284189600:
                    return "83";
                case -1150725321:
                    return "11";
                case -1101600581:
                    return "1";
                case -1091844130:
                    return "61";
                case -1012194872:
                    return "97";
                case -986526968:
                    return "85";
                case -971327749:
                    return "70";
                case -817257615:
                    return "36";
                case -799736697:
                    return "62";
                case -790388762:
                    return "50";
                case -783752827:
                    return "67";
                case -631654088:
                    return "7";
                case -621921156:
                    return "65";
                case -561505403:
                    return "15";
                case -538773735:
                    return "34";
                case -493674687:
                    return "63";
                case -461877888:
                    return "31";
                case -381590603:
                    return "46";
                case -378761310:
                    return "76";
                case -317710003:
                    return "33";
                case -291906585:
                    return "89";
                case -260248031:
                    return "43";
                case -217290325:
                    return "82";
                case -192656628:
                    return "42";
                case -164645908:
                    return "78";
                case -164083748:
                    return "88";
                case -92787706:
                    return "9";
                case -19268531:
                    return "58";
                case -11314776:
                    return "66";
                case 20000209:
                    return "87";
                case 25209764:
                    return "3";
                case 94851343:
                    return "47";
                case 109250890:
                    return "20";
                case 169846802:
                    return "10";
                case 169997180:
                    return "94";
                case 293932680:
                    return "72";
                case 375334353:
                    return "0";
                case 388662790:
                    return "81";
                case 421050507:
                    return "101";
                case 447915951:
                    return "57";
                case 485031261:
                    return "79";
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
                    return "69";
                case 797640206:
                    return "48";
                case 810737919:
                    return "25";
                case 860214447:
                    return "68";
                case 996172250:
                    return "24";
                case 1028378801:
                    return "91";
                case 1037267417:
                    return "74";
                case 1091074225:
                    return "71";
                case 1092457133:
                    return "44";
                case 1108260124:
                    return "18";
                case 1139691781:
                    return "99";
                case 1141422913:
                    return "39";
                case 1145249444:
                    return "60";
                case 1232347828:
                    return "40";
                case 1262925297:
                    return "26";
                case 1282232523:
                    return "27";
                case 1408059794:
                    return "92";
                case 1414179291:
                    return "86";
                case 1420616515:
                    return "95";
                case 1423926404:
                    return "53";
                case 1520778617:
                    return "55";
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
                    return "90";
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

        protected final boolean m26782a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 54:
                    if (str.equals("6")) {
                        z = true;
                        break;
                    }
                    break;
                case 55:
                    if (str.equals("7")) {
                        z = true;
                        break;
                    }
                    break;
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
                case 1635:
                    if (str.equals("36")) {
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
                case 1697:
                    if (str.equals("56")) {
                        z = true;
                        break;
                    }
                    break;
                case 1699:
                    if (str.equals("58")) {
                        z = true;
                        break;
                    }
                    break;
                case 1700:
                    if (str.equals("59")) {
                        z = true;
                        break;
                    }
                    break;
                case 1723:
                    if (str.equals("61")) {
                        z = true;
                        break;
                    }
                    break;
                case 1724:
                    if (str.equals("62")) {
                        z = true;
                        break;
                    }
                    break;
                case 1725:
                    if (str.equals("63")) {
                        z = true;
                        break;
                    }
                    break;
                case 1727:
                    if (str.equals("65")) {
                        z = true;
                        break;
                    }
                    break;
                case 1822:
                    if (str.equals("97")) {
                        z = true;
                        break;
                    }
                    break;
                case 1824:
                    if (str.equals("99")) {
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

    /* compiled from: TEXT DEFAULT 'private' */
    public class GametimeReactionTailLoadQueryString extends TypedGraphQlQueryString<GametimeReactionTailLoadFragmentModel> {
        public GametimeReactionTailLoadQueryString() {
            super(GametimeReactionTailLoadFragmentModel.class, false, "GametimeReactionTailLoadQuery", "47ebaf77449d77a6d1574f57433f4b24", "gametime_match_reaction_units", "10154688433346729", RegularImmutableSet.a);
        }

        public final TriState m26786g() {
            return TriState.NO;
        }

        public final String m26784a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "22";
                case -2069553567:
                    return "77";
                case -2018573478:
                    return "84";
                case -1966188374:
                    return "49";
                case -1849402738:
                    return "4";
                case -1831222590:
                    return "80";
                case -1807695521:
                    return "41";
                case -1780769805:
                    return "13";
                case -1778558196:
                    return "35";
                case -1777441434:
                    return "52";
                case -1773565470:
                    return "100";
                case -1745741354:
                    return "12";
                case -1700233621:
                    return "19";
                case -1663499699:
                    return "30";
                case -1651445858:
                    return "64";
                case -1469598440:
                    return "23";
                case -1460262781:
                    return "98";
                case -1397293948:
                    return "51";
                case -1397104088:
                    return "45";
                case -1363693170:
                    return "54";
                case -1362584798:
                    return "59";
                case -1333184300:
                    return "56";
                case -1332962213:
                    return "75";
                case -1332654029:
                    return "73";
                case -1284189600:
                    return "83";
                case -1150725321:
                    return "11";
                case -1101600581:
                    return "1";
                case -1091844130:
                    return "61";
                case -1012194872:
                    return "97";
                case -986526968:
                    return "85";
                case -971327749:
                    return "70";
                case -817257615:
                    return "36";
                case -799736697:
                    return "62";
                case -790388762:
                    return "50";
                case -783752827:
                    return "67";
                case -631654088:
                    return "7";
                case -621921156:
                    return "65";
                case -561505403:
                    return "15";
                case -538773735:
                    return "34";
                case -493674687:
                    return "63";
                case -461877888:
                    return "31";
                case -378761310:
                    return "76";
                case -317710003:
                    return "33";
                case -291906585:
                    return "89";
                case -260248031:
                    return "43";
                case -230346670:
                    return "46";
                case -217290325:
                    return "82";
                case -192656628:
                    return "42";
                case -164645908:
                    return "78";
                case -164083748:
                    return "88";
                case -92787706:
                    return "9";
                case -19268531:
                    return "58";
                case -11314776:
                    return "66";
                case 20000209:
                    return "87";
                case 25209764:
                    return "3";
                case 94851343:
                    return "47";
                case 109250890:
                    return "20";
                case 169846802:
                    return "10";
                case 169997180:
                    return "94";
                case 293932680:
                    return "72";
                case 375334353:
                    return "0";
                case 388662790:
                    return "81";
                case 421050507:
                    return "101";
                case 447915951:
                    return "57";
                case 485031261:
                    return "79";
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
                    return "69";
                case 797640206:
                    return "48";
                case 810737919:
                    return "25";
                case 860214447:
                    return "68";
                case 996172250:
                    return "24";
                case 1028378801:
                    return "91";
                case 1037267417:
                    return "74";
                case 1091074225:
                    return "71";
                case 1092457133:
                    return "44";
                case 1108260124:
                    return "18";
                case 1139691781:
                    return "99";
                case 1141422913:
                    return "39";
                case 1145249444:
                    return "60";
                case 1232347828:
                    return "40";
                case 1262925297:
                    return "26";
                case 1282232523:
                    return "27";
                case 1408059794:
                    return "92";
                case 1414179291:
                    return "86";
                case 1420616515:
                    return "95";
                case 1423926404:
                    return "53";
                case 1520778617:
                    return "55";
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
                    return "90";
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

        protected final boolean m26785a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 54:
                    if (str.equals("6")) {
                        z = true;
                        break;
                    }
                    break;
                case 55:
                    if (str.equals("7")) {
                        z = true;
                        break;
                    }
                    break;
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
                case 1635:
                    if (str.equals("36")) {
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
                case 1697:
                    if (str.equals("56")) {
                        z = true;
                        break;
                    }
                    break;
                case 1699:
                    if (str.equals("58")) {
                        z = true;
                        break;
                    }
                    break;
                case 1700:
                    if (str.equals("59")) {
                        z = true;
                        break;
                    }
                    break;
                case 1723:
                    if (str.equals("61")) {
                        z = true;
                        break;
                    }
                    break;
                case 1724:
                    if (str.equals("62")) {
                        z = true;
                        break;
                    }
                    break;
                case 1725:
                    if (str.equals("63")) {
                        z = true;
                        break;
                    }
                    break;
                case 1727:
                    if (str.equals("65")) {
                        z = true;
                        break;
                    }
                    break;
                case 1822:
                    if (str.equals("97")) {
                        z = true;
                        break;
                    }
                    break;
                case 1824:
                    if (str.equals("99")) {
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

    /* compiled from: TEXT DEFAULT 'private' */
    public class GametimeSportsPlaysQueryString extends TypedGraphQlQueryString<GametimeSportsPlaysQueryModel> {
        public GametimeSportsPlaysQueryString() {
            super(GametimeSportsPlaysQueryModel.class, false, "GametimeSportsPlaysQuery", "dccb3e24a820cb7f990933921db42c20", "node", "10154641828766729", RegularImmutableSet.a);
        }

        public final String m26787a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "5";
                case -803548981:
                    return "0";
                case -631593393:
                    return "1";
                case -381590603:
                    return "2";
                case -230346670:
                    return "3";
                case 94851343:
                    return "4";
                case 109250890:
                    return "7";
                case 1911442659:
                    return "6";
                default:
                    return str;
            }
        }

        protected final boolean m26788a(String str, Object obj) {
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

    public static final GametimeMatchHeaderUpdateSubscriptionString m26789f() {
        return new GametimeMatchHeaderUpdateSubscriptionString();
    }

    public static final GametimePlaySubscriptionString m26790g() {
        return new GametimePlaySubscriptionString();
    }
}
