package com.facebook.feed.ui.attachments;

import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: Tried to start loading without a valid story id. */
public class FallbackPhotoGridProperties {
    private static final CoordinateMapper f21813g = new C18381();
    private static final CoordinateMapper f21814h = new C18392();
    private static final DimensionMapper f21815i = new C18403();
    private static final DimensionMapper f21816j = new C18414();
    private static final CoordinateMapper f21817k = new C18425();
    private static final CoordinateMapper f21818l = new C18436();
    private static final DimensionMapper f21819m = new C18447();
    private static final DimensionMapper f21820n = new C18458();
    private static final CoordinateMapper f21821o = new C18469();
    private static final CoordinateMapper f21822p = new CoordinateMapper() {
        public final int mo1512a(int i) {
            return i == 0 ? 0 : 4;
        }
    };
    private static final DimensionMapper f21823q = new DimensionMapper() {
        public final int mo1513a(int i) {
            return i == 0 ? 6 : 2;
        }
    };
    private static final DimensionMapper f21824r = new DimensionMapper() {
        public final int mo1513a(int i) {
            return i == 0 ? 4 : 2;
        }
    };
    private static final CoordinateMapper f21825s = new CoordinateMapper() {
        public final int mo1512a(int i) {
            switch (i) {
                case 1:
                    return 3;
                case 3:
                    return 2;
                case 4:
                    return 4;
                default:
                    return 0;
            }
        }
    };
    private static final CoordinateMapper f21826t = new CoordinateMapper() {
        public final int mo1512a(int i) {
            switch (i) {
                case 2:
                case 3:
                case 4:
                    return 3;
                default:
                    return 0;
            }
        }
    };
    private static final DimensionMapper f21827u = new DimensionMapper() {
        public final int mo1513a(int i) {
            switch (i) {
                case 2:
                case 3:
                case 4:
                    return 2;
                default:
                    return 3;
            }
        }
    };
    public CoordinateMapper f21828a;
    public CoordinateMapper f21829b;
    public DimensionMapper f21830c;
    public DimensionMapper f21831d;
    public boolean f21832e;
    public int f21833f;

    /* compiled from: Tried to start loading without a valid story id. */
    public interface CoordinateMapper {
        int mo1512a(int i);
    }

    /* compiled from: Tried to start loading without a valid story id. */
    public interface DimensionMapper {
        int mo1513a(int i);
    }

    /* compiled from: Tried to start loading without a valid story id. */
    final class C18381 implements CoordinateMapper {
        C18381() {
        }

        public final int mo1512a(int i) {
            return 0;
        }
    }

    /* compiled from: Tried to start loading without a valid story id. */
    final class C18392 implements CoordinateMapper {
        C18392() {
        }

        public final int mo1512a(int i) {
            return i * 3;
        }
    }

    /* compiled from: Tried to start loading without a valid story id. */
    final class C18403 implements DimensionMapper {
        C18403() {
        }

        public final int mo1513a(int i) {
            return 6;
        }
    }

    /* compiled from: Tried to start loading without a valid story id. */
    final class C18414 implements DimensionMapper {
        C18414() {
        }

        public final int mo1513a(int i) {
            return 3;
        }
    }

    /* compiled from: Tried to start loading without a valid story id. */
    final class C18425 implements CoordinateMapper {
        C18425() {
        }

        public final int mo1512a(int i) {
            return i == 2 ? 3 : 0;
        }
    }

    /* compiled from: Tried to start loading without a valid story id. */
    final class C18436 implements CoordinateMapper {
        C18436() {
        }

        public final int mo1512a(int i) {
            return i == 0 ? 0 : 4;
        }
    }

    /* compiled from: Tried to start loading without a valid story id. */
    final class C18447 implements DimensionMapper {
        C18447() {
        }

        public final int mo1513a(int i) {
            return i == 0 ? 6 : 3;
        }
    }

    /* compiled from: Tried to start loading without a valid story id. */
    final class C18458 implements DimensionMapper {
        C18458() {
        }

        public final int mo1513a(int i) {
            return i == 0 ? 4 : 2;
        }
    }

    /* compiled from: Tried to start loading without a valid story id. */
    final class C18469 implements CoordinateMapper {
        C18469() {
        }

        public final int mo1512a(int i) {
            switch (i) {
                case 2:
                    return 2;
                case 3:
                    return 4;
                default:
                    return 0;
            }
        }
    }

    @Inject
    public FallbackPhotoGridProperties(@Assisted Integer num, @Assisted Boolean bool) {
        this.f21832e = bool.booleanValue();
        this.f21833f = num.intValue();
        switch (num.intValue()) {
            case 2:
                this.f21828a = f21813g;
                this.f21829b = f21814h;
                this.f21830c = f21815i;
                this.f21831d = f21816j;
                return;
            case 3:
                this.f21828a = f21817k;
                this.f21829b = f21818l;
                this.f21830c = f21819m;
                this.f21831d = f21820n;
                return;
            case 4:
                this.f21828a = f21821o;
                this.f21829b = f21822p;
                this.f21830c = f21823q;
                this.f21831d = f21824r;
                return;
            case 5:
                this.f21828a = f21825s;
                this.f21829b = f21826t;
                this.f21830c = f21827u;
                this.f21831d = f21827u;
                return;
            default:
                throw new IllegalArgumentException("Unsupported number of photos: " + num);
        }
    }
}
