package com.facebook.uicontrib.datetimepicker;

import android.content.Context;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator.TabsContainer;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewPager;
import java.util.Calendar;
import javax.inject.Inject;

/* compiled from: extra_event_host_id */
public class DateTimePicker extends CustomLinearLayout {
    @Inject
    public DateTimePickerPagerAdapterProvider f12913a;
    public TabbedViewPagerIndicator f12914b;
    public DateTimePickerPagerAdapter f12915c;
    public CustomViewPager f12916d = ((CustomViewPager) a(2131560889));

    public static void m12904a(Object obj, Context context) {
        ((DateTimePicker) obj).f12913a = (DateTimePickerPagerAdapterProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(DateTimePickerPagerAdapterProvider.class);
    }

    public DateTimePicker(Context context, Calendar calendar) {
        Calendar calendar2;
        super(context);
        Class cls = DateTimePicker.class;
        m12904a(this, getContext());
        setContentView(2130903844);
        setOrientation(1);
        this.f12916d.b(0, true);
        this.f12914b = (TabbedViewPagerIndicator) a(2131560888);
        DateTimePickerPagerAdapterProvider dateTimePickerPagerAdapterProvider = this.f12913a;
        if (calendar == null) {
            calendar2 = null;
        } else {
            calendar2 = (Calendar) calendar.clone();
        }
        this.f12915c = new DateTimePickerPagerAdapter(calendar2, IdBasedProvider.a(dateTimePickerPagerAdapterProvider, 4483), IdBasedProvider.a(dateTimePickerPagerAdapterProvider, 4486));
        this.f12915c.f12931g = (TabsContainer) this.f12914b.getChildAt(0);
        this.f12916d.setAdapter(this.f12915c);
        this.f12914b.setViewPager(this.f12916d);
    }
}
