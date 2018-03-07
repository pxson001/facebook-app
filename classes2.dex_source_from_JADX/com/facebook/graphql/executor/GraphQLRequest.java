package com.facebook.graphql.executor;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.graphql.executor.GraphQLQueryExecutor.CacheProcessor;
import com.facebook.graphql.executor.cache.GraphQLRequestDiskCache;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.query.GraphQLRefParam;
import com.facebook.graphql.query.GraphQLRefParam.BatchQueryFanOutStyle;
import com.facebook.graphql.query.GraphQLRefParam.FallbackStyle;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.http.common.FbRequestState;
import com.facebook.http.interfaces.RequestPriority;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import org.apache.http.Header;

/* compiled from: resign */
public class GraphQLRequest<T> {
    private static final AtomicInteger f7082n = new AtomicInteger(0);
    public GraphQLCachePolicy f7083a;
    public boolean f7084b;
    public GraphQLCacheKeySerializer f7085c;
    public long f7086d;
    public Set<String> f7087e;
    @Nullable
    public CallerContext f7088f;
    @Nullable
    public ImmutableList<Header> f7089g;
    public CacheProcessor<T> f7090h;
    public boolean f7091i;
    public String f7092j;
    public GraphQLSubscription f7093k;
    public boolean f7094l;
    public boolean f7095m;
    public final GraphQlQueryString f7096o;
    public final Class f7097p;
    public FbJsonDeserializer f7098q;
    private FbRequestState f7099r;
    @Nullable
    public ViewerContext f7100s;
    public GraphQLRequestDiskCache f7101t;
    public GenericGraphQLMethod f7102u;
    public final int f7103v;
    private String f7104w;
    public int f7105x;
    public int f7106y;

    private GraphQLRequest(GraphQlQueryString graphQlQueryString, Class cls) {
        this(graphQlQueryString, cls, null);
    }

    private GraphQLRequest(GraphQlQueryString graphQlQueryString, Class cls, FbJsonDeserializer fbJsonDeserializer) {
        this.f7083a = GraphQLCachePolicy.f7111c;
        this.f7084b = false;
        this.f7085c = GraphQLCacheKeySerializer.f7183a;
        this.f7086d = 604800000;
        this.f7088f = null;
        this.f7089g = null;
        this.f7090h = null;
        this.f7101t = null;
        this.f7102u = null;
        this.f7093k = null;
        this.f7104w = null;
        this.f7094l = false;
        this.f7105x = 1;
        this.f7106y = 0;
        Preconditions.checkNotNull(graphQlQueryString);
        Preconditions.checkNotNull(cls);
        this.f7096o = graphQlQueryString;
        this.f7096o.mo1608a(true);
        this.f7097p = cls;
        this.f7098q = fbJsonDeserializer;
        this.f7099r = m11589c(graphQlQueryString.f6530b);
        this.f7103v = f7082n.incrementAndGet();
    }

    private static FbRequestState m11589c(String str) {
        if (str == null) {
            str = "unknown";
        }
        return new FbRequestState(str);
    }

    GraphQLRequest(GraphQLRequest<T> graphQLRequest) {
        this.f7083a = GraphQLCachePolicy.f7111c;
        this.f7084b = false;
        this.f7085c = GraphQLCacheKeySerializer.f7183a;
        this.f7086d = 604800000;
        this.f7088f = null;
        this.f7089g = null;
        this.f7090h = null;
        this.f7101t = null;
        this.f7102u = null;
        this.f7093k = null;
        this.f7104w = null;
        this.f7094l = false;
        this.f7105x = 1;
        this.f7106y = 0;
        GraphQlQueryString graphQlQueryString = graphQLRequest.f7096o;
        GraphQlQueryString graphQlQueryString2 = new GraphQlQueryString(graphQlQueryString.f6530b, graphQlQueryString.f6531c, graphQlQueryString.f6532d, graphQlQueryString.f6534f, graphQlQueryString.f6536h, graphQlQueryString.f6535g);
        graphQlQueryString2.f6529a = graphQlQueryString.f6529a;
        graphQlQueryString2.f6533e = graphQlQueryString.f6533e;
        this.f7096o = graphQlQueryString2;
        this.f7097p = graphQLRequest.f7097p;
        this.f7098q = graphQLRequest.f7098q;
        this.f7083a = graphQLRequest.f7083a;
        this.f7084b = graphQLRequest.f7084b;
        this.f7085c = graphQLRequest.f7085c;
        this.f7086d = graphQLRequest.f7086d;
        this.f7094l = graphQLRequest.f7094l;
        this.f7087e = graphQLRequest.f7087e;
        this.f7088f = graphQLRequest.f7088f;
        this.f7089g = graphQLRequest.f7089g;
        this.f7090h = graphQLRequest.f7090h;
        this.f7092j = graphQLRequest.f7092j;
        this.f7104w = graphQLRequest.f7104w;
        this.f7093k = graphQLRequest.f7093k;
        this.f7099r = graphQLRequest.f7099r;
        this.f7100s = graphQLRequest.f7100s;
        this.f7091i = graphQLRequest.f7091i;
        this.f7105x = graphQLRequest.f7105x;
        this.f7103v = f7082n.incrementAndGet();
    }

