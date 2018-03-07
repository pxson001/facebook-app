package com.facebook.groups.feed.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.annotationprocessors.transformer.api.Clone;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.bookmark.client.BookmarkClient;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.shortcuts.InstallShortcutHelper;
import com.facebook.common.shortcuts.InstallShortcutHelper.IconStyle;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.config.application.FbAppType;
import com.facebook.content.SecureContextHelper;
import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.create.EventCreationNikumanActivity;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.calls.GroupLeaveInputData;
import com.facebook.graphql.calls.GroupLeaveInputData.ReaddPolicy;
import com.facebook.graphql.calls.GroupRequestToJoinInputData.Source;
import com.facebook.graphql.calls.GroupSubscribeInputData.SubscribeLocation;
import com.facebook.graphql.calls.GroupUnsubscribeInputData;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLInterfaces$FetchGroupInformation$;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.DraculaImplementation;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel.Builder;
import com.facebook.groups.feed.ui.GroupsFeedFragment.AnonymousClass15;
import com.facebook.groups.feed.ui.GroupsPlutoniumHeaderAdapter.GroupsPlutoniumHeaderAdapterListener;
import com.facebook.groups.feed.ui.headerstore.GroupsFeedHeaderStore;
import com.facebook.groups.info.GroupInfoIntentBuilder;
import com.facebook.groups.memberpicker.GroupsAddMemberIntentProvider;
import com.facebook.groups.mutations.GroupsClient;
import com.facebook.inject.Assisted;
import com.facebook.search.titlebar.GraphSearchIntentLauncher;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: ThreadViewMessagesFragment.forceUpdateMessageListUIForPendingSend */
public class GroupsPlutoniumHeaderActionBarController implements GroupsPlutoniumHeaderAdapterListener {
    public static final Class f22303a = GroupsPlutoniumHeaderActionBarController.class;
    private final Boolean f22304b;
    public AnonymousClass15 f22305c;
    public final GroupsClient f22306d;
    private final FbUriIntentHandler f22307e;
    public final SecureContextHelper f22308f;
    private final AnalyticsLogger f22309g;
    private final InstallShortcutHelper f22310h;
    public final Toaster f22311i;
    private final DefaultAndroidThreadUtil f22312j;
    public final Provider<ComponentName> f22313k;
    private final BookmarkClient f22314l;
    private final TasksManager f22315m;
    private final Provider<ViewerContext> f22316n;
    public final AbstractFbErrorReporter f22317o;
    public final GraphSearchIntentLauncher f22318p;
    private final GroupsAddMemberIntentProvider f22319q;
    private final GroupInfoIntentBuilder f22320r;

    /* compiled from: ThreadViewMessagesFragment.forceUpdateMessageListUIForPendingSend */
    enum Task {
        GROUP_ADD_TO_FAVORITES,
        GROUP_REMOVE_FROM_FAVORITES,
        GROUP_FOLLOW_UNFOLLOW
    }

    @Inject
    public GroupsPlutoniumHeaderActionBarController(@Assisted GroupsFeedHeaderStore groupsFeedHeaderStore, FbUriIntentHandler fbUriIntentHandler, SecureContextHelper secureContextHelper, AnalyticsLogger analyticsLogger, InstallShortcutHelper installShortcutHelper, Toaster toaster, GroupsClient groupsClient, @FragmentChromeActivity Provider<ComponentName> provider, AndroidThreadUtil androidThreadUtil, BookmarkClient bookmarkClient, TasksManager tasksManager, FbAppType fbAppType, Provider<ViewerContext> provider2, FbErrorReporter fbErrorReporter, GraphSearchIntentLauncher graphSearchIntentLauncher, GroupsAddMemberIntentProvider groupsAddMemberIntentProvider, GroupInfoIntentBuilder groupInfoIntentBuilder, Boolean bool) {
        this.f22305c = groupsFeedHeaderStore;
        this.f22307e = fbUriIntentHandler;
        this.f22308f = secureContextHelper;
        this.f22309g = analyticsLogger;
        this.f22310h = installShortcutHelper;
        this.f22311i = toaster;
        this.f22306d = groupsClient;
        this.f22312j = androidThreadUtil;
        this.f22313k = provider;
        this.f22314l = bookmarkClient;
        this.f22315m = tasksManager;
        this.f22316n = provider2;
        this.f22317o = fbErrorReporter;
        this.f22318p = graphSearchIntentLauncher;
        this.f22319q = groupsAddMemberIntentProvider;
        this.f22320r = groupInfoIntentBuilder;
        this.f22304b = bool;
    }

