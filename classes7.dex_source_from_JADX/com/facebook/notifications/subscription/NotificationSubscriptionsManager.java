package com.facebook.notifications.subscription;

import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.util.CollectionUtil;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.notifications.abtest.ExperimentsForNotificationsAbtestModule;
import com.facebook.photos.adaptiveimagequality.base.ImageQuality;
import com.facebook.prefetch.notifications.NotificationStorySubscriber;
import com.facebook.timeline.profilevideo.upload.ProfileVideoNotificationListener;
import com.facebook.timeline.profilevideo.upload.ProfileVideoNotificationListener.ProfileVideoNotificationTypeSubscriber;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: minutiae_object_picker_time_to_init */
public class NotificationSubscriptionsManager {
    private static volatile NotificationSubscriptionsManager f8859g;
    private final Map<String, Set<NotificationTypeSubscriber>> f8860a = new HashMap();
    private final Set<NotificationSubscriber> f8861b;
    private final ExecutorService f8862c;
    private final ReadWriteLock f8863d;
    private final Lock f8864e;
    private final Lock f8865f;

    public static com.facebook.notifications.subscription.NotificationSubscriptionsManager m10778a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8859g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.subscription.NotificationSubscriptionsManager.class;
        monitor-enter(r1);
        r0 = f8859g;	 Catch:{ all -> 0x003a }
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
        r0 = m10779b(r0);	 Catch:{ all -> 0x0035 }
        f8859g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8859g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.subscription.NotificationSubscriptionsManager.a(com.facebook.inject.InjectorLike):com.facebook.notifications.subscription.NotificationSubscriptionsManager");
    }

    private static NotificationSubscriptionsManager m10779b(InjectorLike injectorLike) {
        return new NotificationSubscriptionsManager(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$NotificationTypeSubscriber(injectorLike)), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$NotificationSubscriber(injectorLike)), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NotificationSubscriptionsManager(Set<NotificationTypeSubscriber> set, Set<NotificationSubscriber> set2, ExecutorService executorService) {
        this.f8862c = executorService;
        this.f8861b = set2;
        this.f8863d = new ReentrantReadWriteLock();
        this.f8864e = this.f8863d.readLock();
        this.f8865f = this.f8863d.writeLock();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            m10780b((ProfileVideoNotificationTypeSubscriber) it.next());
        }
    }

    private void m10781b(ProfileVideoNotificationTypeSubscriber profileVideoNotificationTypeSubscriber, String... strArr) {
        this.f8865f.lock();
        try {
            for (Object obj : strArr) {
                Set set = (Set) this.f8860a.get(obj);
                if (set == null) {
                    Map map = this.f8860a;
                    set = Collections.newSetFromMap(new WeakHashMap());
                    map.put(obj, set);
                }
                set.add(profileVideoNotificationTypeSubscriber);
            }
        } finally {
            this.f8865f.unlock();
        }
    }

    private void m10780b(ProfileVideoNotificationTypeSubscriber profileVideoNotificationTypeSubscriber) {
        m10781b(profileVideoNotificationTypeSubscriber, ProfileVideoNotificationListener.a);
    }

    public final void m10784a(String str, final GraphQLStory graphQLStory) {
        this.f8864e.lock();
        try {
            Set<ProfileVideoNotificationTypeSubscriber> set = (Set) this.f8860a.get(str);
            if (!CollectionUtil.a(set)) {
                for (final ProfileVideoNotificationTypeSubscriber profileVideoNotificationTypeSubscriber : set) {
                    ExecutorDetour.a(this.f8862c, new Runnable(this) {
                        final /* synthetic */ NotificationSubscriptionsManager f8855c;

                        public void run() {
                            profileVideoNotificationTypeSubscriber.a(graphQLStory);
                        }
                    }, -195724908);
                }
            }
            for (final NotificationStorySubscriber notificationStorySubscriber : this.f8861b) {
                ExecutorDetour.a(this.f8862c, new Runnable(this) {
                    final /* synthetic */ NotificationSubscriptionsManager f8858c;

                    public void run() {
                        NotificationStorySubscriber notificationStorySubscriber = notificationStorySubscriber;
                        GraphQLStory graphQLStory = graphQLStory;
                        if (notificationStorySubscriber.d.b(graphQLStory) == null && GraphQLHelper.b(graphQLStory) == null) {
                            notificationStorySubscriber.b.a.m24864a(FeedProps.c(graphQLStory), ImageQuality.OFF);
                            if (notificationStorySubscriber.a.a.a(ExperimentsForNotificationsAbtestModule.b, false)) {
                                notificationStorySubscriber.c.a(graphQLStory);
                            }
                            if (notificationStorySubscriber.g.d || notificationStorySubscriber.g.q) {
                                notificationStorySubscriber.e.a(graphQLStory);
                            }
                        }
                    }
                }, 2080981854);
            }
        } finally {
            this.f8864e.unlock();
        }
    }

    public final void m10783a(ProfileVideoNotificationTypeSubscriber profileVideoNotificationTypeSubscriber, String... strArr) {
        m10781b(profileVideoNotificationTypeSubscriber, strArr);
    }

    public final void m10782a(ProfileVideoNotificationTypeSubscriber profileVideoNotificationTypeSubscriber) {
        this.f8865f.lock();
        try {
            for (Collection remove : this.f8860a.values()) {
                remove.remove(profileVideoNotificationTypeSubscriber);
            }
        } finally {
            this.f8865f.unlock();
        }
    }
}
