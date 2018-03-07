package com.facebook.feedback.ui.rows.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: resultRecievedAtMillis */
public class CommentPlaceInfoAttachmentView extends CustomFrameLayout implements HighlightableView {
    @Inject
    public CommentRowViewControllerProvider f5187a;
    private final CommentRowViewController f5188b;
    public final ImageBlockLayout f5189c;
    private final View f5190d;
    public final View f5191e;

    public static void m5640a(Object obj, Context context) {
        ((CommentPlaceInfoAttachmentView) obj).f5187a = (CommentRowViewControllerProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(CommentRowViewControllerProvider.class);
    }

    public CommentPlaceInfoAttachmentView(Context context) {
        this(context, null);
    }

    private CommentPlaceInfoAttachmentView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private CommentPlaceInfoAttachmentView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = CommentPlaceInfoAttachmentView.class;
        m5640a(this, getContext());
        setContentView(2130903632);
        this.f5189c = (ImageBlockLayout) findViewById(2131560452);
        this.f5190d = findViewById(2131560456);
        this.f5191e = findViewById(2131560451);
        this.f5188b = this.f5187a.m5645a(this);
        this.f5188b.m5642a();
    }

    public void setAddToMapButtonVisibility(int i) {
        this.f5190d.setVisibility(i);
    }

    public final void mo279a(ValueAnimator valueAnimator) {
        this.f5188b.m5643a(valueAnimator);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f5188b.m5644a(motionEvent);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
        this.f5188b.f5194c = onTouchListener;
    }
}
