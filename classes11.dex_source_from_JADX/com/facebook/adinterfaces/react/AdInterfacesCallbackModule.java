package com.facebook.adinterfaces.react;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.fbreact.fragment.ImmersiveReactFragmentHooks;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: meta_text */
public class AdInterfacesCallbackModule extends ReactContextBaseJavaModule {
    private static final CallerContext f5416a = CallerContext.a(AdInterfacesCallbackModule.class);
    public final ImmersiveReactFragmentHooks f5417b;
    private final ExecutorService f5418c;
    private final ImagePipeline f5419d;
    private DataSource<CloseableReference<CloseableImage>> f5420e;

    @Inject
    public AdInterfacesCallbackModule(@Assisted ReactApplicationContext reactApplicationContext, ExecutorService executorService, ImmersiveReactFragmentHooks immersiveReactFragmentHooks, ImagePipeline imagePipeline) {
        super(reactApplicationContext);
        this.f5418c = executorService;
        this.f5417b = immersiveReactFragmentHooks;
        this.f5419d = imagePipeline;
    }

    public String getName() {
        return "AdInterfacesModule";
    }

    @ReactMethod
    public void onImageSelected(@Nullable ReadableMap readableMap) {
        if (readableMap == null) {
            this.f5417b.a();
            return;
        }
        String string = readableMap.b("imageSource").getString("uri");
        if (string == null) {
            this.f5417b.a();
            return;
        }
        ImageRequest a = ImageRequest.a(Uri.parse(string));
        ReadableMap b = readableMap.b("transformData");
        ReadableMap b2 = b.b("offset");
        final int i = b.b("size").getInt("width");
        final int i2 = b.b("size").getInt("height");
        final int i3 = b2.getInt("x");
        final int i4 = b2.getInt("y");
        this.f5420e = this.f5419d.c(a, f5416a);
        this.f5420e.a(new BaseDataSubscriber<CloseableReference<CloseableImage>>(this) {
            final /* synthetic */ AdInterfacesCallbackModule f5415e;

            public final void m6639e(DataSource<CloseableReference<CloseableImage>> dataSource) {
                int i = 0;
                if (dataSource.b()) {
                    int i2;
                    Bitmap bitmap;
                    CloseableReference closeableReference = (CloseableReference) dataSource.d();
                    CloseableImage closeableImage = (CloseableImage) closeableReference.a();
                    if (closeableReference == null || !(closeableImage instanceof CloseableBitmap)) {
                        i2 = 0;
                        bitmap = null;
                    } else {
                        if (closeableImage instanceof CloseableStaticBitmap) {
                            i = ((CloseableStaticBitmap) closeableImage).h();
                        }
                        i2 = i;
                        bitmap = ((CloseableBitmap) closeableImage).a();
                    }
                    if (bitmap == null) {
                        try {
                            this.f5415e.f5417b.a();
                        } finally {
                            CloseableReference.c(closeableReference);
                        }
                    } else {
                        this.f5415e.m6642a(bitmap, i3, i4, Math.min(i, bitmap.getWidth() - i3), Math.min(i2, bitmap.getHeight() - i4), i2);
                        CloseableReference.c(closeableReference);
                    }
                }
            }

            protected final void m6640f(DataSource<CloseableReference<CloseableImage>> dataSource) {
                this.f5415e.f5417b.a();
            }
        }, this.f5418c);
    }

    private void m6642a(Bitmap bitmap, int i, int i2, int i3, int i4, int i5) {
        Bitmap createBitmap;
        Throwable th;
        Bitmap bitmap2 = null;
        try {
            Matrix matrix = new Matrix();
            matrix.setRotate((float) i5);
            createBitmap = Bitmap.createBitmap(bitmap, i, i2, i3, i4, matrix, false);
            try {
                File createTempFile = File.createTempFile("upload", ".jpeg");
                OutputStream fileOutputStream = new FileOutputStream(createTempFile);
                createBitmap.compress(CompressFormat.JPEG, 85, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                if (!(createBitmap == null || createBitmap.isRecycled())) {
                    createBitmap.recycle();
                }
                if (!(q() == null || createTempFile == null)) {
                    Intent intent = new Intent();
                    intent.putExtra("file_path", createTempFile.getAbsolutePath());
                    q().setResult(-1, intent);
                }
                this.f5417b.a();
            } catch (IOException e) {
                try {
                    this.f5417b.a();
                    if (createBitmap != null && !createBitmap.isRecycled()) {
                        createBitmap.recycle();
                    }
                } catch (Throwable th2) {
                    bitmap2 = createBitmap;
                    th = th2;
                    bitmap2.recycle();
                    throw th;
                }
            } catch (OutOfMemoryError e2) {
                this.f5417b.a();
                if (createBitmap != null && !createBitmap.isRecycled()) {
                    createBitmap.recycle();
                }
            }
        } catch (IOException e3) {
            createBitmap = null;
            this.f5417b.a();
            if (createBitmap != null) {
            }
        } catch (OutOfMemoryError e4) {
            createBitmap = null;
            this.f5417b.a();
            if (createBitmap != null) {
            }
        } catch (Throwable th3) {
            th = th3;
            if (!(bitmap2 == null || bitmap2.isRecycled())) {
                bitmap2.recycle();
            }
            throw th;
        }
    }
}
