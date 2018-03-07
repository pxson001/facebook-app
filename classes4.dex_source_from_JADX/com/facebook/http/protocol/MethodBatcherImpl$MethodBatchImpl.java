package com.facebook.http.protocol;

import android.net.Uri;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.udppriming.client.EncryptChannelInformation;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.crudolib.params.ParamsCollectionArray;
import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.crudolib.params.ParamsFormEncoder;
import com.facebook.crudolib.params.ParamsJsonEncoder;
import com.facebook.crudolib.params.SimpleIntArrayMap;
import com.facebook.debug.log.BLog;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.http.common.DefaultNetworkPriority;
import com.facebook.http.config.PlatformAppHttpConfig;
import com.facebook.http.entity.mime.MultipartEntityWithProgressListener;
import com.facebook.http.entity.mime.UrlEncodingEntityWithProgressListener;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.BatchOperation.BatchController;
import com.facebook.http.protocol.BatchOperation.ProcessedBatchResponse;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;

/* compiled from: features_extra_data */
public class MethodBatcherImpl$MethodBatchImpl extends AbstractBatch {
    public final /* synthetic */ MethodBatcherImpl f11908a;
    private BatchController f11909b;

    /* compiled from: features_extra_data */
    class BatchResponseHandler implements ResponseHandler<Void> {
        final /* synthetic */ MethodBatcherImpl$MethodBatchImpl f11943a;
        private final ApiMethodRunnerParams f11944b;
        private final List<BatchOperation<?, ?>> f11945c;
        private final List<MethodBatcherImpl$BatchRequest<?, ?>> f11946d;
        @Nullable
        private final CallerContext f11947e;

        public BatchResponseHandler(MethodBatcherImpl$MethodBatchImpl methodBatcherImpl$MethodBatchImpl, ApiMethodRunnerParams apiMethodRunnerParams, List<BatchOperation<?, ?>> list, List<MethodBatcherImpl$BatchRequest<?, ?>> list2, @Nullable CallerContext callerContext) {
            this.f11943a = methodBatcherImpl$MethodBatchImpl;
            this.f11944b = (ApiMethodRunnerParams) Preconditions.checkNotNull(apiMethodRunnerParams);
            this.f11945c = (List) Preconditions.checkNotNull(list);
            this.f11946d = (List) Preconditions.checkNotNull(list2);
            this.f11947e = callerContext;
        }

        public Object handleResponse(HttpResponse httpResponse) {
            try {
                m12555b(httpResponse);
                return null;
            } catch (Exception e) {
                throw IOExecutionExceptionWrapper.m10856a(e);
            }
        }

        private void m12555b(HttpResponse httpResponse) {
            Exception exception;
            HttpEntity entity = httpResponse.getEntity();
            this.f11943a.f11908a.p.a(httpResponse);
            BatchJsonParser batchJsonParser = new BatchJsonParser(this.f11943a.f11908a.n.a(entity.getContent()), ((Boolean) this.f11943a.f11908a.z.get()).booleanValue());
            Exception exception2 = null;
            int i = 0;
            while (batchJsonParser.m12557L()) {
                try {
                    if (i == this.f11945c.size() && this.f11943a.m12531d()) {
                        this.f11943a.m12525a(new DeviceApiResult((JsonNode) batchJsonParser.a(JsonNode.class)));
                        break;
                    }
                    BatchOperation batchOperation = (BatchOperation) this.f11945c.get(i);
                    MethodBatcherImpl$BatchRequest methodBatcherImpl$BatchRequest = (MethodBatcherImpl$BatchRequest) this.f11946d.get(i);
                    if (batchJsonParser.g() != JsonToken.VALUE_NULL) {
                        batchJsonParser.c();
                    }
                    try {
                        Object a = this.f11943a.m12510a(methodBatcherImpl$BatchRequest, (JsonParser) batchJsonParser, httpResponse, this.f11944b, this.f11947e);
                        if (batchOperation.m12545g() != null) {
                            batchOperation.m12545g().a(a);
                        }
                        this.f11943a.m12528a(batchOperation.m12544c(), a);
                        exception = exception2;
                    } catch (Exception exception3) {
                        Exception exception4 = exception3;
                        TriState h = methodBatcherImpl$BatchRequest.f11939a.m12546h();
                        if (exception2 == null && (h.equals(TriState.YES) || (this.f11944b.g() && h.equals(TriState.UNSET)))) {
                            exception3 = exception4;
                        } else {
                            exception3 = exception2;
                        }
                        if (batchOperation.m12545g() != null) {
                            batchOperation.m12545g().a(exception4);
                        }
                        this.f11943a.m12527a(batchOperation.m12544c(), exception4);
                    }
                    i++;
                    exception2 = exception3;
                } finally {
                    batchJsonParser.mo892K();
                }
            }
            if (i != this.f11945c.size()) {
                throw new Exception("Received wrong number of batches in response");
            } else if (exception2 != null) {
                throw exception2;
            }
        }
    }

