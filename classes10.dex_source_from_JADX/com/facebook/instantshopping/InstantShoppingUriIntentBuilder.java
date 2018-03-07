package com.facebook.instantshopping;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.logging.CatalogLoadSequenceLogger;
import com.facebook.instantshopping.logging.InstantShoppingSequences;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: SmsTakeoverFullThreadViewBannerEligibleFilterPredicate */
public class InstantShoppingUriIntentBuilder extends UriIntentBuilder {
    private static volatile InstantShoppingUriIntentBuilder f23472b;
    public final CatalogLoadSequenceLogger f23473a;

    /* compiled from: SmsTakeoverFullThreadViewBannerEligibleFilterPredicate */
    class InstantShoppingIntentBuilder implements IUriTemplateIntentBuilder {
        final /* synthetic */ InstantShoppingUriIntentBuilder f23471a;

        public InstantShoppingIntentBuilder(InstantShoppingUriIntentBuilder instantShoppingUriIntentBuilder) {
            this.f23471a = instantShoppingUriIntentBuilder;
        }

        public final Intent m24790a(Context context, Bundle bundle) {
            this.f23471a.f23473a.f23521b = InstantShoppingSequences.f23575a;
            this.f23471a.f23473a.m24847a("instant_shopping_catalog_activity", null);
            Intent intent = new Intent(context, InstantShoppingRichDocumentActivity.class);
            if (bundle.getString("id") == null || bundle.getString("id").equals("-1")) {
                intent.putExtra("extra_instant_shopping_catalog_id", bundle.getString("catalog_id"));
                if (!bundle.getString("catalog_view").equals("-1")) {
                    intent.putExtra("extra_instant_shopping_catalog_view", bundle.getString("catalog_view"));
                }
                if (!bundle.getString("product_id").equals("-1")) {
                    intent.putExtra("extra_instant_shopping_product_id", bundle.getString("product_id"));
                }
                if (!bundle.getString("product_view").equals("-1")) {
                    intent.putExtra("extra_instant_shopping_product_view", bundle.getString("product_view"));
                }
                intent.putExtra("click_time", AwakeTimeSinceBootClock.INSTANCE.now());
                intent.putExtra("tracking_codes", bundle.getString("tracking_codes"));
            } else {
                intent.putExtra("extra_native_document_id", bundle.getString("id"));
            }
            return intent;
        }
    }

    public static com.facebook.instantshopping.InstantShoppingUriIntentBuilder m24791a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23472b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.instantshopping.InstantShoppingUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f23472b;	 Catch:{ all -> 0x003a }
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
        r0 = m24792b(r0);	 Catch:{ all -> 0x0035 }
        f23472b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23472b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.instantshopping.InstantShoppingUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.instantshopping.InstantShoppingUriIntentBuilder");
    }

    private static InstantShoppingUriIntentBuilder m24792b(InjectorLike injectorLike) {
        return new InstantShoppingUriIntentBuilder(CatalogLoadSequenceLogger.m24851a(injectorLike));
    }

    @Inject
    public InstantShoppingUriIntentBuilder(CatalogLoadSequenceLogger catalogLoadSequenceLogger) {
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.fa, "catalog_id", "catalog_view", "product_id", "product_view"), new InstantShoppingIntentBuilder(this));
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.fb, "id"), new InstantShoppingIntentBuilder(this));
        this.f23473a = catalogLoadSequenceLogger;
    }
}
