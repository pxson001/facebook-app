package com.facebook.platform.webdialogs;

import android.app.Activity;
import android.content.Intent;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.common.action.AbstractPlatformActionExecutor;
import com.facebook.platform.common.action.PlatformAppCall;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: location_instruction */
public class PlatformWebDialogsControllerImpl {
    private final PlatformWebDialogsPerformanceLogger f8489a;
    private final FbSharedPreferences f8490b;
    private final Provider<ViewerContext> f8491c;
    private final ObjectMapper f8492d;
    private final SecureContextHelper f8493e;
    private final Provider<String> f8494f;
    private final Provider<String> f8495g;
    private PlatformWebDialogsManifest f8496h;

    public static PlatformWebDialogsControllerImpl m8393b(InjectorLike injectorLike) {
        return new PlatformWebDialogsControllerImpl(PlatformWebDialogsPerformanceLogger.m8413a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 372), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), PlatformWebDialogsManifest.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), IdBasedProvider.a(injectorLike, 4441));
    }

    @Inject
    public PlatformWebDialogsControllerImpl(PlatformWebDialogsPerformanceLogger platformWebDialogsPerformanceLogger, FbSharedPreferences fbSharedPreferences, Provider<ViewerContext> provider, ObjectMapper objectMapper, SecureContextHelper secureContextHelper, PlatformWebDialogsManifest platformWebDialogsManifest, Provider<String> provider2, Provider<String> provider3) {
        this.f8489a = platformWebDialogsPerformanceLogger;
        this.f8490b = fbSharedPreferences;
        this.f8491c = provider;
        this.f8492d = objectMapper;
        this.f8493e = secureContextHelper;
        this.f8496h = platformWebDialogsManifest;
        this.f8494f = provider2;
        this.f8495g = provider3;
    }

    public final AbstractPlatformActionExecutor m8395a(Activity activity, Intent intent, PlatformAppCall platformAppCall) {
        boolean z = false;
        String str = platformAppCall.i;
        if (this.f8490b.a()) {
            z = this.f8490b.a(PlatformWebDialogsPrefKeys.c, false);
        }
        if (z) {
            this.f8496h.b();
        }
        if (this.f8496h.a(str) != null) {
            return m8394c(activity, intent, platformAppCall);
        }
        this.f8496h.a();
        return null;
    }

    public final AbstractPlatformActionExecutor m8396b(Activity activity, Intent intent, PlatformAppCall platformAppCall) {
        return m8394c(activity, intent, platformAppCall);
    }

    private PlatformWebDialogsActionExecutor m8394c(Activity activity, Intent intent, PlatformAppCall platformAppCall) {
        return new PlatformWebDialogsActionExecutor(this.f8489a, this.f8491c, this.f8492d, this.f8493e, activity, intent, platformAppCall, this.f8494f, this.f8495g);
    }
}
