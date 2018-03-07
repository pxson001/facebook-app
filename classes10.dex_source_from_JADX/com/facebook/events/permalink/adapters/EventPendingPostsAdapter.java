package com.facebook.events.permalink.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.events.gating.EventPermalinkBazingaHelper;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.model.Event;
import com.facebook.events.permalink.pendingposts.EventPendingPostsStatusView;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.listview.FbBaseAdapter;
import javax.inject.Inject;

/* compiled from: bwfjrjmmyquappyddyfghfhjfhffhblphfnfohnggyfuclbvnnyjefjnjjkjsswawkvbhfcbcnjrryjkm */
public class EventPendingPostsAdapter extends FbBaseAdapter {
    private final Context f18158a;
    public Event f18159b;
    private EventPermalinkBazingaHelper f18160c;
    public FetchEventPermalinkFragmentModel f18161d;
    private boolean f18162e;

    /* compiled from: bwfjrjmmyquappyddyfghfhjfhffhblphfnfohnggyfuclbvnnyjefjnjjkjsswawkvbhfcbcnjrryjkm */
    enum ViewType {
        EVENT_PERMALINK_GAP_VIEW,
        PENDING_POSTS_STATUS
    }

    public static EventPendingPostsAdapter m18522a(InjectorLike injectorLike) {
        return new EventPendingPostsAdapter((Context) injectorLike.getInstance(Context.class), EventPermalinkBazingaHelper.a(injectorLike));
    }

    @Inject
    public EventPendingPostsAdapter(Context context, EventPermalinkBazingaHelper eventPermalinkBazingaHelper) {
        this.f18158a = context;
        this.f18160c = eventPermalinkBazingaHelper;
    }

    public final View m18524a(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(this.f18158a).inflate(ViewType.values()[i] == ViewType.EVENT_PERMALINK_GAP_VIEW ? 2130904074 : 2130904052, viewGroup, false);
    }

    public final void m18525a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        if (ViewType.values()[i2] == ViewType.PENDING_POSTS_STATUS) {
            ((EventPendingPostsStatusView) view).m19066a(this.f18159b, this.f18161d);
        }
    }

    public int getItemViewType(int i) {
        if (i != 0 || m18523b()) {
            return ViewType.PENDING_POSTS_STATUS.ordinal();
        }
        return ViewType.EVENT_PERMALINK_GAP_VIEW.ordinal();
    }

    public int getViewTypeCount() {
        return ViewType.values().length;
    }

    public int getCount() {
        if (this.f18162e) {
            return !m18523b() ? 2 : 1;
        } else {
            return 0;
        }
    }

    public Object getItem(int i) {
        return this.f18161d;
    }

    public long getItemId(int i) {
        return 0;
    }

    public final void m18526a(Event event, FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        this.f18159b = event;
        this.f18161d = fetchEventPermalinkFragmentModel;
        boolean z = false;
        if (this.f18159b != null && this.f18161d != null && this.f18161d.M() && this.f18161d.aN() > 0) {
            z = true;
        }
        this.f18162e = z;
    }

    private boolean m18523b() {
        return this.f18159b != null && EventPermalinkBazingaHelper.a(this.f18159b.l);
    }
}
