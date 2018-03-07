package com.facebook.messaging.business.airline.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.facebook.R;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: thread_fetch_handler_changes */
public class AirlinePassengerTableView extends CustomLinearLayout {
    private final BetterTextView f1599a;
    private final BetterTextView f1600b;
    private final LinearLayout f1601c;
    private final boolean f1602d;
    private final boolean f1603e;
    private final LayoutInflater f1604f;
    private String f1605g;

    public AirlinePassengerTableView(Context context) {
        this(context, null, 0);
    }

    public AirlinePassengerTableView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AirlinePassengerTableView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130903225);
        this.f1604f = LayoutInflater.from(context);
        this.f1599a = (BetterTextView) a(2131559531);
        this.f1600b = (BetterTextView) a(2131559532);
        this.f1601c = (LinearLayout) a(2131559533);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AirlineView);
            this.f1602d = obtainStyledAttributes.getBoolean(0, false);
            this.f1603e = obtainStyledAttributes.getBoolean(1, false);
            obtainStyledAttributes.recycle();
        } else {
            this.f1602d = false;
            this.f1603e = false;
        }
        m1577a();
        setOrientation(1);
    }

    private void m1577a() {
        int i = this.f1602d ? 2131626471 : 2131626470;
        this.f1599a.setTextAppearance(getContext(), i);
        this.f1600b.setTextAppearance(getContext(), i);
    }

    public void setPassengerTitle(String str) {
        this.f1599a.setText(str);
    }

    public void setSeatTitle(String str) {
        this.f1600b.setText(str);
    }

    public void setCabinTitle(String str) {
        this.f1605g = str;
    }

    private void setUpRows(int i) {
        int childCount = this.f1601c.getChildCount();
        if (childCount < i) {
            while (childCount < i) {
                this.f1601c.addView(this.f1604f.inflate(2130903224, this, false));
                childCount++;
            }
        } else if (childCount > i) {
            for (childCount--; childCount >= i; childCount--) {
                this.f1601c.removeView(this.f1601c.getChildAt(childCount));
            }
        }
    }
}
