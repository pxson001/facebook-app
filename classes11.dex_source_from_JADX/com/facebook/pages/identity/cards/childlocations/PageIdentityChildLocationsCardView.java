package com.facebook.pages.identity.cards.childlocations;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.android.maps.model.LatLng;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.fbui.widget.text.BadgeTextView;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.inject.FbInjector;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.FbStaticMapView;
import com.facebook.pages.common.childlocations.PageChildLocationsRowView;
import com.facebook.pages.common.childlocations.PageChildLocationsRowViewController;
import com.facebook.pages.common.intent_builder.DefaultPageSurfaceIntentBuilder;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.logging.analytics.TapEvent;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageSecondaryCardView;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQLModels.ChildLocationConnectionFieldsModel.NodesModel;
import com.facebook.pages.identity.intent.impl.FbAndroidPageSurfaceIntentBuilder;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: privacy_checkup_review_step_close */
public class PageIdentityChildLocationsCardView extends CustomFrameLayout implements PageSecondaryCardView {
    @Inject
    public SecureContextHelper f3320a;
    @Inject
    public DefaultPageSurfaceIntentBuilder f3321b;
    @Inject
    public PagesAnalytics f3322c;
    @Inject
    public UriIntentMapper f3323d;
    private final SegmentedLinearLayout f3324e;
    public final BadgeTextView f3325f;
    public final StaticMapOptions f3326g = new StaticMapOptions("pages_multi_locations_map");
    public final int f3327h;
    public long f3328i;
    public ImmutableList<NodesModel> f3329j;
    private String f3330k;
    public FbStaticMapView f3331l;

    /* compiled from: privacy_checkup_review_step_close */
    public class C04461 implements OnClickListener {
        final /* synthetic */ PageIdentityChildLocationsCardView f3316a;

