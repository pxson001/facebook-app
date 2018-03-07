package com.facebook.reaction.ui.attachment.handler;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionRecyclableAttachmentHandler;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryTopicAttachmentFragmentModel.TopicModel;
import com.facebook.reaction.ui.recyclerview.ReactionSimpleViewHolder;
import com.facebook.ui.touchlistener.HighlightViewOnTouchListener;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: VIEW_STORY_TAP */
public class ReactionTopicBlocksHandler extends ReactionRecyclableAttachmentHandler<ReactionSimpleViewHolder> {
    private final ReactionIntentFactory f20961a;
    private final StyleSpan f20962b;
    private final HighlightViewOnTouchListener f20963c = new HighlightViewOnTouchListener();

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    public final void mo1130a(ViewHolder viewHolder, ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        ContentView contentView = (ContentView) ((ReactionSimpleViewHolder) viewHolder).a;
        TopicModel aa = reactionStoryAttachmentFragmentModel.aa();
        String d = aa.d();
        CharSequence spannableStringBuilder = new SpannableStringBuilder(StringFormatUtil.formatStrLocaleSafe("%s: %s", d, aa.g()));
        spannableStringBuilder.setSpan(this.f20962b, 0, d.length() + 1, 17);
        contentView.setTitleText(spannableStringBuilder);
        contentView.setTitleTextAppearance(2131625837);
        contentView.setThumbnailUri(aa.fu_().b());
        contentView.setThumbnailPlaceholderResource(2131361970);
        contentView.setOnTouchListener(this.f20963c);
    }

    @Inject
    public ReactionTopicBlocksHandler(ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher) {
        super(reactionIntentLauncher);
        this.f20961a = reactionIntentFactory;
        this.f20962b = new StyleSpan(1);
    }

    public final ViewHolder mo1131g() {
        return new ReactionSimpleViewHolder(m22840a(2130906721));
    }

    public final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        TopicModel aa = reactionStoryAttachmentFragmentModel.aa();
        return (aa == null || Strings.isNullOrEmpty(aa.c()) || Strings.isNullOrEmpty(aa.d()) || aa.g() == null || aa.fu_() == null || Strings.isNullOrEmpty(aa.fu_().b())) ? false : true;
    }

    protected final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        TopicModel aa = reactionStoryAttachmentFragmentModel.aa();
        if (aa.c() == null) {
            return null;
        }
        return this.f20961a.m22772d(aa.c(), aa.d());
    }
}
