package com.facebook.photos.tagging.store;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.facebook.photos.base.tagging.FaceBox;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: group_mall_ads_education_type */
public class FaceboxOrientationHelper {
    public static List<FaceBox> m21140a(List<FaceBox> list, int i) {
        if (list == null || i == 0) {
            return list;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) (-i), 0.5f, 0.5f);
        List<FaceBox> a = Lists.a();
        for (FaceBox faceBox : list) {
            RectF rectF = new RectF(faceBox.mo1099d());
            matrix.mapRect(rectF);
            a.add(new FaceBox(rectF, faceBox.mo1102n(), faceBox.f12770f, false));
        }
        return a;
    }
}
