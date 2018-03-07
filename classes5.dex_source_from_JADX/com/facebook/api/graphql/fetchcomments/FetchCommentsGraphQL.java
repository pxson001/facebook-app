package com.facebook.api.graphql.fetchcomments;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: annotation */
public final class FetchCommentsGraphQL {

    /* compiled from: annotation */
    public class UFIFeedbackQueryString extends TypedGraphQlQueryString<GraphQLFeedback> {
        public UFIFeedbackQueryString() {
            super(GraphQLFeedback.class, false, "UFIFeedbackQuery", "c38319dbbaf85201afe0c98eb1506ba6", "node", "10154690955181729", RegularImmutableSet.a);
        }

        public final TriState m16381g() {
            return TriState.NO;
        }

        public final String m16379a(String str) {
            switch (str.hashCode()) {
                case -2111250185:
                    return "3";
                case -1966188374:
                    return "36";
                case -1849402738:
                    return "8";
                case -1780769805:
                    return "17";
                case -1778558196:
                    return "32";
                case -1745741354:
                    return "16";
                case -1718813234:
                    return "53";
                case -1663499699:
                    return "27";
                case -1547457328:
                    return "22";
                case -1460262781:
                    return "56";
                case -1397293948:
                    return "38";
                case -1362584798:
                    return "55";
                case -1302586347:
                    return "0";
                case -1284099636:
                    return "42";
                case -1150725321:
                    return "15";
                case -1109830290:
                    return "1";
                case -1101600581:
                    return "5";
                case -1012194872:
                    return "45";
                case -971327749:
                    return "48";
                case -969292942:
                    return "47";
                case -945993139:
                    return "43";
                case -817257615:
                    return "33";
                case -790388762:
                    return "37";
                case -680727674:
                    return "44";
                case -631654088:
                    return "11";
                case -561505403:
                    return "19";
                case -538773735:
                    return "31";
                case -461877888:
                    return "28";
                case -317710003:
                    return "30";
                case -113788560:
                    return "41";
                case -92787706:
                    return "13";
                case -16226492:
                    return "39";
                case 25209764:
                    return "7";
                case 41001321:
                    return "54";
                case 169846802:
                    return "14";
                case 293932680:
                    return "50";
                case 355809903:
                    return "4";
                case 557908192:
                    return "29";
                case 580042479:
                    return "18";
                case 609122022:
                    return "10";
                case 651215103:
                    return "20";
                case 656444234:
                    return "52";
                case 689802720:
                    return "23";
                case 774983793:
                    return "40";
                case 797640206:
                    return "35";
                case 810737919:
                    return "46";
                case 1091074225:
                    return "49";
                case 1108260124:
                    return "26";
                case 1139691781:
                    return "57";
                case 1420616515:
                    return "51";
                case 1585010628:
                    return "21";
                case 1598177384:
                    return "6";
                case 1673542407:
                    return "12";
                case 1827871700:
                    return "25";
                case 1896402612:
                    return "2";
                case 1939875509:
                    return "9";
                case 1963391292:
                    return "34";
                case 2059544769:
                    return "24";
                default:
                    return str;
            }
        }

        protected final boolean m16380a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1599:
                    if (str.equals("21")) {
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
                case 1696:
                    if (str.equals("55")) {
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

    /* compiled from: annotation */
    public class UFILastFeedbackQueryString extends TypedGraphQlQueryString<GraphQLFeedback> {
        public UFILastFeedbackQueryString() {
            super(GraphQLFeedback.class, false, "UFILastFeedbackQuery", "31324c60ac1429f9b113dd2ef2c55ccd", "node", "10154690955161729", RegularImmutableSet.a);
        }

        public final TriState m16384g() {
            return TriState.NO;
        }

        public final String m16382a(String str) {
            switch (str.hashCode()) {
                case -2111250185:
                    return "3";
                case -1966188374:
                    return "36";
                case -1849402738:
                    return "8";
                case -1780769805:
                    return "17";
                case -1778558196:
                    return "32";
                case -1745741354:
                    return "16";
                case -1718813234:
                    return "53";
                case -1663499699:
                    return "27";
                case -1547457328:
                    return "22";
                case -1460262781:
                    return "56";
                case -1397293948:
                    return "38";
                case -1362584798:
                    return "55";
                case -1302586347:
                    return "0";
                case -1284099636:
                    return "42";
                case -1150725321:
                    return "15";
                case -1109830290:
                    return "1";
                case -1101600581:
                    return "5";
                case -1012194872:
                    return "45";
                case -971327749:
                    return "48";
                case -969292942:
                    return "47";
                case -945993139:
                    return "43";
                case -817257615:
                    return "33";
                case -790388762:
                    return "37";
                case -680727674:
                    return "44";
                case -631654088:
                    return "11";
                case -561505403:
                    return "19";
                case -538773735:
                    return "31";
                case -461877888:
                    return "28";
                case -317710003:
                    return "30";
                case -113788560:
                    return "41";
                case -92787706:
                    return "13";
                case -16226492:
                    return "39";
                case 25209764:
                    return "7";
                case 41001321:
                    return "54";
                case 169846802:
                    return "14";
                case 293932680:
                    return "50";
                case 355809903:
                    return "4";
                case 557908192:
                    return "29";
                case 580042479:
                    return "18";
                case 609122022:
                    return "10";
                case 651215103:
                    return "20";
                case 656444234:
                    return "52";
                case 689802720:
                    return "23";
                case 774983793:
                    return "40";
                case 797640206:
                    return "35";
                case 810737919:
                    return "46";
                case 1091074225:
                    return "49";
                case 1108260124:
                    return "26";
                case 1139691781:
                    return "57";
                case 1420616515:
                    return "51";
                case 1585010628:
                    return "21";
                case 1598177384:
                    return "6";
                case 1673542407:
                    return "12";
                case 1827871700:
                    return "25";
                case 1896402612:
                    return "2";
                case 1939875509:
                    return "9";
                case 1963391292:
                    return "34";
                case 2059544769:
                    return "24";
                default:
                    return str;
            }
        }

        protected final boolean m16383a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1599:
                    if (str.equals("21")) {
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
                case 1696:
                    if (str.equals("55")) {
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
