package com.facebook.orca.compose;

import com.facebook.base.fragment.FbFragment;
import com.facebook.bugreporter.BugReportOperationLogger;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.ui.keyboard.CustomKeyboardHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.messaging.analytics.navigation.MessagingAnalyticsLogger;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.react.keyboardinterface.ReactInstanceLifecycleHelperStub;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.user.cache.UserCache;

/* compiled from: orca_thread_read */
public class ComposerKeyboardManagerProvider extends AbstractAssistedProvider<ComposerKeyboardManager> {
    public final ComposerKeyboardManager m5110a(FbFragment fbFragment) {
        return new ComposerKeyboardManager((FbSharedPreferences) FbSharedPreferencesImpl.a(this), CustomKeyboardHelper.a(this), InputMethodManagerMethodAutoProvider.a(this), MessagingAnalyticsLogger.a(this), IdBasedSingletonScopeProvider.b(this, 137), (ZeroDialogController) FbZeroDialogController.a(this), BugReportOperationLogger.a(this), IdBasedProvider.a(this, 4197), IdBasedProvider.a(this, 4233), IdBasedProvider.a(this, 4108), ReactInstanceLifecycleHelperStub.m3598a(this), fbFragment, (QeAccessor) QeInternalImplMethodAutoProvider.a(this), IdBasedLazy.a(this, 8782), IdBasedLazy.a(this, 7620), UserCache.a(this), DataCache.a(this));
    }
}
