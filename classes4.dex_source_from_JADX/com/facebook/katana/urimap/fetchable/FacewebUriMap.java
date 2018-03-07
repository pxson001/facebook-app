package com.facebook.katana.urimap.fetchable;

import android.content.ComponentName;
import android.content.Context;
import com.facebook.common.uri.UriTemplateMap;
import com.facebook.inject.FbInjector;
import com.facebook.katana.urimap.api.UriHandler;
import com.facebook.manageddatastore.ManagedDataStore;
import com.facebook.manageddatastore.ManagedDataStore.Mode;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

/* compiled from: suffix */
public class FacewebUriMap {
    public static final Map<String, String> f1575a = new C00861();
    protected static ManagedDataStore<Object, UriTemplateMap<UriHandler>> f1576b;

    /* compiled from: suffix */
    final class C00861 extends LinkedHashMap<String, String> {
        C00861() {
        }
    }

    /* compiled from: suffix */
    public class FacewebUriHandler {
        public final String f2007a;
        public final Provider<ComponentName> f2008b;

        public FacewebUriHandler(Provider<ComponentName> provider, String str) {
            this.f2007a = str;
            this.f2008b = provider;
        }
    }

    public static ManagedDataStore<Object, UriTemplateMap<UriHandler>> m1793b(Context context) {
        if (f1576b == null) {
            f1576b = new ManagedDataStore(new FacewebUriMapClient(C0085x28de9b83.m1788b(FbInjector.get(context))), Mode.SINGLE_REQUEST, context);
        }
        return f1576b;
    }
}
