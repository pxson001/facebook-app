package com.facebook.messaging.montage.viewer;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v7.internal.widget.ViewStubCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.locale.Locales;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.montage.MontageMessagesHelper;
import com.facebook.messaging.montage.model.MontageMessageInfo;
import com.facebook.messaging.montage.model.MyMontageMessageInfo;
import com.facebook.messaging.montage.viewer.MontageViewerSeenByListController.C14191;
import com.facebook.orca.threadview.montage.MontageViewActivity;
import com.facebook.orca.threadview.montage.MontageViewActivity.1;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: is_full_screen */
public abstract class AbstractMontageItemFragment extends FbFragment {
    @Inject
    Clock f12571a;
    private final Runnable aA = new C14011(this);
    public final Runnable aB = new C14022(this);
    public final Runnable aC = new C14033(this);
    private TextView al;
    private TextView am;
    public TextView an;
    public ViewGroup ao;
    public ViewStubHolder<MontageViewerSeenHeadsView> ap;
    public 1 aq;
    public boolean ar;
    public boolean as;
    private boolean at;
    private DateFormat au;
    private long av;
    private long aw;
    private boolean ax;
    private long ay;
    @Nullable
    private C14066 az;
    @Inject
    @ForUiThread
    public Handler f12572b;
    @Inject
    Locales f12573c;
    @Inject
    MontageMessagesHelper f12574d;
    @Inject
    MontageViewerSeenByListController f12575e;
    @Inject
    Toaster f12576f;
    public MontageMessageInfo f12577g;
    public MontageViewerContainerView f12578h;
    public ProgressBar f12579i;

    /* compiled from: is_full_screen */
    class C14011 implements Runnable {
        final /* synthetic */ AbstractMontageItemFragment f12563a;

        C14011(AbstractMontageItemFragment abstractMontageItemFragment) {
            this.f12563a = abstractMontageItemFragment;
        }

        public void run() {
            this.f12563a.aB();
        }
    }

    /* compiled from: is_full_screen */
    class C14022 implements Runnable {
        final /* synthetic */ AbstractMontageItemFragment f12564a;

        C14022(AbstractMontageItemFragment abstractMontageItemFragment) {
            this.f12564a = abstractMontageItemFragment;
        }

        public void run() {
            this.f12564a.f12579i.setVisibility(8);
            this.f12564a.ao.setVisibility(0);
        }
    }

    /* compiled from: is_full_screen */
    class C14033 implements Runnable {
        final /* synthetic */ AbstractMontageItemFragment f12565a;

        C14033(AbstractMontageItemFragment abstractMontageItemFragment) {
            this.f12565a = abstractMontageItemFragment;
        }

        public void run() {
            this.f12565a.f12579i.setVisibility(0);
            this.f12565a.ao.setVisibility(4);
        }
    }

    /* compiled from: is_full_screen */
    public class C14044 implements OnClickListener {
        final /* synthetic */ AbstractMontageItemFragment f12566a;

