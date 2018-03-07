package com.facebook.adinterfaces.component;

import android.content.Intent;
import com.facebook.adinterfaces.AdInterfacesObjectiveActivity;
import com.facebook.common.util.StringUtil;
import com.facebook.offlinemode.intentchecker.OfflineIntentChecker;
import com.facebook.offlinemode.ui.OfflineSnackbarActionController;
import javax.annotation.Nullable;

/* compiled from: _is_valid */
public class AdInterfacesOfflineChecker implements OfflineIntentChecker {
    public final boolean m22607a(Intent intent) {
        if (intent.getComponent() == null) {
            return false;
        }
        return StringUtil.a(intent.getComponent().getClassName(), AdInterfacesObjectiveActivity.class.getName());
    }

    public final boolean m22606a() {
        return true;
    }

    @Nullable
    public final OfflineSnackbarActionController m22608b(Intent intent) {
        return null;
    }
}
