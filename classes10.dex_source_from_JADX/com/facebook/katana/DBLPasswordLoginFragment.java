package com.facebook.katana;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.auth.credentials.PasswordCredentials;
import com.facebook.auth.credentials.PasswordCredentials.Type;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.util.StringUtil;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.devicebasedlogin.ui.DBLProfilePhotoView;
import com.facebook.devicebasedlogin.ui.DeviceBasedLoginWaitListener;
import com.facebook.inject.FbInjector;
import com.facebook.katana.common.SoftKeyboardHelper;
import com.facebook.katana.common.TextEnteredListener;
import com.facebook.katana.dbl.DeviceBasedLoginListener;
import com.facebook.katana.util.MSiteUrlUtils;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.IFbResourcesNotRequired;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.keyboard.KeyboardUtils;
import javax.inject.Inject;

/* compiled from: SEND_FAILED_NOT_CONNECTED */
public class DBLPasswordLoginFragment extends FbFragment implements OnClickListener, IAuthNotRequired, DeviceBasedLoginWaitListener, TextEnteredListener, IFbResourcesNotRequired {
    @Inject
    public UniqueIdForDeviceHolderImpl f24105a;
    private DBLFacebookCredentials al;
    public DBLProfilePhotoView am;
    public View an;
    public final Handler ao = new Handler();
    @Inject
    public MSiteUrlUtils f24106b;
    public EditText f24107c;
    public DeviceBasedLoginListener f24108d;
    public Button f24109e;
    private ProgressBar f24110f;
    private int f24111g;
    public TextView f24112h;
    public TextView f24113i;

    /* compiled from: SEND_FAILED_NOT_CONNECTED */
    public class C34621 implements TextWatcher {
        final /* synthetic */ DBLPasswordLoginFragment f24102a;

        public C34621(DBLPasswordLoginFragment dBLPasswordLoginFragment) {
            this.f24102a = dBLPasswordLoginFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (StringUtil.a(this.f24102a.f24107c.getText())) {
                if (this.f24102a.f24109e.isEnabled()) {
                    this.f24102a.f24109e.setEnabled(false);
                }
            } else if (!this.f24102a.f24109e.isEnabled()) {
                this.f24102a.f24109e.setEnabled(true);
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: SEND_FAILED_NOT_CONNECTED */
    public class C34642 implements Runnable {
        final /* synthetic */ DBLPasswordLoginFragment f24104a;

        /* compiled from: SEND_FAILED_NOT_CONNECTED */
        class C34631 implements AnimationListener {
            final /* synthetic */ C34642 f24103a;

            C34631(C34642 c34642) {
                this.f24103a = c34642;
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                DBLPasswordLoginFragment.as(this.f24103a.f24104a);
                this.f24103a.f24104a.f24107c.setText("");
                this.f24103a.f24104a.f24107c.setHint(2131236271);
                this.f24103a.f24104a.f24107c.setCursorVisible(true);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        }

        public C34642(DBLPasswordLoginFragment dBLPasswordLoginFragment) {
            this.f24104a = dBLPasswordLoginFragment;
        }

        public void run() {
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(500);
            this.f24104a.f24112h.startAnimation(alphaAnimation);
            this.f24104a.f24109e.startAnimation(alphaAnimation);
            this.f24104a.an.startAnimation(alphaAnimation);
            this.f24104a.am.startAnimation(alphaAnimation);
            this.f24104a.f24113i.startAnimation(alphaAnimation);
            alphaAnimation.setAnimationListener(new C34631(this));
        }
    }

    public static void m25410a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        DBLPasswordLoginFragment dBLPasswordLoginFragment = (DBLPasswordLoginFragment) obj;
        UniqueIdForDeviceHolderImpl b = UniqueIdForDeviceHolderMethodAutoProvider.b(fbInjector);
        MSiteUrlUtils b2 = MSiteUrlUtils.b(fbInjector);
        dBLPasswordLoginFragment.f24105a = b;
        dBLPasswordLoginFragment.f24106b = b2;
    }

    public final void m25417c(Bundle bundle) {
        super.c(bundle);
        Class cls = DBLPasswordLoginFragment.class;
        m25410a(this, getContext());
        this.al = (DBLFacebookCredentials) this.s.getParcelable("dbl_account_details");
    }

    public final View m25412a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1842723524);
        View inflate = layoutInflater.inflate(2130903855, viewGroup, false);
        this.f24113i = (TextView) inflate.findViewById(2131560318);
        if (this.f24111g != 0) {
            this.f24113i.setText(this.f24111g);
        }
        this.am = (DBLProfilePhotoView) inflate.findViewById(2131559671);
        this.am.setImage(this.al.mPicUrl);
        this.f24107c = (EditText) inflate.findViewById(2131560912);
        this.f24107c.addTextChangedListener(new C34621(this));
        this.an = inflate.findViewById(2131560916);
        new SoftKeyboardHelper().a(this, getContext(), this.f24107c, b(2131236275));
        this.f24112h = (TextView) inflate.findViewById(2131560918);
        this.f24112h.setOnClickListener(this);
        this.f24110f = (ProgressBar) inflate.findViewById(2131559418);
        this.f24109e = (Button) inflate.findViewById(2131560917);
        this.f24109e.setOnClickListener(this);
        this.f24109e.setEnabled(false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1095584270, a);
        return inflate;
    }

