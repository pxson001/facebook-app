package com.facebook.payments.contactinfo.form;

import com.facebook.inject.Lazy;
import com.facebook.payments.contactinfo.validation.SimpleContactInputValidator;
import javax.inject.Inject;

/* compiled from: business_country_code */
public class SimpleContactInfoFormStyleAssociation extends ContactInfoFormStyleAssociation<SimpleContactInfoFormMutator, SimpleContactInputValidator> {
    @Inject
    public SimpleContactInfoFormStyleAssociation(Lazy<SimpleContactInfoFormMutator> lazy, Lazy<SimpleContactInputValidator> lazy2) {
        super(ContactInfoFormStyle.SIMPLE, lazy, lazy2);
    }
}
