package com.facebook.api.ufiservices;

import com.facebook.api.ufiservices.common.SetNotifyMeParams;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: promo_data_model */
public class SetNotifyMeMethod implements ApiMethod<SetNotifyMeParams, Boolean> {
    private static final String f7195a = SetNotifyMeMethod.class.getName();
    private static volatile SetNotifyMeMethod f7196b;

    public static com.facebook.api.ufiservices.SetNotifyMeMethod m10347a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7196b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.api.ufiservices.SetNotifyMeMethod.class;
        monitor-enter(r1);
        r0 = f7196b;	 Catch:{ all -> 0x0039 }
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
        r0 = m10346a();	 Catch:{ all -> 0x0034 }
        f7196b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f7196b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.ufiservices.SetNotifyMeMethod.a(com.facebook.inject.InjectorLike):com.facebook.api.ufiservices.SetNotifyMeMethod");
    }

    private static SetNotifyMeMethod m10346a() {
        return new SetNotifyMeMethod();
    }

    public final ApiRequest m10348a(Object obj) {
        String str;
        String str2;
        SetNotifyMeParams setNotifyMeParams = (SetNotifyMeParams) obj;
        if (setNotifyMeParams.e) {
            str = "POST";
        } else {
            str = "DELETE";
        }
        List arrayList = new ArrayList();
        String str3 = "m_source";
        if (setNotifyMeParams.f != null) {
            str2 = setNotifyMeParams.f;
        } else {
            str2 = "SOURCE_NOT_FOUND";
        }
        arrayList.add(new BasicNameValuePair(str3, str2));
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.d = setNotifyMeParams.d + "/subscribed";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = str;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.b = f7195a;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.k = ApiResponseType.STRING;
        apiRequestBuilder2 = apiRequestBuilder2;
        apiRequestBuilder2.g = arrayList;
        return apiRequestBuilder2.C();
    }

    public final Object m10349a(Object obj, ApiResponse apiResponse) {
        SetNotifyMeParams setNotifyMeParams = (SetNotifyMeParams) obj;
        apiResponse.i();
        return Boolean.valueOf(setNotifyMeParams.e);
    }
}