    public static <T> GraphQLRequest<T> m11587a(TypedGraphQlQueryString<T> typedGraphQlQueryString) {
        if (typedGraphQlQueryString instanceof TypedGraphQLMutationString) {
            throw new IllegalArgumentException("Trying to create a " + GraphQLRequest.class.getSimpleName() + " from a " + TypedGraphQLMutationString.class.getSimpleName() + ". Use createMutationRequest() instead.");
        }
        if (DefaultParameterHelper.m11619a(typedGraphQlQueryString, "profile_image_small_size")) {
            typedGraphQlQueryString.m11314a("profile_image_small_size", Integer.valueOf(GraphQlQueryDefaults.m11419b()));
        } else if (DefaultParameterHelper.m11619a(typedGraphQlQueryString, "profile_image_big_size")) {
            typedGraphQlQueryString.m11314a("profile_image_big_size", Integer.valueOf(GraphQlQueryDefaults.m11421c()));
        }
        if (!typedGraphQlQueryString.f6527d && null != null) {
            return new GraphQLRequest(typedGraphQlQueryString, typedGraphQlQueryString.f6526c);
        }
        GraphQLRequest<T> graphQLRequest = new GraphQLRequest(typedGraphQlQueryString, typedGraphQlQueryString.f6526c);
        if (!typedGraphQlQueryString.f6527d) {
            return graphQLRequest;
        }
        Preconditions.checkState(graphQLRequest.f7105x == 1);
        graphQLRequest.f7094l = true;
        return graphQLRequest;
    }

    public static <T> MutationRequest<T> m11588a(TypedGraphQLMutationString<T> typedGraphQLMutationString) {
        return new MutationRequest(typedGraphQLMutationString);
    }

    @Deprecated
    public static <T> GraphQLRequest<T> m11585a(GraphQlQueryString graphQlQueryString, Class<T> cls) {
        return new GraphQLRequest(graphQlQueryString, cls);
    }

    @Deprecated
    public static <T> GraphQLRequest<T> m11586a(GraphQlQueryString graphQlQueryString, Class<T> cls, int i) {
        GraphQLRequest<T> a = m11585a(graphQlQueryString, (Class) cls);
        a.f7105x = i;
        return a;
    }

    public final GraphQLRefParam m11599a(String str, BatchQueryFanOutStyle batchQueryFanOutStyle, FallbackStyle fallbackStyle) {
        Set set;
        GraphQlQueryString graphQlQueryString = this.f7096o;
        if (graphQlQueryString.f6534f == null) {
            set = RegularImmutableSet.f688a;
        } else {
            set = graphQlQueryString.f6534f;
        }
        Preconditions.checkArgument(set.contains(str), "query does not contain token " + str);
        return new GraphQLRefParam(this, str, batchQueryFanOutStyle, fallbackStyle);
    }

    public final GraphQlQueryString m11605b() {
        return this.f7096o;
    }

    public static final CallerContext m11584a(@Nullable CallerContext callerContext, Class cls) {
        return callerContext != null ? callerContext : CallerContext.m9060a(cls);
    }

    public final GraphQLCachePolicy m11606c() {
        return this.f7083a;
    }

    public final String m11601a(KeyFactory keyFactory) {
        return this.f7085c.mo1645a(this, this.f7097p, keyFactory);
    }

    public final GraphQLRequest<T> m11590a(long j) {
        this.f7086d = 1000 * j;
        return this;
    }

    public final GraphQlQueryParamSet m11607d() {
        return this.f7096o.f6529a;
    }

    @Deprecated
    public final GraphQLRequest<T> m11595a(GraphQlQueryParamSet graphQlQueryParamSet) {
        Preconditions.checkNotNull(graphQlQueryParamSet);
        this.f7096o.f6529a = graphQlQueryParamSet;
        return this;
    }

    public final GraphQLRequest<T> m11594a(GraphQLCachePolicy graphQLCachePolicy) {
        Preconditions.checkNotNull(graphQLCachePolicy);
        this.f7083a = graphQLCachePolicy;
        return this;
    }

    public final int m11608e() {
        return this.f7106y;
    }

    public final GraphQLRequest<T> m11597a(boolean z) {
        this.f7084b = z;
        return this;
    }

