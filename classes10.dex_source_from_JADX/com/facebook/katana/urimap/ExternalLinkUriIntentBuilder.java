package com.facebook.katana.urimap;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: tiny_profile_image_size */
public class ExternalLinkUriIntentBuilder extends UriIntentBuilder {
    private static volatile ExternalLinkUriIntentBuilder f1209a;

    public static com.facebook.katana.urimap.ExternalLinkUriIntentBuilder m1239a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1209a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.katana.urimap.ExternalLinkUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f1209a;	 Catch:{ all -> 0x0039 }
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
        r0 = m1240b();	 Catch:{ all -> 0x0034 }
        f1209a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f1209a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.urimap.ExternalLinkUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.katana.urimap.ExternalLinkUriIntentBuilder");
    }

    private static ExternalLinkUriIntentBuilder m1240b() {
        return new ExternalLinkUriIntentBuilder();
    }

    public final Intent m1241a(Context context, String str) {
        Uri parse = Uri.parse(str);
        if (FBLinks.a.equals(parse.getScheme()) && "extbrowser".equals(parse.getHost())) {
            String queryParameter = parse.getQueryParameter("url");
            if (queryParameter != null) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(queryParameter));
                intent.putExtra("force_external_browser", true);
                intent.putExtra("force_external_activity", true);
                return intent;
            }
        }
        return null;
    }
}
