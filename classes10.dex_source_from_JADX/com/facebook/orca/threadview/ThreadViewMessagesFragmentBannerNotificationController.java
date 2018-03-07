package com.facebook.orca.threadview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.internal.widget.ViewStubCompat;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.banner.BannerNotification;
import com.facebook.common.banner.BannerNotificationController;
import com.facebook.common.banner.BannerNotificationController.ParentType;
import com.facebook.common.banner.BannerNotificationPrioritizer;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.contacts.cache.ContactsCache;
import com.facebook.contacts.graphql.Contact;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureContextHelper;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTriggerContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.banner.MuteThreadWarningNotification;
import com.facebook.messaging.bannertriggers.BannerTriggersOmnistoreComponent;
import com.facebook.messaging.cache.ThreadRecipientUtil;
import com.facebook.messaging.chatheads.detect.ChatHeadsContextDetector;
import com.facebook.messaging.connectivity.ConnectionStatusNotification;
import com.facebook.messaging.events.banner.EventReminderNotification;
import com.facebook.messaging.groups.abtest.ExperimentsForGroupsAbTestModule;
import com.facebook.messaging.groups.banner.GroupJoinRequestNotification;
import com.facebook.messaging.groups.banner.GroupJoinRequestNotificationProvider;
import com.facebook.messaging.groups.namingbar.GroupNamingBarBanner;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.invites.constants.InviteConstants.InviteEntryPoint;
import com.facebook.messaging.invites.quickinvites.InviteToMessengerBannerNotification;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsParams.QueryType;
import com.facebook.messaging.payment.service.model.transactions.MutatePaymentPlatformContextParams.Mutation;
import com.facebook.messaging.payment.thread.banner.IncomingPaymentRequestBannerManager;
import com.facebook.messaging.payment.thread.banner.IncomingPaymentRequestBannerNotification;
import com.facebook.messaging.payment.thread.banner.PaymentPlatformContextBannerManager;
import com.facebook.messaging.payment.thread.banner.PaymentPlatformContextBannerNotification;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.messaging.quickpromotion.QuickPromotionBannerView;
import com.facebook.messaging.quickpromotion.QuickPromotionBannerView.ComposerPointerLocation;
import com.facebook.messaging.quickpromotion.QuickPromotionThreadViewBannerController;
import com.facebook.messaging.quickpromotion.QuickPromotionTriggers;
import com.facebook.messaging.quickpromotion.ThreadViewBannerReason;
import com.facebook.messaging.users.MessengerInviteEligibilityChecker;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.Source;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.quickpromotion.controller.QuickPromotionController;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.TemplateType;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.user.module.UserNameUtil;
import com.facebook.widget.OverlayLayout.LayoutParams;
import com.facebook.widget.ViewStubHolder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: merchantSubscriptionParams */
public class ThreadViewMessagesFragmentBannerNotificationController {
    private final MessengerInviteEligibilityChecker f7792A;
    private final Provider<Boolean> f7793B;
    private final DefaultAppChoreographer f7794C;
    private final QeAccessor f7795D;
    private final GatekeeperStoreImpl f7796E;
    private final Provider<Boolean> f7797F;
    private final UserCache f7798G;
    private SelfRegistrableReceiverImpl f7799H = this.f7830r.a().a(MessagesBroadcastIntents.s, new C11788(this)).a("com.facebook.messaging.payment.ACTION_PAYMENT_PLATFORM_CONTEXTS_CACHE_UPDATED", new C11777(this)).a("com.facebook.messaging.payment.ACTION_PAYMENT_REQUEST_CACHE_UPDATED", new C11766(this)).a(MessagesBroadcastIntents.E, new C11755(this)).a();
    @Nullable
    private ThreadKey f7800I;
    @Nullable
    private ThreadSummary f7801J;
    public Name f7802K;
    @Nullable
    public Listener f7803L;
    private boolean f7804M;
    private ComposerPointerLocation f7805N;
    private InterstitialTriggerContext f7806O;
    private ViewStubHolder<QuickPromotionBannerView> f7807P;
    private ViewStubHolder<QuickPromotionBannerView> f7808Q;
    public ViewStubHolder<ImageView> f7809R;
    public boolean f7810S;
    private Source f7811T;
    public boolean f7812U;
    public final Context f7813a;
    private final SecureContextHelper f7814b;
    private final FbSharedPreferences f7815c;
    public final AnalyticsLogger f7816d;
    private final AbstractFbErrorReporter f7817e;
    private final UserNameUtil f7818f;
    private final Lazy<InterstitialManager> f7819g;
    private final BannerNotificationPrioritizer f7820h;
    public final BannerNotificationController f7821i;
    public final EventReminderNotification f7822j;
    private final MuteThreadWarningNotification f7823k;
    private final InviteToMessengerBannerNotification f7824l;
    private final ConnectionStatusNotification f7825m;
    private final GroupNamingBarBanner f7826n;
    public final PaymentPlatformContextBannerNotification f7827o;
    private final IncomingPaymentRequestBannerNotification f7828p;
    private final GroupJoinRequestNotification f7829q;
    private final BaseFbBroadcastManager f7830r;
    private final Provider<Boolean> f7831s;
    private final ThreadRecipientUtil f7832t;
    private final LayoutInflater f7833u;
    private final ContactsCache f7834v;
    private final DefaultAndroidThreadUtil f7835w;
    private final BannerTriggersOmnistoreComponent f7836x;
    public final PaymentPlatformContextBannerManager f7837y;
    private final IncomingPaymentRequestBannerManager f7838z;