        public C14044(AbstractMontageItemFragment abstractMontageItemFragment) {
            this.f12566a = abstractMontageItemFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1998976418);
            if (!this.f12566a.ay()) {
                this.f12566a.aB();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1382275364, a);
        }
    }

    /* compiled from: is_full_screen */
    public class C14066 {
        public final /* synthetic */ AbstractMontageItemFragment f12569a;

        C14066(AbstractMontageItemFragment abstractMontageItemFragment) {
            this.f12569a = abstractMontageItemFragment;
        }
    }

    /* compiled from: is_full_screen */
    public class C14077 implements OnClickListener {
        final /* synthetic */ AbstractMontageItemFragment f12570a;

        public C14077(AbstractMontageItemFragment abstractMontageItemFragment) {
            this.f12570a = abstractMontageItemFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2072492190);
            if (this.f12570a.aq != null) {
                1 1 = this.f12570a.aq;
                AbstractMontageItemFragment n = MontageViewActivity.n(1.a);
                if (n != null) {
                    n.an.setVisibility(8);
                    n.av();
                    MontageViewActivity.j(1.a);
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1836742010, a);
        }
    }

    public static void m13018a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AbstractMontageItemFragment) obj).m13017a((Clock) SystemClockMethodAutoProvider.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike), Locales.a(injectorLike), MontageMessagesHelper.m12857b(injectorLike), new MontageViewerSeenByListController((Context) injectorLike.getInstance(Context.class)), Toaster.b(injectorLike));
    }

    public abstract void mo492a(LayoutInflater layoutInflater, ViewGroup viewGroup);

    protected abstract void aq();

    protected abstract void ar();

    public static Bundle m13016a(MontageMessageInfo montageMessageInfo) {
        Preconditions.checkNotNull(montageMessageInfo);
        Bundle bundle = new Bundle();
        bundle.putParcelable("montage_message_info", montageMessageInfo);
        return bundle;
    }

    private void m13017a(Clock clock, Handler handler, Locales locales, MontageMessagesHelper montageMessagesHelper, MontageViewerSeenByListController montageViewerSeenByListController, Toaster toaster) {
        this.f12571a = clock;
        this.f12572b = handler;
        this.f12573c = locales;
        this.f12574d = montageMessagesHelper;
        this.f12575e = montageViewerSeenByListController;
        this.f12576f = toaster;
    }

    public void mo496c(@Nullable Bundle bundle) {
        MontageMessageInfo montageMessageInfo;
        super.c(bundle);
        Class cls = AbstractMontageItemFragment.class;
        m13018a((Object) this, getContext());
        if (this.s == null) {
            montageMessageInfo = null;
        } else {
            montageMessageInfo = (MontageMessageInfo) this.s.getParcelable("montage_message_info");
        }
        this.f12577g = montageMessageInfo;
        Preconditions.checkNotNull(this.f12577g);
        this.au = SimpleDateFormat.getTimeInstance(3, this.f12573c.a());
    }

    public void mo497d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1956872260);
        super.d(bundle);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2124706000, a);
    }

    public final View m13022a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -59663382);
        View inflate = layoutInflater.inflate(2130905345, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -111543459, a);
        return inflate;
    }

    public final void m13025a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f12578h = (MontageViewerContainerView) e(2131562508);
        this.f12579i = (ProgressBar) e(2131563968);
        this.al = (TextView) e(2131563988);
        this.am = (TextView) e(2131559673);
        this.an = (TextView) e(2131563990);
        this.ao = (ViewGroup) e(2131563987);
        this.ap = ViewStubHolder.a((ViewStubCompat) e(2131563989));
        mo492a(b(bundle), this.f12578h);
        this.f12578h.setOnClickListener(new C14044(this));
        aC();
        if (this.f12577g instanceof MyMontageMessageInfo) {
            final MyMontageMessageInfo myMontageMessageInfo = (MyMontageMessageInfo) this.f12577g;
            if (!myMontageMessageInfo.f12562d.isEmpty()) {
                ((MontageViewerSeenHeadsView) this.ap.a()).setSeenBy(myMontageMessageInfo.f12562d);
                ((MontageViewerSeenHeadsView) this.ap.a()).setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AbstractMontageItemFragment f12568b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 55579626);
                        this.f12568b.av();
                        MontageViewerSeenByListController montageViewerSeenByListController = this.f12568b.f12575e;
                        ImmutableList immutableList = myMontageMessageInfo.f12562d;
                        if (montageViewerSeenByListController.f12627a == null) {
                            montageViewerSeenByListController.f12628b = new MontageViewerSeenByListAdapter(montageViewerSeenByListController.f12630d);
                            montageViewerSeenByListController.f12627a = new BottomSheetDialog(montageViewerSeenByListController.f12630d);
                            montageViewerSeenByListController.f12627a.c();
                            montageViewerSeenByListController.f12627a.a(montageViewerSeenByListController.f12628b);
                            montageViewerSeenByListController.f12627a.setOnDismissListener(new C14191(montageViewerSeenByListController));
                        }
                        MontageViewerSeenByListAdapter montageViewerSeenByListAdapter = montageViewerSeenByListController.f12628b;
                        montageViewerSeenByListAdapter.f12624b.clear();
                        montageViewerSeenByListAdapter.f12624b.addAll(immutableList);
                        montageViewerSeenByListAdapter.f12625c = montageViewerSeenByListAdapter.f12623a.getResources().getQuantityString(2131689784, immutableList.size(), new Object[]{Integer.valueOf(immutableList.size())});
                        montageViewerSeenByListAdapter.notifyDataSetChanged();
                        if (!montageViewerSeenByListController.m13082a()) {
                            Window window = montageViewerSeenByListController.f12627a.getWindow();
                            window.addFlags(8);
                            Activity activity = (Activity) ContextUtils.a(montageViewerSeenByListController.f12627a.getContext(), Activity.class);
                            if (activity != null) {
                                window.getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility());
                            }
                            montageViewerSeenByListController.f12627a.show();
                            window.clearFlags(8);
                        }
                        AbstractMontageItemFragment.aE(this.f12568b);
                        Logger.a(2, EntryType.UI_INPUT_END, -340828175, a);
                    }
                });
                this.ap.f();
            }
        } else {
            this.an.setOnClickListener(new C14077(this));
            at();
        }
        ViewCompat.z(this.ao);
    }

    private void aC() {
        Message message = this.f12577g.f12555b;
        this.al.setText(message.e.c);
        CharSequence format = this.au.format(new Date(message.c));
        if (this.f12577g instanceof MyMontageMessageInfo) {
            format = jW_().getString(2131240924, new Object[]{format, m13019b(Math.abs(message.c - MontageMessagesHelper.m12853a()))});
        }
        this.am.setText(format);
    }

    public static void aE(AbstractMontageItemFragment abstractMontageItemFragment) {
        if (abstractMontageItemFragment.az == null) {
            abstractMontageItemFragment.az = new C14066(abstractMontageItemFragment);
        }
        abstractMontageItemFragment.f12575e.f12629c = abstractMontageItemFragment.az;
    }

    private String m13019b(long j) {
        long j2;
        long toSeconds = TimeUnit.MILLISECONDS.toSeconds(j);
        long j3 = 0;
        if (toSeconds >= 3600) {
            j2 = toSeconds / 3600;
            long j4 = j2;
            j2 = toSeconds - (3600 * j2);
            toSeconds = j4;
        } else {
            j2 = toSeconds;
            toSeconds = 0;
        }
        if (j2 >= 60) {
            j3 = j2 / 60;
        }
        if (toSeconds > 0) {
            return jW_().getQuantityString(2131689782, j3 == 0 ? 1 : (int) j3, new Object[]{Long.valueOf(toSeconds), Long.valueOf(j3)});
        }
        Resources jW_ = jW_();
        int i = j3 == 0 ? 1 : (int) j3;
        Object[] objArr = new Object[1];
        if (j3 == 0) {
            j3 = 1;
        }
        objArr[0] = Long.valueOf(j3);
        return jW_.getQuantityString(2131689783, i, objArr);
    }

    public final void m13020G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1955244069);
        super.G();
        aG();
        if (this.f12575e.m13082a()) {
            aE(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 471690914, a);
    }

    public final void m13029g(boolean z) {
        super.g(z);
        if (z) {
            aG();
        } else {
            aI();
        }
    }

    public final void m13021H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1628063869);
        super.H();
        aI();
        this.f12575e.f12629c = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1010879013, a);
    }

    private void aG() {
        Object obj;
        if (mx_() && !this.K && D()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null && this.ar && !this.at) {
            this.at = true;
            aq();
            aK();
        }
    }

    private void aI() {
        if (this.at) {
            this.at = false;
            aJ();
            ar();
        }
    }

    protected final void m13023a(long j) {
        aJ();
        this.av = this.f12571a.a();
        this.aw = j;
        HandlerDetour.b(this.f12572b, this.aA, j, -841610535);
    }

    private void aJ() {
        if (this.f12572b != null) {
            HandlerDetour.a(this.f12572b, this.aA);
        }
    }

    public long as() {
        if (ay()) {
            return this.ay;
        }
        if (this.f12571a == null) {
            return 3000;
        }
        return Math.max(0, this.aw - (this.f12571a.a() - this.av));
    }

    public final void at() {
        this.an.setVisibility(0);
    }

    public void av() {
        if (!ay()) {
            this.ay = as();
            this.ax = true;
            HandlerDetour.a(this.f12572b, this.aA);
        }
    }

    public void aw() {
        if (ay()) {
            this.ax = false;
            this.av = this.f12571a.a() - (this.aw - this.ay);
            HandlerDetour.b(this.f12572b, this.aA, as(), 1619575958);
        }
    }

    public void ax() {
        if (this.at) {
            aq();
        }
    }

    public boolean ay() {
        return this.ax;
    }

    protected final void m13026a(Throwable th) {
        this.as = true;
        this.ar = false;
        aL();
        aK();
        if (this.aq != null) {
            1 1 = this.aq;
            if (MontageViewActivity.b(1.a, this)) {
                MontageViewActivity.o(1.a);
            }
        }
    }

    private void aK() {
        if (this.as && this.at) {
            this.f12576f.a(new ToastBuilder(2131240922));
        }
    }

    protected final void aA() {
        Preconditions.checkArgument(!this.as);
        if (!this.ar) {
            this.ar = true;
            aG();
        }
        aL();
        if (this.aq != null) {
            1 1 = this.aq;
            if (MontageViewActivity.b(1.a, this)) {
                1.a.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                MontageViewActivity montageViewActivity = 1.a;
                if (!montageViewActivity.E) {
                    montageViewActivity.u.m10123a(montageViewActivity.D);
                    montageViewActivity.E = true;
                }
            }
        }
    }

    protected final void aB() {
        if (this.aq != null) {
            1 1 = this.aq;
            if (MontageViewActivity.b(1.a, this)) {
                MontageViewActivity.o(1.a);
            }
        }
    }

    private void aL() {
        HandlerDetour.a(this.f12572b, this.aC);
        HandlerDetour.a(this.f12572b, this.aB, 2128874096);
    }
}
