package com.facebook.messaging.payment.value.input;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.Theme;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.ThemeModel;
import com.facebook.messaging.payment.value.input.ui.ScaleTypeFitWidth;
import java.util.List;

/* compiled from: error_data */
public class ThemePagerAdapter extends PagerAdapter {
    private final Context f15698a;
    private List<Theme> f15699b;
    private GenericDraweeHierarchy f15700c;

    public ThemePagerAdapter(List<Theme> list, Context context) {
        this.f15699b = list;
        this.f15698a = context;
    }

    public final Object m15870a(View view, int i) {
        FbDraweeView fbDraweeView = new FbDraweeView(this.f15698a);
        if (this.f15699b == null || i <= 0 || i > this.f15699b.size()) {
            return fbDraweeView;
        }
        this.f15700c = new GenericDraweeHierarchyBuilder(this.f15698a.getResources()).e(new ScaleTypeFitWidth()).u();
        fbDraweeView.setHierarchy(this.f15700c);
        fbDraweeView.a(ThemeHelper.m15868a((ThemeModel) this.f15699b.get(i - 1)), CallerContext.a(this.f15698a));
        fbDraweeView.setBackground(new ColorDrawable(ContextCompat.b(this.f15698a, 17170445)));
        fbDraweeView.setLayoutParams(new LayoutParams(-1, -2));
        ((ViewPager) view).addView(fbDraweeView);
        return fbDraweeView;
    }

    public final void m15871a(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
    }

    public final int m15873b() {
        if (this.f15699b == null) {
            return 1;
        }
        return this.f15699b.size() + 1;
    }

    public final boolean m15872a(View view, Object obj) {
        return view == obj;
    }
}
