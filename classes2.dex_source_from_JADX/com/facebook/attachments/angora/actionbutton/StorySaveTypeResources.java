package com.facebook.attachments.angora.actionbutton;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.graphql.enums.GraphQLStorySaveType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: neue/ */
public class StorySaveTypeResources {
    public static final String f12400a = StorySaveTypeResources.class.getSimpleName();
    private static volatile StorySaveTypeResources f12401d;
    public final ImmutableMap<GraphQLStorySaveType, StorySaveTypeResource> f12402b = new Builder().m609b(GraphQLStorySaveType.LINK, new StorySaveTypeResource(2131237659, 2131237672, 2131237683, 2131237696)).m609b(GraphQLStorySaveType.VIDEO, new StorySaveTypeResource(2131237660, 2131237673, 2131237684, 2131237697)).m609b(GraphQLStorySaveType.PLACE, new StorySaveTypeResource(2131237661, 2131237674, 2131237685, 2131237698)).m609b(GraphQLStorySaveType.PAGE, new StorySaveTypeResource(2131237662, 2131237675, 2131237686, 2131237699)).m609b(GraphQLStorySaveType.MUSIC, new StorySaveTypeResource(2131237663, 2131237676, 2131237687, 2131237700)).m609b(GraphQLStorySaveType.BOOK, new StorySaveTypeResource(2131237664, 2131237677, 2131237688, 2131237701)).m609b(GraphQLStorySaveType.MOVIE, new StorySaveTypeResource(2131237665, 2131237678, 2131237689, 2131237702)).m609b(GraphQLStorySaveType.TV_SHOW, new StorySaveTypeResource(2131237666, 2131237679, 2131237690, 2131237703)).m609b(GraphQLStorySaveType.EVENT, new StorySaveTypeResource(2131237667, 2131237680, 2131237691, 2131237704)).m609b(GraphQLStorySaveType.POST, new StorySaveTypeResource(2131237668, 2131237682, 2131237692, 2131237706)).m609b(GraphQLStorySaveType.PHOTO, new StorySaveTypeResource(2131237669, 2131237681, 2131237693, 2131237705)).m609b(GraphQLStorySaveType.PHOTOS, new StorySaveTypeResource(2131237670, 2131237681, 2131237694, 2131237705)).m609b(GraphQLStorySaveType.GENERIC, new StorySaveTypeResource(2131237671, 2131237682, 2131237695, 2131237706)).m610b();
    public final AbstractFbErrorReporter f12403c;

    /* compiled from: neue/ */
    public class StorySaveTypeResource {
        public final int f12404a;
        public final int f12405b;
        public final int f12406c;
        public final int f12407d;

        public StorySaveTypeResource(int i, int i2, int i3, int i4) {
            this.f12404a = i;
            this.f12405b = i2;
            this.f12406c = i3;
            this.f12407d = i4;
        }
    }

    public static com.facebook.attachments.angora.actionbutton.StorySaveTypeResources m18473a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12401d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.attachments.angora.actionbutton.StorySaveTypeResources.class;
        monitor-enter(r1);
        r0 = f12401d;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m18474b(r0);	 Catch:{ all -> 0x0035 }
        f12401d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12401d;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.attachments.angora.actionbutton.StorySaveTypeResources.a(com.facebook.inject.InjectorLike):com.facebook.attachments.angora.actionbutton.StorySaveTypeResources");
    }

    private static StorySaveTypeResources m18474b(InjectorLike injectorLike) {
        return new StorySaveTypeResources(FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public StorySaveTypeResources(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12403c = abstractFbErrorReporter;
    }
}
