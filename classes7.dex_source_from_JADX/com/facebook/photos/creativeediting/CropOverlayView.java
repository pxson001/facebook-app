package com.facebook.photos.creativeediting;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger.LoggingParameters;
import com.facebook.photos.creativeediting.interfaces.UriAwarePhotoOverlayItem;
import com.facebook.photos.creativeediting.renderers.MovableItemContainer;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsHelper;
import com.facebook.photos.editgallery.CropEditController.C08564;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: magic_stories_feed_prompt_tapped */
public class CropOverlayView extends View {
    public float f9463A;
    public float f9464B;
    public float f9465C;
    @Nullable
    public C08564 f9466D;
    public LoggingParameters f9467E;
    public boolean f9468F = false;
    public CropMode f9469G = CropMode.FREE_FORM;
    public boolean f9470H = true;
    private MovableItemContainer f9471I;
    private final Rect f9472a = new Rect();
    public Mode f9473b;
    public float f9474c;
    public float f9475d;
    public boolean f9476e = false;
    public boolean f9477f = false;
    public boolean f9478g = false;
    public boolean f9479h = false;
    public boolean f9480i = false;
    public boolean f9481j = false;
    public boolean f9482k = false;
    public boolean f9483l = false;
    public float f9484m;
    public float f9485n;
    public float f9486o;
    public float f9487p;
    public float f9488q;
    public RectF f9489r = new RectF();
    private RectF f9490s = new RectF();
    public RectF f9491t = new RectF();
    public Paint f9492u;
    public Paint f9493v;
    public Paint f9494w;
    public Paint f9495x;
    public Paint f9496y;
    public float f9497z;

    /* compiled from: magic_stories_feed_prompt_tapped */
    public class C07731 implements OnTouchListener {
        final /* synthetic */ CropOverlayView f9462a;

