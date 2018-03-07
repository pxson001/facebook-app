package com.facebook.graphql.protocol;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.common.udppriming.client.EncryptChannelInformation;
import com.facebook.common.udppriming.service.UDPPrimingServiceHandler;
import com.facebook.crudolib.params.ParamsCollection;
import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.crudolib.params.ParamsCollectionPool;
import com.facebook.crudolib.params.ParamsJsonEncoder;
import com.facebook.debug.fieldusage.FieldUsageReporterFactory;
import com.facebook.graphql.error.GraphQLError;
import com.facebook.graphql.protocol.parsing.GraphQLProtocolParseHelper;
import com.facebook.graphql.query.GraphQLRefParam;
import com.facebook.graphql.query.GraphQLRefParam.BatchQueryFanOutStyle;
import com.facebook.graphql.query.GraphQLRefParam.FallbackStyle;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.interfaces.RequestState;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.UDPPrimingHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.api.LoomLogger;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: server_muted_until */
public class GraphQLProtocolHelper {
    public static final List<BasicNameValuePair> f5533a = Lists.m1300a(new BasicNameValuePair("response_format", "flatbuffer"), new BasicNameValuePair("flatbuffer_version", "1"), new BasicNameValuePair("flatbuffer_schema_id", "10154690582226729"));
    public static final Callable<String> f5534b = new C02601();
    private static volatile GraphQLProtocolHelper f5535j;
    public final ObjectMapper f5536c;
    private final AbstractFbErrorReporter f5537d;
    private final JsonFactory f5538e;
    private final String f5539f;
    private final Lazy<UDPPrimingServiceHandler> f5540g;
    private final UDPPrimingHelper f5541h;
    public final FieldUsageReporterFactory f5542i;

    /* compiled from: server_muted_until */
    final class C02601 implements Callable<String> {
        C02601() {
        }

        public final Object call() {
            return SafeUUIDGenerator.m2795a().toString();
        }
    }

