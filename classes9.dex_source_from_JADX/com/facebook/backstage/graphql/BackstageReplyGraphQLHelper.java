package com.facebook.backstage.graphql;

import android.net.Uri;
import com.facebook.backstage.abtest.BackstageGatekeepers;
import com.facebook.backstage.consumption.reply.ReplyDataProvider;
import com.facebook.backstage.consumption.reply.ReplyDataProvider.C05201;
import com.facebook.backstage.consumption.reply.ReplyDataProvider.C05201.C05181;
import com.facebook.backstage.data.BackstageProfile.Reply;
import com.facebook.backstage.data.BackstageUser;
import com.facebook.backstage.data.ReplyThread;
import com.facebook.backstage.data.ReplyThreadSummary;
import com.facebook.backstage.data.TimezoneDate;
import com.facebook.backstage.graphql.FBBackstageQuery.FBBackstageThreadsQueryString;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstagePostModel.PostMediaModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstageSeenByFragmentModel.SeenByUsersModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstageThreadsQueryModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstageThreadsQueryModel.BackstageThreadsModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstageThreadsQueryModel.BackstageThreadsModel.EdgesModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstageThreadsQueryModel.BackstageThreadsModel.EdgesModel.NodeModel.PostsModel.PostsEdgesModel;
import com.facebook.backstage.graphql.FBBackstageQueryModels.FBBackstageThreadsQueryModel.BackstageThreadsModel.EdgesModel.NodeModel.ThreadParticipantsModel.ThreadParticipantsEdgesModel;
import com.facebook.backstage.util.EmojiReplyUtil;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.locale.Locales;
import com.facebook.common.time.Clock;
import com.facebook.common.time.TimeConversions;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Date;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: requesterFbId */
public class BackstageReplyGraphQLHelper {
    public static final String f5235a = BackstageReplyGraphQLHelper.class.getSimpleName();
    private final Executor f5236b;
    private final GraphQLQueryExecutor f5237c;
    private final Locales f5238d;
    private final String f5239e;
    private final Clock f5240f;
    private final AbstractFbErrorReporter f5241g;
    private final BackstageGatekeepers f5242h;

    @Inject
    public BackstageReplyGraphQLHelper(Provider<String> provider, Executor executor, GraphQLQueryExecutor graphQLQueryExecutor, Locales locales, Clock clock, FbErrorReporter fbErrorReporter, BackstageGatekeepers backstageGatekeepers) {
        this.f5241g = fbErrorReporter;
        this.f5239e = (String) provider.get();
        this.f5236b = executor;
        this.f5237c = graphQLQueryExecutor;
        this.f5238d = locales;
        this.f5242h = backstageGatekeepers;
        this.f5240f = clock;
    }

