package com.facebook.photos.local;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.media.MediaItemCursorUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: hash_file_size */
public class MediaCursorUtil {
    private final MediaItemCursorUtil f13092a;
    private final ContentResolver f13093b;
    private final AbstractFbErrorReporter f13094c;

    public static MediaCursorUtil m20427b(InjectorLike injectorLike) {
        return new MediaCursorUtil(MediaItemCursorUtil.m20086b(injectorLike), ContentResolverMethodAutoProvider.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public MediaCursorUtil(MediaItemCursorUtil mediaItemCursorUtil, ContentResolver contentResolver, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f13092a = mediaItemCursorUtil;
        this.f13093b = contentResolver;
        this.f13094c = abstractFbErrorReporter;
    }

    public final List<MediaItem> m20430a(Cursor cursor, int i, Map<Long, MediaItem> map) {
        List a = Lists.a();
        List a2 = Lists.a();
        List<Long> arrayList = new ArrayList(i);
        List<MediaItem> arrayList2 = new ArrayList(i);
        int i2 = 0;
        while (i2 < i && cursor.moveToNext()) {
            long j = cursor.getLong(0);
            arrayList.add(Long.valueOf(j));
            i2++;
            if (!map.containsKey(Long.valueOf(j))) {
                if (cursor.getInt(1) == 3) {
                    a2.add(Long.valueOf(j));
                } else {
                    a.add(Long.valueOf(j));
                }
            }
        }
        if (!a.isEmpty()) {
            m20426a(m20424a("_id", a), (Map) map);
        }
        if (!a2.isEmpty()) {
            m20428b(m20424a("_id", a2), map);
        }
        for (Long longValue : arrayList) {
            long longValue2 = longValue.longValue();
            if (map.containsKey(Long.valueOf(longValue2))) {
                arrayList2.add(map.get(Long.valueOf(longValue2)));
            } else {
                arrayList2.add(null);
            }
        }
        return arrayList2;
    }

    public final void m20431a(long j, long j2, Map<Long, MediaItem> map) {
        m20426a(m20423a("_id", j, j2), (Map) map);
    }

    public final void m20432b(long j, long j2, Map<Long, MediaItem> map) {
        m20428b(m20423a("_id", j, j2), map);
    }

    private static String m20423a(String str, long j, long j2) {
        return StringFormatUtil.a("%s <= %d AND %s >= %d", new Object[]{str, Long.valueOf(j), str, Long.valueOf(j2)});
    }

    private static String m20424a(String str, List<Long> list) {
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = StringUtil.b(",", new Object[]{list});
        return StringFormatUtil.a("%s in (%s)", objArr);
    }

    private void m20426a(String str, Map<Long, MediaItem> map) {
        m20425a(this.f13092a.m20089a(Media.EXTERNAL_CONTENT_URI, str, null), (Map) map);
    }

    private void m20428b(String str, Map<Long, MediaItem> map) {
        m20425a(this.f13092a.m20091b(Video.Media.EXTERNAL_CONTENT_URI, str, null), (Map) map);
    }

    private void m20425a(@Nullable Cursor cursor, Map<Long, MediaItem> map) {
        if (cursor != null) {
            try {
                UnmodifiableIterator a = this.f13092a.m20090a(cursor);
                while (a.hasNext()) {
                    MediaItem mediaItem = (MediaItem) a.next();
                    if (mediaItem != null) {
                        map.put(Long.valueOf(mediaItem.a().d()), mediaItem);
                    }
                }
            } finally {
                cursor.close();
            }
        }
    }

    public final long m20429a() {
        long j;
        Throwable e;
        try {
            Cursor query = this.f13093b.query(Video.Media.EXTERNAL_CONTENT_URI, new String[]{"date_added"}, null, null, "_id desc");
            if (query.moveToFirst()) {
                j = query.getLong(0);
            } else {
                j = -1;
            }
            try {
                query.close();
            } catch (RuntimeException e2) {
                e = e2;
                this.f13094c.a("MediaCursorUtil: fetchLatestVideoAddedTime failed", "error creating cursor", e);
                return j;
            }
        } catch (Throwable e3) {
            e = e3;
            j = -1;
            this.f13094c.a("MediaCursorUtil: fetchLatestVideoAddedTime failed", "error creating cursor", e);
            return j;
        }
        return j;
    }
}
