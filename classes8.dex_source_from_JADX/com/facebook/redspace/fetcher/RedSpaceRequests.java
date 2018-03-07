package com.facebook.redspace.fetcher;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.calls.NoContextTokenInputNoContextToken;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQLRefParam;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.redspace.protocol.RedSpaceFeedFragments.RedSpaceFriendsOverflowCountQueryString;
import com.facebook.redspace.protocol.RedSpaceFeedFragments.RedSpaceFriendsQueryString;
import com.facebook.redspace.protocol.RedSpaceFeedFragments.RedSpaceProfileQueryString;
import com.facebook.redspace.protocol.RedSpaceFeedFragments.RedSpaceStoriesQueryString;
import com.facebook.redspace.protocol.RedSpaceFeedFragments.RedSpaceVisitsQueryString;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceStoriesQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceVisitsQueryModel;
import com.facebook.ultralight.Inject;

@ContextScoped
/* compiled from: USER_SCROLL_FINISHED */
public class RedSpaceRequests {
    private static RedSpaceRequests f21322c;
    private static final Object f21323d = new Object();
    @Inject
    public Resources f21324a;
    @Inject
    public RedSpaceFriendsImageSizeResolver f21325b;

    /* compiled from: USER_SCROLL_FINISHED */
    public class ExportedParam {
        private GraphQLRefParam f21320a;
        private Boolean f21321b;

        public ExportedParam(GraphQLRefParam graphQLRefParam) {
            this.f21320a = graphQLRefParam;
        }

        public ExportedParam(Boolean bool) {
            this.f21321b = bool;
        }

        public static void m24943a(ExportedParam exportedParam, String str, GraphQlQueryString graphQlQueryString) {
            if (exportedParam.f21321b != null) {
                graphQlQueryString.a(str, exportedParam.f21321b);
            }
            if (exportedParam.f21320a != null) {
                graphQlQueryString.a(str, exportedParam.f21320a);
            }
        }
    }

    private static RedSpaceRequests m24946b(InjectorLike injectorLike) {
        RedSpaceRequests redSpaceRequests = new RedSpaceRequests();
        RedSpaceFriendsImageSizeResolver b = RedSpaceFriendsImageSizeResolver.m24941b(injectorLike);
        redSpaceRequests.f21324a = ResourcesMethodAutoProvider.a(injectorLike);
        redSpaceRequests.f21325b = b;
        return redSpaceRequests;
    }

    public static RedSpaceRequests m24945a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceRequests b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21323d) {
                RedSpaceRequests redSpaceRequests;
                if (a2 != null) {
                    redSpaceRequests = (RedSpaceRequests) a2.a(f21323d);
                } else {
                    redSpaceRequests = f21322c;
                }
                if (redSpaceRequests == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24946b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21323d, b3);
                        } else {
                            f21322c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceRequests;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final GraphQLRequest<RedSpaceFriendsOverflowCountQueryModel> m24949a(String str, @Nullable ExportedParam exportedParam) {
        RedSpaceFriendsOverflowCountQueryString redSpaceFriendsOverflowCountQueryString = (RedSpaceFriendsOverflowCountQueryString) new RedSpaceFriendsOverflowCountQueryString().a("section", str).a("overflow_first", Integer.valueOf(3)).a("picture_size", Integer.valueOf(this.f21325b.m24942a()));
        if (exportedParam != null) {
            ExportedParam.m24943a(exportedParam, "skip_query", redSpaceFriendsOverflowCountQueryString);
        }
        return GraphQLRequest.a(redSpaceFriendsOverflowCountQueryString).a(GraphQLCachePolicy.c);
    }

    public final GraphQLRequest<RedSpaceFriendsQueryModel> m24950a(String str, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3, @Nullable ExportedParam exportedParam, @Nullable ExportedParam exportedParam2, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Boolean bool5) {
        RedSpaceFriendsQueryString redSpaceFriendsQueryString = (RedSpaceFriendsQueryString) new RedSpaceFriendsQueryString().a("section", str).a("has_redspace_content", bool).a("first", Integer.valueOf(20)).a("afterCursor", str3).a("named", str2).a("skip_attributes", bool4).a("skip_badge", bool2).a("skip_recent_story", bool3).a("skip_actor", bool5).a("picture_size", Integer.valueOf(this.f21325b.m24942a()));
        if (exportedParam != null) {
            ExportedParam.m24943a(exportedParam, "run_query", redSpaceFriendsQueryString);
        }
        if (exportedParam2 != null) {
            ExportedParam.m24943a(exportedParam2, "skip_query", redSpaceFriendsQueryString);
        }
        return GraphQLRequest.a(redSpaceFriendsQueryString).a(GraphQLCachePolicy.c);
    }

    public static GraphQLRequest<RedSpaceStoriesQueryModel> m24944a(String str, @Nullable String str2, @Nullable NoContextTokenInputNoContextToken noContextTokenInputNoContextToken, @Nullable String str3, GraphQLCachePolicy graphQLCachePolicy) {
        return GraphQLRequest.a((RedSpaceStoriesQueryString) new RedSpaceStoriesQueryString().a("profile_id", str).a("context_token", str2).a("no_context_token_reason", noContextTokenInputNoContextToken).a("first", Integer.valueOf(10)).a("afterCursor", str3)).a(graphQLCachePolicy).a(180000);
    }

    public final GraphQLRequest<RedSpaceVisitsQueryModel> m24947a(int i, @Nullable String str) {
        RedSpaceVisitsQueryString redSpaceVisitsQueryString = (RedSpaceVisitsQueryString) new RedSpaceVisitsQueryString().a("visits_limit", Integer.valueOf(i)).a("visitor_picture_size", String.valueOf(this.f21324a.getDimensionPixelSize(2131430546)));
        if (TextUtils.isEmpty(str)) {
            redSpaceVisitsQueryString.a("no_context_token_reason", NoContextTokenInputNoContextToken.SELF_VIEW_UNIT_NOT_LOADED_YET);
        } else {
            redSpaceVisitsQueryString.a("context_token", str);
        }
        return GraphQLRequest.a(redSpaceVisitsQueryString);
    }

    public final GraphQLRequest<RedSpaceFeedProfileFragmentModel> m24948a(String str) {
        return GraphQLRequest.a((RedSpaceProfileQueryString) new RedSpaceProfileQueryString().a("profile_id", str).a("picture_size", Integer.valueOf(this.f21325b.m24942a()))).a(GraphQLCachePolicy.a).a(180000);
    }
}
