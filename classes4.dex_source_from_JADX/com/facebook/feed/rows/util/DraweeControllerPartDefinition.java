package com.facebook.feed.rows.util;

import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Deprecated
/* compiled from: onMessengerFriends */
public class DraweeControllerPartDefinition<V extends View> extends BaseSinglePartDefinition<Props<V>, State<V>, AnyEnvironment, V> {
    private static final String f6155a = DraweeControllerPartDefinition.class.getName();
    private static volatile DraweeControllerPartDefinition f6156d;
    private final FbDraweeControllerBuilder f6157b;
    private final ImagePipeline f6158c;

    /* compiled from: onMessengerFriends */
    public interface Callbacks<V extends View> {
        @Nullable
        ImageRequest mo567a();

        void mo568a(V v, @Nullable DraweeController draweeController);
    }

    /* compiled from: onMessengerFriends */
    public class Props<V extends View> {
        public final CallerContext f6371a;
        public final Callbacks<V> f6372b;
        public final boolean f6373c;
        public final boolean f6374d;

        public Props(CallerContext callerContext, Callbacks<V> callbacks, boolean z, boolean z2) {
            this.f6371a = callerContext;
            this.f6372b = callbacks;
            this.f6373c = z;
            this.f6374d = z2;
        }
    }

    /* compiled from: onMessengerFriends */
    public class State<V> {
        @Nullable
        public DraweeController f6381a;
        @Nullable
        public ImageRequest f6382b;
        @Nullable
        public V f6383c;
    }

    public static com.facebook.feed.rows.util.DraweeControllerPartDefinition m6627a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6156d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.rows.util.DraweeControllerPartDefinition.class;
        monitor-enter(r1);
        r0 = f6156d;	 Catch:{ all -> 0x003a }
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
        r0 = m6631b(r0);	 Catch:{ all -> 0x0035 }
        f6156d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6156d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.rows.util.DraweeControllerPartDefinition.a(com.facebook.inject.InjectorLike):com.facebook.feed.rows.util.DraweeControllerPartDefinition");
    }

    private static DraweeControllerPartDefinition m6631b(InjectorLike injectorLike) {
        return new DraweeControllerPartDefinition(FbDraweeControllerBuilder.b(injectorLike), ImagePipelineMethodAutoProvider.a(injectorLike));
    }

    public final Object m6633a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        State state = new State();
        if (props.f6373c) {
            m6632b(props, state);
        }
        state.f6381a = m6626a(props, state);
        return state;
    }

    public final /* synthetic */ void m6635b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        m6629a((Props) obj, (State) obj2, view);
    }

    @Inject
    public DraweeControllerPartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder, ImagePipeline imagePipeline) {
        this.f6157b = fbDraweeControllerBuilder;
        this.f6158c = imagePipeline;
    }

    private void m6630a(Props<V> props, State<V> state, AnyEnvironment anyEnvironment, V v) {
        if (v == state.f6383c) {
            BLog.c(f6155a, "Attempted to bind the same view twice! View: %s", new Object[]{v});
            return;
        }
        if (state.f6383c != null) {
            BLog.c(f6155a, "Attempted to bind already bound view! Previous: %s, New: %s", new Object[]{state.f6383c, v});
            m6629a((Props) props, (State) state, (View) state.f6383c);
        }
        if (props.f6374d) {
            m6632b(props, state);
        }
        state.f6383c = v;
        props.f6372b.mo568a(v, m6626a((Props) props, (State) state));
    }

    private static void m6629a(Props<V> props, State<V> state, V v) {
        if (v != state.f6383c) {
            BLog.c(f6155a, "Attempted to unbind a wrong view! Bound: %s, Attempted: %s", new Object[]{state.f6383c, v});
            return;
        }
        state.f6383c = null;
        props.f6372b.mo568a(v, null);
    }

    private DraweeController m6626a(Props<V> props, State<V> state) {
        if (state.f6381a != null) {
            return state.f6381a;
        }
        ImageRequest a = m6628a((Props) props, state.f6382b);
        if (a == null) {
            return null;
        }
        DraweeController s = ((FbDraweeControllerBuilder) this.f6157b.a(props.f6371a).c(a)).r().s();
        state.f6381a = s;
        return s;
    }

    private static ImageRequest m6628a(Props<V> props, ImageRequest imageRequest) {
        if (imageRequest == null) {
            return props.f6372b.mo567a();
        }
        return imageRequest;
    }

    private void m6632b(Props<V> props, State<V> state) {
        state.f6382b = m6628a((Props) props, state.f6382b);
        if (state.f6382b != null) {
            this.f6158c.e(state.f6382b, props.f6371a);
        }
    }
}
