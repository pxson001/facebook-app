package com.facebook.feed.fragment.controllercallbacks;

import android.content.Intent;
import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.base.fragment.FbFragment;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.analytics.ComposerAnalyticsEventBuilder;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.common.EditPostParams;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.common.PublishPostParams.Builder;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.controllercallbacks.fragment.ActivityResultCallback;
import com.facebook.controllercallbacks.fragment.FragmentCreateDestroyCallbacks;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.crowdsourcing.feather.FeatherManager;
import com.facebook.feed.annotations.FeedGatekeepers;
import com.facebook.feed.tooltip.OnlyMeShareDetector;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Strings;
import java.util.List;

/* compiled from: pic_square */
public class ComposerActivityController extends BaseController implements ActivityResultCallback, FragmentCreateDestroyCallbacks, ResumePauseCallbacks {
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ComposerAnalyticsLogger> f9846a = UltralightRuntime.f368b;
    @Inject
    private GatekeeperStoreImpl f9847b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ComposerPublishServiceHelper> f9848c = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ReactionSessionManager> f9849d = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FeatherManager> f9850e = UltralightRuntime.f368b;
    @Inject
    private OnlyMeShareDetector f9851f;
    @Inject
    public ComposerLauncher f9852g;
    public Holder<FbFragment> f9853h;
    public Holder<LegacyFeedUnitUpdater> f9854i;

    private static ComposerActivityController m14879b(InjectorLike injectorLike) {
        ComposerActivityController composerActivityController = new ComposerActivityController();
        composerActivityController.m14878a(IdBasedSingletonScopeProvider.m1810b(injectorLike, 5189), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), IdBasedLazy.m1808a(injectorLike, 5272), IdBasedSingletonScopeProvider.m1810b(injectorLike, 9836), IdBasedLazy.m1808a(injectorLike, 1001), OnlyMeShareDetector.m14884a(injectorLike), ComposerLauncherImpl.m14892a(injectorLike));
        return composerActivityController;
    }

    private void m14878a(com.facebook.inject.Lazy<ComposerAnalyticsLogger> lazy, GatekeeperStore gatekeeperStore, com.facebook.inject.Lazy<ComposerPublishServiceHelper> lazy2, com.facebook.inject.Lazy<ReactionSessionManager> lazy3, com.facebook.inject.Lazy<FeatherManager> lazy4, OnlyMeShareDetector onlyMeShareDetector, ComposerLauncher composerLauncher) {
        this.f9846a = lazy;
        this.f9847b = gatekeeperStore;
        this.f9848c = lazy2;
        this.f9849d = lazy3;
        this.f9850e = lazy4;
        this.f9851f = onlyMeShareDetector;
        this.f9852g = composerLauncher;
    }

    public static ComposerActivityController m14876a(InjectorLike injectorLike) {
        return m14879b(injectorLike);
    }

    public final void mo1941a(int i, int i2, Intent intent) {
        if (i == 1756 || i == 1758) {
            if (i == 1756) {
                m14877a(i2, intent);
            }
            if (i2 == -1 && intent != null) {
                if (this.f9847b.m2189a(FeedGatekeepers.a, false) && intent.hasExtra("publishPostParams")) {
                    Builder builder = new Builder((PublishPostParams) intent.getParcelableExtra("publishPostParams"));
                    builder.ak = true;
                    intent.putExtra("publishPostParams", builder.a());
                }
                ((ComposerPublishServiceHelper) this.f9848c.get()).c(intent);
                if (intent.hasExtra("publishPostParams")) {
                    PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
                    ((ReactionSessionManager) this.f9849d.get()).a(publishPostParams.composerSessionId, (FbFragment) this.f9853h.f10429a);
                    ((FeatherManager) this.f9850e.get()).m21373a(((FbFragment) this.f9853h.f10429a).getContext(), publishPostParams);
                    if (!(publishPostParams.privacy == null || !publishPostParams.privacy.equals("{\"value\":\"SELF\"}") || publishPostParams.shareable == null)) {
                        this.f9851f.m14889c();
                    }
                }
                if (intent.hasExtra("publishEditPostParamsKey")) {
                    EditPostParams editPostParams = (EditPostParams) intent.getParcelableExtra("publishEditPostParamsKey");
                    if (editPostParams.cacheIds != null && !editPostParams.cacheIds.isEmpty()) {
                        List<GraphQLFeedUnitEdge> d = ((LegacyFeedUnitUpdater) this.f9854i.f10429a).mo1384d((String) editPostParams.cacheIds.get(0));
                        if (d != null && !d.isEmpty()) {
                            for (GraphQLFeedUnitEdge a : d) {
                                ((LegacyFeedUnitUpdater) this.f9854i.f10429a).mo1380a(a);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void mo1264c() {
        this.f9851f.m14887a();
    }

    public final void mo1265d() {
        this.f9851f.m14888b();
    }

    private void m14877a(int i, Intent intent) {
        boolean z = true;
        boolean z2 = false;
        String str = null;
        if (intent == null || !intent.hasExtra("publishPostParams")) {
            z = false;
        } else {
            PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
            if (publishPostParams != null) {
                z2 = true;
                str = publishPostParams.composerSessionId;
            } else {
                z2 = true;
                z = false;
            }
        }
        ComposerAnalyticsLogger composerAnalyticsLogger = (ComposerAnalyticsLogger) this.f9846a.get();
        ComposerAnalyticsEventBuilder h = new ComposerAnalyticsEventBuilder("composer_activity_result").h(Strings.nullToEmpty(str));
        h.a.m5087a("has_post_params_extra", z);
        h = h;
        h.a.m5087a("has_post_params", z2);
        h = h;
        h.a.m5083a("result_code", i);
        composerAnalyticsLogger.a.mo526a(h.a);
    }

    public final void mo1949b() {
    }
}
