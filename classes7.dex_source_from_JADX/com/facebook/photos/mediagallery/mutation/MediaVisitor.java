package com.facebook.photos.mediagallery.mutation;

import com.facebook.graphql.executor.cache.RecursiveModelTransformer;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLModels.SizeAwareMediaModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataModel;
import com.google.common.collect.Sets;
import java.util.Set;

/* compiled from: is_skippable */
public class MediaVisitor implements CacheVisitor {
    private final String f10754a;
    private final RecursiveModelTransformer[] f10755b;

    public MediaVisitor(String str, SimpleMediaTransform simpleMediaTransform) {
        this.f10754a = str;
        this.f10755b = new RecursiveModelTransformer[]{new RecursiveModelTransformer(GraphQLMedia.class, simpleMediaTransform), new RecursiveModelTransformer(MediaMetadataModel.class, simpleMediaTransform), new RecursiveModelTransformer(SizeAwareMediaModel.class, simpleMediaTransform)};
    }

    public final <T> T m12774a(T t) {
        for (RecursiveModelTransformer a : this.f10755b) {
            t = a.a(t);
        }
        return t;
    }

    public final Set<String> m12775a() {
        return Sets.a(new String[]{this.f10754a});
    }
}