    public final void m25418g(int i) {
        this.f24111g = i;
        if (this.T != null) {
            this.f24113i.setText(this.f24111g);
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1830952585);
        super.mi_();
        this.f24107c.requestFocus();
        KeyboardUtils.b(ao(), this.f24107c);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1003427421, a);
    }

    public final void m25411G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1126294120);
        super.G();
        HandlerDetour.b(this.ao, new C34642(this), 500, 673797621);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1153967247, a);
    }

    public final void m25413a() {
        this.f24109e.setVisibility(8);
        this.f24112h.setVisibility(8);
        this.an.setVisibility(8);
        this.f24113i.setVisibility(8);
        this.am.setVisibility(8);
        this.f24107c.setVisibility(8);
        this.f24110f.setVisibility(0);
    }

    public final void m25415b() {
    }

    public final void m25416c() {
        as(this);
        this.f24107c.setText("");
        this.f24110f.setVisibility(8);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -862147022);
        int id = view.getId();
        if (id == 2131560917) {
            Object obj = this.f24107c.getText().toString();
            if (StringUtil.a(obj)) {
                Logger.a(2, EntryType.UI_INPUT_END, 507389081, a);
                return;
            }
            m25414a(obj);
        } else if (id == 2131560918) {
            this.f24108d.a(Uri.parse(this.f24106b.b(ao().getApplicationContext(), "login/identify?ctx=recover&allow_token_login=1")).buildUpon().appendQueryParameter("device_id", this.f24105a.a()).build());
        }
        LogUtils.a(2135788654, a);
    }

    public static void as(DBLPasswordLoginFragment dBLPasswordLoginFragment) {
        dBLPasswordLoginFragment.f24109e.setVisibility(0);
        dBLPasswordLoginFragment.f24112h.setVisibility(0);
        dBLPasswordLoginFragment.an.setVisibility(0);
        dBLPasswordLoginFragment.f24113i.setVisibility(0);
        dBLPasswordLoginFragment.am.setVisibility(0);
        dBLPasswordLoginFragment.f24107c.setVisibility(0);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 890711009);
        super.mj_();
        KeyboardUtils.a(ao());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1197183963, a);
    }

    public final void m25414a(String str) {
        this.f24108d.a(new PasswordCredentials(this.al.mUserId, str, Type.PASSWORD), this.al, this.s.getInt("dbl_flag", 0));
    }
}
