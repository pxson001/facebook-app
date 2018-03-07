package com.facebook.drawee.span;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.lifecycle.AttachDetachListener;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feedplugins.spannable.PersistentSpannablePreparer.2;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.HashSet;
import java.util.Set;

/* compiled from: offensive */
public class DraweeSpanStringBuilder extends SpannableStringBuilder implements AttachDetachListener {
    public final Set<DraweeSpan> f8889a = new HashSet();
    public View f8890b;
    public 2 f8891c;

    /* compiled from: offensive */
    class DrawableChangedListener extends BaseControllerListener<ImageInfo> {
        final /* synthetic */ DraweeSpanStringBuilder f8885a;
        private final DraweeController f8886b;
        private final boolean f8887c;
        private final int f8888d;

        public final void m12681a(String str, Object obj, Animatable animatable) {
            CloseableImage closeableImage = (CloseableImage) obj;
            if (!(!this.f8887c || closeableImage == null || this.f8886b.d() == null || this.f8886b.d().a() == null)) {
                if (this.f8888d != -1) {
                    this.f8886b.d().a().setBounds(0, 0, (int) ((((float) this.f8888d) / ((float) closeableImage.g())) * ((float) closeableImage.f())), this.f8888d);
                } else {
                    this.f8886b.d().a().setBounds(0, 0, closeableImage.f(), closeableImage.g());
                }
            }
            if (this.f8885a.f8891c != null) {
                ((HasInvalidate) this.f8885a.f8891c.a).a(new Object[]{this.f8885a.f8891c.b.c()});
            }
            if (this.f8885a.f8890b != null) {
                this.f8885a.f8890b.postInvalidate();
            }
        }

        public DrawableChangedListener(DraweeSpanStringBuilder draweeSpanStringBuilder, DraweeController draweeController, boolean z, int i) {
            this.f8885a = draweeSpanStringBuilder;
            Preconditions.a(draweeController);
            this.f8886b = draweeController;
            this.f8887c = z;
            this.f8888d = i;
        }
    }

    public DraweeSpanStringBuilder(CharSequence charSequence) {
        super(charSequence);
    }

    public final void m12685a(DraweeHolder draweeHolder, int i, int i2, int i3, int i4, boolean z, int i5) {
        DraweeController draweeController = draweeHolder.f;
        if (draweeController instanceof AbstractDraweeController) {
            ((AbstractDraweeController) draweeController).a(new DrawableChangedListener(this, draweeController, z, i4));
        }
        Drawable a = draweeHolder.f().a();
        if (a != null && a.getBounds().isEmpty()) {
            a.setBounds(0, 0, i3, i4);
        }
        DraweeSpan draweeSpan = new DraweeSpan(draweeHolder, i5);
        setSpan(draweeSpan, i, i2 + 1, 33);
        this.f8889a.add(draweeSpan);
    }

    public final void m12684a(View view) {
        m12682c(view);
        for (DraweeSpan draweeSpan : this.f8889a) {
            draweeSpan.f8884a.b();
        }
    }

    public final void m12686b(View view) {
        m12683d(view);
        for (DraweeSpan draweeSpan : this.f8889a) {
            draweeSpan.f8884a.d();
        }
    }

    private void m12682c(View view) {
        if (this.f8890b != null) {
            m12683d(this.f8890b);
        }
        this.f8890b = view;
    }

    private void m12683d(View view) {
        if (view == this.f8890b) {
            this.f8890b = null;
        }
    }
}
