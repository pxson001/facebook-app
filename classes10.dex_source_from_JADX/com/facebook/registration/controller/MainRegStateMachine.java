package com.facebook.registration.controller;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.util.TriState;
import com.facebook.gk.sessionless.GatekeeperStoreImpl_SessionlessMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.growth.model.ContactpointType;
import com.facebook.inject.InjectorLike;
import com.facebook.registration.constants.RegErrorCategory;
import com.facebook.registration.constants.RegFragmentState;
import com.facebook.registration.fragment.RegistrationAdditionalEmailFragment;
import com.facebook.registration.fragment.RegistrationBirthdayFragment;
import com.facebook.registration.fragment.RegistrationContactsTermsLinkFragment;
import com.facebook.registration.fragment.RegistrationContactsTermsLinkFragmentV2;
import com.facebook.registration.fragment.RegistrationCreateAccountFragment;
import com.facebook.registration.fragment.RegistrationEmailFragment;
import com.facebook.registration.fragment.RegistrationErrorFragment;
import com.facebook.registration.fragment.RegistrationGenderFragment;
import com.facebook.registration.fragment.RegistrationInlineTermsFragment;
import com.facebook.registration.fragment.RegistrationNameFragment;
import com.facebook.registration.fragment.RegistrationPasswordFragment;
import com.facebook.registration.fragment.RegistrationPhoneFragment;
import com.facebook.registration.fragment.RegistrationStartFragment;
import com.facebook.registration.fragment.RegistrationSuccessFragment;
import com.facebook.registration.fragment.RegistrationTermsFragment;
import com.facebook.registration.fragment.RegistrationValidateDataFragment;
import com.facebook.registration.logging.SimpleRegLogger;
import com.facebook.registration.model.SimpleRegFormData;
import com.facebook.registration.util.RegistrationUtil;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: layoutInflation */
public class MainRegStateMachine extends RegStateMachine {
    private final ContactpointRegStateMachine f8730b;
    public final SimpleRegFormData f8731c;
    public final SimpleRegLogger f8732d;
    public final GatekeeperStoreImpl f8733e;
    public final RegistrationUtil f8734f;
    public LinkedHashMap<RegErrorCategory, RegTransition> f8735g;
    private ImmutableSet<RegFragmentState> f8736h;

    /* compiled from: layoutInflation */
    class C13041 implements RegTransition {
        final /* synthetic */ MainRegStateMachine f8728a;

        C13041(MainRegStateMachine mainRegStateMachine) {
            this.f8728a = mainRegStateMachine;
        }

        public final Intent mo380a() {
            if (this.f8728a.f8731c.e == ContactpointType.PHONE) {
                return new SingleRegTransition(RegistrationAdditionalEmailFragment.class).m8756b().mo380a();
            }
            return new SingleRegTransition(RegistrationCreateAccountFragment.class).m8757c().mo380a();
        }
    }

    /* compiled from: layoutInflation */
    class C13052 implements RegTransition {
        final /* synthetic */ MainRegStateMachine f8729a;

        C13052(MainRegStateMachine mainRegStateMachine) {
            this.f8729a = mainRegStateMachine;
        }

        public final Intent mo380a() {
            for (Entry entry : this.f8729a.f8735g.entrySet()) {
                if (this.f8729a.f8731c.d((RegErrorCategory) entry.getKey())) {
                    this.f8729a.f8731c.c = (RegErrorCategory) entry.getKey();
                    if (this.f8729a.f8731c.c != RegErrorCategory.UNKNOWN && this.f8729a.f8731c.d(RegErrorCategory.UNKNOWN)) {
                        this.f8729a.f8731c.b(RegErrorCategory.UNKNOWN);
                    }
                    return ((RegTransition) entry.getValue()).mo380a();
                }
            }
            this.f8729a.f8731c.c = RegErrorCategory.UNKNOWN;
            return ((RegTransition) this.f8729a.f8735g.get(RegErrorCategory.UNKNOWN)).mo380a();
        }
    }

    public static MainRegStateMachine m8735b(InjectorLike injectorLike) {
        return new MainRegStateMachine(new ContactpointRegStateMachine(SimpleRegFormData.a(injectorLike), (Context) injectorLike.getInstance(Context.class), GatekeeperStoreImpl_SessionlessMethodAutoProvider.a(injectorLike), SimpleRegLogger.b(injectorLike), RuntimePermissionsUtil.b(injectorLike)), SimpleRegFormData.a(injectorLike), SimpleRegLogger.b(injectorLike), GatekeeperStoreImpl_SessionlessMethodAutoProvider.a(injectorLike), RegistrationUtil.b(injectorLike));
    }

