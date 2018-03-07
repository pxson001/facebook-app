package com.facebook.redspace.data;

import android.util.Pair;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQLRefParam;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.redspace.badge.RedSpaceTabUnseenCountFetcher;
import com.facebook.redspace.fetcher.RedSpaceBatchFetcher;
import com.facebook.redspace.fetcher.RedSpaceBatchRequests;
import com.facebook.redspace.fetcher.RedSpaceBatchRequests.RedSpaceFriendsWithOverflowResult;
import com.facebook.redspace.fetcher.RedSpaceRequests;
import com.facebook.redspace.fetcher.RedSpaceRequests.ExportedParam;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsQueryModel.RedspaceModel.FriendsModel;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.lang.ref.WeakReference;

/* compiled from: PrivacyCheckupRoute */
public class RedSpaceFriendsFetcherHelper {
    private static final String f11790a = RedSpaceFriendsFetcherHelper.class.getSimpleName();
    @Inject
    private RedSpaceBatchRequests f11791b;
    @Inject
    private RedSpaceRequests f11792c;
    @Inject
    private RedSpaceBatchFetcher f11793d;
    @Inject
    private RedSpaceTabUnseenCountFetcher f11794e;
    @Inject
    public RedSpaceFriendsCacheHelper f11795f;
    @Inject
    public QeAccessor f11796g;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbErrorReporter> f11797h = UltralightRuntime.b;
    public final WeakReference<RedSpaceFriendsFetchListener> f11798i;
    public final ImmutableList<Pair<RedSpaceFriendsSection, RedSpaceFriendsCollection>> f11799j;
    private final Params f11800k;
    public boolean f11801l = false;
    public boolean f11802m;

    /* compiled from: PrivacyCheckupRoute */
    public class Params {
        public boolean f11789a;
    }

    /* compiled from: PrivacyCheckupRoute */
    public interface RedSpaceFriendsFetchListener {
        void mo343a(RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFriendsCollection redSpaceFriendsCollection);

        void mo344a(RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFriendsCollection redSpaceFriendsCollection, RedSpaceFriendsFetchResult redSpaceFriendsFetchResult);

        void a_(Throwable th);
    }

    final void m12232a(RedSpaceBatchRequests redSpaceBatchRequests, RedSpaceRequests redSpaceRequests, RedSpaceBatchFetcher redSpaceBatchFetcher, RedSpaceTabUnseenCountFetcher redSpaceTabUnseenCountFetcher, RedSpaceFriendsCacheHelper redSpaceFriendsCacheHelper, QeAccessor qeAccessor, com.facebook.inject.Lazy<FbErrorReporter> lazy) {
        this.f11791b = redSpaceBatchRequests;
        this.f11792c = redSpaceRequests;
        this.f11793d = redSpaceBatchFetcher;
        this.f11794e = redSpaceTabUnseenCountFetcher;
        this.f11795f = redSpaceFriendsCacheHelper;
        this.f11796g = qeAccessor;
        this.f11797h = lazy;
    }

    @Inject
    public RedSpaceFriendsFetcherHelper(@Assisted RedSpaceFriendsFetchListener redSpaceFriendsFetchListener, @Assisted ImmutableList<Pair<RedSpaceFriendsSection, RedSpaceFriendsCollection>> immutableList, @Assisted Params params) {
        Preconditions.checkNotNull(redSpaceFriendsFetchListener, "listener must not be null");
        Preconditions.checkNotNull(immutableList, "List of collections and section must not be null");
        this.f11798i = new WeakReference(redSpaceFriendsFetchListener);
        this.f11799j = immutableList;
        this.f11800k = params;
    }

