package com.facebook.groups.editsettings;

import android.content.res.Resources;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.calls.GroupEditInputData;
import com.facebook.graphql.calls.GroupEditInputData.GroupPurpose;
import com.facebook.graphql.calls.GroupEditInputData.JoinApprovalSetting;
import com.facebook.graphql.calls.GroupEditInputData.PostApprovalSetting;
import com.facebook.graphql.calls.GroupEditInputData.PostPermissionSetting;
import com.facebook.graphql.calls.GroupEditInputData.Source;
import com.facebook.graphql.calls.GroupEditInputData.VisibilitySetting;
import com.facebook.graphql.enums.GraphQLGroupJoinApprovalSetting;
import com.facebook.graphql.enums.GraphQLGroupPostPermissionSetting;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.groups.editsettings.adapter.GroupEditSettingsAdapter;
import com.facebook.groups.editsettings.adapter.GroupEditSettingsAdapter.C30731;
import com.facebook.groups.editsettings.fragment.GroupEditPrivacyFragment.C30951;
import com.facebook.groups.editsettings.fragment.GroupEditPurposeFragment;
import com.facebook.groups.editsettings.fragment.GroupEditPurposeFragment.C30961;
import com.facebook.groups.editsettings.protocol.FetchGroupEditSettings;
import com.facebook.groups.editsettings.protocol.FetchGroupEditSettings.FBGroupEditSettingsMutationString;
import com.facebook.groups.editsettings.protocol.FetchGroupEditSettingsModels.FBGroupEditSettingsMutationModel;
import com.facebook.groups.editsettings.protocol.FetchGroupSettingsModels.FetchGroupSettingsModel;
import com.facebook.groups.editsettings.protocol.FetchGroupSettingsModels.FetchGroupSettingsModel.Builder;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Unknown Facebook Ads SDK delivery response type */
public class GroupEditSettingsController {
    private static final Source f21520a = Source.TREEHOUSE_GROUP_INFO;
    private Toaster f21521b;
    private String f21522c;
    private ExecutorService f21523d;
    private final GraphQLQueryExecutor f21524e;
    private Resources f21525f;
    public DefaultEditSettingsUpdateListener f21526g;
    public GraphQLSubscriptionHolder f21527h;
    public FetchGroupSettingsModel f21528i;
    public C30731 f21529j;
    public C30951 f21530k;
    public final FutureCallback<GraphQLResult<FetchGroupSettingsModel>> f21531l = new C30571(this);

    /* compiled from: Unknown Facebook Ads SDK delivery response type */
    class C30571 implements FutureCallback<GraphQLResult<FetchGroupSettingsModel>> {
        final /* synthetic */ GroupEditSettingsController f21503a;

        C30571(GroupEditSettingsController groupEditSettingsController) {
            this.f21503a = groupEditSettingsController;
        }