        public C07731(CropOverlayView cropOverlayView) {
            this.f9462a = cropOverlayView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z = false;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            CropOverlayView cropOverlayView;
            CropOverlayView cropOverlayView2;
            switch (motionEvent.getAction()) {
                case 0:
                    boolean z2;
                    this.f9462a.f9468F = true;
                    this.f9462a.f9474c = x;
                    this.f9462a.f9475d = y;
                    CropOverlayView cropOverlayView3 = this.f9462a;
                    if (Math.abs(x - this.f9462a.f9491t.left) < this.f9462a.f9463A) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    cropOverlayView3.f9476e = z2;
                    cropOverlayView3 = this.f9462a;
                    if (Math.abs(x - this.f9462a.f9491t.right) < this.f9462a.f9463A) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    cropOverlayView3.f9477f = z2;
                    cropOverlayView3 = this.f9462a;
                    if (Math.abs(y - this.f9462a.f9491t.top) < this.f9462a.f9463A) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    cropOverlayView3.f9478g = z2;
                    cropOverlayView3 = this.f9462a;
                    if (Math.abs(y - this.f9462a.f9491t.bottom) < this.f9462a.f9463A) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    cropOverlayView3.f9479h = z2;
                    this.f9462a.f9480i = this.f9462a.f9476e & this.f9462a.f9478g;
                    this.f9462a.f9481j = this.f9462a.f9476e & this.f9462a.f9479h;
                    this.f9462a.f9482k = this.f9462a.f9477f & this.f9462a.f9478g;
                    this.f9462a.f9483l = this.f9462a.f9477f & this.f9462a.f9479h;
                    if (!this.f9462a.f9470H || (!this.f9462a.f9480i && !this.f9462a.f9481j && !this.f9462a.f9482k && !this.f9462a.f9483l)) {
                        if (!this.f9462a.f9476e && !this.f9462a.f9477f && !this.f9462a.f9478g && !this.f9462a.f9479h) {
                            if (this.f9462a.f9491t.contains(x, y)) {
                                this.f9462a.f9473b = Mode.MOVE;
                                break;
                            }
                        } else if (this.f9462a.f9469G != CropMode.FREE_FORM) {
                            if (this.f9462a.f9470H) {
                                boolean z3;
                                z2 = Math.abs(x - this.f9462a.f9491t.left) < Math.abs(x - this.f9462a.f9491t.right);
                                boolean z4;
                                if (Math.abs(y - this.f9462a.f9491t.top) < Math.abs(y - this.f9462a.f9491t.bottom)) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                cropOverlayView3 = this.f9462a;
                                if ((this.f9462a.f9476e && r3) || (this.f9462a.f9478g && z2)) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                cropOverlayView3.f9480i = z3;
                                cropOverlayView3 = this.f9462a;
                                if (!(this.f9462a.f9477f && r3) && (!this.f9462a.f9478g || z2)) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                cropOverlayView3.f9482k = z3;
                                cropOverlayView3 = this.f9462a;
                                if ((!this.f9462a.f9476e || r3) && !(this.f9462a.f9479h && z2)) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                cropOverlayView3.f9481j = z3;
                                cropOverlayView = this.f9462a;
                                if ((this.f9462a.f9477f && !r3) || (this.f9462a.f9479h && !z2)) {
                                    z = true;
                                }
                                cropOverlayView.f9483l = z;
                                this.f9462a.f9473b = Mode.RESIZE_WITH_RATIO;
                                break;
                            }
                        } else {
                            this.f9462a.f9473b = Mode.RESIZE;
                            break;
                        }
                    }
                    this.f9462a.f9473b = Mode.RESIZE_WITH_RATIO;
                    break;
                    break;
                case 1:
                    this.f9462a.f9468F = false;
                    this.f9462a.f9473b = null;
                    cropOverlayView2 = this.f9462a;
                    CropOverlayView cropOverlayView4 = this.f9462a;
                    cropOverlayView = this.f9462a;
                    this.f9462a.f9479h = false;
                    z = false;
                    cropOverlayView.f9478g = z;
                    z = z;
                    cropOverlayView4.f9477f = z;
                    cropOverlayView2.f9476e = z;
                    if (this.f9462a.f9466D != null) {
                        LoggingParameters loggingParameters = this.f9462a.f9467E;
                        loggingParameters.f9521h++;
                        this.f9462a.f9466D.m12040a(new RectF(this.f9462a.f9491t), true);
                    }
                    this.f9462a.invalidate();
                    break;
                case 2:
                    this.f9462a.f9468F = true;
                    if (this.f9462a.f9473b == Mode.RESIZE_WITH_RATIO) {
                        this.f9462a.m11421b(x, y);
                    } else if (this.f9462a.f9473b == Mode.RESIZE) {
                        RectF rectF;
                        float max;
                        cropOverlayView2 = this.f9462a;
                        if (Math.abs(x - cropOverlayView2.f9474c) > cropOverlayView2.f9464B) {
                            if (cropOverlayView2.f9476e && (x < cropOverlayView2.f9474c || cropOverlayView2.f9491t.width() - (x - cropOverlayView2.f9474c) > cropOverlayView2.f9465C)) {
                                cropOverlayView2.f9486o = Math.max(cropOverlayView2.f9486o + (x - cropOverlayView2.f9474c), cropOverlayView2.f9489r.left);
                                if (x >= cropOverlayView2.f9474c || cropOverlayView2.f9486o - cropOverlayView2.f9489r.left >= cropOverlayView2.f9488q) {
                                    rectF = cropOverlayView2.f9491t;
                                    max = Math.abs((cropOverlayView2.f9491t.right - cropOverlayView2.f9486o) - cropOverlayView2.f9491t.height()) < cropOverlayView2.f9488q ? Math.max(cropOverlayView2.f9491t.right - cropOverlayView2.f9491t.height(), cropOverlayView2.f9489r.left) : cropOverlayView2.f9486o;
                                } else {
                                    rectF = cropOverlayView2.f9491t;
                                    max = cropOverlayView2.f9489r.left;
                                    cropOverlayView2.f9486o = max;
                                }
                                rectF.left = max;
                            }
                            if (cropOverlayView2.f9477f && (x > cropOverlayView2.f9474c || cropOverlayView2.f9491t.width() + (x - cropOverlayView2.f9474c) > cropOverlayView2.f9465C)) {
                                cropOverlayView2.f9487p = Math.min(cropOverlayView2.f9487p + (x - cropOverlayView2.f9474c), cropOverlayView2.f9489r.right);
                                if (x <= cropOverlayView2.f9474c || cropOverlayView2.f9489r.right - cropOverlayView2.f9487p >= cropOverlayView2.f9488q) {
                                    rectF = cropOverlayView2.f9491t;
                                    max = Math.abs((cropOverlayView2.f9487p - cropOverlayView2.f9491t.left) - cropOverlayView2.f9491t.height()) < cropOverlayView2.f9488q ? Math.min(cropOverlayView2.f9491t.left + cropOverlayView2.f9491t.height(), cropOverlayView2.f9489r.right) : cropOverlayView2.f9487p;
                                } else {
                                    rectF = cropOverlayView2.f9491t;
                                    max = cropOverlayView2.f9489r.right;
                                    cropOverlayView2.f9487p = max;
                                }
                                rectF.right = max;
                            }
                        }
                        if (Math.abs(y - cropOverlayView2.f9475d) > cropOverlayView2.f9464B) {
                            if (cropOverlayView2.f9478g && (y < cropOverlayView2.f9475d || cropOverlayView2.f9491t.height() - (y - cropOverlayView2.f9475d) > cropOverlayView2.f9465C)) {
                                cropOverlayView2.f9485n = Math.max(cropOverlayView2.f9485n + (y - cropOverlayView2.f9475d), cropOverlayView2.f9489r.top);
                                if (y >= cropOverlayView2.f9475d || cropOverlayView2.f9485n - cropOverlayView2.f9489r.top >= cropOverlayView2.f9488q) {
                                    rectF = cropOverlayView2.f9491t;
                                    max = Math.abs((cropOverlayView2.f9491t.bottom - cropOverlayView2.f9485n) - cropOverlayView2.f9491t.width()) < cropOverlayView2.f9488q ? Math.max(cropOverlayView2.f9491t.bottom - cropOverlayView2.f9491t.width(), cropOverlayView2.f9489r.top) : cropOverlayView2.f9485n;
                                } else {
                                    rectF = cropOverlayView2.f9491t;
                                    max = cropOverlayView2.f9489r.top;
                                    cropOverlayView2.f9485n = max;
                                }
                                rectF.top = max;
                            }
                            if (cropOverlayView2.f9479h && (y > cropOverlayView2.f9475d || cropOverlayView2.f9491t.height() + (y - cropOverlayView2.f9475d) > cropOverlayView2.f9465C)) {
                                cropOverlayView2.f9484m = Math.min(cropOverlayView2.f9484m + (y - cropOverlayView2.f9475d), cropOverlayView2.f9489r.bottom);
                                if (y <= cropOverlayView2.f9475d || cropOverlayView2.f9489r.bottom - cropOverlayView2.f9484m >= cropOverlayView2.f9488q) {
                                    rectF = cropOverlayView2.f9491t;
                                    max = Math.abs((cropOverlayView2.f9484m - cropOverlayView2.f9491t.top) - cropOverlayView2.f9491t.width()) < cropOverlayView2.f9488q ? Math.min(cropOverlayView2.f9491t.top + cropOverlayView2.f9491t.width(), cropOverlayView2.f9489r.bottom) : cropOverlayView2.f9484m;
                                } else {
                                    rectF = cropOverlayView2.f9491t;
                                    max = cropOverlayView2.f9489r.bottom;
                                    cropOverlayView2.f9484m = max;
                                }
                                rectF.bottom = max;
                            }
                        }
                        cropOverlayView2.f9467E.f9519f = true;
                        cropOverlayView2.invalidate();
                    } else if (this.f9462a.f9473b != Mode.MOVE) {
                        return false;
                    } else {
                        CropOverlayView.m11422c(this.f9462a, x, y);
                    }
                    this.f9462a.f9474c = x;
                    this.f9462a.f9475d = y;
                    break;
            }
            return true;
        }
    }

