package com.facebook.camera.facetracking;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.camera.facetracking.FaceTracker.TrackedFacesListener;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: alpha must be between 0 and 255. */
public class FaceDetectionIndicatorView extends View implements TrackedFacesListener {
    public static final Class<?> f10921c = FaceDetectionIndicatorView.class;
    public static ArrayList<Integer> f10922d = new C10591();
    public int f10923a;
    public int f10924b;
    private Map<Long, Paint> f10925e;
    private Map<Long, Rect> f10926f;
    private Map<Long, Rect> f10927g;
    private AnimatorSet f10928h;
    private Collection<Animator> f10929i;
    private boolean f10930j;

    /* compiled from: alpha must be between 0 and 255. */
    final class C10591 extends ArrayList<Integer> {
        C10591() {
            add(Integer.valueOf(-16711936));
            add(Integer.valueOf(-16776961));
            add(Integer.valueOf(-16711681));
            add(Integer.valueOf(-256));
            add(Integer.valueOf(-65536));
            add(Integer.valueOf(-65281));
        }
    }

    public final void mo1159a(List<TrackedFace> list) {
        if (list == null) {
            this.f10926f.clear();
            for (Long l : this.f10925e.keySet()) {
                f10922d.add(Integer.valueOf(((Paint) this.f10925e.get(l)).getColor()));
            }
            this.f10925e.clear();
        } else {
            Set<Long> a = Sets.a();
            for (Long l2 : this.f10926f.keySet()) {
                a.add(l2);
            }
            for (TrackedFace trackedFace : list) {
                if (!this.f10925e.containsKey(Long.valueOf(trackedFace.f10960l))) {
                    int i;
                    Map map = this.f10925e;
                    Long valueOf = Long.valueOf(trackedFace.f10960l);
                    if (f10922d.size() == 0) {
                        i = -3355444;
                    } else {
                        int random = (int) (Math.random() * ((double) f10922d.size()));
                        i = ((Integer) f10922d.get(random)).intValue();
                        f10922d.remove(random);
                    }
                    Paint paint = new Paint();
                    paint.setColor(i);
                    paint.setStrokeWidth(3.0f);
                    paint.setStyle(Style.STROKE);
                    map.put(valueOf, paint);
                }
                if (this.f10926f.containsKey(Long.valueOf(trackedFace.f10960l))) {
                    this.f10927g.put(Long.valueOf(trackedFace.f10960l), this.f10926f.get(Long.valueOf(trackedFace.f10960l)));
                }
                this.f10926f.put(Long.valueOf(trackedFace.f10960l), m18964a(trackedFace));
                a.remove(Long.valueOf(trackedFace.f10960l));
            }
            for (Long l22 : a) {
                f10922d.add(Integer.valueOf(((Paint) this.f10925e.get(l22)).getColor()));
                this.f10925e.remove(l22);
                this.f10926f.remove(l22);
                this.f10927g.remove(l22);
            }
        }
        invalidate();
    }

    private Rect m18964a(TrackedFace trackedFace) {
        return m18965a(trackedFace, this.f10923a, this.f10924b);
    }

    public static Rect m18965a(TrackedFace trackedFace, int i, int i2) {
        Rect rect = trackedFace.f10954f;
        return new Rect(m18963a((float) rect.left, i), m18963a((float) rect.top, i2), m18963a((float) rect.right, i), m18963a((float) rect.bottom, i2));
    }

    private static int m18963a(float f, int i) {
        return (int) (((1000.0f + f) * ((float) i)) / 2000.0f);
    }

    public final void m18966a() {
        this.f10930j = true;
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        if (this.f10930j) {
            this.f10930j = false;
            return;
        }
        this.f10929i.clear();
        for (Long l : this.f10926f.keySet()) {
            Paint paint = (Paint) this.f10925e.get(l);
            Rect rect = (Rect) this.f10926f.get(l);
            Rect rect2 = (Rect) this.f10927g.get(l);
            if (rect2 == null) {
                canvas.drawRect(rect, paint);
            } else {
                canvas.drawRect(rect2, paint);
                this.f10929i.add(ObjectAnimator.ofFloat(rect2, "translationX", new float[]{(float) rect2.centerX(), (float) rect.centerX()}));
                this.f10929i.add(ObjectAnimator.ofFloat(rect2, "translationY", new float[]{(float) rect2.centerY(), (float) rect.centerY()}));
            }
        }
        this.f10928h.playTogether(this.f10929i);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        this.f10923a = size;
        this.f10924b = size2;
    }
}
