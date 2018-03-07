package com.facebook.presence;

import android.database.Cursor;
import com.facebook.common.cursors.CursorIterator;
import com.facebook.common.util.TriState;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;

/* compiled from: forceRefresh */
public class ContactPresenceIterator extends CursorIterator<ContactPushableState> {
    public int f11473b = -1;
    public int f11474c = -1;
    public int f11475d = -1;

    public ContactPresenceIterator(Cursor cursor) {
        super(cursor);
    }

    protected final Object mo849a(Cursor cursor) {
        if (this.f11473b == -1) {
            this.f11473b = cursor.getColumnIndexOrThrow("fbid");
            this.f11474c = cursor.getColumnIndexOrThrow("is_mobile_pushable");
            this.f11475d = cursor.getColumnIndexOrThrow("is_messenger_user");
        }
        UserKey userKey = new UserKey(Type.FACEBOOK, cursor.getString(this.f11473b));
        TriState fromDbValue = TriState.fromDbValue(cursor.getInt(this.f11474c));
        return new ContactPushableState(userKey, fromDbValue.asBoolean(false), Boolean.valueOf(cursor.getString(this.f11475d)).booleanValue());
    }
}
