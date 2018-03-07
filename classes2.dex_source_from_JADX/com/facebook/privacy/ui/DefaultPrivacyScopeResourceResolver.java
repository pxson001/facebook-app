package com.facebook.privacy.ui;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
/* compiled from: network_info_req_bw_ingress_avg */
public class DefaultPrivacyScopeResourceResolver {
    private static final Map<String, Integer> f12516a = ImmutableMap.builder().m609b("acquaintances", Integer.valueOf(2130842742)).m609b("close_friends", Integer.valueOf(2130842743)).m609b("custom", Integer.valueOf(2130842744)).m609b("event", Integer.valueOf(2130842745)).m609b("everyone", Integer.valueOf(2130842746)).m609b("facebook", Integer.valueOf(2130842747)).m609b("family_list", Integer.valueOf(2130842748)).m609b("friends", Integer.valueOf(2130842749)).m609b("friends_except_acquaintances", Integer.valueOf(2130842750)).m609b("friends_of_friends", Integer.valueOf(2130842751)).m609b("generic_list", Integer.valueOf(2130842755)).m609b("group", Integer.valueOf(2130842754)).m609b("list_members", Integer.valueOf(2130842755)).m609b("location_list", Integer.valueOf(2130842756)).m609b("only_me", Integer.valueOf(2130842757)).m609b("school_list", Integer.valueOf(2130842758)).m609b("school_group", Integer.valueOf(2130842758)).m609b("work_list", Integer.valueOf(2130842759)).m609b("good_friends", Integer.valueOf(2130842753)).m610b();
    private static volatile DefaultPrivacyScopeResourceResolver f12517b;

    public static com.facebook.privacy.ui.DefaultPrivacyScopeResourceResolver m18602a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f12517b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.privacy.ui.DefaultPrivacyScopeResourceResolver.class;
        monitor-enter(r1);
        r0 = f12517b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m18601a();	 Catch:{ all -> 0x0034 }
        f12517b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f12517b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.ui.DefaultPrivacyScopeResourceResolver.a(com.facebook.inject.InjectorLike):com.facebook.privacy.ui.DefaultPrivacyScopeResourceResolver");
    }

    private static DefaultPrivacyScopeResourceResolver m18601a() {
        return new DefaultPrivacyScopeResourceResolver();
    }

    public final int m18603a(String str) {
        Integer num = (Integer) f12516a.get(str);
        return num != null ? num.intValue() : 2130842744;
    }
}
