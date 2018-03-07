package com.facebook.graphql.executor;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.fieldusage.FieldAccessQueryContext;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.error.GraphQLError;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.graphql.error.GraphQLInvalidBatchResponseException;
import com.facebook.graphql.executor.GraphQLResult.Builder;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.protocol.parsing.GraphQLProtocolParseHelper;
import com.facebook.graphql.visitor.GraphQLIdFindingVisitor;
import com.facebook.graphql.visitor.GraphQLReadOnlyVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: requests_waited */
public class GraphQLResponseParser {
    private static TypeReference<Map<String, List<Object>>> f7231a;
    private static TypeReference<Map<String, Object>> f7232b;
    private final GraphQLProtocolHelper f7233c;
    private final AbstractFbErrorReporter f7234d;
    private final Clock f7235e;

    /* compiled from: requests_waited */
    public interface GraphQLBatchResultCallback {
        void mo1650a();

        void mo1651a(GraphQLResult graphQLResult, GraphQLRequest graphQLRequest);

        void mo1652a(Exception exception, GraphQLRequest graphQLRequest);
    }

    @VisibleForTesting
    /* compiled from: requests_waited */
    class BatchRawQueryResponse {
        Map<String, Object> f15575a;
        Map<String, List<String>> f15576b;
        String f15577c;
        Exception f15578d;
        Boolean f15579e;
        GraphQLResult f15580f;
        GraphQLRequest f15581g;

        BatchRawQueryResponse() {
        }
    }

