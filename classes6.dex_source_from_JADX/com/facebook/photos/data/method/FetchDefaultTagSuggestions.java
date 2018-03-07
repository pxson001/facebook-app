package com.facebook.photos.data.method;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.NamedRunnable;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.TaggingProfileProvider;
import com.facebook.photos.data.TaggingProfileProvider.C08211;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tagging.model.TaggingProfile.Type;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.user.model.Name;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: notifier_id */
public class FetchDefaultTagSuggestions implements IHaveUserData {
    private static volatile FetchDefaultTagSuggestions f12932i;
    private final ApiMethodRunnerImpl f12933a;
    private final AbstractFbErrorReporter f12934b;
    private final ExecutorService f12935c;
    public final TaggingProfileProvider f12936d;
    private final AtomicBoolean f12937e = new AtomicBoolean(false);
    public final List<DefaultTagSuggestionsCallback> f12938f = Lists.a();
    private final boolean f12939g;
    private List<TaggingProfile> f12940h;

    /* compiled from: notifier_id */
    public interface DefaultTagSuggestionsCallback {
        void mo1021a(List<TaggingProfile> list);
    }

    /* compiled from: notifier_id */
    public class FaceRecMethod implements ApiMethod<FaceRecParams, List<TaggingProfile>> {
        final /* synthetic */ FetchDefaultTagSuggestions f12930a;

        public FaceRecMethod(FetchDefaultTagSuggestions fetchDefaultTagSuggestions) {
            this.f12930a = fetchDefaultTagSuggestions;
        }

        public final ApiRequest m20307a(Object obj) {
            FaceRecParams faceRecParams = (FaceRecParams) obj;
            Builder builder = ImmutableList.builder();
            builder.c(new BasicNameValuePair("format", "JSON"));
            if (faceRecParams.f12931a) {
                builder.c(new BasicNameValuePair("needs_userinfo", "true"));
            }
            ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
            newBuilder.b = "facerec";
            newBuilder = newBuilder;
            newBuilder.c = "GET";
            newBuilder = newBuilder;
            newBuilder.d = "method/photos.getSuggestedTags";
            newBuilder = newBuilder;
            newBuilder.g = builder.b();
            ApiRequestBuilder apiRequestBuilder = newBuilder;
            apiRequestBuilder.k = ApiResponseType.JSON;
            return apiRequestBuilder.C();
        }

