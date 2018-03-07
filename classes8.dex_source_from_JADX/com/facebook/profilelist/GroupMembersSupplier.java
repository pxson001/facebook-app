package com.facebook.profilelist;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.tagging.protocol.FetchGroupMembersParams;
import com.facebook.tagging.protocol.FetchGroupMembersParams.Builder;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: removing all MessageReceivedCallbacks */
public class GroupMembersSupplier implements ProfilesSupplier {
    public static final Comparator<FacebookProfile> f4558a = new C05981();
    private static volatile GroupMembersSupplier f4559d;
    private final DefaultBlueServiceOperationFactory f4560b;
    public long f4561c = 0;

    /* compiled from: removing all MessageReceivedCallbacks */
    final class C05981 implements Comparator<FacebookProfile> {
        C05981() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((FacebookProfile) obj).mDisplayName.compareTo(((FacebookProfile) obj2).mDisplayName);
        }
    }

    /* compiled from: removing all MessageReceivedCallbacks */
    class C05992 implements Function<OperationResult, List<FacebookProfile>> {
        final /* synthetic */ GroupMembersSupplier f4557a;

        C05992(GroupMembersSupplier groupMembersSupplier) {
            this.f4557a = groupMembersSupplier;
        }

        public Object apply(Object obj) {
            List i = ((OperationResult) obj).i();
            Collections.sort(i, GroupMembersSupplier.f4558a);
            return i;
        }
    }

    public static com.facebook.profilelist.GroupMembersSupplier m4421a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4559d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.profilelist.GroupMembersSupplier.class;
        monitor-enter(r1);
        r0 = f4559d;	 Catch:{ all -> 0x003a }
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
        r0 = m4422b(r0);	 Catch:{ all -> 0x0035 }
        f4559d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4559d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.profilelist.GroupMembersSupplier.a(com.facebook.inject.InjectorLike):com.facebook.profilelist.GroupMembersSupplier");
    }

    private static GroupMembersSupplier m4422b(InjectorLike injectorLike) {
        return new GroupMembersSupplier(DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public GroupMembersSupplier(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f4560b = defaultBlueServiceOperationFactory;
    }

    public final ListenableFuture<List<FacebookProfile>> mo213a(Optional<String> optional) {
        if (!optional.isPresent()) {
            return Futures.a(Lists.a());
        }
        Builder builder = new Builder();
        builder.a = this.f4561c;
        Builder builder2 = builder;
        builder2.b = (String) optional.orNull();
        builder = builder2;
        Parcelable fetchGroupMembersParams = new FetchGroupMembersParams(builder.a, builder.b, builder.c);
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetch_group_members_params", fetchGroupMembersParams);
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f4560b, "fetch_group_members", bundle, -529277495).a(), new C05992(this), MoreExecutors.a());
    }

    public final boolean mo214a() {
        return false;
    }
}
