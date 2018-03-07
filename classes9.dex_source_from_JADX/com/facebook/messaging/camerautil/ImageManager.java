package com.facebook.messaging.camerautil;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.location.Location;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.facebook.debug.log.BLog;
import com.facebook.messaging.camerautil.gallery.BaseImageList;
import com.facebook.messaging.camerautil.gallery.IImage;
import com.facebook.messaging.camerautil.gallery.IImageList;
import com.facebook.messaging.camerautil.gallery.ImageList;
import com.facebook.messaging.camerautil.gallery.ImageListUber;
import com.facebook.messaging.camerautil.gallery.SingleImageList;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: messenger_segmented_transcode_upload */
public class ImageManager {
    public static final String f9681a;
    public static final String f9682b;
    private static final Class<?> f9683c = ImageManager.class;
    private static final Uri f9684d = Media.EXTERNAL_CONTENT_URI;
    private static final Uri f9685e = Thumbnails.EXTERNAL_CONTENT_URI;
    private static final Uri f9686f = Uri.parse("content://media/external/video/media");

    /* compiled from: messenger_segmented_transcode_upload */
    public enum DataLocation {
        NONE,
        INTERNAL,
        EXTERNAL,
        ALL
    }

    /* compiled from: messenger_segmented_transcode_upload */
    class EmptyImageList implements IImageList {
        public final void mo387a() {
        }

        public final int mo388b() {
            return 0;
        }

        public final IImage mo385a(int i) {
            return null;
        }

        public final IImage mo386a(Uri uri) {
            return null;
        }
    }

    /* compiled from: messenger_segmented_transcode_upload */
    public class ImageListParam implements Parcelable {
        public static final Creator CREATOR = new C11251();
        public DataLocation f9675a;
        public int f9676b;
        public int f9677c;
        public String f9678d;
        public Uri f9679e;
        public boolean f9680f;

        /* compiled from: messenger_segmented_transcode_upload */
        final class C11251 implements Creator {
            C11251() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new ImageListParam(parcel);
            }

            public final Object[] newArray(int i) {
                return new ImageListParam[i];
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f9675a.ordinal());
            parcel.writeInt(this.f9676b);
            parcel.writeInt(this.f9677c);
            parcel.writeString(this.f9678d);
            parcel.writeParcelable(this.f9679e, i);
            parcel.writeInt(this.f9680f ? 1 : 0);
        }

        public ImageListParam(Parcel parcel) {
            this.f9675a = DataLocation.values()[parcel.readInt()];
            this.f9676b = parcel.readInt();
            this.f9677c = parcel.readInt();
            this.f9678d = parcel.readString();
            this.f9679e = (Uri) parcel.readParcelable(null);
            this.f9680f = parcel.readInt() != 0;
        }

        public String toString() {
            return String.format("ImageListParam{loc=%s,inc=%d,sort=%d,bucket=%s,empty=%b,single=%s}", new Object[]{this.f9675a, Integer.valueOf(this.f9676b), Integer.valueOf(this.f9677c), this.f9678d, Boolean.valueOf(this.f9680f), this.f9679e});
        }

