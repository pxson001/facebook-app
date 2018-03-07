package com.facebook.notifications.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.WearableExtender;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.NotificationSource;
import com.facebook.apptab.state.TabTag;
import com.facebook.auth.login.LoginApprovalNotificationService;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecurePendingIntent;
import com.facebook.datasource.DataSource;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.linkutil.TextWithEntitiesUtil;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLCommentHelper;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.feed.PermalinkStoryIdParams;
import com.facebook.ipc.feed.PermalinkStoryIdParams.Builder;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.notifications.abtest.ExperimentsForNotificationsAbtestModule;
import com.facebook.notifications.intent.NotificationsLoggingIntentBuilder;
import com.facebook.notifications.lockscreen.util.LockScreenUtil;
import com.facebook.notifications.logging.NotificationType;
import com.facebook.notifications.logging.NotificationsLogger;
import com.facebook.notifications.logging.NotificationsLogger.Component;
import com.facebook.notifications.logging.NotificationsLogger.Event;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.notifications.model.SystemTrayNotification;
import com.facebook.notifications.model.SystemTrayNotification.ActionType;
import com.facebook.notifications.model.SystemTrayNotificationBuilder;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationsEdgeFieldsModel;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.sync.NotificationsSyncConstants.SyncSource;
import com.facebook.notifications.sync.NotificationsSyncManager;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: min_stars_for_store */
public class SystemTrayNotificationHelper {
    private static final String f8944a = SystemTrayNotificationHelper.class.getSimpleName();
    private static final CallerContext f8945b = CallerContext.a(SystemTrayNotificationHelper.class, "notifications");
    private static final ImmutableMap<NotificationType, String> f8946w = ImmutableMap.builder().b(NotificationType.WALL, "wall").b(NotificationType.MENTION, "wall").b(NotificationType.FRIEND_CONFIRMED, "friend_confirm").b(NotificationType.PHOTO_TAG, "photo_tag").b(NotificationType.PHOTO_TAGGED_BY_NON_OWNER, "photo_tag").b(NotificationType.PHOTO_TAG_REQUEST, "photo_tag_request").b(NotificationType.EVENT, "event_invites").b(NotificationType.PLACE_TAG, "place_tag").b(NotificationType.NEARBY, "nearby").b(NotificationType.COMMENT, "comment").b(NotificationType.COMMENT_MENTION, "comment").b(NotificationType.LIKE, "like").b(NotificationType.GROUP_ACTIVITY, "group_activity").b(NotificationType.CLOSE_FRIEND_ACTIVITY, "close_friend").b(NotificationType.TAGGED_WITH_STORY, "tagged_with_story").b(NotificationType.SHARE_WALL_CREATE, "wall_share").b(NotificationType.GIFT_RECIPIENT, "gifts").b(NotificationType.BACKSTAGE_FRIEND_POSTED, "backstage_friend_posted").b(NotificationType.BACKSTAGE_FRIEND_REACTED, "backstage_friend_reacted").b();
    private static final ImmutableMap<ActionType, Integer> f8947x = ImmutableMap.of(ActionType.LA_AUTHENTICATE_APPROVE, Integer.valueOf(2130839774), ActionType.LA_AUTHENTICATE_DENY, Integer.valueOf(2130839815));
    private static volatile SystemTrayNotificationHelper f8948y;
    private final Context f8949c;
    private final AbstractFbErrorReporter f8950d;
    private final ImagePipeline f8951e;
    private final GraphQLNotificationsContentProviderHelper f8952f;
    private final ListeningExecutorService f8953g;
    private final NotificationsLogger f8954h;
    private final NotificationsLoggingIntentBuilder f8955i;
    private final NotificationStoryHelper f8956j;
    private final Provider<String> f8957k;
    public final SystemTrayNotificationManager f8958l;
    private final Provider<SystemTrayNotificationBuilder> f8959m;
    private final LockScreenUtil f8960n;
    private final NotificationsSyncManager f8961o;
    private final MonotonicClock f8962p;
    private final UriIntentMapper f8963q;
    private final TextWithEntitiesUtil f8964r;
    private final NotificationsUtils f8965s;
    private final QeAccessor f8966t;
    private final TodayExperimentController f8967u;
    private final NotificationsConnectionControllerManager f8968v;

