package com.facebook.notifications.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.graphql.calls.NotifOptionSetContextInputNotifOptionSetContext;
import com.facebook.graphql.calls.NotifOptionSetContextInputNotifOptionSetContext.SupportedDisplayStyles;
import com.facebook.graphql.calls.NotifOptionSetContextInputNotifOptionSetContext.SupportedDisplayStyles.OptionDisplayStyles;
import com.facebook.graphql.calls.NotifOptionSetContextInputNotifOptionSetContext.SupportedDisplayStyles.OptionSetDisplayStyle;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.event.NotificationsEventBus;
import com.facebook.notifications.event.NotificationsEvents.NotificationsActionExecutedEvent;
import com.facebook.notifications.event.NotificationsEvents.NotificationsActionExecutedSubscriber;
import com.facebook.notifications.logging.NotificationSettingsLogger;
import com.facebook.notifications.logging.NotificationSettingsLogger.Surface;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.notifications.protocol.NotifOptionRowsMutationModels.NotifOptionActionMutationModel;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQL.NotificationUserSettingsQueryString;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment.NotifOptions.Nodes;
import com.facebook.notifications.protocol.NotificationsOptionSetContextBuilder;
import com.facebook.notifications.settings.NotifOptionSetNode;
import com.facebook.notifications.settings.NotificationSettingsDataFetcher;
import com.facebook.notifications.settings.NotificationSettingsDataFetcher.NotificationSettingsCallback;
import com.facebook.notifications.settings.NotificationSettingsFeedEnvironment;
import com.facebook.notifications.settings.NotificationSettingsFeedEnvironmentProvider;
import com.facebook.notifications.settings.NotificationSettingsItemCollection;
import com.facebook.notifications.settings.NotificationSettingsLocalPreferenceMigrator;
import com.facebook.notifications.settings.NotificationSettingsRootGroupPartDefinition;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: method/mobile.zeroGetRecommendedPromo */
public class NotificationSettingsFragment extends FbFragment {
    public static final Class<?> am = NotificationSettingsFragment.class;
    @Inject
    NotificationSettingsDataFetcher f9028a;
    @Inject
    @ForUiThread
    public Executor al;
    public MultiRowAdapter an;
    private ImmutableList<String> ao;
    public ScrollingViewProxy ap;
    public NotificationSettingsItemCollection aq;
    private final NotificationsActionExecutedSubscriber ar = new C07201(this);
    @Inject
    NotificationSettingsFeedEnvironmentProvider f9029b;
    @Inject
    AbstractFbErrorReporter f9030c;
    @Inject
    public NotificationSettingsLocalPreferenceMigrator f9031d;
    @Inject
    public MultiRowAdapterBuilder f9032e;
    @Inject
    NotificationsEventBus f9033f;
    @Inject
    MultipleRowsStoriesRecycleCallback f9034g;
    @Inject
    public Lazy<NotificationSettingsRootGroupPartDefinition> f9035h;
    @Inject
    NotificationSettingsLogger f9036i;

    /* compiled from: method/mobile.zeroGetRecommendedPromo */
    class C07201 extends NotificationsActionExecutedSubscriber {
        final /* synthetic */ NotificationSettingsFragment f9025a;

        C07201(NotificationSettingsFragment notificationSettingsFragment) {
            this.f9025a = notificationSettingsFragment;
        }

        public final void m10865b(FbEvent fbEvent) {
            NotificationsActionExecutedEvent notificationsActionExecutedEvent = (NotificationsActionExecutedEvent) fbEvent;
            if (notificationsActionExecutedEvent.f8155a != null) {
                Object obj;
                NotificationSettingsItemCollection notificationSettingsItemCollection = this.f9025a.aq;
                String str = notificationsActionExecutedEvent.f8155a;
                loop0:
                for (NotifOptionSetNode notifOptionSetNode : notificationSettingsItemCollection.f8727a) {
                    if (!(notifOptionSetNode.f8710a == null || notifOptionSetNode.f8710a.mo467c() == null)) {
                        ImmutableList a = notifOptionSetNode.f8710a.mo467c().mo464a();
                        int size = a.size();
                        for (int i = 0; i < size; i++) {
                            if (((Nodes) a.get(i)).mo461c().equals(str)) {
                                obj = 1;
                                break loop0;
                            }
                        }
                        continue;
                    }
                }
                obj = null;
                if (obj != null) {
                    NotificationSettingsFragment.aq(this.f9025a);
                }
            }
        }
    }

