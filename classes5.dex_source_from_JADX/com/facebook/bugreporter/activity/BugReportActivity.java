package com.facebook.bugreporter.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.fragment.NavigableFragment;
import com.facebook.base.fragment.NavigableFragment.Listener;
import com.facebook.bugreporter.BugReport;
import com.facebook.bugreporter.BugReportBuilder;
import com.facebook.bugreporter.BugReporterConfig;
import com.facebook.bugreporter.BugReporterFileUtil;
import com.facebook.bugreporter.BugReporterFileUtil.C10171;
import com.facebook.bugreporter.BugReporterRelated;
import com.facebook.bugreporter.ConstBugReporterConfig;
import com.facebook.bugreporter.activity.bugreport.BugReportFragment;
import com.facebook.bugreporter.activity.categorylist.CategoryInfo;
import com.facebook.bugreporter.activity.categorylist.CategoryListFragment;
import com.facebook.bugreporter.imagepicker.BugReporterImagePickerPersistentFragment;
import com.facebook.bugreporter.imagepicker.BugReporterImagePickerPersistentFragment.C10471;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import javax.inject.Inject;

/* compiled from: android.media.metadata.DISPLAY_DESCRIPTION */
public class BugReportActivity extends FbFragmentActivity implements AnalyticsActivity, BugReporterRelated, IAuthNotRequired {
    private static final Class<?> f10666p = BugReportActivity.class;
    private ConstBugReporterConfig f10667q;
    public BugReporterFileUtil f10668r;
    private Listener f10669s;
    private BugReportBuilder f10670t;
    private BugReporterImagePickerPersistentFragment f10671u;

    /* compiled from: android.media.metadata.DISPLAY_DESCRIPTION */
    class C10231 implements Listener {
        final /* synthetic */ BugReportActivity f10665a;

        C10231(BugReportActivity bugReportActivity) {
            this.f10665a = bugReportActivity;
        }

        public final void mo564a(NavigableFragment navigableFragment, Intent intent) {
            this.f10665a.m18688a(navigableFragment, intent);
        }
    }

    private static <T extends Context> void m18691a(Class<T> cls, T t) {
        m18692a((Object) t, (Context) t);
    }

    public static void m18692a(Object obj, Context context) {
        ((BugReportActivity) obj).f10668r = BugReporterFileUtil.m18646a(FbInjector.get(context));
    }

    public static Intent m18687a(Context context, BugReport bugReport, BugReporterConfig bugReporterConfig) {
        Intent intent = new Intent(context, BugReportActivity.class);
        intent.putExtra("report", bugReport);
        intent.putExtra("reporter_config", ConstBugReporterConfig.m18663a(bugReporterConfig));
        return intent;
    }

    @Inject
    private void m18689a(BugReporterFileUtil bugReporterFileUtil) {
        this.f10668r = bugReporterFileUtil;
    }

    protected final void m18701b(Bundle bundle) {
        super.b(bundle);
        Class cls = BugReportActivity.class;
        m18692a((Object) this, (Context) this);
        setContentView(2130903456);
        this.f10669s = new C10231(this);
        FragmentManager kO_ = kO_();
        CategoryListFragment categoryListFragment = (CategoryListFragment) kO_.a("categoryList");
        if (categoryListFragment != null) {
            categoryListFragment.mo563a(this.f10669s);
        }
        BugReportFragment bugReportFragment = (BugReportFragment) kO_.a("bugReport");
        if (bugReportFragment != null) {
            bugReportFragment.mo563a(this.f10669s);
        }
        this.f10671u = (BugReporterImagePickerPersistentFragment) kO_.a("persistent_fragment");
        if (this.f10671u == null) {
            this.f10671u = new BugReporterImagePickerPersistentFragment();
            kO_.a().a(this.f10671u, "persistent_fragment").b();
        }
        if (bundle != null) {
            this.f10670t = BugReport.newBuilder().m18535a((BugReport) bundle.getParcelable("report"));
            this.f10667q = (ConstBugReporterConfig) bundle.getParcelable("reporter_config");
            return;
        }
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("retry", false);
        BugReport bugReport = (BugReport) intent.getParcelableExtra("report");
        if (bugReport == null) {
            BLog.a(f10666p, "Missing bug report in intent");
            finish();
            return;
        }
        this.f10670t = BugReport.newBuilder().m18535a(bugReport);
        this.f10667q = (ConstBugReporterConfig) intent.getParcelableExtra("reporter_config");
        m18696b(booleanExtra);
    }