    public final GraphQLRequest<T> m11593a(GraphQLCacheKeySerializer graphQLCacheKeySerializer) {
        Preconditions.checkNotNull(graphQLCacheKeySerializer);
        this.f7085c = graphQLCacheKeySerializer;
        return this;
    }

    public final String m11602a(KeyFactory keyFactory, GraphQLResult<T> graphQLResult) {
        Map map = graphQLResult.f6208j;
        if (map == null || map.isEmpty()) {
            return m11601a(keyFactory);
        }
        GraphQlQueryParamSet graphQlQueryParamSet;
        GraphQLRequest graphQLRequest = new GraphQLRequest(this);
        if (graphQLRequest.m11607d() != null) {
            graphQlQueryParamSet = new GraphQlQueryParamSet(graphQLRequest.m11607d().m11384e());
        } else {
            graphQlQueryParamSet = new GraphQlQueryParamSet();
        }
        GraphQlQueryString graphQlQueryString = this.f7096o;
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (graphQlQueryString != null) {
                str = graphQlQueryString.mo1605a(str);
            }
            if (entry.getValue() instanceof String) {
                graphQlQueryParamSet.m11376a(str, (String) entry.getValue());
            } else if (entry.getValue() instanceof List) {
                graphQlQueryParamSet.m11377a(str, (List) entry.getValue());
            } else {
                throw new IllegalArgumentException("Unexpected type found in ref params");
            }
        }
        graphQLRequest.m11595a(graphQlQueryParamSet);
        return graphQLRequest.m11601a(keyFactory);
    }

    public final GraphQLRequest<T> m11603b(boolean z) {
        this.f7091i = z;
        return this;
    }

    public final GraphQLRequest<T> m11592a(@Nullable CallerContext callerContext) {
        this.f7088f = callerContext;
        return this;
    }

    public final GraphQLRequest<T> m11596a(RequestPriority requestPriority) {
        this.f7099r.m11635a(requestPriority);
        return this;
    }

    final FbRequestState m11609g() {
        RequestPriority requestPriority;
        FbRequestState fbRequestState = this.f7099r;
        if (this.f7083a == GraphQLCachePolicy.f7113e) {
            requestPriority = RequestPriority.CAN_WAIT;
        } else {
            requestPriority = null;
        }
        fbRequestState.m11637b(requestPriority);
        return this.f7099r;
    }

    public final String m11600a() {
        if (this.f7092j == null) {
            return this.f7096o.f6530b;
        }
        return this.f7092j;
    }

    public final GraphQLRefParam m11604b(String str) {
        return m11599a(str, BatchQueryFanOutStyle.FIRST, FallbackStyle.NOT_SET);
    }

    public final GraphQLRefParam m11598a(String str, BatchQueryFanOutStyle batchQueryFanOutStyle) {
        return m11599a(str, batchQueryFanOutStyle, FallbackStyle.NOT_SET);
    }

    public final Map<String, GraphQLRequest<T>> m11610h() {
        if (this.f7104w == null || !this.f7094l || m11607d() == null) {
            return null;
        }
        List<String> list = (List) m11607d().m11378a(this.f7104w);
        Preconditions.checkNotNull(list);
        Map e = m11607d().m11384e();
        e.remove(this.f7104w);
        Map<String, GraphQLRequest<T>> c = Maps.m838c();
        for (String str : list) {
            GraphQLRequest a = new GraphQLRequest(this).m11595a(new GraphQlQueryParamSet(ImmutableMap.builder().m608a(e).m609b(this.f7104w, Lists.m1300a(str)).m610b()));
            a.f7094l = false;
            c.put(str, a);
        }
        return c;
    }

    public final boolean m11611i() {
        return this.f7096o.mo1640i();
    }

    public final boolean m11612j() {
        if (m11607d() == null) {
            return false;
        }
        for (GraphQLRefParam graphQLRefParam : m11607d().m11381b().values()) {
            if (graphQLRefParam.c == BatchQueryFanOutStyle.EACH) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final ViewerContext m11613k() {
        return this.f7100s;
    }

    public final GraphQLRequest<T> m11591a(@Nullable ViewerContext viewerContext) {
        this.f7100s = viewerContext;
        return this;
    }

    public final Class m11614n() {
        return this.f7097p;
    }

    final int m11615p() {
        return this.f7103v;
    }

    final boolean m11616s() {
        if (!this.f7084b) {
            return false;
        }
        if (!this.f7096o.m11331l()) {
            return false;
        }
        if (!(this.f7096o instanceof TypedGraphQlQueryString)) {
            return false;
        }
        if (this.f7094l) {
            return false;
        }
        Class cls = ((TypedGraphQlQueryString) this.f7096o).f6526c;
        if (TypeModel.class.isAssignableFrom(cls)) {
            return false;
        }
        if (cls.isAnnotationPresent(FragmentModelWithBridge.class)) {
            return false;
        }
        return true;
    }
}
