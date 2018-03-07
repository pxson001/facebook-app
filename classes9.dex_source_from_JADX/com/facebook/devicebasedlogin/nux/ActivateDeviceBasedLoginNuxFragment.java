package com.facebook.devicebasedlogin.nux;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.devicebasedlogin.nux.TargetedNuxResolver.NuxType;
import com.facebook.devicebasedlogin.ui.DBLProfilePhotoView;
import com.facebook.devicebasedlogin.ui.DeviceBasedLoginWaitListener;
import com.facebook.fbui.nux.canvas.MobileChromeView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.dbl.DBLStorageAndRetrievalHelper;
import com.facebook.katana.dbl.DeviceBasedLoginActivityHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.IFbResourcesNotRequired;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.user.model.User;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Thread operations Cache level */
public class ActivateDeviceBasedLoginNuxFragment extends FbFragment implements OnClickListener, IAuthNotRequired, DeviceBasedLoginWaitListener, IFbResourcesNotRequired {
    private static final Class<?> f24134d = ActivateDeviceBasedLoginNuxFragment.class;
    @Inject
    @LoggedInUser
    public Provider<User> f24135a;
    private FbTextView al;
    private boolean am;
    @Inject
    public TargetedNuxResolver f24136b;
    @Inject
    public DBLStorageAndRetrievalHelper f24137c;
    @Inject
    public DeviceBasedLoginActivityHelper f24138e;
    public ActivateDBLListener f24139f;
    public View f24140g;
    private DBLProfilePhotoView f24141h;
    private DBLProfilePhotoView f24142i;

    public static void m26094a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ActivateDeviceBasedLoginNuxFragment activateDeviceBasedLoginNuxFragment = (ActivateDeviceBasedLoginNuxFragment) obj;
        DeviceBasedLoginActivityHelper b = DeviceBasedLoginActivityHelper.b(injectorLike);
        Provider a = IdBasedProvider.a(injectorLike, 3595);
        TargetedNuxResolver b2 = TargetedNuxResolver.m26135b(injectorLike);
        DBLStorageAndRetrievalHelper b3 = DBLStorageAndRetrievalHelper.b(injectorLike);
        activateDeviceBasedLoginNuxFragment.f24138e = b;
        activateDeviceBasedLoginNuxFragment.f24135a = a;
        activateDeviceBasedLoginNuxFragment.f24136b = b2;
        activateDeviceBasedLoginNuxFragment.f24137c = b3;
    }

    public static ActivateDeviceBasedLoginNuxFragment m26093a(boolean z, NuxType nuxType) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("arg_show_passcode_cta", z);
        bundle.putSerializable("arg_nux_type", nuxType);
        ActivateDeviceBasedLoginNuxFragment activateDeviceBasedLoginNuxFragment = new ActivateDeviceBasedLoginNuxFragment();
        activateDeviceBasedLoginNuxFragment.g(bundle);
        return activateDeviceBasedLoginNuxFragment;
    }

    public final void m26101c(Bundle bundle) {
        super.c(bundle);
        Class cls = ActivateDeviceBasedLoginNuxFragment.class;
        m26094a((Object) this, getContext());
    }

    public final View m26096a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1118238202);
        this.f24140g = layoutInflater.inflate(2130903084, viewGroup, false);
        View view = this.f24140g;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1471790669, a);
        return view;
    }

    public final void m26098a(View view, Bundle bundle) {
        Object obj;
        boolean z;
        super.a(view, bundle);
        Bundle bundle2 = this.s;
        NuxType nuxType = (NuxType) bundle2.getSerializable("arg_nux_type");
        this.f24141h = (DBLProfilePhotoView) this.f24140g.findViewById(2131559211);
        this.f24141h.setImage(((User) this.f24135a.get()).x());
        ((TextView) this.f24140g.findViewById(2131559212)).setText(((User) this.f24135a.get()).e.a());
        TextView textView = (TextView) this.f24140g.findViewById(2131559214);
        this.f24142i = (DBLProfilePhotoView) this.f24140g.findViewById(2131559213);
        if (nuxType == NuxType.SHARED_DEVICE) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            for (DBLFacebookCredentials dBLFacebookCredentials : this.f24137c.a()) {
                if (!dBLFacebookCredentials.mUserId.equals(((User) this.f24135a.get()).a)) {
                    this.f24142i.setImage(dBLFacebookCredentials.mPicUrl);
                    textView.setText(dBLFacebookCredentials.mName);
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            this.f24142i.setVisibility(8);
            textView.setVisibility(8);
        }
        this.al = (FbTextView) this.f24140g.findViewById(2131559206);
        this.am = bundle2.getBoolean("arg_show_passcode_cta", true);
        if (this.am) {
            this.al.setOnClickListener(this);
        } else {
            this.al.setVisibility(4);
        }
        FbTextView fbTextView = (FbTextView) this.f24140g.findViewById(2131558927);
        FbTextView fbTextView2 = (FbTextView) this.f24140g.findViewById(2131558926);
        if (this.f24138e.c() && nuxType == NuxType.DEFAULT) {
            nuxType = NuxType.AUTOSAVE;
        }
        fbTextView.setText(this.f24136b.m26136a(nuxType));
        fbTextView2.setText(this.f24136b.m26137b(nuxType));
        ((FbButton) this.f24140g.findViewById(2131559218)).setOnClickListener(this);
        ((FbButton) this.f24140g.findViewById(2131559217)).setOnClickListener(this);
        this.f24140g.findViewById(2131559207).setVisibility(4);
        aq();
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1814548358);
        super.mi_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1820631612, a);
    }

    public final void m26095G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 679350446);
        super.G();
        View findViewById = this.f24140g.findViewById(2131559207);
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(500);
        translateAnimation.setFillAfter(true);
        findViewById.startAnimation(translateAnimation);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1963533468, a);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -724599011);
        int id = view.getId();
        if (id == 2131559218) {
            if (this.f24139f != null) {
                this.f24139f.mo1127a();
            }
        } else if (id == 2131559217) {
            if (this.f24139f != null) {
                this.f24139f.mo1128b();
            }
        } else if (id == 2131559206 && this.f24139f != null) {
            this.f24139f.mo1130c();
        }
        LogUtils.a(1498271299, a);
    }

    public final void mo1131a() {
    }

    public final void mo1132b() {
    }

    public final void mo1133c() {
    }

    private void aq() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        if (width <= 300) {
            ((MobileChromeView) this.f24140g.findViewById(2131559208)).setScaleX(0.7f);
            this.f24140g.findViewById(2131559212).setVisibility(8);
            this.f24140g.findViewById(2131559214).setVisibility(8);
            this.f24141h.setScaleX(0.7f);
            this.f24141h.setScaleY(0.7f);
            this.f24142i.setScaleX(0.7f);
            this.f24142i.setScaleY(0.7f);
            this.f24140g.findViewById(2131559210).setScaleX(0.7f);
            this.f24140g.findViewById(2131559210).setScaleY(0.7f);
        }
        FrameLayout frameLayout = (FrameLayout) this.f24140g.findViewById(2131559207);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2, 1.0f);
        layoutParams.setMargins(width / 12, height / 20, width / 12, 0);
        frameLayout.setLayoutParams(layoutParams);
    }
}
