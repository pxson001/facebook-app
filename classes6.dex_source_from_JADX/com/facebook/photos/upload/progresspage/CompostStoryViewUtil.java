package com.facebook.photos.upload.progresspage;

import android.content.Intent;
import android.os.Handler;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.composer.publish.common.ErrorDetails.Builder;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.composer.publish.common.PostParamsWrapper;
import com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster;
import com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster.Result;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents.ChangeRendererEvent;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEvent;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.model.RetrySource;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.manager.UploadManager$RequestType;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: getRegularOpenHours */
public class CompostStoryViewUtil extends Handler {
    private PendingStoryStore f13940a;
    private AbstractFbErrorReporter f13941b;
    private OptimisticStoryStateCache f13942c;
    private FeedEventBus f13943d;
    private Lazy<UploadManager> f13944e;
    private UploadOperationFactory f13945f;
    private ComposerActivityBroadcaster f13946g;
    private FbObjectMapper f13947h;
    private ComposerAnalyticsLogger f13948i;
    private final Clock f13949j;
    private final Lazy<ComposerPublishServiceHelper> f13950k;
    public final QeAccessor f13951l;

    public static CompostStoryViewUtil m21676b(InjectorLike injectorLike) {
        return new CompostStoryViewUtil(PendingStoryStore.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), OptimisticStoryStateCache.a(injectorLike), FeedEventBus.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2984), UploadOperationFactory.m21557b(injectorLike), ComposerActivityBroadcaster.m11633a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike), ComposerAnalyticsLogger.m11140a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 5272), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CompostStoryViewUtil(PendingStoryStore pendingStoryStore, FbErrorReporter fbErrorReporter, OptimisticStoryStateCache optimisticStoryStateCache, FeedEventBus feedEventBus, Lazy<UploadManager> lazy, UploadOperationFactory uploadOperationFactory, ComposerActivityBroadcaster composerActivityBroadcaster, FbObjectMapper fbObjectMapper, ComposerAnalyticsLogger composerAnalyticsLogger, Clock clock, Lazy<ComposerPublishServiceHelper> lazy2, QeAccessor qeAccessor) {
        this.f13940a = pendingStoryStore;
        this.f13941b = fbErrorReporter;
        this.f13942c = optimisticStoryStateCache;
        this.f13943d = feedEventBus;
        this.f13944e = lazy;
        this.f13945f = uploadOperationFactory;
        this.f13946g = composerActivityBroadcaster;
        this.f13947h = fbObjectMapper;
        this.f13948i = composerAnalyticsLogger;
        this.f13949j = clock;
        this.f13950k = lazy2;
        this.f13951l = qeAccessor;
    }

    public final void m21677a(GraphQLStory graphQLStory) {
        Preconditions.checkNotNull(graphQLStory);
        Optional d = this.f13940a.d(graphQLStory.T());
        if (d.isPresent()) {
            boolean z;
            Preconditions.checkState(d.isPresent());
            this.f13942c.a(graphQLStory, GraphQLFeedOptimisticPublishState.DELETED);
            this.f13943d.a(new StoryVisibilityEvent(null, null, graphQLStory.T(), StoryVisibility.GONE, 0));
            this.f13943d.a(new ChangeRendererEvent());
            this.f13940a.a(graphQLStory.T());
            PostParamsWrapper b = ((PendingStory) d.get()).b();
            if (b.e()) {
                ((UploadManager) this.f13944e.get()).c(this.f13945f.m21578b(graphQLStory.T()));
            }
            this.f13946g.m11636a(Result.CANCELLED, b.j() == null ? graphQLStory.ai() : null, null, graphQLStory.T(), b.d(), new Builder().a(false).a());
            String str = "";
            try {
                str = this.f13947h.a(b);
            } catch (JsonProcessingException e) {
                this.f13941b.a("publish_offline_post_header_param_json_failed", e);
            }
            ComposerAnalyticsLogger composerAnalyticsLogger = this.f13948i;
            String a = b.a();
            ComposerType f = b.f();
            int g = b.g();
            if (b.h() != null) {
                z = true;
            } else {
                z = false;
            }
            composerAnalyticsLogger.m11151a(a, f, str, g, z);
            return;
        }
        this.f13941b.b("offline_post_delete_missing_story", "couldn't find story, sessionId: " + graphQLStory.T());
    }

    public final void m21678a(@Nullable GraphQLStory graphQLStory, RetrySource retrySource, boolean z) {
        boolean z2 = false;
        if (graphQLStory != null) {
            boolean z3 = true;
            if (!(this.f13951l.a(ExperimentsForCompostAbTestModule.f8107z, false) && this.f13951l.a(ExperimentsForCompostAbTestModule.f8093l, true))) {
                z3 = false;
            }
            if (!z3) {
                z = false;
            }
            removeMessages(2, graphQLStory.T());
            if (z || this.f13942c.a(graphQLStory) == GraphQLFeedOptimisticPublishState.FAILED) {
                Optional d = this.f13940a.d(graphQLStory.T());
                if (d.isPresent()) {
                    PostParamsWrapper b = ((PendingStory) d.get()).b();
                    b.a(retrySource);
                    ((PendingStory) d.get()).b(this.f13949j.a(), StoryAttachmentHelper.a(graphQLStory));
                    Intent intent = new Intent();
                    if (b.k() != null) {
                        intent.putExtra("publishPostParams", b.k());
                    } else {
                        intent.putExtra("publishEditPostParamsKey", b.j());
                    }
                    this.f13942c.a(graphQLStory, GraphQLFeedOptimisticPublishState.POSTING);
                    this.f13940a.c(graphQLStory.T());
                    if (b.e()) {
                        boolean b2;
                        if (retrySource == RetrySource.OFFLINE_POSTING_HEADER || retrySource == RetrySource.COMPOST || retrySource == RetrySource.NOTIFICATION) {
                            z2 = true;
                        }
                        if (z) {
                            b2 = ((UploadManager) this.f13944e.get()).b(graphQLStory.T(), z2 ? UploadManager$RequestType.UserRetry : UploadManager$RequestType.AutoRetry);
                        } else {
                            b2 = ((UploadManager) this.f13944e.get()).a(graphQLStory.T(), z2 ? UploadManager$RequestType.UserRetry : UploadManager$RequestType.AutoRetry);
                        }
                        if (b2) {
                            ((PendingStory) d.get()).b(this.f13949j.a(), true);
                        }
                    } else {
                        ((ComposerPublishServiceHelper) this.f13950k.get()).m11566a(intent);
                    }
                    this.f13943d.a(new ChangeRendererEvent());
                }
            }
        }
    }
}
