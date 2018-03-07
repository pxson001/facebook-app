package com.facebook.tagging.conversion;

import android.os.Handler;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.places.future.SimpleExecutor;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQL;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQL.FBPersonFriendTagSuggestionsQueryString;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLInterfaces.FBPersonFriendTagSuggestionsQuery;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLModels.FBPersonFriendTagSuggestionsQueryModel;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLModels.FBPersonFriendTagSuggestionsQueryModel.SuggestedWithGroupsModel;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLModels.FBPersonFriendTagSuggestionsQueryModel.SuggestedWithGroupsModel.UsersModel;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLModels.FBPersonFriendTagSuggestionsQueryModel.SuggestedWithTagsModel.EdgesModel;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLModels.FBPersonFriendTagSuggestionsQueryModel.SuggestedWithTagsModel.EdgesModel.NodeModel;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.facebook.widget.tokenizedtypeahead.TokenPickerTokenUtil;
import com.facebook.widget.tokenizedtypeahead.model.GroupTagToken;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: max_font_size */
public class FriendSuggestionsRunner {
    private static final String f9098a = FriendSuggestionsRunner.class.getSimpleName();
    private final SimpleExecutor f9099b;
    private final GraphQLQueryExecutor f9100c;
    public final FriendSuggestionsCache f9101d;
    private final TokenPickerTokenUtil f9102e;
    public final Handler f9103f = new Handler();
    private final AbstractFbErrorReporter f9104g;
    private final AnalyticsLogger f9105h;
    public FutureCallback<ImmutableList<SimpleUserToken>> f9106i;
    public final Runnable f9107j = new C09472(this);

    /* compiled from: max_font_size */
    class C09472 implements Runnable {
        final /* synthetic */ FriendSuggestionsRunner f9097a;

        C09472(FriendSuggestionsRunner friendSuggestionsRunner) {
            this.f9097a = friendSuggestionsRunner;
        }

        public void run() {
            this.f9097a.m10880b();
            FriendSuggestionsRunner.m10875a(this.f9097a, "time_out");
            if (this.f9097a.f9106i != null) {
                this.f9097a.f9106i.onFailure(new Throwable("Timed out fetching results"));
            }
        }
    }

