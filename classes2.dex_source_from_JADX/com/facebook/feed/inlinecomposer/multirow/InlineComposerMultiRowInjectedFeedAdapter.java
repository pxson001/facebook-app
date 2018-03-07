package com.facebook.feed.inlinecomposer.multirow;

import android.content.Context;
import android.view.View;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.util.StringUtil;
import com.facebook.common.viewport.BaseViewportEventListener;
import com.facebook.common.viewport.ViewportEventListener;
import com.facebook.content.event.FbEvent;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.controllercallbacks.fragment.ViewCreatedDestroyedCallbacks;
import com.facebook.feed.environment.HasInvalidate.InvalidateRunnable;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.inlinecomposer.abtest.WorkInlineComposerGateKeepers;
import com.facebook.feed.inlinecomposer.model.ComposerGroup;
import com.facebook.feed.inlinecomposer.model.InlineComposerModel;
import com.facebook.feed.inlinecomposer.model.InlineComposerModelBuilder;
import com.facebook.feed.inlinecomposer.model.WorkComposerModel;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerEnvironmentProvider;
import com.facebook.feed.photoreminder.model.PhotoReminderPromptObject;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowListViewAdapterWrapper;
import com.facebook.feed.rows.adapter.OneItemListItemCollection;
import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.feed.util.composer.launch.FeedComposerLauncher$ComposerConfigCustomizer;
import com.facebook.feed.util.composer.launch.FeedComposerLauncher$LauncherContext;
import com.facebook.feed.util.composer.launch.NewsfeedLauncherContext;
import com.facebook.feed.util.event.DataSetEvents$DataSetUpdatedEvent;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.FeedEventSubscriber;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.friendsharing.souvenirs.prompt.model.SouvenirPromptObject;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.productionprompts.abtest.ExperimentsForProductionPromptsAbtestModule;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.common.InlineComposerPromptHolder;
import com.facebook.productionprompts.common.InlineComposerPromptViewController;
import com.facebook.productionprompts.events.PromptsEventBus;
import com.facebook.productionprompts.events.PromptsInvalidateEvent;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.PromptViewState$Visibility;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.user.model.User;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.work.inlinecomposer.WorkComposerGroupsQuery;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: phone_display_number */
public class InlineComposerMultiRowInjectedFeedAdapter extends BaseViewportEventListener implements ViewportEventListener, ResumePauseCallbacks, ViewCreatedDestroyedCallbacks {
    private static final FeedComposerLauncher$ComposerConfigCustomizer f10164b = new C04271();
    @VisibleForTesting
    final OneItemListItemCollection<InlineComposerModel> f10165a = new OneItemListItemCollection();
    private final MultiRowAdapterBuilder f10166c;
    private final Lazy<InlineComposerRootGroupPartDefinition> f10167d;
    private final InlineComposerListItemComparator f10168e;
    private final Provider<InlineComposerPromptViewController> f10169f;
    private final InlineComposerEnvironmentProvider f10170g;
    public final Provider<InlineComposerPromptHolder> f10171h;
    public final int f10172i;
    private final Lazy<WorkComposerGroupsQuery> f10173j;
    private final WorkInlineComposerGateKeepers f10174k;
    private final Lazy<PromptsEventBus> f10175l;
    public final FeedEventBus f10176m;
    public final LoggedInUserSessionManager f10177n;
    private final QeAccessor f10178o;
    private final PromptsExperimentHelper f10179p;
    public final InvalidateRunnable f10180q;
    private final 2 f10181r;
    public Context f10182s;
    public FeedType f10183t;
    public FeedInlineComposerDataSetInvalidatedSubscriber f10184u;
    private boolean f10185v;

    /* compiled from: phone_display_number */
    final class C04271 implements FeedComposerLauncher$ComposerConfigCustomizer {
        C04271() {
        }

        public final void mo1984a(Builder builder) {
            builder.setAllowFeedOnlyPost(true).setAllowDynamicTextStyle(true);
        }
    }

    /* compiled from: phone_display_number */
    public class C05253 {
        final /* synthetic */ InlineComposerMultiRowInjectedFeedAdapter f12846a;

        C05253(InlineComposerMultiRowInjectedFeedAdapter inlineComposerMultiRowInjectedFeedAdapter) {
            this.f12846a = inlineComposerMultiRowInjectedFeedAdapter;
        }

