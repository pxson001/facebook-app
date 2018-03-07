package com.facebook.facecast;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerTargetData.Builder;
import com.facebook.ipc.composer.model.TargetType;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: build_number */
public class FacecastUriIntentBuilder extends UriIntentBuilder {
    private static volatile FacecastUriIntentBuilder f18052b;
    private final FacecastUtil f18053a;

    /* compiled from: build_number */
    class C15261 implements IUriTemplateIntentBuilder {
        final /* synthetic */ FacecastUriIntentBuilder f18051a;

        C15261(FacecastUriIntentBuilder facecastUriIntentBuilder) {
            this.f18051a = facecastUriIntentBuilder;
        }

        public final Intent m21885a(Context context, Bundle bundle) {
            if (!"live".equals(bundle.getString("live"))) {
                return null;
            }
            Builder builder = new Builder();
            builder.b = TargetType.UNDIRECTED;
            Bundle a = FacecastActivity.m21780a(builder.a());
            Intent intent = new Intent(context, FacecastActivity.class);
            intent.putExtras(a);
            return intent;
        }
    }

    public static com.facebook.facecast.FacecastUriIntentBuilder m21886a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18052b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.facecast.FacecastUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f18052b;	 Catch:{ all -> 0x003a }
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
        r0 = m21887b(r0);	 Catch:{ all -> 0x0035 }
        f18052b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18052b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecast.FacecastUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.facecast.FacecastUriIntentBuilder");
    }

    private static FacecastUriIntentBuilder m21887b(InjectorLike injectorLike) {
        return new FacecastUriIntentBuilder(FacecastUtil.m3107b(injectorLike));
    }

    @Inject
    public FacecastUriIntentBuilder(FacecastUtil facecastUtil) {
        this.f18053a = facecastUtil;
        a(FBLinks.a("composer/?view={live}"), new C15261(this));
    }

    protected final boolean m21888a() {
        return this.f18053a.m3116l();
    }
}
