package com.facebook.photos.upload.scaling;

import com.facebook.bitmaps.Dimension;
import com.facebook.bitmaps.ImageResizer;
import com.facebook.bitmaps.ImageResizer.ImageResizingException;
import com.facebook.bitmaps.ImageScaleParam;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.upload.abtest.ExperimentsForPhotosUploadModule;
import com.facebook.photos.upload.module.UploadQualityXConfig;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.xconfig.core.XConfigReader;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: full_res_is_coming_later */
public class ImageScalingPolicy {
    private final XConfigReader f14230a;
    private final QeAccessor f14231b;
    private final Provider<Boolean> f14232c;

    /* compiled from: full_res_is_coming_later */
    public class EmptyOutputFileException extends ImageResizingException {
        public EmptyOutputFileException(String str) {
            super(str, true);
        }
    }

    public static ImageScalingPolicy m21908a(InjectorLike injectorLike) {
        return new ImageScalingPolicy(XConfigReader.a(injectorLike), IdBasedProvider.a(injectorLike, 4254), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ImageScalingPolicy(XConfigReader xConfigReader, Provider<Boolean> provider, QeAccessor qeAccessor) {
        this.f14230a = xConfigReader;
        this.f14231b = qeAccessor;
        this.f14232c = provider;
    }

    public final ImageScaleParam m21909a(int i, int i2, boolean z) {
        int i3;
        boolean z2 = ((Boolean) this.f14232c.get()).booleanValue() && this.f14231b.a(ExperimentsForPhotosUploadModule.f13511p, false);
        int a = this.f14231b.a(ExperimentsForPhotosUploadModule.f13509n, 2048);
        if (!z2) {
            a = 960;
        }
        int a2 = this.f14230a.a(UploadQualityXConfig.d, 90);
        int a3 = this.f14231b.a(ExperimentsForPhotosUploadModule.f13510o, 90);
        if (z2) {
            i3 = a3;
        } else {
            i3 = a2;
        }
        int a4 = m21907a(i, i2, a, 2, 640, 921600);
        if (z) {
            a4 = 6144;
        }
        return new ImageScaleParam(a4, a4, true, i3);
    }

    public final ImageScaleParam m21910a(ImageResizer imageResizer, String str, Dimension dimension, File file, boolean z) {
        ImageScaleParam a = m21909a(dimension.b, dimension.a, z);
        String absolutePath = file.getAbsolutePath();
        ImageScaleParam a2 = imageResizer.a(str, absolutePath, dimension.b, dimension.a, a);
        if (file.length() != 0) {
            return a2;
        }
        throw new EmptyOutputFileException(absolutePath);
    }

    private static int m21907a(int i, int i2, int i3, int i4, int i5, int i6) {
        Object obj = 1;
        Object obj2 = i >= i4 * i2 ? 1 : null;
        if (i2 < i4 * i) {
            obj = null;
        }
        if (obj == null && obj2 == null) {
            return i3;
        }
        float f = 1.0f;
        if (i > i2) {
            if (i2 > i5) {
                f = ((float) i5) / ((float) i2);
            }
        } else if (i > i5) {
            f = ((float) i5) / ((float) i);
        }
        float f2 = ((((float) i) * f) * ((float) i2)) * f;
        if (f2 > ((float) i6)) {
            f = (float) (Math.sqrt((double) (((float) i6) / f2)) * ((double) f));
        }
        return (int) (f * ((float) Math.max(i, i2)));
    }
}
