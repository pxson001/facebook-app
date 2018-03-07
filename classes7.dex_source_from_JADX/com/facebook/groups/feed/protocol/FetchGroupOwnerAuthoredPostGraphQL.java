package com.facebook.groups.feed.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;

/* compiled from: radius_center */
public final class FetchGroupOwnerAuthoredPostGraphQL {

    /* compiled from: radius_center */
    public class GroupAuthoredAvailableForSalePostsString extends TypedGraphQlQueryString<Map<String, GraphQLNode>> {
        public GroupAuthoredAvailableForSalePostsString() {
            super(GraphQLNode.class, true, "GroupAuthoredAvailableForSalePosts", "453dc55a70f1f82555cb62ac519beaf7", "nodes", "10154686761316729", RegularImmutableSet.a);
        }

        public final TriState m6488g() {
            return TriState.NO;
        }

        public final String m6486a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "23";
                case -1966188374:
                    return "34";
                case -1849402738:
                    return "7";
                case -1780769805:
                    return "16";
                case -1778558196:
                    return "30";
                case -1745741354:
                    return "15";
                case -1663499699:
                    return "25";
                case -1651445858:
                    return "46";
                case -1469598440:
                    return "24";
                case -1460262781:
                    return "55";
                case -1397293948:
                    return "38";
                case -1392885889:
                    return "1";
                case -1363693170:
                    return "39";
                case -1362584798:
                    return "42";
                case -1150725321:
                    return "14";
                case -1101600581:
                    return "4";
                case -1091844130:
                    return "43";
                case -1012194872:
                    return "54";
                case -971327749:
                    return "49";
                case -817257615:
                    return "31";
                case -799736697:
                    return "44";
                case -790388762:
                    return "35";
                case -631654088:
                    return "10";
                case -621921156:
                    return "47";
                case -561505403:
                    return "18";
                case -538773735:
                    return "29";
                case -493674687:
                    return "45";
                case -461877888:
                    return "26";
                case -317710003:
                    return "28";
                case -92787706:
                    return "12";
                case -19268531:
                    return "37";
                case 25209764:
                    return "6";
                case 92734940:
                    return "2";
                case 97440432:
                    return "3";
                case 169846802:
                    return "13";
                case 293932680:
                    return "51";
                case 447915951:
                    return "41";
                case 506361563:
                    return "0";
                case 557908192:
                    return "27";
                case 580042479:
                    return "17";
                case 609122022:
                    return "9";
                case 651215103:
                    return "19";
                case 656444234:
                    return "53";
                case 689802720:
                    return "22";
                case 797640206:
                    return "33";
                case 810737919:
                    return "48";
                case 1091074225:
                    return "50";
                case 1108260124:
                    return "21";
                case 1139691781:
                    return "56";
                case 1145249444:
                    return "36";
                case 1420616515:
                    return "52";
                case 1520778617:
                    return "40";
                case 1585010628:
                    return "20";
                case 1598177384:
                    return "5";
                case 1673542407:
                    return "11";
                case 1939875509:
                    return "8";
                case 1963391292:
                    return "32";
                default:
                    return str;
            }
        }

        protected final boolean m6487a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1598:
                    if (str.equals("20")) {
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
                case 1662:
                    if (str.equals("42")) {
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
                case 1667:
                    if (str.equals("47")) {
                        z = true;
                        break;
                    }
                    break;
                case 1668:
                    if (str.equals("48")) {
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

    /* compiled from: radius_center */
    public class GroupAuthoredExpiredForSalePostsString extends TypedGraphQlQueryString<Map<String, GraphQLNode>> {
        public GroupAuthoredExpiredForSalePostsString() {
            super(GraphQLNode.class, true, "GroupAuthoredExpiredForSalePosts", "d024696e3a5d6dc4f5c1b8755524941b", "nodes", "10154686761491729", RegularImmutableSet.a);
        }

        public final TriState m6491g() {
            return TriState.NO;
        }

        public final String m6489a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "23";
                case -1966188374:
                    return "34";
                case -1849402738:
                    return "7";
                case -1780769805:
                    return "16";
                case -1778558196:
                    return "30";
                case -1745741354:
                    return "15";
                case -1663499699:
                    return "25";
                case -1651445858:
                    return "46";
                case -1469598440:
                    return "24";
                case -1460262781:
                    return "55";
                case -1397293948:
                    return "38";
                case -1392885889:
                    return "1";
                case -1363693170:
                    return "39";
                case -1362584798:
                    return "42";
                case -1150725321:
                    return "14";
                case -1101600581:
                    return "4";
                case -1091844130:
                    return "43";
                case -1012194872:
                    return "54";
                case -971327749:
                    return "49";
                case -817257615:
                    return "31";
                case -799736697:
                    return "44";
                case -790388762:
                    return "35";
                case -631654088:
                    return "10";
                case -621921156:
                    return "47";
                case -561505403:
                    return "18";
                case -538773735:
                    return "29";
                case -493674687:
                    return "45";
                case -461877888:
                    return "26";
                case -317710003:
                    return "28";
                case -92787706:
                    return "12";
                case -19268531:
                    return "37";
                case 25209764:
                    return "6";
                case 92734940:
                    return "2";
                case 97440432:
                    return "3";
                case 169846802:
                    return "13";
                case 293932680:
                    return "51";
                case 447915951:
                    return "41";
                case 506361563:
                    return "0";
                case 557908192:
                    return "27";
                case 580042479:
                    return "17";
                case 609122022:
                    return "9";
                case 651215103:
                    return "19";
                case 656444234:
                    return "53";
                case 689802720:
                    return "22";
                case 797640206:
                    return "33";
                case 810737919:
                    return "48";
                case 1091074225:
                    return "50";
                case 1108260124:
                    return "21";
                case 1139691781:
                    return "56";
                case 1145249444:
                    return "36";
                case 1420616515:
                    return "52";
                case 1520778617:
                    return "40";
                case 1585010628:
                    return "20";
                case 1598177384:
                    return "5";
                case 1673542407:
                    return "11";
                case 1939875509:
                    return "8";
                case 1963391292:
                    return "32";
                default:
                    return str;
            }
        }

        protected final boolean m6490a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1598:
                    if (str.equals("20")) {
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
                case 1662:
                    if (str.equals("42")) {
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
                case 1667:
                    if (str.equals("47")) {
                        z = true;
                        break;
                    }
                    break;
                case 1668:
                    if (str.equals("48")) {
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

    /* compiled from: radius_center */
    public class GroupAuthoredSoldForSalePostsString extends TypedGraphQlQueryString<Map<String, GraphQLNode>> {
        public GroupAuthoredSoldForSalePostsString() {
            super(GraphQLNode.class, true, "GroupAuthoredSoldForSalePosts", "4a10e8d1d10e49ccc8b0153591063b56", "nodes", "10154686761381729", RegularImmutableSet.a);
        }

        public final TriState m6494g() {
            return TriState.NO;
        }

        public final String m6492a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "23";
                case -1966188374:
                    return "34";
                case -1849402738:
                    return "7";
                case -1780769805:
                    return "16";
                case -1778558196:
                    return "30";
                case -1745741354:
                    return "15";
                case -1663499699:
                    return "25";
                case -1651445858:
                    return "46";
                case -1469598440:
                    return "24";
                case -1460262781:
                    return "55";
                case -1397293948:
                    return "38";
                case -1392885889:
                    return "1";
                case -1363693170:
                    return "39";
                case -1362584798:
                    return "42";
                case -1150725321:
                    return "14";
                case -1101600581:
                    return "4";
                case -1091844130:
                    return "43";
                case -1012194872:
                    return "54";
                case -971327749:
                    return "49";
                case -817257615:
                    return "31";
                case -799736697:
                    return "44";
                case -790388762:
                    return "35";
                case -631654088:
                    return "10";
                case -621921156:
                    return "47";
                case -561505403:
                    return "18";
                case -538773735:
                    return "29";
                case -493674687:
                    return "45";
                case -461877888:
                    return "26";
                case -317710003:
                    return "28";
                case -92787706:
                    return "12";
                case -19268531:
                    return "37";
                case 25209764:
                    return "6";
                case 92734940:
                    return "2";
                case 97440432:
                    return "3";
                case 169846802:
                    return "13";
                case 293932680:
                    return "51";
                case 447915951:
                    return "41";
                case 506361563:
                    return "0";
                case 557908192:
                    return "27";
                case 580042479:
                    return "17";
                case 609122022:
                    return "9";
                case 651215103:
                    return "19";
                case 656444234:
                    return "53";
                case 689802720:
                    return "22";
                case 797640206:
                    return "33";
                case 810737919:
                    return "48";
                case 1091074225:
                    return "50";
                case 1108260124:
                    return "21";
                case 1139691781:
                    return "56";
                case 1145249444:
                    return "36";
                case 1420616515:
                    return "52";
                case 1520778617:
                    return "40";
                case 1585010628:
                    return "20";
                case 1598177384:
                    return "5";
                case 1673542407:
                    return "11";
                case 1939875509:
                    return "8";
                case 1963391292:
                    return "32";
                default:
                    return str;
            }
        }

        protected final boolean m6493a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1598:
                    if (str.equals("20")) {
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
                case 1662:
                    if (str.equals("42")) {
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
                case 1667:
                    if (str.equals("47")) {
                        z = true;
                        break;
                    }
                    break;
                case 1668:
                    if (str.equals("48")) {
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
