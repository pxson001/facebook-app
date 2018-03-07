package com.facebook.feed.rows.styling;

import javax.annotation.concurrent.Immutable;

/* compiled from: name_list */
public interface HorizontalPadder {
    public static final HorizontalPadder f13043a = new ZeroHorizontalPadder();

    @Immutable
    /* compiled from: name_list */
    public class ConstantHorizontalPadder implements HorizontalPadder {
        private final float f13041b;
        private final float f13042c;

        public ConstantHorizontalPadder(float f, float f2) {
            this.f13041b = f;
            this.f13042c = f2;
        }

        public final float mo2553a(int i) {
            return this.f13041b + (((float) i) * this.f13042c);
        }
    }

    @Immutable
    /* compiled from: name_list */
    public class ZeroHorizontalPadder implements HorizontalPadder {
        public final float mo2553a(int i) {
            return 0.0f;
        }
    }

    @Immutable
    /* compiled from: name_list */
    public class HorizontalPadderSum implements HorizontalPadder {
        private final HorizontalPadder f19258b;
        private final HorizontalPadder f19259c;

        public HorizontalPadderSum(HorizontalPadder horizontalPadder, HorizontalPadder horizontalPadder2) {
            this.f19258b = horizontalPadder;
            this.f19259c = horizontalPadder2;
        }

        public final float mo2553a(int i) {
            return this.f19258b.mo2553a(i) + this.f19259c.mo2553a(i);
        }
    }

    float mo2553a(int i);
}
