package com.facebook.ssl;

import android.annotation.SuppressLint;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.ssl.verification.BadVerifyInvocationNotifier;
import com.facebook.ssl.verification.FbHostnameVerifier;
import com.facebook.ssl.verification.FbHostnameVerifierAdaptor;
import javax.inject.Singleton;
import javax.net.ssl.HostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

@InjectorModule
/* compiled from: confirmation_text */
public class SSLModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @SSLSessionTimeoutSeconds
    public static Integer m10196a() {
        return Integer.valueOf(86000);
    }

    @ProviderMethod
    @Singleton
    @SuppressLint({"ExplicitSimpleProvider"})
    static HostnameVerifier m10198b() {
        return new FbHostnameVerifier();
    }

    @ProviderMethod
    @Singleton
    @SuppressLint({"ExplicitSimpleProvider"})
    static X509HostnameVerifier m10197a(BadVerifyInvocationNotifier badVerifyInvocationNotifier) {
        return new FbHostnameVerifierAdaptor(badVerifyInvocationNotifier);
    }
}
