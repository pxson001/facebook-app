package com.facebook.contactlogs.iterator;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android_src.provider.Telephony.Mms;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.contactlogs.data.ContactLogMetadata;
import com.facebook.contactlogs.data.ContactLogMetadata.ContactLogType;
import com.facebook.inject.InjectorLike;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: profile_question_option_id */
public class MmsLogMetaDataIteratorGetter extends AbstractContactLogMetaDataIteratorGetter {
    private static final String[] f6143a = new String[]{"contact_id", "address", "type", "charset"};
    private static final String[] f6144b = new String[]{"_id", "m_id", "ct_cls", "ct_t", "date", "date_sent", "d_tm", "d_rpt", "msg_box"};
    private static final String[] f6145c = new String[]{"m_id", "ct_cls", "ct_t", "date", "date_sent", "d_tm", "d_rpt", "msg_box"};
    public final ContentResolver f6146d;
    private final ContactLogMetaDataIteratorProvider f6147e;
    public final RuntimePermissionsUtil f6148f;

    public static MmsLogMetaDataIteratorGetter m6490b(InjectorLike injectorLike) {
        return new MmsLogMetaDataIteratorGetter(ContentResolverMethodAutoProvider.b(injectorLike), (ContactLogMetaDataIteratorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ContactLogMetaDataIteratorProvider.class), RuntimePermissionsUtil.b(injectorLike));
    }

    @Inject
    public MmsLogMetaDataIteratorGetter(ContentResolver contentResolver, ContactLogMetaDataIteratorProvider contactLogMetaDataIteratorProvider, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f6146d = contentResolver;
        this.f6147e = contactLogMetaDataIteratorProvider;
        this.f6148f = runtimePermissionsUtil;
    }

    @Nullable
    public final ContactLogMetaDataIterator m6493b() {
        String[] strArr = f6144b;
        String str = null;
        if (this.f6148f.a("android.permission.READ_SMS")) {
            Cursor query = this.f6146d.query(Mms.a, strArr, null, null, "_id");
            if (query != null) {
                str = ContactLogMetaDataIteratorProvider.m6489a(query, this);
            }
        }
        return str;
    }

    protected final ContactLogType mo242a() {
        return ContactLogType.MMS_LOG;
    }

    protected final ContactLogMetadata mo243a(Cursor cursor) {
        Throwable th;
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        if (!this.f6148f.a("android.permission.READ_SMS")) {
            return new ContactLogMetadata(objectNode, mo242a());
        }
        Cursor query;
        try {
            query = this.f6146d.query(Uri.parse(StringFormatUtil.formatStrLocaleSafe("content://mms/%s/addr", cursor.getString(cursor.getColumnIndex("_id")))), f6143a, null, null, null);
            try {
                ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
                if (query != null) {
                    while (query.moveToNext()) {
                        ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
                        AbstractContactLogMetaDataIteratorGetter.m6481a(objectNode2, query);
                        arrayNode.a(objectNode2);
                    }
                }
                objectNode.c("addresses", arrayNode);
                if (query != null) {
                    query.close();
                }
                AbstractContactLogMetaDataIteratorGetter.m6481a(objectNode, cursor);
                return new ContactLogMetadata(objectNode, mo242a());
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }
}
