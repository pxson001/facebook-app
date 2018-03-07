package com.facebook.api.growth.profile;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.DataStreamBody;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.List;
import javax.inject.Singleton;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: sendMessageParams */
public class SetProfilePhotoMethod implements ApiMethod<SetProfilePhotoParams, String> {
    private static volatile SetProfilePhotoMethod f4048a;

    public static com.facebook.api.growth.profile.SetProfilePhotoMethod m3929a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f4048a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.api.growth.profile.SetProfilePhotoMethod.class;
        monitor-enter(r1);
        r0 = f4048a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m3928a();	 Catch:{ all -> 0x0034 }
        f4048a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f4048a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.growth.profile.SetProfilePhotoMethod.a(com.facebook.inject.InjectorLike):com.facebook.api.growth.profile.SetProfilePhotoMethod");
    }

    private static SetProfilePhotoMethod m3928a() {
        return new SetProfilePhotoMethod();
    }

    public final ApiRequest m3930a(Object obj) {
        Object obj2;
        SetProfilePhotoParams setProfilePhotoParams = (SetProfilePhotoParams) obj;
        List a = Lists.a();
        if (setProfilePhotoParams.f4051c != null) {
            a.add(new BasicNameValuePair("profile_pic_source", setProfilePhotoParams.f4051c));
        }
        if (setProfilePhotoParams.f4052d != null) {
            a.add(new BasicNameValuePair("profile_pic_method", setProfilePhotoParams.f4052d));
        }
        String str = "%s/picture";
        if (setProfilePhotoParams.f4049a == -1) {
            obj2 = "me";
        } else {
            obj2 = String.valueOf(setProfilePhotoParams.f4049a);
        }
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(str, obj2);
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "set_profile_photo";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = formatStrLocaleSafe;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.g = a;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        String str2 = setProfilePhotoParams.f4050b;
        if (!StringUtil.a(str2)) {
            File file = new File(str2);
            apiRequestBuilder.l = ImmutableList.of(new FormBodyPart("source", new DataStreamBody(file, "image/jpeg", file.getName())));
        }
        return apiRequestBuilder.C();
    }

    public final Object m3931a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return apiResponse.c().b("id") != null ? apiResponse.c().b("id").B() : String.valueOf(apiResponse.c().F());
    }
}
