package com.facebook.feedplugins.share;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.ClipboardUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.ComposerPublishServiceHelper.PublishLogger;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.common.PublishPostParams.Builder;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.popover.PopoverWindow.OnCancelListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.feed.analytics.NewsfeedAnalyticsLogger;
import com.facebook.feed.annotations.FeedGatekeepers;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.ui.abtest.ExperimentsForFeedUIAbTestModule;
import com.facebook.feed.util.composer.OptimisticPostStoryBuilder;
import com.facebook.feed.util.composer.OptimisticPostStoryBuilderProvider;
import com.facebook.feedplugins.base.abtest.ExperimentsForBlingBarABTestModule;
import com.facebook.feedplugins.base.abtest.ShareSheetVariantsExperimentUtil;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StorySharingHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.infer.annotation.Assertions;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.OptimisticPostPrivacy;
import com.facebook.messaging.appspecific.AppGlyphResolver;
import com.facebook.messaging.sharing.sendasmessage.SendAsMessageUtil;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.service.cache.PrivacyOptionsCache;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.ui.errordialog.ErrorMessageGenerator;
import com.facebook.ui.toaster.ToastThreadUtil;
import com.facebook.user.model.User;
import com.facebook.zero.onboarding.experiments.ExperimentsForAssistedOnboardingAbTestModule;
import com.facebook.zero.onboarding.experiments.ShareExternalExperimentUtils;
import com.facebook.zero.onboarding.experiments.ShareExternalUtils;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: removal_count */
public class ShareMenuPopoverFactory {
    private static volatile ShareMenuPopoverFactory f5332q;
    public final Lazy<SendAsMessageUtil> f5333a;
    public final NewsfeedAnalyticsLogger f5334b;
    public final Provider<ViewerContext> f5335c;
    private final GraphQLStoryUtil f5336d;
    public final Provider<ComposerPublishServiceHelper> f5337e;
    public final Lazy<ErrorMessageGenerator> f5338f;
    private final PrivacyOptionsCache f5339g;
    public final Lazy<ToastThreadUtil> f5340h;
    public final ShareExternalUtils f5341i;
    private final ShareSheetVariantsExperimentUtil f5342j;
    private final OptimisticPostStoryBuilderProvider f5343k;
    private final Provider<User> f5344l;
    public final Clock f5345m;
    public final QeAccessor f5346n;
    public final boolean f5347o;
    private final ShareExternalExperimentUtils f5348p;

    /* compiled from: removal_count */
    public interface WritePostOnClickCallback {
        void mo282a(String str);
    }

    /* compiled from: removal_count */
    public interface OnPopoverDismissCallback {
        void mo283a();
    }

