package com.facebook.crudolib.netmodule;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.crudolib.net.CrudoNet;
import com.facebook.crudolib.net.CrudoNet.Builder;
import com.facebook.crudolib.net.RequestFactory;
import com.facebook.crudolib.netengine.fbhttp.FbHttpEngine;
import com.facebook.crudolib.netfb.EndpointSelector;
import com.facebook.crudolib.netfb.FbRequestFactory;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.shared.FbSharedPreferences;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: Threads Fetch Caller */
public class CrudoNetModule extends AbstractLibraryModule {

    /* compiled from: Threads Fetch Caller */
    public final class C29121 {
        public final /* synthetic */ Provider f24117a;

        C29121(Provider provider) {
            this.f24117a = provider;
        }
    }

    /* compiled from: Threads Fetch Caller */
    public final class C29132 {
        public final /* synthetic */ Provider f24118a;

        C29132(Provider provider) {
            this.f24118a = provider;
        }
    }

    /* compiled from: Threads Fetch Caller */
    public final class C29143 implements EndpointSelector {
        public final /* synthetic */ FbSharedPreferences f24119a;

        C29143(FbSharedPreferences fbSharedPreferences) {
            this.f24119a = fbSharedPreferences;
        }

        public final String mo1121a() {
            return "https";
        }

        public final String mo1122a(String str) {
            String a;
            StringBuilder append = new StringBuilder().append(str).append(".");
            if (this.f24119a.a()) {
                a = this.f24119a.a(InternalHttpPrefKeys.r, "facebook.com");
            } else {
                a = "facebook.com";
            }
            return append.append(a).toString();
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static CrudoNet m26067a(ExecutorService executorService, FbHttpEngine fbHttpEngine) {
        Builder builder = new Builder();
        builder.f24027b = executorService;
        builder = builder;
        builder.f24026a = fbHttpEngine;
        builder = builder;
        builder.f24028c = false;
        return new CrudoNet(builder);
    }

    @ProviderMethod
    @Singleton
    static RequestFactory m26068a(CrudoNet crudoNet, Provider<String> provider) {
        RequestFactory.Builder builder = new RequestFactory.Builder(crudoNet);
        builder.f24039c = new C29121(provider);
        return builder.m25973b();
    }

    @ProviderMethod
    @Singleton
    static FbRequestFactory m26070a(RequestFactory requestFactory, Provider<ViewerContext> provider, EndpointSelector endpointSelector) {
        FbRequestFactory.Builder builder = new FbRequestFactory.Builder(requestFactory);
        builder.f24107d = new RequestMapperHack();
        builder = builder;
        builder.f24106c = endpointSelector;
        builder = builder;
        builder.f24105b = new C29132(provider);
        return new FbRequestFactory(builder);
    }

    @ProviderMethod
    @Singleton
    static EndpointSelector m26069a(FbSharedPreferences fbSharedPreferences) {
        return new C29143(fbSharedPreferences);
    }
}
