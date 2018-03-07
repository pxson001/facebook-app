package com.facebook.groups.photos.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.photos.protocol.FetchGroupPhotosModels.FetchGroupPhotosModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: TOXICLE_BUY_TICKETS_CALL_TO_ACTION */
public final class FetchGroupPhotos {

    /* compiled from: TOXICLE_BUY_TICKETS_CALL_TO_ACTION */
    public class FetchGroupPhotosString extends TypedGraphQlQueryString<FetchGroupPhotosModel> {
        public FetchGroupPhotosString() {
            super(FetchGroupPhotosModel.class, false, "FetchGroupPhotos", "a20d7aea259612e2b3ed98de1b8fcada", "group_address", "10154686241876729", RegularImmutableSet.a);
        }

        public final String m24372a(String str) {
            switch (str.hashCode()) {
                case -1849402738:
                    return "9";
                case -1780769805:
                    return "23";
                case -1745741354:
                    return "25";
                case -1663499699:
                    return "21";
                case -1392885889:
                    return "1";
                case -1150725321:
                    return "24";
                case -1109106741:
                    return "16";
                case -1101600581:
                    return "4";
                case -1012194872:
                    return "5";
                case -1004839537:
                    return "14";
                case -920426905:
                    return "18";
                case -817257615:
                    return "6";
                case -747148849:
                    return "11";
                case -711183266:
                    return "13";
                case -461877888:
                    return "22";
                case -317710003:
                    return "27";
                case 92734940:
                    return "2";
                case 94851343:
                    return "3";
                case 169846802:
                    return "12";
                case 506361563:
                    return "0";
                case 557908192:
                    return "26";
                case 759459718:
                    return "19";
                case 810737919:
                    return "8";
                case 1368284815:
                    return "17";
                case 1409276231:
                    return "15";
                case 1635420007:
                    return "20";
                case 1939875509:
                    return "10";
                case 1963391292:
                    return "7";
                default:
                    return str;
            }
        }

        protected final boolean m24373a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 56:
                    if (str.equals("8")) {
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
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }
}
