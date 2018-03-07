package com.facebook.appinvites.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ListView;
import com.facebook.appinvites.adapter.AppInvitesAdapter;
import com.facebook.appinvites.adapter.AppInvitesAdapter.C20301;
import com.facebook.appinvites.adapter.AppInvitesAdapter.C20312;
import com.facebook.appinvites.adapter.AppInvitesAdapter.C20323;
import com.facebook.appinvites.adapter.AppInvitesAdapter.C20334;
import com.facebook.appinvites.adapter.AppInvitesAdapter.C20345;
import com.facebook.appinvites.adapter.AppInvitesAdapter.C20356;
import com.facebook.appinvites.adapter.AppInvitesAdapterProvider;
import com.facebook.appinvites.data.AppInvitesData;
import com.facebook.appinvites.events.AppInvitesEventBus;
import com.facebook.appinvites.nux.AppInviteNuxInterstitialController;
import com.facebook.appinvites.nux.AppInviteNuxInterstitialController$1;
import com.facebook.appinvites.nux.AppInvitesNuxSyncController;
import com.facebook.appinvites.protocol.FetchAppInvitesListQuery.AppInvitesListQueryString;
import com.facebook.appinvites.protocol.FetchAppInvitesListQueryModels.AppInvitesListQueryModel;
import com.facebook.appinvites.ui.AppInvitesViewController;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.calls.DeviceInputDevice;
import com.facebook.graphql.calls.RequestsTypeInputRequestsType;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.FbInjector;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.refreshableview.RefreshableListViewContainer;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike.OnRefreshListener;
import javax.inject.Inject;

/* compiled from: edit_event */
public class AppInvitesFragment extends FbFragment {
    public static final Class<?> f14588h = AppInvitesFragment.class;
    public static final String f14589i = FBLinks.dc;
    @Inject
    public GraphQLQueryExecutor f14590a;
    public AppInvitesAdapter al;
    private FbEventSubscriberListManager am;
    public AppInvitesData an;
    public RefreshableListViewContainer ao;
    public ListView ap;
    public LoadingIndicatorView aq;
    private View ar;
    private ViewStub as;
    @Inject
    TasksManager f14591b;
    @Inject
    AppInvitesAdapterProvider f14592c;
    @Inject
    FbUriIntentHandler f14593d;
    @Inject
    InterstitialManager f14594e;
    @Inject
    AppInvitesNuxSyncController f14595f;
    @Inject
    AppInvitesEventBus f14596g;

    /* compiled from: edit_event */
    class C20421 implements OnTouchListener {
        final /* synthetic */ AppInvitesFragment f14582a;

