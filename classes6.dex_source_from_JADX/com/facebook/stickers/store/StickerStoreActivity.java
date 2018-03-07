package com.facebook.stickers.store;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import com.facebook.actionbar.ActionBarOwner;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.base.fragment.NavigableFragment;
import com.facebook.base.fragment.NavigableFragment.Listener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.stickers.client.StickerToPackMetadataLoader;
import com.facebook.stickers.client.StickerToPackMetadataLoader.Params;
import com.facebook.stickers.client.StickerToPackMetadataLoader.Results;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.perf.StickerSequences;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import com.facebook.widget.titlebar.FbActionBarUtil;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.base.Preconditions;
import java.text.DecimalFormat;
import javax.inject.Inject;

/* compiled from: e3b91b4367a45680b608504597cf5701 */
public class StickerStoreActivity extends FbFragmentActivity implements ActionBarOwner {
    private static final Class<?> f16928p = StickerStoreActivity.class;
    public FbTitleBar f16929A;
    private ActionBarBasedFbTitleBar f16930B;
    private StickerStoreFragment f16931C;
    private StickerStorePackFragment f16932D;
    public MonotonicClock f16933q;
    public SequenceLogger f16934r;
    private FbActionBarUtil f16935s;
    private FbAppType f16936t;
    public AbstractFbErrorReporter f16937u;
    private AppCompatActivityOverrider f16938v;
    private StickerToPackMetadataLoader f16939w;
    private boolean f16940x;
    public StickerInterface f16941y;
    private ActionBar f16942z;

    /* compiled from: e3b91b4367a45680b608504597cf5701 */
    class C12121 implements Listener {
        final /* synthetic */ StickerStoreActivity f16924a;

        C12121(StickerStoreActivity stickerStoreActivity) {
            this.f16924a = stickerStoreActivity;
        }

        public final void m24621a(NavigableFragment navigableFragment, Intent intent) {
            this.f16924a.m24628a(navigableFragment, intent);
        }
    }

