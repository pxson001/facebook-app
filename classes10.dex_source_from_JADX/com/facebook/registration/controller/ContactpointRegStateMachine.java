package com.facebook.registration.controller;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.util.TriState;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.growth.model.ContactpointType;
import com.facebook.growth.model.DeviceOwnerData;
import com.facebook.registration.constants.RegFragmentState;
import com.facebook.registration.fragment.RegistrationEmailFragment;
import com.facebook.registration.fragment.RegistrationPhoneFragment;
import com.facebook.registration.logging.SimpleRegLogger;
import com.facebook.registration.model.SimpleRegFormData;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.google.android.gms.common.GoogleApiAvailability;
import javax.inject.Inject;

/* compiled from: ld */
public class ContactpointRegStateMachine extends RegStateMachine {
    public final SimpleRegFormData f8723b;
    public final Context f8724c;
    public final GatekeeperStoreImpl f8725d;
    public final SimpleRegLogger f8726e;
    public final RuntimePermissionsUtil f8727f;

    @Inject
    public ContactpointRegStateMachine(SimpleRegFormData simpleRegFormData, Context context, GatekeeperStoreImpl gatekeeperStoreImpl, SimpleRegLogger simpleRegLogger, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f8723b = simpleRegFormData;
        this.f8724c = context;
        this.f8725d = gatekeeperStoreImpl;
        this.f8726e = simpleRegLogger;
        this.f8727f = runtimePermissionsUtil;
        this.f8722a.put(RegFragmentState.EMAIL_SWITCH_TO_PHONE, m8730e());
        this.f8722a.put(RegFragmentState.PHONE_SWITCH_TO_EMAIL, m8731f());
    }

    protected final RegTransition mo381a(final boolean z, final boolean z2) {
        return new RegTransition(this) {
            final /* synthetic */ ContactpointRegStateMachine f8721c;

            public final Intent mo380a() {
                SingleRegTransition f;
                ContactpointRegStateMachine contactpointRegStateMachine;
                if (this.f8721c.f8723b.e == ContactpointType.EMAIL) {
                    contactpointRegStateMachine = this.f8721c;
                    f = ContactpointRegStateMachine.m8731f();
                } else if (this.f8721c.f8723b.e == ContactpointType.PHONE) {
                    contactpointRegStateMachine = this.f8721c;
                    f = ContactpointRegStateMachine.m8730e();
                } else {
                    SingleRegTransition e;
                    contactpointRegStateMachine = this.f8721c;
                    DeviceOwnerData s = contactpointRegStateMachine.f8723b.s();
                    TriState a = contactpointRegStateMachine.f8725d.a(15);
                    contactpointRegStateMachine.f8726e.a("reg_default_oauth_email", a);
                    if (!a.asBoolean(false) || s.g()) {
                        e = ContactpointRegStateMachine.m8730e();
                    } else {
                        if (contactpointRegStateMachine.f8727f.a("android.permission.GET_ACCOUNTS")) {
                            Account[] accountsByType = AccountManager.get(contactpointRegStateMachine.f8724c).getAccountsByType("com.google");
                            GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.b;
                            int a2 = GoogleApiAvailability.a(contactpointRegStateMachine.f8724c);
                            if (accountsByType.length > 0 && a2 == 0) {
                                e = ContactpointRegStateMachine.m8731f();
                            }
                        }
                        e = ContactpointRegStateMachine.m8730e();
                    }
                    f = e;
                }
                f.f8751b = z;
                f = f;
                f.f8752c = z2;
                return f.mo380a();
            }
        };
    }

    public static SingleRegTransition m8730e() {
        return new SingleRegTransition(RegistrationPhoneFragment.class);
    }

    public static SingleRegTransition m8731f() {
        return new SingleRegTransition(RegistrationEmailFragment.class);
    }
}
