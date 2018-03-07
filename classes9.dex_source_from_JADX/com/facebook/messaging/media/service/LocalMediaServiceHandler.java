package com.facebook.messaging.media.service;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.ExifOrientationUtil;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.ui.media.attachments.MediaResourceHelper;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: location_types */
public class LocalMediaServiceHandler implements BlueServiceHandler {
    private static final String[] f11821a = new String[]{"_id", "_data", "_display_name", "mime_type", "datetaken", "orientation"};
    private static final String[] f11822b = new String[]{"_id", "_data", "_display_name", "mime_type", "datetaken"};
    private final ContentResolver f11823c;
    public final MediaResourceHelper f11824d;

    public static LocalMediaServiceHandler m12444b(InjectorLike injectorLike) {
        return new LocalMediaServiceHandler(ContentResolverMethodAutoProvider.b(injectorLike), MediaResourceHelper.a(injectorLike));
    }

    public final OperationResult m12449a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("load_local_media".equals(str)) {
            return m12443b(operationParams);
        }
        throw new UnsupportedOperationException("Unsupported operation type" + str);
    }

    private OperationResult m12443b(OperationParams operationParams) {
        boolean z = operationParams.c.getBoolean("loadVideos");
        int i = operationParams.c.getInt("limit");
        Collection a = m12442a(i);
        if (z) {
            a.addAll(m12446b(i));
            Collections.sort(a, MediaResource.a);
            if (i > 0 && a.size() > i) {
                a = a.subList(0, i);
            }
        }
        return OperationResult.a(new LocalMediaLoadResult(ImmutableList.copyOf(a)));
    }

    @Inject
    public LocalMediaServiceHandler(ContentResolver contentResolver, MediaResourceHelper mediaResourceHelper) {
        this.f11823c = contentResolver;
        this.f11824d = mediaResourceHelper;
    }

    private List<MediaResource> m12442a(int i) {
        List<MediaResource> arrayList;
        Throwable th;
        Throwable th2 = null;
        Cursor query = this.f11823c.query(Media.EXTERNAL_CONTENT_URI, f11821a, null, null, "date_modified DESC" + m12448c(i));
        if (query == null) {
            try {
                arrayList = new ArrayList();
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th3) {
                th2 = th;
                th = th3;
            }
        } else {
            arrayList = new ArrayList();
            while (query.moveToNext()) {
                MediaResource a = m12441a(query);
                if (a != null) {
                    arrayList.add(a);
                }
            }
            if (query != null) {
                query.close();
            }
        }
        return arrayList;
        if (query != null) {
            if (th2 != null) {
                try {
                    query.close();
                } catch (Throwable th32) {
                    AndroidCompat.addSuppressed(th2, th32);
                }
            } else {
                query.close();
            }
        }
        throw th;
        throw th;
    }

    private List<MediaResource> m12446b(int i) {
        List<MediaResource> arrayList;
        Throwable th;
        Throwable th2 = null;
        Cursor query = this.f11823c.query(Video.Media.EXTERNAL_CONTENT_URI, f11822b, null, null, "date_modified DESC" + m12448c(i));
        if (query == null) {
            try {
                arrayList = new ArrayList();
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th3) {
                th2 = th;
                th = th3;
            }
        } else {
            arrayList = new ArrayList();
            while (query.moveToNext()) {
                MediaResource b = m12445b(query);
                if (b != null) {
                    arrayList.add(b);
                }
            }
            if (query != null) {
                query.close();
            }
        }
        return arrayList;
        if (query != null) {
            if (th2 != null) {
                try {
                    query.close();
                } catch (Throwable th32) {
                    AndroidCompat.addSuppressed(th2, th32);
                }
            } else {
                query.close();
            }
        }
        throw th;
        throw th;
    }

    private static String m12448c(int i) {
        return i > 0 ? StringFormatUtil.formatStrLocaleSafe(" LIMIT %d", Integer.valueOf(i)) : "";
    }

    @Nullable
    private MediaResource m12441a(Cursor cursor) {
        MediaResourceBuilder c = m12447c(cursor);
        if (c == null) {
            return null;
        }
        c.j = ExifOrientationUtil.a(cursor.getInt(5));
        c = c;
        c.b = Type.PHOTO;
        return c.C();
    }

    @Nullable
    private MediaResource m12445b(Cursor cursor) {
        MediaResourceBuilder c = m12447c(cursor);
        if (c == null) {
            return null;
        }
        c.b = Type.VIDEO;
        return c.C();
    }

    @Nullable
    private MediaResourceBuilder m12447c(Cursor cursor) {
        if (cursor.getString(2) == null) {
            return null;
        }
        String string = cursor.getString(1);
        if (string == null) {
            return null;
        }
        long j = cursor.getLong(0);
        String string2 = cursor.getString(3);
        if (string2 == null || string2.startsWith("*/")) {
            string2 = this.f11824d.a(Uri.parse(string));
        }
        String str = string2;
        long j2 = cursor.getLong(4);
        MediaResourceBuilder a = MediaResource.a();
        a.a = Uri.fromFile(new File(string));
        MediaResourceBuilder mediaResourceBuilder = a;
        mediaResourceBuilder.m = str;
        MediaResourceBuilder mediaResourceBuilder2 = mediaResourceBuilder;
        mediaResourceBuilder2.y = j2;
        mediaResourceBuilder2 = mediaResourceBuilder2;
        mediaResourceBuilder2.f = j;
        return mediaResourceBuilder2;
    }
}
