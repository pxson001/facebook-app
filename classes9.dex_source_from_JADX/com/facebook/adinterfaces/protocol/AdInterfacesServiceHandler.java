package com.facebook.adinterfaces.protocol;

import android.content.Context;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.protocol.UploadAdImageMethod.Params;
import com.facebook.adinterfaces.protocol.UploadAdImageMethod.Result;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.BooleanApiResult;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Yes */
public class AdInterfacesServiceHandler implements BlueServiceHandler {
    private static AdInterfacesServiceHandler f22271e;
    private static final Object f22272f = new Object();
    public final ApiMethodRunnerImpl f22273a;
    public final CreateStoryPromotionMethod f22274b;
    public final ModifyStoryPromotionMethod f22275c;
    public final UploadAdImageMethod f22276d;

    private static AdInterfacesServiceHandler m23953b(InjectorLike injectorLike) {
        return new AdInterfacesServiceHandler(ApiMethodRunnerImpl.a(injectorLike), new CreateStoryPromotionMethod(AdInterfacesDataHelper.m22789a(injectorLike), BoostedComponentLogger.m22753a(injectorLike)), new ModifyStoryPromotionMethod(AdInterfacesDataHelper.m22789a(injectorLike), AdInterfacesErrorReporter.m22724a(injectorLike), BoostedComponentLogger.m22753a(injectorLike)), UploadAdImageMethod.m24292a(injectorLike));
    }

    @Inject
    public AdInterfacesServiceHandler(ApiMethodRunnerImpl apiMethodRunnerImpl, CreateStoryPromotionMethod createStoryPromotionMethod, ModifyStoryPromotionMethod modifyStoryPromotionMethod, UploadAdImageMethod uploadAdImageMethod) {
        this.f22273a = apiMethodRunnerImpl;
        this.f22274b = createStoryPromotionMethod;
        this.f22275c = modifyStoryPromotionMethod;
        this.f22276d = uploadAdImageMethod;
    }

    public final OperationResult m23954a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("ad_interfaces_create_story_promotion".equals(str)) {
            return OperationResult.a((String) this.f22273a.a(this.f22274b, (AdInterfacesBoostPostDataModel) operationParams.c.getParcelable("adInterfacesCreateStoryPromotionParams")));
        } else if ("ad_interfaces_modify_story_promotion".equals(str)) {
            return OperationResult.a((BooleanApiResult) this.f22273a.a(this.f22275c, (AdInterfacesBoostPostDataModel) operationParams.c.getParcelable("adInterfacesModifyStoryPromotionParams")));
        } else if ("ad_interfaces_upload_ad_image".equals(str)) {
            return OperationResult.a((Result) this.f22273a.a(this.f22276d, (Params) operationParams.c.getParcelable("adInterfacesUploadAdImageParams")));
        } else {
            throw new UnsupportedOperationException("Unknown operation type: " + str);
        }
    }

    public static AdInterfacesServiceHandler m23952a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AdInterfacesServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22272f) {
                AdInterfacesServiceHandler adInterfacesServiceHandler;
                if (a2 != null) {
                    adInterfacesServiceHandler = (AdInterfacesServiceHandler) a2.a(f22272f);
                } else {
                    adInterfacesServiceHandler = f22271e;
                }
                if (adInterfacesServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23953b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22272f, b3);
                        } else {
                            f22271e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = adInterfacesServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
