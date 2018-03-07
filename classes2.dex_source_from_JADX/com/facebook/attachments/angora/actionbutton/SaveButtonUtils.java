package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.api.feed.service.GraphPostService;
import com.facebook.attachments.angora.actionbutton.StorySaveTypeResources.StorySaveTypeResource;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents$FetchFollowUpUnitEvent;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLFollowUpFeedUnitActionType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLStorySaveType;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStorySaveInfo;
import com.facebook.graphql.model.GraphQLTimelineAppCollection;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.InterstitialStartHelper;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.saved.analytics.SaveAnalyticsLogger.Referer;
import com.facebook.saved.common.data.RecentSaveInfo;
import com.facebook.saved.common.data.RecentSaveTimeframe;
import com.facebook.saved.common.protocol.UpdateSavedStateParams.Builder;
import com.facebook.saved.common.protocol.UpdateSavedStateParams.SavedAction;
import com.facebook.story.UpdateTimelineAppCollectionParams;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: neue_nux/ */
public class SaveButtonUtils {
    private static final String f12383a = SaveButtonUtils.class.getSimpleName();
    private static final InterstitialTrigger f12384b = new InterstitialTrigger(Action.ITEM_SAVED);
    private static volatile SaveButtonUtils f12385q;
    private final GatekeeperStoreImpl f12386c;
    private final Provider<TriState> f12387d;
    private final StorySaveTypeResources f12388e;
    private final SaveAnalyticsLogger f12389f;
    private final FbUriIntentHandler f12390g;
    private final GraphPostService f12391h;
    public final AbstractFbErrorReporter f12392i;
    private final GraphQLStoryUtil f12393j;
    private final FeedEventBus f12394k;
    private final TasksManager f12395l;
    private final Resources f12396m;
    private final Toaster f12397n;
    private final InterstitialStartHelper f12398o;
    public final RecentSaveInfo f12399p;

