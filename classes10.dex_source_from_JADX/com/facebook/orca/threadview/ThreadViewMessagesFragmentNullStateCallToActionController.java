package com.facebook.orca.threadview;

import android.content.Context;
import android.support.v7.internal.widget.ViewStubCompat;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.common.calltoaction.CTAPostbackActionHandler;
import com.facebook.messaging.business.common.calltoaction.model.CallToAction;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.C11592;
import com.facebook.user.model.User;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import com.facebook.widget.text.BetterButton;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: megaphone_last_dismissed */
public class ThreadViewMessagesFragmentNullStateCallToActionController {
    public final CTAPostbackActionHandler f7866a;
    private final GatekeeperStoreImpl f7867b;
    private ViewStubHolder<View> f7868c;
    public BetterButton f7869d;
    public C11592 f7870e;
    @Nullable
    private ImmutableList<CallToAction> f7871f;
    public ThreadKey f7872g;

    /* compiled from: megaphone_last_dismissed */
    class C11881 implements OnInflateListener<View> {
        final /* synthetic */ ThreadViewMessagesFragmentNullStateCallToActionController f7863a;

        C11881(ThreadViewMessagesFragmentNullStateCallToActionController threadViewMessagesFragmentNullStateCallToActionController) {
            this.f7863a = threadViewMessagesFragmentNullStateCallToActionController;
        }

        public final void m7811a(View view) {
            this.f7863a.f7869d = (BetterButton) view.findViewById(2131564998);
            this.f7863a.f7866a;
        }
    }

    private static ThreadViewMessagesFragmentNullStateCallToActionController m7816b(InjectorLike injectorLike) {
        return new ThreadViewMessagesFragmentNullStateCallToActionController((Context) injectorLike.getInstance(Context.class), CTAPostbackActionHandler.b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ThreadViewMessagesFragmentNullStateCallToActionController(Context context, CTAPostbackActionHandler cTAPostbackActionHandler, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f7866a = cTAPostbackActionHandler;
        this.f7867b = gatekeeperStoreImpl;
    }

    public static ThreadViewMessagesFragmentNullStateCallToActionController m7812a(InjectorLike injectorLike) {
        return m7816b(injectorLike);
    }

    public final boolean m7823a() {
        return this.f7867b.a(271, false) && m7820e() != null;
    }

    public final void m7822a(ThreadKey threadKey, @Nullable User user) {
        this.f7872g = threadKey;
        this.f7871f = null;
        if (this.f7867b.a(271, false) && user != null) {
            this.f7871f = user.Q;
        }
        this.f7866a;
    }

    public final boolean m7824b() {
        return this.f7868c != null && this.f7868c.d();
    }

    public final void m7821a(ViewStubCompat viewStubCompat) {
        this.f7868c = ViewStubHolder.a(viewStubCompat);
        this.f7868c.c = new C11881(this);
    }

    public static void m7818c(ThreadViewMessagesFragmentNullStateCallToActionController threadViewMessagesFragmentNullStateCallToActionController) {
        threadViewMessagesFragmentNullStateCallToActionController.m7819d();
        final CallToAction e = threadViewMessagesFragmentNullStateCallToActionController.m7820e();
        if (e != null && threadViewMessagesFragmentNullStateCallToActionController.f7869d != null) {
            threadViewMessagesFragmentNullStateCallToActionController.f7869d.setText(e.b());
            threadViewMessagesFragmentNullStateCallToActionController.f7869d.setOnClickListener(new OnClickListener(threadViewMessagesFragmentNullStateCallToActionController) {
                final /* synthetic */ ThreadViewMessagesFragmentNullStateCallToActionController f7865b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1107882290);
                    this.f7865b.f7866a.a(e, this.f7865b.f7872g, null);
                    Logger.a(2, EntryType.UI_INPUT_END, -848990044, a);
                }
            });
        }
    }

    private void m7819d() {
        CallToAction e = m7820e();
        if (this.f7868c == null) {
            return;
        }
        if (e != null && m7824b()) {
            return;
        }
        if (e != null || m7824b()) {
            if (e != null) {
                this.f7868c.f();
            } else {
                this.f7868c.e();
            }
            if (this.f7870e != null) {
                this.f7870e.m7460a();
            }
        }
    }

    @Nullable
    private CallToAction m7820e() {
        if (this.f7871f == null || this.f7871f.isEmpty()) {
            return null;
        }
        return (CallToAction) this.f7871f.get(0);
    }
}