    public final void m4988a(final C05201 c05201, GraphQLCachePolicy graphQLCachePolicy, final String str) {
        Futures.a(m4981a(graphQLCachePolicy), new FutureCallback<GraphQLResult<FBBackstageThreadsQueryModel>>(this) {
            final /* synthetic */ BackstageReplyGraphQLHelper f5232c;

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null) {
                    BLog.b(BackstageReplyGraphQLHelper.f5235a, "null result.");
                    return;
                }
                Builder builder = new Builder();
                BackstageReplyGraphQLHelper.m4982a(this.f5232c, str, builder, ((FBBackstageThreadsQueryModel) graphQLResult.e).m5470a());
                c05201.m4800a(new ReplyThread(str, builder.b()));
            }

            public void onFailure(Throwable th) {
                BLog.b(BackstageReplyGraphQLHelper.f5235a, "Reply result not available", th);
            }
        }, this.f5236b);
    }

    public static void m4982a(BackstageReplyGraphQLHelper backstageReplyGraphQLHelper, String str, Builder builder, BackstageThreadsModel backstageThreadsModel) {
        ImmutableList a = backstageThreadsModel.m5466a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            EdgesModel edgesModel = (EdgesModel) a.get(i);
            if (str.equals(edgesModel.m5461a().m5456j())) {
                ImmutableList a2 = edgesModel.m5461a().m5457k().m5420a();
                int size2 = a2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    PostsEdgesModel postsEdgesModel = (PostsEdgesModel) a2.get(i2);
                    builder.c(new Reply(postsEdgesModel.m5415a().m5201j(), postsEdgesModel.m5415a().m5202k().m5191k().m5154j(), postsEdgesModel.m5415a().m5202k().m5195o(), postsEdgesModel.m5415a().m5202k().m5192l() != null ? postsEdgesModel.m5415a().m5202k().m5192l().m5166a() : "", postsEdgesModel.m5415a().m5202k().m5193m().m5181j().m5172a(), m4980a(postsEdgesModel.m5415a().m5202k().m5190j(), postsEdgesModel.m5415a().m5204m()), ((float) postsEdgesModel.m5415a().m5202k().m5191k().m5150a()) / ((float) postsEdgesModel.m5415a().m5202k().m5191k().m5155k())));
                }
                return;
            }
        }
    }

    public final void m4987a(final C05201 c05201, GraphQLCachePolicy graphQLCachePolicy) {
        Futures.a(m4981a(graphQLCachePolicy), new FutureCallback<GraphQLResult<FBBackstageThreadsQueryModel>>(this) {
            final /* synthetic */ BackstageReplyGraphQLHelper f5234b;

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null) {
                    BLog.b(BackstageReplyGraphQLHelper.f5235a, "null result.");
                    return;
                }
                Builder builder = new Builder();
                ImmutableList a = ((FBBackstageThreadsQueryModel) graphQLResult.e).m5470a().m5466a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    ReplyThreadSummary a2 = BackstageReplyGraphQLHelper.m4979a(this.f5234b, (EdgesModel) a.get(i));
                    if (a2 != null) {
                        builder.c(a2);
                    }
                }
                C05201 c05201 = c05201;
                ImmutableList b = builder.b();
                ExecutorDetour.a(c05201.f4952a.f4961g, new C05181(c05201, c05201.f4952a.f4959e.m4901a(), ReplyDataProvider.m4802a(c05201.f4952a, b)), -880783333);
            }

            public void onFailure(Throwable th) {
                BLog.b(BackstageReplyGraphQLHelper.f5235a, "Reply result not available", th);
            }
        }, this.f5236b);
    }

    public static ReplyThreadSummary m4979a(BackstageReplyGraphQLHelper backstageReplyGraphQLHelper, EdgesModel edgesModel) {
        String j = edgesModel.m5461a().m5456j();
        String str = null;
        String str2 = null;
        Date date = null;
        String str3 = null;
        ImmutableList a = edgesModel.m5461a().m5457k().m5420a();
        String j2 = ((PostsEdgesModel) a.get(0)).m5415a().m5202k().m5191k().m5154j();
        if (a.size() == 2 && backstageReplyGraphQLHelper.f5239e.equals(((PostsEdgesModel) a.get(a.size() - 1)).m5415a().m5202k().m5193m().m5180b())) {
            return null;
        }
        String str4;
        Date a2;
        String str5;
        Date d;
        int size = a.size() - 1;
        while (size >= 0) {
            PostsEdgesModel postsEdgesModel = (PostsEdgesModel) a.get(size);
            PostMediaModel k = postsEdgesModel.m5415a().m5202k();
            String b = k.m5189b().m5180b();
            if (k.m5186a() == null || !EmojiReplyUtil.m5771a(k.m5186a().m5166a())) {
                str4 = str3;
            } else {
                str4 = k.m5186a().m5166a();
            }
            if (backstageReplyGraphQLHelper.f5239e.equals(b)) {
                str2 = postsEdgesModel.m5415a().m5201j();
                str3 = Strings.isNullOrEmpty(str4) ? postsEdgesModel.m5415a().m5202k().m5191k().m5154j() : j2;
                a2 = m4980a(postsEdgesModel.m5415a().m5202k().m5190j(), postsEdgesModel.m5415a().m5204m());
                str5 = str3;
                str3 = str2;
            } else {
                ImmutableList a3 = postsEdgesModel.m5415a().m5203l().m5402a();
                int size2 = a3.size();
                int i = 0;
                while (i < size2) {
                    if (backstageReplyGraphQLHelper.f5239e.equals(((SeenByUsersModel.EdgesModel) a3.get(i)).m5397a().m5392j())) {
                        str3 = postsEdgesModel.m5415a().m5201j();
                        str5 = Strings.isNullOrEmpty(str4) ? postsEdgesModel.m5415a().m5202k().m5191k().m5154j() : j2;
                        a2 = m4980a(postsEdgesModel.m5415a().m5202k().m5190j(), postsEdgesModel.m5415a().m5204m());
                        if (Strings.isNullOrEmpty(str3)) {
                            break;
                        }
                        size--;
                        str = str5;
                        date = a2;
                        str2 = str3;
                        str3 = str4;
                    } else {
                        i++;
                    }
                }
                a2 = date;
                str3 = str2;
                str5 = str;
                if (Strings.isNullOrEmpty(str3)) {
                    break;
                }
                size--;
                str = str5;
                date = a2;
                str2 = str3;
                str3 = str4;
            }
        }
        str4 = str3;
        a2 = date;
        str3 = str2;
        str5 = str;
        if (Strings.isNullOrEmpty(str3)) {
            BLog.b(f5235a, "Error, unable to find the last seen item.");
            if (edgesModel.m5461a().m5457k().m5420a().size() <= 0) {
                return null;
            }
            str3 = m4983b(edgesModel);
            str5 = m4984c(edgesModel);
            d = backstageReplyGraphQLHelper.m4985d(edgesModel);
        } else {
            d = a2;
        }
        BackstageUser e = backstageReplyGraphQLHelper.m4986e(edgesModel);
        if (e == null) {
            return null;
        }
        if (backstageReplyGraphQLHelper.f5242h.m4257a() || d.after(new Date(backstageReplyGraphQLHelper.f5240f.a() - 172800000))) {
            return new ReplyThreadSummary(j, str3, str5, d, e, str4);
        }
        return null;
    }

    private ListenableFuture<GraphQLResult<FBBackstageThreadsQueryModel>> m4981a(GraphQLCachePolicy graphQLCachePolicy) {
        GraphQlQueryString fBBackstageThreadsQueryString = new FBBackstageThreadsQueryString();
        fBBackstageThreadsQueryString.a("3", "4");
        return this.f5237c.a(GraphQLRequest.a(fBBackstageThreadsQueryString).a(graphQLCachePolicy).a(7200));
    }

    private static String m4983b(EdgesModel edgesModel) {
        return ((PostsEdgesModel) edgesModel.m5461a().m5457k().m5420a().get(0)).m5415a().m5201j();
    }

    private static String m4984c(EdgesModel edgesModel) {
        return ((PostsEdgesModel) edgesModel.m5461a().m5457k().m5420a().get(0)).m5415a().m5202k().m5191k().m5154j();
    }

    private TimezoneDate m4985d(EdgesModel edgesModel) {
        return m4980a(((PostsEdgesModel) edgesModel.m5461a().m5457k().m5420a().get(0)).m5415a().m5202k().m5190j(), ((PostsEdgesModel) edgesModel.m5461a().m5457k().m5420a().get(0)).m5415a().m5204m());
    }

    private BackstageUser m4986e(EdgesModel edgesModel) {
        int i = 0;
        if (edgesModel.m5461a().m5458l().m5452a().size() != 2) {
            this.f5241g.a(f5235a, "Wrong thread participants size. id : " + edgesModel.m5461a().m5456j());
            return null;
        }
        Preconditions.checkArgument(edgesModel.m5461a().m5458l().m5452a().size() == 2);
        ImmutableList a = edgesModel.m5461a().m5458l().m5452a();
        int size = a.size();
        while (i < size) {
            ThreadParticipantsEdgesModel threadParticipantsEdgesModel = (ThreadParticipantsEdgesModel) a.get(i);
            if (!this.f5239e.equals(threadParticipantsEdgesModel.m5448a().m5443j())) {
                return new BackstageUser(threadParticipantsEdgesModel.m5448a().m5445l(), Uri.parse(threadParticipantsEdgesModel.m5448a().m5446m().m5436a()), Uri.parse(threadParticipantsEdgesModel.m5448a().m5444k().m5431a()));
            }
            i++;
        }
        throw new RuntimeException("Unable to retrieve thread owner.");
    }

    private static TimezoneDate m4980a(long j, int i) {
        return new TimezoneDate(TimeConversions.o(j), TimeConversions.o((long) i));
    }
}
