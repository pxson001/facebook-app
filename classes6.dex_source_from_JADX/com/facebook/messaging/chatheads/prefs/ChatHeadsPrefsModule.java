package com.facebook.messaging.chatheads.prefs;

import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.facebook.config.application.Product;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.chatheads.annotations.DefaultIsChatHeadsEnabled;
import com.facebook.messaging.chatheads.annotations.IsChatHeadDebugShadingEnabled;
import com.facebook.messaging.chatheads.annotations.IsChatHeadsEnabled;
import com.facebook.messaging.chatheads.annotations.IsChatHeadsNYConfettiGlobeEnabled;
import com.facebook.messaging.chatheads.annotations.IsChatHeadsPermitted;
import com.facebook.messaging.chatheads.annotations.IsPrimaryChatHeadsEnabled;
import com.facebook.prefs.shared.FbSharedPreferences;
import java.util.Calendar;
import javax.inject.Provider;

@InjectorModule
/* compiled from: is_sponsored_nested_story_length */
public class ChatHeadsPrefsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsChatHeadsEnabled
    public static Boolean m18912a(Provider<Boolean> provider) {
        return (Boolean) provider.get();
    }

    @ProviderMethod
    @DefaultIsChatHeadsEnabled
    public static Boolean m18911a(FbSharedPreferences fbSharedPreferences, Provider<Boolean> provider) {
        boolean z = ((Boolean) provider.get()).booleanValue() && fbSharedPreferences.a(ChatHeadsPrefKeys.d, true);
        return Boolean.valueOf(z);
    }

    @ProviderMethod
    @IsPrimaryChatHeadsEnabled
    public static Boolean m18913b(FbSharedPreferences fbSharedPreferences, Provider<Boolean> provider) {
        return Boolean.valueOf(fbSharedPreferences.a(ChatHeadsPrefKeys.e, ((Boolean) provider.get()).booleanValue()));
    }

    @ProviderMethod
    @IsChatHeadsPermitted
    public static Boolean m18909a(IsChatHeadsPermittedProvider isChatHeadsPermittedProvider) {
        boolean z = false;
        if (isChatHeadsPermittedProvider.f11997d.j == Product.MESSENGER && isChatHeadsPermittedProvider.f11996c.booleanValue() && (VERSION.SDK_INT >= 23 || isChatHeadsPermittedProvider.f11995b.checkCallingOrSelfPermission("android.permission.SYSTEM_ALERT_WINDOW") != -1)) {
            Object obj;
            DisplayMetrics displayMetrics = isChatHeadsPermittedProvider.f11998e.getDisplayMetrics();
            int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            int max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            int dimensionPixelSize = isChatHeadsPermittedProvider.f11998e.getDimensionPixelSize(2131427734);
            int dimensionPixelSize2 = isChatHeadsPermittedProvider.f11998e.getDimensionPixelSize(2131427735);
            if (min < dimensionPixelSize || max < dimensionPixelSize2) {
                new StringBuilder("screen size not supported: ").append(displayMetrics.widthPixels).append(",").append(displayMetrics.heightPixels);
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                z = true;
            }
        }
        return Boolean.valueOf(z);
    }

    @ProviderMethod
    @IsChatHeadsNYConfettiGlobeEnabled
    static Boolean m18908a(IsChatHeadsNYConfettiGlobeEnabledProvider isChatHeadsNYConfettiGlobeEnabledProvider) {
        boolean z;
        if (((Boolean) isChatHeadsNYConfettiGlobeEnabledProvider.f11993a.get()).booleanValue()) {
            Calendar instance = Calendar.getInstance();
            instance.add(12, 30);
            if (instance.get(1) > 2010 && instance.get(2) == 0 && instance.get(5) == 1 && instance.get(11) < 12) {
                z = true;
                return Boolean.valueOf(z);
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }

    @ProviderMethod
    @IsChatHeadDebugShadingEnabled
    static Boolean m18910a(FbSharedPreferences fbSharedPreferences) {
        return Boolean.valueOf(fbSharedPreferences.a(ChatHeadsPrefKeys.k, false));
    }
}
