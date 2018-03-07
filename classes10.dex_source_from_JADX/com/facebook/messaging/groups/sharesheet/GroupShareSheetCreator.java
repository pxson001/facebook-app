package com.facebook.messaging.groups.sharesheet;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.view.LayoutInflater;
import com.facebook.common.util.ClipboardUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.groups.admin.GroupAdminController;
import com.facebook.messaging.groups.logging.GroupJoinableLinksLogger;
import com.facebook.messaging.groups.sharesheet.GroupCustomShareActionsView.Callback;
import com.facebook.messaging.groups.threadactions.ChangeJoinableGroupModeCallback;
import com.facebook.messaging.groups.threadactions.GroupThreadActionHandler;
import com.facebook.messaging.groups.threadactions.GroupThreadActionHandler.C04336;
import com.facebook.messaging.groups.threadactions.GroupThreadModelUpgrader;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummary.GroupType;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.facebook.widget.bottomsheet.SlideUpDialogView;
import com.facebook.widget.bottomsheet.sharesheet.ShareSheetIntentAdapter;
import com.facebook.widget.bottomsheet.sharesheet.ShareSheetIntentAdapterProvider;
import com.facebook.widget.bottomsheet.sharesheet.ShareSheetIntentLauncher;
import com.facebook.widget.recyclerview.RecyclerViewAdapterWithHeadersAndFooters;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: should_collapse */
public class GroupShareSheetCreator {
    public static final Intent f2515a = new Intent("android.intent.action.SEND").setType("text/plain");
    public final SecureContextHelper f2516b;
    public final ShareSheetIntentAdapterProvider f2517c;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<GroupThreadActionHandler> f2518d = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ShareSheetIntentLauncher> f2519e = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<GroupAdminController> f2520f = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<GroupThreadModelUpgrader> f2521g = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<GroupJoinableLinksLogger> f2522h = UltralightRuntime.b;
    public GroupShareSheetHeaderView f2523i;
    public Context f2524j;
    public ThreadSummary f2525k;
    public BottomSheetDialog f2526l;

    /* compiled from: should_collapse */
    public class C04182 {
        public final /* synthetic */ GroupShareSheetCreator f2508a;

        /* compiled from: should_collapse */
        public class C04171 implements ChangeJoinableGroupModeCallback {
            final /* synthetic */ ActivityInfo f2506a;
            final /* synthetic */ C04182 f2507b;

            public C04171(C04182 c04182, ActivityInfo activityInfo) {
                this.f2507b = c04182;
                this.f2506a = activityInfo;
            }

            public final void mo64a() {
                this.f2507b.f2508a.f2523i.m2551e(2131241308);
            }

            public final void mo65a(@Nullable Uri uri) {
                if (uri == null) {
                    this.f2507b.f2508a.f2523i.m2550d(2131241307);
                    return;
                }
                this.f2507b.f2508a.f2525k = ((GroupThreadModelUpgrader) this.f2507b.f2508a.f2521g.get()).m2578a(this.f2507b.f2508a.f2525k, uri);
                GroupShareSheetCreator.m2535a(this.f2507b.f2508a, this.f2506a, uri);
                this.f2507b.f2508a.f2523i.m2548a(((GroupAdminController) this.f2507b.f2508a.f2520f.get()).m2346c(this.f2507b.f2508a.f2525k), this.f2507b.f2508a.f2525k.Q);
            }

            public final void mo66b() {
                this.f2507b.f2508a.f2523i.m2550d(2131241307);
            }

            public final void mo67c() {
                this.f2507b.f2508a.f2523i.m2546a();
            }
        }

        public C04182(GroupShareSheetCreator groupShareSheetCreator) {
            this.f2508a = groupShareSheetCreator;
        }
    }

    /* compiled from: should_collapse */
    public class C04193 implements Callback {
        final /* synthetic */ GroupShareSheetCreator f2509a;

        public C04193(GroupShareSheetCreator groupShareSheetCreator) {
            this.f2509a = groupShareSheetCreator;
        }

        public final void mo68a() {
            ((GroupJoinableLinksLogger) this.f2509a.f2522h.get()).m2493b(this.f2509a.f2525k, "add_people");
            GroupShareSheetCreator groupShareSheetCreator = this.f2509a;
            groupShareSheetCreator.f2516b.a(new Intent().setAction(MessagingIntentUris.a).setData(Uri.parse(MessengerLinks.C)).putExtra("thread_key", groupShareSheetCreator.f2525k.a), groupShareSheetCreator.f2524j);
            this.f2509a.f2526l.dismiss();
        }

        public final void mo69b() {
            ((GroupJoinableLinksLogger) this.f2509a.f2522h.get()).m2493b(this.f2509a.f2525k, "copy");
            GroupShareSheetCreator groupShareSheetCreator = this.f2509a;
            if (groupShareSheetCreator.f2525k.d()) {
                GroupShareSheetCreator.m2536a(groupShareSheetCreator, groupShareSheetCreator.f2525k.I, ((GroupAdminController) groupShareSheetCreator.f2520f.get()).m2346c(groupShareSheetCreator.f2525k));
            } else {
                GroupShareSheetCreator.m2537a(groupShareSheetCreator, new C04237(groupShareSheetCreator));
            }
        }

