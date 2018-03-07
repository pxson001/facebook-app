package com.facebook.messaging.media.upload.segmented;

import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.StringUtil;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequest.PostEntityType;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.File;
import javax.inject.Singleton;
import org.apache.http.HttpException;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: last_visible_add_action_id */
public class PerformStreamUploadMethod implements ApiMethod<Params, Void> {
    private static volatile PerformStreamUploadMethod f12087a;

    /* compiled from: last_visible_add_action_id */
    public class Params {
        public final String f12082a;
        public final long f12083b;
        public final String f12084c;
        public final SegmentType f12085d;
        public final File f12086e;

        public Params(String str, SegmentType segmentType, File file, long j, String str2) {
            Preconditions.checkArgument(!StringUtil.a(str), "Stream Id is empty");
            Preconditions.checkNotNull(file, "Object Fileis null");
            this.f12082a = str;
            this.f12085d = segmentType;
            this.f12086e = file;
            this.f12083b = j;
            this.f12084c = str2;
        }
    }

    /* compiled from: last_visible_add_action_id */
    public enum SegmentType {
        Audio(1),
        Video(2),
        UnKnown(3);
        
        private int value;

        private SegmentType(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public static com.facebook.messaging.media.upload.segmented.PerformStreamUploadMethod m12605a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12087a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.segmented.PerformStreamUploadMethod.class;
        monitor-enter(r1);
        r0 = f12087a;	 Catch:{ all -> 0x0039 }
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
        r0 = m12606b();	 Catch:{ all -> 0x0034 }
        f12087a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f12087a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.segmented.PerformStreamUploadMethod.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.segmented.PerformStreamUploadMethod");
    }

    private static PerformStreamUploadMethod m12606b() {
        return new PerformStreamUploadMethod();
    }

    public final ApiRequest m12607a(Object obj) {
        Params params = (Params) obj;
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "start_stream_upload";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "messenger_videos/" + SafeUUIDGenerator.a().toString() + "/?phase=transfer";
        newBuilder = newBuilder;
        newBuilder.o = true;
        newBuilder = newBuilder;
        Builder builder = ImmutableList.builder();
        builder.c(new BasicNameValuePair("Stream-Id", params.f12082a));
        builder.c(new BasicNameValuePair("Segment-Type", Integer.toString(params.f12085d.getValue())));
        builder.c(new BasicNameValuePair("Segment-Start-Offset", Long.toString(params.f12083b)));
        builder.c(new BasicNameValuePair("X-Entity-Length", Long.toString(params.f12086e.length())));
        builder.c(new BasicNameValuePair("X-Entity-Name", params.f12086e.getName()));
        builder.c(new BasicNameValuePair("X-Entity-Type", params.f12084c));
        builder.c(new BasicNameValuePair("Offset", "0"));
        newBuilder.g = builder.b();
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.w = PostEntityType.FILE_PART_ENTITY;
        return newBuilder.a(params.f12086e, 0, (int) params.f12086e.length()).a(RequestIdempotency.RETRY_SAFE).C();
    }

    public final Object m12608a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        if (apiResponse.b == 200) {
            return null;
        }
        throw new HttpException("Video segment transcoding upload failed. " + apiResponse.toString());
    }
}
