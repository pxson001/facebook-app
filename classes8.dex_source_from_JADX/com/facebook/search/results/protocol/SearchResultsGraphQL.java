package com.facebook.search.results.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.search.results.protocol.SearchResultsGraphQLModels.SearchResultsGraphQLModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: moderator_end_cursor */
public final class SearchResultsGraphQL {

    /* compiled from: moderator_end_cursor */
    public class SearchResultsGraphQLString extends TypedGraphQlQueryString<SearchResultsGraphQLModel> {
        public SearchResultsGraphQLString() {
            super(SearchResultsGraphQLModel.class, false, "SearchResultsGraphQL", "08a39ab7f884d73312ba375e88746cc3", "search_query", "10154686460226729", RegularImmutableSet.a);
        }

        public final TriState m9807g() {
            return TriState.NO;
        }

        public final String m9805a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "17";
                case -1745741354:
                    return "23";
                case -1663499699:
                    return "9";
                case -1651445858:
                    return "35";
                case -1469598440:
                    return "5";
                case -1460262781:
                    return "32";
                case -1442803611:
                    return "14";
                case -1362584798:
                    return "26";
                case -1150725321:
                    return "22";
                case -1101600581:
                    return "3";
                case -1091844130:
                    return "36";
                case -1012194872:
                    return "37";
                case -799736697:
                    return "33";
                case -631654088:
                    return "39";
                case -620205220:
                    return "10";
                case -613045507:
                    return "2";
                case -561505403:
                    return "29";
                case -558156362:
                    return "8";
                case -550333201:
                    return "19";
                case -493674687:
                    return "34";
                case -461877888:
                    return "16";
                case -317710003:
                    return "25";
                case -313454818:
                    return "20";
                case -77796550:
                    return "1";
                case -19268531:
                    return "38";
                case 109250890:
                    return "21";
                case 169846802:
                    return "18";
                case 447915951:
                    return "27";
                case 454936093:
                    return "7";
                case 461177713:
                    return "0";
                case 532434399:
                    return "11";
                case 557908192:
                    return "24";
                case 580042479:
                    return "28";
                case 614012309:
                    return "12";
                case 651215103:
                    return "30";
                case 689802720:
                    return "4";
                case 823395938:
                    return "13";
                case 1139691781:
                    return "31";
                case 1538702542:
                    return "6";
                case 1939875509:
                    return "15";
                default:
                    return str;
            }
        }

        protected final boolean m9806a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
                        z = true;
                        break;
                    }
                    break;
                case 53:
                    if (str.equals("5")) {
                        z = true;
                        break;
                    }
                    break;
                case 1570:
                    if (str.equals("13")) {
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
                case 1606:
                    if (str.equals("28")) {
                        z = true;
                        break;
                    }
                    break;
                case 1630:
                    if (str.equals("31")) {
                        z = true;
                        break;
                    }
                    break;
                case 1631:
                    if (str.equals("32")) {
                        z = true;
                        break;
                    }
                    break;
                case 1632:
                    if (str.equals("33")) {
                        z = true;
                        break;
                    }
                    break;
                case 1633:
                    if (str.equals("34")) {
                        z = true;
                        break;
                    }
                    break;
                case 1635:
                    if (str.equals("36")) {
                        z = false;
                        break;
                    }
                    break;
                case 1636:
                    if (str.equals("37")) {
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
                    return obj instanceof String ? "MPEG_DASH".equals(obj) : false;
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
                    return obj instanceof String ? "SEARCH".equals(obj) : false;
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
