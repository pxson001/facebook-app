package com.facebook.contacts.iterator;

import android.database.Cursor;
import com.facebook.common.cursors.CursorIterator;
import com.facebook.common.util.TriState;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.debug.log.BLog;
import com.facebook.user.model.Name;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.PicSquareUrlWithSize;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import javax.annotation.Nullable;

/* compiled from: dropped_message */
public class UserDatabaseIterator extends CursorIterator<User> implements UserIterator {
    private static final Class<?> f13550b = UserDatabaseIterator.class;

    @Nullable
    protected final /* synthetic */ Object mo849a(Cursor cursor) {
        return m14413b(cursor);
    }

    public UserDatabaseIterator(Cursor cursor) {
        super(cursor);
    }

    @Nullable
    private static User m14413b(Cursor cursor) {
        try {
            boolean z;
            int columnIndex = cursor.getColumnIndex("fbid");
            int columnIndex2 = cursor.getColumnIndex("first_name");
            int columnIndex3 = cursor.getColumnIndex("last_name");
            int columnIndex4 = cursor.getColumnIndex("display_name");
            int columnIndex5 = cursor.getColumnIndex("small_picture_url");
            int columnIndex6 = cursor.getColumnIndex("big_picture_url");
            int columnIndex7 = cursor.getColumnIndex("huge_picture_url");
            int columnIndex8 = cursor.getColumnIndex("small_picture_size");
            int columnIndex9 = cursor.getColumnIndex("big_picture_size");
            int columnIndex10 = cursor.getColumnIndex("huge_picture_size");
            int columnIndex11 = cursor.getColumnIndex("communication_rank");
            int columnIndex12 = cursor.getColumnIndex("is_mobile_pushable");
            int columnIndex13 = cursor.getColumnIndex("is_messenger_user");
            int columnIndex14 = cursor.getColumnIndex("messenger_install_time_ms");
            int columnIndex15 = cursor.getColumnIndex("added_time_ms");
            int columnIndex16 = cursor.getColumnIndex("link_type");
            int columnIndex17 = cursor.getColumnIndex("bday_month");
            int columnIndex18 = cursor.getColumnIndex("bday_day");
            int columnIndex19 = cursor.getColumnIndex("is_partial");
            int columnIndex20 = cursor.getColumnIndex("messenger_invite_priority");
            int columnIndex21 = cursor.getColumnIndex("phonebook_section_key");
            Name name = new Name(cursor.getString(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4));
            String string = cursor.getString(columnIndex5);
            String string2 = cursor.getString(columnIndex6);
            String string3 = cursor.getString(columnIndex7);
            PicSquare picSquare = null;
            if (!(string == null || string2 == null || string3 == null)) {
                picSquare = new PicSquare(new PicSquareUrlWithSize(cursor.getInt(columnIndex8), cursor.getString(columnIndex5)), new PicSquareUrlWithSize(cursor.getInt(columnIndex9), cursor.getString(columnIndex6)), new PicSquareUrlWithSize(cursor.getInt(columnIndex10), cursor.getString(columnIndex7)));
            }
            boolean equals = ContactLinkType.getFromDbValue(cursor.getInt(columnIndex16)).equals(ContactLinkType.FRIEND);
            UserBuilder a = new UserBuilder().a(Type.FACEBOOK, cursor.getString(columnIndex)).b(name).f(cursor.getString(columnIndex5)).a(picSquare).a(cursor.getFloat(columnIndex11)).a(TriState.fromDbValue(cursor.getInt(columnIndex12))).c(Boolean.valueOf(cursor.getString(columnIndex13)).booleanValue()).a(cursor.getLong(columnIndex14)).b(cursor.getLong(columnIndex15)).h(equals).a(cursor.getInt(columnIndex17), cursor.getInt(columnIndex18));
            if (((long) cursor.getInt(columnIndex19)) == 1) {
                z = true;
            } else {
                z = false;
            }
            UserBuilder b = a.k(z).b(cursor.getFloat(columnIndex20));
            if (columnIndex21 >= 0) {
                b.i(cursor.getString(columnIndex21));
            }
            return b.aa();
        } catch (Throwable e) {
            BLog.a(f13550b, "Exception deserializing user from contact", e);
            return null;
        }
    }
}
