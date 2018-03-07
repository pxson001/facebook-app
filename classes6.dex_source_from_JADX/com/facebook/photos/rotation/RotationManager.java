package com.facebook.photos.rotation;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.local.LocalMediaCursorImp;
import com.facebook.photos.local.LocalMediaCursorMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: has_saved_instance_state */
public class RotationManager {
    private final AbstractFbErrorReporter f13250a;
    private final Context f13251b;
    private final ImagePipeline f13252c;
    private final LocalMediaCursorImp f13253d;

    public static RotationManager m20927b(InjectorLike injectorLike) {
        return new RotationManager((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Context) injectorLike.getInstance(Context.class, ForAppContext.class), ImagePipelineMethodAutoProvider.a(injectorLike), LocalMediaCursorMethodAutoProvider.m20422b(injectorLike));
    }

    @Inject
    public RotationManager(AbstractFbErrorReporter abstractFbErrorReporter, @ForAppContext Context context, ImagePipeline imagePipeline, LocalMediaCursorImp localMediaCursorImp) {
        this.f13250a = abstractFbErrorReporter;
        this.f13252c = imagePipeline;
        this.f13251b = context.getApplicationContext();
        this.f13253d = localMediaCursorImp;
    }

    public static RotationManager m20924a(InjectorLike injectorLike) {
        return m20927b(injectorLike);
    }

    public final int m20928a(String str) {
        int i = 0;
        try {
            i = m20923a(new ExifInterface(str).getAttributeInt("Orientation", 1));
        } catch (Throwable e) {
            this.f13250a.a("RotationManager", "Error checking exif", e);
        }
        return i;
    }

    public final void m20929a(Uri uri, int i) {
        m20925a(uri.getPath(), i);
        this.f13252c.a(uri);
    }

    public final void m20930a(PhotoItem photoItem, int i) {
        m20925a(photoItem.e(), i);
        m20931b(photoItem, i);
        this.f13252c.a(photoItem.f());
    }

    public final void m20931b(PhotoItem photoItem, int i) {
        photoItem.m20115b(i);
        this.f13253d.m20420b(photoItem.c());
        ContentResolver contentResolver = this.f13251b.getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("orientation", String.valueOf(i));
        try {
            if (contentResolver.update(Media.EXTERNAL_CONTENT_URI, contentValues, StringFormatUtil.formatStrLocaleSafe("%s = ?", "_id"), new String[]{String.valueOf(photoItem.c())}) > 0) {
                contentResolver.notifyChange(Media.EXTERNAL_CONTENT_URI, null);
            }
        } catch (Throwable e) {
            this.f13250a.a("RotationManager", "Error writing content resolver", e);
        }
    }

    private void m20925a(String str, int i) {
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            exifInterface.setAttribute("Orientation", String.valueOf(m20926b(i)));
            exifInterface.saveAttributes();
        } catch (Throwable e) {
            this.f13250a.a("RotationManager", "Error writing exif", e);
        }
    }

    private static int m20923a(int i) {
        switch (i) {
            case 3:
                return 180;
            case 6:
                return 90;
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    private static int m20926b(int i) {
        switch (i) {
            case 90:
                return 6;
            case 180:
                return 3;
            case 270:
                return 8;
            default:
                return 1;
        }
    }
}
