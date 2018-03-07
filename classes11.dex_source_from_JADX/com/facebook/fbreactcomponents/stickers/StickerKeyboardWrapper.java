package com.facebook.fbreactcomponents.stickers;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.facebook.stickers.keyboard.StickerKeyboardView;
import com.facebook.stickers.model.StickerInterface;

/* compiled from: egenerator */
public class StickerKeyboardWrapper extends FrameLayout {
    public final StickerKeyboardView f7487a;
    private final Runnable f7488b = new C09481(this);

    /* compiled from: egenerator */
    class C09481 implements Runnable {
        final /* synthetic */ StickerKeyboardWrapper f7486a;

        C09481(StickerKeyboardWrapper stickerKeyboardWrapper) {
            this.f7486a = stickerKeyboardWrapper;
        }

        public void run() {
            this.f7486a.measure(MeasureSpec.makeMeasureSpec(this.f7486a.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(this.f7486a.getHeight(), 1073741824));
            this.f7486a.layout(this.f7486a.getLeft(), this.f7486a.getTop(), this.f7486a.getRight(), this.f7486a.getBottom());
        }
    }

    public StickerKeyboardWrapper(Context context) {
        super(context);
        this.f7487a = new StickerKeyboardView(context);
        this.f7487a.setInterface(StickerInterface.COMMENTS);
        addView(this.f7487a);
    }

    public void setBackgroundColor(int i) {
        this.f7487a.g.setBackgroundDrawable(new ColorDrawable(i));
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.f7488b);
    }
}
