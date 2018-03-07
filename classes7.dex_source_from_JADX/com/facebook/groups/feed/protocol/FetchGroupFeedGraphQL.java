package com.facebook.groups.feed.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLGroup;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: rating_value */
public final class FetchGroupFeedGraphQL {

    /* compiled from: rating_value */
    public class GroupFeedQueryString extends TypedGraphQlQueryString<GraphQLGroup> {
        public GroupFeedQueryString() {
            super(GraphQLGroup.class, false, "GroupFeedQuery", "098690fa7e9b99142506710624992af2", "group_address", "10154686760971729", RegularImmutableSet.a);
        }

        public final TriState m6253g() {
            return TriState.NO;
        }

        public final String m6251a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "25";
                case -2022667685:
                    return "2";
                case -1966188374:
                    return "37";
                case -1849402738:
                    return "9";
                case -1816243979:
                    return "41";
                case -1780769805:
                    return "18";
                case -1778558196:
                    return "33";
                case -1745741354:
                    return "17";
                case -1663499699:
                    return "28";
                case -1651445858:
                    return "54";
                case -1469598440:
                    return "26";
                case -1460262781:
                    return "63";
                case -1397293948:
                    return "47";
                case -1392885889:
                    return "3";
                case -1363693170:
                    return "48";
                case -1362584798:
                    return "27";
                case -1150725321:
                    return "16";
                case -1101600581:
                    return "6";
                case -1091844130:
                    return "51";
                case -1012194872:
                    return "62";
                case -971327749:
                    return "57";
                case -817257615:
                    return "34";
                case -799736697:
                    return "52";
                case -790388762:
                    return "38";
                case -631654088:
                    return "12";
                case -621921156:
                    return "55";
                case -599319479:
                    return "43";
                case -561505403:
                    return "20";
                case -538773735:
                    return "32";
                case -493674687:
                    return "53";
                case -461877888:
                    return "29";
                case -317710003:
                    return "31";
                case -92787706:
                    return "14";
                case -19268531:
                    return "40";
                case 25209764:
                    return "8";
                case 92734940:
                    return "4";
                case 97440432:
                    return "5";
                case 169846802:
                    return "15";
                case 293932680:
                    return "59";
                case 336420357:
                    return "46";
                case 447915951:
                    return "50";
                case 506361563:
                    return "0";
                case 550113673:
                    return "44";
                case 557908192:
                    return "30";
                case 580042479:
                    return "19";
                case 609122022:
                    return "11";
                case 651215103:
                    return "21";
                case 656444234:
                    return "61";
                case 689802720:
                    return "24";
                case 797640206:
                    return "36";
                case 810737919:
                    return "56";
                case 1091074225:
                    return "58";
                case 1108260124:
                    return "23";
                case 1139691781:
                    return "64";
                case 1145249444:
                    return "39";
                case 1420616515:
                    return "60";
                case 1520778617:
                    return "49";
                case 1569020255:
                    return "42";
                case 1585010628:
                    return "22";
                case 1598177384:
                    return "7";
                case 1613128163:
                    return "45";
                case 1673542407:
                    return "13";
                case 1710767214:
                    return "1";
                case 1939875509:
                    return "10";
                case 1963391292:
                    return "35";
                default:
                    return str;
            }
        }

        protected final boolean m6252a(String str, Object obj) {
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
                case 1605:
                    if (str.equals("27")) {
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
                case 1693:
                    if (str.equals("52")) {
                        z = true;
                        break;
                    }
                    break;
                case 1696:
                    if (str.equals("55")) {
                        z = true;
                        break;
                    }
                    break;
                case 1697:
                    if (str.equals("56")) {
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
                        return "5".equals(obj);
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    if (((Integer) obj).intValue() != 5) {
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

    /* compiled from: rating_value */
    public class GroupStoriesFeedQueryString extends TypedGraphQlQueryString<GraphQLGroup> {
        public GroupStoriesFeedQueryString() {
            super(GraphQLGroup.class, false, "GroupStoriesFeedQuery", "82a6a86f51ffabea95ce4fe52e22c482", "group_address", "10154686761076729", RegularImmutableSet.a);
        }

        public final TriState m6256g() {
            return TriState.NO;
        }

        public final String m6254a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "24";
                case -1966188374:
                    return "35";
                case -1849402738:
                    return "8";
                case -1780769805:
                    return "17";
                case -1778558196:
                    return "31";
                case -1745741354:
                    return "16";
                case -1663499699:
                    return "26";
                case -1651445858:
                    return "47";
                case -1469598440:
                    return "25";
                case -1460262781:
                    return "56";
                case -1397293948:
                    return "39";
                case -1392885889:
                    return "2";
                case -1363693170:
                    return "40";
                case -1362584798:
                    return "43";
                case -1150725321:
                    return "15";
                case -1101600581:
                    return "5";
                case -1091844130:
                    return "44";
                case -1012194872:
                    return "55";
                case -971327749:
                    return "50";
                case -817257615:
                    return "32";
                case -799736697:
                    return "45";
                case -790388762:
                    return "36";
                case -631654088:
                    return "11";
                case -621921156:
                    return "48";
                case -561505403:
                    return "19";
                case -538773735:
                    return "30";
                case -493674687:
                    return "46";
                case -461877888:
                    return "27";
                case -317710003:
                    return "29";
                case -92787706:
                    return "13";
                case -19268531:
                    return "38";
                case 25209764:
                    return "7";
                case 92734940:
                    return "3";
                case 97440432:
                    return "4";
                case 169846802:
                    return "14";
                case 293932680:
                    return "52";
                case 447915951:
                    return "42";
                case 506361563:
                    return "0";
                case 557908192:
                    return "28";
                case 580042479:
                    return "18";
                case 609122022:
                    return "10";
                case 651215103:
                    return "20";
                case 656444234:
                    return "54";
                case 689802720:
                    return "23";
                case 797640206:
                    return "34";
                case 810737919:
                    return "49";
                case 1091074225:
                    return "51";
                case 1108260124:
                    return "22";
                case 1139691781:
                    return "57";
                case 1145249444:
                    return "37";
                case 1420616515:
                    return "53";
                case 1520778617:
                    return "41";
                case 1585010628:
                    return "21";
                case 1598177384:
                    return "6";
                case 1673542407:
                    return "12";
                case 1710767214:
                    return "1";
                case 1939875509:
                    return "9";
                case 1963391292:
                    return "33";
                default:
                    return str;
            }
        }

        protected final boolean m6255a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1599:
                    if (str.equals("21")) {
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
                case 1663:
                    if (str.equals("43")) {
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
                case 1669:
                    if (str.equals("49")) {
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
