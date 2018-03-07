package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.richdocument.ham.ExtraPaddingAware;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.model.block.Annotation;
import com.facebook.richdocument.model.block.Annotation.AnnotationAlignment;
import com.facebook.richdocument.model.block.Annotation.AnnotationType;
import com.facebook.richdocument.model.block.RichText;
import com.facebook.richdocument.model.block.RichText.RichTextBuilder;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentElementStyleModel;
import com.facebook.richdocument.view.util.CompositeRecyclableViewFactory.RecyclableView;
import com.facebook.widget.CustomLinearLayout;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: open_page_info_tap */
public class TextAnnotationView<V extends Annotation> extends CustomLinearLayout implements ExtraPaddingAware, RecyclableView, AnnotationView<V> {
    public RichTextView f7092a;
    private ImageView f7093b;
    @Inject
    RichTextUtils f7094c;
    @Inject
    HamDimensions f7095d;
    protected V f7096e;

    private static <T extends View> void m7397a(Class<T> cls, T t) {
        m7398a((Object) t, t.getContext());
    }

    private static void m7398a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((TextAnnotationView) obj).m7396a(RichTextUtils.m1355a(injectorLike), HamDimensions.m5268a(injectorLike));
    }

    public TextAnnotationView(Context context) {
        super(context);
        mo444e();
    }

    public TextAnnotationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo444e();
    }

    public TextAnnotationView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo444e();
    }

    private void mo444e() {
        m7397a(TextAnnotationView.class, (View) this);
        setContentView(2130906861);
        this.f7092a = (RichTextView) a(2131559597);
        this.f7093b = (ImageView) a(2131567026);
    }

    public void setAnnotation(V v) {
        this.f7096e = v;
        mo443d();
    }

    public V getAnnotation() {
        return this.f7096e;
    }

    public final View mo438b() {
        return this;
    }

    public void setIsOverlay(boolean z) {
        setEnabled(z);
    }

    public final boolean mo439c() {
        return true;
    }

    protected void mo443d() {
        int color;
        RichText a = new RichTextBuilder(getContext()).m5443a(this.f7096e).m5446a();
        this.f7094c.m1359a((TextView) this.f7092a.f7393d, a);
        if (getDrawable() == null) {
            this.f7093b.setVisibility(8);
        }
        List list = a.f5642b;
        int color2 = getContext().getResources().getColor(2131363476);
        if (!list.isEmpty()) {
            color2 = RichTextUtils.m1353a(((RichDocumentElementStyleModel) list.get(0)).m5924b());
        }
        r3 = new int[2][];
        r3[0] = new int[]{16842910};
        r3[1] = new int[0];
        int[] iArr = new int[2];
        if (this.f7096e.f5608a == AnnotationType.COPYRIGHT) {
            color = getContext().getResources().getColor(2131363477);
        } else {
            color = -1;
        }
        iArr[0] = color;
        iArr[1] = color2;
        this.f7092a.f7393d.setTextColor(new ColorStateList(r3, iArr));
        AnnotationAlignment annotationAlignment = this.f7096e.f5611d;
        if (annotationAlignment != null) {
            switch (annotationAlignment) {
                case LEFT:
                    setGravity(3);
                    break;
                case CENTER:
                    setGravity(1);
                    break;
                case RIGHT:
                    setGravity(5);
                    break;
            }
        }
        this.f7092a.setEnableCopy(true);
    }

    public Drawable getDrawable() {
        return this.f7093b.getDrawable();
    }

    public RichTextView getTextView() {
        return this.f7092a;
    }

    public final void m7401a(int i, int i2, int i3) {
        this.f7093b.setImageResource(i);
        this.f7093b.setVisibility(0);
        LayoutParams layoutParams = this.f7093b.getLayoutParams();
        layoutParams.width = this.f7095d.m5276b(i2);
        layoutParams.height = this.f7095d.m5276b(i3);
        this.f7093b.setLayoutParams(layoutParams);
    }

    public void setText(int i) {
        this.f7092a.f7393d.setText(i);
    }

    public void setText(String str) {
        this.f7092a.f7393d.setText(str);
    }

    public final void m7402a(Drawable drawable, int i, int i2) {
        this.f7093b.setImageDrawable(drawable);
        this.f7093b.setVisibility(0);
        LayoutParams layoutParams = this.f7093b.getLayoutParams();
        layoutParams.width = this.f7095d.m5276b(i);
        layoutParams.height = this.f7095d.m5276b(i2);
        this.f7093b.setLayoutParams(layoutParams);
    }

    public void setDrawablePaddingResource(int i) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f7093b.getLayoutParams();
        marginLayoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(i), 0);
        this.f7093b.setLayoutParams(marginLayoutParams);
    }

    public void setTextOnClickListener(OnClickListener onClickListener) {
        if (this.f7092a != null && this.f7092a.f7393d != null) {
            this.f7092a.f7393d.setOnClickListener(onClickListener);
        }
    }

    public String toString() {
        if (this.f7096e.f5609b == null) {
            return null;
        }
        String str = this.f7096e.f5609b;
        return getClass().getSimpleName() + "(" + str.substring(0, Math.min(8, str.length())) + ")";
    }

    public int getExtraPaddingBottom() {
        return getDrawable() == null ? this.f7092a.getExtraPaddingBottom() : 0;
    }

    public final void mo437a() {
    }

    private void m7396a(RichTextUtils richTextUtils, HamDimensions hamDimensions) {
        this.f7094c = richTextUtils;
        this.f7095d = hamDimensions;
    }
}
