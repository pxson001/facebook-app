package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;

/* compiled from: VIEW_TYPE_DESCRIPTION_ONLY_ITEM */
public class MinutiaeAttachmentIconView extends CustomLinearLayout {
    @VisibleForTesting
    final FbDraweeView f21076a;

    public MinutiaeAttachmentIconView(Context context) {
        this(context, null);
    }

    private MinutiaeAttachmentIconView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130905286);
        this.f21076a = (FbDraweeView) a(2131563893);
        setOrientation(1);
    }
}
