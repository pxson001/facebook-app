package com.facebook.photos.base.tagging;

import android.graphics.RectF;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: initial_app_attribution */
public class LocalPhotoUtil {
    public static void m20176a(@Nullable List<FaceBox> list, @Nullable List<Tag> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            for (FaceBox faceBox : list) {
                for (Tag tag : list2) {
                    if ((tag.f12786a instanceof FaceBoxStub) || (tag.f12786a instanceof FaceBox)) {
                        Object obj = null;
                        RectF d = tag.f12786a.mo1099d();
                        RectF d2 = faceBox.mo1099d();
                        if (!(d == null || d2 == null)) {
                            int i;
                            if (d.contains(d2) || d2.contains(d)) {
                                i = 1;
                            } else if (RectF.intersects(d, d2)) {
                                RectF rectF = new RectF(d);
                                rectF.intersect(d2);
                                RectF rectF2 = new RectF(d);
                                rectF2.union(d2);
                                if ((rectF.width() * rectF.height()) / (rectF2.width() * rectF2.height()) >= 0.5f) {
                                    i = 1;
                                }
                            }
                        }
                        if (obj != null) {
                            tag.f12786a = faceBox;
                            faceBox.f12770f = true;
                            break;
                        }
                    }
                }
            }
        }
    }
}
