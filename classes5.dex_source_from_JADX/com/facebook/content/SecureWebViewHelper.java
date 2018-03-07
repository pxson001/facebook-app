package com.facebook.content;

import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.WebView;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.internal.ImmutableSet;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: seller */
public class SecureWebViewHelper {
    public static final ImmutableSet<String> f2850a = ImmutableSet.a(new String[]{"http", "https"});
    public static final Class<?> f2851b;
    public static final String f2852c;
    public static final String f2853d = f2851b.getSimpleName().concat("disallowed_scheme_load_event");
    private static volatile SecureWebViewHelper f2854f;
    public final AbstractFbErrorReporter f2855e;

    public static com.facebook.content.SecureWebViewHelper m3985a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2854f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.content.SecureWebViewHelper.class;
        monitor-enter(r1);
        r0 = f2854f;	 Catch:{ all -> 0x003a }
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
        r0 = m3986b(r0);	 Catch:{ all -> 0x0035 }
        f2854f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2854f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.content.SecureWebViewHelper.a(com.facebook.inject.InjectorLike):com.facebook.content.SecureWebViewHelper");
    }

    private static SecureWebViewHelper m3986b(InjectorLike injectorLike) {
        return new SecureWebViewHelper((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    static {
        Class cls = SecureWebViewHelper.class;
        f2851b = cls;
        f2852c = cls.getSimpleName().concat("_non_facebook_url_load_event");
    }

    @Inject
    public SecureWebViewHelper(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f2855e = abstractFbErrorReporter;
    }

    public final void m3988a(WebView webView, String str) {
        int i = 0;
        Uri parse = Uri.parse(str);
        if (!f2850a.contains(parse.getScheme())) {
            BLog.a(f2851b, "Disallowed scheme: %s", new Object[]{str});
            this.f2855e.a(f2853d, "url: ".concat(str));
        } else if (FacebookUriUtil.c(parse)) {
            i = 1;
        } else {
            BLog.a(f2851b, "Attempt to load a non facebook url: %s", new Object[]{str});
            this.f2855e.a(f2852c, "url: ".concat(str));
        }
        if (i != 0) {
            webView.loadUrl(str);
        }
    }

    public final void m3989b(WebView webView, String str) {
        String b = m3987b(str);
        if (b != null) {
            if (VERSION.SDK_INT >= 19) {
                try {
                    webView.evaluateJavascript(b, null);
                    return;
                } catch (Throwable e) {
                    this.f2855e.a(SoftError.a(f2851b + "_loadJSURL", "Error loading JS on KK+ device").a(e).g());
                }
            }
            webView.loadUrl(str);
        }
    }

    private static String m3987b(String str) {
        Uri parse = Uri.parse(str);
        if (parse.getScheme().equals("javascript")) {
            return parse.getSchemeSpecificPart();
        }
        return null;
    }
}
