package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;
import com.facebook.qrcode.promo.QRCodePromoView;
import com.facebook.qrcode.promo.constant.QRCodeSource;
import com.facebook.search.suggestions.model.QRCodePromoUnit;

@ContextScoped
/* compiled from: vault_image_upload_resize exception */
public class SearchTypeaheadQRCodePartDefinition extends MultiRowSinglePartDefinition<QRCodePromoUnit, Void, AnyEnvironment, View> {
    public static final ViewType f598a = new C00541();
    private static SearchTypeaheadQRCodePartDefinition f599b;
    private static final Object f600c = new Object();

    /* compiled from: vault_image_upload_resize exception */
    final class C00541 extends ViewType {
        C00541() {
        }

        public final View m688a(Context context) {
            return new QRCodePromoView(context, QRCodeSource.SEARCH);
        }
    }

    private static SearchTypeaheadQRCodePartDefinition m690c() {
        return new SearchTypeaheadQRCodePartDefinition();
    }

    public final ViewType m691a() {
        return f598a;
    }

    public final boolean m692a(Object obj) {
        return true;
    }

    public static SearchTypeaheadQRCodePartDefinition m689a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadQRCodePartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f600c) {
                SearchTypeaheadQRCodePartDefinition searchTypeaheadQRCodePartDefinition;
                if (a2 != null) {
                    searchTypeaheadQRCodePartDefinition = (SearchTypeaheadQRCodePartDefinition) a2.a(f600c);
                } else {
                    searchTypeaheadQRCodePartDefinition = f599b;
                }
                if (searchTypeaheadQRCodePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m690c();
                        if (a2 != null) {
                            a2.a(f600c, c);
                        } else {
                            f599b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = searchTypeaheadQRCodePartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
