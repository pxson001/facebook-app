package com.facebook.checkin.socialsearch.conversion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.checkin.socialsearch.conversion.SocialSearchConversionAcceptFragment.Listener;
import com.facebook.checkin.socialsearch.conversion.StoryConversionInfoFetcher.C21011;
import com.facebook.checkin.socialsearch.graphql.PlaceListMutations.ConvertToPlaceListStoryMutationCallString;
import com.facebook.checkin.socialsearch.graphql.PlaceListMutationsModels.ConvertToPlaceListStoryMutationCallModel;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQL.FetchStoryConversionInfoString;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLModels.StoryConversionDetailsModel;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLModels.StoryConversionDetailsModel.PlaceRecommendationInfoModel.PlaceEntitiesModel;
import com.facebook.checkin.socialsearch.utils.ConvertToPlaceListMutator;
import com.facebook.checkin.socialsearch.utils.ConvertToPlaceListMutator.1;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.PlacelistStoryConvertInputData;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.feed.PermalinkStoryIdParams.Builder;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.checkin.ipc.CheckinIntentCreator;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.checkin.launcher.PlacePickerLauncher;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: description_text_color */
public class SocialSearchConversionActivity extends FbFragmentActivity implements Listener, SocialSearchConversionLocationSelectorFragment.Listener {
    public static final String f15085v = SocialSearchConversionActivity.class.getSimpleName();
    @Inject
    StoryConversionInfoFetcher f15086p;
    @Inject
    ConvertToPlaceListMutator f15087q;
    @Inject
    PlacePickerLauncher f15088r;
    @Inject
    ViewPermalinkIntentFactory f15089s;
    @Inject
    SecureContextHelper f15090t;
    @Inject
    AbstractFbErrorReporter f15091u;
    public String f15092w;
    public String f15093x;
    public String f15094y;
    public boolean f15095z;

    /* compiled from: description_text_color */
    class C20961 implements FutureCallback<GraphQLResult<ConvertToPlaceListStoryMutationCallModel>> {
        final /* synthetic */ SocialSearchConversionActivity f15082a;

        C20961(SocialSearchConversionActivity socialSearchConversionActivity) {
            this.f15082a = socialSearchConversionActivity;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f15082a.f15095z = false;
            if (graphQLResult == null || graphQLResult.e == null || ((ConvertToPlaceListStoryMutationCallModel) graphQLResult.e).a() == null) {
                this.f15082a.f15091u.a(SocialSearchConversionActivity.f15085v, "Error converting post");
                return;
            }
            Builder builder = new Builder();
            builder.a = this.f15082a.f15092w;
            this.f15082a.f15090t.a(this.f15082a.f15089s.a(builder.a()), this.f15082a);
            this.f15082a.finish();
        }

        public void onFailure(Throwable th) {
            this.f15082a.f15095z = false;
        }
    }

    /* compiled from: description_text_color */
    class C20972 implements OnClickListener {
        final /* synthetic */ SocialSearchConversionActivity f15083a;