    /* compiled from: min_stars_for_store */
    /* synthetic */ class C07163 {
        static final /* synthetic */ int[] f8942a = new int[NotificationType.values().length];
        static final /* synthetic */ int[] f8943b = new int[ActionType.values().length];

        static {
            try {
                f8943b[ActionType.LA_AUTHENTICATE_APPROVE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8942a[NotificationType.GROUP_ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static com.facebook.notifications.util.SystemTrayNotificationHelper m10832a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8948y;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.util.SystemTrayNotificationHelper.class;
        monitor-enter(r1);
        r0 = f8948y;	 Catch:{ all -> 0x003a }
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
        r0 = m10837b(r0);	 Catch:{ all -> 0x0035 }
        f8948y = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8948y;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.util.SystemTrayNotificationHelper.a(com.facebook.inject.InjectorLike):com.facebook.notifications.util.SystemTrayNotificationHelper");
    }

    private static SystemTrayNotificationHelper m10837b(InjectorLike injectorLike) {
        return new SystemTrayNotificationHelper((Context) injectorLike.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ImagePipelineMethodAutoProvider.a(injectorLike), GraphQLNotificationsContentProviderHelper.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), NotificationsLogger.a(injectorLike), NotificationsLoggingIntentBuilder.a(injectorLike), NotificationStoryHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), SystemTrayNotificationManager.a(injectorLike), IdBasedProvider.a(injectorLike, 8699), LockScreenUtil.a(injectorLike), NotificationsSyncManager.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), TextWithEntitiesUtil.a(injectorLike), NotificationsUtils.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), TodayExperimentController.a(injectorLike), NotificationsConnectionControllerManager.a(injectorLike));
    }

    @Inject
    public SystemTrayNotificationHelper(Context context, FbErrorReporter fbErrorReporter, ImagePipeline imagePipeline, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, ListeningExecutorService listeningExecutorService, NotificationsLogger notificationsLogger, NotificationsLoggingIntentBuilder notificationsLoggingIntentBuilder, NotificationStoryHelper notificationStoryHelper, Provider<String> provider, SystemTrayDisplayManager systemTrayDisplayManager, Provider<SystemTrayNotificationBuilder> provider2, LockScreenUtil lockScreenUtil, NotificationsSyncManager notificationsSyncManager, MonotonicClock monotonicClock, UriIntentMapper uriIntentMapper, TextWithEntitiesUtil textWithEntitiesUtil, NotificationsUtils notificationsUtils, QeAccessor qeAccessor, TodayExperimentController todayExperimentController, NotificationsConnectionControllerManager notificationsConnectionControllerManager) {
        this.f8949c = context;
        this.f8950d = fbErrorReporter;
        this.f8951e = imagePipeline;
        this.f8952f = graphQLNotificationsContentProviderHelper;
        this.f8953g = listeningExecutorService;
        this.f8954h = notificationsLogger;
        this.f8955i = notificationsLoggingIntentBuilder;
        this.f8956j = notificationStoryHelper;
        this.f8957k = provider;
        this.f8958l = systemTrayDisplayManager;
        this.f8959m = provider2;
        this.f8960n = lockScreenUtil;
        this.f8961o = notificationsSyncManager;
        this.f8962p = monotonicClock;
        this.f8963q = uriIntentMapper;
        this.f8964r = textWithEntitiesUtil;
        this.f8965s = notificationsUtils;
        this.f8966t = qeAccessor;
        this.f8967u = todayExperimentController;
        this.f8968v = notificationsConnectionControllerManager;
    }

