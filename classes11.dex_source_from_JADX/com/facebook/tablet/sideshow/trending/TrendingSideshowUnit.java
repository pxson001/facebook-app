package com.facebook.tablet.sideshow.trending;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.tablet.sideshow.SideshowUnit;
import com.facebook.tablet.sideshow.analytics.SideshowAnalyticsLogger;
import com.facebook.tablet.sideshow.loader.SideshowLoader.1;
import com.facebook.tablet.sideshow.trending.graphql.FetchTrendingEntitiesSideshowDataQL.FetchTrendingEntitiesSideshowDataString;
import com.facebook.tablet.sideshow.trending.graphql.FetchTrendingEntitiesSideshowDataRequest;
import com.facebook.tablet.sideshow.trending.graphql.FetchTrendingEntitiesSideshowDataRequest.C06601;
import com.facebook.tablet.sideshow.trending.model.TrendingDataHolder;
import com.facebook.tablet.sideshow.trending.model.TrendingDataHolder.C06611;
import com.facebook.tablet.sideshow.trending.model.TrendingRow;
import com.facebook.tablet.sideshow.trending.ui.TrendingSideshowListAdapter;
import com.facebook.tablet.sideshow.trending.ui.TrendingSideshowListAdapter.C06621;
import com.facebook.tablet.sideshow.widget.SideshowExpandableListView;
import com.facebook.tablet.sideshow.widget.SideshowExpandableListView.ListExpansionListener;
import com.facebook.tablet.sideshow.widget.SideshowExpandableListView.OnItemClickedListener;
import com.facebook.tablet.sideshow.widget.SideshowUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.util.concurrent.Futures;

/* compiled from: omvp_app_updates */
public class TrendingSideshowUnit implements SideshowUnit {
    private TrendingSideshowListAdapter f4864a;
    private TrendingDataHolder f4865b;
    public SideshowAnalyticsLogger f4866c;
    public SearchResultsIntentBuilder f4867d;
    public SecureContextHelper f4868e;
    public SideshowUtils f4869f;

    public TrendingSideshowUnit(TrendingSideshowListAdapter trendingSideshowListAdapter, FetchTrendingEntitiesSideshowDataRequest fetchTrendingEntitiesSideshowDataRequest, SideshowAnalyticsLogger sideshowAnalyticsLogger, SearchResultsIntentBuilder searchResultsIntentBuilder, SecureContextHelper secureContextHelper, SideshowUtils sideshowUtils) {
        this.f4864a = trendingSideshowListAdapter;
        this.f4866c = sideshowAnalyticsLogger;
        this.f4865b = new TrendingDataHolder(fetchTrendingEntitiesSideshowDataRequest);
        TrendingSideshowListAdapter trendingSideshowListAdapter2 = this.f4864a;
        TrendingDataHolder trendingDataHolder = this.f4865b;
        if (trendingSideshowListAdapter2.f4903b != trendingDataHolder) {
            trendingSideshowListAdapter2.f4903b = trendingDataHolder;
            C06621 c06621 = new C06621(trendingSideshowListAdapter2);
            trendingDataHolder.f4893b.add(c06621);
            if (trendingDataHolder.m6112a() > 0) {
                c06621.m6113b();
            }
        }
        this.f4867d = searchResultsIntentBuilder;
        this.f4868e = secureContextHelper;
        this.f4869f = sideshowUtils;
    }

    public final View m6066a(final Context context, ViewGroup viewGroup) {
        LayoutInflater from = LayoutInflater.from(context);
        View inflate = from.inflate(2130907564, viewGroup);
        final SideshowExpandableListView sideshowExpandableListView = (SideshowExpandableListView) inflate.findViewById(16908298);
        sideshowExpandableListView.setAdapter(this.f4864a);
        sideshowExpandableListView.g = new OnItemClickedListener(this) {
            final /* synthetic */ TrendingSideshowUnit f4858b;

            public final void m6063a(View view, Object obj) {
                this.f4858b.f4866c.b(this.f4858b.m6071d());
                TrendingRow trendingRow = (TrendingRow) obj;
                TrendingSideshowUnit trendingSideshowUnit = this.f4858b;
                Context context = context;
                trendingSideshowUnit.f4868e.a(trendingSideshowUnit.f4867d.a(SearchTypeaheadSession.a, trendingRow.f4895a, trendingRow.f4896b, SearchResultsSource.i), context);
            }
        };
        sideshowExpandableListView.a(from.inflate(2130907566, viewGroup, false));
        View c = sideshowExpandableListView.c(2130907565);
        final TextView textView = (TextView) c.findViewById(2131568138);
        this.f4869f.a(textView.getText(), textView);
        c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TrendingSideshowUnit f4860b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 4494694);
                if (sideshowExpandableListView.k) {
                    sideshowExpandableListView.a();
                } else {
                    sideshowExpandableListView.b();
                }
                LogUtils.a(-1005078523, a);
            }
        });
        sideshowExpandableListView.h = new ListExpansionListener(this) {
            final /* synthetic */ TrendingSideshowUnit f4863c;

            public final void m6064a() {
                this.f4863c.f4869f.a(context.getString(2131241719), textView);
            }

            public final void m6065b() {
                this.f4863c.f4869f.a(context.getString(2131241720), textView);
            }
        };
        return inflate;
    }

    public final void m6067a() {
    }

    public final void m6069b() {
    }

    public final void m6070c() {
        TrendingDataHolder trendingDataHolder = this.f4865b;
        trendingDataHolder.f4894c = null;
        for (C06621 c06621 : trendingDataHolder.f4893b) {
            AdapterDetour.a(c06621.f4901a, -105038757);
        }
    }

    public final void m6068a(Context context, 1 1) {
        TrendingDataHolder trendingDataHolder = this.f4865b;
        FetchTrendingEntitiesSideshowDataRequest fetchTrendingEntitiesSideshowDataRequest = trendingDataHolder.f4892a;
        Futures.a(fetchTrendingEntitiesSideshowDataRequest.f4888a.a(GraphQLRequest.a((FetchTrendingEntitiesSideshowDataString) new FetchTrendingEntitiesSideshowDataString().a("count", Integer.valueOf(10)))), new C06601(fetchTrendingEntitiesSideshowDataRequest, new C06611(trendingDataHolder, 1)), fetchTrendingEntitiesSideshowDataRequest.f4889b);
    }

    public final String m6071d() {
        return "trending";
    }
}
