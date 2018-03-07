package com.facebook.redspace.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.api.feedcache.memory.FeedUnitTagHelper;
import com.facebook.api.feedcache.memory.pendingstory.PendingStoryCache;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.model.Feedbackable;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.parser.GraphQlIdParserUtil;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.redspace.fragment.RedSpaceStoriesFragment;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceStoriesQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceStoriesQueryModel.RedspaceModel.WallModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceWallItemFragmentModel;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;

/* compiled from: Platform / Games / Apps */
public class RedSpaceWallCollection implements ListItemCollection<Object> {
    @Inject
    public volatile Provider<RedSpaceWallItemDebugWriter> f11888a = UltralightRuntime.a;
    public DefaultPageInfoFieldsModel f11889b;
    public ImmutableList<RedSpaceWallItemFragmentModel> f11890c;
    public RedSpaceFeedProfileFragmentModel f11891d;
    public RedSpaceStoriesFragment f11892e;
    @Inject
    public PendingStoryCache f11893f;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbErrorReporter> f11894g = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceNewsFeedTitle> f11895h = UltralightRuntime.b;
    private final FutureCallback<GraphQLResult<GraphQLStory>> f11896i = new C14121(this);
    private final FutureCallback<GraphQLResult<GraphQLFeedback>> f11897j = new C14132(this);

    /* compiled from: Platform / Games / Apps */
    class C14121 implements FutureCallback<GraphQLResult<GraphQLStory>> {
        final /* synthetic */ RedSpaceWallCollection f11882a;

