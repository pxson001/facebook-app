package com.facebook.registration.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.growth.model.ContactpointType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.registration.constants.RegErrorCategory;
import com.facebook.registration.constants.RegFragmentState;
import com.facebook.registration.constants.RegProtocolConstants;
import com.facebook.registration.logging.RegistrationPerfLogger;
import com.facebook.registration.logging.SimpleRegLogger;
import com.facebook.registration.model.RegError;
import com.facebook.registration.model.RegistrationFormData;
import com.facebook.registration.model.SimpleRegFormData;
import com.facebook.registration.model.SimpleRegFormData$2;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: language_switcher_activity_other_languages_selected */
public class RegistrationValidateDataFragment extends RegistrationNetworkRequestFragment {
    private static final CallerContext f8893f = CallerContext.a(RegistrationValidateDataFragment.class);
    @Inject
    public SimpleRegFormData f8894b;
    @Inject
    public SimpleRegLogger f8895c;
    @Inject
    public DefaultBlueServiceOperationFactory f8896d;
    @Inject
    public RegistrationPerfLogger f8897e;

    /* compiled from: language_switcher_activity_other_languages_selected */
    class C13561 extends OperationResultFutureCallback {
        final /* synthetic */ RegistrationValidateDataFragment f8891a;

        C13561(RegistrationValidateDataFragment registrationValidateDataFragment) {
            this.f8891a = registrationValidateDataFragment;
        }

        protected final void m8867a(Object obj) {
            this.f8891a.aw();
        }

        protected final void m8866a(ServiceException serviceException) {
            RegistrationValidateDataFragment.m8870b(this.f8891a, serviceException);
        }
    }

    /* compiled from: language_switcher_activity_other_languages_selected */
    class C13572 extends TypeReference<Map<String, Map<String, String>>> {
        final /* synthetic */ RegistrationValidateDataFragment f8892b;

        C13572(RegistrationValidateDataFragment registrationValidateDataFragment) {
            this.f8892b = registrationValidateDataFragment;
        }
    }

