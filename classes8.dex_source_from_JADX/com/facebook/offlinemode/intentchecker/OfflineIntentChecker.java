package com.facebook.offlinemode.intentchecker;

import android.content.Intent;
import com.facebook.offlinemode.ui.OfflineSnackbarActionController;
import javax.annotation.Nullable;

/* compiled from: currentTime */
public interface OfflineIntentChecker {
    boolean m19481a();

    boolean m19482a(Intent intent);

    @Nullable
    OfflineSnackbarActionController m19483b(Intent intent);
}
