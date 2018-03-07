package com.facebook.components.glyph;

import android.graphics.drawable.Drawable;
import android.support.v4.util.Pools$SynchronizedPool;
import com.facebook.components.ComponentContext;
import com.facebook.components.reference.Reference;
import com.facebook.components.reference.ReferenceLifecycle;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: ig_pff_imp */
public class GlyphColorizerDrawableReference extends ReferenceLifecycle<Drawable> {
    public static final Pools$SynchronizedPool<Builder> f20580a = new Pools$SynchronizedPool(2);
    private static volatile GlyphColorizerDrawableReference f20581c;
    private final GlyphColorizerDrawableReferenceSpec f20582b;

    public static com.facebook.components.glyph.GlyphColorizerDrawableReference m28322a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20581c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.components.glyph.GlyphColorizerDrawableReference.class;
        monitor-enter(r1);
        r0 = f20581c;	 Catch:{ all -> 0x003a }
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
        r0 = m28323b(r0);	 Catch:{ all -> 0x0035 }
        f20581c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20581c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.components.glyph.GlyphColorizerDrawableReference.a(com.facebook.inject.InjectorLike):com.facebook.components.glyph.GlyphColorizerDrawableReference");
    }

    private static GlyphColorizerDrawableReference m28323b(InjectorLike injectorLike) {
        return new GlyphColorizerDrawableReference(GlyphColorizerDrawableReferenceSpec.m28328a(injectorLike));
    }

    @Inject
    public GlyphColorizerDrawableReference(GlyphColorizerDrawableReferenceSpec glyphColorizerDrawableReferenceSpec) {
        this.f20582b = glyphColorizerDrawableReferenceSpec;
    }

    protected final Object mo3151a(ComponentContext componentContext, Reference reference) {
        State state = (State) reference;
        GlyphColorizerDrawableReferenceSpec glyphColorizerDrawableReferenceSpec = this.f20582b;
        return glyphColorizerDrawableReferenceSpec.f20585a.m11489a(state.a, state.b);
    }

    public final Builder m28324a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) f20580a.mo740a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.a(builder, componentContext, state);
        return builder;
    }
}
