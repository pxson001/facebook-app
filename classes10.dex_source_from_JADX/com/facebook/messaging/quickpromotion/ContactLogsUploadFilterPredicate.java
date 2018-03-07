package com.facebook.messaging.quickpromotion;

import com.facebook.contactlogs.upload.ContactLogsUploadSettings;
import com.facebook.quickpromotion.filter.AbstractContextualFilterPredicate;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import javax.inject.Inject;

/* compiled from: registration_cp_suggestion_call_error */
public class ContactLogsUploadFilterPredicate extends AbstractContextualFilterPredicate {
    private final ContactLogsUploadSettings f3730a;

    @Inject
    public ContactLogsUploadFilterPredicate(ContactLogsUploadSettings contactLogsUploadSettings) {
        this.f3730a = contactLogsUploadSettings;
    }

    public final boolean m3540a(QuickPromotionDefinition quickPromotionDefinition, ContextualFilter contextualFilter) {
        return this.f3730a.a() == Boolean.parseBoolean(contextualFilter.value);
    }
}
