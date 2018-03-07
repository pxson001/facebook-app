package com.facebook.reactionsanimations;

import android.graphics.Color;
import com.facebook.reactionsanimations.data.HasKeyFrame;
import com.facebook.reactionsanimations.data.ReactionsColorFrame;
import com.facebook.reactionsanimations.data.ReactionsGradientColor;
import java.util.List;

/* compiled from: fetch_heisman_cta */
public class KeyFramedGradient extends KeyFramedObject<ReactionsColorFrame, GradientColorPair> {
    private final Position f14363a;

    /* compiled from: fetch_heisman_cta */
    public class GradientColorPair {
        public int f14361a;
        public int f14362b;

        public final int m18250a() {
            return this.f14361a;
        }

        public final int m18251b() {
            return this.f14362b;
        }
    }

    /* compiled from: fetch_heisman_cta */
    public enum Position {
        START,
        END
    }

    protected final void mo1139a(HasKeyFrame hasKeyFrame, HasKeyFrame hasKeyFrame2, float f, Object obj) {
        ReactionsColorFrame reactionsColorFrame = (ReactionsColorFrame) hasKeyFrame;
        ReactionsColorFrame reactionsColorFrame2 = (ReactionsColorFrame) hasKeyFrame2;
        GradientColorPair gradientColorPair = (GradientColorPair) obj;
        if (reactionsColorFrame2 == null) {
            if (this.f14363a == Position.START) {
                gradientColorPair.f14361a = reactionsColorFrame.b();
            } else {
                gradientColorPair.f14362b = reactionsColorFrame.b();
            }
        } else if (this.f14363a == Position.START) {
            gradientColorPair.f14361a = m18252a(f, reactionsColorFrame.b(), reactionsColorFrame2.b());
        } else {
            gradientColorPair.f14362b = m18252a(f, reactionsColorFrame.b(), reactionsColorFrame2.b());
        }
    }

    public static KeyFramedGradient m18253a(ReactionsGradientColor reactionsGradientColor, Position position) {
        return new KeyFramedGradient(reactionsGradientColor.mKeyValues, reactionsGradientColor.mTimingCurves, position);
    }

    private KeyFramedGradient(List<ReactionsColorFrame> list, float[][][] fArr, Position position) {
        super(list, fArr);
        this.f14363a = position;
    }

    private static int m18252a(float f, int i, int i2) {
        int alpha = Color.alpha(i);
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        return ((((alpha + ((int) (((float) (Color.alpha(i2) - alpha)) * f))) << 24) | ((red + ((int) (((float) (Color.red(i2) - red)) * f))) << 16)) | ((((int) (((float) (Color.green(i2) - green)) * f)) + green) << 8)) | (((int) (((float) (Color.blue(i2) - blue)) * f)) + blue);
    }
}
