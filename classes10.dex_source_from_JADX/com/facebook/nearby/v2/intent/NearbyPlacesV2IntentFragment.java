package com.facebook.nearby.v2.intent;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.graphql.calls.CheckinSearchQueryInputCheckinSearchQuery;
import com.facebook.graphql.calls.CheckinSearchQueryInputCheckinSearchQuery.ViewerCoordinates;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.FbInjector;
import com.facebook.location.gmsupsell.GooglePlayLocationServicesSettingsManager.LocationSettingsRequestParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.NearbyPlacesV2Fragment;
import com.facebook.nearby.v2.NearbyPlacesV2Fragment.4;
import com.facebook.nearby.v2.NearbyPlacesV2Fragment.5;
import com.facebook.nearby.v2.NearbyPlacesV2Fragment.ContentFragmentViewState;
import com.facebook.nearby.v2.abtest.ExperimentsForNearbyPlacesModule;
import com.facebook.nearby.v2.intent.NearbyPlacesHereCardRunner.C07031;
import com.facebook.nearby.v2.intent.categorypicker.NearbyPlacesCategoryPickerView.OnClickCategoryPickerIconListener;
import com.facebook.nearby.v2.intent.categorypicker.icons.NearbyPlacesCategoryPickerIconToQueryTopicConverter;
import com.facebook.nearby.v2.intent.categorypicker.icons.NearbyPlacesCategoryPickerIconType;
import com.facebook.nearby.v2.intent.model.FBNearbyPlacesIntentModel;
import com.facebook.nearby.v2.model.NearbyPlacesFragmentModel;
import com.facebook.nearby.v2.model.NearbyPlacesPlaceModel;
import com.facebook.nearby.v2.model.NearbyPlacesResultListQueryTopic;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataProvider;
import com.facebook.nearby.v2.network.NearbyPlacesHereCardSuggestionGraphQL.FBNearbyPlacesHereCardHugeResultCellQueryString;
import com.facebook.nearby.v2.resultlist.util.NearbyPlacesV2PageActionHandler;
import com.facebook.nearby.v2.resultlist.views.itemview.actionbar.NearbyPlacesActionBarView.ActionBarItemType;
import com.facebook.places.future.SimpleExecutor;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.BetterListView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: people_count */
public class NearbyPlacesV2IntentFragment extends FbFragment implements AnalyticsFragment {
    public static final Class<?> f5131c = NearbyPlacesV2IntentFragment.class;
    @Inject
    public NearbyPlacesHereCardRunner f5132a;
    public NearbyPlacesV2Fragment al;
    public NearbyPlacesSearchDataProvider am;
    public NearbyPlacesFragmentModel an;
    @Inject
    public NearbyPlacesV2PageActionHandler f5133b;
    private final OnClickCategoryPickerIconListener f5134d = new C07081(this);
    private final C07092 f5135e = new C07092(this);
    public FBNearbyPlacesIntentModel f5136f;
    private ViewGroup f5137g;
    private BetterListView f5138h;
    public NearbyPlacesIntentListAdapter f5139i;

    /* compiled from: people_count */
    class C07081 implements OnClickCategoryPickerIconListener {
        final /* synthetic */ NearbyPlacesV2IntentFragment f5126a;

        C07081(NearbyPlacesV2IntentFragment nearbyPlacesV2IntentFragment) {
            this.f5126a = nearbyPlacesV2IntentFragment;
        }

        public final void mo139a(NearbyPlacesCategoryPickerIconType nearbyPlacesCategoryPickerIconType) {
            NearbyPlacesResultListQueryTopic a = NearbyPlacesCategoryPickerIconToQueryTopicConverter.m4640a(nearbyPlacesCategoryPickerIconType, this.f5126a.jW_());
            if (a != null && this.f5126a.al != null) {
                NearbyPlacesV2Fragment nearbyPlacesV2Fragment = this.f5126a.al;
                Preconditions.checkNotNull(a);
                nearbyPlacesV2Fragment.as.b.h = a;
                NearbyPlacesV2Fragment.au(nearbyPlacesV2Fragment);
                if (nearbyPlacesV2Fragment.as.b.h()) {
                    NearbyPlacesV2Fragment.a(nearbyPlacesV2Fragment, ContentFragmentViewState.RESULT_LIST_FRAGMENT);
                } else {
                    nearbyPlacesV2Fragment.ar.an.requestFocus();
                }
            }
        }
    }