    /* compiled from: removal_count */
    /* synthetic */ class C05247 {
        static final /* synthetic */ int[] f5325a = new int[GraphQLPrivacyOptionType.values().length];

        static {
            f5326b = new int[ShareMenuItemType.values().length];
            try {
                f5326b[ShareMenuItemType.SHARE_NOW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5326b[ShareMenuItemType.WRITE_POST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5326b[ShareMenuItemType.SEND_AS_MESSAGE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5326b[ShareMenuItemType.SHARE_EXTERNAL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5326b[ShareMenuItemType.COPY_LINK.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5325a[GraphQLPrivacyOptionType.EVERYONE.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f5325a[GraphQLPrivacyOptionType.FRIENDS.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* compiled from: removal_count */
    class ShareMenuItem {
        ShareMenuItemType f5327a;
        String f5328b;
        int f5329c;
        int f5330d;
        int f5331e;

        public ShareMenuItem(ShareMenuItemType shareMenuItemType, int i, int i2, int i3) {
            this.f5327a = shareMenuItemType;
            this.f5329c = i;
            this.f5330d = i2;
            this.f5331e = i3;
        }

        public final MenuItemImpl m5772a(PopoverMenu popoverMenu) {
            MenuItemImpl a;
            if (this.f5329c != 0) {
                a = popoverMenu.a(this.f5331e, this.f5331e, this.f5329c);
            } else {
                a = new MenuItemImpl(popoverMenu, this.f5331e, this.f5331e, this.f5328b);
                popoverMenu.a(a);
            }
            if (this.f5330d != 0) {
                a.setIcon(this.f5330d);
            }
            return a;
        }
    }

    /* compiled from: removal_count */
    enum ShareMenuItemType {
        SHARE_NOW,
        WRITE_POST,
        SEND_AS_MESSAGE,
        SHARE_EXTERNAL,
        COPY_LINK,
        CONTACT_SHARE
    }

    public static com.facebook.feedplugins.share.ShareMenuPopoverFactory m5773a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f5332q;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.share.ShareMenuPopoverFactory.class;
        monitor-enter(r1);
        r0 = f5332q;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m5781b(r0);	 Catch:{ all -> 0x0035 }
        f5332q = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5332q;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.share.ShareMenuPopoverFactory.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.share.ShareMenuPopoverFactory");
    }

    private static ShareMenuPopoverFactory m5781b(InjectorLike injectorLike) {
        return new ShareMenuPopoverFactory(GraphQLStoryUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 5272), IdBasedLazy.a(injectorLike, 3560), PrivacyOptionsCache.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 8437), NewsfeedAnalyticsLogger.a(injectorLike), IdBasedProvider.a(injectorLike, 372), IdBasedLazy.a(injectorLike, 11511), ShareExternalUtils.m20248a(injectorLike), ShareExternalExperimentUtils.m20244a(injectorLike), ShareSheetVariantsExperimentUtil.m5667a(injectorLike), (OptimisticPostStoryBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(OptimisticPostStoryBuilderProvider.class), IdBasedProvider.a(injectorLike, 3595), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    private void m5784c(PopoverMenu popoverMenu, ShareMenuItem shareMenuItem, FeedProps<GraphQLStory> feedProps, View view, String str, String str2) {
        final GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        MenuItemImpl a = shareMenuItem.m5772a(popoverMenu);
        final FeedProps<GraphQLStory> feedProps2 = feedProps;
        final String str3 = str;
        final String str4 = str2;
        final View view2 = view;
        a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShareMenuPopoverFactory f5319f;

            public boolean onMenuItemClick(MenuItem menuItem) {
                String q = GraphQLStoryUtil.q(GraphQLStoryUtil.p(feedProps2));
                this.f5319f.f5334b.g(str3, ((GraphQLStory) GraphQLStoryUtil.o(feedProps2).a).c(), ((ViewerContext) this.f5319f.f5335c.get()).mUserId, StorySharingHelper.a(graphQLStory), str4);
                ClipboardUtil.a(view2.getContext(), q);
                ((ToastThreadUtil) this.f5319f.f5340h.get()).a(view2.getContext().getString(2131232721));
                return true;
            }
        });
        if (this.f5342j.m5669b()) {
            CharSequence h = this.f5342j.m5673h();
            if (!StringUtil.a(h)) {
                a.a(h);
            }
        }
    }

    @Inject
    public ShareMenuPopoverFactory(GraphQLStoryUtil graphQLStoryUtil, Provider<ComposerPublishServiceHelper> provider, Lazy<ErrorMessageGenerator> lazy, PrivacyOptionsCache privacyOptionsCache, Lazy<SendAsMessageUtil> lazy2, NewsfeedAnalyticsLogger newsfeedAnalyticsLogger, Provider<ViewerContext> provider2, Lazy<ToastThreadUtil> lazy3, ShareExternalUtils shareExternalUtils, ShareExternalExperimentUtils shareExternalExperimentUtils, ShareSheetVariantsExperimentUtil shareSheetVariantsExperimentUtil, OptimisticPostStoryBuilderProvider optimisticPostStoryBuilderProvider, Provider<User> provider3, Clock clock, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore) {
        this.f5336d = graphQLStoryUtil;
        this.f5337e = provider;
        this.f5338f = lazy;
        this.f5339g = privacyOptionsCache;
        this.f5333a = lazy2;
        this.f5334b = newsfeedAnalyticsLogger;
        this.f5335c = provider2;
        this.f5340h = lazy3;
        this.f5342j = shareSheetVariantsExperimentUtil;
        this.f5343k = optimisticPostStoryBuilderProvider;
        this.f5344l = provider3;
        this.f5345m = clock;
        this.f5346n = qeAccessor;
        this.f5341i = shareExternalUtils;
        this.f5347o = gatekeeperStore.a(FeedGatekeepers.a, false);
        this.f5348p = shareExternalExperimentUtils;
    }

    private boolean m5780a(GraphQLStory graphQLStory) {
        GraphQLFeedback l = graphQLStory.l();
        if ((l != null && l.O() != null) || ((ViewerContext) this.f5335c.get()).mIsPageContext) {
            return false;
        }
        GraphQLPrivacyOption a = this.f5339g.a();
        if (a != null) {
            switch (C05247.f5325a[PrivacyOptionHelper.a(a).ordinal()]) {
                case 1:
                case 2:
                    return true;
            }
        }
        return false;
    }

    private void m5779a(PopoverMenu popoverMenu, ShareMenuItem shareMenuItem, FeedProps<GraphQLStory> feedProps, String str, String str2, Activity activity, ComposerSourceType composerSourceType) {
        final GraphQLStory graphQLStory = (GraphQLStory) feedProps.a();
        if (m5780a(graphQLStory)) {
            final GraphQLPrivacyOption a = this.f5339g.a();
            MenuItemImpl a2 = shareMenuItem.m5772a(popoverMenu);
            final FeedProps<GraphQLStory> feedProps2 = feedProps;
            final String str3 = str;
            final String str4 = str2;
            final ComposerSourceType composerSourceType2 = composerSourceType;
            final Activity activity2 = activity;
            final PopoverMenu popoverMenu2 = popoverMenu;
            a2.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ ShareMenuPopoverFactory f5298i;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    boolean z;
                    final GraphQLStory graphQLStory = (GraphQLStory) GraphQLStoryUtil.o(feedProps2).a();
                    if (PrivacyOptionHelper.a(a) == GraphQLPrivacyOptionType.EVERYONE) {
                        this.f5298i.f5334b.b(str3, graphQLStory.c(), ((ViewerContext) this.f5298i.f5335c.get()).a(), StorySharingHelper.a(graphQLStory), str4);
                    } else if (PrivacyOptionHelper.a(a) == GraphQLPrivacyOptionType.FRIENDS) {
                        this.f5298i.f5334b.c(str3, graphQLStory.c(), ((ViewerContext) this.f5298i.f5335c.get()).a(), StorySharingHelper.a(graphQLStory), str4);
                    }
                    boolean z2;
                    if (composerSourceType2 == ComposerSourceType.FEED) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    long parseLong = Long.parseLong(((ViewerContext) this.f5298i.f5335c.get()).a());
                    Builder builder = new Builder();
                    if (PrivacyOptionHelper.a(GraphQLStoryHelper.c(graphQLStory))) {
                        builder.X = true;
                    }
                    FeedProps b = StoryProps.b(feedProps2);
                    if (b == null) {
                        b = feedProps2;
                    }
                    FeedbackLoggingParams.Builder newBuilder = FeedbackLoggingParams.newBuilder();
                    newBuilder.a = TrackableFeedProps.a(b);
                    this.f5298i.f5334b.a((FeedUnit) b.a(), newBuilder);
                    ArrayNode b2 = JSONUtil.b(newBuilder.a().e());
                    builder = builder.d(this.f5298i.f5345m.a() / 1000).a(parseLong).c(parseLong);
                    builder.k = graphQLStory.av();
                    builder = builder;
                    builder.l = b2.toString();
                    Builder builder2 = builder;
                    builder2.g = a.c();
                    builder2 = builder2;
                    builder2.G = str4;
                    builder = builder2;
                    if (this.f5298i.f5347o && r1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    builder.ak = z;
                    PublishPostParams a = builder.a();
                    Intent intent = new Intent();
                    intent.putExtra("publishPostParams", a);
                    if (this.f5298i.f5346n.a(ExperimentsForFeedUIAbTestModule.f3777a, false)) {
                        intent.putExtra("extra_optimistic_feed_story", ShareMenuPopoverFactory.m5774a(this.f5298i, str4, parseLong, graphQLStory));
                    }
                    ComposerPublishServiceHelper composerPublishServiceHelper = (ComposerPublishServiceHelper) this.f5298i.f5337e.get();
                    composerPublishServiceHelper.s = activity2;
                    composerPublishServiceHelper.a(intent, new PublishLogger(this) {
                        final /* synthetic */ C05181 f5289b;

                        public final void m5767a(PublishPostParams publishPostParams) {
                            this.f5289b.f5298i.f5334b.d(str3, graphQLStory.c(), ((ViewerContext) this.f5289b.f5298i.f5335c.get()).mUserId, StorySharingHelper.a(graphQLStory), str4);
                        }

                        public final void m5770b(PublishPostParams publishPostParams) {
                        }

                        public final void m5768a(String str, PublishPostParams publishPostParams) {
                            this.f5289b.f5298i.f5334b.b(str3, graphQLStory.c(), ((ViewerContext) this.f5289b.f5298i.f5335c.get()).mUserId, StorySharingHelper.a(graphQLStory), str4, TrackableFeedProps.a(feedProps2));
                        }

                        public final void m5769a(String str, PublishPostParams publishPostParams, ServiceException serviceException) {
                            this.f5289b.f5298i.f5334b.a(str3, graphQLStory.c(), ((ViewerContext) this.f5289b.f5298i.f5335c.get()).mUserId, StorySharingHelper.a(graphQLStory), str4, ((ErrorMessageGenerator) this.f5289b.f5298i.f5338f.get()).a(serviceException, false, false));
                        }
                    });
                    ((ToastThreadUtil) this.f5298i.f5340h.get()).a(popoverMenu2.a().getString(2131234541));
                    return true;
                }
            });
            if (PrivacyOptionHelper.a(a) == GraphQLPrivacyOptionType.EVERYONE) {
                a2.a(2131232715);
            } else if (PrivacyOptionHelper.a(a) == GraphQLPrivacyOptionType.FRIENDS) {
                a2.a(2131232716);
            }
        }
    }

    public static GraphQLStory m5774a(ShareMenuPopoverFactory shareMenuPopoverFactory, String str, long j, GraphQLStory graphQLStory) {
        OptimisticPostStoryBuilder a = shareMenuPopoverFactory.f5343k.m4479a(new GraphQLTextWithEntities.Builder().a(), RegularImmutableList.a, RegularImmutableList.a).m4477a((User) shareMenuPopoverFactory.f5344l.get());
        a.f3832u = j;
        a = a;
        a.f3830s = graphQLStory;
        a = a;
        a.f3826o = str;
        a = a;
        a.f3834w = OptimisticPostPrivacy.a;
        return a.m4478a();
    }

    private void m5778a(PopoverMenu popoverMenu, ShareMenuItem shareMenuItem, FeedProps<GraphQLStory> feedProps, WritePostOnClickCallback writePostOnClickCallback, String str, String str2) {
        MenuItemImpl a = shareMenuItem.m5772a(popoverMenu);
        final FeedProps<GraphQLStory> feedProps2 = feedProps;
        final String str3 = str;
        final String str4 = str2;
        final WritePostOnClickCallback writePostOnClickCallback2 = writePostOnClickCallback;
        a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShareMenuPopoverFactory f5303e;

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f5303e.f5334b.e(str3, ((GraphQLStory) GraphQLStoryUtil.o(feedProps2).a).c(), ((ViewerContext) this.f5303e.f5335c.get()).mUserId, StorySharingHelper.a((GraphQLStory) feedProps2.a), str4);
                writePostOnClickCallback2.mo282a(str4);
                return true;
            }
        });
        if (this.f5342j.m5669b()) {
            CharSequence f = this.f5342j.m5671f();
            if (!StringUtil.a(f)) {
                a.a(f);
            }
        }
    }

    private void m5777a(PopoverMenu popoverMenu, ShareMenuItem shareMenuItem, FeedProps<GraphQLStory> feedProps, View view, String str, String str2) {
        if (this.f5336d.u((GraphQLStory) feedProps.a)) {
            MenuItemImpl a = shareMenuItem.m5772a(popoverMenu);
            final String str3 = str;
            final FeedProps<GraphQLStory> feedProps2 = feedProps;
            final String str4 = str2;
            final View view2 = view;
            a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ ShareMenuPopoverFactory f5308e;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    ShareMenuPopoverFactory shareMenuPopoverFactory = this.f5308e;
                    String str = str3;
                    FeedProps feedProps = feedProps2;
                    String str2 = str4;
                    View view = view2;
                    GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
                    shareMenuPopoverFactory.f5334b.f(str, ((GraphQLStory) GraphQLStoryUtil.o(feedProps).a).c(), ((ViewerContext) shareMenuPopoverFactory.f5335c.get()).mUserId, StorySharingHelper.a(graphQLStory), str2);
                    ((SendAsMessageUtil) shareMenuPopoverFactory.f5333a.get()).m9498a(feedProps, view.getContext(), true, "footer_share_popover_menu");
                    return true;
                }
            });
            if (this.f5342j.m5669b()) {
                CharSequence g = this.f5342j.m5672g();
                if (!StringUtil.a(g)) {
                    a.a(g);
                }
            }
        }
    }

