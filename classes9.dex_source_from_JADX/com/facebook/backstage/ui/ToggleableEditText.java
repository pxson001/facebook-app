package com.facebook.backstage.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.backstage.util.KeyboardHeightChangeDetector;
import com.facebook.backstage.util.KeyboardHeightChangeDetector.OnKeyboardHeightChangeListener;
import com.facebook.debug.log.BLog;
import com.facebook.resources.ui.FbEditText;
import com.facebook.ui.keyboard.KeyboardUtils;

/* compiled from: ride_type */
public class ToggleableEditText extends FbEditText implements OnKeyboardHeightChangeListener {
    private static final String f5503c = ToggleableEditText.class.getSimpleName();
    protected final OnTouchListener f5504b;
    public ToggleEventListener f5505d;

    /* compiled from: ride_type */
    public interface ToggleEventListener {
        void mo175a();

        void mo176b();
    }

    /* compiled from: ride_type */
    class C05861 implements OnTouchListener {
        final /* synthetic */ ToggleableEditText f5519a;

        C05861(ToggleableEditText toggleableEditText) {
            this.f5519a = toggleableEditText;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (this.f5519a.isFocused()) {
                    this.f5519a.m5737c();
                } else {
                    this.f5519a.m5735b();
                }
            }
            return true;
        }
    }

    public ToggleableEditText(Context context) {
        this(context, null);
    }

    public ToggleableEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ToggleableEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5504b = new C05861(this);
        KeyboardHeightChangeDetector a = KeyboardHeightChangeDetector.m5772a();
        if (a.f5580i) {
            a.m5775a(this);
            setFocusable(true);
            setEnabled(true);
            setFocusableInTouchMode(true);
            setOnTouchListener(this.f5504b);
            return;
        }
        BLog.b(f5503c, "Keyboard height detector is not initialized.");
        throw new RuntimeException("Cannot inflate ToggleableEditText when Keyboard detector is not initialized.");
    }

    public final void m5733a() {
        setImeOptions(16448);
        setInputType(65);
    }

    public final void m5735b() {
        setFocusable(true);
        setEnabled(true);
        requestFocus();
        KeyboardUtils.b(getContext(), this);
    }

    public final void m5737c() {
        clearFocus();
        KeyboardUtils.a(getContext(), this);
    }

    @TargetApi(16)
    public final void m5736b(int i) {
        setBackground(new ColorDrawable(i));
    }

    public final void mo159a(int i) {
        if (i == 0) {
            clearFocus();
            if (this.f5505d != null) {
                this.f5505d.mo176b();
            }
        } else if (this.f5505d != null) {
            this.f5505d.mo175a();
        }
    }

    public void setEventListener(ToggleEventListener toggleEventListener) {
        this.f5505d = toggleEventListener;
    }
}
