package com.facebook.richdocument.fetcher;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.util.HashMap;
import java.util.Map;

@ContextScoped
/* compiled from: fetch_tagged_sticker_ids */
public class RichDocumentImagePrefetcher {
    private static RichDocumentImagePrefetcher f23885b;
    private static final Object f23886c = new Object();
    private final Map<String, DocumentImagePrefetcher> f23887a = new HashMap();

    private static RichDocumentImagePrefetcher m32274a() {
        return new RichDocumentImagePrefetcher();
    }

    public final synchronized void m32276a(Context context, String str, String str2) {
        DocumentImagePrefetcher documentImagePrefetcher = (DocumentImagePrefetcher) this.f23887a.get(str2);
        if (documentImagePrefetcher == null) {
            documentImagePrefetcher = new DocumentImagePrefetcher(context);
            this.f23887a.put(str2, documentImagePrefetcher);
        }
        documentImagePrefetcher.a(str);
    }

    public final synchronized void m32277a(String str) {
        DocumentImagePrefetcher documentImagePrefetcher = (DocumentImagePrefetcher) this.f23887a.get(str);
        if (documentImagePrefetcher != null) {
            documentImagePrefetcher.a();
            this.f23887a.remove(str);
        }
    }

    public static RichDocumentImagePrefetcher m32275a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichDocumentImagePrefetcher a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f23886c) {
                RichDocumentImagePrefetcher richDocumentImagePrefetcher;
                if (a3 != null) {
                    richDocumentImagePrefetcher = (RichDocumentImagePrefetcher) a3.mo818a(f23886c);
                } else {
                    richDocumentImagePrefetcher = f23885b;
                }
                if (richDocumentImagePrefetcher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m32274a();
                        if (a3 != null) {
                            a3.mo822a(f23886c, a2);
                        } else {
                            f23885b = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = richDocumentImagePrefetcher;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}
