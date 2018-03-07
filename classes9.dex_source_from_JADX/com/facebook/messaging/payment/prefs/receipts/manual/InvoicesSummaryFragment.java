package com.facebook.messaging.payment.prefs.receipts.manual;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewSwitcher;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.common.activity.BusinessActivity;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.EventListener;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: getIncomingRequestIds */
public class InvoicesSummaryFragment extends FbFragment implements BusinessActivityFragment {
    @Inject
    public InvoicesSummaryPresenterProvider f14217a;
    @Nullable
    private EventListener f14218b;
    @Nullable
    private InvoicesSummaryPresenter f14219c;
    private String f14220d;

    /* compiled from: getIncomingRequestIds */
    public class Factory implements com.facebook.messaging.business.common.activity.BusinessActivityFragment.Factory {
        public final String mo307a() {
            return "InvoicesSummaryFragment";
        }

        public final BusinessActivityFragment mo308b() {
            return new InvoicesSummaryFragment();
        }
    }

    public static void m14669a(Object obj, Context context) {
        ((InvoicesSummaryFragment) obj).f14217a = (InvoicesSummaryPresenterProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(InvoicesSummaryPresenterProvider.class);
    }

    public static Intent m14671c(Context context, String str) {
        Parcelable bundle = new Bundle();
        bundle.putString("InvoicesSummaryFragment_KEY_TRANSACTION_ID", str);
        return BusinessActivity.m8889a(context, "InvoicesSummaryFragment", bundle);
    }

    public final void mo310a(Parcelable parcelable) {
        m14672n((Bundle) parcelable);
    }

    public final String mo309a(Context context) {
        return context.getString(2131240597);
    }

    public final void mo311a(EventListener eventListener) {
        this.f14218b = eventListener;
        m14670b();
    }

    private void m14670b() {
        if (this.f14219c != null) {
            this.f14219c.f14227f = this.f14218b;
        }
    }

    public final void m14679c(Bundle bundle) {
        super.c(bundle);
        Class cls = InvoicesSummaryFragment.class;
        m14669a((Object) this, getContext());
    }

    public final View m14674a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 22110429);
        View inflate = layoutInflater.inflate(2130903643, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1795049608, a);
        return inflate;
    }

    public final void m14673I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 132045333);
        super.I();
        if (this.f14219c != null) {
            this.f14219c.f14222a.f14158b.c();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 507996089, a);
    }

    public final void m14677a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        m14672n(this.s);
        this.f14219c = this.f14217a.m14682a(new InvoicesSummaryView((RecyclerView) FindViewUtil.b(view, 2131560475), (ViewSwitcher) FindViewUtil.b(view, 2131560463), new LinearLayoutManager(o())), this.f14220d);
        m14670b();
    }

    private void m14672n(Bundle bundle) {
        if (this.f14220d == null) {
            this.f14220d = bundle.getString("InvoicesSummaryFragment_KEY_TRANSACTION_ID");
            Preconditions.checkArgument(!StringUtil.a(this.f14220d));
        }
    }
}