    private void m5783b(PopoverMenu popoverMenu, ShareMenuItem shareMenuItem, FeedProps<GraphQLStory> feedProps, View view, String str, String str2) {
        MenuItemImpl a = shareMenuItem.m5772a(popoverMenu);
        a.a(2131233510);
        final FeedProps<GraphQLStory> feedProps2 = feedProps;
        final String str3 = str;
        final String str4 = str2;
        final View view2 = view;
        a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShareMenuPopoverFactory f5313e;

            public boolean onMenuItemClick(MenuItem menuItem) {
                this.f5313e.f5334b.h(str3, ((GraphQLStory) GraphQLStoryUtil.o(feedProps2).a).c(), ((ViewerContext) this.f5313e.f5335c.get()).mUserId, StorySharingHelper.a((GraphQLStory) feedProps2.a), str4);
                this.f5313e.f5341i.m20250a(view2.getContext(), GraphQLStoryUtil.q(GraphQLStoryUtil.p(feedProps2)) + "&ref=fb4aextshare");
                return true;
            }
        });
    }

    public final PopoverMenuWindow m5785a(FeedProps<GraphQLStory> feedProps, View view, String str, WritePostOnClickCallback writePostOnClickCallback, @Nullable OnPopoverDismissCallback onPopoverDismissCallback, ComposerSourceType composerSourceType) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a();
        if (!StorySharingHelper.b(graphQLStory)) {
            return null;
        }
        boolean b = this.f5342j.m5669b();
        if (this.f5342j.m5668a()) {
            return null;
        }
        ImmutableList a;
        boolean c = this.f5342j.m5670c();
        boolean a2 = PrivacyOptionHelper.a(GraphQLStoryHelper.c(graphQLStory));
        if (b) {
            a = m5775a();
        } else if (c || !this.f5348p.m20247a()) {
            a = m5776a(a2);
        } else {
            a = m5782b(a2);
        }
        final String uuid = SafeUUIDGenerator.a().toString();
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(view.getContext());
        figPopoverMenuWindow.c(view);
        figPopoverMenuWindow.a(true);
        figPopoverMenuWindow.a(Position.ABOVE);
        final FeedProps<GraphQLStory> feedProps2 = feedProps;
        final String str2 = str;
        final OnPopoverDismissCallback onPopoverDismissCallback2 = onPopoverDismissCallback;
        figPopoverMenuWindow.a(new OnCancelListener(this) {
            final /* synthetic */ ShareMenuPopoverFactory f5324e;

            public final boolean m5771a() {
                ShareMenuPopoverFactory shareMenuPopoverFactory = this.f5324e;
                String str = uuid;
                FeedProps feedProps = feedProps2;
                String str2 = str2;
                OnPopoverDismissCallback onPopoverDismissCallback = onPopoverDismissCallback2;
                String str3 = str2;
                String str4 = str;
                shareMenuPopoverFactory.f5334b.a(str3, ((GraphQLStory) GraphQLStoryUtil.o(feedProps).a).c(), ((ViewerContext) shareMenuPopoverFactory.f5335c.get()).mUserId, StorySharingHelper.a((GraphQLStory) feedProps.a), str4, TrackableFeedProps.a(feedProps));
                if (onPopoverDismissCallback != null) {
                    onPopoverDismissCallback.mo283a();
                }
                return false;
            }
        });
        PopoverMenu c2 = figPopoverMenuWindow.c();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ShareMenuItem shareMenuItem = (ShareMenuItem) a.get(i);
            switch (shareMenuItem.f5327a) {
                case SHARE_NOW:
                    Activity activity = (Activity) ContextUtils.a(view.getContext(), Activity.class);
                    Assertions.b(activity);
                    m5779a(c2, shareMenuItem, feedProps, str, uuid, activity, composerSourceType);
                    break;
                case WRITE_POST:
                    m5778a(c2, shareMenuItem, (FeedProps) feedProps, writePostOnClickCallback, str, uuid);
                    break;
                case SEND_AS_MESSAGE:
                    m5777a(c2, shareMenuItem, (FeedProps) feedProps, view, str, uuid);
                    break;
                case SHARE_EXTERNAL:
                    m5783b(c2, shareMenuItem, feedProps, view, str, uuid);
                    break;
                case COPY_LINK:
                    m5784c(c2, shareMenuItem, feedProps, view, str, uuid);
                    break;
                default:
                    break;
            }
        }
        if (c2.getCount() < 2) {
            return null;
        }
        this.f5334b.a(str, ((GraphQLStory) GraphQLStoryUtil.o(feedProps).a()).c(), ((ViewerContext) this.f5335c.get()).a(), StorySharingHelper.a(graphQLStory), uuid);
        return figPopoverMenuWindow;
    }

    private ImmutableList<ShareMenuItem> m5775a() {
        ImmutableList.Builder builder = ImmutableList.builder();
        int a = this.f5342j.f5244a.a(ExperimentsForBlingBarABTestModule.f5237g, -1);
        if (a != -1) {
            builder.c(new ShareMenuItem(ShareMenuItemType.WRITE_POST, 2131233506, 2130839809, a));
        }
        a = this.f5342j.f5244a.a(ExperimentsForBlingBarABTestModule.f5241k, -1);
        if (a != -1) {
            builder.c(new ShareMenuItem(ShareMenuItemType.SHARE_NOW, 2131232714, 2130840082, a));
        }
        builder.c(new ShareMenuItem(ShareMenuItemType.SEND_AS_MESSAGE, 2131233507, AppGlyphResolver.a(), 2));
        return builder.b();
    }

    private static ImmutableList<ShareMenuItem> m5776a(boolean z) {
        ImmutableList.Builder builder = ImmutableList.builder();
        builder.c(new ShareMenuItem(ShareMenuItemType.SHARE_NOW, z ? 2131233505 : 2131232714, 2130840082, 0));
        builder.c(new ShareMenuItem(ShareMenuItemType.WRITE_POST, 2131233506, 2130839809, 1));
        builder.c(new ShareMenuItem(ShareMenuItemType.SEND_AS_MESSAGE, 2131233507, AppGlyphResolver.a(), 2));
        return builder.b();
    }

    private ImmutableList<ShareMenuItem> m5782b(boolean z) {
        ImmutableList.Builder builder = ImmutableList.builder();
        builder.c(new ShareMenuItem(ShareMenuItemType.SHARE_NOW, z ? 2131233505 : 2131232714, 2130840082, 0));
        builder.c(new ShareMenuItem(ShareMenuItemType.WRITE_POST, 2131233506, 2130839809, 1));
        if (this.f5348p.f16195a.a(ExperimentsForAssistedOnboardingAbTestModule.f16191a, false)) {
            builder.c(new ShareMenuItem(ShareMenuItemType.SEND_AS_MESSAGE, 2131233507, AppGlyphResolver.a(), 2));
        }
        if (this.f5348p.f16195a.a(ExperimentsForAssistedOnboardingAbTestModule.f16192b, false)) {
            builder.c(new ShareMenuItem(ShareMenuItemType.SHARE_EXTERNAL, 2131233509, 2130840095, 3));
        }
        return builder.b();
    }
}
