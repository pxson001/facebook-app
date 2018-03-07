package com.facebook.groups.widget.remotepogview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeView;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: prefetch_privacy_options */
public class RemotePogView extends DraweeView<GenericDraweeHierarchy> {
    private static final CallerContext f6080c = CallerContext.a(RemotePogView.class, "group_info");
    @Inject
    public FbDraweeControllerBuilder f6081a;
    private int f6082b;
    private Drawable f6083d;
    private boolean f6084e;
    private Bitmap f6085f;

    private static <T extends View> void m7859a(Class<T> cls, T t) {
        m7860a((Object) t, t.getContext());
    }

    private static void m7860a(Object obj, Context context) {
        ((RemotePogView) obj).f6081a = FbDraweeControllerBuilder.b(FbInjector.get(context));
    }

    private void m7858a(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f6081a = fbDraweeControllerBuilder;
    }

    public RemotePogView(Context context) {
        super(context);
        m7857a(null, 0, 0);
    }

    public RemotePogView(Context context, int i, int i2) {
        super(context);
        m7857a(null, i, i2);
    }

    public RemotePogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RemotePogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7857a(attributeSet, 0, 0);
    }

    private void m7857a(AttributeSet attributeSet, int i, int i2) {
        int resourceId;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder;
        int i3 = 0;
        m7859a(RemotePogView.class, (View) this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.RemotePogAttrs);
            if (obtainStyledAttributes != null) {
                setPogSize(obtainStyledAttributes.getDimensionPixelSize(0, 0));
                resourceId = obtainStyledAttributes.getResourceId(3, 0);
                if (resourceId != 0) {
                    this.f6083d = getResources().getDrawable(resourceId);
                }
                resourceId = obtainStyledAttributes.getDimensionPixelSize(1, 0);
                if (resourceId > 0) {
                    i3 = obtainStyledAttributes.getColor(2, getResources().getColor(2131363563));
                }
                obtainStyledAttributes.recycle();
                int i4 = resourceId;
                resourceId = i3;
                i3 = i4;
                if (this.f6083d == null) {
                    this.f6083d = new ColorDrawable(getResources().getColor(2131361871));
                }
                if (i == 0) {
                    i = resourceId;
                }
                if (i2 == 0) {
                    i2 = i3;
                }
                genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
                genericDraweeHierarchyBuilder.u = RoundingParams.e().a(i, (float) i2);
                setHierarchy(genericDraweeHierarchyBuilder.u());
            }
        }
        resourceId = 0;
        if (this.f6083d == null) {
            this.f6083d = new ColorDrawable(getResources().getColor(2131361871));
        }
        if (i == 0) {
            i = resourceId;
        }
        if (i2 == 0) {
            i2 = i3;
        }
        genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
        genericDraweeHierarchyBuilder.u = RoundingParams.e().a(i, (float) i2);
        setHierarchy(genericDraweeHierarchyBuilder.u());
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f6082b, this.f6082b);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f6084e) {
            if (this.f6085f == null) {
                this.f6085f = ((BitmapDrawable) getResources().getDrawable(2130843749)).getBitmap();
            }
            canvas.drawBitmap(this.f6085f, (float) (getWidth() - this.f6085f.getWidth()), (float) (getHeight() - this.f6085f.getHeight()), null);
        }
    }

    private void m7861a(String str) {
        ((GenericDraweeHierarchy) getHierarchy()).b(this.f6083d);
        if (!StringUtil.a(str)) {
            setController(((FbDraweeControllerBuilder) this.f6081a.a(f6080c).b(Uri.parse(str)).b(getController())).s());
        }
    }

    public final void m7862a(String str, boolean z) {
        this.f6084e = z;
        m7861a(str);
    }

    public void setPogSize(int i) {
        if (i != this.f6082b) {
            this.f6082b = i;
            setMinimumHeight(this.f6082b);
            setMinimumWidth(this.f6082b);
            requestLayout();
        }
    }
}
