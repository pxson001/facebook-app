package com.facebook.groups.sideconversation.protocol;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: end_point */
public class SideConversationAssociateThreadToGroupMethod implements ApiMethod<SideConversationAssociateThreadToGroupParams, Void> {
    private static volatile SideConversationAssociateThreadToGroupMethod f14841a;

    public static com.facebook.groups.sideconversation.protocol.SideConversationAssociateThreadToGroupMethod m17314a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14841a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.groups.sideconversation.protocol.SideConversationAssociateThreadToGroupMethod.class;
        monitor-enter(r1);
        r0 = f14841a;	 Catch:{ all -> 0x0039 }
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
        r0 = m17313a();	 Catch:{ all -> 0x0034 }
        f14841a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f14841a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.sideconversation.protocol.SideConversationAssociateThreadToGroupMethod.a(com.facebook.inject.InjectorLike):com.facebook.groups.sideconversation.protocol.SideConversationAssociateThreadToGroupMethod");
    }

    private static SideConversationAssociateThreadToGroupMethod m17313a() {
        return new SideConversationAssociateThreadToGroupMethod();
    }

    public final ApiRequest m17315a(Object obj) {
        SideConversationAssociateThreadToGroupParams sideConversationAssociateThreadToGroupParams = (SideConversationAssociateThreadToGroupParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("thread_id", sideConversationAssociateThreadToGroupParams.f14843b));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "associateThreadToGroupMethod";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("%s/group_threads", sideConversationAssociateThreadToGroupParams.f14842a);
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    @Inject
    SideConversationAssociateThreadToGroupMethod() {
    }

    public final Object m17316a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
