package com.facebook.messaging.sms.migration;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.actionbar.AppCompatFragmentOverrider;
import com.facebook.actionbar.FragmentActionBarHost;
import com.facebook.base.fragment.AbstractNavigableFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.ui.util.ViewReplacementUtil;
import com.facebook.contactlogs.migrator.TopSmsContact;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.picker.ContactPickerView;
import com.facebook.contacts.picker.ContactPickerView.OnRowClickedListener;
import com.facebook.contacts.picker.PickableContactPickerRow;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.sms.migration.ContactMatchingOperationLogic.Listener;
import com.facebook.messaging.sms.migration.ContactMatchingOperationLogic.OperationType;
import com.facebook.messaging.sms.migration.SMSContactPickerConfig.PickerMode;
import com.facebook.messaging.sms.migration.util.ContactMatchingUtil;
import com.facebook.messaging.sms.migration.util.SMSContactsMigrationTextUtil;
import com.facebook.messaging.sms.migration.util.SMSUploadUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: qrcode_camera_not_loaded */
public class SMSContactPickerFragment extends AbstractNavigableFragment {
    public TextView al;
    public int am;
    public int an;
    public SMSContactPickerAdapter ao;
    public SMSContactPickerConfig ap;
    @Inject
    public AppCompatFragmentOverrider f4160b;
    @Inject
    public ContactMatchingOperationLogic f4161c;
    @Inject
    SMSContactPickerAdapterProvider f4162d;
    @Inject
    SMSContactPickerConfigProvider f4163e;
    @Inject
    SMSContactMigrationDialogHelperProvider f4164f;
    @Inject
    SMSUploadUtil f4165g;
    SMSContactMigrationDialogHelper f4166h;
    public ContactPickerView f4167i;

    /* compiled from: qrcode_camera_not_loaded */
    class C06181 implements Listener {
        final /* synthetic */ SMSContactPickerFragment f4151a;

        C06181(SMSContactPickerFragment sMSContactPickerFragment) {
            this.f4151a = sMSContactPickerFragment;
        }

        public final void mo118a() {
            this.f4151a.f4166h.m3790a();
        }

        public final void mo119b() {
            this.f4151a.f4166h.m3791b();
        }
    }

    /* compiled from: qrcode_camera_not_loaded */
    public class C06192 implements OnRowClickedListener {
        final /* synthetic */ SMSContactPickerFragment f4152a;

        public C06192(SMSContactPickerFragment sMSContactPickerFragment) {
            this.f4152a = sMSContactPickerFragment;
        }

        public final void m3811a(ContactPickerRow contactPickerRow, int i) {
            this.f4152a.ao.m3797a(contactPickerRow, i);
            SMSContactPickerFragment.at(this.f4152a);
        }
    }

    /* compiled from: qrcode_camera_not_loaded */
    public class C06203 implements OnClickListener {
        final /* synthetic */ SMSContactPickerFragment f4153a;