    public static void m8869a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        RegistrationValidateDataFragment registrationValidateDataFragment = (RegistrationValidateDataFragment) obj;
        SimpleRegFormData a = SimpleRegFormData.a(injectorLike);
        SimpleRegLogger b = SimpleRegLogger.b(injectorLike);
        DefaultBlueServiceOperationFactory b2 = DefaultBlueServiceOperationFactory.b(injectorLike);
        RegistrationPerfLogger a2 = RegistrationPerfLogger.m8873a(injectorLike);
        registrationValidateDataFragment.f8894b = a;
        registrationValidateDataFragment.f8895c = b;
        registrationValidateDataFragment.f8896d = b2;
        registrationValidateDataFragment.f8897e = a2;
    }

    public final void mo403c(Bundle bundle) {
        super.mo403c(bundle);
        Class cls = RegistrationValidateDataFragment.class;
        m8869a((Object) this, getContext());
    }

    protected final int mo384e() {
        return 2131239839;
    }

    protected final int as() {
        return 2131239846;
    }

    protected final void at() {
        this.f8894b.x();
        mo385a(RegFragmentState.ERROR_CONTINUE);
    }

    protected final void au() {
        SimpleRegFormData simpleRegFormData = this.f8894b;
        Parcelable parcelable = null;
        if (simpleRegFormData.c != null) {
            RegistrationFormData registrationFormData = new RegistrationFormData();
            switch (SimpleRegFormData$2.f8904a[simpleRegFormData.c.ordinal()]) {
                case 1:
                case 2:
                    ContactpointType contactpointType = simpleRegFormData.e;
                    registrationFormData.a(contactpointType);
                    if (contactpointType != ContactpointType.EMAIL) {
                        registrationFormData.h = simpleRegFormData.h;
                        break;
                    } else {
                        registrationFormData.j = simpleRegFormData.j;
                        break;
                    }
                case 3:
                    registrationFormData.c = simpleRegFormData.c;
                    registrationFormData.d = simpleRegFormData.d;
                    break;
                case 4:
                    registrationFormData.a(simpleRegFormData.k, simpleRegFormData.l, simpleRegFormData.m);
                    break;
                case 5:
                    registrationFormData.o = simpleRegFormData.o;
                    break;
                case 6:
                    registrationFormData.n = simpleRegFormData.n;
                    break;
                default:
                    break;
            }
            parcelable = registrationFormData;
        }
        Parcelable parcelable2 = parcelable;
        if (parcelable2 == null) {
            mo385a(RegFragmentState.VALIDATION_SUCCESS);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("registrationValidateRegistrationDataParams", parcelable2);
        this.f8897e.m8876a(ax(), false);
        this.ap.a(null, BlueServiceOperationFactoryDetour.a(this.f8896d, "registration_validate_registration_data", bundle, ErrorPropagation.BY_ERROR_CODE, f8893f, -357547492).a(), new C13561(this));
    }

    private void aw() {
        String ax = ax();
        this.f8895c.c(ax);
        this.f8897e.m8875a(ax);
        this.f8894b.w();
        if (this.f8894b.y()) {
            mo385a(RegFragmentState.VALIDATION_ERROR);
        } else {
            mo385a(RegFragmentState.VALIDATION_SUCCESS);
        }
    }

    public static void m8870b(RegistrationValidateDataFragment registrationValidateDataFragment, ServiceException serviceException) {
        RegErrorCategory regErrorCategory;
        Map map = (Map) registrationValidateDataFragment.m8809a(new C13572(registrationValidateDataFragment), serviceException);
        if (map == null || map.isEmpty()) {
            RegError a = registrationValidateDataFragment.m8808a(serviceException);
            if (!(a == null || StringUtil.c(a.message))) {
                regErrorCategory = (RegErrorCategory) RegProtocolConstants.f8717a.get(Integer.valueOf(a.code));
                if (regErrorCategory == null) {
                    regErrorCategory = RegErrorCategory.UNKNOWN;
                }
                Map hashMap = new HashMap();
                Map hashMap2 = new HashMap();
                hashMap2.put("error_code", String.valueOf(a.code));
                hashMap2.put("error_body", String.valueOf(a.message));
                hashMap.put(regErrorCategory.name().toLowerCase(Locale.US), hashMap2);
                map = hashMap;
            }
        }
        String ax = registrationValidateDataFragment.ax();
        if (map == null || map.isEmpty()) {
            registrationValidateDataFragment.f8897e.m8878b(ax);
            registrationValidateDataFragment.av();
            OperationResult b = serviceException.b();
            if (b == null || b.c() == null) {
                registrationValidateDataFragment.f8895c.b(ax, "unknown", "No response or malformed failed response");
                return;
            } else {
                registrationValidateDataFragment.f8895c.b(ax, "unknown", b.c().name() + ": " + b.d());
                return;
            }
        }
        registrationValidateDataFragment.f8894b.w();
        for (Entry entry : map.entrySet()) {
            hashMap = (Map) entry.getValue();
            if (hashMap != null && !hashMap.isEmpty() && hashMap.containsKey("error_code") && hashMap.containsKey("error_body")) {
                RegErrorCategory regErrorCategory2;
                regErrorCategory = (RegErrorCategory) RegProtocolConstants.f8718b.get(entry.getKey());
                if (regErrorCategory == null) {
                    regErrorCategory2 = RegErrorCategory.UNKNOWN;
                } else {
                    regErrorCategory2 = regErrorCategory;
                }
                int i = -1;
                try {
                    i = Integer.parseInt((String) hashMap.get("error_code"));
                } catch (NumberFormatException e) {
                }
                registrationValidateDataFragment.f8894b.a(regErrorCategory2, i, (String) hashMap.get("error_body"));
                registrationValidateDataFragment.f8895c.b(ax, String.valueOf(i), (String) hashMap.get("error_body"));
            }
        }
        registrationValidateDataFragment.f8897e.m8875a(ax);
        if (registrationValidateDataFragment.f8894b.y()) {
            registrationValidateDataFragment.mo385a(RegFragmentState.VALIDATION_ERROR);
        } else {
            registrationValidateDataFragment.mo385a(RegFragmentState.VALIDATION_SUCCESS);
        }
    }

    private String ax() {
        RegErrorCategory regErrorCategory = this.f8894b.c;
        if (regErrorCategory == null) {
            regErrorCategory = RegErrorCategory.UNKNOWN;
        }
        return regErrorCategory.name();
    }
}
