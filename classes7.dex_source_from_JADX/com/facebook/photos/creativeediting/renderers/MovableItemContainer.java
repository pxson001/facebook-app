package com.facebook.photos.creativeediting.renderers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.inject.Assisted;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem;
import com.facebook.photos.creativeediting.interfaces.UriAwarePhotoOverlayItem;
import com.facebook.photos.creativeediting.model.DoodleParams;
import com.facebook.photos.creativeediting.model.PhotoOverlayItemFactory;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.photos.creativeediting.model.TextParams;
import com.facebook.photos.creativeediting.utilities.PhotoOverlayDrawUtilities;
import com.facebook.photos.editgallery.EditableOverlayContainerView.C08772;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.LinkedHashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mStrength */
public class MovableItemContainer {
    public static final CallerContext f9582a = CallerContext.a(MovableItemContainer.class, "creative_editing_in_composer");
    public final LinkedHashMap<UriAwarePhotoOverlayItem, DraweeHolder<GenericDraweeHierarchy>> f9583b;
    public final Context f9584c;
    private final PhotoOverlayDrawUtilities f9585d;
    public final Provider<FbDraweeControllerBuilder> f9586e;
    private final int f9587f;
    private final int f9588g;
    private final int f9589h;
    private Drawable f9590i;
    private Drawable f9591j;
    public UriAwarePhotoOverlayItem f9592k;
    private boolean f9593l;
    public C08772 f9594m;
    public Rect f9595n;
    public float f9596o = 1.0f;

    @Inject
    public MovableItemContainer(@Assisted Rect rect, Context context, PhotoOverlayDrawUtilities photoOverlayDrawUtilities, Provider<FbDraweeControllerBuilder> provider) {
        this.f9595n = rect;
        this.f9584c = context;
        this.f9585d = photoOverlayDrawUtilities;
        this.f9586e = provider;
        this.f9583b = Maps.d();
        this.f9587f = this.f9584c.getResources().getDimensionPixelSize(2131429542);
        this.f9588g = this.f9584c.getResources().getDimensionPixelSize(2131429543);
        this.f9589h = this.f9584c.getResources().getDimensionPixelSize(2131429544);
        this.f9590i = this.f9584c.getResources().getDrawable(2130838471);
        this.f9591j = this.f9584c.getResources().getDrawable(2130843470);
    }

    public final boolean m11510a() {
        return this.f9583b.isEmpty();
    }

    public final void m11509a(UriAwarePhotoOverlayItem uriAwarePhotoOverlayItem, Callback callback) {
        FbPipelineDraweeController s = ((FbDraweeControllerBuilder) this.f9586e.get()).a(f9582a).b(uriAwarePhotoOverlayItem.d()).s();
        GenericDraweeHierarchyBuilder e = new GenericDraweeHierarchyBuilder(this.f9584c.getResources()).e(ScaleType.c);
        e.f = new AutoRotateDrawable(this.f9584c.getResources().getDrawable(2130844043), 1000);
        DraweeHolder a = DraweeHolder.a(e.u(), this.f9584c);
        a.a(s);
        DraweeHolder draweeHolder = a;
        draweeHolder.h().setCallback(callback);
        this.f9583b.put(uriAwarePhotoOverlayItem, draweeHolder);
        draweeHolder.b();
    }

    public final void m11507a(PhotoOverlayItem photoOverlayItem) {
        if (this.f9583b.containsKey(photoOverlayItem)) {
            ((DraweeHolder) this.f9583b.get(photoOverlayItem)).d();
            this.f9583b.remove(photoOverlayItem);
        }
    }

    public final void m11506a(Canvas canvas, @Nullable Rect rect) {
        for (UriAwarePhotoOverlayItem uriAwarePhotoOverlayItem : this.f9583b.keySet()) {
            if (!(uriAwarePhotoOverlayItem.equals(this.f9592k) || rect == null)) {
                m11502a(canvas, uriAwarePhotoOverlayItem, rect);
            }
        }
    }

    public final void m11513b(Canvas canvas, @Nullable Rect rect) {
        if (this.f9592k != null && rect != null) {
            m11502a(canvas, this.f9592k, rect);
        }
    }

