package com.facebook.messaging.inbox2.sharing;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.inbox2.sharing.ShareFlowExperiment.ShareFlowType;
import com.facebook.messaging.send.common.SendResult;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.user.model.User;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mPinId */
public class ShareFlowSelectorView extends CustomFrameLayout {
    @Inject
    public QeAccessor f11346a;
    LayoutInflater f11347b;
    public UserSelectionListener f11348c;
    private ShareFlowType f11349d;
    private boolean f11350e;
    @Nullable
    private QuickShareSuggestionsView f11351f;
    @Nullable
    private TextView f11352g;

    /* compiled from: mPinId */
    class C12511 implements OnClickListener {
        final /* synthetic */ ShareFlowSelectorView f11343a;

        C12511(ShareFlowSelectorView shareFlowSelectorView) {
            this.f11343a = shareFlowSelectorView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1445176531);
            if (this.f11343a.f11348c != null) {
                this.f11343a.f11348c.mo433a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -261897346, a);
        }
    }

    /* compiled from: mPinId */
    class C12522 implements UserSelectionListener {
        final /* synthetic */ ShareFlowSelectorView f11344a;

        C12522(ShareFlowSelectorView shareFlowSelectorView) {
            this.f11344a = shareFlowSelectorView;
        }

        public final void mo434a(User user, FutureCallback<SendResult> futureCallback) {
            if (this.f11344a.f11348c != null) {
                this.f11344a.f11348c.mo434a(user, futureCallback);
            }
        }

        public final void mo433a() {
            if (this.f11344a.f11348c != null) {
                this.f11344a.f11348c.mo433a();
            }
        }
    }

    private static <T extends View> void m11946a(Class<T> cls, T t) {
        m11947a((Object) t, t.getContext());
    }

    private static void m11947a(Object obj, Context context) {
        ((ShareFlowSelectorView) obj).f11346a = (QeAccessor) QeInternalImplMethodAutoProvider.a(FbInjector.get(context));
    }

    public ShareFlowSelectorView(Context context) {
        super(context);
        m11948b();
    }

    public ShareFlowSelectorView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m11948b();
    }

    public ShareFlowSelectorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11948b();
    }

    private void m11948b() {
        m11946a(ShareFlowSelectorView.class, (View) this);
        this.f11347b = LayoutInflater.from(getContext());
    }

    private void m11945a(QeAccessor qeAccessor) {
        this.f11346a = qeAccessor;
    }

    public void setListener(UserSelectionListener userSelectionListener) {
        this.f11348c = userSelectionListener;
    }

    public final void m11953a() {
        if (this.f11350e) {
            m11952h();
        } else {
            m11949e();
        }
    }

    public int getShareViewHeight() {
        switch (this.f11349d) {
            case top_contacts_heads:
                return getResources().getDimensionPixelSize(2131433610);
            default:
                return getResources().getDimensionPixelSize(2131433615);
        }
    }

    public void setSendButtonText(CharSequence charSequence) {
        if (this.f11352g != null) {
            this.f11352g.setText(charSequence);
        }
    }

    private void m11949e() {
        this.f11350e = true;
        this.f11349d = (ShareFlowType) this.f11346a.a(Liveness.Live, ExposureLogging.On, ExperimentsForMessagingInbox2SharingModule.f11307a, ShareFlowType.class, ShareFlowType.send_button);
        switch (this.f11349d) {
            case top_contacts_heads:
                m11951g();
                return;
            default:
                m11950f();
                return;
        }
    }

    private void m11950f() {
        this.f11347b.inflate(2130904887, this);
        this.f11352g = (TextView) c(2131563114);
        this.f11352g.setOnClickListener(new C12511(this));
    }

    private void m11951g() {
        this.f11347b.inflate(2130904874, this);
        this.f11351f = (QuickShareSuggestionsView) c(2131563099);
        this.f11351f.setListener(new C12522(this));
    }

    private void m11952h() {
        if (this.f11351f != null) {
            this.f11351f.m11941a();
        }
    }
}
