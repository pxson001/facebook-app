package com.facebook.orca.threadview;

import android.content.Context;
import com.facebook.common.pillstub.PillViewStub;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import com.facebook.orca.threadview.abtest.ExperimentsForThreadViewExperimentsModule;
import com.facebook.orca.threadview.messagelist.MessageListHelper;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ultralight.Inject;
import javax.annotation.Nullable;

/* compiled from: max_names_count */
public class UnreadMessagesPillController {
    @Inject
    public Context f8147a;
    @Inject
    public QeAccessor f8148b;
    public MessageListHelper f8149c;
    private int f8150d;
    public int f8151e;
    private ThreadKey f8152f;
    public PillViewStub f8153g;

    public static UnreadMessagesPillController m8062a(InjectorLike injectorLike) {
        UnreadMessagesPillController unreadMessagesPillController = new UnreadMessagesPillController();
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike);
        unreadMessagesPillController.f8147a = (Context) injectorLike.getInstance(Context.class);
        unreadMessagesPillController.f8148b = qeAccessor;
        return unreadMessagesPillController;
    }

    public final void m8067a(@Nullable ThreadSummary threadSummary) {
        if (threadSummary == null || !threadSummary.a.equals(this.f8152f)) {
            this.f8153g.d();
        }
        if (m8066i() && threadSummary != null && threadSummary.n != 0 && threadSummary.a.b()) {
            if (this.f8153g.e) {
                m8063a(threadSummary.n);
            } else if (threadSummary.n <= 200) {
                this.f8150d = (int) threadSummary.n;
                this.f8152f = threadSummary.a;
                this.f8153g.a();
            }
        }
    }

    public final void m8070e() {
        this.f8153g.c();
    }

    public final boolean m8068a() {
        if (!m8066i()) {
            return false;
        }
        m8065h();
        if (m8064g()) {
            return false;
        }
        return this.f8148b.a(ExperimentsForThreadViewExperimentsModule.f8156c, false);
    }

    public final void m8069b() {
        this.f8153g.setPillText(this.f8147a.getString(2131231095, new Object[]{Integer.valueOf(this.f8150d)}));
    }

    public final void m8071f() {
        if (this.f8153g.e && m8064g()) {
            this.f8153g.c();
        }
    }

    private void m8063a(long j) {
        if (this.f8153g.e && j != 0) {
            long j2 = ((long) this.f8150d) + j;
            if (j2 > 200) {
                this.f8153g.c();
                return;
            }
            this.f8150d = (int) j2;
            m8069b();
            m8065h();
        }
    }

    private boolean m8064g() {
        if (this.f8150d > 0 && this.f8151e < this.f8149c.mo357e()) {
            return false;
        }
        return true;
    }

    private void m8065h() {
        if (this.f8150d <= 0) {
            this.f8151e = this.f8149c.mo356d() - 1;
            return;
        }
        int i = this.f8150d;
        for (int d = this.f8149c.mo356d() - 1; d >= 0; d--) {
            if (this.f8149c.mo335a(d) instanceof RowMessageItem) {
                i--;
                if (i <= 0) {
                    this.f8151e = d;
                    return;
                }
            }
        }
        this.f8151e = 0;
    }

    private boolean m8066i() {
        return this.f8148b.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForThreadViewExperimentsModule.f8155b, false);
    }
}
