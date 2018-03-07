package com.facebook.http.protocol;

import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiErrorResult.Builder;
import com.facebook.http.protocol.ApiErrorResult.ErrorDomain;
import com.facebook.http.reauth.SsoReauthRequiredHandler;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;

@Singleton
/* compiled from: request_time */
public class ApiResponseChecker {
    private static volatile ApiResponseChecker f7269d;
    @Inject
    public volatile Provider<SsoReauthRequiredHandler> f7270a = UltralightRuntime.f367a;
    public final ObjectMapper f7271b;
    private BaseFbBroadcastManager f7272c;

    /* compiled from: request_time */
    public abstract class AbstractHttpResponseAdapter {
        public final int f15559a;
        @Nullable
        public final String f15560b;
        public String f15561c;

        @Nullable
        public abstract String mo2859a();

        public AbstractHttpResponseAdapter(int i, @Nullable String str) {
            this.f15559a = i;
            this.f15560b = str;
        }
    }

    public static com.facebook.http.protocol.ApiResponseChecker m11759a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7269d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.protocol.ApiResponseChecker.class;
        monitor-enter(r1);
        r0 = f7269d;	 Catch:{ all -> 0x003a }
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
        r0 = m11763b(r0);	 Catch:{ all -> 0x0035 }
        f7269d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7269d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.protocol.ApiResponseChecker.a(com.facebook.inject.InjectorLike):com.facebook.http.protocol.ApiResponseChecker");
    }

    private static ApiResponseChecker m11763b(InjectorLike injectorLike) {
        ApiResponseChecker apiResponseChecker = new ApiResponseChecker(FbObjectMapperMethodAutoProvider.m6609a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike));
        apiResponseChecker.f7270a = IdBasedProvider.m1811a(injectorLike, 7206);
        return apiResponseChecker;
    }

    @Inject
    private ApiResponseChecker(ObjectMapper objectMapper, BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f7271b = objectMapper;
        this.f7272c = baseFbBroadcastManager;
    }

    private ApiException m11758a(JsonNode jsonNode, JsonNode jsonNode2) {
        int d = JSONUtil.m13460d(jsonNode2.mo710c("code"));
        Builder a = ApiErrorResult.a(d, JSONUtil.m13458b(jsonNode2.mo710c("description")));
        a.g = jsonNode.toString();
        a = a.a(ErrorDomain.GRAPHQL_KERROR_DOMAIN);
        a.i = jsonNode2.mo710c("is_transient").mo726a(true);
        ApiErrorResult a2 = a.a();
        switch (d) {
            case 102:
                return new GraphQLAuthException(a2);
            case 190:
                d = jsonNode2.mo730d("error_subcode") ? JSONUtil.m13460d(jsonNode2.mo710c("error_subcode")) : 0;
                if (d == 490) {
                    m11760a();
                    return null;
                } else if (d != 491) {
                    return new GraphQLAuthException(a2);
                } else {
                    if (m11764b()) {
                        return null;
                    }
                    return new ApiException(a2);
                }
            case 1675007:
                return new GraphQlInvalidQueryIdException(a2);
            case 1675013:
                return new GraphQlUnpersistableQueryException(a2);
            default:
                return new ApiException(a2);
        }
    }

    private void m11762a(JsonNode jsonNode, ObjectMapper objectMapper) {
        boolean z = false;
        ApiException apiException = null;
        if (jsonNode != null) {
            if (jsonNode.m5197i()) {
                if (jsonNode.mo730d("error_code")) {
                    String b = JSONUtil.m13458b(jsonNode.mo710c("error_msg"));
                    String b2 = JSONUtil.m13458b(jsonNode.mo710c("error_data"));
                    if (b2 != null) {
                        try {
                            JsonNode a = objectMapper.m6636a(b2);
                            if (a.mo730d("error_message")) {
                                b = JSONUtil.m13458b(a.mo709b("error_message"));
                            }
                        } catch (IOException e) {
                        }
                    }
                    apiException = new ApiException(ApiErrorResult.a(JSONUtil.m13460d(jsonNode.mo710c("error_code")), b).b(b2).e(jsonNode.toString()).a(ErrorDomain.API_EC_DOMAIN).a(jsonNode.mo710c("is_transient").mo726a(true)).a());
                } else if (jsonNode.mo730d("error") && jsonNode.mo710c("error").mo1604n()) {
                    apiException = new ApiException(ApiErrorResult.a(JSONUtil.m13460d(jsonNode.mo710c("error")), JSONUtil.m13458b(jsonNode.mo710c("error_description"))).e(jsonNode.toString()).a(ErrorDomain.API_EC_DOMAIN).a(jsonNode.mo710c("is_transient").mo726a(true)).a());
                } else if (jsonNode.mo730d("error") && jsonNode.mo710c("error").m5197i()) {
                    JsonNode c = jsonNode.mo710c("error");
                    if (c.mo730d("code") && c.mo730d("description")) {
                        apiException = m11758a(jsonNode, c);
                    } else if (c.mo730d("message")) {
                        int d;
                        String b3;
                        String b4;
                        int d2 = c.mo730d("code") ? JSONUtil.m13460d(c.mo710c("code")) : 0;
                        if (c.mo730d("error_subcode")) {
                            d = JSONUtil.m13460d(c.mo710c("error_subcode"));
                        } else {
                            d = 0;
                        }
                        if (c.mo730d("error_user_title")) {
                            b3 = JSONUtil.m13458b(c.mo710c("error_user_title"));
                        } else {
                            b3 = null;
                        }
                        if (c.mo730d("error_user_msg")) {
                            b4 = JSONUtil.m13458b(c.mo710c("error_user_msg"));
                        } else {
                            b4 = null;
                        }
                        if (d2 == 190) {
                            switch (d) {
                                case 490:
                                    m11760a();
                                    z = true;
                                    break;
                                case 491:
                                    z = m11764b();
                                    if (z) {
                                        break;
                                    }
                                    break;
                            }
                        }
                        if (!z) {
                            apiException = new ApiException(ApiErrorResult.a(d2, JSONUtil.m13458b(c.mo710c("message"))).b(d).b(c.mo710c("error_data").toString()).c(b3).d(b4).e(jsonNode.toString()).a(ErrorDomain.API_EC_DOMAIN).a(c.mo710c("is_transient").mo726a(true)).a());
                        }
                    }
                }
                if (apiException != null) {
                    throw apiException;
                }
            } else if (!jsonNode.m5196h()) {
                throw new JsonMappingException("Response was neither an array or a dictionary");
            }
        }
    }

    private void m11760a() {
        this.f7272c.mo406a(new Intent().setAction("com.facebook.http.protocol.CHECKPOINT_API_EXCEPTION"));
    }

    private boolean m11764b() {
        SsoReauthRequiredHandler ssoReauthRequiredHandler = (SsoReauthRequiredHandler) this.f7270a.get();
        if (ssoReauthRequiredHandler != null) {
            return ssoReauthRequiredHandler.a();
        }
        return false;
    }

    public final void m11767a(@Nullable String str) {
        if (!StringUtil.m3589a((CharSequence) str)) {
            try {
                m11762a(this.f7271b.m6636a(str), this.f7271b);
            } catch (ApiException e) {
                throw e;
            } catch (JsonProcessingException e2) {
            } catch (IOException e3) {
            }
        }
    }

    public final void m11766a(@Nullable JsonNode jsonNode) {
        if (jsonNode != null) {
            try {
                m11762a(jsonNode, this.f7271b);
            } catch (JsonProcessingException e) {
            }
        }
    }

    public final void m11768a(HttpResponse httpResponse) {
        Preconditions.checkNotNull(httpResponse);
        StatusLine statusLine = httpResponse.getStatusLine();
        final HttpEntity entity = httpResponse.getEntity();
        m11761a(new AbstractHttpResponseAdapter(this, statusLine.getStatusCode(), statusLine.getReasonPhrase()) {
            final /* synthetic */ ApiResponseChecker f15558b;

            @Nullable
            public final String mo2859a() {
                return entity != null ? EntityUtils.toString(entity) : null;
            }
        });
    }

    public final void m11765a(int i, @Nullable String str, @Nullable JsonParser jsonParser) {
        m11761a(new 3(this, i, str, jsonParser));
    }

    private void m11761a(AbstractHttpResponseAdapter abstractHttpResponseAdapter) {
        int i = abstractHttpResponseAdapter.f15559a;
        if (i >= 300) {
            if (abstractHttpResponseAdapter.f15561c == null) {
                abstractHttpResponseAdapter.f15561c = abstractHttpResponseAdapter.mo2859a();
            }
            String str = abstractHttpResponseAdapter.f15561c;
            if (i >= 400) {
                m11767a(str);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(abstractHttpResponseAdapter.f15560b);
            if (str != null) {
                stringBuilder.append('\n');
                stringBuilder.append(str);
            }
            throw new HttpResponseException(i, stringBuilder.toString());
        }
    }
}
