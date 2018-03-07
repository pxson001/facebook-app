package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.richdocument.ham.RichDocumentPaddingCalculator;
import com.facebook.richdocument.model.block.Annotation.AnnotationSlot;
import com.facebook.richdocument.view.block.BlockViewUtil;
import com.facebook.richdocument.view.widget.AnnotationViews.AnnotationViewComparator;
import com.facebook.widget.CustomLinearLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: open_upcoming_birthdays_tap */
public class AnnotationSlotLinearLayout extends CustomLinearLayout {
    @Inject
    RichDocumentPaddingCalculator f7082a;
    @Inject
    BlockViewUtil f7083b;
    private final TreeSet<AnnotationView> f7084c = new TreeSet(AnnotationViewComparator.f7085a);

    private static <T extends View> void m7387a(Class<T> cls, T t) {
        m7388a((Object) t, t.getContext());
    }

    private static void m7388a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AnnotationSlotLinearLayout) obj).m7386a(RichDocumentPaddingCalculator.m5294a(injectorLike), BlockViewUtil.m6915a(injectorLike));
    }

    public AnnotationSlotLinearLayout(Context context) {
        super(context);
        m7385a();
    }

    public AnnotationSlotLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m7385a();
    }

    public AnnotationSlotLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7385a();
    }

    private void m7385a() {
        m7387a(AnnotationSlotLinearLayout.class, (View) this);
        setOrientation(1);
    }

    public final void m7389a(AnnotationView annotationView) {
        if (annotationView != null) {
            int a = m7384a(getBottommostAnnotation(), annotationView);
            this.f7084c.add(annotationView);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, a, 0, 0);
            annotationView.mo438b().setLayoutParams(layoutParams);
            this.f7083b.m6924a(annotationView.mo438b());
            switch (annotationView.getAnnotation().f5611d) {
                case CENTER:
                    layoutParams.gravity = 1;
                    break;
                case RIGHT:
                    layoutParams.gravity = 5;
                    break;
            }
            addView(annotationView.mo438b());
            if (annotationView.getAnnotation().f5612e == AnnotationSlot.CENTER) {
                annotationView.mo438b().setEnabled(true);
            } else {
                annotationView.mo438b().setEnabled(false);
            }
        }
    }

    public AnnotationView getBottommostAnnotation() {
        List arrayList = new ArrayList(this.f7084c);
        if (arrayList.isEmpty()) {
            return null;
        }
        return (AnnotationView) arrayList.get(arrayList.size() - 1);
    }

    private int m7384a(AnnotationView annotationView, AnnotationView annotationView2) {
        return this.f7082a.m5297a(annotationView, annotationView2);
    }

    private void m7386a(RichDocumentPaddingCalculator richDocumentPaddingCalculator, BlockViewUtil blockViewUtil) {
        this.f7082a = richDocumentPaddingCalculator;
        this.f7083b = blockViewUtil;
    }
}
