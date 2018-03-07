package com.facebook.stickers.store;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.actionbar.ActionBarOwner;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.stickers.analytics.StickerLogger;
import com.facebook.stickers.client.StickerDownloadManager;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.perf.StickerSequences;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: e1bc6ef54f3911a6444a57c8147e304a */
public class StickerStorePackFragment extends FbFragment implements ActionReceiver {
    private static final Class<?> f17013a;
    private static final CallerContext f17014b;
    private SequenceLogger aA;
    private MonotonicClock aB;
    private Optional<StickerInterface> aC;
    private FbDraweeControllerBuilder aD;
    private ErrorDialogs al;
    private StickerPack am;
    private boolean an;
    private boolean ao;
    private String ap;
    private FbDraweeView aq;
    private TextView ar;
    private TextView as;
    private TextView at;
    private TextView au;
    private ProgressBar av;
    private Button aw;
    public ProgressBar ax;
    public FbDraweeView ay;
    private LinearLayout az;
    private Context f17015c;
    private LayoutInflater f17016d;
    private BaseFbBroadcastManager f17017e;
    private StickerDownloadManager f17018f;
    private StickerLogger f17019g;
    private SelfRegistrableReceiverImpl f17020h;
    private AnalyticsTagger f17021i;

    /* compiled from: e1bc6ef54f3911a6444a57c8147e304a */
    class C12261 implements OnClickListener {
        final /* synthetic */ StickerStorePackFragment f17011a;

