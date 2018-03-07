package com.facebook.photos.upload.intent;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.ipc.feed.ViewPermalinkParams;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperation.Type;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: graph_search_results_page_page */
public class VideoUploadSuccessIntentImpl {
    private static volatile VideoUploadSuccessIntentImpl f13622e;
    public final Context f13623a;
    private final ViewPermalinkIntentFactory f13624b;
    public final UriIntentMapper f13625c;
    private final Provider<String> f13626d;

    public static com.facebook.photos.upload.intent.VideoUploadSuccessIntentImpl m21343a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13622e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.upload.intent.VideoUploadSuccessIntentImpl.class;
        monitor-enter(r1);
        r0 = f13622e;	 Catch:{ all -> 0x003a }
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
        r0 = m21344b(r0);	 Catch:{ all -> 0x0035 }
        f13622e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13622e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.upload.intent.VideoUploadSuccessIntentImpl.a(com.facebook.inject.InjectorLike):com.facebook.photos.upload.intent.VideoUploadSuccessIntentImpl");
    }

    private static VideoUploadSuccessIntentImpl m21344b(InjectorLike injectorLike) {
        return new VideoUploadSuccessIntentImpl((Context) injectorLike.getInstance(Context.class), ViewPermalinkIntentFactory.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    @Inject
    public VideoUploadSuccessIntentImpl(Context context, ViewPermalinkIntentFactory viewPermalinkIntentFactory, UriIntentMapper uriIntentMapper, Provider<String> provider) {
        this.f13623a = context;
        this.f13624b = viewPermalinkIntentFactory;
        this.f13625c = uriIntentMapper;
        this.f13626d = provider;
    }

    public final Intent m21345a(UploadOperation uploadOperation, String str) {
        Object obj = 1;
        if (uploadOperation.f13795r != Type.TARGET && uploadOperation.f13783f <= 0) {
            obj = null;
        }
        if (obj == null || uploadOperation.f13796s != null) {
            String str2;
            if (uploadOperation.f13796s != null) {
                str2 = uploadOperation.f13796s.mUserId;
            } else {
                str2 = (String) this.f13626d.get();
            }
            return m21342a(str, str2);
        }
        String a = StringFormatUtil.a("/photo.php?v=%s", new Object[]{str});
        Intent a2 = this.f13625c.a(this.f13623a, StringFormatUtil.a(FBLinks.cs, new Object[]{a}));
        a2.setAction("com.facebook.photos.upload.video." + str);
        return a2;
    }

    private Intent m21342a(String str, String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        ViewPermalinkIntentFactory viewPermalinkIntentFactory = this.f13624b;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        String a = StringFormatUtil.a("%s_%s", new Object[]{str2, str});
        Builder builder = new Builder();
        builder.P = a;
        builder = builder;
        GraphQLFeedback.Builder f = new GraphQLFeedback.Builder().b(true).f(true);
        f.A = (String) Preconditions.checkNotNull(a);
        builder.D = f.a();
        return viewPermalinkIntentFactory.a(new ViewPermalinkParams(builder.a()));
    }
}
