package com.facebook.orca.notify;

import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.config.application.Product;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.annotations.IsBadgeTrayNotificationsEnabled;
import com.facebook.messaging.annotations.IsMessengerAppIconBadgingEnabled;
import java.util.Locale;

@InjectorModule
/* compiled from: highlight_state */
public class MessagesNotificationModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsBadgeTrayNotificationsEnabled
    public static Boolean m11194a(Boolean bool) {
        boolean z = VERSION.SDK_INT <= 19 && bool.booleanValue();
        return Boolean.valueOf(z);
    }

    @ProviderMethod
    @IsMessengerAppIconBadgingEnabled
    public static Boolean m11193a(Product product, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        if (!bool.booleanValue() || product != Product.MESSENGER) {
            return Boolean.valueOf(false);
        }
        String str = Build.MANUFACTURER;
        if (str != null) {
            if (str.toLowerCase(Locale.US).contains("samsung")) {
                return Boolean.valueOf(true);
            }
            if (str.toLowerCase(Locale.US).contains("htc")) {
                return bool3;
            }
            if (str.toLowerCase(Locale.US).contains("sony")) {
                return bool2;
            }
            if (str.toLowerCase(Locale.US).contains("lg")) {
                return Boolean.valueOf(true);
            }
            if (str.toLowerCase(Locale.US).contains("asus")) {
                return bool4;
            }
        }
        return Boolean.valueOf(false);
    }
}
