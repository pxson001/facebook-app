package com.facebook.privacy.checkup.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.checkup.abtest.PrivacyCheckupMobileXConfig;
import com.facebook.privacy.checkup.manager.IDBackedPrivacyCheckupManager;
import com.facebook.privacy.checkup.manager.IDBackedPrivacyCheckupManager.OnDataFetchedListener;
import com.facebook.privacy.checkup.manager.IDBackedPrivacyCheckupManager.Task;
import com.facebook.privacy.checkup.service.PrivacyCheckupAnalyticsLogger;
import com.facebook.privacy.protocol.EditObjectsPrivacyParams.ObjectPrivacyEdit;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.widget.CustomViewPager;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: SUMMARY */
public class PrivacyGenericCheckupActivity extends FbFragmentActivity {
    private static int f11216B = 0;
    public AlertDialog f11217A;
    public long f11218C = 0;
    public int f11219D = 0;
    public int f11220E = 0;
    ImmutableList<ObjectPrivacyEdit> f11221p;
    public IDBackedPrivacyCheckupManager f11222q;
    private Resources f11223r;
    private XConfigReader f11224s;
    public PrivacyCheckupAnalyticsLogger f11225t;
    public Clock f11226u;
    public FbTitleBar f11227v;
    public CustomViewPager f11228w;
    public PrivacyGenericCheckupPagerAdapter f11229x;
    private String f11230y;
    public CountDownTimer f11231z;

    /* compiled from: SUMMARY */
    class C13442 implements OnClickListener {
        final /* synthetic */ PrivacyGenericCheckupActivity f11207a;

