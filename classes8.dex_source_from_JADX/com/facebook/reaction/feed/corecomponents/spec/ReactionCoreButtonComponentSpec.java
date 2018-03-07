package com.facebook.reaction.feed.corecomponents.spec;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.graphql.enums.GraphQLReactionCoreButtonGlyphAlignment;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LayoutSpec
/* compiled from: batch_request_task_key_not_used */
public class ReactionCoreButtonComponentSpec {
    public static final CallerContext f19021a = CallerContext.a(ReactionCoreButtonComponentSpec.class, "reaction_photos");
    private static volatile ReactionCoreButtonComponentSpec f19022d;
    public final ReactionCoreTextComponent f19023b;
    public final FbDraweeControllerBuilder f19024c;

    /* compiled from: batch_request_task_key_not_used */
    public /* synthetic */ class C20851 {
        public static final /* synthetic */ int[] f19020a = new int[GraphQLReactionCoreButtonGlyphAlignment.values().length];

        static {
            try {
                f19020a[GraphQLReactionCoreButtonGlyphAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19020a[GraphQLReactionCoreButtonGlyphAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19020a[GraphQLReactionCoreButtonGlyphAlignment.START.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19020a[GraphQLReactionCoreButtonGlyphAlignment.END.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static com.facebook.reaction.feed.corecomponents.spec.ReactionCoreButtonComponentSpec m23066a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19022d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.corecomponents.spec.ReactionCoreButtonComponentSpec.class;
        monitor-enter(r1);
        r0 = f19022d;	 Catch:{ all -> 0x003a }
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
        r0 = m23067b(r0);	 Catch:{ all -> 0x0035 }
        f19022d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19022d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.corecomponents.spec.ReactionCoreButtonComponentSpec.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.corecomponents.spec.ReactionCoreButtonComponentSpec");
    }

    private static ReactionCoreButtonComponentSpec m23067b(InjectorLike injectorLike) {
        return new ReactionCoreButtonComponentSpec(ReactionCoreTextComponent.m23109a(injectorLike), FbDraweeControllerBuilder.b(injectorLike));
    }

    @Inject
    public ReactionCoreButtonComponentSpec(ReactionCoreTextComponent reactionCoreTextComponent, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f19023b = reactionCoreTextComponent;
        this.f19024c = fbDraweeControllerBuilder;
    }
}
