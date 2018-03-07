package com.facebook.messaging.composer.botcomposer;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.Intent;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.composer.botcomposer.BotComposerView.C02772;
import com.facebook.messaging.model.messagemetadata.QuickReplyItem;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import java.util.List;
import javax.inject.Inject;

/* compiled from: text_button */
public class QuickReplyController {
    private static final Class<?> f1762a = QuickReplyController.class;
    private final BaseFbBroadcastManager f1763b;
    public final QuickReplyAdapter f1764c;
    public final ViewStubHolder<RecyclerView> f1765d;
    public final C02772 f1766e;
    public final SelfRegistrableReceiverImpl f1767f;
    public final BotComposerAnalyticsLogger f1768g;
    public final MonotonicClock f1769h;
    public String f1770i;
    public long f1771j = 0;

    /* compiled from: text_button */
    class C02831 implements ActionReceiver {
        final /* synthetic */ QuickReplyController f1746a;

        C02831(QuickReplyController quickReplyController) {
            this.f1746a = quickReplyController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1696154330);
            List list = null;
            this.f1746a.f1770i = intent.getStringExtra("page_id");
            if (intent.hasExtra("action_list")) {
                list = intent.getParcelableArrayListExtra("action_list");
                this.f1746a.f1768g.m1700a(this.f1746a.f1770i, list.size());
            }
            QuickReplyController.m1724a(this.f1746a, list);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 377466581, a);
        }
    }

    /* compiled from: text_button */
    public class C02852 {
        public final /* synthetic */ QuickReplyController f1749a;

        /* compiled from: text_button */
        public class C02841 implements Runnable {
            final /* synthetic */ QuickReplyItem f1747a;
            final /* synthetic */ C02852 f1748b;

            public C02841(C02852 c02852, QuickReplyItem quickReplyItem) {
                this.f1748b = c02852;
                this.f1747a = quickReplyItem;
            }

            public void run() {
                this.f1748b.f1749a.f1768g.m1701a(this.f1747a.b != null ? this.f1747a.b.dbValue : "", this.f1748b.f1749a.f1769h.now() - this.f1748b.f1749a.f1771j);
                this.f1748b.f1749a.f1766e.m1704a(this.f1747a);
            }
        }

        C02852(QuickReplyController quickReplyController) {
            this.f1749a = quickReplyController;
        }
    }

    /* compiled from: text_button */
    class C02863 implements OnInflateListener<RecyclerView> {
        final /* synthetic */ QuickReplyController f1750a;

        C02863(QuickReplyController quickReplyController) {
            this.f1750a = quickReplyController;
        }

        public final void m1722a(View view) {
            RecyclerView recyclerView = (RecyclerView) view;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
            linearLayoutManager.b(0);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(this.f1750a.f1764c);
        }
    }

    /* compiled from: text_button */
    public class C02874 implements Runnable {
        final /* synthetic */ QuickReplyController f1751a;

        public C02874(QuickReplyController quickReplyController) {
            this.f1751a = quickReplyController;
        }

        public void run() {
            this.f1751a.f1771j = this.f1751a.f1769h.now();
        }
    }

    /* compiled from: text_button */
    public class AnimationEndListener implements AnimatorListener {
        final /* synthetic */ QuickReplyController f1760a;
        private final Runnable f1761b;

        public AnimationEndListener(QuickReplyController quickReplyController, Runnable runnable) {
            this.f1760a = quickReplyController;
            this.f1761b = runnable;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f1761b != null) {
                this.f1761b.run();
            }
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    @Inject
    public QuickReplyController(BaseFbBroadcastManager baseFbBroadcastManager, QuickReplyAdapterProvider quickReplyAdapterProvider, BotComposerAnalyticsLogger botComposerAnalyticsLogger, MonotonicClock monotonicClock, @Assisted ViewStubCompat viewStubCompat, @Assisted C02772 c02772) {
        this.f1763b = baseFbBroadcastManager;
        this.f1766e = c02772;
        this.f1765d = ViewStubHolder.a(viewStubCompat);
        this.f1768g = botComposerAnalyticsLogger;
        this.f1769h = monotonicClock;
        this.f1767f = this.f1763b.a().a("com.facebook.messaging.composer.QUICK_REPLY", new C02831(this)).a();
        this.f1764c = new QuickReplyAdapter(new C02852(this));
        this.f1765d.c = new C02863(this);
    }

    public static void m1724a(QuickReplyController quickReplyController, List list) {
        if (list == null || list.isEmpty()) {
            m1723a(quickReplyController, null);
            return;
        }
        Integer.valueOf(list.size());
        quickReplyController.f1764c.m1721a(list);
        final View a = quickReplyController.f1765d.a();
        final Runnable c02874 = new C02874(quickReplyController);
        a.setVisibility(4);
        a.setTranslationY((float) a.getMeasuredHeight());
        a.setVisibility(0);
        a.setClickable(false);
        a.animate().translationY(0.0f).setInterpolator(new DecelerateInterpolator(2.0f)).setDuration(300).setListener(new AnimationEndListener(quickReplyController, new Runnable(quickReplyController) {
            final /* synthetic */ QuickReplyController f1756c;

            public void run() {
                a.setClickable(true);
                if (c02874 != null) {
                    c02874.run();
                }
            }
        })).start();
    }

    public static void m1723a(QuickReplyController quickReplyController, final Runnable runnable) {
        if (quickReplyController.f1765d.d()) {
            final View a = quickReplyController.f1765d.a();
            final Runnable c02885 = new Runnable(quickReplyController) {
                final /* synthetic */ QuickReplyController f1753b;

                public void run() {
                    this.f1753b.f1764c.m1721a(null);
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            };
            int measuredHeight = a.getMeasuredHeight();
            a.setClickable(false);
            a.animate().translationY((float) measuredHeight).setInterpolator(new AccelerateInterpolator(2.0f)).setDuration(300).setListener(new AnimationEndListener(quickReplyController, new Runnable(quickReplyController) {
                final /* synthetic */ QuickReplyController f1759c;

                public void run() {
                    a.setVisibility(8);
                    if (c02885 != null) {
                        c02885.run();
                    }
                }
            })).start();
        }
    }
}
