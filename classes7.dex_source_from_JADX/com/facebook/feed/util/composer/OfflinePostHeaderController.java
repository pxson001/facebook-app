package com.facebook.feed.util.composer;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.cache.OfflinePostConfigCache;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.OfflinePostConfig;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.model.RetrySource;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.progresspage.CompostStoryViewUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: shouldAskUser */
public class OfflinePostHeaderController extends Handler {
    private static volatile OfflinePostHeaderController f3786k;
    private final PendingStoryStore f3787a;
    private final Lazy<ComposerPublishServiceHelper> f3788b;
    private final FeedEventBus f3789c;
    public final Lazy<UploadManager> f3790d;
    private final Clock f3791e;
    private final OfflinePostConfigCache f3792f;
    public final QeAccessor f3793g;
    private final OptimisticStoryStateCache f3794h;
    private final FeedEventBus f3795i;
    private final CompostStoryViewUtil f3796j;

    /* compiled from: shouldAskUser */
    public class C03171 implements OnClickListener {
        final /* synthetic */ GraphQLStory f3782a;
        final /* synthetic */ OfflinePostHeaderController f3783b;

        public C03171(OfflinePostHeaderController offlinePostHeaderController, GraphQLStory graphQLStory) {
            this.f3783b = offlinePostHeaderController;
            this.f3782a = graphQLStory;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f3783b.m4436a(this.f3782a);
        }
    }

    /* compiled from: shouldAskUser */
    public class C03182 implements OnClickListener {
        final /* synthetic */ OfflinePostHeaderController f3784a;

        public C03182(OfflinePostHeaderController offlinePostHeaderController) {
            this.f3784a = offlinePostHeaderController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: shouldAskUser */
    class C03193 implements OnTouchListener {
        final /* synthetic */ OfflinePostHeaderController f3785a;

        C03193(OfflinePostHeaderController offlinePostHeaderController) {
            this.f3785a = offlinePostHeaderController;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            Preconditions.checkArgument(view instanceof ImageView, "cancel button is not an image view");
            switch (motionEvent.getAction()) {
                case 0:
                    ((ImageView) view).setColorFilter(-12303292, Mode.MULTIPLY);
                    break;
                case 1:
                    ((ImageView) view).setColorFilter(null);
                    break;
            }
            return false;
        }
    }

    public static com.facebook.feed.util.composer.OfflinePostHeaderController m4432a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3786k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.util.composer.OfflinePostHeaderController.class;
        monitor-enter(r1);
        r0 = f3786k;	 Catch:{ all -> 0x003a }
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
        r0 = m4433b(r0);	 Catch:{ all -> 0x0035 }
        f3786k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3786k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.composer.OfflinePostHeaderController.a(com.facebook.inject.InjectorLike):com.facebook.feed.util.composer.OfflinePostHeaderController");
    }

