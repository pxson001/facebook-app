package com.facebook.api.graphql.fetchcomments;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.api.graphql.fetchcomments.FetchSingleCommentGraphQLModels.FetchSingleCommentQueryModel;
import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: anniversary_campaign */
public final class FetchSingleCommentGraphQL {

    /* compiled from: anniversary_campaign */
    public class FetchSingleCommentQueryString extends TypedGraphQlQueryString<FetchSingleCommentQueryModel> {
        public FetchSingleCommentQueryString() {
            super(FetchSingleCommentQueryModel.class, false, "FetchSingleCommentQuery", "ce796a398394fafe3676efa111f3ebdd", "node", "10154690955016729", RegularImmutableSet.a);
        }

        public final TriState m16387g() {
            return TriState.NO;
        }

        public final String m16385a(String str) {
            switch (str.hashCode()) {
                case -2111250185:
                    return "3";
                case -1966188374:
                    return "40";
                case -1849402738:
                    return "12";
                case -1780769805:
                    return "21";
                case -1778558196:
                    return "36";
                case -1745741354:
                    return "20";
                case -1718813234:
                    return "57";
                case -1663499699:
                    return "31";
                case -1547457328:
                    return "26";
                case -1460262781:
                    return "60";
                case -1397293948:
                    return "42";
                case -1362584798:
                    return "59";
                case -1284099636:
                    return "46";
                case -1150725321:
                    return "19";
                case -1116221284:
                    return "4";
                case -1105641875:
                    return "9";
                case -1101600581:
                    return "8";
                case -1012194872:
                    return "49";
                case -971327749:
                    return "52";
                case -969292942:
                    return "51";
                case -945993139:
                    return "47";
                case -817257615:
                    return "37";
                case -790388762:
                    return "41";
                case -680727674:
                    return "48";
                case -631654088:
                    return "15";
                case -561505403:
                    return "23";
                case -538773735:
                    return "35";
                case -461877888:
                    return "32";
                case -317710003:
                    return "34";
                case -113788560:
                    return "45";
                case -92787706:
                    return "17";
                case -16226492:
                    return "43";
                case 25209764:
                    return "11";
                case 41001321:
                    return "58";
                case 169846802:
                    return "18";
                case 293932680:
                    return "54";
                case 297456968:
                    return "1";
                case 355809903:
                    return "7";
                case 557908192:
                    return "33";
                case 580042479:
                    return "22";
                case 609122022:
                    return "14";
                case 613692368:
                    return "6";
                case 651215103:
                    return "24";
                case 656444234:
                    return "56";
                case 689802720:
                    return "27";
                case 774983793:
                    return "44";
                case 797640206:
                    return "39";
                case 810737919:
                    return "50";
                case 899150587:
                    return "0";
                case 1091074225:
                    return "53";
                case 1108260124:
                    return "30";
                case 1139691781:
                    return "61";
                case 1420616515:
                    return "55";
                case 1585010628:
                    return "25";
                case 1598177384:
                    return "10";
                case 1673542407:
                    return "16";
                case 1827871700:
                    return "29";
                case 1896402612:
                    return "2";
                case 1939875509:
                    return "13";
                case 1963391292:
                    return "38";
                case 2024508229:
                    return "5";
                case 2059544769:
                    return "28";
                default:
                    return str;
            }
        }

        protected final boolean m16386a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
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
                case 1691:
                    if (str.equals("50")) {
                        z = false;
                        break;
                    }
                    break;
                case 1698:
                    if (str.equals("57")) {
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
