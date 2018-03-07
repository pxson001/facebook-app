package com.facebook.catalyst.shadow.flat;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Assertions;
import javax.annotation.Nullable;

/* compiled from: location_lightweight_picker_sprout */
public final class PipelineRequestHelper implements DataSubscriber<CloseableReference<CloseableImage>> {
    public final ImageRequest f5779a;
    @Nullable
    public BitmapUpdateListener f5780b;
    @Nullable
    public DataSource<CloseableReference<CloseableImage>> f5781c;
    @Nullable
    public CloseableReference<CloseableImage> f5782d;
    public int f5783e;

    public PipelineRequestHelper(ImageRequest imageRequest) {
        this.f5779a = imageRequest;
    }

    @Nullable
    public final Bitmap m7110b() {
        if (this.f5782d == null) {
            return null;
        }
        CloseableImage closeableImage = (CloseableImage) this.f5782d.a();
        if (closeableImage instanceof CloseableBitmap) {
            return ((CloseableBitmap) closeableImage).a();
        }
        this.f5782d.close();
        this.f5782d = null;
        return null;
    }

    public final void m7109a(DataSource<CloseableReference<CloseableImage>> dataSource) {
        if (dataSource.b()) {
            try {
                if (this.f5781c == dataSource) {
                    this.f5781c = null;
                    CloseableReference closeableReference = (CloseableReference) dataSource.d();
                    if (closeableReference == null) {
                        dataSource.g();
                    } else if (((CloseableImage) closeableReference.a()) instanceof CloseableBitmap) {
                        this.f5782d = closeableReference;
                        if (m7110b() == null) {
                            dataSource.g();
                            return;
                        }
                        ((BitmapUpdateListener) Assertions.a(this.f5780b)).mo160c();
                        dataSource.g();
                    } else {
                        closeableReference.close();
                        dataSource.g();
                    }
                }
            } finally {
                dataSource.g();
            }
        }
    }

    public final void m7111b(DataSource<CloseableReference<CloseableImage>> dataSource) {
        if (this.f5781c == dataSource) {
            this.f5781c = null;
        }
        dataSource.g();
    }

    public final void m7112c(DataSource<CloseableReference<CloseableImage>> dataSource) {
        if (this.f5781c == dataSource) {
            this.f5781c = null;
        }
        dataSource.g();
    }

    public final void m7113d(DataSource<CloseableReference<CloseableImage>> dataSource) {
    }
}
