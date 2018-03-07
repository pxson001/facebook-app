package com.facebook.fbreact.persistedqueries;

import com.facebook.catalyst.modules.persistedqueries.RelayPersistedQueriesPreloader.PersistedQueryRequestCallback;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiResponse;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: squareProfilePicUrl */
public class Fb4aPersistedQueryRequestSender {
    public static final CallerContext f3517a = CallerContext.a(Fb4aPersistedQueryRequestSender.class);
    public final RelayPersistedQueriesPreloaderMethod f3518b;
    public final AbstractSingleMethodRunner f3519c;
    private final ListeningExecutorService f3520d;

    @Inject
    public Fb4aPersistedQueryRequestSender(RelayPersistedQueriesPreloaderMethod relayPersistedQueriesPreloaderMethod, AbstractSingleMethodRunner abstractSingleMethodRunner, ListeningExecutorService listeningExecutorService) {
        this.f3518b = relayPersistedQueriesPreloaderMethod;
        this.f3519c = abstractSingleMethodRunner;
        this.f3520d = listeningExecutorService;
    }

    public final void m4209a(final String str, final String str2, final PersistedQueryRequestCallback persistedQueryRequestCallback) {
        Futures.a(this.f3520d.a(new Callable<ApiResponse>(this) {
            final /* synthetic */ Fb4aPersistedQueryRequestSender f3513c;

            public Object call() {
                Map hashMap = new HashMap();
                hashMap.put("queries", str2);
                hashMap.put("entryName", str);
                return (ApiResponse) this.f3513c.f3519c.a(this.f3513c.f3518b, hashMap, Fb4aPersistedQueryRequestSender.f3517a);
            }
        }), new FutureCallback<ApiResponse>(this) {
            final /* synthetic */ Fb4aPersistedQueryRequestSender f3516c;

            public void onSuccess(Object obj) {
                try {
                    persistedQueryRequestCallback.m1057a(str, ((ApiResponse) obj).f().toString());
                } catch (Throwable e) {
                    persistedQueryRequestCallback.m1058a(str, e);
                }
            }

            public void onFailure(Throwable th) {
                persistedQueryRequestCallback.m1058a(str, th);
            }
        });
    }
}
