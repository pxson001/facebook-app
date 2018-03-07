package com.facebook.zero.notification;

import android.content.Context;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.iorg.common.zero.interfaces.ZeroFeatureVisibilityHelper;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: {  */
public class MessengerFreeDataNotification extends ZeroFreeDataNotificationBase {
    private static MessengerFreeDataNotification m118b(InjectorLike injectorLike) {
        return new MessengerFreeDataNotification((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3754), IdBasedProvider.a(injectorLike, 4034), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public MessengerFreeDataNotification(Context context, FbSharedPreferences fbSharedPreferences, FbBroadcastManager fbBroadcastManager, Lazy<ZeroFeatureVisibilityHelper> lazy, Provider<Boolean> provider, SecureContextHelper secureContextHelper) {
        super(context, fbSharedPreferences, fbBroadcastManager, lazy, provider, secureContextHelper);
    }
}
