package com.facebook.groups.feed.rows;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.controller.connectioncontroller.common.ConnectionController;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.api.ListItemCollectionEndProvider;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.ListItemComparator;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.groups.feed.controller.GroupsFeedPager;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import javax.inject.Inject;

/* compiled from: faceweb/f?href=/%s/activity_feed/?type=share */
public class BaseGroupsMultiRowAdapterFactory {
    private final MultiRowAdapterBuilder f14132a;

    /* compiled from: faceweb/f?href=/%s/activity_feed/?type=share */
    class C15123 implements ListItemComparator<GraphQLFeedUnitEdge> {
        final /* synthetic */ BaseGroupsMultiRowAdapterFactory f14131a;

        C15123(BaseGroupsMultiRowAdapterFactory baseGroupsMultiRowAdapterFactory) {
            this.f14131a = baseGroupsMultiRowAdapterFactory;
        }

        public final boolean m15681a(Object obj, Object obj2) {
            return ((GraphQLFeedUnitEdge) obj) == ((GraphQLFeedUnitEdge) obj2);
        }

        public final boolean m15682a(Object obj, Object obj2, long j) {
            return ((GraphQLFeedUnitEdge) obj) == ((GraphQLFeedUnitEdge) obj2);
        }
    }

    public static BaseGroupsMultiRowAdapterFactory m15684b(InjectorLike injectorLike) {
        return new BaseGroupsMultiRowAdapterFactory(MultiRowAdapterBuilder.b(injectorLike));
    }

    @Inject
    public BaseGroupsMultiRowAdapterFactory(MultiRowAdapterBuilder multiRowAdapterBuilder) {
        this.f14132a = multiRowAdapterBuilder;
    }

    public final <E extends FeedEnvironment> MultiRowAdapter m15686a(ListItemCollection<FeedEdge> listItemCollection, Lazy<? extends MultiRowGroupPartDefinition<?, ?, ? super E>> lazy, E e, final GroupsFeedPager groupsFeedPager) {
        Builder a = this.f14132a.a(lazy, listItemCollection).a(new ListItemCollectionEndProvider(this) {
            final /* synthetic */ BaseGroupsMultiRowAdapterFactory f14128b;

            public final boolean m15679a() {
                return !groupsFeedPager.f13938r;
            }
        });
        a.f = e;
        return a.e();
    }

    public static BaseGroupsMultiRowAdapterFactory m15683a(InjectorLike injectorLike) {
        return m15684b(injectorLike);
    }

    public final <E extends FeedEnvironment> MultiRowAdapter m15685a(ListItemCollection<FeedEdge> listItemCollection, Lazy<? extends MultiRowGroupPartDefinition<?, ?, ? super E>> lazy, E e, final ConnectionController<GraphQLFeedUnitEdge, ?> connectionController, boolean z) {
        Builder a = this.f14132a.a(lazy, listItemCollection).a(new ListItemCollectionEndProvider(this) {
            final /* synthetic */ BaseGroupsMultiRowAdapterFactory f14130b;

            public final boolean m15680a() {
                return connectionController.d().c().d;
            }
        });
        a.f = e;
        a = a;
        if (z) {
            a.e = new C15123(this);
        }
        return a.e();
    }
}