        public C04461(PageIdentityChildLocationsCardView pageIdentityChildLocationsCardView) {
            this.f3316a = pageIdentityChildLocationsCardView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1327679501);
            this.f3316a.f3322c.a(TapEvent.EVENT_TAPPED_ALL_NEARBY_LOCATIONS_MAP, this.f3316a.f3328i);
            PageIdentityChildLocationsCardView.m4455e(this.f3316a);
            Logger.a(2, EntryType.UI_INPUT_END, 1594958183, a);
        }
    }

    /* compiled from: privacy_checkup_review_step_close */
    public class C04484 implements OnClickListener {
        final /* synthetic */ PageIdentityChildLocationsCardView f3319a;

        public C04484(PageIdentityChildLocationsCardView pageIdentityChildLocationsCardView) {
            this.f3319a = pageIdentityChildLocationsCardView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -294519468);
            this.f3319a.f3322c.a(TapEvent.EVENT_TAPPED_ALL_NEARBY_LOCATIONS_LIST, this.f3319a.f3328i);
            PageIdentityChildLocationsCardView.m4455e(this.f3319a);
            Logger.a(2, EntryType.UI_INPUT_END, 1591371772, a);
        }
    }

    public static void m4453a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PageIdentityChildLocationsCardView pageIdentityChildLocationsCardView = (PageIdentityChildLocationsCardView) obj;
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        DefaultPageSurfaceIntentBuilder defaultPageSurfaceIntentBuilder = (DefaultPageSurfaceIntentBuilder) FbAndroidPageSurfaceIntentBuilder.m5074b(fbInjector);
        PagesAnalytics a = PagesAnalytics.a(fbInjector);
        UriIntentMapper uriIntentMapper = (UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector);
        pageIdentityChildLocationsCardView.f3320a = secureContextHelper;
        pageIdentityChildLocationsCardView.f3321b = defaultPageSurfaceIntentBuilder;
        pageIdentityChildLocationsCardView.f3322c = a;
        pageIdentityChildLocationsCardView.f3323d = uriIntentMapper;
    }

    public PageIdentityChildLocationsCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = PageIdentityChildLocationsCardView.class;
        m4453a(this, getContext());
        setContentView(2130906005);
        this.f3331l = (FbStaticMapView) c(2131565432);
        this.f3324e = (SegmentedLinearLayout) c(2131559225);
        this.f3325f = (BadgeTextView) c(2131565433);
        this.f3327h = getResources().getInteger(2131492913);
    }

    public final void m4456a(long j, String str, ImmutableList<NodesModel> immutableList) {
        this.f3328i = j;
        this.f3330k = str;
        this.f3329j = immutableList;
        m4452a();
    }

    private void m4452a() {
        ImmutableList subList = this.f3329j.size() > this.f3327h ? this.f3329j.subList(0, this.f3327h) : this.f3329j;
        List arrayList = new ArrayList();
        int size = subList.size();
        for (int i = 0; i < size; i++) {
            DefaultLocationFieldsModel l = ((NodesModel) subList.get(i)).l();
            if (l != null && Math.abs(l.a()) <= 90.0d && Math.abs(l.b()) <= 180.0d) {
                arrayList.add(new LatLng(l.a(), l.b()));
            }
        }
        if (arrayList.isEmpty()) {
            this.f3331l.setVisibility(8);
        } else {
            this.f3331l.setVisibility(0);
            this.f3331l.a(ZeroFeatureKey.VIEW_MAP_INTERSTITIAL, ((FragmentActivity) getContext()).kO_(), null);
            this.f3331l.setOnClickListener(new C04461(this));
            this.f3331l.setMapOptions(this.f3326g.a().a(arrayList, "red"));
        }
        m4454b(subList);
        if (this.f3329j.size() <= this.f3327h) {
            this.f3325f.setVisibility(8);
            return;
        }
        this.f3325f.setBadgeText(String.valueOf(this.f3329j.size()));
        this.f3325f.setOnClickListener(new C04484(this));
        this.f3325f.setVisibility(0);
    }

    private void m4454b(ImmutableList<NodesModel> immutableList) {
        this.f3324e.removeAllViews();
        PageChildLocationsRowViewController pageChildLocationsRowViewController = new PageChildLocationsRowViewController();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            final NodesModel nodesModel = (NodesModel) immutableList.get(i);
            PageChildLocationsRowView pageChildLocationsRowView = new PageChildLocationsRowView(getContext());
            pageChildLocationsRowViewController.m2017a(nodesModel);
            pageChildLocationsRowView.m2016a(pageChildLocationsRowViewController);
            pageChildLocationsRowView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ PageIdentityChildLocationsCardView f3318b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 639926395);
                    long parseLong = Long.parseLong(nodesModel.k());
                    this.f3318b.f3322c.b(this.f3318b.f3328i, parseLong);
                    this.f3318b.f3320a.a(this.f3318b.f3321b.b(parseLong, nodesModel.m(), nodesModel.n().b()), this.f3318b.getContext());
                    Logger.a(2, EntryType.UI_INPUT_END, 1994968008, a);
                }
            });
            this.f3324e.addView(pageChildLocationsRowView);
        }
        this.f3324e.setVisibility(0);
    }

    public static void m4455e(PageIdentityChildLocationsCardView pageIdentityChildLocationsCardView) {
        if (pageIdentityChildLocationsCardView.f3329j != null) {
            Intent a = pageIdentityChildLocationsCardView.f3323d.a(pageIdentityChildLocationsCardView.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.as, Long.valueOf(pageIdentityChildLocationsCardView.f3328i)));
            if (a != null) {
                FlatBufferModelHelper.a(a, "extra_child_locations", Lists.a(pageIdentityChildLocationsCardView.f3329j));
                a.putExtra("extra_page_name", pageIdentityChildLocationsCardView.f3330k).putExtra("com.facebook.katana.profile.id", pageIdentityChildLocationsCardView.f3328i);
                pageIdentityChildLocationsCardView.f3320a.a(a, pageIdentityChildLocationsCardView.getContext());
            }
        }
    }
}
