package com.facebook.groups.feed.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;

/* compiled from: ThreadViewMessagesFragment.forceUpdateMessageListState */
public class GroupsPlutoniumHeaderActionBarPopoverHelper {
    private static final Class<?> f22344a = GroupsPlutoniumHeaderActionBarPopoverHelper.class;

    /* compiled from: ThreadViewMessagesFragment.forceUpdateMessageListState */
    final class C32261 implements OnMenuItemClickListener {
        final /* synthetic */ GroupsPlutoniumHeaderActionBarController f22321a;
        final /* synthetic */ FetchGroupInformationModel f22322b;

        C32261(GroupsPlutoniumHeaderActionBarController groupsPlutoniumHeaderActionBarController, FetchGroupInformationModel fetchGroupInformationModel) {
            this.f22321a = groupsPlutoniumHeaderActionBarController;
            this.f22322b = fetchGroupInformationModel;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.f22321a.m23409e(this.f22322b);
            return true;
        }
    }

    /* compiled from: ThreadViewMessagesFragment.forceUpdateMessageListState */
    final class C32272 implements OnMenuItemClickListener {
        final /* synthetic */ GroupsPlutoniumHeaderActionBarController f22323a;
        final /* synthetic */ FetchGroupInformationModel f22324b;

        C32272(GroupsPlutoniumHeaderActionBarController groupsPlutoniumHeaderActionBarController, FetchGroupInformationModel fetchGroupInformationModel) {
            this.f22323a = groupsPlutoniumHeaderActionBarController;
            this.f22324b = fetchGroupInformationModel;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.f22323a.m23404b(this.f22324b);
            return true;
        }
    }

    /* compiled from: ThreadViewMessagesFragment.forceUpdateMessageListState */
    final class C32283 implements OnMenuItemClickListener {
        final /* synthetic */ GroupsPlutoniumHeaderActionBarController f22325a;
        final /* synthetic */ FetchGroupInformationModel f22326b;

        C32283(GroupsPlutoniumHeaderActionBarController groupsPlutoniumHeaderActionBarController, FetchGroupInformationModel fetchGroupInformationModel) {
            this.f22325a = groupsPlutoniumHeaderActionBarController;
            this.f22326b = fetchGroupInformationModel;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.f22325a.m23400a(this.f22326b);
            return true;
        }
    }

    /* compiled from: ThreadViewMessagesFragment.forceUpdateMessageListState */
    final class C32294 implements OnMenuItemClickListener {
        final /* synthetic */ GroupsPlutoniumHeaderActionBarController f22327a;
        final /* synthetic */ View f22328b;
        final /* synthetic */ boolean f22329c;
        final /* synthetic */ FetchGroupInformationModel f22330d;

        C32294(GroupsPlutoniumHeaderActionBarController groupsPlutoniumHeaderActionBarController, View view, boolean z, FetchGroupInformationModel fetchGroupInformationModel) {
            this.f22327a = groupsPlutoniumHeaderActionBarController;
            this.f22328b = view;
            this.f22329c = z;
            this.f22330d = fetchGroupInformationModel;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.f22327a.m23399a(this.f22328b.getContext(), this.f22329c, this.f22330d);
            return true;
        }
    }

    /* compiled from: ThreadViewMessagesFragment.forceUpdateMessageListState */
    final class C32305 implements OnMenuItemClickListener {
        final /* synthetic */ GroupsPlutoniumHeaderActionBarController f22331a;
        final /* synthetic */ View f22332b;
        final /* synthetic */ boolean f22333c;
        final /* synthetic */ FetchGroupInformationModel f22334d;

        C32305(GroupsPlutoniumHeaderActionBarController groupsPlutoniumHeaderActionBarController, View view, boolean z, FetchGroupInformationModel fetchGroupInformationModel) {
            this.f22331a = groupsPlutoniumHeaderActionBarController;
            this.f22332b = view;
            this.f22333c = z;
            this.f22334d = fetchGroupInformationModel;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.f22331a.m23399a(this.f22332b.getContext(), this.f22333c, this.f22334d);
            return true;
        }
    }

    /* compiled from: ThreadViewMessagesFragment.forceUpdateMessageListState */
    final class C32316 implements OnMenuItemClickListener {
        final /* synthetic */ GroupsPlutoniumHeaderActionBarController f22335a;
        final /* synthetic */ FetchGroupInformationModel f22336b;
        final /* synthetic */ View f22337c;

