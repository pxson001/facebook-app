package com.facebook.groups.feed.ui;

import android.content.Context;
import android.os.Bundle;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.permalink.PermalinkGraphQLStorySelectorPartDefinition;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.groups.feed.data.GroupsFeedConsistencySync;
import com.facebook.groups.feed.data.GroupsFeedConsistencySyncProvider;
import com.facebook.groups.feed.data.GroupsOnDataChangeListener;
import com.facebook.groups.feed.protocol.FetchCrossGroupForSalePostsIdsMethod;
import com.facebook.groups.feed.protocol.FetchCrossGroupForSalePostsIdsMethodProvider;
import com.facebook.groups.feed.protocol.GroupsFeedTypeValueParams;
import com.facebook.groups.feed.protocol.GroupsFeedTypeValueParams.GroupsFeedTypes;
import com.facebook.groups.feed.rows.BaseGroupsMultiRowAdapterFactory;
import com.facebook.groups.feed.ui.partdefinitions.FB4AGroupsFeedRootPartDefinitionFactory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import javax.inject.Inject;

/* compiled from: TimelineFragment.onFragmentCreate.setPreliminaryProfile */
public class CrossGroupForSalePostsFragment extends BaseForSalePostsFeedFragment implements AnalyticsFragment {
    @Inject
    public FetchCrossGroupForSalePostsIdsMethodProvider al;
    @Inject
    public BaseGroupsMultiRowAdapterFactory f22008g;
    @Inject
    public FB4AGroupsFeedRootPartDefinitionFactory f22009h;
    @Inject
    public Lazy<PermalinkGraphQLStorySelectorPartDefinition> f22010i;

    public static void m23145a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CrossGroupForSalePostsFragment crossGroupForSalePostsFragment = (CrossGroupForSalePostsFragment) obj;
        BaseGroupsMultiRowAdapterFactory b = BaseGroupsMultiRowAdapterFactory.b(fbInjector);
        FB4AGroupsFeedRootPartDefinitionFactory a = FB4AGroupsFeedRootPartDefinitionFactory.m23506a(fbInjector);
        Lazy a2 = IdBasedLazy.a(fbInjector, 5911);
        FetchCrossGroupForSalePostsIdsMethodProvider fetchCrossGroupForSalePostsIdsMethodProvider = (FetchCrossGroupForSalePostsIdsMethodProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FetchCrossGroupForSalePostsIdsMethodProvider.class);
        crossGroupForSalePostsFragment.f22008g = b;
        crossGroupForSalePostsFragment.f22009h = a;
        crossGroupForSalePostsFragment.f22010i = a2;
        crossGroupForSalePostsFragment.al = fetchCrossGroupForSalePostsIdsMethodProvider;
    }

    public final void mo973c(Bundle bundle) {
        super.mo973c(bundle);
        Class cls = CrossGroupForSalePostsFragment.class;
        m23145a((Object) this, getContext());
    }

    public final MultiRowAdapter m23146a(ListItemCollection<FeedEdge> listItemCollection, FeedEnvironment feedEnvironment) {
        this.f = this.f22008g.a(listItemCollection, this.f22009h.m23508a(this.f22010i, null), feedEnvironment, this.f22000b);
        return this.f22004f;
    }

    public final String am_() {
        return "cross_group_for_sale_posts";
    }

    public final void m23148a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        this.f22002d.a(str, fileDescriptor, printWriter, strArr);
    }

    public final FeedType at() {
        return new FeedType(new GroupsFeedTypeValueParams(av(), GroupsFeedTypes.CrossGroupForSalePosts), Name.p);
    }

    public final int au() {
        return 2131237950;
    }

    public final GroupsFeedConsistencySync mo974a(GroupsFeedConsistencySyncProvider groupsFeedConsistencySyncProvider, FeedUnitCollection feedUnitCollection, GroupsOnDataChangeListener groupsOnDataChangeListener) {
        FeedType at = at();
        return groupsFeedConsistencySyncProvider.a(at, new FetchCrossGroupForSalePostsIdsMethod(at, DbFeedHomeStoriesHandler.a(this.al)), feedUnitCollection, groupsOnDataChangeListener);
    }
}
