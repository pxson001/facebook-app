package com.facebook.pages.identity.fragments.moreinformation;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultTimeRangeFieldsModel;
import com.facebook.inject.FbInjector;
import com.facebook.pages.hours.PageDayHourRanges;
import com.facebook.pages.hours.PageDayHours;
import com.facebook.pages.hours.PageHours;
import com.facebook.pages.hours.PageHoursRenderer;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLModels.PageInformationDataModel.LocationModel;
import com.facebook.widget.CustomFrameLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.inject.Inject;

/* compiled from: pages_browser_category_page_load_error */
public class PageInformationHoursCardView extends CustomFrameLayout {
    @Inject
    public Clock f4033a;
    private final LinearLayout f4034b;
    private final PageHoursRenderer f4035c;
    private final LayoutInflater f4036d;
    private boolean f4037e;

    private static <T extends View> void m4958a(Class<T> cls, T t) {
        m4959a((Object) t, t.getContext());
    }

    private static void m4959a(Object obj, Context context) {
        ((PageInformationHoursCardView) obj).f4033a = (Clock) SystemClockMethodAutoProvider.a(FbInjector.get(context));
    }

    public PageInformationHoursCardView(Context context) {
        this(context, null);
    }

    public PageInformationHoursCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageInformationHoursCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130906050);
        this.f4034b = (LinearLayout) c(2131565582);
        this.f4035c = new PageHoursRenderer();
        this.f4036d = LayoutInflater.from(context);
        m4958a(PageInformationHoursCardView.class, (View) this);
    }

    public final void m4960a(List<DefaultTimeRangeFieldsModel> list, LocationModel locationModel) {
        TimeZone timeZone;
        TimeZone timeZone2 = null;
        if (locationModel != null) {
            timeZone2 = PageHoursRenderer.a(locationModel);
        }
        if (timeZone2 == null) {
            this.f4037e = true;
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = timeZone2;
        }
        ArrayList a = this.f4035c.a(new PageHours(list, timeZone, this.f4033a), getResources());
        while (this.f4034b.getChildCount() > 1) {
            this.f4034b.removeViewAt(0);
        }
        int size = a.size();
        CharSequence string = getResources().getString(2131239247);
        int color = getResources().getColor(2131363044);
        int size2 = a.size();
        int i = 0;
        int i2 = 0;
        while (i < size2) {
            int i3;
            int i4;
            int i5;
            int i6;
            TextView textView;
            PageDayHours pageDayHours = (PageDayHours) a.get(i);
            View inflate = this.f4036d.inflate(2130906052, null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131565588);
            linearLayout.setOrientation(1);
            PageDayHourRanges a2 = pageDayHours.a();
            List a3 = a2.a();
            TextView textView2;
            if (pageDayHours.c()) {
                textView2 = (TextView) inflate.findViewById(2131565587);
                inflate.findViewById(2131565586).setVisibility(8);
                i3 = 2131565590;
                i4 = 2131565589;
                i5 = 2131565585;
                i6 = 2131565584;
                textView = textView2;
            } else {
                textView2 = (TextView) inflate.findViewById(2131565586);
                inflate.findViewById(2131565587).setVisibility(8);
                i3 = 2131565589;
                i4 = 2131565590;
                i5 = 2131565584;
                i6 = 2131565585;
                textView = textView2;
            }
            if (a3.isEmpty() || StringUtil.a((CharSequence) a3.get(0))) {
                ((TextView) linearLayout.findViewById(i3)).setText(string);
                ((TextView) linearLayout.findViewById(i3)).setTextColor(color);
                linearLayout.findViewById(i4).setVisibility(8);
            } else {
                m4956a(linearLayout, (String) a3.get(0), a2.a, i3, i4);
            }
            for (i4 = 1; i4 < a3.size(); i4++) {
                View inflate2 = this.f4036d.inflate(2130906051, null);
                m4956a(inflate2, (String) a3.get(i4), a2.a, i5, i6);
                linearLayout.addView(inflate2);
            }
            textView.setVisibility(0);
            textView.setText(pageDayHours.b());
            int i7 = i2 + 1;
            if (i7 == size) {
                inflate.findViewById(2131565591).setVisibility(8);
            }
            this.f4034b.addView(inflate, this.f4034b.getChildCount() - 1);
            i++;
            i2 = i7;
        }
        if (!this.f4037e) {
            TextView textView3 = (TextView) this.f4034b.getChildAt(this.f4034b.getChildCount() - 1);
            if (!timeZone.equals(TimeZone.getDefault())) {
                String displayName = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 1, Locale.getDefault());
                textView3.setText(getResources().getString(2131235420, new Object[]{displayName}));
                textView3.setVisibility(0);
            }
        }
    }

    private void m4957a(Clock clock) {
        this.f4033a = clock;
    }

    private static void m4956a(View view, String str, String str2, int i, int i2) {
        TextView textView = (TextView) view.findViewById(i);
        view.findViewById(i2).setVisibility(8);
        textView.setVisibility(0);
        textView.setText(str);
        if (!StringUtil.a(str2)) {
            int indexOf = str.indexOf(str2);
            if (indexOf != -1) {
                Paint paint = textView.getPaint();
                float measureText = paint.measureText(str.substring(0, indexOf));
                float measureText2 = paint.measureText(str.substring(indexOf + str2.length()));
                if (measureText > measureText2) {
                    textView.setPadding(0, 0, (int) (measureText - measureText2), 0);
                } else if (measureText2 > measureText) {
                    textView.setPadding((int) (measureText2 - measureText), 0, 0, 0);
                }
            }
        }
    }
}
