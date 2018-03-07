package com.facebook.contactlogs.iterator;

import android.content.ContentResolver;
import android.database.Cursor;
import android_src.provider.Telephony.Sms;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.contactlogs.data.ContactLogMetadata.ContactLogType;
import com.facebook.inject.InjectorLike;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: profile_question_id */
public class SmsLogMetaDataIteratorGetter extends AbstractContactLogMetaDataIteratorGetter {
    private static final String[] f6149a = new String[]{"_id", "address", "date", "date_sent", "person", "type", "read", "seen", "status"};
    private static final String[] f6150b = new String[]{"address", "date", "date_sent", "person", "type", "read", "seen", "status"};
    public final ContentResolver f6151c;
    private final ContactLogMetaDataIteratorProvider f6152d;
    public final RuntimePermissionsUtil f6153e;

    public static SmsLogMetaDataIteratorGetter m6494b(InjectorLike injectorLike) {
        return new SmsLogMetaDataIteratorGetter(ContentResolverMethodAutoProvider.b(injectorLike), (ContactLogMetaDataIteratorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ContactLogMetaDataIteratorProvider.class), RuntimePermissionsUtil.b(injectorLike));
    }

    @Inject
    public SmsLogMetaDataIteratorGetter(ContentResolver contentResolver, ContactLogMetaDataIteratorProvider contactLogMetaDataIteratorProvider, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f6151c = contentResolver;
        this.f6152d = contactLogMetaDataIteratorProvider;
        this.f6153e = runtimePermissionsUtil;
    }

    @Nullable
    public final ContactLogMetaDataIterator m6496b() {
        String[] strArr = f6149a;
        String str = null;
        if (this.f6153e.a("android.permission.READ_SMS")) {
            Cursor query = this.f6151c.query(Sms.a, strArr, null, null, "_id");
            if (query != null) {
                str = ContactLogMetaDataIteratorProvider.m6489a(query, this);
            }
        }
        return str;
    }

    protected final ContactLogType mo242a() {
        return ContactLogType.SMS_LOG;
    }
}
