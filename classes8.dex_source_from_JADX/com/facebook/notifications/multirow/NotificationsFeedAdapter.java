package com.facebook.notifications.multirow;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.api.feed.data.collections.ObservableListItemCollection;
import com.facebook.common.dispose.Disposable;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.feed.rows.core.ListItemComparator;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.notifications.multirow.partdefinition.NotificationsFeedRootPartDefinition;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationsEdgeFieldsModel;
import com.facebook.widget.listview.AdapterCompatibleWithListView;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: custom_renderer_type */
public class NotificationsFeedAdapter extends Adapter<ViewHolder> implements Disposable, AdapterCompatibleWithListView<ViewHolder> {
    private static final int f16028a = 2131558781;
    private static final int f16029b = 2131558780;
    private static final int f16030c = 2131558782;
    private final MultiRowAdapterBuilder f16031d;
    private final MultipleRowsStoriesRecycleCallback f16032e;
    private final Lazy<NotificationsFeedRootPartDefinition> f16033f;
    private final boolean f16034g;
    private MultiRowRecyclerViewAdapter f16035h;
    public TailLoadingState f16036i = TailLoadingState.LOADING;
    public OnClickListener f16037j;

    /* compiled from: custom_renderer_type */
    class C17161 extends AdapterDataObserver {
        final /* synthetic */ NotificationsFeedAdapter f16027a;

        C17161(NotificationsFeedAdapter notificationsFeedAdapter) {
            this.f16027a = notificationsFeedAdapter;
        }

        public final void bb_() {
            this.f16027a.notifyDataSetChanged();
        }

        public final void m18822a(int i, int i2) {
            this.f16027a.a(i, i2);
        }

        public final void m18824b(int i, int i2) {
            this.f16027a.c(i, i2);
        }

        public final void m18825c(int i, int i2) {
            this.f16027a.d(i, i2);
        }

        public final void m18823a(int i, int i2, int i3) {
            throw new UnsupportedOperationException("onItemRangeMoved is not supported");
        }
    }

    /* compiled from: custom_renderer_type */
    class LoadingViewHolder extends ViewHolder {
        public LoadingViewHolder(View view) {
            super(view);
        }
    }

    /* compiled from: custom_renderer_type */
    public enum TailLoadingState {
        LOADING,
        FAILED,
        FINISHED
    }

    @Inject
    public NotificationsFeedAdapter(@Assisted AnyEnvironment anyEnvironment, @Nullable @Assisted ListItemComparator<NotificationsEdgeFieldsModel> listItemComparator, @Assisted ListItemCollection listItemCollection, MultiRowAdapterBuilder multiRowAdapterBuilder, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, Lazy<NotificationsFeedRootPartDefinition> lazy) {
        this.f16031d = multiRowAdapterBuilder;
        this.f16032e = multipleRowsStoriesRecycleCallback;
        this.f16033f = lazy;
        Builder a = this.f16031d.a(this.f16033f, listItemCollection);
        a.f = anyEnvironment;
        a = a;
        a.e = listItemComparator;
        this.f16035h = a.d();
        this.f16034g = listItemCollection instanceof ObservableListItemCollection;
        if (this.f16034g) {
            this.f16035h.a(new C17161(this));
        }
    }

    public final int aZ_() {
        return this.f16035h.aZ_() + 1;
    }

    public Object getItem(int i) {
        if (i >= this.f16035h.aZ_()) {
            return null;
        }
        return this.f16035h.getItem(i);
    }

    public final int iy_() {
        return this.f16035h.iy_();
    }

    public final void jc_() {
        this.f16035h.jc_();
    }

    public final boolean ba_() {
        return this.f16035h.ba_();
    }

    public final ViewHolder m18826a(ViewGroup viewGroup, int i) {
        if (i == f16028a) {
            return new LoadingViewHolder(View.inflate(viewGroup.getContext(), 2130907503, null));
        }
        if (i == f16030c) {
            Context context = viewGroup.getContext();
            View inflate = View.inflate(context, 2130907502, null);
            ((TextView) inflate.findViewById(2131563532)).setText(context.getString(2131230811));
            if (this.f16037j != null) {
                inflate.setOnClickListener(this.f16037j);
            }
            return new LoadingViewHolder(inflate);
        } else if (i == f16029b) {
            return new LoadingViewHolder(new View(viewGroup.getContext()));
        } else {
            return this.f16035h.a(viewGroup, i);
        }
    }

    public final void m18828a(ViewHolder viewHolder, int i) {
        if (!(viewHolder instanceof LoadingViewHolder)) {
            this.f16035h.a(viewHolder, i);
        }
    }

    public final void m18827a(ViewHolder viewHolder) {
        super.a(viewHolder);
        MultipleRowsStoriesRecycleCallback.a(viewHolder.a);
    }

    public int getItemViewType(int i) {
        if (i < this.f16035h.aZ_()) {
            return this.f16035h.getItemViewType(i);
        }
        if (this.f16036i == TailLoadingState.LOADING) {
            return f16028a;
        }
        if (this.f16036i == TailLoadingState.FAILED) {
            return f16030c;
        }
        return f16029b;
    }

    public final void m18829e() {
        Preconditions.checkState(!this.f16034g);
        this.f16035h.notifyDataSetChanged();
        notifyDataSetChanged();
    }
}
