package com.facebook.messaging.payment.config;

import com.facebook.config.application.Product;
import com.facebook.gk.internal.GkPrefKeys;
import com.facebook.messaging.payment.sync.model.PaymentsSyncPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;

/* compiled from: force_create_new_activity */
public class IsP2pPaymentsSyncProtocolEnabledProvider {
    public static Boolean m11959a(Product product, FbSharedPreferences fbSharedPreferences, Boolean bool) {
        if (product != Product.MESSENGER) {
            return Boolean.valueOf(false);
        }
        long a = fbSharedPreferences.a(PaymentsSyncPrefKeys.f11443b, -1);
        if (a > fbSharedPreferences.a(GkPrefKeys.c, -1)) {
            return Boolean.valueOf(false);
        }
        if (a == -1) {
            return bool;
        }
        fbSharedPreferences.edit().a(PaymentsSyncPrefKeys.f11443b).commit();
        return bool;
    }
}
