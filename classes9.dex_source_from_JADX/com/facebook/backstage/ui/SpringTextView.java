package com.facebook.backstage.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.backstage.ui.ToggleTextButton.C05851;
import com.facebook.backstage.util.Bouncy3Conversion;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;

/* compiled from: searchHint */
public class SpringTextView extends TextView {
    public final SpringConfig f4385a;
    public final SpringConfig f4386b;
    public final Spring f4387c;
    public final TapController f4388d;
    public AnimStates f4389e;
    public C05851 f4390f;

    /* compiled from: searchHint */
    public class C05841 {
        public final /* synthetic */ SpringTextView f5509a;

        C05841(SpringTextView springTextView) {
            this.f5509a = springTextView;
        }

        public final void m5743c() {
            SpringTextView springTextView = this.f5509a;
            if (!springTextView.f4389e.equals(AnimStates.UNPRESSING)) {
                springTextView.f4389e = AnimStates.UNPRESSING;
                springTextView.f4387c.a(springTextView.f4386b);
                springTextView.f4387c.b(1.0d).c(8.0d);
            }
        }
    }

    /* compiled from: searchHint */
    public enum AnimStates {
        NONE,
        PRESSING,
        UNPRESSING
    }

    /* compiled from: searchHint */
    class SpringListener extends SimpleSpringListener {
        final /* synthetic */ SpringTextView f5510a;

        public SpringListener(SpringTextView springTextView) {
            this.f5510a = springTextView;
        }

        public final void m5745a(Spring spring) {
            float b = (float) spring.b();
            this.f5510a.setScaleX(b);
            this.f5510a.setScaleY(b);
        }

        public final void m5744a() {
            this.f5510a.f4389e = AnimStates.NONE;
        }
    }

    public SpringTextView(Context context) {
        this(context, null);
    }

    public SpringTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SpringTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4389e = AnimStates.NONE;
        Bouncy3Conversion bouncy3Conversion = new Bouncy3Conversion(20.0d, 0.0d);
        this.f4385a = SpringConfig.a(bouncy3Conversion.f5563a, bouncy3Conversion.f5564b);
        bouncy3Conversion = new Bouncy3Conversion(5.0d, 10.0d);
        this.f4386b = SpringConfig.a(bouncy3Conversion.f5563a, bouncy3Conversion.f5564b);
        this.f4387c = SpringSystem.b().a().a(new SpringListener(this)).a(this.f4385a).a(1.0d);
        this.f4388d = new TapController(getContext(), this);
        this.f4388d.f5515c = new C05841(this);
    }

    public void setEnabled(boolean z) {
        setAlpha(z ? 1.0f : 0.5f);
        super.setEnabled(z);
    }
}
