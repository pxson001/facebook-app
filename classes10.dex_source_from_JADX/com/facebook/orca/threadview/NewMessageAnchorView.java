package com.facebook.orca.threadview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.facebook.common.ui.util.ViewPositionUtil;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: messaging_received */
public class NewMessageAnchorView extends CustomFrameLayout {
    private TextView f7314a;
    private Animation f7315b;
    private Animation f7316c;

    /* compiled from: messaging_received */
    class C10961 implements OnTouchListener {
        final /* synthetic */ NewMessageAnchorView f7313a;

        C10961(NewMessageAnchorView newMessageAnchorView) {
            this.f7313a = newMessageAnchorView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f7313a.m6965a(motionEvent);
        }
    }

    public NewMessageAnchorView(Context context) {
        super(context);
        m6967b();
    }

    public NewMessageAnchorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6967b();
    }

    public NewMessageAnchorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6967b();
    }

    private void m6967b() {
        setContentView(2130905793);
        setVisibility(8);
        setClickable(true);
        setOnTouchListener(new C10961(this));
        this.f7314a = (TextView) findViewById(2131564997);
        this.f7315b = AnimationUtils.loadAnimation(getContext(), 2130968691);
        this.f7316c = AnimationUtils.loadAnimation(getContext(), 2130968690);
    }

    final void m6969a(int i) {
        m6970a(getResources().getString(2131231093, new Object[]{Integer.valueOf(i)}));
    }

    final void m6970a(String str) {
        this.f7314a.setText(str);
        if (getVisibility() == 8) {
            setVisibility(0);
            startAnimation(this.f7315b);
        }
    }

    final void m6968a() {
        if (getVisibility() == 0) {
            startAnimation(this.f7316c);
            setVisibility(8);
        }
    }

    private boolean m6965a(MotionEvent motionEvent) {
        boolean a = ViewPositionUtil.a(motionEvent, this);
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                setPressed(a);
                break;
            case 1:
                if (a) {
                    performClick();
                    break;
                }
                break;
            case 3:
                break;
        }
        setPressed(false);
        return true;
    }
}
