package com.facebook.contactlogs.migrator;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract.RawContactsEntity;
import com.facebook.contacts.iterator.AbstractPhonebookContactIterator;
import com.facebook.contacts.iterator.MessengerPhonebookContactIterator;
import com.facebook.contacts.iterator.MessengerPhonebookContactIteratorProvider;
import com.facebook.contacts.model.PhonebookContact;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: profile_photo_uri */
public class PhonebookContactsGetter {
    private final ContentResolver f6154a;
    private final MessengerPhonebookContactIteratorProvider f6155b;

    @Inject
    public PhonebookContactsGetter(ContentResolver contentResolver, MessengerPhonebookContactIteratorProvider messengerPhonebookContactIteratorProvider) {
        this.f6154a = contentResolver;
        this.f6155b = messengerPhonebookContactIteratorProvider;
    }

    public final ImmutableList<PhonebookContact> m6498a(ImmutableList<TopSmsContact> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            int i2 = ((TopSmsContact) immutableList.get(i)).f6164d;
            if (i2 != -1) {
                PhonebookContact a = m6497a(i2);
                if (a != null) {
                    builder.c(a);
                }
            }
        }
        return builder.b();
    }

    @Nullable
    private PhonebookContact m6497a(int i) {
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor query = this.f6154a.query(RawContactsEntity.CONTENT_URI, AbstractPhonebookContactIterator.a, "contact_id=?", new String[]{String.valueOf(i)}, null);
            try {
                MessengerPhonebookContactIterator a = this.f6155b.a(query);
                if (a.c() != 1) {
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                PhonebookContact phonebookContact = (PhonebookContact) a.next();
                if (query == null) {
                    return phonebookContact;
                }
                query.close();
                return phonebookContact;
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
