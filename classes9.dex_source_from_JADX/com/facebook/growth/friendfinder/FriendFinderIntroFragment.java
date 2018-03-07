package com.facebook.growth.friendfinder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.friends.protocol.FetchDailyDialogueContactImporterModels.DailyDialogueContactImporterQueryModel;
import com.facebook.friends.protocol.FetchDailyDialogueContactImporterModels.DailyDialogueContactImporterQueryModel.DailyDialogueContactImporterModel;
import com.facebook.friends.protocol.FetchFriendsWhoUsedContactImporter;
import com.facebook.friends.protocol.FetchFriendsWhoUsedContactImporter.OrderBy;
import com.facebook.friends.protocol.FriendsWhoUsedContactImporterGraphQLModels.FacepileFieldsModel;
import com.facebook.friends.protocol.FriendsWhoUsedContactImporterGraphQLModels.FacepileFriendsConnectionModel;
import com.facebook.growth.annotations.IsNUXSkipContactsTermsEnabled;
import com.facebook.growth.friendfinder.FriendFinderIntroView.FriendFinderIntroViewListener;
import com.facebook.growth.friendfinder.FriendFinderIntroView.Theme;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nux.status.NuxStepListener;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: password cannot be empty */
public class FriendFinderIntroFragment extends FbFragment {
    public static final String[] f7231i = new String[]{"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"};
    @Inject
    public SecureContextHelper f7232a;
    public ActivityRuntimePermissionsManager al;
    public CIFlow am;
    public String an;
    private boolean ao = false;
    @Inject
    FbUriIntentHandler f7233b;
    @Inject
    FriendFinderAnalyticsLogger f7234c;
    @Inject
    TasksManager f7235d;
    @Inject
    FetchFriendsWhoUsedContactImporter f7236e;
    @Inject
    @IsNUXSkipContactsTermsEnabled
    Provider<TriState> f7237f;
    @Inject
    public FriendFinderPreferenceSetter f7238g;
    @Inject
    ActivityRuntimePermissionsManagerProvider f7239h;

    /* compiled from: password cannot be empty */
    public class C07812 implements FriendFinderIntroViewListener {
        final /* synthetic */ FriendFinderIntroFragment f7228a;

        public C07812(FriendFinderIntroFragment friendFinderIntroFragment) {
            this.f7228a = friendFinderIntroFragment;
        }

        public final void mo282a() {
            FriendFinderIntroFragment friendFinderIntroFragment = this.f7228a;
            friendFinderIntroFragment.al.a(FriendFinderIntroFragment.f7231i, new C07823(friendFinderIntroFragment, true));
        }

        public final void mo283b() {
            this.f7228a.f7234c.a();
            Bundle bundle = new Bundle();
            bundle.putBoolean("titlebar_with_modal_done", true);
            this.f7228a.f7233b.a(this.f7228a.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, "/invite/history"), bundle);
        }

        public final void mo284c() {
            this.f7228a.f7234c.b();
            this.f7228a.f7233b.a(this.f7228a.getContext(), FBLinks.cb);
        }

