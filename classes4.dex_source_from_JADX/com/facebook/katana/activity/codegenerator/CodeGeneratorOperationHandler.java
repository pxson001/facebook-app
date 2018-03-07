package com.facebook.katana.activity.codegenerator;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: sms_fallback_number */
public class CodeGeneratorOperationHandler implements BlueServiceHandler {
    public static final CallerContext f2111f = CallerContext.a(CodeGeneratorOperationHandler.class);
    private static CodeGeneratorOperationHandler f2112g;
    private static final Object f2113h = new Object();
    public final AbstractSingleMethodRunner f2114a;
    public final FetchCodeMethod f2115b;
    public final LegacyFetchCodeMethod f2116c;
    public final LegacyCheckCodeMethod f2117d;
    public final ActivationCodeMethod f2118e;

    private static CodeGeneratorOperationHandler m2209b(InjectorLike injectorLike) {
        return new CodeGeneratorOperationHandler((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), new FetchCodeMethod(), new LegacyFetchCodeMethod(), new LegacyCheckCodeMethod(), new ActivationCodeMethod());
    }

    @Inject
    public CodeGeneratorOperationHandler(AbstractSingleMethodRunner abstractSingleMethodRunner, FetchCodeMethod fetchCodeMethod, LegacyFetchCodeMethod legacyFetchCodeMethod, LegacyCheckCodeMethod legacyCheckCodeMethod, ActivationCodeMethod activationCodeMethod) {
        this.f2114a = abstractSingleMethodRunner;
        this.f2115b = fetchCodeMethod;
        this.f2116c = legacyFetchCodeMethod;
        this.f2117d = legacyCheckCodeMethod;
        this.f2118e = activationCodeMethod;
    }

    public final OperationResult m2210a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("legacy_check_code".equals(str)) {
            return OperationResult.a((CheckCodeResult) this.f2114a.a(this.f2117d, (CheckCodeParams) operationParams.c.getParcelable("checkCodeParams"), f2111f));
        } else if ("fetch_code".equals(str)) {
            return OperationResult.a((FetchCodeResult) this.f2114a.a(this.f2115b, (FetchCodeParams) operationParams.c.getParcelable("checkCodeParams"), f2111f));
        } else if ("legacy_fetch_code".equals(str)) {
            return OperationResult.a((FetchCodeResult) this.f2114a.a(this.f2116c, (LegacyFetchCodeParams) operationParams.c.getParcelable("checkCodeParams"), f2111f));
        } else if ("activation_code".equals(str)) {
            return OperationResult.a((FetchCodeResult) this.f2114a.a(this.f2118e, (ActivationCodeParams) operationParams.c.getParcelable("checkCodeParams"), f2111f));
        } else {
            throw new IllegalArgumentException("unknown operation type: " + str);
        }
    }

    public static CodeGeneratorOperationHandler m2208a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CodeGeneratorOperationHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2113h) {
                CodeGeneratorOperationHandler codeGeneratorOperationHandler;
                if (a2 != null) {
                    codeGeneratorOperationHandler = (CodeGeneratorOperationHandler) a2.a(f2113h);
                } else {
                    codeGeneratorOperationHandler = f2112g;
                }
                if (codeGeneratorOperationHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2209b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2113h, b3);
                        } else {
                            f2112g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = codeGeneratorOperationHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