    /* compiled from: people_count */
    public class C07092 {
        public final /* synthetic */ NearbyPlacesV2IntentFragment f5127a;

        C07092(NearbyPlacesV2IntentFragment nearbyPlacesV2IntentFragment) {
            this.f5127a = nearbyPlacesV2IntentFragment;
        }
    }

    /* compiled from: people_count */
    class C07103 implements OnClickListener {
        final /* synthetic */ NearbyPlacesV2IntentFragment f5128a;

        C07103(NearbyPlacesV2IntentFragment nearbyPlacesV2IntentFragment) {
            this.f5128a = nearbyPlacesV2IntentFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -748538557);
            NearbyPlacesV2Fragment nearbyPlacesV2Fragment = this.f5128a.al;
            switch (5.b[nearbyPlacesV2Fragment.as.b.a.ordinal()]) {
                case 1:
                case 2:
                    if (!nearbyPlacesV2Fragment.f.a(ExperimentsForNearbyPlacesModule.a, false)) {
                        nearbyPlacesV2Fragment.a(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                        break;
                    }
                    nearbyPlacesV2Fragment.e.a(new LocationSettingsRequestParams(), "surface_checkin_niem_controller", "mechanism_niem");
                    break;
                case 3:
                    nearbyPlacesV2Fragment.au.a(NearbyPlacesV2Fragment.i, new 4(nearbyPlacesV2Fragment));
                    break;
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1481501106, a);
        }
    }

    /* compiled from: people_count */
    public class C07114 implements FutureCallback<ArrayList<NearbyPlacesPlaceModel>> {
        final /* synthetic */ NearbyPlacesV2IntentFragment f5129a;

        public C07114(NearbyPlacesV2IntentFragment nearbyPlacesV2IntentFragment) {
            this.f5129a = nearbyPlacesV2IntentFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            if (arrayList != null && !arrayList.isEmpty()) {
                this.f5129a.f5136f.f5151a = ImmutableList.copyOf(arrayList);
                AdapterDetour.a(this.f5129a.f5139i, 468348273);
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: people_count */
    public /* synthetic */ class C07125 {
        public static final /* synthetic */ int[] f5130a = new int[ActionBarItemType.values().length];

        static {
            try {
                f5130a[ActionBarItemType.DISTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5130a[ActionBarItemType.LIKES.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5130a[ActionBarItemType.REVIEW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5130a[ActionBarItemType.OPEN_NOW.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5130a[ActionBarItemType.PRICE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static void m4632a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        NearbyPlacesV2IntentFragment nearbyPlacesV2IntentFragment = (NearbyPlacesV2IntentFragment) obj;
        NearbyPlacesHereCardRunner nearbyPlacesHereCardRunner = new NearbyPlacesHereCardRunner(GraphQLQueryExecutor.a(fbInjector), SimpleExecutor.b(fbInjector));
        NearbyPlacesV2PageActionHandler a = NearbyPlacesV2PageActionHandler.a(fbInjector);
        nearbyPlacesV2IntentFragment.f5132a = nearbyPlacesHereCardRunner;
        nearbyPlacesV2IntentFragment.f5133b = a;
    }

    public final void m4636c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = NearbyPlacesV2IntentFragment.class;
        m4632a(this, getContext());
    }

    public final void m4637d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 977007495);
        super.d(bundle);
        if (bundle != null) {
            this.f5136f = (FBNearbyPlacesIntentModel) bundle.getParcelable("intent_model_state");
        } else {
            this.f5136f = new FBNearbyPlacesIntentModel();
        }
        Preconditions.checkNotNull(this.am);
        if (this.f5139i == null) {
            this.f5139i = new NearbyPlacesIntentListAdapter(getContext(), this.f5136f, this.am);
            this.f5139i.f5124e = new C07103(this);
        }
        if (this.f5138h != null) {
            this.f5138h.setAdapter(this.f5139i);
        }
        LogUtils.f(-1313832393, a);
    }

    public final void m4634G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 67307153);
        super.G();
        this.f5139i.f5123d = this.f5134d;
        this.f5139i.f5125f = this.f5135e;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 98516275, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1722303506);
        this.f5132a.m4615a();
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1176957937, a);
    }

    public final View m4635a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1798121922);
        this.f5137g = (ViewGroup) layoutInflater.inflate(2130905394, viewGroup, false);
        this.f5138h = (BetterListView) this.f5137g.findViewById(2131564119);
        View view = this.f5137g;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 750664399, a);
        return view;
    }

