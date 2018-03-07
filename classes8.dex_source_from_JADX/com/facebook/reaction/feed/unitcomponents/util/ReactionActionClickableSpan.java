package com.facebook.reaction.feed.unitcomponents.util;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.feed.environment.HasContext;
import com.facebook.reaction.action.ReactionActionHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionStoryAttachmentActionFragment;
import javax.annotation.Nullable;

/* compiled from: You'll now see Place Tips on your lock screen as you explore. */
public final class ReactionActionClickableSpan<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends ClickableSpan {
    private final ReactionAttachmentIntent f20697a;
    private final E f20698b;
    private final String f20699c;
    private final String f20700d;
    private final int f20701e;

    public ReactionActionClickableSpan(@Nullable ReactionStoryAttachmentActionFragment reactionStoryAttachmentActionFragment, ReactionActionHandler reactionActionHandler, E e, String str, String str2) {
        ReactionAttachmentIntent a;
        String str3 = null;
        if (reactionStoryAttachmentActionFragment != null) {
            Context context = ((HasContext) e).getContext();
            if (reactionStoryAttachmentActionFragment.fU_() != null) {
                str3 = reactionStoryAttachmentActionFragment.fU_().a();
            }
            a = reactionActionHandler.m22676a(reactionStoryAttachmentActionFragment, context, str3, ((HasReactionSession) e).mo704p().f18658a, ((HasReactionSession) e).mo704p().f18660c, str);
        }
        this.f20697a = a;
        this.f20698b = e;
        this.f20699c = str;
        this.f20700d = str2;
        this.f20701e = ((HasContext) e).getContext().getResources().getColor(2131361916);
    }

    public final void onClick(View view) {
        this.f20698b.mo695a(this.f20699c, this.f20700d, this.f20697a);
    }

    public final void updateDrawState(TextPaint textPaint) {
        if (this.f20697a != null) {
            textPaint.setColor(this.f20701e);
        }
        textPaint.setUnderlineText(false);
    }
}
