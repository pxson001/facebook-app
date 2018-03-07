package com.facebook.groups.fb4a.create;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import com.facebook.api.feedcache.mutator.FeedUnitCacheMutator;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.FindViewUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
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
import com.facebook.groups.create.GroupCreationProgressDialogFragment;
import com.facebook.groups.create.event.GroupCreatedEvent;
import com.facebook.groups.create.event.GroupCreatedEventBus;
import com.facebook.groups.create.protocol.CreateGroupParams;
import com.facebook.groups.create.protocol.GroupCreationActionHandler;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.mediastorage.MediaStorage;
import com.facebook.resources.ui.FbEditText;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: payments_initiate_add_card */
public class FB4AGroupsCreateFragment extends FbFragment implements CanHandleBackPressed {
    public static final Class f6862a = FB4AGroupsCreateFragment.class;
    public static final String[] ap = new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    public static final String[] aq = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    private static final CallerContext as = CallerContext.a(FB4AGroupsCreateFragment.class, "group_creation");
    public boolean aA = true;
    public boolean aB;
    public String aC;
    public String aD;
    public String aE;
    public String aF;
    public String aG;
    public ActivityRuntimePermissionsManager aH;
    public FB4AGroupsCreateMemberPickerFragment aI;
    private FB4AGroupsCreatePrivacySelectorFragment aJ;
    private final C07061 aK = new C07061(this);
    @Inject
    ActivityRuntimePermissionsManagerProvider al;
    @Inject
    @IsWorkBuild
    public Boolean am;
    @Inject
    GroupCreatedEventBus an;
    @Inject
    FeedUnitCacheMutator ao;
    public String ar;
    public FbEditText at;
    public ImageView au;
    public DraweeView av;
    public Uri aw;
    public Uri ax;
    public MediaResource ay;
    public GroupCreationProgressDialogFragment az;
    @Inject
    public Toaster f6863b;
    @Inject
    InputMethodManager f6864c;
    @Inject
    public MediaStorage f6865d;
    @Inject
    FbDraweeControllerBuilder f6866e;
    @Inject
    public SecureContextHelper f6867f;
    @Inject
    GroupCreationActionHandler f6868g;
    @Inject
    TasksManager f6869h;
    @Inject
    GroupsAnalyticsLogger f6870i;

    /* compiled from: payments_initiate_add_card */
    public class C07061 {
        public final /* synthetic */ FB4AGroupsCreateFragment f6852a;

        C07061(FB4AGroupsCreateFragment fB4AGroupsCreateFragment) {
            this.f6852a = fB4AGroupsCreateFragment;
        }
    }

    /* compiled from: payments_initiate_add_card */
    class C07072 implements OnFocusChangeListener {
        final /* synthetic */ FB4AGroupsCreateFragment f6853a;

        C07072(FB4AGroupsCreateFragment fB4AGroupsCreateFragment) {
            this.f6853a = fB4AGroupsCreateFragment;
        }

        public void onFocusChange(View view, boolean z) {
            if (!z) {
                FB4AGroupsCreateFragment.m7138b(this.f6853a);
            }
        }
    }

    /* compiled from: payments_initiate_add_card */
    public class C07094 implements OnClickListener {
        final /* synthetic */ FB4AGroupsCreateFragment f6856a;

        public C07094(FB4AGroupsCreateFragment fB4AGroupsCreateFragment) {
            this.f6856a = fB4AGroupsCreateFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f6856a.f6870i.b();
            FB4AGroupsCreateFragment fB4AGroupsCreateFragment = this.f6856a;
            fB4AGroupsCreateFragment.aB = true;
            fB4AGroupsCreateFragment.o().onBackPressed();
        }
    }

    /* compiled from: payments_initiate_add_card */
    public class C07105 implements OnClickListener {
        final /* synthetic */ FB4AGroupsCreateFragment f6857a;