    /* compiled from: magic_stories_feed_prompt_tapped */
    public enum CropMode {
        FREE_FORM,
        SQUARE
    }

    /* compiled from: magic_stories_feed_prompt_tapped */
    enum Mode {
        MOVE,
        RESIZE,
        RESIZE_WITH_RATIO
    }

    public CropOverlayView(Context context) {
        super(context);
        m11423a();
        setOnTouchListener(new C07731(this));
        float f = getResources().getDisplayMetrics().density;
        float f2 = 1.0f * f;
        float f3 = 2.0f * f;
        float f4 = 1.5f * f;
        this.f9497z = 7.0f * f;
        this.f9463A = 30.0f * f;
        this.f9464B = f2;
        this.f9465C = 80.0f * f;
        this.f9488q = f * 7.0f;
        this.f9492u = new Paint();
        this.f9492u.setColor(-1509949441);
        this.f9492u.setStyle(Style.STROKE);
        this.f9492u.setAntiAlias(true);
        this.f9492u.setStrokeWidth(f2);
        this.f9493v = new Paint();
        this.f9493v.setColor(-16745729);
        this.f9493v.setStyle(Style.STROKE);
        this.f9493v.setAntiAlias(true);
        this.f9493v.setStrokeWidth(f3);
        this.f9494w = new Paint();
        this.f9494w.setColor(-1509949441);
        this.f9494w.setAlpha(150);
        this.f9494w.setStyle(Style.FILL);
        this.f9495x = new Paint();
        this.f9495x.setColor(-1);
        this.f9495x.setStyle(Style.FILL);
        this.f9496y = new Paint();
        this.f9496y.setColor(-16745729);
        this.f9496y.setStyle(Style.STROKE);
        this.f9496y.setStrokeWidth(f4);
        setContentDescription(getResources().getText(2131234480));
        this.f9467E = new LoggingParameters();
    }

