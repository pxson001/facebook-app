package com.facebook.search.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.search.protocol.Fb4aGraphSearchPhotoQueryModels.Fb4aGraphSearchPhotoQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: niem_permission_settings_click */
public final class Fb4aGraphSearchPhotoQuery {

    /* compiled from: niem_permission_settings_click */
    public class Fb4aGraphSearchPhotoQueryString extends TypedGraphQlQueryString<Fb4aGraphSearchPhotoQueryModel> {
        public Fb4aGraphSearchPhotoQueryString() {
            super(Fb4aGraphSearchPhotoQueryModel.class, false, "Fb4aGraphSearchPhotoQuery", "31ce43c538044862677d87345252cdbd", "graph_search_query", "10154686242431729", RegularImmutableSet.a);
        }

        public final String m8475a(String str) {
            switch (str.hashCode()) {
                case -1849402738:
                    return "10";
                case -1780769805:
                    return "24";
                case -1745741354:
                    return "26";
                case -1663499699:
                    return "22";
                case -1150725321:
                    return "25";
                case -1109106741:
                    return "17";
                case -1101600581:
                    return "5";
                case -1012194872:
                    return "6";
                case -1004839537:
                    return "15";
                case -920426905:
                    return "19";
                case -817257615:
                    return "7";
                case -747148849:
                    return "12";
                case -711183266:
                    return "14";
                case -461877888:
                    return "23";
                case -376687594:
                    return "3";
                case -317710003:
                    return "28";
                case 3569626:
                    return "1";
                case 16907033:
                    return "2";
                case 94851343:
                    return "4";
                case 107944136:
                    return "0";
                case 169846802:
                    return "13";
                case 557908192:
                    return "27";
                case 759459718:
                    return "20";
                case 810737919:
                    return "9";
                case 1368284815:
                    return "18";
                case 1409276231:
                    return "16";
                case 1635420007:
                    return "21";
                case 1939875509:
                    return "11";
                case 1963391292:
                    return "8";
                default:
                    return str;
            }
        }

        protected final boolean m8476a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 57:
                    if (str.equals("9")) {
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