    public static com.facebook.attachments.angora.actionbutton.SaveButtonUtils m18452a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12385q;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.attachments.angora.actionbutton.SaveButtonUtils.class;
        monitor-enter(r1);
        r0 = f12385q;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m18461b(r0);	 Catch:{ all -> 0x0035 }
        f12385q = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12385q;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.attachments.angora.actionbutton.SaveButtonUtils.a(com.facebook.inject.InjectorLike):com.facebook.attachments.angora.actionbutton.SaveButtonUtils");
    }

    private static SaveButtonUtils m18461b(InjectorLike injectorLike) {
        return new SaveButtonUtils(IdBasedProvider.m1811a(injectorLike, 764), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), StorySaveTypeResources.m18473a(injectorLike), SaveAnalyticsLogger.m13117a(injectorLike), FbUriIntentHandler.m8626a(injectorLike), GraphPostService.m18477b(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), GraphQLStoryUtil.m9565a(injectorLike), FeedEventBus.m4573a(injectorLike), TasksManager.m14550b(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike), Toaster.m6454b(injectorLike), InterstitialStartHelper.m13670b(injectorLike), RecentSaveInfo.m18557a(injectorLike));
    }

    private void m18458a(FeedProps<GraphQLStory> feedProps, @Nullable String str, UpdateTimelineAppCollectionParams.Action action, CurationMechanism curationMechanism, CurationSurface curationSurface) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (GraphQLHelper.m22485a(graphQLStory.as())) {
            SavedAction savedAction;
            GraphQLStory d = StoryProps.m27457d(feedProps);
            ArrayNode a = TrackableFeedProps.m27451a(feedProps);
            if (action == UpdateTimelineAppCollectionParams.Action.ADD) {
                savedAction = SavedAction.SAVE;
            } else {
                savedAction = SavedAction.UNSAVE;
            }
            Builder builder = new Builder(savedAction, curationSurface, curationMechanism, this.f12393j.m9598h(graphQLStory));
            builder.a = Optional.of(graphQLStory.m22350c());
            Builder builder2 = builder;
            builder2.d = Optional.of(a.toString());
            builder2 = builder2;
            if (!StringUtil.m3589a((CharSequence) str)) {
                builder2.c = Optional.of(str);
            }
            this.f12395l.m14553a("task_key_update_all_save_collections" + d.m22350c() + "_" + d.mo2507g(), this.f12391h.m18482a(builder2.a(), CallerContext.m9060a(getClass())), new 2(this));
            return;
        }
        this.f12392i.m2340a(getClass().getSimpleName(), "Trying to (un)save all attachments of a story while not having enough data for save.");
    }

    @Inject
    public SaveButtonUtils(Provider<TriState> provider, GatekeeperStore gatekeeperStore, StorySaveTypeResources storySaveTypeResources, SaveAnalyticsLogger saveAnalyticsLogger, FbUriIntentHandler fbUriIntentHandler, GraphPostService graphPostService, FbErrorReporter fbErrorReporter, GraphQLStoryUtil graphQLStoryUtil, FeedEventBus feedEventBus, TasksManager tasksManager, Resources resources, Toaster toaster, InterstitialStartHelper interstitialStartHelper, RecentSaveInfo recentSaveInfo) {
        this.f12387d = provider;
        this.f12386c = gatekeeperStore;
        this.f12388e = storySaveTypeResources;
        this.f12389f = saveAnalyticsLogger;
        this.f12390g = fbUriIntentHandler;
        this.f12391h = graphPostService;
        this.f12392i = fbErrorReporter;
        this.f12393j = graphQLStoryUtil;
        this.f12394k = feedEventBus;
        this.f12395l = tasksManager;
        this.f12396m = resources;
        this.f12397n = toaster;
        this.f12398o = interstitialStartHelper;
        this.f12399p = recentSaveInfo;
    }

    public static boolean m18460a(@Nullable GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null) {
            return false;
        }
        GraphQLStoryActionLink a = ActionLinkHelper.m22936a(graphQLStoryAttachment, -908457779);
        if (a == null || !GraphQLHelper.m22484a(a)) {
            return false;
        }
        return true;
    }

    public static boolean m18459a(@Nullable GraphQLStory graphQLStory, GraphQLPlace graphQLPlace) {
        if (!(graphQLStory == null || graphQLPlace == null)) {
            GraphQLObjectType j = graphQLPlace.m24157j();
            if (j != null && j.m22301g() == 2479791) {
                GraphQLTimelineAppCollection S = graphQLPlace.m24143S();
                if (!(S == null || !GraphQLHelper.m22486a(S) || StoryActionLinkHelper.m28072a(graphQLStory, -908457779) == null)) {
                    GraphQLStorySaveInfo as = graphQLStory.as();
                    if (!(as == null || as.m24778m() == GraphQLSavedState.NOT_SAVABLE || as.m24778m() == GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void m18469a(Context context, @Nullable GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType, @Nullable String str, Referer referer) {
        if (m18463b()) {
            m18455a(context, graphQLSavedDashboardSectionType, referer);
        } else {
            m18456a(context, str, referer);
        }
    }

    public final void m18471a(FeedProps<GraphQLStory> feedProps, CurationMechanism curationMechanism, CurationSurface curationSurface) {
        m18458a(feedProps, null, UpdateTimelineAppCollectionParams.Action.ADD, curationMechanism, curationSurface);
        this.f12394k.mo651a(new StoryEvents$FetchFollowUpUnitEvent(((GraphQLStory) feedProps.f13444a).mo2507g(), GraphQLFollowUpFeedUnitActionType.SAVE));
    }

    public final void m18472b(FeedProps<GraphQLStory> feedProps, CurationMechanism curationMechanism, CurationSurface curationSurface) {
        m18458a(feedProps, null, UpdateTimelineAppCollectionParams.Action.REMOVE, curationMechanism, curationSurface);
    }

    public final void m18468a(Context context) {
        this.f12398o.m13672a(context, f12384b, InterstitialController.class, null);
    }

    public final void m18470a(View view) {
        int i = 0;
        if (m18465d()) {
            String str;
            int a = this.f12399p.m18562a() + 1;
            RecentSaveInfo recentSaveInfo = this.f12399p;
            RecentSaveInfo.m18558a(recentSaveInfo, a, recentSaveInfo.f12486b);
            RecentSaveTimeframe b = this.f12399p.m18563b();
            String str2 = "<b>" + view.getContext().getString(2131232728) + "</b>";
            if (a > 1) {
                str = str2 + "<br/>" + view.getContext().getString(b.equals(RecentSaveTimeframe.PAST_WEEK) ? 2131232738 : 2131232739, new Object[]{Integer.valueOf(a)});
            } else {
                str = str2;
            }
            Snackbar a2 = Snackbar.a(view, Html.fromHtml(str), 0);
            ViewGroup viewGroup = (ViewGroup) a2.d;
            while (i < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextColor(-1);
                    textView.setLineSpacing(0.0f, 1.2f);
                }
                i++;
            }
            a2.a(2131232740, new 1(this));
            a2.b();
        } else if (m18464c()) {
            this.f12397n.m6456b(new ToastBuilder(2131232728));
        }
    }

    public final void m18467a() {
        if (m18464c()) {
            this.f12397n.m6456b(new ToastBuilder(2131232729));
        }
    }

    private void m18455a(Context context, @Nullable GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType, Referer referer) {
        this.f12390g.m8632a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.dF, m18454a(graphQLSavedDashboardSectionType).or(GraphQLSavedDashboardSectionType.ALL), referer));
    }

    private void m18456a(Context context, @Nullable String str, Referer referer) {
        if (StringUtil.m3589a((CharSequence) str)) {
            this.f12392i.m2350b(f12383a, "Not enough information to launch Faceweb saved dashboard");
            return;
        }
        String str2;
        Uri build = Uri.parse(str).buildUpon().appendQueryParameter("cref", referer.toString()).build();
        if (build == null) {
            str2 = null;
        } else {
            str2 = build.toString();
        }
        CharSequence charSequence = str2;
        if (!StringUtil.m3589a(charSequence)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("titlebar_with_modal_done", true);
            this.f12390g.m8633a(context, charSequence, bundle);
        }
    }

    private Optional<GraphQLSavedDashboardSectionType> m18454a(@Nullable GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType) {
        if (graphQLSavedDashboardSectionType != null && graphQLSavedDashboardSectionType != GraphQLSavedDashboardSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            return Optional.of(graphQLSavedDashboardSectionType);
        }
        this.f12392i.m2340a(f12383a, "Not enough information to launch native saved dashboard");
        return Absent.INSTANCE;
    }

    private boolean m18463b() {
        return ((TriState) this.f12387d.get()).asBoolean(false);
    }

    private boolean m18464c() {
        return this.f12386c.m2189a(1108, false);
    }

    private boolean m18465d() {
        return this.f12386c.m2189a(1107, false);
    }

    public final StorySaveTypeResource m18466a(GraphQLStorySaveType graphQLStorySaveType) {
        StorySaveTypeResources storySaveTypeResources = this.f12388e;
        StorySaveTypeResource storySaveTypeResource = (StorySaveTypeResource) storySaveTypeResources.f12402b.get(graphQLStorySaveType);
        if (storySaveTypeResource == null) {
            storySaveTypeResources.f12403c.m2340a(StorySaveTypeResources.f12400a, "Unsupported save type: " + graphQLStorySaveType);
            storySaveTypeResource = (StorySaveTypeResource) storySaveTypeResources.f12402b.get(GraphQLStorySaveType.GENERIC);
        }
        return storySaveTypeResource;
    }
}
