package com.facebook.katana.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.facebook.feed.prefs.NativeFeedSettingsActivity;

/* compiled from: SDK_VERSION */
class FbMainTabActivity$28 implements OnLongClickListener {
    final /* synthetic */ FbMainTabActivity f24216a;

    FbMainTabActivity$28(FbMainTabActivity fbMainTabActivity) {
        this.f24216a = fbMainTabActivity;
    }

    public boolean onLongClick(View view) {
        this.f24216a.ba.startActivity(new Intent(this.f24216a.ba, NativeFeedSettingsActivity.class));
        return true;
    }
}
