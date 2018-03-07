package com.facebook.reaction.feed.unitcomponents.spec.body.binders;

import com.facebook.components.annotations.LayoutSpec;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.environment.HasContext;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LayoutSpec
/* compiled from: _NPE */
public class ReactionPhotoComponentSpec {
    private static volatile ReactionPhotoComponentSpec f20439c;
    private final ReactionIntentFactory f20440a;
    public final FbDraweeControllerBuilder f20441b;

    public static com.facebook.reaction.feed.unitcomponents.spec.body.binders.ReactionPhotoComponentSpec m24224a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20439c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.binders.ReactionPhotoComponentSpec.class;
        monitor-enter(r1);
        r0 = f20439c;	 Catch:{ all -> 0x003a }
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
        r0 = m24225b(r0);	 Catch:{ all -> 0x0035 }
        f20439c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20439c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.binders.ReactionPhotoComponentSpec.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.binders.ReactionPhotoComponentSpec");
    }

    private static ReactionPhotoComponentSpec m24225b(InjectorLike injectorLike) {
        return new ReactionPhotoComponentSpec(FbDraweeControllerBuilder.b(injectorLike), ReactionIntentFactory.m22683a(injectorLike));
    }

    @Inject
    public ReactionPhotoComponentSpec(FbDraweeControllerBuilder fbDraweeControllerBuilder, ReactionIntentFactory reactionIntentFactory) {
        this.f20440a = reactionIntentFactory;
        this.f20441b = fbDraweeControllerBuilder;
    }

    protected final void m24226a(SizeAwareMedia sizeAwareMedia, CanLaunchReactionIntent canLaunchReactionIntent, HasContext hasContext, long[] jArr, String str, String str2) {
        canLaunchReactionIntent.mo695a(str, str2, ReactionIntentFactory.m22684a(hasContext.getContext(), Long.parseLong(sizeAwareMedia.d()), jArr, sizeAwareMedia.be_().b()));
    }
}
