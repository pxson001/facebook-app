package com.facebook.messaging.business.common.calltoaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.business.common.calltoaction.CallToActionContainerView.C09981.C09971;
import com.facebook.messaging.business.common.calltoaction.model.CallToAction;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.xma.XMAAction;
import com.facebook.messaging.xma.XMAActionHandler;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: newBuilder */
public final class CallToActionXMAHandler implements XMAActionHandler<Message> {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<BusinessUriMapper> f8729a = UltralightRuntime.b;
    private final CallToActionAnalyticsLogger f8730b;
    private final Set<CallToActionTypeHandler> f8731c;

    public static CallToActionXMAHandler m8934a(InjectorLike injectorLike) {
        CallToActionXMAHandler callToActionXMAHandler = new CallToActionXMAHandler(new CallToActionAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike)), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$CallToActionTypeHandler(injectorLike)));
        callToActionXMAHandler.f8729a = IdBasedLazy.a(injectorLike, 7623);
        return callToActionXMAHandler;
    }

    public final boolean m8936a(Object obj, XMAAction xMAAction, View view) {
        String str;
        String str2;
        Message message = (Message) obj;
        boolean z = xMAAction.a == null || (xMAAction.a instanceof C09971);
        Preconditions.checkState(z);
        Bundle bundle = (Bundle) xMAAction.a("extra_cta_clicked");
        CallToAction callToAction = (CallToAction) bundle.getParcelable("cta");
        String string = bundle.getString("native_link");
        String string2 = bundle.getString("fallback_url");
        if (!(m8935a(callToAction, message.b, xMAAction.a) || Strings.isNullOrEmpty(string2))) {
            ((BusinessUriMapper) this.f8729a.get()).m8918a(string == null ? null : Uri.parse(string), Uri.parse(string2), message.b);
        }
        CallToActionAnalyticsLogger callToActionAnalyticsLogger = this.f8730b;
        string = callToAction == null ? "" : callToAction.a();
        if (callToAction == null) {
            string2 = "";
        } else {
            string2 = callToAction.f;
        }
        if (callToAction == null || callToAction.b == null) {
            str = "";
        } else {
            str = callToAction.b.name();
        }
        if (callToAction == null || callToAction.a == null) {
            str2 = "";
        } else {
            str2 = callToAction.a.toString();
        }
        callToActionAnalyticsLogger.m8926a(string, string2, str, str2, bundle.getString("target_id"), message.a, Long.toString(message.b.i()), message.N, message.M);
        return true;
    }

    @Inject
    public CallToActionXMAHandler(CallToActionAnalyticsLogger callToActionAnalyticsLogger, Set<CallToActionTypeHandler> set) {
        this.f8730b = callToActionAnalyticsLogger;
        this.f8731c = set;
    }

    public static Bundle m8933a(@Nullable CallToAction callToAction, @Nullable Uri uri, @Nullable Uri uri2, String str) {
        Preconditions.checkNotNull(str);
        boolean z = (callToAction == null && uri2 == null) ? false : true;
        Preconditions.checkState(z);
        Bundle bundle = new Bundle();
        bundle.putString("target_id", str);
        if (callToAction != null) {
            String str2;
            bundle.putParcelable("cta", callToAction);
            String str3 = "fallback_url";
            if (callToAction.a == null) {
                str2 = "";
            } else {
                str2 = callToAction.a.toString();
            }
            bundle.putString(str3, str2);
        } else {
            if (uri != null) {
                bundle.putString("native_link", uri.toString());
            }
            bundle.putString("fallback_url", uri2.toString());
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("extra_cta_clicked", bundle);
        return bundle2;
    }

    private boolean m8935a(@Nullable CallToAction callToAction, @Nullable ThreadKey threadKey, @Nullable C09971 c09971) {
        if (callToAction == null || callToAction.b == null || Strings.isNullOrEmpty(callToAction.a()) || threadKey == null) {
            return false;
        }
        for (CallToActionTypeHandler a : this.f8731c) {
            if (a.mo319a(callToAction, threadKey, c09971)) {
                return true;
            }
        }
        return false;
    }
}
