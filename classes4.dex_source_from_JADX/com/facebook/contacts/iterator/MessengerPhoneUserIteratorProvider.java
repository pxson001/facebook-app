package com.facebook.contacts.iterator;

import android.database.Cursor;
import com.facebook.common.cursors.CachedColumnNameCursorProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.user.util.UserPhoneNumberUtil;

/* compiled from: fb.exp. */
public class MessengerPhoneUserIteratorProvider extends AbstractAssistedProvider<MessengerPhoneUserIterator> {
    public final MessengerPhoneUserIterator m12849a(Cursor cursor) {
        return new MessengerPhoneUserIterator(UserPhoneNumberUtil.m3630a((InjectorLike) this), (CachedColumnNameCursorProvider) getOnDemandAssistedProviderForStaticDi(CachedColumnNameCursorProvider.class), cursor);
    }
}
