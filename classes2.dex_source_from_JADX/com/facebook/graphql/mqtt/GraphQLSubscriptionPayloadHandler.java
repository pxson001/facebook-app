package com.facebook.graphql.mqtt;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLCacheAggregator;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionHandle;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

@UserScoped
/* compiled from: internal_settings/ */
public class GraphQLSubscriptionPayloadHandler {
    private static final Class<?> f19672a = GraphQLSubscriptionPayloadHandler.class;
    private static final Object f19673g = new Object();
    private final ObjectMapper f19674b;
    private final JsonFactory f19675c;
    private final GraphQLProtocolHelper f19676d;
    private final GraphQLCacheAggregator f19677e;
    private final GraphQLSubscriptionAnalytics f19678f;

    private static GraphQLSubscriptionPayloadHandler m27403b(InjectorLike injectorLike) {
        return new GraphQLSubscriptionPayloadHandler(FbObjectMapperMethodAutoProvider.m6609a(injectorLike), JsonFactoryMethodAutoProvider.m8062a(injectorLike), GraphQLProtocolHelper.m9427a(injectorLike), GraphQLCacheAggregator.m10380b(injectorLike), GraphQLSubscriptionAnalytics.m9560b(injectorLike));
    }

    @Inject
    public GraphQLSubscriptionPayloadHandler(ObjectMapper objectMapper, JsonFactory jsonFactory, GraphQLProtocolHelper graphQLProtocolHelper, GraphQLCacheAggregator graphQLCacheAggregator, GraphQLSubscriptionAnalytics graphQLSubscriptionAnalytics) {
        this.f19674b = objectMapper;
        this.f19675c = jsonFactory;
        this.f19676d = graphQLProtocolHelper;
        this.f19677e = graphQLCacheAggregator;
        this.f19678f = graphQLSubscriptionAnalytics;
    }

    public final <T extends GraphQLVisitableModel> void m27404a(GraphQLSubscriptionHandle<T> graphQLSubscriptionHandle, byte[] bArr) {
        FutureCallback d = graphQLSubscriptionHandle.mo3115d();
        try {
            GraphQlQueryString c = graphQLSubscriptionHandle.mo3114c();
            JsonParser a = this.f19675c.m7166a(bArr);
            a.mo1763a(this.f19674b);
            this.f19676d.m9437a(c.m11324c(), 1, a);
            GraphQLVisitableModel graphQLVisitableModel = (GraphQLVisitableModel) a.m13259a(c.m11307p());
            this.f19678f.m9561a(graphQLSubscriptionHandle);
            this.f19677e.m10386a(graphQLVisitableModel);
            d.onSuccess(graphQLVisitableModel);
        } catch (Throwable e) {
            BLog.a(f19672a, e, "GraphQL Subscription payload received but handling failed for query %s using %s", new Object[]{graphQLSubscriptionHandle.mo3114c().m11324c(), graphQLSubscriptionHandle.mo3116e()});
            d.onFailure(e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.graphql.mqtt.GraphQLSubscriptionPayloadHandler m27402a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.m1499a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.mo191b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.m1454a(r1);
        r4 = r3.m8951b();	 Catch:{ all -> 0x006c }
        r1 = f19673g;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.f724a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.m8952c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.m1504b(r1);	 Catch:{  }
        r6 = r0.m1455a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.m1474e();	 Catch:{ all -> 0x0062 }
        r1 = m27403b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.m1452a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f19673g;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.f724a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.graphql.mqtt.GraphQLSubscriptionPayloadHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.m1505c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.graphql.mqtt.GraphQLSubscriptionPayloadHandler) r0;	 Catch:{  }
        r3.m8952c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.m1452a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.m1505c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.m8952c();
        throw r0;
    L_0x0071:
        r0 = f19673g;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.graphql.mqtt.GraphQLSubscriptionPayloadHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.mqtt.GraphQLSubscriptionPayloadHandler.a(com.facebook.inject.InjectorLike):com.facebook.graphql.mqtt.GraphQLSubscriptionPayloadHandler");
    }
}