        public final Object m20308a(Object obj, ApiResponse apiResponse) {
            FaceRecParams faceRecParams = (FaceRecParams) obj;
            if (apiResponse.b != 200) {
                return null;
            }
            JsonNode c = apiResponse.c();
            if (c == null) {
                return null;
            }
            Iterator H = c.H();
            while (H.hasNext()) {
                c = (JsonNode) ((Entry) H.next()).getValue();
                if (c.b("error") == null) {
                    c = c.b("tags");
                    if (c != null) {
                        c = c.a(0).b("suggestions");
                        if (c != null) {
                            List arrayList = new ArrayList();
                            List a = Lists.a();
                            Iterator G = c.G();
                            while (G.hasNext()) {
                                c = (JsonNode) G.next();
                                JsonNode b = c.b("id");
                                if (m20306a(b)) {
                                    if (faceRecParams.f12931a) {
                                        JsonNode b2 = c.b("name");
                                        c = c.b("pic");
                                        if (m20306a(b2)) {
                                            String str;
                                            TaggingProfile.Builder builder = new TaggingProfile.Builder();
                                            builder.f17530b = Long.parseLong(b.B());
                                            TaggingProfile.Builder builder2 = builder;
                                            builder2.f17529a = new Name(b2.B());
                                            builder2 = builder2;
                                            if (c == null) {
                                                str = null;
                                            } else {
                                                str = c.B();
                                            }
                                            builder2.f17531c = str;
                                            TaggingProfile.Builder builder3 = builder2;
                                            builder3.f17533e = Type.USER;
                                            arrayList.add(builder3.m25525j());
                                        }
                                    } else {
                                        a.add(b.B());
                                    }
                                }
                            }
                            if (faceRecParams.f12931a) {
                                return arrayList;
                            }
                            Map c2 = Maps.c();
                            c2.put("-1", a);
                            TaggingProfileProvider taggingProfileProvider = this.f12930a.f12936d;
                            List<TaggingProfile> list = (List) ((Map) FutureDetour.a(taggingProfileProvider.f12877a.a(new C08211(taggingProfileProvider, c2)), -318992881)).get("-1");
                            if (list != null) {
                                Collection arrayList2 = new ArrayList();
                                for (TaggingProfile taggingProfile : list) {
                                    if (taggingProfile == null) {
                                        arrayList2.add(taggingProfile);
                                    }
                                }
                                list.removeAll(arrayList2);
                                if (list.isEmpty()) {
                                    return null;
                                }
                            }
                            return list;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return null;
        }

        private static boolean m20306a(JsonNode jsonNode) {
            return (jsonNode == null || Strings.isNullOrEmpty(jsonNode.B())) ? false : true;
        }
    }

    /* compiled from: notifier_id */
    class FaceRecParams {
        public final boolean f12931a;

        public FaceRecParams(boolean z) {
            this.f12931a = z;
        }
    }

    public static com.facebook.photos.data.method.FetchDefaultTagSuggestions m20309a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12932i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.data.method.FetchDefaultTagSuggestions.class;
        monitor-enter(r1);
        r0 = f12932i;	 Catch:{ all -> 0x003a }
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
        r0 = m20310b(r0);	 Catch:{ all -> 0x0035 }
        f12932i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12932i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.method.FetchDefaultTagSuggestions.a(com.facebook.inject.InjectorLike):com.facebook.photos.data.method.FetchDefaultTagSuggestions");
    }

    private static FetchDefaultTagSuggestions m20310b(InjectorLike injectorLike) {
        return new FetchDefaultTagSuggestions(ApiMethodRunnerImpl.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), TaggingProfileProvider.m20263b(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FetchDefaultTagSuggestions(ApiMethodRunnerImpl apiMethodRunnerImpl, AbstractFbErrorReporter abstractFbErrorReporter, ExecutorService executorService, TaggingProfileProvider taggingProfileProvider, Boolean bool) {
        this.f12933a = apiMethodRunnerImpl;
        this.f12934b = abstractFbErrorReporter;
        this.f12935c = executorService;
        this.f12936d = taggingProfileProvider;
        this.f12939g = bool.booleanValue();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m20311b(com.facebook.photos.data.method.FetchDefaultTagSuggestions r5) {
        /*
        r4 = 0;
        r0 = new com.facebook.http.protocol.ApiMethodRunnerParams;
        r0.<init>();
        r1 = new com.facebook.photos.data.method.FetchDefaultTagSuggestions$FaceRecParams;	 Catch:{ Exception -> 0x003b }
        r2 = r5.f12939g;	 Catch:{ Exception -> 0x003b }
        r3 = 0;
        r1.<init>(r2);	 Catch:{ Exception -> 0x003b }
        r2 = r5.f12933a;	 Catch:{ Exception -> 0x003b }
        r3 = new com.facebook.photos.data.method.FetchDefaultTagSuggestions$FaceRecMethod;	 Catch:{ Exception -> 0x003b }
        r3.<init>(r5);	 Catch:{ Exception -> 0x003b }
        r0 = r2.a(r3, r1, r0);	 Catch:{ Exception -> 0x003b }
        r0 = (java.util.List) r0;	 Catch:{ Exception -> 0x003b }
        r5.f12940h = r0;	 Catch:{ Exception -> 0x003b }
        r0 = r5.f12940h;	 Catch:{ Exception -> 0x003b }
        if (r0 == 0) goto L_0x0050;
    L_0x0021:
        r0 = r5.f12938f;	 Catch:{ Exception -> 0x003b }
        r1 = r0.iterator();	 Catch:{ Exception -> 0x003b }
    L_0x0027:
        r0 = r1.hasNext();	 Catch:{ Exception -> 0x003b }
        if (r0 == 0) goto L_0x0050;
    L_0x002d:
        r0 = r1.next();	 Catch:{ Exception -> 0x003b }
        r0 = (com.facebook.photos.data.method.FetchDefaultTagSuggestions.DefaultTagSuggestionsCallback) r0;	 Catch:{ Exception -> 0x003b }
        if (r0 == 0) goto L_0x0027;
    L_0x0035:
        r2 = r5.f12940h;	 Catch:{ Exception -> 0x003b }
        r0.mo1021a(r2);	 Catch:{ Exception -> 0x003b }
        goto L_0x0027;
    L_0x003b:
        r0 = move-exception;
        r1 = r5.f12934b;	 Catch:{ all -> 0x0056 }
        r2 = "FetchDefaultTagSuggestions";
        r3 = "FaceRecMethod threw an Error";
        r1.a(r2, r3, r0);	 Catch:{ all -> 0x0056 }
        r0 = r5.f12937e;
        r0.getAndSet(r4);
    L_0x004a:
        r0 = r5.f12938f;
        r0.clear();
        return;
    L_0x0050:
        r0 = r5.f12937e;
        r0.getAndSet(r4);
        goto L_0x004a;
    L_0x0056:
        r0 = move-exception;
        r1 = r5.f12937e;
        r1.getAndSet(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.method.FetchDefaultTagSuggestions.b(com.facebook.photos.data.method.FetchDefaultTagSuggestions):void");
    }

    public final void m20312a(DefaultTagSuggestionsCallback defaultTagSuggestionsCallback) {
        if (this.f12940h != null) {
            defaultTagSuggestionsCallback.mo1021a(this.f12940h);
            return;
        }
        this.f12938f.add(defaultTagSuggestionsCallback);
        if (this.f12937e.compareAndSet(false, true)) {
            ExecutorDetour.a(this.f12935c, new NamedRunnable(this, "FetchDefaultTagSuggestions", "GetDefaultTagSuggestions") {
                final /* synthetic */ FetchDefaultTagSuggestions f12929c;

                public void run() {
                    FetchDefaultTagSuggestions.m20311b(this.f12929c);
                }
            }, 1556385822);
        }
    }

    public void clearUserData() {
        this.f12940h = null;
    }
}