    public void setCropMode(CropMode cropMode) {
        Preconditions.checkNotNull(cropMode);
        this.f9469G = cropMode;
        if (cropMode == CropMode.FREE_FORM) {
            this.f9491t = new RectF(this.f9489r);
            this.f9470H = false;
        } else {
            float abs = Math.abs(this.f9489r.width() - this.f9489r.height());
            if (this.f9489r.width() > this.f9489r.height()) {
                this.f9491t = new RectF(this.f9489r.left + (abs / 2.0f), this.f9489r.top, this.f9489r.right - (abs / 2.0f), this.f9489r.bottom);
            } else {
                this.f9491t = new RectF(this.f9489r.left, this.f9489r.top + (abs / 2.0f), this.f9489r.right, this.f9489r.bottom - (abs / 2.0f));
            }
            this.f9470H = true;
        }
        this.f9484m = this.f9491t.bottom;
        this.f9485n = this.f9491t.top;
        this.f9486o = this.f9491t.left;
        this.f9487p = this.f9491t.right;
        if (!(this.f9466D == null || (this.f9491t.left == 0.0f && this.f9491t.top == 0.0f && this.f9491t.right == 0.0f && this.f9491t.bottom == 0.0f))) {
            this.f9466D.m12040a(new RectF(this.f9491t), true);
        }
        invalidate();
    }

    public final void m11425a(List<? extends UriAwarePhotoOverlayItem> list, MovableItemContainer movableItemContainer) {
        this.f9471I = (MovableItemContainer) Preconditions.checkNotNull(movableItemContainer);
        setAdjustableOverlayItems(list);
    }

