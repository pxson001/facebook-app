package com.facebook.messaging.sms.migration;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.sms.migration.ContactMatchingOperationLogic.Listener;
import com.facebook.messaging.sms.migration.ContactMatchingOperationLogic.OperationType;
import com.facebook.messaging.sms.migration.SMSContactPickerConfig.PickerMode;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: pyml_items_fetch */
public class SMSUploadAndMatchFragment extends SMSUploadFragment {
    public SMSContactMigrationDialogHelper am;
    @Inject
    public ContactMatchingOperationLogic f4212b;
    @Inject
    public SMSContactMigrationDialogHelperProvider f4213c;

    /* compiled from: pyml_items_fetch */
    class C06321 implements Listener {
        final /* synthetic */ SMSUploadAndMatchFragment f4202a;

        C06321(SMSUploadAndMatchFragment sMSUploadAndMatchFragment) {
            this.f4202a = sMSUploadAndMatchFragment;
        }

        public final void mo118a() {
            this.f4202a.am.m3790a();
        }

        public final void mo119b() {
            this.f4202a.am.m3791b();
        }
    }

    /* compiled from: pyml_items_fetch */
    class C06332 extends AbstractDisposableFutureCallback<ContactMatchingOperationResult> {
        final /* synthetic */ SMSUploadAndMatchFragment f4203a;

        C06332(SMSUploadAndMatchFragment sMSUploadAndMatchFragment) {
            this.f4203a = sMSUploadAndMatchFragment;
        }

        protected final void m3847a(Object obj) {
            ImmutableList subList;
            ContactMatchingOperationResult contactMatchingOperationResult = (ContactMatchingOperationResult) obj;
            SMSUploadAndMatchFragment sMSUploadAndMatchFragment = this.f4203a;
            if (contactMatchingOperationResult.f4123b.size() > 5) {
                subList = contactMatchingOperationResult.f4123b.subList(0, 5);
            } else {
                subList = contactMatchingOperationResult.f4123b;
            }
            if (subList.isEmpty()) {
                SMSUploadAndMatchFragment.ar(sMSUploadAndMatchFragment);
                return;
            }
            ArrayList arrayList = new ArrayList(subList);
            Bundle bundle = new Bundle();
            bundle.putString("picker_mode_param", PickerMode.MATCHED.toString());
            bundle.putParcelableArrayList("matched_contacts_param", arrayList);
            Intent intent = SMSContactsMigratorConstants.f4179a;
            intent.putExtras(bundle);
            sMSUploadAndMatchFragment.b(intent);
        }

        protected final void m3848a(Throwable th) {
            SMSUploadAndMatchFragment.ar(this.f4203a);
        }
    }

    /* compiled from: pyml_items_fetch */
    class C06343 implements OnClickListener {
        final /* synthetic */ SMSUploadAndMatchFragment f4204a;

        C06343(SMSUploadAndMatchFragment sMSUploadAndMatchFragment) {
            this.f4204a = sMSUploadAndMatchFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f4204a.b(SMSContactsMigratorConstants.f4180b);
        }
    }

    /* compiled from: pyml_items_fetch */
    class C06354 implements OnDismissListener {
        final /* synthetic */ SMSUploadAndMatchFragment f4205a;

        C06354(SMSUploadAndMatchFragment sMSUploadAndMatchFragment) {
            this.f4205a = sMSUploadAndMatchFragment;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f4205a.b(SMSContactsMigratorConstants.f4180b);
        }
    }

    public static void m3856a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        SMSUploadAndMatchFragment sMSUploadAndMatchFragment = (SMSUploadAndMatchFragment) obj;
        ContactMatchingOperationLogic b = ContactMatchingOperationLogic.m3775b(injectorLike);
        SMSContactMigrationDialogHelperProvider sMSContactMigrationDialogHelperProvider = (SMSContactMigrationDialogHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SMSContactMigrationDialogHelperProvider.class);
        sMSUploadAndMatchFragment.f4212b = b;
        sMSUploadAndMatchFragment.f4213c = sMSContactMigrationDialogHelperProvider;
    }

    public final void a_(Context context) {
        super.a_(context);
        Class cls = SMSUploadAndMatchFragment.class;
        m3856a(this, getContext());
        this.am = this.f4213c.m3794a(kO_());
        this.f4212b.f4121i = new C06321(this);
    }

    public final void m3858d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 595382968);
        super.d(bundle);
        if (ContactMatchingOperationLogic.m3772a(bundle) == OperationType.COMBINED_FETCH) {
            mo123e();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1198251951, a);
    }

    protected final void mo123e() {
        this.al.m3867a();
        this.f4212b.m3778a(new C06332(this));
    }

    protected final void aq() {
        b(SMSContactsMigratorConstants.f4180b);
    }

    public static void ar(SMSUploadAndMatchFragment sMSUploadAndMatchFragment) {
        SMSContactMigrationDialogHelper sMSContactMigrationDialogHelper = sMSUploadAndMatchFragment.am;
        OnClickListener c06343 = new C06343(sMSUploadAndMatchFragment);
        new FbAlertDialogBuilder(sMSContactMigrationDialogHelper.f4134a).a(2131240069, c06343).a(new C06354(sMSUploadAndMatchFragment)).a(2131240075).b(2131240076).b();
    }

    public final void m3860e(Bundle bundle) {
        super.e(bundle);
        this.f4212b.m3779b(bundle);
    }

    public final void m3857I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1051148796);
        super.I();
        this.f4212b.m3777a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1432525408, a);
    }
}