    public final void mo988a() {
        this.f22315m.c();
    }

    public final void m23402a(FetchGroupInformationModel fetchGroupInformationModel, Context context) {
        if (fetchGroupInformationModel == null || fetchGroupInformationModel.gW_() == null) {
            this.f22317o.a(f22303a.getName(), "groupInformation or groupId is null in openGroupInfo");
            return;
        }
        m23396a("open_group_info");
        this.f22308f.a(this.f22320r.m23672b(fetchGroupInformationModel), context);
    }

    @Clone(from = "startSharingIntent", processor = "com.facebook.dracula.transformer.Transformer")
    public final void m23401a(FetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$, Context context) {
        boolean z;
        int i = 1;
        if (fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ == null) {
            z = true;
        } else {
            DraculaReturnValue b = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i2 = b.b;
            int i3 = b.c;
            z = DraculaRuntime.a(mutableFlatBuffer, i2, null, 0);
        }
        if (!z) {
            b = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.b();
            mutableFlatBuffer = b.a;
            i2 = b.b;
            i3 = b.c;
            if (mutableFlatBuffer.k(i2, 15) != null) {
                i = 0;
            }
        }
        if (i != 0) {
            this.f22317o.a(f22303a.getName(), "groupInformation or url is null in startSharingIntent");
            return;
        }
        m23396a("share_group");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        DraculaReturnValue b2 = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.b();
        MutableFlatBuffer mutableFlatBuffer2 = b2.a;
        int i4 = b2.b;
        int i5 = b2.c;
        intent.putExtra("android.intent.extra.TEXT", mutableFlatBuffer2.k(i4, 15).toString());
        this.f22308f.b(Intent.createChooser(intent, context.getString(2131238006)), context);
    }

    @Clone(from = "changeGroupSubscriptionStatus", processor = "com.facebook.dracula.transformer.Transformer")
    public final void m23399a(Context context, final boolean z, final FetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$) {
        if (fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ == null || fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_() == null) {
            this.f22317o.a(f22303a.getName(), "groupInformation or groupId is null in changeGroupSubscriptionStatus");
            return;
        }
        String string;
        final FetchGroupInformationModel a = FetchGroupInformationModel.a(fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$);
        Builder a2 = Builder.a(a);
        if (z) {
            m23396a("follow_group");
            a2.k = GraphQLSubscribeStatus.IS_SUBSCRIBED;
            string = context.getString(2131238002);
        } else {
            m23396a("unfollow_group");
            a2.k = GraphQLSubscribeStatus.CAN_SUBSCRIBE;
            string = context.getString(2131238003);
        }
        final FetchGroupInformationModel a3 = a2.a();
        this.f22305c.m23231a(a, a3);
        final Context context2 = context;
        this.f22315m.a(Task.GROUP_FOLLOW_UNFOLLOW, new Callable<ListenableFuture<Void>>(this) {
            final /* synthetic */ GroupsPlutoniumHeaderActionBarController f22281c;

            public Object call() {
                if (z) {
                    return this.f22281c.f22306d.a(fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_(), SubscribeLocation.GROUP_JOIN);
                }
                return this.f22281c.f22306d.a(fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_(), GroupUnsubscribeInputData.SubscribeLocation.GROUP_JOIN);
            }
        }, new AbstractDisposableFutureCallback<Void>(this) {
            final /* synthetic */ GroupsPlutoniumHeaderActionBarController f22286e;

            protected final void m23391a(Throwable th) {
                Context context = context2;
                CharSequence string = context2.getString(2131238004);
                new AlertDialog.Builder(context).a(string).b(string).a(2131238005, null).b();
                this.f22286e.f22305c.m23231a(a3, a);
            }
        });
    }

