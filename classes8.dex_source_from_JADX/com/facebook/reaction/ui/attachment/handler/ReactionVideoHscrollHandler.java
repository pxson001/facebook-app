package com.facebook.reaction.ui.attachment.handler;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.dialtone.DialtoneController;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel.CreationStoryModel.ActorsModel;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.ui.util.ReactionViewUtil;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: VIEW_STORY_INSIGHTS_TAP */
public class ReactionVideoHscrollHandler extends AbstractReactionHscrollHandler {
    private static final CallerContext f20964c = CallerContext.a(ReactionVideoHscrollHandler.class, "reaction_dialog_videos");
    private DialtoneController f20965b;

    @Inject
    public ReactionVideoHscrollHandler(DialtoneController dialtoneController, ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher, ReactionUtil reactionUtil) {
        super(reactionIntentFactory, reactionIntentLauncher, reactionUtil);
        this.f20965b = dialtoneController;
    }

    protected final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return m24612a(reactionStoryAttachmentFragmentModel.af()) && m24613d(reactionStoryAttachmentFragmentModel);
    }

    protected final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        VideoDetailFragmentModel af = reactionStoryAttachmentFragmentModel.af();
        Preconditions.checkArgument(m24612a(af));
        View a = m22840a(2130906614);
        if (this.f20965b.b()) {
            a.findViewById(2131566629).setVisibility(8);
        }
        String e = m24614e(reactionStoryAttachmentFragmentModel);
        String str = null;
        if (reactionStoryAttachmentFragmentModel.k() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.k().a())) {
            VideoDetailFragmentModel af2 = reactionStoryAttachmentFragmentModel.af();
            if (af2 != null) {
                int t = af2.t();
                if (t > 0) {
                    str = this.f18821d.getResources().getQuantityString(2131689538, t, new Object[]{Integer.valueOf(t)});
                }
            }
        } else {
            str = reactionStoryAttachmentFragmentModel.k().a();
        }
        String str2 = str;
        boolean z = (Strings.isNullOrEmpty(e) && Strings.isNullOrEmpty(str2)) ? false : true;
        Preconditions.checkArgument(z);
        ReactionViewUtil.m24825a((TextView) a.findViewById(2131566631), e);
        ReactionViewUtil.m24825a((TextView) a.findViewById(2131566632), str2);
        FbDraweeView fbDraweeView = (FbDraweeView) a.findViewById(2131566628);
        String b = af.F().b();
        fbDraweeView.a(b != null ? Uri.parse(b) : null, f20964c);
        fbDraweeView.setAspectRatio(1.7777778f);
        return a;
    }

    private static boolean m24612a(@Nullable VideoDetailFragmentModel videoDetailFragmentModel) {
        return (videoDetailFragmentModel == null || videoDetailFragmentModel.v() == null || videoDetailFragmentModel.j() == null || videoDetailFragmentModel.F() == null || videoDetailFragmentModel.F().b() == null) ? false : true;
    }

    private boolean m24613d(@Nonnull ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        if (Strings.isNullOrEmpty(m24614e(reactionStoryAttachmentFragmentModel))) {
            Object obj = 1;
            if (reactionStoryAttachmentFragmentModel.k() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.k().a())) {
                VideoDetailFragmentModel af = reactionStoryAttachmentFragmentModel.af();
                if (af == null || af.t() <= 0) {
                    obj = null;
                }
            }
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    private String m24614e(@Nonnull ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        if (reactionStoryAttachmentFragmentModel.z() != null && !Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.z().a())) {
            return reactionStoryAttachmentFragmentModel.z().a();
        }
        VideoDetailFragmentModel af = reactionStoryAttachmentFragmentModel.af();
        if (af == null) {
            return null;
        }
        String a = m24611a(af.E());
        if (!Strings.isNullOrEmpty(a)) {
            return a;
        }
        a = m24611a(af.s());
        if (!Strings.isNullOrEmpty(a)) {
            return a;
        }
        if (af.g() == null || af.g().b().isEmpty()) {
            return null;
        }
        return ((ActorsModel) af.g().b().get(0)).b();
    }

    protected final ReactionAttachmentIntent mo1129a(@Nonnull ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        ReactionAttachmentIntent reactionAttachmentIntent;
        Context context = this.f18821d;
        if (reactionStoryAttachmentFragmentModel.af() == null) {
            reactionAttachmentIntent = null;
        } else {
            reactionAttachmentIntent = ReactionIntentFactory.m22691a(reactionStoryAttachmentFragmentModel.af(), context);
        }
        return reactionAttachmentIntent;
    }

    private static String m24611a(DefaultTextWithEntitiesFields defaultTextWithEntitiesFields) {
        return defaultTextWithEntitiesFields != null ? defaultTextWithEntitiesFields.a() : null;
    }
}
