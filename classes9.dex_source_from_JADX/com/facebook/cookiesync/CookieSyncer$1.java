package com.facebook.cookiesync;

import com.facebook.cookiesync.CookieSyncUserDataEncryptionGraphQLModels.FetchEncrytedCookieSyncUserDataModel;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: place_tag_id */
public class CookieSyncer$1 implements FutureCallback<GraphQLResult<FetchEncrytedCookieSyncUserDataModel>> {
    final /* synthetic */ String f6556a;
    final /* synthetic */ CookieSyncer f6557b;

    public CookieSyncer$1(CookieSyncer cookieSyncer, String str) {
        this.f6557b = cookieSyncer;
        this.f6556a = str;
    }

    public void onSuccess(Object obj) {
        CookieSyncer.a(this.f6557b, this.f6556a, ((FetchEncrytedCookieSyncUserDataModel) ((GraphQLResult) obj).e).m6881a());
    }

    public void onFailure(Throwable th) {
        BLog.b(CookieSyncer.a, "Fetch encyrpted cookie sync user data failure.");
    }
}