        public final void m18898a(ImmutableList<ComposerGroup> immutableList) {
            InlineComposerModel inlineComposerModel = (InlineComposerModel) this.f12846a.f10165a.mo1375a(0);
            if (!immutableList.equals(inlineComposerModel.f12913h.f12922b)) {
                OneItemListItemCollection oneItemListItemCollection = this.f12846a.f10165a;
                InlineComposerModelBuilder inlineComposerModelBuilder = new InlineComposerModelBuilder(inlineComposerModel.f12906a, inlineComposerModel.f12907b);
                inlineComposerModelBuilder.f12894d = new WorkComposerModel(immutableList, this.f12846a.f10172i);
                oneItemListItemCollection.f10223a = inlineComposerModelBuilder.m18960a();
                this.f12846a.f10180q.run();
            }
        }
    }

    /* compiled from: phone_display_number */
    public class FeedInlineComposerDataSetInvalidatedSubscriber extends FeedEventSubscriber<DataSetEvents$DataSetUpdatedEvent> {
        final /* synthetic */ InlineComposerMultiRowInjectedFeedAdapter f13526a;

        public FeedInlineComposerDataSetInvalidatedSubscriber(InlineComposerMultiRowInjectedFeedAdapter inlineComposerMultiRowInjectedFeedAdapter) {
            this.f13526a = inlineComposerMultiRowInjectedFeedAdapter;
        }

        public final void mo650b(FbEvent fbEvent) {
            InlineComposerModel inlineComposerModel = (InlineComposerModel) this.f13526a.f10165a.mo1375a(0);
            String x = this.f13526a.f10177n.m2523c().m5856x();
            if (!inlineComposerModel.f12907b.equals(x) && !Strings.isNullOrEmpty(x)) {
                OneItemListItemCollection oneItemListItemCollection = this.f13526a.f10165a;
                InlineComposerModelBuilder inlineComposerModelBuilder = new InlineComposerModelBuilder(inlineComposerModel);
                inlineComposerModelBuilder.f12892b = x;
                oneItemListItemCollection.f10223a = inlineComposerModelBuilder.m18960a();
                this.f13526a.f10180q.run();
            }
        }

        public final Class<DataSetEvents$DataSetUpdatedEvent> mo648a() {
            return DataSetEvents$DataSetUpdatedEvent.class;
        }
    }