        public void onSuccess(Object obj) {
            FetchGroupSettingsModel fetchGroupSettingsModel = (FetchGroupSettingsModel) ((GraphQLResult) obj).e;
            String t = fetchGroupSettingsModel.m22809t();
            String m = fetchGroupSettingsModel.m22802m();
            if (this.f21503a.f21528i == null) {
                return;
            }
            if (!this.f21503a.f21528i.m22809t().equals(t) || !this.f21503a.f21528i.m22802m().equals(m)) {
                GroupEditSettingsController.m22531a(this.f21503a, t, m);
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: Unknown Facebook Ads SDK delivery response type */
    class C30582 implements FutureCallback<GraphQLResult<FBGroupEditSettingsMutationModel>> {
        final /* synthetic */ GroupEditSettingsController f21504a;

        C30582(GroupEditSettingsController groupEditSettingsController) {
            this.f21504a = groupEditSettingsController;
        }

        public void onSuccess(Object obj) {
            DefaultEditSettingsUpdateListener defaultEditSettingsUpdateListener = this.f21504a.f21526g;
        }

        public void onFailure(Throwable th) {
            GroupEditSettingsController.m22527a(this.f21504a, 2131242139);
        }
    }

    /* compiled from: Unknown Facebook Ads SDK delivery response type */
    public /* synthetic */ class C30659 {
        static final /* synthetic */ int[] f21517a = new int[GraphQLGroupVisibility.values().length];
        public static final /* synthetic */ int[] f21518b = new int[GraphQLGroupJoinApprovalSetting.values().length];
        public static final /* synthetic */ int[] f21519c = new int[GraphQLGroupPostPermissionSetting.values().length];

        static {
            try {
                f21519c[GraphQLGroupPostPermissionSetting.ADMIN_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21519c[GraphQLGroupPostPermissionSetting.ANYONE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f21519c[GraphQLGroupPostPermissionSetting.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f21518b[GraphQLGroupJoinApprovalSetting.ADMIN_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f21518b[GraphQLGroupJoinApprovalSetting.ADMIN_ONLY_ADD.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f21518b[GraphQLGroupJoinApprovalSetting.ANYONE.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f21518b[GraphQLGroupJoinApprovalSetting.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f21517a[GraphQLGroupVisibility.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f21517a[GraphQLGroupVisibility.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f21517a[GraphQLGroupVisibility.SECRET.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    public static GroupEditSettingsController m22535b(InjectorLike injectorLike) {
        return new GroupEditSettingsController(Toaster.b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), GraphQLSubscriptionHolder.b(injectorLike), new DefaultEditSettingsUpdateListener());
    }

    @Inject
    public GroupEditSettingsController(Toaster toaster, ExecutorService executorService, String str, GraphQLQueryExecutor graphQLQueryExecutor, Resources resources, GraphQLSubscriptionHolder graphQLSubscriptionHolder, DefaultEditSettingsUpdateListener defaultEditSettingsUpdateListener) {
        this.f21521b = toaster;
        this.f21523d = executorService;
        this.f21522c = str;
        this.f21524e = graphQLQueryExecutor;
        this.f21525f = resources;
        this.f21527h = graphQLSubscriptionHolder;
        this.f21526g = defaultEditSettingsUpdateListener;
    }

    public final void m22536a(FetchGroupSettingsModel fetchGroupSettingsModel, @Nullable C30731 c30731) {
        this.f21528i = fetchGroupSettingsModel;
        this.f21529j = c30731;
    }

    public final void m22542a(String str, @Nullable String str2, @Nullable String str3) {
        GroupEditInputData groupEditInputData = new GroupEditInputData();
        if (str2 != null) {
            groupEditInputData.a("name", str2);
        }
        if (str3 != null) {
            groupEditInputData.a("description", str3);
        }
        m22533a(str, groupEditInputData, new C30582(this));
    }

    public final void m22537a(String str, GroupPurpose groupPurpose, final C30961 c30961) {
        GroupEditInputData groupEditInputData = new GroupEditInputData();
        groupEditInputData.a(groupPurpose);
        m22533a(str, groupEditInputData, new FutureCallback<GraphQLResult<FBGroupEditSettingsMutationModel>>(this) {
            final /* synthetic */ GroupEditSettingsController f21506b;

            public void onSuccess(Object obj) {
                C30961 c30961 = c30961;
                if (c30961.f21641a.mx_()) {
                    c30961.f21641a.o().onBackPressed();
                }
            }

            public void onFailure(Throwable th) {
                C30961 c30961 = c30961;
                if (c30961.f21641a.mx_()) {
                    GroupEditPurposeFragment.m22611a(c30961.f21641a, c30961.f21641a.jW_().getString(2131242173), c30961.f21641a.jW_().getString(2131242140));
                }
            }
        });
    }

    public final void m22540a(String str, GraphQLGroupVisibility graphQLGroupVisibility, FragmentManager fragmentManager) {
        final DialogFragment a = ProgressDialogFragment.a(this.f21525f.getString(2131242170), true, false);
        a.a(fragmentManager, null);
        m22533a(str, new GroupEditInputData().a(m22534b(graphQLGroupVisibility)), new FutureCallback<GraphQLResult<FBGroupEditSettingsMutationModel>>(this) {
            final /* synthetic */ GroupEditSettingsController f21508b;

            public void onSuccess(Object obj) {
                a.b();
                if (this.f21508b.f21530k != null) {
                    this.f21508b.f21530k.m22603a();
                }
            }

            public void onFailure(Throwable th) {
                a.b();
                if (this.f21508b.f21530k != null) {
                    this.f21508b.f21530k.m22603a();
                }
                GroupEditSettingsController.m22527a(this.f21508b, 2131242141);
            }
        });
    }

    public final void m22541a(String str, GraphQLGroupVisibility graphQLGroupVisibility, final GraphQLGroupVisibility graphQLGroupVisibility2) {
        m22530a(this, graphQLGroupVisibility);
        m22533a(str, new GroupEditInputData().a(m22534b(graphQLGroupVisibility)), new FutureCallback<GraphQLResult<FBGroupEditSettingsMutationModel>>(this) {
            final /* synthetic */ GroupEditSettingsController f21510b;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                GroupEditSettingsController.m22530a(this.f21510b, graphQLGroupVisibility2);
                GroupEditSettingsController.m22527a(this.f21510b, 2131242141);
            }
        });
    }

    public final void m22538a(String str, GraphQLGroupJoinApprovalSetting graphQLGroupJoinApprovalSetting, final GraphQLGroupJoinApprovalSetting graphQLGroupJoinApprovalSetting2) {
        JoinApprovalSetting joinApprovalSetting;
        m22528a(this, graphQLGroupJoinApprovalSetting);
        GroupEditInputData groupEditInputData = new GroupEditInputData();
        switch (C30659.f21518b[graphQLGroupJoinApprovalSetting.ordinal()]) {
            case 1:
                joinApprovalSetting = JoinApprovalSetting.ADMIN_ONLY;
                break;
            case 2:
                joinApprovalSetting = JoinApprovalSetting.ADMIN_ONLY_ADD;
                break;
            case 3:
                joinApprovalSetting = JoinApprovalSetting.ANYONE;
                break;
            case 4:
                joinApprovalSetting = JoinApprovalSetting.NONE;
                break;
            default:
                joinApprovalSetting = null;
                break;
        }
        groupEditInputData.a("join_approval_setting", joinApprovalSetting);
        m22533a(str, groupEditInputData, new FutureCallback<GraphQLResult<FBGroupEditSettingsMutationModel>>(this) {
            final /* synthetic */ GroupEditSettingsController f21512b;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                GroupEditSettingsController.m22528a(this.f21512b, graphQLGroupJoinApprovalSetting2);
                GroupEditSettingsController.m22527a(this.f21512b, 2131242142);
            }
        });
    }

    public final void m22539a(String str, GraphQLGroupPostPermissionSetting graphQLGroupPostPermissionSetting, final GraphQLGroupPostPermissionSetting graphQLGroupPostPermissionSetting2) {
        PostPermissionSetting postPermissionSetting;
        m22529a(this, graphQLGroupPostPermissionSetting);
        GroupEditInputData groupEditInputData = new GroupEditInputData();
        switch (C30659.f21519c[graphQLGroupPostPermissionSetting.ordinal()]) {
            case 1:
                postPermissionSetting = PostPermissionSetting.ADMIN_ONLY;
                break;
            case 2:
                postPermissionSetting = PostPermissionSetting.ANYONE;
                break;
            case 3:
                postPermissionSetting = PostPermissionSetting.NONE;
                break;
            default:
                postPermissionSetting = null;
                break;
        }
        groupEditInputData.a("post_permission_setting", postPermissionSetting);
        m22533a(str, groupEditInputData, new FutureCallback<GraphQLResult<FBGroupEditSettingsMutationModel>>(this) {
            final /* synthetic */ GroupEditSettingsController f21514b;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                GroupEditSettingsController.m22529a(this.f21514b, graphQLGroupPostPermissionSetting2);
                GroupEditSettingsController.m22527a(this.f21514b, 2131242143);
            }
        });
    }

    public final void m22543a(String str, boolean z, final boolean z2) {
        Enum enumR;
        m22532a(this, z);
        GroupEditInputData groupEditInputData = new GroupEditInputData();
        if (z) {
            enumR = PostApprovalSetting.ADMIN_ONLY;
        } else {
            enumR = PostApprovalSetting.NONE;
        }
        groupEditInputData.a("post_approval_setting", enumR);
        m22533a(str, groupEditInputData, new FutureCallback<GraphQLResult<FBGroupEditSettingsMutationModel>>(this) {
            final /* synthetic */ GroupEditSettingsController f21516b;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                GroupEditSettingsController.m22532a(this.f21516b, z2);
                GroupEditSettingsController.m22527a(this.f21516b, 2131242144);
            }
        });
    }

    private void m22533a(String str, GroupEditInputData groupEditInputData, FutureCallback<GraphQLResult<FBGroupEditSettingsMutationModel>> futureCallback) {
        groupEditInputData.b(str).a(this.f21522c).a(f21520a);
        Futures.a(this.f21524e.a(GraphQLRequest.a((FBGroupEditSettingsMutationString) FetchGroupEditSettings.m22645a().a("input", groupEditInputData))), futureCallback, this.f21523d);
    }

    public static void m22527a(GroupEditSettingsController groupEditSettingsController, int i) {
        Toaster toaster = groupEditSettingsController.f21521b;
        ToastBuilder toastBuilder = new ToastBuilder(groupEditSettingsController.f21525f.getString(i));
        toastBuilder.b = 17;
        toaster.b(toastBuilder);
    }

    public static void m22531a(GroupEditSettingsController groupEditSettingsController, String str, String str2) {
        if (groupEditSettingsController.f21528i != null) {
            Builder a = Builder.m22698a(groupEditSettingsController.f21528i);
            a.f21703k = str;
            a = a;
            a.f21696d = str2;
            groupEditSettingsController.f21528i = a.m22699a();
            groupEditSettingsController.m22526a();
        }
    }

    public static void m22530a(GroupEditSettingsController groupEditSettingsController, GraphQLGroupVisibility graphQLGroupVisibility) {
        if (groupEditSettingsController.f21528i != null) {
            Builder a = Builder.m22698a(groupEditSettingsController.f21528i);
            a.f21712t = graphQLGroupVisibility;
            groupEditSettingsController.f21528i = a.m22699a();
            groupEditSettingsController.m22526a();
        }
    }

    public static void m22528a(GroupEditSettingsController groupEditSettingsController, GraphQLGroupJoinApprovalSetting graphQLGroupJoinApprovalSetting) {
        if (groupEditSettingsController.f21528i != null) {
            Builder a = Builder.m22698a(groupEditSettingsController.f21528i);
            a.f21702j = graphQLGroupJoinApprovalSetting;
            groupEditSettingsController.f21528i = a.m22699a();
            groupEditSettingsController.m22526a();
        }
    }

    public static void m22529a(GroupEditSettingsController groupEditSettingsController, GraphQLGroupPostPermissionSetting graphQLGroupPostPermissionSetting) {
        if (groupEditSettingsController.f21528i != null) {
            Builder a = Builder.m22698a(groupEditSettingsController.f21528i);
            a.f21708p = graphQLGroupPostPermissionSetting;
            groupEditSettingsController.f21528i = a.m22699a();
            groupEditSettingsController.m22526a();
        }
    }

    public static void m22532a(GroupEditSettingsController groupEditSettingsController, boolean z) {
        if (groupEditSettingsController.f21528i != null) {
            Builder a = Builder.m22698a(groupEditSettingsController.f21528i);
            a.f21711s = z;
            groupEditSettingsController.f21528i = a.m22699a();
            groupEditSettingsController.m22526a();
        }
    }

    private void m22526a() {
        if (this.f21529j != null) {
            C30731 c30731 = this.f21529j;
            GroupEditSettingsAdapter.m22576c(c30731.f21574a, this.f21528i);
        }
    }

    private static VisibilitySetting m22534b(GraphQLGroupVisibility graphQLGroupVisibility) {
        switch (C30659.f21517a[graphQLGroupVisibility.ordinal()]) {
            case 1:
                return VisibilitySetting.OPEN;
            case 2:
                return VisibilitySetting.CLOSED;
            case 3:
                return VisibilitySetting.SECRET;
            default:
                return null;
        }
    }
}
