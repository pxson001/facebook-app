package com.facebook.graphql.mqtt;

import android.support.v4.util.ArrayMap;
import com.facebook.graphql.query.TypedGraphQLSubscriptionString;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: session_cache_hit_type */
public class GraphQLSubscriptionConnector {
    private static final Class<?> f5496a = GraphQLSubscriptionConnector.class;
    private static final FutureCallback f5497b = new C02581();
    private static volatile GraphQLSubscriptionConnector f5498e;
    private final GraphQLMQTTSubscriptionConnector f5499c;
    private final GraphQLSubscriptionAnalytics f5500d;

    /* compiled from: session_cache_hit_type */
    final class C02581 implements FutureCallback {
        C02581() {
        }

        public final void onSuccess(Object obj) {
        }

        public final void onFailure(Throwable th) {
        }
    }

    /* compiled from: session_cache_hit_type */
    public interface GraphQLSubscriptionHandle<T extends GraphQLVisitableModel> {
        TypedGraphQLSubscriptionString<T> mo3114c();

        FutureCallback<T> mo3115d();

        String mo3116e();

        JsonNode mo3117f();
    }

    /* compiled from: session_cache_hit_type */
    public class GraphQLSubscriptionResult<T extends GraphQLVisitableModel> {
        public GraphQLSubscriptionHandle<T> f19679a;
        public GraphQLSubscriptionConnectorException f19680b;

        public GraphQLSubscriptionResult(GraphQLSubscriptionHandle<T> graphQLSubscriptionHandle) {
            this.f19679a = graphQLSubscriptionHandle;
        }

        public GraphQLSubscriptionResult(GraphQLSubscriptionConnectorException graphQLSubscriptionConnectorException) {
            this.f19680b = graphQLSubscriptionConnectorException;
        }
    }

    public static com.facebook.graphql.mqtt.GraphQLSubscriptionConnector m9383a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f5498e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.class;
        monitor-enter(r1);
        r0 = f5498e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m9384b(r0);	 Catch:{ all -> 0x0035 }
        f5498e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5498e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.a(com.facebook.inject.InjectorLike):com.facebook.graphql.mqtt.GraphQLSubscriptionConnector");
    }

    private static GraphQLSubscriptionConnector m9384b(InjectorLike injectorLike) {
        return new GraphQLSubscriptionConnector(GraphQLMQTTSubscriptionConnector.m9389a(injectorLike), GraphQLSubscriptionAnalytics.m9560b(injectorLike));
    }

    @Inject
    public GraphQLSubscriptionConnector(GraphQLMQTTSubscriptionConnector graphQLMQTTSubscriptionConnector, GraphQLSubscriptionAnalytics graphQLSubscriptionAnalytics) {
        this.f5499c = graphQLMQTTSubscriptionConnector;
        this.f5500d = graphQLSubscriptionAnalytics;
    }

    public final <T extends GraphQLVisitableModel> GraphQLSubscriptionHandle m9385a(TypedGraphQLSubscriptionString<T> typedGraphQLSubscriptionString) {
        return m9386a(typedGraphQLSubscriptionString, f5497b);
    }

    public final <T extends GraphQLVisitableModel> GraphQLSubscriptionHandle m9386a(TypedGraphQLSubscriptionString<T> typedGraphQLSubscriptionString, FutureCallback<T> futureCallback) {
        Map arrayMap = new ArrayMap(1);
        arrayMap.put(typedGraphQLSubscriptionString, futureCallback);
        GraphQLSubscriptionResult graphQLSubscriptionResult = (GraphQLSubscriptionResult) m9387a(arrayMap).get(typedGraphQLSubscriptionString);
        if (graphQLSubscriptionResult.f19680b == null) {
            return graphQLSubscriptionResult.f19679a;
        }
        throw graphQLSubscriptionResult.f19680b;
    }

    public final <T extends GraphQLVisitableModel> Map<TypedGraphQLSubscriptionString, GraphQLSubscriptionResult> m9387a(Map<TypedGraphQLSubscriptionString<T>, FutureCallback<T>> map) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.putAll(this.f5499c.m9392a((Map) map));
        for (Entry entry : arrayMap.entrySet()) {
            GraphQLSubscriptionHandle graphQLSubscriptionHandle = ((GraphQLSubscriptionResult) entry.getValue()).f19679a;
            if (graphQLSubscriptionHandle != null) {
                entry.getKey();
                this.f5500d.m9562b(graphQLSubscriptionHandle);
            }
        }
        return arrayMap;
    }

    public final void m9388a(Set<GraphQLSubscriptionHandle> set) {
        this.f5499c.m9393a((Set) set);
        for (GraphQLSubscriptionHandle c : set) {
            this.f5500d.m9563c(c);
        }
    }
}
