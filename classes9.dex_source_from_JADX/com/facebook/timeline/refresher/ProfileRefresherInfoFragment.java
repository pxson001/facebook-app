package com.facebook.timeline.refresher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.event.TimelineHeaderEventBus;
import com.facebook.timeline.inforeview.FetchTimelineInfoReviewParams;
import com.facebook.timeline.inforeview.TimelineInfoReviewAdapter;
import com.facebook.timeline.inforeview.TimelineInfoReviewAdapterProvider;
import com.facebook.timeline.inforeview.TimelineInfoReviewData;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQL.TimelineInfoReviewQueryString;
import com.facebook.timeline.refresher.ProfileRefresherInfoController.C01011;
import com.facebook.timeline.refresher.ProfileRefresherInfoController.C01022;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: updateLastReadTimeActionId */
public class ProfileRefresherInfoFragment extends FbFragment {
    @Inject
    public ProfileRefresherInfoControllerProvider f1000a;
    @Inject
    public TimelineInfoReviewAdapterProvider f1001b;
    public InfoFragmentListener f1002c;
    @Nullable
    private TimelineInfoReviewAdapter f1003d;
    private ProfileRefresherInfoController f1004e;
    private ViewGroup f1005f;
    private LoadingIndicatorView f1006g;

    /* compiled from: updateLastReadTimeActionId */
    public interface InfoFragmentListener {
        void mo47j();
    }

    public static void m1016a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ProfileRefresherInfoFragment profileRefresherInfoFragment = (ProfileRefresherInfoFragment) obj;
        ProfileRefresherInfoControllerProvider profileRefresherInfoControllerProvider = (ProfileRefresherInfoControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ProfileRefresherInfoControllerProvider.class);
        TimelineInfoReviewAdapterProvider timelineInfoReviewAdapterProvider = (TimelineInfoReviewAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(TimelineInfoReviewAdapterProvider.class);
        profileRefresherInfoFragment.f1000a = profileRefresherInfoControllerProvider;
        profileRefresherInfoFragment.f1001b = timelineInfoReviewAdapterProvider;
    }

    public final void m1023c(Bundle bundle) {
        super.c(bundle);
        Class cls = ProfileRefresherInfoFragment.class;
        m1016a(this, getContext());
        ProfileRefresherInfoControllerProvider profileRefresherInfoControllerProvider = this.f1000a;
        this.f1004e = new ProfileRefresherInfoController(this, GraphQLQueryExecutor.a(profileRefresherInfoControllerProvider), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(profileRefresherInfoControllerProvider), TimelineHeaderEventBus.a(profileRefresherInfoControllerProvider));
        ProfileRefresherInfoController profileRefresherInfoController = this.f1004e;
        profileRefresherInfoController.f999f.a(new C01011(profileRefresherInfoController));
        Futures.a(profileRefresherInfoController.f995b.a(GraphQLRequest.a((TimelineInfoReviewQueryString) new TimelineInfoReviewQueryString().a("scale", GraphQlQueryDefaults.a()).a("ref", "android_plutonium_expando").a("session", new FetchTimelineInfoReviewParams("").f846a).a("surface", "native_plutonium_header"))), new C01022(profileRefresherInfoController), profileRefresherInfoController.f996c);
    }

    public final void m1021a(Activity activity) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -315681574);
        super.a(activity);
        this.f1002c = (InfoFragmentListener) activity;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1285933907, a);
    }

    public final View m1019a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1648250641);
        View inflate = layoutInflater.inflate(2130906472, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -364834180, a);
        return inflate;
    }

    public final void m1024d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -380183108);
        super.d(bundle);
        this.f1005f = (ViewGroup) e(2131566401);
        this.f1006g = (LoadingIndicatorView) e(2131566402);
        this.f1006g.a();
        ProfileRefresherInfoController profileRefresherInfoController = this.f1004e;
        profileRefresherInfoController.f994a.m1022a(profileRefresherInfoController.f998e);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 813007518, a);
    }

    public final void m1020a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1 && i == 1956) {
            ProfileRefresherInfoController profileRefresherInfoController = this.f1004e;
            String stringExtra = intent.getStringExtra("typeahead_selected_page_id");
            String stringExtra2 = intent.getStringExtra("typeahead_selected_page_name");
            profileRefresherInfoController.f998e.f914f.m896a(stringExtra);
            profileRefresherInfoController.f998e.f914f.m901b(stringExtra2);
            profileRefresherInfoController.m1015d();
        }
    }

    public final void m1017G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -477240335);
        super.G();
        ProfileRefresherInfoController profileRefresherInfoController = this.f1004e;
        profileRefresherInfoController.f999f.a(profileRefresherInfoController.f997d);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 31427234, a);
    }

    public final void m1018H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1682713805);
        ProfileRefresherInfoController profileRefresherInfoController = this.f1004e;
        profileRefresherInfoController.f999f.b(profileRefresherInfoController.f997d);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1574869119, a);
    }

    public final void m1022a(TimelineInfoReviewData timelineInfoReviewData) {
        if (timelineInfoReviewData.d() && this.T != null) {
            this.f1005f.removeAllViews();
            this.f1003d = this.f1001b.m920a(o(), timelineInfoReviewData);
            if (this.f1003d.isEmpty()) {
                this.f1002c.mo47j();
                return;
            }
            for (int i = 0; i < this.f1003d.getCount(); i++) {
                this.f1005f.addView(this.f1003d.getView(i, null, this.f1005f));
            }
            this.f1006g.b();
        }
    }
}
