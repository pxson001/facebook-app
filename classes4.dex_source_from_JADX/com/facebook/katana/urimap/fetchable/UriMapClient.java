package com.facebook.katana.urimap.fetchable;

import android.content.Context;
import com.facebook.common.uri.UriTemplateMap;
import com.facebook.katana.service.AppSession;
import com.facebook.katana.urimap.api.UriHandler;
import com.facebook.manageddatastore.ManagedDataStore.Client;
import com.facebook.manageddatastore.NetworkRequestCallback;
import javax.annotation.Nullable;

/* compiled from: successful_processes */
public abstract class UriMapClient implements Client<Object, UriTemplateMap<UriHandler>> {
    protected abstract String mo106b();

    protected abstract String mo108c();

    protected abstract UriTemplateMapParser mo109d();

    public final /* synthetic */ Object mo110a(String str) {
        return m1804b(str);
    }

    public final UriTemplateMap<UriHandler> m1804b(String str) {
        return mo109d().m1792a(str);
    }

    public final void mo111a(Context context, @Nullable Object obj, NetworkRequestCallback<Object, UriTemplateMap<UriHandler>> networkRequestCallback) {
        1 1 = new 1(this, networkRequestCallback);
        networkRequestCallback.mo114b().a("requesting project name %s/map %s", new Object[]{mo106b(), mo108c()});
        AppSession a = AppSession.a(context, false);
        if (a != null) {
            FqlGetUserServerSettings.a(a, context, mo106b(), mo108c(), 1);
        }
    }

    public final boolean mo112a(@Nullable Object obj, Object obj2) {
        return true;
    }
}
