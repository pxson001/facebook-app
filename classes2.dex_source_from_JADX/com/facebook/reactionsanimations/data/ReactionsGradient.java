package com.facebook.reactionsanimations.data;

import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.reactionsanimations.KeyFramedGradient;
import com.facebook.reactionsanimations.KeyFramedGradient.GradientColorPair;
import com.facebook.reactionsanimations.KeyFramedGradient.Position;

/* compiled from: gysc_imp */
public class ReactionsGradient {
    private KeyFramedGradient f21439a;
    private KeyFramedGradient f21440b;
    public LinearGradient[] f21441c;
    public int f21442d;
    @DoNotStrip
    private ReactionsGradientColor mColorEnd;
    @DoNotStrip
    private ReactionsGradientColor mColorStart;

    public final void m29167a(float f, int i, int i2) {
        if (this.f21441c == null) {
            int round = Math.round((30.0f * ((float) i2)) / ((float) i));
            this.f21441c = new LinearGradient[(round + 1)];
            this.f21442d = i2;
            GradientColorPair gradientColorPair = new GradientColorPair();
            for (int i3 = 0; i3 < round; i3++) {
                float f2 = (((float) i3) / ((float) round)) * ((float) i2);
                m29165a().a(f2, gradientColorPair);
                m29166b().a(f2, gradientColorPair);
                this.f21441c[i3] = new LinearGradient(0.0f, 0.0f, 0.0f, f, gradientColorPair.a(), gradientColorPair.b(), TileMode.CLAMP);
            }
        }
    }

    private KeyFramedGradient m29165a() {
        if (this.f21439a == null) {
            this.f21439a = KeyFramedGradient.a(this.mColorStart, Position.START);
        }
        return this.f21439a;
    }

    private KeyFramedGradient m29166b() {
        if (this.f21440b == null) {
            this.f21440b = KeyFramedGradient.a(this.mColorEnd, Position.END);
        }
        return this.f21440b;
    }
}
