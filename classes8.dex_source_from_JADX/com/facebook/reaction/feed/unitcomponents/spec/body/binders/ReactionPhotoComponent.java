package com.facebook.reaction.feed.unitcomponents.spec.body.binders;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.components.ClickEvent;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.fb.fresco.FbFrescoComponent;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.feed.environment.HasContext;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: __a */
public class ReactionPhotoComponent extends ComponentLifecycle {
    private static final SynchronizedPool<Object> f20436b = new SynchronizedPool(2);
    private static volatile ReactionPhotoComponent f20437d;
    private final ReactionPhotoComponentSpec f20438c;

    /* compiled from: __a */
    class State extends Component<ReactionPhotoComponent> implements Cloneable {
        CallerContext f20428a;
        SizeAwareMedia f20429b;
        boolean f20430c;
        CanLaunchReactionIntent f20431d;
        HasContext f20432e;
        long[] f20433f;
        String f20434g;
        String f20435h;

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
            if (this.f20428a == null ? state.f20428a != null : !this.f20428a.equals(state.f20428a)) {
                return false;
            }
            if (this.f20429b == null ? state.f20429b != null : !this.f20429b.equals(state.f20429b)) {
                return false;
            }
            if (this.f20430c != state.f20430c) {
                return false;
            }
            if (this.f20431d == null ? state.f20431d != null : !this.f20431d.equals(state.f20431d)) {
                return false;
            }
            if (this.f20432e == null ? state.f20432e != null : !this.f20432e.equals(state.f20432e)) {
                return false;
            }
            if (!Arrays.equals(this.f20433f, state.f20433f)) {
                return false;
            }
            if (this.f20434g == null ? state.f20434g != null : !this.f20434g.equals(state.f20434g)) {
                return false;
            }
            if (this.f20435h != null) {
                if (this.f20435h.equals(state.f20435h)) {
                    return true;
                }
            } else if (state.f20435h == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.body.binders.ReactionPhotoComponent m24219a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20437d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.binders.ReactionPhotoComponent.class;
        monitor-enter(r1);
        r0 = f20437d;	 Catch:{ all -> 0x003a }
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
        r0 = m24221b(r0);	 Catch:{ all -> 0x0035 }
        f20437d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20437d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.binders.ReactionPhotoComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.binders.ReactionPhotoComponent");
    }

    private static ReactionPhotoComponent m24221b(InjectorLike injectorLike) {
        return new ReactionPhotoComponent(ReactionPhotoComponentSpec.m24224a(injectorLike));
    }

    @Inject
    public ReactionPhotoComponent(ReactionPhotoComponentSpec reactionPhotoComponentSpec) {
        this.f20438c = reactionPhotoComponentSpec;
    }

    protected final InternalNode m24223b(ComponentContext componentContext, Component component) {
        int i;
        State state = (State) component;
        ReactionPhotoComponentSpec reactionPhotoComponentSpec = this.f20438c;
        CallerContext callerContext = state.f20428a;
        SizeAwareMedia sizeAwareMedia = state.f20429b;
        boolean z = state.f20430c;
        Resources resources = componentContext.getResources();
        float min = Math.min(((float) sizeAwareMedia.be_().c()) / ((float) sizeAwareMedia.be_().a()), 1.5f);
        if (z) {
            i = resources.getDisplayMetrics().widthPixels;
        } else {
            i = Math.min(sizeAwareMedia.be_().c(), resources.getDimensionPixelSize(2131431421));
        }
        return FbFrescoComponent.a(componentContext).b(min).b(ScaleType.g).a(reactionPhotoComponentSpec.f20441b.b(Uri.parse(sizeAwareMedia.be_().b())).a(callerContext).s()).c().a(ComponentLifecycle.a(componentContext, 1380721441, null)).j(i).j();
    }

    private void m24220a(View view, Component component) {
        State state = (State) component;
        this.f20438c.m24226a(state.f20429b, state.f20431d, state.f20432e, state.f20433f, state.f20434g, state.f20435h);
    }

    public final void m24222a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionPhotoComponent f20427c;

                public void run() {
                    this.f20427c.a(eventHandler, obj);
                }
            }, 1567081488);
            return;
        }
        switch (eventHandler.b) {
            case 1380721441:
                m24220a(((ClickEvent) obj).a, eventHandler.a);
                return;
            default:
                return;
        }
    }
}