    private void m18696b(boolean z) {
        int size = this.f10667q.mo1120a().size();
        if (size > 1) {
            m18694a(false, z);
        } else if (size == 1) {
            this.f10670t.f10447i = String.valueOf(((CategoryInfo) this.f10667q.mo1120a().get(0)).f10695c);
            m18693a(false, this.f10670t.m18542x());
        } else {
            finish();
        }
    }

    private void m18694a(boolean z, boolean z2) {
        Bundle i = m18698i();
        i.putBoolean("retry", z2);
        CategoryListFragment categoryListFragment = new CategoryListFragment();
        categoryListFragment.mo563a(this.f10669s);
        categoryListFragment.g(i);
        FragmentTransaction a = kO_().a();
        a.a(2131559223, categoryListFragment, "categoryList");
        if (z) {
            a.a(null);
        }
        a.b();
    }

    private void m18693a(boolean z, BugReport bugReport) {
        Bundle i = m18698i();
        i.putParcelable("report", bugReport);
        BugReportFragment bugReportFragment = new BugReportFragment();
        bugReportFragment.g(i);
        bugReportFragment.mo563a(this.f10669s);
        FragmentTransaction a = kO_().a();
        a.a(2131559223, bugReportFragment, "bugReport");
        if (z) {
            a.a("bugReport_bs");
        }
        a.b();
    }

    private void m18697c(boolean z) {
        Intent intent = new Intent();
        intent.putExtra("from_bug_report_activity", true);
        intent.putExtra("isSendClickedFlag", z);
        setResult(-1, intent);
        finish();
    }

    private void m18688a(NavigableFragment navigableFragment, Intent intent) {
        if (intent == null) {
            m18697c(false);
        } else if (intent.hasExtra("isSendClickedFlag")) {
            m18697c(intent.getBooleanExtra("isSendClickedFlag", false));
        } else if (navigableFragment instanceof CategoryListFragment) {
            if (!intent.getBooleanExtra("retry", false)) {
                r0 = intent.getStringExtra("category_id");
                if (r0 == null) {
                    r0 = "100977986739334";
                }
                this.f10670t.f10447i = r0;
            }
            m18693a(true, this.f10670t.m18542x());
        } else if (navigableFragment instanceof BugReportFragment) {
            r0 = intent.getStringExtra("bug_desc");
            if (!Strings.isNullOrEmpty(r0)) {
                this.f10670t.f10440b = r0;
            }
            List parcelableArrayListExtra = intent.getParcelableArrayListExtra("bug_shots");
            if (parcelableArrayListExtra != null) {
                this.f10670t.f10442d = parcelableArrayListExtra;
            }
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("reporter_config", this.f10667q);
        bundle.putParcelable("report", this.f10670t.m18542x());
    }

    public void onBackPressed() {
        if (!kO_().e()) {
            BugReporterFileUtil bugReporterFileUtil = this.f10668r;
            ExecutorDetour.a(bugReporterFileUtil.f10627c, new C10171(bugReporterFileUtil, this.f10670t.f10439a), 1414389456);
            finish();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    private Bundle m18698i() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("reporter_config", this.f10667q);
        return bundle;
    }

    public final String am_() {
        return "bug_report";
    }

    public static boolean m18695a(int i, Intent intent) {
        return i == 18067 && intent.getBooleanExtra("from_bug_report_activity", false);
    }

    public final ListenableFuture<Bitmap> m18699a(Uri uri) {
        ListenableFuture<Bitmap> a;
        BugReporterImagePickerPersistentFragment bugReporterImagePickerPersistentFragment = this.f10671u;
        Bitmap bitmap = (Bitmap) bugReporterImagePickerPersistentFragment.f10757d.get(uri);
        if (bitmap != null) {
            a = Futures.a(bitmap);
        } else {
            a = bugReporterImagePickerPersistentFragment.f10756c.a(new C10471(bugReporterImagePickerPersistentFragment, uri));
        }
        return a;
    }

    public final void m18700b(Uri uri) {
        this.f10671u.f10757d.remove(uri);
    }
}
