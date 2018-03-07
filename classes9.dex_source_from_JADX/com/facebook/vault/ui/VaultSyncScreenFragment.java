package com.facebook.vault.ui;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.vault.VaultContract.ImagesTable;
import com.facebook.ipc.vault.VaultContract.ImagesTable.Columns;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.photos.VaultLocalPhoto;
import com.facebook.photos.base.photos.VaultPhoto;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.vault.prefs.TableCutoffTimePref;
import com.facebook.vault.protocol.VaultImageDeleteMethod;
import com.facebook.vault.protocol.VaultImageGetMethod;
import com.facebook.vault.provider.VaultImageProviderRow;
import com.facebook.vault.service.VaultHelpers;
import com.facebook.vault.service.VaultLocalImageFetcher;
import com.facebook.vault.service.VaultLogger;
import com.facebook.vault.service.VaultNotificationManager;
import com.facebook.vault.service.VaultTable;
import com.facebook.widget.listeners.BaseAnimationListener;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import javax.inject.Inject;

/* compiled from: text/javascript */
public class VaultSyncScreenFragment extends FbFragment {
    @Inject
    TableCutoffTimePref f2065a;
    public RelativeLayout aA;
    public VaultSyncScreenPrivacyBar aB;
    public VaultSyncScreenErrorBar aC;
    public VaultChromeVisibility aD;
    public RefreshGridTask aE;
    private final VaultDataSetObserver aF = new VaultDataSetObserver(this);
    public final GestureDetector aG = new GestureDetector(new C01951(this));
    @Inject
    public VaultLocalImageFetcher al;
    @Inject
    VaultNotificationManager am;
    @Inject
    VaultDraweeGridAdapterProvider an;
    private BroadcastReceiver ao;
    public Context ap;
    private VaultPhoto aq;
    public FragmentManager ar;
    public VaultSimpleOptInFragment as;
    public Set<String> at;
    public int au = 0;
    public int av = 0;
    public boolean aw = false;
    private View ax;
    public VaultAdapter ay;
    public GridView az;
    @Inject
    VaultHelpers f2066b;
    @Inject
    public VaultLogger f2067c;
    @Inject
    AbstractSingleMethodRunner f2068d;
    @Inject
    public DefaultAndroidThreadUtil f2069e;
    @Inject
    VaultImageGetMethod f2070f;
    @Inject
    VaultImageDeleteMethod f2071g;
    @Inject
    SecureContextHelper f2072h;
    @Inject
    VaultTable f2073i;

    /* compiled from: text/javascript */
    class C01951 extends SimpleOnGestureListener {
        final /* synthetic */ VaultSyncScreenFragment f2043a;
        private float[] f2044b = new float[4];
        private int f2045c = 0;

        C01951(VaultSyncScreenFragment vaultSyncScreenFragment) {
            this.f2043a = vaultSyncScreenFragment;
        }

        private boolean m2068a(float f) {
            int i = 0;
            int i2 = 0;
            for (float f2 : this.f2044b) {
                if (f2 > 0.0f) {
                    i2++;
                } else {
                    i++;
                }
            }
            if ((f < 0.0f || i2 <= i) && (f >= 0.0f || i <= i2)) {
                return false;
            }
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            int height = this.f2043a.aB.getHeight();
            float f3 = (float) ((LayoutParams) this.f2043a.aB.getLayoutParams()).topMargin;
            if (this.f2043a.aD == VaultChromeVisibility.VISIBLE && f2 < ((float) (-this.f2043a.au)) && f3 > ((float) (-height))) {
                this.f2043a.m2085a(false);
            } else if (this.f2043a.aD == VaultChromeVisibility.HIDDEN && f2 > ((float) this.f2043a.au)) {
                this.f2043a.m2085a(true);
            }
            return false;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.f2044b[this.f2045c] = f2;
            this.f2045c = (this.f2045c + 1) % this.f2044b.length;
            if (m2068a(f2)) {
                int height = this.f2043a.aB.getHeight();
                ViewGroup.LayoutParams layoutParams = new LayoutParams(new MarginLayoutParams(-1, height));
                float f3 = (float) ((LayoutParams) this.f2043a.aB.getLayoutParams()).topMargin;
                if ((f3 > ((float) (-height)) || f2 <= 0.0f) && (f3 < 0.0f || f2 >= 0.0f)) {
                    int min;
                    if (f2 < 0.0f) {
                        min = Math.min((int) (f3 + Math.abs(f2 * 5.0f)), 0);
                    } else {
                        min = Math.max((int) (f3 - (f2 * 5.0f)), -height);
                    }
                    this.f2043a.av = min;
                    layoutParams.setMargins(0, min, 0, 0);
                    this.f2043a.aB.setLayoutParams(layoutParams);
                }
            }
            return true;
        }
    }

