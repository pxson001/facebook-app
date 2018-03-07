package com.facebook.appdiscovery.composer.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.appdiscovery.composer.ui.AppTitleBar;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbAutoUnFocusEditText;
import com.facebook.widget.listview.BetterListView;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: cta_lead_gen_share_click */
public class AppPickerFragment extends FbFragment {
    public static final String f16437d = AppPickerFragment.class.toString();
    @Inject
    public AbstractFbErrorReporter f16438a;
    public AppTitleBar al;
    public View am;
    @Inject
    public ApplicationAdapterProvider f16439b;
    @Inject
    public ComposerLauncher f16440c;
    public PackageManager f16441e;
    private BetterListView f16442f;
    public ApplicationAdapter f16443g;
    public List<ApplicationInfo> f16444h;
    public FbAutoUnFocusEditText f16445i;

    /* compiled from: cta_lead_gen_share_click */
    class C12921 implements OnItemClickListener {
        final /* synthetic */ AppPickerFragment f16431a;

        C12921(AppPickerFragment appPickerFragment) {
            this.f16431a = appPickerFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppPickerFragment appPickerFragment = this.f16431a;
            if (i >= adapterView.getAdapter().getCount()) {
                appPickerFragment.f16438a.b(AppPickerFragment.f16437d, "Clicking outside of adapter bounds");
                return;
            }
            ApplicationInfo applicationInfo = (ApplicationInfo) appPickerFragment.f16443g.getItem(i);
            if (applicationInfo == null) {
                appPickerFragment.f16438a.b(AppPickerFragment.f16437d, "Expected an application item but received null");
                return;
            }
            String str = applicationInfo.packageName;
            Builder a = ComposerConfiguration.a((ComposerConfiguration) appPickerFragment.o().getIntent().getParcelableExtra("composerConfig"));
            a.setInitialShareParams(ComposerShareParams.Builder.a("https://play.google.com/store/apps/details?id=" + str).b());
            appPickerFragment.f16440c.a(appPickerFragment.o().getIntent().getStringExtra("composerSessionId"), a.a(), 1756, appPickerFragment);
        }
    }

    /* compiled from: cta_lead_gen_share_click */
    public class C12932 implements OnClickListener {
        final /* synthetic */ AppPickerFragment f16432a;

        public C12932(AppPickerFragment appPickerFragment) {
            this.f16432a = appPickerFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 370306800);
            this.f16432a.o().onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -630904821, a);
        }
    }

    /* compiled from: cta_lead_gen_share_click */
    public class C12943 implements OnClickListener {
        final /* synthetic */ AppPickerFragment f16433a;

        public C12943(AppPickerFragment appPickerFragment) {
            this.f16433a = appPickerFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1153867087);
            AppPickerFragment appPickerFragment = this.f16433a;
            if (appPickerFragment.f16445i != null && appPickerFragment.f16445i.getText().length() > 0) {
                appPickerFragment.f16445i.setText("");
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1919640851, a);
        }
    }

    /* compiled from: cta_lead_gen_share_click */
    class C12954 implements TextWatcher {
        final /* synthetic */ AppPickerFragment f16434a;

        C12954(AppPickerFragment appPickerFragment) {
            this.f16434a = appPickerFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.f16434a.f16445i.getText().toString().isEmpty()) {
                this.f16434a.am.setVisibility(8);
            } else {
                this.f16434a.am.setVisibility(0);
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: cta_lead_gen_share_click */
    class LoadApplications extends FbAsyncTask<Void, Void, Void> {
        final /* synthetic */ AppPickerFragment f16435a;
        private ProgressDialog f16436b = null;

        public LoadApplications(AppPickerFragment appPickerFragment) {
            this.f16435a = appPickerFragment;
        }

        protected void onPostExecute(Object obj) {
            Void voidR = (Void) obj;
            this.f16436b.dismiss();
            super.onPostExecute(voidR);
            this.f16435a.f16443g.addAll(this.f16435a.f16444h);
        }

        protected void onProgressUpdate(Object[] objArr) {
            super.onProgressUpdate((Void[]) objArr);
        }

        protected final Object m20519a(Object[] objArr) {
            this.f16435a.f16444h = this.f16435a.m20520a(this.f16435a.f16441e.getInstalledApplications(128));
            return null;
        }

        protected void onCancelled() {
            super.onCancelled();
            this.f16435a.f16443g.clear();
        }

        protected void onPreExecute() {
            this.f16436b = ProgressDialog.a(this.f16435a.getContext(), null, "Loading application info...");
            super.onPreExecute();
        }
    }

    public static void m20521a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        AppPickerFragment appPickerFragment = (AppPickerFragment) obj;
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        ApplicationAdapterProvider applicationAdapterProvider = (ApplicationAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ApplicationAdapterProvider.class);
        ComposerLauncher composerLauncher = (ComposerLauncher) ComposerLauncherImpl.a(fbInjector);
        appPickerFragment.f16438a = abstractFbErrorReporter;
        appPickerFragment.f16439b = applicationAdapterProvider;
        appPickerFragment.f16440c = composerLauncher;
    }

    public final void m20527c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = AppPickerFragment.class;
        m20521a((Object) this, getContext());
        this.f16441e = getContext().getPackageManager();
        this.f16443g = new ApplicationAdapter(getContext(), PackageManagerMethodAutoProvider.a(this.f16439b));
        new LoadApplications(this).execute(new Void[0]);
    }

    public final View m20524a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 844973833);
        View inflate = layoutInflater.inflate(2130903658, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1895575503, a);
        return inflate;
    }

    public final void m20526a(View view, Bundle bundle) {
        this.al = (AppTitleBar) view.findViewById(2131558563);
        this.f16445i = (FbAutoUnFocusEditText) this.al.findViewById(2131560492);
        this.f16442f = (BetterListView) view.findViewById(2131560128);
        this.f16442f.setAdapter(this.f16443g);
        this.f16442f.setOnItemClickListener(new C12921(this));
        this.am = this.al.getClearSearchTextButton();
        this.al.f16453c.setOnClickListener(new C12932(this));
        this.am.setOnClickListener(new C12943(this));
    }

    public final void m20523G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2097730485);
        super.G();
        this.f16445i.addTextChangedListener(new C12954(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1308313102, a);
    }

    private List<ApplicationInfo> m20520a(List<ApplicationInfo> list) {
        List arrayList = new ArrayList();
        for (ApplicationInfo applicationInfo : list) {
            if ((applicationInfo.flags & 1) != 1) {
                try {
                    if (this.f16441e.getLaunchIntentForPackage(applicationInfo.packageName) != null) {
                        arrayList.add(applicationInfo);
                    }
                } catch (Throwable e) {
                    this.f16438a.b(f16437d, e);
                }
            }
        }
        return arrayList;
    }

    public final void m20525a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        o().setResult(i2, intent);
        o().finish();
    }
}