        public int describeContents() {
            return 0;
        }
    }

    static {
        String str = Environment.getExternalStorageDirectory().toString() + "/DCIM/Camera";
        f9681a = str;
        f9682b = String.valueOf(str.toLowerCase().hashCode());
    }

    public static Uri m10271a(ContentResolver contentResolver, String str, long j, Location location, String str2, String str3, Bitmap bitmap, byte[] bArr, int[] iArr) {
        Closeable fileOutputStream;
        Throwable e;
        Throwable th;
        String str4 = str2 + "/" + str3;
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            fileOutputStream = new FileOutputStream(new File(str2, str3));
            if (bitmap != null) {
                try {
                    bitmap.compress(CompressFormat.JPEG, 75, fileOutputStream);
                    iArr[0] = 0;
                } catch (FileNotFoundException e2) {
                    e = e2;
                    try {
                        BLog.a(f9683c, "", e);
                        CameraUtil.m10223a(fileOutputStream);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        CameraUtil.m10223a(fileOutputStream);
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    BLog.a(f9683c, "", e);
                    CameraUtil.m10223a(fileOutputStream);
                    return null;
                }
            }
            fileOutputStream.write(bArr);
            iArr[0] = m10276b(str4);
            CameraUtil.m10223a(fileOutputStream);
            ContentValues contentValues = new ContentValues(7);
            contentValues.put("title", str);
            contentValues.put("_display_name", str3);
            contentValues.put("datetaken", Long.valueOf(j));
            contentValues.put("mime_type", "image/jpeg");
            contentValues.put("orientation", Integer.valueOf(iArr[0]));
            contentValues.put("_data", str4);
            if (location != null) {
                contentValues.put("latitude", Double.valueOf(location.getLatitude()));
                contentValues.put("longitude", Double.valueOf(location.getLongitude()));
            }
            return contentResolver.insert(f9684d, contentValues);
        } catch (FileNotFoundException e4) {
            e = e4;
            fileOutputStream = null;
            BLog.a(f9683c, "", e);
            CameraUtil.m10223a(fileOutputStream);
            return null;
        } catch (IOException e5) {
            e = e5;
            fileOutputStream = null;
            BLog.a(f9683c, "", e);
            CameraUtil.m10223a(fileOutputStream);
            return null;
        } catch (Throwable e6) {
            fileOutputStream = null;
            th = e6;
            CameraUtil.m10223a(fileOutputStream);
            throw th;
        }
    }

    private static int m10276b(String str) {
        ExifInterface exifInterface;
        try {
            exifInterface = new ExifInterface(str);
        } catch (Throwable e) {
            BLog.b(f9683c, "cannot read exif", e);
            exifInterface = null;
        }
        if (exifInterface == null) {
            return 0;
        }
        int attributeInt = exifInterface.getAttributeInt("Orientation", -1);
        if (attributeInt == -1) {
            return 0;
        }
        switch (attributeInt) {
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

    public static IImageList m10273a(ContentResolver contentResolver, ImageListParam imageListParam) {
        DataLocation dataLocation = imageListParam.f9675a;
        int i = imageListParam.f9676b;
        int i2 = imageListParam.f9677c;
        String str = imageListParam.f9678d;
        Uri uri = imageListParam.f9679e;
        if (imageListParam.f9680f || contentResolver == null) {
            return new EmptyImageList();
        }
        if (uri != null) {
            return new SingleImageList(contentResolver, uri);
        }
        boolean a = m10275a(false);
        ArrayList arrayList = new ArrayList();
        if (!(!a || dataLocation == DataLocation.INTERNAL || (i & 1) == 0)) {
            arrayList.add(new ImageList(contentResolver, f9684d, f9685e, i2, str));
        }
        if ((dataLocation == DataLocation.INTERNAL || dataLocation == DataLocation.ALL) && (i & 1) != 0) {
            arrayList.add(new ImageList(contentResolver, Media.INTERNAL_CONTENT_URI, Thumbnails.INTERNAL_CONTENT_URI, i2, str));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object obj;
            BaseImageList baseImageList = (BaseImageList) it.next();
            if (baseImageList.mo388b() == 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                baseImageList.mo387a();
                it.remove();
            }
        }
        if (arrayList.size() == 1) {
            return (BaseImageList) arrayList.get(0);
        }
        return new ImageListUber((IImageList[]) arrayList.toArray(new IImageList[arrayList.size()]), i2);
    }

    public static IImageList m10272a(ContentResolver contentResolver, DataLocation dataLocation, int i, int i2, String str) {
        ImageListParam imageListParam = new ImageListParam();
        imageListParam.f9675a = dataLocation;
        imageListParam.f9676b = i;
        imageListParam.f9677c = i2;
        imageListParam.f9678d = str;
        return m10273a(contentResolver, imageListParam);
    }

    private static boolean m10277b() {
        String str = Environment.getExternalStorageDirectory().toString() + "/DCIM";
        File file = new File(str);
        if (!file.isDirectory() && !file.mkdirs()) {
            return false;
        }
        file = new File(str, ".probe");
        try {
            if (file.exists()) {
                file.delete();
            }
            if (!file.createNewFile()) {
                return false;
            }
            file.delete();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean m10274a() {
        return m10275a(true);
    }

    private static boolean m10275a(boolean z) {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            if (z) {
                return m10277b();
            }
            return true;
        } else if (z || !"mounted_ro".equals(externalStorageState)) {
            return false;
        } else {
            return true;
        }
    }
}
