package com.facebook.feed.topicfeeds.favorites;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bugreporter.activity.FragmentWithDebugInfo;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedFragmentModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedListModel;
import com.facebook.topics.protocol.TopicModelHelper;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.dragsortgridview.DragSortGridView;
import com.facebook.widget.dragsortgridview.DragSortGridView.OnDropListener;
import com.facebook.widget.listview.ScrollableListContainer;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.annotations.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: TRANSACTION_HISTORY_MESSENGER_PAY_PREFERENCES */
public class TopicFeedFavoritesFragment extends FbFragment implements AnalyticsFragment, FragmentWithDebugInfo, ScrollableListContainer {
    @Inject
    public Provider<TopicFeedFavoritesDragSortGridAdapter> f24617a;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbErrorReporter> f24618b = UltralightRuntime.b;
    public DragSortGridView f24619c;
    public TopicFeedFavoritesDragSortGridAdapter f24620d;

    /* compiled from: TRANSACTION_HISTORY_MESSENGER_PAY_PREFERENCES */
    public class C29671 implements OnItemClickListener {
        final /* synthetic */ TopicFeedFavoritesFragment f24612a;

        public C29671(TopicFeedFavoritesFragment topicFeedFavoritesFragment) {
            this.f24612a = topicFeedFavoritesFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TopicFeedFavoritesDragSortGridAdapter topicFeedFavoritesDragSortGridAdapter = this.f24612a.f24620d;
            Object item = topicFeedFavoritesDragSortGridAdapter.getItem(i);
            if (item instanceof TopicFeedFragmentModel) {
                TopicFeedFavoritesDragSortGridAdapter.m26514a(topicFeedFavoritesDragSortGridAdapter, (TopicFeedFragmentModel) item);
            }
        }
    }

    /* compiled from: TRANSACTION_HISTORY_MESSENGER_PAY_PREFERENCES */
    public class C29682 implements OnItemLongClickListener {
        final /* synthetic */ TopicFeedFavoritesFragment f24613a;

        public C29682(TopicFeedFavoritesFragment topicFeedFavoritesFragment) {
            this.f24613a = topicFeedFavoritesFragment;
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            view.setPressed(false);
            this.f24613a.f24619c.a();
            return false;
        }
    }

    /* compiled from: TRANSACTION_HISTORY_MESSENGER_PAY_PREFERENCES */
    public class C29693 implements OnDropListener {
        final /* synthetic */ TopicFeedFavoritesFragment f24614a;

        public C29693(TopicFeedFavoritesFragment topicFeedFavoritesFragment) {
            this.f24614a = topicFeedFavoritesFragment;
        }

        public final void m26522a() {
            this.f24614a.f24619c.b();
        }
    }

    /* compiled from: TRANSACTION_HISTORY_MESSENGER_PAY_PREFERENCES */
    public class C29704 implements OnTouchListener {
        final /* synthetic */ TopicFeedFavoritesFragment f24615a;

        public C29704(TopicFeedFavoritesFragment topicFeedFavoritesFragment) {
            this.f24615a = topicFeedFavoritesFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(this.f24615a.f24619c.s);
            return false;
        }
    }

    /* compiled from: TRANSACTION_HISTORY_MESSENGER_PAY_PREFERENCES */
    public class C29715 {
        public final /* synthetic */ TopicFeedFavoritesFragment f24616a;

        public C29715(TopicFeedFavoritesFragment topicFeedFavoritesFragment) {
            this.f24616a = topicFeedFavoritesFragment;
        }
    }

    public static void m26523a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        TopicFeedFavoritesFragment topicFeedFavoritesFragment = (TopicFeedFavoritesFragment) obj;
        Provider a = IdBasedProvider.a(fbInjector, 6067);
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 494);
        topicFeedFavoritesFragment.f24617a = a;
        topicFeedFavoritesFragment.f24618b = b;
    }

    public final void m26528c(Bundle bundle) {
        super.c(bundle);
        Class cls = TopicFeedFavoritesFragment.class;
        m26523a((Object) this, getContext());
        if (this.f24620d == null) {
            this.f24620d = (TopicFeedFavoritesDragSortGridAdapter) this.f24617a.get();
        }
    }

    public final View m26526a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1691141839);
        View inflate = layoutInflater.inflate(2130907527, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 609765673, a);
        return inflate;
    }

    public final void m26527a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f24619c = (DragSortGridView) e(2131568075);
        this.f24619c.setAdapter(this.f24620d);
        this.f24619c.setOnItemClickListener(new C29671(this));
        this.f24619c.setOnItemLongClickListener(new C29682(this));
        this.f24619c.t = new C29693(this);
        this.f24619c.setOnTouchListener(new C29704(this));
        this.f24620d.f24608b = new C29715(this);
        if (this.f24620d.m26521c() == null) {
            TopicFeedListModel n;
            Bundle bundle2 = this.s;
            if (!(bundle == null || bundle.get("bundle_topic_model") == null)) {
                n = m26525n(bundle);
                if (n == null) {
                    ((AbstractFbErrorReporter) this.f24618b.get()).a(getClass().getSimpleName(), "TopicFeedListModel restored from instanceState is invalid, falling back to arguments");
                }
                this.f24620d.m26520a(TopicModelHelper.a(n).a());
            }
            TopicFeedListModel n2 = m26525n(bundle2);
            if (n2 == null) {
                ((AbstractFbErrorReporter) this.f24618b.get()).b(getClass().getSimpleName(), "Could not find TopicFeedListModel in savedInstanceState and arguments");
            }
            n = n2;
            this.f24620d.m26520a(TopicModelHelper.a(n).a());
        }
    }

    public final void m26529e(Bundle bundle) {
        FlatBufferModelHelper.a(bundle, "bundle_topic_model", m26524e());
    }

    public final String am_() {
        return "topic_feeds_favorites";
    }

    @VisibleForTesting
    private TopicFeedListModel m26524e() {
        return this.f24620d.m26521c();
    }

    public Map<String, String> getDebugInfo() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("TopicFeedFavoritesFragment_data", m26524e().toString());
        return hashMap;
    }

    public final void gB_() {
        if (this.f24619c != null) {
            this.f24619c.smoothScrollToPosition(0);
        }
    }

    public final boolean gC_() {
        return this.f24619c == null || !this.f24619c.canScrollVertically(-1);
    }

    @Nullable
    public final ScrollingViewProxy m26530n() {
        return null;
    }

    public static TopicFeedListModel m26525n(Bundle bundle) {
        Object a = FlatBufferModelHelper.a(bundle, "bundle_topic_model");
        if (a instanceof TopicFeedListModel) {
            return (TopicFeedListModel) a;
        }
        return null;
    }
}
