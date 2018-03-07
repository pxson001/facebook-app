package com.facebook.katana.activity.faceweb;

import android.content.Intent;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.offlinemode.intentchecker.OfflineIntentChecker;
import com.facebook.offlinemode.ui.OfflineSnackbarActionController;
import javax.annotation.Nullable;

/* compiled from: uri_unhandled_report_category_name */
public class FacewebOfflineIntentChecker implements OfflineIntentChecker {
    public final boolean m844a(Intent intent) {
        return intent.getIntExtra("target_fragment", -1) == ContentFragmentType.FACEWEB_FRAGMENT.ordinal();
    }

    public final boolean m843a() {
        return true;
    }

    @Nullable
    public final OfflineSnackbarActionController m845b(Intent intent) {
        return null;
    }
}
