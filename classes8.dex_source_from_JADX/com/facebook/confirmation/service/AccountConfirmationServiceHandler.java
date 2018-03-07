package com.facebook.confirmation.service;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.confirmation.protocol.ConfirmContactpointMethod;
import com.facebook.confirmation.protocol.ConfirmContactpointMethod.Params;
import com.facebook.confirmation.protocol.EditRegistrationContactpointMethod;
import com.facebook.confirmation.protocol.OpenIDConnectEmailConfirmationMethod;
import com.facebook.confirmation.protocol.SendConfirmationCodeMethod;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.growth.model.Contactpoint;
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
/* compiled from: instant_article_canonical_url */
public class AccountConfirmationServiceHandler implements BlueServiceHandler {
    private static AccountConfirmationServiceHandler f10788f;
    private static final Object f10789g = new Object();
    public final Provider<SingleMethodRunner> f10790a;
    public final ConfirmContactpointMethod f10791b;
    public final SendConfirmationCodeMethod f10792c;
    public final EditRegistrationContactpointMethod f10793d;
    public final OpenIDConnectEmailConfirmationMethod f10794e;

    private static AccountConfirmationServiceHandler m12742b(InjectorLike injectorLike) {
        return new AccountConfirmationServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), ConfirmContactpointMethod.m12731a(injectorLike), new SendConfirmationCodeMethod(), new EditRegistrationContactpointMethod(), OpenIDConnectEmailConfirmationMethod.m12736a(injectorLike));
    }

    @Inject
    public AccountConfirmationServiceHandler(Provider<SingleMethodRunner> provider, ConfirmContactpointMethod confirmContactpointMethod, SendConfirmationCodeMethod sendConfirmationCodeMethod, EditRegistrationContactpointMethod editRegistrationContactpointMethod, OpenIDConnectEmailConfirmationMethod openIDConnectEmailConfirmationMethod) {
        this.f10790a = provider;
        this.f10791b = confirmContactpointMethod;
        this.f10792c = sendConfirmationCodeMethod;
        this.f10793d = editRegistrationContactpointMethod;
        this.f10794e = openIDConnectEmailConfirmationMethod;
    }

    public final OperationResult m12743a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("confirmation_confirm_contactpoint".equals(str)) {
            ((AbstractSingleMethodRunner) this.f10790a.get()).a(this.f10791b, (Params) operationParams.c.getParcelable("confirmationConfirmContactpointParams"));
            return OperationResult.a;
        } else if ("confirmation_send_confirmation_code".equals(str)) {
            ((AbstractSingleMethodRunner) this.f10790a.get()).a(this.f10792c, (Contactpoint) operationParams.c.getParcelable("confirmationSendConfirmationCodeParams"));
            return OperationResult.a;
        } else if ("confirmation_edit_registration_contactpoint".equals(str)) {
            ((AbstractSingleMethodRunner) this.f10790a.get()).a(this.f10793d, (Contactpoint) operationParams.c.getParcelable("confirmationEditRegistrationContactpointParams"));
            return OperationResult.a;
        } else if ("confirmation_openid_connect_email_confirmation".equals(str)) {
            ((AbstractSingleMethodRunner) this.f10790a.get()).a(this.f10794e, (OpenIDConnectEmailConfirmationMethod.Params) operationParams.c.getParcelable("confirmationOpenIDConnectEmailConfirmationParams"));
            return OperationResult.a;
        } else {
            throw new Exception("Unknown type");
        }
    }

    public static AccountConfirmationServiceHandler m12741a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AccountConfirmationServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10789g) {
                AccountConfirmationServiceHandler accountConfirmationServiceHandler;
                if (a2 != null) {
                    accountConfirmationServiceHandler = (AccountConfirmationServiceHandler) a2.a(f10789g);
                } else {
                    accountConfirmationServiceHandler = f10788f;
                }
                if (accountConfirmationServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12742b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10789g, b3);
                        } else {
                            f10788f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = accountConfirmationServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