    public static GraphQLResponseParser m11711b(InjectorLike injectorLike) {
        return new GraphQLResponseParser(GraphQLProtocolHelper.m9427a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    private static TypeReference<Map<String, List<Object>>> m11706a() {
        if (f7231a == null) {
            f7231a = new 1();
        }
        return f7231a;
    }

    private static TypeReference<Map<String, Object>> m11712b() {
        if (f7232b == null) {
            f7232b = new 2();
        }
        return f7232b;
    }

    @Inject
    public GraphQLResponseParser(GraphQLProtocolHelper graphQLProtocolHelper, Clock clock, AbstractFbErrorReporter abstractFbErrorReporter, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f7233c = graphQLProtocolHelper;
        this.f7235e = clock;
        this.f7234d = abstractFbErrorReporter;
        GlobalAutoGenDeserializerCache.f7239d = gatekeeperStoreImpl.m2189a(89, false);
    }

    @VisibleForTesting
    private BatchRawQueryResponse m11710b(JsonParser jsonParser, GraphQLBatchRequest graphQLBatchRequest) {
        BatchRawQueryResponse batchRawQueryResponse = new BatchRawQueryResponse();
        batchRawQueryResponse.f15579e = Boolean.valueOf(false);
        batchRawQueryResponse.f15577c = jsonParser.mo1778i();
        batchRawQueryResponse.f15581g = (GraphQLRequest) graphQLBatchRequest.f6470a.get(batchRawQueryResponse.f15577c);
        if (batchRawQueryResponse.f15581g == null) {
            throw new GraphQLInvalidBatchResponseException("Invalid request name \"" + batchRawQueryResponse.f15577c + "\"");
        }
        jsonParser.mo1792d();
        if (jsonParser.mo1794g() != JsonToken.START_OBJECT) {
            return batchRawQueryResponse;
        }
        jsonParser.mo1766c();
        while (jsonParser.mo1794g() == JsonToken.FIELD_NAME) {
            String i = jsonParser.mo1778i();
            jsonParser.mo1766c();
            if (jsonParser.mo1794g() != JsonToken.VALUE_NULL) {
                if ("response".equals(i)) {
                    try {
                        batchRawQueryResponse.f15580f = m11713a(jsonParser, batchRawQueryResponse.f15581g, DataFreshnessResult.FROM_SERVER);
                        Object d = batchRawQueryResponse.f15580f.m10400d();
                        if ((d instanceof HashMap) && ((HashMap) d).isEmpty()) {
                            batchRawQueryResponse.f15580f = null;
                            batchRawQueryResponse.f15579e = Boolean.valueOf(true);
                        }
                    } catch (GraphQLException e) {
                        batchRawQueryResponse.f15578d = e;
                    }
                } else if ("error".equals(i)) {
                    batchRawQueryResponse.f15578d = this.f7233c.m9438a(jsonParser);
                } else if (!"query_id".equals(i)) {
                    if ("ref_params".equals(i)) {
                        batchRawQueryResponse.f15575a = (Map) jsonParser.m13258a(m11712b());
                    } else if ("exports".equals(i)) {
                        batchRawQueryResponse.f15576b = (Map) jsonParser.m13258a(m11706a());
                    } else {
                        BLog.a("GraphQLResponseParser", "received unknown response field %s", new Object[]{i});
                        if (jsonParser.mo1794g() == JsonToken.START_OBJECT || jsonParser.mo1794g() == JsonToken.START_ARRAY) {
                            jsonParser.mo1793f();
                        }
                    }
                }
            }
            jsonParser.mo1766c();
        }
        return batchRawQueryResponse;
    }

    private BatchRawQueryResponse m11704a(DataInputStream dataInputStream, GraphQLBatchRequest graphQLBatchRequest, int i) {
        int b = m11709b(dataInputStream);
        byte[] bArr = new byte[b];
        dataInputStream.readFully(bArr);
        String str = new String(bArr, "UTF-8");
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("request_name");
        BatchRawQueryResponse batchRawQueryResponse = new BatchRawQueryResponse();
        batchRawQueryResponse.f15577c = string;
        batchRawQueryResponse.f15581g = (GraphQLRequest) graphQLBatchRequest.f6470a.get(batchRawQueryResponse.f15577c);
        batchRawQueryResponse.f15579e = Boolean.valueOf(false);
        if (batchRawQueryResponse.f15581g == null) {
            throw new GraphQLInvalidBatchResponseException("Invalid request name \"" + batchRawQueryResponse.f15577c + "\"");
        }
        int i2 = (i - b) - 4;
        if (i2 > 0) {
            bArr = new byte[i2];
            dataInputStream.readFully(bArr);
            try {
                batchRawQueryResponse.f15580f = m11705a(bArr, batchRawQueryResponse.f15581g, DataFreshnessResult.FROM_SERVER);
            } catch (Exception e) {
                batchRawQueryResponse.f15578d = e;
            }
        } else if (i2 != 0) {
            string = "Response chunk size should be bigger than chunk header size";
            BLog.c("FLATBUFFER_FROM_SERVER", string);
            throw new RuntimeException(string);
        } else if (jSONObject.has("error")) {
            GraphQLError a = GraphQLError.a(jSONObject.getJSONObject("error"));
            if (a != null) {
                batchRawQueryResponse.f15578d = GraphQLProtocolParseHelper.m29712a(a);
            } else {
                batchRawQueryResponse.f15578d = new RuntimeException(str);
            }
        } else {
            batchRawQueryResponse.f15579e = Boolean.valueOf(true);
        }
        return batchRawQueryResponse;
    }

    public final Void m11715a(JsonParser jsonParser, GraphQLBatchRequest graphQLBatchRequest) {
        Object obj = null;
        jsonParser.mo1766c();
        Set a = Sets.m1313a();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (jsonParser.mo1794g() == JsonToken.START_OBJECT && obj == null) {
            int i5;
            Object obj2;
            int i6;
            jsonParser.mo1766c();
            if ("successful_results".equals(jsonParser.mo1778i()) || "error_results".equals(jsonParser.mo1778i()) || "skipped_results".equals(jsonParser.mo1778i())) {
                jsonParser.mo1766c();
                while (jsonParser.mo1794g() == JsonToken.VALUE_NUMBER_INT) {
                    if ("successful_results".equals(jsonParser.mo1778i())) {
                        i3 = jsonParser.mo1785x();
                    } else if ("error_results".equals(jsonParser.mo1778i())) {
                        i2 = jsonParser.mo1785x();
                    } else if ("skipped_results".equals(jsonParser.mo1778i())) {
                        i = jsonParser.mo1785x();
                    }
                    jsonParser.mo1792d();
                }
                i5 = i;
                i = i2;
                i2 = i3;
                obj2 = 1;
                i6 = i5;
            } else if ("error".equals(jsonParser.mo1778i())) {
                jsonParser.mo1792d();
                throw this.f7233c.m9438a(jsonParser);
            } else {
                BatchRawQueryResponse b = m11710b(jsonParser, graphQLBatchRequest);
                if (b.f15577c != null) {
                    a.add(b.f15577c);
                    i4++;
                }
                if (b.f15581g == null) {
                    b.f15578d = new GraphQLInvalidBatchResponseException("No such request " + b.f15577c);
                }
                if (b.f15578d == null && b.f15580f == null && !b.f15579e.booleanValue()) {
                    b.f15578d = new GraphQLInvalidBatchResponseException("Received null error and null result");
                } else if (b.f15578d != null && b.f15580f != null) {
                    b.f15578d = new GraphQLInvalidBatchResponseException("Received both an error and a result");
                } else if (b.f15578d != null && b.f15579e.booleanValue()) {
                    b.f15578d = new GraphQLInvalidBatchResponseException("Received error for skipped query");
                } else if (b.f15580f != null && b.f15579e.booleanValue()) {
                    b.f15578d = new GraphQLInvalidBatchResponseException("Received result for skipped query");
                }
                if (b.f15578d != null) {
                    graphQLBatchRequest.m11226d().mo1652a(b.f15578d, b.f15581g);
                    i5 = i;
                    i = i2;
                    i2 = i3;
                    obj2 = obj;
                    i6 = i5;
                } else {
                    if (!b.f15579e.booleanValue()) {
                        if (!(b.f15575a == null && b.f15576b == null)) {
                            Builder a2 = Builder.m21595a(b.f15580f);
                            if (b.f15575a != null) {
                                a2.f15063e = b.f15575a;
                            }
                            if (b.f15576b != null) {
                                a2.f15064f = b.f15576b;
                            }
                            a2.f15068j = b.f15577c;
                            b.f15580f = a2.m21600a();
                        }
                        graphQLBatchRequest.m11226d().mo1651a(b.f15580f, b.f15581g);
                    }
                    i5 = i;
                    i = i2;
                    i2 = i3;
                    obj2 = obj;
                    i6 = i5;
                }
            }
            while (jsonParser.mo1794g() == JsonToken.END_OBJECT) {
                jsonParser.mo1766c();
            }
            i5 = i6;
            obj = obj2;
            i3 = i2;
            i2 = i;
            i = i5;
        }
        if (obj == null) {
            this.f7234d.m2340a("graphql_error", "Did not receive an end of message result");
        }
        if (!a.containsAll(graphQLBatchRequest.m11225c())) {
            for (String str : Sets.m1326c(graphQLBatchRequest.f6470a.keySet(), a)) {
                graphQLBatchRequest.m11226d().mo1652a(new GraphQLInvalidBatchResponseException("Did not receive response for " + str), (GraphQLRequest) graphQLBatchRequest.f6470a.get(str));
            }
        }
        if (i4 != (i3 + i2) + i) {
            this.f7234d.m2340a("graphql_error", "Received a different number of results than the server sent (" + i4 + " vs. " + (i2 + i3) + " received).");
        }
        graphQLBatchRequest.m11226d().mo1650a();
        return null;
    }

    public final Void m11716a(InputStream inputStream, GraphQLBatchRequest graphQLBatchRequest) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int i = 0;
        while (i < 51) {
            int b = m11709b(dataInputStream);
            String str;
            if (b > 1000000) {
                if (b == 1919230587) {
                    str = "{\"er" + m11707a(dataInputStream);
                    try {
                        GraphQLError a = GraphQLError.a(new JSONObject(str).getJSONObject("error"));
                        if (a != null) {
                            throw GraphQLProtocolParseHelper.m29712a(a);
                        }
                    } catch (JSONException e) {
                        this.f7234d.m2350b("FLATBUFFER_FROM_SERVER", "Not able to parse error message:" + str);
                    }
                } else {
                    byte[] bArr = new byte[256];
                    try {
                        dataInputStream.read(bArr);
                    } catch (IOException e2) {
                    }
                    this.f7234d.m2350b("FLATBUFFER_FROM_SERVER", "Story length exceeds max story size:" + b + new String(bArr, "UTF-8"));
                }
            } else if (b == 0) {
                if (i == 0) {
                    try {
                        str = m11707a(dataInputStream);
                        if (str != null) {
                            GraphQLError a2 = GraphQLError.a(new JSONObject(str).getJSONObject("error"));
                            if (a2 != null) {
                                throw GraphQLProtocolParseHelper.m29712a(a2);
                            }
                        }
                    } catch (JSONException e3) {
                    }
                }
            } else if (i == 50) {
                this.f7234d.m2350b("FLATBUFFER_FROM_SERVER", "Number of stories exceeds maximum story limit");
                break;
            } else {
                BatchRawQueryResponse a3 = m11704a(dataInputStream, graphQLBatchRequest, b);
                if (a3.f15578d != null) {
                    graphQLBatchRequest.m11226d().mo1652a(a3.f15578d, a3.f15581g);
                } else {
                    graphQLBatchRequest.m11226d().mo1651a(a3.f15580f, a3.f15581g);
                }
                i++;
            }
        }
        graphQLBatchRequest.m11226d().mo1650a();
        return null;
    }

    private static String m11707a(DataInputStream dataInputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[2048];
            while (true) {
                int read = dataInputStream.read(bArr);
                if (read < 0) {
                    return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            return null;
        }
    }

    public final GraphQLResult<?> m11713a(JsonParser jsonParser, GraphQLRequest graphQLRequest, DataFreshnessResult dataFreshnessResult) {
        boolean z = true;
        int i = 0;
        if (this.f7233c.f5542i != null) {
            this.f7233c.f5542i.m9547a(graphQLRequest.f7096o.f6530b, graphQLRequest.f7096o.f6532d, jsonParser);
        }
        if (graphQLRequest.f7094l) {
            Object obj;
            if (graphQLRequest.f7105x != 1) {
                z = false;
            }
            Preconditions.checkState(z);
            JsonDeserializer jsonDeserializer = graphQLRequest.f7098q;
            if (jsonDeserializer != null) {
                obj = (Map) jsonDeserializer.mo1797a(jsonParser, null);
            } else {
                Map a = GraphQLProtocolParseHelper.m29715a(graphQLRequest.f7097p, jsonParser, 0, this.f7233c.f5536c);
            }
            Builder builder = new Builder();
            builder.f15069k = obj;
            Builder builder2 = builder;
            builder2.f15060b = dataFreshnessResult;
            builder2 = builder2;
            builder2.f15061c = this.f7235e.mo211a();
            builder2 = builder2.m21599a(graphQLRequest.f7087e);
            builder2.f15067i = graphQLRequest.f7084b;
            return builder2.m21600a();
        }
        Object a2;
        this.f7233c.m9437a(graphQLRequest.f7096o.f6530b, graphQLRequest.f7105x, jsonParser);
        int i2 = graphQLRequest.f7105x;
        if (jsonParser.mo1794g() == JsonToken.END_OBJECT) {
            i2--;
        }
        JsonDeserializer jsonDeserializer2 = graphQLRequest.f7098q;
        if (jsonDeserializer2 != null) {
            a2 = jsonDeserializer2.mo1797a(jsonParser, null);
        } else {
            a2 = jsonParser.m13259a(graphQLRequest.f7097p);
        }
        while (i < i2) {
            if (jsonParser.mo1766c() == JsonToken.FIELD_NAME) {
                jsonParser.mo1766c();
                jsonParser.mo1793f();
            }
            i++;
        }
        builder2 = new Builder();
        builder2.f15069k = a2;
        builder2 = builder2;
        builder2.f15060b = dataFreshnessResult;
        builder2 = builder2;
        builder2.f15061c = this.f7235e.mo211a();
        builder2 = builder2.m21599a(graphQLRequest.f7087e);
        builder2.f15067i = graphQLRequest.f7084b;
        return builder2.m21600a();
    }

    private static int m11709b(DataInputStream dataInputStream) {
        byte[] bArr = new byte[4];
        dataInputStream.readFully(bArr);
        return ((bArr[3] & 255) << 24) | (((bArr[0] & 255) | ((bArr[1] & 255) << 8)) | ((bArr[2] & 255) << 16));
    }

    private GraphQLResult<?> m11705a(byte[] bArr, GraphQLRequest graphQLRequest, DataFreshnessResult dataFreshnessResult) {
        Flattenable a = MutableFlatBuffer.m21520a(ByteBuffer.wrap(bArr), graphQLRequest.f7097p, null);
        if (this.f7233c.f5542i != null) {
            this.f7233c.f5542i.m9547a(graphQLRequest.f7096o.f6530b, graphQLRequest.f7096o.f6532d, a);
            if ((a instanceof BaseModel) && (a instanceof MutableFlattenable)) {
                FieldAccessQueryTracker b = FieldAccessQueryContext.m9557b(((MutableFlattenable) a).w_());
                if (b != null) {
                    ((BaseModel) a).m9942a(b);
                }
            }
        }
        Builder builder = new Builder();
        builder.f15069k = a;
        builder = builder;
        builder.f15060b = dataFreshnessResult;
        builder = builder;
        builder.f15061c = this.f7235e.mo211a();
        builder = builder.m21599a(graphQLRequest.f7087e);
        builder.f15067i = graphQLRequest.f7084b;
        return builder.m21600a();
    }

    public final GraphQLResult m11714a(InputStream inputStream, GraphQLRequest graphQLRequest) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int b = m11709b(dataInputStream);
        if (b > 1000000) {
            byte[] bArr = new byte[256];
            try {
                dataInputStream.read(bArr);
            } catch (IOException e) {
            }
            this.f7234d.m2350b("FLATBUFFER_FROM_SERVER", "Server response length exceeds max flatbuffer size:" + b + new String(bArr, "UTF-8"));
        }
        int b2 = m11709b(dataInputStream);
        byte[] bArr2 = new byte[b2];
        dataInputStream.readFully(bArr2);
        String str = new String(bArr2, "UTF-8");
        b = (b - b2) - 4;
        if (b > 0) {
            byte[] bArr3 = new byte[b];
            dataInputStream.readFully(bArr3);
            return m11705a(bArr3, graphQLRequest, DataFreshnessResult.FROM_SERVER);
        } else if (b == 0) {
            throw new RuntimeException(str);
        } else {
            String str2 = "Response size should be bigger than header size";
            BLog.c("FLATBUFFER_FROM_SERVER", str2);
            throw new RuntimeException(str2);
        }
    }

    @Nonnull
    public static Set<String> m11708a(@Nullable Object obj) {
        TracerDetour.a("GraphQLResponseParser.findTags", -1917615378);
        try {
            Set<String> set;
            if (obj instanceof GraphQLVisitableModel) {
                GraphQLVisitableModel graphQLVisitableModel = (GraphQLVisitableModel) obj;
                GraphQLReadOnlyVisitor graphQLIdFindingVisitor = new GraphQLIdFindingVisitor();
                graphQLIdFindingVisitor.mo2928b(graphQLVisitableModel);
                set = graphQLIdFindingVisitor.f22226a;
            } else {
                set = ImmutableSet.of();
                TracerDetour.a(603580598);
            }
            return set;
        } finally {
            TracerDetour.a(-1163678605);
        }
    }
}
