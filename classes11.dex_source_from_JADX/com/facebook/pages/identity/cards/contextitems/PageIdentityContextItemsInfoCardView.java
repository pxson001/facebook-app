package com.facebook.pages.identity.cards.contextitems;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.entitycards.contextitems.analytics.ContextItemsAnalyticsLogger;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryInterfaces.ContextItemsConnectionFragment;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemFieldsModel;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemsConnectionFragmentModel.EdgesModel;
import com.facebook.entitycards.contextitems.surface.ContextItemSurfaces;
import com.facebook.entitycards.contextitems.ui.ContextItemsAdapter.EntityData;
import com.facebook.entitycards.contextitems.ui.ContextItemsViewBinder;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.graphql.enums.GraphQLEntityCardContextItemType;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.FbStaticMapView;
import com.facebook.pages.common.intent_builder.DefaultPageSurfaceIntentBuilder;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.logging.analytics.TapEvent;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageSecondaryCardView;
import com.facebook.pages.common.ui.widgets.ExpandableTextView;
import com.facebook.pages.common.ui.widgets.ExpandableTextView.OnExpandCollapseListener;
import com.facebook.pages.data.graphql.cards.PageContextItemInfoCardGraphQLModels.PageInfoCardContextItemQueryModel;
import com.facebook.pages.data.graphql.cards.PageContextItemInfoCardGraphQLModels.PageInfoCardContextItemQueryModel.MapBoundingBoxModel;
import com.facebook.pages.identity.cards.maps.PageIdentityMapUtil;
import com.facebook.pages.identity.contextitems.PageContextItemsClickHandlerImpl;
import com.facebook.pages.identity.contextitems.handler.PageContextItemHandlingData;
import com.facebook.pages.identity.contextitems.handler.PageContextItemsClickHandler;
import com.facebook.pages.identity.intent.impl.FbAndroidPageSurfaceIntentBuilder;
import com.facebook.places.report.PlaceMapReporterLauncher;
import com.facebook.places.report.PlaceMapReporterLauncherProvider;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.facebook.uicontrib.contextitem.PlutoniumContextualItemView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: privacy_checkup_manager_empty_section_data */
public class PageIdentityContextItemsInfoCardView extends CustomFrameLayout implements PageSecondaryCardView {
    @Inject
    public LayoutInflater f3416a;
    @Inject
    public ContextItemsViewBinder f3417b;
    @Inject
    PageContextItemsClickHandler f3418c;
    @Inject
    DefaultPageSurfaceIntentBuilder f3419d;
    @Inject
    ContextItemsAnalyticsLogger f3420e;
    @Inject
    PagesAnalytics f3421f;
    @Inject
    public LinkifyUtil f3422g;
    @Inject
    PageIdentityMapUtil f3423h;
    @Inject
    PlaceMapReporterLauncherProvider f3424i;
    public SegmentedLinearLayout f3425j;
    public View f3426k;
    public PageContextItemHandlingData f3427l;
    private int f3428m;
    private RectF f3429n;
    private GraphQLPlaceType f3430o;
    private boolean f3431p;
    private PlaceMapReporterLauncher f3432q;
    private final StaticMapOptions f3433r = new StaticMapOptions("pages_single_location_map");

    /* compiled from: privacy_checkup_manager_empty_section_data */
    class C04621 implements OnClickListener {
        final /* synthetic */ PageIdentityContextItemsInfoCardView f3407a;

