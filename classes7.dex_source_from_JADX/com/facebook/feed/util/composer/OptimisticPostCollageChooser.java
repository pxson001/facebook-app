package com.facebook.feed.util.composer;

import com.facebook.feed.collage.offline.CollageLayoutModel;
import com.facebook.feed.collage.offline.CollageLayoutModel.GridItem;
import com.facebook.feed.collage.offline.OfflineCollageLayoutChooser;
import com.facebook.feed.collage.offline.OfflineCollageLayoutChooser.Dimension;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachmentStyleInfo;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: should handle measured state too small  */
public class OptimisticPostCollageChooser {
    private final OfflineCollageLayoutChooser f3800a;

    public static OptimisticPostCollageChooser m4445b(InjectorLike injectorLike) {
        return new OptimisticPostCollageChooser(OfflineCollageLayoutChooser.m4376a(injectorLike));
    }

    @Inject
    public OptimisticPostCollageChooser(OfflineCollageLayoutChooser offlineCollageLayoutChooser) {
        this.f3800a = offlineCollageLayoutChooser;
    }

    public final CollageLayoutModel m4446a(ImmutableList<GraphQLMedia> immutableList) {
        Preconditions.checkNotNull(immutableList);
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLMedia graphQLMedia = (GraphQLMedia) immutableList.get(i);
            final int bo = graphQLMedia.bo();
            final int R = graphQLMedia.R();
            builder.c(new Dimension(this) {
                final /* synthetic */ OptimisticPostCollageChooser f3799c;

                public final int mo174a() {
                    return bo;
                }

                public final int mo175b() {
                    return R;
                }
            });
        }
        return this.f3800a.m4379a(builder.b());
    }

    public static GraphQLStoryAttachmentStyleInfo m4444a(@Nullable CollageLayoutModel collageLayoutModel, int i) {
        if (collageLayoutModel == null) {
            return null;
        }
        GridItem gridItem;
        if (i >= collageLayoutModel.f3657b.size()) {
            gridItem = null;
        } else {
            gridItem = (GridItem) collageLayoutModel.f3657b.get(i);
        }
        GridItem gridItem2 = gridItem;
        if (gridItem2 == null) {
            return new GraphQLStoryAttachmentStyleInfo();
        }
        GraphQLStoryAttachmentStyleInfo.Builder builder = new GraphQLStoryAttachmentStyleInfo.Builder();
        builder.m = gridItem2.f3654c;
        builder = builder;
        builder.l = gridItem2.f3655d;
        builder = builder;
        builder.n = gridItem2.f3652a;
        builder = builder;
        builder.o = gridItem2.f3653b;
        return new GraphQLStoryAttachmentStyleInfo(builder);
    }
}
