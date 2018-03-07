package com.facebook.contacts.upload.data;

import android.text.TextUtils;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing.Sha256Holder;
import java.util.Collections;
import java.util.List;

/* compiled from: tapped_check_in */
public class ContactsUploadFriendFinderHashHelper {
    public static ContactsUploadFriendFinderHashHelper m2134a(InjectorLike injectorLike) {
        return new ContactsUploadFriendFinderHashHelper();
    }

    public static String m2135a(List<String> list) {
        Collections.sort(list);
        return Sha256Holder.a.a(TextUtils.join(":", list.toArray()), Charsets.UTF_8).toString();
    }
}
