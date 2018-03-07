package com.facebook.video.downloadmanager.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.video.downloadmanager.graphql.SavedVideoMutationModels.SavedVideoDownloadStateMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: connectionConstraint */
public final class SavedVideoMutation {

    /* compiled from: connectionConstraint */
    public class SavedVideoDownloadStateMutationString extends TypedGraphQLMutationString<SavedVideoDownloadStateMutationModel> {
        public SavedVideoDownloadStateMutationString() {
            super(SavedVideoDownloadStateMutationModel.class, false, "SavedVideoDownloadStateMutation", "a013ecd934e74f8c4ccedc274ce08c82", "saved_video_download_state", "0", "10154611276936729", RegularImmutableSet.a);
        }

        public final String m27473a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
