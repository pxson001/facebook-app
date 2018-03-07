package com.facebook.localcontent.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.localcontent.protocol.graphql.FetchPhotosByCategoryGraphQLModels.AvailableCategoriesQueryModel;
import com.facebook.localcontent.protocol.graphql.FetchPhotosByCategoryGraphQLModels.PhotosByCategoryQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: last_page_submit_button_text */
public final class FetchPhotosByCategoryGraphQL {

    /* compiled from: last_page_submit_button_text */
    public class AvailableCategoriesQueryString extends TypedGraphQlQueryString<AvailableCategoriesQueryModel> {
        public AvailableCategoriesQueryString() {
            super(AvailableCategoriesQueryModel.class, false, "AvailableCategoriesQuery", "5ffc4ece43935df6182f5d60b5df9ca2", "page", "10154405445371729", RegularImmutableSet.a);
        }

        public final String m18453a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                case -799136893:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: last_page_submit_button_text */
    public class PhotosByCategoryQueryString extends TypedGraphQlQueryString<PhotosByCategoryQueryModel> {
        public PhotosByCategoryQueryString() {
            super(PhotosByCategoryQueryModel.class, false, "PhotosByCategoryQuery", "26782e6fe3d17f23b74ecb46264821e7", "page", "10154686241901729", RegularImmutableSet.a);
        }

        public final String m18454a(String str) {
            switch (str.hashCode()) {
                case -1849402738:
                    return "11";
                case -1780769805:
                    return "25";
                case -1745741354:
                    return "27";
                case -1663499699:
                    return "23";
                case -1150725321:
                    return "26";
                case -1109106741:
                    return "18";
                case -1101600581:
                    return "6";
                case -1012194872:
                    return "7";
                case -1004839537:
                    return "16";
                case -920426905:
                    return "20";
                case -817257615:
                    return "8";
                case -803548981:
                    return "0";
                case -799136893:
                    return "3";
                case -747148849:
                    return "13";
                case -711183266:
                    return "15";
                case -461877888:
                    return "24";
                case -381590603:
                    return "1";
                case -317710003:
                    return "29";
                case -230346670:
                    return "2";
                case 50511102:
                    return "4";
                case 94851343:
                    return "5";
                case 169846802:
                    return "14";
                case 557908192:
                    return "28";
                case 759459718:
                    return "21";
                case 810737919:
                    return "10";
                case 1368284815:
                    return "19";
                case 1409276231:
                    return "17";
                case 1635420007:
                    return "22";
                case 1939875509:
                    return "12";
                case 1963391292:
                    return "9";
                default:
                    return str;
            }
        }

        protected final boolean m18455a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 1567:
                    if (str.equals("10")) {
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
