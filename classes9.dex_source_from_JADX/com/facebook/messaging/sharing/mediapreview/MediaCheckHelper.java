package com.facebook.messaging.sharing.mediapreview;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.webkit.MimeTypeMap;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.dextricks.DalvikInternals;
import com.facebook.common.dextricks.DalvikInternals.Stat;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.common.util.UriUtil;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.media.attachments.MediaMimeTypeMap;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.ui.media.attachments.MediaResourceHelper;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: composerAppAttribution.appId */
public class MediaCheckHelper {
    private static final Class<?> f17401a = MediaCheckHelper.class;
    private final ContentResolver f17402b;
    public final ListeningExecutorService f17403c;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MediaMimeTypeMap> f17404d = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MediaResourceHelper> f17405e = UltralightRuntime.b;
    private final TempFileManager f17406f;
    private final AnalyticsLogger f17407g;

    /* compiled from: composerAppAttribution.appId */
    public class C20692 implements Callable<List<MediaResource>> {
        final /* synthetic */ List f17399a;
        final /* synthetic */ MediaCheckHelper f17400b;

        public C20692(MediaCheckHelper mediaCheckHelper, List list) {
            this.f17400b = mediaCheckHelper;
            this.f17399a = list;
        }

        public Object call() {
            return ((MediaResourceHelper) this.f17400b.f17405e.get()).b(this.f17399a);
        }
    }

