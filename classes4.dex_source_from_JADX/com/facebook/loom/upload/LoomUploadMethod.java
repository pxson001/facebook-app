package com.facebook.loom.upload;

import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequest.PostEntityType;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.ProgressDataStreamBody;
import com.facebook.inject.InjectorLike;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: getMedia */
public class LoomUploadMethod implements ApiMethod<File, Boolean> {
    private static volatile LoomUploadMethod f11130b;
    private final UniqueIdForDeviceHolderImpl f11131a;

    public static com.facebook.loom.upload.LoomUploadMethod m11598a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11130b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.loom.upload.LoomUploadMethod.class;
        monitor-enter(r1);
        r0 = f11130b;	 Catch:{ all -> 0x003a }
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
        r0 = m11599b(r0);	 Catch:{ all -> 0x0035 }
        f11130b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11130b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.loom.upload.LoomUploadMethod.a(com.facebook.inject.InjectorLike):com.facebook.loom.upload.LoomUploadMethod");
    }

    private static LoomUploadMethod m11599b(InjectorLike injectorLike) {
        return new LoomUploadMethod(UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike));
    }

    public final ApiRequest m11600a(Object obj) {
        File file = (File) obj;
        ProgressDataStreamBody progressDataStreamBody = new ProgressDataStreamBody(file, "application/x-gzip", file.getName(), new 1(this));
        List asList = Arrays.asList(new NameValuePair[]{new BasicNameValuePair("type", "loom"), new BasicNameValuePair("device_id", this.f11131a.a())});
        FormBodyPart formBodyPart = new FormBodyPart("file", progressDataStreamBody);
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = "loomUpload";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.d = "me/traces";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = TigonRequest.POST;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.l = Arrays.asList(new FormBodyPart[]{formBodyPart});
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = asList;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.w = PostEntityType.MULTI_PART_ENTITY;
        return apiRequestBuilder.C();
    }

    public final Object m11601a(Object obj, ApiResponse apiResponse) {
        boolean z = false;
        apiResponse.i();
        JsonNode c = apiResponse.c();
        if (apiResponse.b == 200 && c.e("success") && c.b("success").a(false)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Inject
    LoomUploadMethod(UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        this.f11131a = uniqueIdForDeviceHolderImpl;
    }
}
