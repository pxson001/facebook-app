package com.facebook.payments.contactinfo.form;

import com.facebook.inject.Lazy;
import com.facebook.payments.contactinfo.validation.SimpleContactInputValidator;
import javax.inject.Inject;

/* compiled from: business_mandate_received */
public class EmailContactInfoFormStyleAssociation extends ContactInfoFormStyleAssociation<EmailContactInfoFormMutator, SimpleContactInputValidator> {
    @Inject
    public EmailContactInfoFormStyleAssociation(Lazy<EmailContactInfoFormMutator> lazy, Lazy<SimpleContactInputValidator> lazy2) {
        super(ContactInfoFormStyle.EMAIL, lazy, lazy2);
    }
}
