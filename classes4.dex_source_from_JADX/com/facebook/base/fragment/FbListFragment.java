package com.facebook.base.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.View;
import com.facebook.common.queryinterface.ProvidesInterface;
import com.facebook.common.util.FindViewUtil;
import com.facebook.inject.InjectableComponentWithContext;

/* compiled from: external_cache_size */
public class FbListFragment extends ListFragment implements FragmentManagerHost, ProvidesInterface, InjectableComponentWithContext {
    public final <T> T m13314a(Class<? extends T> cls) {
        T b = m13313b(cls);
        if (b != null) {
            return b;
        }
        Fragment fragment = this.G;
        if (fragment instanceof ProvidesInterface) {
            return ((ProvidesInterface) fragment).a(cls);
        }
        Context context = getContext();
        if (context instanceof ProvidesInterface) {
            return ((ProvidesInterface) context).a(cls);
        }
        return null;
    }

    private <T> T m13313b(Class<? extends T> cls) {
        return cls.isInstance(this) ? this : null;
    }

    public final void gE_() {
        C();
    }

    public final FragmentManager kO_() {
        return this.D;
    }

    public final <T extends View> T m13315e(int i) {
        return FindViewUtil.b(this.T, i);
    }
}