    /* compiled from: method/mobile.zeroGetRecommendedPromo */
    public class C07212 extends AbstractDisposableFutureCallback<GraphQLResult<NotifOptionActionMutationModel>> {
        final /* synthetic */ NotificationSettingsFragment f9026a;

        public C07212(NotificationSettingsFragment notificationSettingsFragment) {
            this.f9026a = notificationSettingsFragment;
        }

        protected final void m10866a(Object obj) {
            NotificationSettingsFragment.aq(this.f9026a);
            this.f9026a.f9031d.m10699c();
        }

        protected final void m10867a(Throwable th) {
            NotificationSettingsFragment.aq(this.f9026a);
            this.f9026a.f9030c.a(NotificationSettingsFragment.am.getSimpleName(), "Fail to sync local settings");
        }
    }

    /* compiled from: method/mobile.zeroGetRecommendedPromo */
    public class C07223 implements Runnable {
        final /* synthetic */ NotificationSettingsFragment f9027a;

        public C07223(NotificationSettingsFragment notificationSettingsFragment) {
            this.f9027a = notificationSettingsFragment;
        }

        public void run() {
            this.f9027a.an.notifyDataSetChanged();
        }
    }

    public static void m10869a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((NotificationSettingsFragment) obj).m10868a(NotificationSettingsDataFetcher.m10684a(fbInjector), (NotificationSettingsFeedEnvironmentProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(NotificationSettingsFeedEnvironmentProvider.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), new NotificationSettingsLocalPreferenceMigrator(IdBasedLazy.a(fbInjector, 2164), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector)), MultiRowAdapterBuilder.b(fbInjector), NotificationsEventBus.a(fbInjector), MultipleRowsStoriesRecycleCallback.a(fbInjector), IdBasedLazy.a(fbInjector, 8726), NotificationSettingsLogger.b(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector));
    }

    public final void m10875c(Bundle bundle) {
        Class cls = NotificationSettingsFragment.class;
        m10869a(this, getContext());
        super.c(bundle);
    }

    public final View m10873a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 388440811);
        View inflate = layoutInflater.inflate(2130905479, viewGroup, false);
        BetterRecyclerView betterRecyclerView = (BetterRecyclerView) FindViewUtil.b(inflate, 2131564270);
        betterRecyclerView.setLayoutManager(new BetterLinearLayoutManager(getContext()));
        this.aq = new NotificationSettingsItemCollection();
        BaseFeedEnvironment notificationSettingsFeedEnvironment = new NotificationSettingsFeedEnvironment(getContext(), HasScrollListenerSupportImpl.a(this.ap), new C07223(this));
        notificationSettingsFeedEnvironment.a_(true);
        Builder a2 = this.f9032e.a(this.f9035h, this.aq);
        a2.f = notificationSettingsFeedEnvironment;
        this.an = a2.e();
        this.ap = new RecyclerViewProxy(betterRecyclerView);
        this.ap.b(false);
        this.ap.f(inflate.findViewById(16908292));
        this.ap.a(this.an);
        this.ap.a(this.f9034g.a());
        Intent intent = o().getIntent();
        if (intent.hasExtra("extra_option_row_set_ids")) {
            this.ao = ImmutableList.copyOf(intent.getStringArrayListExtra("extra_option_row_set_ids"));
        }
        if (ar()) {
            this.f9036i.a(Surface.WEBVIEW);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -979410984, a);
        return inflate;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1525825245);
        super.mi_();
        m10870a(o().getIntent().getStringExtra("fragment_title"));
        if (this.f9031d.f8730c.a(NotificationsPreferenceConstants.L, true)) {
            ListenableFuture a2 = this.f9031d.m10698a();
            if (a2 == null) {
                aq(this);
            } else {
                Futures.a(a2, new C07212(this), this.al);
            }
        } else {
            aq(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -915792113, a);
    }

    public final void m10871G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1506835681);
        super.G();
        this.f9033f.a(this.ar);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 96221305, a);
    }

    public final void m10872H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1692778117);
        super.H();
        this.f9033f.b(this.ar);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 464723231, a);
    }

    public final void m10874a(List<? extends NotifOptionSetFragment> list) {
        this.aq.f8727a.clear();
        for (int i = 0; i < list.size(); i++) {
            NotificationSettingsItemCollection notificationSettingsItemCollection = this.aq;
            notificationSettingsItemCollection.f8727a.add(new NotifOptionSetNode((NotifOptionSetFragment) list.get(i), i));
        }
        this.an.notifyDataSetChanged();
    }

    public static void aq(NotificationSettingsFragment notificationSettingsFragment) {
        if (notificationSettingsFragment.ar()) {
            NotificationSettingsDataFetcher notificationSettingsDataFetcher = notificationSettingsFragment.f9028a;
            GraphQlQueryString notificationUserSettingsQueryString = new NotificationUserSettingsQueryString();
            NotifOptionSetContextInputNotifOptionSetContext notifOptionSetContextInputNotifOptionSetContext = new NotifOptionSetContextInputNotifOptionSetContext();
            notifOptionSetContextInputNotifOptionSetContext.a("supported_display_styles", ImmutableList.of(new SupportedDisplayStyles().a(OptionSetDisplayStyle.SETTING_PAGE_SECTION).a(ImmutableList.of(OptionDisplayStyles.BASIC_MENU, OptionDisplayStyles.PROFILE_IMAGE_OPTION, OptionDisplayStyles.TEXT_WITH_BUTTON, OptionDisplayStyles.WASH_TEXTS)), new SupportedDisplayStyles().a(OptionSetDisplayStyle.MENU_SECTION_WITH_INDEPENDENT_ROWS).a(ImmutableList.of(OptionDisplayStyles.BASIC_MENU, OptionDisplayStyles.PROFILE_IMAGE_OPTION, OptionDisplayStyles.TEXT_WITH_BUTTON, OptionDisplayStyles.WASH_TEXTS)), new SupportedDisplayStyles().a(OptionSetDisplayStyle.TOGGLE).a(ImmutableList.of(OptionDisplayStyles.TOGGLE_ON, OptionDisplayStyles.TOGGLE_OFF)), new SupportedDisplayStyles().a(OptionSetDisplayStyle.SINGLE_SELECTOR).a(ImmutableList.of(OptionDisplayStyles.BLUE_CIRCLE_BUTTON)), new SupportedDisplayStyles().a(OptionSetDisplayStyle.MULTI_SELECTOR).a(ImmutableList.of(OptionDisplayStyles.PLAIN_CHECK))));
            notifOptionSetContextInputNotifOptionSetContext.a("client_action_types", NotificationsOptionSetContextBuilder.m10657b());
            notificationUserSettingsQueryString.a("notif_option_set_context", notifOptionSetContextInputNotifOptionSetContext);
            notificationUserSettingsQueryString.a("image_height", notificationSettingsDataFetcher.f8720b.f());
            notificationUserSettingsQueryString.a("image_width", notificationSettingsDataFetcher.f8720b.f());
            notificationUserSettingsQueryString.a("icon_scale", GraphQlQueryDefaults.a());
            notificationSettingsDataFetcher.f8721c.a("NOTIFICATION_SETTINGS_LOAD", notificationSettingsDataFetcher.f8719a.a(GraphQLRequest.a(notificationUserSettingsQueryString)), new NotificationSettingsCallback(notificationSettingsFragment));
            return;
        }
        notificationSettingsFragment.f9028a.m10686a(notificationSettingsFragment.ao, notificationSettingsFragment);
    }

    private void m10870a(@Nullable String str) {
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            if (Strings.isNullOrEmpty(str)) {
                str = o().getResources().getString(2131233696);
            }
            hasTitleBar.a_(str);
            hasTitleBar.c(true);
        }
    }

    private boolean ar() {
        return this.ao == null;
    }

    private void m10868a(NotificationSettingsDataFetcher notificationSettingsDataFetcher, NotificationSettingsFeedEnvironmentProvider notificationSettingsFeedEnvironmentProvider, FbErrorReporter fbErrorReporter, NotificationSettingsLocalPreferenceMigrator notificationSettingsLocalPreferenceMigrator, MultiRowAdapterBuilder multiRowAdapterBuilder, NotificationsEventBus notificationsEventBus, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, Lazy<NotificationSettingsRootGroupPartDefinition> lazy, NotificationSettingsLogger notificationSettingsLogger, Executor executor) {
        this.f9028a = notificationSettingsDataFetcher;
        this.f9029b = notificationSettingsFeedEnvironmentProvider;
        this.f9030c = fbErrorReporter;
        this.f9031d = notificationSettingsLocalPreferenceMigrator;
        this.f9032e = multiRowAdapterBuilder;
        this.f9033f = notificationsEventBus;
        this.f9034g = multipleRowsStoriesRecycleCallback;
        this.f9035h = lazy;
        this.f9036i = notificationSettingsLogger;
        this.al = executor;
    }
}
