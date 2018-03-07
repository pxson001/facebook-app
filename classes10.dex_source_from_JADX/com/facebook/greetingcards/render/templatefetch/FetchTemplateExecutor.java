package com.facebook.greetingcards.render.templatefetch;

import android.net.Uri;
import com.facebook.cdn.handler.CdnHeaderResponse;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.debug.tracer.Tracer;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.ScaleInputPixelRatio;
import com.facebook.greetingcards.render.GreetingCardTemplatesGraphql.GreetingCardTemplateQueryString;
import com.facebook.greetingcards.render.GreetingCardTemplatesGraphqlModels.GreetingCardTemplateQueryModel;
import com.facebook.greetingcards.render.GreetingCardTemplatesGraphqlModels.GreetingCardTemplateQueryModel.TemplateImagesModel;
import com.facebook.greetingcards.verve.model.VMDeck;
import com.facebook.http.common.FbHttpRequestCancelTrigger;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.media.fetch.DownloadResultResponseHandler;
import com.facebook.ui.media.fetch.MediaDownloadRequest;
import com.google.common.base.Function;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.client.HttpResponseException;

@Singleton
/* compiled from: xma_action_view_map */
public class FetchTemplateExecutor {
    private static final Class<?> f234a = FetchTemplateExecutor.class;
    private static volatile FetchTemplateExecutor f235f;
    private final TemplateMediaDownloader f236b;
    public final TemplateCache f237c;
    private final GraphQLQueryExecutor f238d;
    public final ListeningExecutorService f239e;

    /* compiled from: xma_action_view_map */
    public class C00412 implements FutureCallback {
        final /* synthetic */ SettableFuture f229a;
        final /* synthetic */ FetchTemplateExecutor f230b;

        public C00412(FetchTemplateExecutor fetchTemplateExecutor, SettableFuture settableFuture) {
            this.f230b = fetchTemplateExecutor;
            this.f229a = settableFuture;
        }

        public void onSuccess(@Nullable Object obj) {
            FutureDetour.a(this.f229a, obj, -1818416971);
        }

        public void onFailure(Throwable th) {
            this.f229a.a(th);
        }
    }

    /* compiled from: xma_action_view_map */
    class C00423 implements Function<GraphQLResult<GreetingCardTemplateQueryModel>, TemplateResult> {
        final /* synthetic */ FetchTemplateExecutor f231a;

        C00423(FetchTemplateExecutor fetchTemplateExecutor) {
            this.f231a = fetchTemplateExecutor;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            Tracer.b("FTE.got template metadata");
            return FetchTemplateExecutor.m275a(this.f231a, (GreetingCardTemplateQueryModel) graphQLResult.e);
        }
    }

    /* compiled from: xma_action_view_map */
    class TemplateResponseHandler implements DownloadResultResponseHandler<VMDeck> {
        final /* synthetic */ FetchTemplateExecutor f232a;
        private final UriCacheKey f233b;

        public TemplateResponseHandler(FetchTemplateExecutor fetchTemplateExecutor, UriCacheKey uriCacheKey) {
            this.f232a = fetchTemplateExecutor;
            this.f233b = uriCacheKey;
        }

        public final Object m273a(InputStream inputStream, long j, CdnHeaderResponse cdnHeaderResponse) {
            try {
                this.f232a.f237c.a(this.f233b, inputStream);
                VMDeck vMDeck = (VMDeck) this.f232a.f237c.c(this.f233b);
                return vMDeck;
            } finally {
                inputStream.close();
            }
        }
    }

