package com.facebook.messaging.doodle;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.facebook.widget.text.TextViewUtils;

/* compiled from: onPlaybackStateChanged -  */
public class CaptionEditText extends EditText {
    public float f7798a;
    public float f7799b;
    public float f7800c;
    public ValueAnimator f7801d;
    public InputMethodManager f7802e = ((InputMethodManager) getContext().getSystemService("input_method"));

    /* compiled from: onPlaybackStateChanged -  */
    public class C06311 implements TextWatcher {
        final /* synthetic */ CaptionEditText f7796a;

        /* compiled from: onPlaybackStateChanged -  */
        class C06301 implements AnimatorUpdateListener {
            final /* synthetic */ C06311 f7795a;

            C06301(C06311 c06311) {
                this.f7795a = c06311;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f7795a.f7796a.setTextSize(0, ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }

        public C06311(CaptionEditText captionEditText) {
            this.f7796a = captionEditText;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            float max = Math.max(this.f7796a.f7799b, ((float) Math.pow(0.85d, (double) (charSequence.length() / 20))) * this.f7796a.f7798a);
            if (Math.abs(this.f7796a.f7800c - max) > 0.001f) {
                this.f7796a.f7800c = max;
                if (this.f7796a.f7801d != null && this.f7796a.f7801d.isRunning()) {
                    this.f7796a.f7801d.cancel();
                }
                this.f7796a.f7801d = ValueAnimator.ofFloat(new float[]{this.f7796a.getTextSize(), this.f7796a.f7800c}).setDuration(500);
                this.f7796a.f7801d.addUpdateListener(new C06301(this));
                this.f7796a.f7801d.start();
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: onPlaybackStateChanged -  */
    public class C06322 implements OnFocusChangeListener {
        final /* synthetic */ CaptionEditText f7797a;

        public C06322(CaptionEditText captionEditText) {
            this.f7797a = captionEditText;
        }

        public void onFocusChange(View view, boolean z) {
            this.f7797a.setInputType(((z ? 0 : 524288) | 1) | 16384);
        }
    }

    public CaptionEditText(Context context) {
        super(context);
        TextViewUtils.a(getContext(), this);
        this.f7798a = 40.0f;
        setTextSize(this.f7798a);
        this.f7798a = getTextSize();
        this.f7799b = this.f7798a / 2.0f;
        setIncludeFontPadding(false);
        addTextChangedListener(new C06311(this));
        setOnFocusChangeListener(new C06322(this));
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return super.dispatchKeyEvent(keyEvent);
        }
        clearFocus();
        this.f7802e.hideSoftInputFromWindow(getWindowToken(), 0);
        ((View) getParent()).requestFocus();
        return true;
    }

    public int getCurrentCursorLine() {
        int selectionStart = getSelectionStart();
        if (selectionStart != -1) {
            return getLayout().getLineForOffset(selectionStart);
        }
        return -1;
    }
}
