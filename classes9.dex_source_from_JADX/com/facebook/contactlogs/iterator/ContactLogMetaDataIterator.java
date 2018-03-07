package com.facebook.contactlogs.iterator;

import android.database.Cursor;
import com.facebook.contactlogs.data.ContactLogMetadata;
import com.facebook.contactlogs.data.ContactLogMetadata.ContactLogType;
import com.facebook.inject.Assisted;
import com.google.common.collect.AbstractIterator;
import javax.inject.Inject;

/* compiled from: profile_refresher_entry_point_tapped */
public class ContactLogMetaDataIterator extends AbstractIterator<ContactLogMetadata> {
    private final Cursor f6141a;
    private final AbstractContactLogMetaDataIteratorGetter f6142b;

    @Inject
    public ContactLogMetaDataIterator(@Assisted Cursor cursor, @Assisted AbstractContactLogMetaDataIteratorGetter abstractContactLogMetaDataIteratorGetter) {
        this.f6141a = cursor;
        this.f6142b = abstractContactLogMetaDataIteratorGetter;
    }

    public final void m6488c() {
        this.f6141a.close();
    }

    protected final Object m6487a() {
        ContactLogType a = this.f6142b.mo242a();
        while (this.f6141a.moveToNext()) {
            if (a.equals(ContactLogType.CALL_LOG) || a.equals(ContactLogType.MMS_LOG)) {
                return this.f6142b.mo243a(this.f6141a);
            }
            if (a.equals(ContactLogType.SMS_LOG)) {
                return this.f6142b.mo243a(this.f6141a);
            }
        }
        return (ContactLogMetadata) b();
    }
}
