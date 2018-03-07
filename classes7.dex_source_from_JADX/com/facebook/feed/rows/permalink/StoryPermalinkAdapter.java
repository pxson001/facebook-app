package com.facebook.feed.rows.permalink;

import android.content.res.Configuration;
import com.facebook.debug.dumpsys.DumpsysContext;
import com.facebook.debug.dumpsys.DumpsysDumpable;
import com.facebook.feed.permalink.PermalinkAdapter;
import com.facebook.feed.rows.adapter.DelegatingMultiRowAdapter;
import com.facebook.feed.rows.adapter.OneItemListItemCollection;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feedback.ui.Bindable;
import com.facebook.graphql.model.FeedUnit;

/* compiled from: activity_picker_object_skipped */
public class StoryPermalinkAdapter extends DelegatingMultiRowAdapter implements DumpsysDumpable, PermalinkAdapter, Bindable<FeedUnit> {
    private final OneItemListItemCollection f19991a;

    public final void mo198a(Object obj) {
        this.f19991a.a = (FeedUnit) obj;
        notifyDataSetChanged();
    }

    public StoryPermalinkAdapter(MultiRowAdapter multiRowAdapter, OneItemListItemCollection<FeedUnit> oneItemListItemCollection) {
        super(multiRowAdapter);
        this.f19991a = oneItemListItemCollection;
    }

    public final void m23194a(Configuration configuration) {
        super.a(configuration);
    }

    public final void m23195a(DumpsysContext dumpsysContext) {
        dumpsysContext.f.a(this.a, dumpsysContext);
    }
}