    @Clone(from = "favoriteGroup", processor = "com.facebook.dracula.transformer.Transformer")
    public final void m23400a(FetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$) {
        boolean z;
        if (fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ == null) {
            z = true;
        } else {
            DraculaReturnValue b = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        }
        if (z || fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_() == null) {
            this.f22317o.a(f22303a.getName(), "groupInformation or groupId is null in favoriteGroup");
            return;
        }
        long parseLong = Long.parseLong(fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_());
        b = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.b();
        MutableFlatBuffer mutableFlatBuffer2 = b.a;
        int i3 = b.b;
        i2 = b.c;
        b = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.b();
        MutableFlatBuffer mutableFlatBuffer3 = b.a;
        int i4 = b.b;
        i2 = b.c;
        b = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.b();
        MutableFlatBuffer mutableFlatBuffer4 = b.a;
        int i5 = b.b;
        i2 = b.c;
        final ListenableFuture a = this.f22314l.a(new Bookmark(parseLong, mutableFlatBuffer2.k(i3, 13), mutableFlatBuffer3.k(i4, 15), 0, null, mutableFlatBuffer4.k(mutableFlatBuffer4.g(i5, 0), 0), null, null));
        if (a != null) {
            final FetchGroupInformationModel a2 = FetchGroupInformationModel.a(fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$);
            Builder a3 = Builder.a(a2);
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(1024);
            int a4 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            i3 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            int b2 = flatBufferBuilder.b(null);
            i4 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            int a5 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            int a6 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            int a7 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            int a8 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            int a9 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            int b3 = flatBufferBuilder.b(null);
            int b4 = flatBufferBuilder.b(null);
            int a10 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            int b5 = flatBufferBuilder.b(null);
            int e = flatBufferBuilder.e(null);
            int a11 = flatBufferBuilder.a(null);
            int a12 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            flatBufferBuilder.c(19);
            flatBufferBuilder.b(0, a4);
            flatBufferBuilder.b(1, i3);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, i4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.a(5, 0, 0);
            flatBufferBuilder.b(6, a6);
            flatBufferBuilder.b(7, a7);
            flatBufferBuilder.b(8, a8);
            flatBufferBuilder.b(9, a9);
            flatBufferBuilder.a(10, true);
            flatBufferBuilder.b(11, b3);
            flatBufferBuilder.a(12, false);
            flatBufferBuilder.b(13, b4);
            flatBufferBuilder.b(14, a10);
            flatBufferBuilder.b(15, b5);
            flatBufferBuilder.b(16, e);
            flatBufferBuilder.b(17, a11);
            flatBufferBuilder.b(18, a12);
            DraculaReturnValue a13 = DraculaReturnValue.a(flatBufferBuilder, 291056794);
            a3.a(a13.a, a13.b, a13.c);
            final FetchGroupInformationModel a14 = a3.a();
            this.f22305c.m23231a(a2, a14);
            this.f22315m.a(Task.GROUP_ADD_TO_FAVORITES, new Callable<ListenableFuture<OperationResult>>(this) {
                final /* synthetic */ GroupsPlutoniumHeaderActionBarController f22288b;

                public Object call() {
                    return a;
                }
            }, new AbstractDisposableFutureCallback<OperationResult>(this) {
                final /* synthetic */ GroupsPlutoniumHeaderActionBarController f22291c;

                protected final void m23392a(Object obj) {
                    this.f22291c.f22305c.m23232a(true);
                }

                protected final void m23393a(Throwable th) {
                    this.f22291c.f22311i.a(new ToastBuilder(2131238000));
                    this.f22291c.f22305c.m23231a(a14, a2);
                }
            });
        }
    }