        C20972(SocialSearchConversionActivity socialSearchConversionActivity) {
            this.f15083a = socialSearchConversionActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -625504085);
            this.f15083a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 2026099424, a);
        }
    }

    /* compiled from: description_text_color */
    class C20983 implements FutureCallback<GraphQLResult<StoryConversionDetailsModel>> {
        final /* synthetic */ SocialSearchConversionActivity f15084a;

        C20983(SocialSearchConversionActivity socialSearchConversionActivity) {
            this.f15084a = socialSearchConversionActivity;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((StoryConversionDetailsModel) graphQLResult.e).a() == null || ((StoryConversionDetailsModel) graphQLResult.e).a().a().isEmpty()) {
                this.f15084a.f15091u.a(SocialSearchConversionActivity.f15085v, "Unable to retrieve valid StoryConversionInfo");
                return;
            }
            PlaceEntitiesModel placeEntitiesModel = (PlaceEntitiesModel) ((StoryConversionDetailsModel) graphQLResult.e).a().a().get(0);
            this.f15084a.f15093x = placeEntitiesModel.j();
            this.f15084a.f15094y = placeEntitiesModel.k();
        }

        public void onFailure(Throwable th) {
        }
    }

    private static <T extends Context> void m15608a(Class<T> cls, T t) {
        m15609a((Object) t, (Context) t);
    }

    public static void m15609a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SocialSearchConversionActivity) obj).m15607a(new StoryConversionInfoFetcher(GraphQLQueryExecutor.a(fbInjector), TasksManager.b(fbInjector)), new ConvertToPlaceListMutator(GraphQLQueryExecutor.a(fbInjector), TasksManager.b(fbInjector)), PlacePickerLauncher.b(fbInjector), ViewPermalinkIntentFactory.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector));
    }

    private void m15614l() {
        Fragment socialSearchConversionAcceptFragment = new SocialSearchConversionAcceptFragment();
        FragmentTransaction a = kO_().a();
        a.b(2131567516, socialSearchConversionAcceptFragment);
        a.b();
    }

    private void m15607a(StoryConversionInfoFetcher storyConversionInfoFetcher, ConvertToPlaceListMutator convertToPlaceListMutator, PlacePickerLauncher placePickerLauncher, ViewPermalinkIntentFactory viewPermalinkIntentFactory, SecureContextHelper secureContextHelper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f15086p = storyConversionInfoFetcher;
        this.f15087q = convertToPlaceListMutator;
        this.f15088r = placePickerLauncher;
        this.f15089s = viewPermalinkIntentFactory;
        this.f15090t = secureContextHelper;
        this.f15091u = abstractFbErrorReporter;
    }

    protected final void m15619b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = SocialSearchConversionActivity.class;
        m15609a((Object) this, (Context) this);
        setContentView(2130907157);
        this.f15092w = getIntent().getStringExtra("post_id");
        m15615m();
        if (bundle == null) {
            m15614l();
        } else {
            this.f15093x = bundle.getString("place_id_state");
            this.f15094y = bundle.getString("place_name_state");
            this.f15095z = bundle.getBoolean("converting_post_state");
            if (this.f15095z) {
                mo754i();
            }
        }
        if (this.f15093x == null) {
            m15616n();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 5002:
                    m15612b(intent);
                    return;
                default:
                    return;
            }
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("place_id_state", this.f15093x);
        bundle.putString("place_name_state", this.f15094y);
        bundle.putBoolean("converting_post_state", this.f15095z);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1143218758);
        super.onDestroy();
        this.f15086p.f15107b.c();
        this.f15087q.b.c();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1161120174, a);
    }

    public final void mo752a() {
        String str = this.f15094y;
        Bundle bundle = new Bundle();
        bundle.putString("place_name", str);
        SocialSearchConversionLocationSelectorFragment socialSearchConversionLocationSelectorFragment = new SocialSearchConversionLocationSelectorFragment();
        socialSearchConversionLocationSelectorFragment.g(bundle);
        Fragment fragment = socialSearchConversionLocationSelectorFragment;
        FragmentTransaction a = kO_().a();
        a.a(null);
        a.b(2131567516, fragment, "location_selector");
        a.b();
    }

    public final void mo753b() {
        onBackPressed();
    }

    public final void mo754i() {
        if (this.f15093x == null) {
            new AlertDialog.Builder(this).b("[FB Only] Please select a city using the \"EDIT CITY\" button").b();
            return;
        }
        this.f15095z = true;
        ConvertToPlaceListMutator convertToPlaceListMutator = this.f15087q;
        String str = this.f15092w;
        String str2 = this.f15093x;
        C20961 c20961 = new C20961(this);
        List arrayList = new ArrayList();
        arrayList.add("0");
        PlacelistStoryConvertInputData placelistStoryConvertInputData = new PlacelistStoryConvertInputData();
        placelistStoryConvertInputData.a("story_id", str);
        GraphQlCallInput graphQlCallInput = placelistStoryConvertInputData;
        graphQlCallInput.a("location_id", str2);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("place_category_ids", arrayList);
        GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
        GraphQlQueryString convertToPlaceListStoryMutationCallString = new ConvertToPlaceListStoryMutationCallString();
        convertToPlaceListStoryMutationCallString.a("input", graphQlCallInput2);
        convertToPlaceListMutator.b.a("convert_to_place_list", convertToPlaceListMutator.a.a(GraphQLRequest.a(convertToPlaceListStoryMutationCallString)), new 1(convertToPlaceListMutator, c20961));
    }

    public final void mo755j() {
        PlacePickerLauncher placePickerLauncher = this.f15088r;
        String str = this.f15092w;
        PlacePickerConfiguration.Builder a = PlacePickerLauncher.a(SearchType.SOCIAL_SEARCH_CONVERSION, "convert_to_social_search_post", null);
        a.u = str;
        ((SecureContextHelper) placePickerLauncher.a.get()).a(CheckinIntentCreator.a(this, a.a()), 5002, this);
    }

    private void m15615m() {
        Fb4aTitleBar fb4aTitleBar = (Fb4aTitleBar) a(2131567515);
        fb4aTitleBar.a(new C20972(this));
        fb4aTitleBar.setSearchButtonVisible(true);
    }

    private void m15616n() {
        StoryConversionInfoFetcher storyConversionInfoFetcher = this.f15086p;
        String str = this.f15092w;
        C20983 c20983 = new C20983(this);
        FetchStoryConversionInfoString fetchStoryConversionInfoString = new FetchStoryConversionInfoString();
        fetchStoryConversionInfoString.a("story_id", str);
        storyConversionInfoFetcher.f15107b.a("fetch_story_info_", storyConversionInfoFetcher.f15106a.a(GraphQLRequest.a(fetchStoryConversionInfoString).a(GraphQLCachePolicy.c)), new C21011(storyConversionInfoFetcher, c20983));
    }

    private void m15612b(Intent intent) {
        CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) FlatBufferModelHelper.a(intent, "extra_place");
        this.f15093x = checkinPlaceModel.cf_();
        this.f15094y = checkinPlaceModel.j();
        SocialSearchConversionLocationSelectorFragment socialSearchConversionLocationSelectorFragment = (SocialSearchConversionLocationSelectorFragment) kO_().a("location_selector");
        if (socialSearchConversionLocationSelectorFragment != null) {
            socialSearchConversionLocationSelectorFragment.f15099b = this.f15094y;
            socialSearchConversionLocationSelectorFragment.f15102e.setText(Html.fromHtml(socialSearchConversionLocationSelectorFragment.getContext().getString(2131241851, new Object[]{socialSearchConversionLocationSelectorFragment.f15099b})));
        }
    }
}
