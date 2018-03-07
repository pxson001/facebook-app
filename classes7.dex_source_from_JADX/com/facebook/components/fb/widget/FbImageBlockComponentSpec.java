package com.facebook.components.fb.widget;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.components.ComponentContext;
import com.facebook.components.Container;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.fb.fresco.FbFrescoComponent;
import com.facebook.components.widget.Text;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LayoutSpec
/* compiled from: creative_cam_picker */
public class FbImageBlockComponentSpec {
    static final CallerContext f16645a = CallerContext.a(FbImageBlockComponent.class);
    private static volatile FbImageBlockComponentSpec f16646c;
    private final FbDraweeControllerBuilder f16647b;

    public static com.facebook.components.fb.widget.FbImageBlockComponentSpec m20689a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16646c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.components.fb.widget.FbImageBlockComponentSpec.class;
        monitor-enter(r1);
        r0 = f16646c;	 Catch:{ all -> 0x003a }
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
        r0 = m20690b(r0);	 Catch:{ all -> 0x0035 }
        f16646c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16646c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.components.fb.widget.FbImageBlockComponentSpec.a(com.facebook.inject.InjectorLike):com.facebook.components.fb.widget.FbImageBlockComponentSpec");
    }

    private static FbImageBlockComponentSpec m20690b(InjectorLike injectorLike) {
        return new FbImageBlockComponentSpec(FbDraweeControllerBuilder.b(injectorLike));
    }

    @Inject
    public FbImageBlockComponentSpec(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f16647b = fbDraweeControllerBuilder;
    }

    protected final InternalNode m20691a(ComponentContext componentContext, Uri uri, CharSequence charSequence, CharSequence charSequence2, EventHandler eventHandler, EventHandler eventHandler2, int i, CallerContext callerContext, RoundingParams roundingParams, Uri uri2) {
        return Container.a(componentContext).C(2).E(2).H(i).a(FbFrescoComponent.a(componentContext).a(this.f16647b.b(uri).a(callerContext).s()).a(roundingParams).c().l(2131431078).p(2131431078).c(8, 2131431080).a(eventHandler)).a(Container.a(componentContext).C(0).b(1.0f).a(Text.a(componentContext).a(charSequence).o(2131427402).c().a(1.0f).g(2, 2131431080)).a(TextUtils.isEmpty(charSequence2) ? null : Text.a(componentContext).a(charSequence2).o(2131427400).l(2131361974).c().a(1.0f).g(2, 2131431080))).a(uri2 == null ? null : FbFrescoComponent.a(componentContext).a(this.f16647b.b(uri2).a(callerContext).s()).c().l(2131431079).p(2131431079).c(8, 2131431080).a(eventHandler2)).j();
    }
}
