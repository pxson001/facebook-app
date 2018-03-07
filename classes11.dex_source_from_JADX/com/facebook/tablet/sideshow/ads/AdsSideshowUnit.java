package com.facebook.tablet.sideshow.ads;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.TextView;
import com.facebook.feed.logging.impression.FeedUnitImpressionType;
import com.facebook.feed.logging.impression.FeedUnitSponsoredImpressionLogger;
import com.facebook.feed.platformads.AppAdsInvalidator;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.ImpressionUtil;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tablet.sideshow.SideshowUnit;
import com.facebook.tablet.sideshow.ads.analytics.AppAdsSideshowUnitImpression;
import com.facebook.tablet.sideshow.ads.graphql.FetchAppAdsSideshowData.FetchAppAdsSideshowDataString;
import com.facebook.tablet.sideshow.ads.graphql.FetchAppAdsSideshowDataRequest;
import com.facebook.tablet.sideshow.ads.graphql.FetchAppAdsSideshowDataRequest.C06331;
import com.facebook.tablet.sideshow.ads.model.AppAdsSideshowDataHolder;
import com.facebook.tablet.sideshow.ads.model.AppAdsSideshowDataHolder.C06341;
import com.facebook.tablet.sideshow.ads.model.AppAdsSideshowRow;
import com.facebook.tablet.sideshow.ads.ui.AdsSideshowListAdapter;
import com.facebook.tablet.sideshow.ads.ui.AppAdsSideshowRowView;
import com.facebook.tablet.sideshow.loader.SideshowLoader.1;
import com.facebook.tablet.sideshow.widget.SideshowExpandableListView;
import com.facebook.tablet.sideshow.widget.SideshowExpandableListView.ListExpansionListener;
import com.facebook.tablet.sideshow.widget.SideshowExpandableListView.OnItemClickedListener;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.util.concurrent.Futures;
import java.util.HashSet;
import java.util.Set;

/* compiled from: onendgame */
public class AdsSideshowUnit implements SideshowUnit {
    private final Set<String> f4627a;
    private final AdsSideshowListAdapter f4628b;
    public final AppAdsSideshowDataHolder f4629c;
    private final FeedUnitSponsoredImpressionLogger f4630d;

    /* compiled from: onendgame */
    class C06303 implements OnItemClickedListener {
        final /* synthetic */ AdsSideshowUnit f4621a;

        C06303(AdsSideshowUnit adsSideshowUnit) {
            this.f4621a = adsSideshowUnit;
        }

        public final void m5838a(View view, Object obj) {
            ((AppAdsSideshowRowView) view).m5866b();
        }
    }

    public AdsSideshowUnit(AdsSideshowListAdapter adsSideshowListAdapter, FetchAppAdsSideshowDataRequest fetchAppAdsSideshowDataRequest, AppAdsInvalidator appAdsInvalidator, FeedUnitSponsoredImpressionLogger feedUnitSponsoredImpressionLogger) {
        this.f4629c = new AppAdsSideshowDataHolder(fetchAppAdsSideshowDataRequest, appAdsInvalidator);
        AppAdsSideshowDataHolder appAdsSideshowDataHolder = this.f4629c;
        FetchAppAdsSideshowDataRequest fetchAppAdsSideshowDataRequest2 = appAdsSideshowDataHolder.f4644a;
        C06341 c06341 = new C06341(appAdsSideshowDataHolder);
        GraphQlQueryString fetchAppAdsSideshowDataString = new FetchAppAdsSideshowDataString();
        fetchAppAdsSideshowDataString.a("device", "android");
        fetchAppAdsSideshowDataString.a("image_width", "254");
        fetchAppAdsSideshowDataString.a("image_height", "133");
        fetchAppAdsSideshowDataString.a("count", Integer.valueOf(5));
        Futures.a(fetchAppAdsSideshowDataRequest2.f4641a.a(GraphQLRequest.a(fetchAppAdsSideshowDataString)), new C06331(fetchAppAdsSideshowDataRequest2, c06341), fetchAppAdsSideshowDataRequest2.f4642b);
        this.f4628b = adsSideshowListAdapter;
        AdsSideshowListAdapter adsSideshowListAdapter2 = this.f4628b;
        AppAdsSideshowDataHolder appAdsSideshowDataHolder2 = this.f4629c;
        if (adsSideshowListAdapter2.f4667b != appAdsSideshowDataHolder2) {
            adsSideshowListAdapter2.f4667b = appAdsSideshowDataHolder2;
        }
        this.f4630d = feedUnitSponsoredImpressionLogger;
        this.f4627a = new HashSet();
    }

