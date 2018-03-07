package com.facebook.nearby.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.analytics.InteractionLogger;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: topPageScroll */
public class TypeaheadStatusView extends CustomFrameLayout {
    private static final Class<?> f781a = TypeaheadStatusView.class;
    private ProgressBar f782b;
    private TextView f783c;
    private InteractionLogger f784d;
    private long f785e;
    private MonotonicClock f786f;

    public TypeaheadStatusView(Context context) {
        this(context, null);
    }

    public TypeaheadStatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TypeaheadStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f785e = 0;
        setContentView(2130905413);
        this.f783c = (TextView) c(2131564173);
        this.f782b = (ProgressBar) c(2131564172);
        FbInjector fbInjector = FbInjector.get(context);
        this.f784d = InteractionLogger.a(fbInjector);
        this.f786f = (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector);
    }

    public final void m1066a() {
        if (InteractionLogger.a(this.f782b)) {
            this.f785e = this.f786f.now();
            this.f784d.a(true);
        }
        this.f782b.setVisibility(0);
        this.f783c.setVisibility(8);
    }

    public final void m1067a(String str) {
        this.f783c.setText(str);
        this.f783c.setVisibility(0);
        if (this.f785e != 0 && this.f784d.a(this.f786f.now() - this.f785e, this.f782b)) {
            this.f785e = 0;
        }
        this.f782b.setVisibility(8);
    }
}
