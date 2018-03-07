package com.facebook.react.modules.camera;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: SIZE_60 */
public class CameraRollManager extends ReactContextBaseJavaModule {
    public static final boolean f11394a;
    public static final String[] f11395b;

    /* compiled from: SIZE_60 */
    class GetPhotosTask extends GuardedAsyncTask<Void, Void> {
        private final Context f11384a;
        private final int f11385b;
        @Nullable
        private final String f11386c;
        @Nullable
        private final String f11387d;
        @Nullable
        private final ReadableArray f11388e;
        private final Promise f11389f;

        private GetPhotosTask(ReactContext reactContext, int i, @Nullable String str, @Nullable String str2, @Nullable ReadableArray readableArray, Promise promise) {
            super(reactContext);
            this.f11384a = reactContext;
            this.f11385b = i;
            this.f11386c = str;
            this.f11387d = str2;
            this.f11388e = readableArray;
            this.f11389f = promise;
        }

        protected final void m11723a(Object[] objArr) {
            StringBuilder stringBuilder = new StringBuilder("1");
            List arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.f11386c)) {
                stringBuilder.append(" AND datetaken < ?");
                arrayList.add(this.f11386c);
            }
            if (!TextUtils.isEmpty(this.f11387d)) {
                stringBuilder.append(" AND bucket_display_name = ?");
                arrayList.add(this.f11387d);
            }
            if (this.f11388e != null && this.f11388e.size() > 0) {
                stringBuilder.append(" AND mime_type IN (");
                for (int i = 0; i < this.f11388e.size(); i++) {
                    stringBuilder.append("?,");
                    arrayList.add(this.f11388e.getString(i));
                }
                stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), ")");
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            ContentResolver contentResolver = this.f11384a.getContentResolver();
            try {
                Cursor query = contentResolver.query(Media.EXTERNAL_CONTENT_URI, CameraRollManager.f11395b, stringBuilder.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), "datetaken DESC, date_modified DESC LIMIT " + (this.f11385b + 1));
                if (query == null) {
                    this.f11389f.a("E_UNABLE_TO_LOAD", "Could not get photos");
                    return;
                }
                try {
                    CameraRollManager.m11731b(contentResolver, query, writableNativeMap, this.f11385b);
                    CameraRollManager.m11732b(query, writableNativeMap, this.f11385b);
                } finally {
                    query.close();
                    this.f11389f.a(writableNativeMap);
                }
            } catch (SecurityException e) {
                this.f11389f.b("E_UNABLE_TO_LOAD_PERMISSION", "Could not get photos: need READ_EXTERNAL_STORAGE permission");
            }
        }
    }

    /* compiled from: SIZE_60 */
    class SaveImageTag extends GuardedAsyncTask<Void, Void> {
        private final Context f11391a;
        private final Uri f11392b;
        public final Promise f11393c;

        /* compiled from: SIZE_60 */
        class C13821 implements OnScanCompletedListener {
            final /* synthetic */ SaveImageTag f11390a;

            C13821(SaveImageTag saveImageTag) {
                this.f11390a = saveImageTag;
            }

            public void onScanCompleted(String str, Uri uri) {
                if (uri != null) {
                    this.f11390a.f11393c.a(uri.toString());
                } else {
                    this.f11390a.f11393c.a("E_UNABLE_TO_SAVE", "Could not add image to gallery");
                }
            }
        }

        protected final void m11725a(Object[] objArr) {
            Throwable e;
            Throwable th;
            FileChannel fileChannel = null;
            File file = new File(this.f11392b.getPath());
            FileChannel channel;
            try {
                File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                externalStoragePublicDirectory.mkdirs();
                if (externalStoragePublicDirectory.isDirectory()) {
                    String substring;
                    String substring2;
                    int i;
                    File file2;
                    FileChannel channel2;
                    File file3 = new File(externalStoragePublicDirectory, file.getName());
                    String name = file.getName();
                    if (name.indexOf(46) >= 0) {
                        substring = name.substring(0, name.lastIndexOf(46));
                        substring2 = name.substring(name.lastIndexOf(46));
                        i = 0;
                        file2 = file3;
                    } else {
                        substring2 = "";
                        substring = name;
                        file2 = file3;
                        i = 0;
                    }
                    while (!file2.createNewFile()) {
                        StringBuilder append = new StringBuilder().append(substring).append("_");
                        int i2 = i + 1;
                        file3 = new File(externalStoragePublicDirectory, append.append(i).append(substring2).toString());
                        i = i2;
                        file2 = file3;
                    }
                    channel = new FileInputStream(file).getChannel();
                    try {
                        channel2 = new FileOutputStream(file2).getChannel();
                    } catch (IOException e2) {
                        e = e2;
                        fileChannel = channel;
                        channel = null;
                        try {
                            this.f11393c.a(e);
                            try {
                                fileChannel.close();
                            } catch (Throwable e3) {
                                FLog.b("React", "Could not close input channel", e3);
                            }
                            if (channel != null) {
                                return;
                            }
                        } catch (Throwable th2) {
                            e3 = th2;
                            FileChannel fileChannel2 = channel;
                            channel = fileChannel;
                            fileChannel = fileChannel2;
                            try {
                                channel.close();
                            } catch (Throwable e4) {
                                FLog.b("React", "Could not close input channel", e4);
                            }
                            try {
                                fileChannel.close();
                            } catch (Throwable e42) {
                                FLog.b("React", "Could not close output channel", e42);
                            }
                            throw e3;
                        }
                    } catch (Throwable th3) {
                        e3 = th3;
                        channel.close();
                        fileChannel.close();
                        throw e3;
                    }
                    try {
                        channel2.transferFrom(channel, 0, channel.size());
                        channel.close();
                        channel2.close();
                        MediaScannerConnection.scanFile(this.f11391a, new String[]{file2.getAbsolutePath()}, null, new C13821(this));
                        if (channel != null && channel.isOpen()) {
                            try {
                                channel.close();
                            } catch (Throwable e422) {
                                FLog.b("React", "Could not close input channel", e422);
                            }
                        }
                        if (channel2 != null && channel2.isOpen()) {
                            try {
                                channel2.close();
                                return;
                            } catch (Throwable e32) {
                                FLog.b("React", "Could not close output channel", e32);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable e5) {
                        th = e5;
                        fileChannel = channel;
                        channel = channel2;
                        e32 = th;
                        this.f11393c.a(e32);
                        fileChannel.close();
                        if (channel != null) {
                        }
                        return;
                    } catch (Throwable e52) {
                        th = e52;
                        fileChannel = channel2;
                        e32 = th;
                        channel.close();
                        fileChannel.close();
                        throw e32;
                    }
                }
                this.f11393c.a("E_UNABLE_TO_LOAD", "External storage pictures directory not available");
            } catch (IOException e6) {
                e32 = e6;
                channel = null;
                this.f11393c.a(e32);
                if (fileChannel != null && fileChannel.isOpen()) {
                    fileChannel.close();
                }
                if (channel != null && channel.isOpen()) {
                    try {
                        channel.close();
                    } catch (Throwable e322) {
                        FLog.b("React", "Could not close output channel", e322);
                    }
                }
            } catch (Throwable th4) {
                e322 = th4;
                channel = null;
                if (channel != null && channel.isOpen()) {
                    channel.close();
                }
                if (fileChannel != null && fileChannel.isOpen()) {
                    fileChannel.close();
                }
                throw e322;
            }
        }

        public SaveImageTag(ReactContext reactContext, Uri uri, Promise promise) {
            super(reactContext);
            this.f11391a = reactContext;
            this.f11392b = uri;
            this.f11393c = promise;
        }
    }

    static {
        boolean z = VERSION.SDK_INT >= 16;
        f11394a = z;
        if (z) {
            f11395b = new String[]{"_id", "mime_type", "bucket_display_name", "datetaken", "width", "height", "longitude", "latitude"};
        } else {
            f11395b = new String[]{"_id", "mime_type", "bucket_display_name", "datetaken", "longitude", "latitude"};
        }
    }

    public CameraRollManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return "RKCameraRollManager";
    }

    public final Map<String, Object> m11734a() {
        return Collections.emptyMap();
    }

    @ReactMethod
    public void saveImageWithTag(String str, Promise promise) {
        new SaveImageTag(this.a, Uri.parse(str), promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getPhotos(ReadableMap readableMap, Promise promise) {
        String string;
        ReadableArray a;
        int i = readableMap.getInt("first");
        String string2 = readableMap.hasKey("after") ? readableMap.getString("after") : null;
        if (readableMap.hasKey("groupName")) {
            string = readableMap.getString("groupName");
        } else {
            string = null;
        }
        if (readableMap.hasKey("mimeTypes")) {
            a = readableMap.a("mimeTypes");
        } else {
            a = null;
        }
        if (readableMap.hasKey("groupTypes")) {
            throw new JSApplicationIllegalArgumentException("groupTypes is not supported on Android");
        }
        new GetPhotosTask(this.a, i, string2, string, a, promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static void m11732b(Cursor cursor, WritableMap writableMap, int i) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("has_next_page", i < cursor.getCount());
        if (i < cursor.getCount()) {
            cursor.moveToPosition(i - 1);
            writableNativeMap.putString("end_cursor", cursor.getString(cursor.getColumnIndex("datetaken")));
        }
        writableMap.a("page_info", writableNativeMap);
    }

    public static void m11731b(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i) {
        int columnIndex;
        int columnIndex2;
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        cursor.moveToFirst();
        int columnIndex3 = cursor.getColumnIndex("_id");
        int columnIndex4 = cursor.getColumnIndex("mime_type");
        int columnIndex5 = cursor.getColumnIndex("bucket_display_name");
        int columnIndex6 = cursor.getColumnIndex("datetaken");
        if (f11394a) {
            columnIndex = cursor.getColumnIndex("width");
        } else {
            columnIndex = -1;
        }
        if (f11394a) {
            columnIndex2 = cursor.getColumnIndex("height");
        } else {
            columnIndex2 = -1;
        }
        int columnIndex7 = cursor.getColumnIndex("longitude");
        int columnIndex8 = cursor.getColumnIndex("latitude");
        int i2 = 0;
        while (i2 < i && !cursor.isAfterLast()) {
            int i3;
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            WritableMap writableNativeMap2 = new WritableNativeMap();
            if (m11730a(contentResolver, cursor, writableNativeMap2, columnIndex3, columnIndex, columnIndex2)) {
                m11729a(cursor, writableNativeMap2, columnIndex4, columnIndex5, columnIndex6);
                m11728a(cursor, writableNativeMap2, columnIndex7, columnIndex8);
                writableNativeMap.a("node", writableNativeMap2);
                writableNativeArray.a(writableNativeMap);
                i3 = i2;
            } else {
                i3 = i2 - 1;
            }
            cursor.moveToNext();
            i2 = i3 + 1;
        }
        writableMap.a("edges", writableNativeArray);
    }

    private static void m11729a(Cursor cursor, WritableMap writableMap, int i, int i2, int i3) {
        writableMap.putString("type", cursor.getString(i));
        writableMap.putString("group_name", cursor.getString(i2));
        writableMap.putDouble("timestamp", ((double) cursor.getLong(i3)) / 1000.0d);
    }

    private static boolean m11730a(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i, int i2, int i3) {
        float f;
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        Uri withAppendedPath = Uri.withAppendedPath(Media.EXTERNAL_CONTENT_URI, cursor.getString(i));
        writableNativeMap.putString("uri", withAppendedPath.toString());
        float f2 = -1.0f;
        if (f11394a) {
            f2 = (float) cursor.getInt(i2);
            f = (float) cursor.getInt(i3);
        } else {
            f = 0.0f;
        }
        if (f2 <= 0.0f || r0 <= 0.0f) {
            try {
                AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(withAppendedPath, "r");
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFileDescriptor(openAssetFileDescriptor.getFileDescriptor(), null, options);
                openAssetFileDescriptor.close();
                f2 = (float) options.outWidth;
                f = (float) options.outHeight;
            } catch (Throwable e) {
                FLog.b("React", "Could not get width/height for " + withAppendedPath.toString(), e);
                return false;
            }
        }
        writableNativeMap.putDouble("width", (double) f2);
        writableNativeMap.putDouble("height", (double) f);
        writableMap.a("image", writableNativeMap);
        return true;
    }

    private static void m11728a(Cursor cursor, WritableMap writableMap, int i, int i2) {
        double d = cursor.getDouble(i);
        double d2 = cursor.getDouble(i2);
        if (d > 0.0d || d2 > 0.0d) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble("longitude", d);
            writableNativeMap.putDouble("latitude", d2);
            writableMap.a("location", writableNativeMap);
        }
    }
}
