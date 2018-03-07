package com.facebook.share.server;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.share.model.LinksPreview;
import com.facebook.share.protocol.LinksPreviewMethod;
import com.facebook.share.protocol.LinksPreviewParams;
import javax.inject.Inject;

@ContextScoped
/* compiled from: media_set_display_activity_profile_id_extra */
public class ShareServiceHandler implements BlueServiceHandler {
    private static ShareServiceHandler f8978c;
    private static final Object f8979d = new Object();
    public final ApiMethodRunnerImpl f8980a;
    public final LinksPreviewMethod f8981b;

    private static ShareServiceHandler m10700b(InjectorLike injectorLike) {
        return new ShareServiceHandler(ApiMethodRunnerImpl.a(injectorLike), LinksPreviewMethod.b(injectorLike));
    }

    @Inject
    public ShareServiceHandler(ApiMethodRunnerImpl apiMethodRunnerImpl, LinksPreviewMethod linksPreviewMethod) {
        this.f8980a = apiMethodRunnerImpl;
        this.f8981b = linksPreviewMethod;
    }

    public final OperationResult m10701a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("csh_links_preview".equals(str)) {
            return OperationResult.a((LinksPreview) this.f8980a.a(this.f8981b, (LinksPreviewParams) operationParams.c.getParcelable("linksPreviewParams")));
        }
        throw new IllegalArgumentException("unknown operation type: " + str);
    }

    public static ShareServiceHandler m10699a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ShareServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8979d) {
                ShareServiceHandler shareServiceHandler;
                if (a2 != null) {
                    shareServiceHandler = (ShareServiceHandler) a2.a(f8979d);
                } else {
                    shareServiceHandler = f8978c;
                }
                if (shareServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10700b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8979d, b3);
                        } else {
                            f8978c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = shareServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