        C13442(PrivacyGenericCheckupActivity privacyGenericCheckupActivity) {
            this.f11207a = privacyGenericCheckupActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1016888565);
            if (this.f11207a.f11222q.m11325b() != 0) {
                this.f11207a.f11218C;
                Logger.a(2, EntryType.UI_INPUT_END, -1768694561, a);
            } else if (this.f11207a.f11228w.getCurrentItem() == 0) {
                this.f11207a.f11225t.m11468a(this.f11207a.f11222q.m11329f(), "checkup_cancel", Integer.valueOf(this.f11207a.f11228w.getCurrentItem()), null, null, null, null);
                this.f11207a.finish();
                LogUtils.a(-1208794023, a);
            } else {
                this.f11207a.f11225t.m11468a(this.f11207a.f11222q.m11329f(), "step_navigation", Integer.valueOf(this.f11207a.f11228w.getCurrentItem() - 1), Integer.valueOf(this.f11207a.f11228w.getCurrentItem()), null, null, null);
                this.f11207a.f11228w.setCurrentItem(this.f11207a.f11228w.getCurrentItem() - 1);
                this.f11207a.f11227v.setTitle(this.f11207a.f11222q.m11321a(this.f11207a.f11228w.getCurrentItem()).f10977m);
                this.f11207a.m11595a(this.f11207a.f11227v);
                LogUtils.a(-641150033, a);
            }
        }
    }

    /* compiled from: SUMMARY */
    class C13453 extends OnToolbarButtonListener {
        final /* synthetic */ PrivacyGenericCheckupActivity f11208a;

        C13453(PrivacyGenericCheckupActivity privacyGenericCheckupActivity) {
            this.f11208a = privacyGenericCheckupActivity;
        }

        public final void m11583a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            if (this.f11208a.f11222q.m11325b() != 0) {
                this.f11208a.f11221p = this.f11208a.f11222q.m11328c(this.f11208a.f11228w.k);
                if (this.f11208a.f11221p == null || this.f11208a.f11221p.isEmpty()) {
                    this.f11208a.f11222q.m11322a();
                } else {
                    this.f11208a.f11225t.m11468a(this.f11208a.f11222q.f10872i, "step_save", Integer.valueOf(this.f11208a.f11228w.k + 1), Integer.valueOf(this.f11208a.f11228w.k), null, null, null);
                    this.f11208a.f11220E = this.f11208a.f11220E + 1;
                    return;
                }
            }
            this.f11208a.f11225t.m11468a(this.f11208a.f11222q.f10872i, "step_navigation", Integer.valueOf(this.f11208a.f11228w.k + 1), Integer.valueOf(this.f11208a.f11228w.k), null, null, null);
            if (this.f11208a.f11228w.k == this.f11208a.f11222q.m11327c() - 1) {
                this.f11208a.finish();
                return;
            }
            this.f11208a.f11228w.setCurrentItem(this.f11208a.f11228w.k + 1);
            this.f11208a.f11227v.setTitle(this.f11208a.f11222q.m11321a(this.f11208a.f11228w.k).f10977m);
            this.f11208a.m11595a(this.f11208a.f11227v);
        }
    }

    /* compiled from: SUMMARY */
    class C13475 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ PrivacyGenericCheckupActivity f11210a;

        C13475(PrivacyGenericCheckupActivity privacyGenericCheckupActivity) {
            this.f11210a = privacyGenericCheckupActivity;
        }

        protected final void m11584a(Object obj) {
            this.f11210a.f11225t.m11468a(this.f11210a.f11222q.f10872i, "step_success", Integer.valueOf(this.f11210a.f11228w.k), null, Integer.valueOf(this.f11210a.f11219D), Integer.valueOf(this.f11210a.f11220E), Long.valueOf(this.f11210a.f11226u.a() - this.f11210a.f11218C));
            this.f11210a.f11219D = 0;
            this.f11210a.f11220E = 0;
            if (this.f11210a.f11231z != null) {
                this.f11210a.f11231z.cancel();
                this.f11210a.f11231z = null;
            }
            PrivacyGenericCheckupActivity.m11600b(this.f11210a, "SEND_PROGRESS_DIALOG_TAG");
            if (this.f11210a.f11217A != null) {
                this.f11210a.f11217A.dismiss();
                this.f11210a.f11217A = null;
            }
            this.f11210a.f11221p = null;
            this.f11210a.f11222q.m11322a();
            if (this.f11210a.f11228w.k == this.f11210a.f11222q.m11327c() - 1) {
                this.f11210a.finish();
                return;
            }
            this.f11210a.f11228w.setCurrentItem(this.f11210a.f11228w.k + 1);
            this.f11210a.f11227v.setTitle(this.f11210a.f11222q.m11321a(this.f11210a.f11228w.k).f10977m);
            this.f11210a.m11595a(this.f11210a.f11227v);
            IDBackedPrivacyCheckupManager.f10862j = true;
            ((TextView) this.f11210a.f11228w.b(this.f11210a.f11222q.m11327c()).findViewById(2131566248)).setText(this.f11210a.f11222q.m11321a(this.f11210a.f11222q.m11327c() - 1).f10971g);
        }

        protected final void m11585a(Throwable th) {
        }
    }

    /* compiled from: SUMMARY */
    class C13486 implements OnDismissListener {
        final /* synthetic */ PrivacyGenericCheckupActivity f11211a;

        C13486(PrivacyGenericCheckupActivity privacyGenericCheckupActivity) {
            this.f11211a = privacyGenericCheckupActivity;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
                this.f11211a.f11217A = null;
            }
        }
    }

    /* compiled from: SUMMARY */
    class C13497 implements DialogInterface.OnClickListener {
        final /* synthetic */ PrivacyGenericCheckupActivity f11212a;

        C13497(PrivacyGenericCheckupActivity privacyGenericCheckupActivity) {
            this.f11212a = privacyGenericCheckupActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f11212a.f11222q.m11330h();
            this.f11212a.f11225t.m11468a(this.f11212a.f11222q.f10872i, "step_fail", Integer.valueOf(this.f11212a.f11228w.k), null, Integer.valueOf(this.f11212a.f11219D), Integer.valueOf(this.f11212a.f11220E), null);
            this.f11212a.f11225t.m11468a(this.f11212a.f11222q.f10872i, "checkup_cancel", Integer.valueOf(this.f11212a.f11228w.k), null, Integer.valueOf(this.f11212a.f11219D), Integer.valueOf(this.f11212a.f11220E), null);
            this.f11212a.finish();
        }
    }

    /* compiled from: SUMMARY */
    class C13508 implements DialogInterface.OnClickListener {
        final /* synthetic */ PrivacyGenericCheckupActivity f11213a;

        C13508(PrivacyGenericCheckupActivity privacyGenericCheckupActivity) {
            this.f11213a = privacyGenericCheckupActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f11213a.f11219D = this.f11213a.f11219D + 1;
            this.f11213a.f11225t.m11468a(this.f11213a.f11222q.f10872i, "step_retry", Integer.valueOf(this.f11213a.f11228w.k), null, Integer.valueOf(this.f11213a.f11219D), Integer.valueOf(this.f11213a.f11220E), null);
            this.f11213a.f11220E = this.f11213a.f11220E + 1;
        }
    }

    /* compiled from: SUMMARY */
    class C13519 implements OnCancelListener {
        final /* synthetic */ PrivacyGenericCheckupActivity f11214a;

        C13519(PrivacyGenericCheckupActivity privacyGenericCheckupActivity) {
            this.f11214a = privacyGenericCheckupActivity;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f11214a.finish();
        }
    }

    /* compiled from: SUMMARY */
    class DataFetchedListener implements OnDataFetchedListener {
        final /* synthetic */ PrivacyGenericCheckupActivity f11215a;

        public DataFetchedListener(PrivacyGenericCheckupActivity privacyGenericCheckupActivity) {
            this.f11215a = privacyGenericCheckupActivity;
        }

        public final void mo302a() {
            PrivacyGenericCheckupActivity.m11600b(this.f11215a, "FETCH_PROGRESS_DIALOG_TAG");
            if (this.f11215a.f11217A != null) {
                this.f11215a.f11217A.dismiss();
                this.f11215a.f11217A = null;
            }
            if (this.f11215a.f11231z != null) {
                this.f11215a.f11231z.cancel();
            }
            this.f11215a.f11231z = null;
            this.f11215a.f11225t.m11468a(this.f11215a.f11222q.f10872i, "succes_data_load", null, null, null, null, null);
            this.f11215a.f11227v.setTitle(this.f11215a.f11222q.m11321a(0).f10977m);
            this.f11215a.m11595a(this.f11215a.f11227v);
            this.f11215a.f11229x.kR_();
        }

        public final void mo303b() {
            this.f11215a.f11226u;
        }
    }

    private static <T extends Context> void m11596a(Class<T> cls, T t) {
        m11597a((Object) t, (Context) t);
    }

    public static void m11597a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PrivacyGenericCheckupActivity) obj).m11591a(IDBackedPrivacyCheckupManager.m11319a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), XConfigReader.a(injectorLike), PrivacyCheckupAnalyticsLogger.m11461b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    private void m11591a(IDBackedPrivacyCheckupManager iDBackedPrivacyCheckupManager, Resources resources, XConfigReader xConfigReader, PrivacyCheckupAnalyticsLogger privacyCheckupAnalyticsLogger, Clock clock) {
        this.f11222q = iDBackedPrivacyCheckupManager;
        this.f11223r = resources;
        this.f11224s = xConfigReader;
        this.f11225t = privacyCheckupAnalyticsLogger;
        this.f11226u = clock;
    }

    protected final void m11622b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = PrivacyGenericCheckupActivity.class;
        m11597a((Object) this, (Context) this);
        this.f11230y = getIntent().getStringExtra("checkup_id");
        Preconditions.checkArgument(!TextUtils.isEmpty(this.f11230y), "PrivacyGenericCheckupActivity no review_id for query");
        this.f11222q.f10872i = this.f11230y;
        f11216B = this.f11224s.a(PrivacyCheckupMobileXConfig.e, 10000);
        setContentView(2130906394);
        m11608i();
        m11610j();
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1412164971);
        super.onResume();
        if (this.f11222q.m11327c() != 0) {
            Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1161728972, a);
            return;
        }
        if (((DialogFragment) kO_().a("FETCH_PROGRESS_DIALOG_TAG")) == null) {
            ProgressDialogFragment.a(2131230739, true, false, false).a(kO_(), "FETCH_PROGRESS_DIALOG_TAG");
        }
        this.f11231z = new CountDownTimer(this, (long) f11216B, (long) f11216B) {
            final /* synthetic */ PrivacyGenericCheckupActivity f11206a;

            public void onTick(long j) {
            }

            public void onFinish() {
                this.f11206a.f11226u;
            }
        }.start();
        this.f11222q.m11323a(new DataFetchedListener(this), this.f11230y, null);
        LogUtils.c(255680402, a);
    }

    public void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -174627762);
        super.onPause();
        if (this.f11231z != null) {
            this.f11231z.cancel();
        }
        this.f11231z = null;
        m11600b(this, "FETCH_PROGRESS_DIALOG_TAG");
        m11600b(this, "SEND_PROGRESS_DIALOG_TAG");
        if (this.f11217A != null) {
            this.f11217A.dismiss();
            this.f11217A = null;
        }
        this.f11222q.f10865b.c(Task.FETCH_GENERIC_PRIVACY_REVIEW_INFO);
        this.f11222q.m11330h();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -232426615, a);
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 471981646);
        super.onDestroy();
        if (isFinishing()) {
            IDBackedPrivacyCheckupManager iDBackedPrivacyCheckupManager = this.f11222q;
            IDBackedPrivacyCheckupManager.f10862j = false;
            iDBackedPrivacyCheckupManager.m11322a();
            iDBackedPrivacyCheckupManager.f10874l.clear();
            LogUtils.c(-303683942, a);
            return;
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1208739492, a);
    }

    private void m11608i() {
        this.f11228w = (CustomViewPager) findViewById(2131566276);
        this.f11229x = new PrivacyGenericCheckupPagerAdapter(this.f11223r, kO_(), this.f11222q);
        this.f11228w.setAdapter(this.f11229x);
        m11610j();
    }

    private void m11610j() {
        FbTitleBarUtil.b(this);
        this.f11227v = (FbTitleBar) a(2131558563);
        Builder a = TitleBarButtonSpec.a();
        a.g = getResources().getString(2131242327);
        a = a;
        a.j = getResources().getString(2131234227);
        a = a;
        a.d = true;
        TitleBarButtonSpec a2 = a.a();
        if (this.f11222q.m11327c() != 0) {
            this.f11227v.setTitle(this.f11222q.m11321a(this.f11228w.k).f10977m);
            m11595a(this.f11227v);
        }
        this.f11227v.a(new C13442(this));
        this.f11227v.setOnToolbarButtonListener(new C13453(this));
        this.f11227v.setButtonSpecs(ImmutableList.of(a2));
    }

    private void m11595a(FbTitleBar fbTitleBar) {
        Builder a = TitleBarButtonSpec.a();
        a.g = this.f11222q.m11321a(this.f11228w.k).f10976l;
        fbTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
    }

    public static void m11612k(PrivacyGenericCheckupActivity privacyGenericCheckupActivity) {
        privacyGenericCheckupActivity.f11218C = privacyGenericCheckupActivity.f11226u.a();
        ProgressDialogFragment.a(2131234227, true, false, false).a(privacyGenericCheckupActivity.kO_(), "SEND_PROGRESS_DIALOG_TAG");
        privacyGenericCheckupActivity.f11231z = new CountDownTimer(privacyGenericCheckupActivity, (long) f11216B, (long) f11216B) {
            final /* synthetic */ PrivacyGenericCheckupActivity f11209a;

            public void onTick(long j) {
            }

            public void onFinish() {
                this.f11209a.f11220E = this.f11209a.f11220E + 1;
                PrivacyGenericCheckupActivity.m11600b(this.f11209a, "SEND_PROGRESS_DIALOG_TAG");
                this.f11209a.m11613l();
            }
        }.start();
        privacyGenericCheckupActivity.f11222q.m11324a("id_backed_privacy_checkup", privacyGenericCheckupActivity.f11221p, new C13475(privacyGenericCheckupActivity));
    }

    private void m11613l() {
        if (this.f11217A == null) {
            this.f11217A = new FbAlertDialogBuilder(this).a(true).b(2131242313).b(getString(2131230767), new C13508(this)).a(getString(2131230728), new C13497(this)).a(new C13486(this)).a();
            this.f11217A.show();
        }
    }

    public static void m11600b(PrivacyGenericCheckupActivity privacyGenericCheckupActivity, String str) {
        DialogFragment dialogFragment = (DialogFragment) privacyGenericCheckupActivity.kO_().a(str);
        if (dialogFragment != null) {
            dialogFragment.a();
        }
    }

    public static void m11616m(PrivacyGenericCheckupActivity privacyGenericCheckupActivity) {
        if (privacyGenericCheckupActivity.f11217A == null) {
            m11600b(privacyGenericCheckupActivity, "FETCH_PROGRESS_DIALOG_TAG");
            privacyGenericCheckupActivity.f11217A = new FbAlertDialogBuilder(privacyGenericCheckupActivity).a(true).b(2131242313).a(privacyGenericCheckupActivity.getString(2131230728), new DialogInterface.OnClickListener(privacyGenericCheckupActivity) {
                final /* synthetic */ PrivacyGenericCheckupActivity f11203a;

                {
                    this.f11203a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f11203a.f11225t.m11468a(this.f11203a.f11222q.f10872i, "checkup_cancel", null, null, null, null, null);
                    dialogInterface.dismiss();
                    this.f11203a.finish();
                }
            }).a(new C13519(privacyGenericCheckupActivity)).a();
            privacyGenericCheckupActivity.f11217A.show();
        }
    }

    public static void m11618n(PrivacyGenericCheckupActivity privacyGenericCheckupActivity) {
        if (privacyGenericCheckupActivity.f11217A == null) {
            privacyGenericCheckupActivity.f11217A = new FbAlertDialogBuilder(privacyGenericCheckupActivity).a(true).a(privacyGenericCheckupActivity.getString(2131234229)).b(privacyGenericCheckupActivity.getString(2131234230)).a(privacyGenericCheckupActivity.getString(2131234231), new DialogInterface.OnClickListener(privacyGenericCheckupActivity) {
                final /* synthetic */ PrivacyGenericCheckupActivity f11205a;

                {
                    this.f11205a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    if (this.f11205a.f11228w.getCurrentItem() == 0) {
                        this.f11205a.f11225t.m11468a(this.f11205a.f11222q.m11329f(), "checkup_cancel", Integer.valueOf(this.f11205a.f11228w.getCurrentItem()), null, Integer.valueOf(this.f11205a.f11219D), Integer.valueOf(this.f11205a.f11220E), null);
                        this.f11205a.finish();
                        return;
                    }
                    this.f11205a.f11222q.m11326b(this.f11205a.f11228w.getCurrentItem());
                    AdapterDetour.a((BaseAdapter) ((HeaderViewListAdapter) ((ListView) this.f11205a.f11228w.b(this.f11205a.f11228w.getCurrentItem()).findViewById(2131566246)).getAdapter()).getWrappedAdapter(), -786969377);
                    this.f11205a.f11219D = 0;
                    this.f11205a.f11220E = 0;
                    this.f11205a.f11225t.m11468a(this.f11205a.f11222q.m11329f(), "step_navigation", Integer.valueOf(this.f11205a.f11228w.getCurrentItem() - 1), Integer.valueOf(this.f11205a.f11228w.getCurrentItem()), Integer.valueOf(this.f11205a.f11219D), Integer.valueOf(this.f11205a.f11220E), null);
                    this.f11205a.f11228w.setCurrentItem(this.f11205a.f11228w.getCurrentItem() - 1);
                    this.f11205a.f11227v.setTitle(this.f11205a.f11222q.m11321a(this.f11205a.f11228w.getCurrentItem()).f10977m);
                }
            }).b(privacyGenericCheckupActivity.getString(2131242328), null).a(new OnDismissListener(privacyGenericCheckupActivity) {
                final /* synthetic */ PrivacyGenericCheckupActivity f11204a;

                {
                    this.f11204a = r1;
                }

                public void onDismiss(DialogInterface dialogInterface) {
                    this.f11204a.f11217A = null;
                }
            }).a();
            privacyGenericCheckupActivity.f11217A.show();
        }
    }
}
