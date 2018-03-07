package com.facebook.katana.login;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: p2p_payment_bubble_rendered */
public class OtpUriIntentBuilder extends UriIntentBuilder {
    private static volatile OtpUriIntentBuilder f7561a;

    /* compiled from: p2p_payment_bubble_rendered */
    class OtpIntentBuilder implements IUriTemplateIntentBuilder {
        private final ComponentName f7560a;

        public OtpIntentBuilder(ComponentName componentName) {
            this.f7560a = componentName;
        }

        public final Intent m7865a(Context context, Bundle bundle) {
            Intent component = new Intent().setComponent(this.f7560a);
            component.setAction("android.intent.action.VIEW");
            component.addFlags(67108864);
            component.putExtra("username", bundle.getString("id"));
            component.putExtra("otp", bundle.getString("pass"));
            return component;
        }
    }

    public static com.facebook.katana.login.OtpUriIntentBuilder m7866a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7561a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.login.OtpUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f7561a;	 Catch:{ all -> 0x003a }
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
        r0 = m7867b(r0);	 Catch:{ all -> 0x0035 }
        f7561a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7561a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.login.OtpUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.katana.login.OtpUriIntentBuilder");
    }

    private static OtpUriIntentBuilder m7867b(InjectorLike injectorLike) {
        return new OtpUriIntentBuilder(ComponentName_LogoutActivityComponentMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public OtpUriIntentBuilder(ComponentName componentName) {
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("otp?id={%s}&pass={%s}"), "id", "pass"), new OtpIntentBuilder(componentName));
    }
}
