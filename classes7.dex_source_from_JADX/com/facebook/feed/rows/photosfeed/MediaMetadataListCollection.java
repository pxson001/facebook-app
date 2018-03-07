package com.facebook.feed.rows.photosfeed;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: action_default_submessage */
public class MediaMetadataListCollection implements ListItemCollection<MediaMetadata> {
    public ImmutableList<MediaMetadata> f20045a;

    public final /* synthetic */ Object m23226a(int i) {
        return m23227b(i);
    }

    public final ImmutableList<MediaMetadata> m23228b() {
        return this.f20045a;
    }

    public final int m23225a() {
        return this.f20045a == null ? 0 : this.f20045a.size();
    }

    public final MediaMetadata m23227b(int i) {
        Preconditions.checkState(this.f20045a != null);
        return (MediaMetadata) this.f20045a.get(i);
    }
}
