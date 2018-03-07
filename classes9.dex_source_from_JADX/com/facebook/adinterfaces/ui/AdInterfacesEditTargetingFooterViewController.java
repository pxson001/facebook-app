package com.facebook.adinterfaces.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ErrorDialogEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.TargetingChangedSubscriber;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.model.AdInterfacesTargetingData;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.InterestModel;
import com.facebook.adinterfaces.protocol.EditTargetingMutation.FBPagePostBoostEditTargetingString;
import com.facebook.adinterfaces.protocol.EditTargetingMutationModels.FBPagePostBoostEditTargetingModel;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.graphql.calls.BoostInfoEditTargetingInputData;
import com.facebook.graphql.calls.BoostInfoEditTargetingInputData.AudienceOption;
import com.facebook.graphql.calls.BoostInfoEditTargetingInputData.CustomTargeting;
import com.facebook.graphql.calls.BoostInfoEditTargetingInputData.CustomTargeting.Genders;
import com.facebook.graphql.calls.BoostInfoEditTargetingInputData.CustomTargeting.GeoLocations;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.enums.GraphQLAdGeoLocationType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;

/* compiled from: V2_SECTION_HEADER */
public class AdInterfacesEditTargetingFooterViewController extends AdInterfacesFooterViewController<AdInterfacesBoostPostDataModel> {
    public final DefaultAndroidThreadUtil f22698a;
    public GraphQLQueryExecutor f22699b;
    public final QuickPerformanceLogger f22700c;
    public AdInterfacesErrorReporter f22701d;
    private BoostedComponentLogger f22702e;
    private AdInterfacesBoostPostDataModel f22703f;

    /* compiled from: V2_SECTION_HEADER */
    class C26161 extends TargetingChangedSubscriber {
        final /* synthetic */ AdInterfacesEditTargetingFooterViewController f22693a;

        C26161(AdInterfacesEditTargetingFooterViewController adInterfacesEditTargetingFooterViewController) {
            this.f22693a = adInterfacesEditTargetingFooterViewController;
        }

        public final void m24618b(FbEvent fbEvent) {
            this.f22693a.f22590c.setCreateAdButtonEnabled(true);
        }
    }

    /* compiled from: V2_SECTION_HEADER */
    class C26182 implements OnClickListener {
        final /* synthetic */ AdInterfacesEditTargetingFooterViewController f22696a;

