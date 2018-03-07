package com.facebook.registration.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.gk.sessionless.GatekeeperStoreImpl_SessionlessMethodAutoProvider;
import com.facebook.gk.sessionless.Sessionless;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.growth.model.ContactpointType;
import com.facebook.inject.FbInjector;
import com.facebook.katana.dbl.FbAndroidAuthActivityUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.facebook.registration.activity.RegistrationLoginActivity;
import com.facebook.registration.model.SimpleRegFormData;
import javax.inject.Inject;

/* compiled from: language_switcher_activity_suggestions_failed */
public class RegistrationSuccessFragment extends RegistrationFragment {
    @Inject
    public SimpleRegFormData f8880b;
    @Inject
    public FbAndroidAuthActivityUtil f8881c;
    @Inject
    public SecureContextHelper f8882d;
    @Inject
    @Sessionless
    public GatekeeperStoreImpl f8883e;
    private Spring f8884f;
    public CountDownTimer f8885g;
    public GlyphView f8886h;

    /* compiled from: language_switcher_activity_suggestions_failed */
    class C13531 extends SimpleSpringListener {
        final /* synthetic */ RegistrationSuccessFragment f8878a;

        C13531(RegistrationSuccessFragment registrationSuccessFragment) {
            this.f8878a = registrationSuccessFragment;
        }

        public final void m8856a(Spring spring) {
            float b = ((float) spring.b()) * 2.0f;
            this.f8878a.f8886h.setScaleX(b);
            this.f8878a.f8886h.setScaleY(b);
        }

        public final void m8855a() {
            if (this.f8878a.f8885g != null) {
                this.f8878a.f8885g.start();
            }
        }
    }

    public static void m8857a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RegistrationSuccessFragment registrationSuccessFragment = (RegistrationSuccessFragment) obj;
        SimpleRegFormData a = SimpleRegFormData.a(fbInjector);
        FbAndroidAuthActivityUtil b = FbAndroidAuthActivityUtil.b(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        GatekeeperStoreImpl a2 = GatekeeperStoreImpl_SessionlessMethodAutoProvider.a(fbInjector);
        registrationSuccessFragment.f8880b = a;
        registrationSuccessFragment.f8881c = b;
        registrationSuccessFragment.f8882d = secureContextHelper;
        registrationSuccessFragment.f8883e = a2;
    }

    public final void m8859c(Bundle bundle) {
        super.c(bundle);
        Class cls = RegistrationSuccessFragment.class;
        m8857a(this, getContext());
    }

    public final void mo383b(View view, Bundle bundle) {
        View findViewById = o().findViewById(2131558563);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        this.f8886h = (GlyphView) FindViewUtil.b(view, 2131566916);
    }

    protected final int mo384e() {
        return 0;
    }

    protected final int aq() {
        return 2130906800;
    }

    protected final void q_() {
        this.f8885g = new CountDownTimer(this, 250, 250) {
            final /* synthetic */ RegistrationSuccessFragment f8879a;

            public void onTick(long j) {
            }

            public void onFinish() {
                String str;
                if (this.f8879a.f8880b.f != null && !StringUtil.c(this.f8879a.f8880b.f.userId)) {
                    str = this.f8879a.f8880b.f.userId;
                } else if (this.f8879a.f8880b.e == ContactpointType.PHONE) {
                    str = this.f8879a.f8880b.h;
                } else {
                    str = this.f8879a.f8880b.j;
                }
                Bundle bundle = new Bundle();
                bundle.putString("extra_uid", str);
                bundle.putString("extra_pwd", this.f8879a.f8880b.n);
                if (this.f8879a.f8883e.a(23, true)) {
                    Intent intent = new Intent(this.f8879a.getContext(), RegistrationLoginActivity.class);
                    intent.putExtras(bundle);
                    this.f8879a.f8882d.a(intent, this.f8879a.getContext());
                    this.f8879a.o().finish();
                    this.f8879a.o().overridePendingTransition(0, 0);
                    return;
                }
                this.f8879a.f8881c.a(this.f8879a.o(), bundle);
            }
        };
        this.f8884f = SpringSystem.b().a().a(new SpringConfig(50.0d, 4.0d));
        this.f8884f.a(new C13531(this));
        this.f8884f.b(1.0d);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -842535751);
        if (this.f8885g != null) {
            this.f8885g.cancel();
            this.f8885g = null;
        }
        if (this.f8884f != null) {
            this.f8884f.m.clear();
        }
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -67567445, a);
    }
}
