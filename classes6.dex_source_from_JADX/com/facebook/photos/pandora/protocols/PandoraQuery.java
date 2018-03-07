package com.facebook.photos.pandora.protocols;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraAlbumQueryModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraCampaignMediasetQueryModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediasetQueryModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraProfileSuggestedPhotoQueryModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraTaggedMediaCountQueryModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraTaggedMediasetQueryModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraUploadedMediaCountQueryModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraUploadedMediasetQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: has_user_edited_content */
public final class PandoraQuery {

    /* compiled from: has_user_edited_content */
    public class PandoraAlbumQueryString extends TypedGraphQlQueryString<PandoraAlbumQueryModel> {
        public PandoraAlbumQueryString() {
            super(PandoraAlbumQueryModel.class, false, "PandoraAlbumQuery", "f6cccb71f74a7b8d8e5126126bf30c5f", "node", "10154686242141729", RegularImmutableSet.a);
        }

        public final String m20448a(String str) {
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
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m20449a(String str, Object obj) {
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

    /* compiled from: has_user_edited_content */
    public class PandoraCampaignMediasetQueryString extends TypedGraphQlQueryString<PandoraCampaignMediasetQueryModel> {
        public PandoraCampaignMediasetQueryString() {
            super(PandoraCampaignMediasetQueryModel.class, false, "PandoraCampaignMediasetQuery", "6b80883871a9892403658dce19602b33", "node", "10154686242106729", RegularImmutableSet.a);
        }

        public final String m20450a(String str) {
            switch (str.hashCode()) {
                case -1849402738:
                    return "7";
                case -1780769805:
                    return "21";
                case -1745741354:
                    return "23";
                case -1663499699:
                    return "19";
                case -1150725321:
                    return "22";
                case -1109106741:
                    return "14";
                case -1101600581:
                    return "2";
                case -1012194872:
                    return "3";
                case -1004839537:
                    return "12";
                case -920426905:
                    return "16";
                case -817257615:
                    return "4";
                case -747148849:
                    return "9";
                case -711183266:
                    return "11";
                case -461877888:
                    return "20";
                case -317710003:
                    return "25";
                case 94851343:
                    return "1";
                case 169846802:
                    return "10";
                case 557908192:
                    return "24";
                case 759459718:
                    return "17";
                case 810737919:
                    return "6";
                case 1368284815:
                    return "15";
                case 1409276231:
                    return "13";
                case 1635420007:
                    return "18";
                case 1939875509:
                    return "8";
                case 1963391292:
                    return "5";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m20451a(String str, Object obj) {
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

    /* compiled from: has_user_edited_content */
    public class PandoraMediasetQueryString extends TypedGraphQlQueryString<PandoraMediasetQueryModel> {
        public PandoraMediasetQueryString() {
            super(PandoraMediasetQueryModel.class, false, "PandoraMediasetQuery", "a6c8958a2f3eef5040958dd619623c64", "node", "10154686242096729", RegularImmutableSet.a);
        }

        public final String m20452a(String str) {
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
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m20453a(String str, Object obj) {
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

    /* compiled from: has_user_edited_content */
    public class PandoraProfileSuggestedPhotoQueryString extends TypedGraphQlQueryString<PandoraProfileSuggestedPhotoQueryModel> {
        public PandoraProfileSuggestedPhotoQueryString() {
            super(PandoraProfileSuggestedPhotoQueryModel.class, false, "PandoraProfileSuggestedPhotoQuery", "d4a892feca26dd97de12f51c4164a507", "viewer", "10154686242086729", RegularImmutableSet.a);
        }

        public final String m20454a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "15";
                case -1745741354:
                    return "17";
                case -1663499699:
                    return "13";
                case -1150725321:
                    return "16";
                case -1109106741:
                    return "8";
                case -1012194872:
                    return "1";
                case -1004839537:
                    return "6";
                case -920426905:
                    return "10";
                case -747148849:
                    return "2";
                case -711183266:
                    return "5";
                case -461877888:
                    return "14";
                case -317710003:
                    return "19";
                case 94851343:
                    return "0";
                case 169846802:
                    return "4";
                case 557908192:
                    return "18";
                case 759459718:
                    return "11";
                case 1368284815:
                    return "9";
                case 1409276231:
                    return "7";
                case 1635420007:
                    return "12";
                case 1939875509:
                    return "3";
                default:
                    return str;
            }
        }
    }

    /* compiled from: has_user_edited_content */
    public class PandoraTaggedMediaCountQueryString extends TypedGraphQlQueryString<PandoraTaggedMediaCountQueryModel> {
        public PandoraTaggedMediaCountQueryString() {
            super(PandoraTaggedMediaCountQueryModel.class, false, "PandoraTaggedMediaCountQuery", "0d02f17426cba811de186a521b5dc0d0", "node", "10154139247861729", RegularImmutableSet.a);
        }

        public final String m20455a(String str) {
            switch (str.hashCode()) {
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: has_user_edited_content */
    public class PandoraTaggedMediasetQueryString extends TypedGraphQlQueryString<PandoraTaggedMediasetQueryModel> {
        public PandoraTaggedMediasetQueryString() {
            super(PandoraTaggedMediasetQueryModel.class, false, "PandoraTaggedMediasetQuery", "9221c624d72b4d97787646c1c98a0869", "node", "10154686242126729", RegularImmutableSet.a);
        }

        public final String m20456a(String str) {
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
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m20457a(String str, Object obj) {
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

    /* compiled from: has_user_edited_content */
    public class PandoraUploadedMediaCountQueryString extends TypedGraphQlQueryString<PandoraUploadedMediaCountQueryModel> {
        public PandoraUploadedMediaCountQueryString() {
            super(PandoraUploadedMediaCountQueryModel.class, false, "PandoraUploadedMediaCountQuery", "e5a64958a55327c8ddf04a24e039a18d", "user", "10154405445786729", RegularImmutableSet.a);
        }

        public final String m20458a(String str) {
            switch (str.hashCode()) {
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: has_user_edited_content */
    public class PandoraUploadedMediasetQueryString extends TypedGraphQlQueryString<PandoraUploadedMediasetQueryModel> {
        public PandoraUploadedMediasetQueryString() {
            super(PandoraUploadedMediasetQueryModel.class, false, "PandoraUploadedMediasetQuery", "2af6f775c0b1d5e5b3a57bc8e098955a", "user", "10154686242196729", RegularImmutableSet.a);
        }

        public final String m20459a(String str) {
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
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m20460a(String str, Object obj) {
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
