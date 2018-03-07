package com.facebook.photos.tagging.shared.layout;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.facebook.inject.Assisted;
import com.facebook.photos.tagging.shared.BubbleLayout.ArrowDirection;
import com.facebook.samples.zoomable.AnimatedZoomableController;
import com.facebook.widget.images.zoomableimageview.ZoomableView;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: guest_list_state */
public class TagsViewLayoutHelper<TAGVIEW extends View & LayoutableTagView> {
    public static final RectF f13395a = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    private View f13396b;
    private List<TagWithFacebox> f13397c = Collections.EMPTY_LIST;
    private List<DummyTagView> f13398d = Lists.a();
    private List<TAGVIEW> f13399e = Collections.EMPTY_LIST;
    private List<RectF> f13400f;
    private DummyTagViewProvider f13401g;
    private final float[] f13402h = new float[2];
    private final Matrix f13403i = new Matrix();
    private InsetContainerBounds f13404j = new InsetContainerBounds();
    private Rect f13405k = new Rect();
    private boolean f13406l;
    private float f13407m;

    /* compiled from: guest_list_state */
    public class PhotoMatrices {
        @Nullable
        public final Matrix f13391a;
        @Nullable
        public final Matrix f13392b;
        @Nullable
        public final Matrix f13393c;
        @Nullable
        public final Matrix f13394d;

        public PhotoMatrices(Matrix matrix, Matrix matrix2, Matrix matrix3) {
            this.f13391a = matrix;
            this.f13392b = matrix2;
            this.f13393c = matrix3;
            this.f13394d = null;
        }

        public PhotoMatrices(Matrix matrix) {
            this.f13391a = null;
            this.f13392b = null;
            this.f13393c = null;
            this.f13394d = matrix;
        }
    }

    private void m21067a(PhotoMatrices photoMatrices, DummyTagView dummyTagView) {
        PointF a = m21064a(photoMatrices, dummyTagView.f13383c, this.f13396b.getWidth(), this.f13396b.getHeight(), (float) dummyTagView.f13386f.f13387a.height(), 0.0f);
        float f = a.x;
        float f2 = a.y;
        ((LayoutableTagView) dummyTagView.f13384d).m21061a(dummyTagView.f13382b, dummyTagView.f13386f);
        dummyTagView.f13386f.f13387a.offset((int) f, (int) f2);
        dummyTagView.f13386f.f13388b.offset((int) f, (int) f2);
    }

    @Inject
    public TagsViewLayoutHelper(@Assisted View view, @Assisted float f, DummyTagViewProvider dummyTagViewProvider) {
        this.f13396b = view;
        this.f13400f = Lists.a();
        this.f13401g = dummyTagViewProvider;
        this.f13407m = f;
    }

    public final void m21076a(Collection<RectF> collection) {
        Preconditions.checkNotNull(collection);
        this.f13400f.clear();
        this.f13400f.addAll(collection);
        this.f13406l = true;
    }

    public final void m21077a(Map<TAGVIEW, TagWithFacebox> map) {
        this.f13399e = Lists.a(((Map) Preconditions.checkNotNull(map)).keySet());
        this.f13397c = Lists.a();
        for (View view : this.f13399e) {
            this.f13397c.add(map.get(view));
        }
        this.f13406l = true;
    }

    public final void m21073a() {
        if (!this.f13397c.isEmpty() && this.f13396b != null) {
            PhotoMatrices photoMatrices;
            View view = this.f13396b;
            Preconditions.checkNotNull(view);
            if (view.getWidth() <= 0 || view.getHeight() <= 0) {
                photoMatrices = null;
            } else {
                Matrix matrix = new Matrix();
                matrix.setRectToRect(f13395a, new RectF(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight()), ScaleToFit.FILL);
                Matrix matrix2 = new Matrix();
                photoMatrices = new PhotoMatrices(matrix, matrix2, matrix2);
            }
            PhotoMatrices photoMatrices2 = photoMatrices;
            if (photoMatrices2 != null) {
                m21070b(photoMatrices2, false);
            }
        }
    }

    public final void m21075a(ZoomableView zoomableView, boolean z) {
        PhotoMatrices photoMatrices;
        Preconditions.checkNotNull(zoomableView);
        if (zoomableView.mo424e()) {
            Matrix matrix = new Matrix();
            Matrix baseMatrix = zoomableView.getBaseMatrix();
            Matrix photoDisplayMatrix = zoomableView.getPhotoDisplayMatrix();
            matrix.setRectToRect(f13395a, new RectF(0.0f, 0.0f, (float) zoomableView.getPhotoWidth(), (float) zoomableView.getPhotoHeight()), ScaleToFit.FILL);
            photoMatrices = new PhotoMatrices(matrix, baseMatrix, photoDisplayMatrix);
        } else {
            photoMatrices = null;
        }
        m21068a(photoMatrices, z);
    }

    private void m21068a(PhotoMatrices photoMatrices, boolean z) {
        if (photoMatrices != null) {
            m21070b(photoMatrices, z);
        }
    }