    /* compiled from: merchantSubscriptionParams */
    public interface Listener {
        int mo324a(ComposerPointerLocation composerPointerLocation, boolean z);

        void mo325a();

        void mo326a(PaymentPlatformContextModel paymentPlatformContextModel);

        void mo327b(PaymentPlatformContextModel paymentPlatformContextModel);
    }

    /* compiled from: merchantSubscriptionParams */
    /* synthetic */ class AnonymousClass13 {
        static final /* synthetic */ int[] f7782a = new int[Type.values().length];

        static {
            try {
                f7782a[Type.ONE_TO_ONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7782a[Type.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7782a[Type.SMS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: merchantSubscriptionParams */
    public class C11711 {
        final /* synthetic */ ThreadViewMessagesFragmentBannerNotificationController f7783a;

        C11711(ThreadViewMessagesFragmentBannerNotificationController threadViewMessagesFragmentBannerNotificationController) {
            this.f7783a = threadViewMessagesFragmentBannerNotificationController;
        }

        public final void m7687a() {
            this.f7783a.f7810S = true;
            this.f7783a.m7751a("invite_banner");
        }

        public final void m7688b() {
            HoneyClientEventFast a = this.f7783a.f7816d.a("invite_friends_banner_dismiss", true);
            if (a.a()) {
                a.a("thread_view_module");
                a.b();
            }
            this.f7783a.f7810S = true;
            ThreadViewMessagesFragmentBannerNotificationController.m7735t(this.f7783a);
        }
    }

    /* compiled from: merchantSubscriptionParams */
    public class C11722 {
        public final /* synthetic */ ThreadViewMessagesFragmentBannerNotificationController f7784a;

        C11722(ThreadViewMessagesFragmentBannerNotificationController threadViewMessagesFragmentBannerNotificationController) {
            this.f7784a = threadViewMessagesFragmentBannerNotificationController;
        }

        public final void m7689b(PaymentPlatformContextModel paymentPlatformContextModel) {
            PaymentPlatformContextBannerManager paymentPlatformContextBannerManager = this.f7784a.f7837y;
            if (paymentPlatformContextModel.g() != null) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(paymentPlatformContextModel.g().j()));
                paymentPlatformContextBannerManager.d.b(intent, paymentPlatformContextBannerManager.c);
                paymentPlatformContextBannerManager.a("p2p_details_button_clicked", paymentPlatformContextModel);
            }
        }

        public final void m7690e(PaymentPlatformContextModel paymentPlatformContextModel) {
            this.f7784a.f7821i.b(this.f7784a.f7827o);
            PaymentPlatformContextBannerManager paymentPlatformContextBannerManager = this.f7784a.f7837y;
            paymentPlatformContextBannerManager.g.a(Mutation.BANNER_DISMISS, paymentPlatformContextModel.d());
            paymentPlatformContextBannerManager.a("p2p_cancel_button_clicked", paymentPlatformContextModel);
        }
    }

    /* compiled from: merchantSubscriptionParams */
    public class C11733 {
        final /* synthetic */ ThreadViewMessagesFragmentBannerNotificationController f7785a;

        C11733(ThreadViewMessagesFragmentBannerNotificationController threadViewMessagesFragmentBannerNotificationController) {
            this.f7785a = threadViewMessagesFragmentBannerNotificationController;
        }

        public final void m7691a() {
            if (this.f7785a.f7803L != null) {
                this.f7785a.f7803L.mo325a();
            }
        }
    }

    /* compiled from: merchantSubscriptionParams */
    public class C11744 {
        final /* synthetic */ ThreadViewMessagesFragmentBannerNotificationController f7786a;

        C11744(ThreadViewMessagesFragmentBannerNotificationController threadViewMessagesFragmentBannerNotificationController) {
            this.f7786a = threadViewMessagesFragmentBannerNotificationController;
        }

        public final void m7692a() {
            this.f7786a.m7699a(ThreadViewBannerReason.BANNER_NOTIFICATION_SHOWN);
        }
    }

    /* compiled from: merchantSubscriptionParams */
    class C11755 implements ActionReceiver {
        final /* synthetic */ ThreadViewMessagesFragmentBannerNotificationController f7787a;

        C11755(ThreadViewMessagesFragmentBannerNotificationController threadViewMessagesFragmentBannerNotificationController) {
            this.f7787a = threadViewMessagesFragmentBannerNotificationController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1697507782);
            if (this.f7787a.f7822j != null) {
                EventReminderNotification eventReminderNotification = this.f7787a.f7822j;
                ThreadKey threadKey = (ThreadKey) intent.getParcelableExtra("thread_key");
                if (threadKey != null && eventReminderNotification.f2336i.a.equals(threadKey)) {
                    eventReminderNotification.f2339l = eventReminderNotification.f2332e.m2178a(eventReminderNotification.f2336i.a, eventReminderNotification.f2329b.a(eventReminderNotification.f2336i.a, eventReminderNotification.f2337j.a));
                }
                this.f7787a.f7822j.m2197e();
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 277842337, a);
        }
    }

    /* compiled from: merchantSubscriptionParams */
    class C11766 implements ActionReceiver {
        final /* synthetic */ ThreadViewMessagesFragmentBannerNotificationController f7788a;

        C11766(ThreadViewMessagesFragmentBannerNotificationController threadViewMessagesFragmentBannerNotificationController) {
            this.f7788a = threadViewMessagesFragmentBannerNotificationController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1363273991);
            ThreadViewMessagesFragmentBannerNotificationController.m7728m(this.f7788a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1468986111, a);
        }
    }

    /* compiled from: merchantSubscriptionParams */
    class C11777 implements ActionReceiver {
        final /* synthetic */ ThreadViewMessagesFragmentBannerNotificationController f7789a;

        C11777(ThreadViewMessagesFragmentBannerNotificationController threadViewMessagesFragmentBannerNotificationController) {
            this.f7789a = threadViewMessagesFragmentBannerNotificationController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -612616571);
            ThreadViewMessagesFragmentBannerNotificationController.m7729n(this.f7789a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1192461625, a);
        }
    }

    /* compiled from: merchantSubscriptionParams */
    class C11788 implements ActionReceiver {
        final /* synthetic */ ThreadViewMessagesFragmentBannerNotificationController f7790a;

        C11788(ThreadViewMessagesFragmentBannerNotificationController threadViewMessagesFragmentBannerNotificationController) {
            this.f7790a = threadViewMessagesFragmentBannerNotificationController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 57695589);
            ThreadViewMessagesFragmentBannerNotificationController.m7735t(this.f7790a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 660627082, a);
        }
    }