    public final void m10840a(SystemTrayNotification systemTrayNotification, int i, int i2, @Nullable Intent intent, ViewerContext viewerContext) {
        ListenableFuture a = this.f8961o.a(viewerContext, SyncSource.PUSH);
        this.f8961o.a(viewerContext);
        int a2 = this.f8966t.a(ExperimentsForNotificationsAbtestModule.E, 0);
        if (a2 > 0) {
            try {
                FutureDetour.a(a, (long) a2, TimeUnit.SECONDS, -165707434);
                m10839a(systemTrayNotification, i, i2, intent);
            } catch (InterruptedException e) {
                m10839a(systemTrayNotification, i, i2, intent);
            } catch (ExecutionException e2) {
                m10839a(systemTrayNotification, i, i2, intent);
            } catch (TimeoutException e3) {
                m10839a(systemTrayNotification, i, i2, intent);
            } catch (Throwable th) {
                m10839a(systemTrayNotification, i, i2, intent);
            }
        } else {
            final SystemTrayNotification systemTrayNotification2 = systemTrayNotification;
            final int i3 = i;
            final int i4 = i2;
            final Intent intent2 = intent;
            Futures.a(a, new FutureCallback<OperationResult>(this) {
                final /* synthetic */ SystemTrayNotificationHelper f8934e;

                public void onSuccess(@Nullable Object obj) {
                    this.f8934e.m10839a(systemTrayNotification2, i3, i4, intent2);
                }

                public void onFailure(Throwable th) {
                    this.f8934e.m10839a(systemTrayNotification2, i3, i4, intent2);
                }
            }, this.f8953g);
        }
    }

