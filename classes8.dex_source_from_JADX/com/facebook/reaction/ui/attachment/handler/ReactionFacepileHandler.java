package com.facebook.reaction.ui.attachment.handler;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionAttachmentListener;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.interfaces.ReactionUnitParent;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionProfileFields;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.google.common.base.Strings;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: WEIGHT */
public class ReactionFacepileHandler extends ReactionAttachmentHandler {
    private static final CallerContext f20833a = CallerContext.a(ReactionFacepileHandler.class, "reaction_dialog");
    private ViewGroup f20834b;
    private final ReactionIntentFactory f20835c;
    private int f20836d;
    private ViewGroup f20837e;
    private FbDraweeView f20838f;
    private boolean f20839g;
    private int f20840h;

    @Inject
    public ReactionFacepileHandler(ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher) {
        super(reactionIntentLauncher);
        this.f20835c = reactionIntentFactory;
    }

    public final void mo1127a(ReactionAttachmentListener reactionAttachmentListener, ViewGroup viewGroup, ReactionCardContainer reactionCardContainer, String str, Surface surface, @Nullable ReactionUnitParent reactionUnitParent) {
        super.mo1127a(reactionAttachmentListener, viewGroup, reactionCardContainer, str, surface, reactionUnitParent);
        View a = m22840a(2130906598);
        this.f20837e = (ViewGroup) a.findViewById(2131566597);
        this.f18820c.addView(a);
        this.f20839g = false;
        this.f20840h = 0;
    }

    protected final int mo1128b(String str, String str2, ReactionAttachmentsModel reactionAttachmentsModel) {
        boolean z = false;
        this.f20836d = reactionAttachmentsModel.b().size();
        if (this.f20836d > 6) {
            return 0;
        }
        if (this.f20836d > 4) {
            z = true;
        }
        this.f20839g = z;
        return super.mo1128b(str, str2, reactionAttachmentsModel);
    }

    protected final View mo1118a(@Nonnull ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        View a = m22840a(2130906665);
        Uri parse = Uri.parse(reactionStoryAttachmentFragmentModel.M().k().b());
        this.f20838f = (FbDraweeView) a.findViewById(2131566713);
        this.f20838f.a(parse, f20833a);
        this.f20838f.setAspectRatio(1.0f);
        return a;
    }

    protected final ReactionAttachmentIntent mo1129a(@Nonnull ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        ReactionProfileFields M = reactionStoryAttachmentFragmentModel.M();
        if (M.eL_() == null) {
            return null;
        }
        return this.f20835c.m22736a(M, UnitInteractionType.PROFILE_TAP);
    }

    protected final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel.M() == null || reactionStoryAttachmentFragmentModel.M().k() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.M().k().b())) ? false : true;
    }

    protected final void mo1132a(View view) {
        this.f20840h++;
        int i = this.f20836d - 4;
        if (!this.f20839g || this.f20840h <= i) {
            this.f20837e.addView(view);
            return;
        }
        view.setLayoutParams(new LayoutParams(-1, 0, 1.0f));
        if ((this.f20836d - this.f20840h) % 2 == 1) {
            this.f20834b = (ViewGroup) m22840a(2130906599);
            this.f20837e.addView(this.f20834b);
        }
        this.f20834b.addView(view);
    }
}
