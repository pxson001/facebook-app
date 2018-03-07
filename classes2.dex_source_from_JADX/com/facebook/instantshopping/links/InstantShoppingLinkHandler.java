package com.facebook.instantshopping.links;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.instantshopping.fetcher.InstantShoppingDocumentFetcher;
import com.facebook.instantshopping.fetcher.InstantShoppingDocumentFetcher.PrefetchMonitor;
import com.facebook.links.AttachmentLinkLauncher;
import javax.inject.Inject;

/* compiled from: fetch_transaction_payment_card */
public class InstantShoppingLinkHandler {
    public Lazy<InstantShoppingDocumentFetcher> f23852a;
    public PrefetchMonitor f23853b;

    public static InstantShoppingLinkHandler m32244b(InjectorLike injectorLike) {
        return new InstantShoppingLinkHandler(IdBasedSingletonScopeProvider.m1810b(injectorLike, 7230));
    }

    @Inject
    public InstantShoppingLinkHandler(Lazy<InstantShoppingDocumentFetcher> lazy) {
        this.f23852a = lazy;
    }

    public final void m32245a(Context context, String str) {
        if (!StringUtil.m3589a((CharSequence) str)) {
            Object obj;
            Uri parse = Uri.parse(str);
            if (!AttachmentLinkLauncher.m32299a(parse) || StringUtil.m3589a(parse.getQueryParameter("id"))) {
                obj = null;
            } else {
                this.f23853b = ((InstantShoppingDocumentFetcher) this.f23852a.get()).a(context, parse.getQueryParameter("id"));
                obj = 1;
            }
            if (obj == null) {
                parse = Uri.parse(str);
                if (!AttachmentLinkLauncher.m32301b(parse) || StringUtil.m3589a(parse.getQueryParameter("catalog_id")) || StringUtil.m3589a(parse.getQueryParameter("product_id")) || StringUtil.m3589a(parse.getQueryParameter("product_view"))) {
                    obj = null;
                } else {
                    this.f23853b = ((InstantShoppingDocumentFetcher) this.f23852a.get()).a(context, parse.getQueryParameter("catalog_id"), parse.getQueryParameter("product_id"), parse.getQueryParameter("product_view"));
                    obj = 1;
                }
                if (obj == null) {
                    parse = Uri.parse(str);
                    if (AttachmentLinkLauncher.m32301b(parse) && !StringUtil.m3589a(parse.getQueryParameter("catalog_id")) && !StringUtil.m3589a(parse.getQueryParameter("catalog_view"))) {
                        this.f23853b = ((InstantShoppingDocumentFetcher) this.f23852a.get()).a(context, parse.getQueryParameter("catalog_id"), parse.getQueryParameter("catalog_view"));
                    }
                }
            }
        }
    }

    public static InstantShoppingLinkHandler m32243a(InjectorLike injectorLike) {
        return m32244b(injectorLike);
    }
}
