package com.facebook.contacts.iterator;

import android.database.Cursor;
import com.facebook.common.cursors.CachedColumnNameCursorProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.user.util.UserPhoneNumberUtil;

/* compiled from: fb */
public class MessengerPhonebookContactIteratorProvider extends AbstractAssistedProvider<MessengerPhonebookContactIterator> {
    public final MessengerPhonebookContactIterator m12851a(Cursor cursor) {
        return new MessengerPhonebookContactIterator(UserPhoneNumberUtil.m3630a((InjectorLike) this), (CachedColumnNameCursorProvider) getOnDemandAssistedProviderForStaticDi(CachedColumnNameCursorProvider.class), cursor);
    }
}