    private static OfflinePostHeaderController m4433b(InjectorLike injectorLike) {
        return new OfflinePostHeaderController(FeedEventBus.a(injectorLike), PendingStoryStore.a(injectorLike), IdBasedLazy.a(injectorLike, 5272), FeedEventBus.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2984), (Clock) SystemClockMethodAutoProvider.a(injectorLike), OfflinePostConfigCache.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), OptimisticStoryStateCache.a(injectorLike), CompostStoryViewUtil.b(injectorLike));
    }

    @Inject
    public OfflinePostHeaderController(FeedEventBus feedEventBus, PendingStoryStore pendingStoryStore, Lazy<ComposerPublishServiceHelper> lazy, FeedEventBus feedEventBus2, Lazy<UploadManager> lazy2, Clock clock, OfflinePostConfigCache offlinePostConfigCache, QeAccessor qeAccessor, OptimisticStoryStateCache optimisticStoryStateCache, CompostStoryViewUtil compostStoryViewUtil) {
        this.f3795i = feedEventBus;
        this.f3787a = pendingStoryStore;
        this.f3788b = lazy;
        this.f3789c = feedEventBus2;
        this.f3790d = lazy2;
        this.f3791e = clock;
        this.f3792f = offlinePostConfigCache;
        this.f3793g = qeAccessor;
        this.f3794h = optimisticStoryStateCache;
        this.f3796j = compostStoryViewUtil;
    }

    public final void m4437a(GraphQLStory graphQLStory, long j) {
        removeMessages(3, graphQLStory);
        Message obtainMessage = obtainMessage(3, graphQLStory);
        Bundle bundle = new Bundle(1);
        FlatBufferModelHelper.a(bundle, "story_key", graphQLStory);
        obtainMessage.setData(bundle);
        sendMessageDelayed(obtainMessage, j);
    }

    public final <V extends View & OfflinePostProgress> void m4439a(GraphQLStory graphQLStory, WeakReference<V> weakReference, long j) {
        removeMessages(1, weakReference);
        Message obtainMessage = obtainMessage(1, weakReference);
        Bundle bundle = new Bundle(1);
        FlatBufferModelHelper.a(bundle, "story_key", graphQLStory);
        obtainMessage.setData(bundle);
        sendMessageDelayed(obtainMessage, j);
    }

    public void handleMessage(Message message) {
        GraphQLStory graphQLStory = (GraphQLStory) FlatBufferModelHelper.a(message.getData(), "story_key");
        OfflinePostConfig a = this.f3792f.a(graphQLStory);
        Optional d = this.f3787a.d(graphQLStory.T());
        switch (message.what) {
            case 1:
                if (d.isPresent()) {
                    if (!(this.f3794h.a(graphQLStory) == GraphQLFeedOptimisticPublishState.FAILED || ((PendingStory) d.get()).d())) {
                        ((PendingStory) d.get()).b(this.f3791e.a(), StoryAttachmentHelper.a(graphQLStory));
                    }
                    if (((PendingStory) d.get()).f()) {
                        WeakReference weakReference = (WeakReference) message.obj;
                        if (weakReference != null) {
                            OfflinePostProgress offlinePostProgress = (OfflinePostProgress) weakReference.get();
                            if (offlinePostProgress == null || weakReference.hashCode() != a.b) {
                                weakReference.clear();
                            } else {
                                offlinePostProgress.mo1590a(graphQLStory);
                            }
                            if (a.b == 0 || weakReference.get() != null) {
                                sendMessageDelayed(Message.obtain(message), 50);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                WeakReference weakReference2 = (WeakReference) message.obj;
                OfflinePostProgress offlinePostProgress2 = weakReference2 != null ? (OfflinePostProgress) weakReference2.get() : null;
                if (offlinePostProgress2 != null) {
                    offlinePostProgress2.mo1589a();
                    return;
                }
                return;
            case 2:
                m4438a(graphQLStory, RetrySource.AUTOMATIC);
                return;
            case 3:
                if (d.isPresent()) {
                    if (!(this.f3794h.a(graphQLStory) == GraphQLFeedOptimisticPublishState.FAILED || ((PendingStory) d.get()).d())) {
                        ((PendingStory) d.get()).b(this.f3791e.a(), StoryAttachmentHelper.a(graphQLStory));
                    }
                    m4434c(graphQLStory);
                    return;
                } else if (this.f3794h.a(graphQLStory) != GraphQLFeedOptimisticPublishState.SUCCESS) {
                    m4434c(graphQLStory);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void m4436a(GraphQLStory graphQLStory) {
        this.f3796j.a(graphQLStory);
    }

    public final void m4438a(@Nullable GraphQLStory graphQLStory, RetrySource retrySource) {
        this.f3796j.a(graphQLStory, retrySource, false);
    }

    public final OnTouchListener m4435a() {
        return new C03193(this);
    }

    private void m4434c(GraphQLStory graphQLStory) {
        this.f3795i.a(new FeedUnitMutatedEvent(graphQLStory));
    }
}
