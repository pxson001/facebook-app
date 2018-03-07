package com.facebook.storygallerysurvey.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.storygallerysurvey.protocol.FetchStoryGallerySurveyWithStoryGraphQLModels.FetchStoryGallerySurveyWithStoryQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: Not Found */
public final class FetchStoryGallerySurveyWithStoryGraphQL {

    /* compiled from: Not Found */
    public class FetchStoryGallerySurveyWithStoryQueryString extends TypedGraphQlQueryString<FetchStoryGallerySurveyWithStoryQueryModel> {
        public FetchStoryGallerySurveyWithStoryQueryString() {
            super(FetchStoryGallerySurveyWithStoryQueryModel.class, false, "FetchStoryGallerySurveyWithStoryQuery", "2fc20867c04b67ff71cea83a0b1d0ed9", "viewer", "10154686761716729", RegularImmutableSet.a);
        }

        public final TriState m13672g() {
            return TriState.NO;
        }

        public final String m13670a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "19";
                case -1966188374:
                    return "30";
                case -1849402738:
                    return "3";
                case -1780769805:
                    return "12";
                case -1778558196:
                    return "26";
                case -1745741354:
                    return "11";
                case -1663499699:
                    return "21";
                case -1651445858:
                    return "43";
                case -1469598440:
                    return "20";
                case -1460262781:
                    return "52";
                case -1397293948:
                    return "32";
                case -1363693170:
                    return "33";
                case -1362584798:
                    return "38";
                case -1333184300:
                    return "35";
                case -1150725321:
                    return "10";
                case -1101600581:
                    return "0";
                case -1091844130:
                    return "40";
                case -1012194872:
                    return "51";
                case -971327749:
                    return "46";
                case -817257615:
                    return "27";
                case -799736697:
                    return "41";
                case -790388762:
                    return "31";
                case -631654088:
                    return "6";
                case -621921156:
                    return "44";
                case -561505403:
                    return "14";
                case -538773735:
                    return "25";
                case -493674687:
                    return "42";
                case -461877888:
                    return "22";
                case -317710003:
                    return "24";
                case -92787706:
                    return "8";
                case -19268531:
                    return "37";
                case 25209764:
                    return "2";
                case 169846802:
                    return "9";
                case 293932680:
                    return "48";
                case 447915951:
                    return "36";
                case 557908192:
                    return "23";
                case 580042479:
                    return "13";
                case 609122022:
                    return "5";
                case 651215103:
                    return "15";
                case 656444234:
                    return "50";
                case 689802720:
                    return "18";
                case 797640206:
                    return "29";
                case 810737919:
                    return "45";
                case 1091074225:
                    return "47";
                case 1108260124:
                    return "17";
                case 1139691781:
                    return "53";
                case 1145249444:
                    return "39";
                case 1420616515:
                    return "49";
                case 1520778617:
                    return "34";
                case 1585010628:
                    return "16";
                case 1598177384:
                    return "1";
                case 1673542407:
                    return "7";
                case 1939875509:
                    return "4";
                case 1963391292:
                    return "28";
                default:
                    return str;
            }
        }

        protected final boolean m13671a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1573:
                    if (str.equals("16")) {
                        z = true;
                        break;
                    }
                    break;
                case 1576:
                    if (str.equals("19")) {
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
                case 1634:
                    if (str.equals("35")) {
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
