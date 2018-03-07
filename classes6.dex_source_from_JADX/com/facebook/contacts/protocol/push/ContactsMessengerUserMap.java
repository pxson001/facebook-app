package com.facebook.contacts.protocol.push;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: page_photo_menus */
public class ContactsMessengerUserMap implements Parcelable {
    public static final Creator<ContactsMessengerUserMap> CREATOR = new C05311();
    public final ImmutableMap<UserKey, Boolean> f8408a;

    /* compiled from: page_photo_menus */
    final class C05311 implements Creator<ContactsMessengerUserMap> {
        C05311() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ContactsMessengerUserMap(parcel);
        }

        public final Object[] newArray(int i) {
            return new ContactsMessengerUserMap[i];
        }
    }

    public ContactsMessengerUserMap(List<Contact> list) {
        Map c = Maps.c();
        for (Contact contact : list) {
            if (ContactProfileType.FACEBOOK_FRIENDS_TYPES.contains(contact.A())) {
                c.put(new UserKey(Type.FACEBOOK, contact.c()), Boolean.valueOf(contact.s()));
            }
        }
        this.f8408a = ImmutableMap.copyOf(c);
    }

    public ContactsMessengerUserMap(Parcel parcel) {
        this.f8408a = ImmutableMap.copyOf(parcel.readHashMap(ContactsMessengerUserMap.class.getClassLoader()));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.f8408a.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            stringBuilder.append(entry.getKey()).append("->").append(entry.getValue() != null ? (Serializable) entry.getValue() : "null").append(",");
        }
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.f8408a);
    }
}
