package com.facebook.looknow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.common.util.FindViewUtil;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.ui.basefeedfragment.BaseFeedFragment;
import com.facebook.feedplugins.customizedstory.CustomizedStoryRootPartDefinition;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.looknow.LookNowAnalyticsLogger.Events;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.LayoutManagerWithKeepAttachedHack;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: vault_sync_mode */
public class LookNowPermalinkFragment extends BaseFeedFragment {
    @Inject
    Lazy<CustomizedStoryRootPartDefinition> f252a;
    public MultiRowAdapter al;
    public LoadingIndicatorView am;
    @Inject
    MultiRowAdapterBuilder f253b;
    @Inject
    LookNowPermalinkEnvironmentProvider f254c;
    @Inject
    MultipleRowsStoriesRecycleCallback f255d;
    @Inject
    LookNowPromoProtocol f256e;
    @Inject
    Lazy<ReactionSessionManager> f257f;
    @Inject
    Lazy<ComposerPublishServiceHelper> f258g;
    @Inject
    public LookNowAnalyticsLogger f259h;
    private ScrollingViewProxy f260i;

    /* compiled from: vault_sync_mode */
    public class C00421 {
        public final /* synthetic */ LookNowPermalinkFragment f250a;

        C00421(LookNowPermalinkFragment lookNowPermalinkFragment) {
            this.f250a = lookNowPermalinkFragment;
        }

        public final void m280a(boolean z) {
            if (z) {
                this.f250a.am.a();
            } else if (LookNowPermalinkFragment.at(this.f250a).v()) {
                this.f250a.f259h.m276a(Events.LOOK_NOW_PERMALINK_LOAD_FAILURE, "no_story");
                this.f250a.am.a(this.f250a.b(2131242231), null);
            } else {
                this.f250a.f259h.m275a(Events.LOOK_NOW_PERMALINK_LOAD_SUCCESS);
                this.f250a.am.b();
                LookNowPermalinkFragment.m283b(this.f250a).notifyDataSetChanged();
            }
        }
    }

    /* compiled from: vault_sync_mode */
    class C00432 implements Runnable {
        final /* synthetic */ LookNowPermalinkFragment f251a;

        C00432(LookNowPermalinkFragment lookNowPermalinkFragment) {
            this.f251a = lookNowPermalinkFragment;
        }

        public void run() {
            this.f251a.al.notifyDataSetChanged();
        }
    }

    public static void m282a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((LookNowPermalinkFragment) obj).m281a(IdBasedLazy.a(injectorLike, 1845), MultiRowAdapterBuilder.b(injectorLike), (LookNowPermalinkEnvironmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LookNowPermalinkEnvironmentProvider.class), MultipleRowsStoriesRecycleCallback.a(injectorLike), LookNowPromoProtocol.m292b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 9836), IdBasedLazy.a(injectorLike, 5272), LookNowAnalyticsLogger.m273a(injectorLike));
    }

    public final void m287c(Bundle bundle) {
        Class cls = LookNowPermalinkFragment.class;
        m282a(this, getContext());
        super.c(bundle);
    }

    public final View m285a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 429279713);
        View inflate = layoutInflater.inflate(2130905148, viewGroup, false);
        BetterRecyclerView betterRecyclerView = (BetterRecyclerView) FindViewUtil.b(inflate, 2131563649);
        betterRecyclerView.setLayoutManager(new LayoutManagerWithKeepAttachedHack(betterRecyclerView));
        this.f260i = new RecyclerViewProxy(betterRecyclerView);
        this.f260i.a(m283b(this));
        this.f260i.a(this.f255d.a());
        this.am = (LoadingIndicatorView) inflate.findViewById(2131560537);
        this.f256e.f269g = (C00421) Preconditions.checkNotNull(new C00421(this));
        this.f259h.m275a(Events.LOOK_NOW_PERMALINK_OPENED);
        this.f256e.m293a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1607070437, a);
        return inflate;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1124179858);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131242229);
            hasTitleBar.c(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1617857416, a);
    }

    public final void m286a(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 1756) {
            ((ComposerPublishServiceHelper) this.f258g.get()).c(intent);
            ((ReactionSessionManager) this.f257f.get()).a(((PublishPostParams) intent.getParcelableExtra("publishPostParams")).composerSessionId, this);
        }
    }

    public final void m288e() {
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -347577786);
        super.mY_();
        if (this.al != null) {
            this.al.jc_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -645700082, a);
    }

    public final void m284I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1227769758);
        super.I();
        if (this.al != null) {
            this.al.jc_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 271185600, a);
    }

    public static MultiRowAdapter m283b(LookNowPermalinkFragment lookNowPermalinkFragment) {
        if (lookNowPermalinkFragment.al == null) {
            LookNowPermalinkEnvironmentProvider lookNowPermalinkEnvironmentProvider = lookNowPermalinkFragment.f254c;
            AnyEnvironment lookNowPermalinkEnvironment = new LookNowPermalinkEnvironment((Context) lookNowPermalinkEnvironmentProvider.getInstance(Context.class), LookNowPermalinkFeedListType.f249a, new C00432(lookNowPermalinkFragment));
            Builder a = lookNowPermalinkFragment.f253b.a(lookNowPermalinkFragment.f252a, at(lookNowPermalinkFragment));
            a.f = lookNowPermalinkEnvironment;
            lookNowPermalinkFragment.al = a.e();
        }
        return lookNowPermalinkFragment.al;
    }

    private void m281a(Lazy<CustomizedStoryRootPartDefinition> lazy, MultiRowAdapterBuilder multiRowAdapterBuilder, LookNowPermalinkEnvironmentProvider lookNowPermalinkEnvironmentProvider, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, LookNowPromoProtocol lookNowPromoProtocol, Lazy<ReactionSessionManager> lazy2, Lazy<ComposerPublishServiceHelper> lazy3, LookNowAnalyticsLogger lookNowAnalyticsLogger) {
        this.f252a = lazy;
        this.f253b = multiRowAdapterBuilder;
        this.f254c = lookNowPermalinkEnvironmentProvider;
        this.f255d = multipleRowsStoriesRecycleCallback;
        this.f256e = lookNowPromoProtocol;
        this.f257f = lazy2;
        this.f258g = lazy3;
        this.f259h = lookNowAnalyticsLogger;
    }

    public static FeedUnitCollection at(LookNowPermalinkFragment lookNowPermalinkFragment) {
        return lookNowPermalinkFragment.f256e.f266d;
    }
}
