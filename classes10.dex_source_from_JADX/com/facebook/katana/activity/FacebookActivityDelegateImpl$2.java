package com.facebook.katana.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: SEARCH_RADIUS_10 */
public class FacebookActivityDelegateImpl$2 implements OnClickListener {
    final /* synthetic */ FacebookActivityDelegateImpl f24208a;

    public FacebookActivityDelegateImpl$2(FacebookActivityDelegateImpl facebookActivityDelegateImpl) {
        this.f24208a = facebookActivityDelegateImpl;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1495617238);
        this.f24208a.e.onBackPressed();
        Logger.a(2, EntryType.UI_INPUT_END, 122043105, a);
    }
}