    public static com.facebook.graphql.protocol.GraphQLProtocolHelper m9427a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5535j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.graphql.protocol.GraphQLProtocolHelper.class;
        monitor-enter(r1);
        r0 = f5535j;	 Catch:{ all -> 0x003a }
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
        r0 = m9433b(r0);	 Catch:{ all -> 0x0035 }
        f5535j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5535j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.protocol.GraphQLProtocolHelper.a(com.facebook.inject.InjectorLike):com.facebook.graphql.protocol.GraphQLProtocolHelper");
    }

    private static GraphQLProtocolHelper m9433b(InjectorLike injectorLike) {
        return new GraphQLProtocolHelper(FbObjectMapperMethodAutoProvider.m6609a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), JsonFactoryMethodAutoProvider.m8062a(injectorLike), (String) null, IdBasedLazy.m1808a(injectorLike, 5166), UDPPrimingHelper.m9443a(injectorLike), FieldUsageReporterFactory.m9546b(injectorLike));
    }

    public static void m9431a(TypedGraphQLMutationString typedGraphQLMutationString, String str, Callable<String> callable) {
        m9430a(typedGraphQLMutationString.f6529a, typedGraphQLMutationString.f7108f, str, callable);
    }

    @Inject
    public GraphQLProtocolHelper(ObjectMapper objectMapper, FbErrorReporter fbErrorReporter, JsonFactory jsonFactory, @Nullable String str, Lazy<UDPPrimingServiceHandler> lazy, UDPPrimingHelper uDPPrimingHelper, FieldUsageReporterFactory fieldUsageReporterFactory) {
        this.f5536c = objectMapper;
        this.f5537d = fbErrorReporter;
        this.f5538e = jsonFactory;
        this.f5539f = str;
        this.f5540g = lazy;
        this.f5541h = uDPPrimingHelper;
        this.f5542i = fieldUsageReporterFactory;
    }

    @Deprecated
    @Nullable
    public static String m9429a(GraphQlQueryParamSet graphQlQueryParamSet) {
        if (graphQlQueryParamSet == null) {
            return null;
        }
        ParamsCollection d = graphQlQueryParamSet.m11383d();
        if (d == null) {
            return null;
        }
        d.m5438a(ParamsJsonEncoder.m5454a());
        Writer stringWriter = new StringWriter(d.f3273c * 50);
        d.m5439a(stringWriter);
        return stringWriter.toString();
    }

    public final String m9440b(GraphQlQueryParamSet graphQlQueryParamSet) {
        String str = null;
        if (graphQlQueryParamSet != null) {
            Map b = graphQlQueryParamSet.m11381b();
            if (!b.isEmpty()) {
                Writer stringWriter = new StringWriter();
                JsonGenerator a = this.f5538e.m7159a(stringWriter);
                try {
                    a.mo1134f();
                    for (Entry entry : b.entrySet()) {
                        String str2 = (String) entry.getKey();
                        GraphQLRefParam graphQLRefParam = (GraphQLRefParam) entry.getValue();
                        a.m7714g(str2);
                        a.mo1658a("query", graphQLRefParam.a.m11600a());
                        a.mo1658a("import", graphQLRefParam.b);
                        if (graphQLRefParam.c != BatchQueryFanOutStyle.NO_FAN_OUT) {
                            a.mo1658a("plural", GraphQLRefParam.a(graphQLRefParam.c));
                        }
                        if (graphQLRefParam.d != FallbackStyle.NOT_SET) {
                            a.mo1658a("fallback", GraphQLRefParam.a(graphQLRefParam.d));
                        }
                        a.mo1136g();
                    }
                    a.mo1136g();
                    a.flush();
                    str = stringWriter.toString();
                } finally {
                    a.close();
                }
            }
        }
        return str;
    }

    public static void m9430a(GraphQlQueryParamSet graphQlQueryParamSet, String str, String str2, Callable<String> callable) {
        Object obj = null;
        Preconditions.checkNotNull(str);
        if (graphQlQueryParamSet != null) {
            ParamsCollectionMap d = graphQlQueryParamSet.m11383d();
            if (d != null) {
                for (int i = 0; i < d.m5430j(); i++) {
                    if (d.m5423b(i).equals(str)) {
                        Object c = d.m5426c(i);
                        if (c instanceof ParamsCollectionMap) {
                            ParamsCollectionMap paramsCollectionMap = (ParamsCollectionMap) c;
                            for (int i2 = 0; i2 < paramsCollectionMap.m5430j(); i2++) {
                                if (paramsCollectionMap.m5423b(i2).equals(str2)) {
                                    obj = 1;
                                    break;
                                }
                            }
                            if (obj == null) {
                                try {
                                    String str3 = (String) callable.call();
                                    if (str3 != null) {
                                        paramsCollectionMap.m5421a(str2, str3);
                                        return;
                                    }
                                    return;
                                } catch (Exception e) {
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    public final String m9442c(GraphQlQueryParamSet graphQlQueryParamSet) {
        Throwable th;
        JsonGenerator jsonGenerator;
        String str = null;
        if (graphQlQueryParamSet != null) {
            Map c = graphQlQueryParamSet.m11382c();
            if (!c.isEmpty()) {
                Writer stringWriter = new StringWriter(c.size() * 50);
                try {
                    JsonGenerator a = this.f5538e.m7159a(stringWriter);
                    try {
                        a.mo1134f();
                        for (Entry entry : c.entrySet()) {
                            String str2 = (String) entry.getKey();
                            Object value = entry.getValue();
                            if (value != null) {
                                if (value instanceof Integer) {
                                    a.m7687a(str2, ((Integer) value).intValue());
                                } else if (value instanceof Double) {
                                    a.m7685a(str2, ((Double) value).doubleValue());
                                } else if (value instanceof Float) {
                                    a.m7686a(str2, ((Float) value).floatValue());
                                } else if (value instanceof Long) {
                                    a.m7688a(str2, ((Long) value).longValue());
                                } else {
                                    a.mo1658a(str2, value.toString());
                                }
                            }
                        }
                        a.mo1136g();
                        a.flush();
                        str = stringWriter.toString();
                        if (a != null) {
                            a.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        jsonGenerator = a;
                        if (jsonGenerator != null) {
                            jsonGenerator.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    jsonGenerator = null;
                    th = th4;
                    if (jsonGenerator != null) {
                        jsonGenerator.close();
                    }
                    throw th;
                }
            }
        }
        return str;
    }

    @Deprecated
    public static void m9432a(List<NameValuePair> list) {
        list.add(new BasicNameValuePair("strip_nulls", "true"));
    }

    @Deprecated
    public static void m9434b(List<NameValuePair> list) {
        list.add(new BasicNameValuePair("strip_defaults", "true"));
    }

    public static void m9435c(List<NameValuePair> list) {
        for (NameValuePair add : f5533a) {
            list.add(add);
        }
    }

    private ParamsCollectionMap m9426a(GraphQlQueryParamSet graphQlQueryParamSet, String str, boolean z, boolean z2, ApiResponseType apiResponseType) {
        ParamsCollectionMap b;
        if (graphQlQueryParamSet != null) {
            b = graphQlQueryParamSet.m11369a().m5398b();
            ParamsCollection d = graphQlQueryParamSet.m11383d();
            if (d != null) {
                d.m5438a(ParamsJsonEncoder.m5454a());
                if (z) {
                    b.m5424b("query_params", d);
                } else {
                    b.m5418a("query_params", d);
                }
            }
        } else {
            b = ParamsCollectionPool.m5397a().m5398b();
        }
        b.m5421a("method", str);
        if (this.f5539f != null) {
            b.m5421a("custom_schema", this.f5539f);
        }
        if (z2) {
            b.m5421a("is_offline", "true");
        }
        if (apiResponseType == ApiResponseType.FLATBUFFER) {
            b.m5421a("response_format", "flatbuffer");
            b.m5420a("flatbuffer_version", Integer.valueOf(1));
        }
        return b;
    }

    final ApiRequest m9436a(String str, String str2, ApiResponseType apiResponseType, GraphQlQueryParamSet graphQlQueryParamSet, String str3, RequestIdempotency requestIdempotency, RequestState requestState, boolean z, boolean z2, @Nullable ImmutableList<Header> immutableList, boolean z3, boolean z4) {
        TracerDetour.a("%s.getParameterizedApiRequest", str, -2018301052);
        LoomLogger.a(LoomLoggerDetour.a(-89307122), "getParameterizedApiRequest", str);
        try {
            ParamsCollectionMap a = m9426a(graphQlQueryParamSet, str3, z3, z4, apiResponseType);
            a.m5421a("query_id", str2);
            a.m5421a("query_name", str);
            if (z) {
                a.m5421a("strip_defaults", "true");
            }
            if (z2) {
                a.m5421a("strip_nulls", "true");
            }
            ApiRequest a2 = m9428a(str, a, immutableList, apiResponseType, requestIdempotency, requestState);
            return a2;
        } finally {
            TracerDetour.a(-637085392);
        }
    }

    private ApiRequest m9428a(String str, ParamsCollectionMap paramsCollectionMap, @Nullable ImmutableList<Header> immutableList, ApiResponseType apiResponseType, RequestIdempotency requestIdempotency, RequestState requestState) {
        Object obj;
        UDPPrimingHelper uDPPrimingHelper = this.f5541h;
        if (!uDPPrimingHelper.m9453a() || EncryptChannelInformation.a.a(uDPPrimingHelper.f5545b)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (!(obj == null || this.f5540g == null)) {
            UDPPrimingServiceHandler uDPPrimingServiceHandler = (UDPPrimingServiceHandler) this.f5540g.get();
            if (UDPPrimingServiceHandler.a.compareAndSet(false, true)) {
                ExecutorDetour.a(uDPPrimingServiceHandler.d, uDPPrimingServiceHandler.e, -1126355312);
            }
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.f7526b = str;
        newBuilder = newBuilder;
        newBuilder.f7527c = "POST";
        newBuilder = newBuilder;
        newBuilder.f7528d = "graphql";
        newBuilder = newBuilder;
        newBuilder.f7532h = paramsCollectionMap;
        newBuilder = newBuilder.m12130a((ImmutableList) immutableList);
        newBuilder.f7535k = apiResponseType;
        newBuilder = newBuilder.m12127a(requestIdempotency);
        newBuilder.f7549y = requestState;
        return newBuilder.m12125C();
    }

    public final Exception m9438a(JsonParser jsonParser) {
        if (jsonParser.mo1778i().equals("error")) {
            return GraphQLProtocolParseHelper.m29712a((GraphQLError) this.f5536c.mo908a(jsonParser, GraphQLError.class));
        }
        throw new RuntimeException("Given a parser to map an error, but no error was found.");
    }

    public final <T> List<T> m9441b(Class<T> cls, JsonParser jsonParser) {
        return GraphQLProtocolParseHelper.m29714a((Class) cls, jsonParser, this.f5536c);
    }

    public final JsonParser m9437a(String str, int i, JsonParser jsonParser) {
        TracerDetour.a("%s.getResponse", str, -88996614);
        try {
            JsonParser a = GraphQLProtocolParseHelper.m29711a(i, jsonParser, this.f5536c);
            return a;
        } finally {
            TracerDetour.a(-151274587);
        }
    }

    public final <T> T m9439a(JsonParser jsonParser, Class<T> cls, String str) {
        try {
            T a = jsonParser.m13259a((Class) cls);
            if (a != null) {
                return a;
            }
            throw new Exception("Null result after successful parsing");
        } catch (Throwable e) {
            this.f5537d.m2343a(str + "_parse_error_json", e.getMessage(), e);
            throw e;
        } catch (Throwable e2) {
            this.f5537d.m2343a(str + "_parse_error_io", e2.getMessage(), e2);
            throw e2;
        }
    }
}
