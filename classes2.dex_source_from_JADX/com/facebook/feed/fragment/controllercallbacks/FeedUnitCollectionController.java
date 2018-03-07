package com.facebook.feed.fragment.controllercallbacks;

import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feed.data.FeedUnitCollectionData;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.controllercallbacks.AdapterCreatedCallback;
import com.facebook.feed.rows.core.persistence.ContextStateMap;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.HasSponsoredImpression;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.graphql.model.SponsoredImpression;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.BasicAdapter;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.controllercallbacks.AdapterDataChangedCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: photos_feed */
public class FeedUnitCollectionController extends BaseController implements AdapterCreatedCallback, AdapterDataChangedCallback {
    private final ContextStateMap f9903a;
    public Holder<ListItemCollection<FeedEdge>> f9904b;

    public static FeedUnitCollectionController m14931a(InjectorLike injectorLike) {
        return new FeedUnitCollectionController(ContextStateMap.m14935a(injectorLike));
    }

    @Inject
    public FeedUnitCollectionController(ContextStateMap contextStateMap) {
        this.f9903a = contextStateMap;
    }

    public final void mo1951a(BasicAdapter basicAdapter) {
        FeedUnitCollection b = m14932b();
        if (b != null) {
            Iterator it = b.iterator();
            int i = 0;
            while (it.hasNext()) {
                FeedUnit c = ((GraphQLFeedUnitEdge) it.next()).mo2540c();
                if (c != null) {
                    SponsoredImpression ab_;
                    if (c instanceof ScrollableItemListFeedUnit) {
                        for (Object next : ((ScrollableItemListFeedUnit) c).mo2882v()) {
                            if (next instanceof HasSponsoredImpression) {
                                ab_ = ((HasSponsoredImpression) next).ab_();
                                if (ab_ != null) {
                                    ab_.f21619r = i;
                                }
                            }
                        }
                    } else if (c instanceof Sponsorable) {
                        ab_ = ((Sponsorable) c).ab_();
                        if (ab_ != null && ab_.mo3121k()) {
                            ab_.f21619r = i;
                        }
                    }
                    i++;
                }
            }
        }
        ContextStateMap contextStateMap = this.f9903a;
        FeedUnitCollectionData feedUnitCollectionData = m14932b().f5631g;
        List list = feedUnitCollectionData.f5661c;
        feedUnitCollectionData.f5661c = new ArrayList();
        contextStateMap.m14942a(list);
    }

    public final void mo1889a(HasMultiRow hasMultiRow, ScrollingViewProxy scrollingViewProxy, FeedEnvironment feedEnvironment) {
        this.f9903a.m14941a();
        m14932b().f5631g.f5660b = true;
    }

    public final void kF_() {
    }

    private FeedUnitCollection m14932b() {
        return (FeedUnitCollection) this.f9904b.f10429a;
    }
}
