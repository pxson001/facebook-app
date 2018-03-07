package com.facebook.stickers.keyboard;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: edit_text */
public class StickerKeyboardTabView extends CustomFrameLayout {
    public static final CallerContext f16649a = CallerContext.a(StickerKeyboardTabView.class, "sticker_keyboard");
    public FbDraweeView f16650b = ((FbDraweeView) c(2131565168));
    private ValueAnimator f16651c;

    /* compiled from: edit_text */
    class C11621 implements AnimatorUpdateListener {
        final /* synthetic */ StickerKeyboardTabView f16648a;

        C11621(StickerKeyboardTabView stickerKeyboardTabView) {
            this.f16648a = stickerKeyboardTabView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            StickerKeyboardTabView.setTabImageScale(this.f16648a, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public StickerKeyboardTabView(Context context) {
        super(context);
        setContentView(2130905868);
        setClickable(true);
        setBackgroundResource(2130842164);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -577719218);
        if (this.f16651c != null) {
            this.f16651c.start();
        }
        super.onAttachedToWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -132338550, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -545840427);
        if (this.f16651c != null) {
            this.f16651c.end();
        }
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1484217995, a);
    }

    public void setPlaceholderResourceId(int i) {
        ((GenericDraweeHierarchy) this.f16650b.getHierarchy()).b(getResources().getDrawable(i));
    }

    public void setContentDescription(String str) {
        this.f16650b.setContentDescription(str);
    }

    public void setIconPulsing(boolean z) {
        if (z) {
            if (this.f16651c == null) {
                this.f16651c = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
                this.f16651c.setRepeatCount(-1);
                this.f16651c.setRepeatMode(2);
                this.f16651c.setDuration(800);
                this.f16651c.start();
                this.f16651c.addUpdateListener(new C11621(this));
            }
            setTabImageScale(this, ((Float) this.f16651c.getAnimatedValue()).floatValue());
        } else if (this.f16651c != null) {
            this.f16651c.end();
            this.f16651c.removeAllUpdateListeners();
            this.f16651c = null;
        }
    }

    public static void setTabImageScale(StickerKeyboardTabView stickerKeyboardTabView, float f) {
        stickerKeyboardTabView.f16650b.setScaleX(f);
        stickerKeyboardTabView.f16650b.setScaleY(f);
    }
}