        C14121(RedSpaceWallCollection redSpaceWallCollection) {
            this.f11882a = redSpaceWallCollection;
        }

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult.e != null) {
                this.f11882a.m12344a((GraphQLStory) graphQLResult.e);
                RedSpaceWallCollection.m12338m(this.f11882a);
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: Platform / Games / Apps */
    class C14132 implements FutureCallback<GraphQLResult<GraphQLFeedback>> {
        final /* synthetic */ RedSpaceWallCollection f11883a;

        C14132(RedSpaceWallCollection redSpaceWallCollection) {
            this.f11883a = redSpaceWallCollection;
        }

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult.e != null) {
                Feedbackable feedbackable;
                RedSpaceWallCollection redSpaceWallCollection = this.f11883a;
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLResult.e;
                String j = graphQLFeedback.j();
                if (j == null || redSpaceWallCollection.f11890c == null) {
                    feedbackable = null;
                } else {
                    for (int i = 0; i < redSpaceWallCollection.m12339a(); i++) {
                        Object a = redSpaceWallCollection.m12341a(i);
                        if (a instanceof Feedbackable) {
                            feedbackable = (Feedbackable) a;
                            String a2 = GraphQlIdParserUtil.a(j);
                            GraphQLFeedback l = feedbackable.l();
                            if (l != null) {
                                if (a2.equals(l.j()) || j.equals(l.j())) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                    feedbackable = null;
                }
                Feedbackable feedbackable2 = feedbackable;
                if (feedbackable2 != null && (feedbackable2 instanceof GraphQLStory)) {
                    Builder a3 = Builder.a((GraphQLStory) feedbackable2);
                    a3.D = graphQLFeedback;
                    a3 = a3;
                    a3.F = SystemClock.a.a();
                    redSpaceWallCollection.m12344a(a3.a());
                }
                RedSpaceWallCollection.m12338m(this.f11883a);
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: Platform / Games / Apps */
    public class State implements Parcelable {
        public static final Creator<State> CREATOR = new C14141();
        public final Map<String, GraphQLStory> f11884a;
        public final ImmutableList<RedSpaceWallItemFragmentModel> f11885b;
        public final DefaultPageInfoFieldsModel f11886c;
        public final RedSpaceFeedProfileFragmentModel f11887d;

        /* compiled from: Platform / Games / Apps */
        final class C14141 implements Creator<State> {
            C14141() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new State(parcel);
            }

            public final Object[] newArray(int i) {
                return new State[i];
            }
        }

        public State(PendingStoryCache pendingStoryCache, @Nullable ImmutableList<RedSpaceWallItemFragmentModel> immutableList, @Nullable DefaultPageInfoFieldsModel defaultPageInfoFieldsModel, RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
            this.f11884a = new ArrayMap(pendingStoryCache.c());
            for (String str : pendingStoryCache.b.keySet()) {
                this.f11884a.put(str, pendingStoryCache.f(str));
            }
            this.f11885b = immutableList;
            this.f11886c = defaultPageInfoFieldsModel;
            this.f11887d = redSpaceFeedProfileFragmentModel;
        }

        protected State(Parcel parcel) {
            this.f11884a = FlatBufferModelHelper.c(parcel);
            this.f11885b = ImmutableList.copyOf(FlatBufferModelHelper.b(parcel));
            this.f11886c = (DefaultPageInfoFieldsModel) FlatBufferModelHelper.a(parcel);
            this.f11887d = (RedSpaceFeedProfileFragmentModel) FlatBufferModelHelper.a(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            FlatBufferModelHelper.a(parcel, this.f11884a);
            FlatBufferModelHelper.a(parcel, this.f11885b);
            FlatBufferModelHelper.a(parcel, this.f11886c);
            FlatBufferModelHelper.a(parcel, this.f11887d);
        }
    }

    public static RedSpaceWallCollection m12324a(InjectorLike injectorLike) {
        RedSpaceWallCollection redSpaceWallCollection = new RedSpaceWallCollection();
        Provider a = IdBasedProvider.a(injectorLike, 10178);
        PendingStoryCache b = PendingStoryCache.b(injectorLike);
        com.facebook.inject.Lazy b2 = IdBasedSingletonScopeProvider.b(injectorLike, 494);
        com.facebook.inject.Lazy a2 = IdBasedLazy.a(injectorLike, 10173);
        redSpaceWallCollection.f11888a = a;
        redSpaceWallCollection.f11893f = b;
        redSpaceWallCollection.f11894g = b2;
        redSpaceWallCollection.f11895h = a2;
        return redSpaceWallCollection;
    }

    public final void m12346a(RedSpaceStoriesQueryModel redSpaceStoriesQueryModel) {
        m12326a(redSpaceStoriesQueryModel, false);
    }

    private ImmutableList<RedSpaceWallItemFragmentModel> m12325a(ImmutableList<RedSpaceWallItemFragmentModel> immutableList) {
        int i;
        List arrayList = new ArrayList();
        for (i = 0; i < immutableList.size(); i++) {
            Object obj;
            RedSpaceWallItemFragmentModel redSpaceWallItemFragmentModel = (RedSpaceWallItemFragmentModel) immutableList.get(i);
            if (redSpaceWallItemFragmentModel == null || redSpaceWallItemFragmentModel.j() == null) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (arrayList.isEmpty()) {
            return immutableList;
        }
        ((AbstractFbErrorReporter) this.f11894g.get()).a(getClass().getSimpleName(), "invalid items in wall " + ((RedSpaceWallItemDebugWriter) this.f11888a.get()).m12359a((RedSpaceWallItemFragmentModel) immutableList.get(((Integer) arrayList.get(0)).intValue())));
        Collection arrayList2 = new ArrayList(immutableList);
        for (i = arrayList.size() - 1; i >= 0; i--) {
            arrayList2.remove(((Integer) arrayList.get(i)).intValue());
        }
        return ImmutableList.copyOf(arrayList2);
    }

    private void m12326a(RedSpaceStoriesQueryModel redSpaceStoriesQueryModel, boolean z) {
        Object obj;
        if (redSpaceStoriesQueryModel == null || redSpaceStoriesQueryModel.j() == null || redSpaceStoriesQueryModel.j().j() == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            WallModel j = redSpaceStoriesQueryModel.j().j();
            this.f11890c = RedSpaceMutator.m12296a(this.f11890c, m12325a(j.a()), z);
            this.f11889b = RedSpaceMutator.m12290a(this.f11889b, j.j());
            m12333h();
            m12332g();
        }
    }

    private void m12332g() {
        int i = 0;
        for (int i2 = 0; i2 < m12339a(); i2++) {
            Object a = m12341a(i2);
            if (a instanceof GraphQLStory) {
                PropertyHelper.a((GraphQLStory) a, i);
                i++;
            }
        }
    }

    private void m12333h() {
        if (this.f11890c != null) {
            int size = this.f11890c.size();
            for (int i = 0; i < size; i++) {
                RedSpaceWallItemFragmentModel redSpaceWallItemFragmentModel = (RedSpaceWallItemFragmentModel) this.f11890c.get(i);
                if (!(redSpaceWallItemFragmentModel == null || redSpaceWallItemFragmentModel.j() == null)) {
                    this.f11893f.c(redSpaceWallItemFragmentModel.j().c());
                }
            }
        }
    }

    @Nullable
    public final GraphQLStory m12340a(String str) {
        return this.f11893f.f(str);
    }

    public final void m12347b(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (str != null) {
            m12329d(str);
        }
        if (str2 != null) {
            m12330e(str2);
        }
        if (str3 != null) {
            m12331f(str3);
        }
    }

    private void m12329d(String str) {
        ImmutableList immutableList;
        ImmutableList immutableList2 = this.f11890c;
        if (immutableList2 == null) {
            immutableList = null;
        } else {
            Collection arrayList = new ArrayList();
            for (int i = 0; i < immutableList2.size(); i++) {
                RedSpaceWallItemFragmentModel redSpaceWallItemFragmentModel = (RedSpaceWallItemFragmentModel) immutableList2.get(i);
                if (redSpaceWallItemFragmentModel != null) {
                    GraphQLStory j = redSpaceWallItemFragmentModel.j();
                    if (j == null) {
                        arrayList.add(redSpaceWallItemFragmentModel);
                    } else if (!StringUtil.a(j.g(), str)) {
                        arrayList.add(redSpaceWallItemFragmentModel);
                    }
                }
            }
            immutableList = ImmutableList.copyOf(arrayList);
        }
        this.f11890c = immutableList;
        m12332g();
    }

    private void m12330e(String str) {
        this.f11893f.a(str);
        m12332g();
    }

    private void m12331f(String str) {
        this.f11893f.b(str);
        m12332g();
    }

    public final void m12344a(GraphQLStory graphQLStory) {
        Object obj;
        ImmutableList immutableList;
        if (graphQLStory.g() == null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            if (graphQLStory.c() != null && graphQLStory.l() != null) {
                this.f11893f.a(graphQLStory);
            } else if (this.f11893f.d(graphQLStory.T())) {
                this.f11893f.a(graphQLStory.T(), graphQLStory);
            }
        }
        ImmutableList immutableList2 = this.f11890c;
        if (immutableList2 == null) {
            immutableList = null;
        } else {
            Collection arrayList = new ArrayList(immutableList2.size());
            for (int i = 0; i < immutableList2.size(); i++) {
                RedSpaceWallItemFragmentModel redSpaceWallItemFragmentModel = (RedSpaceWallItemFragmentModel) immutableList2.get(i);
                if (!(redSpaceWallItemFragmentModel == null || redSpaceWallItemFragmentModel.j() == null)) {
                    Object obj2;
                    GraphQLStory j = redSpaceWallItemFragmentModel.j();
                    if ((StringUtil.a(j.g()) || !StringUtil.a(j.g(), graphQLStory.g())) && (StringUtil.a(j.c()) || !StringUtil.a(j.c(), graphQLStory.c()))) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        PropertyHelper.a(j, PropertyHelper.f(j));
                        RedSpaceWallItemFragmentModel.Builder builder = new RedSpaceWallItemFragmentModel.Builder();
                        builder.a = redSpaceWallItemFragmentModel.a();
                        builder.b = redSpaceWallItemFragmentModel.j();
                        builder.c = redSpaceWallItemFragmentModel.k();
                        RedSpaceWallItemFragmentModel.Builder builder2 = builder;
                        builder2.b = graphQLStory;
                        arrayList.add(builder2.a());
                    }
                }
                arrayList.add(redSpaceWallItemFragmentModel);
            }
            immutableList = ImmutableList.copyOf(arrayList);
        }
        this.f11890c = immutableList;
        m12333h();
        m12332g();
    }

    public final void m12342a(GraphQLSubscriptionHolder graphQLSubscriptionHolder) {
        for (int i = 0; i < m12339a(); i++) {
            Object a = m12341a(i);
            if (a instanceof GraphQLStory) {
                GraphQLStory graphQLStory = (GraphQLStory) a;
                m12343a(graphQLSubscriptionHolder, graphQLStory);
                m12327b(graphQLSubscriptionHolder, graphQLStory);
            }
        }
    }

    public final void m12343a(GraphQLSubscriptionHolder graphQLSubscriptionHolder, GraphQLStory graphQLStory) {
        graphQLSubscriptionHolder.a(this.f11896i, graphQLStory.c(), new GraphQLResult(graphQLStory, DataFreshnessResult.FROM_CACHE_UP_TO_DATE, 0, FeedUnitTagHelper.a(graphQLStory, false)));
    }

    private void m12327b(GraphQLSubscriptionHolder graphQLSubscriptionHolder, GraphQLStory graphQLStory) {
        if (!(graphQLStory.l() == null || graphQLStory.l().z_() == null || graphQLStory.l().j() == null)) {
            graphQLSubscriptionHolder.a(this.f11897j, graphQLStory.l().z_(), new GraphQLResult(graphQLStory.l(), DataFreshnessResult.FROM_CACHE_UP_TO_DATE, 0, ImmutableSet.of(graphQLStory.l().j())));
        }
        if (!(StoryHierarchyHelper.a(graphQLStory) == null || StoryHierarchyHelper.a(graphQLStory).j() == null)) {
            ImmutableList j = StoryHierarchyHelper.a(graphQLStory).j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                m12327b(graphQLSubscriptionHolder, (GraphQLStory) j.get(i));
            }
        }
        if (graphQLStory.L() != null) {
            m12327b(graphQLSubscriptionHolder, graphQLStory.L());
        }
    }

    public final boolean m12348c() {
        return this.f11889b == null || this.f11889b.b();
    }

    public final int m12349e() {
        return m12334i() + m12335j();
    }

    private int m12334i() {
        return this.f11893f.c();
    }

    private int m12335j() {
        return this.f11890c == null ? 0 : this.f11890c.size();
    }

    private int m12336k() {
        if (m12348c() || m12334i() + m12335j() <= 0 || this.f11891d == null) {
            return 0;
        }
        return 1;
    }

    private int m12337l() {
        return m12334i() + m12335j() > 0 ? 1 : 0;
    }

    public final int m12339a() {
        return ((m12334i() + m12335j()) + m12336k()) + m12337l();
    }

    public final Object m12341a(int i) {
        if (m12336k() > 0 && i == m12339a() - 1) {
            return this.f11891d;
        }
        if (m12337l() == 1 && i == 0) {
            return this.f11895h.get();
        }
        if (i - m12337l() >= m12334i()) {
            return m12328c((i - m12334i()) - m12337l());
        }
        return (GraphQLStory) ((GraphQLFeedUnitEdge) this.f11893f.a().get(i - m12337l())).c();
    }

    @VisibleForTesting
    private Object m12328c(int i) {
        return ((RedSpaceWallItemFragmentModel) this.f11890c.get(i)).j();
    }

    public static void m12338m(RedSpaceWallCollection redSpaceWallCollection) {
        if (redSpaceWallCollection.f11892e != null) {
            RedSpaceStoriesFragment.at(redSpaceWallCollection.f11892e);
        }
    }

    public final void m12345a(@Nullable State state, GraphQLSubscriptionHolder graphQLSubscriptionHolder) {
        if (state != null) {
            for (String str : state.f11884a.keySet()) {
                this.f11893f.a(str, (GraphQLStory) state.f11884a.get(str));
            }
            this.f11890c = state.f11885b;
            this.f11889b = state.f11886c;
            this.f11891d = state.f11887d;
            m12333h();
            m12332g();
            m12342a(graphQLSubscriptionHolder);
        }
    }
}
