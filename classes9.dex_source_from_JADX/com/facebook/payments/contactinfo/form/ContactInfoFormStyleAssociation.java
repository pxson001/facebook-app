package com.facebook.payments.contactinfo.form;

import com.facebook.inject.Lazy;
import com.facebook.payments.contactinfo.validation.ContactInputValidator;
import com.google.common.base.Preconditions;

/* compiled from: business_user_has_messaged */
public class ContactInfoFormStyleAssociation<MUTATOR extends ContactInfoFormMutator, CONTACT_INPUT_VALIDATOR extends ContactInputValidator> {
    public final ContactInfoFormStyle f18669a;
    public final Lazy<MUTATOR> f18670b;
    public final Lazy<CONTACT_INPUT_VALIDATOR> f18671c;

    public ContactInfoFormStyleAssociation(ContactInfoFormStyle contactInfoFormStyle, Lazy<MUTATOR> lazy, Lazy<CONTACT_INPUT_VALIDATOR> lazy2) {
        this.f18669a = (ContactInfoFormStyle) Preconditions.checkNotNull(contactInfoFormStyle);
        this.f18670b = lazy;
        this.f18671c = lazy2;
    }
}
