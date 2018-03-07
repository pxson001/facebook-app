package com.facebook.reaction.ui.attachment.handler;

import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.CollectionUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionStoryAttachmentStoryFragmentModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionStoryAttachmentStoryFragmentModel.ActorsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.ui.touchlistener.HighlightViewOnTouchListener;
import com.google.common.base.Strings;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: Value for  */
public class ReactionProfileStoryHandler extends ReactionAttachmentHandler {
    private static final CallerContext f20945a = CallerContext.a(ReactionProfileStoryHandler.class, "reaction_dialog", "attachment_icon");
    private ReactionIntentFactory f20946b;

    @Inject
    public ReactionProfileStoryHandler(ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher) {
        super(reactionIntentLauncher);
        this.f20946b = reactionIntentFactory;
    }

    protected View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        ReactionStoryAttachmentStoryFragmentModel W = reactionStoryAttachmentFragmentModel.W();
        ActorsModel actorsModel = (ActorsModel) W.b().get(0);
        View a = m22840a(2130906610);
        mo1139a(a, actorsModel);
        TextView textView = (TextView) a.findViewById(2131566618);
        ReactionStoryAttachmentStoryFragmentModel W2 = reactionStoryAttachmentFragmentModel.W();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((ActorsModel) W2.b().get(0)).b());
        CharSequence charSequence = null;
        if (reactionStoryAttachmentFragmentModel.z() != null && !Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.z().a())) {
            charSequence = reactionStoryAttachmentFragmentModel.z().a();
        } else if (!(W2.eM_() == null || Strings.isNullOrEmpty(W2.eM_().a()))) {
            charSequence = W2.eM_().a();
        }
        if (charSequence != null) {
            spannableStringBuilder.append(" - ");
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.setSpan(new TextAppearanceSpan(this.f18821d, 2131625827), 0, length, 33);
            spannableStringBuilder.setSpan(new TextAppearanceSpan(this.f18821d, 2131625828), length, spannableStringBuilder.length(), 33);
        } else {
            spannableStringBuilder.setSpan(new TextAppearanceSpan(this.f18821d, 2131625827), 0, spannableStringBuilder.length(), 33);
        }
        textView.setText(spannableStringBuilder);
        if (!(reactionStoryAttachmentFragmentModel.Y() == null || reactionStoryAttachmentFragmentModel.Y().b() == null)) {
            ((FbDraweeView) ((ViewStub) a.findViewById(2131566620)).inflate()).a(Uri.parse(reactionStoryAttachmentFragmentModel.Y().b()), f20945a);
        }
        ((TextView) a.findViewById(2131566619)).setText(m22843a(W.d()));
        a.setOnTouchListener(new HighlightViewOnTouchListener());
        return a;
    }

    protected void mo1139a(View view, ActorsModel actorsModel) {
        if (actorsModel.c() != null && actorsModel.c().b() != null) {
            ImageBlockLayout imageBlockLayout = (ImageBlockLayout) view.findViewById(2131566617);
            imageBlockLayout.setThumbnailUri(actorsModel.c().b());
            imageBlockLayout.setThumbnailPlaceholderResource(2131361970);
        }
    }

    protected final ReactionAttachmentIntent mo1129a(@Nonnull ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        ReactionStoryAttachmentStoryFragmentModel W = reactionStoryAttachmentFragmentModel.W();
        if (W.g() == null) {
            return null;
        }
        return this.f20946b.m22748a(W.g(), W.c(), W.eN_().a(), UnitInteractionType.STORY_TAP);
    }

    protected final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        ReactionStoryAttachmentStoryFragmentModel W = reactionStoryAttachmentFragmentModel.W();
        return (W == null || !CollectionUtil.b(W.b()) || Strings.isNullOrEmpty(((ActorsModel) W.b().get(0)).b())) ? false : true;
    }
}