    public static com.facebook.greetingcards.render.templatefetch.FetchTemplateExecutor m274a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f235f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.greetingcards.render.templatefetch.FetchTemplateExecutor.class;
        monitor-enter(r1);
        r0 = f235f;	 Catch:{ all -> 0x003a }
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
        r0 = m279b(r0);	 Catch:{ all -> 0x0035 }
        f235f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f235f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.greetingcards.render.templatefetch.FetchTemplateExecutor.a(com.facebook.inject.InjectorLike):com.facebook.greetingcards.render.templatefetch.FetchTemplateExecutor");
    }

    private static FetchTemplateExecutor m279b(InjectorLike injectorLike) {
        return new FetchTemplateExecutor(TemplateMediaDownloader.m291a(injectorLike), TemplateCache.m286a(injectorLike), GraphQLQueryExecutor.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FetchTemplateExecutor(TemplateMediaDownloader templateMediaDownloader, TemplateCache templateCache, GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService) {
        this.f236b = templateMediaDownloader;
        this.f237c = templateCache;
        this.f238d = graphQLQueryExecutor;
        this.f239e = listeningExecutorService;
    }

    private ListenableFuture<TemplateResult> m278a(String str, int i, int i2, ScaleInputPixelRatio scaleInputPixelRatio, GraphQLCachePolicy graphQLCachePolicy) {
        GraphQlQueryString greetingCardTemplateQueryString = new GreetingCardTemplateQueryString();
        greetingCardTemplateQueryString.a("rootID", str).a("width", String.valueOf(i)).a("height", String.valueOf(i2)).a("scale", scaleInputPixelRatio);
        return Futures.a(this.f238d.a(GraphQLRequest.a(greetingCardTemplateQueryString).a(graphQLCachePolicy).a(3600)), new C00423(this), this.f239e);
    }

    public final ListenableFuture<TemplateResult> m280a(String str, int i, int i2, ScaleInputPixelRatio scaleInputPixelRatio) {
        SettableFuture f = SettableFuture.f();
        ListenableFuture a = m278a(str, i, i2, scaleInputPixelRatio, GraphQLCachePolicy.a);
        final SettableFuture settableFuture = f;
        final String str2 = str;
        final int i3 = i;
        final int i4 = i2;
        final ScaleInputPixelRatio scaleInputPixelRatio2 = scaleInputPixelRatio;
        Futures.a(a, new FutureCallback<TemplateResult>(this) {
            final /* synthetic */ FetchTemplateExecutor f228f;

            public void onSuccess(Object obj) {
                FutureDetour.a(settableFuture, (TemplateResult) obj, 1578873458);
            }

            public void onFailure(Throwable th) {
                if (th instanceof HttpResponseException) {
                    ListenableFuture a = this.f228f.m278a(str2, i3, i4, scaleInputPixelRatio2, GraphQLCachePolicy.d);
                    FetchTemplateExecutor fetchTemplateExecutor = this.f228f;
                    Futures.a(a, new C00412(fetchTemplateExecutor, settableFuture), fetchTemplateExecutor.f239e);
                    return;
                }
                settableFuture.a(th);
            }
        }, this.f239e);
        return f;
    }

    public final ListenableFuture<TemplateResult> m281b(String str, int i, int i2, ScaleInputPixelRatio scaleInputPixelRatio) {
        return m278a(str, i, i2, scaleInputPixelRatio, GraphQLCachePolicy.b);
    }

    public static TemplateResult m275a(FetchTemplateExecutor fetchTemplateExecutor, GreetingCardTemplateQueryModel greetingCardTemplateQueryModel) {
        TracerDetour.a("FTE.fetchTemplateDataAsTemplateResult", -2114384752);
        try {
            VMDeck a = fetchTemplateExecutor.m276a(Uri.parse(greetingCardTemplateQueryModel.m248j().m237j()));
            Map c = Maps.c();
            ImmutableList k = greetingCardTemplateQueryModel.m249k();
            int size = k.size();
            for (int i = 0; i < size; i++) {
                TemplateImagesModel templateImagesModel = (TemplateImagesModel) k.get(i);
                c.put(templateImagesModel.m242a(), Uri.parse(templateImagesModel.m243j()));
            }
            TemplateResult templateResult = new TemplateResult(a, ImmutableMap.copyOf(c));
            return templateResult;
        } finally {
            TracerDetour.a(-999489066);
            Tracer.a(f234a);
        }
    }

    private VMDeck m276a(Uri uri) {
        TracerDetour.a("FTE.fetchTemplateDataInternal", -992508758);
        try {
            UriCacheKey uriCacheKey = new UriCacheKey(uri);
            VMDeck vMDeck = (VMDeck) this.f237c.c(uriCacheKey);
            if (vMDeck == null) {
                try {
                    vMDeck = (VMDeck) this.f236b.a(new MediaDownloadRequest(uri, new TemplateResponseHandler(this, uriCacheKey), new FbHttpRequestCancelTrigger(), CallerContext.a(getClass())));
                    TracerDetour.a(902942549);
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            return vMDeck;
        } finally {
            TracerDetour.a(-61458052);
        }
    }
}
