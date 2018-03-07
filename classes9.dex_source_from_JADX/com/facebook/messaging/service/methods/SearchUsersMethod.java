package com.facebook.messaging.service.methods;

import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.service.model.SearchUserParams;
import com.facebook.messaging.service.model.SearchUserResult;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: cta */
public class SearchUsersMethod implements ApiMethod<SearchUserParams, SearchUserResult> {
    private static volatile SearchUsersMethod f16973b;
    private final boolean f16974a;

    public static com.facebook.messaging.service.methods.SearchUsersMethod m17025a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f16973b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.service.methods.SearchUsersMethod.class;
        monitor-enter(r1);
        r0 = f16973b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m17027b(r0);	 Catch:{ all -> 0x0035 }
        f16973b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16973b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.service.methods.SearchUsersMethod.a(com.facebook.inject.InjectorLike):com.facebook.messaging.service.methods.SearchUsersMethod");
    }

    private static SearchUsersMethod m17027b(InjectorLike injectorLike) {
        return new SearchUsersMethod(Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
    }

    public final ApiRequest m17028a(Object obj) {
        SearchUserParams searchUserParams = (SearchUserParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        arrayList.add(new BasicNameValuePair("context", "messenger_composer"));
        arrayList.add(new BasicNameValuePair("query", searchUserParams.f17298b));
        arrayList.add(new BasicNameValuePair("limit", "20"));
        arrayList.add(new BasicNameValuePair("filter", "['user']"));
        arrayList.add(new BasicNameValuePair("include_is_messenger_user", "1"));
        return new ApiRequest("searchUsersMethod", "GET", "method/ubersearch.get", arrayList, ApiResponseType.JSON);
    }

    @Inject
    public SearchUsersMethod(Boolean bool) {
        this.f16974a = bool.booleanValue();
    }

    private SearchUserResult m17026a(SearchUserParams searchUserParams, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        Builder builder = ImmutableList.builder();
        Builder builder2 = ImmutableList.builder();
        Builder builder3 = ImmutableList.builder();
        Builder builder4 = ImmutableList.builder();
        boolean contains = searchUserParams.m17173a().contains(Integer.valueOf(0));
        boolean contains2 = searchUserParams.m17173a().contains(Integer.valueOf(2));
        boolean contains3 = searchUserParams.m17173a().contains(Integer.valueOf(1));
        boolean contains4 = searchUserParams.m17173a().contains(Integer.valueOf(3));
        for (int i = 0; i < c.e(); i++) {
            JsonNode a = c.a(i);
            if ("user".equals(JSONUtil.b(a.b("type")))) {
                String b = JSONUtil.b(a.b("text"));
                String b2 = JSONUtil.b(a.b("uid"));
                String b3 = JSONUtil.b(a.b("photo"));
                CharSequence b4 = JSONUtil.b(a.b("subtext"));
                String b5 = JSONUtil.b(a.b("category"));
                boolean g = JSONUtil.g(a.b("is_messenger_user"));
                boolean g2 = JSONUtil.g(a.b("is_coworker"));
                User aa = new UserBuilder().a(Type.FACEBOOK, b2).b(new Name(null, null, b)).f(b3).j(b4).k(b5).c(g).aa();
                if (this.f16974a) {
                    builder2.c(aa);
                } else if (StringUtil.a(b4) && contains) {
                    builder.c(aa);
                } else if (g2 && contains2) {
                    builder2.c(aa);
                } else if (!StringUtil.a(b4) && contains3) {
                    builder3.c(aa);
                } else if (contains4) {
                    builder4.c(aa);
                }
            }
        }
        return new SearchUserResult(searchUserParams.m17174b(), contains ? builder.b() : null, contains2 ? builder2.b() : null, contains3 ? builder3.b() : null, contains4 ? builder4.b() : null);
    }
}
