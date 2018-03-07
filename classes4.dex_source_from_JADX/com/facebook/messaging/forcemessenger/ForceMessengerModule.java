package com.facebook.messaging.forcemessenger;

import com.facebook.common.util.TriState;
import com.facebook.config.application.Product;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.annotations.DisableMessagingBackgroundTasks;
import com.facebook.messaging.annotations.IsShouldRedirectToMessenger;
import com.facebook.messaging.forcemessenger.annotations.IsInAccountSwitchingDiode;
import com.facebook.messaging.forcemessenger.annotations.IsUserInDiode;
import com.facebook.prefs.shared.FbSharedPreferences;

@InjectorModule
/* compiled from: ja@collation=phonebook */
public class ForceMessengerModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsUserInDiode
    public static Boolean m10160a(FbSharedPreferences fbSharedPreferences, GatekeeperStoreImpl gatekeeperStoreImpl) {
        boolean z = true;
        boolean a = gatekeeperStoreImpl.a(57, false);
        if (fbSharedPreferences.a(ForceMessengerPrefKeys.f9725c)) {
            TriState fromDbValue = TriState.fromDbValue(Integer.parseInt(fbSharedPreferences.a(ForceMessengerPrefKeys.f9725c, String.valueOf(TriState.UNSET.getDbValue()))));
            if (a) {
                z = false;
            }
            return Boolean.valueOf(fromDbValue.asBoolean(z));
        }
        if (a) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    @ProviderMethod
    @IsInAccountSwitchingDiode
    public static Boolean m10158a(GatekeeperStoreImpl gatekeeperStoreImpl) {
        return Boolean.valueOf(gatekeeperStoreImpl.a(152, false));
    }

    @ProviderMethod
    @IsShouldRedirectToMessenger
    public static Boolean m10159a(ForceMessenger forceMessenger) {
        return Boolean.valueOf(forceMessenger.m8015a(TriState.UNSET, true));
    }

    @ProviderMethod
    @DisableMessagingBackgroundTasks
    public static Boolean m10157a(Product product) {
        return Boolean.valueOf(product == Product.FB4A);
    }
}
