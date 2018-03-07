package com.facebook.registration.fragment;

import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.growth.model.Birthday;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.registration.constants.RegErrorCategory;
import com.facebook.registration.constants.RegFragmentState;
import com.facebook.registration.fragment.RegistrationInputFragment.RegInputException;
import com.facebook.registration.ui.RegClickableSpan.TargetActivity;
import com.facebook.registration.ui.RegClickableSpanProvider;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.widget.dialog.FbDatePickerDialog;
import com.facebook.widget.text.BetterLinkMovementMethod;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: last_upsell_decline_ms */
public class RegistrationBirthdayFragment extends RegistrationInputFragment {
    public EditText an;
    public DatePicker ao;
    public boolean ap = false;
    @Inject
    public BetterLinkMovementMethod f8781b;
    @Inject
    public Provider<Locale> f8782c;
    @Inject
    public RegClickableSpanProvider f8783d;

    /* compiled from: last_upsell_decline_ms */
    class C13121 implements OnCancelListener {
        final /* synthetic */ RegistrationBirthdayFragment f8768a;

        C13121(RegistrationBirthdayFragment registrationBirthdayFragment) {
            this.f8768a = registrationBirthdayFragment;
        }

        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: last_upsell_decline_ms */
    class C13132 implements OnClickListener {
        final /* synthetic */ RegistrationBirthdayFragment f8769a;

        C13132(RegistrationBirthdayFragment registrationBirthdayFragment) {
            this.f8769a = registrationBirthdayFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: last_upsell_decline_ms */
    class C13143 implements OnClickListener {
        final /* synthetic */ RegistrationBirthdayFragment f8770a;

        C13143(RegistrationBirthdayFragment registrationBirthdayFragment) {
            this.f8770a = registrationBirthdayFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f8770a.ap = false;
            this.f8770a.ay();
        }
    }

    /* compiled from: last_upsell_decline_ms */
    public class C13154 implements OnDateChangedListener {
        final /* synthetic */ RegistrationBirthdayFragment f8771a;

        public C13154(RegistrationBirthdayFragment registrationBirthdayFragment) {
            this.f8771a = registrationBirthdayFragment;
        }

        public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
            this.f8771a.ap = false;
            this.f8771a.f8777f.a(i, i2, i3);
        }
    }

    public static void m8780a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RegistrationBirthdayFragment registrationBirthdayFragment = (RegistrationBirthdayFragment) obj;
        BetterLinkMovementMethod a = BetterLinkMovementMethod.a(fbInjector);
        Provider a2 = IdBasedProvider.a(fbInjector, 4483);
        RegClickableSpanProvider regClickableSpanProvider = (RegClickableSpanProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(RegClickableSpanProvider.class);
        registrationBirthdayFragment.f8781b = a;
        registrationBirthdayFragment.f8782c = a2;
        registrationBirthdayFragment.f8783d = regClickableSpanProvider;
    }

    public final void mo394c(Bundle bundle) {
        super.mo394c(bundle);
        Class cls = RegistrationBirthdayFragment.class;
        m8780a((Object) this, getContext());
    }

    protected final void mo393b(View view) {
        this.an = (EditText) view.findViewById(2131567127);
        this.ao = (DatePicker) view.findViewById(2131566907);
        Resources jW_ = jW_();
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(jW_);
        styledStringBuilder.a(StringFormatUtil.formatStrLocaleSafe(b(as()), "[[birthday_help]]"));
        styledStringBuilder.a("[[birthday_help]]", jW_.getString(2131230747), this.f8783d.a(TargetActivity.BROWSER, "http://m.facebook.com/birthday_help.php"), 33);
        this.al.setContentDescription(styledStringBuilder.b());
        this.al.setText(styledStringBuilder.b());
        this.al.setMovementMethod(this.f8781b);
        aC();
    }

    protected final int mo384e() {
        return 2131239821;
    }

    protected final int mz_() {
        return 2131239822;
    }

    public final int as() {
        return 2131239825;
    }

    protected final int at() {
        return 2130906797;
    }

    protected final void au() {
        if (this.f8777f.k() == null) {
            throw new RegInputException(2131239824);
        }
    }

    protected final void av() {
    }

    protected final RegFragmentState aw() {
        return RegFragmentState.BIRTHDAY_ACQUIRED;
    }

    protected final RegErrorCategory ax() {
        return RegErrorCategory.BIRTHDAY;
    }

    protected final void ay() {
        if (this.ap) {
            KeyboardUtils.a(o());
            new Builder(o()).a(2131239826).b(StringFormatUtil.formatStrLocaleSafe(b(2131239827), m8779a(this, this.f8777f.k()))).a(2131230735, new C13143(this)).b(2131230736, new C13132(this)).a(new C13121(this)).a().show();
            return;
        }
        super.ay();
    }

    private void aC() {
        Birthday birthday;
        if (this.f8777f.k() != null) {
            birthday = new Birthday(this.f8777f.k, this.f8777f.l, this.f8777f.m);
        } else {
            this.ap = this.ao != null;
            Calendar instance = Calendar.getInstance();
            instance.add(1, -18);
            birthday = new Birthday(instance.get(1), instance.get(2), instance.get(5));
        }
        if (this.ao != null) {
            this.ao.init(birthday.c, birthday.b, birthday.a, new C13154(this));
            this.ao.setMaxDate(new Date().getTime());
            this.f8777f.a(birthday.c, birthday.b, birthday.a);
            return;
        }
        if (this.f8777f.k() != null) {
            this.an.setText(m8779a(this, this.f8777f.k()));
        }
        this.an.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ RegistrationBirthdayFragment f8775b;

            /* compiled from: last_upsell_decline_ms */
            class C13161 implements OnDateSetListener {
                final /* synthetic */ C13185 f8772a;

                C13161(C13185 c13185) {
                    this.f8772a = c13185;
                }

                public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                    this.f8772a.f8775b.f8777f.a(i, i2, i3);
                    this.f8772a.f8775b.an.setText(RegistrationBirthdayFragment.m8779a(this.f8772a.f8775b, this.f8772a.f8775b.f8777f.k()));
                }
            }

            /* compiled from: last_upsell_decline_ms */
            class C13172 implements OnDismissListener {
                final /* synthetic */ C13185 f8773a;

                C13172(C13185 c13185) {
                    this.f8773a = c13185;
                }

                public void onDismiss(DialogInterface dialogInterface) {
                    KeyboardUtils.a(this.f8773a.f8775b.o());
                }
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1126532113);
                FbDatePickerDialog fbDatePickerDialog = new FbDatePickerDialog(this.f8775b.getContext(), 2131626293, new C13161(this), birthday.c, birthday.b, birthday.a);
                fbDatePickerDialog.setOnDismissListener(new C13172(this));
                fbDatePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
                fbDatePickerDialog.show();
                Logger.a(2, EntryType.UI_INPUT_END, 1790648129, a);
            }
        });
    }

    public static String m8779a(RegistrationBirthdayFragment registrationBirthdayFragment, Date date) {
        return DateFormat.getDateInstance(2, (Locale) registrationBirthdayFragment.f8782c.get()).format(date);
    }
}
