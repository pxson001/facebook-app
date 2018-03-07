package com.facebook.messaging.groups.threadactions;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.auth.annotations.LoggedInUserKey;
import com.facebook.fbservice.ops.BlueServiceFragment;
import com.facebook.fbservice.ops.BlueServiceOperation.OnCompletedListener;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.service.model.AddAdminsToGroupParams;
import com.facebook.messaging.service.model.RemoveAdminsFromGroupParams;
import com.facebook.messaging.service.model.RemoveMemberParams;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.NonDismissingAlertDialogFragment;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.ultralight.Inject;
import com.facebook.user.model.UserFbidIdentifier;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Provider;

/* compiled from: sharing_upsell */
public class AdminActionDialogFragment extends NonDismissingAlertDialogFragment {
    @Inject
    public ErrorDialogs am;
    @Inject
    @LoggedInUserKey
    public Provider<UserKey> an;
    private BlueServiceFragment ao;
    private ThreadKey ap;
    private UserKey aq;
    private String ar;
    private String as;

    /* compiled from: sharing_upsell */
    class C04251 implements OnClickListener {
        final /* synthetic */ AdminActionDialogFragment f2541a;

        C04251(AdminActionDialogFragment adminActionDialogFragment) {
            this.f2541a = adminActionDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f2541a.a();
        }
    }

    /* compiled from: sharing_upsell */
    class C04262 implements OnClickListener {
        final /* synthetic */ AdminActionDialogFragment f2542a;

        C04262(AdminActionDialogFragment adminActionDialogFragment) {
            this.f2542a = adminActionDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            AdminActionDialogFragment.ar(this.f2542a);
        }
    }

    /* compiled from: sharing_upsell */
    class C04283 extends OnCompletedListener {
        final /* synthetic */ AdminActionDialogFragment f2544a;

        /* compiled from: sharing_upsell */
        class C04271 implements OnClickListener {
            final /* synthetic */ C04283 f2543a;

            C04271(C04283 c04283) {
                this.f2543a = c04283;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f2543a.f2544a.a();
            }
        }

        C04283(AdminActionDialogFragment adminActionDialogFragment) {
            this.f2544a = adminActionDialogFragment;
        }

        public final void m2558a(OperationResult operationResult) {
            this.f2544a.b();
        }

        public final void m2559a(ServiceException serviceException) {
            ErrorDialogs errorDialogs = this.f2544a.am;
            ErrorDialogParamsBuilder a = ErrorDialogParams.a(this.f2544a.jW_()).a(2131230721);
            a.f = serviceException;
            a = a;
            a.g = new C04271(this);
            errorDialogs.a(a.l());
        }
    }

    public static void m2561a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        AdminActionDialogFragment adminActionDialogFragment = (AdminActionDialogFragment) obj;
        ErrorDialogs a = ErrorDialogs.a(fbInjector);
        Provider a2 = IdBasedProvider.a(fbInjector, 3597);
        adminActionDialogFragment.am = a;
        adminActionDialogFragment.an = a2;
    }

    public static AdminActionDialogFragment m2560a(AdminActionDialogParams adminActionDialogParams) {
        AdminActionDialogFragment adminActionDialogFragment = new AdminActionDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("thread_key", adminActionDialogParams.f2552a);
        bundle.putParcelable("user_key", adminActionDialogParams.f2553b);
        bundle.putString("title_text", adminActionDialogParams.f2554c);
        bundle.putString("body_text", adminActionDialogParams.f2555d);
        bundle.putString("confirm_button_text", adminActionDialogParams.f2556e);
        bundle.putString("loading_text", adminActionDialogParams.f2557f);
        bundle.putString("operation_type", adminActionDialogParams.f2558g);
        adminActionDialogFragment.g(bundle);
        return adminActionDialogFragment;
    }

    public final void m2562a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1926995773);
        super.a(bundle);
        Class cls = AdminActionDialogFragment.class;
        m2561a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -348169792, a);
    }

    public final FbAlertDialogBuilder aq() {
        boolean z;
        boolean z2 = true;
        Bundle bundle = this.s;
        this.ap = (ThreadKey) bundle.getParcelable("thread_key");
        this.aq = (UserKey) bundle.getParcelable("user_key");
        CharSequence string = bundle.getString("title_text");
        CharSequence string2 = bundle.getString("body_text");
        CharSequence string3 = bundle.getString("confirm_button_text");
        this.ar = bundle.getString("operation_type");
        this.as = bundle.getString("loading_text");
        Preconditions.checkNotNull(this.ap);
        Preconditions.checkNotNull(this.aq);
        Preconditions.checkArgument(!Strings.isNullOrEmpty(string));
        if (Strings.isNullOrEmpty(string2)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (Strings.isNullOrEmpty(string3)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (Strings.isNullOrEmpty(this.ar)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (Strings.isNullOrEmpty(this.as)) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(getContext());
        fbAlertDialogBuilder.a(string).b(string2).a(string3, new C04262(this)).b(17039360, new C04251(this));
        return fbAlertDialogBuilder;
    }

    public static void ar(AdminActionDialogFragment adminActionDialogFragment) {
        if (adminActionDialogFragment.ao == null) {
            Bundle bundle = new Bundle();
            String str = adminActionDialogFragment.ar;
            Object obj = -1;
            switch (str.hashCode()) {
                case 1161540277:
                    if (str.equals("remove_member")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 1358248696:
                    if (str.equals("add_admins_to_group")) {
                        obj = null;
                        break;
                    }
                    break;
                case 1888614090:
                    if (str.equals("remove_admins_from_group")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    bundle.putParcelable(AddAdminsToGroupParams.a, new AddAdminsToGroupParams(ImmutableList.of(adminActionDialogFragment.aq), adminActionDialogFragment.ap));
                    adminActionDialogFragment.ao = BlueServiceFragment.a(adminActionDialogFragment.D, "addAdminsOperation");
                    break;
                case 1:
                    bundle.putParcelable(RemoveAdminsFromGroupParams.a, new RemoveAdminsFromGroupParams(ImmutableList.of(adminActionDialogFragment.aq), adminActionDialogFragment.ap));
                    adminActionDialogFragment.ao = BlueServiceFragment.a(adminActionDialogFragment.D, "removeAdminsOperation");
                    break;
                case 2:
                    Parcelable removeMemberParams;
                    UserFbidIdentifier userFbidIdentifier = new UserFbidIdentifier(adminActionDialogFragment.aq.b());
                    if (((UserKey) adminActionDialogFragment.an.get()).equals(adminActionDialogFragment.aq)) {
                        removeMemberParams = new RemoveMemberParams(adminActionDialogFragment.ap, true, ImmutableList.of(userFbidIdentifier));
                    } else {
                        removeMemberParams = RemoveMemberParams.b(adminActionDialogFragment.ap, userFbidIdentifier);
                    }
                    bundle.putParcelable("removeMemberParams", removeMemberParams);
                    adminActionDialogFragment.ao = BlueServiceFragment.a(adminActionDialogFragment.D, "removeMemberOperation");
                    break;
                default:
                    throw new IllegalArgumentException("Unable to process Operation Type: " + adminActionDialogFragment.ar + " for AdminDialogFragment.");
            }
            adminActionDialogFragment.ao.b = new C04283(adminActionDialogFragment);
            adminActionDialogFragment.ao.a(new DialogBasedProgressIndicator(adminActionDialogFragment.getContext(), adminActionDialogFragment.as));
            adminActionDialogFragment.ao.a(adminActionDialogFragment.ar, bundle);
        }
    }
}
