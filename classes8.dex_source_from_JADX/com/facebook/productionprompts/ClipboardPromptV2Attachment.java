package com.facebook.productionprompts;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import com.facebook.feed.inlinecomposer.v2attachment.V2Attachment;
import com.facebook.widget.text.BetterTextView;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;

/* compiled from: resource_name */
public class ClipboardPromptV2Attachment implements V2Attachment {
    @VisibleForTesting
    public final BetterTextView f4482a;

    public ClipboardPromptV2Attachment(Context context) {
        this.f4482a = new BetterTextView(context);
        this.f4482a.setTextAppearance(context, 2131626160);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(2131432503);
        this.f4482a.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        this.f4482a.setMaxLines(2);
        this.f4482a.setEllipsize(TruncateAt.END);
    }

    public final View m4325a() {
        return this.f4482a;
    }

    @Nullable
    public Animator getExpandAnimator() {
        return null;
    }

    @Nullable
    public Animator getCollapseAnimator() {
        return null;
    }
}
