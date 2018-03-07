package com.facebook.orca.threadview.montage;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.support.v7.internal.widget.ViewStubCompat;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.loader.AbstractFbLoaderCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.ui.keyboard.CustomKeyboardLayout;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.analytics.base.MessagingAnalyticsConstants.MessageSendTrigger;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.ReadThreadManager;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.ThreadViewTheme.BubbleType;
import com.facebook.messaging.customthreads.ThreadViewTheme.SenderType;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.threadkey.DefaultThreadKeyFactory;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.montage.MontageMessagesHelper;
import com.facebook.messaging.montage.MontageTestHelper;
import com.facebook.messaging.montage.model.MontageMessageInfo;
import com.facebook.messaging.montage.model.MontagePlayQueue;
import com.facebook.messaging.montage.viewer.AbstractMontageItemFragment;
import com.facebook.messaging.montage.viewer.MontageProgressIndicatorController;
import com.facebook.messaging.montage.viewer.MontageProgressIndicatorControllerProvider;
import com.facebook.messaging.montage.viewer.MontageProgressIndicatorView;
import com.facebook.messaging.montage.viewer.MontageViewerPagerAdapter;
import com.facebook.messaging.send.client.SendMessageManager;
import com.facebook.messaging.send.common.SendResult;
import com.facebook.messaging.send.trigger.NavigationTrigger;
import com.facebook.orca.compose.ComposeFragment;
import com.facebook.orca.compose.ComposeFragment.SimpleComposerListener;
import com.facebook.orca.threadview.ThreadViewLoader;
import com.facebook.orca.threadview.ThreadViewLoader.Error;
import com.facebook.orca.threadview.ThreadViewLoader.Params;
import com.facebook.orca.threadview.ThreadViewLoader.Result;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomViewPager;
import com.facebook.widget.ViewStubHolder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: manage_message_menu_dialog */
public class MontageViewActivity extends FbFragmentActivity {
    private static final String f8269B = MontageViewActivity.class.getSimpleName();
    @Inject
    @ForUiThread
    public ScheduledExecutorService f8270A;
    private ThreadKey f8271C;
    public ThreadKey f8272D;
    public boolean f8273E;
    public MontagePlayQueue f8274F;
    public CustomViewPager f8275G;
    public FrameLayout f8276H;
    private MontageProgressIndicatorView f8277I;
    public MontageViewerReplyContainer f8278J;
    private ViewStubHolder<CustomKeyboardLayout> f8279K;
    public ComposeFragment f8280L;
    @Nullable
    public MontageViewerPagerAdapter f8281M;
    public MontageProgressIndicatorController f8282N;
    @Inject
    InputMethodManager f8283p;
    @Inject
    DataCache f8284q;
    @Inject
    public MontageMessagesHelper f8285r;
    @Inject
    public MontageTestHelper f8286s;
    @Inject
    MontageProgressIndicatorControllerProvider f8287t;
    @Inject
    public ReadThreadManager f8288u;
    @Inject
    public SendMessageManager f8289v;
    @Inject
    DefaultThreadKeyFactory f8290w;
    @Inject
    ThreadViewLoader f8291x;
    @Inject
    public DefaultThreadViewTheme f8292y;
    @Inject
    Toaster f8293z;

    /* compiled from: manage_message_menu_dialog */
    public class C12391 {
        public final /* synthetic */ MontageViewActivity f8262a;

        C12391(MontageViewActivity montageViewActivity) {
            this.f8262a = montageViewActivity;
        }
    }

    /* compiled from: manage_message_menu_dialog */
    public class C12402 {
        public final /* synthetic */ MontageViewActivity f8263a;

        C12402(MontageViewActivity montageViewActivity) {
            this.f8263a = montageViewActivity;
        }
    }

    /* compiled from: manage_message_menu_dialog */
    public class C12413 extends SimpleOnPageChangeListener {
        final /* synthetic */ MontageViewActivity f8264a;

