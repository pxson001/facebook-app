package com.facebook.ui.images.fetch;

import com.facebook.bitmaps.WebpTranscoder;
import com.facebook.bitmaps.WebpTranscoder.1;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.google.common.io.ByteStreams;
import com.google.common.io.CountingInputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Inject;

/* compiled from: recentPrivacyOption */
public class ImageWriter {
    private static final String f12931a = ImageWriter.class.getName();
    private final Lazy<WebpTranscoder> f12932b;
    private final AbstractFbErrorReporter f12933c;

    /* compiled from: recentPrivacyOption */
    /* synthetic */ class C01721 {
        static final /* synthetic */ int[] f3665a = new int[ImageFormat.values().length];

        static {
            try {
                f3665a[ImageFormat.WEBP_SIMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3665a[ImageFormat.WEBP_LOSSLESS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3665a[ImageFormat.WEBP_EXTENDED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3665a[ImageFormat.WEBP_EXTENDED_WITH_ALPHA.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static ImageWriter m13829b(InjectorLike injectorLike) {
        return new ImageWriter(IdBasedSingletonScopeProvider.b(injectorLike, 4982), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public ImageWriter(Lazy<WebpTranscoder> lazy, FbErrorReporter fbErrorReporter) {
        this.f12932b = lazy;
        this.f12933c = fbErrorReporter;
    }

    public final void m13831a(InputStream inputStream, OutputStream outputStream) {
        InputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192);
        if (m13828a(ImageFormatChecker.a(bufferedInputStream))) {
            InputStream countingInputStream = new CountingInputStream(bufferedInputStream);
            OutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            try {
                m13830b(countingInputStream, bufferedOutputStream);
            } finally {
                bufferedOutputStream.flush();
            }
        } else {
            ByteStreams.m11949a(bufferedInputStream, outputStream);
        }
    }

    private boolean m13828a(ImageFormat imageFormat) {
        switch (C01721.f3665a[imageFormat.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                this.f12932b.get();
                boolean z = false;
                switch (1.a[imageFormat.ordinal()]) {
                    case 2:
                    case 3:
                    case 4:
                        if (!WebpSupportStatus.c) {
                            z = true;
                            break;
                        }
                        break;
                }
                return z;
            default:
                return false;
        }
    }

    private void m13830b(InputStream inputStream, OutputStream outputStream) {
        try {
            m13827a().a(inputStream, outputStream, 80);
        } catch (Throwable e) {
            LibraryNotLoadedException libraryNotLoadedException = new LibraryNotLoadedException(this, "NativeImageLibraries reports loaded but fails!");
            libraryNotLoadedException.initCause(e);
            this.f12933c.a(f12931a, "Transcode without library", libraryNotLoadedException);
            throw libraryNotLoadedException;
        }
    }

    private WebpTranscoder m13827a() {
        WebpTranscoder webpTranscoder = (WebpTranscoder) this.f12932b.get();
        if (webpTranscoder.b) {
            return webpTranscoder;
        }
        LibraryNotLoadedException libraryNotLoadedException = new LibraryNotLoadedException(this, "NativeImageLibrary not loaded for webp transcoding!");
        if (this.f12933c != null) {
            this.f12933c.a(f12931a, libraryNotLoadedException.getMessage(), libraryNotLoadedException);
        }
        throw libraryNotLoadedException;
    }
}