        C12261(StickerStorePackFragment stickerStorePackFragment) {
            this.f17011a = stickerStorePackFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -971201837);
            StickerStorePackFragment.aq(this.f17011a);
            Logger.a(2, EntryType.UI_INPUT_END, -1345612273, a);
        }
    }

    /* compiled from: e1bc6ef54f3911a6444a57c8147e304a */
    class C12272 extends BaseControllerListener {
        final /* synthetic */ StickerStorePackFragment f17012a;

        C12272(StickerStorePackFragment stickerStorePackFragment) {
            this.f17012a = stickerStorePackFragment;
        }

        public final void m24721a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            CloseableImage closeableImage = (CloseableImage) obj;
            float f = 2.0f;
            if (closeableImage != null) {
                int i;
                this.f17012a.ax.setVisibility(8);
                this.f17012a.ay.setVisibility(0);
                int f2 = closeableImage.f();
                int g = closeableImage.g();
                DisplayMetrics displayMetrics = this.f17012a.jW_().getDisplayMetrics();
                int i2 = displayMetrics.widthPixels;
                if (this.f17012a.jW_().getConfiguration().orientation == 2) {
                    i2 = displayMetrics.heightPixels;
                }
                float f3 = ((float) i2) / ((float) f2);
                if (f3 > 2.0f) {
                    i = (int) (((float) f2) * 2.0f);
                } else {
                    f = f3;
                    i = i2;
                }
                int i3 = (int) (f * ((float) g));
                this.f17012a.ay.setMinimumWidth(i);
                this.f17012a.ay.setMinimumHeight(i3);
            }
        }

        public final void m24720a(String str, Object obj) {
        }

        public final void m24722b(String str, Throwable th) {
        }

        public final void m24719a(String str) {
        }
    }

    public static void m24724a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((StickerStorePackFragment) obj).m24723a(AnalyticsTagger.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (SequenceLogger) SequenceLoggerImpl.a(injectorLike), StickerDownloadManager.m23933a(injectorLike), StickerLogger.m23898a(injectorLike), FbDraweeControllerBuilder.b(injectorLike), ErrorDialogs.a(injectorLike));
    }

    static {
        Class cls = StickerStorePackFragment.class;
        f17013a = cls;
        f17014b = CallerContext.a(cls, "sticker_store_pack");
    }

    public final View m24730a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 696797267);
        this.f17015c = ContextUtils.a(getContext(), 2130773101, 2131625136);
        this.f17016d = layoutInflater.cloneInContext(this.f17015c);
        View inflate = layoutInflater.inflate(2130905866, viewGroup, false);
        Class cls = StickerStorePackFragment.class;
        m24724a((Object) this, getContext());
        this.f17021i.a(inflate, "sticker_store", this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1748594589, a);
        return inflate;
    }

    @Inject
    private void m24723a(AnalyticsTagger analyticsTagger, BaseFbBroadcastManager baseFbBroadcastManager, MonotonicClock monotonicClock, SequenceLogger sequenceLogger, StickerDownloadManager stickerDownloadManager, StickerLogger stickerLogger, FbDraweeControllerBuilder fbDraweeControllerBuilder, ErrorDialogs errorDialogs) {
        this.f17021i = analyticsTagger;
        this.f17017e = baseFbBroadcastManager;
        this.aB = monotonicClock;
        this.aA = sequenceLogger;
        this.f17018f = stickerDownloadManager;
        this.f17019g = stickerLogger;
        this.aD = fbDraweeControllerBuilder;
        this.al = errorDialogs;
    }

    public final void m24733d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1164350254);
        super.d(bundle);
        this.aq = (FbDraweeView) e(2131562910);
        this.ar = (TextView) e(2131560124);
        this.as = (TextView) e(2131565135);
        this.at = (TextView) e(2131560464);
        this.au = (TextView) e(2131559627);
        this.av = (ProgressBar) e(2131559418);
        this.aw = (Button) e(2131565134);
        this.ax = (ProgressBar) e(2131560407);
        this.ay = (FbDraweeView) e(2131565164);
        this.az = (LinearLayout) e(2131565165);
        this.av.setMax(100);
        this.aw.setBackgroundResource(ContextUtils.b(this.f17015c, 2130773106, 2130841882));
        this.aw.setOnClickListener(new C12261(this));
        m24726b();
        this.f17020h = this.f17017e.a().a("com.facebook.orca.stickers.DOWNLOAD_PROGRESS", this).a("com.facebook.orca.stickers.DOWNLOAD_SUCCESS", this).a("com.facebook.orca.stickers.DOWNLOAD_FAILURE", this).a();
        m24727e();
        Sequence e = this.aA.e(StickerSequences.f16772c);
        if (e != null) {
            SequenceLoggerDetour.b(e, "StickerCreateStickerStoreActivity", null, null, this.aB.now(), -983394833);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1481909596, a);
    }

    public final void m24728G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2114972185);
        super.G();
        this.f17020h.b();
        m24727e();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 470628963, a);
    }

    public final void m24729I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -550350786);
        super.I();
        this.f17020h.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 30918894, a);
    }

    public final void m24732c(boolean z) {
        super.c(z);
        if (!z) {
            m24726b();
        }
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1009487129);
        StickerPack stickerPack = (StickerPack) intent.getParcelableExtra("stickerPack");
        if (Objects.equal(this.am, stickerPack)) {
            if ("com.facebook.orca.stickers.DOWNLOAD_PROGRESS".equals(intent.getAction())) {
                this.aw.setText(2131231296);
                this.aw.setEnabled(false);
                this.av.setIndeterminate(false);
                this.av.setProgress(intent.getIntExtra("progress", 0));
                this.av.setVisibility(0);
            } else if ("com.facebook.orca.stickers.DOWNLOAD_SUCCESS".equals(intent.getAction())) {
                m24725a("sticker_pack_downloaded", stickerPack);
                this.an = true;
                m24727e();
            } else if ("com.facebook.orca.stickers.DOWNLOAD_FAILURE".equals(intent.getAction())) {
                m24725a("sticker_pack_download_error", stickerPack);
                m24727e();
                this.al.a(ErrorDialogParams.a(jW_()).a(2131230721).b(2131230758).l());
            }
            LogUtils.e(-578573953, a);
            return;
        }
        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1387321027, a);
    }

    private void m24726b() {
        if (ao() instanceof ActionBarOwner) {
            ActionBar a = ((ActionBarOwner) ao()).a();
            if (a != null) {
                a.c(0);
            }
        }
    }

    public final void m24731a(StickerPack stickerPack, boolean z, boolean z2, String str, @Nonnull StickerInterface stickerInterface) {
        this.am = stickerPack;
        this.an = z;
        this.ao = z2;
        this.ap = str;
        this.aC = Optional.of(stickerInterface);
        m24727e();
    }

    private void m24727e() {
        if (this.am != null && this.aq != null) {
            this.aq.a(this.am.f4959e, f17014b);
            this.ar.setText(this.am.f4956b);
            this.as.setText(this.am.f4957c);
            if (this.ap == null) {
                this.at.setText(2131231293);
            } else {
                this.at.setText(this.ap);
            }
            this.au.setText(this.am.f4958d);
            if (this.f17018f.m23937c(this.am)) {
                this.aw.setText(2131231296);
                this.aw.setEnabled(false);
                this.av.setIndeterminate(false);
                this.av.setProgress(this.f17018f.m23938d(this.am));
                this.av.setVisibility(0);
            } else if (this.an) {
                this.aw.setText(2131231297);
                this.aw.setEnabled(false);
                this.av.setVisibility(8);
            } else {
                this.aw.setText(2131231295);
                this.aw.setEnabled(true);
                this.av.setVisibility(8);
            }
            if (this.aC.isPresent() && !this.am.m7725a((StickerInterface) this.aC.get())) {
                this.aw.setEnabled(false);
                this.at.setText(jW_().getString(2131232439));
            }
            this.ax.setVisibility(0);
            this.ay.setController(((FbDraweeControllerBuilder) this.aD.b(this.am.f4961g).a(f17014b).a(new C12272(this))).s());
            this.az.removeAllViews();
            ImmutableList immutableList = this.am.f4973s;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                String str = (String) immutableList.get(i);
                if (!StringUtil.a(str)) {
                    TextView textView = (TextView) this.f17016d.inflate(2130905865, this.az, false);
                    textView.setText(str);
                    this.az.addView(textView);
                }
            }
            if (this.ao) {
                aq(this);
                this.ao = false;
            }
        }
    }

    public static void aq(StickerStorePackFragment stickerStorePackFragment) {
        stickerStorePackFragment.m24725a("sticker_pack_download_tapped", stickerStorePackFragment.am);
        stickerStorePackFragment.aw.setEnabled(false);
        stickerStorePackFragment.av.setProgress(0);
        stickerStorePackFragment.av.setVisibility(0);
        stickerStorePackFragment.f17018f.m23936a(stickerStorePackFragment.am);
    }

    private void m24725a(String str, StickerPack stickerPack) {
        HoneyClientEvent a = StickerLogger.m23897a("sticker_store_pack");
        a.b("action", str);
        a.b("sticker_pack", stickerPack.f4955a);
        a.a("is_featured", stickerPack.f4970p);
        this.f17019g.m23900a(a);
    }
}
