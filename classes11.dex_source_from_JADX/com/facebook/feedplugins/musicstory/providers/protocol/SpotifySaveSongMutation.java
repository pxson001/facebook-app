package com.facebook.feedplugins.musicstory.providers.protocol;

import com.facebook.feedplugins.musicstory.providers.protocol.SpotifySaveSongMutationModels.SpotifySaveSongMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: com.facebook.platform.PLATFORM_SERVICE */
public final class SpotifySaveSongMutation {

    /* compiled from: com.facebook.platform.PLATFORM_SERVICE */
    public class SpotifySaveSongMutationString extends TypedGraphQLMutationString<SpotifySaveSongMutationModel> {
        public SpotifySaveSongMutationString() {
            super(SpotifySaveSongMutationModel.class, false, "SpotifySaveSongMutation", "b3042f58db288fdf1b1b2cefd481cb55", "spotify_save_song", "0", "10154357651281729", RegularImmutableSet.a);
        }

        public final String m9293a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
