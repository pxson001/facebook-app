package com.facebook.facecast.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: avatarTranslationY */
public class FacecastPreviewSaveButton extends CustomLinearLayout {
    private GlyphView f18831a;
    private GlyphView f18832b;
    private CircularProgressView f18833c;
    public SaveButtonState f18834d;

    /* compiled from: avatarTranslationY */
    class C16331 implements Runnable {
        final /* synthetic */ FacecastPreviewSaveButton f18829a;

        C16331(FacecastPreviewSaveButton facecastPreviewSaveButton) {
            this.f18829a = facecastPreviewSaveButton;
        }

        public void run() {
            this.f18829a.m22429a(SaveButtonState.SAVED);
        }
    }

    /* compiled from: avatarTranslationY */
    public enum SaveButtonState {
        IDLE,
        SAVING_IN_PROGRESS,
        SAVING_COMPLETED,
        SAVED
    }

    public FacecastPreviewSaveButton(Context context) {
        this(context, null);
    }

    public FacecastPreviewSaveButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FacecastPreviewSaveButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22428a();
    }

    private void m22428a() {
        setContentView(2130904215);
        this.f18831a = (GlyphView) a(2131561675);
        this.f18832b = (GlyphView) a(2131561677);
        this.f18833c = (CircularProgressView) a(2131561676);
        m22429a(SaveButtonState.IDLE);
    }

    public final void m22429a(SaveButtonState saveButtonState) {
        switch (saveButtonState) {
            case IDLE:
                this.f18831a.setVisibility(0);
                this.f18832b.setVisibility(8);
                this.f18833c.setVisibility(8);
                break;
            case SAVING_IN_PROGRESS:
                this.f18831a.setVisibility(8);
                this.f18832b.setVisibility(8);
                this.f18833c.setVisibility(0);
                this.f18833c.setProgress(0.0f);
                break;
            case SAVING_COMPLETED:
                this.f18831a.setVisibility(8);
                this.f18832b.setVisibility(8);
                this.f18833c.setVisibility(0);
                this.f18833c.setProgress(1.0f);
                postDelayed(new C16331(this), 1000);
                break;
            case SAVED:
                this.f18831a.setVisibility(8);
                this.f18832b.setVisibility(0);
                this.f18833c.setVisibility(8);
                break;
        }
        this.f18834d = saveButtonState;
    }

    public void setProgress(float f) {
        if (this.f18833c.getVisibility() == 0) {
            this.f18833c.setProgress(f);
        }
    }

    public SaveButtonState getCurrentState() {
        return this.f18834d;
    }
}
