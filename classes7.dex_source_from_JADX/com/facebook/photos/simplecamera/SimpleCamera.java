package com.facebook.photos.simplecamera;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.UriUtil;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.simplecamera.SimpleCameraCallback;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.MediaItemFactory.FallbackMediaId;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: intro_cards_fav_photos_post_to_feed_dismissed */
public class SimpleCamera {
    public static final String f10897a = SimpleCamera.class.getName();
    private static final String[] f10898b = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
    private final MediaItemFactory f10899c;
    public final Context f10900d;
    @DefaultExecutorService
    private final ExecutorService f10901e;
    @ForUiThread
    private final ExecutorService f10902f;
    @Nullable
    public Uri f10903g;
    public Lazy<FbErrorReporter> f10904h;

    /* compiled from: intro_cards_fav_photos_post_to_feed_dismissed */
    public enum CameraType {
        IMAGE,
        VIDEO
    }

    public static SimpleCamera m12921b(InjectorLike injectorLike) {
        return new SimpleCamera(MediaItemFactory.b(injectorLike), (Context) injectorLike.getInstance(Context.class), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public SimpleCamera(MediaItemFactory mediaItemFactory, Context context, ExecutorService executorService, ExecutorService executorService2, Lazy<FbErrorReporter> lazy) {
        this.f10899c = mediaItemFactory;
        this.f10900d = context;
        this.f10901e = executorService;
        this.f10902f = executorService2;
        this.f10904h = lazy;
    }

    public static CameraType m12919a(int i) {
        switch (i) {
            case 2002:
                return CameraType.IMAGE;
            case 2003:
                return CameraType.VIDEO;
            default:
                throw new IllegalStateException("unknown request code");
        }
    }

    public final Intent m12924b(CameraType cameraType) {
        Intent intent;
        switch (cameraType) {
            case VIDEO:
                intent = new Intent("android.media.action.VIDEO_CAPTURE");
                this.f10903g = null;
                break;
            case IMAGE:
                Uri fromFile;
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Facebook");
                if (file.exists() || file.mkdirs()) {
                    fromFile = Uri.fromFile(new File(file, StringFormatUtil.formatStrLocaleSafe("FB_IMG_%d.jpg", Long.valueOf(new Date().getTime()))));
                } else {
                    ((AbstractFbErrorReporter) this.f10904h.get()).a(f10897a, "Can not create directory to store new photos");
                    fromFile = null;
                }
                this.f10903g = fromFile;
                intent.putExtra("output", this.f10903g);
                break;
            default:
                throw new IllegalStateException("Invalid camera type");
        }
        intent.setFlags(3);
        return intent;
    }

    public final void m12923a(final CameraType cameraType, @Nullable final Intent intent, final SimpleCameraCallback simpleCameraCallback) {
        ExecutorDetour.a(this.f10901e, new Runnable(this) {
            final /* synthetic */ SimpleCamera f10890d;

            /* compiled from: intro_cards_fav_photos_post_to_feed_dismissed */
            class C09371 implements OnScanCompletedListener {
                final /* synthetic */ C09381 f10886a;

                C09371(C09381 c09381) {
                    this.f10886a = c09381;
                }

                public void onScanCompleted(String str, Uri uri) {
                    if (uri != null) {
                        SimpleCamera.m12920a(this.f10886a.f10890d, uri, simpleCameraCallback);
                    }
                }
            }

            public void run() {
                Uri a = SimpleCamera.m12918a(this.f10890d, cameraType, intent);
                if (a != null) {
                    if (UriUtil.b(a)) {
                        MediaScannerConnection.scanFile(this.f10890d.f10900d, new String[]{a.getPath()}, null, new C09371(this));
                        return;
                    }
                    SimpleCamera.m12920a(this.f10890d, a, simpleCameraCallback);
                }
            }
        }, 615265551);
    }

    public static void m12920a(SimpleCamera simpleCamera, Uri uri, final SimpleCameraCallback simpleCameraCallback) {
        final MediaItem a = simpleCamera.f10899c.a(uri, FallbackMediaId.SINGLE_SHOT_CAMERA);
        if (a != null) {
            ExecutorDetour.a(simpleCamera.f10902f, new Runnable(simpleCamera) {
                final /* synthetic */ SimpleCamera f10893c;

                public void run() {
                    simpleCameraCallback.mo201a(ImmutableList.of(a), false);
                }
            }, 972736373);
        }
    }

    @Nullable
    public static Uri m12918a(SimpleCamera simpleCamera, @Nullable CameraType cameraType, Intent intent) {
        if (cameraType == CameraType.VIDEO) {
            if (intent != null) {
                return intent.getData();
            }
            return null;
        } else if (simpleCamera.f10903g == null) {
            return null;
        } else {
            File c = simpleCamera.m12922c();
            if (c != null) {
                String path = simpleCamera.f10903g.getPath();
                final File file = new File(path);
                if (!StringUtil.a(c.getAbsolutePath(), path)) {
                    try {
                        if (Files.b(c, file)) {
                            ExecutorDetour.a(simpleCamera.f10901e, new Runnable(simpleCamera) {
                                final /* synthetic */ SimpleCamera f10895b;

                                public void run() {
                                    file.delete();
                                }
                            }, 1259424716);
                            return Uri.fromFile(c);
                        }
                    } catch (IOException e) {
                    }
                }
            }
            return simpleCamera.f10903g;
        }
    }

    @Nullable
    private File m12922c() {
        Cursor cursor;
        Throwable th;
        Cursor query;
        try {
            query = this.f10900d.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data"}, null, null, "_id DESC LIMIT 1");
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        if (query.moveToFirst()) {
                            File file = new File(query.getString(1));
                            if (query == null) {
                                return file;
                            }
                            query.close();
                            return file;
                        }
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    }
                } catch (SQLiteException e) {
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (SQLiteException e2) {
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }
}