    public final void m12231a() {
        if (!this.f11793d.b()) {
            int size = this.f11799j.size();
            int i = 0;
            while (i < size) {
                Pair pair = (Pair) this.f11799j.get(i);
                if (!((RedSpaceFriendsCollection) pair.second).m12218a()) {
                    i++;
                } else if (this.f11802m || ((RedSpaceFriendsCollection) pair.second).m12222d() != 0 || ((RedSpaceFriendsSection) pair.first).isOverflow()) {
                    m12230c((RedSpaceFriendsSection) pair.first, (RedSpaceFriendsCollection) pair.second);
                    m12229b(this, (RedSpaceFriendsSection) pair.first, (RedSpaceFriendsCollection) pair.second);
                    return;
                } else {
                    m12230c((RedSpaceFriendsSection) pair.first, (RedSpaceFriendsCollection) pair.second);
                    final RedSpaceFriendsSection redSpaceFriendsSection = (RedSpaceFriendsSection) pair.first;
                    final RedSpaceFriendsCollection redSpaceFriendsCollection = (RedSpaceFriendsCollection) pair.second;
                    if (this.f11796g.a(ExperimentsForRedSpaceExperimentsModule.d, false)) {
                        this.f11795f.m12209a(redSpaceFriendsSection, new Object(this) {
                            public final /* synthetic */ RedSpaceFriendsFetcherHelper f11783c;
                        });
                    } else {
                        m12229b(this, redSpaceFriendsSection, redSpaceFriendsCollection);
                    }
                    return;
                }
            }
        }
    }

