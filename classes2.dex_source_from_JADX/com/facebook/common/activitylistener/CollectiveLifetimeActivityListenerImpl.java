package com.facebook.common.activitylistener;

import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import com.android.debug.hv.ViewServer;
import com.facebook.aldrin.transition.activity.AldrinStatusCheckActivityListener;
import com.facebook.analytics.AnalyticsActivityListener;
import com.facebook.analytics.impression.ImpressionActivityListener;
import com.facebook.apptab.ui.nux.AppTabInterstitialController;
import com.facebook.apptab.ui.nux.MainTabNuxController;
import com.facebook.auth.activity.AuthenticatedActivityHelper;
import com.facebook.bugreporter.BugReportAcknowledgementListener;
import com.facebook.bugreporter.BugReportAcknowledgementListener.1;
import com.facebook.bugreporter.activity.BugReportActivity;
import com.facebook.common.activitycleaner.ActivityCleaner;
import com.facebook.common.activitylistener.annotations.AuthNotRequiredHelper;
import com.facebook.common.appchoreographer.ChoreographedActivityListener;
import com.facebook.debug.viewserver.HierarchyViewerActivityListener;
import com.facebook.dialtone.activitylistener.DialtoneActivityListener;
import com.facebook.fbservice.ops.CriticalServiceExceptionChecker;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.runtimelinter.UIRuntimeLinter;
import com.facebook.fbui.runtimelinter.listener.UIRuntimeLinterActivityListener;
import com.facebook.fbui.uimetrics.UiMetricsActivityListener;
import com.facebook.feed.autoplay.FeedAutoplayActivityListener;
import com.facebook.feed.autoplay.VideoDisplayedCoordinator;
import com.facebook.feedplugins.attachments.video.AutoplayVisibilityRunnable;
import com.facebook.feedplugins.attachments.video.AutoplayVisibilityRunnableActivityListener;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialActivityListener;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.katana.orca.MessagesDataInitializationActivityHelper;
import com.facebook.languages.switcher.LanguageSwitcherListener;
import com.facebook.messages.ipc.peer.MessageNotificationPeerContract;
import com.facebook.messaging.chatheads.ipc.ChatHeadsActivityListener;
import com.facebook.notifications.activitylistener.NotificationsActivityListener;
import com.facebook.notifications.logging.NotificationsLogger;
import com.facebook.notifications.logging.NotificationsLogger.Event;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.orca.notify.MessagesForegroundActivityListener;
import com.facebook.perf.listener.FB4APerfActivityListener;
import com.facebook.resources.impl.StringResourcesActivityListener;
import com.facebook.selfupdate.SelfUpdateActivityListener;
import com.facebook.selfupdate.SelfUpdateInstallActivity;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.engine.VideoEngineUtils;
import com.facebook.video.engine.texview.ProxyActivityListener;
import com.facebook.video.engine.texview.TextureAttachManager;
import com.facebook.video.player.PlayerActivityManager;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.plugins.PlaybackController;
import com.facebook.video.videohome.audio.VideoHomeInlineAudioManager;
import com.facebook.widget.recycle.ViewPoolCleaner;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: suggetifier_response_id */
public class CollectiveLifetimeActivityListenerImpl implements CollectiveLifetimeActivityListener {
    private final Lazy<AldrinStatusCheckActivityListener> f3838a;
    private final Lazy<ImpressionActivityListener> f3839b;
    private final Lazy<AnalyticsActivityListener> f3840c;
    private final Lazy<AuthenticatedActivityHelper> f3841d;
    private final Lazy<BugReportAcknowledgementListener> f3842e;
    private final Lazy<ActivityCleaner> f3843f;
    private final Lazy<ChoreographedActivityListener> f3844g;
    private final Lazy<HierarchyViewerActivityListener> f3845h;
    private final Lazy<DialtoneActivityListener> f3846i;
    private final Lazy<UIRuntimeLinterActivityListener> f3847j;
    private final Lazy<UiMetricsActivityListener> f3848k;
    private final Lazy<FeedAutoplayActivityListener> f3849l;
    private final Lazy<AutoplayVisibilityRunnableActivityListener> f3850m;
    private final Lazy<InterstitialActivityListener> f3851n;
    private final Lazy<MessagesDataInitializationActivityHelper> f3852o;
    private final Lazy<LanguageSwitcherListener> f3853p;
    private final Lazy<ChatHeadsActivityListener> f3854q;
    private final Lazy<NotificationsActivityListener> f3855r;
    private final Lazy<MessagesForegroundActivityListener> f3856s;
    private final Lazy<FB4APerfActivityListener> f3857t;
    private final Lazy<StringResourcesActivityListener> f3858u;
    private final Lazy<SelfUpdateActivityListener> f3859v;
    private final Lazy<ProxyActivityListener> f3860w;
    private final Lazy<TextureAttachManager> f3861x;
    private final Lazy<PlayerActivityManager> f3862y;
    private final Lazy<VideoHomeInlineAudioManager> f3863z;

