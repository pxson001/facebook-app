package com.facebook.messaging.media.mediatray;

import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: seconds_since_warm_start */
public class MediaTrayLoader$Item {
    public final Type f3126a;
    public final MediaResource f3127b;
    public final MediaResource f3128c;

    public MediaTrayLoader$Item(MediaResource mediaResource, MediaResource mediaResource2) {
        this.f3127b = (MediaResource) Preconditions.checkNotNull(mediaResource);
        this.f3128c = (MediaResource) Preconditions.checkNotNull(mediaResource2);
        Preconditions.checkArgument(mediaResource.d == mediaResource2.d);
        this.f3126a = mediaResource.d;
    }
}
