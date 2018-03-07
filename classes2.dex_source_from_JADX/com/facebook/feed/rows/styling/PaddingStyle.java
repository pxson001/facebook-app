package com.facebook.feed.rows.styling;

import android.graphics.Rect;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver.BaseStyle;
import com.facebook.feed.rows.styling.HorizontalPadder.ConstantHorizontalPadder;
import com.facebook.feed.rows.styling.HorizontalPadder.HorizontalPadderSum;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: name=? */
public class PaddingStyle {
    public static final PaddingStyle f13071a = new PaddingStyle(BaseStyle.DEFAULT);
    public static final PaddingStyle f13072b = new PaddingStyle(BaseStyle.DEFAULT, new PaddingValues(), true);
    public static final PaddingStyle f13073c = new PaddingStyle(BaseStyle.SHARED_ATTACHMENT, new PaddingValues(0.0f, 0.0f, 0.0f, new ConstantHorizontalPadder(13.0f, 0.0f)), true);
    public static final PaddingStyle f13074d = new PaddingStyle(BaseStyle.SHARED_ATTACHMENT, new PaddingValues(0.0f, -3.0f, 0.0f, new ConstantHorizontalPadder(13.0f, 0.0f)), false);
    public static final PaddingStyle f13075e = new PaddingStyle(BaseStyle.DEFAULT_TEXT);
    public static final PaddingStyle f13076f = new PaddingStyle(BaseStyle.ZERO);
    public static final PaddingStyle f13077g = new PaddingStyle(BaseStyle.ZERO, new PaddingValues(), true);
    public static final PaddingStyle f13078h = new PaddingStyle(BaseStyle.ZERO, new PaddingValues(0.0f, 0.0f, 0.0f, new ConstantHorizontalPadder(10.0f, 12.0f)), false);
    public static final PaddingStyle f13079i = new PaddingStyle(BaseStyle.DEFAULT_HEADER);
    public static final PaddingStyle f13080j = new PaddingStyle(BaseStyle.DEFAULT_TEXT_HEADER);
    public static final PaddingStyle f13081k = new PaddingStyle(BaseStyle.SUBSTORY_HEADER);
    public static final PaddingStyle f13082l = new PaddingStyle(BaseStyle.ATTACHMENT_TOP, new PaddingValues(0.0f, 0.0f, 0.0f, new ConstantHorizontalPadder(10.0f, 12.0f)), false);
    public static final PaddingStyle f13083m = new PaddingStyle(BaseStyle.ATTACHMENT_BOTTOM, new PaddingValues(0.0f, 0.0f, 0.0f, new ConstantHorizontalPadder(10.0f, 12.0f)), false);
    public static final PaddingStyle f13084n = new PaddingStyle(BaseStyle.ZERO, new PaddingValues(0.0f, -4.0f, 0.0f, new ConstantHorizontalPadder(10.0f, 0.0f)), true);
    public static final PaddingStyle f13085o = new PaddingStyle(BaseStyle.LEGACY_DEFAULT);
    public static final PaddingStyle f13086p = new PaddingStyle(BaseStyle.LEGACY_ZERO);
    public static final PaddingStyle f13087q = new PaddingStyle(BaseStyle.STORY_EDGE);
    public final BaseStyle f13088r;
    public final PaddingValues f13089s;
    public final boolean f13090t;

    @Immutable
    /* compiled from: name=? */
    public class PaddingValues {
        public final float f13044a;
        public final float f13045b;
        public final float f13046c;
        public final HorizontalPadder f13047d;

        public PaddingValues(float f, float f2, float f3, HorizontalPadder horizontalPadder) {
            Preconditions.checkNotNull(horizontalPadder);
            this.f13044a = f;
            this.f13045b = f2;
            this.f13046c = f3;
            this.f13047d = horizontalPadder;
        }

        public PaddingValues() {
            this(0.0f, 0.0f, 0.0f, HorizontalPadder.f13043a);
        }

        public final PaddingValues m19182a(PaddingValues paddingValues) {
            return new PaddingValues(this.f13044a + paddingValues.f13044a, this.f13045b + paddingValues.f13045b, this.f13046c + paddingValues.f13046c, new HorizontalPadderSum(this.f13047d, paddingValues.f13047d));
        }

        public String toString() {
            return "Top:" + this.f13044a + " Bottom:" + this.f13045b + " Horizontal:" + this.f13047d.mo2553a(0) + " right:" + this.f13046c;
        }
    }

    /* compiled from: name=? */
    public class Builder {
        private BaseStyle f13065a;
        public float f13066b = 0.0f;
        public float f13067c = 0.0f;
        public float f13068d = 0.0f;
        public float f13069e = 0.0f;
        private boolean f13070f = false;

        private Builder(BaseStyle baseStyle) {
            this.f13065a = baseStyle;
        }

        public static Builder m19301a() {
            return new Builder(BaseStyle.DEFAULT);
        }

        public static Builder m19302b() {
            return new Builder(BaseStyle.DEFAULT_TEXT);
        }

        public static Builder m19303c() {
            return new Builder(BaseStyle.ZERO);
        }

        public static Builder m19304d() {
            return new Builder(BaseStyle.DEFAULT_HEADER);
        }

        public static Builder m19305e() {
            return new Builder(BaseStyle.LEGACY_ZERO);
        }

        public static Builder m19306f() {
            return new Builder(BaseStyle.STORY_EDGE);
        }

        public static Builder m19307g() {
            return new Builder(BaseStyle.LEGACY_DEFAULT);
        }

        public final Builder m19308a(float f) {
            this.f13066b = f;
            return this;
        }

        public final Builder m19309a(int i) {
            this.f13066b = (float) (i * 4);
            return this;
        }

        public final Builder m19311b(int i) {
            this.f13067c = (float) (i * 4);
            return this;
        }

        public final Builder m19312h() {
            this.f13070f = true;
            return this;
        }

        public final Builder m19310a(Rect rect, float f) {
            this.f13066b = ((float) (-rect.top)) / f;
            this.f13067c = ((float) (-rect.bottom)) / f;
            if (!this.f13065a.isZero()) {
                this.f13068d = ((float) (-rect.left)) / f;
                this.f13069e = ((float) (-(rect.right - rect.left))) / f;
            }
            return this;
        }

        public final PaddingStyle m19313i() {
            return new PaddingStyle(this.f13065a, new PaddingValues(this.f13066b, this.f13067c, this.f13069e, new ConstantHorizontalPadder(this.f13068d, 0.0f)), this.f13070f);
        }
    }

    public PaddingStyle(BaseStyle baseStyle, PaddingValues paddingValues, boolean z) {
        this.f13088r = baseStyle;
        this.f13089s = paddingValues;
        this.f13090t = z;
    }

    private PaddingStyle(BaseStyle baseStyle) {
        this.f13088r = baseStyle;
        this.f13089s = new PaddingValues();
        this.f13090t = false;
    }

    public String toString() {
        return this.f13088r.name() + (this.f13090t ? " w/shadowPadder Values:" : " values:") + this.f13089s.toString();
    }

    public final boolean m19314d() {
        return this.f13088r.isZero();
    }
}