        C20421(AppInvitesFragment appInvitesFragment) {
            this.f14582a = appInvitesFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getHistorySize() != 0) {
                if (motionEvent.getY(0) < motionEvent.getHistoricalY(0)) {
                    if (this.f14582a.ap.getOverScrollMode() != 0) {
                        this.f14582a.ap.setOverScrollMode(0);
                    }
                } else if (this.f14582a.ap.getOverScrollMode() != 2) {
                    this.f14582a.ap.setOverScrollMode(2);
                }
            }
            return false;
        }
    }

    /* compiled from: edit_event */
    class C20432 extends OnRefreshListener {
        final /* synthetic */ AppInvitesFragment f14583a;

        C20432(AppInvitesFragment appInvitesFragment) {
            this.f14583a = appInvitesFragment;
        }

        public final void m14752b(boolean z) {
            if (z) {
                AppInvitesFragment.m14756a(this.f14583a, false);
            }
        }
    }

    /* compiled from: edit_event */
    class C20443 implements OnClickListener {
        final /* synthetic */ AppInvitesFragment f14584a;

        C20443(AppInvitesFragment appInvitesFragment) {
            this.f14584a = appInvitesFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -81918185);
            this.f14584a.f14593d.a(this.f14584a.getContext(), AppInvitesFragment.f14589i);
            Logger.a(2, EntryType.UI_INPUT_END, 1792850661, a);
        }
    }

    /* compiled from: edit_event */
    enum AppInvitesTask {
        FETCH_INVITES
    }

    public static void m14758a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AppInvitesFragment) obj).m14757a(GraphQLQueryExecutor.a(fbInjector), TasksManager.b(fbInjector), (AppInvitesAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(AppInvitesAdapterProvider.class), FbUriIntentHandler.a(fbInjector), InterstitialManager.a(fbInjector), AppInvitesNuxSyncController.m14769a(fbInjector), AppInvitesEventBus.a(fbInjector));
    }

    public final void m14761c(Bundle bundle) {
        super.c(bundle);
        Class cls = AppInvitesFragment.class;
        m14758a((Object) this, getContext());
        this.an = new AppInvitesData();
        this.al = new AppInvitesAdapter(this.an, AppInvitesViewController.m15104b(this.f14592c));
        this.am = new FbEventSubscriberListManager();
        this.am.a(new C20301(this.al));
        this.am.a(new C20312(this.al));
        this.am.a(new C20323(this.al));
        this.am.a(new C20334(this.al));
        this.am.a(new C20345(this.al));
        this.am.a(new C20356(this.al));
        this.am.a(this.f14596g);
        this.f14595f.f14613a = false;
    }

    public final void m14759I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1340720814);
        super.I();
        this.am.b(this.f14596g);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1016240516, a);
    }

    public final View m14760a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 972070889);
        View inflate = layoutInflater.inflate(2130903277, viewGroup, false);
        this.ap = (BetterListView) inflate.findViewById(2131559658);
        this.ap.setAdapter(this.al);
        this.ap.setOverScrollMode(2);
        this.ap.setOnTouchListener(new C20421(this));
        this.ao = (RefreshableListViewContainer) inflate.findViewById(2131559657);
        this.aq = (LoadingIndicatorView) inflate.findViewById(2131559656);
        this.ao.setVisibility(8);
        this.ao.setOnRefreshListener(new C20432(this));
        this.ar = inflate.findViewById(2131559659);
        this.ap.setEmptyView(this.ar);
        this.ar.setVisibility(8);
        ((FbButton) inflate.findViewById(2131559662)).setOnClickListener(new C20443(this));
        this.as = (ViewStub) inflate.findViewById(2131559655);
        m14756a(this, true);
        this.aq.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2068746176, a);
        return inflate;
    }

    public static void m14756a(AppInvitesFragment appInvitesFragment, final boolean z) {
        appInvitesFragment.f14591b.a(AppInvitesTask.FETCH_INVITES, appInvitesFragment.f14590a.a(GraphQLRequest.a((AppInvitesListQueryString) new AppInvitesListQueryString().a("invite_image_scale", GraphQlQueryDefaults.a()).a("app_profile_image_size", String.valueOf(2131434164)).a("sender_profile_image_size", String.valueOf(2131434163)).a("request_type", RequestsTypeInputRequestsType.INVITE).a("device", DeviceInputDevice.ANDROID)).a(GraphQLCachePolicy.c)), new AbstractDisposableFutureCallback<GraphQLResult<AppInvitesListQueryModel>>(appInvitesFragment) {
            public final /* synthetic */ AppInvitesFragment f14587b;

            /* compiled from: edit_event */
            class C20451 implements RetryClickedListener {
                final /* synthetic */ C20464 f14585a;

                C20451(C20464 c20464) {
                    this.f14585a = c20464;
                }

                public final void m14753a() {
                    AppInvitesFragment.m14756a(this.f14585a.f14587b, z);
                }
            }

            protected final void m14755a(Throwable th) {
                BLog.b(AppInvitesFragment.f14588h, "Fetch invites failed", th);
                if (this.f14587b.aq.getVisibility() == 0) {
                    this.f14587b.aq.a(this.f14587b.jW_().getString(2131230811), new C20451(this));
                } else {
                    this.f14587b.ao.g();
                }
            }
        });
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1690207533);
        super.mY_();
        this.f14591b.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -280136463, a);
    }

    public static void ar(AppInvitesFragment appInvitesFragment) {
        AppInviteNuxInterstitialController appInviteNuxInterstitialController = (AppInviteNuxInterstitialController) appInvitesFragment.f14594e.a(new InterstitialTrigger(Action.APP_INVITE_FEED), AppInviteNuxInterstitialController.class);
        if (appInviteNuxInterstitialController != null) {
            ViewStub viewStub = appInvitesFragment.as;
            if (viewStub != null) {
                viewStub.setLayoutResource(2130903282);
                View inflate = viewStub.inflate();
                inflate.findViewById(2131559679).setOnClickListener(new AppInviteNuxInterstitialController$1(inflate));
            }
            appInvitesFragment.f14595f.f14613a = true;
            appInvitesFragment.f14594e.a().a(appInviteNuxInterstitialController.b());
        }
    }

    private void m14757a(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, AppInvitesAdapterProvider appInvitesAdapterProvider, FbUriIntentHandler fbUriIntentHandler, InterstitialManager interstitialManager, AppInvitesNuxSyncController appInvitesNuxSyncController, AppInvitesEventBus appInvitesEventBus) {
        this.f14590a = graphQLQueryExecutor;
        this.f14591b = tasksManager;
        this.f14592c = appInvitesAdapterProvider;
        this.f14593d = fbUriIntentHandler;
        this.f14594e = interstitialManager;
        this.f14595f = appInvitesNuxSyncController;
        this.f14596g = appInvitesEventBus;
    }
}
