package com.facebook.reaction.feed.unitcomponents.spec.header;

import android.net.Uri;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.view.View.OnClickListener;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout.Builder;
import com.facebook.components.ComponentLayout.ContainerBuilder;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.Container;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.fb.fresco.FbFrescoComponent;
import com.facebook.components.reference.ColorDrawableReference;
import com.facebook.components.widget.Image;
import com.facebook.components.widget.Text;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.feed.unitcomponents.spec.body.ReactionOnClickDelegateComponent;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: ^(6011|65|64[4-9]|622([2-8]|1[3-9]|12[6-9]|9[0-1]|92[0-5])) */
public class ReactionIconHeaderComponent extends ComponentLifecycle {
    private static final SynchronizedPool<Object> f20475b = new SynchronizedPool(2);
    private static volatile ReactionIconHeaderComponent f20476d;
    private final ReactionIconHeaderComponentSpec f20477c;

    /* compiled from: ^(6011|65|64[4-9]|622([2-8]|1[3-9]|12[6-9]|9[0-1]|92[0-5])) */
    class State extends Component<ReactionIconHeaderComponent> implements Cloneable {
        String f20472a;
        Uri f20473b;
        OnClickListener f20474c;

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
            if (this.f20472a == null ? state.f20472a != null : !this.f20472a.equals(state.f20472a)) {
                return false;
            }
            if (this.f20473b == null ? state.f20473b != null : !this.f20473b.equals(state.f20473b)) {
                return false;
            }
            if (this.f20474c != null) {
                if (this.f20474c.equals(state.f20474c)) {
                    return true;
                }
            } else if (state.f20474c == null) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.header.ReactionIconHeaderComponent m24246a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20476d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.header.ReactionIconHeaderComponent.class;
        monitor-enter(r1);
        r0 = f20476d;	 Catch:{ all -> 0x003a }
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
        r0 = m24247b(r0);	 Catch:{ all -> 0x0035 }
        f20476d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20476d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.header.ReactionIconHeaderComponent.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.header.ReactionIconHeaderComponent");
    }

    private static ReactionIconHeaderComponent m24247b(InjectorLike injectorLike) {
        return new ReactionIconHeaderComponent(ReactionIconHeaderComponentSpec.m24250a(injectorLike));
    }

    @Inject
    public ReactionIconHeaderComponent(ReactionIconHeaderComponentSpec reactionIconHeaderComponentSpec) {
        this.f20477c = reactionIconHeaderComponentSpec;
    }

    protected final InternalNode m24249b(ComponentContext componentContext, Component component) {
        Builder builder;
        State state = (State) component;
        ReactionIconHeaderComponentSpec reactionIconHeaderComponentSpec = this.f20477c;
        CharSequence charSequence = state.f20472a;
        Uri uri = state.f20473b;
        OnClickListener onClickListener = state.f20474c;
        Component.Builder builder2 = null;
        componentContext.getResources();
        ContainerBuilder n = Container.a(componentContext).C(2).E(2).F(2130773596).m(5, 2130773576).n(1, 2131431413).n(3, 2131431416);
        if (uri == null) {
            builder = null;
        } else {
            builder = FbFrescoComponent.a(componentContext).a(ColorDrawableReference.a(componentContext).i(2131361970).b()).a(reactionIconHeaderComponentSpec.f20480b.b(uri).a(ReactionIconHeaderComponentSpec.f20478a).s()).c().l(2131431405).p(2131431405).c(7, 2131431365);
        }
        ContainerBuilder a = n.a(builder).a(Text.a(componentContext).o(2131427402).m(2130773571).a(charSequence).c().a(1.0f));
        if (onClickListener != null) {
            com.facebook.reaction.feed.unitcomponents.spec.body.ReactionOnClickDelegateComponent.State state2 = new com.facebook.reaction.feed.unitcomponents.spec.body.ReactionOnClickDelegateComponent.State(reactionIconHeaderComponentSpec.f20481c);
            ReactionOnClickDelegateComponent.Builder builder3 = (ReactionOnClickDelegateComponent.Builder) ReactionOnClickDelegateComponent.f20312b.a();
            if (builder3 == null) {
                builder3 = new ReactionOnClickDelegateComponent.Builder();
            }
            ReactionOnClickDelegateComponent.Builder.m24145a(builder3, componentContext, 0, state2);
            ReactionOnClickDelegateComponent.Builder builder4 = builder3;
            builder4.f20305a.f20310b = onClickListener;
            builder4.f20308d.set(1);
            builder2 = builder4.m24146a(Image.a(componentContext).h(2130840320));
        }
        return a.a(builder2).j();
    }

    public final void m24248a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ ReactionIconHeaderComponent f20471c;

                public void run() {
                    this.f20471c.a(eventHandler, obj);
                }
            }, -758606098);
        }
    }
}
