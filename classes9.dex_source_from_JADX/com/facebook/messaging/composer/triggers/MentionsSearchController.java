package com.facebook.messaging.composer.triggers;

import android.support.v7.internal.widget.ViewStubCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.FutureUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.Assisted;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.bots.model.BotCommand;
import com.facebook.messaging.bots.service.BotCommandsGraphQLFetcher;
import com.facebook.messaging.cache.ThreadParticipantUtils;
import com.facebook.messaging.composer.edit.MessageComposerEditor;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.orca.compose.TwoLineComposerView.11;
import com.facebook.orca.compose.TwoLineComposerView.12;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.user.model.User;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import com.facebook.widget.text.BetterEditTextView.OnSelectionChangedListener;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: messenger_inbox_item_title */
public class MentionsSearchController {
    public static final String f9876a = MentionsSearchController.class.getSimpleName();
    private static final SpringConfig f9877b = SpringConfig.b(16.0d, 2.0d);
    private List<User> f9878A;
    public final ViewStubHolder<MentionsSearchResultsView> f9879c;
    public final DefaultAndroidThreadUtil f9880d;
    public final Executor f9881e;
    public final ListeningExecutorService f9882f;
    private final MessageComposerEditor f9883g;
    private final SpringSystem f9884h;
    private final BotCommandsGraphQLFetcher f9885i;
    private final ThreadParticipantUtils f9886j;
    public final MessagingPerformanceLogger f9887k;
    public final Spring f9888l;
    private ListenableFuture<ImmutableList<BotCommand>> f9889m;
    public ListenableFuture<ImmutableList<User>> f9890n;
    private FutureCallback<ImmutableList<BotCommand>> f9891o;
    public FutureCallback<ImmutableList<User>> f9892p;
    public 11 f9893q;
    @GuardedBy("this")
    public 12 f9894r;
    @GuardedBy("this")
    @Nullable
    public ThreadKey f9895s;
    @Nullable
    public String f9896t;
    private boolean f9897u;
    private boolean f9898v;
    private boolean f9899w;
    public boolean f9900x;
    public int f9901y;
    private List<BotCommand> f9902z;

    /* compiled from: messenger_inbox_item_title */
    public class C11491 implements OnInflateListener<MentionsSearchResultsView> {
        public final /* synthetic */ MentionsSearchController f9868a;

        /* compiled from: messenger_inbox_item_title */
        public class C11481 {
            public final /* synthetic */ C11491 f9867a;

            C11481(C11491 c11491) {
                this.f9867a = c11491;
            }

            public final void m10432a(User user) {
                MentionsSearchController mentionsSearchController = this.f9867a.f9868a;
                Editable o = MentionsSearchController.m10456o(mentionsSearchController);
                o.replace(0, o.length(), user.h() + ' ');
                MentionsSearchController.m10447c(mentionsSearchController, false);
            }
        }

        C11491(MentionsSearchController mentionsSearchController) {
            this.f9868a = mentionsSearchController;
        }

        public final void m10433a(View view) {
            ((MentionsSearchResultsView) view).f9915a.f9913e = new C11481(this);
        }
    }

    /* compiled from: messenger_inbox_item_title */
    class C11502 implements OnSelectionChangedListener {
        final /* synthetic */ MentionsSearchController f9869a;

        C11502(MentionsSearchController mentionsSearchController) {
            this.f9869a = mentionsSearchController;
        }

        public final void m10434a() {
            MentionsSearchController.m10443a(this.f9869a, MentionsSearchController.m10456o(this.f9869a));
        }
    }

    /* compiled from: messenger_inbox_item_title */
    class C11513 implements TextWatcher {
        final /* synthetic */ MentionsSearchController f9870a;

        C11513(MentionsSearchController mentionsSearchController) {
            this.f9870a = mentionsSearchController;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f9870a.f9887k.e("mentions_search");
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            MentionsSearchController.m10443a(this.f9870a, (CharSequence) editable);
            this.f9870a.f9887k.d();
        }
    }

    /* compiled from: messenger_inbox_item_title */
    abstract class QueryFutureCallback<V> implements FutureCallback<ImmutableList<V>> {
        final /* synthetic */ MentionsSearchController f9871b;

        abstract void mo404a(ImmutableList<V> immutableList);