    /* compiled from: merchantSubscriptionParams */
    class C11799 implements com.facebook.messaging.bannertriggers.BannerTriggersOmnistoreComponent.Listener {
        final /* synthetic */ ThreadViewMessagesFragmentBannerNotificationController f7791a;

        C11799(ThreadViewMessagesFragmentBannerNotificationController threadViewMessagesFragmentBannerNotificationController) {
            this.f7791a = threadViewMessagesFragmentBannerNotificationController;
        }

        public final void m7693a() {
            this.f7791a.m7699a(ThreadViewBannerReason.BANNER_TRIGGERS_DELTA_RECEIVED);
        }
    }

    @Inject
    public ThreadViewMessagesFragmentBannerNotificationController(Context context, SecureContextHelper secureContextHelper, FbSharedPreferences fbSharedPreferences, AnalyticsLogger analyticsLogger, FbErrorReporter fbErrorReporter, UserNameUtil userNameUtil, Lazy<InterstitialManager> lazy, BannerNotificationPrioritizer bannerNotificationPrioritizer, BannerNotificationController bannerNotificationController, EventReminderNotification eventReminderNotification, MuteThreadWarningNotification muteThreadWarningNotification, InviteToMessengerBannerNotification inviteToMessengerBannerNotification, ConnectionStatusNotification connectionStatusNotification, GroupNamingBarBanner groupNamingBarBanner, PaymentPlatformContextBannerNotification paymentPlatformContextBannerNotification, IncomingPaymentRequestBannerNotification incomingPaymentRequestBannerNotification, FbBroadcastManager fbBroadcastManager, Provider<Boolean> provider, ThreadRecipientUtil threadRecipientUtil, @Assisted LayoutInflater layoutInflater, ContactsCache contactsCache, AndroidThreadUtil androidThreadUtil, BannerTriggersOmnistoreComponent bannerTriggersOmnistoreComponent, PaymentPlatformContextBannerManager paymentPlatformContextBannerManager, IncomingPaymentRequestBannerManager incomingPaymentRequestBannerManager, MessengerInviteEligibilityChecker messengerInviteEligibilityChecker, Provider<Boolean> provider2, AppChoreographer appChoreographer, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore, Provider<Boolean> provider3, UserCache userCache, GroupJoinRequestNotificationProvider groupJoinRequestNotificationProvider) {
        this.f7813a = context;
        this.f7814b = secureContextHelper;
        this.f7815c = fbSharedPreferences;
        this.f7816d = analyticsLogger;
        this.f7817e = fbErrorReporter;
        this.f7818f = userNameUtil;
        this.f7819g = lazy;
        this.f7820h = bannerNotificationPrioritizer;
        this.f7821i = bannerNotificationController;
        this.f7822j = eventReminderNotification;
        this.f7823k = muteThreadWarningNotification;
        this.f7824l = inviteToMessengerBannerNotification;
        this.f7825m = connectionStatusNotification;
        this.f7798G = userCache;
        this.f7826n = groupNamingBarBanner;
        this.f7827o = paymentPlatformContextBannerNotification;
        this.f7828p = incomingPaymentRequestBannerNotification;
        this.f7830r = fbBroadcastManager;
        this.f7831s = provider;
        this.f7832t = threadRecipientUtil;
        this.f7833u = layoutInflater;
        this.f7834v = contactsCache;
        this.f7835w = androidThreadUtil;
        this.f7836x = bannerTriggersOmnistoreComponent;
        this.f7837y = paymentPlatformContextBannerManager;
        this.f7838z = incomingPaymentRequestBannerManager;
        this.f7792A = messengerInviteEligibilityChecker;
        this.f7793B = provider2;
        this.f7794C = appChoreographer;
        this.f7795D = qeAccessor;
        this.f7796E = gatekeeperStore;
        this.f7797F = provider3;
        this.f7829q = groupJoinRequestNotificationProvider.m2358a(this.f7813a);
        this.f7824l.m2982a(new C11711(this));
        this.f7827o.a(new C11722(this));
        this.f7829q.m2354a(new C11733(this));
        this.f7821i.a(ImmutableSet.of(this.f7825m, this.f7828p, this.f7827o, this.f7826n, this.f7822j, this.f7823k, new BannerNotification[]{this.f7824l, this.f7829q}), this.f7820h);
        this.f7821i.a(new C11744(this));
        this.f7836x.a(new C11799(this));
    }

    public final void m7749a(Listener listener) {
        this.f7803L = listener;
    }

    public final void m7744a(ViewGroup viewGroup) {
        this.f7821i.h = viewGroup;
        m7738w();
    }

