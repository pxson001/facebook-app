package com.facebook.groups.widget.preferenceview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.facebook.groups.widget.preferenceview.delegates.SwitchPreferenceDelegate;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: preselected_recipients */
public class SwitchPreferenceView extends CustomFrameLayout {
    @Inject
    public DefaultPreferenceSwitchViewManager f6065a;
    public TextView f6066b;
    public CompoundButton f6067c;
    public boolean f6068d = true;
    public SwitchPreferenceDelegate f6069e = null;

    /* compiled from: preselected_recipients */
    public class C05461 implements OnCheckedChangeListener {
        final /* synthetic */ SwitchPreferenceView f6063a;

        public C05461(SwitchPreferenceView switchPreferenceView) {
            this.f6063a = switchPreferenceView;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.f6063a.f6068d && this.f6063a.f6069e != null) {
                this.f6063a.f6069e.m7855a(z);
            }
        }
    }

    /* compiled from: preselected_recipients */
    public class C05472 implements OnClickListener {
        final /* synthetic */ SwitchPreferenceView f6064a;

        public C05472(SwitchPreferenceView switchPreferenceView) {
            this.f6064a = switchPreferenceView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 159272412);
            this.f6064a.f6067c.setChecked(!this.f6064a.f6067c.isChecked());
            LogUtils.a(-579458087, a);
        }
    }

    public static void m7852a(Object obj, Context context) {
        ((SwitchPreferenceView) obj).f6065a = DefaultPreferenceSwitchViewManager.m7849a(FbInjector.get(context));
    }

    public SwitchPreferenceView(Context context) {
        super(context);
        Class cls = SwitchPreferenceView.class;
        m7852a(this, getContext());
        LayoutInflater.from(this.f6065a.m7850a(context)).inflate(2130907356, this, true);
        this.f6066b = (TextView) c(2131560307);
        ViewStub viewStub = (ViewStub) c(2131567800);
        DefaultPreferenceSwitchViewManager defaultPreferenceSwitchViewManager = this.f6065a;
        viewStub.setLayoutResource(2130906365);
        viewStub.inflate();
        this.f6067c = (CompoundButton) c(2131567801);
        this.f6067c.setOnCheckedChangeListener(new C05461(this));
        setOnClickListener(new C05472(this));
    }

    public void setDelegate(SwitchPreferenceDelegate switchPreferenceDelegate) {
        if (switchPreferenceDelegate != null) {
            this.f6069e = switchPreferenceDelegate;
            this.f6066b.setText(this.f6069e.m7854a());
            this.f6067c.setText(this.f6069e.m7854a());
            boolean b = this.f6069e.m7856b();
            this.f6068d = false;
            this.f6067c.setChecked(b);
            this.f6068d = true;
        }
    }
}