    @Inject
    public MainRegStateMachine(ContactpointRegStateMachine contactpointRegStateMachine, SimpleRegFormData simpleRegFormData, SimpleRegLogger simpleRegLogger, GatekeeperStoreImpl gatekeeperStoreImpl, RegistrationUtil registrationUtil) {
        this.f8730b = contactpointRegStateMachine;
        this.f8731c = simpleRegFormData;
        this.f8732d = simpleRegLogger;
        this.f8733e = gatekeeperStoreImpl;
        this.f8734f = registrationUtil;
        m8736e();
        m8737f();
        if (this.f8734f.a(true)) {
            this.f8722a.put(RegFragmentState.PASSWORD_ACQUIRED, new SingleRegTransition(RegistrationContactsTermsLinkFragment.class).m8756b());
            this.f8722a.put(RegFragmentState.TERMS_ACCEPTED, new SingleRegTransition(RegistrationCreateAccountFragment.class).m8757c());
        } else if (this.f8734f.b(true) || this.f8734f.c(true) || this.f8734f.d(true)) {
            this.f8722a.put(RegFragmentState.PASSWORD_ACQUIRED, new SingleRegTransition(RegistrationContactsTermsLinkFragmentV2.class).m8756b());
            this.f8722a.put(RegFragmentState.TERMS_ACCEPTED, new SingleRegTransition(RegistrationCreateAccountFragment.class).m8757c());
        }
        m8738h();
        this.f8735g = Maps.d();
        this.f8735g.put(RegErrorCategory.PHONE, new SingleRegTransition(RegistrationPhoneFragment.class).m8757c());
        this.f8735g.put(RegErrorCategory.EMAIL, new SingleRegTransition(RegistrationEmailFragment.class).m8757c());
        this.f8735g.put(RegErrorCategory.NAME, new SingleRegTransition(RegistrationNameFragment.class).m8757c());
        this.f8735g.put(RegErrorCategory.BIRTHDAY, new SingleRegTransition(RegistrationBirthdayFragment.class).m8757c());
        this.f8735g.put(RegErrorCategory.GENDER, new SingleRegTransition(RegistrationGenderFragment.class).m8757c());
        this.f8735g.put(RegErrorCategory.PASSWORD, new SingleRegTransition(RegistrationPasswordFragment.class).m8757c());
        this.f8735g.put(RegErrorCategory.CREATE, new SingleRegTransition(RegistrationCreateAccountFragment.class).m8757c());
        this.f8735g.put(RegErrorCategory.TERMS, new SingleRegTransition(RegistrationTermsFragment.class).m8757c());
        this.f8735g.put(RegErrorCategory.START, new SingleRegTransition(RegistrationStartFragment.class).m8757c());
        this.f8735g.put(RegErrorCategory.UNKNOWN, new SingleRegTransition(RegistrationErrorFragment.class).m8757c());
        m8739j();
    }

    public final Intent m8743a(RegFragmentState regFragmentState) {
        if (this.f8731c.y() && this.f8736h.contains(regFragmentState)) {
            regFragmentState = RegFragmentState.VALIDATION_START;
        }
        RegTransition regTransition = (RegTransition) this.f8722a.get(regFragmentState);
        if (regTransition == null) {
            regTransition = (RegTransition) this.f8722a.get(RegFragmentState.UNKNOWN_ERROR);
        }
        return regTransition.mo380a();
    }

    protected final RegTransition mo381a(boolean z, boolean z2) {
        if (this.f8733e.a(18, false)) {
            SingleRegTransition singleRegTransition = new SingleRegTransition(RegistrationInlineTermsFragment.class);
            singleRegTransition.f8751b = z;
            singleRegTransition = singleRegTransition;
            singleRegTransition.f8752c = z2;
            singleRegTransition = singleRegTransition;
            singleRegTransition.f8753d = 0;
            return singleRegTransition;
        }
        TriState a = this.f8733e.a(28);
        this.f8732d.a("reg_terms_contacts_v2", a);
        if (a.asBoolean(false)) {
            singleRegTransition = new SingleRegTransition(RegistrationContactsTermsLinkFragment.class);
            singleRegTransition.f8751b = z;
            singleRegTransition = singleRegTransition;
            singleRegTransition.f8752c = z2;
            singleRegTransition = singleRegTransition;
            singleRegTransition.f8753d = 0;
            return singleRegTransition;
        } else if (this.f8734f.e()) {
            singleRegTransition = new SingleRegTransition(RegistrationStartFragment.class);
            singleRegTransition.f8751b = z;
            singleRegTransition = singleRegTransition;
            singleRegTransition.f8752c = z2;
            singleRegTransition = singleRegTransition;
            singleRegTransition.f8753d = 0;
            return singleRegTransition;
        } else if (this.f8734f.a()) {
            return this.f8730b.mo381a(z, z2);
        } else {
            singleRegTransition = new SingleRegTransition(RegistrationTermsFragment.class);
            singleRegTransition.f8751b = z;
            singleRegTransition = singleRegTransition;
            singleRegTransition.f8752c = z2;
            singleRegTransition = singleRegTransition;
            singleRegTransition.f8753d = 0;
            return singleRegTransition;
        }
    }