    private <P, R> MethodBatcherImpl$BatchRequest<P, R> m12517b(BatchOperation<P, R> batchOperation) {
        ApiRequest a;
        String str;
        String str2;
        ApiMethod apiMethod = batchOperation.f11917a;
        ApiRequest apiRequest = null;
        if (apiMethod instanceof AbstractPersistedGraphQlApiMethod) {
            apiRequest = ((AbstractPersistedGraphQlApiMethod) apiMethod).d(batchOperation.f11918b);
        }
        if (apiRequest == null) {
            a = apiMethod.a(batchOperation.f11918b);
        } else {
            a = apiRequest;
        }
        if (apiMethod instanceof ApiMethodEvents) {
            ((ApiMethodEvents) apiMethod).b(batchOperation.f11918b);
        }
        ParamsCollectionMap b = this.f11908a.x.b();
        b.a(ParamsJsonEncoder.a());
        b.a("method", a.b);
        ParamsCollectionMap a2 = this.f11908a.q.a(a);
        if (((Boolean) this.f11908a.h.get()).booleanValue()) {
            a2.a("phprof_sample", "1");
            str = (String) this.f11908a.f.get();
            if (str != null) {
                a2.a("phprof_user", str);
            }
        }
        if (((Boolean) this.f11908a.i.get()).booleanValue()) {
            a2.a("teak_sample", "1");
            str = (String) this.f11908a.f.get();
            if (str != null) {
                a2.a("teak_user", str);
            }
        }
        if (((Boolean) this.f11908a.j.get()).booleanValue()) {
            a2.a("wirehog_sample", "1");
            str = (String) this.f11908a.f.get();
            if (str != null) {
                a2.a("wirehog_user", str);
            }
        }
        if (((Boolean) this.f11908a.k.get()).booleanValue()) {
            a2.a("artillery_sample", "1");
        }
        a2.a("fb_api_req_friendly_name", a.a);
        ParamsCollectionMap paramsCollectionMap = a2;
        String str3 = a.c;
        if (TigonRequest.GET.equals(a.b)) {
            str3 = str3 + "?" + UrlEncodingEntityWithProgressListener.a(paramsCollectionMap);
            paramsCollectionMap.a();
        } else if (TigonRequest.POST.equals(a.b)) {
            b.a("body", paramsCollectionMap);
            paramsCollectionMap.a(ParamsFormEncoder.a());
            Class cls = ParamsJsonEncoder.class;
            if (paramsCollectionMap.a == null) {
                paramsCollectionMap.a = new SimpleIntArrayMap(1);
            }
            paramsCollectionMap.a.m12553a(cls, 1);
        } else if ("DELETE".equals(a.b)) {
            str3 = str3 + "?" + UrlEncodingEntityWithProgressListener.a(paramsCollectionMap);
            paramsCollectionMap.a();
        } else {
            throw new UnsupportedOperationException("Unsupported method: " + a.b);
        }
        if (batchOperation.f11919c != null) {
            b.a("name", batchOperation.f11919c);
        }
        if (batchOperation.f11920d != null) {
            b.a("depends_on", batchOperation.f11920d);
        }
        if (batchOperation.f11923g != null) {
            str2 = str3 + batchOperation.f11923g;
        } else {
            str2 = str3;
        }
        if (batchOperation.f11921e != null) {
            b.a("continue_if_set", batchOperation.f11921e);
        }
        ImmutableList immutableList = RegularImmutableList.a;
        if (a.m() != null) {
            Builder builder = ImmutableList.builder();
            ParamsCollectionMap b2 = b.b("attached_files");
            for (FormBodyPart formBodyPart : a.m()) {
                b2.b(formBodyPart.a);
                builder.c(formBodyPart);
            }
            immutableList = builder.b();
        }
        b.a("omit_response_on_success", Boolean.valueOf(false));
        b.a("relative_url", str2);
        return new MethodBatcherImpl$BatchRequest(batchOperation, a, b, immutableList);
    }

