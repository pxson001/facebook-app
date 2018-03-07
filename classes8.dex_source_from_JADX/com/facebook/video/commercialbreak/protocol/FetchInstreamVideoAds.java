package com.facebook.video.commercialbreak.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.video.commercialbreak.protocol.FetchInstreamVideoAdsModels.InstreamVideoAdsQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: location_settings_perf_overall_tti */
public final class FetchInstreamVideoAds {

    /* compiled from: location_settings_perf_overall_tti */
    public class InstreamVideoAdsQueryString extends TypedGraphQlQueryString<InstreamVideoAdsQueryModel> {
        public InstreamVideoAdsQueryString() {
            super(InstreamVideoAdsQueryModel.class, false, "InstreamVideoAdsQuery", "62ef04c0e250dc0744c3987e1e49cca2", "viewer", "10154661259631729", RegularImmutableSet.a);
        }

        public final TriState m11464g() {
            return TriState.NO;
        }

        public final String m11462a(String str) {
            switch (str.hashCode()) {
                case -1992012396:
                    return "1";
                case -1780769805:
                    return "9";
                case -1745741354:
                    return "11";
                case -1663499699:
                    return "7";
                case -1469598440:
                    return "4";
                case -1362584798:
                    return "14";
                case -1150725321:
                    return "10";
                case -1101600581:
                    return "2";
                case -1091844130:
                    return "18";
                case -1012194872:
                    return "16";
                case -631654088:
                    return "20";
                case -461877888:
                    return "8";
                case -317710003:
                    return "13";
                case -19268531:
                    return "19";
                case 109250890:
                    return "15";
                case 169846802:
                    return "6";
                case 424337430:
                    return "0";
                case 447915951:
                    return "17";
                case 557908192:
                    return "12";
                case 689802720:
                    return "3";
                case 1939875509:
                    return "5";
                default:
                    return str;
            }
        }

        protected final boolean m11463a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 52:
                    if (str.equals("4")) {
                        z = true;
                        break;
                    }
                    break;
                case 1571:
                    if (str.equals("14")) {
                        z = true;
                        break;
                    }
                    break;
                case 1573:
                    if (str.equals("16")) {
                        z = true;
                        break;
                    }
                    break;
                case 1575:
                    if (str.equals("18")) {
                        z = false;
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
