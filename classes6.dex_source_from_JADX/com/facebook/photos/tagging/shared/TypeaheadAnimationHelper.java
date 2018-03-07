package com.facebook.photos.tagging.shared;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Pair;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.samples.zoomable.AnimatedZoomableController;
import com.facebook.widget.images.zoomableimageview.ZoomableView;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: has_content */
public class TypeaheadAnimationHelper {
    public final Resources f13371a;
    public final float f13372b = this.f13371a.getDimension(2131430298);
    public final float f13373c = this.f13371a.getDimension(2131430299);
    public final float f13374d = this.f13371a.getDimension(2131430303);

    /* compiled from: has_content */
    public class SelectedFaceParams {
        public float f13367a;
        public float f13368b;
        public float f13369c;
        final /* synthetic */ TypeaheadAnimationHelper f13370d;

        public SelectedFaceParams(TypeaheadAnimationHelper typeaheadAnimationHelper) {
            this.f13370d = typeaheadAnimationHelper;
        }
    }

    public static TypeaheadAnimationHelper m21045b(InjectorLike injectorLike) {
        return new TypeaheadAnimationHelper(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TypeaheadAnimationHelper(Resources resources) {
        this.f13371a = resources;
    }

    private Pair<Float, Float> m21042a() {
        float f = ((this.f13372b + this.f13373c) + this.f13374d) - ((float) this.f13371a.getDisplayMetrics().heightPixels);
        float f2 = this.f13372b;
        float f3 = this.f13373c;
        if (f > 0.0f) {
            f3 += f2;
            f = Math.max(f3 - f, 0.0f);
            f2 = f * (f2 / f3);
            f3 = f - f2;
        }
        return Pair.create(Float.valueOf(f2), Float.valueOf(f3));
    }

    public final SelectedFaceParams m21048a(AnimatedZoomableController animatedZoomableController, RectF rectF) {
        RectF rectF2 = new RectF();
        Matrix matrix = new Matrix();
        animatedZoomableController.m7599a(matrix);
        matrix.mapRect(rectF2, rectF);
        return m21044a(rectF2, animatedZoomableController.mo344m(), animatedZoomableController.f4810j);
    }

    public final SelectedFaceParams m21050a(ZoomableView zoomableView, RectF rectF) {
        RectF rectF2 = new RectF(0.0f, 0.0f, rectF.width() * ((float) zoomableView.getPhotoWidth()), rectF.height() * ((float) zoomableView.getPhotoHeight()));
        zoomableView.getPhotoDisplayMatrix().mapRect(rectF2);
        return m21044a(rectF2, zoomableView.getScale(), zoomableView.getMaxZoom());
    }

    private SelectedFaceParams m21044a(RectF rectF, float f, float f2) {
        SelectedFaceParams selectedFaceParams = new SelectedFaceParams(this);
        Pair a = m21042a();
        float floatValue = ((Float) a.first).floatValue();
        float floatValue2 = ((Float) a.second).floatValue();
        float max = (floatValue2 / Math.max(rectF.width(), rectF.height())) * f;
        if (max >= 1.0f) {
            float min = Math.min(max, f2);
            selectedFaceParams.f13368b = (min / max) * floatValue2;
            selectedFaceParams.f13369c = (floatValue2 - selectedFaceParams.f13368b) + floatValue;
            selectedFaceParams.f13367a = min;
        } else {
            selectedFaceParams.f13369c = 0.0f;
            selectedFaceParams.f13368b = floatValue2 + floatValue;
            selectedFaceParams.f13367a = 1.0f;
        }
        return selectedFaceParams;
    }

    public final SelectedFaceParams m21047a(AnimatedZoomableController animatedZoomableController) {
        return m21043a(animatedZoomableController.mo344m());
    }

    public final SelectedFaceParams m21049a(ZoomableView zoomableView) {
        return m21043a(zoomableView.getScale());
    }

    private SelectedFaceParams m21043a(float f) {
        SelectedFaceParams selectedFaceParams = new SelectedFaceParams(this);
        Pair a = m21042a();
        float floatValue = ((Float) a.first).floatValue();
        float floatValue2 = ((Float) a.second).floatValue();
        selectedFaceParams.f13367a = f;
        selectedFaceParams.f13368b = 0.0f;
        selectedFaceParams.f13369c = floatValue2 + floatValue;
        return selectedFaceParams;
    }

    public static RectF m21041a(ZoomableView zoomableView, RectF rectF, Matrix matrix) {
        Preconditions.checkNotNull(rectF);
        Preconditions.checkNotNull(matrix);
        Preconditions.checkNotNull(zoomableView);
        Preconditions.checkState(zoomableView.mo424e());
        RectF rectF2 = new RectF(rectF.left * ((float) zoomableView.getPhotoWidth()), rectF.top * ((float) zoomableView.getPhotoHeight()), rectF.right * ((float) zoomableView.getPhotoWidth()), rectF.bottom * ((float) zoomableView.getPhotoHeight()));
        RectF rectF3 = new RectF();
        matrix.mapRect(rectF3, rectF2);
        return rectF3;
    }

    public static PointF m21040a(ZoomableView zoomableView, PointF pointF, SelectedFaceParams selectedFaceParams) {
        return m21039a(pointF, selectedFaceParams, (float) zoomableView.getPhotoWidth(), (float) zoomableView.getWidth(), zoomableView.mo421b());
    }

    public static PointF m21039a(PointF pointF, SelectedFaceParams selectedFaceParams, float f, float f2, boolean z) {
        float min;
        int i = 1;
        float f3 = f2 / 2.0f;
        if (z) {
            float f4 = selectedFaceParams.f13367a * pointF.x;
            float f5 = f * selectedFaceParams.f13367a;
            min = Math.min(f3, f4);
            f4 = Math.max(f3, f2 - (f5 - f4));
            float f6 = f3 - min;
            float f7 = f4 - f3;
            int i2 = f6 > 0.0f ? 1 : 0;
            if (f7 <= 0.0f) {
                i = 0;
            }
            if ((i ^ i2) == 0) {
                min = f3;
            } else if (f6 <= f7) {
                min = f4;
            }
        } else {
            min = f3;
        }
        return new PointF(min, selectedFaceParams.f13369c + (selectedFaceParams.f13368b / 2.0f));
    }

    public static float m21038a(int i, int i2, RectF rectF) {
        float width = rectF.width() * ((float) i2);
        float height = rectF.height() * ((float) i);
        return (((float) Math.sqrt((double) ((width * width) + (height * height)))) * 0.8f) / 2.0f;
    }

    public final float m21046a(Matrix matrix) {
        Matrix matrix2 = new Matrix();
        matrix.invert(matrix2);
        RectF rectF = new RectF(0.0f, 0.0f, this.f13373c, this.f13373c);
        matrix2.mapRect(rectF);
        return ((0.8f * ((float) Math.sqrt(2.0d))) * rectF.width()) / 2.0f;
    }
}
