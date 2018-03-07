package com.facebook.localcontent.menus;

import android.content.Context;
import android.widget.TextView;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: ec_context_item_impression */
public class PagePhotoMenuView extends CustomFrameLayout {
    @Inject
    public TimeFormatUtil f15010a;
    public TextView f15011b = ((TextView) c(2131565640));
    public TextView f15012c = ((TextView) c(2131565641));
    public FbDraweeView f15013d = ((FbDraweeView) c(2131565642));

    public static void m17450a(Object obj, Context context) {
        ((PagePhotoMenuView) obj).f15010a = (TimeFormatUtil) DefaultTimeFormatUtil.a(FbInjector.get(context));
    }

    public PagePhotoMenuView(Context context) {
        super(context);
        Class cls = PagePhotoMenuView.class;
        m17450a(this, getContext());
        setContentView(2130906075);
    }

    public void setTimestamp(long j) {
        this.f15012c.setText(this.f15010a.a(TimeFormatStyle.MONTH_DAY_YEAR_STYLE, 1000 * j));
    }
}
