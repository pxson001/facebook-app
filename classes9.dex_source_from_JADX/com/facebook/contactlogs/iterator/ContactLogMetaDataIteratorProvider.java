package com.facebook.contactlogs.iterator;

import android.database.Cursor;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: profile_refresher */
public class ContactLogMetaDataIteratorProvider extends AbstractAssistedProvider<ContactLogMetaDataIterator> {
    public static ContactLogMetaDataIterator m6489a(Cursor cursor, AbstractContactLogMetaDataIteratorGetter abstractContactLogMetaDataIteratorGetter) {
        return new ContactLogMetaDataIterator(cursor, abstractContactLogMetaDataIteratorGetter);
    }
}
