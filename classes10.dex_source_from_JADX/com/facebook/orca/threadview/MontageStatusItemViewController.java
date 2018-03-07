package com.facebook.orca.threadview;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.ui.util.LayoutParamsUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.montage.annotations.MyMontageThreadKey;
import com.facebook.messaging.montage.model.MontageThreadInfo;
import com.facebook.orca.threadview.AbstractMontageViewerHelper.C10133;
import com.facebook.orca.threadview.montage.MontageViewActivity;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: messenger_customthreads_picker_save */
public class MontageStatusItemViewController {
    public boolean f7284a;
    private final Lazy<AddMontageViewerHelper> f7285b;
    public final Lazy<FbBroadcastManager> f7286c;
    private final Lazy<SecureContextHelper> f7287d;
    private final Lazy<TimeFormatUtil> f7288e;
    public final Lazy<Toaster> f7289f;
    private final Lazy<UserCache> f7290g;
    public final MontageStatusItemView f7291h;
    public final MontageThreadHelper f7292i;
    public final MontageThreadHelper f7293j;
    private final Provider<User> f7294k;
    @MyMontageThreadKey
    private final Provider<ThreadKey> f7295l;
    public SelfRegistrableReceiverImpl f7296m;
    private ThreadKey f7297n;
    public User f7298o;
    public final C10921 f7299p = new C10921(this);
    private final OnPreDrawListener f7300q = new C10932(this);

    /* compiled from: messenger_customthreads_picker_save */
    public class C10921 {
        public final /* synthetic */ MontageStatusItemViewController f7279a;

        C10921(MontageStatusItemViewController montageStatusItemViewController) {
            this.f7279a = montageStatusItemViewController;
        }
    }

    /* compiled from: messenger_customthreads_picker_save */
    class C10932 implements OnPreDrawListener {
        final /* synthetic */ MontageStatusItemViewController f7280a;

        C10932(MontageStatusItemViewController montageStatusItemViewController) {
            this.f7280a = montageStatusItemViewController;
        }

