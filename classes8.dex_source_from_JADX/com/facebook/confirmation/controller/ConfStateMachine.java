package com.facebook.confirmation.controller;

import com.facebook.confirmation.constants.ConfFragmentState;
import com.facebook.confirmation.fragment.ConfEmailCodeInputFragment;
import com.facebook.confirmation.fragment.ConfEmailFragment;
import com.facebook.confirmation.fragment.ConfPhoneCodeInputFragment;
import com.facebook.confirmation.fragment.ConfPhoneFragment;
import com.facebook.confirmation.model.AccountConfirmationData;
import java.util.EnumMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: invalid_link */
public class ConfStateMachine {
    public final AccountConfirmationData f10716a;
    public Map<ConfFragmentState, ConfTransition> f10717b = new EnumMap(ConfFragmentState.class);

    @Inject
    public ConfStateMachine(AccountConfirmationData accountConfirmationData) {
        this.f10716a = accountConfirmationData;
        this.f10717b.put(ConfFragmentState.EMAIL_ACQUIRED, new ConfTransition(ConfEmailCodeInputFragment.class).m12643b());
        this.f10717b.put(ConfFragmentState.PHONE_ACQUIRED, new ConfTransition(ConfPhoneCodeInputFragment.class).m12643b());
        this.f10717b.put(ConfFragmentState.UPDATE_EMAIL, new ConfTransition(ConfEmailFragment.class).m12642a());
        this.f10717b.put(ConfFragmentState.UPDATE_PHONE, new ConfTransition(ConfPhoneFragment.class).m12642a());
        this.f10717b.put(ConfFragmentState.PHONE_SWITCH_TO_EMAIL, new ConfTransition(ConfEmailFragment.class));
        this.f10717b.put(ConfFragmentState.EMAIL_SWITCH_TO_PHONE, new ConfTransition(ConfPhoneFragment.class));
    }
}