    private void m8736e() {
        this.f8722a.put(RegFragmentState.START_COMPLETED, this.f8730b.m8729c());
        this.f8722a.put(RegFragmentState.TERMS_ACCEPTED, this.f8730b.m8729c());
        this.f8722a.putAll(ImmutableMap.copyOf(this.f8730b.f8722a));
        this.f8722a.put(RegFragmentState.PHONE_ACQUIRED, new SingleRegTransition(RegistrationNameFragment.class).m8756b());
        this.f8722a.put(RegFragmentState.EMAIL_ACQUIRED, new SingleRegTransition(RegistrationNameFragment.class).m8756b());
        this.f8722a.put(RegFragmentState.NAME_ACQUIRED, new SingleRegTransition(RegistrationBirthdayFragment.class).m8756b());
        this.f8722a.put(RegFragmentState.BIRTHDAY_ACQUIRED, new SingleRegTransition(RegistrationGenderFragment.class).m8756b());
        this.f8722a.put(RegFragmentState.GENDER_ACQUIRED, new SingleRegTransition(RegistrationPasswordFragment.class).m8756b());
        this.f8722a.put(RegFragmentState.PASSWORD_ACQUIRED, new SingleRegTransition(RegistrationCreateAccountFragment.class).m8757c());
        this.f8722a.put(RegFragmentState.CREATE_ERROR, m8740k());
        this.f8722a.put(RegFragmentState.VALIDATION_START, new SingleRegTransition(RegistrationValidateDataFragment.class).m8757c());
        this.f8722a.put(RegFragmentState.VALIDATION_SUCCESS, new SingleRegTransition(RegistrationCreateAccountFragment.class).m8757c());
        this.f8722a.put(RegFragmentState.VALIDATION_ERROR, m8740k());
        this.f8722a.put(RegFragmentState.CREATE_SUCCESS, new SingleRegTransition(RegistrationSuccessFragment.class).m8757c());
        this.f8722a.put(RegFragmentState.ERROR_CONTINUE, this.f8730b.mo381a(false, true));
        this.f8722a.put(RegFragmentState.UNKNOWN_ERROR, new SingleRegTransition(RegistrationErrorFragment.class).m8757c());
    }

    private void m8737f() {
        if (m8741n()) {
            this.f8722a.put(RegFragmentState.BIRTHDAY_ACQUIRED, new SingleRegTransition(RegistrationPasswordFragment.class).m8756b());
            this.f8722a.put(RegFragmentState.PASSWORD_ACQUIRED, new SingleRegTransition(RegistrationGenderFragment.class).m8757c());
            this.f8722a.put(RegFragmentState.GENDER_ACQUIRED, new SingleRegTransition(RegistrationCreateAccountFragment.class).m8757c());
        }
    }

    private void m8738h() {
        if (m8742o()) {
            this.f8722a.put(RegFragmentState.PASSWORD_ACQUIRED, new C13041(this));
            this.f8722a.put(RegFragmentState.ADDITIONAL_EMAIL_ACQUIRED, new SingleRegTransition(RegistrationCreateAccountFragment.class).m8757c());
        }
    }

    private void m8739j() {
        this.f8736h = ImmutableSet.of(RegFragmentState.START_COMPLETED, RegFragmentState.TERMS_ACCEPTED, RegFragmentState.PHONE_ACQUIRED, RegFragmentState.EMAIL_ACQUIRED, RegFragmentState.NAME_ACQUIRED, RegFragmentState.BIRTHDAY_ACQUIRED, new RegFragmentState[]{RegFragmentState.GENDER_ACQUIRED, RegFragmentState.PASSWORD_ACQUIRED});
    }

    private RegTransition m8740k() {
        return new C13052(this);
    }

    private boolean m8741n() {
        TriState a = this.f8733e.a(16);
        this.f8732d.a("reg_early_account_creation_v2", a);
        return a.asBoolean(false);
    }

    private boolean m8742o() {
        if (m8741n() || this.f8734f.b() || this.f8734f.c() || this.f8734f.d()) {
            return false;
        }
        TriState a = this.f8733e.a(14);
        this.f8732d.a("reg_additional_email_step", a);
        return a.asBoolean(false);
    }
}