    public static FriendSuggestionsRunner m10876b(InjectorLike injectorLike) {
        return new FriendSuggestionsRunner(SimpleExecutor.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), FriendSuggestionsCache.m10871a(injectorLike), TokenPickerTokenUtil.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FriendSuggestionsRunner(SimpleExecutor simpleExecutor, GraphQLQueryExecutor graphQLQueryExecutor, FriendSuggestionsCache friendSuggestionsCache, TokenPickerTokenUtil tokenPickerTokenUtil, AbstractFbErrorReporter abstractFbErrorReporter, AnalyticsLogger analyticsLogger) {
        this.f9099b = simpleExecutor;
        this.f9100c = graphQLQueryExecutor;
        this.f9101d = friendSuggestionsCache;
        this.f9102e = tokenPickerTokenUtil;
        this.f9104g = abstractFbErrorReporter;
        this.f9105h = analyticsLogger;
    }

    public final void m10879a(@Nullable final FutureCallback<ImmutableList<SimpleUserToken>> futureCallback, @Nullable final FutureCallback<ImmutableList<GroupTagToken>> futureCallback2) {
        ImmutableList immutableList;
        m10880b();
        FriendSuggestionsCache friendSuggestionsCache = this.f9101d;
        if (friendSuggestionsCache.f9089b == null || friendSuggestionsCache.f9092e + 600000 >= friendSuggestionsCache.f9093f.a()) {
            immutableList = friendSuggestionsCache.f9089b;
        } else {
            immutableList = null;
        }
        ImmutableList immutableList2 = immutableList;
        if (!(immutableList2 == null || futureCallback2 == null)) {
            futureCallback2.onSuccess(immutableList2);
        }
        friendSuggestionsCache = this.f9101d;
        if (friendSuggestionsCache.f9088a == null || friendSuggestionsCache.f9091d + 600000 >= friendSuggestionsCache.f9093f.a()) {
            immutableList = friendSuggestionsCache.f9088a;
        } else {
            immutableList = null;
        }
        immutableList2 = immutableList;
        if (immutableList2 == null) {
            this.f9106i = futureCallback;
            HandlerDetour.b(this.f9103f, this.f9107j, 4000, 1694459126);
            m10875a(this, "start");
            this.f9099b.a(GraphQLQueryExecutor.a(this.f9100c.a(m10877c())), new FutureCallback<FBPersonFriendTagSuggestionsQuery>(this) {
                final /* synthetic */ FriendSuggestionsRunner f9096c;

                public void onSuccess(Object obj) {
                    FBPersonFriendTagSuggestionsQueryModel fBPersonFriendTagSuggestionsQueryModel = (FBPersonFriendTagSuggestionsQueryModel) obj;
                    HandlerDetour.a(this.f9096c.f9103f, this.f9096c.f9107j);
                    ImmutableList a = fBPersonFriendTagSuggestionsQueryModel.a();
                    if (a != null) {
                        a = FriendSuggestionsRunner.m10874a(this.f9096c, a);
                        FriendSuggestionsCache friendSuggestionsCache = this.f9096c.f9101d;
                        friendSuggestionsCache.f9089b = a;
                        friendSuggestionsCache.f9092e = friendSuggestionsCache.f9093f.a();
                        if (futureCallback2 != null) {
                            futureCallback2.onSuccess(a);
                        }
                    }
                    if (fBPersonFriendTagSuggestionsQueryModel.b() != null) {
                        FriendSuggestionsRunner.m10875a(this.f9096c, "success");
                        a = FriendSuggestionsRunner.m10873a(this.f9096c, fBPersonFriendTagSuggestionsQueryModel);
                        String b = fBPersonFriendTagSuggestionsQueryModel.b().b();
                        FriendSuggestionsCache friendSuggestionsCache2 = this.f9096c.f9101d;
                        friendSuggestionsCache2.f9088a = a;
                        friendSuggestionsCache2.f9090c = b;
                        friendSuggestionsCache2.f9091d = friendSuggestionsCache2.f9093f.a();
                        if (futureCallback != null) {
                            futureCallback.onSuccess(a);
                        }
                    } else if (futureCallback != null) {
                        FriendSuggestionsRunner.m10875a(this.f9096c, "empty_list");
                        futureCallback.onFailure(new Throwable("Empty list retrieved"));
                    }
                }

                public void onFailure(Throwable th) {
                    FriendSuggestionsRunner.m10875a(this.f9096c, "fail");
                    HandlerDetour.a(this.f9096c.f9103f, this.f9096c.f9107j);
                    if (futureCallback != null) {
                        futureCallback.onFailure(th);
                    }
                }
            });
        } else if (futureCallback != null) {
            futureCallback.onSuccess(immutableList2);
        }
    }

    public static void m10875a(FriendSuggestionsRunner friendSuggestionsRunner, String str) {
        friendSuggestionsRunner.f9105h.a(new HoneyClientEvent("people_tag_suggestions_fetch").b("fetch_status", str));
    }

    public final String m10878a() {
        return this.f9101d.f9090c;
    }

    public final void m10880b() {
        HandlerDetour.a(this.f9103f, this.f9107j);
        this.f9099b.c();
    }

    private static GraphQLRequest m10877c() {
        FBPersonFriendTagSuggestionsQueryString b = TagSearchGraphQL.b();
        b.a("count", "10").a("profile_image_size", "80");
        return GraphQLRequest.a(TagSearchGraphQL.b()).a(b.a);
    }

    public static ImmutableList m10873a(FriendSuggestionsRunner friendSuggestionsRunner, FBPersonFriendTagSuggestionsQueryModel fBPersonFriendTagSuggestionsQueryModel) {
        Builder builder = ImmutableList.builder();
        UnmodifiableIterator it = fBPersonFriendTagSuggestionsQueryModel.b().a().iterator();
        while (it.hasNext()) {
            NodeModel a = ((EdgesModel) it.next()).a();
            if (a == null || a.d() == null) {
                friendSuggestionsRunner.f9104g.b(f9098a, "Invalid friendSuggestion " + a);
            } else {
                UserBuilder a2 = new UserBuilder().a(Type.FACEBOOK, a.b());
                a2.h = a.c();
                a2 = a2;
                a2.n = a.d().a();
                builder.c(new SimpleUserToken(TokenPickerTokenUtil.a(a2.aa())));
            }
        }
        return builder.b();
    }

    public static ImmutableList m10874a(FriendSuggestionsRunner friendSuggestionsRunner, ImmutableList immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            SuggestedWithGroupsModel suggestedWithGroupsModel = (SuggestedWithGroupsModel) immutableList.get(i);
            Builder builder2 = ImmutableList.builder();
            ImmutableList b = suggestedWithGroupsModel.b();
            int size2 = b.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String a;
                UsersModel usersModel = (UsersModel) b.get(i2);
                UserBuilder a2 = new UserBuilder().a(Type.FACEBOOK, usersModel.b());
                a2.h = usersModel.c();
                a2 = a2;
                if (usersModel.d() != null) {
                    a = usersModel.d().a();
                } else {
                    a = null;
                }
                a2.n = a;
                builder2.c(new SimpleUserToken(TokenPickerTokenUtil.a(a2.aa())));
            }
            builder.c(new GroupTagToken(builder2.b(), suggestedWithGroupsModel.a()));
        }
        return builder.b();
    }
}
