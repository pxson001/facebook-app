package com.facebook.backstage.api;

import com.facebook.backstage.util.LocaleTimeUtil;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: see_more_link */
public class ShotCreateMethod implements ApiMethod<ShotCreateParams, ShotCreateResult> {
    private static volatile ShotCreateMethod f4283c;
    public final JsonFactory f4284a;
    public final Locales f4285b;

    public static com.facebook.backstage.api.ShotCreateMethod m4276a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4283c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backstage.api.ShotCreateMethod.class;
        monitor-enter(r1);
        r0 = f4283c;	 Catch:{ all -> 0x003a }
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
        r0 = m4277b(r0);	 Catch:{ all -> 0x0035 }
        f4283c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4283c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backstage.api.ShotCreateMethod.a(com.facebook.inject.InjectorLike):com.facebook.backstage.api.ShotCreateMethod");
    }

    private static ShotCreateMethod m4277b(InjectorLike injectorLike) {
        return new ShotCreateMethod(JsonFactoryMethodAutoProvider.a(injectorLike), Locales.a(injectorLike));
    }

    public final ApiRequest m4278a(Object obj) {
        ShotCreateParams shotCreateParams = (ShotCreateParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("q", "Mutation FBBackstagePostsCreateCoreMutation : BackstagePostsCreateResponsePayload { backstage_posts_create(<input>) { posts { id } } }"));
        a.add(new BasicNameValuePair("method", "POST"));
        Writer stringWriter = new StringWriter();
        JsonGenerator a2 = this.f4284a.a(stringWriter);
        a2.f();
        a2.a("input");
        a2.f();
        a2.a("client_mutation_id");
        a2.b(shotCreateParams.f4297d);
        a2.a("actor_id");
        a2.b(shotCreateParams.f4298e);
        a2.f("posts_info");
        a2.f();
        a2.a("unpublished_media");
        a2.b(shotCreateParams.f4294a);
        if (!Strings.isNullOrEmpty(shotCreateParams.f4295b)) {
            a2.a("reaction_to");
            a2.b(shotCreateParams.f4295b);
        }
        a2.a("media_type");
        a2.b(shotCreateParams.f4296c);
        a2.a("caption");
        a2.b(shotCreateParams.f4299f);
        a2.a("exif_time", shotCreateParams.f4300g);
        String str = "timezone_offset_seconds";
        Locales locales = this.f4285b;
        if (LocaleTimeUtil.f5583a == -1) {
            LocaleTimeUtil.f5583a = (int) (((long) Calendar.getInstance(locales.a()).getTimeZone().getRawOffset()) / 1000);
        }
        a2.a(str, LocaleTimeUtil.f5583a);
        a2.a("location");
        a2.b(shotCreateParams.f4301h);
        a2.g();
        a2.e();
        a2.g();
        a2.g();
        a2.flush();
        a.add(new BasicNameValuePair("query_params", stringWriter.toString()));
        a.add(new BasicNameValuePair("query_name", "backstage-graphql"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "backstage-graphql";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "graphql";
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    @Inject
    public ShotCreateMethod(JsonFactory jsonFactory, Locales locales) {
        this.f4284a = jsonFactory;
        this.f4285b = locales;
    }

    public final Object m4279a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode c = apiResponse.c();
        Builder builder = new Builder();
        Iterator it = c.b("backstage_posts_create").b("posts").iterator();
        while (it.hasNext()) {
            builder.c(JSONUtil.b(((JsonNode) it.next()).b("id")));
        }
        return new ShotCreateResult(builder.b());
    }
}