        public C12413(MontageViewActivity montageViewActivity) {
            this.f8264a = montageViewActivity;
        }

        public final void e_(int i) {
            MontageViewActivity.m8247b(this.f8264a, i);
        }

        public final void m8240b(int i) {
            if (i == 0) {
                Fragment n = MontageViewActivity.m8252n(this.f8264a);
                if (n != null && MontageViewActivity.m8248b(this.f8264a, n) && n.as) {
                    MontageViewActivity.m8253o(this.f8264a);
                }
            }
        }
    }

    /* compiled from: manage_message_menu_dialog */
    class C12424 implements Runnable {
        final /* synthetic */ MontageViewActivity f8265a;

        C12424(MontageViewActivity montageViewActivity) {
            this.f8265a = montageViewActivity;
        }

        public void run() {
            this.f8265a.f8280L.ar();
        }
    }

    /* compiled from: manage_message_menu_dialog */
    class C12435 extends SimpleComposerListener {
        final /* synthetic */ MontageViewActivity f8266a;

        C12435(MontageViewActivity montageViewActivity) {
            this.f8266a = montageViewActivity;
        }

        public final void mo147a(Message message, MessageSendTrigger messageSendTrigger) {
            this.f8266a.f8280L.aC();
            this.f8266a.f8280L.aD();
            MontageViewActivity.m8251l(this.f8266a);
            MontageViewActivity montageViewActivity = this.f8266a;
            montageViewActivity.f8278J.m8265a(message);
            Futures.a(montageViewActivity.f8289v.a(message, "composer", NavigationTrigger.b("montage_reply"), messageSendTrigger), new C12446(montageViewActivity), montageViewActivity.f8270A);
        }
    }

    /* compiled from: manage_message_menu_dialog */
    public class C12446 implements FutureCallback<SendResult> {
        final /* synthetic */ MontageViewActivity f8267a;

        public C12446(MontageViewActivity montageViewActivity) {
            this.f8267a = montageViewActivity;
        }

        public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
        }

