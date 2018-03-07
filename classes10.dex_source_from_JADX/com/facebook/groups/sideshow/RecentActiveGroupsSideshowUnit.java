package com.facebook.groups.sideshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsDataQL.FetchRecentActiveGroupsQueryString;
import com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsRequest;
import com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsRequest.C00591;
import com.facebook.groups.sideshow.model.RecentActiveGroupRow;
import com.facebook.groups.sideshow.model.RecentActiveGroupsDataHolder;
import com.facebook.groups.sideshow.model.RecentActiveGroupsDataHolder.C00601;
import com.facebook.groups.sideshow.ui.RecentActiveGroupsListAdapter;
import com.facebook.groups.sideshow.ui.RecentActiveGroupsListAdapter.C00611;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tablet.sideshow.SideshowUnit;
import com.facebook.tablet.sideshow.analytics.SideshowAnalyticsLogger;
import com.facebook.tablet.sideshow.loader.SideshowLoader.C14851;
import com.facebook.tablet.sideshow.widget.SideshowExpandableListView;
import com.facebook.tablet.sideshow.widget.SideshowExpandableListView.ListExpansionListener;
import com.facebook.tablet.sideshow.widget.SideshowExpandableListView.OnItemClickedListener;
import com.facebook.tablet.sideshow.widget.SideshowUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.util.concurrent.Futures;

/* compiled from: windows-1252 */
public class RecentActiveGroupsSideshowUnit implements SideshowUnit {
    private RecentActiveGroupsListAdapter f311a;
    private RecentActiveGroupsDataHolder f312b;
    public FbUriIntentHandler f313c;
    public SideshowAnalyticsLogger f314d;
    public SideshowUtils f315e;

    public RecentActiveGroupsSideshowUnit(RecentActiveGroupsListAdapter recentActiveGroupsListAdapter, FetchRecentActiveGroupsRequest fetchRecentActiveGroupsRequest, FbUriIntentHandler fbUriIntentHandler, SideshowAnalyticsLogger sideshowAnalyticsLogger, SideshowUtils sideshowUtils) {
        this.f311a = recentActiveGroupsListAdapter;
        this.f313c = fbUriIntentHandler;
        this.f314d = sideshowAnalyticsLogger;
        this.f312b = new RecentActiveGroupsDataHolder(fetchRecentActiveGroupsRequest);
        RecentActiveGroupsListAdapter recentActiveGroupsListAdapter2 = this.f311a;
        RecentActiveGroupsDataHolder recentActiveGroupsDataHolder = this.f312b;
        if (recentActiveGroupsListAdapter2.f352b != recentActiveGroupsDataHolder) {
            recentActiveGroupsListAdapter2.f352b = recentActiveGroupsDataHolder;
            C00611 c00611 = new C00611(recentActiveGroupsListAdapter2);
            recentActiveGroupsDataHolder.f347b.add(c00611);
            if (recentActiveGroupsDataHolder.m476a() > 0) {
                c00611.m477b();
            }
        }
        this.f315e = sideshowUtils;
    }

    public final View m404a(final Context context, ViewGroup viewGroup) {
        LayoutInflater from = LayoutInflater.from(context);
        View inflate = from.inflate(2130906745, viewGroup);
        final SideshowExpandableListView sideshowExpandableListView = (SideshowExpandableListView) inflate.findViewById(16908298);
        sideshowExpandableListView.setAdapter(this.f311a);
        sideshowExpandableListView.f10143g = new OnItemClickedListener(this) {
            final /* synthetic */ RecentActiveGroupsSideshowUnit f305b;

            public final void mo13a(View view, Object obj) {
                this.f305b.f314d.m10183b(this.f305b.m409d());
                RecentActiveGroupRow recentActiveGroupRow = (RecentActiveGroupRow) obj;
                RecentActiveGroupsSideshowUnit recentActiveGroupsSideshowUnit = this.f305b;
                recentActiveGroupsSideshowUnit.f313c.a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.u, recentActiveGroupRow.f340a));
            }
        };
        sideshowExpandableListView.m10206a(from.inflate(2130906747, null));
        View c = sideshowExpandableListView.m10209c(2130906746);
        final TextView textView = (TextView) c.findViewById(2131566840);
        this.f315e.m10212a(textView.getText(), textView);
        c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RecentActiveGroupsSideshowUnit f307b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -637195915);
                if (sideshowExpandableListView.f10147k) {
                    sideshowExpandableListView.m10207a();
                } else {
                    sideshowExpandableListView.m10208b();
                }
                LogUtils.a(-1583010, a);
            }
        });
        sideshowExpandableListView.f10144h = new ListExpansionListener(this) {
            final /* synthetic */ RecentActiveGroupsSideshowUnit f310c;

            public final void mo14a() {
                this.f310c.f315e.m10212a(context.getString(2131241381), textView);
            }

            public final void mo15b() {
                this.f310c.f315e.m10212a(context.getString(2131241382), textView);
            }
        };
        return inflate;
    }

    public final void m407b() {
    }

    public final void m405a() {
    }

    public final void m408c() {
        RecentActiveGroupsDataHolder recentActiveGroupsDataHolder = this.f312b;
        recentActiveGroupsDataHolder.f348c = null;
        for (C00611 c00611 : recentActiveGroupsDataHolder.f347b) {
            AdapterDetour.a(c00611.f350a, 1885133249);
        }
    }

    public final void m406a(Context context, C14851 c14851) {
        RecentActiveGroupsDataHolder recentActiveGroupsDataHolder = this.f312b;
        FetchRecentActiveGroupsRequest fetchRecentActiveGroupsRequest = recentActiveGroupsDataHolder.f346a;
        Futures.a(fetchRecentActiveGroupsRequest.f337a.a(GraphQLRequest.a((FetchRecentActiveGroupsQueryString) new FetchRecentActiveGroupsQueryString().a("node_id", fetchRecentActiveGroupsRequest.f339c).a("count", Integer.valueOf(6)))), new C00591(fetchRecentActiveGroupsRequest, new C00601(recentActiveGroupsDataHolder, c14851)), fetchRecentActiveGroupsRequest.f338b);
    }

    public final String m409d() {
        return "recent_active_groups";
    }
}
