package com.facebook.timeline.aboutpage;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.inject.InjectorLike;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.events.CollectionsClickEvents.CollectionCurationClickEvent;
import com.facebook.timeline.aboutpage.events.CollectionsClickEvents.CollectionCurationClickEventSubscriber;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: NOT_ALL_TILES_IN_CACHE */
public class CollectionsCurationController {
    private static volatile CollectionsCurationController f13003b;
    public final FbUriIntentHandler f13004a;

    public static com.facebook.timeline.aboutpage.CollectionsCurationController m13746a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13003b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.aboutpage.CollectionsCurationController.class;
        monitor-enter(r1);
        r0 = f13003b;	 Catch:{ all -> 0x003a }
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
        r0 = m13747b(r0);	 Catch:{ all -> 0x0035 }
        f13003b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13003b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.CollectionsCurationController.a(com.facebook.inject.InjectorLike):com.facebook.timeline.aboutpage.CollectionsCurationController");
    }

    private static CollectionsCurationController m13747b(InjectorLike injectorLike) {
        return new CollectionsCurationController(FbUriIntentHandler.a(injectorLike));
    }

    @Inject
    public CollectionsCurationController(FbUriIntentHandler fbUriIntentHandler) {
        this.f13004a = fbUriIntentHandler;
    }

    public final void m13748a(final Context context, final ProfileViewerContext profileViewerContext, FbEventSubscriberListManager fbEventSubscriberListManager) {
        fbEventSubscriberListManager.a(new CollectionCurationClickEventSubscriber(this) {
            final /* synthetic */ CollectionsCurationController f13002c;

            public final void m13745b(FbEvent fbEvent) {
                CollectionCurationClickEvent collectionCurationClickEvent = (CollectionCurationClickEvent) fbEvent;
                Bundle bundle = new Bundle();
                CollectionsExtras.m13749a(bundle, profileViewerContext.c, profileViewerContext.d);
                this.f13002c.f13004a.a(context, collectionCurationClickEvent.f13139a, bundle, null);
            }
        });
    }
}
