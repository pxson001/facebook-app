package com.facebook.reactionsanimations;

import com.facebook.reactionsanimations.data.HasKeyFrame;
import com.facebook.reactionsanimations.data.ReactionsAnimationFrame;
import java.util.List;

/* compiled from: fetch_group_feed */
public class KeyFramedStrokeWidth extends KeyFramedObject<ReactionsAnimationFrame, float[]> {
    public static final KeyFramedStrokeWidth f14364a = new KeyFramedStrokeWidth();

    protected final void mo1139a(HasKeyFrame hasKeyFrame, HasKeyFrame hasKeyFrame2, float f, Object obj) {
        ReactionsAnimationFrame reactionsAnimationFrame = (ReactionsAnimationFrame) hasKeyFrame;
        ReactionsAnimationFrame reactionsAnimationFrame2 = (ReactionsAnimationFrame) hasKeyFrame2;
        float[] fArr = (float[]) obj;
        if (reactionsAnimationFrame2 == null) {
            fArr[0] = reactionsAnimationFrame.mData[0];
        } else {
            fArr[0] = KeyFramedObject.m18244a(reactionsAnimationFrame.mData[0], reactionsAnimationFrame2.mData[0], f);
        }
    }

    public KeyFramedStrokeWidth(List<ReactionsAnimationFrame> list, float[][][] fArr) {
        super(list, fArr);
    }

    private KeyFramedStrokeWidth() {
    }
}
