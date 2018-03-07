package com.facebook.timeline.refresher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import javax.annotation.Nullable;

/* compiled from: unread_mms_sms_threads */
public class ProfileRefresherPagerAdapterFactory {
    @Nullable
    public static Fragment m1040a(FragmentManager fragmentManager, @Nullable Bundle bundle, String str) {
        return bundle != null ? fragmentManager.a(bundle, str) : null;
    }
}
