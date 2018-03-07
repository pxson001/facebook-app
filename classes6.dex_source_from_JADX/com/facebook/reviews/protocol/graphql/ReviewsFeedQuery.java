package com.facebook.reviews.protocol.graphql;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQueryModels.OverallRatingAndViewerReviewStoryModel;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQueryModels.ReviewsFeedHeaderModel;
import com.facebook.reviews.protocol.graphql.ReviewsFeedQueryModels.ReviewsFeedStoriesModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: setIsEdit */
public final class ReviewsFeedQuery {

    /* compiled from: setIsEdit */
    public class OverallRatingAndViewerReviewStoryString extends TypedGraphQlQueryString<OverallRatingAndViewerReviewStoryModel> {
        public OverallRatingAndViewerReviewStoryString() {
            super(OverallRatingAndViewerReviewStoryModel.class, false, "OverallRatingAndViewerReviewStory", "50088af4d79c8a978df97686a534dad4", "page", "10154686761551729", RegularImmutableSet.a);
        }

        public final TriState m7333g() {
            return TriState.NO;
        }

        public final String m7331a(String str) {
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
                    return "44";
                case -1469598440:
                    return "21";
                case -1460262781:
                    return "53";
                case -1397293948:
                    return "33";
                case -1363693170:
                    return "34";
                case -1362584798:
                    return "39";
                case -1333184300:
                    return "36";
                case -1150725321:
                    return "11";
                case -1101600581:
                    return "1";
                case -1091844130:
                    return "41";
                case -1012194872:
                    return "52";
                case -971327749:
                    return "47";
                case -817257615:
                    return "28";
                case -803548981:
                    return "0";
                case -799736697:
                    return "42";
                case -790388762:
                    return "32";
                case -631654088:
                    return "7";
                case -621921156:
                    return "45";
                case -561505403:
                    return "15";
                case -538773735:
                    return "26";
                case -493674687:
                    return "43";
                case -461877888:
                    return "23";
                case -317710003:
                    return "25";
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
                    return "24";
                case 580042479:
                    return "14";
                case 609122022:
                    return "6";
                case 651215103:
                    return "16";
                case 656444234:
                    return "51";
                case 689802720:
                    return "19";
                case 797640206:
                    return "30";
                case 810737919:
                    return "46";
                case 1091074225:
                    return "48";
                case 1108260124:
                    return "18";
                case 1139691781:
                    return "54";
                case 1145249444:
                    return "40";
                case 1420616515:
                    return "50";
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
                default:
                    return str;
            }
        }

        protected final boolean m7332a(String str, Object obj) {
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
                case 1635:
                    if (str.equals("36")) {
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

    /* compiled from: setIsEdit */
    public class ReviewsFeedHeaderString extends TypedGraphQlQueryString<ReviewsFeedHeaderModel> {
        public ReviewsFeedHeaderString() {
            super(ReviewsFeedHeaderModel.class, false, "ReviewsFeedHeader", "a99125e65e926b9dbc731558588d5e1f", "page", "10154405445711729", RegularImmutableSet.a);
        }

        public final String m7334a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: setIsEdit */
    public class ReviewsFeedStoriesString extends TypedGraphQlQueryString<ReviewsFeedStoriesModel> {
        public ReviewsFeedStoriesString() {
            super(ReviewsFeedStoriesModel.class, false, "ReviewsFeedStories", "b0e92fad00dcf80abcf2a5b842d20a32", "page", "10154686761556729", RegularImmutableSet.a);
        }

        public final TriState m7337g() {
            return TriState.NO;
        }

        public final String m7335a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "22";
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
                    return "46";
                case -1469598440:
                    return "23";
                case -1460262781:
                    return "55";
                case -1397293948:
                    return "35";
                case -1363693170:
                    return "36";
                case -1362584798:
                    return "41";
                case -1333184300:
                    return "38";
                case -1150725321:
                    return "13";
                case -1101600581:
                    return "3";
                case -1091844130:
                    return "43";
                case -1012194872:
                    return "54";
                case -971327749:
                    return "49";
                case -930389691:
                    return "2";
                case -817257615:
                    return "30";
                case -803548981:
                    return "0";
                case -799736697:
                    return "44";
                case -790388762:
                    return "34";
                case -631654088:
                    return "9";
                case -621921156:
                    return "47";
                case -561505403:
                    return "17";
                case -538773735:
                    return "28";
                case -493674687:
                    return "45";
                case -461877888:
                    return "25";
                case -317710003:
                    return "27";
                case -92787706:
                    return "11";
                case -19268531:
                    return "40";
                case 25209764:
                    return "5";
                case 169846802:
                    return "12";
                case 293932680:
                    return "51";
                case 447915951:
                    return "39";
                case 557908192:
                    return "26";
                case 580042479:
                    return "16";
                case 609122022:
                    return "8";
                case 651215103:
                    return "18";
                case 656444234:
                    return "53";
                case 689802720:
                    return "21";
                case 797640206:
                    return "32";
                case 810737919:
                    return "48";
                case 1091074225:
                    return "50";
                case 1108260124:
                    return "20";
                case 1139691781:
                    return "56";
                case 1145249444:
                    return "42";
                case 1420616515:
                    return "52";
                case 1520778617:
                    return "37";
                case 1578862879:
                    return "1";
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

        protected final boolean m7336a(String str, Object obj) {
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
