package com.facebook.timeline.header;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.util.ContextUtils;
import com.facebook.graphql.calls.ProfileWizardNuxDismissInputData;
import com.facebook.graphql.calls.ProfileWizardNuxStartInputData;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.protocol.ProfileNuxCancelMutation.ProfileNuxCancelButtonMutationString;
import com.facebook.timeline.protocol.ProfileNuxCancelMutation.ProfileNuxStartMutationString;
import com.facebook.timeline.refresher.ProfileNuxRefresherDismissController;
import com.facebook.timeline.refresher.ProfileRefresherAnalyticsLogger;
import com.facebook.timeline.refresher.launcher.ProfileRefresherConfiguration;
import com.facebook.timeline.refresher.launcher.ProfileRefresherLauncher;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: friends_nearby_dashboard_map_contract */
public class ProfileNuxEntryViewBinder {
    ProfileRefresherConfiguration f11298a;
    public final ProfileRefresherLauncher f11299b;
    public final Provider<ProfileNuxRefresherDismissController> f11300c;
    private final Provider<ProfileNuxViewMutationController> f11301d;
    public final Provider<ProfileNuxFlowStartedMutationController> f11302e;
    public final Provider<ProfileRefresherAnalyticsLogger> f11303f;
    public String f11304g;
    @Nullable
    public View f11305h;
    @Nullable
    public Activity f11306i;
    private boolean f11307j = false;
    private boolean f11308k = false;
    @Nullable
    private final OnClickListener f11309l = new C16381(this);
    @Nullable
    private final OnClickListener f11310m = new C16392(this);

    /* compiled from: friends_nearby_dashboard_map_contract */
    class C16381 implements OnClickListener {
        final /* synthetic */ ProfileNuxEntryViewBinder f11296a;

        C16381(ProfileNuxEntryViewBinder profileNuxEntryViewBinder) {
            this.f11296a = profileNuxEntryViewBinder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -37022023);
            ((ProfileRefresherAnalyticsLogger) this.f11296a.f11303f.get()).d("profile_nux");
            this.f11296a.f11299b.a(this.f11296a.f11298a, (Activity) ContextUtils.a(view.getContext(), Activity.class));
            ProfileNuxFlowStartedMutationController profileNuxFlowStartedMutationController = (ProfileNuxFlowStartedMutationController) this.f11296a.f11302e.get();
            String str = this.f11296a.f11304g;
            ProfileWizardNuxStartInputData profileWizardNuxStartInputData = new ProfileWizardNuxStartInputData();
            profileWizardNuxStartInputData.a("actor_id", str);
            GraphQlQueryString profileNuxStartMutationString = new ProfileNuxStartMutationString();
            profileNuxStartMutationString.a("input", profileWizardNuxStartInputData);
            profileNuxFlowStartedMutationController.f11311a.a(GraphQLRequest.a(profileNuxStartMutationString));
            Logger.a(2, EntryType.UI_INPUT_END, -1998604182, a);
        }
    }

    /* compiled from: friends_nearby_dashboard_map_contract */
    class C16392 implements OnClickListener {
        final /* synthetic */ ProfileNuxEntryViewBinder f11297a;

        C16392(ProfileNuxEntryViewBinder profileNuxEntryViewBinder) {
            this.f11297a = profileNuxEntryViewBinder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2128678514);
            ((ProfileRefresherAnalyticsLogger) this.f11297a.f11303f.get()).c("profile_nux");
            if (this.f11297a.f11305h != null) {
                this.f11297a.f11305h.setVisibility(8);
            } else if (this.f11297a.f11306i != null) {
                this.f11297a.f11306i.finish();
            }
            ProfileNuxRefresherDismissController profileNuxRefresherDismissController = (ProfileNuxRefresherDismissController) this.f11297a.f11300c.get();
            String str = this.f11297a.f11304g;
            ProfileWizardNuxDismissInputData profileWizardNuxDismissInputData = new ProfileWizardNuxDismissInputData();
            profileWizardNuxDismissInputData.a("actor_id", str);
            GraphQlQueryString profileNuxCancelButtonMutationString = new ProfileNuxCancelButtonMutationString();
            profileNuxCancelButtonMutationString.a("input", profileWizardNuxDismissInputData);
            profileNuxRefresherDismissController.a.a(GraphQLRequest.a(profileNuxCancelButtonMutationString));
            LogUtils.a(-401253664, a);
        }
    }

    @Inject
    public ProfileNuxEntryViewBinder(ProfileRefresherLauncher profileRefresherLauncher, Provider<ProfileNuxRefresherDismissController> provider, Provider<ProfileNuxViewMutationController> provider2, Provider<ProfileNuxFlowStartedMutationController> provider3, Provider<ProfileRefresherAnalyticsLogger> provider4) {
        this.f11299b = profileRefresherLauncher;
        this.f11300c = provider;
        this.f11301d = provider2;
        this.f11302e = provider3;
        this.f11303f = provider4;
    }

    public final void m11398a(ProfileRefresherConfiguration profileRefresherConfiguration, String str, FbButton fbButton, FbButton fbButton2, FbTextView fbTextView, FbTextView fbTextView2, String str2, String str3, @Nullable View view, Activity activity) {
        this.f11298a = profileRefresherConfiguration;
        this.f11304g = str;
        this.f11305h = view;
        this.f11306i = activity;
        fbButton.setOnClickListener(this.f11309l);
        fbButton2.setOnClickListener(this.f11310m);
        fbTextView.setText(str2);
        fbTextView2.setText(str3);
        if (!this.f11307j) {
            ((ProfileRefresherAnalyticsLogger) this.f11303f.get()).b("profile_nux");
            this.f11307j = true;
        }
        if (!this.f11308k) {
            ((ProfileNuxViewMutationController) this.f11301d.get()).m11399a(this.f11304g);
            this.f11308k = true;
        }
    }
}