    private void m21070b(PhotoMatrices photoMatrices, boolean z) {
        if (!this.f13406l) {
            m21071c(photoMatrices, z);
        } else if (m21072d(photoMatrices, z)) {
            this.f13406l = false;
        }
    }

    private void m21071c(PhotoMatrices photoMatrices, boolean z) {
        Preconditions.checkNotNull(photoMatrices);
        int size = this.f13397c.size();
        int i = 0;
        while (i < size) {
            View view = (View) this.f13399e.get(i);
            if (view != null && view.getWidth() != 0 && view.getHeight() != 0) {
                m21066a(photoMatrices, view, ((DummyTagView) this.f13398d.get(i)).f13383c, z);
                i++;
            } else {
                return;
            }
        }
    }

    private boolean m21072d(PhotoMatrices photoMatrices, boolean z) {
        int size = this.f13397c.size();
        if (size <= 0) {
            return true;
        }
        int i;
        int i2;
        int length = ArrowDirection.values().length;
        ArrowDirection[] values = ArrowDirection.values();
        ArrowDirection[] arrowDirectionArr = new ArrowDirection[size];
        ArrowDirection[] arrowDirectionArr2 = new ArrowDirection[size];
        this.f13398d.clear();
        boolean[] zArr = new boolean[size];
        int dimension = (int) this.f13396b.getResources().getDimension(2131430309);
        for (i = 0; i < size; i++) {
            View view = (View) this.f13399e.get(i);
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                return false;
            }
            this.f13398d.add(DummyTagViewProvider.m21055a((LayoutableTagView) view, Integer.valueOf(dimension), (TagWithFacebox) this.f13397c.get(i)));
            zArr[i] = false;
            arrowDirectionArr[i] = DummyTagView.f13381a;
            arrowDirectionArr2[i] = DummyTagView.f13381a;
        }
        Rect[] rectArr = new Rect[this.f13400f.size()];
        for (i2 = 0; i2 < rectArr.length; i2++) {
            rectArr[i2] = m21065a((RectF) this.f13400f.get(i2), photoMatrices);
        }
        i = 0;
        i2 = 0;
        int i3 = 0;
        while (i < size) {
            int i4;
            this.f13399e.get(i);
            DummyTagView dummyTagView = (DummyTagView) this.f13398d.get(i);
            dimension = Math.max(i2, i);
            int ordinal = arrowDirectionArr2[i].ordinal();
            i2 = i3;
            while (ordinal < length) {
                arrowDirectionArr2[i] = values[ordinal];
                ArrowDirection a = dummyTagView.m21051a();
                dummyTagView.m21052a(arrowDirectionArr2[i]);
                m21067a(photoMatrices, dummyTagView);
                i3 = m21063a(i, this.f13398d, rectArr);
                if (i3 > i2) {
                    for (i2 = 0; i2 <= i; i2++) {
                        arrowDirectionArr[i2] = arrowDirectionArr2[i2];
                    }
                    i2 = i3;
                }
                if (i3 == i + 1) {
                    break;
                }
                dummyTagView.m21052a(a);
                ordinal++;
            }
            i3 = i2;
            if (ordinal < length) {
                i4 = i + 1;
                if (i4 < size - 1) {
                    arrowDirectionArr2[i4] = DummyTagView.f13381a;
                    i = i4;
                    i2 = dimension;
                }
            } else if (i <= 0 || zArr[i - 1] || arrowDirectionArr2[i - 1].ordinal() >= length - 1) {
                for (i2 = 0; i2 <= dimension; i2++) {
                    ((DummyTagView) this.f13398d.get(i2)).m21052a(arrowDirectionArr[i2]);
                    arrowDirectionArr2[i2] = arrowDirectionArr[i2];
                    zArr[i2] = true;
                    m21067a(photoMatrices, (DummyTagView) this.f13398d.get(i2));
                }
                i4 = dimension + 1;
            } else {
                i4 = i - 1;
                arrowDirectionArr2[i4] = values[arrowDirectionArr2[i4].ordinal() + 1];
                i = i4;
                i2 = dimension;
            }
            i = i4;
            i2 = dimension;
        }
        for (ordinal = 0; ordinal < size; ordinal++) {
            view = (View) this.f13399e.get(ordinal);
            ((LayoutableTagView) view).setArrowDirection(((DummyTagView) this.f13398d.get(ordinal)).m21051a());
            m21066a(photoMatrices, view, ((DummyTagView) this.f13398d.get(ordinal)).m21053b(), z);
        }
        return true;
    }

    private void m21066a(PhotoMatrices photoMatrices, TAGVIEW tagview, PointF pointF, boolean z) {
        RectF rectF = new RectF(f13395a);
        if (photoMatrices.f13394d != null) {
            photoMatrices.f13394d.mapRect(rectF);
        } else {
            Preconditions.checkNotNull(photoMatrices.f13391a);
            Preconditions.checkNotNull(photoMatrices.f13393c);
            photoMatrices.f13391a.mapRect(rectF);
            photoMatrices.f13393c.mapRect(rectF);
        }
        ((LayoutableTagView) tagview).m21061a(((LayoutableTagView) tagview).getArrowDirection(), this.f13404j);
        int width = this.f13404j.f13387a.width();
        int height = this.f13404j.f13387a.height();
        PointF a = m21064a(photoMatrices, pointF, this.f13396b.getWidth(), this.f13396b.getHeight(), (float) height, (float) ((LayoutableTagView) tagview).getArrowLength());
        PointF pointF2 = new PointF(a.x, a.y);
        pointF2.offset((float) this.f13404j.f13388b.left, (float) this.f13404j.f13388b.top);
        if ((((LayoutableTagView) tagview).getArrowDirection() == ArrowDirection.UP || ((LayoutableTagView) tagview).getArrowDirection() == ArrowDirection.DOWN) && !z) {
            int a2 = (int) ((m21062a(a, rectF, (float) this.f13396b.getWidth(), (float) width) * ((float) width)) - ((float) (width / 2)));
            ((LayoutableTagView) tagview).m21060a(a2);
            pointF2.offset((float) (-a2), 0.0f);
        }
        tagview.setX(pointF2.x);
        tagview.setY(pointF2.y);
    }

    private PointF m21064a(PhotoMatrices photoMatrices, PointF pointF, int i, int i2, float f, float f2) {
        this.f13402h[0] = pointF.x;
        this.f13402h[1] = pointF.y;
        if (photoMatrices.f13394d != null) {
            photoMatrices.f13394d.mapPoints(this.f13402h);
        } else {
            Preconditions.checkNotNull(photoMatrices.f13391a);
            Preconditions.checkNotNull(photoMatrices.f13392b);
            photoMatrices.f13391a.mapPoints(this.f13402h);
            photoMatrices.f13392b.mapPoints(this.f13402h);
            this.f13402h[0] = Math.max(Math.min(this.f13402h[0], ((float) i) - f2), f2);
            this.f13402h[1] = Math.min(this.f13402h[1], (((float) i2) - this.f13407m) - f);
            photoMatrices.f13392b.invert(this.f13403i);
            this.f13403i.mapPoints(this.f13402h);
            photoMatrices.f13393c.mapPoints(this.f13402h);
        }
        return new PointF(this.f13402h[0], this.f13402h[1]);
    }

    private boolean m21069a(Rect rect, Rect rect2) {
        if (!this.f13405k.setIntersect(rect, rect2)) {
            return false;
        }
        float width = (float) (rect2.width() * rect2.height());
        float width2 = (float) (this.f13405k.width() * this.f13405k.height());
        if (width2 / ((float) (rect.width() * rect.height())) > 0.1f || width2 / width > 0.1f) {
            return true;
        }
        return false;
    }

    private int m21063a(int i, List<DummyTagView> list, Rect[] rectArr) {
        int i2 = i + 1;
        int i3 = 0;
        while (i3 <= i && i3 < list.size()) {
            int i4;
            Rect c = ((DummyTagView) list.get(i3)).m21054c();
            if (c.top < 0 || c.bottom > this.f13396b.getHeight() || !((c.left >= 0 && c.right <= this.f13396b.getWidth()) || ((DummyTagView) list.get(i3)).f13382b == ArrowDirection.DOWN || ((DummyTagView) list.get(i3)).f13382b == ArrowDirection.UP)) {
                i4 = i2 - 1;
            } else {
                int i5;
                Object obj;
                for (i5 = i3 + 1; i5 < list.size(); i5++) {
                    if (m21069a(c, ((DummyTagView) list.get(i5)).m21054c())) {
                        i5 = i2 - 1;
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                i5 = i2;
                if (obj == null) {
                    for (Rect a : rectArr) {
                        if (m21069a(c, a)) {
                            i4 = i5 - 1;
                            break;
                        }
                    }
                }
                i4 = i5;
            }
            i3++;
            i2 = i4;
        }
        return i2;
    }

    private static float m21062a(PointF pointF, RectF rectF, float f, float f2) {
        float min = pointF.x - Math.min(rectF.left, 0.0f);
        float max = Math.max(rectF.right, f) - pointF.x;
        if (min < f2 / 2.0f) {
            return min / f2;
        }
        if (max < f2 / 2.0f) {
            return (f2 - max) / f2;
        }
        return 0.5f;
    }

    @Nullable
    private static Rect m21065a(RectF rectF, PhotoMatrices photoMatrices) {
        RectF rectF2 = new RectF();
        if (photoMatrices.f13394d != null) {
            photoMatrices.f13394d.mapRect(rectF2, rectF);
        } else {
            Preconditions.checkNotNull(photoMatrices.f13391a);
            Preconditions.checkNotNull(photoMatrices.f13393c);
            photoMatrices.f13391a.mapRect(rectF2, rectF);
            photoMatrices.f13393c.mapRect(rectF2);
        }
        return new Rect((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom);
    }

    public final void m21074a(AnimatedZoomableController animatedZoomableController, boolean z) {
        Matrix matrix = new Matrix();
        animatedZoomableController.m7599a(matrix);
        m21068a(new PhotoMatrices(matrix), z);
    }
}
