package com.facebook.localcontent.criticreviews;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.RecyclableView;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: notification_classic_scroll_perf */
public class CriticReviewView extends CustomLinearLayout implements RecyclableView {
    private static final CallerContext f6868a = CallerContext.a(CriticReviewView.class);
    private ImageBlockLayout f6869b;
    private FbDraweeView f6870c;
    private TextView f6871d;
    private TextView f6872e;
    private FbDraweeView f6873f;
    private TextView f6874g;
    private TextView f6875h;
    private TextView f6876i;
    private boolean f6877j;

    public CriticReviewView(Context context) {
        super(context);
        m7211b();
    }

    public CriticReviewView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m7211b();
    }

    public CriticReviewView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7211b();
    }

    public void setPublisherName(@Nullable String str) {
        m7210a(this.f6871d, str);
    }

    public void setPublishTime(@Nullable String str) {
        m7210a(this.f6872e, str);
    }

    public void setPublisherThumbnail(String str) {
        this.f6870c.a(Uri.parse(str), f6868a);
    }

    public void setPublisherContainerOnClickListener(OnClickListener onClickListener) {
        this.f6869b.setOnClickListener(onClickListener);
    }

    public void setReviewThumbnail(String str) {
        this.f6873f.a(Uri.parse(str), f6868a);
    }

    public void setReviewTitle(@Nullable String str) {
        m7210a(this.f6874g, str);
    }

    public void setReviewSummary(@Nullable String str) {
        m7210a(this.f6875h, str);
    }

    public void setReviewAuthor(@Nullable String str) {
        m7210a(this.f6876i, str);
    }

    public final boolean mo569a() {
        return this.f6877j;
    }

    public void setHasBeenAttached(boolean z) {
        this.f6877j = z;
    }

    private void m7211b() {
        setContentView(2130903827);
        this.f6869b = (ImageBlockLayout) a(2131560850);
        this.f6870c = (FbDraweeView) a(2131560851);
        this.f6871d = (TextView) a(2131560852);
        this.f6872e = (TextView) a(2131560853);
        this.f6873f = (FbDraweeView) a(2131560854);
        this.f6874g = (TextView) a(2131560856);
        this.f6875h = (TextView) a(2131560857);
        this.f6876i = (TextView) a(2131560858);
    }

    private static void m7210a(TextView textView, @Nullable String str) {
        textView.setText(str);
        textView.setVisibility(Strings.isNullOrEmpty(str) ? 8 : 0);
    }
}
