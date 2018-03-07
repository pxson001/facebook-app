package com.facebook.messaging.camerautil.gallery;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.util.LruCache;
import com.facebook.debug.log.BLog;
import com.facebook.messaging.camerautil.CameraUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: messenger_save_photo_start */
public abstract class BaseImageList implements IImageList {
    private static final Class<?> f9702h = BaseImageList.class;
    public static final Pattern f9703j = Pattern.compile("(.*)/\\d+");
    protected ContentResolver f9704a;
    public int f9705b;
    protected Uri f9706c;
    protected Cursor f9707d;
    public String f9708e;
    protected Uri f9709f;
    protected boolean f9710g = false;
    private final LruCache<Integer, BaseImage> f9711i = new LruCache(512);

    protected abstract BaseImage mo395a(Cursor cursor);

    protected abstract long mo396b(Cursor cursor);

    protected abstract Cursor mo397d();

    public BaseImageList(ContentResolver contentResolver, Uri uri, int i, String str) {
        this.f9705b = i;
        this.f9706c = uri;
        this.f9708e = str;
        this.f9704a = contentResolver;
        this.f9707d = mo397d();
        if (this.f9707d == null) {
            BLog.a(f9702h, "createCursor returns null.");
        }
        this.f9711i.a();
    }

    public final void mo387a() {
        try {
            m10291g();
        } catch (Throwable e) {
            BLog.b(f9702h, "Caught exception while deactivating cursor.", e);
        }
        this.f9704a = null;
        if (this.f9707d != null) {
            this.f9707d.close();
            this.f9707d = null;
        }
    }

    public final Uri m10292a(long j) {
        try {
            if (ContentUris.parseId(this.f9706c) != j) {
                BLog.b(f9702h, "id mismatch");
            }
            return this.f9706c;
        } catch (NumberFormatException e) {
            return ContentUris.withAppendedId(this.f9706c, j);
        }
    }

    public final int mo388b() {
        Cursor f = m10290f();
        if (f == null) {
            return 0;
        }
        int count;
        synchronized (this) {
            count = f.getCount();
        }
        return count;
    }

    private Cursor m10290f() {
        Cursor cursor;
        synchronized (this) {
            if (this.f9707d == null) {
                cursor = null;
            } else {
                if (this.f9710g) {
                    this.f9707d.requery();
                    this.f9710g = false;
                }
                cursor = this.f9707d;
            }
        }
        return cursor;
    }

    public final IImage mo385a(int i) {
        BaseImage baseImage = (BaseImage) this.f9711i.a(Integer.valueOf(i));
        if (baseImage != null) {
            return baseImage;
        }
        Cursor f = m10290f();
        if (f == null) {
            return null;
        }
        IImage a;
        synchronized (this) {
            if (f.moveToPosition(i)) {
                a = mo395a(f);
            } else {
                a = null;
            }
            this.f9711i.a(Integer.valueOf(i), a);
        }
        return a;
    }

    private void m10291g() {
        if (this.f9707d != null) {
            this.f9707d.deactivate();
            this.f9710g = true;
        }
    }

    private boolean m10289c(Uri uri) {
        Uri uri2 = this.f9706c;
        if (CameraUtil.m10224a(uri2.getScheme(), uri.getScheme()) && CameraUtil.m10224a(uri2.getHost(), uri.getHost()) && CameraUtil.m10224a(uri2.getAuthority(), uri.getAuthority())) {
            String path = uri2.getPath();
            CharSequence path2 = uri.getPath();
            Matcher matcher = f9703j.matcher(path2);
            if (matcher.matches()) {
                path2 = matcher.group(1);
            }
            if (CameraUtil.m10224a(path, (String) path2)) {
                return true;
            }
        }
        return false;
    }

    public final IImage mo386a(Uri uri) {
        int i = 0;
        IImage iImage = null;
        if (m10289c(uri)) {
            try {
                long parseId = ContentUris.parseId(uri);
                Cursor f = m10290f();
                if (f != null) {
                    synchronized (this) {
                        f.moveToPosition(-1);
                        while (f.moveToNext()) {
                            if (mo396b(f) == parseId) {
                                iImage = (BaseImage) this.f9711i.a(Integer.valueOf(i));
                                if (iImage == null) {
                                    iImage = mo395a(f);
                                    this.f9711i.a(Integer.valueOf(i), iImage);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
            } catch (NumberFormatException e) {
                new Object[1][0] = uri;
            }
        }
        return iImage;
    }
}
