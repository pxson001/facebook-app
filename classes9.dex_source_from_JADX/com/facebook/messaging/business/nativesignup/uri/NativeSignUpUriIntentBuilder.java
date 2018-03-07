package com.facebook.messaging.business.nativesignup.uri;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.business.nativesignup.helpers.DefaultNativeSignUpResultHandler;
import com.facebook.messaging.business.nativesignup.model.NativeSignUpParams;
import com.facebook.messaging.business.nativesignup.model.NativeSignUpParams.NativeSignUpParamsBuilder;
import com.facebook.messaging.business.nativesignup.view.BusinessSignUpFragment;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: multipart/* */
public class NativeSignUpUriIntentBuilder extends UriIntentBuilder {
    public final Provider<String> f8919a;
    public final DefaultNativeSignUpResultHandler f8920b;

    /* compiled from: multipart/* */
    class NativeSignUpViewUriIntentBuilder implements IUriTemplateIntentBuilder {
        final /* synthetic */ NativeSignUpUriIntentBuilder f8918a;

        public NativeSignUpViewUriIntentBuilder(NativeSignUpUriIntentBuilder nativeSignUpUriIntentBuilder) {
            this.f8918a = nativeSignUpUriIntentBuilder;
        }

        public final Intent m9174a(Context context, Bundle bundle) {
            ThreadKey threadKey = null;
            if (bundle.get("provider_name") == null) {
                return null;
            }
            if (!Strings.isNullOrEmpty(bundle.getString("provider_page_fbid"))) {
                threadKey = ThreadKey.a(Long.parseLong(bundle.getString("provider_page_fbid")), Long.parseLong((String) this.f8918a.f8919a.get()));
            }
            NativeSignUpParamsBuilder newBuilder = NativeSignUpParams.newBuilder();
            newBuilder.f8877a = bundle.getString("provider_name");
            newBuilder = newBuilder;
            newBuilder.f8878b = this.f8918a.f8920b.mo321a();
            newBuilder = newBuilder;
            newBuilder.f8879c = "native_sign_up_uri";
            newBuilder = newBuilder;
            newBuilder.f8881e = threadKey;
            return BusinessSignUpFragment.m9267a(context, newBuilder.m9162h());
        }
    }

    @Inject
    public NativeSignUpUriIntentBuilder(Provider<String> provider, DefaultNativeSignUpResultHandler defaultNativeSignUpResultHandler) {
        this.f8919a = provider;
        this.f8920b = defaultNativeSignUpResultHandler;
        a(StringFormatUtil.formatStrLocaleSafe(MessengerLinks.Q, "{provider_name}", "{provider_page_fbid}"), new NativeSignUpViewUriIntentBuilder(this));
    }
}
