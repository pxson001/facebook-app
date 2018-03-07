package com.facebook.feedback.ui.rows.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import com.facebook.attachments.ui.AttachmentViewSticker;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: responsible_user */
public class CommentStickerView extends AttachmentViewSticker implements HighlightableView {
    @Inject
    public CommentRowViewControllerProvider f5199j;
    private final CommentRowViewController f5200k;

    public static void m5648a(Object obj, Context context) {
        ((CommentStickerView) obj).f5199j = (CommentRowViewControllerProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(CommentRowViewControllerProvider.class);
    }

    public CommentStickerView(Context context) {
        this(context, null);
    }

    private CommentStickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Class cls = CommentStickerView.class;
        m5648a(this, getContext());
        this.f5200k = this.f5199j.m5645a(this);
        this.f5200k.m5642a();
    }

    public final void mo279a(ValueAnimator valueAnimator) {
        this.f5200k.m5643a(valueAnimator);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f5200k.m5644a(motionEvent);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
        this.f5200k.f5194c = onTouchListener;
    }
}
