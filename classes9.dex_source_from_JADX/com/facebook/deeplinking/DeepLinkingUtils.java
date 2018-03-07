package com.facebook.deeplinking;

import android.content.Intent;
import android.net.Uri;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.deeplinking.logging.DeepLinkLoggingUtils;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: photo_vault */
public class DeepLinkingUtils {
    private final DeepLinkLoggingUtils f6600a;
    private final SecureContextHelper f6601b;

    public static DeepLinkingUtils m6909b(InjectorLike injectorLike) {
        return new DeepLinkingUtils(DeepLinkLoggingUtils.m6945b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public DeepLinkingUtils(DeepLinkLoggingUtils deepLinkLoggingUtils, SecureContextHelper secureContextHelper) {
        this.f6600a = deepLinkLoggingUtils;
        this.f6601b = secureContextHelper;
    }

    @Nullable
    public static Intent m6908b(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        return intent;
    }

    @Nullable
    public final Intent m6910a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return m6908b(Uri.parse(str));
    }
}
