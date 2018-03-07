package com.facebook.timeline.actionbar.seefirst;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: use_ent_photo */
public class PermanentSeeFirstPopUpWindow extends LinearLayout {
    @Inject
    public BottomPopoverWindow f796a;
    public final TextView f797b = ((TextView) FindViewUtil.b(this, 2131567379));

    public static void m840a(Object obj, Context context) {
        ((PermanentSeeFirstPopUpWindow) obj).f796a = BottomPopoverWindow.m833b(FbInjector.get(context));
    }

    public PermanentSeeFirstPopUpWindow(Context context) {
        super(context);
        Class cls = PermanentSeeFirstPopUpWindow.class;
        m840a(this, getContext());
        View.inflate(context, 2130907043, this);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131429905);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        setOrientation(1);
        this.f796a.d(this);
    }
}
