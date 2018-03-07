package com.facebook.reaction;

import android.content.Context;
import com.facebook.drawee.view.DraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParams;
import com.facebook.photos.mediagallery.ui.DefaultMediaGalleryLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStoryFragment.ReactionAttachments;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel.EdgesModel;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: c08182f28974157a7ee11700d48d14dc */
public class ReactionMediaGalleryUtil {
    public final MediaGalleryLauncher f18613a;
    private final MediaGalleryLauncherParamsFactory f18614b;

    public static ReactionMediaGalleryUtil m22513b(InjectorLike injectorLike) {
        return new ReactionMediaGalleryUtil((MediaGalleryLauncher) DefaultMediaGalleryLauncher.m2459a(injectorLike), MediaGalleryLauncherParamsFactory.a(injectorLike));
    }

    @Inject
    public ReactionMediaGalleryUtil(MediaGalleryLauncher mediaGalleryLauncher, MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory) {
        this.f18613a = mediaGalleryLauncher;
        this.f18614b = mediaGalleryLauncherParamsFactory;
    }

    public final void m22514a(String str, ReactionAttachmentsModel reactionAttachmentsModel, String str2, DraweeView draweeView, ImageRequest imageRequest, Context context) {
        m22515a(str, m22512a(reactionAttachmentsModel), str2, draweeView, imageRequest, context);
    }

    public final void m22515a(String str, List<? extends SizeAwareMedia> list, final String str2, final DraweeView draweeView, final ImageRequest imageRequest, Context context) {
        Builder a = MediaGalleryLauncherParamsFactory.a(str, list).a(FullscreenGallerySource.REACTION_PHOTO_ITEM);
        a.m = true;
        a = a.a(str2).a(imageRequest);
        this.f18613a.a(context, a.b(), new AnimationParamProvider(this) {
            final /* synthetic */ ReactionMediaGalleryUtil f18612d;

            public final AnimationParams m22511a(String str) {
                if (str.equals(str2) && draweeView.b()) {
                    return AnimationParams.a(draweeView, imageRequest);
                }
                return null;
            }
        });
    }

    private static List<SizeAwareMedia> m22512a(ReactionAttachments reactionAttachments) {
        List<SizeAwareMedia> arrayList = new ArrayList();
        ImmutableList b = reactionAttachments.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            EdgesModel edgesModel = (EdgesModel) b.get(i);
            if (!(edgesModel == null || edgesModel.a() == null || edgesModel.a().E() == null)) {
                arrayList.add(edgesModel.a().E());
            }
        }
        return arrayList;
    }
}