        public final void mo70c() {
            ((GroupJoinableLinksLogger) this.f2509a.f2522h.get()).m2493b(this.f2509a.f2525k, "forward");
            GroupShareSheetCreator groupShareSheetCreator = this.f2509a;
            if (groupShareSheetCreator.f2525k.d()) {
                GroupShareSheetCreator.m2538a(groupShareSheetCreator, groupShareSheetCreator.f2525k.I.toString());
            } else {
                GroupShareSheetCreator.m2537a(groupShareSheetCreator, new C04226(groupShareSheetCreator));
            }
        }
    }

    /* compiled from: should_collapse */
    public class C04204 implements ToggleApprovalsShareSheetView.Callback {
        final /* synthetic */ GroupShareSheetCreator f2510a;

        public C04204(GroupShareSheetCreator groupShareSheetCreator) {
            this.f2510a = groupShareSheetCreator;
        }

        public final void mo71a(boolean z) {
            GroupShareSheetCreator groupShareSheetCreator = this.f2510a;
            GroupThreadActionHandler groupThreadActionHandler = (GroupThreadActionHandler) groupShareSheetCreator.f2518d.get();
            ThreadSummary threadSummary = groupShareSheetCreator.f2525k;
            Context context = groupShareSheetCreator.f2524j;
            groupThreadActionHandler.f2577a.m2342a(threadSummary, new C04336(groupThreadActionHandler, threadSummary, z, context, new C04215(groupShareSheetCreator, z)), context);
        }
    }

    /* compiled from: should_collapse */
    public class C04215 {
        public final /* synthetic */ boolean f2511a;
        public final /* synthetic */ GroupShareSheetCreator f2512b;

        public C04215(GroupShareSheetCreator groupShareSheetCreator, boolean z) {
            this.f2512b = groupShareSheetCreator;
            this.f2511a = z;
        }

        public final void m2525a(boolean z) {
            this.f2512b.f2523i.setPreviewTogglePosition(!z);
            this.f2512b.f2523i.m2550d(2131241307);
        }
    }

    /* compiled from: should_collapse */
    public class C04226 implements ChangeJoinableGroupModeCallback {
        final /* synthetic */ GroupShareSheetCreator f2513a;

        public C04226(GroupShareSheetCreator groupShareSheetCreator) {
            this.f2513a = groupShareSheetCreator;
        }

        public final void mo64a() {
            this.f2513a.f2523i.m2551e(2131241308);
        }

        public final void mo66b() {
            this.f2513a.f2523i.m2550d(2131241307);
        }

        public final void mo67c() {
            this.f2513a.f2523i.m2546a();
        }

        public final void mo65a(@Nullable Uri uri) {
            if (uri == null) {
                this.f2513a.f2523i.m2550d(2131241307);
                return;
            }
            this.f2513a.f2525k = ((GroupThreadModelUpgrader) this.f2513a.f2521g.get()).m2578a(this.f2513a.f2525k, uri);
            GroupShareSheetCreator.m2538a(this.f2513a, uri.toString());
        }
    }

    /* compiled from: should_collapse */
    public class C04237 implements ChangeJoinableGroupModeCallback {
        final /* synthetic */ GroupShareSheetCreator f2514a;

        public C04237(GroupShareSheetCreator groupShareSheetCreator) {
            this.f2514a = groupShareSheetCreator;
        }

        public final void mo64a() {
            this.f2514a.f2523i.m2551e(2131241308);
        }

        public final void mo66b() {
            this.f2514a.f2523i.m2550d(2131241307);
        }

        public final void mo67c() {
            this.f2514a.f2523i.m2546a();
        }

        public final void mo65a(@Nullable Uri uri) {
            if (uri == null) {
                this.f2514a.f2523i.m2550d(2131241307);
                return;
            }
            this.f2514a.f2525k = ((GroupThreadModelUpgrader) this.f2514a.f2521g.get()).m2578a(this.f2514a.f2525k, uri);
            GroupShareSheetCreator.m2536a(this.f2514a, uri, ((GroupAdminController) this.f2514a.f2520f.get()).m2346c(this.f2514a.f2525k));
        }
    }