    private static InlineComposerMultiRowInjectedFeedAdapter m15264b(InjectorLike injectorLike) {
        return new InlineComposerMultiRowInjectedFeedAdapter(FeedRenderUtils.m14652a(injectorLike), MultiRowAdapterBuilder.m15276b(injectorLike), IdBasedLazy.m1808a(injectorLike, 1393), InlineComposerListItemComparator.m15303a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3137), (InlineComposerEnvironmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(InlineComposerEnvironmentProvider.class), IdBasedProvider.m1811a(injectorLike, 3136), IdBasedLazy.m1808a(injectorLike, 11779), WorkInlineComposerGateKeepers.m15308b(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3151), FeedEventBus.m4573a(injectorLike), LoggedInUserSessionManager.m2511a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), PromptsExperimentHelper.m15312b(injectorLike));
    }

    public static InlineComposerMultiRowInjectedFeedAdapter m15262a(InjectorLike injectorLike) {
        return m15264b(injectorLike);
    }

    @Inject
    public InlineComposerMultiRowInjectedFeedAdapter(FeedRenderUtils feedRenderUtils, MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<InlineComposerRootGroupPartDefinition> lazy, InlineComposerListItemComparator inlineComposerListItemComparator, Provider<InlineComposerPromptViewController> provider, InlineComposerEnvironmentProvider inlineComposerEnvironmentProvider, Provider<InlineComposerPromptHolder> provider2, Lazy<WorkComposerGroupsQuery> lazy2, WorkInlineComposerGateKeepers workInlineComposerGateKeepers, Lazy<PromptsEventBus> lazy3, FeedEventBus feedEventBus, LoggedInUserAuthDataStore loggedInUserAuthDataStore, QeAccessor qeAccessor, PromptsExperimentHelper promptsExperimentHelper) {
        this.f10172i = feedRenderUtils.m14654a();
        this.f10166c = multiRowAdapterBuilder;
        this.f10167d = lazy;
        this.f10168e = inlineComposerListItemComparator;
        this.f10169f = provider;
        this.f10170g = inlineComposerEnvironmentProvider;
        this.f10171h = provider2;
        this.f10173j = lazy2;
        this.f10174k = workInlineComposerGateKeepers;
        this.f10175l = lazy3;
        this.f10176m = feedEventBus;
        this.f10177n = loggedInUserAuthDataStore;
        this.f10178o = qeAccessor;
        this.f10179p = promptsExperimentHelper;
        this.f10185v = false;
        this.f10180q = new InvalidateRunnable();
        this.f10181r = new 2(this);
    }

    public final FbListAdapter m15270b() {
        FeedComposerLauncher$LauncherContext newsfeedLauncherContext;
        FeedComposerLauncher$LauncherContext feedComposerLauncher$LauncherContext;
        ((InlineComposerPromptHolder) this.f10171h.get()).f12583x = this.f10181r;
        if (this.f10174k.m15310b()) {
            m15266g();
        }
        if (Name.f5048c.equals(this.f10183t.f5044g)) {
            newsfeedLauncherContext = new NewsfeedLauncherContext("goodFriends");
            feedComposerLauncher$LauncherContext = newsfeedLauncherContext;
        } else {
            newsfeedLauncherContext = new NewsfeedLauncherContext("feed_inline");
            feedComposerLauncher$LauncherContext = new NewsfeedLauncherContext("feed_inline_button");
        }
        AnyEnvironment a = InlineComposerEnvironmentProvider.m15306a(this.f10180q, newsfeedLauncherContext, f10164b, feedComposerLauncher$LauncherContext, this.f10182s, HasScrollListenerSupportImpl.f12259b, (PromptViewStateUpdater) this.f10171h.get());
        MultiRowAdapterBuilder.Builder a2 = this.f10166c.m15277a(this.f10167d, this.f10165a);
        a2.f12879f = a;
        MultiRowAdapterBuilder.Builder builder = a2;
        builder.f12878e = this.f10168e;
        builder = builder.m18956a("InlineComposerAdapter");
        this.f10165a.f10223a = m15265e();
        FbListAdapter multiRowListViewAdapterWrapper = new MultiRowListViewAdapterWrapper(builder.m18958d());
        this.f10180q.f10224a = multiRowListViewAdapterWrapper;
        this.f10184u = new FeedInlineComposerDataSetInvalidatedSubscriber(this);
        this.f10176m.m4568a(this.f10184u);
        if (this.f10171h != null) {
            InlineComposerPromptHolder inlineComposerPromptHolder = (InlineComposerPromptHolder) this.f10171h.get();
            if (inlineComposerPromptHolder.f12562c.mo2490a()) {
                inlineComposerPromptHolder.f12569j.m4568a(inlineComposerPromptHolder.f12572m);
                inlineComposerPromptHolder.f12569j.m4568a(inlineComposerPromptHolder.f12573n);
                inlineComposerPromptHolder.f12569j.m4568a(inlineComposerPromptHolder.f12574o);
                inlineComposerPromptHolder.f12569j.m4568a(inlineComposerPromptHolder.f12575p);
            }
        }
        return multiRowListViewAdapterWrapper;
    }

    private InlineComposerModel m15265e() {
        User c = this.f10177n.m2523c();
        InlineComposerModelBuilder inlineComposerModelBuilder = new InlineComposerModelBuilder(c.f3598a, c.m5856x());
        inlineComposerModelBuilder.f12896f = this.f10182s.getString(2131234839);
        InlineComposerModelBuilder inlineComposerModelBuilder2 = inlineComposerModelBuilder;
        inlineComposerModelBuilder2.f12897g = this.f10182s.getString(2131234840);
        inlineComposerModelBuilder2 = inlineComposerModelBuilder2;
        inlineComposerModelBuilder2.f12898h = this.f10182s.getString(2131234841);
        inlineComposerModelBuilder2 = inlineComposerModelBuilder2;
        inlineComposerModelBuilder2.f12895e = 2130842656;
        inlineComposerModelBuilder = inlineComposerModelBuilder2;
        inlineComposerModelBuilder.f12899i = this.f10178o.mo581a(ExperimentsForFeedUtilComposerAbtestModule.ag, this.f10182s.getString(2131234528));
        if (this.f10183t.f5044g.equals(Name.f5056k)) {
            inlineComposerModelBuilder.f12900j = false;
            GraphQLExploreFeed graphQLExploreFeed = (GraphQLExploreFeed) this.f10183t.f5043f;
            if (graphQLExploreFeed != null) {
                if (!StringUtil.m3599c(graphQLExploreFeed.G())) {
                    inlineComposerModelBuilder.f12899i = graphQLExploreFeed.G();
                }
                inlineComposerModelBuilder.f12905o = graphQLExploreFeed;
            }
        }
        if (this.f10183t.f5044g.equals(Name.f5048c)) {
            inlineComposerModelBuilder.f12899i = this.f10182s.getString(2131238313);
            inlineComposerModelBuilder2 = inlineComposerModelBuilder;
            inlineComposerModelBuilder2.f12903m = true;
            inlineComposerModelBuilder2.f12900j = false;
        }
        if (this.f10178o.mo596a(ExperimentsForFeedUtilComposerAbtestModule.aa, false)) {
            inlineComposerModelBuilder.f12898h = this.f10182s.getString(2131234520);
            inlineComposerModelBuilder2 = inlineComposerModelBuilder;
            inlineComposerModelBuilder2.f12895e = 2130839966;
            inlineComposerModelBuilder2.f12904n = true;
        }
        return inlineComposerModelBuilder.m18960a();
    }

    public final void mo1970a(Object obj) {
        if ((obj instanceof BoundedAdapter) && (((BoundedAdapter) obj).f13446a.f12957b instanceof InlineComposerModel)) {
            ((InlineComposerPromptViewController) this.f10169f.get()).mo2614a(this.f10185v, ((InlineComposerModel) ((BoundedAdapter) obj).f13446a.f12957b).f12908c);
            this.f10185v = true;
        }
    }

    public final void mo1973b(Object obj) {
        if (!this.f10179p.f10219a.mo596a(ExperimentsForProductionPromptsAbtestModule.f13415d, false) && (obj instanceof BoundedAdapter) && (((BoundedAdapter) obj).f13446a.f12957b instanceof InlineComposerModel)) {
            InlineComposerModel inlineComposerModel = (InlineComposerModel) ((BoundedAdapter) obj).f13446a.f12957b;
            ((InlineComposerPromptViewController) this.f10169f.get()).mo2613a(inlineComposerModel.f12908c);
            if (inlineComposerModel.f12909d) {
                if (m15263a(inlineComposerModel)) {
                    InlineComposerPromptHolder inlineComposerPromptHolder = (InlineComposerPromptHolder) this.f10171h.get();
                    inlineComposerPromptHolder.f12561a = null;
                    inlineComposerPromptHolder.f12583x.a(null);
                }
                ((InlineComposerPromptHolder) this.f10171h.get()).m18657a(!m15263a((InlineComposerModel) this.f10165a.mo1375a(0)), "on_exit_viewport");
            }
            if (this.f10174k.m15310b()) {
                ((WorkComposerGroupsQuery) this.f10173j.get()).b();
            }
        }
    }

    public final void mo1971b(ScrollingViewProxy scrollingViewProxy) {
        this.f10185v = false;
    }

    public final void mo1264c() {
        if (this.f10165a.mo1374a() != 0) {
            if (this.f10171h != null && ((InlineComposerModel) this.f10165a.mo1375a(0)).f12909d) {
                ((InlineComposerPromptHolder) this.f10171h.get()).m18657a(false, "on_resume");
            }
            m15267h();
        }
    }

    public final void mo1265d() {
        int i = 0;
        if (this.f10165a.mo1374a() != 0) {
            InlineComposerPromptSession inlineComposerPromptSession = ((InlineComposerModel) this.f10165a.mo1375a(0)).f12908c;
            if (inlineComposerPromptSession != null) {
                ImmutableList of = ImmutableList.of(PhotoReminderPromptObject.class, SouvenirPromptObject.class);
                int size = of.size();
                while (i < size) {
                    Class cls = (Class) of.get(i);
                    if (cls.isInstance(inlineComposerPromptSession.f13409a)) {
                        ((PromptsEventBus) this.f10175l.get()).mo651a(new PromptsInvalidateEvent(cls));
                        return;
                    }
                    i++;
                }
            }
        }
    }

    public final void mo1886a(View view) {
    }

    public final void kG_() {
        this.f10176m.m4569b(this.f10184u);
        if (this.f10171h != null) {
            InlineComposerPromptHolder inlineComposerPromptHolder = (InlineComposerPromptHolder) this.f10171h.get();
            if (inlineComposerPromptHolder.f12562c.mo2490a()) {
                inlineComposerPromptHolder.f12579t.mo476d(9633793);
                inlineComposerPromptHolder.f12569j.m4569b(inlineComposerPromptHolder.f12572m);
                inlineComposerPromptHolder.f12569j.m4569b(inlineComposerPromptHolder.f12573n);
                inlineComposerPromptHolder.f12569j.m4569b(inlineComposerPromptHolder.f12574o);
                inlineComposerPromptHolder.f12569j.m4569b(inlineComposerPromptHolder.f12575p);
            }
        }
    }

    private void m15266g() {
        ((WorkComposerGroupsQuery) this.f10173j.get()).c = new C05253(this);
        m15267h();
    }

    private void m15267h() {
        if (this.f10174k.m15310b()) {
            ((WorkComposerGroupsQuery) this.f10173j.get()).a();
        }
    }

    private boolean m15263a(InlineComposerModel inlineComposerModel) {
        return (!this.f10179p.m15314c() || inlineComposerModel == null || inlineComposerModel.f12908c == null || inlineComposerModel.f12908c.f13411c == null || inlineComposerModel.f12908c.f13411c.a != PromptViewState$Visibility.DISMISSED) ? false : true;
    }
}
