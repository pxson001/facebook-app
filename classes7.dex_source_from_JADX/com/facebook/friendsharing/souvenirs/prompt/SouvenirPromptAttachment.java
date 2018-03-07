package com.facebook.friendsharing.souvenirs.prompt;

import android.animation.Animator;
import android.content.Context;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.inlinecomposer.v2attachment.V2Attachment;

/* compiled from: RESIZE */
public class SouvenirPromptAttachment extends LinearLayout implements V2Attachment {
    private static final CallerContext f24089a = CallerContext.a(SouvenirPromptAttachment.class, "souvenirs");
    public FbDraweeView f24090b = ((FbDraweeView) findViewById(2131567550));
    public TextView f24091c = ((TextView) findViewById(2131565300));
    public TextView f24092d = ((TextView) findViewById(2131565301));

    public SouvenirPromptAttachment(Context context) {
        super(context);
        View.inflate(context, 2130907179, this);
        setOrientation(1);
    }

    public final void m26218a(Uri uri, String str, SpannableStringBuilder spannableStringBuilder) {
        this.f24090b.a(uri, f24089a);
        this.f24091c.setText(str);
        this.f24092d.setText(spannableStringBuilder);
    }

    public final View mo1476a() {
        return this;
    }

    public Animator getExpandAnimator() {
        return null;
    }

    public Animator getCollapseAnimator() {
        return null;
    }
}
