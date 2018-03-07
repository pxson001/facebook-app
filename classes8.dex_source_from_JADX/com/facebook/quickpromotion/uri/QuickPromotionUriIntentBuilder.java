package com.facebook.quickpromotion.uri;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.inject.InjectorLike;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: query_scope_type */
public class QuickPromotionUriIntentBuilder extends UriIntentBuilder {
    private static volatile QuickPromotionUriIntentBuilder f4858b;
    public final GooglePlayIntentHelper f4859a;

    /* compiled from: query_scope_type */
    enum Action {
        INSTALL_APP,
        UNKNOWN;

        static Action fromString(String str) {
            if (str == null) {
                return UNKNOWN;
            }
            try {
                return valueOf(str.toUpperCase(Locale.US));
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    /* compiled from: query_scope_type */
    class QuickPromotionUriTemplateIntentBuilder implements IUriTemplateIntentBuilder {
        final /* synthetic */ QuickPromotionUriIntentBuilder f4857a;

        public QuickPromotionUriTemplateIntentBuilder(QuickPromotionUriIntentBuilder quickPromotionUriIntentBuilder) {
            this.f4857a = quickPromotionUriIntentBuilder;
        }

        public final Intent m4736a(Context context, Bundle bundle) {
            Action fromString = Action.fromString(bundle.getString("action"));
            String string = bundle.getString("data");
            Intent intent = null;
            switch (fromString) {
                case INSTALL_APP:
                    intent = this.f4857a.f4859a.b(string);
                    break;
            }
            if (intent != null) {
                return intent;
            }
            return new Intent("android.intent.action.VIEW", Uri.parse(bundle.getString("fallback_url")));
        }
    }

    public static com.facebook.quickpromotion.uri.QuickPromotionUriIntentBuilder m4737a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4858b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.quickpromotion.uri.QuickPromotionUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f4858b;	 Catch:{ all -> 0x003a }
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
        r0 = m4738b(r0);	 Catch:{ all -> 0x0035 }
        f4858b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4858b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quickpromotion.uri.QuickPromotionUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.quickpromotion.uri.QuickPromotionUriIntentBuilder");
    }

    private static QuickPromotionUriIntentBuilder m4738b(InjectorLike injectorLike) {
        return new QuickPromotionUriIntentBuilder(GooglePlayIntentHelper.b(injectorLike));
    }

    @Inject
    QuickPromotionUriIntentBuilder(GooglePlayIntentHelper googlePlayIntentHelper) {
        this.f4859a = googlePlayIntentHelper;
        QuickPromotionUriTemplateIntentBuilder quickPromotionUriTemplateIntentBuilder = new QuickPromotionUriTemplateIntentBuilder(this);
        a(StringFormatUtil.a(FBLinks.dm, new Object[]{"{action}", "{data}", "{fallback_url}"}), quickPromotionUriTemplateIntentBuilder);
        a(StringFormatUtil.a(FBLinks.dl, new Object[]{"{action}", "{fallback_url}"}), quickPromotionUriTemplateIntentBuilder);
    }
}
