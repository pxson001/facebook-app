package com.facebook.timeline.actionbar;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.intent.HomeIntentHandlerHelper;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.friending.newuserpromotion.NewUserFriendingDialogController;
import com.facebook.friends.constants.FriendRequestResponse;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.SubscribeStatusChangedEvent;
import com.facebook.friends.events.FriendingEvents.SubscribeStatusChangedEventSubscriber;
import com.facebook.friends.events.FriendingEvents.UserBlockedEvent;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.ipc.profile.TimelineFriendParams;
import com.facebook.profile.api.RelationshipType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.actionbar.seefirst.FollowSwitcherPopupWindow;
import com.facebook.timeline.actionbar.seefirst.FollowSwitcherPopupWindow.OnChangeListener;
import com.facebook.timeline.actionbar.seefirst.FollowSwitcherPopupWindowProvider;
import com.facebook.timeline.actionbar.seefirst.PermanentSeeFirstPopUpWindow;
import com.facebook.timeline.cache.TimelineUserDataCleaner;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.event.TimelineFriendingEvents.AddFriendClickedEvent;
import com.facebook.timeline.event.TimelineFriendingEvents.FriendRequestResponseClickedEvent;
import com.facebook.timeline.event.TimelineFriendingEvents.SubscribeStatusChangeClickedEvent;
import com.facebook.timeline.event.TimelineHeaderEventBus;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.menus.TimelineFriendPopoverHelper;
import com.facebook.timeline.header.menus.TimelineFriendPopoverHelper.C16953;
import com.facebook.timeline.header.menus.TimelineFriendPopoverHelper.C16964;
import com.facebook.timeline.header.menus.TimelineFriendPopoverHelper.C16975;
import com.facebook.timeline.header.menus.TimelineFriendPopoverHelper.C16986;
import com.facebook.timeline.header.menus.TimelineFriendPopoverHelper.C16997;
import com.facebook.timeline.header.menus.TimelineFriendingClient;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.timeline.refresher.ProfileRefresherAnalyticsLogger;
import com.facebook.timeline.refresher.launcher.ProfileRefresherConfiguration.Builder;
import com.facebook.timeline.refresher.launcher.ProfileRefresherLauncher;
import com.facebook.timeline.services.ProfileServicesCallbackHelper;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: groups/requests/{%s} */
public class TimelineActionBarControllerImpl implements TimelineActionBarController {
    private final Provider<NavigationLogger> f10272a;
    public final Provider<ExecutorService> f10273b;
    public final Provider<IFeedIntentBuilder> f10274c;
    private final Provider<FbUriIntentHandler> f10275d;
    private final Provider<ProfileServicesCallbackHelper> f10276e;
    private final Provider<ProfileRefresherLauncher> f10277f;
    private final Provider<ProfileRefresherAnalyticsLogger> f10278g;
    public final Provider<SecureContextHelper> f10279h;
    public final Provider<TimelineUserDataCleaner> f10280i;
    private final FollowSwitcherPopupWindowProvider f10281j;
    private final Lazy<TimelineFriendPopoverHelper> f10282k;
    public final Lazy<FbErrorReporter> f10283l;
    private final SecureContextHelper f10284m;
    private final ProfileControllerDelegate f10285n;
    private final Lazy<NewUserFriendingDialogController> f10286o;
    private final QeAccessor f10287p;
    public final Context f10288q;
    private final String f10289r;
    public final Provider<TimelineHeaderEventBus> f10290s;
    public final Provider<FriendingEventBus> f10291t;
    public final TimelineContext f10292u;
    private final TimelineHeaderUserData f10293v;
    public final TimelineFriendingClient f10294w;
    private final TimelineAnalyticsLogger f10295x;
    public ProgressDialog f10296y;

    /* compiled from: groups/requests/{%s} */
    class C15163 implements OnChangeListener {
        final /* synthetic */ TimelineActionBarControllerImpl f10260a;

        C15163(TimelineActionBarControllerImpl timelineActionBarControllerImpl) {
            this.f10260a = timelineActionBarControllerImpl;
        }

