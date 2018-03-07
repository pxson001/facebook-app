package com.facebook.reactionsanimations;

import android.view.animation.Interpolator;
import com.facebook.reactionsanimations.path.FbPathInterpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: fetch_story_ */
public class KeyFrameAnimationHelper {
    public static List<Interpolator> m18243a(float[][][] fArr) {
        if (fArr == null) {
            return Collections.emptyList();
        }
        List arrayList = new ArrayList();
        for (float[][] fArr2 : fArr) {
            arrayList.add(new FbPathInterpolator(fArr2[0][0], fArr2[0][1], fArr2[1][0], fArr2[1][1]));
        }
        return Collections.unmodifiableList(arrayList);
    }
}
