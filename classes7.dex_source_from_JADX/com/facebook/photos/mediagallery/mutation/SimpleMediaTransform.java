package com.facebook.photos.mediagallery.mutation;

import com.facebook.graphql.executor.iface.TypedModelVisitor;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLModels.SizeAwareMediaModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataModel;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: is_show_caspian_style */
public class SimpleMediaTransform implements TypedModelVisitor {
    @Nonnull
    private String f10756a;

    public SimpleMediaTransform(@Nonnull String str) {
        Preconditions.checkNotNull(str);
        this.f10756a = str;
    }

    public GraphQLMedia mo604a(GraphQLMedia graphQLMedia) {
        return graphQLMedia;
    }

    public SizeAwareMediaModel mo606a(SizeAwareMediaModel sizeAwareMediaModel) {
        return sizeAwareMediaModel;
    }

    public MediaMetadataModel mo605a(MediaMetadataModel mediaMetadataModel) {
        return mediaMetadataModel;
    }

    public final Object m12779a(@Nullable Object obj) {
        if ((obj instanceof GraphQLMedia) && this.f10756a.equals(((GraphQLMedia) obj).b())) {
            return mo604a((GraphQLMedia) obj);
        }
        if ((obj instanceof SizeAwareMediaModel) && this.f10756a.equals(((SizeAwareMediaModel) obj).d())) {
            return mo606a((SizeAwareMediaModel) obj);
        }
        if ((obj instanceof MediaMetadataModel) && this.f10756a.equals(((MediaMetadataModel) obj).d())) {
            return mo605a((MediaMetadataModel) obj);
        }
        return obj;
    }
}
