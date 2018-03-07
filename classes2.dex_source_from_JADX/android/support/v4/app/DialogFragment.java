package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: |   */
public class DialogFragment extends Fragment implements OnCancelListener, OnDismissListener {
    int f86a = 0;
    int f87b = 0;
    boolean f88c = true;
    public boolean f89d = true;
    int f90e = -1;
    public Dialog f91f;
    boolean f92g;
    boolean f93h;
    boolean f94i;

    public final void m211a(int i, @StyleRes int i2) {
        this.f86a = i;
        if (this.f86a == 2 || this.f86a == 3) {
            this.f87b = 16973913;
        }
        if (i2 != 0) {
            this.f87b = i2;
        }
    }

    public void m213a(FragmentManager fragmentManager, String str) {
        this.f93h = false;
        this.f94i = true;
        FragmentTransaction a = fragmentManager.mo842a();
        a.mo1845a((Fragment) this, str);
        a.mo1847b();
    }

    public final int m208a(FragmentTransaction fragmentTransaction, String str) {
        this.f93h = false;
        this.f94i = true;
        fragmentTransaction.mo1845a((Fragment) this, str);
        this.f92g = false;
        this.f90e = fragmentTransaction.mo1847b();
        return this.f90e;
    }

    public final int m209a(FragmentTransaction fragmentTransaction, String str, boolean z) {
        this.f93h = false;
        this.f94i = true;
        fragmentTransaction.mo1845a((Fragment) this, str);
        this.f92g = false;
        this.f90e = z ? fragmentTransaction.mo1851c() : fragmentTransaction.mo1847b();
        return this.f90e;
    }

    public void m210a() {
        m207h(false);
    }

    public final void m215b() {
        m207h(true);
    }

    private void m207h(boolean z) {
        if (!this.f93h) {
            this.f93h = true;
            this.f94i = false;
            if (this.f91f != null) {
                this.f91f.dismiss();
                this.f91f = null;
            }
            this.f92g = true;
            if (this.f90e >= 0) {
                this.f100D.mo843a(this.f90e, 1);
                this.f90e = -1;
                return;
            }
            FragmentTransaction a = this.f100D.mo842a();
            a.mo1844a((Fragment) this);
            if (z) {
                a.mo1851c();
            } else {
                a.mo1847b();
            }
        }
    }

    @StyleRes
    public int m217d() {
        return this.f87b;
    }

    public final void d_(boolean z) {
        this.f88c = z;
        if (this.f91f != null) {
            this.f91f.setCancelable(z);
        }
    }

    public void a_(Context context) {
        super.a_(context);
        if (!this.f94i) {
            this.f93h = false;
        }
    }

    public final void dE_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -115541182);
        super.dE_();
        if (!(this.f94i || this.f93h)) {
            this.f93h = true;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -469609, a);
    }

    public void mo15a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2019834695);
        super.mo15a(bundle);
        this.f89d = this.f105I == 0;
        if (bundle != null) {
            this.f86a = bundle.getInt("android:style", 0);
            this.f87b = bundle.getInt("android:theme", 0);
            this.f88c = bundle.getBoolean("android:cancelable", true);
            this.f89d = bundle.getBoolean("android:showsDialog", this.f89d);
            this.f90e = bundle.getInt("android:backStackId", -1);
        }
        LogUtils.f(796776816, a);
    }

    public final LayoutInflater mo17b(Bundle bundle) {
        if (!this.f89d) {
            return super.mo17b(bundle);
        }
        this.f91f = mo13c(bundle);
        switch (this.f86a) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                break;
            case 3:
                this.f91f.getWindow().addFlags(24);
                break;
        }
        this.f91f.requestWindowFeature(1);
        LayoutInflater m = this.f101E.mo870m();
        if (this.f91f != null) {
            m = m.cloneInContext(this.f91f.getContext());
        }
        return new ChildFragmentLayoutInflator(m, this);
    }

    @NonNull
    public Dialog mo13c(Bundle bundle) {
        return new Dialog(getContext(), m217d());
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.f92g) {
            m207h(true);
        }
    }

    public void mo18d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1962515245);
        super.mo18d(bundle);
        if (this.f89d) {
            View view = this.f116T;
            if (view != null) {
                if (view.getParent() != null) {
                    IllegalStateException illegalStateException = new IllegalStateException("DialogFragment can not be attached to a container view");
                    LogUtils.f(-1335993336, a);
                    throw illegalStateException;
                }
                this.f91f.setContentView(view);
            }
            Context context = getContext();
            if (context instanceof Activity) {
                this.f91f.setOwnerActivity((Activity) context);
            }
            this.f91f.setCancelable(this.f88c);
            this.f91f.setOnCancelListener(this);
            this.f91f.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.f91f.onRestoreInstanceState(bundle2);
                }
            }
            LogUtils.f(-1166532172, a);
            return;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1864015747, a);
    }

    public void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1414964985);
        super.mi_();
        if (this.f91f != null) {
            this.f92g = false;
            this.f91f.show();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 958289696, a);
    }

    public void mo20e(Bundle bundle) {
        super.mo20e(bundle);
        if (this.f91f != null) {
            Bundle onSaveInstanceState = this.f91f.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.f86a != 0) {
            bundle.putInt("android:style", this.f86a);
        }
        if (this.f87b != 0) {
            bundle.putInt("android:theme", this.f87b);
        }
        if (!this.f88c) {
            bundle.putBoolean("android:cancelable", this.f88c);
        }
        if (!this.f89d) {
            bundle.putBoolean("android:showsDialog", this.f89d);
        }
        if (this.f90e != -1) {
            bundle.putInt("android:backStackId", this.f90e);
        }
    }

    public void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2016483370);
        super.mj_();
        if (this.f91f != null) {
            this.f91f.hide();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1648828166, a);
    }

    public void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1992015385);
        super.mY_();
        if (this.f91f != null) {
            this.f92g = true;
            this.f91f.dismiss();
            this.f91f = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 351318483, a);
    }
}