        public final void mo285d() {
            this.f7228a.f7233b.a(this.f7228a.getContext(), FBLinks.co);
        }
    }

    /* compiled from: password cannot be empty */
    public class C07823 extends AbstractRuntimePermissionsListener {
        final /* synthetic */ boolean f7229a;
        final /* synthetic */ FriendFinderIntroFragment f7230b;

        public C07823(FriendFinderIntroFragment friendFinderIntroFragment, boolean z) {
            this.f7230b = friendFinderIntroFragment;
            this.f7229a = z;
        }

        public final void m7512a() {
            this.f7230b.f7234c.d(this.f7230b.am.value, this.f7230b.an);
            this.f7230b.f7238g.m7549b(this.f7229a);
            FriendFinderIntroFragment friendFinderIntroFragment = this.f7230b;
            Context ao = friendFinderIntroFragment.ao();
            Intent intent = new Intent(ao, FriendFinderHostingActivity.class);
            intent.putExtras(friendFinderIntroFragment.s);
            if (friendFinderIntroFragment.am == CIFlow.IORG_INCENTIVE_INVITE && (ao instanceof LegalCallback)) {
                ((LegalCallback) ao).m7513a();
            } else if (ao instanceof NuxStepListener) {
                friendFinderIntroFragment.f7232a.a(intent, 0, friendFinderIntroFragment);
            } else {
                friendFinderIntroFragment.f7232a.a(intent, ao);
                if (friendFinderIntroFragment.s.getBoolean("FINISH_CONTAINING_ACTIVITY", false)) {
                    ao.finish();
                }
            }
        }
    }

    /* compiled from: password cannot be empty */
    public interface LegalCallback {
        void m7513a();
    }

    public static void m7516a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FriendFinderIntroFragment) obj).m7515a((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), FbUriIntentHandler.a(injectorLike), FriendFinderAnalyticsLogger.a(injectorLike), TasksManager.b(injectorLike), FetchFriendsWhoUsedContactImporter.a(injectorLike), IdBasedProvider.a(injectorLike, 691), FriendFinderPreferenceSetter.m7544b(injectorLike), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class));
    }

    private void m7515a(SecureContextHelper secureContextHelper, FbUriIntentHandler fbUriIntentHandler, FriendFinderAnalyticsLogger friendFinderAnalyticsLogger, TasksManager tasksManager, FetchFriendsWhoUsedContactImporter fetchFriendsWhoUsedContactImporter, Provider<TriState> provider, FriendFinderPreferenceSetter friendFinderPreferenceSetter, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider) {
        this.f7232a = secureContextHelper;
        this.f7233b = fbUriIntentHandler;
        this.f7234c = friendFinderAnalyticsLogger;
        this.f7235d = tasksManager;
        this.f7236e = fetchFriendsWhoUsedContactImporter;
        this.f7237f = provider;
        this.f7238g = friendFinderPreferenceSetter;
        this.f7239h = activityRuntimePermissionsManagerProvider;
    }

    public final void m7523c(Bundle bundle) {
        super.c(bundle);
        Class cls = FriendFinderIntroFragment.class;
        m7516a((Object) this, getContext());
        this.al = this.f7239h.a(o());
        this.am = CIFlow.fromSerializable(this.s.getSerializable("ci_flow"));
        this.an = this.s.getString("ccu_ref");
        if ("UNKNOWN".equals(this.an)) {
            this.an = this.am.value;
        }
        this.f7234c.c(this.am.value, this.an);
    }

    public final View m7520a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1004141745);
        View inflate = layoutInflater.inflate(2130904472, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 698984437, a);
        return inflate;
    }

    public final void m7522a(View view, Bundle bundle) {
        Theme theme;
        super.a(view, bundle);
        final ProgressBar progressBar = (ProgressBar) e(2131562250);
        final FriendFinderIntroView friendFinderIntroView = (FriendFinderIntroView) e(2131562251);
        progressBar.setVisibility(0);
        friendFinderIntroView.f7247c = new C07812(this);
        if (this.f7238g.m7548a(ao())) {
            theme = Theme.REJECT_REG_TERMS_DD_STYLE;
        } else {
            theme = Theme.DAILY_DIALOGUE_STYLE;
        }
        friendFinderIntroView.setIntroViewTheme(theme);
        friendFinderIntroView.setVisibility(8);
        this.f7235d.a("DAILY_DIALOG_TASK_KEY", this.f7236e.b(5, jW_().getDimensionPixelSize(2131428711), OrderBy.MUTUAL_IMPORTANCE), new AbstractDisposableFutureCallback<DailyDialogueContactImporterQueryModel>(this) {
            final /* synthetic */ FriendFinderIntroFragment f7227c;

            protected final void m7502a(@Nullable Object obj) {
                DailyDialogueContactImporterQueryModel dailyDialogueContactImporterQueryModel = (DailyDialogueContactImporterQueryModel) obj;
                friendFinderIntroView.setVisibility(0);
                progressBar.setVisibility(8);
                if (dailyDialogueContactImporterQueryModel != null && dailyDialogueContactImporterQueryModel.a() != null) {
                    FacepileFriendsConnectionModel a = dailyDialogueContactImporterQueryModel.a().a();
                    FriendFinderIntroView friendFinderIntroView = friendFinderIntroView;
                    if (a == null || a.j() == null || a.j().size() < 2) {
                        friendFinderIntroView.m7532a();
                    } else {
                        List arrayList = new ArrayList();
                        List arrayList2 = new ArrayList();
                        ImmutableList j = a.j();
                        int size = j.size();
                        for (int i = 0; i < size; i++) {
                            FacepileFieldsModel facepileFieldsModel = (FacepileFieldsModel) j.get(i);
                            if (!(facepileFieldsModel.b() == null || StringUtil.a(facepileFieldsModel.b().a()))) {
                                arrayList.add(Uri.parse(facepileFieldsModel.b().a()));
                                arrayList2.add(facepileFieldsModel.a());
                            }
                        }
                        if (arrayList2.size() >= 2) {
                            friendFinderIntroView.setFacepileFaces(arrayList);
                            friendFinderIntroView.m7535a(arrayList2, a.a());
                        } else {
                            friendFinderIntroView.m7532a();
                        }
                    }
                    FriendFinderIntroFragment friendFinderIntroFragment = this.f7227c;
                    DailyDialogueContactImporterModel j2 = dailyDialogueContactImporterQueryModel.j();
                    FriendFinderIntroView friendFinderIntroView2 = friendFinderIntroView;
                    if (j2 != null && j2.l() != null && j2.k() != null && j2.j() != null && j2.a() != null) {
                        if (!friendFinderIntroFragment.f7238g.m7548a(friendFinderIntroFragment.ao())) {
                            friendFinderIntroView2.m7534a(j2.l().a(), j2.k().a());
                        }
                        friendFinderIntroView2.m7533a(j2.j().b(), j2.j().a(), j2.j().c());
                        friendFinderIntroView2.m7536b(j2.a().b(), j2.a().a(), j2.a().c());
                    }
                }
            }

            protected final void m7503a(Throwable th) {
                friendFinderIntroView.m7532a();
                friendFinderIntroView.setVisibility(0);
                progressBar.setVisibility(8);
            }
        });
    }

    public final void m7518G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1376793212);
        super.G();
        this.ao = true;
        ar();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -35695367, a);
    }

    public final void m7519H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1792482092);
        this.ao = false;
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -239817320, a);
    }

    public final void m7524g(boolean z) {
        super.g(z);
        ar();
    }

    public final void m7521a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        Activity ao = ao();
        if (!(ao instanceof NuxStepListener) || i != 0) {
            return;
        }
        if (i2 == -1) {
            ((NuxStepListener) ao).b("contact_importer");
        } else if (i2 == 0 && this.f7237f != null && ((TriState) this.f7237f.get()).asBoolean(false)) {
            ao.onBackPressed();
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -182783913);
        this.f7235d.c("DAILY_DIALOG_TASK_KEY");
        super.mY_();
        this.al = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -43344537, a);
    }

    public static FriendFinderIntroFragment m7514a(CIFlow cIFlow, @Nullable String str) {
        FriendFinderIntroFragment friendFinderIntroFragment = new FriendFinderIntroFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("ci_flow", cIFlow);
        if (StringUtil.a(str)) {
            str = "UNKNOWN";
        }
        bundle.putString("ccu_ref", str);
        friendFinderIntroFragment.g(bundle);
        return friendFinderIntroFragment;
    }

    public static FriendFinderIntroFragment m7517b(CIFlow cIFlow, @Nullable String str) {
        FriendFinderIntroFragment a = m7514a(cIFlow, str);
        a.s.putBoolean("FINISH_CONTAINING_ACTIVITY", true);
        return a;
    }

    private void ar() {
        if (this.ao && D()) {
            HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
            if (hasTitleBar != null) {
                hasTitleBar.y_(2131233242);
                hasTitleBar.c(true);
            }
        }
    }
}