    public static GroupShareSheetCreator m2539b(InjectorLike injectorLike) {
        GroupShareSheetCreator groupShareSheetCreator = new GroupShareSheetCreator((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (ShareSheetIntentAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ShareSheetIntentAdapterProvider.class));
        groupShareSheetCreator.m2534a(IdBasedLazy.a(injectorLike, 7872), IdBasedLazy.a(injectorLike, 11753), IdBasedLazy.a(injectorLike, 7861), IdBasedLazy.a(injectorLike, 7873), IdBasedSingletonScopeProvider.b(injectorLike, 7868));
        return groupShareSheetCreator;
    }

    @Inject
    public GroupShareSheetCreator(SecureContextHelper secureContextHelper, ShareSheetIntentAdapterProvider shareSheetIntentAdapterProvider) {
        this.f2516b = secureContextHelper;
        this.f2517c = shareSheetIntentAdapterProvider;
    }

    public final BottomSheetDialog m2540a(Context context, ThreadSummary threadSummary) {
        this.f2524j = (Context) Preconditions.checkNotNull(context);
        this.f2525k = (ThreadSummary) Preconditions.checkNotNull(threadSummary);
        this.f2526l = new BottomSheetDialog(context);
        this.f2523i = (GroupShareSheetHeaderView) LayoutInflater.from(this.f2524j).inflate(2130904696, null);
        this.f2523i.setActionCallback(new C04193(this));
        this.f2523i.setToggleApprovalCallback(new C04204(this));
        this.f2523i.m2547a(this.f2525k);
        ShareSheetIntentAdapter shareSheetIntentAdapter = new ShareSheetIntentAdapter(this.f2524j, f2515a, ShareSheetIntentLauncher.m13019b(this.f2517c));
        shareSheetIntentAdapter.f12985e = new C04182(this);
        RecyclerViewAdapterWithHeadersAndFooters recyclerViewAdapterWithHeadersAndFooters = new RecyclerViewAdapterWithHeadersAndFooters(shareSheetIntentAdapter);
        recyclerViewAdapterWithHeadersAndFooters.a(Lists.a(new GroupShareSheetHeaderView[]{this.f2523i}));
        final RecyclerViewAdapterWithHeadersAndFooters recyclerViewAdapterWithHeadersAndFooters2 = recyclerViewAdapterWithHeadersAndFooters;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
        gridLayoutManager.h = new SpanSizeLookup(this) {
            final /* synthetic */ GroupShareSheetCreator f2505c;

            public final int m2511a(int i) {
                if (i < recyclerViewAdapterWithHeadersAndFooters2.b.size()) {
                    return 3;
                }
                return 1;
            }
        };
        SlideUpDialogView slideUpDialogView = this.f2526l.b;
        Preconditions.checkNotNull(gridLayoutManager);
        if (!slideUpDialogView.i.equals(gridLayoutManager)) {
            slideUpDialogView.i = gridLayoutManager;
            slideUpDialogView.h.setLayoutManager(slideUpDialogView.i);
            slideUpDialogView.invalidate();
        }
        this.f2526l.a(recyclerViewAdapterWithHeadersAndFooters2);
        return this.f2526l;
    }

    public static void m2535a(GroupShareSheetCreator groupShareSheetCreator, ActivityInfo activityInfo, Uri uri) {
        ((ShareSheetIntentLauncher) groupShareSheetCreator.f2519e.get()).m13020a(groupShareSheetCreator.f2524j, new Intent(f2515a).putExtra("android.intent.extra.TEXT", uri.toString()), activityInfo);
    }

    private void m2534a(com.facebook.inject.Lazy<GroupThreadActionHandler> lazy, com.facebook.inject.Lazy<ShareSheetIntentLauncher> lazy2, com.facebook.inject.Lazy<GroupAdminController> lazy3, com.facebook.inject.Lazy<GroupThreadModelUpgrader> lazy4, com.facebook.inject.Lazy<GroupJoinableLinksLogger> lazy5) {
        this.f2518d = lazy;
        this.f2519e = lazy2;
        this.f2520f = lazy3;
        this.f2521g = lazy4;
        this.f2522h = lazy5;
    }

    public static void m2537a(GroupShareSheetCreator groupShareSheetCreator, ChangeJoinableGroupModeCallback changeJoinableGroupModeCallback) {
        ((GroupThreadActionHandler) groupShareSheetCreator.f2518d.get()).m2576a(groupShareSheetCreator.f2525k, GroupType.HIDDEN, groupShareSheetCreator.f2524j, changeJoinableGroupModeCallback, "action_sheet");
    }

    public static void m2536a(GroupShareSheetCreator groupShareSheetCreator, Uri uri, boolean z) {
        ClipboardUtil.a(groupShareSheetCreator.f2524j, uri.toString());
        groupShareSheetCreator.f2523i.m2548a(z, groupShareSheetCreator.f2525k.Q);
        groupShareSheetCreator.f2523i.m2549c(2131241306);
    }

    public static void m2538a(GroupShareSheetCreator groupShareSheetCreator, String str) {
        groupShareSheetCreator.f2516b.a(new Intent(MessagingIntentUris.a).setData(Uri.parse(MessengerLinks.p)).putExtra("android.intent.extra.TEXT", str), groupShareSheetCreator.f2524j);
        groupShareSheetCreator.f2526l.dismiss();
    }
}
