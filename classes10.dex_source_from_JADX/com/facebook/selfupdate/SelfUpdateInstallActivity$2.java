package com.facebook.selfupdate;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableBiMap;

/* compiled from: has_pin */
class SelfUpdateInstallActivity$2 implements OnClickListener {
    final /* synthetic */ SelfUpdateInstallActivity f9992a;

    SelfUpdateInstallActivity$2(SelfUpdateInstallActivity selfUpdateInstallActivity) {
        this.f9992a = selfUpdateInstallActivity;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1071422680);
        this.f9992a.p.a("selfupdate_click_not_now", ImmutableBiMap.b("source", this.f9992a.B));
        this.f9992a.q.m10105c();
        this.f9992a.finish();
        Logger.a(2, EntryType.UI_INPUT_END, 202628007, a);
    }
}
