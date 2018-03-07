package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;

/* compiled from: V_MPEG2 */
public class LifeEventHeaderIconView extends CustomLinearLayout {
    @VisibleForTesting
    final FbDraweeView f21072a;

    public LifeEventHeaderIconView(Context context) {
        this(context, null);
    }

    private LifeEventHeaderIconView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130905034);
        this.f21072a = (FbDraweeView) a(2131560549);
        setOrientation(1);
    }
}
