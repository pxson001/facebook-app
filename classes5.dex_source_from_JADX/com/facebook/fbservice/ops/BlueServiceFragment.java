package com.facebook.fbservice.ops;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.ops.BlueServiceOperation.OnCompletedListener;
import com.facebook.fbservice.ops.BlueServiceOperation.OnProgressListener;
import com.facebook.fbservice.ops.BlueServiceOperation.State;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;

/* compiled from: return_after_snap */
public class BlueServiceFragment extends Fragment {
    public BlueServiceOperation f2979a;
    public OnCompletedListener f2980b;
    public OnProgressListener f2981c;
    private DialogBasedProgressIndicator f2982d;
    public boolean f2983e;
    public String f2984f;
    public Bundle f2985g;
    public CallerContext f2986h;

    /* compiled from: return_after_snap */
    class C02101 extends OnCompletedListener {
        final /* synthetic */ BlueServiceFragment f2977a;

        C02101(BlueServiceFragment blueServiceFragment) {
            this.f2977a = blueServiceFragment;
        }

        public final void mo605a(OperationResult operationResult) {
            if (this.f2977a.f2980b != null) {
                this.f2977a.f2980b.mo605a(operationResult);
            }
        }

        public final void mo606a(ServiceException serviceException) {
            if (this.f2977a.f2980b != null) {
                this.f2977a.f2980b.mo606a(serviceException);
            }
        }
    }

    /* compiled from: return_after_snap */
    class C02112 extends OnProgressListener {
        final /* synthetic */ BlueServiceFragment f2978a;

        C02112(BlueServiceFragment blueServiceFragment) {
            this.f2978a = blueServiceFragment;
        }

        public final void mo607a(OperationResult operationResult) {
            if (this.f2978a.f2981c != null) {
                this.f2978a.f2981c.mo607a(operationResult);
            }
        }
    }

    public final void a_(Context context) {
        super.a_(context);
        this.f2979a = BlueServiceOperation.m4173b((InjectorLike) FbInjector.get(getContext()));
    }

    public final void m4166d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 726671251);
        super.d(bundle);
        this.f2979a.f3005m = true;
        this.f2979a.f3003k = new C02101(this);
        this.f2979a.f3004l = new C02112(this);
        if (bundle != null && this.f2984f == null) {
            this.f2979a.m4187b(bundle);
        }
        this.f2979a.m4185a(this.f2982d);
        this.f2982d = null;
        this.f2983e = true;
        if (this.f2984f != null) {
            this.f2979a.m4186a(this.f2984f, this.f2985g, this.f2986h);
            this.f2984f = null;
            this.f2985g = null;
            this.f2986h = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -229593358, a);
    }

    public final void m4162I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -871677533);
        super.I();
        this.f2979a.m4184a();
        this.f2980b = null;
        this.f2981c = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 446654863, a);
    }

    public final void m4167e(Bundle bundle) {
        super.e(bundle);
        BlueServiceOperation blueServiceOperation = this.f2979a;
        bundle.putSerializable("operationState", blueServiceOperation.f3009q);
        bundle.putString("type", blueServiceOperation.f3010r);
        bundle.putParcelable("param", blueServiceOperation.f3011s);
        bundle.putParcelable("callerContext", blueServiceOperation.f3012t);
        bundle.putString("operationId", blueServiceOperation.f3013u);
    }

    public final State m4165b() {
        return this.f2979a.f3009q;
    }

    public final void m4163a(DialogBasedProgressIndicator dialogBasedProgressIndicator) {
        if (this.f2983e) {
            this.f2979a.m4185a(dialogBasedProgressIndicator);
        } else {
            this.f2982d = dialogBasedProgressIndicator;
        }
    }

    public final void m4164a(String str, @Nullable Bundle bundle) {
        if (this.f2983e) {
            this.f2979a.m4186a(str, bundle, null);
            return;
        }
        this.f2984f = str;
        this.f2985g = bundle;
        this.f2986h = null;
    }

    public static BlueServiceFragment m4160a(FragmentActivity fragmentActivity, String str) {
        return m4161a(fragmentActivity.kO_(), str);
    }

    public static BlueServiceFragment m4161a(FragmentManager fragmentManager, String str) {
        BlueServiceFragment blueServiceFragment = (BlueServiceFragment) fragmentManager.a(str);
        if (blueServiceFragment != null) {
            return blueServiceFragment;
        }
        blueServiceFragment = new BlueServiceFragment();
        FragmentTransaction a = fragmentManager.a();
        a.a(blueServiceFragment, str);
        a.b();
        return blueServiceFragment;
    }
}
