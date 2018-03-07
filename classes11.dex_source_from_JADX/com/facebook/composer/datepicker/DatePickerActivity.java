package com.facebook.composer.datepicker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.fragment.FbFragment;
import com.facebook.graphql.enums.GraphQLLifeEventAPIIdentifier;
import com.facebook.uicontrib.datepicker.Date;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;

/* compiled from: has_done_pulsar_scan_once */
public class DatePickerActivity extends FbFragmentActivity {
    private GraphQLLifeEventAPIIdentifier f6367p;

    /* compiled from: has_done_pulsar_scan_once */
    class C07961 extends OnToolbarButtonListener {
        final /* synthetic */ DatePickerActivity f6365a;

        C07961(DatePickerActivity datePickerActivity) {
            this.f6365a = datePickerActivity;
        }

        public final void m7781a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f6365a.setResult(-1, DatePickerActivity.m7790j(this.f6365a));
            this.f6365a.finish();
        }
    }

    /* compiled from: has_done_pulsar_scan_once */
    /* synthetic */ class C07972 {
        static final /* synthetic */ int[] f6366a = new int[GraphQLLifeEventAPIIdentifier.values().length];

        static {
            try {
                f6366a[GraphQLLifeEventAPIIdentifier.MARRIED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6366a[GraphQLLifeEventAPIIdentifier.ENGAGED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6366a[GraphQLLifeEventAPIIdentifier.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6366a[GraphQLLifeEventAPIIdentifier.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6366a[GraphQLLifeEventAPIIdentifier.STARTED_JOB.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f6366a[GraphQLLifeEventAPIIdentifier.GRADUATED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* compiled from: has_done_pulsar_scan_once */
    public enum DatePickerType {
        DATE,
        WORK_PERIOD,
        EDUCATION_PERIOD
    }

    public final void m7792b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130903664);
        m7789i();
        if (bundle == null) {
            Fragment e;
            Bundle extras = getIntent().getExtras();
            this.f6367p = GraphQLLifeEventAPIIdentifier.valueOf(extras.getString("mleType"));
            DatePickerType a = m7784a(this.f6367p);
            if (a.equals(DatePickerType.EDUCATION_PERIOD)) {
                e = m7788e(extras);
            } else if (a.equals(DatePickerType.WORK_PERIOD)) {
                e = m7787d(extras);
            } else {
                e = m7786c(extras);
            }
            kO_().a().a(2131560496, e).b();
            return;
        }
        this.f6367p = GraphQLLifeEventAPIIdentifier.valueOf(bundle.getString("mleType"));
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("mleType", this.f6367p.name());
    }

    private void m7789i() {
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
        fbTitleBar.setTitle(getResources().getString(2131242366));
        m7785a(fbTitleBar);
        fbTitleBar.setOnToolbarButtonListener(new C07961(this));
    }

    private void m7785a(FbTitleBar fbTitleBar) {
        Builder a = TitleBarButtonSpec.a();
        a.a = 1;
        a = a;
        a.g = getResources().getString(2131230733);
        a = a;
        a.h = -2;
        fbTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
    }

    public static Intent m7790j(DatePickerActivity datePickerActivity) {
        return ((IResultIntentFragment) datePickerActivity.kO_().a(2131560496)).mo187b();
    }

    private static DatePickerType m7784a(GraphQLLifeEventAPIIdentifier graphQLLifeEventAPIIdentifier) {
        switch (C07972.f6366a[graphQLLifeEventAPIIdentifier.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return DatePickerType.DATE;
            case 5:
                return DatePickerType.WORK_PERIOD;
            case 6:
                return DatePickerType.EDUCATION_PERIOD;
            default:
                return DatePickerType.DATE;
        }
    }

    private static FbFragment m7786c(Bundle bundle) {
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("startDate", bundle.getParcelable("startDate"));
        Date date = (Date) bundle.getParcelable("minimumDate");
        if (date != null) {
            bundle2.putParcelable("minimumDate", date);
        }
        datePickerFragment.g(bundle2);
        return datePickerFragment;
    }

    private FbFragment m7787d(Bundle bundle) {
        WorkPeriodPickerFragment workPeriodPickerFragment = new WorkPeriodPickerFragment();
        Bundle bundle2 = new Bundle();
        Date date = (Date) bundle.getParcelable("minimumDate");
        if (date != null) {
            bundle2.putParcelable("minimumDate", date);
        }
        GraphQLLifeEventAPIIdentifier.valueOf(bundle.getString("mleType"));
        bundle2.putString("currentActionText", m7791k());
        bundle2.putBoolean("isCurrent", bundle.getBoolean("isCurrent"));
        bundle2.putParcelable("startDate", bundle.getParcelable("startDate"));
        bundle2.putParcelable("endDate", bundle.getParcelable("endDate"));
        workPeriodPickerFragment.g(bundle2);
        return workPeriodPickerFragment;
    }

    private static FbFragment m7788e(Bundle bundle) {
        EducationPeriodPickerFragment educationPeriodPickerFragment = new EducationPeriodPickerFragment();
        Bundle bundle2 = new Bundle();
        Date date = (Date) bundle.getParcelable("minimumDate");
        if (date != null) {
            bundle2.putParcelable("minimumDate", date);
        }
        bundle2.putBoolean("hasGraduated", bundle.getBoolean("hasGraduated"));
        bundle2.putParcelable("startDate", bundle.getParcelable("startDate"));
        bundle2.putParcelable("endDate", bundle.getParcelable("endDate"));
        educationPeriodPickerFragment.g(bundle2);
        return educationPeriodPickerFragment;
    }

    private String m7791k() {
        return getResources().getString(2131242370);
    }

    public static Intent m7782a(Context context, GraphQLLifeEventAPIIdentifier graphQLLifeEventAPIIdentifier, Date date, Date date2, Date date3, boolean z, boolean z2) {
        Intent intent = new Intent(context, DatePickerActivity.class);
        intent.putExtra("mleType", graphQLLifeEventAPIIdentifier.name());
        if (date != null) {
            intent.putExtra("minimumDate", date);
        }
        if (date2 != null) {
            intent.putExtra("startDate", date2);
        }
        if (date3 != null) {
            intent.putExtra("endDate", date3);
        }
        intent.putExtra("isCurrent", z);
        intent.putExtra("hasGraduated", z2);
        return intent;
    }
}
