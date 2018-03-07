package com.facebook.backstage.camera;

import android.hardware.Camera.Size;
import com.facebook.debug.log.BLog;
import com.facebook.optic.CameraDevice.CaptureQuality;
import com.facebook.optic.CameraFeatures;
import com.facebook.optic.DefaultSizeSetter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/* compiled from: secret_key */
public class BackstageSizeSetter extends DefaultSizeSetter {
    private static final String f4308a = BackstageSizeSetter.class.getSimpleName();

    /* compiled from: secret_key */
    class C03891 implements Comparator<Size> {
        final /* synthetic */ BackstageSizeSetter f4306a;

        C03891(BackstageSizeSetter backstageSizeSetter) {
            this.f4306a = backstageSizeSetter;
        }

        public int compare(Object obj, Object obj2) {
            Size size = (Size) obj;
            Size size2 = (Size) obj2;
            return (size.width * size.height) - (size2.width * size2.height);
        }
    }

    /* compiled from: secret_key */
    class C03902 implements Comparator<Size> {
        final /* synthetic */ BackstageSizeSetter f4307a;

        C03902(BackstageSizeSetter backstageSizeSetter) {
            this.f4307a = backstageSizeSetter;
        }

        public int compare(Object obj, Object obj2) {
            Size size = (Size) obj;
            Size size2 = (Size) obj2;
            return (size.width * size.height) - (size2.width * size2.height);
        }
    }

    public final void m4282a(CameraFeatures cameraFeatures, CaptureQuality captureQuality, CaptureQuality captureQuality2) {
        Size size;
        Size size2;
        Size size3 = null;
        List<Size> y = cameraFeatures.y();
        Collection hashSet = new HashSet(cameraFeatures.z());
        Collection A = cameraFeatures.A();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList(A);
        if (arrayList2.isEmpty()) {
            arrayList2.addAll(A);
        }
        Collections.sort(arrayList2, new C03891(this));
        if (captureQuality.equals(CaptureQuality.HIGH)) {
            size = (Size) arrayList2.get(arrayList2.size() - 1);
        } else if (captureQuality.equals(CaptureQuality.MEDIUM)) {
            r1 = arrayList2.size();
            size2 = null;
            do {
                r1--;
                if (r1 < 0) {
                    break;
                }
                size2 = (Size) arrayList2.get(r1);
            } while (size2.width * size2.height > 2097152);
            size = size2;
        } else if (captureQuality.equals(CaptureQuality.LOW)) {
            r1 = arrayList2.size();
            size2 = null;
            do {
                r1--;
                if (r1 < 0) {
                    break;
                }
                size2 = (Size) arrayList2.get(r1);
            } while (size2.width * size2.height > 3145728);
            size = size2;
        } else {
            size = null;
        }
        float f = ((float) size.height) / ((float) size.width);
        if (y != null) {
            for (Size size22 : y) {
                float f2 = ((float) size22.height) / ((float) size22.width);
                if (hashSet.contains(size22) && Math.abs(f2 - f) < 1.0E-6f) {
                    arrayList.add(size22);
                }
            }
        } else {
            arrayList.addAll(hashSet);
        }
        if (arrayList.size() == 0) {
            BLog.b(f4308a, "could not find a size that matches picture aspect ratio.");
            super.a(cameraFeatures, captureQuality, captureQuality2);
            return;
        }
        int size4;
        Collections.sort(arrayList, new C03902(this));
        if (arrayList.size() == 1) {
            size3 = (Size) arrayList.get(0);
        }
        if (captureQuality2.equals(CaptureQuality.HIGH)) {
            size22 = (Size) arrayList.get(arrayList.size() - 1);
        } else if (captureQuality2.equals(CaptureQuality.MEDIUM)) {
            size22 = (Size) arrayList.get(arrayList.size() - 1);
            r3 = (size22.height * size22.width) / 2;
            size22 = size3;
            size4 = arrayList.size();
            do {
                size4--;
                if (size4 < 0) {
                    break;
                }
                size22 = (Size) arrayList.get(size4);
            } while (size22.width * size22.height > r3);
        } else if (captureQuality2.equals(CaptureQuality.LOW)) {
            size22 = (Size) arrayList.get(arrayList.size() - 1);
            r3 = (size22.height * size22.width) / 3;
            size22 = size3;
            size4 = arrayList.size();
            do {
                size4--;
                if (size4 < 0) {
                    break;
                }
                size22 = (Size) arrayList.get(size4);
            } while (size22.width * size22.height > r3);
        } else {
            size22 = size3;
        }
        size4 = size22.width;
        size4 = size22.height;
        cameraFeatures.a(size22.width, size22.height);
        cameraFeatures.b(size.width, size.height);
    }
}
