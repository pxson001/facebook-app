package com.facebook.registration.fragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.growth.model.Gender;
import com.facebook.inject.FbInjector;
import com.facebook.registration.constants.RegErrorCategory;
import com.facebook.registration.constants.RegFragmentState;
import com.facebook.registration.fragment.RegistrationInputFragment.RegInputException;
import com.facebook.registration.util.RegistrationUtil;
import javax.inject.Inject;

/* compiled from: last_geofence/ */
public class RegistrationGenderFragment extends RegistrationInputFragment {
    private static final CallerContext f8828c = CallerContext.a(RegistrationGenderFragment.class);
    @Inject
    public RegistrationUtil f8829b;
    private RadioGroup f8830d;

    /* compiled from: last_geofence/ */
    class C13301 implements OnCheckedChangeListener {
        final /* synthetic */ RegistrationGenderFragment f8827a;

        C13301(RegistrationGenderFragment registrationGenderFragment) {
            this.f8827a = registrationGenderFragment;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == 2131559290) {
                this.f8827a.f8777f.o = Gender.MALE;
                return;
            }
            this.f8827a.f8777f.o = Gender.FEMALE;
        }
    }

    public static void m8826a(Object obj, Context context) {
        ((RegistrationGenderFragment) obj).f8829b = RegistrationUtil.b(FbInjector.get(context));
    }

    public final void mo394c(Bundle bundle) {
        super.mo394c(bundle);
        Class cls = RegistrationGenderFragment.class;
        m8826a(this, getContext());
    }

    @TargetApi(17)
    protected final void mo393b(View view) {
        this.f8830d = (RadioGroup) FindViewUtil.b(view, 2131559288);
        RadioButton radioButton = (RadioButton) FindViewUtil.b(view, 2131559290);
        RadioButton radioButton2 = (RadioButton) FindViewUtil.b(view, 2131559291);
        radioButton.setText(2131239831);
        radioButton2.setText(2131239832);
        Gender gender = this.f8777f.o;
        if (gender == Gender.MALE) {
            radioButton.setChecked(true);
        } else if (gender == Gender.FEMALE) {
            radioButton2.setChecked(true);
        }
        this.f8830d.setOnCheckedChangeListener(new C13301(this));
        Drawable[] compoundDrawables = radioButton.getCompoundDrawables();
        compoundDrawables[0].setAlpha(90);
        radioButton.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        boolean z = VERSION.SDK_INT >= 17;
        if (z) {
            radioButton.setCompoundDrawablesRelative(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
        Drawable[] compoundDrawables2 = radioButton2.getCompoundDrawables();
        compoundDrawables2[0].setAlpha(90);
        radioButton2.setCompoundDrawables(compoundDrawables2[0], compoundDrawables2[1], compoundDrawables2[2], compoundDrawables2[3]);
        if (z) {
            radioButton2.setCompoundDrawablesRelative(compoundDrawables2[0], compoundDrawables2[1], compoundDrawables2[2], compoundDrawables2[3]);
        }
        aB();
    }

    protected final int mo384e() {
        return 2131239828;
    }

    protected final int mz_() {
        return 2131239829;
    }

    protected final int as() {
        return 2131239830;
    }

    protected final int at() {
        return 2130906803;
    }

    protected final void au() {
        Gender gender = this.f8777f.o;
        if (gender != Gender.MALE && gender != Gender.FEMALE) {
            throw new RegInputException(2131239833);
        }
    }

    protected final void av() {
    }

    protected final RegFragmentState aw() {
        return RegFragmentState.GENDER_ACQUIRED;
    }

    protected final RegErrorCategory ax() {
        return RegErrorCategory.GENDER;
    }

    private void aB() {
        if (this.f8776e.a(16, false) && this.f8777f.e == null) {
            if (this.f8777f.o == null) {
                this.f8777f.o = Gender.UNKNOWN;
            }
            this.f8777f.e = this.f8829b.a(f8828c);
        }
    }
}
