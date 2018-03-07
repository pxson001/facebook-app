package com.facebook.messaging.sms.migration;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.base.fragment.AbstractNavigableFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.ui.util.DynamicLayoutUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.contactsync.learn.ContactsLearnMoreLinkHelper;
import com.facebook.messaging.sms.migration.abtest.ExperimentsForSMSMigrationModule;
import com.facebook.messaging.sms.migration.pref.SMSMigrationPrefKeys;
import com.facebook.messaging.sms.migration.util.SMSContactsMigrationTextUtil;
import com.facebook.messaging.sms.migration.util.SMSUploadUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: pymk_seen */
public class SMSUploadFragment extends AbstractNavigableFragment {
    @Inject
    SMSUploadUtil al;
    @Inject
    ContactsLearnMoreLinkHelper f4206d;
    @Inject
    public DynamicLayoutUtil f4207e;
    @Inject
    FbSharedPreferences f4208f;
    @Inject
    QeAccessor f4209g;
    @Inject
    Resources f4210h;
    @Inject
    SMSContactsMigrationTextUtil f4211i;

    /* compiled from: pymk_seen */
    class C06361 implements OnClickListener {
        final /* synthetic */ SMSUploadFragment f4214a;

        C06361(SMSUploadFragment sMSUploadFragment) {
            this.f4214a = sMSUploadFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1730500284);
            this.f4214a.mo123e();
            Logger.a(2, EntryType.UI_INPUT_END, 1071960549, a);
        }
    }

    /* compiled from: pymk_seen */
    class C06372 implements OnClickListener {
        final /* synthetic */ SMSUploadFragment f4215a;

        C06372(SMSUploadFragment sMSUploadFragment) {
            this.f4215a = sMSUploadFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -482279713);
            this.f4215a.aq();
            Logger.a(2, EntryType.UI_INPUT_END, -1554674955, a);
        }
    }

    /* compiled from: pymk_seen */
    class C06383 implements OnClickListener {
        final /* synthetic */ SMSUploadFragment f4216a;

        C06383(SMSUploadFragment sMSUploadFragment) {
            this.f4216a = sMSUploadFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 411093781);
            this.f4216a.f4206d.m1896a();
            Logger.a(2, EntryType.UI_INPUT_END, 148670908, a);
        }
    }

    public static void m3851a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SMSUploadFragment) obj).m3850a(ContactsLearnMoreLinkHelper.m1895b(fbInjector), DynamicLayoutUtil.b(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), ResourcesMethodAutoProvider.a(fbInjector), SMSContactsMigrationTextUtil.m3864b(fbInjector), SMSUploadUtil.m3866b(fbInjector));
    }

    public void a_(Context context) {
        super.a_(context);
        Class cls = SMSUploadFragment.class;
        m3851a((Object) this, getContext());
    }

    public final View m3853a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2072359231);
        View inflate = layoutInflater.inflate(2130907141, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2051982144, a);
        return inflate;
    }

    public final void m3854a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        ((ImageView) e(2131564977)).setImageResource(2130841305);
        ((TextView) e(2131558927)).setText(m3849a(ExperimentsForSMSMigrationModule.f4230n, 2131240055));
        TextView textView = (TextView) e(2131564978);
        textView.setText(m3849a(ExperimentsForSMSMigrationModule.f4226j, 2131240058));
        textView.setOnClickListener(new C06361(this));
        textView = (TextView) e(2131564979);
        textView.setText(m3849a(ExperimentsForSMSMigrationModule.f4227k, 2131240059));
        textView.setOnClickListener(new C06372(this));
        textView = (TextView) e(2131564980);
        CharSequence spannableString = new SpannableString(m3849a(ExperimentsForSMSMigrationModule.f4229m, 2131240060));
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
        textView.setText(spannableString);
        textView.setOnClickListener(new C06383(this));
        m3852a(m3849a(ExperimentsForSMSMigrationModule.f4225i, 2131240056));
        View view2 = this.T;
        this.f4207e.a(view2, jW_().getInteger(2131492956), ImmutableList.of(Integer.valueOf(2131564977)));
        this.f4207e.a(view2, jW_().getInteger(2131492955), ImmutableList.of(Integer.valueOf(2131558927), Integer.valueOf(2131563835)), ImmutableList.of(Integer.valueOf(2131427716), Integer.valueOf(2131427718)), ImmutableList.of(Integer.valueOf(2131427715), Integer.valueOf(2131427717)));
    }

    private void m3850a(ContactsLearnMoreLinkHelper contactsLearnMoreLinkHelper, DynamicLayoutUtil dynamicLayoutUtil, FbSharedPreferences fbSharedPreferences, QeAccessor qeAccessor, Resources resources, SMSContactsMigrationTextUtil sMSContactsMigrationTextUtil, SMSUploadUtil sMSUploadUtil) {
        this.f4206d = contactsLearnMoreLinkHelper;
        this.f4207e = dynamicLayoutUtil;
        this.f4208f = fbSharedPreferences;
        this.f4209g = qeAccessor;
        this.f4210h = resources;
        this.f4211i = sMSContactsMigrationTextUtil;
        this.al = sMSUploadUtil;
    }

    private void m3852a(String str) {
        TextView textView = (TextView) e(2131563835);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(this.f4211i.m3865a(str, "{learn_more_link}", m3849a(ExperimentsForSMSMigrationModule.f4228l, 2131240057)));
    }

    protected void mo123e() {
        this.al.m3867a();
        as();
    }

    protected void aq() {
        as();
    }

    private void as() {
        b(SMSContactsMigratorConstants.f4179a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -660000081);
        super.mi_();
        this.f4208f.edit().putBoolean(SMSMigrationPrefKeys.f4235a, true).commit();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1244541733, a);
    }

    private String m3849a(char c, int i) {
        return this.f4209g.a(Liveness.Cached, ExposureLogging.Off, c, i, this.f4210h);
    }
}
