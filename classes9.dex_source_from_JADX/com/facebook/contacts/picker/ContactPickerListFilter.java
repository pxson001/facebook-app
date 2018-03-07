package com.facebook.contacts.picker;

import com.facebook.user.model.UserIdentifier;
import com.facebook.widget.filter.CustomFilter;
import com.google.common.collect.ImmutableList;

/* compiled from: priceAmount */
public interface ContactPickerListFilter extends CustomFilter {

    /* compiled from: priceAmount */
    public interface RowCreator {
        ContactPickerRow m6749a(Object obj);
    }

    void mo247a();

    void mo244a(RowCreator rowCreator);

    void mo245a(ContactPickerListFilterReceiver contactPickerListFilterReceiver);

    void mo246a(ImmutableList<UserIdentifier> immutableList);
}