    public final void m10839a(SystemTrayNotification systemTrayNotification, int i, int i2, @Nullable Intent intent) {
        if (this.f8965s.g) {
            this.f8954h.a(systemTrayNotification.c(), Event.DROPPED_BY_SEEN_STATE);
        } else if (this.f8952f.a(systemTrayNotification.x(), systemTrayNotification.mServerUtcSecs)) {
            this.f8954h.a(systemTrayNotification.c(), Event.DROPPED_BY_STALENESS);
        } else {
            String str;
            GraphQLStory graphQLStory;
            Intent intent2;
            String str2;
            GraphQLStory graphQLStory2 = null;
            if (intent == null && systemTrayNotification.d().isPresent()) {
                str = (String) systemTrayNotification.d().get();
                Object obj = null;
                if (this.f8967u.v()) {
                    NotificationsEdgeFieldsModel a = NotificationConnectionControllerHelper.m10799a(this.f8968v.a().d(), str);
                    if (a != null) {
                        obj = a.k().au().name();
                        graphQLStory2 = a.k();
                    }
                } else {
                    obj = this.f8952f.d(str);
                    graphQLStory2 = this.f8952f.b(str);
                }
                if (obj == null || GraphQLStorySeenState.UNSEEN_AND_UNREAD.name().equals(obj)) {
                    String g;
                    Builder builder = new Builder();
                    if (graphQLStory2 != null) {
                        g = graphQLStory2.g();
                    } else {
                        g = null;
                    }
                    builder.b = g;
                    Builder builder2 = builder;
                    builder2.a = str;
                    builder2 = builder2.e(graphQLStory2).f(graphQLStory2).a(graphQLStory2).d(graphQLStory2).b(graphQLStory2).c(graphQLStory2);
                    builder2.j = NotificationSource.PUSH;
                    builder2 = builder2;
                    GraphQLComment a2 = GraphQLHelper.a(graphQLStory2);
                    String h = GraphQLHelper.h(graphQLStory2);
                    if (!(a2 == null || h == null)) {
                        builder2.e = a2.y();
                        builder2.h = CommentOrderType.getOrder(h);
                    }
                    intent = m10829a(graphQLStory2, builder2.a(), systemTrayNotification);
                    graphQLStory = graphQLStory2;
                    intent2 = intent;
                    str2 = str;
                } else {
                    this.f8954h.a(systemTrayNotification.c(), Event.DROPPED_BY_SEEN_STATE);
                    return;
                }
            }
            graphQLStory = null;
            intent2 = intent;
            str2 = null;
            if (intent2 == null) {
                AbstractFbErrorReporter abstractFbErrorReporter = this.f8950d;
                String str3 = f8944a;
                StringBuilder append = new StringBuilder("intent is null for notification type: ").append(systemTrayNotification.a()).append(", raw type: ").append(systemTrayNotification.b()).append(", cacheid: ");
                if (graphQLStory == null) {
                    str = "";
                } else {
                    str = graphQLStory.g();
                }
                abstractFbErrorReporter.a(str3, append.append(str).toString());
                return;
            }
            int nextInt;
            NotificationLogObject c = systemTrayNotification.c();
            Optional h2 = systemTrayNotification.h();
            if (h2.isPresent()) {
                str = (String) h2.get();
            } else {
                str = (String) f8946w.get(systemTrayNotification.a());
            }
            c.c = str;
            boolean a3 = this.f8966t.a(ExperimentsForVideoHomeAbTestModule.p, false);
            Object obj2 = this.f8966t.a(ExperimentsForVideoHomeAbTestModule.j, 0) == 1 ? 1 : null;
            if (systemTrayNotification.a() == NotificationType.LIVE_VIDEO_ON_VIDEO_TAB && a3 && obj2 != null) {
                intent2.putExtra("target_tab_name", TabTag.VideoHome.name());
            } else {
                intent2.putExtra("target_tab_name", TabTag.Notifications.name());
            }
            SystemTrayNotificationBuilder a4 = ((SystemTrayNotificationBuilder) this.f8959m.get()).m9993a(systemTrayNotification.mMessage).m9997c(systemTrayNotification.mMessage).m9999d(this.f8949c.getApplicationContext().getResources().getString(this.f8949c.getApplicationInfo().labelRes)).m9989a(i2).m9991a(m10826a(systemTrayNotification));
            a4.f8403c = systemTrayNotification;
            SystemTrayNotificationBuilder systemTrayNotificationBuilder = a4;
            if (systemTrayNotification.i()) {
                systemTrayNotificationBuilder.m9988a();
            }
            if (systemTrayNotification.j()) {
                systemTrayNotificationBuilder.m9996c();
            }
            if (systemTrayNotification.k()) {
                systemTrayNotificationBuilder.m9994b();
            }
            boolean z = false;
            if (systemTrayNotification.n()) {
                nextInt = new Random().nextInt();
                z = m10836a(systemTrayNotification, c, nextInt, systemTrayNotificationBuilder);
            } else {
                nextInt = i;
            }
            if (z && systemTrayNotification.o()) {
                m10838b(systemTrayNotification, c, nextInt, systemTrayNotificationBuilder);
            }
            if (systemTrayNotification.m()) {
                systemTrayNotificationBuilder.m9995b(systemTrayNotification.w());
            }
            if (!(StringUtil.c((CharSequence) this.f8957k.get()) || str2 == null)) {
                GraphQLStory b;
                if (graphQLStory == null) {
                    b = this.f8952f.b(str2);
                } else {
                    b = graphQLStory;
                }
                CharSequence a5 = m10834a(systemTrayNotification, b);
                if (a5 != null) {
                    systemTrayNotificationBuilder.m9999d(a5);
                }
                if (b != null) {
                    a5 = this.f8956j.a(b, NotificationStoryHelper$NotificationLocation.SYSTEM_TRAY).a();
                    if (this.f8966t.a(ExperimentsForNotificationsAbtestModule.G, false)) {
                        systemTrayNotificationBuilder.m9993a(this.f8956j.b(b, NotificationStoryHelper$NotificationLocation.SYSTEM_TRAY));
                    } else {
                        systemTrayNotificationBuilder.m9993a(a5);
                    }
                    systemTrayNotificationBuilder.m9997c(a5);
                }
                graphQLStory = b;
            }
            if (this.f8960n.a(systemTrayNotification)) {
                this.f8960n.a(c, systemTrayNotification, m10826a(systemTrayNotification));
                systemTrayNotificationBuilder.f8409i = true;
            }
            m10835a(graphQLStory, systemTrayNotification, nextInt, intent2, c, systemTrayNotificationBuilder);
        }
    }

