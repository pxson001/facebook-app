package com.facebook.photos.tagging.ui;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PointF;
import android.graphics.RectF;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.TagPoint;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: intro_card_expansion */
public class FaceBoxConverter {
    private static final RectF f10921a = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    public Map<FaceBox, FaceBox> f10922b = Maps.c();
    @Nullable
    public RectF f10923c;
    public int f10924d;

    public static FaceBoxConverter m12936a(InjectorLike injectorLike) {
        return new FaceBoxConverter();
    }

    public static List<RectF> m12937a(@Nullable List<FaceBox> list, @Nullable RectF rectF, int i) {
        if (list == null) {
            return null;
        }
        Builder builder = new Builder();
        Matrix matrix = new Matrix();
        if (rectF != null) {
            matrix.setRectToRect(rectF, f10921a, ScaleToFit.FILL);
        }
        matrix.postRotate((float) i, 0.5f, 0.5f);
        for (FaceBox d : list) {
            RectF rectF2 = new RectF(d.d());
            if (rectF == null || rectF.contains(rectF2)) {
                matrix.mapRect(rectF2);
                builder.c(rectF2);
            }
        }
        return builder.b();
    }

    @Nullable
    public final Collection<RectF> m12944a(@Nullable List<FaceBox> list) {
        m12939c((List) list);
        Builder builder = new Builder();
        for (FaceBox d : this.f10922b.keySet()) {
            builder.c(d.d());
        }
        return builder.b();
    }

    private void m12939c(@Nullable List<FaceBox> list) {
        this.f10922b.clear();
        if (list != null) {
            Matrix matrix = new Matrix();
            if (this.f10923c != null) {
                matrix.setRectToRect(this.f10923c, f10921a, ScaleToFit.FILL);
            }
            matrix.postRotate((float) this.f10924d, 0.5f, 0.5f);
            for (FaceBox faceBox : list) {
                if (!faceBox.f) {
                    RectF rectF = new RectF(faceBox.d());
                    if (this.f10923c == null) {
                        this.f10922b.put(faceBox, faceBox);
                    } else if (m12940c(faceBox)) {
                        matrix.mapRect(rectF);
                        this.f10922b.put(new FaceBox(rectF, faceBox.n(), faceBox.f, false), faceBox);
                    }
                }
            }
        }
    }

    @Nullable
    public final FaceBox m12941a(RectF rectF) {
        Preconditions.checkNotNull(rectF);
        for (FaceBox faceBox : this.f10922b.keySet()) {
            if (faceBox.d() == rectF) {
                return (FaceBox) this.f10922b.get(faceBox);
            }
        }
        return null;
    }

    public final void m12945a(@Nullable RectF rectF, @Nullable List<FaceBox> list, int i) {
        Preconditions.checkNotNull(rectF);
        Preconditions.checkState(f10921a.contains(rectF));
        this.f10923c = rectF;
        this.f10924d = i;
        m12939c((List) list);
    }

    @Nullable
    public final FaceBox m12942a(FaceBox faceBox) {
        for (Entry entry : this.f10922b.entrySet()) {
            if (entry.getValue() != faceBox) {
                if (m12938a((FaceBox) entry.getValue(), faceBox)) {
                }
            }
            return (FaceBox) entry.getKey();
        }
        return null;
    }

    public final TagPoint m12943a(TagPoint tagPoint, int i) {
        if (this.f10923c == null && i == 0) {
            return tagPoint;
        }
        Matrix matrix = new Matrix();
        matrix.setRectToRect(this.f10923c, f10921a, ScaleToFit.FILL);
        matrix.postRotate((float) i, 0.5f, 0.5f);
        Matrix matrix2 = new Matrix();
        matrix.invert(matrix2);
        float[] fArr = new float[]{tagPoint.f().x, tagPoint.f().y};
        matrix2.mapPoints(fArr);
        return new TagPoint(new PointF(fArr[0], fArr[1]), tagPoint.n());
    }

    public static boolean m12938a(FaceBox faceBox, FaceBox faceBox2) {
        Preconditions.checkNotNull(faceBox);
        Preconditions.checkNotNull(faceBox2);
        if (faceBox.d().left == faceBox2.d().left && faceBox.d().right == faceBox2.d().right && faceBox.d().top == faceBox2.d().top && faceBox.d().bottom == faceBox2.d().bottom) {
            return true;
        }
        return false;
    }

    private boolean m12940c(FaceBox faceBox) {
        float max;
        RectF rectF = new RectF(faceBox.d());
        float width = rectF.width() * rectF.height();
        if (this.f10923c != null) {
            max = Math.max(0.0f, Math.min(this.f10923c.bottom, rectF.bottom) - Math.max(this.f10923c.top, rectF.top)) * Math.max(0.0f, Math.min(this.f10923c.right, rectF.right) - Math.max(this.f10923c.left, rectF.left));
        } else {
            max = width;
        }
        return this.f10923c.contains(faceBox.b().x, faceBox.b().y) && max >= width * 0.5f;
    }
}