    /* compiled from: e3b91b4367a45680b608504597cf5701 */
    /* synthetic */ class C12143 {
        static final /* synthetic */ int[] f16927a = new int[Product.values().length];

        static {
            try {
                f16927a[Product.MESSENGER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f16927a[Product.FB4A.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static <T extends Context> void m24633a(Class<T> cls, T t) {
        m24634a((Object) t, (Context) t);
    }

    public static void m24634a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((StickerStoreActivity) obj).m24629a((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector), (SequenceLogger) SequenceLoggerImpl.a(fbInjector), FbActionBarUtil.m8789a(fbInjector), (FbAppType) fbInjector.getInstance(FbAppType.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), AppCompatActivityOverrider.b(fbInjector), StickerToPackMetadataLoader.m23942b(fbInjector));
    }

    protected final void m24644a(Bundle bundle) {
        super.a(bundle);
        MessengerMaterialThemeUtil.m18984a(this, 2131625175);
        Class cls = StickerStoreActivity.class;
        m24634a((Object) this, (Context) this);
        this.f16940x = this.f16935s.m8791a();
        if (this.f16940x) {
            a(this.f16938v);
        }
    }

    @Inject
    private void m24629a(MonotonicClock monotonicClock, SequenceLogger sequenceLogger, FbActionBarUtil fbActionBarUtil, FbAppType fbAppType, AbstractFbErrorReporter abstractFbErrorReporter, AppCompatActivityOverrider appCompatActivityOverrider, StickerToPackMetadataLoader stickerToPackMetadataLoader) {
        this.f16933q = monotonicClock;
        this.f16934r = sequenceLogger;
        this.f16935s = fbActionBarUtil;
        this.f16936t = fbAppType;
        this.f16937u = abstractFbErrorReporter;
        this.f16938v = appCompatActivityOverrider;
        this.f16939w = stickerToPackMetadataLoader;
    }

    protected final void m24646b(Bundle bundle) {
        boolean z;
        StickerPack stickerPack;
        Sequence e;
        Intent intent = getIntent();
        Preconditions.checkNotNull(intent);
        if (intent.hasExtra("stickerContext")) {
            this.f16941y = (StickerInterface) intent.getSerializableExtra("stickerContext");
        }
        if (this.f16941y == null) {
            AbstractFbErrorReporter abstractFbErrorReporter = this.f16937u;
            SoftErrorBuilder a = SoftError.a("error_no_sticker_context", "StickerStoreActivity was created with an intent that either did not have an EXTRA_STICKER_CONTEXT extra or an had an invalid value in this extra.");
            a.e = 10;
            a = a;
            a.f = false;
            a = a;
            a.d = true;
            abstractFbErrorReporter.a(a.g());
            switch (C12143.f16927a[this.f16936t.j.ordinal()]) {
                case 1:
                    this.f16941y = StickerInterface.MESSENGER;
                    break;
                case 2:
                    this.f16941y = StickerInterface.COMMENTS;
                    break;
            }
            this.f16941y = StickerInterface.MESSENGER;
        }
        if (intent.hasExtra("stickerPack")) {
            z = false;
            stickerPack = (StickerPack) intent.getParcelableExtra("stickerPack");
            e = this.f16934r.e(StickerSequences.f16773d);
        } else if (intent.hasExtra("stickerId")) {
            z = true;
            e = null;
            stickerPack = null;
        } else {
            e = this.f16934r.e(StickerSequences.f16772c);
            z = false;
            stickerPack = null;
        }
        boolean booleanExtra = intent.getBooleanExtra("startDownload", false);
        if (e != null) {
            SequenceLoggerDetour.a(e, "StickerCreateStickerStoreActivity", null, null, this.f16933q.now(), 409988998);
        }
        super.b(bundle);
        setContentView(2130905862);
        if (this.f16940x) {
            this.f16942z = this.f16938v.g();
            this.f16930B = new ActionBarBasedFbTitleBar((FragmentManagerHost) this, this.f16942z);
            this.f16929A = this.f16930B;
        } else {
            FbTitleBarUtil.m8799b(this);
            this.f16929A = (FbTitleBar) a(2131558563);
            this.f16929A.setTitle(2131231288);
        }
        if (z) {
            m24635a(intent.getStringExtra("stickerId"), booleanExtra);
        } else if (stickerPack == null) {
            m24640k(this);
        } else {
            m24630a(stickerPack, false, booleanExtra, m24637b(stickerPack), false);
        }
    }

    public static String m24637b(StickerPack stickerPack) {
        if (stickerPack.f4963i == 0) {
            return null;
        }
        return new DecimalFormat("$0.00").format(((double) stickerPack.f4963i) / 100.0d);
    }

    public final void m24645a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof NavigableFragment) {
            ((NavigableFragment) fragment).a(new C12121(this));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        if (this.f16940x && onCreateOptionsMenu) {
            this.f16930B.m8768a(menu);
        }
        return onCreateOptionsMenu;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean z;
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            z = true;
        } else {
            z = this.f16940x ? this.f16930B.m8771a(menuItem) : false;
        }
        if (z || super.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return false;
    }

    public final ActionBar m24643a() {
        return this.f16942z;
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -273168643);
        super.onDestroy();
        this.f16939w.m23943a();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 236666097, a);
    }

    final FbTitleBar m24647i() {
        return this.f16929A;
    }

    public static void m24640k(StickerStoreActivity stickerStoreActivity) {
        FragmentManager kO_ = stickerStoreActivity.kO_();
        if (!kO_.c()) {
            BLog.b(f16928p, "Unable to safely commit fragment transactions--aborting operation.");
        } else if (stickerStoreActivity.m24641l()) {
            FragmentTransaction a = kO_.a();
            a.c(stickerStoreActivity.f16931C);
            a.b();
        }
    }

    private boolean m24641l() {
        FragmentManager kO_ = kO_();
        this.f16931C = (StickerStoreFragment) kO_.a("storeFragment");
        if (this.f16931C != null) {
            return true;
        }
        if (kO_.c()) {
            this.f16931C = new StickerStoreFragment();
            FragmentTransaction a = kO_.a();
            a.a(2131559223, this.f16931C, "storeFragment");
            a.b(this.f16931C);
            a.b();
            kO_.b();
            return true;
        }
        BLog.b(f16928p, "Unable to safely commit fragment transactions--aborting operation.");
        return false;
    }

    private void m24630a(StickerPack stickerPack, boolean z, boolean z2, String str, boolean z3) {
        FragmentManager kO_ = kO_();
        if (!kO_.c()) {
            BLog.b(f16928p, "Unable to safely commit fragment transactions--aborting operation.");
        } else if (m24642m()) {
            this.f16932D.m24731a(stickerPack, z, z2, str, this.f16941y);
            FragmentTransaction a = kO_.a();
            a.b(kO_().a("storeFragment"));
            a.c(this.f16932D);
            if (z3) {
                a.a("packFragment");
            }
            a.b();
        }
    }

    private boolean m24642m() {
        FragmentManager kO_ = kO_();
        this.f16932D = (StickerStorePackFragment) kO_.a("packFragment");
        if (this.f16932D != null) {
            return true;
        }
        if (kO_.c()) {
            this.f16932D = new StickerStorePackFragment();
            FragmentTransaction a = kO_.a();
            a.a(2131559223, this.f16932D, "packFragment");
            a.b(this.f16932D);
            a.b();
            kO_.b();
            return true;
        }
        BLog.b(f16928p, "Unable to safely commit fragment transactions--aborting operation.");
        return false;
    }

    private void m24635a(String str, final boolean z) {
        Params params = new Params(str);
        this.f16939w.m23943a();
        this.f16939w.m23944a(new Callback<Params, Results, Throwable>(this) {
            final /* synthetic */ StickerStoreActivity f16926b;

            public final void m24624b(Object obj, Object obj2) {
                StickerPack stickerPack = ((Results) obj2).f16466a;
                String b = StickerStoreActivity.m24637b(stickerPack);
                Sequence e = this.f16926b.f16934r.e(StickerSequences.f16773d);
                if (e != null) {
                    SequenceLoggerDetour.a(e, "StickerCreateStickerStoreActivity", null, null, this.f16926b.f16933q.now(), 1526787849);
                }
                this.f16926b.m24630a(stickerPack, false, z, b, false);
            }

            public final void m24625c(Object obj, Object obj2) {
                this.f16926b.f16937u.a("StickerStoreActivity_StickerPackFromIdLoadFailed", "Failed to load sticker pack from sticker id", (Throwable) obj2);
                StickerStoreActivity.m24640k(this.f16926b);
            }
        });
        this.f16939w.m23945a(params);
    }

    private void m24628a(NavigableFragment navigableFragment, Intent intent) {
        if (intent == null) {
            finish();
        } else if (navigableFragment instanceof StickerStoreFragment) {
            m24630a((StickerPack) intent.getParcelableExtra("stickerPack"), intent.getBooleanExtra("isDownloaded", false), false, intent.getStringExtra("price"), true);
        }
    }

    public final StickerInterface m24648j() {
        return this.f16941y;
    }
}