    public static MediaCheckHelper m17375b(InjectorLike injectorLike) {
        MediaCheckHelper mediaCheckHelper = new MediaCheckHelper(ContentResolverMethodAutoProvider.b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), TempFileManager.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 3572);
        com.facebook.inject.Lazy b2 = IdBasedSingletonScopeProvider.b(injectorLike, 3573);
        mediaCheckHelper.f17404d = b;
        mediaCheckHelper.f17405e = b2;
        return mediaCheckHelper;
    }

    @Inject
    public MediaCheckHelper(ContentResolver contentResolver, ListeningExecutorService listeningExecutorService, TempFileManager tempFileManager, AnalyticsLogger analyticsLogger) {
        this.f17402b = contentResolver;
        this.f17403c = listeningExecutorService;
        this.f17406f = tempFileManager;
        this.f17407g = analyticsLogger;
    }

    public final ListenableFuture<List<MediaResource>> m17378a(final List<MediaResource> list) {
        return this.f17403c.a(new Callable<List<MediaResource>>(this) {
            final /* synthetic */ MediaCheckHelper f17398b;

            /* compiled from: composerAppAttribution.appId */
            class C20671 implements Function<MediaResource, MediaResource> {
                final /* synthetic */ C20681 f17396a;

                C20671(C20681 c20681) {
                    this.f17396a = c20681;
                }

                public Object apply(Object obj) {
                    try {
                        return MediaCheckHelper.m17374a(this.f17396a.f17398b, (MediaResource) obj);
                    } catch (Throwable e) {
                        throw Throwables.propagate(e);
                    }
                }
            }

            public Object call() {
                return Lists.a(Iterables.a(list, new C20671(this)));
            }
        });
    }

    public static MediaResource m17374a(MediaCheckHelper mediaCheckHelper, MediaResource mediaResource) {
        InputStream openInputStream;
        Throwable th;
        ParcelFileDescriptor parcelFileDescriptor = null;
        boolean z = false;
        Uri uri = mediaResource.c;
        try {
            String a;
            String str;
            if ("android.resource".equals(uri.getScheme())) {
                a = ((MediaMimeTypeMap) mediaCheckHelper.f17404d.get()).a(mediaResource.o);
                openInputStream = mediaCheckHelper.f17402b.openInputStream(uri);
                str = a;
                a = mediaResource.o;
                z = true;
            } else if (UriUtil.c(uri)) {
                a = mediaCheckHelper.f17402b.getType(uri);
                if (a != null) {
                    z = true;
                }
                Preconditions.checkState(z, "Unable to get mime type for %s", new Object[]{uri});
                String a2 = ((MediaMimeTypeMap) mediaCheckHelper.f17404d.get()).a(a);
                openInputStream = mediaCheckHelper.f17402b.openInputStream(uri);
                str = a2;
                z = true;
            } else if (UriUtil.b(uri)) {
                String a3;
                str = mediaCheckHelper.f17402b.getType(uri);
                if (str != null) {
                    a3 = ((MediaMimeTypeMap) mediaCheckHelper.f17404d.get()).a(str);
                } else {
                    a3 = MimeTypeMap.getFileExtensionFromUrl(uri.toString());
                }
                ParcelFileDescriptor openFileDescriptor = mediaCheckHelper.f17402b.openFileDescriptor(uri, "r");
                try {
                    if (Process.myUid() == m17372a(openFileDescriptor)) {
                        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("security_error");
                        honeyClientEvent.b("uri", uri.toString());
                        honeyClientEvent.b("canonicalPath", new File(uri.getPath()).getCanonicalPath());
                        mediaCheckHelper.f17407g.c(honeyClientEvent);
                        throw new IllegalArgumentException("unable to read: " + uri);
                    }
                    InputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                    try {
                        z = m17376b(openFileDescriptor);
                        parcelFileDescriptor = openFileDescriptor;
                        openInputStream = fileInputStream;
                        a = str;
                        str = a3;
                    } catch (Throwable th2) {
                        th = th2;
                        parcelFileDescriptor = openFileDescriptor;
                        openInputStream = fileInputStream;
                        if (openInputStream != null) {
                            openInputStream.close();
                        }
                        if (parcelFileDescriptor != null) {
                            parcelFileDescriptor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    ParcelFileDescriptor parcelFileDescriptor2 = openFileDescriptor;
                    openInputStream = null;
                    parcelFileDescriptor = parcelFileDescriptor2;
                    if (openInputStream != null) {
                        openInputStream.close();
                    }
                    if (parcelFileDescriptor != null) {
                        parcelFileDescriptor.close();
                    }
                    throw th;
                }
            } else {
                throw new IllegalArgumentException("Uri must be a content, resource, or file uri");
            }
            try {
                if (Strings.isNullOrEmpty(str)) {
                    throw new IllegalArgumentException("Unable to find extension for " + mediaResource.c);
                }
                File a4 = mediaCheckHelper.f17406f.a("orca_share_media", "." + str, m17373a(z, a));
                if (a4 == null) {
                    throw new IOException("Failed to create temp file");
                }
                Files.a(a4, new FileWriteMode[0]).a(openInputStream);
                MediaResource C = new MediaResourceBuilder().a(mediaResource).a(Uri.fromFile(a4)).C();
                if (openInputStream != null) {
                    openInputStream.close();
                }
                if (parcelFileDescriptor != null) {
                    parcelFileDescriptor.close();
                }
                return C;
            } catch (Throwable th4) {
                th = th4;
                if (openInputStream != null) {
                    openInputStream.close();
                }
                if (parcelFileDescriptor != null) {
                    parcelFileDescriptor.close();
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            openInputStream = null;
            if (openInputStream != null) {
                openInputStream.close();
            }
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }
            throw th;
        }
    }

    private static int m17372a(ParcelFileDescriptor parcelFileDescriptor) {
        Stat stat = new Stat();
        try {
            DalvikInternals.statOpenFile(parcelFileDescriptor.getFd(), stat);
            return stat.ownerUid;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean m17376b(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            Stat stat = new Stat();
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory == null) {
                return false;
            }
            DalvikInternals.statNamedFile(externalStorageDirectory.getAbsolutePath(), stat);
            long j = stat.device;
            DalvikInternals.statOpenFile(parcelFileDescriptor.getFd(), stat);
            if (stat.device == j) {
                return true;
            }
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    private static Privacy m17373a(boolean z, String str) {
        if (!z) {
            return Privacy.REQUIRE_PRIVATE;
        }
        if (str == null) {
            return Privacy.REQUIRE_PRIVATE;
        }
        if (str.startsWith("image/") || str.startsWith("video/") || str.startsWith("audio/")) {
            return Privacy.PREFER_SDCARD;
        }
        return Privacy.REQUIRE_PRIVATE;
    }

    @Nullable
    public final MediaResourceBuilder m17377a(Uri uri, @Nullable Uri uri2, @Nullable String str) {
        String str2;
        Type type;
        if ("android.resource".equals(uri.getScheme())) {
            String str3 = null;
            if (str != null) {
                if (((MediaMimeTypeMap) this.f17404d.get()).a(str) != null) {
                    str3 = str;
                } else {
                    String str4 = str.startsWith("image") ? "image/*" : str.startsWith("video") ? "video/*" : str.startsWith("audio") ? "audio/*" : null;
                    str3 = str4;
                }
            }
            str2 = str3;
        } else {
            str2 = ((MediaResourceHelper) this.f17405e.get()).a(uri);
        }
        String nullToEmpty = Strings.nullToEmpty(str2);
        if (nullToEmpty.startsWith("image")) {
            type = Type.PHOTO;
        } else if (nullToEmpty.startsWith("video")) {
            type = Type.VIDEO;
        } else if (nullToEmpty.startsWith("audio")) {
            type = Type.AUDIO;
        } else {
            type = Type.OTHER;
        }
        MediaResourceBuilder a = MediaResource.a();
        a.b = type;
        MediaResourceBuilder mediaResourceBuilder = a;
        mediaResourceBuilder.a = uri;
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.m = nullToEmpty;
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.c = Source.SHARE;
        mediaResourceBuilder = mediaResourceBuilder;
        mediaResourceBuilder.w = uri2;
        return mediaResourceBuilder;
    }
}
