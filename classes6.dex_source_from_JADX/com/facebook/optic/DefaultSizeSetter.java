package com.facebook.optic;

import android.hardware.Camera.Size;
import com.facebook.optic.CameraDevice.CaptureQuality;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/* compiled from: targetIDs */
public class DefaultSizeSetter {

    /* compiled from: targetIDs */
    class C02061 implements Comparator<Size> {
        final /* synthetic */ DefaultSizeSetter f3333a;

        C02061(DefaultSizeSetter defaultSizeSetter) {
            this.f3333a = defaultSizeSetter;
        }

        public int compare(Object obj, Object obj2) {
            Size size = (Size) obj;
            Size size2 = (Size) obj2;
            return (size.width * size.height) - (size2.width * size2.height);
        }
    }

    /* compiled from: targetIDs */
    class C02072 implements Comparator<Size> {
        final /* synthetic */ DefaultSizeSetter f3334a;

        C02072(DefaultSizeSetter defaultSizeSetter) {
            this.f3334a = defaultSizeSetter;
        }

        public int compare(Object obj, Object obj2) {
            Size size = (Size) obj;
            Size size2 = (Size) obj2;
            return (size.width * size.height) - (size2.width * size2.height);
        }
    }

    public void m4403a(CameraFeatures cameraFeatures, CaptureQuality captureQuality, CaptureQuality captureQuality2) {
        Size size;
        Size size2;
        List<Size> y = cameraFeatures.m4347y();
        Collection hashSet = new HashSet(cameraFeatures.m4348z());
        List arrayList = new ArrayList();
        if (y != null) {
            for (Size size3 : y) {
                if (hashSet.contains(size3)) {
                    arrayList.add(size3);
                }
            }
        } else {
            arrayList.addAll(hashSet);
        }
        Collections.sort(arrayList, new C02061(this));
        if (arrayList.size() == 1) {
            size2 = (Size) arrayList.get(0);
        } else {
            size2 = null;
        }
        if (captureQuality2.equals(CaptureQuality.HIGH)) {
            size2 = (Size) arrayList.get(arrayList.size() - 1);
        } else if (captureQuality2.equals(CaptureQuality.MEDIUM)) {
            size3 = (Size) arrayList.get(arrayList.size() - 1);
            r4 = (size3.height * size3.width) / 2;
            size3 = size2;
            r1 = arrayList.size();
            do {
                r1--;
                if (r1 < 0) {
                    break;
                }
                size3 = (Size) arrayList.get(r1);
            } while (size3.width * size3.height > r4);
            size2 = size3;
        } else if (captureQuality2.equals(CaptureQuality.LOW)) {
            size3 = (Size) arrayList.get(arrayList.size() - 1);
            r4 = (size3.height * size3.width) / 3;
            size3 = size2;
            r1 = arrayList.size();
            do {
                r1--;
                if (r1 < 0) {
                    break;
                }
                size3 = (Size) arrayList.get(r1);
            } while (size3.width * size3.height > r4);
            size2 = size3;
        }
        int i = size2.width;
        i = size2.height;
        Collection A = cameraFeatures.m4311A();
        arrayList = new ArrayList(A);
        if (arrayList.isEmpty()) {
            arrayList.addAll(A);
        }
        Collections.sort(arrayList, new C02072(this));
        if (captureQuality.equals(CaptureQuality.HIGH)) {
            size3 = (Size) arrayList.get(arrayList.size() - 1);
        } else if (captureQuality.equals(CaptureQuality.MEDIUM)) {
            size3 = null;
            r2 = arrayList.size();
            do {
                r2--;
                if (r2 < 0) {
                    break;
                }
                size3 = (Size) arrayList.get(r2);
            } while (size3.width * size3.height > 2097152);
        } else if (captureQuality.equals(CaptureQuality.LOW)) {
            size3 = null;
            r2 = arrayList.size();
            do {
                r2--;
                if (r2 < 0) {
                    break;
                }
                size3 = (Size) arrayList.get(r2);
            } while (size3.width * size3.height > 1048576);
        } else {
            size3 = null;
        }
        cameraFeatures.m4314a(size2.width, size2.height);
        cameraFeatures.m4320b(size3.width, size3.height);
    }
}