    public static CollectiveLifetimeActivityListenerImpl m6402b(InjectorLike injectorLike) {
        return new CollectiveLifetimeActivityListenerImpl(IdBasedSingletonScopeProvider.m1810b(injectorLike, 113), IdBasedLazy.m1808a(injectorLike, 172), IdBasedSingletonScopeProvider.m1810b(injectorLike, 116), IdBasedLazy.m1808a(injectorLike, 331), IdBasedLazy.m1808a(injectorLike, 421), IdBasedSingletonScopeProvider.m1810b(injectorLike, 456), IdBasedLazy.m1808a(injectorLike, 469), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1042), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1097), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1277), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1279), IdBasedLazy.m1808a(injectorLike, 1297), IdBasedLazy.m1808a(injectorLike, 1808), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2356), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2410), IdBasedLazy.m1808a(injectorLike, 2451), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2576), IdBasedSingletonScopeProvider.m1810b(injectorLike, 8688), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2898), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2951), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3280), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3410), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3676), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3680), IdBasedLazy.m1808a(injectorLike, 3685), IdBasedLazy.m1808a(injectorLike, 11645));
    }

    public final Optional<Boolean> mo244a() {
        return Absent.INSTANCE;
    }

    public final Optional<Boolean> mo254b(Activity activity, int i, KeyEvent keyEvent) {
        return Absent.INSTANCE;
    }

    @Inject
    public CollectiveLifetimeActivityListenerImpl(Lazy<AldrinStatusCheckActivityListener> lazy, Lazy<ImpressionActivityListener> lazy2, Lazy<AnalyticsActivityListener> lazy3, Lazy<AuthenticatedActivityHelper> lazy4, Lazy<BugReportAcknowledgementListener> lazy5, Lazy<ActivityCleaner> lazy6, Lazy<ChoreographedActivityListener> lazy7, Lazy<HierarchyViewerActivityListener> lazy8, Lazy<DialtoneActivityListener> lazy9, Lazy<UIRuntimeLinterActivityListener> lazy10, Lazy<UiMetricsActivityListener> lazy11, Lazy<FeedAutoplayActivityListener> lazy12, Lazy<AutoplayVisibilityRunnableActivityListener> lazy13, Lazy<InterstitialActivityListener> lazy14, Lazy<MessagesDataInitializationActivityHelper> lazy15, Lazy<LanguageSwitcherListener> lazy16, Lazy<ChatHeadsActivityListener> lazy17, Lazy<NotificationsActivityListener> lazy18, Lazy<MessagesForegroundActivityListener> lazy19, Lazy<FB4APerfActivityListener> lazy20, Lazy<StringResourcesActivityListener> lazy21, Lazy<SelfUpdateActivityListener> lazy22, Lazy<ProxyActivityListener> lazy23, Lazy<TextureAttachManager> lazy24, Lazy<PlayerActivityManager> lazy25, Lazy<VideoHomeInlineAudioManager> lazy26) {
        this.f3838a = lazy;
        this.f3839b = lazy2;
        this.f3840c = lazy3;
        this.f3841d = lazy4;
        this.f3842e = lazy5;
        this.f3843f = lazy6;
        this.f3844g = lazy7;
        this.f3845h = lazy8;
        this.f3846i = lazy9;
        this.f3847j = lazy10;
        this.f3848k = lazy11;
        this.f3849l = lazy12;
        this.f3850m = lazy13;
        this.f3851n = lazy14;
        this.f3852o = lazy15;
        this.f3853p = lazy16;
        this.f3854q = lazy17;
        this.f3855r = lazy18;
        this.f3856s = lazy19;
        this.f3857t = lazy20;
        this.f3858u = lazy21;
        this.f3859v = lazy22;
        this.f3860w = lazy23;
        this.f3861x = lazy24;
        this.f3862y = lazy25;
        this.f3863z = lazy26;
    }

    public final void mo261a(Activity activity) {
        AldrinStatusCheckActivityListener aldrinStatusCheckActivityListener = (AldrinStatusCheckActivityListener) this.f3838a.get();
        TracerDetour.a(aldrinStatusCheckActivityListener.getClass().getName(), 369531202);
        try {
            aldrinStatusCheckActivityListener.m12839a(activity);
            AuthenticatedActivityHelper authenticatedActivityHelper = (AuthenticatedActivityHelper) this.f3841d.get();
            TracerDetour.a(authenticatedActivityHelper.getClass().getName(), -31109326);
            try {
                authenticatedActivityHelper.m6532a(activity);
                ActivityCleaner activityCleaner = (ActivityCleaner) this.f3843f.get();
                TracerDetour.a(activityCleaner.getClass().getName(), 1440329456);
                try {
                    activityCleaner.m12851a(activity);
                    ChoreographedActivityListener choreographedActivityListener = (ChoreographedActivityListener) this.f3844g.get();
                    TracerDetour.a(choreographedActivityListener.getClass().getName(), 1200752557);
                    try {
                        choreographedActivityListener.m12862a(activity);
                        HierarchyViewerActivityListener hierarchyViewerActivityListener = (HierarchyViewerActivityListener) this.f3845h.get();
                        TracerDetour.a(hierarchyViewerActivityListener.getClass().getName(), -480818568);
                        try {
                            hierarchyViewerActivityListener.m12871a(activity);
                            InterstitialActivityListener interstitialActivityListener = (InterstitialActivityListener) this.f3851n.get();
                            TracerDetour.a(interstitialActivityListener.getClass().getName(), -895691031);
                            try {
                                interstitialActivityListener.m12876a(activity);
                                FB4APerfActivityListener fB4APerfActivityListener = (FB4APerfActivityListener) this.f3857t.get();
                                TracerDetour.a(fB4APerfActivityListener.getClass().getName(), -194835503);
                                try {
                                    fB4APerfActivityListener.m12880a(activity);
                                } finally {
                                    TracerDetour.a(160891960);
                                }
                            } finally {
                                TracerDetour.a(1750312666);
                            }
                        } finally {
                            TracerDetour.a(548781353);
                        }
                    } finally {
                        TracerDetour.a(-449750453);
                    }
                } finally {
                    TracerDetour.a(1108324423);
                }
            } finally {
                TracerDetour.a(-27972535);
            }
        } finally {
            TracerDetour.a(-338706931);
        }
    }

    public final void mo262b(Activity activity) {
        ActivityCleaner activityCleaner = (ActivityCleaner) this.f3843f.get();
        TracerDetour.a(activityCleaner.getClass().getName(), 1613198036);
        try {
            activityCleaner.m12853b(activity);
            DialtoneActivityListener dialtoneActivityListener = (DialtoneActivityListener) this.f3846i.get();
            TracerDetour.a(dialtoneActivityListener.getClass().getName(), 423990672);
            try {
                dialtoneActivityListener.m12975a(activity);
                SelfUpdateActivityListener selfUpdateActivityListener = (SelfUpdateActivityListener) this.f3859v.get();
                TracerDetour.a(selfUpdateActivityListener.getClass().getName(), -1164079362);
                try {
                    selfUpdateActivityListener.m12981a(activity);
                    PlayerActivityManager playerActivityManager = (PlayerActivityManager) this.f3862y.get();
                    TracerDetour.a(playerActivityManager.getClass().getName(), 1372697950);
                    try {
                        playerActivityManager.m13003c();
                    } finally {
                        TracerDetour.a(-1620543539);
                    }
                } finally {
                    TracerDetour.a(-30836935);
                }
            } finally {
                TracerDetour.a(-774846185);
            }
        } finally {
            TracerDetour.a(50106337);
        }
    }

    public final void mo263c(Activity activity) {
        ImpressionActivityListener impressionActivityListener = (ImpressionActivityListener) this.f3839b.get();
        TracerDetour.a(impressionActivityListener.getClass().getName(), -589615764);
        try {
            impressionActivityListener.m13013a(activity);
            AnalyticsActivityListener analyticsActivityListener = (AnalyticsActivityListener) this.f3840c.get();
            TracerDetour.a(analyticsActivityListener.getClass().getName(), 938996818);
            try {
                analyticsActivityListener.m13018a(activity);
                AuthenticatedActivityHelper authenticatedActivityHelper = (AuthenticatedActivityHelper) this.f3841d.get();
                TracerDetour.a(authenticatedActivityHelper.getClass().getName(), -243765788);
                try {
                    authenticatedActivityHelper.m6534b(activity);
                    HierarchyViewerActivityListener hierarchyViewerActivityListener = (HierarchyViewerActivityListener) this.f3845h.get();
                    TracerDetour.a(hierarchyViewerActivityListener.getClass().getName(), -149009033);
                    try {
                        hierarchyViewerActivityListener.m12872c(activity);
                        DialtoneActivityListener dialtoneActivityListener = (DialtoneActivityListener) this.f3846i.get();
                        TracerDetour.a(dialtoneActivityListener.getClass().getName(), -1611551091);
                        try {
                            dialtoneActivityListener.m12977b(activity);
                            UIRuntimeLinterActivityListener uIRuntimeLinterActivityListener = (UIRuntimeLinterActivityListener) this.f3847j.get();
                            TracerDetour.a(uIRuntimeLinterActivityListener.getClass().getName(), -536290021);
                            try {
                                uIRuntimeLinterActivityListener.m13046a(activity);
                                UiMetricsActivityListener uiMetricsActivityListener = (UiMetricsActivityListener) this.f3848k.get();
                                TracerDetour.a(uiMetricsActivityListener.getClass().getName(), -271828767);
                                try {
                                    uiMetricsActivityListener.m13075a(activity);
                                    FeedAutoplayActivityListener feedAutoplayActivityListener = (FeedAutoplayActivityListener) this.f3849l.get();
                                    TracerDetour.a(feedAutoplayActivityListener.getClass().getName(), -1805933953);
                                    try {
                                        feedAutoplayActivityListener.m13078a();
                                        AutoplayVisibilityRunnableActivityListener autoplayVisibilityRunnableActivityListener = (AutoplayVisibilityRunnableActivityListener) this.f3850m.get();
                                        TracerDetour.a(autoplayVisibilityRunnableActivityListener.getClass().getName(), -607282750);
                                        try {
                                            autoplayVisibilityRunnableActivityListener.m13081a();
                                            LanguageSwitcherListener languageSwitcherListener = (LanguageSwitcherListener) this.f3853p.get();
                                            TracerDetour.a(languageSwitcherListener.getClass().getName(), 1326674198);
                                            try {
                                                languageSwitcherListener.m6545a(activity);
                                                ChatHeadsActivityListener chatHeadsActivityListener = (ChatHeadsActivityListener) this.f3854q.get();
                                                TracerDetour.a(chatHeadsActivityListener.getClass().getName(), 2039054695);
                                                try {
                                                    chatHeadsActivityListener.m13086a(activity);
                                                    MessagesForegroundActivityListener messagesForegroundActivityListener = (MessagesForegroundActivityListener) this.f3856s.get();
                                                    TracerDetour.a(messagesForegroundActivityListener.getClass().getName(), -96236768);
                                                    try {
                                                        messagesForegroundActivityListener.m13091a(activity);
                                                        ProxyActivityListener proxyActivityListener = (ProxyActivityListener) this.f3860w.get();
                                                        TracerDetour.a(proxyActivityListener.getClass().getName(), 1410321803);
                                                        try {
                                                            proxyActivityListener.m13095a(activity);
                                                            TextureAttachManager textureAttachManager = (TextureAttachManager) this.f3861x.get();
                                                            TracerDetour.a(textureAttachManager.getClass().getName(), -1324943233);
                                                            try {
                                                                textureAttachManager.m13101a(activity);
                                                                PlayerActivityManager playerActivityManager = (PlayerActivityManager) this.f3862y.get();
                                                                TracerDetour.a(playerActivityManager.getClass().getName(), -727472844);
                                                                try {
                                                                    playerActivityManager.m12997a();
                                                                } finally {
                                                                    TracerDetour.a(-1672797850);
                                                                }
                                                            } finally {
                                                                TracerDetour.a(-499922799);
                                                            }
                                                        } finally {
                                                            TracerDetour.a(-1040754115);
                                                        }
                                                    } finally {
                                                        TracerDetour.a(-1231128047);
                                                    }
                                                } finally {
                                                    TracerDetour.a(288382951);
                                                }
                                            } finally {
                                                TracerDetour.a(1175521200);
                                            }
                                        } finally {
                                            TracerDetour.a(-455768430);
                                        }
                                    } finally {
                                        TracerDetour.a(-1465647295);
                                    }
                                } finally {
                                    TracerDetour.a(-2100433344);
                                }
                            } finally {
                                TracerDetour.a(-2119523034);
                            }
                        } finally {
                            TracerDetour.a(120347289);
                        }
                    } finally {
                        TracerDetour.a(1289586999);
                    }
                } finally {
                    TracerDetour.a(-936520800);
                }
            } finally {
                TracerDetour.a(-414989287);
            }
        } finally {
            TracerDetour.a(-720049966);
        }
    }

    public final void mo242d(Activity activity) {
        ((AnalyticsActivityListener) this.f3840c.get()).f8462e.m5518c(activity);
        ((ActivityCleaner) this.f3843f.get()).m12854c(activity);
        ((DialtoneActivityListener) this.f3846i.get()).f8426f = null;
        UIRuntimeLinter uIRuntimeLinter = ((UIRuntimeLinterActivityListener) this.f3847j.get()).f8494a;
        HandlerDetour.a(uIRuntimeLinter.f8498c, uIRuntimeLinter.f8510o);
        uIRuntimeLinter.f8510o = null;
        uIRuntimeLinter.f8509n.clear();
        UiMetricsActivityListener uiMetricsActivityListener = (UiMetricsActivityListener) this.f3848k.get();
        View view = uiMetricsActivityListener.f8526d != null ? (View) uiMetricsActivityListener.f8526d.get() : null;
        if (view != null) {
            view.removeCallbacks(uiMetricsActivityListener.f8528f);
        }
        uiMetricsActivityListener.f8526d = null;
        FeedAutoplayActivityListener feedAutoplayActivityListener = (FeedAutoplayActivityListener) this.f3849l.get();
        VideoEngineUtils.m13008a(feedAutoplayActivityListener.f8533b);
        for (WeakReference weakReference : feedAutoplayActivityListener.f8533b) {
            VideoDisplayedCoordinator videoDisplayedCoordinator = (VideoDisplayedCoordinator) weakReference.get();
            if (videoDisplayedCoordinator != null) {
                videoDisplayedCoordinator.m26592c();
            }
        }
        AutoplayVisibilityRunnableActivityListener autoplayVisibilityRunnableActivityListener = (AutoplayVisibilityRunnableActivityListener) this.f3850m.get();
        VideoEngineUtils.m13008a(autoplayVisibilityRunnableActivityListener.f8536a);
        for (WeakReference weakReference2 : autoplayVisibilityRunnableActivityListener.f8536a) {
            AutoplayVisibilityRunnable autoplayVisibilityRunnable = (AutoplayVisibilityRunnable) weakReference2.get();
            if (autoplayVisibilityRunnable != null) {
                autoplayVisibilityRunnable.e = false;
            }
        }
        MessagesForegroundActivityListener messagesForegroundActivityListener = (MessagesForegroundActivityListener) this.f3856s.get();
        messagesForegroundActivityListener.f8545b = null;
        if (messagesForegroundActivityListener.f8544a != null) {
            messagesForegroundActivityListener.f8544a.m4872a(MessageNotificationPeerContract.f2848n, Boolean.valueOf(false));
        }
        ProxyActivityListener proxyActivityListener = (ProxyActivityListener) this.f3860w.get();
        proxyActivityListener.f8549a = false;
        if (proxyActivityListener.f8550b != null) {
            proxyActivityListener.f8550b.mo242d(activity);
        }
        ((TextureAttachManager) this.f3861x.get()).m13103b(activity);
        ((PlayerActivityManager) this.f3862y.get()).m13001b();
    }

    public final void mo264e(Activity activity) {
        ((DialtoneActivityListener) this.f3846i.get()).m12978f();
        ((ChatHeadsActivityListener) this.f3854q.get()).m13087b(activity);
        SelfUpdateActivityListener selfUpdateActivityListener = (SelfUpdateActivityListener) this.f3859v.get();
        if (selfUpdateActivityListener.f8432a instanceof SelfUpdateInstallActivity) {
            selfUpdateActivityListener.f8433b = false;
        }
        selfUpdateActivityListener.f8432a = null;
        ((PlayerActivityManager) this.f3862y.get()).m13004d();
    }

    public final void mo265f(Activity activity) {
        AuthenticatedActivityHelper authenticatedActivityHelper = (AuthenticatedActivityHelper) this.f3841d.get();
        if (!AuthNotRequiredHelper.m6539a(activity)) {
            if (authenticatedActivityHelper.f3929a != null) {
                authenticatedActivityHelper.f3929a.mo1933b();
                authenticatedActivityHelper.f3929a = null;
            }
            if (authenticatedActivityHelper.f3939l != null) {
                authenticatedActivityHelper.f3939l.m3297c();
                authenticatedActivityHelper.f3939l = null;
            }
        }
        ActivityCleaner activityCleaner = (ActivityCleaner) this.f3843f.get();
        if (activity instanceof ViewPoolCleaner) {
            ((ViewPoolCleaner) activity).mo793e();
        }
        activityCleaner.f8332f.m4304b(activity);
        activityCleaner.f8332f.m4308f();
        if (((Boolean) ((HierarchyViewerActivityListener) this.f3845h.get()).f8360a.get()).booleanValue()) {
            ViewServer.a(activity).b(activity);
        }
        ((TextureAttachManager) this.f3861x.get()).m13105c(activity);
    }

    public final void mo249a(Activity activity, Bundle bundle) {
        ((AuthenticatedActivityHelper) this.f3841d.get()).m6533a(activity, bundle);
    }

    public final void mo255b(Activity activity, Bundle bundle) {
        MessagesDataInitializationActivityHelper messagesDataInitializationActivityHelper = (MessagesDataInitializationActivityHelper) this.f3852o.get();
        TracerDetour.a(messagesDataInitializationActivityHelper.getClass().getName(), -976815637);
        try {
            messagesDataInitializationActivityHelper.m6542a(activity);
            LanguageSwitcherListener languageSwitcherListener = (LanguageSwitcherListener) this.f3853p.get();
            TracerDetour.a(languageSwitcherListener.getClass().getName(), 1209648874);
            try {
                languageSwitcherListener.m6546b();
                StringResourcesActivityListener stringResourcesActivityListener = (StringResourcesActivityListener) this.f3858u.get();
                TracerDetour.a(stringResourcesActivityListener.getClass().getName(), -171829033);
                try {
                    stringResourcesActivityListener.m6549a(activity);
                } finally {
                    TracerDetour.a(-1786976395);
                }
            } finally {
                TracerDetour.a(246810078);
            }
        } finally {
            TracerDetour.a(-1172925051);
        }
    }

    public final void mo251a(Bundle bundle) {
    }

    public final void mo247a(Activity activity, Intent intent) {
        ((ActivityCleaner) this.f3843f.get()).f8332f.m4308f();
        DialtoneActivityListener dialtoneActivityListener = (DialtoneActivityListener) this.f3846i.get();
        dialtoneActivityListener.f8429i = dialtoneActivityListener.f8425e.mo1214a((Context) activity, intent);
        NotificationsActivityListener notificationsActivityListener = (NotificationsActivityListener) this.f3855r.get();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                Event event = (Event) extras.get("EVENT_TYPE");
                NotificationLogObject notificationLogObject = (NotificationLogObject) extras.getParcelable("NOTIF_LOG");
                if (event != null && notificationLogObject != null && event.equals(Event.COMMENT_FROM_TRAY)) {
                    ((NotificationsLogger) notificationsActivityListener.a.get()).a(notificationLogObject, Event.COMMENT_FROM_TRAY);
                    ((NotificationsUtils) notificationsActivityListener.c.get()).a(notificationLogObject);
                    int i = notificationLogObject.q;
                    String str = notificationLogObject.r;
                    if (i >= 0 && str != null) {
                        ((NotificationManager) notificationsActivityListener.b.get()).cancel(str, i);
                    }
                }
            }
        }
    }

    public final void mo258g(Activity activity) {
        ((ChoreographedActivityListener) this.f3844g.get()).m12863b(activity);
    }

    public final void mo259h(Activity activity) {
    }

    public final Optional<Boolean> mo245a(Activity activity, int i, KeyEvent keyEvent) {
        VideoHomeInlineAudioManager videoHomeInlineAudioManager = (VideoHomeInlineAudioManager) this.f3863z.get();
        if (i == 25 || i == 24) {
            videoHomeInlineAudioManager.e = false;
            if (videoHomeInlineAudioManager.d()) {
                RichVideoPlayer richVideoPlayer = videoHomeInlineAudioManager.f != null ? (RichVideoPlayer) videoHomeInlineAudioManager.f.get() : null;
                if (richVideoPlayer != null) {
                    PlaybackController playbackController = richVideoPlayer.u;
                    if (richVideoPlayer.m() && richVideoPlayer.x == PlayerOrigin.VIDEO_HOME && playbackController != null && playbackController.q == PlayerType.INLINE_PLAYER) {
                        richVideoPlayer.a(false, EventTriggerType.BY_USER);
                    }
                }
            }
        }
        Optional optional = Absent.INSTANCE;
        if (optional.isPresent()) {
            return optional;
        }
        return Absent.INSTANCE;
    }

    public final Dialog mo243a(int i) {
        return null;
    }

    public final boolean mo252a(int i, Dialog dialog) {
        return false;
    }

    public final boolean mo260i(Activity activity) {
        AnalyticsActivityListener analyticsActivityListener = (AnalyticsActivityListener) this.f3840c.get();
        if (analyticsActivityListener.f8462e.f3310u == null) {
            analyticsActivityListener.f8462e.m5498a("tap_back_button");
        }
        if (null != null) {
            return true;
        }
        return false;
    }

    public final void mo248a(Activity activity, Configuration configuration) {
        AnalyticsActivityListener analyticsActivityListener = (AnalyticsActivityListener) this.f3840c.get();
        analyticsActivityListener.f8462e.m5500a(analyticsActivityListener.f8459b.getDefaultDisplay().getRotation(), false);
        InterstitialActivityListener interstitialActivityListener = (InterstitialActivityListener) this.f3851n.get();
        if (interstitialActivityListener.f8363a.m2278c()) {
            InterstitialController a = interstitialActivityListener.f8364b.m8117a(new InterstitialTrigger(Action.ACTIVITY_CONFIGURATION_CHANGED, activity.getClass()));
            if (a != null && (a instanceof AppTabInterstitialController)) {
                MainTabNuxController mainTabNuxController = ((AppTabInterstitialController) a).f4255b;
                if (mainTabNuxController.m7891h() && mainTabNuxController.f4262d != null) {
                    mainTabNuxController.m7887b(mainTabNuxController.f4262d);
                }
            }
        }
        ((LanguageSwitcherListener) this.f3853p.get()).m6544a();
    }

    public final boolean mo253a(Activity activity, Throwable th) {
        AuthenticatedActivityHelper authenticatedActivityHelper = (AuthenticatedActivityHelper) this.f3841d.get();
        Object obj = null;
        if (!AuthNotRequiredHelper.m6539a(activity) && CriticalServiceExceptionChecker.m6536a(th)) {
            AuthenticatedActivityHelper.m6530d(authenticatedActivityHelper, activity);
            obj = 1;
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    public final boolean mo257b() {
        return false;
    }

    public final void mo246a(Activity activity, int i, int i2, Intent intent) {
        BugReportAcknowledgementListener bugReportAcknowledgementListener = (BugReportAcknowledgementListener) this.f3842e.get();
        if (i2 == -1 && BugReportActivity.a(i, intent) && intent.getBooleanExtra("isSendClickedFlag", false)) {
            new Builder(activity).a(2131235813).b(2131235814).a(2131235815, new 1(bugReportAcknowledgementListener)).b();
        }
    }

    public final void mo256b(Bundle bundle) {
        AuthenticatedActivityHelper authenticatedActivityHelper = (AuthenticatedActivityHelper) this.f3841d.get();
        if (authenticatedActivityHelper.f3938k != null) {
            bundle.putString("loggedInUser", authenticatedActivityHelper.f3938k);
        }
    }

    public final void mo250a(Activity activity, Fragment fragment) {
        UIRuntimeLinterActivityListener uIRuntimeLinterActivityListener = (UIRuntimeLinterActivityListener) this.f3847j.get();
        uIRuntimeLinterActivityListener.f8494a.m13054a(activity);
        uIRuntimeLinterActivityListener.f8494a.m13056b(500);
        ((FB4APerfActivityListener) this.f3857t.get()).m12881a(fragment);
    }
}
