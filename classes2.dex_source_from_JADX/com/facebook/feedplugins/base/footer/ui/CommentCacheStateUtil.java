package com.facebook.feedplugins.base.footer.ui;

import android.os.Handler;
import com.facebook.api.ufiservices.FeedbackPrefetchPolicyProvider;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.graphql.executor.cache.GraphQLDiskCacheImpl;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ufiservices.data.FeedbackCacheStateProvider;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: has_shared_info */
public class CommentCacheStateUtil {
    public final FeedbackCacheStateProvider f21260a;
    private final ExecutorService f21261b;
    public final Handler f21262c;
    private final FbSharedPreferences f21263d;
    private final QeAccessor f21264e;

    public static CommentCacheStateUtil m28981b(InjectorLike injectorLike) {
        return new CommentCacheStateUtil(new FeedbackCacheStateProvider(GraphQLDiskCacheImpl.m10254a(injectorLike), (FeedbackPrefetchPolicyProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedbackPrefetchPolicyProvider.class)), C0055x2995691a.m1881a(injectorLike), Handler_ForUiThreadMethodAutoProvider.m1701b(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public CommentCacheStateUtil(FeedbackCacheStateProvider feedbackCacheStateProvider, ExecutorService executorService, Handler handler, FbSharedPreferences fbSharedPreferences, QeAccessor qeAccessor) {
        this.f21260a = feedbackCacheStateProvider;
        this.f21261b = executorService;
        this.f21262c = handler;
        this.f21263d = fbSharedPreferences;
        this.f21264e = qeAccessor;
    }

    public final void m28982a(Footer footer, GraphQLStory graphQLStory) {
        if (this.f21263d.mo286a(FeedPrefKeys.f5761y, false) || this.f21264e.mo596a(ExperimentsForNewsFeedAbTestModule.f5115p, false)) {
            ExecutorDetour.a(this.f21261b, new 1(this, footer, graphQLStory), -1560663029);
        }
    }

    public static CommentCacheStateUtil m28980a(InjectorLike injectorLike) {
        return m28981b(injectorLike);
    }
}
