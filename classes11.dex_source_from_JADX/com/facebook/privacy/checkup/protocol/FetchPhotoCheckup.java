package com.facebook.privacy.checkup.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupModels.FetchProfilePhotoCheckupMediaOnlyQueryModel;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupModels.FetchProfilePhotoCheckupQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: page/{#%s}/notifications */
public final class FetchPhotoCheckup {

    /* compiled from: page/{#%s}/notifications */
    public class FetchProfilePhotoCheckupMediaOnlyQueryString extends TypedGraphQlQueryString<FetchProfilePhotoCheckupMediaOnlyQueryModel> {
        public FetchProfilePhotoCheckupMediaOnlyQueryString() {
            super(FetchProfilePhotoCheckupMediaOnlyQueryModel.class, false, "FetchProfilePhotoCheckupMediaOnlyQuery", "3071ce945deffb1c641cfc42a651f2f4", "viewer", "10154686281706729", RegularImmutableSet.a);
        }

        public final TriState m5413g() {
            return TriState.NO;
        }

        public final String m5411a(String str) {
            switch (str.hashCode()) {
                case -1963785130:
                    return "0";
                case -1780769805:
                    return "6";
                case -1745741354:
                    return "16";
                case -1663499699:
                    return "4";
                case -1363693170:
                    return "11";
                case -1150725321:
                    return "15";
                case -1109106741:
                    return "10";
                case -1012194872:
                    return "14";
                case -747148849:
                    return "8";
                case -705314112:
                    return "13";
                case -461877888:
                    return "5";
                case -317710003:
                    return "18";
                case -154818044:
                    return "1";
                case 16907033:
                    return "12";
                case 169846802:
                    return "9";
                case 557908192:
                    return "17";
                case 1086866511:
                    return "2";
                case 1939875509:
                    return "7";
                case 2088117983:
                    return "3";
                default:
                    return str;
            }
        }

        protected final boolean m5412a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 51:
                    if (str.equals("3")) {
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

    /* compiled from: page/{#%s}/notifications */
    public class FetchProfilePhotoCheckupQueryString extends TypedGraphQlQueryString<FetchProfilePhotoCheckupQueryModel> {
        public FetchProfilePhotoCheckupQueryString() {
            super(FetchProfilePhotoCheckupQueryModel.class, false, "FetchProfilePhotoCheckupQuery", "5311762f550ad8403b04f9bda0dcd277", "viewer", "10154686281736729", RegularImmutableSet.a);
        }

        public final TriState m5416g() {
            return TriState.NO;
        }

        public final String m5414a(String str) {
            switch (str.hashCode()) {
                case -1963785130:
                    return "0";
                case -1947111144:
                    return "3";
                case -1780769805:
                    return "9";
                case -1745741354:
                    return "19";
                case -1663499699:
                    return "7";
                case -1363693170:
                    return "14";
                case -1150725321:
                    return "18";
                case -1109106741:
                    return "13";
                case -1012194872:
                    return "17";
                case -747148849:
                    return "11";
                case -705314112:
                    return "16";
                case -620205220:
                    return "2";
                case -461877888:
                    return "8";
                case -317710003:
                    return "21";
                case -283133711:
                    return "1";
                case -154818044:
                    return "4";
                case 16907033:
                    return "15";
                case 169846802:
                    return "12";
                case 557908192:
                    return "20";
                case 1086866511:
                    return "5";
                case 1939875509:
                    return "10";
                case 2088117983:
                    return "6";
                default:
                    return str;
            }
        }

        protected final boolean m5415a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 54:
                    if (str.equals("6")) {
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