        public void onFailure(Throwable th) {
            this.f8267a.f8293z.a(new ToastBuilder(2131240921));
        }
    }

    /* compiled from: manage_message_menu_dialog */
    class MontageViewLoaderCallback extends AbstractFbLoaderCallback<Params, Result, Error> {
        final /* synthetic */ MontageViewActivity f8268a;

        public MontageViewLoaderCallback(MontageViewActivity montageViewActivity) {
            this.f8268a = montageViewActivity;
        }

        public final void m8242b(Object obj, Object obj2) {
            Result result = (Result) obj2;
            MontageViewActivity montageViewActivity = this.f8268a;
            MessagesCollection messagesCollection = result.f7613c;
            ThreadSummary threadSummary = result.f7611a;
            long j = threadSummary.l;
            ImmutableList a = montageViewActivity.f8285r.b(messagesCollection, j) ? montageViewActivity.f8285r.a(messagesCollection, j) : montageViewActivity.f8285r.a(messagesCollection);
            Collection arrayList = new ArrayList(a.size());
            int size = a.size();
            for (int i = 0; i < size; i++) {
                Object a2;
                Message message = (Message) a.get(i);
                if (montageViewActivity.f8286s.a(message.b)) {
                    a2 = montageViewActivity.f8285r.a(message, threadSummary);
                } else {
                    a2 = montageViewActivity.f8285r.c(message);
                }
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            if (arrayList.isEmpty()) {
                montageViewActivity.finish();
                return;
            }
            Collections.reverse(arrayList);
            montageViewActivity.f8274F = new MontagePlayQueue(ImmutableList.copyOf(arrayList));
            montageViewActivity.f8282N.a(montageViewActivity.f8274F.c);
            montageViewActivity.f8281M = new MontageViewerPagerAdapter(montageViewActivity.f8274F.a, montageViewActivity.kO_());
            montageViewActivity.f8275G.setAdapter(montageViewActivity.f8281M);
            MontageViewActivity.m8247b(montageViewActivity, 0);
        }

        public final void m8243c(Object obj, Object obj2) {
            this.f8268a.f8293z.a(new ToastBuilder(2131240922));
            this.f8268a.finish();
        }
    }

    public static void m8246a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MontageViewActivity) obj).m8244a(InputMethodManagerMethodAutoProvider.b(injectorLike), DataCache.a(injectorLike), MontageMessagesHelper.b(injectorLike), MontageTestHelper.b(injectorLike), (MontageProgressIndicatorControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MontageProgressIndicatorControllerProvider.class), ReadThreadManager.a(injectorLike), SendMessageManager.a(injectorLike), DefaultThreadKeyFactory.b(injectorLike), ThreadViewLoader.m7346b(injectorLike), DefaultThreadViewTheme.b(injectorLike), Toaster.b(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    private void m8244a(InputMethodManager inputMethodManager, DataCache dataCache, MontageMessagesHelper montageMessagesHelper, MontageTestHelper montageTestHelper, MontageProgressIndicatorControllerProvider montageProgressIndicatorControllerProvider, ReadThreadManager readThreadManager, SendMessageManager sendMessageManager, DefaultThreadKeyFactory defaultThreadKeyFactory, ThreadViewLoader threadViewLoader, DefaultThreadViewTheme defaultThreadViewTheme, Toaster toaster, ScheduledExecutorService scheduledExecutorService) {
        this.f8283p = inputMethodManager;
        this.f8284q = dataCache;
        this.f8285r = montageMessagesHelper;
        this.f8286s = montageTestHelper;
        this.f8287t = montageProgressIndicatorControllerProvider;
        this.f8288u = readThreadManager;
        this.f8289v = sendMessageManager;
        this.f8290w = defaultThreadKeyFactory;
        this.f8291x = threadViewLoader;
        this.f8292y = defaultThreadViewTheme;
        this.f8293z = toaster;
        this.f8270A = scheduledExecutorService;
    }

    public final void m8254a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof AbstractMontageItemFragment) {
            ((AbstractMontageItemFragment) fragment).aq = new C12391(this);
        }
    }

    protected final void m8255b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = MontageViewActivity.class;
        m8246a(this, this);
        setContentView(2130905344);
        this.f8275G = (CustomViewPager) a(2131562217);
        this.f8277I = (MontageProgressIndicatorView) a(2131563984);
        this.f8276H = (FrameLayout) a(2131563986);
        this.f8278J = (MontageViewerReplyContainer) a(2131563985);
        this.f8279K = ViewStubHolder.a((ViewStubCompat) a(2131563846));
        this.f8275G.setOnPageChangeListener(new C12413(this));
        this.f8282N = new MontageProgressIndicatorController(this.f8277I, (Clock) SystemClockMethodAutoProvider.a(this.f8287t));
        this.f8282N.l = new C12402(this);
        this.f8291x.m7350a(new MontageViewLoaderCallback(this));
        if (bundle == null) {
            bundle = getIntent().getExtras();
        }
        m8245a((ThreadKey) bundle.getParcelable("thread_key"));
    }

    private void m8245a(ThreadKey threadKey) {
        if (threadKey == null) {
            finish();
            throw new IllegalStateException("StatusThreadViewActivity created without a ThreadKey");
        }
        this.f8272D = threadKey;
        this.f8291x.m7351a(this.f8272D);
        this.f8291x.m7352a(Params.m7325a(false, true, true));
    }

    public static void m8247b(MontageViewActivity montageViewActivity, int i) {
        Preconditions.checkNotNull(montageViewActivity.f8281M, "Pager adapter was unexpectedly null");
        MontagePlayQueue montagePlayQueue = montageViewActivity.f8274F;
        Preconditions.checkElementIndex(i, montagePlayQueue.a.size());
        MontageMessageInfo montageMessageInfo = (MontageMessageInfo) montagePlayQueue.a.get(i);
        AbstractMontageItemFragment e = montageViewActivity.f8281M.e(i);
        if (e != null) {
            e.ax();
        }
        Message message = montageMessageInfo.b;
        montageViewActivity.f8271C = montageViewActivity.f8290w.a(message.e.b);
        MontageProgressIndicatorController montageProgressIndicatorController = montageViewActivity.f8282N;
        long b = montageViewActivity.f8285r.b(message);
        montagePlayQueue = montageViewActivity.f8274F;
        Preconditions.checkElementIndex(i, montagePlayQueue.b.length);
        montageProgressIndicatorController.a(b, montagePlayQueue.b[i]);
        montageViewActivity.f8282N.b();
    }

    public static void m8249j(MontageViewActivity montageViewActivity) {
        montageViewActivity.f8279K.f();
        montageViewActivity.f8276H.setVisibility(0);
        montageViewActivity.m8250k();
        montageViewActivity.f8276H.post(new C12424(montageViewActivity));
        AbstractMontageItemFragment n = m8252n(montageViewActivity);
        if (n != null) {
            n.av();
        }
    }

    private void m8250k() {
        int id = this.f8276H.getId();
        if (this.f8280L == null) {
            this.f8280L = (ComposeFragment) kO_().a(id);
            if (this.f8280L == null) {
                this.f8280L = new ComposeFragment();
                kO_().a().b(id, this.f8280L).b();
            }
            if (this.f8271C == null) {
                throw new IllegalStateException("mReplyTargetThreadKey == null");
            }
            ThreadSummary a = this.f8284q.a(this.f8271C);
            if (a != null) {
                this.f8292y.a(a);
                if (this.f8280L != null) {
                    this.f8280L.m4974g(this.f8292y.a(BubbleType.NORMAL, SenderType.ME));
                }
                this.f8278J.f8301d = this.f8292y;
            }
            this.f8280L.m4951a(this.f8271C);
            this.f8280L.bt = new C12435(this);
        }
    }

    public static void m8251l(MontageViewActivity montageViewActivity) {
        View currentFocus = montageViewActivity.getCurrentFocus();
        if (currentFocus != null) {
            montageViewActivity.f8283p.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        AbstractMontageItemFragment n = m8252n(montageViewActivity);
        if (n != null) {
            n.at();
            montageViewActivity.f8279K.e();
            montageViewActivity.f8276H.setVisibility(8);
            n.aw();
        }
    }

    public static boolean m8248b(MontageViewActivity montageViewActivity, Fragment fragment) {
        return fragment.z() && fragment == m8252n(montageViewActivity);
    }

    @Nullable
    public static AbstractMontageItemFragment m8252n(MontageViewActivity montageViewActivity) {
        if (montageViewActivity.f8281M == null) {
            return null;
        }
        return montageViewActivity.f8281M.e(montageViewActivity.f8275G.k);
    }

    public static void m8253o(MontageViewActivity montageViewActivity) {
        if (montageViewActivity.f8281M != null) {
            montageViewActivity.f8282N.a();
            int i = montageViewActivity.f8275G.k + 1;
            if (i >= montageViewActivity.f8274F.a.size()) {
                montageViewActivity.finish();
            } else {
                montageViewActivity.f8275G.a(i, true);
            }
        }
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 727689772);
        super.onResume();
        this.f8282N.b();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 280316737, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1469058518);
        super.onPause();
        this.f8282N.a();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 279704243, a);
    }

    public void onBackPressed() {
        if (this.f8280L == null || !this.f8280L.au()) {
            Object obj;
            if (this.f8276H.getVisibility() == 0 && this.f8280L != null && this.f8280L.z()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                m8251l(this);
            } else {
                super.onBackPressed();
            }
        }
    }
}
