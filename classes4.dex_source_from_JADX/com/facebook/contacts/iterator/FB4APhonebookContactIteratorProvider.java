package com.facebook.contacts.iterator;

import android.database.Cursor;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.cursors.CachedColumnNameCursorProvider;
import com.facebook.contacts.util.ContactMetadataUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;

/* compiled from: fb.db */
public class FB4APhonebookContactIteratorProvider extends AbstractAssistedProvider<FB4APhonebookContactIterator> {
    public final FB4APhonebookContactIterator m12850a(Cursor cursor) {
        return new FB4APhonebookContactIterator((CachedColumnNameCursorProvider) getOnDemandAssistedProviderForStaticDi(CachedColumnNameCursorProvider.class), ContactIteratorAnalyticsLogger.a(this), new ContactMetadataUtil(ContentResolverMethodAutoProvider.b(this), RuntimePermissionsUtil.b(this), IdBasedProvider.a(this, 3946)), IdBasedProvider.a(this, 655), cursor);
    }
}
