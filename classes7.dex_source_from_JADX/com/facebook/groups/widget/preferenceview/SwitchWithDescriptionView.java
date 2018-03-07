package com.facebook.groups.widget.preferenceview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.groups.widget.preferenceview.delegates.SwitchPreferenceDelegate;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: prefetch_successful_no_data */
public class SwitchWithDescriptionView extends CustomFrameLayout {
    public static final String f6072c = SwitchWithDescriptionView.class.getName();
    @Inject
    public DefaultPreferenceSwitchViewManager f6073a;
    @Inject
    public Lazy<FbErrorReporter> f6074b;
    public TextView f6075d;
    public TextView f6076e;
    public CompoundButton f6077f;
    public boolean f6078g = true;
    public SwitchPreferenceDelegate f6079h;

    /* compiled from: prefetch_successful_no_data */
    public class C05481 implements OnCheckedChangeListener {
        final /* synthetic */ SwitchWithDescriptionView f6070a;

        public C05481(SwitchWithDescriptionView switchWithDescriptionView) {
            this.f6070a = switchWithDescriptionView;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.f6070a.f6078g && this.f6070a.f6079h != null) {
                this.f6070a.f6079h.m7855a(z);
            } else if (this.f6070a.f6079h == null) {
                ((AbstractFbErrorReporter) this.f6070a.f6074b.get()).b(SwitchWithDescriptionView.f6072c, "Checking delegate status before it gets set");
            }
        }
    }

    /* compiled from: prefetch_successful_no_data */
    public class C05492 implements OnClickListener {
        final /* synthetic */ SwitchWithDescriptionView f6071a;

        public C05492(SwitchWithDescriptionView switchWithDescriptionView) {
            this.f6071a = switchWithDescriptionView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 808259560);
            this.f6071a.f6077f.setChecked(!this.f6071a.f6077f.isChecked());
            LogUtils.a(1969159506, a);
        }
    }

    public static void m7853a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        SwitchWithDescriptionView switchWithDescriptionView = (SwitchWithDescriptionView) obj;
        DefaultPreferenceSwitchViewManager a = DefaultPreferenceSwitchViewManager.m7849a(injectorLike);
        Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 494);
        switchWithDescriptionView.f6073a = a;
        switchWithDescriptionView.f6074b = b;
    }

    public void setSwitchDesciption(String str) {
        this.f6076e.setText(str);
    }

    public SwitchWithDescriptionView(Context context) {
        super(context);
        Class cls = SwitchWithDescriptionView.class;
        m7853a(this, getContext());
        LayoutInflater.from(this.f6073a.m7850a(context)).inflate(2130907357, this, true);
        ViewStub viewStub = (ViewStub) c(2131567800);
        DefaultPreferenceSwitchViewManager defaultPreferenceSwitchViewManager = this.f6073a;
        viewStub.setLayoutResource(2130906365);
        viewStub.inflate();
        this.f6075d = (TextView) c(2131560499);
        this.f6076e = (TextView) c(2131560500);
        this.f6077f = (CompoundButton) c(2131567801);
        this.f6077f.setOnCheckedChangeListener(new C05481(this));
        setOnClickListener(new C05492(this));
    }

    public void setDelegate(SwitchPreferenceDelegate switchPreferenceDelegate) {
        if (switchPreferenceDelegate != null) {
            this.f6079h = switchPreferenceDelegate;
            this.f6075d.setText(this.f6079h.m7854a());
            this.f6077f.setText(this.f6079h.m7854a());
            boolean b = this.f6079h.m7856b();
            this.f6078g = false;
            this.f6077f.setChecked(b);
            this.f6078g = true;
        }
    }
}
