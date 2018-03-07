package com.facebook.groups.sideconversation.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeView;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.groups.analytics.GroupsAnalyticsLogger;
import com.facebook.groups.members.GroupsMembersSelectorFragment;
import com.facebook.groups.sideconversation.appswitch.AppSwitchHelper;
import com.facebook.groups.sideconversation.navigation.DefaultSideConversationNavigationHandler;
import com.facebook.groups.sideconversation.navigation.DefaultSideConversationNavigationHandler.C16011;
import com.facebook.groups.sideconversation.protocol.SideConversationAssociateThreadToGroupMethod;
import com.facebook.groups.sideconversation.protocol.SideConversationAssociateThreadToGroupParams;
import com.facebook.groups.sideconversation.protocol.SideConversationCreateMessageThreadMethod;
import com.facebook.groups.sideconversation.protocol.SideConversationCreateMessageThreadParams;
import com.facebook.groups.sideconversation.protocol.SideConversationSetThreadImageMethod;
import com.facebook.groups.sideconversation.protocol.SideConversationSetThreadImageParams;
import com.facebook.http.protocol.ApiMethodRunner.Batch;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.mediastorage.MediaStorage;
import com.facebook.resources.ui.FbEditText;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.User;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: empty_list */
public class GroupsStartSideConversationFragment extends FbFragment implements AnalyticsFragment, CanHandleBackPressed {
    public static final String[] as = new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    public static final String[] at = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    private static final CallerContext au = CallerContext.a(GroupsStartSideConversationFragment.class, "group_mall_side_conversation");
    @Inject
    GroupsAnalyticsLogger f14866a;
    public DraweeView aA;
    public Uri aB;
    public MediaResource aC;
    public DialogFragment aD;
    public GroupsMembersSelectorFragment aE;
    private boolean aF;
    private final OnClickListener aG = new C16041(this);
    @Inject
    public SecureContextHelper al;
    @Inject
    public MediaStorage am;
    @Inject
    public Toaster an;
    @Inject
    FbDraweeControllerBuilder ao;
    @Inject
    DefaultSideConversationNavigationHandler ap;
    @Inject
    ActivityRuntimePermissionsManagerProvider aq;
    public ActivityRuntimePermissionsManager ar;
    public final String av = GroupsStartSideConversationFragment.class.getSimpleName();
    public String aw;
    private ArrayList<User> ax;
    public FbEditText ay;
    public ImageView az;
    @Inject
    InputMethodManager f14867b;
    @Inject
    ApiMethodRunnerImpl f14868c;
    @Inject
    SideConversationCreateMessageThreadMethod f14869d;
    @Inject
    SideConversationAssociateThreadToGroupMethod f14870e;
    @Inject
    SideConversationSetThreadImageMethod f14871f;
    @DefaultExecutorService
    @Inject
    public ExecutorService f14872g;
    @Inject
    TasksManager f14873h;
    @Inject
    AppSwitchHelper f14874i;

    /* compiled from: empty_list */
    class C16041 implements OnClickListener {
        final /* synthetic */ GroupsStartSideConversationFragment f14855a;

        /* compiled from: empty_list */
        class C16021 implements Callable<ListenableFuture<String>> {
            final /* synthetic */ C16041 f14851a;

            C16021(C16041 c16041) {
                this.f14851a = c16041;
            }

            public Object call() {
                GroupsStartSideConversationFragment groupsStartSideConversationFragment = this.f14851a.f14855a;
                SettableFuture f = SettableFuture.f();
                ExecutorDetour.a(groupsStartSideConversationFragment.f14872g, new C16052(groupsStartSideConversationFragment, f), -690713708);
                return f;
            }
        }

        /* compiled from: empty_list */
        class C16032 extends AbstractDisposableFutureCallback<String> {
            final /* synthetic */ C16041 f14852a;

            C16032(C16041 c16041) {
                this.f14852a = c16041;
            }

