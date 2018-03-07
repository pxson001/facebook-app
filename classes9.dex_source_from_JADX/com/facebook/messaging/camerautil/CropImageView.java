package com.facebook.messaging.camerautil;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.images.ImageViewTouchBase;
import java.util.ArrayList;

/* compiled from: messenger_transcode_failed */
class CropImageView extends ImageViewTouchBase {
    ArrayList<HighlightView> f9652i = new ArrayList();
    HighlightView f9653j = null;
    float f9654k;
    float f9655l;
    int f9656m;

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.c.b != null) {
            int size = this.f9652i.size();
            for (int i5 = 0; i5 < size; i5++) {
                HighlightView highlightView = (HighlightView) this.f9652i.get(i5);
                highlightView.f9663f.set(getImageMatrix());
                highlightView.m10262c();
                if (highlightView.f9659b) {
                    m10248c(highlightView);
                }
            }
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void m10250a(float f, float f2, float f3) {
        super.a(f, f2, f3);
        int size = this.f9652i.size();
        for (int i = 0; i < size; i++) {
            HighlightView highlightView = (HighlightView) this.f9652i.get(i);
            highlightView.f9663f.set(getImageMatrix());
            highlightView.m10262c();
        }
    }

    public final void m10249a(float f, float f2) {
        super.a(f, f2);
        for (int i = 0; i < this.f9652i.size(); i++) {
            HighlightView highlightView = (HighlightView) this.f9652i.get(i);
            highlightView.f9663f.postTranslate(f, f2);
            highlightView.m10262c();
        }
    }

    private void m10246a(MotionEvent motionEvent) {
        int i = 0;
        for (int i2 = 0; i2 < this.f9652i.size(); i2++) {
            HighlightView highlightView = (HighlightView) this.f9652i.get(i2);
            highlightView.f9659b = false;
            highlightView.m10262c();
        }
        while (i < this.f9652i.size()) {
            highlightView = (HighlightView) this.f9652i.get(i);
            if (highlightView.m10255a(motionEvent.getX(), motionEvent.getY()) != 1) {
                if (!highlightView.f9659b) {
                    highlightView.f9659b = true;
                    highlightView.m10262c();
                }
                invalidate();
            }
            i++;
        }
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1869773538);
        CropImage cropImage = (CropImage) getContext();
        if (cropImage.f9643q) {
            Logger.a(2, EntryType.UI_INPUT_END, 564124280, a);
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (!cropImage.f9642p) {
                    for (int i = 0; i < this.f9652i.size(); i++) {
                        HighlightView highlightView = (HighlightView) this.f9652i.get(i);
                        int a2 = highlightView.m10255a(motionEvent.getX(), motionEvent.getY());
                        if (a2 != 1) {
                            this.f9656m = a2;
                            this.f9653j = highlightView;
                            this.f9654k = motionEvent.getX();
                            this.f9655l = motionEvent.getY();
                            this.f9653j.m10259a(a2 == 32 ? ModifyMode.Move : ModifyMode.Grow);
                            break;
                        }
                    }
                    break;
                }
                m10246a(motionEvent);
                break;
            case 1:
                if (cropImage.f9642p) {
                    for (int i2 = 0; i2 < this.f9652i.size(); i2++) {
                        HighlightView highlightView2 = (HighlightView) this.f9652i.get(i2);
                        if (highlightView2.f9659b) {
                            cropImage.f9644r = highlightView2;
                            for (int i3 = 0; i3 < this.f9652i.size(); i3++) {
                                if (i3 != i2) {
                                    ((HighlightView) this.f9652i.get(i3)).f9660c = true;
                                }
                            }
                            m10248c(highlightView2);
                            ((CropImage) getContext()).f9642p = false;
                            LogUtils.a(-765023528, a);
                            return true;
                        }
                    }
                } else if (this.f9653j != null) {
                    m10248c(this.f9653j);
                    this.f9653j.m10259a(ModifyMode.None);
                }
                this.f9653j = null;
                break;
            case 2:
                if (!cropImage.f9642p) {
                    if (this.f9653j != null) {
                        this.f9653j.m10256a(this.f9656m, motionEvent.getX() - this.f9654k, motionEvent.getY() - this.f9655l);
                        this.f9654k = motionEvent.getX();
                        this.f9655l = motionEvent.getY();
                        m10247b(this.f9653j);
                        break;
                    }
                }
                m10246a(motionEvent);
                break;
                break;
        }
        switch (motionEvent.getAction()) {
            case 1:
                a(true, true);
                break;
            case 2:
                if (getScale() == 1.0f) {
                    a(true, true);
                    break;
                }
                break;
        }
        LogUtils.a(-835001438, a);
        return true;
    }

    private void m10247b(HighlightView highlightView) {
        Rect rect = highlightView.f9661d;
        int max = Math.max(0, getLeft() - rect.left);
        int min = Math.min(0, getRight() - rect.right);
        int max2 = Math.max(0, getTop() - rect.top);
        int min2 = Math.min(0, getBottom() - rect.bottom);
        if (max == 0) {
            max = min;
        }
        if (max2 == 0) {
            max2 = min2;
        }
        if (max != 0 || max2 != 0) {
            b((float) max, (float) max2);
        }
    }

    private void m10248c(HighlightView highlightView) {
        Rect rect = highlightView.f9661d;
        float width = (float) getWidth();
        float min = Math.min(1.0f, Math.min((width / ((float) rect.width())) * 0.6f, (((float) getHeight()) / ((float) rect.height())) * 0.6f) * getScale());
        if (((double) (Math.abs(min - getScale()) / min)) > 0.1d) {
            float[] fArr = new float[]{highlightView.f9662e.centerX(), highlightView.f9662e.centerY()};
            getImageMatrix().mapPoints(fArr);
            a(min, fArr[0], fArr[1], 300.0f);
        }
        m10247b(highlightView);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < this.f9652i.size(); i++) {
            ((HighlightView) this.f9652i.get(i)).m10257a(canvas);
        }
    }

    public final void m10251a(HighlightView highlightView) {
        this.f9652i.add(highlightView);
        invalidate();
    }
}
