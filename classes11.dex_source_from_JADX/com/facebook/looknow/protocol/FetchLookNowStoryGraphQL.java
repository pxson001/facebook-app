package com.facebook.looknow.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLCustomizedStory;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: utm_reg */
public final class FetchLookNowStoryGraphQL {

    /* compiled from: utm_reg */
    public class LookNowStoryQueryString extends TypedGraphQlQueryString<GraphQLCustomizedStory> {
        public LookNowStoryQueryString() {
            super(GraphQLCustomizedStory.class, false, "LookNowStoryQuery", "ac30855d4691779afc58ec3929e6d7c0", "look_now_story", "10154686761281729", RegularImmutableSet.a);
        }

        public final TriState m297g() {
            return TriState.NO;
        }

        public final String m295a(String str) {
            switch (str.hashCode()) {
                case -1966188374:
                    return "27";
                case -1849402738:
                    return "3";
                case -1780769805:
                    return "12";
                case -1778558196:
                    return "23";
                case -1745741354:
                    return "11";
                case -1663499699:
                    return "18";
                case -1460262781:
                    return "39";
                case -1397293948:
                    return "29";
                case -1362584798:
                    return "38";
                case -1150725321:
                    return "10";
                case -1101600581:
                    return "1";
                case -1012194872:
                    return "37";
                case -971327749:
                    return "32";
                case -817257615:
                    return "24";
                case -790388762:
                    return "28";
                case -631654088:
                    return "6";
                case -561505403:
                    return "14";
                case -538773735:
                    return "22";
                case -461877888:
                    return "19";
                case -317710003:
                    return "21";
                case -92787706:
                    return "8";
                case 25209764:
                    return "2";
                case 169846802:
                    return "9";
                case 293932680:
                    return "34";
                case 557908192:
                    return "20";
                case 580042479:
                    return "13";
                case 609122022:
                    return "5";
                case 651215103:
                    return "15";
                case 656444234:
                    return "36";
                case 689802720:
                    return "31";
                case 797640206:
                    return "26";
                case 810737919:
                    return "30";
                case 1091074225:
                    return "33";
                case 1108260124:
                    return "17";
                case 1139691781:
                    return "40";
                case 1420616515:
                    return "35";
                case 1585010628:
                    return "16";
                case 1598177384:
                    return "0";
                case 1673542407:
                    return "7";
                case 1939875509:
                    return "4";
                case 1963391292:
                    return "25";
                default:
                    return str;
            }
        }

        protected final boolean m296a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1573:
                    if (str.equals("16")) {
                        z = true;
                        break;
                    }
                    break;
                case 1629:
                    if (str.equals("30")) {
                        z = false;
                        break;
                    }
                    break;
                case 1637:
                    if (str.equals("38")) {
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
