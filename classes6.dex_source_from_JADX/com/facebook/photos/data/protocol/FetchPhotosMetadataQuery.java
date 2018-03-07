package com.facebook.photos.data.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataWithoutFeedbackModel;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;

/* compiled from: suggested_photos */
public final class FetchPhotosMetadataQuery {

    /* compiled from: suggested_photos */
    public class FetchPhotosMetadataQueryString extends TypedGraphQlQueryString<Map<String, MediaMetadataWithoutFeedbackModel>> {
        public FetchPhotosMetadataQueryString() {
            super(MediaMetadataWithoutFeedbackModel.class, true, "FetchPhotosMetadataQuery", "d82ab2fec1d5ab756e172fe1cec08a89", "nodes", "10154686281651729", RegularImmutableSet.a);
        }

        public final String m4772a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "9";
                case -1745741354:
                    return "11";
                case -1663499699:
                    return "7";
                case -1363693170:
                    return "6";
                case -1150725321:
                    return "10";
                case -1109106741:
                    return "5";
                case -747148849:
                    return "2";
                case -461877888:
                    return "8";
                case -317710003:
                    return "13";
                case 104993457:
                    return "0";
                case 169846802:
                    return "4";
                case 557908192:
                    return "12";
                case 1939875509:
                    return "3";
                case 2088117983:
                    return "1";
                default:
                    return str;
            }
        }

        protected final boolean m4773a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
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
