package com.facebook.graphql.mqtt;

import android.support.v4.util.ArrayMap;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionConnectorException;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionHandle;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionResult;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.TypedGraphQLSubscriptionString;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.push.mqtt.external.MqttPushHandler;
import com.facebook.push.mqtt.service.ClientSubscriptionManager;
import com.facebook.push.mqtt.service.SubscribeTopic;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: sess_mgr_type */
public final class GraphQLMQTTSubscriptionConnector implements MqttPushHandler {
    public static final Class<?> f5501a = GraphQLMQTTSubscriptionConnector.class;
    private static volatile GraphQLMQTTSubscriptionConnector f5502g;
    private final ClientSubscriptionManager f5503b;
    private final GraphQLProtocolHelper f5504c;
    private final Provider<GraphQLSubscriptionPayloadHandler> f5505d;
    private final JsonFactory f5506e;
    @GuardedBy("this")
    private final HashMap<String, GraphQLMQTTSubscriptionHandle<? extends GraphQLVisitableModel>> f5507f = new HashMap();

    /* compiled from: sess_mgr_type */
    public final class GraphQLMQTTSubscriptionHandle<T extends GraphQLVisitableModel> implements GraphQLSubscriptionHandle<T> {
        SubscribeTopic f19665a;
        TypedGraphQLSubscriptionString<T> f19666b;
        FutureCallback<T> f19667c;
        GraphQLSubscriptionPayloadHandler f19668d;
        public JsonFactory f19669e;
        JsonNode f19670f;
        boolean f19671g = false;

        public GraphQLMQTTSubscriptionHandle(SubscribeTopic subscribeTopic, TypedGraphQLSubscriptionString<T> typedGraphQLSubscriptionString, FutureCallback<T> futureCallback, GraphQLSubscriptionPayloadHandler graphQLSubscriptionPayloadHandler, JsonFactory jsonFactory) {
            this.f19665a = subscribeTopic;
            this.f19666b = typedGraphQLSubscriptionString;
            this.f19667c = futureCallback;
            this.f19668d = graphQLSubscriptionPayloadHandler;
            this.f19669e = jsonFactory;
        }

        protected final SubscribeTopic m27392a() {
            return this.f19665a;
        }

        public final GraphQLSubscriptionPayloadHandler m27393b() {
            return this.f19668d;
        }

        public final TypedGraphQLSubscriptionString<T> mo3114c() {
            return this.f19666b;
        }

        public final FutureCallback<T> mo3115d() {
            return this.f19667c;
        }

        public final String mo3116e() {
            return "mqtt";
        }

        public final synchronized JsonNode mo3117f() {
            JsonNode jsonNode;
            if (this.f19671g) {
                jsonNode = null;
            } else {
                if (this.f19670f == null) {
                    try {
                        this.f19670f = m27391g();
                    } catch (Throwable e) {
                        BLog.a(GraphQLMQTTSubscriptionConnector.f5501a, e, "Failed to build input query param node. Its value will remain null", new Object[0]);
                        this.f19671g = true;
                    }
                }
                jsonNode = this.f19670f;
            }
            return jsonNode;
        }

        private JsonNode m27391g() {
            Object obj = this.f19666b.f6529a.m11384e().get(this.f19666b.f19657b);
            Writer stringWriter = new StringWriter();
            JsonGenerator a = this.f19669e.m7159a(stringWriter);
            a.mo1114a(obj);
            a.flush();
            return new ObjectNode(JsonNodeFactory.f3121a).m5137a("input", stringWriter.toString());
        }
    }

