package com.facebook.reaction.ui.attachment.handler;

import android.view.View;
import android.widget.TextView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: VideoCardQuery */
public class ReactionPageServiceItemHandler extends ReactionAttachmentHandler {
    private final ReactionIntentFactory f20896a;
    private String f20897b;

    @Inject
    public ReactionPageServiceItemHandler(ReactionIntentLauncher reactionIntentLauncher, ReactionIntentFactory reactionIntentFactory) {
        super(reactionIntentLauncher);
        this.f20896a = reactionIntentFactory;
    }

    public final boolean mo1135a(String str, String str2, ReactionAttachmentsModel reactionAttachmentsModel) {
        this.f20897b = str;
        return super.mo1135a(str, str2, reactionAttachmentsModel);
    }

    protected final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        View a = m22840a(2130906699);
        TextView textView = (TextView) a.findViewById(2131565737);
        TextView textView2 = (TextView) a.findViewById(2131565738);
        ((ImageBlockLayout) a.findViewById(2131565732)).setShowThumbnail(false);
        textView.setText(reactionStoryAttachmentFragmentModel.D().eC_());
        CharSequence c = reactionStoryAttachmentFragmentModel.D().c();
        if (Strings.isNullOrEmpty(c)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(c);
            textView2.setVisibility(0);
        }
        return a;
    }

    protected final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel == null || reactionStoryAttachmentFragmentModel.A() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.A().b()) || reactionStoryAttachmentFragmentModel.D() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.D().d()) || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.D().eC_())) ? false : true;
    }

    protected final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        return ReactionIntentFactory.m22700a(this.f18824g, this.f20897b, GraphQLReactionStoryActionStyle.VIEW_PAGE_SERVICES.toString(), this.f20896a.m22770d(this.f18821d, reactionStoryAttachmentFragmentModel.A().b(), null, reactionStoryAttachmentFragmentModel.D().d()), UnitInteractionType.SEE_MORE_TAP);
    }
}
