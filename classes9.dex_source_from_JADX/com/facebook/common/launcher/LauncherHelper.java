package com.facebook.common.launcher;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.SecureContextHelper;
import javax.inject.Inject;

/* compiled from: public_key */
public class LauncherHelper {
    private final SecureContextHelper f5989a;

    @Inject
    public LauncherHelper(SecureContextHelper secureContextHelper) {
        this.f5989a = secureContextHelper;
    }

    public final void m6313a(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        this.f5989a.b(intent, context);
    }
}
