package com.facebook.places.checkin.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.megaphone.Megaphone.OnDismissListener;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.toaster.ClickableToast;
import com.facebook.ui.toaster.ClickableToastBuilder;
import com.facebook.uicontrib.error.AlertView;
import com.facebook.widget.LazyView;
import com.facebook.widget.refreshableview.ConnectionRetrySnackbarView;
import javax.inject.Inject;

/* compiled from: checkin_tap */
public class CheckinNiemAlertViewImpl extends BaseCheckinNiemUI {
    private Context f18069d;
    private final Lazy<ClickableToastBuilder> f18070e;
    public ClickableToast f18071f;
    public OnClickListener f18072g;

    /* compiled from: checkin_tap */
    class C19501 implements OnClickListener {
        final /* synthetic */ CheckinNiemAlertViewImpl f18068a;

        C19501(CheckinNiemAlertViewImpl checkinNiemAlertViewImpl) {
            this.f18068a = checkinNiemAlertViewImpl;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -252712258);
            if (this.f18068a.f18071f != null) {
                this.f18068a.f18071f.b();
            }
            this.f18068a.f18072g.onClick(view);
            Logger.a(2, EntryType.UI_INPUT_END, 800600316, a);
        }
    }

    @Inject
    public CheckinNiemAlertViewImpl(@Assisted LazyView lazyView, @Assisted String str, Context context, Lazy<ClickableToastBuilder> lazy) {
        super(lazyView, str, context.getResources());
        this.f18069d = context;
        this.b = str;
        this.f18070e = lazy;
    }

    public final boolean mo1074a(OnClickListener onClickListener, OnDismissListener onDismissListener) {
        this.f18072g = onClickListener;
        AlertView alertView = (AlertView) mo1075b();
        if (alertView == null) {
            return false;
        }
        alertView.setPrimaryButtonText(m22017a(2131235307, new String[0]));
        return true;
    }

    public final void mo1072a() {
        ((AlertView) mo1075b()).setVisibility(8);
    }

    public final void mo1073a(OnClickListener onClickListener) {
        AlertView alertView = (AlertView) mo1075b();
        alertView.setVisibility(0);
        alertView.setMessage(m22017a(2131235172, new String[0]));
        alertView.setPrimaryButtonText(m22017a(2131235308, new String[0]));
        alertView.setPrimaryButtonClickListener(onClickListener);
    }

    public final void mo1076b(OnClickListener onClickListener) {
        AlertView alertView = (AlertView) mo1075b();
        alertView.setVisibility(0);
        alertView.setMessage(m22017a(2131235302, new String[0]));
        alertView.setPrimaryButtonClickListener(onClickListener);
    }

    public final void mo1077c(OnClickListener onClickListener) {
        AlertView alertView = (AlertView) mo1075b();
        alertView.setVisibility(0);
        alertView.setMessage(m22017a(2131235301, new String[0]));
        alertView.setPrimaryButtonText(m22017a(2131235306, new String[0]));
        alertView.setPrimaryButtonClickListener(onClickListener);
    }

    public final void mo1078d(OnClickListener onClickListener) {
        ConnectionRetrySnackbarView connectionRetrySnackbarView = new ConnectionRetrySnackbarView(this.f18069d);
        connectionRetrySnackbarView.setRetryClickListener(new C19501(this));
        this.f18071f = ((ClickableToastBuilder) this.f18070e.get()).a(connectionRetrySnackbarView, 10000);
        this.f18071f.a();
    }

    public final void mo1079e(OnClickListener onClickListener) {
        AlertView alertView = (AlertView) mo1075b();
        alertView.setVisibility(0);
        alertView.setMessage(m22017a(2131235304, new String[0]));
        alertView.setPrimaryButtonClickListener(onClickListener);
    }

    public final void mo1080f(OnClickListener onClickListener) {
        AlertView alertView = (AlertView) mo1075b();
        alertView.setVisibility(0);
        alertView.setMessage(m22017a(2131235305, this.f18065b));
        alertView.setPrimaryButtonText(m22017a(2131235309, new String[0]));
        alertView.setPrimaryButtonClickListener(onClickListener);
    }

    protected final View mo1075b() {
        return this.f18066c.a();
    }
}
