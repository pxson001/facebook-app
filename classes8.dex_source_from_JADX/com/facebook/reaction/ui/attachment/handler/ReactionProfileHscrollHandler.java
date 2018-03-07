package com.facebook.reaction.ui.attachment.handler;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentActionStyle;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionProfileFields;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStoryAttachmentFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionAttachmentActionFragment;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionAttachmentActionFragmentModel;
import com.facebook.ui.touchlistener.HighlightViewOnTouchListener;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: VertexAttributionQuery */
public class ReactionProfileHscrollHandler extends AbstractReactionHscrollHandler {
    private static final CallerContext f20942b = CallerContext.a(ReactionProfileHscrollHandler.class, "reaction_dialog", "COVER_PHOTO");
    private static final CallerContext f20943c = CallerContext.a(ReactionProfileHscrollHandler.class, "reaction_dialog", "PROFILE_PHOTO");
    public final HighlightViewOnTouchListener f20944d = new HighlightViewOnTouchListener();

    @Inject
    public ReactionProfileHscrollHandler(ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher, ReactionUtil reactionUtil) {
        super(reactionIntentFactory, reactionIntentLauncher, reactionUtil);
    }

    protected final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        ReactionProfileFields M = reactionStoryAttachmentFragmentModel.M();
        boolean z = (M == null || M.eL_() == null || M.j() == null || M.k() == null || M.k().b() == null) ? false : true;
        return z;
    }

    protected final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        ReactionProfileFields M = reactionStoryAttachmentFragmentModel.M();
        Builder builder = ImmutableList.builder();
        ImmutableList b = reactionStoryAttachmentFragmentModel.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            ReactionAttachmentActionFragmentModel reactionAttachmentActionFragmentModel = (ReactionAttachmentActionFragmentModel) b.get(i);
            List fF_ = reactionAttachmentActionFragmentModel.fF_();
            if (!(fF_ == null || m24577a(fF_) == null)) {
                builder.c(reactionAttachmentActionFragmentModel);
            }
        }
        ImmutableList b2 = builder.b();
        if (!b2.isEmpty()) {
            return m24576a(reactionStoryAttachmentFragmentModel, M, b2);
        }
        View a = m22840a(2130906600);
        FbDraweeView fbDraweeView = (FbDraweeView) a.findViewById(2131566599);
        fbDraweeView.setAspectRatio(4.318584f);
        m24578a(reactionStoryAttachmentFragmentModel, M, a, fbDraweeView);
        a.setOnTouchListener(this.f20944d);
        return a;
    }

    protected final ReactionAttachmentIntent mo1129a(@Nonnull ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        int id = view.getId();
        if (id == 2131566605 || id == 2131566598) {
            ReactionProfileFields M = reactionStoryAttachmentFragmentModel.M();
            if (M == null || M.eL_() == null) {
                return null;
            }
            return this.f20808d.m22736a(M, UnitInteractionType.PROFILE_TAP);
        } else if (!(view.getTag() instanceof ReactionAttachmentActionFragmentModel)) {
            return null;
        } else {
            ReactionAttachmentActionFragmentModel reactionAttachmentActionFragmentModel = (ReactionAttachmentActionFragmentModel) view.getTag();
            GraphQLReactionStoryAttachmentActionStyle a = m24577a(reactionAttachmentActionFragmentModel.fF_());
            ReactionIntentFactory reactionIntentFactory = this.f20808d;
            ReactionAttachmentIntent reactionAttachmentIntent = null;
            if (reactionIntentFactory.m22753a(a)) {
                if (a == GraphQLReactionStoryAttachmentActionStyle.OPEN_URL) {
                    reactionAttachmentIntent = reactionIntentFactory.m22784h(reactionAttachmentActionFragmentModel.g());
                } else {
                    ReactionProfileFields M2 = reactionStoryAttachmentFragmentModel.M();
                    if (!(M2 == null || M2.eL_() == null)) {
                        if (a == GraphQLReactionStoryAttachmentActionStyle.VIEW_PROFILE) {
                            reactionAttachmentIntent = reactionIntentFactory.m22736a(M2, UnitInteractionType.VIEW_PROFILE_TAP);
                        } else if (a == GraphQLReactionStoryAttachmentActionStyle.SEND_MESSAGE) {
                            reactionAttachmentIntent = reactionIntentFactory.m22794l(M2.eL_());
                        }
                    }
                }
            }
            return reactionAttachmentIntent;
        }
    }

    private View m24576a(ReactionStoryAttachmentFragment reactionStoryAttachmentFragment, ReactionProfileFields reactionProfileFields, ImmutableList<ReactionAttachmentActionFragment> immutableList) {
        Preconditions.checkArgument(!immutableList.isEmpty());
        View a = m22840a(2130906603);
        FbDraweeView fbDraweeView = (FbDraweeView) a.findViewById(2131566599);
        fbDraweeView.setAspectRatio(2.5957446f);
        m24578a(reactionStoryAttachmentFragment, reactionProfileFields, a, fbDraweeView);
        a.findViewById(2131566605).setOnTouchListener(new HighlightViewOnTouchListener());
        ViewStub viewStub = (ViewStub) a.findViewById(2131566606);
        ReactionAttachmentActionFragmentModel reactionAttachmentActionFragmentModel;
        if (immutableList.size() == 1) {
            reactionAttachmentActionFragmentModel = (ReactionAttachmentActionFragmentModel) immutableList.get(0);
            viewStub.setLayoutResource(2130906677);
            m24579a(reactionAttachmentActionFragmentModel, (TextView) viewStub.inflate());
        } else {
            reactionAttachmentActionFragmentModel = (ReactionAttachmentActionFragmentModel) immutableList.get(0);
            viewStub.setLayoutResource(2130906676);
            ViewGroup viewGroup = (ViewGroup) viewStub.inflate();
            m24579a(reactionAttachmentActionFragmentModel, (TextView) viewGroup.findViewById(2131566724));
            m24579a((ReactionAttachmentActionFragmentModel) immutableList.get(1), (TextView) viewGroup.findViewById(2131566725));
        }
        return a;
    }

    public static void m24578a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, ReactionProfileFields reactionProfileFields, View view, FbDraweeView fbDraweeView) {
        if (!(reactionProfileFields.g() == null || reactionProfileFields.g().a() == null || reactionProfileFields.g().a().a() == null || reactionProfileFields.g().a().a().a() == null)) {
            fbDraweeView.a(Uri.parse(reactionProfileFields.g().a().a().a()), f20942b);
        }
        boolean z = (reactionProfileFields.k() == null || reactionProfileFields.k().b() == null) ? false : true;
        Preconditions.checkArgument(z);
        ((FbDraweeView) view.findViewById(2131566601)).a(Uri.parse(reactionProfileFields.k().b()), f20943c);
        ((TextView) view.findViewById(2131566591)).setText(reactionProfileFields.j());
        DefaultTextWithEntitiesFields k = reactionStoryAttachmentFragmentModel.k();
        if (k != null) {
            ((TextView) view.findViewById(2131566600)).setText(k.a());
        }
    }

    private void m24579a(ReactionAttachmentActionFragmentModel reactionAttachmentActionFragmentModel, TextView textView) {
        textView.setText(reactionAttachmentActionFragmentModel.b().a());
        textView.setOnTouchListener(this.f20944d);
        textView.setTag(reactionAttachmentActionFragmentModel);
    }

    private GraphQLReactionStoryAttachmentActionStyle m24577a(@Nonnull List<? extends GraphQLReactionStoryAttachmentActionStyle> list) {
        for (GraphQLReactionStoryAttachmentActionStyle graphQLReactionStoryAttachmentActionStyle : list) {
            if (this.f20808d.m22753a(graphQLReactionStoryAttachmentActionStyle)) {
                return graphQLReactionStoryAttachmentActionStyle;
            }
        }
        return null;
    }
}
