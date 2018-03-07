package com.facebook.reaction.feed.unitcomponents.spec.header;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionOnClickDelegateComponent;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LayoutSpec
/* compiled from: ^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{8})$ */
public class ReactionIconHeaderComponentSpec {
    public static final CallerContext f20478a = CallerContext.a(ReactionIconHeaderComponent.class);
    private static volatile ReactionIconHeaderComponentSpec f20479d;
    public final FbDraweeControllerBuilder f20480b;
    public final ReactionOnClickDelegateComponent f20481c;

    public static com.facebook.reaction.feed.unitcomponents.spec.header.ReactionIconHeaderComponentSpec m24250a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20479d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.header.ReactionIconHeaderComponentSpec.class;
        monitor-enter(r1);
        r0 = f20479d;	 Catch:{ all -> 0x003a }
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
        r0 = m24251b(r0);	 Catch:{ all -> 0x0035 }
        f20479d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20479d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.header.ReactionIconHeaderComponentSpec.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.header.ReactionIconHeaderComponentSpec");
    }

    private static ReactionIconHeaderComponentSpec m24251b(InjectorLike injectorLike) {
        return new ReactionIconHeaderComponentSpec(FbDraweeControllerBuilder.b(injectorLike), ReactionOnClickDelegateComponent.m24149a(injectorLike));
    }

    @Inject
    public ReactionIconHeaderComponentSpec(FbDraweeControllerBuilder fbDraweeControllerBuilder, ReactionOnClickDelegateComponent reactionOnClickDelegateComponent) {
        this.f20480b = fbDraweeControllerBuilder;
        this.f20481c = reactionOnClickDelegateComponent;
    }
}
