package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.abtest.ExperimentsForAdInterfacesModule;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper.ScheduleOption;
import com.facebook.adinterfaces.ui.EditableRadioGroup.OnCheckedChangeRadioGroupListener;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Preconditions;
import java.text.DateFormat;
import java.util.Calendar;
import javax.inject.Inject;

/* compiled from: UriMapHelper */
public class AdInterfacesScheduleView extends CustomLinearLayout {
    private EditableRadioGroup f22922a;
    private FbCustomRadioButton[] f22923b;
    public Long f22924c;
    private String f22925d;
    private DateFormat f22926e;
    @Inject
    public QeAccessor f22927f;

    private static <T extends View> void m24885a(Class<T> cls, T t) {
        m24886a((Object) t, t.getContext());
    }

    private static void m24886a(Object obj, Context context) {
        ((AdInterfacesScheduleView) obj).f22927f = (QeAccessor) QeInternalImplMethodAutoProvider.a(FbInjector.get(context));
    }

    public AdInterfacesScheduleView(Context context) {
        super(context);
        m24888c();
    }

    public AdInterfacesScheduleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24888c();
    }

    protected AdInterfacesScheduleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24888c();
    }

    private void m24888c() {
        int i;
        int i2 = 0;
        m24885a(AdInterfacesScheduleView.class, (View) this);
        setContentView(2130903142);
        setOrientation(1);
        ScheduleOption[] values = ScheduleOption.values();
        int length = values.length;
        this.f22926e = DateFormat.getDateInstance(2);
        this.f22922a = (EditableRadioGroup) a(2131559257);
        this.f22923b = new FbCustomRadioButton[length];
        for (i = 0; i < length; i++) {
            this.f22923b[i] = m24882a(i, getResources().getString(m24887b(values[i])));
        }
        if (this.f22927f.a(ExperimentsForAdInterfacesModule.f21613j, false)) {
            m24883a(ScheduleOption.CONTINUOUS);
            String string = getResources().getString(2131233913);
            while (i2 < length) {
                if (values[i2].isFixedDuration()) {
                    Calendar instance = Calendar.getInstance();
                    instance.add(5, values[i2].getDuration());
                    this.f22923b[i2].setTextTextViewEnd(m24881a(Long.valueOf(instance.getTimeInMillis()), string));
                }
                i2++;
            }
        } else {
            for (i = 0; i < length; i++) {
                if (values[i].isFixedDuration()) {
                    m24883a(values[i]);
                }
            }
        }
        this.f22925d = getResources().getString(2131233912);
        Calendar instance2 = Calendar.getInstance();
        instance2.add(5, 10);
        this.f22924c = Long.valueOf(instance2.getTimeInMillis());
        m24889a();
    }

    private void m24884a(QeAccessor qeAccessor) {
        this.f22927f = qeAccessor;
    }

    public void setDateOnClickListener(OnClickListener onClickListener) {
        this.f22923b[ScheduleOption.SPECIFIC_DATE.ordinal()].setOnClickListener(onClickListener);
    }

    public final void m24889a() {
        String format = this.f22926e.format(this.f22924c);
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(getResources());
        styledStringBuilder.a(this.f22925d);
        styledStringBuilder.a("date", format, new TextAppearanceSpan(getContext(), 2131625324), 33);
        this.f22923b[ScheduleOption.SPECIFIC_DATE.ordinal()].setTextTextViewStart(styledStringBuilder.b());
    }

    private SpannableString m24881a(Long l, String str) {
        CharSequence format = this.f22926e.format(l);
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(getResources());
        styledStringBuilder.a(str);
        styledStringBuilder.a("date", format);
        return styledStringBuilder.b();
    }

    @Deprecated
    public final void m24890b() {
        m24883a(ScheduleOption.CONTINUOUS);
    }

    public final void m24891c(int i) {
        boolean z = i >= 0 && i < this.f22923b.length;
        Preconditions.checkArgument(z);
        this.f22922a.m25129a(this.f22922a.getChildAt(i).getId());
    }

    public Long getDate() {
        return this.f22924c;
    }

    public void setOnCheckChangedListener(OnCheckedChangeRadioGroupListener onCheckedChangeRadioGroupListener) {
        this.f22922a.f23144d = onCheckedChangeRadioGroupListener;
    }

    public int getSelectedIndex() {
        View findViewById = findViewById(this.f22922a.f23141a);
        if (findViewById == null || findViewById.getTag() == null) {
            return -1;
        }
        return ((Integer) findViewById.getTag()).intValue();
    }

    public void setDate(Long l) {
        this.f22924c = l;
        m24889a();
    }

    private void m24883a(ScheduleOption scheduleOption) {
        FbCustomRadioButton fbCustomRadioButton = this.f22923b[scheduleOption.ordinal()];
        fbCustomRadioButton.setEnabled(false);
        fbCustomRadioButton.setVisibility(8);
    }

    private FbCustomRadioButton m24882a(int i, CharSequence charSequence) {
        FbCustomRadioButton fbCustomRadioButton = (FbCustomRadioButton) LayoutInflater.from(getContext()).inflate(2130903141, this.f22922a, false);
        fbCustomRadioButton.setTextTextViewStart(charSequence);
        fbCustomRadioButton.setTag(Integer.valueOf(i));
        this.f22922a.addView(fbCustomRadioButton);
        return fbCustomRadioButton;
    }

    private static int m24887b(ScheduleOption scheduleOption) {
        switch (scheduleOption) {
            case SEVEN_DAYS:
                return 2131233914;
            case FOURTEEN_DAYS:
                return 2131233915;
            case TWENTY_EIGHT_DAYS:
                return 2131233916;
            case CONTINUOUS:
                return 2131233911;
            case SPECIFIC_DATE:
                return 2131233912;
            default:
                throw new IllegalArgumentException("Illegal schedule option");
        }
    }
}
