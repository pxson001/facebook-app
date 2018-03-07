package com.facebook.messaging.business.nativesignup.helpers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.business.nativesignup.model.NativeSignUpParams;
import com.facebook.messaging.model.threadkey.ThreadKey;
import javax.inject.Inject;

/* compiled from: mute_until_flat_buffer */
public class DefaultNativeSignUpResultHandler implements BusinessNativeSignUpResultHandler {
    private final Context f8867a;
    private final SecureContextHelper f8868b;

    public static DefaultNativeSignUpResultHandler m9146b(InjectorLike injectorLike) {
        return new DefaultNativeSignUpResultHandler((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public DefaultNativeSignUpResultHandler(Context context, SecureContextHelper secureContextHelper) {
        this.f8867a = context;
        this.f8868b = secureContextHelper;
    }

    public final String mo321a() {
        return "DefaultNativeSignUpResultHandler";
    }

    public final boolean mo323b(NativeSignUpParams nativeSignUpParams) {
        return false;
    }

    public final boolean mo322a(NativeSignUpParams nativeSignUpParams) {
        ThreadKey threadKey = nativeSignUpParams.f8888e;
        if (threadKey == null) {
            return false;
        }
        Uri parse = Uri.parse(StringFormatUtil.formatStrLocaleSafe(MessengerLinks.w, String.valueOf(threadKey.i())));
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        this.f8868b.a(intent, this.f8867a);
        return true;
    }
}