        C26182(AdInterfacesEditTargetingFooterViewController adInterfacesEditTargetingFooterViewController) {
            this.f22696a = adInterfacesEditTargetingFooterViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1938122988);
            this.f22696a.f22700c.b(5898249);
            this.f22696a.f22700c.a(5898249, this.f22696a.f22589b.mo962b().name());
            final DialogBasedProgressIndicator dialogBasedProgressIndicator = new DialogBasedProgressIndicator(view.getContext(), this.f22696a.f22590c.getContext().getString(2131233953));
            dialogBasedProgressIndicator.a();
            this.f22696a.f22698a.a(this.f22696a.f22699b.a(GraphQLRequest.a((FBPagePostBoostEditTargetingString) new FBPagePostBoostEditTargetingString().a("input", AdInterfacesEditTargetingFooterViewController.m24620m(this.f22696a)))), new FutureCallback<GraphQLResult<FBPagePostBoostEditTargetingModel>>(this) {
                final /* synthetic */ C26182 f22695b;

                public void onSuccess(Object obj) {
                    this.f22695b.f22696a.f22700c.b(5898249, (short) 2);
                    dialogBasedProgressIndicator.b();
                    FbFragmentActivity fbFragmentActivity = (FbFragmentActivity) this.f22695b.f22696a.f22590c.getContext();
                    fbFragmentActivity.setResult(-1);
                    fbFragmentActivity.finish();
                }

                public void onFailure(Throwable th) {
                    dialogBasedProgressIndicator.b();
                    this.f22695b.f22696a.f22701d.m22727a(AdInterfacesEditTargetingFooterViewController.class, "Edit Targeting Failed", th);
                    this.f22695b.f22696a.f22700c.b(5898249, (short) 3);
                    this.f22695b.f22696a.f22440b.m22429a(new ErrorDialogEvent());
                }
            });
            Logger.a(2, EntryType.UI_INPUT_END, -1243609883, a);
        }
    }

    /* compiled from: V2_SECTION_HEADER */
    /* synthetic */ class C26193 {
        static final /* synthetic */ int[] f22697a = new int[GraphQLAdGeoLocationType.values().length];

        static {
            try {
                f22697a[GraphQLAdGeoLocationType.CITY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22697a[GraphQLAdGeoLocationType.REGION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22697a[GraphQLAdGeoLocationType.COUNTRY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        baseAdInterfacesData = (AdInterfacesBoostPostDataModel) baseAdInterfacesData;
        super.mo983a(baseAdInterfacesData);
        this.f22703f = baseAdInterfacesData;
    }

    @Inject
    public AdInterfacesEditTargetingFooterViewController(AdInterfacesLegalUtil adInterfacesLegalUtil, DefaultAndroidThreadUtil defaultAndroidThreadUtil, GraphQLQueryExecutor graphQLQueryExecutor, QuickPerformanceLogger quickPerformanceLogger, AdInterfacesErrorReporter adInterfacesErrorReporter, BoostedComponentLogger boostedComponentLogger) {
        super(adInterfacesLegalUtil);
        this.f22698a = defaultAndroidThreadUtil;
        this.f22699b = graphQLQueryExecutor;
        this.f22700c = quickPerformanceLogger;
        this.f22701d = adInterfacesErrorReporter;
        this.f22702e = boostedComponentLogger;
    }

    public final void mo1005a(AdInterfacesFooterView adInterfacesFooterView, AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo1005a(adInterfacesFooterView, adInterfacesCardLayout);
        this.f22440b.m22430a(new C26161(this));
        this.f22590c.setCreateAdButtonEnabled(false);
    }

    protected final OnClickListener mo996b() {
        return new C26182(this);
    }

    public static BoostInfoEditTargetingInputData m24620m(AdInterfacesEditTargetingFooterViewController adInterfacesEditTargetingFooterViewController) {
        CustomTargeting customTargeting;
        String str = adInterfacesEditTargetingFooterViewController.f22589b.f21754j.f21729i;
        Enum valueOf = str != null ? AudienceOption.CUSTOM_AUDIENCE : AudienceOption.valueOf(adInterfacesEditTargetingFooterViewController.f22589b.f21754j.f21728h.toString());
        BoostInfoEditTargetingInputData boostInfoEditTargetingInputData = new BoostInfoEditTargetingInputData();
        boostInfoEditTargetingInputData.a("boost_info_id", adInterfacesEditTargetingFooterViewController.f22703f.f21780a.m23713l().m23674q());
        GraphQlCallInput graphQlCallInput = boostInfoEditTargetingInputData;
        graphQlCallInput.a("audience_option", valueOf);
        graphQlCallInput = graphQlCallInput;
        if (str != null) {
            graphQlCallInput.a("audience_id", str);
        }
        int i = 0;
        CustomTargeting customTargeting2 = new CustomTargeting();
        if (adInterfacesEditTargetingFooterViewController.f22589b.f21754j.f21729i != null) {
            customTargeting = customTargeting2;
        } else {
            AdInterfacesTargetingData adInterfacesTargetingData = adInterfacesEditTargetingFooterViewController.f22589b.f21754j;
            if (valueOf.equals(AudienceOption.NCPP)) {
                List asList;
                if (adInterfacesTargetingData.f21721a.toString().equals("ALL")) {
                    asList = Arrays.asList(new Genders[]{Genders.FEMALE, Genders.MALE});
                } else {
                    asList = Arrays.asList(new Genders[]{Genders.valueOf(adInterfacesTargetingData.f21721a.toString())});
                }
                customTargeting2.a("genders", asList);
                customTargeting2.a("age_max", Integer.valueOf(adInterfacesTargetingData.f21723c));
                customTargeting2.a("age_min", Integer.valueOf(adInterfacesTargetingData.f21722b));
                List arrayList = new ArrayList();
                ImmutableList immutableList = adInterfacesTargetingData.f21726f;
                int size = immutableList.size();
                while (i < size) {
                    arrayList.add(((InterestModel) immutableList.get(i)).m23463j());
                    i++;
                }
                customTargeting2.a("interest_ids", arrayList);
            }
            customTargeting2.a("geo_locations", m24619a(adInterfacesTargetingData.f21725e));
            customTargeting = customTargeting2;
        }
        graphQlCallInput.a("custom_targeting", customTargeting);
        graphQlCallInput.a("flow_id", adInterfacesEditTargetingFooterViewController.f22702e.f21686e);
        return graphQlCallInput;
    }

    protected final void mo999d() {
        this.f22590c.setCreateAdButtonText(this.f22590c.getContext().getString(2131233952));
    }

    public static GeoLocations m24619a(ImmutableList<GeoLocationModel> immutableList) {
        GeoLocations geoLocations = new GeoLocations();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        for (int i = 0; i < immutableList.size(); i++) {
            switch (C26193.f22697a[((GeoLocationModel) immutableList.get(i)).mM_().ordinal()]) {
                case 1:
                    arrayList3.add(((GeoLocationModel) immutableList.get(i)).mL_());
                    break;
                case 2:
                    arrayList2.add(((GeoLocationModel) immutableList.get(i)).mL_());
                    break;
                case 3:
                    arrayList.add(((GeoLocationModel) immutableList.get(i)).m23439b());
                    break;
                default:
                    break;
            }
        }
        geoLocations.a("countries", arrayList);
        GraphQlCallInput graphQlCallInput = geoLocations;
        graphQlCallInput.a("region_keys", arrayList2);
        graphQlCallInput.a("city_keys", arrayList3);
        return geoLocations;
    }

    protected final void mo1003h() {
        this.f22590c.setCreateAdButtonVisibility(0);
        this.f22590c.setAddBudgetButtonVisibility(8);
        this.f22590c.setResumeAdButtonVisibility(8);
        this.f22590c.setPauseAdButtonVisibility(8);
        this.f22590c.setDeleteAdButtonVisibility(8);
    }
}
