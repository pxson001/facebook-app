package com.facebook.katana;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.devicebasedlogin.settings.DBLLoggedInAccountSettingsController;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import javax.inject.Inject;

/* compiled from: SEND_FAILED_PUBLISH_FAILED_WITH_EXCEPTION */
public class DBLLoggedInAccountSettingsFragment extends FbFragment {
    @Inject
    public DBLLoggedInAccountSettingsController f24093a;
    @Inject
    public DBLSettingsAdapterProvider f24094b;
    public BetterRecyclerView f24095c;
    public DBLSettingsAdapter f24096d;

    public static void m25398a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        DBLLoggedInAccountSettingsFragment dBLLoggedInAccountSettingsFragment = (DBLLoggedInAccountSettingsFragment) obj;
        DBLLoggedInAccountSettingsController a = DBLLoggedInAccountSettingsController.a(fbInjector);
        DBLSettingsAdapterProvider dBLSettingsAdapterProvider = (DBLSettingsAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(DBLSettingsAdapterProvider.class);
        dBLLoggedInAccountSettingsFragment.f24093a = a;
        dBLLoggedInAccountSettingsFragment.f24094b = dBLSettingsAdapterProvider;
    }

    public final void m25400c(Bundle bundle) {
        super.c(bundle);
        Class cls = DBLLoggedInAccountSettingsFragment.class;
        m25398a(this, getContext());
    }

    public final View m25399a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -827724220);
        View inflate = layoutInflater.inflate(2130903861, viewGroup, false);
        this.f24095c = (BetterRecyclerView) inflate.findViewById(2131560925);
        int applyDimension = (int) TypedValue.applyDimension(1, 16.0f, jW_().getDisplayMetrics());
        this.f24095c.setPadding(applyDimension, 0, applyDimension, 0);
        CustomViewUtils.b(inflate, new ColorDrawable(jW_().getColor(2131361920)));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1226101123, a);
        return inflate;
    }

    public final void m25401d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -360333483);
        super.d(bundle);
        this.f24096d = this.f24094b.m25462a(this.f24093a.c(), o());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(o());
        this.f24095c.setAdapter(this.f24096d);
        this.f24095c.setLayoutManager(linearLayoutManager);
        this.f24095c.a(new DividerItemDecoration(o()));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1233392371, a);
    }
}
