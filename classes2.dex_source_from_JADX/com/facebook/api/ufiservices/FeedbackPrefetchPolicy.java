package com.facebook.api.ufiservices;

import com.facebook.api.prefetch.GraphQLPrefetchPolicy;
import com.facebook.api.prefetch.GraphQLPrefetchPriority;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FetchFeedbackParams;
import com.facebook.api.ufiservices.common.FetchFeedbackParams.FetchType;
import com.facebook.api.ufiservices.config.FeedbackPrefetchPolicyXConfig;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.time.Clock;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.Assisted;
import com.facebook.xconfig.core.XConfigReader;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: post_business_address */
public class FeedbackPrefetchPolicy extends GraphQLPrefetchPolicy<GraphQLFeedback> {
    private final FetchFeedbackMethod f9401a;
    private final XConfigReader f9402b;
    private final boolean f9403c;
    public final boolean f9404d;
    private final Clock f9405e;
    private final AppStateManager f9406f;
    public final HashMap<String, String> f9407g = new HashMap();

    @Inject
    public FeedbackPrefetchPolicy(FetchFeedbackMethod fetchFeedbackMethod, XConfigReader xConfigReader, @Assisted Boolean bool, @Assisted Boolean bool2, Clock clock, AppStateManager appStateManager) {
        this.f9401a = fetchFeedbackMethod;
        this.f9402b = xConfigReader;
        this.f9403c = bool.booleanValue();
        this.f9404d = bool2.booleanValue();
        this.f9405e = clock;
        this.f9406f = appStateManager;
    }

    public final String mo1929c() {
        return "comments_prefetch";
    }

    public final int mo1927b() {
        return this.f9402b.m2683a(FeedbackPrefetchPolicyXConfig.f21649k, 259200);
    }

    public final boolean mo1926a(GraphQLResult<GraphQLFeedback> graphQLResult) {
        if (this.f9402b.m2686a(FeedbackPrefetchPolicyXConfig.f21642d, true) || this.f9405e.mo211a() - graphQLResult.clientTimeMs > this.f9402b.m2684a(FeedbackPrefetchPolicyXConfig.f21643e, 0)) {
            return true;
        }
        return false;
    }

    public final boolean mo1930d() {
        return this.f9402b.m2686a(FeedbackPrefetchPolicyXConfig.f21641c, true);
    }

    public final boolean mo1931e() {
        if (this.f9406f.m2262j()) {
            return this.f9402b.m2686a(FeedbackPrefetchPolicyXConfig.f21650l, false);
        }
        return this.f9402b.m2686a(FeedbackPrefetchPolicyXConfig.f21644f, false);
    }

    public final boolean mo1925a(GraphQLPrefetchPriority graphQLPrefetchPriority) {
        if (this.f9402b.m2686a(FeedbackPrefetchPolicyXConfig.f21645g, false) || (this.f9406f.m2262j() && this.f9402b.m2686a(FeedbackPrefetchPolicyXConfig.f21651m, false))) {
            return graphQLPrefetchPriority.isAtLeast(GraphQLPrefetchPriority.LOW);
        }
        return graphQLPrefetchPriority.isAtLeast(GraphQLPrefetchPriority.HIGH);
    }

    public final int mo1932f() {
        if (this.f9404d) {
            return 1;
        }
        return this.f9402b.m2683a(FeedbackPrefetchPolicyXConfig.f21648j, 10);
    }

    public static FetchFeedbackParams m14359h() {
        return new FetchFeedbackParams(null, 25, FetchType.COMPLETE, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, CommentOrderType.DEFAULT_ORDER, null, true, false, false);
    }

    public final GraphQLRequest<GraphQLFeedback> mo1924a(String str) {
        String str2;
        int i = m14360i();
        FetchType fetchType = FetchType.COMPLETE;
        DataFreshnessParam dataFreshnessParam = DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE;
        CommentOrderType commentOrderType = CommentOrderType.DEFAULT_ORDER;
        if (this.f9404d) {
            str2 = (String) this.f9407g.get(str);
        } else {
            str2 = null;
        }
        return this.f9401a.m10195a(new FetchFeedbackParams(str, i, fetchType, dataFreshnessParam, commentOrderType, str2, true, this.f9403c, false));
    }

    @Nullable
    public final GraphQLRequest<GraphQLFeedback> mo1928b(String str) {
        return this.f9401a.m10195a(new FetchFeedbackParams(str, m14360i(), FetchType.COMPLETE, DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE, CommentOrderType.DEFAULT_ORDER, null, true, this.f9403c, false));
    }

    private int m14360i() {
        return this.f9402b.m2683a(FeedbackPrefetchPolicyXConfig.f21646h, 25);
    }

    public final void m14362a(String str, String str2) {
        if (this.f9404d) {
            this.f9407g.put(str, str2);
        }
    }

    public final void m14368c(String str) {
        if (this.f9404d) {
            this.f9407g.remove(str);
        }
    }
}
