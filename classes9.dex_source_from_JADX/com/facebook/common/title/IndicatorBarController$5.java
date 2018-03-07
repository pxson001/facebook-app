package com.facebook.common.title;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.facebook.zero.activity.ZeroInternSettingsActivity;

/* compiled from: promo_data */
class IndicatorBarController$5 implements OnLongClickListener {
    final /* synthetic */ View f6124a;
    final /* synthetic */ IndicatorBarController f6125b;

    IndicatorBarController$5(IndicatorBarController indicatorBarController, View view) {
        this.f6125b = indicatorBarController;
        this.f6124a = view;
    }

    public boolean onLongClick(View view) {
        Context context = this.f6124a.getContext();
        this.f6125b.b.a(new Intent(context, ZeroInternSettingsActivity.class), context);
        return true;
    }
}
