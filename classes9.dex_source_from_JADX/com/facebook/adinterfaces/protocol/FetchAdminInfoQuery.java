package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.FetchAdminInfoQueryModels.FetchAdminInfoQueryModel;
import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.ImmutableSet;

/* compiled from: Wake lock still held! */
public final class FetchAdminInfoQuery {

    /* compiled from: Wake lock still held! */
    public class FetchAdminInfoQueryString extends TypedGraphQlQueryString<FetchAdminInfoQueryModel> {
        public FetchAdminInfoQueryString() {
            super(FetchAdminInfoQueryModel.class, false, "FetchAdminInfoQuery", "ecdbc1bc926006774ddccf5754df7615", "page", "10154686760176729", ImmutableSet.of("short_term_cache_key_pyml"));
        }

        public final TriState m24099g() {
            return TriState.NO;
        }

        public final String m24097a(String str) {
            switch (str.hashCode()) {
                case -2123990406:
                    return "36";
                case -1992012396:
                    return "27";
                case -1966188374:
                    return "48";
                case -1849402738:
                    return "8";
                case -1780769805:
                    return "17";
                case -1778558196:
                    return "44";
                case -1745741354:
                    return "16";
                case -1663499699:
                    return "39";
                case -1651445858:
                    return "59";
                case -1469598440:
                    return "37";
                case -1460262781:
                    return "76";
                case -1397293948:
                    return "50";
                case -1363693170:
                    return "51";
                case -1362584798:
                    return "38";
                case -1327444660:
                    return "61";
                case -1256899066:
                    return "66";
                case -1179772549:
                    return "69";
                case -1150725321:
                    return "15";
                case -1133156857:
                    return "70";
                case -1101600581:
                    return "5";
                case -1091844130:
                    return "56";
                case -1012194872:
                    return "54";
                case -971327749:
                    return "71";
                case -899242647:
                    return "28";
                case -817257615:
                    return "45";
                case -815566671:
                    return "31";
                case -803548981:
                    return "0";
                case -799736697:
                    return "57";
                case -790388762:
                    return "49";
                case -631654088:
                    return "11";
                case -621921156:
                    return "60";
                case -561505403:
                    return "19";
                case -554685518:
                    return "1";
                case -538773735:
                    return "43";
                case -493674687:
                    return "58";
                case -461877888:
                    return "40";
                case -427466126:
                    return "67";
                case -317710003:
                    return "42";
                case -247173063:
                    return "2";
                case -117334504:
                    return "64";
                case -92787706:
                    return "13";
                case -19268531:
                    return "53";
                case 25209764:
                    return "7";
                case 36967363:
                    return "33";
                case 169846802:
                    return "14";
                case 182666285:
                    return "3";
                case 209914905:
                    return "32";
                case 240181920:
                    return "65";
                case 293932680:
                    return "73";
                case 361270353:
                    return "63";
                case 557908192:
                    return "41";
                case 580042479:
                    return "18";
                case 609122022:
                    return "10";
                case 651215103:
                    return "20";
                case 656444234:
                    return "75";
                case 689802720:
                    return "35";
                case 797640206:
                    return "47";
                case 810737919:
                    return "68";
                case 914102582:
                    return "30";
                case 975628804:
                    return "29";
                case 1091074225:
                    return "72";
                case 1108260124:
                    return "34";
                case 1139691781:
                    return "77";
                case 1145249444:
                    return "55";
                case 1390036172:
                    return "22";
                case 1420616515:
                    return "74";
                case 1520778617:
                    return "52";
                case 1585010628:
                    return "21";
                case 1598177384:
                    return "6";
                case 1599444866:
                    return "24";
                case 1673542407:
                    return "12";
                case 1706754015:
                    return "4";
                case 1717754021:
                    return "26";
                case 1728811114:
                    return "62";
                case 1913029129:
                    return "25";
                case 1932266260:
                    return "23";
                case 1939875509:
                    return "9";
                case 1963391292:
                    return "46";
                default:
                    return str;
            }
        }

        protected final boolean m24098a(String str, Object obj) {
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
                case 1635:
                    if (str.equals("36")) {
                        z = true;
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
                case 1698:
                    if (str.equals("57")) {
                        z = true;
                        break;
                    }
                    break;
                case 1722:
                    if (str.equals("60")) {
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
                case 1725:
                    if (str.equals("63")) {
                        z = false;
                        break;
                    }
                    break;
                case 1730:
                    if (str.equals("68")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
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
                        return "1".equals(obj);
                    }
                    if ((obj instanceof Integer) && ((Integer) obj).intValue() == 1) {
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
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }
}
