package com.facebook.orca.contacts.divebar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.util.ContextUtils;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.ContactPickerUserRow.ContactRowSectionType;
import com.facebook.contacts.picker.ContactPickerView;
import com.facebook.contacts.picker.ContactPickerView.EmptyState;
import com.facebook.contacts.picker.ContactPickerView.OnRowClickedListener;
import com.facebook.debug.log.BLog;
import com.facebook.divebar.DrawerBasedDivebarControllerImpl;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.activity.DivebarEnabledActivity;
import com.facebook.messaging.contacts.picker.ContactPickerRowsFactory;
import com.facebook.orca.contacts.picker.service.ContactPickerNearbyResult;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.drawers.DrawerContentFragment;
import com.facebook.ui.drawers.DrawerFragmentContentController;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;

/* compiled from: on_demand_waiting_for_load */
public class DivebarNearbyFriendsFragment extends DrawerContentFragment {
    public static final Class<?> f5851a = DivebarNearbyFriendsFragment.class;
    private ContactPickerRowsFactory f5852b;
    public DefaultBlueServiceOperationFactory f5853c;
    public ExecutorService f5854d;
    private ContactPickerView f5855e;
    private View f5856f;
    private DivebarNearbyFriendsListAdapter f5857g;
    public DivebarViewListener f5858h;
    public FutureAndCallbackHolder<OperationResult> f5859i;

    /* compiled from: on_demand_waiting_for_load */
    class C08591 implements OnRowClickedListener {
        final /* synthetic */ DivebarNearbyFriendsFragment f5848a;

        C08591(DivebarNearbyFriendsFragment divebarNearbyFriendsFragment) {
            this.f5848a = divebarNearbyFriendsFragment;
        }

        public final void m5525a(ContactPickerRow contactPickerRow, int i) {
            ContactPickerUserRow contactPickerUserRow = (ContactPickerUserRow) contactPickerRow;
            if (this.f5848a.f5858h != null) {
                this.f5848a.f5858h.m5547a(contactPickerUserRow.a, true, contactPickerUserRow, "friends_nearby_divebar_msg", i);
            }
        }
    }

    /* compiled from: on_demand_waiting_for_load */
    class C08602 implements OnClickListener {
        final /* synthetic */ DivebarNearbyFriendsFragment f5849a;

        C08602(DivebarNearbyFriendsFragment divebarNearbyFriendsFragment) {
            this.f5849a = divebarNearbyFriendsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1065562410);
            Context context = this.f5849a.getContext();
            if (context instanceof DivebarEnabledActivity) {
                DrawerBasedDivebarControllerImpl f = ((DivebarEnabledActivity) context).f();
                if (f instanceof DrawerFragmentContentController) {
                    ((DrawerFragmentContentController) f).m();
                    Logger.a(2, EntryType.UI_INPUT_END, -2142426996, a);
                    return;
                }
            }
            this.f5849a.D.d();
            LogUtils.a(2123989917, a);
        }
    }

    /* compiled from: on_demand_waiting_for_load */
    public class C08613 extends OperationResultFutureCallback {
        final /* synthetic */ DivebarNearbyFriendsFragment f5850a;

        public C08613(DivebarNearbyFriendsFragment divebarNearbyFriendsFragment) {
            this.f5850a = divebarNearbyFriendsFragment;
        }

        protected final void m5527a(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            this.f5850a.f5859i = null;
            DivebarNearbyFriendsFragment.m5528a(this.f5850a, ((ContactPickerNearbyResult) operationResult.h()).f6103a);
        }

        protected final void m5526a(ServiceException serviceException) {
            this.f5850a.f5859i = null;
            BLog.a(DivebarNearbyFriendsFragment.f5851a, "Failure to load nearby friends", serviceException);
            DivebarNearbyFriendsFragment.m5528a(this.f5850a, RegularImmutableList.a);
        }
    }

    public final void m5531c(Bundle bundle) {
        super.c(bundle);
        FbInjector an = an();
        this.f5852b = ContactPickerRowsFactory.m1786b(an);
        this.f5853c = DefaultBlueServiceOperationFactory.b(an);
        this.f5854d = (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(an);
    }

    public final View m5530a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1114076783);
        Context a2 = ContextUtils.a(getContext(), 2130772966, 2131625115);
        this.f5857g = new DivebarNearbyFriendsListAdapter(a2);
        this.f5855e = new ContactPickerView(a2, 2130905672);
        this.f5855e.setAdapter(this.f5857g);
        this.f5855e.c = new C08591(this);
        this.f5856f = this.f5855e.findViewById(2131564802);
        this.f5856f.setOnClickListener(new C08602(this));
        this.f5855e.a(EmptyState.LOADING);
        ContactPickerView contactPickerView = this.f5855e;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1556082658, a);
        return contactPickerView;
    }

    public final void m5529G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1655773031);
        super.G();
        if (this.f5859i == null) {
            OperationFuture a2 = BlueServiceOperationFactoryDetour.a(this.f5853c, "fetch_nearby_suggestions", new Bundle(), -1727397859).a();
            C08613 c08613 = new C08613(this);
            this.f5859i = FutureAndCallbackHolder.a(a2, c08613);
            Futures.a(a2, c08613, this.f5854d);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1985530213, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1224897579);
        super.mY_();
        if (this.f5859i != null) {
            this.f5859i.a(false);
            this.f5859i = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -50308524, a);
    }

    public static void m5528a(DivebarNearbyFriendsFragment divebarNearbyFriendsFragment, ImmutableList immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(divebarNearbyFriendsFragment.f5852b.m1789a((User) immutableList.get(i), ContactRowSectionType.NEARBY));
        }
        divebarNearbyFriendsFragment.f5855e.a(builder.b());
    }
}