    public final View m5841a(final Context context, ViewGroup viewGroup) {
        LayoutInflater from = LayoutInflater.from(context);
        final View inflate = from.inflate(2130907089, viewGroup);
        final SideshowExpandableListView sideshowExpandableListView = (SideshowExpandableListView) inflate.findViewById(16908298);
        this.f4628b.f4674i = sideshowExpandableListView;
        sideshowExpandableListView.setAdapter(this.f4628b);
        sideshowExpandableListView.a(from.inflate(2130903197, viewGroup, false));
        View c = sideshowExpandableListView.c(2130903196);
        final TextView textView = (TextView) c.findViewById(2131559457);
        c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AdsSideshowUnit f4616b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1034574345);
                if (sideshowExpandableListView.k) {
                    sideshowExpandableListView.a();
                } else {
                    sideshowExpandableListView.b();
                }
                LogUtils.a(-1186413021, a);
            }
        });
        sideshowExpandableListView.h = new ListExpansionListener(this) {
            final /* synthetic */ AdsSideshowUnit f4620d;

            public final void m5836a() {
                textView.setText(context.getString(2131241705));
            }

            public final void m5837b() {
                textView.setText(context.getString(2131241706));
                AdsSideshowUnit.m5840a(this.f4620d, sideshowExpandableListView);
            }
        };
        AppAdsSideshowDataHolder appAdsSideshowDataHolder = this.f4629c;
        C06325 c06325 = new Object(this) {
            final /* synthetic */ AdsSideshowUnit f4626c;

            public final void m5839b() {
                AdsSideshowUnit.m5840a(this.f4626c, sideshowExpandableListView);
            }
        };
        appAdsSideshowDataHolder.f4646c.add(c06325);
        if (appAdsSideshowDataHolder.m5859e() > 0) {
            c06325.m5839b();
        }
        sideshowExpandableListView.g = new C06303(this);
        sideshowExpandableListView.getViewTreeObserver().addOnScrollChangedListener(new OnScrollChangedListener(this) {
            final /* synthetic */ AdsSideshowUnit f4623b;

            public void onScrollChanged() {
                AdsSideshowUnit.m5840a(this.f4623b, sideshowExpandableListView);
            }
        });
        return inflate;
    }

    public final void m5842a() {
    }

    public final void m5844b() {
    }

    public final void m5845c() {
    }

    public final void m5843a(Context context, 1 1) {
        if (this.f4629c.f4650g) {
            1.a(this.f4629c.f4651h);
        } else {
            this.f4629c.f4649f.add(1);
        }
    }

    public final String m5846d() {
        return "sideshow_ads";
    }

    public static void m5840a(AdsSideshowUnit adsSideshowUnit, SideshowExpandableListView sideshowExpandableListView) {
        int count;
        if (sideshowExpandableListView.k) {
            count = adsSideshowUnit.f4628b.getCount();
        } else {
            count = adsSideshowUnit.f4628b.a();
        }
        Rect rect = new Rect();
        sideshowExpandableListView.getHitRect(rect);
        for (int i = 1; i <= count; i++) {
            if (sideshowExpandableListView.getChildAt(i) instanceof AppAdsSideshowRowView) {
                AppAdsSideshowRowView appAdsSideshowRowView = (AppAdsSideshowRowView) sideshowExpandableListView.getChildAt(i);
                if (appAdsSideshowRowView != null && appAdsSideshowRowView.isShown() && appAdsSideshowRowView.getLocalVisibleRect(rect)) {
                    AppAdsSideshowRow a = adsSideshowUnit.f4628b.m5863a(i - 1);
                    if (!(a == null || adsSideshowUnit.f4627a.contains(a.f4659h) || ImpressionUtil.c((Sponsorable) a.f4652a.a))) {
                        adsSideshowUnit.f4627a.add(a.f4659h);
                        adsSideshowUnit.f4630d.a(new AppAdsSideshowUnitImpression(FeedUnitImpressionType.SPONSORED_IMPRESSION, (Sponsorable) a.f4652a.a, TrackableFeedProps.a(a.f4652a)));
                    }
                }
            }
        }
    }
}
