package com.facebook.composer.attachments;

import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.tagging.store.TagStore;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.inject.Inject;

/* compiled from: place_picker_add_place_done */
public class PhotoTagExtractor {
    private final TagStore f7817a;

    @Inject
    public PhotoTagExtractor(TagStore tagStore) {
        this.f7817a = tagStore;
    }

    public final ImmutableList<Tag> m11260a(List<? extends MediaItem> list) {
        Builder builder = ImmutableList.builder();
        for (MediaItem mediaItem : list) {
            if (mediaItem.m() == MediaType.PHOTO) {
                List<Tag> b = this.f7817a.m21167b((PhotoItem) mediaItem);
                if (b != null) {
                    for (Tag tag : b) {
                        if (tag.f12788c > 0) {
                            builder.c(tag);
                        }
                    }
                }
            }
        }
        return builder.b();
    }
}
