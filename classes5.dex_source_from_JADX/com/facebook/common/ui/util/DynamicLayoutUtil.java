package com.facebook.common.ui.util;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.SizeUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.inject.Inject;

/* compiled from: should_auto_open */
public class DynamicLayoutUtil {
    public final Resources f2768a;

    public static DynamicLayoutUtil m3868b(InjectorLike injectorLike) {
        return new DynamicLayoutUtil(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DynamicLayoutUtil(Resources resources) {
        this.f2768a = resources;
    }

    public final void m3869a(final View view, final int i, final List<Integer> list) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ DynamicLayoutUtil f2761d;

            public void onGlobalLayout() {
                int i = ((float) SizeUtil.b(this.f2761d.f2768a, (float) view.getHeight())) < ((float) i) ? 8 : 0;
                for (Integer intValue : list) {
                    view.findViewById(intValue.intValue()).setVisibility(i);
                }
            }
        });
    }

    public final void m3870a(View view, int i, List<Integer> list, List<Integer> list2, List<Integer> list3) {
        boolean z = true;
        Preconditions.checkArgument(list.size() == list2.size(), "Expected linkedIds and smallDimenIds list lengths to match");
        if (list.size() != list3.size()) {
            z = false;
        }
        Preconditions.checkArgument(z, "Expected linkedIds and normalDimenIds list lengths to match");
        final View view2 = view;
        final List<Integer> list4 = list;
        final int i2 = i;
        final List<Integer> list5 = list2;
        final List<Integer> list6 = list3;
        view.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ DynamicLayoutUtil f2767f;

            public void onGlobalLayout() {
                float b = (float) SizeUtil.b(this.f2767f.f2768a, (float) view2.getHeight());
                for (int i = 0; i < list4.size(); i++) {
                    ((TextView) view2.findViewById(((Integer) list4.get(i)).intValue())).setTextSize(0, b < ((float) i2) ? this.f2767f.f2768a.getDimension(((Integer) list5.get(i)).intValue()) : this.f2767f.f2768a.getDimension(((Integer) list6.get(i)).intValue()));
                }
            }
        });
    }
}