        public QueryFutureCallback(MentionsSearchController mentionsSearchController) {
            this.f9871b = mentionsSearchController;
        }

        public void onSuccess(@Nullable Object obj) {
            Object obj2;
            ImmutableList immutableList = (ImmutableList) obj;
            MentionsSearchController mentionsSearchController = this.f9871b;
            if (StringUtil.a(MentionsSearchController.m10456o(mentionsSearchController).toString(), mentionsSearchController.f9896t)) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                String str = MentionsSearchController.f9876a;
                return;
            }
            int i;
            str = MentionsSearchController.f9876a;
            if (immutableList == null) {
                i = 0;
            } else {
                i = immutableList.size();
            }
            Integer.valueOf(i);
            MentionsSearchResultsAdapter j = MentionsSearchController.m10453j(this.f9871b);
            mo404a(immutableList);
            if (!MentionsSearchController.m10454l(this.f9871b) && j.aZ_() == 0) {
                MentionsSearchController.m10447c(this.f9871b, false);
            } else if (!MentionsSearchController.m10455m(this.f9871b)) {
                ((MentionsSearchResultsView) this.f9871b.f9879c.a()).m10472a();
                MentionsSearchController.m10447c(this.f9871b, true);
            }
        }

        public void onFailure(Throwable th) {
            BLog.b(MentionsSearchController.f9876a, "Failed to load search result", th);
            MentionsSearchController.m10444a(this.f9871b, (List) RegularImmutableList.a);
            if (!MentionsSearchController.m10454l(this.f9871b)) {
                MentionsSearchController.m10447c(this.f9871b, false);
            }
        }
    }

    /* compiled from: messenger_inbox_item_title */
    class C11524 extends QueryFutureCallback<BotCommand> {
        final /* synthetic */ MentionsSearchController f9872a;

        C11524(MentionsSearchController mentionsSearchController) {
            this.f9872a = mentionsSearchController;
            super(mentionsSearchController);
        }

        final void mo404a(ImmutableList<BotCommand> immutableList) {
            MentionsSearchController.m10444a(this.f9872a, (List) immutableList);
        }
    }

    /* compiled from: messenger_inbox_item_title */
    public class C11535 extends QueryFutureCallback<User> {
        final /* synthetic */ MentionsSearchController f9873a;

        public C11535(MentionsSearchController mentionsSearchController) {
            this.f9873a = mentionsSearchController;
            super(mentionsSearchController);
        }

        final void mo404a(ImmutableList<User> immutableList) {
            MentionsSearchController.m10445b(this.f9873a, immutableList);
        }
    }

    /* compiled from: messenger_inbox_item_title */
    public class C11546 implements Callable<ImmutableList<User>> {
        final /* synthetic */ MentionsSearchController f9874a;

        public C11546(MentionsSearchController mentionsSearchController) {
            this.f9874a = mentionsSearchController;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object call() {
            /*
            r5 = this;
            r1 = r5.f9874a;
            monitor-enter(r1);
            r0 = r5.f9874a;	 Catch:{ all -> 0x0030 }
            r0 = r0.f9895s;	 Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x002d;
        L_0x0009:
            r0 = r5.f9874a;	 Catch:{ all -> 0x0030 }
            r0 = r0.f9894r;	 Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x002d;
        L_0x000f:
            r0 = r5.f9874a;	 Catch:{ all -> 0x0030 }
            r2 = r5.f9874a;	 Catch:{ all -> 0x0030 }
            r2 = r2.f9896t;	 Catch:{ all -> 0x0030 }
            r0 = com.facebook.messaging.composer.triggers.MentionsSearchController.m10442a(r0, r2);	 Catch:{ all -> 0x0030 }
            r2 = r5.f9874a;	 Catch:{ all -> 0x0030 }
            r3 = r5.f9874a;	 Catch:{ all -> 0x0030 }
            r3 = r3.f9894r;	 Catch:{ all -> 0x0030 }
            r4 = r5.f9874a;	 Catch:{ all -> 0x0030 }
            r4 = r4.f9895s;	 Catch:{ all -> 0x0030 }
            r3 = r3.a(r4);	 Catch:{ all -> 0x0030 }
            r0 = com.facebook.messaging.composer.triggers.MentionsSearchController.m10441a(r2, r3, r0);	 Catch:{ all -> 0x0030 }
            monitor-exit(r1);	 Catch:{ all -> 0x0030 }
        L_0x002c:
            return r0;
        L_0x002d:
            monitor-exit(r1);	 Catch:{ all -> 0x0030 }
            r0 = 0;
            goto L_0x002c;
        L_0x0030:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0030 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.composer.triggers.MentionsSearchController.6.call():java.lang.Object");
        }
    }

    /* compiled from: messenger_inbox_item_title */
    class TranslationSpringListener extends SimpleSpringListener {
        final /* synthetic */ MentionsSearchController f9875a;

        public final void m10440c(Spring spring) {
            if (spring.i != 0.0d) {
                this.f9875a.f9879c.f();
            }
        }

        public TranslationSpringListener(MentionsSearchController mentionsSearchController) {
            this.f9875a = mentionsSearchController;
        }

        public final void m10438a(Spring spring) {
            LayoutParams layoutParams = (LayoutParams) ((MentionsSearchResultsView) this.f9875a.f9879c.a()).getLayoutParams();
            layoutParams.height = Math.round((float) spring.d());
            layoutParams.weight = 0.0f;
            ((MentionsSearchResultsView) this.f9875a.f9879c.a()).requestLayout();
        }

        public final void m10439b(Spring spring) {
            if (spring.i == 0.0d) {
                this.f9875a.f9879c.e();
                MentionsSearchController.m10445b(this.f9875a, null);
                MentionsSearchController.m10444a(this.f9875a, null);
                return;
            }
            LayoutParams layoutParams = (LayoutParams) ((MentionsSearchResultsView) this.f9875a.f9879c.a()).getLayoutParams();
            layoutParams.height = 0;
            layoutParams.weight = 1.0f;
            ((MentionsSearchResultsView) this.f9875a.f9879c.a()).requestLayout();
        }
    }

    @Inject
    public MentionsSearchController(DefaultAndroidThreadUtil defaultAndroidThreadUtil, Executor executor, ListeningExecutorService listeningExecutorService, @Assisted ViewStubCompat viewStubCompat, @Assisted MessageComposerEditor messageComposerEditor, SpringSystem springSystem, BotCommandsGraphQLFetcher botCommandsGraphQLFetcher, ThreadParticipantUtils threadParticipantUtils, MessagingPerformanceLogger messagingPerformanceLogger) {
        this.f9880d = defaultAndroidThreadUtil;
        this.f9881e = executor;
        this.f9882f = listeningExecutorService;
        this.f9879c = ViewStubHolder.a(viewStubCompat);
        this.f9879c.c = new C11491(this);
        this.f9883g = messageComposerEditor;
        this.f9884h = springSystem;
        this.f9885i = botCommandsGraphQLFetcher;
        this.f9886j = threadParticipantUtils;
        this.f9887k = messagingPerformanceLogger;
        Spring a = this.f9884h.a().a(f9877b);
        a.c = true;
        this.f9888l = a.l().a(new TranslationSpringListener(this));
        this.f9883g.f9787c.d = new C11502(this);
        this.f9883g.m10357a(new C11513(this));
    }

    public final int m10457a() {
        if (this.f9879c.d()) {
            return ((MentionsSearchResultsView) this.f9879c.a()).getMeasuredHeight();
        }
        return 0;
    }

    public final synchronized void m10459a(12 12) {
        this.f9894r = 12;
    }

    public final synchronized void m10458a(@Nullable ThreadKey threadKey) {
        this.f9895s = threadKey;
        m10446b(!this.f9886j.m10159a(this.f9895s));
    }

    private void m10446b(boolean z) {
        this.f9900x = z;
    }

    public final void m10460a(boolean z) {
        this.f9880d.a();
        this.f9898v = z;
        m10449e();
    }

    public static void m10447c(MentionsSearchController mentionsSearchController, boolean z) {
        mentionsSearchController.f9897u = z;
        mentionsSearchController.m10449e();
    }

    private void m10449e() {
        this.f9880d.a();
        if (this.f9897u && this.f9898v) {
            this.f9888l.b((double) this.f9901y);
            if (this.f9893q != null) {
                this.f9893q.a();
                return;
            }
            return;
        }
        m10450f();
        this.f9891o = null;
        this.f9892p = null;
        this.f9888l.b(0.0d);
        if (this.f9893q != null) {
            this.f9893q.b();
        }
    }

    private void m10450f() {
        this.f9896t = null;
        if (this.f9889m != null) {
            this.f9889m.cancel(true);
            this.f9889m = null;
        }
        if (this.f9890n != null) {
            this.f9890n.cancel(true);
            this.f9890n = null;
        }
    }

    public static void m10443a(MentionsSearchController mentionsSearchController, CharSequence charSequence) {
        int i = 0;
        if (charSequence != null) {
            String trim = charSequence.toString().trim();
            if (!trim.isEmpty() && (!mentionsSearchController.f9900x || trim.codePointAt(0) == 64)) {
                i = 1;
            }
        }
        if (i == 0) {
            m10447c(mentionsSearchController, false);
        } else {
            mentionsSearchController.m10448c(charSequence);
        }
    }

    private void m10448c(CharSequence charSequence) {
        this.f9880d.a();
        String charSequence2 = charSequence.toString();
        Preconditions.checkArgument(!StringUtil.c(charSequence2));
        if (!StringUtil.a(charSequence2, this.f9896t)) {
            this.f9899w = true;
            m10450f();
            this.f9896t = charSequence2;
            m10451g();
            this.f9880d.a();
            if (this.f9892p == null) {
                this.f9892p = new C11535(this);
            }
            this.f9890n = this.f9882f.a(new C11546(this));
            Futures.a(this.f9890n, this.f9892p, this.f9881e);
            this.f9899w = false;
        }
    }

    private void m10451g() {
        this.f9880d.a();
        if (this.f9891o == null) {
            this.f9891o = new C11524(this);
        }
        synchronized (this) {
            this.f9889m = this.f9885i.m8631a(this.f9896t, this.f9895s);
        }
        Futures.a(this.f9889m, this.f9891o, this.f9881e);
    }

    public static void m10444a(MentionsSearchController mentionsSearchController, List list) {
        mentionsSearchController.f9902z = list;
        mentionsSearchController.m10452i();
    }

    public static void m10445b(MentionsSearchController mentionsSearchController, List list) {
        mentionsSearchController.f9878A = list;
        mentionsSearchController.m10452i();
    }

    private void m10452i() {
        if (!m10454l(this)) {
            m10453j(this).m10467a(this.f9902z, this.f9878A);
        }
    }

    public static MentionsSearchResultsAdapter m10453j(MentionsSearchController mentionsSearchController) {
        return ((MentionsSearchResultsView) mentionsSearchController.f9879c.a()).f9915a;
    }

    @Nullable
    public static String m10442a(MentionsSearchController mentionsSearchController, String str) {
        if (!mentionsSearchController.f9900x) {
            return str;
        }
        int indexOf = str.indexOf(64);
        if (indexOf < 0) {
            return null;
        }
        return str.substring(indexOf + 1);
    }

    static /* synthetic */ ImmutableList m10441a(MentionsSearchController mentionsSearchController, ImmutableList immutableList, String str) {
        ImmutableList immutableList2;
        if (str == null) {
            immutableList2 = null;
        } else {
            Builder builder = ImmutableList.builder();
            CharSequence toLowerCase = str.toLowerCase();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                User user = (User) immutableList.get(i);
                if (user.j().toLowerCase().contains(toLowerCase)) {
                    builder.c(user);
                }
            }
            immutableList2 = builder.b();
        }
        return immutableList2;
    }

    public static boolean m10454l(MentionsSearchController mentionsSearchController) {
        if (!(mentionsSearchController.f9899w || m10455m(mentionsSearchController))) {
            Object obj = (mentionsSearchController.f9890n == null || mentionsSearchController.f9890n.isDone() || FutureUtils.c(mentionsSearchController.f9890n)) ? null : 1;
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean m10455m(MentionsSearchController mentionsSearchController) {
        return (mentionsSearchController.f9889m == null || mentionsSearchController.f9889m.isDone() || FutureUtils.c(mentionsSearchController.f9889m)) ? false : true;
    }

    public static Editable m10456o(MentionsSearchController mentionsSearchController) {
        return mentionsSearchController.f9883g.m10355a();
    }
}
