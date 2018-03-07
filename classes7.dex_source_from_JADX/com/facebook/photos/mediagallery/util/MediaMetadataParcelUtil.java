package com.facebook.photos.mediagallery.util;

import android.os.Parcelable;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.SimpleMediaFeedbackModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;

/* compiled from: is_low_engagement_refresh_enabled */
public class MediaMetadataParcelUtil {
    public final ArrayList<Parcelable> m12812a(ImmutableList<MediaMetadata> immutableList, boolean z) {
        if (immutableList == null) {
            return null;
        }
        ArrayList<Parcelable> a = Lists.a();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            SimpleMediaFeedbackModel C;
            MediaMetadata mediaMetadata = (MediaMetadata) immutableList.get(i);
            DefaultImageFields g = mediaMetadata.g();
            String d = mediaMetadata.d();
            String b = g.b();
            int c = g.c();
            int a2 = g.a();
            if (z) {
                C = mediaMetadata.C();
            } else {
                C = null;
            }
            a.add(new MediaGalleryDataCore(d, b, c, a2, C));
        }
        return a;
    }

    public final ImmutableList<MediaMetadata> m12811a(ArrayList<Parcelable> arrayList, boolean z) {
        if (arrayList == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            builder.c(m12810a((Parcelable) arrayList.get(i), z));
        }
        return builder.b();
    }

    private static MediaMetadata m12810a(Parcelable parcelable, boolean z) {
        SimpleMediaFeedbackModel a;
        MediaGalleryDataCore mediaGalleryDataCore = (MediaGalleryDataCore) parcelable;
        MediaMetadataModel.Builder builder = new MediaMetadataModel.Builder();
        builder.y = mediaGalleryDataCore.f10787a;
        builder = builder;
        DefaultImageFieldsModel.Builder builder2 = new DefaultImageFieldsModel.Builder();
        builder2.b = mediaGalleryDataCore.f10788b;
        builder2 = builder2;
        builder2.c = mediaGalleryDataCore.f10789c;
        builder2 = builder2;
        builder2.a = mediaGalleryDataCore.f10790d;
        builder.A = builder2.a();
        MediaMetadataModel.Builder builder3 = builder;
        if (z) {
            a = SimpleMediaFeedbackModel.a(mediaGalleryDataCore.f10791e);
        } else {
            a = null;
        }
        builder3.u = a;
        return builder3.a();
    }
}