        public C07105(FB4AGroupsCreateFragment fB4AGroupsCreateFragment) {
            this.f6857a = fB4AGroupsCreateFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: payments_initiate_add_card */
    class C07116 extends AbstractDisposableFutureCallback<String> {
        final /* synthetic */ FB4AGroupsCreateFragment f6858a;

        C07116(FB4AGroupsCreateFragment fB4AGroupsCreateFragment) {
            this.f6858a = fB4AGroupsCreateFragment;
        }

        protected final void m7131a(Object obj) {
            String str = (String) obj;
            this.f6858a.f6863b.b(new ToastBuilder(2131239963));
            if (this.f6858a.ar != null) {
                this.f6858a.ao.a(this.f6858a.ar, this.f6858a.aE);
            }
            this.f6858a.f6870i.d();
            if (!(this.f6858a.aF == null || this.f6858a.aG == null)) {
                this.f6858a.f6870i.a(this.f6858a.aF, this.f6858a.aG, this.f6858a.aD, this.f6858a.aE, this.f6858a.aC);
            }
            if (!(this.f6858a.aC == null || !this.f6858a.aC.equals("gysc_tab") || this.f6858a.aE == null || this.f6858a.aD == null)) {
                this.f6858a.an.a(new GroupCreatedEvent(str, this.f6858a.aE, this.f6858a.aD));
            }
            FB4AGroupsCreateFragment fB4AGroupsCreateFragment = this.f6858a;
            FB4AGroupsCreateFragment.ax(fB4AGroupsCreateFragment);
            int ordinal = ContentFragmentType.GROUPS_MALL_FRAGMENT.ordinal();
            Intent intent = new Intent(fB4AGroupsCreateFragment.o(), fB4AGroupsCreateFragment.o().getClass());
            fB4AGroupsCreateFragment.o().finish();
            intent.putExtra("group_feed_id", str);
            intent.putExtra("target_fragment", ordinal);
            fB4AGroupsCreateFragment.f6867f.a(intent, fB4AGroupsCreateFragment.ao());
        }

        protected final void m7132a(Throwable th) {
            BLog.b(FB4AGroupsCreateFragment.f6862a, th.getMessage());
            FB4AGroupsCreateFragment.ax(this.f6858a);
            this.f6858a.f6870i.e();
            this.f6858a.f6863b.b(new ToastBuilder(2131239960));
        }
    }

    /* compiled from: payments_initiate_add_card */
    class C07127 extends OnToolbarButtonListener {
        final /* synthetic */ FB4AGroupsCreateFragment f6859a;

        C07127(FB4AGroupsCreateFragment fB4AGroupsCreateFragment) {
            this.f6859a = fB4AGroupsCreateFragment;
        }

        public final void m7133a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            Object obj;
            FB4AGroupsCreateFragment fB4AGroupsCreateFragment = this.f6859a;
            if (fB4AGroupsCreateFragment.at.getText().toString().trim().isEmpty()) {
                fB4AGroupsCreateFragment.f6863b.b(new ToastBuilder(2131239966));
                obj = null;
            } else if (fB4AGroupsCreateFragment.aI.m7154b().isEmpty() || !fB4AGroupsCreateFragment.aI.m7158e()) {
                fB4AGroupsCreateFragment.f6863b.b(new ToastBuilder(fB4AGroupsCreateFragment.am.booleanValue() ? 2131239965 : 2131239964));
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                fB4AGroupsCreateFragment.aA = false;
                HasTitleBar hasTitleBar = (HasTitleBar) fB4AGroupsCreateFragment.a(HasTitleBar.class);
                if (hasTitleBar != null) {
                    hasTitleBar.y_(2131239962);
                    Builder a = TitleBarButtonSpec.a();
                    a.g = fB4AGroupsCreateFragment.jW_().getString(2131239972);
                    a = a;
                    a.h = -2;
                    hasTitleBar.a(a.a());
                    hasTitleBar.a(new C07138(fB4AGroupsCreateFragment));
                }
                fB4AGroupsCreateFragment.e(2131561750).setVisibility(8);
                fB4AGroupsCreateFragment.e(2131561745).setVisibility(8);
                fB4AGroupsCreateFragment.e(2131561751).setVisibility(0);
            }
        }
    }

    /* compiled from: payments_initiate_add_card */
    public class C07138 extends OnToolbarButtonListener {
        final /* synthetic */ FB4AGroupsCreateFragment f6860a;

        public C07138(FB4AGroupsCreateFragment fB4AGroupsCreateFragment) {
            this.f6860a = fB4AGroupsCreateFragment;
        }

        public final void m7134a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            FB4AGroupsCreateFragment.av(this.f6860a);
        }
    }

    /* compiled from: payments_initiate_add_card */
    public class C07149 implements OnMenuItemClickListener {
        final /* synthetic */ FB4AGroupsCreateFragment f6861a;