    @Clone(from = "unfavoriteGroup", processor = "com.facebook.dracula.transformer.Transformer")
    public final void m23404b(FetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$) {
        if (fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ == null || fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_() == null) {
            this.f22317o.a(f22303a.getName(), "groupInformation or groupId is null in unfavoriteGroup");
            return;
        }
        m23396a("remove_group_from_favorite");
        final ListenableFuture a = this.f22314l.a(Long.parseLong(fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_()));
        if (a != null) {
            final FetchGroupInformationModel a2 = FetchGroupInformationModel.a(fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$);
            Builder a3 = Builder.a(a2);
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(1024);
            int a4 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            int a5 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            int b = flatBufferBuilder.b(null);
            int a6 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            int a7 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            int a8 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            int a9 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            int a10 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            int a11 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            int b2 = flatBufferBuilder.b(null);
            int b3 = flatBufferBuilder.b(null);
            int a12 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            int b4 = flatBufferBuilder.b(null);
            int e = flatBufferBuilder.e(null);
            int a13 = flatBufferBuilder.a(null);
            int a14 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
            flatBufferBuilder.c(19);
            flatBufferBuilder.b(0, a4);
            flatBufferBuilder.b(1, a5);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a6);
            flatBufferBuilder.b(4, a7);
            flatBufferBuilder.a(5, 0, 0);
            flatBufferBuilder.b(6, a8);
            flatBufferBuilder.b(7, a9);
            flatBufferBuilder.b(8, a10);
            flatBufferBuilder.b(9, a11);
            flatBufferBuilder.a(10, true);
            flatBufferBuilder.b(11, b2);
            flatBufferBuilder.a(12, false);
            flatBufferBuilder.b(13, b3);
            flatBufferBuilder.b(14, a12);
            flatBufferBuilder.b(15, b4);
            flatBufferBuilder.b(16, e);
            flatBufferBuilder.b(17, a13);
            flatBufferBuilder.b(18, a14);
            DraculaReturnValue a15 = DraculaReturnValue.a(flatBufferBuilder, 291056794);
            a3.a(a15.a, a15.b, a15.c);
            final FetchGroupInformationModel a16 = a3.a();
            this.f22305c.m23231a(a2, a16);
            this.f22315m.a(Task.GROUP_REMOVE_FROM_FAVORITES, new Callable<ListenableFuture<OperationResult>>(this) {
                final /* synthetic */ GroupsPlutoniumHeaderActionBarController f22293b;

                public Object call() {
                    return a;
                }
            }, new AbstractDisposableFutureCallback<OperationResult>(this) {
                final /* synthetic */ GroupsPlutoniumHeaderActionBarController f22296c;

                protected final void m23394a(Object obj) {
                    this.f22296c.f22305c.m23232a(true);
                }

                protected final void m23395a(Throwable th) {
                    this.f22296c.f22311i.a(new ToastBuilder(2131238001));
                    this.f22296c.f22305c.m23231a(a16, a2);
                }
            });
        }
    }

    @Clone(from = "createShortcut", processor = "com.facebook.dracula.transformer.Transformer")
    public final void m23405c(FetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$) {
        if (fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ == null || fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_() == null) {
            this.f22317o.a(f22303a.getName(), "groupInformation or groupId is null in createShortcut");
            return;
        }
        Uri parse;
        m23396a("create_shortcut_group");
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.u, fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_());
        DraculaReturnValue b = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.b();
        MutableFlatBuffer mutableFlatBuffer = b.a;
        int i = b.b;
        int i2 = b.c;
        if (DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(i, 1), null, 0)) {
            i2 = 0;
        } else {
            b = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            i2 = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(mutableFlatBuffer.g(i, 1), 0), null, 0) ? 1 : 0;
        }
        if (i2 != 0) {
            b = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.b();
            mutableFlatBuffer = b.a;
            i = b.b;
            i2 = b.c;
            i2 = !DraculaRuntime.a(mutableFlatBuffer, mutableFlatBuffer.g(mutableFlatBuffer.g(mutableFlatBuffer.g(i, 1), 0), 2), null, 0) ? 1 : 0;
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            b = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.b();
            MutableFlatBuffer mutableFlatBuffer2 = b.a;
            int i3 = b.b;
            i2 = b.c;
            parse = Uri.parse(mutableFlatBuffer2.k(mutableFlatBuffer2.g(mutableFlatBuffer2.g(mutableFlatBuffer2.g(i3, 1), 0), 2), 0));
        } else {
            parse = null;
        }
        DraculaReturnValue b2 = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.b();
        MutableFlatBuffer mutableFlatBuffer3 = b2.a;
        int i4 = b2.b;
        int i5 = b2.c;
        this.f22310h.b(formatStrLocaleSafe, mutableFlatBuffer3.k(i4, 13), parse, IconStyle.ROUNDED);
        this.f22311i.b(new ToastBuilder(2131237985));
    }

    public final void m23398a(Context context) {
        m23396a("create_new_group");
        if (this.f22304b.booleanValue()) {
            this.f22307e.a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, "https://m.facebook.com/groups/create?renderBasic=true"));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("ref", "groups_mall_header");
        this.f22307e.a(context, FBLinks.D, bundle);
    }

    @Clone(from = "createNewGroupChat", processor = "com.facebook.dracula.transformer.Transformer")
    public final void m23406c(FetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$, Context context) {
        m23396a("group_side_conversation_displayed");
        Intent component = new Intent().setComponent((ComponentName) this.f22313k.get());
        component.putExtra("group_feed_id", fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_());
        component.putExtra("target_fragment", ContentFragmentType.GROUP_CREATE_SIDE_CONVERSATION_FRAGMENT.ordinal());
        this.f22308f.a(component, context);
    }

    @Clone(from = "createNewGroupEvent", processor = "com.facebook.dracula.transformer.Transformer")
    public final void m23408d(FetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$, Context context) {
        String str = null;
        m23396a("create_new_group_event");
        DraculaReturnValue b = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.b();
        MutableFlatBuffer mutableFlatBuffer = b.a;
        int i = b.b;
        int i2 = b.c;
        b = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.b();
        MutableFlatBuffer mutableFlatBuffer2 = b.a;
        int i3 = b.b;
        i2 = b.c;
        b = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.b();
        MutableFlatBuffer mutableFlatBuffer3 = b.a;
        int i4 = b.b;
        i2 = b.c;
        if (!DraculaRuntime.a(mutableFlatBuffer3, mutableFlatBuffer3.g(i4, 14), null, 0)) {
            b = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.b();
            mutableFlatBuffer3 = b.a;
            i4 = b.b;
            i2 = b.c;
            str = mutableFlatBuffer3.k(mutableFlatBuffer3.g(i4, 14), 1);
        }
        this.f22308f.a(EventCreationNikumanActivity.m16519a(context, "group_header".toString(), Long.valueOf(Long.parseLong(((ViewerContext) this.f22316n.get()).mUserId)), ActionMechanism.GROUP_PERMALINK_ACTIONS, fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_(), mutableFlatBuffer.k(i, 13), (GraphQLGroupVisibility) mutableFlatBuffer2.f(i3, 17, GraphQLGroupVisibility.class), str), context);
    }

    @Clone(from = "addMembersToGroup", processor = "com.facebook.dracula.transformer.Transformer")
    public final void m23410e(FetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$, Context context) {
        if (fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ == null || fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_() == null) {
            this.f22317o.a(f22303a.getName(), "groupInformation or groupId is null in addMembersToGroup");
            return;
        }
        m23396a("add_members_to_group");
        this.f22308f.a(this.f22319q.b(fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_(), context), context);
    }

    @Clone(from = "sendJoinGroupRequest", processor = "com.facebook.dracula.transformer.Transformer")
    public final void m23407d(FetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$) {
        if (fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ == null) {
            this.f22317o.a(f22303a.getName(), "groupInformation is null in sendJoinGroupRequest");
        } else if (fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.p() == GraphQLGroupJoinState.CAN_JOIN || fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.p() == GraphQLGroupJoinState.CAN_REQUEST) {
            m23396a("send_join_request_to_group");
            ListenableFuture a = this.f22306d.a(fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_(), Source.MOBILE_GROUP_JOIN);
            final FetchGroupInformationModel a2 = FetchGroupInformationModel.a(fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$);
            Builder a3 = Builder.a(a2);
            a3.p = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.p() == GraphQLGroupJoinState.CAN_JOIN ? GraphQLGroupJoinState.MEMBER : GraphQLGroupJoinState.REQUESTED;
            final FetchGroupInformationModel a4 = a3.a();
            this.f22305c.m23231a(a2, a4);
            this.f22312j.a(a, new FutureCallback<Void>(this) {
                final /* synthetic */ GroupsPlutoniumHeaderActionBarController f22299c;

                public void onSuccess(Object obj) {
                    this.f22299c.f22305c.m23232a(true);
                }

                public void onFailure(Throwable th) {
                    this.f22299c.f22305c.m23231a(a4, a2);
                    this.f22299c.f22305c.m23232a(true);
                }
            });
        }
    }

    @Clone(from = "sendCancelGroupJoinRequestRequest", processor = "com.facebook.dracula.transformer.Transformer")
    public final void m23409e(FetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$) {
        boolean z;
        if (fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ == null) {
            z = true;
        } else {
            DraculaReturnValue b = fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            z = DraculaRuntime.a(mutableFlatBuffer, i, null, 0);
        }
        if (z) {
            this.f22317o.a(f22303a.getName(), "groupInformation is null in sendCancelGroupJoinRequestRequest");
        } else if (fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.p() == GraphQLGroupJoinState.REQUESTED || fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.p() == GraphQLGroupJoinState.MEMBER) {
            if (fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.p() == GraphQLGroupJoinState.MEMBER) {
                m23396a("send_leave_request_to_group");
            } else {
                m23396a("send_cancel_request_to_group");
            }
            ListenableFuture a = this.f22306d.a(fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_(), GroupLeaveInputData.Source.MOBILE_GROUP_JOIN, ReaddPolicy.ALLOW_READD);
            final FetchGroupInformationModel a2 = FetchGroupInformationModel.a(fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$);
            Builder a3 = Builder.a(a2);
            a3.p = GraphQLGroupJoinState.CAN_REQUEST;
            final FetchGroupInformationModel a4 = a3.a();
            this.f22305c.m23231a(a2, a4);
            this.f22312j.a(a, new FutureCallback<Void>(this) {
                final /* synthetic */ GroupsPlutoniumHeaderActionBarController f22302c;

                public void onSuccess(Object obj) {
                    this.f22302c.f22305c.m23232a(true);
                }

                public void onFailure(Throwable th) {
                    this.f22302c.f22305c.m23231a(a4, a2);
                    this.f22302c.f22305c.m23232a(true);
                }
            });
        }
    }

    public final void m23403a(AnonymousClass15 anonymousClass15) {
        this.f22305c = anonymousClass15;
    }

    @Clone(from = "reportGroup", processor = "com.facebook.dracula.transformer.Transformer")
    public final void m23411f(FetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$, Context context) {
        if (fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ == null || fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_() == null) {
            this.f22317o.a(f22303a.getName(), "groupInformation or groupId is null in reportGroup");
            return;
        }
        m23396a("report_group");
        this.f22307e.a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, StringFormatUtil.formatStrLocaleSafe("/report/id/?id=%s", fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_())));
    }

    @Clone(from = "editNotificationSetting", processor = "com.facebook.dracula.transformer.Transformer")
    public final void m23412g(FetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$, Context context) {
        if (fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$ == null || fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_() == null) {
            this.f22317o.a(f22303a.getName(), "groupInformation or groupId is null in editNotificationSetting");
            return;
        }
        m23396a("edit_group_notif_setting");
        this.f22307e.a(context, StringFormatUtil.formatStrLocaleSafe("https://m.facebook.com/group/settings/?group_id=%s", fetchGroupInformationGraphQLInterfaces$FetchGroupInformation$.gW_()));
    }

    private void m23396a(String str) {
        HoneyClientEventFast a = this.f22309g.a(str, false);
        if (a.a()) {
            a.a("group_header");
            a.b();
        }
    }
}