        public final void m10387a(boolean z, boolean z2) {
            TimelineFriendingClient timelineFriendingClient = this.f10260a.f10294w;
            timelineFriendingClient.f11903d.a(z ? GraphQLSubscribeStatus.IS_SUBSCRIBED : GraphQLSubscribeStatus.CAN_SUBSCRIBE);
            if (z2) {
                timelineFriendingClient.f11903d.a(GraphQLSecondarySubscribeStatus.SEE_FIRST);
            } else {
                timelineFriendingClient.f11903d.a(GraphQLSecondarySubscribeStatus.REGULAR_FOLLOW);
            }
            TimelineFriendingClient.m11955c(timelineFriendingClient);
            ((TimelineHeaderEventBus) this.f10260a.f10290s.get()).a(new SubscribeStatusChangeClickedEvent(z, z2));
        }
    }

    /* compiled from: groups/requests/{%s} */
    class C15174 implements OnClickListener {
        final /* synthetic */ TimelineActionBarControllerImpl f10261a;

        C15174(TimelineActionBarControllerImpl timelineActionBarControllerImpl) {
            this.f10261a = timelineActionBarControllerImpl;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f10261a.f10292u != null) {
                ((TimelineHeaderEventBus) this.f10261a.f10290s.get()).a(new FriendRequestResponseClickedEvent(this.f10261a.f10292u.b, i == 0 ? FriendRequestResponse.CONFIRM : FriendRequestResponse.REJECT));
            }
        }
    }

    /* compiled from: groups/requests/{%s} */
    class C15185 implements OnClickListener {
        final /* synthetic */ TimelineActionBarControllerImpl f10262a;

        C15185(TimelineActionBarControllerImpl timelineActionBarControllerImpl) {
            this.f10262a = timelineActionBarControllerImpl;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ListenableFuture a = this.f10262a.f10294w.m11956a().a(this.f10262a.f10292u.a, this.f10262a.f10292u.g());
            this.f10262a.f10296y.show();
            Futures.a(a, new BlockingUserFutureCallback(this.f10262a.f10291t, this.f10262a.f10292u, this.f10262a.f10280i, this.f10262a.f10288q, this.f10262a.f10283l, this.f10262a.f10296y, this.f10262a.f10274c, this.f10262a.f10279h), (Executor) this.f10262a.f10273b.get());
        }
    }

    /* compiled from: groups/requests/{%s} */
    /* synthetic */ class C15196 {
        static final /* synthetic */ int[] f10263a = new int[GraphQLFriendshipStatus.values().length];

        static {
            try {
                f10263a[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10263a[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10263a[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10263a[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: groups/requests/{%s} */
    public class BlockingUserFutureCallback implements FutureCallback<Void> {
        private final Provider<FriendingEventBus> f10264a;
        private final TimelineContext f10265b;
        private final Provider<TimelineUserDataCleaner> f10266c;
        private final Context f10267d;
        private final Lazy<FbErrorReporter> f10268e;
        private final ProgressDialog f10269f;
        private final Provider<IFeedIntentBuilder> f10270g;
        private final Provider<SecureContextHelper> f10271h;

        public BlockingUserFutureCallback(Provider<FriendingEventBus> provider, TimelineContext timelineContext, Provider<TimelineUserDataCleaner> provider2, Context context, Lazy<FbErrorReporter> lazy, ProgressDialog progressDialog, Provider<IFeedIntentBuilder> provider3, Provider<SecureContextHelper> provider4) {
            this.f10264a = provider;
            this.f10265b = timelineContext;
            this.f10266c = provider2;
            this.f10267d = context;
            this.f10268e = lazy;
            this.f10269f = progressDialog;
            this.f10270g = provider3;
            this.f10271h = provider4;
        }

        public void onSuccess(Object obj) {
            ((FriendingEventBus) this.f10264a.get()).a(new UserBlockedEvent(Long.valueOf(this.f10265b.b).longValue()));
            ((TimelineUserDataCleaner) this.f10266c.get()).a("BlockUserFromActionBarOnSuccess");
            m10389b();
        }

        public void onFailure(Throwable th) {
            if (!(th instanceof CancellationException)) {
                ((TimelineUserDataCleaner) this.f10266c.get()).a("BlockUserFromActionBarOnFailure");
                if (m10388a(th)) {
                    Toast.makeText(this.f10267d, 2131234959, 1).show();
                } else {
                    Toast.makeText(this.f10267d, 2131234958, 1).show();
                }
                ((AbstractFbErrorReporter) this.f10268e.get()).a("timeline_block_user_failed", th);
            }
            m10389b();
        }

        private static boolean m10388a(Throwable th) {
            if (th instanceof ServiceException) {
                ServiceException serviceException = (ServiceException) th;
                if (serviceException.result.g instanceof ApiException) {
                    ApiException apiException = (ApiException) serviceException.result.g;
                    if (apiException.b() != null && apiException.b().a() == 3802) {
                        return true;
                    }
                }
            }
            return false;
        }

        private void m10389b() {
            if (this.f10269f.isShowing()) {
                this.f10269f.dismiss();
            }
            ((SecureContextHelper) this.f10271h.get()).a(((IFeedIntentBuilder) this.f10270g.get()).b(this.f10267d, FBLinks.bT), this.f10267d);
        }
    }

    @Inject
    public TimelineActionBarControllerImpl(@Assisted Context context, @Assisted TimelineAnalyticsLogger timelineAnalyticsLogger, @Assisted TimelineContext timelineContext, @Assisted TimelineFriendingClient timelineFriendingClient, @Assisted TimelineHeaderUserData timelineHeaderUserData, @Nullable @Assisted String str, Provider<FriendingEventBus> provider, Provider<TimelineHeaderEventBus> provider2, Provider<NavigationLogger> provider3, Provider<ExecutorService> provider4, Provider<IFeedIntentBuilder> provider5, Provider<ProfileServicesCallbackHelper> provider6, Provider<ProfileRefresherLauncher> provider7, Provider<ProfileRefresherAnalyticsLogger> provider8, Provider<FbUriIntentHandler> provider9, Lazy<HomeIntentHandlerHelper> lazy, Provider<SecureContextHelper> provider10, FollowSwitcherPopupWindowProvider followSwitcherPopupWindowProvider, Provider<TimelineUserDataCleaner> provider11, SecureContextHelper secureContextHelper, Lazy<TimelineFriendPopoverHelper> lazy2, Lazy<FbErrorReporter> lazy3, ProfileControllerDelegate profileControllerDelegate, Lazy<NewUserFriendingDialogController> lazy4, QeAccessor qeAccessor) {
        this.f10288q = context;
        this.f10284m = secureContextHelper;
        this.f10295x = timelineAnalyticsLogger;
        this.f10292u = timelineContext;
        this.f10294w = timelineFriendingClient;
        this.f10293v = timelineHeaderUserData;
        this.f10289r = str;
        this.f10291t = provider;
        this.f10290s = provider2;
        this.f10272a = provider3;
        this.f10273b = provider4;
        this.f10274c = provider5;
        this.f10276e = provider6;
        this.f10277f = provider7;
        this.f10278g = provider8;
        this.f10275d = provider9;
        this.f10279h = provider10;
        this.f10281j = followSwitcherPopupWindowProvider;
        this.f10280i = provider11;
        this.f10282k = lazy2;
        this.f10283l = lazy3;
        this.f10285n = profileControllerDelegate;
        this.f10286o = lazy4;
        this.f10287p = qeAccessor;
    }

    public final void mo487a(String str) {
        m10409l(str);
        switch (C15196.f10263a[this.f10293v.B().ordinal()]) {
            case 1:
                m10400e();
                return;
            case 2:
                ((TimelineHeaderEventBus) this.f10290s.get()).a(new AddFriendClickedEvent(this.f10292u.b));
                if (this.f10287p.a(ExperimentsForTimelineAbTestModule.N, false)) {
                    ((NewUserFriendingDialogController) this.f10286o.get()).a(Uri.parse(this.f10293v.L()), this.f10293v.N(), this.f10287p.a(ExperimentsForTimelineAbTestModule.P, 10000));
                    return;
                }
                return;
            case 3:
                m10400e();
                return;
            case 4:
                m10402f();
                return;
            default:
                return;
        }
    }

    public final void mo488a(String str, View view) {
        m10409l(str);
        m10391a(view);
    }

    public final void mo489a(String str, String str2) {
        m10409l(str);
        ((NavigationLogger) this.f10272a.get()).a(str2);
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.R, Long.valueOf(this.f10292u.b));
        Intent b = ((IFeedIntentBuilder) this.f10274c.get()).b(this.f10288q, formatStrLocaleSafe);
        if (b != null) {
            if (this.f10289r != null) {
                b.putExtra("group_commerce_sell_options_id", this.f10289r);
            }
            this.f10284m.b(b, this.f10288q);
            return;
        }
        Bundle bundle;
        if (this.f10289r != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("group_commerce_sell_options_id", this.f10289r);
            bundle = bundle2;
        } else {
            bundle = null;
        }
        ((FbUriIntentHandler) this.f10275d.get()).a(this.f10288q, formatStrLocaleSafe, bundle);
    }

    public final void mo491b(String str, String str2) {
        m10409l(str);
        ((NavigationLogger) this.f10272a.get()).a(str2);
        ((FbUriIntentHandler) this.f10275d.get()).a(this.f10288q, StringFormatUtil.formatStrLocaleSafe(FBLinks.ab, Long.valueOf(this.f10292u.b)));
    }

    public final void mo493c(String str, String str2) {
        m10409l(str);
        ((NavigationLogger) this.f10272a.get()).a(str2);
        ((FbUriIntentHandler) this.f10275d.get()).a(this.f10288q, StringFormatUtil.formatStrLocaleSafe(FBLinks.bc, Long.valueOf(this.f10292u.b)));
    }

    public final void mo486a() {
        ((ProfileRefresherAnalyticsLogger) this.f10278g.get()).a("profile_refresher");
        Activity activity = (Activity) ContextUtils.a(this.f10288q, Activity.class);
        if (activity != null) {
            ProfileRefresherLauncher profileRefresherLauncher = (ProfileRefresherLauncher) this.f10277f.get();
            Builder builder = new Builder();
            builder.a = this.f10293v.N();
            builder = builder;
            builder.b = String.valueOf(this.f10292u.b);
            builder = builder;
            builder.c = this.f10293v.L();
            builder = builder;
            builder.d = this.f10293v.R();
            builder = builder;
            builder.e = true;
            profileRefresherLauncher.a(builder.a(), activity);
        }
    }

    public final void mo490b(String str) {
        m10409l(str);
        ((FbUriIntentHandler) this.f10275d.get()).a(this.f10288q, StringFormatUtil.formatStrLocaleSafe(FBLinks.aY, Long.valueOf(this.f10292u.b)));
    }

    public final void mo492c(String str) {
        m10409l(str);
        Futures.a(this.f10294w.m11956a().b(this.f10292u.a, this.f10292u.b), ((ProfileServicesCallbackHelper) this.f10276e.get()).a(this.f10288q, this.f10293v.N()), (Executor) this.f10273b.get());
    }

    public final void mo494d(String str) {
        m10409l(str);
        ((FbUriIntentHandler) this.f10275d.get()).a(this.f10288q, StringFormatUtil.formatStrLocaleSafe(FBLinks.dh, Long.valueOf(this.f10292u.a), Long.valueOf(this.f10292u.b)));
    }

    public final void mo495e(String str) {
        m10409l(str);
        ((FbUriIntentHandler) this.f10275d.get()).a(this.f10288q, StringFormatUtil.formatStrLocaleSafe(FBLinks.di, Long.valueOf(this.f10292u.b), this.f10293v.N()));
    }

    public final void mo496f(String str) {
        m10409l(str);
        ((FbUriIntentHandler) this.f10275d.get()).a(this.f10288q, StringFormatUtil.formatStrLocaleSafe(FBLinks.z, Long.valueOf(this.f10292u.b), this.f10293v.N()));
    }

    public final void mo497g(String str) {
        m10409l(str);
        m10404g();
    }

    public final void mo498h(String str) {
        m10409l(str);
        ((FbUriIntentHandler) this.f10275d.get()).a(this.f10288q, StringFormatUtil.formatStrLocaleSafe(FBLinks.cB, Long.valueOf(this.f10292u.b), GraphQLNegativeFeedbackActionType.DONT_LIKE, NegativeFeedbackExperienceLocation.TIMELINE_SOMEONE_ELSE.stringValueOf()));
    }

    public final void mo499i(String str) {
        m10409l(str);
        this.f10285n.mo473l().mo546a();
    }

    public final void mo500j(String str) {
        m10409l(str);
        this.f10285n.mo483t().mo544a();
    }

    public final void mo501k(String str) {
        m10409l(str);
        ((FbUriIntentHandler) this.f10275d.get()).a(this.f10288q, FBLinks.cF);
    }

    public final void m10414b() {
        if (this.f10296y != null && this.f10296y.isShowing()) {
            this.f10296y.dismiss();
        }
    }

    private void m10391a(View view) {
        boolean z = true;
        if (this.f10293v != null) {
            if (m10396c()) {
                PermanentSeeFirstPopUpWindow permanentSeeFirstPopUpWindow = new PermanentSeeFirstPopUpWindow(this.f10288q);
                permanentSeeFirstPopUpWindow.b.setText(StringFormatUtil.formatStrLocaleSafe(permanentSeeFirstPopUpWindow.b.getContext().getString(2131234913), this.f10293v.y()));
                permanentSeeFirstPopUpWindow.a.a(view);
                return;
            }
            boolean z2;
            boolean z3 = this.f10293v.C() == GraphQLSubscribeStatus.IS_SUBSCRIBED;
            if (this.f10293v.B() == GraphQLFriendshipStatus.ARE_FRIENDS) {
                z2 = true;
            } else {
                z2 = false;
            }
            FollowSwitcherPopupWindowProvider followSwitcherPopupWindowProvider = this.f10281j;
            Boolean valueOf = Boolean.valueOf(z3);
            Boolean valueOf2 = Boolean.valueOf(m10398d());
            if (z2) {
                z = false;
            }
            final FollowSwitcherPopupWindow a = followSwitcherPopupWindowProvider.a(view, valueOf, valueOf2, Boolean.valueOf(z));
            final C15141 c15141 = new SubscribeStatusChangedEventSubscriber(this) {
                final /* synthetic */ TimelineActionBarControllerImpl f10257b;

                public final void m10385b(FbEvent fbEvent) {
                    if (TimelineActionBarControllerImpl.m10392a((SubscribeStatusChangedEvent) fbEvent)) {
                        a.i.a();
                    }
                }
            };
            ((FriendingEventBus) this.f10291t.get()).a(c15141);
            a.a(new OnDismissListener(this) {
                final /* synthetic */ TimelineActionBarControllerImpl f10259b;

                public final boolean m10386a(PopoverWindow popoverWindow) {
                    ((FriendingEventBus) this.f10259b.f10291t.get()).b(c15141);
                    return true;
                }
            });
            a.j = new C15163(this);
            a.a();
            a.e();
        }
    }

    private boolean m10396c() {
        return this.f10293v.d != null && this.f10293v.d.k();
    }

    private boolean m10398d() {
        return this.f10293v.C() == GraphQLSubscribeStatus.IS_SUBSCRIBED && this.f10293v.D() == GraphQLSecondarySubscribeStatus.SEE_FIRST;
    }

    private static boolean m10392a(SubscribeStatusChangedEvent subscribeStatusChangedEvent) {
        if (subscribeStatusChangedEvent.d || subscribeStatusChangedEvent.b != GraphQLSubscribeStatus.CAN_SUBSCRIBE) {
            return false;
        }
        return true;
    }

    private void m10409l(String str) {
        this.f10295x.b(this.f10292u.b, str, RelationshipType.getRelationshipType(this.f10292u.i(), this.f10293v.B(), this.f10293v.C()));
    }

    private void m10400e() {
        if (this.f10293v != null) {
            TimelineFriendParams a = TimelineFriendParams.a(this.f10292u, this.f10293v.N(), this.f10293v.C(), this.f10293v.B());
            TimelineFriendPopoverHelper timelineFriendPopoverHelper = (TimelineFriendPopoverHelper) this.f10282k.get();
            if (!(timelineFriendPopoverHelper.f11867e == null || timelineFriendPopoverHelper.f11867e.getWindow() == null)) {
                boolean z;
                Preconditions.checkNotNull(a);
                timelineFriendPopoverHelper.f11870h = a;
                timelineFriendPopoverHelper.f11871i = new FigPopoverMenuWindow(timelineFriendPopoverHelper.f11863a);
                PopoverMenu c = timelineFriendPopoverHelper.f11871i.c();
                timelineFriendPopoverHelper.f11872j = c.a(2131234903);
                TimelineFriendPopoverHelper.m11949e(timelineFriendPopoverHelper);
                timelineFriendPopoverHelper.f11872j.setOnMenuItemClickListener(new C16953(timelineFriendPopoverHelper));
                MenuItem menuItem = timelineFriendPopoverHelper.f11872j;
                if (timelineFriendPopoverHelper.f11870h.d != GraphQLSubscribeStatus.CANNOT_SUBSCRIBE) {
                    z = true;
                } else {
                    z = false;
                }
                menuItem.setVisible(z);
                if (GraphQLFriendshipStatus.ARE_FRIENDS.equals(timelineFriendPopoverHelper.f11870h.e)) {
                    c.a(2131233232).setOnMenuItemClickListener(new C16964(timelineFriendPopoverHelper));
                } else {
                    c.a(2131234924).setOnMenuItemClickListener(new C16975(timelineFriendPopoverHelper));
                }
                c.a(2131233235).setOnMenuItemClickListener(new C16986(timelineFriendPopoverHelper));
                timelineFriendPopoverHelper.f11873k = new FbEventSubscriberListManager();
                timelineFriendPopoverHelper.f11873k.a(new C16997(timelineFriendPopoverHelper));
                timelineFriendPopoverHelper.f11873k.a(timelineFriendPopoverHelper.f11865c);
                timelineFriendPopoverHelper.f11871i.H = timelineFriendPopoverHelper.f11868f;
                timelineFriendPopoverHelper.f11871i.I = timelineFriendPopoverHelper.f11869g;
                timelineFriendPopoverHelper.f11871i.a(timelineFriendPopoverHelper.f11867e.getWindow().getDecorView());
            }
        }
    }

    private void m10402f() {
        if (this.f10292u != null) {
            new AlertDialog.Builder(this.f10288q).a(new String[]{this.f10288q.getResources().getString(2131234861), this.f10288q.getResources().getString(2131234925)}, new C15174(this)).b();
        }
    }

    private void m10404g() {
        CharSequence a = StringLocaleUtil.a(this.f10288q.getResources().getString(2131233241), new Object[]{this.f10293v.N()});
        View inflate = LayoutInflater.from(this.f10288q).inflate(2130907436, null);
        ((TextView) inflate.findViewById(2131567918)).setText(StringLocaleUtil.a(this.f10288q.getResources().getString(2131234950), new Object[]{this.f10293v.N()}));
        ((TextView) inflate.findViewById(2131567919)).setText(StringLocaleUtil.a(this.f10288q.getResources().getString(2131234956), new Object[]{this.f10293v.N()}));
        this.f10296y = new ProgressDialog(this.f10288q);
        this.f10296y.d = 0;
        this.f10296y.a(this.f10288q.getResources().getString(2131234957));
        new AlertDialog.Builder(this.f10288q).b(true).a(a).b(inflate).a(2131234877, new C15185(this)).b(2131234960, null).b();
    }
}
