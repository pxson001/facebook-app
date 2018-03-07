package com.facebook.groups.fb4a.create;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: payments_fetch_payment_option_successful */
public class FB4AGroupsCreatePrivacySelectorFragment extends FbFragment {
    @Inject
    @IsWorkBuild
    public Boolean f6876a;
    private CheckedContentView f6877b;
    private CheckedContentView f6878c;
    private CheckedContentView f6879d;

    /* compiled from: payments_fetch_payment_option_successful */
    class C07151 implements OnClickListener {
        final /* synthetic */ FB4AGroupsCreatePrivacySelectorFragment f6875a;

        C07151(FB4AGroupsCreatePrivacySelectorFragment fB4AGroupsCreatePrivacySelectorFragment) {
            this.f6875a = fB4AGroupsCreatePrivacySelectorFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2102769715);
            FB4AGroupsCreatePrivacySelectorFragment.m7166g(this.f6875a, view.getId());
            Logger.a(2, EntryType.UI_INPUT_END, -1167107631, a);
        }
    }

    private static <T extends InjectableComponentWithContext> void m7162a(Class<T> cls, T t) {
        m7163a((Object) t, t.getContext());
    }

    private static void m7163a(Object obj, Context context) {
        ((FB4AGroupsCreatePrivacySelectorFragment) obj).f6876a = Boolean_IsWorkBuildMethodAutoProvider.a(FbInjector.get(context));
    }

    public final void m7171c(Bundle bundle) {
        super.c(bundle);
        m7162a(FB4AGroupsCreatePrivacySelectorFragment.class, (InjectableComponentWithContext) this);
    }

    public final View m7167a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1972848909);
        View inflate = layoutInflater.inflate(2130904251, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1744154267, a);
        return inflate;
    }

    public final void m7168a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f6877b = (CheckedContentView) e(2131561754);
        this.f6879d = (CheckedContentView) e(2131561753);
        this.f6878c = (CheckedContentView) e(2131561755);
        this.f6879d.setTitleText(this.f6876a.booleanValue() ? 2131239977 : 2131239976);
        this.f6877b.setOnClickListener(m7165e());
        this.f6879d.setOnClickListener(m7165e());
        this.f6878c.setOnClickListener(m7165e());
        aq();
    }

    private void m7161a(Boolean bool) {
        this.f6876a = bool;
    }

    private OnClickListener m7165e() {
        return new C07151(this);
    }

    public final String m7170b() {
        if (this.f6877b.isChecked()) {
            return "Closed";
        }
        if (this.f6879d.isChecked()) {
            return "Open";
        }
        return "Secret";
    }

    public final void m7169a(String str) {
        if ("Closed".equals(str)) {
            m7166g(this, 2131561754);
        } else if ("Open".equals(str)) {
            m7166g(this, 2131561753);
        } else if ("Secret".equals(str)) {
            m7166g(this, 2131561755);
        }
    }

    public static void m7166g(FB4AGroupsCreatePrivacySelectorFragment fB4AGroupsCreatePrivacySelectorFragment, int i) {
        if (i == 2131561754) {
            fB4AGroupsCreatePrivacySelectorFragment.f6877b.setChecked(true);
        } else {
            fB4AGroupsCreatePrivacySelectorFragment.f6877b.setChecked(false);
        }
        if (i == 2131561753) {
            fB4AGroupsCreatePrivacySelectorFragment.f6879d.setChecked(true);
        } else {
            fB4AGroupsCreatePrivacySelectorFragment.f6879d.setChecked(false);
        }
        if (i == 2131561755) {
            fB4AGroupsCreatePrivacySelectorFragment.f6878c.setChecked(true);
        } else {
            fB4AGroupsCreatePrivacySelectorFragment.f6878c.setChecked(false);
        }
        fB4AGroupsCreatePrivacySelectorFragment.aq();
    }

    private void aq() {
        m7159a(this.f6877b);
        m7159a(this.f6879d);
        m7159a(this.f6878c);
    }

    private void m7159a(CheckedContentView checkedContentView) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(checkedContentView.getTitleText());
        m7164a(stringBuilder);
        stringBuilder.append(" ").append(checkedContentView.getSubtitleText());
        m7164a(stringBuilder);
        stringBuilder.append(" ").append(b(checkedContentView.isChecked() ? 2131239985 : 2131239986));
        m7164a(stringBuilder);
        checkedContentView.setContentDescription(stringBuilder.toString());
    }

    private static void m7164a(StringBuilder stringBuilder) {
        if (stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) != '.') {
            stringBuilder.append('.');
        }
    }
}