    public final void m4639e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("intent_model_state", this.f5136f);
    }

    public final void m4638e() {
        Preconditions.checkNotNull(this.f5139i);
        if (this.am.c().c != null) {
            Object obj;
            if (this.f5136f == null || this.f5136f.f5151a.isEmpty()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                this.f5132a.m4615a();
                Location location = this.am.c().c;
                Preconditions.checkNotNull(location);
                NearbyPlacesHereCardRunner nearbyPlacesHereCardRunner = this.f5132a;
                C07114 c07114 = new C07114(this);
                nearbyPlacesHereCardRunner.m4615a();
                CheckinSearchQueryInputCheckinSearchQuery checkinSearchQueryInputCheckinSearchQuery = new CheckinSearchQueryInputCheckinSearchQuery();
                checkinSearchQueryInputCheckinSearchQuery.a("");
                if (location != null) {
                    ViewerCoordinates viewerCoordinates = new ViewerCoordinates();
                    viewerCoordinates.a(Double.valueOf(location.getLatitude()));
                    viewerCoordinates.b(Double.valueOf(location.getLongitude()));
                    viewerCoordinates.c(Double.valueOf((double) location.getAccuracy()));
                    if (location.hasSpeed()) {
                        viewerCoordinates.d(Double.valueOf((double) location.getSpeed()));
                    }
                    checkinSearchQueryInputCheckinSearchQuery.a(viewerCoordinates);
                }
                GraphQlQueryString fBNearbyPlacesHereCardHugeResultCellQueryString = new FBNearbyPlacesHereCardHugeResultCellQueryString();
                fBNearbyPlacesHereCardHugeResultCellQueryString.a("query_data", checkinSearchQueryInputCheckinSearchQuery);
                fBNearbyPlacesHereCardHugeResultCellQueryString.a("suggestion_context", "nearby_places");
                fBNearbyPlacesHereCardHugeResultCellQueryString.a("scale", GraphQlQueryDefaults.a());
                fBNearbyPlacesHereCardHugeResultCellQueryString.a("friends_who_visited_count", Integer.valueOf(3));
                fBNearbyPlacesHereCardHugeResultCellQueryString.a("friendRecommendationsCount", Integer.valueOf(1));
                nearbyPlacesHereCardRunner.f5113b.a(GraphQLQueryExecutor.a(nearbyPlacesHereCardRunner.f5112a.a(GraphQLRequest.a(fBNearbyPlacesHereCardHugeResultCellQueryString))), new C07031(nearbyPlacesHereCardRunner, c07114));
            }
        }
        AdapterDetour.a(this.f5139i, 1812033036);
    }

    public static void m4633g(NearbyPlacesV2IntentFragment nearbyPlacesV2IntentFragment, int i) {
        Preconditions.checkArgument(i >= 0);
        NearbyPlacesPlaceModel nearbyPlacesPlaceModel = (NearbyPlacesPlaceModel) nearbyPlacesV2IntentFragment.f5139i.getItem(i);
        if (nearbyPlacesPlaceModel != null) {
            nearbyPlacesV2IntentFragment.f5133b.a(nearbyPlacesV2IntentFragment.getContext(), nearbyPlacesPlaceModel, null, nearbyPlacesV2IntentFragment.an, nearbyPlacesV2IntentFragment, f5131c);
        }
    }

    public final String am_() {
        return "nearby_places_intent";
    }
}
