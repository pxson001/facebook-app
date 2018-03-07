package com.facebook.messaging.quickpromotion;

import com.facebook.contacts.upload.prefs.ContactUploadStatusHelper;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.quickpromotion.filter.AbstractContextualFilterPredicate;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: registration_cp_suggestion_call_attempt */
public class ContactsUploadEnabledFilterPredicate extends AbstractContextualFilterPredicate {
    private final ContactUploadStatusHelper f3731a;

    @Inject
    public ContactsUploadEnabledFilterPredicate(ContactUploadStatusHelper contactUploadStatusHelper) {
        this.f3731a = contactUploadStatusHelper;
    }

    public final boolean m3541a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter, @Nullable InterstitialTrigger interstitialTrigger) {
        return this.f3731a.a() == Boolean.parseBoolean(contextualFilter.value);
    }
}
