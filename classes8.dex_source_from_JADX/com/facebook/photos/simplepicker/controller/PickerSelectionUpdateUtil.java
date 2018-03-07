package com.facebook.photos.simplepicker.controller;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore.Files;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.ipc.media.MediaItem;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: share_in_email */
public class PickerSelectionUpdateUtil {
    private final ContentResolver f3115a;

    @Inject
    public PickerSelectionUpdateUtil(ContentResolver contentResolver) {
        this.f3115a = contentResolver;
    }

    public final ImmutableList<MediaItem> m3136a(ImmutableList<MediaItem> immutableList) {
        if (immutableList.isEmpty()) {
            return immutableList;
        }
        int i;
        List a = Lists.a();
        int size = immutableList.size();
        for (i = 0; i < size; i++) {
            a.add(Long.valueOf(((MediaItem) immutableList.get(i)).c()));
        }
        Object[] objArr = new Object[1];
        objArr[0] = StringUtil.b(",", new Object[]{a});
        String a2 = StringFormatUtil.a(" in (%s)", objArr);
        Cursor query = this.f3115a.query(Files.getContentUri("external"), new String[]{"_id"}, "_id" + a2, null, null);
        if (query == null) {
            return immutableList;
        }
        if (query.getCount() == a.size()) {
            query.close();
            return immutableList;
        }
        Set a3 = Sets.a();
        while (query.moveToNext()) {
            a3.add(Long.valueOf(query.getLong(0)));
        }
        query.close();
        Collection a4 = Lists.a();
        int size2 = immutableList.size();
        for (i = 0; i < size2; i++) {
            MediaItem mediaItem = (MediaItem) immutableList.get(i);
            if (a3.contains(Long.valueOf(mediaItem.c()))) {
                a4.add(mediaItem);
            }
        }
        return ImmutableList.copyOf(a4);
    }
}
