package com.facebook.messaging.sync.util;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.attachment.VideoData.Source;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threadkey.DefaultThreadKeyFactory;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: possible_post_permission_settings */
public class ThriftModelUtil {
    private static final ImmutableMap<Integer, String> f4704a = new Builder().b(Integer.valueOf(0), "invalid").b(Integer.valueOf(1), "inbox").b(Integer.valueOf(2), "other").b(Integer.valueOf(3), "spam").b();
    private static volatile ThriftModelUtil f4705c;
    private final DefaultThreadKeyFactory f4706b;

    public static com.facebook.messaging.sync.util.ThriftModelUtil m4260a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f4705c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sync.util.ThriftModelUtil.class;
        monitor-enter(r1);
        r0 = f4705c;	 Catch:{ all -> 0x003a }
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
        r0 = m4261b(r0);	 Catch:{ all -> 0x0035 }
        f4705c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4705c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.util.ThriftModelUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.util.ThriftModelUtil");
    }

    private static ThriftModelUtil m4261b(InjectorLike injectorLike) {
        return new ThriftModelUtil(DefaultThreadKeyFactory.b(injectorLike));
    }

    @Inject
    public ThriftModelUtil(DefaultThreadKeyFactory defaultThreadKeyFactory) {
        this.f4706b = defaultThreadKeyFactory;
    }

    public final ThreadKey m4262a(com.facebook.messaging.sync.model.thrift.ThreadKey threadKey) {
        if (threadKey.otherUserFbId != null) {
            return this.f4706b.a(threadKey.otherUserFbId.longValue());
        }
        return ThreadKey.a(threadKey.threadFbId.longValue());
    }

    public final ImmutableList<ThreadKey> m4263a(List<com.facebook.messaging.sync.model.thrift.ThreadKey> list) {
        if (list == null || list.isEmpty()) {
            return RegularImmutableList.a;
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (com.facebook.messaging.sync.model.thrift.ThreadKey a : list) {
            builder.c(m4262a(a));
        }
        return builder.b();
    }

    public static FolderName m4259a(int i) {
        return FolderName.fromDbName((String) f4704a.get(Integer.valueOf(i)));
    }

    public static Source m4258a(Integer num) {
        if (num == null) {
            return Source.NONQUICKCAM;
        }
        if (num.intValue() == 2) {
            return Source.QUICKCAM;
        }
        return Source.NONQUICKCAM;
    }
}
