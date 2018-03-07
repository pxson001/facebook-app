package com.facebook.messaging.media.upload.segmented;

import com.facebook.ipc.media.data.LocalMediaData;
import com.facebook.ipc.media.data.MediaData;
import com.facebook.ipc.media.data.MediaData.Builder;
import com.facebook.ipc.media.data.MimeType;
import com.facebook.photos.base.media.MediaItemFactory.VideoItemBuilder;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import javax.annotation.Nullable;

/* compiled from: last_transaction_id */
public class VideoSegmentTranscodeUploadHelper {
    @Nullable
    public static VideoItem m12621a(MediaResource mediaResource) {
        if (Type.VIDEO.toString().equals(mediaResource.o)) {
            return null;
        }
        VideoItemBuilder videoItemBuilder = new VideoItemBuilder();
        Builder a = new Builder().a(Long.toString(mediaResource.g)).a(MediaData.Type.Video).a(mediaResource.c).a(MimeType.a(mediaResource.o));
        a.f = mediaResource.j;
        a = a;
        a.g = mediaResource.k;
        LocalMediaData.Builder a2 = new LocalMediaData.Builder().a(a.a());
        a2.b = mediaResource.A;
        a2 = a2;
        a2.d = mediaResource.g;
        videoItemBuilder.e = a2.a();
        videoItemBuilder = videoItemBuilder;
        videoItemBuilder.d = (long) mediaResource.b();
        videoItemBuilder = videoItemBuilder;
        videoItemBuilder.d = mediaResource.i;
        return videoItemBuilder.a();
    }
}
