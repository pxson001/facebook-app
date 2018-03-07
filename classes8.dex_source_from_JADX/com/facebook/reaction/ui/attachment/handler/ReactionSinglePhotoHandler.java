package com.facebook.reaction.ui.attachment.handler;

import android.net.Uri;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.reaction.ReactionMediaGalleryUtil;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.google.common.base.Strings;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: VIEW_STUB */
public class ReactionSinglePhotoHandler extends ReactionAttachmentHandler {
    private static final CallerContext f20947a = CallerContext.a(ReactionSinglePhotoHandler.class, "reaction_dialog");
    private final ReactionIntentFactory f20948b;
    private ReactionAttachmentsModel f20949c;
    private final ReactionMediaGalleryUtil f20950d;
    private String f20951e;

    @Inject
    public ReactionSinglePhotoHandler(ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher, ReactionMediaGalleryUtil reactionMediaGalleryUtil) {
        super(reactionIntentLauncher);
        this.f20948b = reactionIntentFactory;
        this.f20950d = reactionMediaGalleryUtil;
    }

    protected final int mo1128b(String str, String str2, ReactionAttachmentsModel reactionAttachmentsModel) {
        this.f20951e = str;
        this.f20949c = reactionAttachmentsModel;
        return super.mo1128b(str, str2, reactionAttachmentsModel);
    }

    protected final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        FbDraweeView fbDraweeView = (FbDraweeView) m22840a(2130906613);
        fbDraweeView.a(Uri.parse(reactionStoryAttachmentFragmentModel.E().be_().b()), f20947a);
        fbDraweeView.setAspectRatio(2.3333333f);
        return fbDraweeView;
    }

    protected final ReactionAttachmentIntent mo1129a(@Nonnull ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        ReactionAttachmentIntent reactionAttachmentIntent = null;
        SizeAwareMedia E = reactionStoryAttachmentFragmentModel.E();
        try {
            reactionAttachmentIntent = ReactionIntentFactory.m22684a(m22859d(), Long.parseLong(E.d()), null, E.be_().b());
        } catch (NumberFormatException e) {
        }
        return reactionAttachmentIntent;
    }

    protected final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        SizeAwareMedia E = reactionStoryAttachmentFragmentModel.E();
        return (E == null || Strings.isNullOrEmpty(E.d()) || E.be_() == null || Strings.isNullOrEmpty(E.be_().b())) ? false : true;
    }

    protected final void mo1138a(String str, ReactionAttachmentIntent reactionAttachmentIntent, View view) {
        if (reactionAttachmentIntent.f18831d != null) {
            this.f20950d.m22514a(this.f20951e, this.f20949c, reactionAttachmentIntent.f18829b, view instanceof FbDraweeView ? (FbDraweeView) view : (FbDraweeView) view.findViewById(2131566626), ImageRequest.a(reactionAttachmentIntent.f18831d.getStringExtra("photo_url")), this.f18821d);
        }
    }
}