        public C07149(FB4AGroupsCreateFragment fB4AGroupsCreateFragment) {
            this.f6861a = fB4AGroupsCreateFragment;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            FB4AGroupsCreateFragment fB4AGroupsCreateFragment = this.f6861a;
            fB4AGroupsCreateFragment.ay = null;
            fB4AGroupsCreateFragment.aw = null;
            fB4AGroupsCreateFragment.av.setVisibility(8);
            fB4AGroupsCreateFragment.au.setVisibility(0);
            return true;
        }
    }

    /* compiled from: payments_initiate_add_card */
    enum Tasks {
        TASK_CREATE_GROUP
    }

    public static void m7137a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FB4AGroupsCreateFragment) obj).m7136a(Toaster.b(fbInjector), InputMethodManagerMethodAutoProvider.b(fbInjector), MediaStorage.a(fbInjector), FbDraweeControllerBuilder.b(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), GroupCreationActionHandler.m7117b(fbInjector), TasksManager.b(fbInjector), GroupsAnalyticsLogger.a(fbInjector), (ActivityRuntimePermissionsManagerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector), GroupCreatedEventBus.m7103a(fbInjector), FeedUnitCacheMutator.a(fbInjector));
    }

    private void m7136a(Toaster toaster, InputMethodManager inputMethodManager, MediaStorage mediaStorage, FbDraweeControllerBuilder fbDraweeControllerBuilder, SecureContextHelper secureContextHelper, GroupCreationActionHandler groupCreationActionHandler, TasksManager tasksManager, GroupsAnalyticsLogger groupsAnalyticsLogger, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, Boolean bool, GroupCreatedEventBus groupCreatedEventBus, FeedUnitCacheMutator feedUnitCacheMutator) {
        this.f6863b = toaster;
        this.f6864c = inputMethodManager;
        this.f6865d = mediaStorage;
        this.f6866e = fbDraweeControllerBuilder;
        this.f6867f = secureContextHelper;
        this.f6868g = groupCreationActionHandler;
        this.f6869h = tasksManager;
        this.f6870i = groupsAnalyticsLogger;
        this.al = activityRuntimePermissionsManagerProvider;
        this.am = bool;
        this.an = groupCreatedEventBus;
        this.ao = feedUnitCacheMutator;
    }

    public final void m7143e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("tmp_image", this.ax);
    }

    public final void m7142c(Bundle bundle) {
        super.c(bundle);
        Class cls = FB4AGroupsCreateFragment.class;
        m7137a((Object) this, getContext());
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 775693562);
        this.f6869h.c(Tasks.TASK_CREATE_GROUP);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 625800462, a);
    }

    public final View m7139a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1735709384);
        View inflate = layoutInflater.inflate(2130904250, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 44671250, a);
        return inflate;
    }

    public final void m7141a(View view, Bundle bundle) {
        super.a(view, bundle);
        ay();
        this.aH = this.al.a(o());
        Bundle bundle2 = this.s;
        this.aC = bundle2.getString("ref");
        if (this.aC == null) {
            BLog.c(f6862a, "Group creation source is not set");
        }
        this.aD = bundle2.getString("suggestion_category");
        this.aE = bundle2.getString("suggestion_identifier");
        this.aF = bundle2.getString("trackingcode_item");
        this.aG = bundle2.getString("trackingcode_unit");
        this.ar = bundle2.getString("cache_id");
        this.at = (FbEditText) e(2131561749);
        this.at.requestFocus();
        this.at.setOnFocusChangeListener(new C07072(this));
        this.at.setText(bundle2.getString("group_name"));
        this.au = (ImageView) e(2131561747);
        this.av = (DraweeView) e(2131561748);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(jW_());
        genericDraweeHierarchyBuilder.u = RoundingParams.e();
        this.av.setHierarchy(genericDraweeHierarchyBuilder.u());
        if (!(bundle == null || bundle.getParcelable("tmp_image") == null)) {
            this.ax = (Uri) bundle.getParcelable("tmp_image");
        }
        this.aI = (FB4AGroupsCreateMemberPickerFragment) s().a(2131561750);
        this.aI.m7157e(bundle2.getString("group_members"));
        this.aJ = (FB4AGroupsCreatePrivacySelectorFragment) s().a(2131561751);
        this.aJ.m7169a(bundle2.getString("group_visibility"));
        final View b = FindViewUtil.b(view, 2131561746);
        b.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ FB4AGroupsCreateFragment f6855b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 579959869);
                FB4AGroupsCreateFragment.m7138b(this.f6855b);
                FB4AGroupsCreateFragment fB4AGroupsCreateFragment = this.f6855b;
                View view2 = b;
                FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(view2.getContext());
                PopoverMenu c = figPopoverMenuWindow.c();
                if (fB4AGroupsCreateFragment.ay != null) {
                    c.a(2131239969).setOnMenuItemClickListener(new C07149(fB4AGroupsCreateFragment));
                }
                c.a(2131239970).setOnMenuItemClickListener(new OnMenuItemClickListener(fB4AGroupsCreateFragment) {
                    final /* synthetic */ FB4AGroupsCreateFragment f6848a;

                    {
                        this.f6848a = r1;
                    }

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        FB4AGroupsCreateFragment fB4AGroupsCreateFragment = this.f6848a;
                        fB4AGroupsCreateFragment.aH.a(FB4AGroupsCreateFragment.ap, new RuntimePermissionsListener(fB4AGroupsCreateFragment) {
                            final /* synthetic */ FB4AGroupsCreateFragment f6850a;

                            {
                                this.f6850a = r1;
                            }

                            public final void m7126a() {
                                FB4AGroupsCreateFragment fB4AGroupsCreateFragment = this.f6850a;
                                if (fB4AGroupsCreateFragment.ax == null) {
                                    fB4AGroupsCreateFragment.ax = fB4AGroupsCreateFragment.f6865d.c();
                                }
                                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                                intent.putExtra("output", fB4AGroupsCreateFragment.ax);
                                fB4AGroupsCreateFragment.f6867f.b(intent, 1010, fB4AGroupsCreateFragment.o());
                            }

                            public final void m7127a(String[] strArr, String[] strArr2) {
                                this.f6850a.f6863b.b(new ToastBuilder(this.f6850a.getContext().getString(2131237935)));
                            }

                            public final void m7128b() {
                            }
                        });
                        return true;
                    }
                });
                c.a(2131239971).setOnMenuItemClickListener(new OnMenuItemClickListener(fB4AGroupsCreateFragment) {
                    final /* synthetic */ FB4AGroupsCreateFragment f6849a;

                    {
                        this.f6849a = r1;
                    }

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        FB4AGroupsCreateFragment fB4AGroupsCreateFragment = this.f6849a;
                        fB4AGroupsCreateFragment.aH.a(FB4AGroupsCreateFragment.aq, new AbstractRuntimePermissionsListener(fB4AGroupsCreateFragment) {
                            final /* synthetic */ FB4AGroupsCreateFragment f6851a;

                            {
                                this.f6851a = r1;
                            }

                            public final void m7129a() {
                                FB4AGroupsCreateFragment fB4AGroupsCreateFragment = this.f6851a;
                                Intent intent = new Intent("android.intent.action.PICK");
                                intent.setType("image/*");
                                fB4AGroupsCreateFragment.f6867f.b(intent, 1011, fB4AGroupsCreateFragment.o());
                            }

                            public final void m7130a(String[] strArr, String[] strArr2) {
                                this.f6851a.f6863b.b(new ToastBuilder(this.f6851a.getContext().getString(2131237936)));
                            }
                        });
                        return true;
                    }
                });
                figPopoverMenuWindow.c(view2);
                figPopoverMenuWindow.d();
                Logger.a(2, EntryType.UI_INPUT_END, -286269803, a);
            }
        });
        e(2131561751).setVisibility(8);
        this.f6870i.c();
    }

    public static void m7138b(FB4AGroupsCreateFragment fB4AGroupsCreateFragment) {
        fB4AGroupsCreateFragment.f6864c.hideSoftInputFromWindow(fB4AGroupsCreateFragment.T.getWindowToken(), 0);
    }

    private void as() {
        ay();
        e(2131561750).setVisibility(0);
        e(2131561745).setVisibility(0);
        e(2131561751).setVisibility(8);
    }

    public final boolean O_() {
        if (this.aB) {
            return false;
        }
        if (!this.aA) {
            as();
            return true;
        } else if (this.at.getText().toString().trim().isEmpty() && this.aI.m7154b().isEmpty() && this.aw == null) {
            this.f6870i.b();
            return false;
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.a(true);
            builder.a(b(2131239981));
            builder.b(b(2131239982));
            builder.a(b(2131239983), new C07094(this));
            builder.b(b(2131239984), new C07105(this));
            builder.a().show();
            return true;
        }
    }

    public static void av(FB4AGroupsCreateFragment fB4AGroupsCreateFragment) {
        String b = fB4AGroupsCreateFragment.aJ.m7170b();
        String trim = fB4AGroupsCreateFragment.at.getText().toString().trim();
        CreateGroupParams.Builder builder = new CreateGroupParams.Builder();
        builder.f6792a = trim;
        CreateGroupParams.Builder builder2 = builder;
        builder2.f6793b = b;
        CreateGroupParams.Builder builder3 = builder2;
        builder3.f6796e = fB4AGroupsCreateFragment.aC;
        builder3 = builder3;
        builder3.f6797f = fB4AGroupsCreateFragment.aD;
        builder3 = builder3;
        builder3.f6798g = fB4AGroupsCreateFragment.aE;
        CreateGroupParams a = builder3.m7109a();
        GroupCreationProgressDialogFragment groupCreationProgressDialogFragment = new GroupCreationProgressDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("message_res_id", 2131239956);
        bundle.putBoolean("is_indeterminate", true);
        bundle.putBoolean("is_cancelable", false);
        bundle.putBoolean("dismiss_on_pause", false);
        groupCreationProgressDialogFragment.g(bundle);
        fB4AGroupsCreateFragment.az = groupCreationProgressDialogFragment;
        fB4AGroupsCreateFragment.az.a(fB4AGroupsCreateFragment.s(), null);
        fB4AGroupsCreateFragment.f6870i.a();
        fB4AGroupsCreateFragment.f6869h.a(Tasks.TASK_CREATE_GROUP, fB4AGroupsCreateFragment.f6868g.m7118a(a, fB4AGroupsCreateFragment.aI.m7154b(), fB4AGroupsCreateFragment.aK, fB4AGroupsCreateFragment.aw), new C07116(fB4AGroupsCreateFragment));
    }

    public static void ax(FB4AGroupsCreateFragment fB4AGroupsCreateFragment) {
        if (fB4AGroupsCreateFragment.az != null) {
            fB4AGroupsCreateFragment.az.b();
            fB4AGroupsCreateFragment.az = null;
        }
    }

    private void ay() {
        this.aA = true;
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.c(true);
            hasTitleBar.y_(2131239961);
            Builder a = TitleBarButtonSpec.a();
            a.g = jW_().getString(2131239973);
            a = a;
            a.h = -2;
            hasTitleBar.a(a.a());
            hasTitleBar.a(new C07127(this));
        }
    }

    private void aA() {
        if (this.ay == null || this.ay.c == null) {
            this.f6863b.b(new ToastBuilder(2131239968));
            return;
        }
        ImageRequestBuilder a = ImageRequestBuilder.a(this.ay.c);
        a.c = true;
        a = a;
        a.d = new ResizeOptions(jW_().getDisplayMetrics().widthPixels, jW_().getDisplayMetrics().heightPixels);
        this.av.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f6866e.b(this.av.getController())).a(as).c(a.m())).s());
        this.au.setVisibility(8);
        this.av.setVisibility(0);
    }

    public final void m7140a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1) {
            MediaResourceBuilder a;
            switch (i) {
                case 1010:
                    this.aw = this.ax;
                    this.ax = null;
                    a = MediaResource.a();
                    a.a = this.aw;
                    a = a;
                    a.b = Type.PHOTO;
                    a = a;
                    a.c = Source.CAMERA;
                    this.ay = a.C();
                    aA();
                    return;
                case 1011:
                    this.aw = m7135a(intent.getData());
                    a = MediaResource.a();
                    a.a = this.aw;
                    a = a;
                    a.b = Type.PHOTO;
                    a = a;
                    a.c = Source.GALLERY;
                    this.ay = a.C();
                    aA();
                    return;
                default:
                    return;
            }
        }
    }

    @Nullable
    private Uri m7135a(Uri uri) {
        Throwable th;
        Cursor cursor = null;
        if ("file".equals(uri.getScheme())) {
            return uri;
        }
        Cursor query;
        try {
            query = getContext().getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() != 0) {
                        int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                        query.moveToFirst();
                        uri = Uri.parse("file://" + query.getString(columnIndexOrThrow));
                        if (query == null) {
                            return uri;
                        }
                        query.close();
                        return uri;
                    }
                } catch (Exception e) {
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    cursor = query;
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            BLog.c(f6862a, "Cannot resolve real pic uri in group creation");
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Exception e2) {
            query = null;
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