    /* compiled from: text/javascript */
    class C01962 implements OnClickListener {
        final /* synthetic */ VaultSyncScreenFragment f2046a;

        C01962(VaultSyncScreenFragment vaultSyncScreenFragment) {
            this.f2046a = vaultSyncScreenFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1835411530);
            this.f2046a.aC.m2066a();
            Logger.a(2, EntryType.UI_INPUT_END, 567165484, a);
        }
    }

    /* compiled from: text/javascript */
    class C01973 implements OnScrollListener {
        final /* synthetic */ VaultSyncScreenFragment f2047a;

        C01973(VaultSyncScreenFragment vaultSyncScreenFragment) {
            this.f2047a = vaultSyncScreenFragment;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i2 > 0) {
                this.f2047a.ay.mo60a(i, i2);
            }
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    /* compiled from: text/javascript */
    class C01984 implements OnItemClickListener {
        final /* synthetic */ VaultSyncScreenFragment f2048a;

        C01984(VaultSyncScreenFragment vaultSyncScreenFragment) {
            this.f2048a = vaultSyncScreenFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            VaultSyncScreenFragment.m2080g(this.f2048a, i);
        }
    }

    /* compiled from: text/javascript */
    public class C01995 {
        public final /* synthetic */ VaultSyncScreenFragment f2049a;

        public C01995(VaultSyncScreenFragment vaultSyncScreenFragment) {
            this.f2049a = vaultSyncScreenFragment;
        }
    }

    /* compiled from: text/javascript */
    public class C02016 implements OnClickListener {
        final /* synthetic */ VaultSyncScreenFragment f2051a;

        /* compiled from: text/javascript */
        class C02001 extends BaseAnimationListener {
            final /* synthetic */ C02016 f2050a;

            C02001(C02016 c02016) {
                this.f2050a = c02016;
            }

            public void onAnimationEnd(Animation animation) {
                this.f2050a.f2051a.aA.setVisibility(8);
            }
        }

        public C02016(VaultSyncScreenFragment vaultSyncScreenFragment) {
            this.f2051a = vaultSyncScreenFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -675003656);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f2051a.ap, 2130968631);
            loadAnimation.setAnimationListener(new C02001(this));
            this.f2051a.aA.setAnimation(loadAnimation);
            this.f2051a.aA.setVisibility(8);
            Logger.a(2, EntryType.UI_INPUT_END, 880455846, a);
        }
    }

    /* compiled from: text/javascript */
    class DeleteImageTask extends FbAsyncTask<VaultPhoto, Void, Boolean> {
        final /* synthetic */ VaultSyncScreenFragment f2052a;
        private VaultPhoto f2053b;
        private final VaultImageGetMethod f2054c;
        private final VaultImageDeleteMethod f2055d;

        protected final Object m2069a(Object[] objArr) {
            this.f2053b = ((VaultPhoto[]) objArr)[0];
            publishProgress(new Void[0]);
            try {
                this.f2052a.f2068d.a(this.f2054c, Long.valueOf(this.f2053b.e()));
                try {
                    return (Boolean) this.f2052a.f2068d.a(this.f2055d, Long.valueOf(this.f2053b.e()));
                } catch (Throwable e) {
                    BLog.b(VaultSyncScreenFragment.class, "Error running SingleMethodRunner", e);
                    return Boolean.valueOf(false);
                }
            } catch (Exception e2) {
                return Boolean.valueOf(true);
            }
        }

        protected void onPostExecute(Object obj) {
            if (((Boolean) obj).booleanValue()) {
                publishProgress(new Void[0]);
                this.f2052a.ay.mo63a(this.f2053b);
                String[] strArr = new String[]{Long.toString(this.f2053b.a)};
                this.f2052a.ap.getContentResolver().delete(ImagesTable.a, StringFormatUtil.a("%s = ?", new Object[]{Columns.b.d}), strArr);
                if (!(this.f2052a.aE == null || this.f2052a.aE.isCancelled())) {
                    this.f2052a.aE.cancel(true);
                }
                this.f2052a.aE = new RefreshGridTask(this.f2052a);
                this.f2052a.f2069e.a(this.f2052a.aE, new Void[0]);
                return;
            }
            this.f2052a.ay.mo65b(this.f2053b.c());
            FragmentManager fragmentManager = this.f2052a.D;
            if (!isCancelled() && fragmentManager != null && fragmentManager.c()) {
                new VaultDeleteFailedDialog().a(fragmentManager, "delete_failed_dialog");
            }
        }

        public DeleteImageTask(VaultSyncScreenFragment vaultSyncScreenFragment, VaultImageGetMethod vaultImageGetMethod, VaultImageDeleteMethod vaultImageDeleteMethod) {
            this.f2052a = vaultSyncScreenFragment;
            this.f2054c = vaultImageGetMethod;
            this.f2055d = vaultImageDeleteMethod;
        }

        protected void onProgressUpdate(Object[] objArr) {
            this.f2052a.ay.mo61a(this.f2053b.c());
        }
    }

    /* compiled from: text/javascript */
    public class RefreshGridTask extends FbAsyncTask<Void, Void, List<VaultPhoto>> {
        final /* synthetic */ VaultSyncScreenFragment f2056a;
        private final boolean f2057b;

        protected final /* bridge */ /* synthetic */ Object m2072a(Object[] objArr) {
            return m2070a();
        }

        protected void onPostExecute(Object obj) {
            List list = (List) obj;
            this.f2056a.ay.mo64a(list);
            this.f2056a.aB.m2094c();
            this.f2056a.aB.m2092a();
            if (list.size() > 0) {
                this.f2056a.f2066b.c(13);
            }
        }

        public RefreshGridTask(VaultSyncScreenFragment vaultSyncScreenFragment, boolean z) {
            this.f2056a = vaultSyncScreenFragment;
            this.f2057b = z;
        }

        public RefreshGridTask(VaultSyncScreenFragment vaultSyncScreenFragment) {
            this.f2056a = vaultSyncScreenFragment;
            this.f2057b = false;
        }

        private List<VaultPhoto> m2070a() {
            List<VaultPhoto> a = Lists.a();
            long a2 = this.f2056a.f2065a.a();
            List<VaultImageProviderRow> a3 = this.f2056a.f2073i.a(a2, 50, this.f2057b);
            Map a4 = this.f2056a.al.a(a2);
            List a5 = Lists.a();
            this.f2056a.at = new HashSet();
            for (VaultImageProviderRow vaultImageProviderRow : a3) {
                MediaItem mediaItem = (MediaItem) a4.get(vaultImageProviderRow.f1874a);
                if (mediaItem == null || !new File(mediaItem.e()).exists()) {
                    a5.add(vaultImageProviderRow);
                } else if (vaultImageProviderRow.f1879f == 4) {
                    a.add(new VaultLocalPhoto(0, mediaItem.e(), 0, mediaItem.j() + ((long) m2071b()), vaultImageProviderRow.f1874a));
                    this.f2056a.at.add(vaultImageProviderRow.f1874a);
                }
            }
            if (a5.size() > 0) {
                this.f2056a.f2073i.a(a5);
            }
            return a;
        }

        private static int m2071b() {
            int dSTSavings;
            int i = 0;
            TimeZone timeZone = TimeZone.getDefault();
            TimeZone timeZone2 = TimeZone.getTimeZone("GMT");
            Date date = new Date();
            if (timeZone.inDaylightTime(date)) {
                dSTSavings = timeZone.getDSTSavings();
            } else {
                dSTSavings = 0;
            }
            if (timeZone2.inDaylightTime(date)) {
                i = timeZone2.getDSTSavings();
            }
            return ((i + timeZone2.getRawOffset()) - timeZone.getRawOffset()) - dSTSavings;
        }
    }

    /* compiled from: text/javascript */
    class RefreshVaultTableTask extends FbAsyncTask<Void, Void, Void> {
        final /* synthetic */ VaultSyncScreenFragment f2058a;
        private final boolean f2059b;

        public RefreshVaultTableTask(VaultSyncScreenFragment vaultSyncScreenFragment, boolean z) {
            this.f2058a = vaultSyncScreenFragment;
            this.f2059b = z;
        }

        protected final Object m2073a(Object[] objArr) {
            this.f2058a.f2073i.b();
            return null;
        }

        protected void onPostExecute(Object obj) {
            if (!(this.f2058a.aE == null || this.f2058a.aE.isCancelled())) {
                this.f2058a.aE.cancel(true);
            }
            this.f2058a.aE = new RefreshGridTask(this.f2058a, this.f2059b);
            this.f2058a.f2069e.a(this.f2058a.aE, new Void[0]);
        }
    }

    /* compiled from: text/javascript */
    class SyncStatusReceiver extends BroadcastReceiver {
        final /* synthetic */ VaultSyncScreenFragment f2060a;

        public SyncStatusReceiver(VaultSyncScreenFragment vaultSyncScreenFragment) {
            this.f2060a = vaultSyncScreenFragment;
        }

        public void onReceive(Context context, Intent intent) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1088869721);
            if (intent.getBooleanExtra("vault.table_refreshed_key", false)) {
                if (!(this.f2060a.aE == null || this.f2060a.aE.isCancelled())) {
                    this.f2060a.aE.cancel(true);
                }
                this.f2060a.aE = new RefreshGridTask(this.f2060a, false);
                this.f2060a.f2069e.a(this.f2060a.aE, new Void[0]);
            } else if (intent.getBooleanExtra("vault.sync_start", false) || intent.getBooleanExtra("vault.sync_end", false)) {
                this.f2060a.aB.m2092a();
            } else if (intent.hasExtra("vault.row_upload_key")) {
                VaultSyncScreenFragment vaultSyncScreenFragment = this.f2060a;
                String stringExtra = intent.getStringExtra("vault.row_upload_key");
                int intExtra = intent.getIntExtra("vault.upload_percentage", 0);
                if (stringExtra != null) {
                    MediaItem d = vaultSyncScreenFragment.al.d(stringExtra);
                    if (d != null) {
                        if (intent.getBooleanExtra("vault.upload_completed", false)) {
                            vaultSyncScreenFragment.ay.mo65b(Uri.parse("file://" + d.e()));
                        } else {
                            vaultSyncScreenFragment.ay.mo62a(Uri.parse("file://" + d.e()), intExtra);
                        }
                        if (!vaultSyncScreenFragment.at.contains(stringExtra)) {
                            if (!(vaultSyncScreenFragment.aE == null || vaultSyncScreenFragment.aE.isCancelled())) {
                                vaultSyncScreenFragment.aE.cancel(true);
                            }
                            vaultSyncScreenFragment.aE = new RefreshGridTask(vaultSyncScreenFragment);
                            vaultSyncScreenFragment.f2069e.a(vaultSyncScreenFragment.aE, new Void[0]);
                        }
                    }
                }
            } else if (intent.hasExtra("vault.status_change_key")) {
                this.f2060a.aC.m2067b();
            }
            LogUtils.a(intent, -880865709, a);
        }
    }

    /* compiled from: text/javascript */
    class TopMarginEvaluator extends IntEvaluator {
        final /* synthetic */ VaultSyncScreenFragment f2061a;
        private View f2062b;

        public TopMarginEvaluator(VaultSyncScreenFragment vaultSyncScreenFragment, View view) {
            this.f2061a = vaultSyncScreenFragment;
            this.f2062b = view;
        }

        public Integer evaluate(float f, Integer num, Integer num2) {
            int intValue = super.evaluate(f, num, num2).intValue();
            ViewGroup.LayoutParams layoutParams = new LayoutParams(new MarginLayoutParams(-1, this.f2062b.getHeight()));
            layoutParams.setMargins(0, intValue, 0, 0);
            this.f2062b.setLayoutParams(layoutParams);
            return Integer.valueOf(intValue);
        }
    }

    /* compiled from: text/javascript */
    enum VaultChromeVisibility {
        VISIBLE,
        HIDDEN
    }

    /* compiled from: text/javascript */
    class VaultDataSetObserver extends DataSetObserver {
        final /* synthetic */ VaultSyncScreenFragment f2063a;

        public VaultDataSetObserver(VaultSyncScreenFragment vaultSyncScreenFragment) {
            this.f2063a = vaultSyncScreenFragment;
        }

        public void onChanged() {
            if (!this.f2063a.aw) {
                VaultSyncScreenFragment vaultSyncScreenFragment = this.f2063a;
                int[] iArr = new int[2];
                this.f2063a.az.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) vaultSyncScreenFragment.aA.getLayoutParams();
                layoutParams.leftMargin = iArr[0];
                layoutParams.topMargin = iArr[1] + 30;
                vaultSyncScreenFragment.aA.setLayoutParams(layoutParams);
                vaultSyncScreenFragment.aA.setOnClickListener(new C02016(vaultSyncScreenFragment));
                vaultSyncScreenFragment.aA.bringToFront();
                vaultSyncScreenFragment.aA.setVisibility(0);
                vaultSyncScreenFragment.aw = true;
            }
        }
    }

    /* compiled from: text/javascript */
    class VaultGridOnTouchListener implements OnTouchListener {
        final /* synthetic */ VaultSyncScreenFragment f2064a;

        public VaultGridOnTouchListener(VaultSyncScreenFragment vaultSyncScreenFragment) {
            this.f2064a = vaultSyncScreenFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f2064a.aG.onTouchEvent(motionEvent);
            return false;
        }
    }

    public static void m2078a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((VaultSyncScreenFragment) obj).m2077a(TableCutoffTimePref.a(injectorLike), VaultHelpers.b(injectorLike), VaultLogger.c(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), VaultImageGetMethod.m1947a(injectorLike), VaultImageDeleteMethod.m1944a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), VaultTable.a(injectorLike), VaultLocalImageFetcher.c(injectorLike), VaultNotificationManager.a(injectorLike), (VaultDraweeGridAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VaultDraweeGridAdapterProvider.class));
    }

    private void m2077a(TableCutoffTimePref tableCutoffTimePref, VaultHelpers vaultHelpers, VaultLogger vaultLogger, AbstractSingleMethodRunner abstractSingleMethodRunner, DefaultAndroidThreadUtil defaultAndroidThreadUtil, VaultImageGetMethod vaultImageGetMethod, VaultImageDeleteMethod vaultImageDeleteMethod, SecureContextHelper secureContextHelper, VaultTable vaultTable, VaultLocalImageFetcher vaultLocalImageFetcher, VaultNotificationManager vaultNotificationManager, VaultDraweeGridAdapterProvider vaultDraweeGridAdapterProvider) {
        this.f2065a = tableCutoffTimePref;
        this.f2066b = vaultHelpers;
        this.f2067c = vaultLogger;
        this.f2068d = abstractSingleMethodRunner;
        this.f2069e = defaultAndroidThreadUtil;
        this.f2070f = vaultImageGetMethod;
        this.f2071g = vaultImageDeleteMethod;
        this.f2072h = secureContextHelper;
        this.f2073i = vaultTable;
        this.al = vaultLocalImageFetcher;
        this.am = vaultNotificationManager;
        this.an = vaultDraweeGridAdapterProvider;
    }

    public final void m2085a(boolean z) {
        m2075a(z ? 0 : -this.aB.getHeight(), 100);
    }

    private void m2075a(int i, int i2) {
        if (i >= 0) {
            this.aD = VaultChromeVisibility.VISIBLE;
            i = 0;
        } else if (i <= this.aB.getHeight()) {
            this.aD = VaultChromeVisibility.HIDDEN;
            i = -this.aB.getHeight();
        }
        if (this.av != i) {
            this.av = i;
            ValueAnimator.ofObject(new TopMarginEvaluator(this, this.aB), new Object[]{Integer.valueOf(this.av), Integer.valueOf(i)}).setDuration((long) i2).start();
        }
    }

    public final void m2086c(Bundle bundle) {
        super.c(bundle);
        Class cls = VaultSyncScreenFragment.class;
        m2078a((Object) this, getContext());
    }

    public final View m2083a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 836193326);
        super.a(layoutInflater, viewGroup, bundle);
        this.ax = layoutInflater.inflate(2130907648, viewGroup, false);
        this.aA = (RelativeLayout) this.ax.findViewById(2131568275);
        this.aB = (VaultSyncScreenPrivacyBar) this.ax.findViewById(2131568265);
        this.aC = (VaultSyncScreenErrorBar) this.ax.findViewById(2131568270);
        this.aC.setOnClickListener(new C01962(this));
        this.aD = VaultChromeVisibility.VISIBLE;
        View view = this.ax;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1410455497, a);
        return view;
    }

    public final void m2087d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1825358477);
        super.d(bundle);
        this.ap = o();
        this.az = (GridView) this.ax.findViewById(2131568274);
        VaultDraweeGridAdapterProvider vaultDraweeGridAdapterProvider = this.an;
        this.ay = new VaultDraweeGridAdapter((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(vaultDraweeGridAdapterProvider), (Context) vaultDraweeGridAdapterProvider.getInstance(Context.class), this.az);
        this.az.setAdapter(this.ay);
        this.az.setOnScrollListener(new C01973(this));
        this.az.setOnItemClickListener(new C01984(this));
        this.az.setOnTouchListener(new VaultGridOnTouchListener(this));
        this.az.setVisibility(0);
        this.ar = o().kO_();
        this.as = null;
        this.at = new HashSet();
        this.ao = new SyncStatusReceiver(this);
        this.au = (int) Math.max(((double) ViewConfiguration.get(this.ap).getScaledMaximumFlingVelocity()) * 0.05d, (double) ViewConfiguration.get(this.ap).getScaledMinimumFlingVelocity());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1305536777, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 401908903);
        super.mi_();
        if (this.f2066b.e()) {
            if (this.as == null) {
                VaultSimpleOptInFragment vaultSimpleOptInFragment = new VaultSimpleOptInFragment();
                vaultSimpleOptInFragment.f2026b = 2130907643;
                this.as = vaultSimpleOptInFragment;
            }
            String str = "none";
            if (!(this.s == null || this.s.getString("nux_ref") == null)) {
                str = this.s.getString("nux_ref");
            }
            this.f2067c.c(str);
            this.as.f2025a = str;
            this.as.am = new C01995(this);
            this.ar.a().b(2131568273, this.as).b();
        } else {
            m2079e(this);
            ar(this);
        }
        LogUtils.f(-1931595536, a);
    }

    public final void m2081G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 563073425);
        super.G();
        this.aC.m2067b();
        this.aB.m2094c();
        if (!this.f2066b.e()) {
            ar(this);
        } else if (this.ay instanceof VaultDraweeGridAdapter) {
            this.ay.registerDataSetObserver(this.aF);
        }
        if (this.f2066b.a(13)) {
            if (this.am.e().equals("end_vault_upload")) {
                this.f2069e.a(new RefreshVaultTableTask(this, true), new Void[0]);
            } else {
                if (!(this.aE == null || this.aE.isCancelled())) {
                    this.aE.cancel(true);
                }
                this.aE = new RefreshGridTask(this, true);
                this.f2069e.a(this.aE, new Void[0]);
            }
        }
        LocalBroadcastManager.a(this.ap).a(this.ao, new IntentFilter("vault.intent.action.SyncStatus"));
        LogUtils.f(106599931, a);
    }

    public final void m2082H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -275665806);
        super.H();
        LocalBroadcastManager.a(this.ap).a(this.ao);
        if (this.f2066b.e() && (this.ay instanceof VaultDraweeGridAdapter)) {
            this.ay.unregisterDataSetObserver(this.aF);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -546103273, a);
    }

    public static void m2079e(VaultSyncScreenFragment vaultSyncScreenFragment) {
        if (vaultSyncScreenFragment.as != null) {
            vaultSyncScreenFragment.ar.a().a(vaultSyncScreenFragment.as).b();
        }
    }

    public final void m2084a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i == 321 && i2 == -1) {
            VaultPhoto vaultPhoto = (VaultPhoto) intent.getParcelableExtra("onResultPhotoObjectParam");
            DeleteImageTask deleteImageTask = new DeleteImageTask(this, this.f2070f, this.f2071g);
            this.f2069e.a(deleteImageTask, new VaultPhoto[]{vaultPhoto});
        }
    }

    private void m2076a(long j) {
        Intent intent = new Intent(ao(), VaultFullScreenGalleryActivity.class);
        intent.putExtra("selectedPhotoIdParam", j);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.ay.getCount(); i++) {
            arrayList.add((VaultPhoto) this.ay.getItem(i));
        }
        intent.putParcelableArrayListExtra("photoObjectsParam", arrayList);
        this.f2072h.a(intent, 321, this);
    }

    public static void m2080g(VaultSyncScreenFragment vaultSyncScreenFragment, int i) {
        vaultSyncScreenFragment.aq = (VaultPhoto) vaultSyncScreenFragment.ay.getItem(i);
        if (vaultSyncScreenFragment.aq != null) {
            if (vaultSyncScreenFragment.aq instanceof VaultLocalPhoto) {
                VaultImageProviderRow a = vaultSyncScreenFragment.f2073i.a(((VaultLocalPhoto) vaultSyncScreenFragment.aq).f);
                if (a != null && !a.m1957a()) {
                    vaultSyncScreenFragment.m2076a(vaultSyncScreenFragment.aq.a);
                    return;
                }
                return;
            }
            vaultSyncScreenFragment.m2076a(vaultSyncScreenFragment.aq.a);
        }
    }

    public static void ar(VaultSyncScreenFragment vaultSyncScreenFragment) {
        vaultSyncScreenFragment.ay.mo60a(0, 0);
    }
}
