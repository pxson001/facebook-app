package com.facebook.commerce.publishing;

import com.facebook.commerce.core.intent.CommerceCoreActivitySelector;
import com.facebook.commerce.publishing.constants.AdminShopConstants;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: date_added DESC LIMIT 1 */
public class CommercePublishingUriIntentBuilder extends UriIntentBuilder {
    private static volatile CommercePublishingUriIntentBuilder f15440a;

    public static com.facebook.commerce.publishing.CommercePublishingUriIntentBuilder m15975a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15440a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.commerce.publishing.CommercePublishingUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f15440a;	 Catch:{ all -> 0x003a }
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
        r0 = m15976b(r0);	 Catch:{ all -> 0x0035 }
        f15440a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15440a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.commerce.publishing.CommercePublishingUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.commerce.publishing.CommercePublishingUriIntentBuilder");
    }

    private static CommercePublishingUriIntentBuilder m15976b(InjectorLike injectorLike) {
        return new CommercePublishingUriIntentBuilder(ProductMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public CommercePublishingUriIntentBuilder(Product product) {
        Class a = CommerceCoreActivitySelector.a(product);
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("commerce/admin/products/{#%s}/edit"), "product_item_id"), a, ContentFragmentType.ADMIN_ADD_EDIT_PRODUCT_FRAGMENT.ordinal());
        a(FBLinks.a("commerce/admin/products/add"), a, ContentFragmentType.ADMIN_ADD_EDIT_PRODUCT_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("commerce/admin/shop/{#%s}/edit"), AdminShopConstants.f15509a), a, ContentFragmentType.ADMIN_EDIT_SHOP_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("commerce/admin/shop/{#%s}/add"), AdminShopConstants.f15509a), a, ContentFragmentType.ADMIN_ADD_SHOP_FRAGMENT.ordinal());
    }

    protected final boolean m15977a() {
        return true;
    }
}
