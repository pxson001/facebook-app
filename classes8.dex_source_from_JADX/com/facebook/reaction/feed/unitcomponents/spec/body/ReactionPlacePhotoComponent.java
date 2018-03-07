package com.facebook.reaction.feed.unitcomponents.spec.body;

import android.net.Uri;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: _inflation */
public class ReactionPlacePhotoComponent extends ComponentLifecycle {
    private static final SynchronizedPool<Object> f20371b = new SynchronizedPool(2);
    private static volatile ReactionPlacePhotoComponent f20372d;
    private final ReactionPlacePhotoComponentSpec f20373c;

    /* compiled from: _inflation */
    class State extends Component<ReactionPlacePhotoComponent> implements Cloneable {
        List<Uri> f20365a;
        String f20366b;
        String f20367c;
        Uri f20368d;
        int f20369e;
        Uri f20370f;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            State state = (State) obj;
            if (this.b == state.b) {
                return true;
            }
            if (this.f20365a == null ? state.f20365a != null : !this.f20365a.equals(state.f20365a)) {
                return false;
            }
            if (this.f20366b == null ? state.f20366b != null : !this.f20366b.equals(state.f20366b)) {
                return false;
            }
            if (this.f20367c == null ? state.f20367c != null : !this.f20367c.equals(state.f20367c)) {
                return false;
            }
            if (this.f20368d == null ? state.f20368d != null : !this.f20368d.equals(state.f20368d)) {
                return false;
            }
            if (this.f20369e != state.f20369e) {
                return false;
            }
            if (this.f20370f != null) {
                if (this.f20370f.equals(state.f20370f)) {
                    return true;
                }
            } else if (state.f20370f == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlacePhotoComponent m24178a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20372d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlacePhotoComponent.class;
        monitor-enter(r1);
        r0 = f20372d;	 Catch:{ all -> 0x003a }
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
        r0 = m24179b(r0);	 Catch:{ all -> 0x0035 }
        f20372d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20372d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlacePhotoComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlacePhotoComponent");
    }

    private static ReactionPlacePhotoComponent m24179b(InjectorLike injectorLike) {
        return new ReactionPlacePhotoComponent(ReactionPlacePhotoComponentSpec.m24185a(injectorLike));
    }

    @Inject
    public ReactionPlacePhotoComponent(ReactionPlacePhotoComponentSpec reactionPlacePhotoComponentSpec) {
        this.f20373c = reactionPlacePhotoComponentSpec;
    }

    protected final InternalNode m24181b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f20373c.m24187a(componentContext, state.f20365a, state.f20366b, state.f20367c, state.f20368d, state.f20369e, state.f20370f);
    }

    public final void m24180a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionPlacePhotoComponent f20364c;

                public void run() {
                    this.f20364c.a(eventHandler, obj);
                }
            }, -1558258346);
        }
    }
}
