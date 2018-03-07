package com.facebook.appinvites.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.appinvites.data.AppInvitesGraphqlMutationHelper;
import com.facebook.appinvites.events.AppInviteEvents.AppInviteAllDeletedEvent;
import com.facebook.appinvites.events.AppInvitesEventBus;
import com.facebook.appinvites.protocol.AppInvitesMutations.AppRequestDeleteAllCoreMutationString;
import com.facebook.appinvites.ui.AppInviteBlocksDialogProvider;
import com.facebook.base.fragment.FbFragment;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.graphql.calls.ApplicationRequestDeleteAllInputData;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;

/* compiled from: editNotificationSetting */
public class AppInvitesSettingsFragment extends FbFragment {
    @Inject
    public AppInvitesEventBus f14601a;
    @Inject
    public Toaster f14602b;
    @Inject
    public AppInvitesGraphqlMutationHelper f14603c;
    @Inject
    public AppInviteBlocksDialogProvider f14604d;
    public View f14605e;

    /* compiled from: editNotificationSetting */
    public class C20481 implements OnClickListener {
        final /* synthetic */ AppInvitesSettingsFragment f14598a;

        /* compiled from: editNotificationSetting */
        class C20471 implements DialogInterface.OnClickListener {
            final /* synthetic */ C20481 f14597a;

            C20471(C20481 c20481) {
                this.f14597a = c20481;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                AppInvitesGraphqlMutationHelper appInvitesGraphqlMutationHelper = this.f14597a.f14598a.f14603c;
                appInvitesGraphqlMutationHelper.f14577a.a(GraphQLRequest.a((AppRequestDeleteAllCoreMutationString) new AppRequestDeleteAllCoreMutationString().a("input", new ApplicationRequestDeleteAllInputData())));
                this.f14597a.f14598a.f14601a.a(new AppInviteAllDeletedEvent());
                this.f14597a.f14598a.f14602b.b(new ToastBuilder(2131241828));
            }
        }

        public C20481(AppInvitesSettingsFragment appInvitesSettingsFragment) {
            this.f14598a = appInvitesSettingsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1286788333);
            new Builder(this.f14598a.getContext()).a(this.f14598a.getContext().getString(2131241824)).b(this.f14598a.getContext().getString(2131241825)).a(this.f14598a.getContext().getString(2131241826), new C20471(this)).b(2131230727, null).b();
            Logger.a(2, EntryType.UI_INPUT_END, 741453744, a);
        }
    }

    /* compiled from: editNotificationSetting */
    public class C20492 implements OnClickListener {
        final /* synthetic */ AppInvitesSettingsFragment f14599a;

        public C20492(AppInvitesSettingsFragment appInvitesSettingsFragment) {
            this.f14599a = appInvitesSettingsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -288314543);
            this.f14599a.f14604d.m15094a(view.getContext(), Integer.valueOf(1)).show();
            Logger.a(2, EntryType.UI_INPUT_END, -291791536, a);
        }
    }

    /* compiled from: editNotificationSetting */
    public class C20503 implements OnClickListener {
        final /* synthetic */ AppInvitesSettingsFragment f14600a;

        public C20503(AppInvitesSettingsFragment appInvitesSettingsFragment) {
            this.f14600a = appInvitesSettingsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -201862355);
            this.f14600a.f14604d.m15094a(view.getContext(), Integer.valueOf(2)).show();
            Logger.a(2, EntryType.UI_INPUT_END, -899300897, a);
        }
    }

    public static void m14762a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        AppInvitesSettingsFragment appInvitesSettingsFragment = (AppInvitesSettingsFragment) obj;
        AppInvitesEventBus a = AppInvitesEventBus.a(fbInjector);
        Toaster b = Toaster.b(fbInjector);
        AppInvitesGraphqlMutationHelper a2 = AppInvitesGraphqlMutationHelper.m14748a(fbInjector);
        AppInviteBlocksDialogProvider appInviteBlocksDialogProvider = (AppInviteBlocksDialogProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(AppInviteBlocksDialogProvider.class);
        appInvitesSettingsFragment.f14601a = a;
        appInvitesSettingsFragment.f14602b = b;
        appInvitesSettingsFragment.f14603c = a2;
        appInvitesSettingsFragment.f14604d = appInviteBlocksDialogProvider;
    }

    public final void m14765c(Bundle bundle) {
        super.c(bundle);
        Class cls = AppInvitesSettingsFragment.class;
        m14762a((Object) this, getContext());
    }

    public final View m14763a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1743212310);
        this.f14605e = layoutInflater.inflate(2130903284, viewGroup, false);
        View view = this.f14605e;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -231867544, a);
        return view;
    }

    public final void m14764a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f14605e.findViewById(2131559681).setOnClickListener(new C20503(this));
        this.f14605e.findViewById(2131559682).setOnClickListener(new C20492(this));
        this.f14605e.findViewById(2131559683).setOnClickListener(new C20481(this));
    }
}
