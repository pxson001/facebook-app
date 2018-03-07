package com.facebook.messaging.business.ride.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: mmsport */
public class RideRouteInfoView extends CustomLinearLayout {
    private BetterTextView f9412a;
    private BetterTextView f9413b;

    public RideRouteInfoView(Context context) {
        super(context);
        m9867a();
    }

    public RideRouteInfoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m9867a();
    }

    protected RideRouteInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9867a();
    }

    private void m9867a() {
        setContentView(2130906895);
        setOrientation(1);
        this.f9412a = (BetterTextView) a(2131567082);
        this.f9413b = (BetterTextView) a(2131567083);
    }

    public final void m9868a(String str, String str2) {
        this.f9412a.setText(str);
        this.f9413b.setText(str2);
    }
}
