package com.facebook.reactionsanimations;

import android.graphics.Path;
import com.facebook.reactionsanimations.data.HasKeyFrame;
import com.facebook.reactionsanimations.data.ReactionsFeatureFrame;
import com.facebook.reactionsanimations.data.ReactionsFeatureFrame$MoveListFeature;
import java.util.List;

/* compiled from: fetch_group_pinned_post */
public class KeyFramedPath extends KeyFramedObject<ReactionsFeatureFrame, Path> {
    protected final void mo1139a(HasKeyFrame hasKeyFrame, HasKeyFrame hasKeyFrame2, float f, Object obj) {
        ReactionsFeatureFrame reactionsFeatureFrame = (ReactionsFeatureFrame) hasKeyFrame;
        ReactionsFeatureFrame reactionsFeatureFrame2 = (ReactionsFeatureFrame) hasKeyFrame2;
        Path path = (Path) obj;
        if (reactionsFeatureFrame2 == null || f == 0.0f) {
            for (VectorCommand a : reactionsFeatureFrame.b().f14402b) {
                a.mo1144a(path);
            }
            return;
        }
        ReactionsFeatureFrame$MoveListFeature b = reactionsFeatureFrame.b();
        ReactionsFeatureFrame$MoveListFeature b2 = reactionsFeatureFrame2.b();
        int size = b.f14402b.size();
        for (int i = 0; i < size; i++) {
            ((VectorCommand) b.f14402b.get(i)).m18277a((VectorCommand) b2.f14402b.get(i), f, path);
        }
    }

    public KeyFramedPath(List<ReactionsFeatureFrame> list, float[][][] fArr) {
        super(list, fArr);
    }
}