    public void setOnCropChangeListener(C08564 c08564) {
        this.f9466D = (C08564) Preconditions.checkNotNull(c08564);
    }

    public final void m11424a(RectF rectF, RectF rectF2, @Nullable RectF rectF3) {
        Preconditions.checkState(getLayoutParams() instanceof LayoutParams, "Expected the container to be a FrameLayout.");
        this.f9489r = new RectF();
        RectF rectF4 = new RectF(Math.abs(rectF2.left - rectF.left), Math.abs(rectF2.top - rectF.top), (rectF.right - rectF.left) + Math.abs(rectF2.left - rectF.left), (rectF.bottom - rectF.top) + Math.abs(rectF2.top - rectF.top));
        if (rectF3 == null) {
            this.f9491t = new RectF(rectF4);
        } else {
            Matrix matrix = new Matrix();
            matrix.setRectToRect(this.f9489r, rectF4, ScaleToFit.CENTER);
            matrix.mapRect(this.f9491t, rectF3);
            if (this.f9466D != null) {
                this.f9466D.m12040a(new RectF(this.f9491t), false);
            }
        }
        this.f9484m = this.f9491t.bottom;
        this.f9485n = this.f9491t.top;
        this.f9486o = this.f9491t.left;
        this.f9487p = this.f9491t.right;
        this.f9489r = rectF4;
        this.f9490s = new RectF(rectF2);
        ViewGroup.LayoutParams layoutParams = new LayoutParams((int) this.f9490s.width(), (int) this.f9490s.height());
        layoutParams.topMargin = (int) this.f9490s.top;
        layoutParams.leftMargin = (int) this.f9490s.left;
        setLayoutParams(layoutParams);
    }

    public final void m11423a() {
        setVisibility(4);
    }