    public final void m7743a(ViewStubCompat viewStubCompat) {
        this.f7807P = ViewStubHolder.a(viewStubCompat);
    }

    public final void m7753b(ViewStubCompat viewStubCompat) {
        this.f7808Q = ViewStubHolder.a(viewStubCompat);
    }

    public final void m7755c(ViewStubCompat viewStubCompat) {
        this.f7809R = ViewStubHolder.a(viewStubCompat);
    }

    public final void m7742a() {
        this.f7799H.b();
    }

    public final void m7752b() {
        this.f7812U = false;
        this.f7821i.a();
        this.f7823k.e();
        m7763k();
        m7699a(ThreadViewBannerReason.THREAD_VIEW_ON_RESUME);
    }

    public final void m7745a(InterstitialTrigger interstitialTrigger, ThreadViewBannerReason threadViewBannerReason) {
        if (!this.f7808Q.d() && !this.f7807P.d()) {
            m7704a(null, interstitialTrigger, threadViewBannerReason);
        }
    }

    public final void m7754c() {
        this.f7821i.b();
    }

    public final void m7756d() {
        this.f7812U = true;
        this.f7799H.c();
        this.f7836x.a(null);
    }

    public final void m7748a(Source source) {
        this.f7811T = source;
        m7728m(this);
        m7729n(this);
        if (m7730o()) {
            this.f7826n.f2485d = this.f7800I;
            this.f7821i.a(this.f7826n);
            return;
        }
        this.f7821i.b(this.f7826n);
    }

    public final void m7757e() {
        this.f7821i.b(this.f7826n);
    }

