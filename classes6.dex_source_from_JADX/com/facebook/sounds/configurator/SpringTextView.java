package com.facebook.sounds.configurator;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.facebook.sounds.configurator.TextButton.OnLongPressListener;
import com.facebook.springs.Bouncy3Conversion;

/* compiled from: event_obj_id */
public class SpringTextView extends TextView {
    public static final SpringConfig f16024a = SpringConfig.m23058a(40.0d, 7.0d);
    public SpringConfig f16025b;
    public SpringConfig f16026c;
    public Spring f16027d;
    public TapController f16028e;
    public AnimStates f16029f = AnimStates.NONE;

    /* compiled from: event_obj_id */
    public enum AnimStates {
        NONE,
        PRESSING,
        UNPRESSING
    }

    /* compiled from: event_obj_id */
    public class PressListener {
        public final /* synthetic */ SpringTextView f16022a;

        public PressListener(SpringTextView springTextView) {
            this.f16022a = springTextView;
        }

        public final void m23656b() {
            SpringTextView springTextView = this.f16022a;
            if (!springTextView.f16029f.equals(AnimStates.UNPRESSING)) {
                springTextView.f16029f = AnimStates.UNPRESSING;
                springTextView.f16027d.m23050a(springTextView.f16026c);
                springTextView.f16027d.m23053b(1.0d).m23054c(8.0d);
            }
        }
    }

    /* compiled from: event_obj_id */
    public class SpringListener extends SimpleSpringListener {
        final /* synthetic */ SpringTextView f16023a;

        public SpringListener(SpringTextView springTextView) {
            this.f16023a = springTextView;
        }

        public final void mo1220a(Spring spring) {
            float b = (float) spring.m23052b();
            this.f16023a.setScaleX(b);
            this.f16023a.setScaleY(b);
        }

        public final void mo1219a() {
            this.f16023a.f16029f = AnimStates.NONE;
        }
    }

    public SpringTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Bouncy3Conversion bouncy3Conversion = new Bouncy3Conversion(20.0d, 0.0d);
        this.f16025b = SpringConfig.m23058a(bouncy3Conversion.b, bouncy3Conversion.c);
        bouncy3Conversion = new Bouncy3Conversion(5.0d, 10.0d);
        this.f16026c = SpringConfig.m23058a(bouncy3Conversion.b, bouncy3Conversion.c);
        this.f16027d = SpringSystem.m23059b().m23035a().m23051a(new SpringListener(this)).m23050a(this.f16025b).m23050a(f16024a).m23049a(1.0d);
        this.f16028e = new TapController(getContext(), this);
        this.f16028e.f16037f = new PressListener(this);
    }

    public void setOnLongPressListener(OnLongPressListener onLongPressListener) {
        this.f16028e.f16038g = onLongPressListener;
    }

    public void setLongPressEnabled(boolean z) {
        this.f16028e.f16034c.setIsLongpressEnabled(z);
    }

    @TargetApi(11)
    public void setEnabled(final boolean z) {
        Object obj;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            setAlpha(z ? 1.0f : 0.5f);
            super.setEnabled(z);
            return;
        }
        post(new Runnable(this) {
            final /* synthetic */ SpringTextView f16021b;

            public void run() {
                this.f16021b.setAlpha(z ? 1.0f : 0.5f);
                super.setEnabled(z);
            }
        });
    }
}
