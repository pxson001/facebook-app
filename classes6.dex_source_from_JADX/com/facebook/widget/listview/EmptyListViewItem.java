package com.facebook.widget.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.analytics.InteractionLogger;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: relationship_type */
public class EmptyListViewItem extends CustomRelativeLayout {
    private ViewStub f6035a;
    private TextView f6036b;
    private long f6037c;

    public EmptyListViewItem(Context context) {
        super(context);
        m8596a();
    }

    public EmptyListViewItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmptyListViewItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8596a();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.EmptyListViewItem);
        if (obtainStyledAttributes.peekValue(0) != null) {
            this.f6036b.setTextColor(obtainStyledAttributes.getColor(0, 0));
        }
        obtainStyledAttributes.recycle();
    }

    private void m8596a() {
        setContentView(2130905693);
        this.f6035a = (ViewStub) a(2131564856);
        this.f6036b = (TextView) a(2131564857);
        if (getBackground() == null) {
            CustomViewUtils.b(this, new ColorDrawable(-1));
        }
    }

    public void setTextColor(int i) {
        this.f6036b.setTextColor(i);
    }

    public void setMessage(@Nullable CharSequence charSequence) {
        this.f6036b.setText(charSequence);
        m8597b();
    }

    public void setMessage(int i) {
        this.f6036b.setText(i);
        m8597b();
    }

    public void setMovementMethod(MovementMethod movementMethod) {
        this.f6036b.setMovementMethod(movementMethod);
    }

    public final void m8598a(boolean z) {
        InteractionLogger a = InteractionLogger.a(this.f);
        MonotonicClock monotonicClock = (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(this.f);
        if (z && InteractionLogger.a(this.f6035a)) {
            this.f6037c = monotonicClock.now();
        }
        if (!(z || this.f6037c == 0 || !a.a(monotonicClock.now() - this.f6037c, this.f6035a))) {
            this.f6037c = 0;
        }
        this.f6035a.setVisibility(z ? 0 : 8);
    }

    private void m8597b() {
        this.f6036b.setVisibility(Strings.isNullOrEmpty(this.f6036b.getText().toString()) ? 8 : 0);
    }
}
