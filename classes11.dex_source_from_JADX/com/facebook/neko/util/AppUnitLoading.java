package com.facebook.neko.util;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.resources.ui.FbTextView;

/* compiled from: togglePlaceSaveParams */
public class AppUnitLoading extends AbstractUnit {
    private AppShimmerFrameLayout f882a;
    public View f883b;
    public View f884c;
    public FbTextView f885d;
    public View f886e;

    public AppUnitLoading(Context context) {
        super(context);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(2130903268, this);
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(2130773807, typedValue, true);
        setBackground(new ColorDrawable(typedValue.data));
        setOrientation(1);
        m1111a(linearLayout.findViewById(2131559625));
        this.f882a = (AppShimmerFrameLayout) linearLayout.findViewById(2131559629);
        this.f883b = linearLayout.findViewById(2131559633);
        this.f884c = linearLayout.findViewById(2131559630);
        this.f885d = (FbTextView) linearLayout.findViewById(2131559631);
        this.f886e = linearLayout.findViewById(2131559632);
        this.f882a.setTilt(0.0f);
        this.f884c.setVisibility(8);
    }

    public void setShowLoading(boolean z) {
        if (z) {
            this.f882a.m1155a();
        } else {
            this.f882a.m1156b();
        }
    }

    public final void mo12a(AppUnitState appUnitState, boolean z, boolean z2) {
        Object obj;
        if (appUnitState == AppUnitState.Error) {
            obj = 1;
        } else {
            obj = null;
        }
        setShowLoading(obj == null);
        if (z2) {
            this.f885d.setText(2131242255);
            this.f885d.setVisibility(0);
            this.f886e.setVisibility(0);
        } else {
            this.f885d.setText(2131242256);
            this.f885d.setVisibility(0);
            this.f886e.setVisibility(8);
        }
        if (z && obj != null) {
            AnimationUtils.m1114a(this.f883b, this.f884c, 4);
        } else if (obj != null) {
            this.f883b.setVisibility(4);
            this.f884c.setVisibility(0);
        } else {
            View view = this.f883b;
            view.setAlpha(1.0f);
            view.setVisibility(0);
            this.f884c.setVisibility(8);
        }
        requestLayout();
    }
}
