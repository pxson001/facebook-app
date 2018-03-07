package com.facebook.timeline.editfeaturedcontainers.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.calls.ExactMatchInputExactMatch;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.pandora.common.events.PandoraEvents.LaunchConsumptionGalleryEvent;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.fragment.GraphSearchChildFragment.OnResultClickListener;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit.Builder;
import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import com.facebook.search.model.NearbyTypeaheadUnit;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.model.PlaceTipsTypeaheadUnit;
import com.facebook.search.model.SeeMoreResultPageUnit;
import com.facebook.search.model.ShortcutTypeaheadUnit;
import com.facebook.search.model.TrendingTypeaheadUnit;
import com.facebook.search.results.environment.tabs.SearchResultsTab;
import com.facebook.search.results.fragment.tabs.SearchResultsTabsFragment;
import com.facebook.timeline.editfeaturedcontainers.ui.views.FeaturedContainersSearchEditText;
import com.facebook.timeline.editfeaturedcontainers.utils.StagingGroundIntentCreator;
import com.facebook.ui.search.SearchEditText.OnSubmitListener;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: geofence_requested_success */
public class AddFeaturedEntityActivity extends FbFragmentActivity {
    private static final ArrayList<SearchResultsTab> f10925q;
    @Inject
    public Provider<SecureContextHelper> f10926p;
    private SearchResultsTabsFragment f10927r;
    public String f10928s;
    public String f10929t;

    /* compiled from: geofence_requested_success */
    class C15842 implements OnResultClickListener {
        final /* synthetic */ AddFeaturedEntityActivity f10923a;

        C15842(AddFeaturedEntityActivity addFeaturedEntityActivity) {
            this.f10923a = addFeaturedEntityActivity;
        }

        public final void m11040a(GraphSearchQuery graphSearchQuery, EntityTypeaheadUnit entityTypeaheadUnit) {
        }

        public final void m11045a(SeeMoreResultPageUnit seeMoreResultPageUnit) {
        }

        public final void m11047a(TrendingTypeaheadUnit trendingTypeaheadUnit) {
        }

        public final void m11042a(KeywordTypeaheadUnit keywordTypeaheadUnit) {
        }

        public final void m11041a(GraphSearchQuery graphSearchQuery, NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit) {
        }

        public final void m11039a() {
        }

        public final void m11046a(ShortcutTypeaheadUnit shortcutTypeaheadUnit) {
        }

        public final void m11044a(PlaceTipsTypeaheadUnit placeTipsTypeaheadUnit) {
        }

        public final void m11043a(NearbyTypeaheadUnit nearbyTypeaheadUnit) {
        }

        public final boolean m11048a(LaunchConsumptionGalleryEvent launchConsumptionGalleryEvent) {
            this.f10923a.f10929t = launchConsumptionGalleryEvent.a;
            ((SecureContextHelper) this.f10923a.f10926p.get()).a(StagingGroundIntentCreator.m11093a(this.f10923a, false, launchConsumptionGalleryEvent.b, launchConsumptionGalleryEvent.a), 1, this.f10923a);
            return true;
        }
    }

    /* compiled from: geofence_requested_success */
    class C15853 implements OnClickListener {
        final /* synthetic */ AddFeaturedEntityActivity f10924a;

        C15853(AddFeaturedEntityActivity addFeaturedEntityActivity) {
            this.f10924a = addFeaturedEntityActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1840470544);
            this.f10924a.setResult(0);
            this.f10924a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, 414039180, a);
        }
    }

    private static <T extends Context> void m11052a(Class<T> cls, T t) {
        m11053a((Object) t, (Context) t);
    }

    public static void m11053a(Object obj, Context context) {
        ((AddFeaturedEntityActivity) obj).f10926p = IdBasedSingletonScopeProvider.a(FbInjector.get(context), 968);
    }

    static {
        ArrayList arrayList = new ArrayList();
        f10925q = arrayList;
        arrayList.add(SearchResultsTab.PHOTOS);
    }

    private void m11054a(Provider<SecureContextHelper> provider) {
        this.f10926p = provider;
    }

    public static Intent m11049a(Context context, String str) {
        Intent intent = new Intent(context, AddFeaturedEntityActivity.class);
        intent.putExtra("query_string_extra", str);
        return intent;
    }

    protected final void m11061b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = AddFeaturedEntityActivity.class;
        m11053a((Object) this, (Context) this);
        setContentView(2130903161);
        m11060m();
        if (bundle == null) {
            this.f10927r = m11057j();
            kO_().a().a(2131558429, this.f10927r).b();
            this.f10928s = getIntent().getStringExtra("query_string_extra");
        } else {
            this.f10927r = (SearchResultsTabsFragment) kO_().a(2131558429);
            this.f10928s = bundle.getString("query_string_save_state_key");
            if (bundle.containsKey("picked_entity_photo_fb_id")) {
                this.f10929t = bundle.getString("picked_entity_photo_fb_id");
            }
        }
        m11056i();
        m11058k(this);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1:
                    setResult(-1, intent.putExtra("picked_photo_fbid", this.f10929t));
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    private void m11056i() {
        final FeaturedContainersSearchEditText featuredContainersSearchEditText = (FeaturedContainersSearchEditText) findViewById(2131559364);
        featuredContainersSearchEditText.setText(this.f10928s);
        featuredContainersSearchEditText.f = new OnSubmitListener(this) {
            final /* synthetic */ AddFeaturedEntityActivity f10922b;

            public final void m11038a() {
                Object obj = featuredContainersSearchEditText.getText().toString();
                if (!StringUtil.c(obj)) {
                    this.f10922b.f10928s = obj;
                    AddFeaturedEntityActivity.m11058k(this.f10922b);
                }
            }
        };
    }

    private static SearchResultsTabsFragment m11057j() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("tabs_override", f10925q);
        SearchResultsTabsFragment searchResultsTabsFragment = new SearchResultsTabsFragment();
        searchResultsTabsFragment.g(bundle);
        return searchResultsTabsFragment;
    }

    public static void m11058k(AddFeaturedEntityActivity addFeaturedEntityActivity) {
        Builder builder = new Builder();
        builder.f = ExactMatchInputExactMatch.FALSE;
        builder = builder;
        builder.v = ImmutableList.of(GraphQLGraphSearchResultsDisplayStyle.BLENDED);
        builder = builder;
        builder.g = KeywordType.escape;
        builder = builder;
        builder.c = SearchQueryFunctions.o(addFeaturedEntityActivity.f10928s);
        builder = builder;
        builder.d = addFeaturedEntityActivity.f10928s;
        builder = builder;
        builder.b = addFeaturedEntityActivity.f10928s;
        builder = builder;
        builder.e = "content";
        addFeaturedEntityActivity.f10927r.a(builder.b(), SearchTypeaheadSession.a, SearchResultsSource.G);
        addFeaturedEntityActivity.f10927r.a(addFeaturedEntityActivity.m11059l());
    }

    private OnResultClickListener m11059l() {
        return new C15842(this);
    }

    private void m11060m() {
        FbTitleBarUtil.b(this);
        ((FbTitleBar) a(2131558563)).a(new C15853(this));
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("query_string_save_state_key", this.f10928s);
        if (this.f10929t != null) {
            bundle.putString("picked_entity_photo_fb_id", this.f10929t);
        }
    }
}
