package com.facebook.uicontrib.datetimepicker;

import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.FrameLayout;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator.TabsContainer;
import com.facebook.inject.Assisted;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: extra_event_cover_photo_uri */
public class DateTimePickerPagerAdapter extends PagerAdapter {
    public static final ImmutableList<Integer> f12925a = ImmutableList.of(Integer.valueOf(0), Integer.valueOf(1));
    private final FrameLayout[] f12926b = new FrameLayout[f12925a.size()];
    public DateFormat f12927c;
    public DateFormat f12928d;
    public TimePicker f12929e;
    public DatePicker f12930f;
    public TabsContainer f12931g;
    public Calendar f12932h;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: extra_event_cover_photo_uri */
    public @interface DateTimePickerType {
    }

    @Inject
    public DateTimePickerPagerAdapter(@Assisted Calendar calendar, Provider<Locale> provider, Provider<TimeZone> provider2) {
        this.f12927c = new SimpleDateFormat("hh:mm a", (Locale) provider.get());
        this.f12928d = new SimpleDateFormat("MMM d", (Locale) provider.get());
        if (calendar == null) {
            calendar = Calendar.getInstance((TimeZone) provider2.get(), (Locale) provider.get());
        }
        this.f12932h = calendar;
    }

    public final int m12909b() {
        return f12925a.size();
    }

    public final boolean m12908a(View view, Object obj) {
        return obj == view;
    }

    public final Object m12905a(ViewGroup viewGroup, final int i) {
        View view = this.f12926b[i];
        if (view == null) {
            View view2;
            if (((Integer) f12925a.get(i)).intValue() == 1) {
                view2 = (FrameLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130907429, viewGroup, false);
                this.f12929e = (TimePicker) view2.findViewById(2131567904);
                this.f12929e.setCurrentMinute(Integer.valueOf(this.f12932h.get(12)));
                this.f12929e.setCurrentHour(Integer.valueOf(this.f12932h.get(10)));
                this.f12929e.setOnTimeChangedListener(new OnTimeChangedListener(this) {
                    final /* synthetic */ DateTimePickerPagerAdapter f12922b;

                    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
                        this.f12922b.f12932h.set(11, i);
                        this.f12922b.f12932h.set(12, i2);
                        this.f12922b.m12906a(i, this.f12922b.f12927c.format(this.f12922b.f12932h.getTime()));
                    }
                });
            } else {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130903843, viewGroup, false);
                this.f12930f = (DatePicker) frameLayout.findViewById(2131560887);
                this.f12930f.init(this.f12932h.get(1), this.f12932h.get(2), this.f12932h.get(5), new OnDateChangedListener(this) {
                    final /* synthetic */ DateTimePickerPagerAdapter f12924b;

                    public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
                        this.f12924b.f12932h.set(i, i2, i3);
                        this.f12924b.m12906a(i, this.f12924b.f12928d.format(this.f12924b.f12932h.getTime()));
                    }
                });
            }
            view = view2;
            this.f12926b[i] = view;
        }
        viewGroup.addView(view);
        return view;
    }

    public final CharSequence J_(int i) {
        if (((Integer) f12925a.get(i)).intValue() == 1) {
            return this.f12927c.format(this.f12932h.getTime());
        }
        return this.f12928d.format(this.f12932h.getTime());
    }

    public final void m12907a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final void m12906a(int i, String str) {
        if (this.f12931g != null && i < this.f12931g.getChildCount()) {
            View childAt = this.f12931g.getChildAt(i);
            Preconditions.checkArgument(childAt instanceof FbTextView);
            FbTextView fbTextView = (FbTextView) childAt;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            fbTextView.setText(str);
        }
    }
}
