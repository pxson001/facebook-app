package com.facebook.groups.react;

import android.app.Activity;
import android.content.Intent;
import com.facebook.api.story.FetchSingleStoryParams.FetchType;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.common.EditPostParams;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.facebook.ufiservices.data.FeedbackLoader;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: payment_risk_verification_controller_fragment_tag */
public class EditPostLauncher {
    public final ReactContext f6991a;
    public final Activity f6992b;
    private final GroupsReactDataFetcher f6993c;
    public final ComposerLauncher f6994d;
    public final Provider<IFeedIntentBuilder> f6995e;
    private final Toaster f6996f;
    private final ComposerPublishServiceHelper f6997g;
    public final FeedbackLoader f6998h;
    @ForUiThread
    public final ExecutorService f6999i;

    /* compiled from: payment_risk_verification_controller_fragment_tag */
    class C07291 implements FutureCallback<GraphQLStory> {
        final /* synthetic */ EditPostLauncher f6987a;

        C07291(EditPostLauncher editPostLauncher) {
            this.f6987a = editPostLauncher;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f6987a.f6994d.a(null, ((IFeedIntentBuilder) this.f6987a.f6995e.get()).b((GraphQLStory) obj).a(), 1758, this.f6987a.f6992b);
        }

        public void onFailure(Throwable th) {
            Toaster.a(this.f6987a.f6991a, 2131239987);
        }
    }

    @Inject
    public EditPostLauncher(@Assisted ReactContext reactContext, @Assisted Activity activity, GroupsReactDataFetcherProvider groupsReactDataFetcherProvider, ComposerLauncher composerLauncher, Provider<IFeedIntentBuilder> provider, Toaster toaster, ComposerPublishServiceHelper composerPublishServiceHelper, FeedbackLoader feedbackLoader, ExecutorService executorService) {
        this.f6991a = reactContext;
        this.f6992b = activity;
        this.f6993c = groupsReactDataFetcherProvider.m7318a(this.f6991a);
        this.f6994d = composerLauncher;
        this.f6995e = provider;
        this.f6996f = toaster;
        this.f6997g = composerPublishServiceHelper;
        this.f6998h = feedbackLoader;
        this.f6999i = executorService;
    }

    public final void m7307a(String str) {
        this.f6993c.m7317a(str, FetchType.PLATFORM_DEFAULT, new C07291(this));
    }

    public final void m7306a(int i, Intent intent) {
        if (i == -1) {
            final EditPostParams editPostParams = (EditPostParams) intent.getParcelableExtra("publishEditPostParamsKey");
            Futures.a(this.f6997g.c(intent), new AbstractDisposableFutureCallback<OperationResult>(this) {
                final /* synthetic */ EditPostLauncher f6990b;

                /* compiled from: payment_risk_verification_controller_fragment_tag */
                class C07301 implements FutureCallback<GraphQLResult<GraphQLStory>> {
                    final /* synthetic */ C07312 f6988a;

                    C07301(C07312 c07312) {
                        this.f6988a = c07312;
                    }

                    public void onSuccess(Object obj) {
                        GraphQLStory graphQLStory = (GraphQLStory) ((GraphQLResult) obj).e;
                        if (this.f6988a.f6990b.f6991a.b()) {
                            ((RCTNativeAppEventEmitter) this.f6988a.f6990b.f6991a.a(RCTNativeAppEventEmitter.class)).emit("reloadFeedViewForGroup", String.valueOf(graphQLStory.aJ().b()));
                        }
                    }

                    public void onFailure(Throwable th) {
                    }
                }

                protected final void m7304a(Object obj) {
                    String str;
                    FeedbackLoader feedbackLoader = this.f6990b.f6998h;
                    String str2 = editPostParams.storyId;
                    FetchType fetchType = FetchType.GRAPHQL_DEFAULT;
                    DataFreshnessParam dataFreshnessParam = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
                    if (editPostParams.cacheIds == null || editPostParams.cacheIds.isEmpty()) {
                        str = null;
                    } else {
                        str = (String) editPostParams.cacheIds.get(0);
                    }
                    Futures.a(feedbackLoader.a(str2, null, fetchType, dataFreshnessParam, str, CommentOrderType.DEFAULT_ORDER, false), new C07301(this), this.f6990b.f6999i);
                }

                protected final void m7305a(Throwable th) {
                    Toaster.a(this.f6990b.f6991a, 2131239987);
                }
            }, this.f6999i);
        }
    }
}
