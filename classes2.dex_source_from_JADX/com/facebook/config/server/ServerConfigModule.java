package com.facebook.config.server;

import com.facebook.config.application.FbAppType;
import com.facebook.config.application.IntendedAudience;
import com.facebook.http.annotations.BootstrapPlatformAppHttpConfig;
import com.facebook.http.annotations.ProductionPlatformAppHttpConfig;
import com.facebook.http.annotations.ShortUserAgentString;
import com.facebook.http.annotations.UserAgentString;
import com.facebook.http.config.PlatformAppHttpConfig;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.google.common.base.Objects;

@InjectorModule
/* compiled from: requests_dropped */
public class ServerConfigModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @IsInternalPrefsEnabled
    @ProviderMethod
    static Boolean m11750a() {
        return Boolean.valueOf(false);
    }

    @ProviderMethod
    @ShouldUsePreferredConfig
    public static Boolean m11752a(Boolean bool, FbAppType fbAppType) {
        boolean z = bool.booleanValue() || fbAppType.i != IntendedAudience.PUBLIC;
        return Boolean.valueOf(z);
    }

    @ProviderMethod
    static PlatformAppHttpConfig m11749a(ServerConfig serverConfig) {
        return serverConfig.mo1354a();
    }

    @ProviderMethod
    @ProductionPlatformAppHttpConfig
    public static PlatformAppHttpConfig m11753b(ServerConfig serverConfig) {
        return serverConfig.mo1355b();
    }

    @ProviderMethod
    @BootstrapPlatformAppHttpConfig
    public static PlatformAppHttpConfig m11754c(ServerConfig serverConfig) {
        return serverConfig.mo1356c();
    }

    @ProviderMethod
    @UserAgentString
    static String m11755d(ServerConfig serverConfig) {
        return serverConfig.mo1357d();
    }

    @ProviderMethod
    @ShortUserAgentString
    static String m11756e(ServerConfig serverConfig) {
        return serverConfig.mo1358e();
    }

    @IsRedirectToSandboxEnabled
    @ProviderMethod
    public static Boolean m11751a(FbSharedPreferences fbSharedPreferences) {
        boolean z = fbSharedPreferences.mo284a() && !Objects.equal(fbSharedPreferences.mo278a(InternalHttpPrefKeys.f2523r, "facebook.com"), "facebook.com");
        return Boolean.valueOf(z);
    }
}