        C32316(GroupsPlutoniumHeaderActionBarController groupsPlutoniumHeaderActionBarController, FetchGroupInformationModel fetchGroupInformationModel, View view) {
            this.f22335a = groupsPlutoniumHeaderActionBarController;
            this.f22336b = fetchGroupInformationModel;
            this.f22337c = view;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.f22335a.m23412g(this.f22336b, this.f22337c.getContext());
            return true;
        }
    }

    /* compiled from: ThreadViewMessagesFragment.forceUpdateMessageListState */
    final class C32327 implements OnMenuItemClickListener {
        final /* synthetic */ FetchGroupInformationModel f22338a;
        final /* synthetic */ View f22339b;
        final /* synthetic */ GroupsPlutoniumHeaderActionBarController f22340c;

        C32327(FetchGroupInformationModel fetchGroupInformationModel, View view, GroupsPlutoniumHeaderActionBarController groupsPlutoniumHeaderActionBarController) {
            this.f22338a = fetchGroupInformationModel;
            this.f22339b = view;
            this.f22340c = groupsPlutoniumHeaderActionBarController;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            FetchGroupInformationModel fetchGroupInformationModel = this.f22338a;
            Context context = this.f22339b.getContext();
            new Builder(context).b(context.getString(2131238044)).a(2131238046, new C32338(this.f22340c, fetchGroupInformationModel)).b(2131238045, null).b();
            return true;
        }
    }

    /* compiled from: ThreadViewMessagesFragment.forceUpdateMessageListState */
    public final class C32338 implements OnClickListener {
        final /* synthetic */ GroupsPlutoniumHeaderActionBarController f22341a;
        final /* synthetic */ FetchGroupInformationModel f22342b;

        public C32338(GroupsPlutoniumHeaderActionBarController groupsPlutoniumHeaderActionBarController, FetchGroupInformationModel fetchGroupInformationModel) {
            this.f22341a = groupsPlutoniumHeaderActionBarController;
            this.f22342b = fetchGroupInformationModel;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.f22341a.m23409e(this.f22342b);
        }
    }

    /* compiled from: ThreadViewMessagesFragment.forceUpdateMessageListState */
    /* synthetic */ class C32349 {
        static final /* synthetic */ int[] f22343a = new int[GraphQLSubscribeStatus.values().length];

        static {
            try {
                f22343a[GraphQLSubscribeStatus.CAN_SUBSCRIBE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22343a[GraphQLSubscribeStatus.IS_SUBSCRIBED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22343a[GraphQLSubscribeStatus.CANNOT_SUBSCRIBE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static void m23414a(FetchGroupInformationModel fetchGroupInformationModel, View view, GroupsPlutoniumHeaderActionBarController groupsPlutoniumHeaderActionBarController, boolean z, boolean z2, GraphQLSubscribeStatus graphQLSubscribeStatus) {
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(view.getContext());
        PopoverMenu c = figPopoverMenuWindow.c();
        if (fetchGroupInformationModel.p() == GraphQLGroupJoinState.REQUESTED) {
            c.a(2131238040).setOnMenuItemClickListener(new C32261(groupsPlutoniumHeaderActionBarController, fetchGroupInformationModel));
        } else if (fetchGroupInformationModel.p() == GraphQLGroupJoinState.MEMBER) {
            if (z2) {
                if (z) {
                    c.a(2131238037).setOnMenuItemClickListener(new C32272(groupsPlutoniumHeaderActionBarController, fetchGroupInformationModel));
                } else {
                    c.a(2131238036).setOnMenuItemClickListener(new C32283(groupsPlutoniumHeaderActionBarController, fetchGroupInformationModel));
                }
            }
            switch (C32349.f22343a[graphQLSubscribeStatus.ordinal()]) {
                case 1:
                    c.a(2131238038).setOnMenuItemClickListener(new C32294(groupsPlutoniumHeaderActionBarController, view, true, fetchGroupInformationModel));
                    break;
                case 2:
                    c.a(2131238039).setOnMenuItemClickListener(new C32305(groupsPlutoniumHeaderActionBarController, view, false, fetchGroupInformationModel));
                    break;
            }
            c.a(2131238043).setOnMenuItemClickListener(new C32316(groupsPlutoniumHeaderActionBarController, fetchGroupInformationModel, view));
            c.a(2131238041).setOnMenuItemClickListener(new C32327(fetchGroupInformationModel, view, groupsPlutoniumHeaderActionBarController));
        } else {
            BLog.b(f22344a, "Trying to display popover menu for non-request/joined groups.");
        }
        figPopoverMenuWindow.a(view);
    }
}
