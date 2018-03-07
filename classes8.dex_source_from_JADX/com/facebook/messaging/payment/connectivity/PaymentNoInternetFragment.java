package com.facebook.messaging.payment.connectivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: tooltip */
public class PaymentNoInternetFragment extends FbFragment {
    public static PaymentNoInternetFragment m1709a(int i, FragmentManager fragmentManager) {
        Fragment paymentNoInternetFragment = new PaymentNoInternetFragment();
        fragmentManager.a().b(i, paymentNoInternetFragment).b();
        return paymentNoInternetFragment;
    }

    public final void m1711c(Bundle bundle) {
        super.c(bundle);
        Class cls = PaymentNoInternetFragment.class;
        FbInjector.get(getContext());
    }

    public final View m1710a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1001126914);
        ao().getWindow().setSoftInputMode(3);
        View inflate = layoutInflater.inflate(2130904964, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1783587632, a);
        return inflate;
    }
}