    public static void m7728m(ThreadViewMessagesFragmentBannerNotificationController threadViewMessagesFragmentBannerNotificationController) {
        Object obj;
        IncomingPaymentRequestBannerManager incomingPaymentRequestBannerManager = threadViewMessagesFragmentBannerNotificationController.f7838z;
        ThreadKey threadKey = threadViewMessagesFragmentBannerNotificationController.f7800I;
        if (!((Boolean) incomingPaymentRequestBannerManager.d.get()).booleanValue()) {
            obj = null;
        } else if (threadKey == null || !(threadKey.a == Type.ONE_TO_ONE || threadKey.a == Type.GROUP)) {
            obj = null;
        } else {
            PaymentRequestModel paymentRequestModel;
            ImmutableList a = incomingPaymentRequestBannerManager.a.a();
            if (a == null) {
                incomingPaymentRequestBannerManager.b.a(QueryType.INCOMING);
                paymentRequestModel = null;
            } else {
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    paymentRequestModel = (PaymentRequestModel) a.get(i);
                    if (incomingPaymentRequestBannerManager.c.a(paymentRequestModel)) {
                        boolean a2 = StringUtil.a(paymentRequestModel.d());
                        if (a2) {
                            if (threadKey.a == Type.ONE_TO_ONE && paymentRequestModel.k().c().equals(String.valueOf(threadKey.d))) {
                                break;
                            }
                        }
                        if (!a2 && threadKey.b() && paymentRequestModel.d().equals(String.valueOf(threadKey.b))) {
                            break;
                        }
                    }
                }
                paymentRequestModel = null;
            }
            incomingPaymentRequestBannerManager.e = paymentRequestModel;
            obj = incomingPaymentRequestBannerManager.e != null ? 1 : null;
        }
        if (obj != null) {
            threadViewMessagesFragmentBannerNotificationController.f7828p.f = threadViewMessagesFragmentBannerNotificationController.f7838z.a();
            threadViewMessagesFragmentBannerNotificationController.f7821i.a(threadViewMessagesFragmentBannerNotificationController.f7828p);
            return;
        }
        threadViewMessagesFragmentBannerNotificationController.f7821i.b(threadViewMessagesFragmentBannerNotificationController.f7828p);
    }

    public static void m7729n(ThreadViewMessagesFragmentBannerNotificationController threadViewMessagesFragmentBannerNotificationController) {
        Object obj;
        PaymentPlatformContextBannerManager paymentPlatformContextBannerManager = threadViewMessagesFragmentBannerNotificationController.f7837y;
        ThreadKey threadKey = threadViewMessagesFragmentBannerNotificationController.f7800I;
        if (!((Boolean) paymentPlatformContextBannerManager.a.get()).booleanValue()) {
            obj = null;
        } else if (threadKey == null || threadKey.a != Type.ONE_TO_ONE || threadKey.e()) {
            obj = null;
        } else {
            PaymentPlatformContextModel paymentPlatformContextModel = null;
            ArrayList a = paymentPlatformContextBannerManager.b.a();
            if (a == null) {
                paymentPlatformContextBannerManager.g.b();
            } else {
                int i;
                PaymentPlatformContextModel paymentPlatformContextModel2;
                String valueOf = String.valueOf(threadKey.d);
                ArrayList arrayList = new ArrayList();
                int size = a.size();
                for (i = 0; i < size; i++) {
                    paymentPlatformContextModel2 = (PaymentPlatformContextModel) a.get(i);
                    if (!(paymentPlatformContextModel2.k() == null || paymentPlatformContextModel2.b() == null || (!paymentPlatformContextModel2.k().c().equals(valueOf) && !paymentPlatformContextModel2.b().c().equals(valueOf)))) {
                        arrayList.add(paymentPlatformContextModel2);
                    }
                }
                a = arrayList;
                Collections.sort(a, paymentPlatformContextBannerManager.h);
                Collection arrayList2 = new ArrayList();
                int size2 = a.size();
                for (i = 0; i < size2; i++) {
                    paymentPlatformContextModel2 = (PaymentPlatformContextModel) a.get(i);
                    if (!paymentPlatformContextModel2.n()) {
                        arrayList2.add(paymentPlatformContextModel2);
                    }
                }
                a.removeAll(arrayList2);
                if (!a.isEmpty()) {
                    paymentPlatformContextModel = (PaymentPlatformContextModel) a.get(0);
                }
            }
            paymentPlatformContextBannerManager.i = paymentPlatformContextModel;
            obj = paymentPlatformContextBannerManager.i != null ? 1 : null;
        }
        if (obj != null) {
            threadViewMessagesFragmentBannerNotificationController.f7827o.g = threadViewMessagesFragmentBannerNotificationController.f7837y.i;
            threadViewMessagesFragmentBannerNotificationController.f7821i.a(threadViewMessagesFragmentBannerNotificationController.f7827o);
            return;
        }
        threadViewMessagesFragmentBannerNotificationController.f7821i.b(threadViewMessagesFragmentBannerNotificationController.f7827o);
    }

    private boolean m7730o() {
        if (this.f7801J == null || this.f7801J.a.a != Type.GROUP || this.f7801J.a()) {
            return false;
        }
        long a = this.f7795D.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForGroupsAbTestModule.f2422e, 0);
        long a2 = this.f7795D.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForGroupsAbTestModule.f2421d, Long.MAX_VALUE);
        long j = this.f7801J.m;
        if (j < a || j > a2) {
            return false;
        }
        return this.f7795D.a(ExperimentsForGroupsAbTestModule.f2418a, false);
    }

    public final void m7747a(ThreadSummary threadSummary) {
        Preconditions.checkNotNull(threadSummary);
        boolean z = threadSummary.a == null || !threadSummary.a.d();
        Preconditions.checkArgument(z);
        m7718c(threadSummary);
    }

    public final void m7746a(ThreadKey threadKey) {
        Preconditions.checkNotNull(threadKey);
        Preconditions.checkArgument(!threadKey.d());
        m7710b(threadKey);
    }

    public final void m7758f() {
        m7710b(null);
        m7718c(null);
        this.f7826n.f2485d = null;
    }

    public final void m7759g() {
        m7699a(ThreadViewBannerReason.COMPOSE_MODE_CHANGED);
    }

    public final void m7760h() {
        m7699a(ThreadViewBannerReason.SAME_THREAD_RELOAD);
    }

    private boolean m7714b(ThreadSummary threadSummary) {
        if (this.f7801J == null) {
            if (threadSummary == null) {
                return true;
            }
            return false;
        } else if (threadSummary != null) {
            return this.f7801J.a.equals(threadSummary.a);
        } else {
            return false;
        }
    }

    public final void m7750a(Name name) {
        this.f7802K = name;
    }

    public final void m7761i() {
        this.f7823k.e();
    }

    private void m7710b(@Nullable ThreadKey threadKey) {
        this.f7800I = threadKey;
        this.f7825m.a(ThreadKey.d(threadKey));
    }

    private void m7718c(@Nullable ThreadSummary threadSummary) {
        boolean z = !m7714b(threadSummary);
        this.f7801J = threadSummary;
        if (this.f7801J != null) {
            m7710b(this.f7801J.a);
        }
        if (this.f7823k != null) {
            this.f7823k.a(this.f7800I);
            this.f7823k.e();
        }
        if (this.f7822j != null) {
            EventReminderNotification eventReminderNotification = this.f7822j;
            eventReminderNotification.f2336i = this.f7801J;
            eventReminderNotification.f2337j = null;
            if (eventReminderNotification.f2336i != null && eventReminderNotification.f2336i.J != null && !eventReminderNotification.f2336i.J.isEmpty()) {
                ImmutableList immutableList = eventReminderNotification.f2336i.J;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    ThreadEventReminder threadEventReminder = (ThreadEventReminder) immutableList.get(i);
                    if (!threadEventReminder.d) {
                        eventReminderNotification.f2337j = threadEventReminder;
                        eventReminderNotification.f2339l = eventReminderNotification.f2332e.m2178a(eventReminderNotification.f2336i.a, eventReminderNotification.f2329b.a(eventReminderNotification.f2336i.a, eventReminderNotification.f2337j.a));
                        break;
                    }
                }
            }
            this.f7822j.m2197e();
        }
        if (this.f7829q != null) {
            this.f7829q.m2353a(this.f7801J);
            this.f7829q.m2357e();
        }
        if (z) {
            m7736u();
            this.f7806O = null;
            m7699a(ThreadViewBannerReason.THREAD_CHANGED);
            this.f7810S = false;
        }
    }

    private String m7731p() {
        String a = this.f7832t.a(this.f7801J);
        if (a == null) {
            return this.f7818f.a(this.f7802K);
        }
        return a;
    }

    public final void m7751a(String str) {
        InviteEntryPoint inviteEntryPoint;
        List r;
        InviteEntryPoint inviteEntryPoint2 = null;
        if ("invite_banner".equals(str)) {
            inviteEntryPoint = InviteEntryPoint.THREAD_VIEW_INVITE_BANNER;
            r = m7733r();
        } else {
            if ("invite_button".equals(str)) {
                inviteEntryPoint2 = InviteEntryPoint.THREAD_VIEW_INVITE_BANNER;
            }
            User s = m7734s();
            if (s != null) {
                ImmutableList of = ImmutableList.of(s);
                inviteEntryPoint = inviteEntryPoint2;
                r = of;
            } else {
                return;
            }
        }
        if (r.size() > 0) {
            m7698a(inviteEntryPoint);
            m7703a(r, inviteEntryPoint);
        }
    }

    private void m7698a(InviteEntryPoint inviteEntryPoint) {
        HoneyClientEventFast a = this.f7816d.a("invite_friends_chaining_start", true);
        if (a.a()) {
            a.a("thread_view_module");
            if (inviteEntryPoint != null) {
                a.b(inviteEntryPoint.name());
            }
            a.b();
        }
    }

    private void m7703a(List<User> list, InviteEntryPoint inviteEntryPoint) {
        Intent data = new Intent().setAction(MessagingIntentUris.a).setData(Uri.parse(MessengerLinks.D));
        if (inviteEntryPoint != null) {
            data.putExtra("ShareType.inviteEntryPoint", inviteEntryPoint);
        }
        Serializable hashMap = new HashMap();
        for (User user : list) {
            hashMap.put(user.a, user.k());
        }
        data.putExtra("ShareType.invitedUsersMap", hashMap);
        if (this.f7800I.b()) {
            data.putExtra("group_fbid", Long.toString(this.f7800I.i()));
        }
        this.f7814b.a(data, this.f7813a);
    }

    private void m7732q() {
        boolean z = false;
        if (!ThreadKey.g(this.f7800I)) {
            List<User> r = m7733r();
            if (!m7708a((List) r) || this.f7811T == Source.OMNI_PICKER) {
                this.f7821i.b(this.f7824l);
                return;
            }
            if (ChatHeadsContextDetector.a(this.f7813a)) {
                if (!this.f7796E.a(251, false)) {
                    z = true;
                }
                if (z) {
                    this.f7821i.b(this.f7824l);
                    return;
                }
            }
            Builder builder = ImmutableList.builder();
            for (User a : r) {
                builder.c(this.f7818f.a(a));
            }
            this.f7824l.f3004d = builder.b();
            this.f7821i.a(this.f7824l);
        }
    }

    private List<User> m7733r() {
        List<User> linkedList = new LinkedList();
        if (this.f7800I == null) {
            return linkedList;
        }
        User user;
        if (this.f7801J != null) {
            ImmutableList c = this.f7832t.c(this.f7801J);
            int size = c.size();
            for (int i = 0; i < size; i++) {
                user = (User) c.get(i);
                if (this.f7792A.a(user.T) && user.z) {
                    if (this.f7815c.a(MessagingPrefKeys.b(user.a), true)) {
                        linkedList.add(user);
                    }
                }
            }
        } else if (this.f7802K != null) {
            user = m7734s();
            if (user != null && this.f7792A.a(user.T)) {
                linkedList.add(user);
            }
        }
        return linkedList;
    }

    @Nullable
    private User m7734s() {
        Preconditions.checkNotNull(this.f7800I);
        Preconditions.checkArgument(!this.f7800I.b());
        return this.f7798G.a(ThreadKey.a(this.f7800I));
    }

    private boolean m7708a(List<User> list) {
        if (!((Boolean) this.f7831s.get()).booleanValue() || this.f7800I == null || ((this.f7801J == null && this.f7800I.a != Type.ONE_TO_ONE) || ((this.f7801J != null && this.f7801J.A.isMessageRequestFolders()) || list.size() <= 0 || this.f7810S))) {
            return false;
        }
        String x = m7739x();
        if (x != null) {
            if (!this.f7815c.a(MessagingPrefKeys.b(x), true)) {
                return false;
            }
        }
        return !this.f7800I.b() || m7715b((List) list);
    }

    private boolean m7715b(List<User> list) {
        if (!((Boolean) this.f7797F.get()).booleanValue()) {
            return false;
        }
        Preconditions.checkNotNull(this.f7800I);
        Preconditions.checkArgument(this.f7800I.b());
        if (this.f7801J.h.size() > 15 || list.size() > 3) {
            return false;
        }
        return true;
    }

    public static void m7735t(ThreadViewMessagesFragmentBannerNotificationController threadViewMessagesFragmentBannerNotificationController) {
        threadViewMessagesFragmentBannerNotificationController.f7821i.b(threadViewMessagesFragmentBannerNotificationController.f7824l);
        if (threadViewMessagesFragmentBannerNotificationController.f7800I != null) {
            String x = threadViewMessagesFragmentBannerNotificationController.m7739x();
            if (x != null) {
                threadViewMessagesFragmentBannerNotificationController.m7713b(x);
            } else if (threadViewMessagesFragmentBannerNotificationController.f7801J != null && threadViewMessagesFragmentBannerNotificationController.f7800I.b()) {
                for (User user : threadViewMessagesFragmentBannerNotificationController.m7733r()) {
                    threadViewMessagesFragmentBannerNotificationController.m7713b(user.a);
                }
            }
        }
    }

    private void m7713b(String str) {
        this.f7815c.edit().putBoolean(MessagingPrefKeys.b(str), false).commit();
    }

    public final void m7762j() {
        if (this.f7805N == null) {
            return;
        }
        if (this.f7804M) {
            m7737v();
            if (this.f7809R.d()) {
                this.f7808Q.f();
                ((QuickPromotionBannerView) this.f7808Q.a()).m3575a();
                this.f7804M = false;
                return;
            }
            return;
        }
        m7699a(ThreadViewBannerReason.COMPOSER_OVERLAP_CHANGED);
    }

    private void m7704a(Map<String, String> map, InterstitialTrigger interstitialTrigger, ThreadViewBannerReason threadViewBannerReason) {
        Object obj;
        if (this.f7821i.c.b() != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            m7736u();
            return;
        }
        InterstitialTriggerContext a = m7695a((Map) map);
        QuickPromotionDefinition b = m7709b(new InterstitialTrigger(interstitialTrigger, a));
        if (b == null) {
            m7696a(interstitialTrigger);
        } else if (((Boolean) this.f7793B.get()).booleanValue()) {
            m7697a(a, b, threadViewBannerReason);
        } else {
            m7712b(this, a, b, threadViewBannerReason);
        }
    }

    private void m7736u() {
        if (this.f7807P != null) {
            this.f7807P.e();
        }
        if (this.f7808Q != null) {
            this.f7808Q.e();
        }
        if (this.f7809R != null) {
            this.f7809R.e();
        }
    }

    private void m7696a(InterstitialTrigger interstitialTrigger) {
        QuickPromotionBannerView quickPromotionBannerView;
        if (this.f7807P != null && this.f7807P.d()) {
            quickPromotionBannerView = (QuickPromotionBannerView) this.f7807P.a();
            if (quickPromotionBannerView != null && quickPromotionBannerView.m3577a(interstitialTrigger)) {
                this.f7807P.e();
            }
        }
        if (this.f7808Q != null && this.f7808Q.d()) {
            quickPromotionBannerView = (QuickPromotionBannerView) this.f7808Q.a();
            if (quickPromotionBannerView != null && quickPromotionBannerView.m3577a(interstitialTrigger)) {
                this.f7808Q.e();
                if (this.f7809R != null) {
                    this.f7809R.e();
                }
            }
        }
    }

    private void m7697a(final InterstitialTriggerContext interstitialTriggerContext, final QuickPromotionDefinition quickPromotionDefinition, final ThreadViewBannerReason threadViewBannerReason) {
        this.f7794C.a("maybeShowQuickPromotionBanner", new Runnable(this) {
            final /* synthetic */ ThreadViewMessagesFragmentBannerNotificationController f7777d;

            public void run() {
                if (!this.f7777d.f7812U) {
                    ThreadViewMessagesFragmentBannerNotificationController.m7712b(this.f7777d, interstitialTriggerContext, quickPromotionDefinition, threadViewBannerReason);
                }
            }
        }, Priority.APPLICATION_LOADED_UI_IDLE, ThreadType.UI);
    }

    public static void m7712b(ThreadViewMessagesFragmentBannerNotificationController threadViewMessagesFragmentBannerNotificationController, InterstitialTriggerContext interstitialTriggerContext, QuickPromotionDefinition quickPromotionDefinition, ThreadViewBannerReason threadViewBannerReason) {
        boolean z;
        QuickPromotionBannerView.Type type;
        ViewStubHolder viewStubHolder;
        threadViewMessagesFragmentBannerNotificationController.f7835w.a();
        threadViewBannerReason.toString();
        if (threadViewMessagesFragmentBannerNotificationController.f7807P.d() || threadViewMessagesFragmentBannerNotificationController.f7808Q.d()) {
            z = true;
        } else {
            z = false;
        }
        threadViewMessagesFragmentBannerNotificationController.m7736u();
        ViewStubHolder viewStubHolder2;
        if (m7707a(quickPromotionDefinition)) {
            viewStubHolder2 = threadViewMessagesFragmentBannerNotificationController.f7807P;
            type = QuickPromotionBannerView.Type.THREADVIEW;
            viewStubHolder = viewStubHolder2;
        } else {
            viewStubHolder2 = threadViewMessagesFragmentBannerNotificationController.f7808Q;
            type = QuickPromotionBannerView.Type.COMPOSER;
            viewStubHolder = viewStubHolder2;
        }
        threadViewMessagesFragmentBannerNotificationController.m7702a(viewStubHolder, m7716c(threadViewMessagesFragmentBannerNotificationController.f7800I));
        ((QuickPromotionBannerView) viewStubHolder.a()).m3576a(type, quickPromotionDefinition, new OnClickListener(threadViewMessagesFragmentBannerNotificationController) {
            final /* synthetic */ ThreadViewMessagesFragmentBannerNotificationController f7779b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -994663324);
                viewStubHolder.e();
                this.f7779b.f7809R.e();
                Logger.a(2, EntryType.UI_INPUT_END, -1868352231, a);
            }
        }, "3545", interstitialTriggerContext);
        viewStubHolder.f();
        if (type == QuickPromotionBannerView.Type.COMPOSER) {
            threadViewMessagesFragmentBannerNotificationController.m7737v();
        }
        threadViewMessagesFragmentBannerNotificationController.m7705a(z, threadViewBannerReason, viewStubHolder);
    }

    private void m7705a(boolean z, ThreadViewBannerReason threadViewBannerReason, ViewStubHolder<QuickPromotionBannerView> viewStubHolder) {
        if ((!this.f7807P.d() && !this.f7808Q.d()) || ThreadViewBannerReason.THREAD_VIEW_ON_RESUME.equals(threadViewBannerReason)) {
            return;
        }
        if (ThreadViewBannerReason.THREAD_CHANGED.equals(threadViewBannerReason) || !z) {
            ((QuickPromotionBannerView) viewStubHolder.a()).m3575a();
        }
    }

    private void m7699a(ThreadViewBannerReason threadViewBannerReason) {
        m7704a(null, QuickPromotionTriggers.f3783c, threadViewBannerReason);
    }

    @Nullable
    private QuickPromotionDefinition m7709b(InterstitialTrigger interstitialTrigger) {
        QuickPromotionController quickPromotionController = (QuickPromotionController) ((InterstitialManager) this.f7819g.get()).a(interstitialTrigger, QuickPromotionThreadViewBannerController.class);
        if (quickPromotionController == null) {
            return null;
        }
        Intent a = quickPromotionController.a(this.f7813a);
        if (a == null) {
            this.f7817e.b("ThreadViewMessagesFragment_QPBanner_NullIntent", "Null intent to present from QP Banner Controller");
            return null;
        } else if (a.hasExtra("qp_definition")) {
            return (QuickPromotionDefinition) a.getExtras().get("qp_definition");
        } else {
            this.f7817e.b("ThreadViewMessagesFragment_QPBanner_MissingKey", "Intent missing QP_DEFINITION_KEY");
            return null;
        }
    }

    private void m7737v() {
        final ImageView imageView = (ImageView) this.f7809R.a();
        this.f7805N = ((QuickPromotionBannerView) this.f7808Q.a()).f3765i;
        if (this.f7805N == null) {
            this.f7809R.e();
        } else if (this.f7803L != null) {
            int a = this.f7803L.mo324a(this.f7805N, ((QuickPromotionBannerView) this.f7808Q.a()).f3766j);
            if (a < 0) {
                this.f7809R.e();
                this.f7808Q.e();
            } else if (a == 0) {
                this.f7804M = true;
                this.f7809R.e();
                this.f7808Q.e();
            } else {
                this.f7809R.f();
                LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
                layoutParams.leftMargin = a - (this.f7813a.getResources().getDrawable(2130838218).getIntrinsicWidth() / 2);
                imageView.setLayoutParams(layoutParams);
                ((QuickPromotionBannerView) this.f7808Q.a()).f3768l = new com.facebook.messaging.quickpromotion.QuickPromotionBannerView.Listener(this) {
                    final /* synthetic */ ThreadViewMessagesFragmentBannerNotificationController f7781b;

                    public final void mo333a(int[] iArr) {
                        for (int i : iArr) {
                            if (i == 16842919) {
                                imageView.setColorFilter(this.f7781b.f7813a.getResources().getColor(2131362529));
                                return;
                            }
                        }
                        imageView.setColorFilter(this.f7781b.f7813a.getResources().getColor(2131362528));
                    }
                };
            }
        }
    }

    private void m7702a(ViewStubHolder viewStubHolder, int i) {
        viewStubHolder.a(this.f7833u.cloneInContext(new ContextThemeWrapper(this.f7813a, i)));
    }

    public final void m7763k() {
        m7732q();
    }

    private void m7738w() {
        this.f7821i.f = (ContextUtils.a(this.f7813a, Activity.class) != null ? 1 : null) != null ? ParentType.THREADVIEW : ParentType.THREADVIEW_CHAT_HEADS;
    }

    private String m7739x() {
        if (this.f7800I == null || this.f7800I.a != Type.ONE_TO_ONE) {
            return null;
        }
        return Long.toString(this.f7800I.d);
    }

    private String m7740y() {
        String x = m7739x();
        if (x == null) {
            return null;
        }
        User a = this.f7798G.a(UserKey.b(x));
        if (a != null) {
            return String.valueOf(a.m);
        }
        return null;
    }

    private boolean m7741z() {
        String x = m7739x();
        if (x == null) {
            return false;
        }
        Contact a = this.f7834v.a(UserKey.b(x));
        if (a == null) {
            return false;
        }
        Calendar instance = GregorianCalendar.getInstance();
        int D = a.D();
        int E = a.E();
        if (D == instance.get(5) && E == instance.get(2) + 1) {
            return true;
        }
        return false;
    }

    private InterstitialTriggerContext m7695a(@Nullable Map<String, String> map) {
        if (this.f7801J == null || this.f7801J.a == null) {
            return new InterstitialTriggerContext();
        }
        if (this.f7806O == null || (map != null && map.size() > 0)) {
            Map hashMap = new HashMap();
            if (map != null) {
                hashMap.putAll(map);
            }
            CharSequence valueOf = String.valueOf(this.f7801J.a.d);
            if (!StringUtil.a(valueOf)) {
                hashMap.put("target_user_id", valueOf);
            }
            valueOf = m7731p();
            if (!StringUtil.a(valueOf)) {
                hashMap.put("target_user_short_name", valueOf);
            }
            valueOf = m7740y();
            if (!StringUtil.a(valueOf)) {
                hashMap.put("target_user_rank", valueOf);
            }
            hashMap.put("target_user_is_birthday", String.valueOf(m7741z()));
            hashMap.put("thread_type", this.f7801J.a.a.name());
            Object obj = null;
            switch (AnonymousClass13.f7782a[this.f7801J.a.a.ordinal()]) {
                case 1:
                    obj = String.valueOf(this.f7801J.a.d);
                    break;
                case 2:
                case 3:
                    obj = String.valueOf(this.f7801J.a.b);
                    break;
            }
            if (obj != null) {
                hashMap.put("thread_id", obj);
            }
            this.f7806O = new InterstitialTriggerContext(hashMap);
        }
        return this.f7806O;
    }

    private static boolean m7707a(QuickPromotionDefinition quickPromotionDefinition) {
        return TemplateType.ANDROID_MESSENGER_THREAD_VIEW_HEADER_BANNER.equals(quickPromotionDefinition.e()) || TemplateType.ANDROID_MESSENGER_THREAD_VIEW_HEADER_BUTTONLESS_BANNER.equals(quickPromotionDefinition.e());
    }

    private static int m7716c(ThreadKey threadKey) {
        return ThreadKey.d(threadKey) ? 2131624677 : 2131624675;
    }

    public final void m7764l() {
        m7704a(null, QuickPromotionTriggers.f3784d, ThreadViewBannerReason.AUDIO_CLIP_RENDERED);
    }
}
