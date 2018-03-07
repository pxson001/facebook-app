package com.facebook.timeline.protiles.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.TimelineProtilesQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: feedDialogActionExecutorMedia */
public final class FetchProtilesGraphQL {

    /* compiled from: feedDialogActionExecutorMedia */
    public class TimelineProtilesQueryString extends TypedGraphQlQueryString<TimelineProtilesQueryModel> {
        public TimelineProtilesQueryString() {
            super(TimelineProtilesQueryModel.class, false, "TimelineProtilesQuery", "ed23f7a75e5908d85766e86a98c39503", "user", "10154663221451729", RegularImmutableSet.a);
        }

        public final String m12126a(String str) {
            switch (str.hashCode()) {
                case -1845462466:
                    return "1";
                case -1780769805:
                    return "15";
                case -1745741354:
                    return "17";
                case -1708299778:
                    return "6";
                case -1663499699:
                    return "13";
                case -1150725321:
                    return "16";
                case -1126348334:
                    return "10";
                case -1102636175:
                    return "0";
                case -1055130534:
                    return "7";
                case -461877888:
                    return "14";
                case -317710003:
                    return "19";
                case -154818044:
                    return "9";
                case 142477244:
                    return "2";
                case 169846802:
                    return "12";
                case 342198569:
                    return "5";
                case 557908192:
                    return "18";
                case 730790073:
                    return "8";
                case 810737919:
                    return "3";
                case 1939875509:
                    return "11";
                case 2013749844:
                    return "4";
                default:
                    return str;
            }
        }

        protected final boolean m12127a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        z = true;
                        break;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        z = true;
                        break;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        z = false;
                        break;
                    }
                    break;
                case 53:
                    if (str.equals("5")) {
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
                case 1567:
                    if (str.equals("10")) {
                        z = true;
                        break;
                    }
                    break;
                case 1568:
                    if (str.equals("11")) {
                        z = true;
                        break;
                    }
                    break;
                case 1572:
                    if (str.equals("15")) {
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
                        return "6".equals(obj);
                    }
                    if (!(obj instanceof Integer)) {
                        return false;
                    }
                    if (((Integer) obj).intValue() != 6) {
                        return false;
                    }
                    return true;
                case true:
                    return obj instanceof String ? "image/jpeg".equals(obj) : false;
                case true:
                    return obj instanceof String ? "undefined".equals(obj) : false;
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
                    return obj instanceof String ? "contain-fit".equals(obj) : false;
                case true:
                    return obj instanceof String ? "undefined".equals(obj) : false;
                default:
                    return false;
            }
        }
    }
}
