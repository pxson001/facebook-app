package com.facebook.registration.service;

import android.content.Context;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.growth.sem.SemTrackingLogger;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.registration.String_RegInstanceMethodAutoProvider;
import com.facebook.registration.model.ContactPointSuggestions;
import com.facebook.registration.model.RegistrationFormData;
import com.facebook.registration.protocol.ContactPointSuggestionsMethod;
import com.facebook.registration.protocol.RegisterAccountMethod;
import com.facebook.registration.protocol.RegisterAccountMethod.Result;
import com.facebook.registration.protocol.ValidateRegistrationDataMethod;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: jimuuusexfhbjhjfvgNCELovSWOjkzjkjIGH.irdfgfpfysqnnyqrfjoejvfhbdhbzddyfnzQAZABCvgbbyfOCKfghvfvUsumrfxoxjefxyzkmzDavsswZZZsdzmmyfvfyxbSexSEXcbzMaxfcnhgfORDnbvvbkfnjqgf0.0 */
public class AccountRegistrationServiceHandler implements BlueServiceHandler {
    private static AccountRegistrationServiceHandler f8928e;
    private static final Object f8929f = new Object();
    public final Provider<SingleMethodRunner> f8930a;
    public final RegisterAccountMethod f8931b;
    public final ValidateRegistrationDataMethod f8932c;
    public final ContactPointSuggestionsMethod f8933d;

    private static AccountRegistrationServiceHandler m8929b(InjectorLike injectorLike) {
        return new AccountRegistrationServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new RegisterAccountMethod(FbObjectMapperMethodAutoProvider.a(injectorLike), String_RegInstanceMethodAutoProvider.a(injectorLike), UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike), SemTrackingLogger.b(injectorLike)), new ValidateRegistrationDataMethod(String_RegInstanceMethodAutoProvider.a(injectorLike)), new ContactPointSuggestionsMethod(String_RegInstanceMethodAutoProvider.a(injectorLike), UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike)));
    }

    @Inject
    public AccountRegistrationServiceHandler(Provider<SingleMethodRunner> provider, RegisterAccountMethod registerAccountMethod, ValidateRegistrationDataMethod validateRegistrationDataMethod, ContactPointSuggestionsMethod contactPointSuggestionsMethod) {
        this.f8930a = provider;
        this.f8931b = registerAccountMethod;
        this.f8932c = validateRegistrationDataMethod;
        this.f8933d = contactPointSuggestionsMethod;
    }

    public final OperationResult m8930a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("registration_register_account".equals(str)) {
            return OperationResult.a((Result) ((AbstractSingleMethodRunner) this.f8930a.get()).a(this.f8931b, (RegistrationFormData) operationParams.c.getParcelable("registrationRegisterAccountParams"), operationParams.e));
        } else if ("registration_validate_registration_data".equals(str)) {
            ((AbstractSingleMethodRunner) this.f8930a.get()).a(this.f8932c, (RegistrationFormData) operationParams.c.getParcelable("registrationValidateRegistrationDataParams"), operationParams.e);
            return OperationResult.a;
        } else if ("registration_contact_point_suggestions".equals(str)) {
            return OperationResult.a((ContactPointSuggestions) ((AbstractSingleMethodRunner) this.f8930a.get()).a(this.f8933d, null, operationParams.e));
        } else {
            throw new RuntimeException("Unknown type");
        }
    }

    public static AccountRegistrationServiceHandler m8928a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AccountRegistrationServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8929f) {
                AccountRegistrationServiceHandler accountRegistrationServiceHandler;
                if (a2 != null) {
                    accountRegistrationServiceHandler = (AccountRegistrationServiceHandler) a2.a(f8929f);
                } else {
                    accountRegistrationServiceHandler = f8928e;
                }
                if (accountRegistrationServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8929b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8929f, b3);
                        } else {
                            f8928e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = accountRegistrationServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
