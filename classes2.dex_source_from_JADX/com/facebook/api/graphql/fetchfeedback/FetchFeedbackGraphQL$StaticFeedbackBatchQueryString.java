package com.facebook.api.graphql.fetchfeedback;

import com.facebook.api.graphql.feed.C0861x186baa6f;
import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;

/* compiled from: group_owner_authored_stories.available_for_sale_count */
public class FetchFeedbackGraphQL$StaticFeedbackBatchQueryString extends TypedGraphQlQueryString<Map<String, C0861x186baa6f>> {
    public FetchFeedbackGraphQL$StaticFeedbackBatchQueryString() {
        super(C0861x186baa6f.class, true, "StaticFeedbackBatchQuery", "27732360a9a115f13c941469cb614e37", "nodes", "10154690955131729", RegularImmutableSet.f688a);
    }

    public final TriState mo1607g() {
        return TriState.NO;
    }

    public final String mo1605a(String str) {
        switch (str.hashCode()) {
            case -2111250185:
                return "46";
            case -1966188374:
                return "32";
            case -1849402738:
                return "4";
            case -1780769805:
                return "13";
            case -1778558196:
                return "28";
            case -1745741354:
                return "12";
            case -1718813234:
                return "59";
            case -1663499699:
                return "23";
            case -1547457328:
                return "18";
            case -1460262781:
                return "62";
            case -1397293948:
                return "34";
            case -1362584798:
                return "61";
            case -1302586347:
                return "0";
            case -1284099636:
                return "38";
            case -1150725321:
                return "11";
            case -1116221284:
                return "48";
            case -1109830290:
                return "44";
            case -1101600581:
                return "1";
            case -1012194872:
                return "41";
            case -971327749:
                return "54";
            case -969292942:
                return "53";
            case -945993139:
                return "39";
            case -817257615:
                return "29";
            case -790388762:
                return "33";
            case -680727674:
                return "40";
            case -631654088:
                return "7";
            case -561505403:
                return "15";
            case -538773735:
                return "27";
            case -461877888:
                return "24";
            case -317710003:
                return "26";
            case -113788560:
                return "37";
            case -92787706:
                return "9";
            case -16226492:
                return "35";
            case 25209764:
                return "3";
            case 41001321:
                return "60";
            case 169846802:
                return "10";
            case 293932680:
                return "56";
            case 297456968:
                return "42";
            case 355809903:
                return "51";
            case 557908192:
                return "25";
            case 580042479:
                return "14";
            case 609122022:
                return "6";
            case 613692368:
                return "50";
            case 651215103:
                return "16";
            case 656444234:
                return "58";
            case 689802720:
                return "19";
            case 774983793:
                return "36";
            case 797640206:
                return "31";
            case 810737919:
                return "52";
            case 825224060:
                return "43";
            case 899150587:
                return "47";
            case 1091074225:
                return "55";
            case 1108260124:
                return "22";
            case 1139691781:
                return "63";
            case 1420616515:
                return "57";
            case 1585010628:
                return "17";
            case 1598177384:
                return "2";
            case 1673542407:
                return "8";
            case 1827871700:
                return "21";
            case 1896402612:
                return "45";
            case 1939875509:
                return "5";
            case 1963391292:
                return "30";
            case 2024508229:
                return "49";
            case 2059544769:
                return "20";
            default:
                return str;
        }
    }

    protected final boolean mo1606a(String str, Object obj) {
        boolean z = true;
        switch (str.hashCode()) {
            case 1574:
                if (str.equals("17")) {
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
            case 1693:
                if (str.equals("52")) {
                    z = false;
                    break;
                }
                break;
            case 1700:
                if (str.equals("59")) {
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
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
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
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
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
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
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
