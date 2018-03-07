package com.facebook.groups.widget.preferencecategoryheading;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.view.LayoutInflater;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: TEXT_VISIBLE */
public class PreferenceCategoryHeadingView extends CustomFrameLayout {
    public Resources f23259a;
    public BetterTextView f23260b = ((BetterTextView) c(2131566204));
    private ImageView f23261c;

    public static void m24597a(Object obj, Context context) {
        ((PreferenceCategoryHeadingView) obj).f23259a = ResourcesMethodAutoProvider.a(FbInjector.get(context));
    }

    public PreferenceCategoryHeadingView(Context context) {
        super(context);
        Class cls = PreferenceCategoryHeadingView.class;
        m24597a(this, getContext());
        setContentView(2130906358);
    }

    public void setTitle(String str) {
        this.f23260b.setText(str);
    }

    public void setIcon(int i) {
        if (this.f23261c == null) {
            LayoutInflater.from(getContext()).inflate(2130906357, this, true);
            this.f23261c = (ImageView) c(2131566203);
        }
        this.f23261c.setImageDrawable(this.f23259a.getDrawable(i));
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f23260b.getLayoutParams();
        marginLayoutParams.setMargins(this.f23259a.getDimensionPixelOffset(2131434319), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        MarginLayoutParamsCompat.a(marginLayoutParams, this.f23259a.getDimensionPixelOffset(2131434319));
        this.f23260b.setLayoutParams(marginLayoutParams);
    }
}
