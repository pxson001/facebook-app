package com.facebook.login;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.login.LoginClient.Request;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: video_list_id_to_fetch */
public class LoginFragment extends Fragment {
    public String f231a;
    public LoginClient f232b;
    public Request f233c;

    /* compiled from: video_list_id_to_fetch */
    public class C00371 {
        public final /* synthetic */ LoginFragment f228a;

        C00371(LoginFragment loginFragment) {
            this.f228a = loginFragment;
        }
    }

    public final void m261a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1782361083);
        super.a(bundle);
        if (bundle != null) {
            this.f232b = (LoginClient) bundle.getParcelable("loginClient");
            this.f232b.m247a((Fragment) this);
        } else {
            this.f232b = new LoginClient((Fragment) this);
        }
        this.f232b.f222d = new C00371(this);
        FragmentActivity o = o();
        if (o == null) {
            LogUtils.f(147861859, a);
            return;
        }
        ComponentName callingActivity = o.getCallingActivity();
        if (callingActivity != null) {
            this.f231a = callingActivity.getPackageName();
        }
        if (o.getIntent() != null) {
            Intent intent = o.getIntent();
            intent.setExtrasClassLoader(Request.class.getClassLoader());
            this.f233c = (Request) intent.getParcelableExtra("request");
        }
        LogUtils.f(-1474665268, a);
    }

    public final void m258I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1171448235);
        LoginClient loginClient = this.f232b;
        if (loginClient.f220b >= 0) {
            loginClient.m253f().mo3a();
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -294556589, a);
    }

    public final View m259a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1612693680);
        final View inflate = layoutInflater.inflate(2130903612, viewGroup, false);
        this.f232b.f223e = new Object(this) {
            final /* synthetic */ LoginFragment f230b;
        };
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 317660332, a);
        return inflate;
    }

    public final void m256G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 832481579);
        super.G();
        if (this.f231a == null) {
            Log.e("LoginFragment", "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            o().finish();
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1425557433, a);
            return;
        }
        this.f232b.m248a(this.f233c);
        LogUtils.f(-1297547174, a);
    }

    public final void m257H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 583866848);
        super.H();
        o().findViewById(2131560415).setVisibility(8);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1736606090, a);
    }

    public final void m260a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        LoginClient loginClient = this.f232b;
        if (loginClient.f225g != null) {
            boolean a = loginClient.m253f().mo4a(i2, intent);
        }
    }

    public final void m262e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("loginClient", this.f232b);
    }
}
