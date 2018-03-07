package com.facebook.photos.mediafetcher.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchForPhotosTakenHereModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchForPhotosTakenOfModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchForPostedPhotosModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchForProfilePictureModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchFromMediaSetIdModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchFromMediaSetTokenModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchFromReactionStoryModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchFromStoryModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchPageMenusModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaFetchPhotosByCategoryModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaWithAttributionFetchFromReactionStoryModel;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;

/* compiled from: lastEventCompletedAtMillis */
public final class MediaFetchQueries {

    /* compiled from: lastEventCompletedAtMillis */
    public class MediaFetchByIdsString extends TypedGraphQlQueryString<Map<String, MediaMetadataModel>> {
        public MediaFetchByIdsString() {
            super(MediaMetadataModel.class, true, "MediaFetchByIds", "d26138e6c6bf394bac6485b11664e703", "nodes", "10154686281761729", RegularImmutableSet.a);
        }

        public final String m12417a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "7";
                case -1745741354:
                    return "17";
                case -1663499699:
                    return "5";
                case -1363693170:
                    return "13";
                case -1176551809:
                    return "3";
                case -1150725321:
                    return "16";
                case -1139465268:
                    return "14";
                case -1109106741:
                    return "11";
                case -1012194872:
                    return "15";
                case -747148849:
                    return "9";
                case -461877888:
                    return "6";
                case -317710003:
                    return "19";
                case -154818044:
                    return "12";
                case 104120:
                    return "0";
                case 169846802:
                    return "10";
                case 557908192:
                    return "18";
                case 810737919:
                    return "2";
                case 1939875509:
                    return "8";
                case 2015690040:
                    return "1";
                case 2088117983:
                    return "4";
                default:
                    return str;
            }
        }

        protected final boolean m12418a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
                        z = false;
                        break;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        z = true;
                        break;
                    }
                    break;
                case 52:
                    if (str.equals("4")) {
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

    /* compiled from: lastEventCompletedAtMillis */
    public class MediaFetchForPhotosTakenHereString extends TypedGraphQlQueryString<MediaFetchForPhotosTakenHereModel> {
        public MediaFetchForPhotosTakenHereString() {
            super(MediaFetchForPhotosTakenHereModel.class, false, "MediaFetchForPhotosTakenHere", "6ebaf530e32e81b24428d9d775d10932", "page", "10154686281766729", RegularImmutableSet.a);
        }

        public final String m12419a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "10";
                case -1745741354:
                    return "20";
                case -1663499699:
                    return "8";
                case -1363693170:
                    return "16";
                case -1176551809:
                    return "6";
                case -1150725321:
                    return "19";
                case -1139465268:
                    return "17";
                case -1109106741:
                    return "14";
                case -1012194872:
                    return "18";
                case -747148849:
                    return "12";
                case -705314112:
                    return "3";
                case -461877888:
                    return "9";
                case -376687594:
                    return "1";
                case -317710003:
                    return "22";
                case -154818044:
                    return "15";
                case 16907033:
                    return "2";
                case 169846802:
                    return "13";
                case 557908192:
                    return "21";
                case 810737919:
                    return "5";
                case 1939875509:
                    return "11";
                case 2015690040:
                    return "4";
                case 2088117983:
                    return "7";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m12420a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 53:
                    if (str.equals("5")) {
                        z = false;
                        break;
                    }
                    break;
                case 54:
                    if (str.equals("6")) {
                        z = true;
                        break;
                    }
                    break;
                case 55:
                    if (str.equals("7")) {
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

    /* compiled from: lastEventCompletedAtMillis */
    public class MediaFetchForPhotosTakenOfString extends TypedGraphQlQueryString<MediaFetchForPhotosTakenOfModel> {
        public MediaFetchForPhotosTakenOfString() {
            super(MediaFetchForPhotosTakenOfModel.class, false, "MediaFetchForPhotosTakenOf", "7b47cdf1e2db2718fdaa30351f307a3f", "page", "10154686281751729", RegularImmutableSet.a);
        }

        public final String m12421a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "10";
                case -1745741354:
                    return "20";
                case -1663499699:
                    return "8";
                case -1363693170:
                    return "16";
                case -1176551809:
                    return "6";
                case -1150725321:
                    return "19";
                case -1139465268:
                    return "17";
                case -1109106741:
                    return "14";
                case -1012194872:
                    return "18";
                case -747148849:
                    return "12";
                case -705314112:
                    return "3";
                case -461877888:
                    return "9";
                case -376687594:
                    return "1";
                case -317710003:
                    return "22";
                case -154818044:
                    return "15";
                case 16907033:
                    return "2";
                case 169846802:
                    return "13";
                case 557908192:
                    return "21";
                case 810737919:
                    return "5";
                case 1939875509:
                    return "11";
                case 2015690040:
                    return "4";
                case 2088117983:
                    return "7";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m12422a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 53:
                    if (str.equals("5")) {
                        z = false;
                        break;
                    }
                    break;
                case 54:
                    if (str.equals("6")) {
                        z = true;
                        break;
                    }
                    break;
                case 55:
                    if (str.equals("7")) {
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

    /* compiled from: lastEventCompletedAtMillis */
    public class MediaFetchForPostedPhotosString extends TypedGraphQlQueryString<MediaFetchForPostedPhotosModel> {
        public MediaFetchForPostedPhotosString() {
            super(MediaFetchForPostedPhotosModel.class, false, "MediaFetchForPostedPhotos", "9f328b20bf7ed292ffce0e281d3097ad", "page", "10154686281716729", RegularImmutableSet.a);
        }

        public final String m12423a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "10";
                case -1745741354:
                    return "20";
                case -1663499699:
                    return "8";
                case -1363693170:
                    return "16";
                case -1176551809:
                    return "6";
                case -1150725321:
                    return "19";
                case -1139465268:
                    return "17";
                case -1109106741:
                    return "14";
                case -1012194872:
                    return "18";
                case -747148849:
                    return "12";
                case -705314112:
                    return "3";
                case -461877888:
                    return "9";
                case -376687594:
                    return "1";
                case -317710003:
                    return "22";
                case -154818044:
                    return "15";
                case 16907033:
                    return "2";
                case 169846802:
                    return "13";
                case 557908192:
                    return "21";
                case 810737919:
                    return "5";
                case 1939875509:
                    return "11";
                case 2015690040:
                    return "4";
                case 2088117983:
                    return "7";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m12424a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 53:
                    if (str.equals("5")) {
                        z = false;
                        break;
                    }
                    break;
                case 54:
                    if (str.equals("6")) {
                        z = true;
                        break;
                    }
                    break;
                case 55:
                    if (str.equals("7")) {
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

    /* compiled from: lastEventCompletedAtMillis */
    public class MediaFetchForProfilePictureString extends TypedGraphQlQueryString<MediaFetchForProfilePictureModel> {
        public MediaFetchForProfilePictureString() {
            super(MediaFetchForProfilePictureModel.class, false, "MediaFetchForProfilePicture", "89f168c37f6f523760b43925bcaf4d11", "node", "10154429039746729", RegularImmutableSet.a);
        }

        public final String m12425a(String str) {
            switch (str.hashCode()) {
                case -1663499699:
                    return "1";
                case -1102636175:
                    return "0";
                case 1939875509:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: lastEventCompletedAtMillis */
    public class MediaFetchFromMediaSetIdString extends TypedGraphQlQueryString<MediaFetchFromMediaSetIdModel> {
        public MediaFetchFromMediaSetIdString() {
            super(MediaFetchFromMediaSetIdModel.class, false, "MediaFetchFromMediaSetId", "ac194a500c899d29303c795600101a66", "node", "10154686281621729", RegularImmutableSet.a);
        }

        public final boolean m12428l() {
            return true;
        }

        public final int[][] m12429m() {
            return new int[][]{new int[]{0, 1, Integer.MIN_VALUE, 24}, new int[]{0, 1, Integer.MIN_VALUE, 2, 1}, new int[]{0, 1, Integer.MIN_VALUE, 3, 0}, new int[]{0, 1, Integer.MIN_VALUE, 15, 1}, new int[]{0, 1, Integer.MIN_VALUE, 17, 3}, new int[]{0, 1, Integer.MIN_VALUE, 17, 0, 0}, new int[]{0, 1, Integer.MIN_VALUE, 17, 5, 0, 0}, new int[]{1, 1, Integer.MIN_VALUE, 18, 1}, new int[]{133, 1, Integer.MIN_VALUE, 18, 2}, new int[]{0, 1, Integer.MIN_VALUE, 19, Integer.MIN_VALUE, 2}, new int[]{0, 1, Integer.MIN_VALUE, 19, Integer.MIN_VALUE, 3, Integer.MIN_VALUE, 1, 1}, new int[]{9, 1, Integer.MIN_VALUE, 20, 12}, new int[]{33, 1, Integer.MIN_VALUE, 20, 1}, new int[]{34, 1, Integer.MIN_VALUE, 20, 4}, new int[]{36, 1, Integer.MIN_VALUE, 20, 8}, new int[]{38, 1, Integer.MIN_VALUE, 20, 11}, new int[]{39, 1, Integer.MIN_VALUE, 20, 13, 0}, new int[]{40, 1, Integer.MIN_VALUE, 20, 14, 0}, new int[]{43, 1, Integer.MIN_VALUE, 20, 17, 0}, new int[]{44, 1, Integer.MIN_VALUE, 20, 17, 1}, new int[]{45, 1, Integer.MIN_VALUE, 20, 20}, new int[]{0, 1, Integer.MIN_VALUE, 31, Integer.MIN_VALUE, 0}, new int[]{0, 1, Integer.MIN_VALUE, 31, Integer.MIN_VALUE, 1, 1}, new int[]{1, 1, Integer.MIN_VALUE, 35, 0, 1}, new int[]{133, 1, Integer.MIN_VALUE, 35, 0, 2}, new int[]{0, 1, Integer.MIN_VALUE, 36, Integer.MIN_VALUE, 0, 2}, new int[]{0, 1, Integer.MIN_VALUE, 37, 1}, new int[]{1, 1, Integer.MIN_VALUE, 38, 1}, new int[]{133, 1, Integer.MIN_VALUE, 38, 2}, new int[]{0, 1, Integer.MIN_VALUE, 42, 1}, new int[]{0, 1, Integer.MIN_VALUE, 44, Integer.MIN_VALUE, 1, 1}, new int[]{0, 1, Integer.MIN_VALUE, 45, Integer.MIN_VALUE, 1}};
        }

        public final String m12426a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "9";
                case -1745741354:
                    return "19";
                case -1663499699:
                    return "7";
                case -1363693170:
                    return "15";
                case -1176551809:
                    return "5";
                case -1150725321:
                    return "18";
                case -1139465268:
                    return "16";
                case -1109106741:
                    return "13";
                case -1012194872:
                    return "17";
                case -747148849:
                    return "11";
                case -705314112:
                    return "2";
                case -461877888:
                    return "8";
                case -317710003:
                    return "21";
                case -154818044:
                    return "14";
                case 3355:
                    return "0";
                case 16907033:
                    return "1";
                case 169846802:
                    return "12";
                case 557908192:
                    return "20";
                case 810737919:
                    return "4";
                case 1939875509:
                    return "10";
                case 2015690040:
                    return "3";
                case 2088117983:
                    return "6";
                default:
                    return str;
            }
        }

        protected final boolean m12427a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 52:
                    if (str.equals("4")) {
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
                case 54:
                    if (str.equals("6")) {
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

    /* compiled from: lastEventCompletedAtMillis */
    public class MediaFetchFromMediaSetTokenString extends TypedGraphQlQueryString<MediaFetchFromMediaSetTokenModel> {
        public MediaFetchFromMediaSetTokenString() {
            super(MediaFetchFromMediaSetTokenModel.class, false, "MediaFetchFromMediaSetToken", "a1d0eeab0ab0d1f05fb3c99331be8599", "mediaset", "10154686281801729", RegularImmutableSet.a);
        }

        public final String m12430a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "11";
                case -1745741354:
                    return "21";
                case -1663499699:
                    return "9";
                case -1363693170:
                    return "17";
                case -1176551809:
                    return "7";
                case -1150725321:
                    return "20";
                case -1139465268:
                    return "18";
                case -1109106741:
                    return "15";
                case -1012194872:
                    return "19";
                case -747148849:
                    return "13";
                case -705314112:
                    return "4";
                case -461877888:
                    return "10";
                case -376687594:
                    return "2";
                case -317710003:
                    return "23";
                case -154818044:
                    return "16";
                case 16907033:
                    return "3";
                case 169846802:
                    return "14";
                case 557908192:
                    return "22";
                case 810737919:
                    return "6";
                case 1291425420:
                    return "1";
                case 1939875509:
                    return "12";
                case 2015690040:
                    return "5";
                case 2088117983:
                    return "8";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }

        protected final boolean m12431a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 54:
                    if (str.equals("6")) {
                        z = false;
                        break;
                    }
                    break;
                case 55:
                    if (str.equals("7")) {
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
                        return "true".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }

    /* compiled from: lastEventCompletedAtMillis */
    public class MediaFetchFromReactionStoryString extends TypedGraphQlQueryString<MediaFetchFromReactionStoryModel> {
        public MediaFetchFromReactionStoryString() {
            super(MediaFetchFromReactionStoryModel.class, false, "MediaFetchFromReactionStory", "e176f26654685dcac473e43d823b1ca5", "node", "10154686281726729", RegularImmutableSet.a);
        }

        public final boolean m12434l() {
            return true;
        }

        public final int[][] m12435m() {
            return new int[][]{new int[]{0, 1, Integer.MIN_VALUE, 1, 24}, new int[]{0, 1, Integer.MIN_VALUE, 1, 2, 1}, new int[]{0, 1, Integer.MIN_VALUE, 1, 3, 0}, new int[]{0, 1, Integer.MIN_VALUE, 1, 15, 1}, new int[]{0, 1, Integer.MIN_VALUE, 1, 17, 3}, new int[]{0, 1, Integer.MIN_VALUE, 1, 17, 0, 0}, new int[]{0, 1, Integer.MIN_VALUE, 1, 17, 5, 0, 0}, new int[]{1, 1, Integer.MIN_VALUE, 1, 18, 1}, new int[]{133, 1, Integer.MIN_VALUE, 1, 18, 2}, new int[]{0, 1, Integer.MIN_VALUE, 1, 19, Integer.MIN_VALUE, 2}, new int[]{0, 1, Integer.MIN_VALUE, 1, 19, Integer.MIN_VALUE, 3, Integer.MIN_VALUE, 1, 1}, new int[]{9, 1, Integer.MIN_VALUE, 1, 20, 12}, new int[]{33, 1, Integer.MIN_VALUE, 1, 20, 1}, new int[]{34, 1, Integer.MIN_VALUE, 1, 20, 4}, new int[]{36, 1, Integer.MIN_VALUE, 1, 20, 8}, new int[]{38, 1, Integer.MIN_VALUE, 1, 20, 11}, new int[]{39, 1, Integer.MIN_VALUE, 1, 20, 13, 0}, new int[]{40, 1, Integer.MIN_VALUE, 1, 20, 14, 0}, new int[]{43, 1, Integer.MIN_VALUE, 1, 20, 17, 0}, new int[]{44, 1, Integer.MIN_VALUE, 1, 20, 17, 1}, new int[]{45, 1, Integer.MIN_VALUE, 1, 20, 20}, new int[]{0, 1, Integer.MIN_VALUE, 1, 31, Integer.MIN_VALUE, 0}, new int[]{0, 1, Integer.MIN_VALUE, 1, 31, Integer.MIN_VALUE, 1, 1}, new int[]{1, 1, Integer.MIN_VALUE, 1, 35, 0, 1}, new int[]{133, 1, Integer.MIN_VALUE, 1, 35, 0, 2}, new int[]{0, 1, Integer.MIN_VALUE, 1, 36, Integer.MIN_VALUE, 0, 2}, new int[]{0, 1, Integer.MIN_VALUE, 1, 37, 1}, new int[]{1, 1, Integer.MIN_VALUE, 1, 38, 1}, new int[]{133, 1, Integer.MIN_VALUE, 1, 38, 2}, new int[]{0, 1, Integer.MIN_VALUE, 1, 42, 1}, new int[]{0, 1, Integer.MIN_VALUE, 1, 44, Integer.MIN_VALUE, 1, 1}, new int[]{0, 1, Integer.MIN_VALUE, 1, 45, Integer.MIN_VALUE, 1}};
        }

        public final String m12432a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "9";
                case -1745741354:
                    return "19";
                case -1663499699:
                    return "7";
                case -1363693170:
                    return "15";
                case -1176551809:
                    return "5";
                case -1150725321:
                    return "18";
                case -1139465268:
                    return "16";
                case -1109106741:
                    return "13";
                case -1012194872:
                    return "17";
                case -747148849:
                    return "11";
                case -705314112:
                    return "2";
                case -461877888:
                    return "8";
                case -317710003:
                    return "21";
                case -154818044:
                    return "14";
                case 3355:
                    return "0";
                case 16907033:
                    return "1";
                case 169846802:
                    return "12";
                case 557908192:
                    return "20";
                case 810737919:
                    return "4";
                case 1939875509:
                    return "10";
                case 2015690040:
                    return "3";
                case 2088117983:
                    return "6";
                default:
                    return str;
            }
        }

        protected final boolean m12433a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 52:
                    if (str.equals("4")) {
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
                case 54:
                    if (str.equals("6")) {
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

    /* compiled from: lastEventCompletedAtMillis */
    public class MediaFetchFromStoryString extends TypedGraphQlQueryString<MediaFetchFromStoryModel> {
        public MediaFetchFromStoryString() {
            super(MediaFetchFromStoryModel.class, false, "MediaFetchFromStory", "f1768d9c8b3fe79fdc5b6fd5407aac6d", "node", "10154686281631729", RegularImmutableSet.a);
        }

        public final String m12436a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "7";
                case -1745741354:
                    return "17";
                case -1663499699:
                    return "5";
                case -1363693170:
                    return "13";
                case -1176551809:
                    return "3";
                case -1150725321:
                    return "16";
                case -1139465268:
                    return "14";
                case -1109106741:
                    return "11";
                case -1012194872:
                    return "15";
                case -747148849:
                    return "9";
                case -461877888:
                    return "6";
                case -317710003:
                    return "19";
                case -154818044:
                    return "12";
                case 3355:
                    return "0";
                case 169846802:
                    return "10";
                case 557908192:
                    return "18";
                case 810737919:
                    return "2";
                case 1939875509:
                    return "8";
                case 2015690040:
                    return "1";
                case 2088117983:
                    return "4";
                default:
                    return str;
            }
        }

        protected final boolean m12437a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
                        z = false;
                        break;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        z = true;
                        break;
                    }
                    break;
                case 52:
                    if (str.equals("4")) {
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

    /* compiled from: lastEventCompletedAtMillis */
    public class MediaFetchPageMenusString extends TypedGraphQlQueryString<MediaFetchPageMenusModel> {
        public MediaFetchPageMenusString() {
            super(MediaFetchPageMenusModel.class, false, "MediaFetchPageMenus", "565c4d6834a9b190e1ae2aa6720bddd7", "page", "10154686281781729", RegularImmutableSet.a);
        }

        public final String m12438a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "10";
                case -1745741354:
                    return "20";
                case -1663499699:
                    return "8";
                case -1363693170:
                    return "16";
                case -1176551809:
                    return "6";
                case -1150725321:
                    return "19";
                case -1139465268:
                    return "17";
                case -1109106741:
                    return "14";
                case -1012194872:
                    return "18";
                case -803548981:
                    return "0";
                case -747148849:
                    return "12";
                case -461877888:
                    return "9";
                case -376687594:
                    return "1";
                case -317710003:
                    return "22";
                case -154818044:
                    return "15";
                case 16907033:
                    return "2";
                case 94851343:
                    return "3";
                case 169846802:
                    return "13";
                case 557908192:
                    return "21";
                case 810737919:
                    return "5";
                case 1939875509:
                    return "11";
                case 2015690040:
                    return "4";
                case 2088117983:
                    return "7";
                default:
                    return str;
            }
        }

        protected final boolean m12439a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 53:
                    if (str.equals("5")) {
                        z = false;
                        break;
                    }
                    break;
                case 54:
                    if (str.equals("6")) {
                        z = true;
                        break;
                    }
                    break;
                case 55:
                    if (str.equals("7")) {
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

    /* compiled from: lastEventCompletedAtMillis */
    public class MediaFetchPhotosByCategoryString extends TypedGraphQlQueryString<MediaFetchPhotosByCategoryModel> {
        public MediaFetchPhotosByCategoryString() {
            super(MediaFetchPhotosByCategoryModel.class, false, "MediaFetchPhotosByCategory", "459d07786ef5e1229230f302948989e5", "page", "10154686281786729", RegularImmutableSet.a);
        }

        public final String m12440a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "12";
                case -1745741354:
                    return "22";
                case -1663499699:
                    return "10";
                case -1363693170:
                    return "18";
                case -1176551809:
                    return "8";
                case -1150725321:
                    return "21";
                case -1139465268:
                    return "19";
                case -1109106741:
                    return "16";
                case -1012194872:
                    return "20";
                case -803548981:
                    return "0";
                case -799136893:
                    return "4";
                case -747148849:
                    return "14";
                case -461877888:
                    return "11";
                case -376687594:
                    return "1";
                case -317710003:
                    return "24";
                case -154818044:
                    return "17";
                case 16907033:
                    return "2";
                case 50511102:
                    return "3";
                case 94851343:
                    return "5";
                case 169846802:
                    return "15";
                case 557908192:
                    return "23";
                case 810737919:
                    return "7";
                case 1939875509:
                    return "13";
                case 2015690040:
                    return "6";
                case 2088117983:
                    return "9";
                default:
                    return str;
            }
        }

        protected final boolean m12441a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 55:
                    if (str.equals("7")) {
                        z = false;
                        break;
                    }
                    break;
                case 56:
                    if (str.equals("8")) {
                        z = true;
                        break;
                    }
                    break;
                case 57:
                    if (str.equals("9")) {
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

    /* compiled from: lastEventCompletedAtMillis */
    public class MediaWithAttributionFetchFromReactionStoryString extends TypedGraphQlQueryString<MediaWithAttributionFetchFromReactionStoryModel> {
        public MediaWithAttributionFetchFromReactionStoryString() {
            super(MediaWithAttributionFetchFromReactionStoryModel.class, false, "MediaWithAttributionFetchFromReactionStory", "ab8acdc3cb923fc3609072c29d4a32f1", "node", "10154439284481729", RegularImmutableSet.a);
        }

        public final String m12442a(String str) {
            switch (str.hashCode()) {
                case -1780769805:
                    return "8";
                case -1745741354:
                    return "10";
                case -1663499699:
                    return "6";
                case -1150725321:
                    return "9";
                case -705314112:
                    return "2";
                case -461877888:
                    return "7";
                case -317710003:
                    return "12";
                case 3355:
                    return "0";
                case 16907033:
                    return "1";
                case 169846802:
                    return "5";
                case 557908192:
                    return "11";
                case 996172250:
                    return "3";
                case 1939875509:
                    return "4";
                default:
                    return str;
            }
        }
    }
}
