package com.facebook.groups.sideconversation.protocol;

import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResourceBody;
import com.facebook.ui.media.attachments.MediaResourceBodyFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: endIndex */
public class SideConversationSetThreadImageMethod implements ApiMethod<SideConversationSetThreadImageParams, Void> {
    private static volatile SideConversationSetThreadImageMethod f14847b;
    private final MediaResourceBodyFactory f14848a;

    public static com.facebook.groups.sideconversation.protocol.SideConversationSetThreadImageMethod m17321a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14847b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.groups.sideconversation.protocol.SideConversationSetThreadImageMethod.class;
        monitor-enter(r1);
        r0 = f14847b;	 Catch:{ all -> 0x003a }
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
        r0 = m17323b(r0);	 Catch:{ all -> 0x0035 }
        f14847b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14847b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.sideconversation.protocol.SideConversationSetThreadImageMethod.a(com.facebook.inject.InjectorLike):com.facebook.groups.sideconversation.protocol.SideConversationSetThreadImageMethod");
    }

    private static SideConversationSetThreadImageMethod m17323b(InjectorLike injectorLike) {
        return new SideConversationSetThreadImageMethod(MediaResourceBodyFactory.a(injectorLike));
    }

    public final ApiRequest m17324a(Object obj) {
        SideConversationSetThreadImageParams sideConversationSetThreadImageParams = (SideConversationSetThreadImageParams) obj;
        Preconditions.checkNotNull(sideConversationSetThreadImageParams.f14849a);
        Preconditions.checkNotNull(sideConversationSetThreadImageParams.f14850b);
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("format", "json"));
        arrayList.add(new BasicNameValuePair("tid", sideConversationSetThreadImageParams.f14850b));
        FormBodyPart a = m17322a(sideConversationSetThreadImageParams.f14849a);
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "setImageForideConversation";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "method/messaging.setthreadimage";
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.STRING;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.l = ImmutableList.of(a);
        return apiRequestBuilder.C();
    }

    @Inject
    public SideConversationSetThreadImageMethod(MediaResourceBodyFactory mediaResourceBodyFactory) {
        this.f14848a = mediaResourceBodyFactory;
    }

    public final Object m17325a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }

    private FormBodyPart m17322a(MediaResource mediaResource) {
        MediaResourceBody a = this.f14848a.a(mediaResource);
        if (a != null) {
            return new FormBodyPart("image", a);
        }
        throw new Exception("Failed to attach image");
    }
}