    public static void m12229b(RedSpaceFriendsFetcherHelper redSpaceFriendsFetcherHelper, final RedSpaceFriendsSection redSpaceFriendsSection, final RedSpaceFriendsCollection redSpaceFriendsCollection) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        GraphQLRefParam graphQLRefParam = null;
        C13972 c13972 = new FutureCallback<RedSpaceFriendsWithOverflowResult>(redSpaceFriendsFetcherHelper) {
            final /* synthetic */ RedSpaceFriendsFetcherHelper f11788c;

            public void onSuccess(Object obj) {
                final RedSpaceFriendsWithOverflowResult redSpaceFriendsWithOverflowResult = (RedSpaceFriendsWithOverflowResult) obj;
                if (redSpaceFriendsWithOverflowResult.a() == null || redSpaceFriendsWithOverflowResult.a().e == null || ((RedSpaceFriendsQueryModel) redSpaceFriendsWithOverflowResult.a().e).j() == null || ((RedSpaceFriendsQueryModel) redSpaceFriendsWithOverflowResult.a().e).j().a() == null) {
                    onFailure(new NullPointerException("Null result " + redSpaceFriendsWithOverflowResult));
                } else if (redSpaceFriendsSection.isOverflow()) {
                    RedSpaceFriendsFetcherHelper.m12228a(this.f11788c, RedSpaceFriendsFetchResult.m12225a(redSpaceFriendsWithOverflowResult.a(), redSpaceFriendsWithOverflowResult.b()), redSpaceFriendsSection, redSpaceFriendsCollection);
                } else {
                    RedSpaceFriendsCacheHelper redSpaceFriendsCacheHelper = this.f11788c.f11795f;
                    RedSpaceFriendsSection redSpaceFriendsSection = redSpaceFriendsSection;
                    Runnable c13961 = new Runnable(this) {
                        final /* synthetic */ C13972 f11785b;

                        public void run() {
                            this.f11785b.f11788c.f11802m = false;
                            RedSpaceFriendsFetcherHelper.m12228a(this.f11785b.f11788c, RedSpaceFriendsFetchResult.m12225a(redSpaceFriendsWithOverflowResult.a(), redSpaceFriendsWithOverflowResult.b()), redSpaceFriendsSection, redSpaceFriendsCollection);
                        }
                    };
                    if (!(redSpaceFriendsWithOverflowResult.a() == null || ((RedSpaceFriendsQueryModel) redSpaceFriendsWithOverflowResult.a().e).j() == null || ((RedSpaceFriendsQueryModel) redSpaceFriendsWithOverflowResult.a().e).j().a() == null)) {
                        FriendsModel a = ((RedSpaceFriendsQueryModel) redSpaceFriendsWithOverflowResult.a().e).j().a();
                        redSpaceFriendsCacheHelper.f11771a.a(ImmutableList.copyOf(a.a()), redSpaceFriendsSection.getApiName(), false);
                        redSpaceFriendsCacheHelper.f11771a.a(a.j(), redSpaceFriendsSection.getApiName());
                        if (!(((RedSpaceFriendsQueryModel) redSpaceFriendsWithOverflowResult.a().e).a() == null || ((RedSpaceFriendsQueryModel) redSpaceFriendsWithOverflowResult.a().e).a().a() == null)) {
                            redSpaceFriendsCacheHelper.f11771a.d = ((RedSpaceFriendsQueryModel) redSpaceFriendsWithOverflowResult.a().e).a().a().a();
                        }
                        if (redSpaceFriendsWithOverflowResult.b() == null || ((RedSpaceFriendsOverflowCountQueryModel) redSpaceFriendsWithOverflowResult.b().e).a() == null) {
                            redSpaceFriendsCacheHelper.f11771a.a(null, redSpaceFriendsSection.getApiName());
                        } else {
                            redSpaceFriendsCacheHelper.f11771a.a(((RedSpaceFriendsOverflowCountQueryModel) redSpaceFriendsWithOverflowResult.b().e).a().a(), redSpaceFriendsSection.getApiName());
                        }
                    }
                    if (redSpaceFriendsSection == RedSpaceFriendsSection.TOP) {
                        redSpaceFriendsCacheHelper.f11771a.a(RedSpaceFriendsSection.OTHERS.getApiName());
                    }
                    if (c13961 != null) {
                        c13961.run();
                    }
                }
            }

            public void onFailure(Throwable th) {
                ((AbstractFbErrorReporter) this.f11788c.f11797h.get()).a(getClass().getSimpleName(), "Friends fetch failure", th);
                this.f11788c.f11801l = true;
                RedSpaceFriendsFetchListener redSpaceFriendsFetchListener = (RedSpaceFriendsFetchListener) this.f11788c.f11798i.get();
                if (redSpaceFriendsFetchListener != null) {
                    redSpaceFriendsFetchListener.a_(th);
                }
            }
        };
        boolean z4 = redSpaceFriendsFetcherHelper.f11800k.f11789a && redSpaceFriendsCollection.m12219b() == null && redSpaceFriendsSection.isTop();
        RedSpaceRequests redSpaceRequests = redSpaceFriendsFetcherHelper.f11792c;
        String apiName = redSpaceFriendsSection.getApiName();
        Boolean valueOf = Boolean.valueOf(redSpaceFriendsFetcherHelper.f11800k.f11789a);
        String b = redSpaceFriendsCollection.m12219b();
        if (redSpaceFriendsFetcherHelper.f11800k.f11789a) {
            z = false;
        } else {
            z = true;
        }
        Boolean valueOf2 = Boolean.valueOf(z);
        if (redSpaceFriendsFetcherHelper.f11800k.f11789a) {
            z2 = false;
        } else {
            z2 = true;
        }
        Boolean valueOf3 = Boolean.valueOf(z2);
        if (z4) {
            z3 = false;
        }
        GraphQLRequest a = redSpaceRequests.a(apiName, valueOf, null, b, null, null, valueOf2, valueOf3, null, Boolean.valueOf(z3));
        if (redSpaceFriendsFetcherHelper.f11800k.f11789a) {
            graphQLRefParam = a.b("has_more_friends");
        }
        GraphQLRequest a2 = redSpaceFriendsFetcherHelper.f11792c.a(redSpaceFriendsSection.getApiName(), new ExportedParam(graphQLRefParam));
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("redspace_friends_with_overflow");
        redSpaceFriendsFetcherHelper.f11793d.a(graphQLBatchRequest, redSpaceFriendsFetcherHelper.f11791b.b(graphQLBatchRequest, a, a2), c13972);
    }

    public static void m12228a(RedSpaceFriendsFetcherHelper redSpaceFriendsFetcherHelper, RedSpaceFriendsFetchResult redSpaceFriendsFetchResult, RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFriendsCollection redSpaceFriendsCollection) {
        redSpaceFriendsCollection.m12214a(redSpaceFriendsFetchResult);
        RedSpaceFriendsFetchListener redSpaceFriendsFetchListener = (RedSpaceFriendsFetchListener) redSpaceFriendsFetcherHelper.f11798i.get();
        if (redSpaceFriendsFetchListener != null) {
            redSpaceFriendsFetchListener.mo344a(redSpaceFriendsSection, redSpaceFriendsCollection, redSpaceFriendsFetchResult);
        }
    }

    private void m12230c(RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFriendsCollection redSpaceFriendsCollection) {
        RedSpaceFriendsFetchListener redSpaceFriendsFetchListener = (RedSpaceFriendsFetchListener) this.f11798i.get();
        this.f11801l = false;
        if (redSpaceFriendsFetchListener != null) {
            redSpaceFriendsFetchListener.mo343a(redSpaceFriendsSection, redSpaceFriendsCollection);
        }
    }

    public final void m12233d() {
        this.f11798i.clear();
        m12234e();
    }

    public final void m12234e() {
        this.f11793d.a();
    }
}
