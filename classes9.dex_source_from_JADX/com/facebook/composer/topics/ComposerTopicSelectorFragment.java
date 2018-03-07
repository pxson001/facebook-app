package com.facebook.composer.topics;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.composer.topics.analytics.ComposerTopicLoggerProvider;
import com.facebook.feed.topicfeeds.abtest.TopicFeedsTestUtil;
import com.facebook.graphql.calls.TopicProjectInputTopicProject;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.topics.data.TopicListFetcher;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedListModel;
import com.facebook.topics.protocol.TopicModelHelper;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicator.State;
import com.facebook.widget.loadingindicator.LoadingIndicatorController;
import com.facebook.widget.loadingindicator.LoadingIndicatorState.Builder;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: TypeName */
public class ComposerTopicSelectorFragment extends FbFragment implements CanHandleBackPressed {
    @Inject
    public ComposerTopicLoggerProvider f23889a;
    @Inject
    public Fb4aTitleBarSupplier f23890b;
    @Inject
    public TopicFeedsTestUtil f23891c;
    @Inject
    public TopicListFetcher f23892d;
    private final RetryClickedListener f23893e = new C28961(this);
    public LoadingIndicatorController f23894f;
    public BetterRecyclerView f23895g;
    public ComposerTopicListAdapter f23896h;
    private TopicProjectInputTopicProject f23897i;

    /* compiled from: TypeName */
    class C28961 implements RetryClickedListener {
        final /* synthetic */ ComposerTopicSelectorFragment f23887a;

        C28961(ComposerTopicSelectorFragment composerTopicSelectorFragment) {
            this.f23887a = composerTopicSelectorFragment;
        }

        public final void m25865a() {
            ComposerTopicSelectorFragment.ar(this.f23887a);
        }
    }

    /* compiled from: TypeName */
    class C28972 extends AbstractDisposableFutureCallback<GraphQLResult<TopicFeedListModel>> {
        final /* synthetic */ ComposerTopicSelectorFragment f23888a;

        C28972(ComposerTopicSelectorFragment composerTopicSelectorFragment) {
            this.f23888a = composerTopicSelectorFragment;
        }

        public final void m25866a(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((TopicFeedListModel) graphQLResult.e).a() == null || ((TopicFeedListModel) graphQLResult.e).a().isEmpty()) {
                ComposerTopicSelectorFragment.as(this.f23888a);
                return;
            }
            ComposerTopicSelectorFragment composerTopicSelectorFragment = this.f23888a;
            composerTopicSelectorFragment.f23894f.b();
            ComposerTopicListAdapter composerTopicListAdapter = composerTopicSelectorFragment.f23896h;
            composerTopicListAdapter.f23883d = TopicModelHelper.a((TopicFeedListModel) graphQLResult.e, composerTopicListAdapter.f23885f);
            composerTopicListAdapter.notifyDataSetChanged();
        }

        public final void m25867a(Throwable th) {
            ComposerTopicSelectorFragment.as(this.f23888a);
        }
    }

    public static void m25868a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ComposerTopicSelectorFragment composerTopicSelectorFragment = (ComposerTopicSelectorFragment) obj;
        ComposerTopicLoggerProvider composerTopicLoggerProvider = (ComposerTopicLoggerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ComposerTopicLoggerProvider.class);
        Fb4aTitleBarSupplier a = Fb4aTitleBarSupplier.a(fbInjector);
        TopicFeedsTestUtil b = TopicFeedsTestUtil.b(fbInjector);
        TopicListFetcher b2 = TopicListFetcher.b(fbInjector);
        composerTopicSelectorFragment.f23889a = composerTopicLoggerProvider;
        composerTopicSelectorFragment.f23890b = a;
        composerTopicSelectorFragment.f23891c = b;
        composerTopicSelectorFragment.f23892d = b2;
    }

    public final void m25871c(Bundle bundle) {
        ImmutableList copyOf;
        super.c(bundle);
        Class cls = ComposerTopicSelectorFragment.class;
        m25868a((Object) this, getContext());
        Bundle bundle2 = this.s;
        ArrayList arrayList = (ArrayList) this.s.getSerializable("topics");
        if (arrayList != null) {
            copyOf = ImmutableList.copyOf(arrayList);
        } else {
            copyOf = RegularImmutableList.a;
        }
        this.f23897i = (TopicProjectInputTopicProject) bundle2.getSerializable("topic_project");
        Preconditions.checkNotNull(this.f23897i);
        this.f23896h = new ComposerTopicListAdapter(copyOf, this.f23891c.g(), this.f23889a.m25913a(bundle2.getString("composer_session_id")));
        Builder builder = new Builder();
        builder.d = -1;
        this.f23894f = new LoadingIndicatorController(builder.a(), this.f23893e);
        ar(this);
    }

    public final View m25869a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -253805823);
        View inflate = layoutInflater.inflate(2130907529, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1123889201, a);
        return inflate;
    }

    public final void m25870a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f23894f.a((LoadingIndicatorView) e(2131568080));
        Fb4aTitleBar fb4aTitleBar = this.f23890b.a;
        if (fb4aTitleBar != null) {
            fb4aTitleBar.setTitle(2131234282);
            fb4aTitleBar.setSearchButtonVisible(false);
        }
        ViewStub viewStub = (ViewStub) e(2131568078);
        viewStub.setLayoutResource(2130903735);
        this.f23895g = (BetterRecyclerView) viewStub.inflate();
        this.f23895g.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f23895g.v = true;
        this.f23895g.setAdapter(this.f23896h);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 996360905);
        super.mY_();
        this.f23894f.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 692966500, a);
    }

    public final boolean O_() {
        if (this.f23894f.a.a == State.LOAD_FINISHED) {
            Serializable serializable;
            Intent intent = new Intent();
            String str = "topics";
            if (this.f23896h == null) {
                serializable = null;
            } else {
                serializable = ImmutableList.copyOf(this.f23896h.f23884e);
            }
            intent.putExtra(str, serializable);
            ao().setResult(-1, intent);
        } else {
            ao().setResult(0);
        }
        return false;
    }

    public static void ar(ComposerTopicSelectorFragment composerTopicSelectorFragment) {
        composerTopicSelectorFragment.f23894f.a();
        composerTopicSelectorFragment.f23892d.a(composerTopicSelectorFragment.f23897i, GraphQLCachePolicy.a, new C28972(composerTopicSelectorFragment));
    }

    public static void as(ComposerTopicSelectorFragment composerTopicSelectorFragment) {
        composerTopicSelectorFragment.f23894f.a(composerTopicSelectorFragment.jW_().getString(2131230811), composerTopicSelectorFragment.f23893e);
    }
}