    private void setAdjustableOverlayItems(List<? extends UriAwarePhotoOverlayItem> list) {
        if (list != null && !list.isEmpty()) {
            this.f9471I.m11523j();
            for (UriAwarePhotoOverlayItem a : list) {
                this.f9471I.m11509a(a, (Callback) this);
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        if (!(this.f9471I == null || this.f9466D == null)) {
            ImmutableList immutableList;
            C08564 c08564 = this.f9466D;
            RectF rectF = c08564.f10167a.f10214x != null ? c08564.f10167a.f10214x : c08564.f10167a.f10179E;
            if (rectF == null) {
                immutableList = null;
            } else {
                rectF.round(c08564.f10167a.f10209s);
                immutableList = SwipeableParamsHelper.m11714b(c08564.f10167a.f10211u.f10295p, c08564.f10167a.f10212v.a());
            }
            List list = immutableList;
            if (list != null) {
                setAdjustableOverlayItems(list);
                this.f9491t.round(this.f9472a);
                this.f9471I.m11506a(canvas, this.f9472a);
            }
        }
        float width = this.f9491t.width() / 3.0f;
        float height = this.f9491t.height() / 3.0f;
        canvas.drawRect(new RectF(this.f9489r.left, this.f9489r.top, this.f9489r.right, this.f9491t.top), this.f9494w);
        canvas.drawRect(new RectF(this.f9489r.left, this.f9491t.bottom, this.f9489r.right, this.f9489r.bottom), this.f9494w);
        canvas.drawRect(new RectF(this.f9489r.left, this.f9491t.top, this.f9491t.left, this.f9491t.bottom), this.f9494w);
        canvas.drawRect(new RectF(this.f9491t.right, this.f9491t.top, this.f9489r.right, this.f9491t.bottom), this.f9494w);
        if (this.f9468F) {
            canvas.drawRect(this.f9491t.left + width, this.f9491t.top, this.f9491t.left + (width * 2.0f), this.f9491t.bottom, this.f9492u);
            canvas.drawRect(this.f9491t.left, this.f9491t.top + height, this.f9491t.right, (2.0f * height) + this.f9491t.top, this.f9492u);
        }
        canvas.drawRect(this.f9491t, this.f9493v);
        canvas.drawCircle(this.f9491t.left, this.f9491t.top, this.f9497z, this.f9495x);
        canvas.drawCircle(this.f9491t.left, this.f9491t.top, this.f9497z, this.f9496y);
        canvas.drawCircle(this.f9491t.left, this.f9491t.bottom, this.f9497z, this.f9495x);
        canvas.drawCircle(this.f9491t.left, this.f9491t.bottom, this.f9497z, this.f9496y);
        canvas.drawCircle(this.f9491t.right, this.f9491t.top, this.f9497z, this.f9495x);
        canvas.drawCircle(this.f9491t.right, this.f9491t.top, this.f9497z, this.f9496y);
        canvas.drawCircle(this.f9491t.right, this.f9491t.bottom, this.f9497z, this.f9495x);
        canvas.drawCircle(this.f9491t.right, this.f9491t.bottom, this.f9497z, this.f9496y);
        canvas.restore();
    }

    private void m11421b(float f, float f2) {
        float abs = Math.abs(f - this.f9474c);
        float abs2 = Math.abs(f2 - this.f9475d);
        float width = this.f9491t.width() / this.f9491t.height();
        if (abs > this.f9464B || abs2 > this.f9464B) {
            float f3;
            float width2;
            if (abs > abs2) {
                if (this.f9491t.width() != 0.0f) {
                    f3 = f - this.f9474c;
                    width2 = ((f - this.f9474c) / this.f9491t.width()) * this.f9491t.height();
                } else {
                    return;
                }
            } else if (this.f9491t.height() != 0.0f) {
                f3 = this.f9491t.width() * ((f2 - this.f9475d) / this.f9491t.height());
                width2 = f2 - this.f9475d;
            } else {
                return;
            }
            Object obj = f < this.f9474c ? 1 : null;
            Object obj2 = f > this.f9474c ? 1 : null;
            Object obj3 = f2 < this.f9475d ? 1 : null;
            Object obj4 = f2 > this.f9475d ? 1 : null;
            Object obj5 = this.f9491t.width() - f3 > this.f9465C ? 1 : null;
            Object obj6 = this.f9491t.width() + f3 > this.f9465C ? 1 : null;
            Object obj7 = this.f9491t.height() - width2 > this.f9465C ? 1 : null;
            Object obj8 = this.f9491t.height() + width2 > this.f9465C ? 1 : null;
            RectF rectF;
            RectF rectF2;
            RectF rectF3;
            if (this.f9480i) {
                if (!((obj == null && obj5 == null) || (obj3 == null && obj7 == null))) {
                    if (this.f9491t.left + f3 < this.f9489r.left) {
                        rectF = this.f9491t;
                        f3 = this.f9489r.left;
                        this.f9486o = f3;
                        rectF.left = f3;
                        rectF = this.f9491t;
                        f3 = this.f9491t.bottom - (this.f9491t.width() / width);
                        this.f9485n = f3;
                        rectF.top = f3;
                    } else if (this.f9491t.top + width2 < this.f9489r.top) {
                        rectF = this.f9491t;
                        f3 = this.f9489r.top;
                        this.f9485n = f3;
                        rectF.top = f3;
                        rectF = this.f9491t;
                        f3 = this.f9491t.right - (this.f9491t.height() * width);
                        this.f9486o = f3;
                        rectF.left = f3;
                    } else {
                        rectF2 = this.f9491t;
                        f3 += this.f9491t.left;
                        this.f9486o = f3;
                        rectF2.left = f3;
                        rectF3 = this.f9491t;
                        width2 += this.f9491t.top;
                        this.f9485n = width2;
                        rectF3.top = width2;
                    }
                }
            } else if (this.f9481j) {
                if (abs > abs2) {
                    if (!((obj == null && obj5 == null) || (obj4 == null && obj8 == null))) {
                        if (this.f9491t.left + f3 < this.f9489r.left) {
                            rectF = this.f9491t;
                            f3 = this.f9489r.left;
                            this.f9486o = f3;
                            rectF.left = f3;
                            rectF = this.f9491t;
                            f3 = this.f9491t.top + (this.f9491t.width() / width);
                            this.f9485n = f3;
                            rectF.bottom = f3;
                        } else if (this.f9491t.bottom + width2 > this.f9489r.bottom) {
                            rectF = this.f9491t;
                            f3 = this.f9489r.bottom;
                            this.f9484m = f3;
                            rectF.bottom = f3;
                            rectF = this.f9491t;
                            f3 = this.f9491t.right - (this.f9491t.height() * width);
                            this.f9486o = f3;
                            rectF.left = f3;
                        } else {
                            rectF2 = this.f9491t;
                            f3 += this.f9491t.left;
                            this.f9486o = f3;
                            rectF2.left = f3;
                            rectF3 = this.f9491t;
                            width2 = this.f9491t.bottom - width2;
                            this.f9484m = width2;
                            rectF3.bottom = width2;
                        }
                    }
                } else if (!((obj == null && obj6 == null) || (obj4 == null && obj7 == null))) {
                    if (this.f9491t.left - f3 < this.f9489r.left) {
                        rectF = this.f9491t;
                        f3 = this.f9489r.left;
                        this.f9486o = f3;
                        rectF.left = f3;
                        rectF = this.f9491t;
                        f3 = this.f9491t.top + (this.f9491t.width() / width);
                        this.f9485n = f3;
                        rectF.bottom = f3;
                    } else if (this.f9491t.bottom + width2 > this.f9489r.bottom) {
                        rectF = this.f9491t;
                        f3 = this.f9489r.bottom;
                        this.f9484m = f3;
                        rectF.bottom = f3;
                        rectF = this.f9491t;
                        f3 = this.f9491t.right - (this.f9491t.height() * width);
                        this.f9486o = f3;
                        rectF.left = f3;
                    } else {
                        rectF2 = this.f9491t;
                        f3 = this.f9491t.left - f3;
                        this.f9486o = f3;
                        rectF2.left = f3;
                        rectF3 = this.f9491t;
                        width2 += this.f9491t.bottom;
                        this.f9484m = width2;
                        rectF3.bottom = width2;
                    }
                }
            } else if (this.f9482k) {
                if (abs > abs2) {
                    if (!((obj2 == null && obj5 == null) || (obj3 == null && obj8 == null))) {
                        if (this.f9491t.right + f3 > this.f9489r.right) {
                            rectF = this.f9491t;
                            f3 = this.f9489r.right;
                            this.f9487p = f3;
                            rectF.right = f3;
                            rectF = this.f9491t;
                            f3 = this.f9491t.bottom - (this.f9491t.width() / width);
                            this.f9485n = f3;
                            rectF.top = f3;
                        } else if (this.f9491t.top - width2 < this.f9489r.top) {
                            rectF = this.f9491t;
                            f3 = this.f9489r.top;
                            this.f9485n = f3;
                            rectF.top = f3;
                            rectF = this.f9491t;
                            f3 = this.f9491t.left + (this.f9491t.height() * width);
                            this.f9486o = f3;
                            rectF.right = f3;
                        } else {
                            rectF2 = this.f9491t;
                            f3 += this.f9491t.right;
                            this.f9487p = f3;
                            rectF2.right = f3;
                            rectF3 = this.f9491t;
                            width2 = this.f9491t.top - width2;
                            this.f9485n = width2;
                            rectF3.top = width2;
                        }
                    }
                } else if (!((obj2 == null && obj6 == null) || (obj3 == null && obj7 == null))) {
                    if (this.f9491t.right - f3 > this.f9489r.right) {
                        rectF = this.f9491t;
                        f3 = this.f9489r.right;
                        this.f9487p = f3;
                        rectF.right = f3;
                        rectF = this.f9491t;
                        f3 = this.f9491t.bottom - (this.f9491t.width() / width);
                        this.f9485n = f3;
                        rectF.top = f3;
                    } else if (this.f9491t.top + width2 < this.f9489r.top) {
                        rectF = this.f9491t;
                        f3 = this.f9489r.top;
                        this.f9485n = f3;
                        rectF.top = f3;
                        rectF = this.f9491t;
                        f3 = this.f9491t.left + (this.f9491t.height() * width);
                        this.f9486o = f3;
                        rectF.right = f3;
                    } else {
                        rectF2 = this.f9491t;
                        f3 = this.f9491t.right - f3;
                        this.f9487p = f3;
                        rectF2.right = f3;
                        rectF3 = this.f9491t;
                        width2 += this.f9491t.top;
                        this.f9485n = width2;
                        rectF3.top = width2;
                    }
                }
            } else if (this.f9483l && !((obj2 == null && obj5 == null) || (obj4 == null && obj7 == null))) {
                if (this.f9491t.right + f3 > this.f9489r.right) {
                    rectF = this.f9491t;
                    f3 = this.f9489r.right;
                    this.f9487p = f3;
                    rectF.right = f3;
                    rectF = this.f9491t;
                    f3 = this.f9491t.top + (this.f9491t.width() / width);
                    this.f9485n = f3;
                    rectF.bottom = f3;
                } else if (this.f9491t.bottom + width2 > this.f9489r.bottom) {
                    rectF = this.f9491t;
                    f3 = this.f9489r.bottom;
                    this.f9484m = f3;
                    rectF.bottom = f3;
                    rectF = this.f9491t;
                    f3 = this.f9491t.left + (this.f9491t.height() * width);
                    this.f9486o = f3;
                    rectF.right = f3;
                } else {
                    rectF2 = this.f9491t;
                    f3 += this.f9491t.right;
                    this.f9487p = f3;
                    rectF2.right = f3;
                    rectF3 = this.f9491t;
                    width2 += this.f9491t.bottom;
                    this.f9484m = width2;
                    rectF3.bottom = width2;
                }
            }
        }
        this.f9467E.f9519f = true;
        invalidate();
    }

    public static void m11422c(CropOverlayView cropOverlayView, float f, float f2) {
        float f3 = cropOverlayView.f9491t.left + (f - cropOverlayView.f9474c);
        float f4 = cropOverlayView.f9491t.top + (f2 - cropOverlayView.f9475d);
        float width = cropOverlayView.f9491t.width() + f3;
        float height = cropOverlayView.f9491t.height() + f4;
        float width2 = cropOverlayView.f9491t.width();
        float height2 = cropOverlayView.f9491t.height();
        if (width > cropOverlayView.f9489r.right) {
            f3 = cropOverlayView.f9489r.right - width2;
        } else if (f3 < cropOverlayView.f9489r.left) {
            f3 = cropOverlayView.f9489r.left;
        }
        if (height > cropOverlayView.f9489r.bottom) {
            f4 = cropOverlayView.f9489r.bottom - height2;
        } else if (f4 < cropOverlayView.f9489r.top) {
            f4 = cropOverlayView.f9489r.top;
        }
        RectF rectF = cropOverlayView.f9491t;
        cropOverlayView.f9486o = f3;
        rectF.left = f3;
        rectF = cropOverlayView.f9491t;
        cropOverlayView.f9485n = f4;
        rectF.top = f4;
        rectF = cropOverlayView.f9491t;
        f3 += width2;
        cropOverlayView.f9487p = f3;
        rectF.right = f3;
        RectF rectF2 = cropOverlayView.f9491t;
        f4 += height2;
        cropOverlayView.f9484m = f4;
        rectF2.bottom = f4;
        cropOverlayView.f9467E.f9520g = true;
        cropOverlayView.invalidate();
    }
}