    public final boolean m11511a(Drawable drawable) {
        for (DraweeHolder draweeHolder : this.f9583b.values()) {
            if (draweeHolder != null && draweeHolder.h() == drawable) {
                return true;
            }
        }
        return false;
    }

    public final void m11516c() {
        if (!this.f9593l) {
            this.f9593l = true;
            for (DraweeHolder b : this.f9583b.values()) {
                b.b();
            }
        }
    }

    public final void m11519d() {
        if (this.f9593l) {
            this.f9593l = false;
            for (DraweeHolder draweeHolder : this.f9583b.values()) {
                if (draweeHolder != null) {
                    draweeHolder.d();
                }
            }
        }
    }

    public final void m11514b(PhotoOverlayItem photoOverlayItem) {
        if ((photoOverlayItem instanceof UriAwarePhotoOverlayItem) && ((UriAwarePhotoOverlayItem) photoOverlayItem).k()) {
            this.f9592k = (UriAwarePhotoOverlayItem) photoOverlayItem;
            DraweeHolder draweeHolder = (DraweeHolder) this.f9583b.get(photoOverlayItem);
            if (draweeHolder != null) {
                this.f9583b.remove(photoOverlayItem);
                this.f9583b.put((UriAwarePhotoOverlayItem) photoOverlayItem, draweeHolder);
            }
        }
    }

    public final void m11521g() {
        this.f9592k = null;
    }

    public final double m11515c(PhotoOverlayItem photoOverlayItem) {
        Preconditions.checkNotNull(photoOverlayItem);
        return (double) ((photoOverlayItem.a().width() * ((float) this.f9595n.width())) / ((float) this.f9589h));
    }

    public final int m11518d(PhotoOverlayItem photoOverlayItem) {
        Preconditions.checkNotNull(photoOverlayItem);
        return ((int) (photoOverlayItem.a().left * ((float) this.f9595n.width()))) + this.f9595n.left;
    }

    public final int m11520e(PhotoOverlayItem photoOverlayItem) {
        Preconditions.checkNotNull(photoOverlayItem);
        return ((int) (photoOverlayItem.a().top * ((float) this.f9595n.height()))) + this.f9595n.top;
    }

    public final void m11503a(double d) {
        if (this.f9592k != null) {
            if (!(d == ((double) ((this.f9592k.e() * ((float) this.f9595n.width())) / ((float) this.f9589h))) || this.f9594m == null)) {
                this.f9594m.m12205a(this.f9592k.g().toString());
            }
            int i = (int) (((double) this.f9589h) * d);
            if (i < this.f9588g) {
                d = ((double) this.f9588g) / ((double) this.f9589h);
            } else if (i > this.f9587f) {
                d = ((double) this.f9587f) / ((double) this.f9589h);
            }
            DraweeHolder draweeHolder = (DraweeHolder) this.f9583b.get(this.f9592k);
            this.f9583b.remove(this.f9592k);
            this.f9592k = PhotoOverlayItemFactory.a(this.f9592k).g(((float) (((double) this.f9589h) * d)) / ((float) this.f9595n.width())).f(((float) ((((double) this.f9589h) * d) / ((double) ((this.f9592k.e() * ((float) this.f9595n.width())) / (this.f9592k.f() * ((float) this.f9595n.height())))))) / ((float) this.f9595n.height())).b();
            this.f9583b.put(this.f9592k, draweeHolder);
        }
    }

    public final void m11504a(float f) {
        if (this.f9592k != null) {
            if (this.f9594m != null) {
                this.f9594m.m12207c(this.f9592k.g().toString());
            }
            DraweeHolder draweeHolder = (DraweeHolder) this.f9583b.get(this.f9592k);
            this.f9583b.remove(this.f9592k);
            this.f9592k = PhotoOverlayItemFactory.a(this.f9592k).j(f).b();
            this.f9583b.put(this.f9592k, draweeHolder);
        }
    }

