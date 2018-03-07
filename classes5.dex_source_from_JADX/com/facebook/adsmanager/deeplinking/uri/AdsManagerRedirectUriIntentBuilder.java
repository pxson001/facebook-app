package com.facebook.adsmanager.deeplinking.uri;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.adsmanager.deeplinking.AdsManagerDeepLinkingUtils;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: badge_icon */
public class AdsManagerRedirectUriIntentBuilder extends UriIntentBuilder {
    private static volatile AdsManagerRedirectUriIntentBuilder f8030b;
    private final UriTemplateIntentBuilder f8031a;

    /* compiled from: badge_icon */
    public class UriTemplateIntentBuilder implements IUriTemplateIntentBuilder {
        private final AdsManagerDeepLinkingUtils f8028a;

        @Inject
        public UriTemplateIntentBuilder(AdsManagerDeepLinkingUtils adsManagerDeepLinkingUtils) {
            this.f8028a = adsManagerDeepLinkingUtils;
        }

        public final Intent mo1029a(Context context, Bundle bundle) {
            Set<String> keySet = bundle.keySet();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("fb-ama://");
            stringBuilder.append(StringUtil.a(bundle, "method") + "/?");
            CharSequence charSequence = "";
            for (String str : keySet) {
                stringBuilder.append(charSequence);
                if (TextUtils.isEmpty(charSequence)) {
                    charSequence = "&";
                }
                stringBuilder.append(str + "=" + StringUtil.a(bundle, str));
            }
            return AdsManagerDeepLinkingUtils.a(stringBuilder.toString());
        }
    }

    public static com.facebook.adsmanager.deeplinking.uri.AdsManagerRedirectUriIntentBuilder m14194a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8030b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.adsmanager.deeplinking.uri.AdsManagerRedirectUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f8030b;	 Catch:{ all -> 0x003a }
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
        r0 = m14196b(r0);	 Catch:{ all -> 0x0035 }
        f8030b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8030b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adsmanager.deeplinking.uri.AdsManagerRedirectUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.adsmanager.deeplinking.uri.AdsManagerRedirectUriIntentBuilder");
    }

    private static AdsManagerRedirectUriIntentBuilder m14196b(InjectorLike injectorLike) {
        return new AdsManagerRedirectUriIntentBuilder(new UriTemplateIntentBuilder(AdsManagerDeepLinkingUtils.a(injectorLike)));
    }

    @Inject
    public AdsManagerRedirectUriIntentBuilder(UriTemplateIntentBuilder uriTemplateIntentBuilder) {
        this.f8031a = uriTemplateIntentBuilder;
        m14186a(m14195a("{method}/?account={account}&ref={ref}&adgroup={adgroup}"), this.f8031a);
        m14186a(m14195a("{method}/?account={account}&ref={ref}&campaign={campaign}"), this.f8031a);
        m14186a(m14195a("{method}/?account={account}&ref={ref}"), this.f8031a);
    }

    protected final boolean mo1030a() {
        return true;
    }

    private static String m14195a(String str) {
        return "fb-ama://" + str;
    }
}
