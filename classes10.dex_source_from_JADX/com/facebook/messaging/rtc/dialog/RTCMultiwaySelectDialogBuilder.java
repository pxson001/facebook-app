package com.facebook.messaging.rtc.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnShowListener;
import android.widget.Button;
import com.facebook.auth.module.String_ViewerContextUserIdMethodAutoProvider;
import com.facebook.common.util.ContextUtils;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.ContactPickerUserRow.ContactRowSectionType;
import com.facebook.contacts.picker.ContactPickerView;
import com.facebook.contacts.picker.ContactPickerView.OnRowClickedListener;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.contacts.picker.ContactPickerRowsFactory;
import com.facebook.messaging.contacts.picker.ContactPickerViewIndexableListAdapter;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.rtc.helpers.RtcCallHandler;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: refuseCodes */
public class RTCMultiwaySelectDialogBuilder {
    public final Context f3805a;
    public final RtcCallHandler f3806b;
    private final ContactPickerRowsFactory f3807c;
    private final String f3808d;
    private final QeAccessor f3809e;
    public final Toaster f3810f;
    private final GatekeeperStoreImpl f3811g;
    public final ContactPickerViewIndexableListAdapter f3812h = new ContactPickerViewIndexableListAdapter(this.f3813i);
    private final Context f3813i = ContextUtils.a(this.f3805a, 2130772969, 2131625113);
    private final UserCache f3814j;
    public int f3815k;

    /* compiled from: refuseCodes */
    class C05851 implements OnClickListener {
        final /* synthetic */ RTCMultiwaySelectDialogBuilder f3796a;

        C05851(RTCMultiwaySelectDialogBuilder rTCMultiwaySelectDialogBuilder) {
            this.f3796a = rTCMultiwaySelectDialogBuilder;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: refuseCodes */
    class C05884 implements OnShowListener {
        final /* synthetic */ RTCMultiwaySelectDialogBuilder f3804a;

        C05884(RTCMultiwaySelectDialogBuilder rTCMultiwaySelectDialogBuilder) {
            this.f3804a = rTCMultiwaySelectDialogBuilder;
        }

        public void onShow(DialogInterface dialogInterface) {
            ((AlertDialog) dialogInterface).a(-1).setEnabled(this.f3804a.f3815k > 0);
        }
    }

    public static RTCMultiwaySelectDialogBuilder m3600a(InjectorLike injectorLike) {
        return new RTCMultiwaySelectDialogBuilder((Context) injectorLike.getInstance(Context.class), RtcCallHandler.a(injectorLike), ContactPickerRowsFactory.m1786b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), Toaster.b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), String_ViewerContextUserIdMethodAutoProvider.b(injectorLike), UserCache.a(injectorLike));
    }

    @Inject
    public RTCMultiwaySelectDialogBuilder(Context context, RtcCallHandler rtcCallHandler, ContactPickerRowsFactory contactPickerRowsFactory, QeAccessor qeAccessor, Toaster toaster, GatekeeperStoreImpl gatekeeperStoreImpl, String str, UserCache userCache) {
        this.f3805a = context;
        this.f3806b = rtcCallHandler;
        this.f3807c = contactPickerRowsFactory;
        this.f3809e = qeAccessor;
        this.f3810f = toaster;
        this.f3811g = gatekeeperStoreImpl;
        this.f3808d = str;
        this.f3814j = userCache;
    }

    public final boolean m3602a() {
        return this.f3811g.a(1090, false);
    }

    public final void m3601a(final ThreadSummary threadSummary, final boolean z, final String str) {
        boolean z2;
        final int f = this.f3806b.f() - 1;
        int a = this.f3809e.a(ExperimentsForRtcModule.df, 4);
        Builder builder = ImmutableList.builder();
        if (threadSummary.h.size() <= a) {
            z2 = true;
        } else {
            z2 = false;
        }
        ImmutableList immutableList = threadSummary.h;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
            if (threadParticipant.b().b() == null || !threadParticipant.b().b().contentEquals(this.f3808d)) {
                User a2 = this.f3814j.a(threadParticipant.b());
                if (a2 != null) {
                    builder.c(this.f3807c.m1792b(a2, ContactRowSectionType.FAVORITES, z2));
                }
            }
        }
        final AlertDialog a3 = new FbAlertDialogBuilder(this.f3805a).a(2131241321).a(2131241322, new OnClickListener(this) {
            final /* synthetic */ RTCMultiwaySelectDialogBuilder f3800d;

            public void onClick(DialogInterface dialogInterface, int i) {
                List arrayList = new ArrayList();
                List arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < this.f3800d.f3812h.getCount(); i2++) {
                    ContactPickerUserRow contactPickerUserRow = (ContactPickerUserRow) this.f3800d.f3812h.getItem(i2);
                    arrayList2.add(contactPickerUserRow.a.a);
                    if (contactPickerUserRow.d()) {
                        arrayList.add(contactPickerUserRow.a.a);
                    }
                }
                this.f3800d.f3806b.a(Long.toString(threadSummary.a.i()), (String[]) arrayList2.toArray(new String[arrayList2.size()]), (String[]) arrayList.toArray(new String[arrayList.size()]), z, str, this.f3800d.f3805a);
            }
        }).b(2131241323, new C05851(this)).a();
        if (z2) {
            this.f3815k = threadSummary.h.size() - 1;
        } else {
            this.f3815k = 0;
        }
        ContactPickerView contactPickerView = new ContactPickerView(this.f3813i, 2130906921);
        ((BetterTextView) contactPickerView.findViewById(2131567168)).setText(2131241324);
        contactPickerView.setAdapter(this.f3812h);
        contactPickerView.c = new OnRowClickedListener(this) {
            final /* synthetic */ RTCMultiwaySelectDialogBuilder f3803c;

            public final void m3599a(ContactPickerRow contactPickerRow, int i) {
                boolean z = true;
                ContactPickerUserRow contactPickerUserRow = (ContactPickerUserRow) contactPickerRow;
                RTCMultiwaySelectDialogBuilder rTCMultiwaySelectDialogBuilder;
                if (contactPickerUserRow.d()) {
                    contactPickerUserRow.a(false);
                    rTCMultiwaySelectDialogBuilder = this.f3803c;
                    rTCMultiwaySelectDialogBuilder.f3815k--;
                } else if (this.f3803c.f3815k >= f) {
                    this.f3803c.f3810f.a(new ToastBuilder(this.f3803c.f3805a.getResources().getQuantityString(2131689795, f, new Object[]{Integer.valueOf(f)})));
                } else {
                    contactPickerUserRow.a(true);
                    rTCMultiwaySelectDialogBuilder = this.f3803c;
                    rTCMultiwaySelectDialogBuilder.f3815k++;
                }
                Button a = a3.a(-1);
                if (this.f3803c.f3815k <= 0) {
                    z = false;
                }
                a.setEnabled(z);
                AdapterDetour.a(this.f3803c.f3812h, -527716134);
            }
        };
        a3.setOnShowListener(new C05884(this));
        contactPickerView.a(builder.b());
        a3.a(contactPickerView, 10, 10, 10, 10);
        a3.show();
    }
}
