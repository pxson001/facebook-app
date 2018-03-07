package com.facebook.common.title;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: promo_data */
class IndicatorBarController$4 implements OnClickListener {
    final /* synthetic */ String f6122a;
    final /* synthetic */ IndicatorBarController f6123b;

    IndicatorBarController$4(IndicatorBarController indicatorBarController, String str) {
        this.f6123b = indicatorBarController;
        this.f6122a = str;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -469196622);
        this.f6123b.b.a(new Intent("android.intent.action.VIEW", Uri.parse(this.f6122a)), this.f6123b.g.getContext());
        Logger.a(2, EntryType.UI_INPUT_END, 1383968697, a);
    }
}
