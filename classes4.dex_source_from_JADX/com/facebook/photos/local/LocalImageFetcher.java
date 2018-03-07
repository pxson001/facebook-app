package com.facebook.photos.local;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import com.facebook.common.media.MediaUtils;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.media.MediaItemFactory.PhotoItemBuilder;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.util.PhotoHashUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: latestInboxFromPush */
public class LocalImageFetcher {
    private static final String f9473a = LocalImageFetcher.class.getSimpleName();
    private final int f9474b = 0;
    private final int f9475c = 1;
    private final int f9476d = 2;
    private final int f9477e = 3;
    private final int f9478f = 4;
    private final int f9479g = 5;
    public final Context f9480h;

    private static LocalImageFetcher m9850b(InjectorLike injectorLike) {
        return new LocalImageFetcher((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public LocalImageFetcher(Context context) {
        this.f9480h = context;
    }

    protected Map<String, MediaItem> mo754a(@Nullable Map<String, Long> map, @Nullable String str, @Nullable List<String> list) {
        Cursor a = m9847a(str, list);
        if (a == null) {
            return Maps.c();
        }
        HashMap hashMap = new HashMap();
        while (a.moveToNext()) {
            PhotoItem b = m9849b(a, map);
            if (b != null) {
                hashMap.put(PhotoHashUtil.a(b.h(), b.j()), b);
            }
        }
        a.close();
        return hashMap;
    }

    private Cursor m9847a(@Nullable String str, @Nullable List<String> list) {
        String[] strArr = new String[]{"_id", "_data", "orientation", "mime_type", "datetaken", "_display_name"};
        if (list == null) {
            list = Lists.a();
        }
        return this.f9480h.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, strArr, str, (String[]) list.toArray(new String[list.size()]), "date_modified DESC");
    }

    @Nullable
    public static PhotoItem m9849b(Cursor cursor, @Nullable Map<String, Long> map) {
        String string = cursor.getString(5);
        if (string == null) {
            return null;
        }
        String string2 = cursor.getString(1);
        if (string2 == null) {
            return null;
        }
        String string3 = cursor.getString(3);
        if (string3 == null || string3.startsWith("*/")) {
            string3 = MediaUtils.c(string2);
            if (string3 == null) {
                return null;
            }
        }
        String str = string3;
        long j = cursor.getLong(4);
        string3 = PhotoHashUtil.a(string, j);
        long longValue = (map == null || !map.containsKey(string3)) ? -1 : ((Long) map.get(string3)).longValue();
        PhotoItemBuilder b = new PhotoItemBuilder().c(cursor.getLong(0)).b(string2);
        if (string != null) {
            b.k.a(string);
        }
        b = b.d(str);
        b.k.b = j;
        b = b.a(cursor.getInt(2));
        b.a = longValue;
        return b.a();
    }

    protected static boolean m9848a(String str) {
        return new File(str).length() == 0;
    }
}
