package android.support.v7.graphics;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.os.AsyncTaskCompat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: share_attachment */
public final class Palette {
    private final List<Swatch> f3734a;
    public final Generator f3735b;

    /* compiled from: share_attachment */
    public abstract class Generator {
        public abstract void mo107a(List<Swatch> list);

        public Swatch mo106a() {
            return null;
        }

        public Swatch mo108b() {
            return null;
        }

        public Swatch mo109c() {
            return null;
        }

        public Swatch mo110d() {
            return null;
        }
    }

    /* compiled from: share_attachment */
    public final class Builder {
        private List<Swatch> f3720a;
        private Bitmap f3721b;
        private int f3722c = 16;
        private int f3723d = 192;
        private Generator f3724e;

        public Builder(Bitmap bitmap) {
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            this.f3721b = bitmap;
        }

        public final Palette m3452a() {
            List list;
            if (this.f3721b == null) {
                list = this.f3720a;
            } else if (this.f3723d <= 0) {
                throw new IllegalArgumentException("Minimum dimension size for resizing should should be >= 1");
            } else {
                Bitmap b = Palette.m3460b(this.f3721b, this.f3723d);
                int i = this.f3722c;
                int width = b.getWidth();
                int height = b.getHeight();
                int[] iArr = new int[(width * height)];
                b.getPixels(iArr, 0, width, 0, 0, width, height);
                ColorCutQuantizer colorCutQuantizer = new ColorCutQuantizer(new ColorHistogram(iArr), i);
                if (b != this.f3721b) {
                    b.recycle();
                }
                list = colorCutQuantizer.f3706e;
            }
            if (this.f3724e == null) {
                this.f3724e = new DefaultGenerator();
            }
            this.f3724e.mo107a(list);
            return new Palette(list, this.f3724e);
        }

        public final AsyncTask<Bitmap, Void, Palette> m3451a(final PaletteAsyncListener paletteAsyncListener) {
            if (paletteAsyncListener == null) {
                throw new IllegalArgumentException("listener can not be null");
            }
            return AsyncTaskCompat.a(new AsyncTask<Bitmap, Void, Palette>(this) {
                final /* synthetic */ Builder f3719b;

                protected void onPostExecute(Object obj) {
                    paletteAsyncListener.mo467a((Palette) obj);
                }

                protected Object doInBackground(Object[] objArr) {
                    return this.f3719b.m3452a();
                }
            }, new Bitmap[]{this.f3721b});
        }
    }

    /* compiled from: share_attachment */
    public interface PaletteAsyncListener {
        void mo467a(Palette palette);
    }

    /* compiled from: share_attachment */
    public final class Swatch {
        private final int f3725a;
        private final int f3726b;
        private final int f3727c;
        public final int f3728d;
        public final int f3729e;
        private boolean f3730f;
        private int f3731g;
        private int f3732h;
        private float[] f3733i;

        public Swatch(int i, int i2) {
            this.f3725a = Color.red(i);
            this.f3726b = Color.green(i);
            this.f3727c = Color.blue(i);
            this.f3728d = i;
            this.f3729e = i2;
        }

        public Swatch(int i, int i2, int i3, int i4) {
            this.f3725a = i;
            this.f3726b = i2;
            this.f3727c = i3;
            this.f3728d = Color.rgb(i, i2, i3);
            this.f3729e = i4;
        }

        public final float[] m3457b() {
            if (this.f3733i == null) {
                this.f3733i = new float[3];
                ColorUtils.a(this.f3725a, this.f3726b, this.f3727c, this.f3733i);
            }
            return this.f3733i;
        }

        public final int m3458c() {
            return this.f3729e;
        }

        private int m3454d() {
            m3456f();
            return this.f3731g;
        }

        private int m3455e() {
            m3456f();
            return this.f3732h;
        }

        private void m3456f() {
            if (!this.f3730f) {
                int a = ColorUtils.a(-1, this.f3728d, 4.5f);
                int a2 = ColorUtils.a(-1, this.f3728d, 3.0f);
                if (a == -1 || a2 == -1) {
                    int a3 = ColorUtils.a(-16777216, this.f3728d, 4.5f);
                    int a4 = ColorUtils.a(-16777216, this.f3728d, 3.0f);
                    if (a3 == -1 || a3 == -1) {
                        this.f3732h = a != -1 ? ColorUtils.b(-1, a) : ColorUtils.b(-16777216, a3);
                        this.f3731g = a2 != -1 ? ColorUtils.b(-1, a2) : ColorUtils.b(-16777216, a4);
                        this.f3730f = true;
                        return;
                    }
                    this.f3732h = ColorUtils.b(-16777216, a3);
                    this.f3731g = ColorUtils.b(-16777216, a4);
                    this.f3730f = true;
                    return;
                }
                this.f3732h = ColorUtils.b(-1, a);
                this.f3731g = ColorUtils.b(-1, a2);
                this.f3730f = true;
            }
        }

        public final String toString() {
            return new StringBuilder(getClass().getSimpleName()).append(" [RGB: #").append(Integer.toHexString(this.f3728d)).append(']').append(" [HSL: ").append(Arrays.toString(m3457b())).append(']').append(" [Population: ").append(this.f3729e).append(']').append(" [Title Text: #").append(Integer.toHexString(m3454d())).append(']').append(" [Body Text: #").append(Integer.toHexString(m3455e())).append(']').toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Swatch swatch = (Swatch) obj;
            if (this.f3729e == swatch.f3729e && this.f3728d == swatch.f3728d) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (this.f3728d * 31) + this.f3729e;
        }
    }

    public static Builder m3459a(Bitmap bitmap) {
        return new Builder(bitmap);
    }

    public Palette(List<Swatch> list, Generator generator) {
        this.f3734a = list;
        this.f3735b = generator;
    }

    public final List<Swatch> m3461a() {
        return Collections.unmodifiableList(this.f3734a);
    }

    public final Swatch m3462b() {
        return this.f3735b.mo106a();
    }

    public final Swatch m3463c() {
        return this.f3735b.mo108b();
    }

    public final Swatch m3464d() {
        return this.f3735b.mo109c();
    }

    public static Bitmap m3460b(Bitmap bitmap, int i) {
        int max = Math.max(bitmap.getWidth(), bitmap.getHeight());
        if (max <= i) {
            return bitmap;
        }
        float f = ((float) i) / ((float) max);
        return Bitmap.createScaledBitmap(bitmap, Math.round(((float) bitmap.getWidth()) * f), Math.round(f * ((float) bitmap.getHeight())), false);
    }
}
