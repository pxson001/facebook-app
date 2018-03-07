package com.facebook.feedback.ui.rows.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import com.facebook.attachments.ui.DefaultShareAttachmentBinder;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: responsive_badge */
public class CommentShareView extends CustomLinearLayout implements HighlightableView {
    @Inject
    public CommentRowViewControllerProvider f5195a;
    @Inject
    public DefaultShareAttachmentBinder f5196b;
    public final ImageBlockLayout f5197c;
    private final CommentRowViewController f5198d;

    public static void m5646a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CommentShareView commentShareView = (CommentShareView) obj;
        CommentRowViewControllerProvider commentRowViewControllerProvider = (CommentRowViewControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CommentRowViewControllerProvider.class);
        DefaultShareAttachmentBinder b = DefaultShareAttachmentBinder.m997b(fbInjector);
        commentShareView.f5195a = commentRowViewControllerProvider;
        commentShareView.f5196b = b;
    }

    public CommentShareView(Context context) {
        this(context, null);
    }

    private CommentShareView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private CommentShareView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = CommentShareView.class;
        m5646a(this, getContext());
        setContentView(2130903299);
        this.f5198d = this.f5195a.m5645a(this);
        this.f5198d.m5642a();
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131431887);
        setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        this.f5197c = (ImageBlockLayout) findViewById(2131559710);
    }

    public final void mo279a(ValueAnimator valueAnimator) {
        this.f5198d.m5643a(valueAnimator);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f5198d.m5644a(motionEvent);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
        this.f5198d.f5194c = onTouchListener;
    }
}
