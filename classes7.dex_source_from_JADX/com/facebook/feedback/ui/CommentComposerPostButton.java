package com.facebook.feedback.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.drawable.TintedStateListDrawable;

/* compiled from: seen state */
public class CommentComposerPostButton extends ImageButton {
    private static final int[] f4196a = new int[0];
    private static final int[] f4197b = new int[]{2130773266};
    private static final int[] f4198c = new int[]{16842913, 2130773266};
    private TintedStateListDrawable f4199d;
    public Listener f4200e;
    public boolean f4201f;

    /* compiled from: seen state */
    class C03711 implements OnClickListener {
        final /* synthetic */ CommentComposerPostButton f4195a;

        C03711(CommentComposerPostButton commentComposerPostButton) {
            this.f4195a = commentComposerPostButton;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 174435281);
            if (!this.f4195a.f4201f) {
                this.f4195a.f4200e.mo231d();
            } else if (this.f4195a.isSelected()) {
                this.f4195a.f4200e.mo233f();
            } else {
                this.f4195a.f4200e.mo232e();
            }
            LogUtils.a(-323272337, a);
        }
    }

    /* compiled from: seen state */
    public interface Listener {
        void mo231d();

        void mo232e();

        void mo233f();
    }

    public CommentComposerPostButton(Context context) {
        this(context, null);
    }

    public CommentComposerPostButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4201f = false;
        m4826a();
    }

    private void m4826a() {
        setSoundEffectsEnabled(false);
        this.f4199d = new TintedStateListDrawable();
        Drawable drawable = getResources().getDrawable(2130843332);
        Drawable drawable2 = getResources().getDrawable(2130841977);
        drawable2.mutate();
        this.f4199d.m19232a(f4198c, Integer.valueOf(-10972929), drawable2);
        this.f4199d.m19232a(f4197b, Integer.valueOf(1291845632), drawable2);
        this.f4199d.addState(f4196a, drawable);
        setImageDrawable(this.f4199d);
        setOnClickListener(new C03711(this));
    }

    public void setListener(Listener listener) {
        this.f4200e = listener;
    }

    public void setShowSticker(boolean z) {
        this.f4201f = z;
        if (this.f4201f) {
            setContentDescription(getResources().getString(2131232438));
        } else {
            setContentDescription(getResources().getString(2131233307));
        }
        refreshDrawableState();
    }

    public boolean getShowSticker() {
        return this.f4201f;
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f4201f) {
            View.mergeDrawableStates(onCreateDrawableState, f4197b);
        }
        return onCreateDrawableState;
    }
}