        C04621(PageIdentityContextItemsInfoCardView pageIdentityContextItemsInfoCardView) {
            this.f3407a = pageIdentityContextItemsInfoCardView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2118420424);
            this.f3407a.f3421f.a(TapEvent.EVENT_TAPPED_SEE_MORE_INFORMATION, this.f3407a.f3427l.a);
            this.f3407a.f3419d.a(this.f3407a.f3427l.a);
            Logger.a(2, EntryType.UI_INPUT_END, 438512185, a);
        }
    }

    /* compiled from: privacy_checkup_manager_empty_section_data */
    class C04632 implements OnClickListener {
        final /* synthetic */ PageIdentityContextItemsInfoCardView f3408a;

        C04632(PageIdentityContextItemsInfoCardView pageIdentityContextItemsInfoCardView) {
            this.f3408a = pageIdentityContextItemsInfoCardView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 782713582);
            this.f3408a.f3421f.a(TapEvent.EVENT_TAPPED_PLACES_MAP, this.f3408a.f3427l.a);
            this.f3408a.f3423h.m4564a(this.f3408a.f3427l);
            Logger.a(2, EntryType.UI_INPUT_END, -190137804, a);
        }
    }

    /* compiled from: privacy_checkup_manager_empty_section_data */
    /* synthetic */ class C04665 {
        static final /* synthetic */ int[] f3415a = new int[GraphQLEntityCardContextItemType.values().length];

        static {
            try {
                f3415a[GraphQLEntityCardContextItemType.LONG_DESC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public static void m4517a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PageIdentityContextItemsInfoCardView) obj).m4515a(LayoutInflaterMethodAutoProvider.b(injectorLike), ContextItemsViewBinder.b(injectorLike), (PageContextItemsClickHandler) PageContextItemsClickHandlerImpl.m4770b(injectorLike), (DefaultPageSurfaceIntentBuilder) FbAndroidPageSurfaceIntentBuilder.m5074b(injectorLike), ContextItemsAnalyticsLogger.a(injectorLike), PagesAnalytics.a(injectorLike), LinkifyUtil.a(injectorLike), PageIdentityMapUtil.m4562a(injectorLike), (PlaceMapReporterLauncherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PlaceMapReporterLauncherProvider.class));
    }

    public PageIdentityContextItemsInfoCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = PageIdentityContextItemsInfoCardView.class;
        m4517a((Object) this, getContext());
        setContentView(2130906020);
        this.f3425j = (SegmentedLinearLayout) c(2131565498);
        this.f3425j.setSegmentedDivider(new ColorDrawable(getResources().getColor(2131362969)));
        this.f3425j.setShowSegmentedDividers(2);
        this.f3425j.setSegmentedDividerThickness(1);
        this.f3426k = c(2131565499);
    }

    public final void m4519a(long j, @Nullable String str, PageInfoCardContextItemQueryModel pageInfoCardContextItemQueryModel) {
        boolean a;
        boolean z = false;
        this.f3428m = pageInfoCardContextItemQueryModel.n();
        MapBoundingBoxModel m = pageInfoCardContextItemQueryModel.m();
        if (m != null) {
            this.f3429n = new RectF((float) m.l(), (float) m.j(), (float) m.a(), (float) m.k());
        }
        this.f3430o = pageInfoCardContextItemQueryModel.p();
        if (pageInfoCardContextItemQueryModel.o() != null) {
            a = pageInfoCardContextItemQueryModel.o().a();
            z = pageInfoCardContextItemQueryModel.o().j();
        } else {
            a = false;
        }
        this.f3432q = this.f3424i.a(Long.valueOf(j), str, null);
        this.f3427l = new PageContextItemHandlingData(j, str, null, pageInfoCardContextItemQueryModel.l(), pageInfoCardContextItemQueryModel.a(), null, a, z);
        this.f3426k.setOnClickListener(new C04621(this));
        this.f3431p = pageInfoCardContextItemQueryModel.k();
        m4516a(pageInfoCardContextItemQueryModel.j());
    }

    private void m4515a(LayoutInflater layoutInflater, ContextItemsViewBinder contextItemsViewBinder, PageContextItemsClickHandler pageContextItemsClickHandler, DefaultPageSurfaceIntentBuilder defaultPageSurfaceIntentBuilder, ContextItemsAnalyticsLogger contextItemsAnalyticsLogger, PagesAnalytics pagesAnalytics, LinkifyUtil linkifyUtil, PageIdentityMapUtil pageIdentityMapUtil, PlaceMapReporterLauncherProvider placeMapReporterLauncherProvider) {
        this.f3416a = layoutInflater;
        this.f3417b = contextItemsViewBinder;
        this.f3418c = pageContextItemsClickHandler;
        this.f3419d = defaultPageSurfaceIntentBuilder;
        this.f3420e = contextItemsAnalyticsLogger;
        this.f3421f = pagesAnalytics;
        this.f3422g = linkifyUtil;
        this.f3423h = pageIdentityMapUtil;
        this.f3424i = placeMapReporterLauncherProvider;
    }

    private void m4516a(ContextItemsConnectionFragment contextItemsConnectionFragment) {
        if (this.f3425j.getChildCount() > 1) {
            this.f3425j.removeViews(1, this.f3425j.getChildCount() - 1);
        }
        if (contextItemsConnectionFragment.a() != null) {
            ImmutableList a = contextItemsConnectionFragment.a();
            int size = a.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ContextItemFieldsModel a2 = ((EdgesModel) a.get(i2)).a();
                if (a2 != null) {
                    if (!(a2.d() != GraphQLEntityCardContextItemType.DISTANCE_FROM_USER || this.f3431p || this.f3427l.g == null)) {
                        this.f3425j.addView(getMapView(), -1, this.f3425j.getResources().getDimensionPixelSize(2131429793));
                    }
                    this.f3425j.addView(m4514a(a2, i));
                    this.f3420e.b(ContextItemSurfaces.PAGE_INFO_CARD, a2.d().name(), String.valueOf(this.f3427l.a), i, Optional.fromNullable(a2.bA_()));
                    i++;
                }
            }
        }
    }

    private View m4514a(final ContextItemFieldsModel contextItemFieldsModel, final int i) {
        switch (C04665.f3415a[contextItemFieldsModel.d().ordinal()]) {
            case 1:
                CustomLinearLayout customLinearLayout = (CustomLinearLayout) this.f3416a.inflate(2130906018, this.f3425j, false);
                ExpandableTextView expandableTextView = (ExpandableTextView) customLinearLayout.findViewById(2131565495);
                expandableTextView.m3660a();
                expandableTextView.setText(this.f3422g.a(LinkifyUtilConverter.c(DefaultGraphQLConversionHelper.a(contextItemFieldsModel.bC_())), true, null));
                expandableTextView.f2731n = new OnExpandCollapseListener(this) {
                    final /* synthetic */ PageIdentityContextItemsInfoCardView f3414c;

                    public final void mo82a() {
                        PageIdentityContextItemsInfoCardView.m4518d(this.f3414c, contextItemFieldsModel, i);
                    }
                };
                return customLinearLayout;
            default:
                PlutoniumContextualItemView plutoniumContextualItemView = (PlutoniumContextualItemView) this.f3416a.inflate(2130903796, this.f3425j, false);
                this.f3417b.a(plutoniumContextualItemView, contextItemFieldsModel, new EntityData(String.valueOf(this.f3427l.a), null));
                plutoniumContextualItemView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ PageIdentityContextItemsInfoCardView f3411c;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 2082138643);
                        PageIdentityContextItemsInfoCardView.m4518d(this.f3411c, contextItemFieldsModel, i);
                        this.f3411c.f3418c.a(view, contextItemFieldsModel, this.f3411c.f3427l);
                        Logger.a(2, EntryType.UI_INPUT_END, 1390813158, a);
                    }
                });
                return plutoniumContextualItemView;
        }
    }

    private View getMapView() {
        FbStaticMapView fbStaticMapView = new FbStaticMapView(getContext());
        fbStaticMapView.a(ZeroFeatureKey.VIEW_MAP_INTERSTITIAL, ((FragmentActivity) getContext()).kO_(), null);
        fbStaticMapView.setOnClickListener(new C04632(this));
        fbStaticMapView.a(this.f3430o == GraphQLPlaceType.PLACE ? fbStaticMapView.getResources().getDrawable(2130841143) : null, 0.5f, 0.93f);
        fbStaticMapView.setMapOptions(this.f3429n != null ? this.f3433r.a().a(this.f3429n) : this.f3433r.a().a(this.f3428m).a(this.f3427l.g.a(), this.f3427l.g.b()));
        fbStaticMapView.setMapReporterLauncher(this.f3432q);
        return fbStaticMapView;
    }

    public static void m4518d(PageIdentityContextItemsInfoCardView pageIdentityContextItemsInfoCardView, ContextItemFieldsModel contextItemFieldsModel, int i) {
        pageIdentityContextItemsInfoCardView.f3420e.a(ContextItemSurfaces.PAGE_INFO_CARD, contextItemFieldsModel.d().name(), String.valueOf(pageIdentityContextItemsInfoCardView.f3427l.a), i, Optional.fromNullable(contextItemFieldsModel.bA_()));
    }
}
