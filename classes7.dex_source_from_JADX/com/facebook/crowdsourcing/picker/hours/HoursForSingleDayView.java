package com.facebook.crowdsourcing.picker.hours;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: com.facebook.livephotos.exoplayer.extractor.mp3.Mp3Extractor */
public class HoursForSingleDayView extends CustomFrameLayout {
    private View f17470a;
    private TextView f17471b;
    public CheckBox f17472c;
    private HoursIntervalView f17473d;
    private HoursIntervalView f17474e;

    /* compiled from: com.facebook.livephotos.exoplayer.extractor.mp3.Mp3Extractor */
    class C14445 implements OnClickListener {
        final /* synthetic */ HoursForSingleDayView f17469a;

        C14445(HoursForSingleDayView hoursForSingleDayView) {
            this.f17469a = hoursForSingleDayView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1843685502);
            this.f17469a.f17472c.toggle();
            Logger.a(2, EntryType.UI_INPUT_END, -569347108, a);
        }
    }

    /* compiled from: com.facebook.livephotos.exoplayer.extractor.mp3.Mp3Extractor */
    public interface HoursOnClickListener {
        void mo1365a(int i);

        void mo1366b(int i);
    }

    public HoursForSingleDayView(Context context) {
        super(context);
        m21372f();
    }

    public HoursForSingleDayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21372f();
    }

    public HoursForSingleDayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21372f();
    }

    private void m21372f() {
        setContentView(2130904802);
        this.f17470a = c(2131562943);
        this.f17471b = (TextView) c(2131562940);
        this.f17472c = (CheckBox) c(2131562939);
        this.f17473d = (HoursIntervalView) c(2131562941);
        this.f17474e = (HoursIntervalView) c(2131562942);
        setChildrenVisibility(this.f17472c.isChecked());
        m21373g();
    }

    public void setDayNameLabel(String str) {
        this.f17471b.setText(str);
    }

    public final void m21374a() {
        setPlaceOpenOrClosed(false);
    }

    public final void m21376b() {
        setPlaceOpenOrClosed(true);
    }

    public final void m21375a(String str, String str2) {
        this.f17473d.m21380a(str, str2);
        setChildrenVisibility(this.f17472c.isChecked());
    }

    public final void m21377b(@Nullable String str, @Nullable String str2) {
        this.f17474e.m21380a(str, str2);
        setChildrenVisibility(this.f17472c.isChecked());
    }

    public void setHoursOnClickListener(final HoursOnClickListener hoursOnClickListener) {
        this.f17473d.setStartHoursOnClickListener(new OnClickListener(this) {
            final /* synthetic */ HoursForSingleDayView f17462b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 34329974);
                hoursOnClickListener.mo1365a(0);
                Logger.a(2, EntryType.UI_INPUT_END, 144403728, a);
            }
        });
        this.f17473d.setEndHoursOnClickListener(new OnClickListener(this) {
            final /* synthetic */ HoursForSingleDayView f17464b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 344053294);
                hoursOnClickListener.mo1366b(0);
                Logger.a(2, EntryType.UI_INPUT_END, 273647675, a);
            }
        });
        this.f17474e.setStartHoursOnClickListener(new OnClickListener(this) {
            final /* synthetic */ HoursForSingleDayView f17466b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1315677558);
                hoursOnClickListener.mo1365a(1);
                Logger.a(2, EntryType.UI_INPUT_END, 1638119475, a);
            }
        });
        this.f17474e.setEndHoursOnClickListener(new OnClickListener(this) {
            final /* synthetic */ HoursForSingleDayView f17468b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1883081274);
                hoursOnClickListener.mo1366b(1);
                Logger.a(2, EntryType.UI_INPUT_END, -547562924, a);
            }
        });
    }

    public void setCheckBoxOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f17472c.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    private void m21373g() {
        OnClickListener c14445 = new C14445(this);
        this.f17470a.setOnClickListener(c14445);
        this.f17471b.setOnClickListener(c14445);
    }

    public void setAddIntervalButtonOnClickListener(OnClickListener onClickListener) {
        this.f17473d.setIconOnClickListener(onClickListener);
    }

    public void setRemoveIntervalButtonOnClickListener(OnClickListener onClickListener) {
        this.f17474e.setIconOnClickListener(onClickListener);
    }

    public final boolean m21378e() {
        return this.f17473d.m21381a();
    }

    public void setChildrenVisibility(boolean z) {
        int i = 8;
        int i2 = 0;
        HoursIntervalView hoursIntervalView = this.f17473d;
        int i3 = (z && this.f17473d.m21381a()) ? 0 : 8;
        hoursIntervalView.setVisibility(i3);
        hoursIntervalView = this.f17474e;
        if (z && this.f17474e.m21381a()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        hoursIntervalView.setVisibility(i3);
        View view = this.f17470a;
        if (!z) {
            i = 0;
        }
        view.setVisibility(i);
        HoursIntervalView hoursIntervalView2 = this.f17473d;
        if (this.f17474e.getVisibility() == 0) {
            i2 = 4;
        }
        hoursIntervalView2.setIconVisibility(i2);
    }

    private void setPlaceOpenOrClosed(boolean z) {
        this.f17472c.setChecked(z);
    }
}
