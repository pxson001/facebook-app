package com.facebook.katana.webview;

import android.content.Context;
import android.os.Bundle;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.FbInjector;
import com.facebook.katana.features.faceweb.FacewebComponentsStore;
import com.facebook.katana.webview.FacewebComponentsStoreCache.Key;
import com.facebook.katana.webview.FacewebComponentsStoreCache.LoadError;
import com.facebook.katana.webview.FacewebComponentsStoreCache.Value;
import com.facebook.manageddatastore.ManagedDataStore.Client;
import com.facebook.manageddatastore.NetworkRequestCallback;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;

/* compiled from: timeline_optimistic_post_failed */
class FacewebComponentsStoreCacheClient implements Client<Key, Value> {
    private FbObjectMapper f1259a;
    private AbstractFbErrorReporter f1260b;

    public final String m1301a(Object obj) {
        return ((Key) obj).toString();
    }

    public final void m1302a(Context context, Object obj, NetworkRequestCallback networkRequestCallback) {
        Key key = (Key) obj;
        synchronized (this) {
            if (LoggedInUserSessionManager.a(FbInjector.get(context)).b()) {
                BlueServiceOperationFactoryDetour.a(DefaultBlueServiceOperationFactory.b(FbInjector.get(context)), "fetchFwComponents", new Bundle(), -470525393).a();
            } else {
                networkRequestCallback.a(context, false, key, null, new Value(LoadError.NO_SESSION_ERROR, ""));
            }
        }
    }

    public FacewebComponentsStoreCacheClient(Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        this.f1259a = FbObjectMapperMethodAutoProvider.a(fbInjector);
        this.f1260b = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
    }

    public final String m1300a() {
        return FacewebComponentsStoreCache.class.getSimpleName();
    }

    public final Object m1299a(String str) {
        try {
            return new Value(FacewebComponentsStore.a(str, this.f1259a));
        } catch (Throwable e) {
            Throwable th = e;
            this.f1260b.a("FacewebComponentStore", "Failed to deserialize", th);
            return new Value(LoadError.DESERIALIZATION_ERROR, th.getMessage());
        }
    }

    public final boolean m1303a(Object obj, Object obj2) {
        return true;
    }

    public final int m1304b(Object obj, Object obj2) {
        return 3600;
    }

    public final int m1305c(Object obj, Object obj2) {
        return 3600;
    }
}
