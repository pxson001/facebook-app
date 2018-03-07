package com.facebook.contactlogs.iterator;

import android.database.Cursor;
import com.facebook.contactlogs.data.ContactLogMetadata;
import com.facebook.contactlogs.data.ContactLogMetadata.ContactLogType;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/* compiled from: profile_wizard_cancel_button_tap */
public abstract class AbstractContactLogMetaDataIteratorGetter {
    protected abstract ContactLogType mo242a();

    protected ContactLogMetadata mo243a(Cursor cursor) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        m6481a(objectNode, cursor);
        return new ContactLogMetadata(objectNode, mo242a());
    }

    protected static void m6481a(ObjectNode objectNode, Cursor cursor) {
        for (int i = 0; i < cursor.getColumnCount(); i++) {
            objectNode.a(cursor.getColumnName(i), cursor.getString(i));
        }
    }
}