        public C06203(SMSContactPickerFragment sMSContactPickerFragment) {
            this.f4153a = sMSContactPickerFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 155476968);
            switch (this.f4153a.ap.f4147a) {
                case LOCAL:
                    SMSContactPickerFragment.av(this.f4153a);
                    break;
                case MATCHED:
                    ArrayList arrayList = new ArrayList();
                    ImmutableList immutableList = this.f4153a.ao.f4143d;
                    int size = immutableList.size();
                    for (int i = 0; i < size; i++) {
                        ContactPickerRow contactPickerRow = (ContactPickerRow) immutableList.get(i);
                        if ((contactPickerRow instanceof SMSMatchedContactRow) && ((SMSMatchedContactRow) contactPickerRow).d()) {
                            arrayList.add(String.valueOf(((SMSMatchedContactRow) contactPickerRow).f4191a));
                        }
                    }
                    this.f4153a.f4165g.m3868a(arrayList);
                    this.f4153a.mo120e();
                    break;
            }
            LogUtils.a(-649306615, a);
        }
    }

    /* compiled from: qrcode_camera_not_loaded */
    class C06214 implements OnClickListener {
        final /* synthetic */ SMSContactPickerFragment f4154a;

        C06214(SMSContactPickerFragment sMSContactPickerFragment) {
            this.f4154a = sMSContactPickerFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1786133545);
            this.f4154a.mo120e();
            Logger.a(2, EntryType.UI_INPUT_END, 522869998, a);
        }
    }

    /* compiled from: qrcode_camera_not_loaded */
    public class C06225 extends AbstractDisposableFutureCallback<ImmutableList<TopSmsContact>> {
        final /* synthetic */ SMSContactPickerFragment f4155a;

        public C06225(SMSContactPickerFragment sMSContactPickerFragment) {
            this.f4155a = sMSContactPickerFragment;
        }

        protected final void m3812a(Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            Builder builder = ImmutableList.builder();
            if (immutableList != null) {
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    TopSmsContact topSmsContact = (TopSmsContact) immutableList.get(i);
                    SMSLocalContactRowBuilder c = SMSLocalContactRow.m3835c();
                    c.f4188b = topSmsContact.b;
                    c = c;
                    c.f4187a = topSmsContact.a;
                    c = c;
                    c.f4189c = topSmsContact.c;
                    c = c;
                    c.f4190d = topSmsContact.d;
                    PickableContactPickerRow b = c.m3838b();
                    b.a(true);
                    builder.c(b);
                }
            }
            ImmutableList b2 = builder.b();
            if (b2.isEmpty()) {
                SMSContactPickerFragment.aw(this.f4155a);
                return;
            }
            this.f4155a.f4167i.a(b2);
            AdapterDetour.a(this.f4155a.ao, 1923051280);
            SMSContactPickerFragment.at(this.f4155a);
        }

        protected final void m3813a(Throwable th) {
            SMSContactPickerFragment.aw(this.f4155a);
        }
    }

    /* compiled from: qrcode_camera_not_loaded */
    class C06236 extends AbstractDisposableFutureCallback<ContactMatchingOperationResult> {
        final /* synthetic */ SMSContactPickerFragment f4156a;

        C06236(SMSContactPickerFragment sMSContactPickerFragment) {
            this.f4156a = sMSContactPickerFragment;
        }

        protected final void m3814a(Object obj) {
            ContactMatchingOperationResult contactMatchingOperationResult = (ContactMatchingOperationResult) obj;
            if (contactMatchingOperationResult.f4123b.isEmpty()) {
                SMSContactPickerFragment.ax(this.f4156a);
                return;
            }
            this.f4156a.f4167i.a(ImmutableList.builder().b(contactMatchingOperationResult.f4123b).b(contactMatchingOperationResult.f4124c).b());
            AdapterDetour.a(this.f4156a.ao, -1892007119);
            this.f4156a.ap.f4147a = PickerMode.MATCHED;
            SMSContactPickerFragment.at(this.f4156a);
            SMSContactPickerFragment sMSContactPickerFragment = this.f4156a;
            sMSContactPickerFragment.f4160b.f().a(sMSContactPickerFragment.ap.m3803a(sMSContactPickerFragment.ao.f4146g, sMSContactPickerFragment.ao.f4143d.size()));
        }

        protected final void m3815a(Throwable th) {
            SMSContactPickerFragment.ax(this.f4156a);
        }
    }

    /* compiled from: qrcode_camera_not_loaded */
    class C06247 implements DialogInterface.OnClickListener {
        final /* synthetic */ SMSContactPickerFragment f4157a;

        C06247(SMSContactPickerFragment sMSContactPickerFragment) {
            this.f4157a = sMSContactPickerFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f4157a.b(SMSContactsMigratorConstants.f4180b);
        }
    }

    /* compiled from: qrcode_camera_not_loaded */
    class C06258 implements OnDismissListener {
        final /* synthetic */ SMSContactPickerFragment f4158a;

        C06258(SMSContactPickerFragment sMSContactPickerFragment) {
            this.f4158a = sMSContactPickerFragment;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f4158a.b(SMSContactsMigratorConstants.f4180b);
        }
    }

    public static void m3818a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((SMSContactPickerFragment) obj).m3817a(AppCompatFragmentOverrider.a(injectorLike), ContactMatchingOperationLogic.m3775b(injectorLike), (SMSContactPickerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SMSContactPickerAdapterProvider.class), (SMSContactPickerConfigProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SMSContactPickerConfigProvider.class), (SMSContactMigrationDialogHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SMSContactMigrationDialogHelperProvider.class), SMSUploadUtil.m3866b(injectorLike));
    }

    public final void a_(Context context) {
        super.a_(context);
        Class cls = SMSContactPickerFragment.class;
        m3818a((Object) this, getContext());
    }

    public final void m3824c(@Nullable Bundle bundle) {
        super.c(bundle);
        SMSContactPickerConfigProvider sMSContactPickerConfigProvider = this.f4163e;
        String str = null;
        Bundle bundle2 = this.s;
        if (bundle != null) {
            str = bundle.getString("picker_mode_param");
        }
        if (str == null && bundle2 != null) {
            bundle2 = bundle2.getBundle("com.facebook.fragment.BUNDLE_EXTRAS");
            if (bundle2 != null) {
                str = bundle2.getString("picker_mode_param");
            }
        }
        if (str == null) {
            str = PickerMode.LOCAL.toString();
        }
        this.ap = new SMSContactPickerConfig(PickerMode.valueOf(str), (QeAccessor) QeInternalImplMethodAutoProvider.a(sMSContactPickerConfigProvider), ResourcesMethodAutoProvider.a(sMSContactPickerConfigProvider), SMSContactsMigrationTextUtil.m3864b(sMSContactPickerConfigProvider));
        SMSContactPickerAdapterProvider sMSContactPickerAdapterProvider = this.f4162d;
        this.ao = new SMSContactPickerAdapter(SMSContactsMigrationTextUtil.m3864b(sMSContactPickerAdapterProvider), this.ap);
        this.f4166h = this.f4164f.m3794a(kO_());
        this.f4161c.f4121i = new C06181(this);
        this.f4160b.b = new FragmentActionBarHost(this);
        a(this.f4160b);
        this.f4160b.a(8);
    }

    private void m3817a(AppCompatFragmentOverrider appCompatFragmentOverrider, ContactMatchingOperationLogic contactMatchingOperationLogic, SMSContactPickerAdapterProvider sMSContactPickerAdapterProvider, SMSContactPickerConfigProvider sMSContactPickerConfigProvider, SMSContactMigrationDialogHelperProvider sMSContactMigrationDialogHelperProvider, SMSUploadUtil sMSUploadUtil) {
        this.f4160b = appCompatFragmentOverrider;
        this.f4161c = contactMatchingOperationLogic;
        this.f4162d = sMSContactPickerAdapterProvider;
        this.f4163e = sMSContactPickerConfigProvider;
        this.f4164f = sMSContactMigrationDialogHelperProvider;
        this.f4165g = sMSUploadUtil;
    }

    public final View m3821a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -689645124);
        View inflate = layoutInflater.inflate(2130907520, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1722190950, a);
        return inflate;
    }

    public final void m3823a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        ImmutableList o = m3819o(bundle);
        this.f4167i = new ContactPickerView(getContext(), 2130905783);
        this.f4167i.setAdapter(this.ao);
        this.f4167i.a(o);
        this.f4167i.c = new C06192(this);
        ViewReplacementUtil.a((ViewGroup) e(2131568061).getParent(), 2131568061, this.f4167i);
        ActionBar f = this.f4160b.f();
        f.a(this.ap.m3803a(this.ao.f4146g, this.ao.f4143d.size()));
        f.a(this.ap.m3805b());
        f.d(2130837525);
        e(true);
        this.al = (TextView) e(2131568063);
        this.al.setText(this.ap.m3804b(this.ao.f4144e, this.ao.f4143d.size()));
        this.al.setOnClickListener(new C06203(this));
        this.am = jW_().getColor(2131363731);
        this.an = jW_().getColor(2131363732);
    }

    public final void m3822a(Menu menu) {
        super.a(menu);
        menu.clear();
    }

    public static void at(SMSContactPickerFragment sMSContactPickerFragment) {
        int i = sMSContactPickerFragment.ao.f4144e;
        int size = sMSContactPickerFragment.ao.f4143d.size();
        if (i == 0) {
            sMSContactPickerFragment.al.setTextColor(sMSContactPickerFragment.an);
            sMSContactPickerFragment.al.setClickable(false);
        } else {
            sMSContactPickerFragment.al.setTextColor(sMSContactPickerFragment.am);
            sMSContactPickerFragment.al.setClickable(true);
        }
        sMSContactPickerFragment.al.setText(sMSContactPickerFragment.ap.m3804b(i, size));
        TextView textView = (TextView) sMSContactPickerFragment.e(2131568062);
        if (sMSContactPickerFragment.ap.m3806c() && textView.getVisibility() != 0) {
            textView.setVisibility(0);
            textView.setText(sMSContactPickerFragment.ap.m3807d());
            textView.setTextColor(sMSContactPickerFragment.ap.m3808e());
            textView.setOnClickListener(new C06214(sMSContactPickerFragment));
        }
    }

    private ImmutableList<ContactPickerRow> m3819o(@Nullable Bundle bundle) {
        ImmutableList a = m3816a(bundle, "matched_contacts_param");
        return ImmutableList.builder().b(a).b(m3816a(bundle, "local_contacts_param")).b();
    }

    private <T> ImmutableList<T> m3816a(@Nullable Bundle bundle, String str) {
        ArrayList parcelableArrayList;
        Builder builder;
        int size;
        int i;
        ArrayList arrayList = null;
        Bundle bundle2 = this.s;
        if (bundle != null) {
            arrayList = bundle.getParcelableArrayList(str);
        }
        if (arrayList == null && bundle2 != null) {
            bundle2 = bundle2.getBundle("com.facebook.fragment.BUNDLE_EXTRAS");
            if (bundle2 != null) {
                parcelableArrayList = bundle2.getParcelableArrayList(str);
                builder = ImmutableList.builder();
                if (!(parcelableArrayList == null || parcelableArrayList.isEmpty())) {
                    size = parcelableArrayList.size();
                    for (i = 0; i < size; i++) {
                        builder.c((Parcelable) parcelableArrayList.get(i));
                    }
                }
                return builder.b();
            }
        }
        parcelableArrayList = arrayList;
        builder = ImmutableList.builder();
        size = parcelableArrayList.size();
        for (i = 0; i < size; i++) {
            builder.c((Parcelable) parcelableArrayList.get(i));
        }
        return builder.b();
    }

    public final void m3827e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("picker_mode_param", this.ap.f4147a.toString());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ImmutableList immutableList = this.ao.f4143d;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ContactPickerRow contactPickerRow = (ContactPickerRow) immutableList.get(i);
            if (contactPickerRow instanceof SMSLocalContactRow) {
                arrayList.add((SMSLocalContactRow) contactPickerRow);
            } else if (contactPickerRow instanceof SMSMatchedContactRow) {
                arrayList2.add((SMSMatchedContactRow) contactPickerRow);
            }
        }
        bundle.putParcelableArrayList("matched_contacts_param", arrayList2);
        bundle.putParcelableArrayList("local_contacts_param", arrayList);
        this.f4161c.m3779b(bundle);
    }

    public final void m3825d(Bundle bundle) {
        Object obj;
        Object obj2 = null;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1190728154);
        super.d(bundle);
        OperationType a2 = ContactMatchingOperationLogic.m3772a(bundle);
        if (this.ao.f4143d.isEmpty() && this.ap.f4147a == PickerMode.LOCAL) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null || a2 == OperationType.LOCAL_CONTACT_FETCH) {
            obj2 = 1;
        }
        if (obj2 != null) {
            this.f4167i.a();
            this.f4161c.m3780b(new C06225(this));
        } else if (a2 == OperationType.MATCHED_CONTACT_FETCH) {
            av(this);
        }
        LogUtils.f(305399679, a);
    }

    public static void av(SMSContactPickerFragment sMSContactPickerFragment) {
        ImmutableList immutableList = sMSContactPickerFragment.ao.f4143d;
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ContactPickerRow contactPickerRow = (ContactPickerRow) immutableList.get(i);
            if ((contactPickerRow instanceof SMSLocalContactRow) && ((SMSLocalContactRow) contactPickerRow).d()) {
                builder.c((SMSLocalContactRow) contactPickerRow);
            }
        }
        immutableList = ContactMatchingUtil.m3862c(builder.b());
        C06236 c06236 = new C06236(sMSContactPickerFragment);
        ContactMatchingOperationLogic contactMatchingOperationLogic = sMSContactPickerFragment.f4161c;
        contactMatchingOperationLogic.f4120h = OperationType.MATCHED_CONTACT_FETCH;
        contactMatchingOperationLogic.f4119g = ContactMatchingOperationLogic.m3774a(contactMatchingOperationLogic, immutableList);
        Futures.a(contactMatchingOperationLogic.f4119g, contactMatchingOperationLogic.f4118f, contactMatchingOperationLogic.f4114b);
        Futures.a(contactMatchingOperationLogic.f4119g, c06236, contactMatchingOperationLogic.f4114b);
        if (contactMatchingOperationLogic.f4121i != null) {
            contactMatchingOperationLogic.f4121i.mo118a();
        }
    }

    public static void aw(SMSContactPickerFragment sMSContactPickerFragment) {
        sMSContactPickerFragment.f4166h.m3792b(sMSContactPickerFragment.ay(), sMSContactPickerFragment.az());
    }

    public static void ax(SMSContactPickerFragment sMSContactPickerFragment) {
        sMSContactPickerFragment.f4166h.m3793c(sMSContactPickerFragment.ay(), sMSContactPickerFragment.az());
    }

    private DialogInterface.OnClickListener ay() {
        return new C06247(this);
    }

    private OnDismissListener az() {
        return new C06258(this);
    }

    void mo120e() {
        b(SMSContactsMigratorConstants.f4179a);
    }

    public final void m3820I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 522513566);
        super.I();
        this.f4161c.m3777a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 110417247, a);
    }
}