    private static void m12515a(HttpUriRequest httpUriRequest, ApiMethodRunnerParams apiMethodRunnerParams) {
        if (apiMethodRunnerParams.g != null) {
            ImmutableList immutableList = apiMethodRunnerParams.g;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                httpUriRequest.addHeader((Header) immutableList.get(i));
            }
        }
    }

    public MethodBatcherImpl$MethodBatchImpl(MethodBatcherImpl methodBatcherImpl) {
        this.f11908a = methodBatcherImpl;
    }

    public final void mo884a(String str, CallerContext callerContext, @Nullable ApiMethodRunnerParams apiMethodRunnerParams) {
        ApiMethodRunnerParams apiMethodRunnerParams2;
        PlatformAppHttpConfig platformAppHttpConfig;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(callerContext);
        CallerContext a = CallerContext.a(callerContext, str);
        this.f11909b = this.f11908a.s.a(m12529b());
        if (apiMethodRunnerParams == null) {
            apiMethodRunnerParams2 = new ApiMethodRunnerParams();
        } else {
            apiMethodRunnerParams2 = apiMethodRunnerParams;
        }
        if (MethodBatcherImpl.C.contains(str)) {
            this.f11908a.v.a(apiMethodRunnerParams2);
        }
        switch (MethodBatcherImpl$1.f11934a[apiMethodRunnerParams2.b().ordinal()]) {
            case 1:
                platformAppHttpConfig = this.f11908a.c;
                break;
            case 2:
                if (!((Boolean) this.f11908a.l.get()).booleanValue()) {
                    platformAppHttpConfig = this.f11908a.d;
                    break;
                } else {
                    platformAppHttpConfig = (PlatformAppHttpConfig) this.f11908a.b.get();
                    break;
                }
            default:
                platformAppHttpConfig = (PlatformAppHttpConfig) this.f11908a.b.get();
                break;
        }
        List<BatchOperation> a2 = m12523a();
        List a3 = Lists.a();
        List a4 = Lists.a();
        for (BatchOperation b : a2) {
            MethodBatcherImpl$BatchRequest b2 = m12517b(b);
            a3.add(b2);
            if (!(b2 == null || b2.f11940b == null)) {
                a4.add(b2.f11940b.g().a());
            }
        }
        HttpUriRequest a5 = m12513a(apiMethodRunnerParams2, a3, str, a, platformAppHttpConfig);
        try {
            this.f11908a.e.a(MethodRunnerUtil.a(str, a5, m12509a(apiMethodRunnerParams2, a4), m12516b(a3), new BatchResponseHandler(this, apiMethodRunnerParams2, a2, a3, a), apiMethodRunnerParams2, a, m12518c(a3)));
            MethodRunnerUtil.a(a5);
        } catch (Exception e) {
            Exception b3 = IOExecutionExceptionWrapper.m10857b(e);
            for (BatchOperation b4 : a2) {
                ApiMethod a6 = b4.m12542a();
                if (a6 instanceof ApiMethodEvents) {
                    ((ApiMethodEvents) a6).a(b4.m12543b(), b3);
                }
            }
            throw b3;
        } catch (Throwable th) {
            MethodRunnerUtil.a(a5);
        }
    }

    private static RequestPriority m12509a(ApiMethodRunnerParams apiMethodRunnerParams, List<RequestPriority> list) {
        if (apiMethodRunnerParams != null && apiMethodRunnerParams.f != null) {
            return apiMethodRunnerParams.f;
        }
        RequestPriority requestPriority = null;
        for (RequestPriority requestPriority2 : list) {
            RequestPriority requestPriority22;
            if (requestPriority22 != null) {
                if (!requestPriority22.isHigherPriorityThan(requestPriority)) {
                    requestPriority22 = requestPriority;
                }
                requestPriority = requestPriority22;
            }
        }
        return requestPriority == null ? DefaultNetworkPriority.a() : requestPriority;
    }

    private HttpPost m12513a(ApiMethodRunnerParams apiMethodRunnerParams, List<MethodBatcherImpl$BatchRequest<?, ?>> list, String str, CallerContext callerContext, PlatformAppHttpConfig platformAppHttpConfig) {
        Object obj;
        String str2;
        HttpEntity a = MethodRunnerUtil.a(m12512a((List) list, str, callerContext));
        HttpUriRequest httpPost = new HttpPost(m12508a(platformAppHttpConfig).toString());
        if (str.equalsIgnoreCase("authLogin") || str.equalsIgnoreCase("handleGetSessionlessQEs") || str.equalsIgnoreCase("logged_out_set_nonce")) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            ViewerContext viewerContext = (ViewerContext) this.f11908a.g.get();
            if (viewerContext != null) {
                str2 = viewerContext.mAuthToken;
            } else {
                str2 = null;
            }
            if (str2 == null) {
                throw new AuthTokenNullException("auth token is null, user logged out?");
            }
            httpPost.addHeader("Authorization", "OAuth " + str2);
        } else {
            if (str.equalsIgnoreCase("authLogin") || str.equalsIgnoreCase("handleGetSessionlessQEs") || str.equalsIgnoreCase("logged_out_set_nonce")) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                httpPost.addHeader("Authorization", "OAuth " + StringUtil.b("|", new Object[]{this.f11908a.y.c(), this.f11908a.y.e()}));
            }
        }
        httpPost.setEntity(a);
        str2 = platformAppHttpConfig.h();
        if (str2 != null) {
            httpPost.addHeader("User-Agent", str2);
        }
        m12515a(httpPost, apiMethodRunnerParams);
        str2 = platformAppHttpConfig.i();
        if (str2 != null) {
            httpPost.addHeader("X-FB-Connection-Type", str2);
        }
        if (this.f11908a.t.a() && "fetch-feed-batch".equals(callerContext.b())) {
            httpPost.addHeader("X-FB-Priming-Channel-ID", EncryptChannelInformation.a.c);
        }
        if (apiMethodRunnerParams.h != FbTraceNode.a) {
            httpPost.addHeader("X-FBTrace-Sampled", "true");
            httpPost.addHeader("X-FBTrace-Meta", apiMethodRunnerParams.h.a());
        }
        if (((Boolean) this.f11908a.m.get()).booleanValue()) {
            httpPost.addHeader("Date", this.f11908a.B.a(TimeFormatStyle.RFC1123_STYLE, this.f11908a.A.a()));
        }
        return httpPost;
    }

    private HttpEntity m12512a(List<MethodBatcherImpl$BatchRequest<?, ?>> list, String str, CallerContext callerContext) {
        Object obj;
        ParamsCollectionMap b = this.f11908a.x.b();
        ParamsCollectionArray c = b.c("batch");
        c.a(ParamsJsonEncoder.a());
        for (MethodBatcherImpl$BatchRequest methodBatcherImpl$BatchRequest : list) {
            c.c(methodBatcherImpl$BatchRequest.f11941c);
        }
        b.a("fb_api_caller_class", callerContext.b);
        b.a("fb_api_req_friendly_name", str);
        if (m12531d()) {
            m12514a(b);
        }
        this.f11909b.a(b);
        for (MethodBatcherImpl$BatchRequest methodBatcherImpl$BatchRequest2 : list) {
            if (!methodBatcherImpl$BatchRequest2.f11942d.isEmpty()) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj == null) {
            return new UrlEncodingEntityWithProgressListener(b);
        }
        MultipartEntityWithProgressListener multipartEntityWithProgressListener = new MultipartEntityWithProgressListener();
        multipartEntityWithProgressListener.a(b);
        for (MethodBatcherImpl$BatchRequest methodBatcherImpl$BatchRequest3 : list) {
            ImmutableList immutableList = methodBatcherImpl$BatchRequest3.f11942d;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                FormBodyPart formBodyPart = (FormBodyPart) immutableList.get(i);
                multipartEntityWithProgressListener.a(formBodyPart.a, formBodyPart.c);
            }
        }
        return multipartEntityWithProgressListener;
    }

    private void m12514a(ParamsCollectionMap paramsCollectionMap) {
        Preconditions.checkState(m12531d());
        DeviceApiContext deviceApiContext = this.f11915f;
        ParamsCollectionMap b = paramsCollectionMap.b("device_api");
        b.a(ParamsJsonEncoder.a());
        b.a("method", deviceApiContext.a);
        ParamsCollectionMap b2 = b.b("device_context");
        Iterator it = deviceApiContext.b.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            b2.a((String) entry.getKey(), (String) entry.getValue());
        }
        b2 = b.b("app_context");
        it = deviceApiContext.c.entrySet().iterator();
        while (it.hasNext()) {
            entry = (Entry) it.next();
            b2.a((String) entry.getKey(), (String) entry.getValue());
        }
        b = b.b("method_context");
        Iterator it2 = deviceApiContext.d.entrySet().iterator();
        while (it2.hasNext()) {
            entry = (Entry) it2.next();
            b.a((String) entry.getKey(), (String) entry.getValue());
        }
    }

    private <P, R> Object m12510a(MethodBatcherImpl$BatchRequest<P, R> methodBatcherImpl$BatchRequest, JsonParser jsonParser, HttpResponse httpResponse, ApiMethodRunnerParams apiMethodRunnerParams, @Nullable CallerContext callerContext) {
        int i;
        BatchOperation batchOperation = methodBatcherImpl$BatchRequest.f11939a;
        ApiMethod a = batchOperation.m12542a();
        ApiRequest apiRequest = methodBatcherImpl$BatchRequest.f11940b;
        ProcessedBatchResponse a2 = this.f11909b.a(batchOperation, jsonParser, this.f11908a.p);
        if (a instanceof ApiMethodEvents) {
            ((ApiMethodEvents) a).c(batchOperation.m12543b());
        }
        if (a2 == ProcessedBatchResponse.f11953a) {
            throw new BatchMethodNotExecutedException(batchOperation.m12544c());
        }
        ApiResponse apiResponse;
        JsonParser b = a2.m12610b();
        b.a(this.f11908a.o);
        String c = methodBatcherImpl$BatchRequest.f11939a.m12544c();
        boolean z = c != null && c.equals("first-fetch") && UDPPrimingHelper.a(httpResponse);
        Optional.fromNullable(apiMethodRunnerParams.e());
        if (apiRequest.n() == ApiResponseType.JSONPARSER) {
            apiResponse = new ApiResponse(apiRequest, a2.m12609a(), b, this.f11908a.p, z);
        } else if (apiRequest.n() == ApiResponseType.STREAM || apiRequest.n() == ApiResponseType.FLATBUFFER) {
            throw new UnsupportedOperationException("Not supportable");
        } else if (apiRequest.n() == ApiResponseType.JSON) {
            apiResponse = new ApiResponse(apiRequest, a2.m12609a(), (JsonNode) b.a(JsonNode.class), this.f11908a.p, z);
        } else if (apiRequest.n() == ApiResponseType.STRING) {
            apiResponse = new ApiResponse(apiRequest, a2.m12609a(), this.f11908a.o.a(b.a(JsonNode.class)), this.f11908a.p, z);
        } else {
            throw new IllegalArgumentException("Unknown api response type");
        }
        if (!(a instanceof AbstractPersistedGraphQlApiMethod)) {
            return a.a(batchOperation.m12543b(), apiResponse);
        }
        Object a3;
        AbstractPersistedGraphQlApiMethod abstractPersistedGraphQlApiMethod = (AbstractPersistedGraphQlApiMethod) a;
        Object obj = null;
        try {
            a3 = abstractPersistedGraphQlApiMethod.a(batchOperation.m12543b(), apiResponse);
        } catch (Throwable e) {
            BLog.c(MethodBatcherImpl.a, e, "Invalid persisted graphql query id", new Object[0]);
            i = 1;
            a3 = null;
        } catch (GraphQlUnpersistableQueryException e2) {
            i = 1;
            a3 = null;
        }
        if (obj == null) {
            return a3;
        }
        return this.f11908a.r.a(abstractPersistedGraphQlApiMethod.a(batchOperation.m12543b()), apiMethodRunnerParams, abstractPersistedGraphQlApiMethod, null, batchOperation.m12543b(), callerContext).a();
    }

    private Uri m12508a(PlatformAppHttpConfig platformAppHttpConfig) {
        String str;
        Uri.Builder b = platformAppHttpConfig.b();
        if (((Boolean) this.f11908a.h.get()).booleanValue()) {
            b.appendQueryParameter("phprof_sample", "1");
            str = (String) this.f11908a.f.get();
            if (str != null) {
                b.appendQueryParameter("phprof_user", str);
            }
        }
        if (((Boolean) this.f11908a.j.get()).booleanValue()) {
            b.appendQueryParameter("wirehog_sample", "1");
            str = (String) this.f11908a.f.get();
            if (str != null) {
                b.appendQueryParameter("wirehog_user", str);
            }
        }
        if (((Boolean) this.f11908a.k.get()).booleanValue()) {
            b.appendQueryParameter("artillery_sample", "1");
        }
        b.appendQueryParameter("include_headers", "false");
        b.appendQueryParameter("decode_body_json", "false");
        b.appendQueryParameter("streamable_json_response", "true");
        ApiRequestUtils apiRequestUtils = this.f11908a.q;
        b.appendQueryParameter("locale", apiRequestUtils.a.c());
        String str2 = (String) apiRequestUtils.b.get();
        if (str2 != null) {
            b.appendQueryParameter("client_country_code", str2);
        }
        return b.build();
    }

    private static FallbackBehavior m12516b(List<MethodBatcherImpl$BatchRequest<?, ?>> list) {
        for (MethodBatcherImpl$BatchRequest methodBatcherImpl$BatchRequest : list) {
            if (methodBatcherImpl$BatchRequest.f11940b.w == FallbackBehavior.FALLBACK_REQUIRED) {
                return FallbackBehavior.FALLBACK_REQUIRED;
            }
        }
        return FallbackBehavior.FALLBACK_NOT_REQUIRED;
    }

    private static com.facebook.http.common.RequestIdempotency m12518c(java.util.List<com.facebook.http.protocol.MethodBatcherImpl$BatchRequest<?, ?>> r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r1 = r5.iterator();
    L_0x0004:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0035;
    L_0x000a:
        r0 = r1.next();
        r0 = (com.facebook.http.protocol.MethodBatcherImpl$BatchRequest) r0;
        r0 = r0.f11940b;
        r4 = r0.x;
        r0 = r4;
        r2 = com.facebook.http.protocol.MethodBatcherImpl$1.f11935b;
        r3 = r0.ordinal();
        r2 = r2[r3];
        switch(r2) {
            case 1: goto L_0x0037;
            case 2: goto L_0x0004;
            default: goto L_0x0020;
        };
    L_0x0020:
        r1 = new java.lang.IllegalStateException;
        r2 = new java.lang.StringBuilder;
        r3 = "Unknown idempotency=";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0035:
        r0 = com.facebook.http.common.RequestIdempotency.RETRY_SAFE;
    L_0x0037:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.protocol.MethodBatcherImpl$MethodBatchImpl.c(java.util.List):com.facebook.http.common.RequestIdempotency");
    }
}
