package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import javax.annotation.Nullable;

/* compiled from: alarm */
public abstract class BaseBitmapDataSubscriber extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    protected abstract void mo1184a(@Nullable Bitmap bitmap);

    public final void m19101e(DataSource<CloseableReference<CloseableImage>> dataSource) {
        if (dataSource.b()) {
            CloseableReference closeableReference = (CloseableReference) dataSource.d();
            Bitmap bitmap = null;
            if (closeableReference != null && (closeableReference.a() instanceof CloseableBitmap)) {
                bitmap = ((CloseableBitmap) closeableReference.a()).a();
            }
            try {
                mo1184a(bitmap);
            } finally {
                CloseableReference.c(closeableReference);
            }
        }
    }
}
