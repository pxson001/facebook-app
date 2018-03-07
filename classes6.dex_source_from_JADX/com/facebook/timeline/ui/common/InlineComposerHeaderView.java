package com.facebook.timeline.ui.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.resources.ui.FbTextView;

/* compiled from: selectedDate */
public class InlineComposerHeaderView extends SegmentedLinearLayout {
    private static final CallerContext f5058a = CallerContext.a(InlineComposerHeaderView.class, "inline_composer");
    private ImageBlockLayout f5059b;
    private FbDraweeView f5060c;
    private FbTextView f5061d;

    public InlineComposerHeaderView(Context context) {
        super(context, null);
        m7821a();
    }

    public InlineComposerHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7821a();
    }

    private void m7821a() {
        setContentView(2130904311);
        setOrientation(1);
        this.f5059b = (ImageBlockLayout) a(2131561925);
        this.f5060c = (FbDraweeView) a(2131561926);
        this.f5061d = (FbTextView) a(2131561928);
    }

    private void m7822b() {
        Resources resources = getResources();
        setSegmentedDivider(new ColorDrawable(resources.getColor(2131362050)));
        setSegmentedDividerThickness(resources.getDimensionPixelSize(2131427379));
    }

    public final void m7823a(String str) {
        this.f5060c.a(Uri.parse(str), f5058a);
        m7822b();
    }

    public void setHeaderSectionOnClickListener(OnClickListener onClickListener) {
        this.f5059b.setOnClickListener(onClickListener);
    }

    public void setProfileImageOnClickListener(OnClickListener onClickListener) {
        this.f5060c.setOnClickListener(onClickListener);
    }

    public void setComposerHintText(String str) {
        this.f5061d.setText(str);
    }
}
