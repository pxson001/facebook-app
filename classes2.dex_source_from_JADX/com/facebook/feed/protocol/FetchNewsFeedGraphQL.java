package com.facebook.feed.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.collect.ImmutableSet;

/* compiled from: rowIndex  */
public final class FetchNewsFeedGraphQL {

    /* compiled from: rowIndex  */
    public class NewsFeedQueryDepth3String extends TypedGraphQlQueryString<GraphQLViewer> {
        public NewsFeedQueryDepth3String() {
            super(GraphQLViewer.class, false, "NewsFeedQueryDepth3", "286d5b87d9e88545e46b64bf12f3965f", "viewer", "10154690685371729", ImmutableSet.of("short_term_cache_key_storyset", "short_term_cache_key_pyml", "focused_comment_id", "feedback_prefetch_id", "end_cursor"));
        }

        public final TriState mo1607g() {
            return TriState.NO;
        }

        public final String mo1605a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "41";
                case -2096998877:
                    return "14";
                case -2022667685:
                    return "7";
                case -1966188374:
                    return "57";
                case -1849402738:
                    return "19";
                case -1840424945:
                    return "78";
                case -1816243979:
                    return "59";
                case -1813769495:
                    return "37";
                case -1780769805:
                    return "28";
                case -1778558196:
                    return "49";
                case -1745741354:
                    return "27";
                case -1672406602:
                    return "9";
                case -1663499699:
                    return "44";
                case -1651445858:
                    return "76";
                case -1469598440:
                    return "42";
                case -1460262781:
                    return "105";
                case -1397293948:
                    return "66";
                case -1385981785:
                    return "65";
                case -1368816037:
                    return "87";
                case -1363957576:
                    return "79";
                case -1363693170:
                    return "67";
                case -1362584798:
                    return "43";
                case -1333184300:
                    return "69";
                case -1327444660:
                    return "81";
                case -1256899066:
                    return "84";
                case -1150725321:
                    return "26";
                case -1101600581:
                    return "17";
                case -1091844130:
                    return "73";
                case -1012194872:
                    return "55";
                case -971327749:
                    return "89";
                case -861996254:
                    return "80";
                case -844973083:
                    return "94";
                case -817257615:
                    return "50";
                case -799736697:
                    return "74";
                case -790388762:
                    return "58";
                case -781030638:
                    return "16";
                case -738841953:
                    return "97";
                case -709248289:
                    return "98";
                case -672731075:
                    return "33";
                case -631654088:
                    return "22";
                case -621921156:
                    return "77";
                case -599319479:
                    return "61";
                case -561505403:
                    return "30";
                case -551035547:
                    return "52";
                case -538773735:
                    return "48";
                case -493674687:
                    return "75";
                case -461877888:
                    return "45";
                case -389625822:
                    return "56";
                case -344707715:
                    return "2";
                case -317710003:
                    return "47";
                case -303949776:
                    return "34";
                case -117334504:
                    return "40";
                case -92787706:
                    return "24";
                case -19268531:
                    return "71";
                case 25209764:
                    return "4";
                case 83381042:
                    return "88";
                case 100113286:
                    return "11";
                case 110760373:
                    return "12";
                case 138216560:
                    return "102";
                case 169846802:
                    return "25";
                case 240181920:
                    return "83";
                case 256851517:
                    return "13";
                case 287854087:
                    return "104";
                case 293932680:
                    return "91";
                case 299464038:
                    return "15";
                case 336420357:
                    return "64";
                case 361270353:
                    return "38";
                case 447915951:
                    return "70";
                case 503153874:
                    return "85";
                case 550113673:
                    return "62";
                case 557908192:
                    return "46";
                case 580042479:
                    return "29";
                case 581973968:
                    return "5";
                case 609122022:
                    return "21";
                case 651215103:
                    return "31";
                case 656444234:
                    return "96";
                case 689802720:
                    return "35";
                case 797640206:
                    return "54";
                case 810737919:
                    return "86";
                case 824185313:
                    return "93";
                case 865582063:
                    return "100";
                case 1091074225:
                    return "90";
                case 1108260124:
                    return "36";
                case 1126804829:
                    return "101";
                case 1139691781:
                    return "106";
                case 1145249444:
                    return "72";
                case 1196911831:
                    return "3";
                case 1227613005:
                    return "99";
                case 1248176853:
                    return "8";
                case 1369871846:
                    return "0";
                case 1420616515:
                    return "95";
                case 1520778617:
                    return "68";
                case 1522025893:
                    return "10";
                case 1569020255:
                    return "60";
                case 1585010628:
                    return "32";
                case 1588387807:
                    return "39";
                case 1598177384:
                    return "18";
                case 1613128163:
                    return "63";
                case 1673542407:
                    return "23";
                case 1687410441:
                    return "92";
                case 1698669044:
                    return "1";
                case 1701781707:
                    return "6";
                case 1728811114:
                    return "82";
                case 1868886612:
                    return "103";
                case 1939875509:
                    return "20";
                case 1963391292:
                    return "51";
                case 2059386387:
                    return "53";
                default:
                    return str;
            }
        }

        protected final boolean mo1606a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 51:
                    if (str.equals("3")) {
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
                case 54:
                    if (str.equals("6")) {
                        z = true;
                        break;
                    }
                    break;
                case 56:
                    if (str.equals("8")) {
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
                case 1600:
                    if (str.equals("22")) {
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
                case 1606:
                    if (str.equals("28")) {
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
                case 1662:
                    if (str.equals("42")) {
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
                case 1692:
                    if (str.equals("51")) {
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
                case 1700:
                    if (str.equals("59")) {
                        z = true;
                        break;
                    }
                    break;
                case 1728:
                    if (str.equals("66")) {
                        z = true;
                        break;
                    }
                    break;
                case 1729:
                    if (str.equals("67")) {
                        z = true;
                        break;
                    }
                    break;
                case 1731:
                    if (str.equals("69")) {
                        z = true;
                        break;
                    }
                    break;
                case 1754:
                    if (str.equals("71")) {
                        z = true;
                        break;
                    }
                    break;
                case 1755:
                    if (str.equals("72")) {
                        z = false;
                        break;
                    }
                    break;
                case 1756:
                    if (str.equals("73")) {
                        z = true;
                        break;
                    }
                    break;
                case 1757:
                    if (str.equals("74")) {
                        z = true;
                        break;
                    }
                    break;
                case 1758:
                    if (str.equals("75")) {
                        z = true;
                        break;
                    }
                    break;
                case 1759:
                    if (str.equals("76")) {
                        z = true;
                        break;
                    }
                    break;
                case 1760:
                    if (str.equals("77")) {
                        z = true;
                        break;
                    }
                    break;
                case 1761:
                    if (str.equals("78")) {
                        z = true;
                        break;
                    }
                    break;
                case 1762:
                    if (str.equals("79")) {
                        z = true;
                        break;
                    }
                    break;
                case 1784:
                    if (str.equals("80")) {
                        z = true;
                        break;
                    }
                    break;
                case 1790:
                    if (str.equals("86")) {
                        z = true;
                        break;
                    }
                    break;
                case 48631:
                    if (str.equals("106")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "homepage_stream".equals(obj);
                    }
                    return false;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    if (obj instanceof String) {
                        return "feed".equals(obj);
                    }
                    return false;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    if (obj instanceof String) {
                        return "image/x-auto".equals(obj);
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
                case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                    if (obj instanceof String) {
                        return "EXCELLENT".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "PRODUCTION".equals(obj);
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
                case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
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
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "NULL".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "2048".equals(obj);
                    }
                    if ((obj instanceof Integer) && ((Integer) obj).intValue() == 2048) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "2048".equals(obj);
                    }
                    if ((obj instanceof Integer) && ((Integer) obj).intValue() == 2048) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "2048".equals(obj);
                    }
                    if ((obj instanceof Integer) && ((Integer) obj).intValue() == 2048) {
                        return true;
                    }
                    return false;
                case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
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
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "image/jpeg".equals(obj);
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
                        return "50".equals(obj);
                    }
                    if ((obj instanceof Integer) && ((Integer) obj).intValue() == 50) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "5".equals(obj);
                    }
                    if ((obj instanceof Integer) && ((Integer) obj).intValue() == 5) {
                        return true;
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "TOP_STORIES".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "image/x-auto".equals(obj);
                    }
                    return false;
                case true:
                    if (obj instanceof String) {
                        return "AUTO".equals(obj);
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
                case HTTPTransportCallback.HEADER_BYTES_RECEIVED /*32*/:
                    if (obj instanceof String) {
                        return "contain-fit".equals(obj);
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
                        return "3600".equals(obj);
                    }
                    if ((obj instanceof Integer) && ((Integer) obj).intValue() == 3600) {
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
                        return "NORMAL".equals(obj);
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

    public static final NewsFeedQueryDepth3String m11301a() {
        return new NewsFeedQueryDepth3String();
    }
}
