package com.facebook.api.graphql.fetchstories;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: android_small_screen_phone_threshold */
public final class FetchPlatformStoryGraphQL {

    /* compiled from: android_small_screen_phone_threshold */
    public class StaticGraphQlPlatformStoryFeedbackQueryString extends TypedGraphQlQueryString<GraphQLStory> {
        public StaticGraphQlPlatformStoryFeedbackQueryString() {
            super(GraphQLStory.class, false, "StaticGraphQlPlatformStoryFeedbackQuery", "759b5da4ba4556958dc8729526f46681", "story", "10154690955076729", RegularImmutableSet.a);
        }

        public final TriState m16687g() {
            return TriState.NO;
        }

        public final String m16685a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "24";
                case -2111250185:
                    return "51";
                case -1966188374:
                    return "35";
                case -1849402738:
                    return "4";
                case -1780769805:
                    return "13";
                case -1778558196:
                    return "31";
                case -1745741354:
                    return "12";
                case -1718813234:
                    return "72";
                case -1663499699:
                    return "26";
                case -1651445858:
                    return "63";
                case -1547457328:
                    return "19";
                case -1469598440:
                    return "25";
                case -1460262781:
                    return "74";
                case -1397293948:
                    return "37";
                case -1363693170:
                    return "38";
                case -1362584798:
                    return "58";
                case -1284099636:
                    return "42";
                case -1150725321:
                    return "11";
                case -1116221284:
                    return "53";
                case -1109830290:
                    return "49";
                case -1101600581:
                    return "1";
                case -1091844130:
                    return "60";
                case -1012194872:
                    return "45";
                case -971327749:
                    return "67";
                case -969292942:
                    return "66";
                case -945993139:
                    return "43";
                case -817257615:
                    return "32";
                case -799736697:
                    return "61";
                case -790388762:
                    return "36";
                case -680727674:
                    return "44";
                case -672731075:
                    return "18";
                case -631654088:
                    return "7";
                case -621921156:
                    return "64";
                case -561505403:
                    return "15";
                case -538773735:
                    return "30";
                case -493674687:
                    return "62";
                case -461877888:
                    return "27";
                case -317710003:
                    return "29";
                case -113788560:
                    return "41";
                case -92787706:
                    return "9";
                case -19268531:
                    return "57";
                case -16226492:
                    return "39";
                case 25209764:
                    return "3";
                case 41001321:
                    return "73";
                case 169846802:
                    return "10";
                case 293932680:
                    return "69";
                case 297456968:
                    return "47";
                case 355809903:
                    return "56";
                case 557908192:
                    return "28";
                case 580042479:
                    return "14";
                case 609122022:
                    return "6";
                case 613692368:
                    return "55";
                case 651215103:
                    return "16";
                case 656444234:
                    return "71";
                case 689802720:
                    return "20";
                case 774983793:
                    return "40";
                case 797640206:
                    return "34";
                case 810737919:
                    return "65";
                case 825224060:
                    return "48";
                case 899150587:
                    return "52";
                case 1091074225:
                    return "68";
                case 1108260124:
                    return "23";
                case 1139691781:
                    return "75";
                case 1145249444:
                    return "59";
                case 1420616515:
                    return "70";
                case 1520778617:
                    return "46";
                case 1585010628:
                    return "17";
                case 1598177384:
                    return "2";
                case 1673542407:
                    return "8";
                case 1827871700:
                    return "22";
                case 1896402612:
                    return "50";
                case 1939875509:
                    return "5";
                case 1963391292:
                    return "33";
                case 2024508229:
                    return "54";
                case 2059544769:
                    return "21";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m16686a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1574:
                    if (str.equals("17")) {
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
                case 1603:
                    if (str.equals("25")) {
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
                case 1699:
                    if (str.equals("58")) {
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
                case 1726:
                    if (str.equals("64")) {
                        z = true;
                        break;
                    }
                    break;
                case 1727:
                    if (str.equals("65")) {
                        z = false;
                        break;
                    }
                    break;
                case 1755:
                    if (str.equals("72")) {
                        z = true;
                        break;
                    }
                    break;
                case 1756:
                    if (str.equals("73")) {
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
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
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
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
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

    /* compiled from: android_small_screen_phone_threshold */
    public class StaticGraphQlPlatformStoryQueryString extends TypedGraphQlQueryString<GraphQLStory> {
        public StaticGraphQlPlatformStoryQueryString() {
            super(GraphQLStory.class, false, "StaticGraphQlPlatformStoryQuery", "82cde6d955445513ddf342291c2e654b", "story", "10154686760316729", RegularImmutableSet.a);
        }

        public final TriState m16690g() {
            return TriState.NO;
        }

        public final String m16688a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "20";
                case -1966188374:
                    return "31";
                case -1849402738:
                    return "4";
                case -1780769805:
                    return "13";
                case -1778558196:
                    return "27";
                case -1745741354:
                    return "12";
                case -1663499699:
                    return "22";
                case -1651445858:
                    return "43";
                case -1469598440:
                    return "21";
                case -1460262781:
                    return "51";
                case -1397293948:
                    return "33";
                case -1363693170:
                    return "34";
                case -1362584798:
                    return "38";
                case -1150725321:
                    return "11";
                case -1101600581:
                    return "1";
                case -1091844130:
                    return "40";
                case -1012194872:
                    return "37";
                case -971327749:
                    return "46";
                case -817257615:
                    return "28";
                case -799736697:
                    return "41";
                case -790388762:
                    return "32";
                case -631654088:
                    return "7";
                case -621921156:
                    return "44";
                case -561505403:
                    return "15";
                case -538773735:
                    return "26";
                case -493674687:
                    return "42";
                case -461877888:
                    return "23";
                case -317710003:
                    return "25";
                case -92787706:
                    return "9";
                case -19268531:
                    return "36";
                case 25209764:
                    return "3";
                case 169846802:
                    return "10";
                case 293932680:
                    return "48";
                case 557908192:
                    return "24";
                case 580042479:
                    return "14";
                case 609122022:
                    return "6";
                case 651215103:
                    return "16";
                case 656444234:
                    return "50";
                case 689802720:
                    return "19";
                case 797640206:
                    return "30";
                case 810737919:
                    return "45";
                case 1091074225:
                    return "47";
                case 1108260124:
                    return "18";
                case 1139691781:
                    return "52";
                case 1145249444:
                    return "39";
                case 1420616515:
                    return "49";
                case 1520778617:
                    return "35";
                case 1585010628:
                    return "17";
                case 1598177384:
                    return "2";
                case 1673542407:
                    return "8";
                case 1939875509:
                    return "5";
                case 1963391292:
                    return "29";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m16689a(String str, Object obj) {
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
                case 1637:
                    if (str.equals("38")) {
                        z = true;
                        break;
                    }
                    break;
                case 1661:
                    if (str.equals("41")) {
                        z = true;
                        break;
                    }
                    break;
                case 1664:
                    if (str.equals("44")) {
                        z = true;
                        break;
                    }
                    break;
                case 1665:
                    if (str.equals("45")) {
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
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
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
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
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
