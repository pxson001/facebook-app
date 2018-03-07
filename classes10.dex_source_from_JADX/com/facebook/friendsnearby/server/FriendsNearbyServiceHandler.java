package com.facebook.friendsnearby.server;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: ZERO_IP_TEST_ACTION */
public class FriendsNearbyServiceHandler implements BlueServiceHandler {
    private static volatile FriendsNearbyServiceHandler f20794d;
    public final Provider<SingleMethodRunner> f20795a;
    public final FriendsNearbyInviteMethod f20796b;
    public final FriendsNearbyDeleteInviteMethod f20797c;

    public static com.facebook.friendsnearby.server.FriendsNearbyServiceHandler m21687a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f20794d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friendsnearby.server.FriendsNearbyServiceHandler.class;
        monitor-enter(r1);
        r0 = f20794d;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m21688b(r0);	 Catch:{ all -> 0x0035 }
        f20794d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20794d;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsnearby.server.FriendsNearbyServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.friendsnearby.server.FriendsNearbyServiceHandler");
    }

    private static FriendsNearbyServiceHandler m21688b(InjectorLike injectorLike) {
        return new FriendsNearbyServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new FriendsNearbyInviteMethod(), new FriendsNearbyDeleteInviteMethod());
    }

    public static Bundle m21686a(String str, Parcelable parcelable) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(str, parcelable);
        return bundle;
    }

    @Inject
    public FriendsNearbyServiceHandler(Provider<SingleMethodRunner> provider, FriendsNearbyInviteMethod friendsNearbyInviteMethod, FriendsNearbyDeleteInviteMethod friendsNearbyDeleteInviteMethod) {
        this.f20795a = provider;
        this.f20796b = friendsNearbyInviteMethod;
        this.f20797c = friendsNearbyDeleteInviteMethod;
    }

    public final OperationResult m21689a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("send_invite".equals(str)) {
            OperationResult operationResult;
            if (((Boolean) ((AbstractSingleMethodRunner) this.f20795a.get()).a(this.f20796b, (FriendsNearbyInviteParams) operationParams.c.getParcelable("friendsNearbyInviteParams"))).booleanValue()) {
                operationResult = OperationResult.a;
            } else {
                operationResult = OperationResult.a(ErrorCode.API_ERROR);
            }
            return operationResult;
        } else if ("delete_invite".equals(str)) {
            ((AbstractSingleMethodRunner) this.f20795a.get()).a(this.f20797c, (FriendsNearbyDeleteInviteParams) operationParams.c.getParcelable("friendsNearbyDeleteInviteParams"));
            return OperationResult.a;
        } else {
            throw new IllegalArgumentException("unknown operation type: " + str);
        }
    }
}
