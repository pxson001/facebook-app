package com.facebook.localcontent.protocol.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.localcontent.protocol.graphql.PhotoUploadMutationsModels.PagePhotoMenuUploadModel;
import com.facebook.localcontent.protocol.graphql.PhotoUploadMutationsModels.PlacePhotoUploadModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: keywords_topic_sport_match */
public final class PhotoUploadMutations {

    /* compiled from: keywords_topic_sport_match */
    public class PagePhotoMenuUploadString extends TypedGraphQLMutationString<PagePhotoMenuUploadModel> {
        public PagePhotoMenuUploadString() {
            super(PagePhotoMenuUploadModel.class, false, "PagePhotoMenuUpload", "8e347abbde22a07be06c307912fac98b", "page_photo_menu_photo_upload", "0", "10154204803901729", RegularImmutableSet.a);
        }

        public final String m18646a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: keywords_topic_sport_match */
    public class PlacePhotoUploadString extends TypedGraphQLMutationString<PlacePhotoUploadModel> {
        public PlacePhotoUploadString() {
            super(PlacePhotoUploadModel.class, false, "PlacePhotoUpload", "7a3c026da0b09f6241173f8a7bef1d35", "place_photo_upload", "0", "10154204803801729", RegularImmutableSet.a);
        }

        public final String m18647a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
