package com.facebook.messaging.tincan.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.inject.FbInjector;
import com.facebook.orca.compose.ComposerKeyboardManager.EphemeralKeyboardFactory.C07711;
import com.facebook.ultralight.Inject;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: placefeed */
public class EphemeralKeyboardView extends CustomLinearLayout {
    public static final int[] f4846a = new int[]{0, 1, 2, 3, 4, 5, 10, 30, 60, 300, 3600};
    @Inject
    public DefaultTimeFormatUtil f4847b;
    public NumberPicker f4848c = ((NumberPicker) a(2131561200));
    @Nullable
    public C07711 f4849d;
    public String[] f4850e;
    public TextView f4851f = ((TextView) a(2131561199));

    /* compiled from: placefeed */
    public class C06611 implements OnValueChangeListener {
        final /* synthetic */ EphemeralKeyboardView f4845a;

        public C06611(EphemeralKeyboardView ephemeralKeyboardView) {
            this.f4845a = ephemeralKeyboardView;
        }

        public void onValueChange(NumberPicker numberPicker, int i, int i2) {
            EphemeralKeyboardView.m4388c(this.f4845a, i2);
            if (this.f4845a.f4849d != null) {
                this.f4845a.f4849d.m5034a((int) (((long) EphemeralKeyboardView.f4846a[i2]) * 1000));
            }
        }
    }

    public static void m4387a(Object obj, Context context) {
        ((EphemeralKeyboardView) obj).f4847b = DefaultTimeFormatUtil.a(FbInjector.get(context));
    }

    public EphemeralKeyboardView(Context context) {
        super(context);
        Class cls = EphemeralKeyboardView.class;
        m4387a(this, getContext());
        setContentView(2130903986);
        setOrientation(1);
        setBackgroundResource(17170443);
        if (this.f4850e == null) {
            this.f4850e = new String[f4846a.length];
            this.f4850e[0] = getResources().getString(2131232415);
            for (int i = 1; i < f4846a.length; i++) {
                this.f4850e[i] = this.f4847b.a(TimeFormatStyle.DURATION_LARGEST_UNIT_STYLE, ((long) f4846a[i]) * 1000);
            }
        }
        this.f4848c.setDisplayedValues(this.f4850e);
        this.f4848c.setMinValue(0);
        this.f4848c.setMaxValue(this.f4850e.length - 1);
        this.f4848c.setWrapSelectorWheel(false);
        this.f4848c.setOnValueChangedListener(new C06611(this));
        m4388c(this, this.f4848c.getValue());
    }

    public static void m4388c(EphemeralKeyboardView ephemeralKeyboardView, int i) {
        if (i == 0) {
            ephemeralKeyboardView.f4851f.setText(ephemeralKeyboardView.getResources().getString(2131232413));
            ephemeralKeyboardView.f4851f.setTextColor(ephemeralKeyboardView.getResources().getColor(17170444));
            return;
        }
        ephemeralKeyboardView.f4851f.setText(ephemeralKeyboardView.getResources().getString(2131232414, new Object[]{ephemeralKeyboardView.f4850e[i]}));
        ephemeralKeyboardView.f4851f.setTextColor(ephemeralKeyboardView.getResources().getColor(2131362298));
    }
}