    public final void m11505a(int i) {
        if (this.f9592k != null) {
            if (!(i == this.f9592k.a(this.f9595n).left || this.f9594m == null)) {
                this.f9594m.m12206b(this.f9592k.g().toString());
            }
            DraweeHolder draweeHolder = (DraweeHolder) this.f9583b.get(this.f9592k);
            this.f9583b.remove(this.f9592k);
            this.f9592k = PhotoOverlayItemFactory.a(this.f9592k).i(((float) (i - this.f9595n.left)) / ((float) this.f9595n.width())).b();
            this.f9583b.put(this.f9592k, draweeHolder);
        }
    }

    public final void m11512b(int i) {
        if (this.f9592k != null) {
            if (!(i == this.f9592k.a(this.f9595n).top || this.f9594m == null)) {
                this.f9594m.m12206b(this.f9592k.g().toString());
            }
            DraweeHolder draweeHolder = (DraweeHolder) this.f9583b.get(this.f9592k);
            this.f9583b.remove(this.f9592k);
            this.f9592k = PhotoOverlayItemFactory.a(this.f9592k).h(((float) (i - this.f9595n.top)) / ((float) this.f9595n.height())).b();
            this.f9583b.put(this.f9592k, draweeHolder);
        }
    }

    public final void m11508a(PhotoOverlayItem photoOverlayItem, int i) {
        Preconditions.checkNotNull(photoOverlayItem);
        ((DraweeHolder) this.f9583b.get(photoOverlayItem)).h().setAlpha(i);
    }

    public final void m11517c(Rect rect) {
        Preconditions.checkNotNull(rect);
        this.f9595n = rect;
    }

    public final ImmutableList<? extends UriAwarePhotoOverlayItem> m11522i() {
        return ImmutableList.copyOf(this.f9583b.keySet());
    }

    public final void m11523j() {
        this.f9583b.clear();
    }

    private void m11502a(Canvas canvas, UriAwarePhotoOverlayItem uriAwarePhotoOverlayItem, Rect rect) {
        Preconditions.checkNotNull(uriAwarePhotoOverlayItem);
        int save = canvas.save();
        DraweeHolder draweeHolder = (DraweeHolder) this.f9583b.get(uriAwarePhotoOverlayItem);
        if (draweeHolder != null) {
            Drawable h = draweeHolder.h();
            Rect a = uriAwarePhotoOverlayItem.a(rect);
            h.setBounds(a);
            if (this.f9592k == uriAwarePhotoOverlayItem) {
                if (this.f9592k instanceof TextParams) {
                    this.f9590i.setBounds(PhotoOverlayDrawUtilities.c(a));
                    this.f9591j.setBounds(0, 0, 0, 0);
                } else if (this.f9592k instanceof StickerParams) {
                    this.f9591j.setBounds(PhotoOverlayDrawUtilities.b(a));
                    this.f9590i.setBounds(0, 0, 0, 0);
                } else if (this.f9592k instanceof DoodleParams) {
                    this.f9591j.setBounds(PhotoOverlayDrawUtilities.c(a));
                    this.f9590i.setBounds(0, 0, 0, 0);
                }
                if (!(this.f9596o == 1.0f || this.f9596o == 0.0f)) {
                    canvas.scale(this.f9596o, this.f9596o, a.exactCenterX(), a.exactCenterY());
                }
            } else if (this.f9592k == null) {
                this.f9590i.setBounds(0, 0, 0, 0);
                this.f9591j.setBounds(0, 0, 0, 0);
            }
            canvas.rotate(uriAwarePhotoOverlayItem.c(), (float) a.centerX(), (float) a.centerY());
            if (uriAwarePhotoOverlayItem.h()) {
                canvas.scale(-1.0f, 1.0f, a.exactCenterX(), a.exactCenterY());
            }
            if (this.f9592k == uriAwarePhotoOverlayItem) {
                if (this.f9592k instanceof TextParams) {
                    this.f9590i.draw(canvas);
                } else if (this.f9592k instanceof StickerParams) {
                    this.f9591j.draw(canvas);
                } else if (this.f9592k instanceof DoodleParams) {
                    this.f9591j.draw(canvas);
                }
            }
            h.draw(canvas);
            canvas.restoreToCount(save);
        }
    }
}
