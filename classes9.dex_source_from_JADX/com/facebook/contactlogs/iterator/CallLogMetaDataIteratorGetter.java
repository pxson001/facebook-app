package com.facebook.contactlogs.iterator;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.CallLog.Calls;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.contactlogs.data.ContactLogMetadata.ContactLogType;
import com.facebook.inject.InjectorLike;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: profile_refresher_step_types */
public class CallLogMetaDataIteratorGetter extends AbstractContactLogMetaDataIteratorGetter {
    private static final String[] f6136a = new String[]{"_id", "number", "type", "date", "duration", "name", "numberlabel", "numbertype"};
    private static final String[] f6137b = new String[]{"number", "type", "date", "duration", "name", "numberlabel", "numbertype"};
    public final ContentResolver f6138c;
    private final ContactLogMetaDataIteratorProvider f6139d;
    public final RuntimePermissionsUtil f6140e;

    public static CallLogMetaDataIteratorGetter m6484b(InjectorLike injectorLike) {
        return new CallLogMetaDataIteratorGetter(ContentResolverMethodAutoProvider.b(injectorLike), (ContactLogMetaDataIteratorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ContactLogMetaDataIteratorProvider.class), RuntimePermissionsUtil.b(injectorLike));
    }

    @Inject
    public CallLogMetaDataIteratorGetter(ContentResolver contentResolver, ContactLogMetaDataIteratorProvider contactLogMetaDataIteratorProvider, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f6138c = contentResolver;
        this.f6139d = contactLogMetaDataIteratorProvider;
        this.f6140e = runtimePermissionsUtil;
    }

    @Nullable
    public final ContactLogMetaDataIterator m6486b() {
        String[] strArr = f6136a;
        String str = null;
        if (this.f6140e.a("android.permission.READ_CALL_LOG")) {
            Cursor query = this.f6138c.query(Calls.CONTENT_URI, strArr, null, null, "_id");
            if (query != null) {
                str = ContactLogMetaDataIteratorProvider.m6489a(query, this);
            }
        }
        return str;
    }

    protected final ContactLogType mo242a() {
        return ContactLogType.CALL_LOG;
    }
}