    public static com.facebook.graphql.mqtt.GraphQLMQTTSubscriptionConnector m9389a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5502g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.graphql.mqtt.GraphQLMQTTSubscriptionConnector.class;
        monitor-enter(r1);
        r0 = f5502g;	 Catch:{ all -> 0x003a }
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
        r0 = m9391b(r0);	 Catch:{ all -> 0x0035 }
        f5502g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5502g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.mqtt.GraphQLMQTTSubscriptionConnector.a(com.facebook.inject.InjectorLike):com.facebook.graphql.mqtt.GraphQLMQTTSubscriptionConnector");
    }

    private static GraphQLMQTTSubscriptionConnector m9391b(InjectorLike injectorLike) {
        return new GraphQLMQTTSubscriptionConnector(ClientSubscriptionManager.m9396a(injectorLike), GraphQLProtocolHelper.m9427a(injectorLike), IdBasedProvider.m1811a(injectorLike, 2195), JsonFactoryMethodAutoProvider.m8062a(injectorLike));
    }

    @Inject
    public GraphQLMQTTSubscriptionConnector(ClientSubscriptionManager clientSubscriptionManager, GraphQLProtocolHelper graphQLProtocolHelper, Provider<GraphQLSubscriptionPayloadHandler> provider, JsonFactory jsonFactory) {
        this.f5503b = clientSubscriptionManager;
        this.f5504c = graphQLProtocolHelper;
        this.f5505d = provider;
        this.f5506e = jsonFactory;
    }

    public final <T extends GraphQLVisitableModel> Map<TypedGraphQLSubscriptionString<T>, GraphQLSubscriptionResult<T>> m9392a(Map<TypedGraphQLSubscriptionString<T>, FutureCallback<T>> map) {
        ArrayMap arrayMap = new ArrayMap(30);
        Collection hashSet = new HashSet();
        for (Entry entry : map.entrySet()) {
            TypedGraphQLSubscriptionString typedGraphQLSubscriptionString = (TypedGraphQLSubscriptionString) entry.getKey();
            FutureCallback futureCallback = (FutureCallback) entry.getValue();
            m9390a(typedGraphQLSubscriptionString);
            String str = "graphqlsubscriptions";
            String f = typedGraphQLSubscriptionString.m11327f();
            try {
                String str2 = "/graphql/1/" + str + "/" + f + "/" + GraphQLProtocolHelper.m9429a(typedGraphQLSubscriptionString.m11330j());
                SubscribeTopic subscribeTopic = new SubscribeTopic(str2, 0);
                GraphQLSubscriptionHandle graphQLMQTTSubscriptionHandle = new GraphQLMQTTSubscriptionHandle(subscribeTopic, typedGraphQLSubscriptionString, futureCallback, (GraphQLSubscriptionPayloadHandler) this.f5505d.get(), this.f5506e);
                synchronized (this) {
                    this.f5507f.put(str2, graphQLMQTTSubscriptionHandle);
                }
                hashSet.add(subscribeTopic);
                arrayMap.put(typedGraphQLSubscriptionString, new GraphQLSubscriptionResult(graphQLMQTTSubscriptionHandle));
            } catch (Throwable e) {
                arrayMap.put(typedGraphQLSubscriptionString, new GraphQLSubscriptionResult(new GraphQLSubscriptionConnectorException("Could not build param set", e)));
            }
        }
        this.f5503b.m9404a(hashSet, ImmutableSet.of());
        return arrayMap;
    }

    public final void m9393a(Set<GraphQLSubscriptionHandle> set) {
        Collection<SubscribeTopic> hashSet = new HashSet(set.size());
        for (GraphQLSubscriptionHandle graphQLSubscriptionHandle : set) {
            hashSet.add(((GraphQLMQTTSubscriptionHandle) graphQLSubscriptionHandle).m27392a());
        }
        for (SubscribeTopic subscribeTopic : hashSet) {
            synchronized (this) {
                this.f5507f.remove(subscribeTopic.m27138a());
            }
        }
        this.f5503b.m9404a(ImmutableSet.of(), (Collection) hashSet);
    }

    private static <T extends GraphQLVisitableModel> void m9390a(TypedGraphQLSubscriptionString<T> typedGraphQLSubscriptionString) {
        Callable callable = GraphQLProtocolHelper.f5534b;
        GraphQLProtocolHelper.m9430a(typedGraphQLSubscriptionString.f6529a, typedGraphQLSubscriptionString.f19657b, "client_subscription_id", callable);
    }

    public final void onMessage(String str, byte[] bArr) {
        if (str.startsWith("/graphql")) {
            GraphQLMQTTSubscriptionHandle graphQLMQTTSubscriptionHandle;
            synchronized (this) {
                graphQLMQTTSubscriptionHandle = (GraphQLMQTTSubscriptionHandle) this.f5507f.get(str);
            }
            if (graphQLMQTTSubscriptionHandle == null) {
                BLog.a(f5501a, "GraphQL Subscription over MQTT got unexpected payload on pattern %s", new Object[]{str});
                return;
            }
            graphQLMQTTSubscriptionHandle.m27393b().m27404a(graphQLMQTTSubscriptionHandle, bArr);
        }
    }
}
