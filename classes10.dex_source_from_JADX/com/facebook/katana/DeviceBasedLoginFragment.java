package com.facebook.katana;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.auth.credentials.DeviceBasedLoginCredentials;
import com.facebook.auth.credentials.DeviceBasedLoginCredentials.Type;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.network.NetworkMonitor.State;
import com.facebook.common.network.OnConnectionChangedListener;
import com.facebook.devicebasedlogin.ui.DBLProfilePhotoView;
import com.facebook.devicebasedlogin.ui.DeviceBasedLoginWaitListener;
import com.facebook.devicebasedlogin.ui.NumPadView;
import com.facebook.devicebasedlogin.ui.NumPadViewListener;
import com.facebook.inject.FbInjector;
import com.facebook.katana.dbl.DeviceBasedLoginListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.IFbResourcesNotRequired;
import com.facebook.ui.errors.ConnectivityBannerController;
import com.facebook.ui.errors.ConnectivityBannerController.1;
import com.facebook.ui.errors.ConnectivityBannerController.2;
import com.facebook.ui.errors.ErrorBannerView;
import com.facebook.ui.errors.ErrorBannerViewStub;
import com.google.common.collect.Lists;
import javax.inject.Inject;

/* compiled from: SEGMENT_UPLOADING_CANCELLATION */
public class DeviceBasedLoginFragment extends FbFragment implements IAuthNotRequired, DeviceBasedLoginWaitListener, NumPadViewListener, IFbResourcesNotRequired {
    @Inject
    public ConnectivityBannerController f24181a;
    public DBLFacebookCredentials f24182b;
    public DeviceBasedLoginListener f24183c;
    public NumPadView f24184d;
    private ProgressBar f24185e;
    public View f24186f;
    public DBLProfilePhotoView f24187g;
    public int f24188h = 0;
    private ErrorBannerView f24189i;

    public static void m25478a(Object obj, Context context) {
        ((DeviceBasedLoginFragment) obj).f24181a = new ConnectivityBannerController(NetworkMonitor.a(FbInjector.get(context)));
    }

    public final void m25486c(Bundle bundle) {
        super.c(bundle);
        Class cls = DeviceBasedLoginFragment.class;
        m25478a(this, getContext());
        this.f24182b = (DBLFacebookCredentials) this.s.getParcelable("dbl_account_details");
    }

    public final View m25481a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1318929252);
        this.f24186f = layoutInflater.inflate(2130903892, viewGroup, false);
        this.f24184d = (NumPadView) this.f24186f.findViewById(2131560966);
        this.f24184d.s = this;
        this.f24185e = (ProgressBar) this.f24186f.findViewById(2131559418);
        this.f24187g = (DBLProfilePhotoView) this.f24186f.findViewById(2131559671);
        this.f24187g.setImage(this.f24182b.mPicUrl);
        if (this.f24188h != 0) {
            ((TextView) this.f24186f.findViewById(2131558927)).setText(this.f24188h);
        }
        this.f24189i = (ErrorBannerView) ((ErrorBannerViewStub) this.f24186f.findViewById(2131560965)).a();
        ConnectivityBannerController connectivityBannerController = this.f24181a;
        OnConnectionChangedListener[] onConnectionChangedListenerArr = new OnConnectionChangedListener[]{this.f24189i};
        connectivityBannerController.b = Lists.a();
        connectivityBannerController.c = onConnectionChangedListenerArr;
        connectivityBannerController.b.add(connectivityBannerController.a.a(State.CONNECTED, new 1(connectivityBannerController)));
        connectivityBannerController.b.add(connectivityBannerController.a.a(State.NO_INTERNET, new 2(connectivityBannerController)));
        connectivityBannerController.b();
        View view = this.f24186f;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -928944750, a);
        return view;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1862474293);
        super.mi_();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ao().getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        float f = getContext().getResources().getDisplayMetrics().density;
        int i2 = i - ((int) ((394.0f * f) + 0.5f));
        int i3 = (int) ((20.0f * f) + 0.5f);
        LayoutParams layoutParams = (LayoutParams) this.f24187g.getLayoutParams();
        layoutParams.setMargins(i3, i2 / 2, i3, 0);
        this.f24187g.setLayoutParams(layoutParams);
        this.f24184d.a(i3 / 2, i2 / 4, i3 / 2, i2 / 4);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1584073133, a);
    }

    public final void m25479G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1242720780);
        super.G();
        this.f24181a.b();
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(600);
        this.f24186f.findViewById(2131558927).startAnimation(alphaAnimation);
        this.f24184d.b();
        this.f24184d.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -269805165, a);
    }

    public final void m25483a(String str) {
        if (this.f24183c != null) {
            this.f24183c.a(new DeviceBasedLoginCredentials(this.f24182b.mUserId, this.f24182b.mNonce, str, Type.DEVICE_BASED_LOGIN_TYPE), this.f24182b);
        }
    }

    public final void m25482a() {
        this.f24187g.setVisibility(4);
        this.T.findViewById(2131558927).setVisibility(4);
        this.f24185e.setVisibility(0);
        this.f24184d.setVisibility(8);
    }

    public final void m25484b() {
    }

    public final void m25485c() {
        this.f24184d.a();
        this.f24187g.setVisibility(0);
        this.T.findViewById(2131558927).setVisibility(0);
        this.f24185e.setVisibility(8);
        this.f24184d.setVisibility(0);
    }

    public final void m25480I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -229513633);
        if (this.f24181a != null) {
            ConnectivityBannerController connectivityBannerController = this.f24181a;
            if (connectivityBannerController.b != null) {
                for (int i = 0; i < connectivityBannerController.b.size(); i++) {
                    ((SelfRegistrableReceiverImpl) connectivityBannerController.b.get(i)).c();
                }
                connectivityBannerController.b.clear();
                connectivityBannerController.b = null;
            }
            connectivityBannerController.c = null;
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 279771337, a);
    }
}