    private Intent m10830a(String str) {
        Intent intent = null;
        if (!StringUtil.a(str)) {
            intent = this.f8963q.a(this.f8949c, StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode(str)));
        }
        if (intent == null) {
            return this.f8963q.a(this.f8949c, FBLinks.cj);
        }
        return intent;
    }

    private void m10835a(@Nullable GraphQLStory graphQLStory, SystemTrayNotification systemTrayNotification, int i, Intent intent, NotificationLogObject notificationLogObject, SystemTrayNotificationBuilder systemTrayNotificationBuilder) {
        String str;
        String str2;
        if (graphQLStory == null) {
            str = null;
        } else {
            str = this.f8958l.a(graphQLStory);
        }
        if (str == null && systemTrayNotification.a() == NotificationType.FRIEND_REQUEST && systemTrayNotification.e().isPresent()) {
            str2 = (String) systemTrayNotification.e().orNull();
        } else {
            str2 = str;
        }
        if (StringUtil.c((CharSequence) this.f8957k.get()) || !systemTrayNotification.d().isPresent() || Strings.isNullOrEmpty(str2)) {
            this.f8958l.a(i, systemTrayNotificationBuilder, intent, Component.ACTIVITY, notificationLogObject);
            return;
        }
        final SystemTrayNotificationBuilder systemTrayNotificationBuilder2 = systemTrayNotificationBuilder;
        final NotificationLogObject notificationLogObject2 = notificationLogObject;
        final GraphQLStory graphQLStory2 = graphQLStory;
        final int i2 = i;
        final Intent intent2 = intent;
        final SystemTrayNotification systemTrayNotification2 = systemTrayNotification;
        this.f8951e.c(ImageRequest.a(str2), f8945b).a(new BaseBitmapDataSubscriber(this) {
            final /* synthetic */ SystemTrayNotificationHelper f8941g;

            protected final void m10824a(@Nullable Bitmap bitmap) {
                if (bitmap != null) {
                    systemTrayNotificationBuilder2.f8411k.g = bitmap;
                    notificationLogObject2.m = true;
                    if (graphQLStory2 != null) {
                        systemTrayNotificationBuilder2.m9992a(SystemTrayNotificationHelper.m10831a(this.f8941g, graphQLStory2, bitmap));
                    }
                }
                this.f8941g.f8958l.a(i2, systemTrayNotificationBuilder2, intent2, C07152.m10823a(systemTrayNotification2), notificationLogObject2);
            }

            protected final void m10825f(DataSource<CloseableReference<CloseableImage>> dataSource) {
                if (graphQLStory2 != null) {
                    systemTrayNotificationBuilder2.m9992a(SystemTrayNotificationHelper.m10831a(this.f8941g, graphQLStory2, null));
                }
                this.f8941g.f8958l.a(i2, systemTrayNotificationBuilder2, intent2, C07152.m10823a(systemTrayNotification2), notificationLogObject2);
            }

            private static Component m10823a(SystemTrayNotification systemTrayNotification) {
                if (systemTrayNotification.a() == NotificationType.NEKO_INSTALL_REMINDER) {
                    return Component.THIRD_PARTY_ACTIVITY;
                }
                return Component.ACTIVITY;
            }
        }, MoreExecutors.a());
    }

    public static WearableExtender m10831a(SystemTrayNotificationHelper systemTrayNotificationHelper, GraphQLStory graphQLStory, Bitmap bitmap) {
        int i = 0;
        WearableExtender wearableExtender = new WearableExtender();
        CharSequence b = systemTrayNotificationHelper.f8956j.b(graphQLStory, NotificationStoryHelper$NotificationLocation.PERMALINK);
        GraphQLStory L = graphQLStory.L();
        if (L != null) {
            graphQLStory = graphQLStory.L();
        }
        CharSequence b2 = systemTrayNotificationHelper.f8956j.b(graphQLStory, NotificationStoryHelper$NotificationLocation.WEARABLE_DETAIL);
        if (L != null) {
            CharSequence spannableString = new SpannableString(StoryActorHelper.b(L).aa());
            if (!(TextUtils.isEmpty(spannableString) || TextUtils.isEmpty(b2))) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (spannableStringBuilder.length() > 0) {
                    spannableStringBuilder.append("\n\n");
                }
                spannableStringBuilder.append(spannableString);
                spannableStringBuilder.append("\n");
                spannableStringBuilder.append(b2);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(systemTrayNotificationHelper.f8949c.getResources().getColor(17170448)), TextUtils.isEmpty(b2) ? 0 : b2.length(), spannableStringBuilder.length(), 33);
                b2 = spannableStringBuilder;
            }
        }
        if (!(TextUtils.isEmpty(b) || TextUtils.isEmpty(b2) || TextUtils.equals(b, b2))) {
            wearableExtender.a(new NotificationCompat.Builder(systemTrayNotificationHelper.f8949c).a(b).b(b2).a(new BigTextStyle().b(b2)).c());
        }
        GraphQLFeedback l = graphQLStory.l();
        ImmutableList j = (l == null || l.L() == null) ? null : l.L().j();
        if (!(j == null || j.isEmpty())) {
            CharSequence spannableStringBuilder2 = new SpannableStringBuilder();
            ImmutableList reverse = j.reverse();
            int size = reverse.size();
            while (i < size) {
                GraphQLComment graphQLComment = (GraphQLComment) reverse.get(i);
                CharSequence a = GraphQLCommentHelper.a(graphQLComment);
                if (!(TextUtils.isEmpty(a) || graphQLComment.s() == null)) {
                    if (spannableStringBuilder2.length() > 0) {
                        spannableStringBuilder2.append("\n\n");
                    }
                    int length = spannableStringBuilder2.length();
                    spannableStringBuilder2.append(a);
                    spannableStringBuilder2.setSpan(new StyleSpan(1), length, spannableStringBuilder2.length(), 33);
                    spannableStringBuilder2.append(": ");
                    spannableStringBuilder2.append(systemTrayNotificationHelper.f8964r.a(graphQLComment.s(), -1));
                }
                i++;
            }
            if (spannableStringBuilder2.length() > 0) {
                NotificationCompat.Builder a2 = new NotificationCompat.Builder(systemTrayNotificationHelper.f8949c).a(systemTrayNotificationHelper.f8949c.getString(2131233665)).b(spannableStringBuilder2).a(new BigTextStyle().b(spannableStringBuilder2));
                new WearableExtender().a(true).a(a2);
                wearableExtender.a(a2.c());
            }
        }
        if (bitmap != null) {
            wearableExtender.e = bitmap;
        }
        return wearableExtender;
    }

    private String m10834a(SystemTrayNotification systemTrayNotification, @Nullable GraphQLStory graphQLStory) {
        if (graphQLStory == null || systemTrayNotification == null) {
            return null;
        }
        switch (C07163.f8942a[systemTrayNotification.a().ordinal()]) {
            case 1:
                if (m10833a(graphQLStory) != null) {
                    return m10833a(graphQLStory);
                }
                return null;
            default:
                return null;
        }
    }

    private static String m10833a(GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return null;
        }
        if (graphQLStory.aJ() != null && graphQLStory.aJ().j() != null && graphQLStory.aJ().j().g() == 69076575) {
            return graphQLStory.aJ().U();
        }
        if (graphQLStory.L() != null && graphQLStory.L().aJ() != null && graphQLStory.L().aJ().j() != null && graphQLStory.L().aJ().j().g() == 69076575) {
            return graphQLStory.L().aJ().U();
        }
        if (!StoryHierarchyHelper.a(graphQLStory).j().isEmpty()) {
            GraphQLProfile aJ = ((GraphQLStory) StoryHierarchyHelper.a(graphQLStory).j().get(0)).aJ();
            if (!(aJ == null || aJ.j() == null || aJ.j().g() != 69076575)) {
                return aJ.U();
            }
        }
        return null;
    }

    public static long m10826a(SystemTrayNotification systemTrayNotification) {
        if (systemTrayNotification.mServerUtcSecs <= 1072944000 || systemTrayNotification.mServerUtcSecs >= 1577865600) {
            return System.currentTimeMillis();
        }
        return systemTrayNotification.mServerUtcSecs * 1000;
    }

    @Nullable
    private Intent m10829a(GraphQLStory graphQLStory, PermalinkStoryIdParams permalinkStoryIdParams, SystemTrayNotification systemTrayNotification) {
        Intent a = this.f8956j.a(this.f8949c, graphQLStory);
        if (a == null) {
            a = this.f8958l.e.a(permalinkStoryIdParams);
        }
        if (a != null) {
            return a;
        }
        SystemTrayNotificationManager systemTrayNotificationManager = this.f8958l;
        Intent intent = null;
        if (!(systemTrayNotification == null || systemTrayNotification.mHref == null)) {
            intent = systemTrayNotificationManager.g.a(systemTrayNotificationManager.a, StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode(systemTrayNotification.mHref)));
        }
        if (intent == null) {
            intent = systemTrayNotificationManager.g.a(systemTrayNotificationManager.a, FBLinks.cj);
        }
        return intent;
    }

    private PendingIntent m10828a(ActionType actionType, NotificationLogObject notificationLogObject, SystemTrayNotification systemTrayNotification, int i) {
        switch (C07163.f8943b[actionType.ordinal()]) {
            case 1:
                return m10827a(new Intent(this.f8949c, LoginApprovalNotificationService.class).putExtra("a_md", (String) systemTrayNotification.v().get()).putExtra("arg_action", "action_approve"), notificationLogObject, Component.SERVICE, Event.click_primary_action, i);
            default:
                return null;
        }
    }

    private PendingIntent m10827a(Intent intent, NotificationLogObject notificationLogObject, Component component, Event event, int i) {
        intent.putExtra("notification_launch_source", "source_system_tray");
        return SecurePendingIntent.c(this.f8949c, (int) this.f8962p.now(), this.f8955i.a(notificationLogObject, intent, component, event, i), 268435456);
    }

    private boolean m10836a(SystemTrayNotification systemTrayNotification, NotificationLogObject notificationLogObject, int i, SystemTrayNotificationBuilder systemTrayNotificationBuilder) {
        int i2;
        String str = (String) systemTrayNotification.t().get();
        PendingIntent pendingIntent = null;
        if (systemTrayNotification.p().isPresent()) {
            ActionType actionType = (ActionType) SystemTrayNotification.b.get(systemTrayNotification.p().get());
            int intValue = ((Integer) f8947x.get(actionType)).intValue();
            pendingIntent = m10828a(actionType, notificationLogObject, systemTrayNotification, i);
            i2 = intValue;
        } else {
            i2 = 0;
        }
        if (pendingIntent == null && systemTrayNotification.r().isPresent()) {
            pendingIntent = m10827a(m10830a((String) systemTrayNotification.r().get()), notificationLogObject, Component.ACTIVITY, Event.click_primary_action, i);
        }
        if (StringUtil.a(str) || pendingIntent == null) {
            return false;
        }
        systemTrayNotificationBuilder.m9990a(i2, str, pendingIntent);
        return true;
    }

    private boolean m10838b(SystemTrayNotification systemTrayNotification, NotificationLogObject notificationLogObject, int i, SystemTrayNotificationBuilder systemTrayNotificationBuilder) {
        int i2;
        String str = (String) systemTrayNotification.u().get();
        PendingIntent pendingIntent = null;
        if (systemTrayNotification.q().isPresent()) {
            ActionType actionType = (ActionType) SystemTrayNotification.b.get(systemTrayNotification.q().get());
            int intValue = ((Integer) f8947x.get(actionType)).intValue();
            pendingIntent = m10828a(actionType, notificationLogObject, systemTrayNotification, i);
            i2 = intValue;
        } else {
            i2 = 0;
        }
        if (pendingIntent == null && systemTrayNotification.s().isPresent()) {
            pendingIntent = m10827a(m10830a((String) systemTrayNotification.s().get()), notificationLogObject, Component.ACTIVITY, Event.click_secondary_action, i);
        }
        if (StringUtil.a(str) || pendingIntent == null) {
            return false;
        }
        systemTrayNotificationBuilder.m9990a(i2, str, pendingIntent);
        return true;
    }
}
