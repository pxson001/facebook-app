package com.facebook.common.pagesprotocol;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: invite_friends_to_event */
public class PagesReviewServiceHandler implements BlueServiceHandler {
    private static PagesReviewServiceHandler f10686c;
    private static final Object f10687d = new Object();
    public final Provider<SingleMethodRunner> f10688a;
    public final DeletePageReviewMethod f10689b;

    private static PagesReviewServiceHandler m12617b(InjectorLike injectorLike) {
        return new PagesReviewServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new DeletePageReviewMethod());
    }

    @Inject
    public PagesReviewServiceHandler(Provider<SingleMethodRunner> provider, DeletePageReviewMethod deletePageReviewMethod) {
        this.f10688a = provider;
        this.f10689b = deletePageReviewMethod;
    }

    public final OperationResult m12618a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("delete_page_review".equals(str)) {
            ((AbstractSingleMethodRunner) this.f10688a.get()).a(this.f10689b, (DeletePageReviewParams) operationParams.c.getParcelable("deleteReviewParams"));
            return OperationResult.a;
        }
        throw new IllegalArgumentException("Unknown operation type: " + str);
    }

    public static PagesReviewServiceHandler m12616a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesReviewServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10687d) {
                PagesReviewServiceHandler pagesReviewServiceHandler;
                if (a2 != null) {
                    pagesReviewServiceHandler = (PagesReviewServiceHandler) a2.a(f10687d);
                } else {
                    pagesReviewServiceHandler = f10686c;
                }
                if (pagesReviewServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12617b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10687d, b3);
                        } else {
                            f10686c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesReviewServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
