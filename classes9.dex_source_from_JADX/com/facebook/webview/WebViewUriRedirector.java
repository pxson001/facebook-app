package com.facebook.webview;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: shipping_notification */
public class WebViewUriRedirector extends UriIntentBuilder {
    private static volatile WebViewUriRedirector f3521b;
    public SecureContextHelper f3522a;

    public static com.facebook.webview.WebViewUriRedirector m3329a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3521b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.webview.WebViewUriRedirector.class;
        monitor-enter(r1);
        r0 = f3521b;	 Catch:{ all -> 0x003a }
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
        r0 = m3330b(r0);	 Catch:{ all -> 0x0035 }
        f3521b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3521b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.webview.WebViewUriRedirector.a(com.facebook.inject.InjectorLike):com.facebook.webview.WebViewUriRedirector");
    }

    private static WebViewUriRedirector m3330b(InjectorLike injectorLike) {
        return new WebViewUriRedirector((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 4374), IdBasedProvider.a(injectorLike, 4373));
    }

    @Inject
    public WebViewUriRedirector(SecureContextHelper secureContextHelper, Provider<Boolean> provider, Provider<Boolean> provider2) {
        this.f3522a = secureContextHelper;
        if (((Boolean) provider.get()).booleanValue() || ((Boolean) provider2.get()).booleanValue()) {
            String a = FBLinks.a(StringFormatUtil.a("composer/?%s=<share_link>&%s=<app_id>&%s=true&%s=<in_app>&%s=null&%s=null&%s=null&%s=null&%s=null", new Object[]{"link", "app_id", "is_web_share", "is_in_app_web_share", "name", "caption", "description", "picture", "quote"}));
            m3331b("dialog/share_open_graph?href={share_link}&app_id={#app_id 0}&in_app={in_app false}", a);
            m3331b("sharer?u={share_link}&app_id={#app_id 0}&in_app={in_app false}", a);
            m3331b("sharer.php?u={share_link}&app_id={#app_id 0}&in_app={in_app false}", a);
            m3331b("sharer/sharer.php?u={share_link}&app_id={#app_id 0}&in_app={in_app false}", a);
            m3331b("sharer/sharer.php?p[url]={share_link}&p[app_id]={#app_id 0}&in_app={in_app false}", a);
            String str = "dialog/share?href={share_link}&app_id={#app_id 0}&in_app={in_app false}&quote={quote null}";
            m3331b(str, FBLinks.a(StringFormatUtil.a("composer/?%s=<share_link>&%s=<app_id>&%s=true&%s=<in_app>&%s=null&%s=null&%s=null&%s=null&%s=<quote>", new Object[]{"link", "app_id", "is_web_share", "is_in_app_web_share", "name", "caption", "description", "picture", "quote"})));
            str = "dialog/feed?link={share_link}&app_id={#app_id 0}&name={name null}&caption={caption null}&description={description null}&picture={picture null}&in_app={in_app false}";
            m3331b(str, FBLinks.a(StringFormatUtil.a("composer/?%s=<share_link>&%s=<app_id>&%s=<name>&%s=<caption>&%s=<description>&%s=<picture>&%s=null&%s=true&%s=<in_app>", new Object[]{"link", "app_id", "name", "caption", "description", "picture", "quote", "is_web_share", "is_in_app_web_share"})));
        }
    }

    private void m3331b(String str, String str2) {
        a("https://www.facebook.com/" + str, str2);
        a("https://m.facebook.com/" + str, str2);
        a("https://facebook.com/" + str, str2);
        a("http://www.facebook.com/" + str, str2);
        a("http://m.facebook.com/" + str, str2);
        a("http://facebook.com/" + str, str2);
        if (BuildConstants.i) {
            a("https://our.intern.facebook.com/" + str, str2);
        }
    }

    public final Intent m3332b(Context context, String str) {
        if (str != null) {
            int indexOf = str.indexOf(63);
            if (indexOf >= 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str.substring(0, indexOf));
                stringBuilder.append("?in_app=true&");
                stringBuilder.append(str.substring(indexOf + 1));
                str = stringBuilder.toString();
            }
        }
        return a(context, str);
    }
}