            protected final void m17326a(Object obj) {
                String str = (String) obj;
                GroupsStartSideConversationFragment.at(this.f14852a.f14855a);
                if (this.f14852a.f14855a.y) {
                    GroupsStartSideConversationFragment.ar(this.f14852a.f14855a);
                }
                AppSwitchHelper appSwitchHelper = this.f14852a.f14855a.f14874i;
                Context context = this.f14852a.f14855a.getContext();
                ((SecureContextHelper) appSwitchHelper.f14800a.get()).b(((UriIntentMapper) appSwitchHelper.f14801b.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.X, str)), context);
            }

            protected final void m17327a(Throwable th) {
                GroupsStartSideConversationFragment.at(this.f14852a.f14855a);
                this.f14852a.f14855a.an.b(new ToastBuilder(2131237923));
            }
        }

        C16041(GroupsStartSideConversationFragment groupsStartSideConversationFragment) {
            this.f14855a = groupsStartSideConversationFragment;
        }

        public void onClick(View view) {
            int i;
            Object obj;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1567339751);
            GroupsStartSideConversationFragment.as(this.f14855a);
            GroupsStartSideConversationFragment groupsStartSideConversationFragment = this.f14855a;
            if (groupsStartSideConversationFragment.ay.getText().toString().trim().isEmpty()) {
                i = 2131237925;
            } else if (groupsStartSideConversationFragment.aE.b().size() < 2) {
                i = 2131237926;
            } else {
                i = -1;
            }
            if (i != -1) {
                groupsStartSideConversationFragment.an.b(new ToastBuilder(i));
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                this.f14855a.f14866a.m427a(this.f14855a.aw);
                groupsStartSideConversationFragment = this.f14855a;
                if (groupsStartSideConversationFragment.aD == null) {
                    groupsStartSideConversationFragment.aD = ProgressDialogFragment.a(2131237922, true, false, false);
                }
                groupsStartSideConversationFragment.aD.a(groupsStartSideConversationFragment.s(), null);
                this.f14855a.f14873h.a(Tasks.START_SIDE_CONVERSATION, new C16021(this), new C16032(this));
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1862158998, a);
        }
    }

    /* compiled from: empty_list */
    public class C16052 implements Runnable {
        final /* synthetic */ SettableFuture f14856a;
        final /* synthetic */ GroupsStartSideConversationFragment f14857b;

        public C16052(GroupsStartSideConversationFragment groupsStartSideConversationFragment, SettableFuture settableFuture) {
            this.f14857b = groupsStartSideConversationFragment;
            this.f14856a = settableFuture;
        }

        public void run() {
            try {
                Batch a = this.f14857b.f14868c.a();
                a.a(BatchOperation.a(this.f14857b.f14869d, new SideConversationCreateMessageThreadParams(this.f14857b.ay.getText().toString().trim(), this.f14857b.aE.b())).a("createGroupSideConversation").a());
                if (this.f14857b.aC != null) {
                    a.a(BatchOperation.a(this.f14857b.f14871f, new SideConversationSetThreadImageParams("{result=createGroupSideConversation:$.id}", this.f14857b.aC)).b("createGroupSideConversation").a());
                }
                a.a(BatchOperation.a(this.f14857b.f14870e, new SideConversationAssociateThreadToGroupParams(this.f14857b.aw, "{result=createGroupSideConversation:$.id}")).b("createGroupSideConversation").a());
                a.a("createSideConversationBatch", CallerContext.a(getClass()));
                FutureDetour.a(this.f14856a, (String) a.a("createGroupSideConversation"), -1949542422);
            } catch (Throwable e) {
                BLog.b(this.f14857b.av, e.getMessage(), e);
                this.f14856a.a(e);
            }
        }
    }

    /* compiled from: empty_list */
    class C16063 implements OnFocusChangeListener {
        final /* synthetic */ GroupsStartSideConversationFragment f14858a;

        C16063(GroupsStartSideConversationFragment groupsStartSideConversationFragment) {
            this.f14858a = groupsStartSideConversationFragment;
        }

        public void onFocusChange(View view, boolean z) {
            if (!z) {
                GroupsStartSideConversationFragment.as(this.f14858a);
            }
        }
    }

    /* compiled from: empty_list */
    public class C16085 implements DialogInterface.OnClickListener {
        final /* synthetic */ GroupsStartSideConversationFragment f14861a;

        public C16085(GroupsStartSideConversationFragment groupsStartSideConversationFragment) {
            this.f14861a = groupsStartSideConversationFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            GroupsStartSideConversationFragment.ar(this.f14861a);
        }
    }

    /* compiled from: empty_list */
    public class C16096 implements DialogInterface.OnClickListener {
        final /* synthetic */ GroupsStartSideConversationFragment f14862a;

        public C16096(GroupsStartSideConversationFragment groupsStartSideConversationFragment) {
            this.f14862a = groupsStartSideConversationFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: empty_list */
    public class C16107 implements OnMenuItemClickListener {
        final /* synthetic */ GroupsStartSideConversationFragment f14863a;

        public C16107(GroupsStartSideConversationFragment groupsStartSideConversationFragment) {
            this.f14863a = groupsStartSideConversationFragment;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            GroupsStartSideConversationFragment groupsStartSideConversationFragment = this.f14863a;
            groupsStartSideConversationFragment.aC = null;
            groupsStartSideConversationFragment.aA.setVisibility(8);
            groupsStartSideConversationFragment.az.setVisibility(0);
            return true;
        }
    }

    /* compiled from: empty_list */
    public class C16118 implements OnMenuItemClickListener {
        final /* synthetic */ GroupsStartSideConversationFragment f14864a;

        public C16118(GroupsStartSideConversationFragment groupsStartSideConversationFragment) {
            this.f14864a = groupsStartSideConversationFragment;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            GroupsStartSideConversationFragment groupsStartSideConversationFragment = this.f14864a;
            groupsStartSideConversationFragment.ar.a(GroupsStartSideConversationFragment.as, new AbstractRuntimePermissionsListener(groupsStartSideConversationFragment) {
                final /* synthetic */ GroupsStartSideConversationFragment f14853a;

                {
                    this.f14853a = r1;
                }

                public final void m17328a() {
                    GroupsStartSideConversationFragment groupsStartSideConversationFragment = this.f14853a;
                    groupsStartSideConversationFragment.aB = groupsStartSideConversationFragment.am.c();
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", groupsStartSideConversationFragment.aB);
                    groupsStartSideConversationFragment.al.b(intent, 1010, groupsStartSideConversationFragment.o());
                }

                public final void m17329a(String[] strArr, String[] strArr2) {
                    this.f14853a.an.b(new ToastBuilder(this.f14853a.getContext().getString(2131237935)));
                }
            });
            return true;
        }
    }

    /* compiled from: empty_list */
    public class C16129 implements OnMenuItemClickListener {
        final /* synthetic */ GroupsStartSideConversationFragment f14865a;

        public C16129(GroupsStartSideConversationFragment groupsStartSideConversationFragment) {
            this.f14865a = groupsStartSideConversationFragment;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            GroupsStartSideConversationFragment groupsStartSideConversationFragment = this.f14865a;
            groupsStartSideConversationFragment.ar.a(GroupsStartSideConversationFragment.at, new AbstractRuntimePermissionsListener(groupsStartSideConversationFragment) {
                final /* synthetic */ GroupsStartSideConversationFragment f14854a;

                {
                    this.f14854a = r1;
                }

                public final void m17330a() {
                    GroupsStartSideConversationFragment groupsStartSideConversationFragment = this.f14854a;
                    Intent intent = new Intent("android.intent.action.PICK");
                    intent.setType("image/*");
                    groupsStartSideConversationFragment.al.b(intent, 1011, groupsStartSideConversationFragment.o());
                }

                public final void m17331a(String[] strArr, String[] strArr2) {
                    this.f14854a.an.b(new ToastBuilder(this.f14854a.getContext().getString(2131237936)));
                }
            });
            return true;
        }
    }

    /* compiled from: empty_list */
    enum Tasks {
        START_SIDE_CONVERSATION
    }

    public static void m17333a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((GroupsStartSideConversationFragment) obj).m17332a(GroupsAnalyticsLogger.m422a(injectorLike), InputMethodManagerMethodAutoProvider.b(injectorLike), ApiMethodRunnerImpl.a(injectorLike), SideConversationCreateMessageThreadMethod.m17318a(injectorLike), SideConversationAssociateThreadToGroupMethod.m17314a(injectorLike), SideConversationSetThreadImageMethod.m17321a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike), AppSwitchHelper.m17166a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), MediaStorage.a(injectorLike), Toaster.b(injectorLike), FbDraweeControllerBuilder.b(injectorLike), DefaultSideConversationNavigationHandler.m17169a(injectorLike), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class));
    }

    private void m17332a(GroupsAnalyticsLogger groupsAnalyticsLogger, InputMethodManager inputMethodManager, ApiMethodRunnerImpl apiMethodRunnerImpl, SideConversationCreateMessageThreadMethod sideConversationCreateMessageThreadMethod, SideConversationAssociateThreadToGroupMethod sideConversationAssociateThreadToGroupMethod, SideConversationSetThreadImageMethod sideConversationSetThreadImageMethod, ExecutorService executorService, TasksManager tasksManager, AppSwitchHelper appSwitchHelper, SecureContextHelper secureContextHelper, MediaStorage mediaStorage, Toaster toaster, FbDraweeControllerBuilder fbDraweeControllerBuilder, DefaultSideConversationNavigationHandler defaultSideConversationNavigationHandler, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider) {
        this.f14866a = groupsAnalyticsLogger;
        this.f14867b = inputMethodManager;
        this.f14868c = apiMethodRunnerImpl;
        this.f14869d = sideConversationCreateMessageThreadMethod;
        this.f14870e = sideConversationAssociateThreadToGroupMethod;
        this.f14871f = sideConversationSetThreadImageMethod;
        this.f14872g = executorService;
        this.f14873h = tasksManager;
        this.f14874i = appSwitchHelper;
        this.al = secureContextHelper;
        this.am = mediaStorage;
        this.an = toaster;
        this.ao = fbDraweeControllerBuilder;
        this.ap = defaultSideConversationNavigationHandler;
        this.aq = activityRuntimePermissionsManagerProvider;
    }

    public final String am_() {
        return "group_mall_side_conversation";
    }

    public final void m17338e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("savedThreadName", this.ay.getText().toString().trim());
        bundle.putParcelable("savedThreadPhoto", this.aC);
        bundle.putParcelable("tmp_image", this.aB);
    }

    public final void m17337c(Bundle bundle) {
        super.c(bundle);
        Class cls = GroupsStartSideConversationFragment.class;
        m17333a((Object) this, getContext());
        this.aw = this.s.getString("group_feed_id");
        this.ax = this.s.getParcelableArrayList("PRE_SELECT_MEMBERS");
        o().getIntent().putExtra("group_feed_id", this.aw);
        this.aF = false;
    }

    public final View m17334a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1350120980);
        View inflate = layoutInflater.inflate(2130907225, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1326832399, a);
        return inflate;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1378857398);
        super.mi_();
        if (this.ax != null) {
            this.aE.a(this.ax);
            this.ax = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -246608224, a);
    }

    public final void m17336a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.ay = (FbEditText) e(2131567634);
        this.ay.getBackground().setColorFilter(jW_().getColor(2131363508), Mode.SRC_ATOP);
        this.ay.requestFocus();
        this.ay.setOnFocusChangeListener(new C16063(this));
        DefaultSideConversationNavigationHandler defaultSideConversationNavigationHandler = this.ap;
        OnClickListener onClickListener = this.aG;
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.c(true);
            hasTitleBar.a_(defaultSideConversationNavigationHandler.f14805a.getString(2131237919));
            Builder a = TitleBarButtonSpec.a();
            a.g = defaultSideConversationNavigationHandler.f14805a.getString(2131237921);
            a = a;
            a.h = -2;
            hasTitleBar.a(a.a());
            hasTitleBar.a(new C16011(defaultSideConversationNavigationHandler, onClickListener));
        }
        this.ar = this.aq.a(o());
        this.az = (ImageView) e(2131567632);
        this.aA = (DraweeView) e(2131567633);
        this.aE = (GroupsMembersSelectorFragment) s().a(2131567635);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(jW_());
        genericDraweeHierarchyBuilder.u = RoundingParams.e();
        this.aA.setHierarchy(genericDraweeHierarchyBuilder.u());
        if (bundle != null) {
            if (bundle.get("savedThreadName") != null) {
                this.ay.setText((String) bundle.get("savedThreadName"));
            }
            if (bundle.getParcelable("savedThreadPhoto") != null) {
                this.aC = (MediaResource) bundle.getParcelable("savedThreadPhoto");
            }
            if (bundle.getParcelable("tmp_image") != null) {
                this.aB = (Uri) bundle.getParcelable("tmp_image");
            }
        }
        final View b = FindViewUtil.b(view, 2131567631);
        b.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GroupsStartSideConversationFragment f14860b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1166350903);
                GroupsStartSideConversationFragment.as(this.f14860b);
                GroupsStartSideConversationFragment groupsStartSideConversationFragment = this.f14860b;
                View view2 = b;
                FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(view2.getContext());
                PopoverMenu c = figPopoverMenuWindow.c();
                if (groupsStartSideConversationFragment.aC != null) {
                    c.a(2131237929).setOnMenuItemClickListener(new C16107(groupsStartSideConversationFragment));
                }
                c.a(2131237930).setOnMenuItemClickListener(new C16118(groupsStartSideConversationFragment));
                c.a(2131237931).setOnMenuItemClickListener(new C16129(groupsStartSideConversationFragment));
                figPopoverMenuWindow.c(view2);
                figPopoverMenuWindow.d();
                Logger.a(2, EntryType.UI_INPUT_END, 1698610468, a);
            }
        });
        ax();
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1843910045);
        super.mY_();
        Fragment a2 = s().a(2131567635);
        if (a2 != null) {
            s().a().a(a2).c();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 189912826, a);
    }

    public final boolean O_() {
        if (this.aF) {
            return false;
        }
        if (this.ay.getText().toString().trim().isEmpty() && this.aE.b().size() <= 0 && this.aC == null) {
            return false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.a(true);
        builder.a(b(2131237939));
        builder.b(b(2131237940));
        builder.a(b(2131237941), new C16085(this));
        builder.b(b(2131237942), new C16096(this));
        builder.a().show();
        return true;
    }

    public static void ar(GroupsStartSideConversationFragment groupsStartSideConversationFragment) {
        groupsStartSideConversationFragment.aF = true;
        groupsStartSideConversationFragment.o().onBackPressed();
    }

    public static void as(GroupsStartSideConversationFragment groupsStartSideConversationFragment) {
        groupsStartSideConversationFragment.f14867b.hideSoftInputFromWindow(groupsStartSideConversationFragment.T.getWindowToken(), 0);
    }

    public static void at(GroupsStartSideConversationFragment groupsStartSideConversationFragment) {
        if (groupsStartSideConversationFragment.aD != null) {
            groupsStartSideConversationFragment.aD.b();
        }
    }

    private void ax() {
        if (this.aC != null && this.aC.c != null) {
            this.aA.setController(this.ao.a(au).b(this.aC.c).s());
            this.az.setVisibility(8);
            this.aA.setVisibility(0);
        }
    }

    public final void m17335a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1) {
            MediaResourceBuilder a;
            switch (i) {
                case 1010:
                    a = MediaResource.a();
                    a.a = this.aB;
                    a = a;
                    a.b = Type.PHOTO;
                    a = a;
                    a.c = Source.CAMERA;
                    this.aC = a.C();
                    ax();
                    return;
                case 1011:
                    a = MediaResource.a();
                    a.a = intent.getData();
                    a = a;
                    a.b = Type.PHOTO;
                    a = a;
                    a.c = Source.GALLERY;
                    this.aC = a.C();
                    ax();
                    return;
                default:
                    return;
            }
        }
    }
}