        public boolean onPreDraw() {
            this.f7280a.f7291h.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.f7280a.f7291h.getLayoutParams() != null) {
                LayoutParamsUtil.b(this.f7280a.f7291h, 0);
            }
            return true;
        }
    }

    /* compiled from: messenger_customthreads_picker_save */
    public class C10954 implements ActionReceiver {
        final /* synthetic */ MontageStatusItemViewController f7283a;

        public C10954(MontageStatusItemViewController montageStatusItemViewController) {
            this.f7283a = montageStatusItemViewController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1075099223);
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("updated_users");
            if (!(parcelableArrayListExtra == null || this.f7283a.f7298o == null || !parcelableArrayListExtra.contains(this.f7283a.f7298o.T))) {
                MontageStatusItemViewController.m6948a(this.f7283a, this.f7283a.f7298o.T);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 2040053542, a);
        }
    }

    @Inject
    public MontageStatusItemViewController(@Assisted MontageStatusItemView montageStatusItemView, Lazy<AddMontageViewerHelper> lazy, Lazy<SecureContextHelper> lazy2, Lazy<TimeFormatUtil> lazy3, Lazy<Toaster> lazy4, Lazy<UserCache> lazy5, MontageThreadHelper montageThreadHelper, MontageThreadHelper montageThreadHelper2, Provider<User> provider, Lazy<FbBroadcastManager> lazy6, @MyMontageThreadKey Provider<ThreadKey> provider2) {
        this.f7291h = montageStatusItemView;
        this.f7285b = lazy;
        this.f7289f = lazy4;
        this.f7292i = montageThreadHelper;
        this.f7293j = montageThreadHelper2;
        this.f7294k = provider;
        this.f7287d = lazy2;
        this.f7288e = lazy3;
        this.f7290g = lazy5;
        this.f7286c = lazy6;
        this.f7295l = provider2;
        this.f7292i.m6957a((ThreadKey) this.f7295l.get());
    }

    final void m6952c() {
        if (this.f7298o == null) {
            BLog.a(MontageStatusItemViewController.class, "Add other user to montage without user set");
            return;
        }
        boolean z;
        final User user = this.f7298o;
        AddMontageViewerHelper addMontageViewerHelper = (AddMontageViewerHelper) this.f7285b.get();
        addMontageViewerHelper.f6759a = new Object(this) {
            public final /* synthetic */ MontageStatusItemViewController f7282b;
        };
        Context context = this.f7291h.getContext();
        UserKey userKey = user.T;
        Preconditions.checkNotNull(userKey);
        if (user == null || userKey.equals(user.T)) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        Operation a = BlueServiceOperationFactoryDetour.a(addMontageViewerHelper.f6760b, addMontageViewerHelper.mo239a(), addMontageViewerHelper.mo238a(userKey.b(), user), ErrorPropagation.BY_ERROR_CODE, addMontageViewerHelper.mo240b(), -453388366);
        a.a(new DialogBasedProgressIndicator(context, addMontageViewerHelper.mo241c()));
        Futures.a(a.a(), new C10133(addMontageViewerHelper, userKey), addMontageViewerHelper.f6761c);
    }

    final void m6949a(View view) {
        m6946a(this.f7297n);
    }

    final void m6951b(View view) {
        m6946a((ThreadKey) this.f7295l.get());
    }

    public final void m6950a(User user, ThreadKey threadKey) {
        this.f7297n = threadKey;
        this.f7298o = user;
        this.f7293j.m6957a(this.f7297n);
        m6947a(this, this.f7298o);
    }

    public static void m6947a(MontageStatusItemViewController montageStatusItemViewController, User user) {
        String str = null;
        boolean z = true;
        boolean a = montageStatusItemViewController.f7292i.m6959a();
        boolean a2 = montageStatusItemViewController.f7293j.m6959a();
        montageStatusItemViewController.f7291h.getViewTreeObserver().removeOnPreDrawListener(montageStatusItemViewController.f7300q);
        if (a || a2) {
            boolean z2;
            String str2;
            boolean z3;
            String str3;
            if (montageStatusItemViewController.f7291h.getLayoutParams() != null) {
                LayoutParamsUtil.b(montageStatusItemViewController.f7291h, -2);
            }
            if (a) {
                MontageThreadInfo montageThreadInfo = montageStatusItemViewController.f7292i.f7305d;
                montageStatusItemViewController.f7291h.m6936a((User) montageStatusItemViewController.f7294k.get());
                MontageStatusItemView montageStatusItemView = montageStatusItemViewController.f7291h;
                ThreadSummary threadSummary = montageThreadInfo.a;
                MessagesCollection messagesCollection = montageThreadInfo.b;
                montageStatusItemView.f7264c.setVisibility(0);
                montageStatusItemView.f7264c.a(threadSummary, messagesCollection);
                if (user.N) {
                    montageStatusItemViewController.f7291h.m6935a();
                    z2 = false;
                    str2 = null;
                } else {
                    str = montageStatusItemViewController.f7291h.getResources().getString(2131240926, new Object[]{user.e.j()});
                    str2 = montageStatusItemViewController.f7291h.getResources().getString(2131240927, new Object[]{user.e.j()});
                    montageStatusItemViewController.f7291h.m6942c();
                    montageStatusItemViewController.f7291h.m6937a(str, str2);
                    z2 = true;
                }
            } else {
                montageStatusItemViewController.f7291h.m6942c();
                montageStatusItemViewController.f7291h.m6938b();
                z2 = false;
                str2 = null;
            }
            if (a2) {
                boolean z4;
                String str4;
                MontageThreadInfo montageThreadInfo2 = montageStatusItemViewController.f7293j.f7305d;
                montageStatusItemViewController.f7291h.m6940b(user);
                montageStatusItemViewController.f7291h.m6939b(montageThreadInfo2.a, montageThreadInfo2.b);
                if (str == null && montageStatusItemViewController.f7293j.m6960b()) {
                    long c = montageStatusItemViewController.f7293j.m6961c();
                    if (c > 0) {
                        str = montageStatusItemViewController.f7291h.getResources().getString(2131240925);
                        str2 = ((TimeFormatUtil) montageStatusItemViewController.f7288e.get()).a(TimeFormatStyle.STREAM_RELATIVE_STYLE, c);
                        montageStatusItemViewController.f7291h.m6941b(str, str2);
                        z4 = a;
                        str4 = str2;
                        z3 = z4;
                        z4 = z2;
                        str3 = str;
                        str = str4;
                        a = z3;
                        z3 = z4;
                    }
                }
                str4 = str2;
                z3 = false;
                z4 = z2;
                str3 = str;
                str = str4;
                a = z3;
                z3 = z4;
            } else {
                montageStatusItemViewController.f7291h.m6944e();
                montageStatusItemViewController.f7291h.m6943d();
                a = false;
                str3 = str;
                str = str2;
                z3 = false;
            }
            MontageStatusItemView montageStatusItemView2 = montageStatusItemViewController.f7291h;
            montageStatusItemView2.f7274m = a;
            montageStatusItemView2.invalidate();
            MontageStatusItemView montageStatusItemView3 = montageStatusItemViewController.f7291h;
            montageStatusItemView3.f7275n = z3;
            montageStatusItemView3.invalidate();
            if (str3 == null || str == null) {
                if (str3 == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkArgument(z3, "Expected to have both primary AND secondary text");
                if (str != null) {
                    z = false;
                }
                Preconditions.checkArgument(z, "Expected to have both primary AND secondary text");
                montageStatusItemViewController.f7291h.m6945f();
            }
        } else if (montageStatusItemViewController.f7291h.getLayoutParams() == null) {
            montageStatusItemViewController.f7291h.getViewTreeObserver().addOnPreDrawListener(montageStatusItemViewController.f7300q);
        } else {
            LayoutParamsUtil.b(montageStatusItemViewController.f7291h, 0);
        }
    }

    public static void m6948a(MontageStatusItemViewController montageStatusItemViewController, UserKey userKey) {
        User a = ((UserCache) montageStatusItemViewController.f7290g.get()).a(userKey);
        if (a != null) {
            montageStatusItemViewController.f7298o = a;
            montageStatusItemViewController.m6950a(montageStatusItemViewController.f7298o, montageStatusItemViewController.f7297n);
        }
    }

    private void m6946a(ThreadKey threadKey) {
        Intent intent = new Intent(this.f7291h.getContext(), MontageViewActivity.class);
        intent.putExtra("thread_key", threadKey);
        ((SecureContextHelper) this.f7287d.get()).a(intent, this.f7291h.getContext());
    }
}
