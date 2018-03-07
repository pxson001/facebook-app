package com.facebook.friendlist.listadapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.popover.PopoverMenuWindow.OnMenuItemClickListener;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.friendlist.constants.FriendListSource;
import com.facebook.friendlist.constants.FriendListType;
import com.facebook.friendlist.fragment.FriendListFragment;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.FriendingButtonController;
import com.facebook.friends.controllers.FriendingExceptionHandler;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.PYMKBlacklistedEvent;
import com.facebook.friends.events.FriendingEvents.UserBlockedEvent;
import com.facebook.graphql.calls.ActorSubscribeInputData.SubscribeLocation;
import com.facebook.graphql.calls.ActorUnsubscribeInputData;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.inject.Assisted;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: action_processor */
public class ActionButtonsController extends FriendingButtonController {
    public static final CallerContext f20373c = CallerContext.a(FriendListFragment.class, "profile_friends_page");
    public Context f20374d;
    private FriendListType f20375e;
    private FriendListSource f20376f;
    public FriendingEventBus f20377g;
    public DefaultAndroidThreadUtil f20378h;
    public FbUriIntentHandler f20379i;

    /* compiled from: action_processor */
    public class C29114 implements OnClickListener {
        final /* synthetic */ ActionButtonsController f20357a;

        public C29114(ActionButtonsController actionButtonsController) {
            this.f20357a = actionButtonsController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* compiled from: action_processor */
    public class C29136 extends AbstractDisposableFutureCallback<Void> {
        final /* synthetic */ ActionButtonsController f20363a;

        public C29136(ActionButtonsController actionButtonsController) {
            this.f20363a = actionButtonsController;
        }

        protected final void m20628a(Throwable th) {
            this.f20363a.a(th);
        }
    }

    /* compiled from: action_processor */
    public class C29158 implements Runnable {
        final /* synthetic */ long f20369a;
        final /* synthetic */ ActionButtonsController f20370b;

        public C29158(ActionButtonsController actionButtonsController, long j) {
            this.f20370b = actionButtonsController;
            this.f20369a = j;
        }

        public void run() {
            this.f20370b.c.a(new UserBlockedEvent(this.f20369a));
        }
    }

    /* compiled from: action_processor */
    /* synthetic */ class C29169 {
        static final /* synthetic */ int[] f20371a = new int[GraphQLSubscribeStatus.values().length];
        static final /* synthetic */ int[] f20372b = new int[GraphQLFriendshipStatus.values().length];

        static {
            try {
                f20372b[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20372b[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f20372b[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f20372b[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f20371a[GraphQLSubscribeStatus.IS_SUBSCRIBED.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f20371a[GraphQLSubscribeStatus.CAN_SUBSCRIBE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Inject
    public ActionButtonsController(@Assisted Context context, @Assisted FriendListType friendListType, @Assisted FriendListSource friendListSource, FriendingClient friendingClient, FriendingEventBus friendingEventBus, DefaultAndroidThreadUtil defaultAndroidThreadUtil, FriendingExceptionHandler friendingExceptionHandler, FbUriIntentHandler fbUriIntentHandler) {
        super(context, friendingClient, friendingEventBus, defaultAndroidThreadUtil, friendingExceptionHandler);
        this.f20374d = context;
        this.f20375e = friendListType;
        this.f20376f = friendListSource;
        this.f20377g = friendingEventBus;
        this.f20378h = defaultAndroidThreadUtil;
        this.f20379i = fbUriIntentHandler;
    }

    public final void m20642a(long j, long j2, String str, FriendingLocation friendingLocation, GraphQLFriendshipStatus graphQLFriendshipStatus, View view) {
        if (GraphQLFriendshipStatus.ARE_FRIENDS.equals(graphQLFriendshipStatus)) {
            m20629a(j, j2, str, friendingLocation, graphQLFriendshipStatus).f(view);
        } else {
            b(j2, friendingLocation, graphQLFriendshipStatus);
        }
    }

    public final void m20643a(long j, long j2, String str, GraphQLFriendshipStatus graphQLFriendshipStatus, GraphQLSubscribeStatus graphQLSubscribeStatus, View view) {
        m20630a(j, j2, str, graphQLFriendshipStatus, graphQLSubscribeStatus).f(view);
    }

    private PopoverMenuWindow m20629a(long j, long j2, String str, FriendingLocation friendingLocation, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(this.f20374d);
        figPopoverMenuWindow.a(true);
        PopoverMenu popoverMenu = new PopoverMenu(this.f20374d);
        figPopoverMenuWindow.a(popoverMenu);
        popoverMenu.a(2131558836, 0, this.f20374d.getString(2131241983)).setIcon(2130839890);
        popoverMenu.a(2131558829, 0, this.f20374d.getString(2131241974)).a(m20631a(2131241975, str)).setIcon(2130839878);
        final long j3 = j2;
        final String str2 = str;
        final FriendingLocation friendingLocation2 = friendingLocation;
        final GraphQLFriendshipStatus graphQLFriendshipStatus2 = graphQLFriendshipStatus;
        final long j4 = j;
        figPopoverMenuWindow.a(new OnMenuItemClickListener(this) {
            final /* synthetic */ ActionButtonsController f20347f;

            public final boolean m20623a(MenuItem menuItem) {
                if (menuItem.getItemId() == 2131558836) {
                    this.f20347f.m20640b(j3, str2, friendingLocation2, graphQLFriendshipStatus2);
                    return true;
                } else if (menuItem.getItemId() != 2131558829) {
                    return false;
                } else {
                    this.f20347f.m20632a(j4, j3, str2);
                    return true;
                }
            }
        });
        return figPopoverMenuWindow;
    }

    private PopoverMenuWindow m20630a(long j, long j2, String str, GraphQLFriendshipStatus graphQLFriendshipStatus, GraphQLSubscribeStatus graphQLSubscribeStatus) {
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(this.f20374d);
        figPopoverMenuWindow.a(true);
        PopoverMenu popoverMenu = new PopoverMenu(this.f20374d);
        figPopoverMenuWindow.a(popoverMenu);
        switch (C29169.f20372b[graphQLFriendshipStatus.ordinal()]) {
            case 1:
                popoverMenu.a(2131558833, 0, this.f20374d.getString(2131241980)).setIcon(2130839886);
                popoverMenu.a(2131558831, 0, this.f20374d.getString(2131241978)).setIcon(2130839685);
                switch (C29169.f20371a[graphQLSubscribeStatus.ordinal()]) {
                    case 1:
                        popoverMenu.a(2131558835, 0, this.f20374d.getString(2131241981)).a(m20631a(2131241982, str)).setIcon(2130840145);
                        break;
                    case 2:
                        popoverMenu.a(2131558830, 0, this.f20374d.getString(2131241976)).a(m20631a(2131241977, str)).setIcon(2130839874);
                        break;
                    default:
                        break;
                }
            case 2:
            case 3:
            case 4:
                popoverMenu.a(2131558833, 0, this.f20374d.getString(2131241980)).setIcon(2130839886);
                if (FriendListType.SUGGESTIONS.equals(this.f20375e)) {
                    popoverMenu.a(2131558832, 0, this.f20374d.getString(2131241979)).setIcon(2130839890);
                }
                popoverMenu.a(2131558829, 0, this.f20374d.getString(2131241974)).a(m20631a(2131241975, str)).setIcon(2130839878);
                break;
        }
        final long j3 = j;
        final long j4 = j2;
        final String str2 = str;
        final GraphQLFriendshipStatus graphQLFriendshipStatus2 = graphQLFriendshipStatus;
        final GraphQLSubscribeStatus graphQLSubscribeStatus2 = graphQLSubscribeStatus;
        figPopoverMenuWindow.a(new OnMenuItemClickListener(this) {
            final /* synthetic */ ActionButtonsController f20353f;

            public final boolean m20624a(MenuItem menuItem) {
                if (menuItem.getItemId() == 2131558829) {
                    this.f20353f.m20632a(j3, j4, str2);
                    return true;
                } else if (menuItem.getItemId() == 2131558830) {
                    ActionButtonsController.m20638a(this.f20353f, j4, true);
                    return true;
                } else if (menuItem.getItemId() == 2131558831) {
                    r1 = this.f20353f;
                    r1.f20379i.a(r1.f20374d, StringFormatUtil.formatStrLocaleSafe(FBLinks.R, Long.valueOf(j4)));
                    return true;
                } else if (menuItem.getItemId() == 2131558832) {
                    r1 = this.f20353f;
                    long j = j4;
                    r1.a.a(j, ActionButtonsController.f20373c);
                    r1.f20377g.a(new PYMKBlacklistedEvent(j));
                    return true;
                } else if (menuItem.getItemId() == 2131558833) {
                    this.f20353f.m20633a(j4, str2, graphQLFriendshipStatus2, graphQLSubscribeStatus2);
                    return true;
                } else if (menuItem.getItemId() != 2131558835) {
                    return false;
                } else {
                    ActionButtonsController.m20638a(this.f20353f, j4, false);
                    return true;
                }
            }
        });
        return figPopoverMenuWindow;
    }

    private void m20640b(long j, String str, FriendingLocation friendingLocation, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        Builder a = a(j, friendingLocation, graphQLFriendshipStatus);
        a.a(m20631a(2131241986, str));
        a.b(m20631a(2131241987, str));
        a.b();
    }

    private void m20632a(long j, long j2, String str) {
        final long j3 = j;
        final long j4 = j2;
        OnClickListener c29103 = new OnClickListener(this) {
            final /* synthetic */ ActionButtonsController f20356c;

            public void onClick(DialogInterface dialogInterface, int i) {
                ActionButtonsController actionButtonsController = this.f20356c;
                long j = j3;
                long j2 = j4;
                ListenableFuture a = actionButtonsController.a.a(j, j2);
                actionButtonsController.f20378h.a(new C29158(actionButtonsController, j2));
                actionButtonsController.f20378h.a(a, new C29136(actionButtonsController));
            }
        };
        Builder a = new Builder(this.f20374d).a(2131234877, c29103).b(2131230727, new C29114(this)).a(true);
        a.a(m20631a(2131241984, str));
        a.b(m20631a(2131241985, str));
        a.b();
    }

    private void m20633a(long j, String str, GraphQLFriendshipStatus graphQLFriendshipStatus, GraphQLSubscribeStatus graphQLSubscribeStatus) {
        Bundle bundle = new Bundle();
        bundle.putString("profile_name", str);
        bundle.putString("friendship_status", graphQLFriendshipStatus.toString());
        bundle.putString("subscribe_status", graphQLSubscribeStatus.toString());
        this.f20379i.a(this.f20374d, StringFormatUtil.formatStrLocaleSafe(FBLinks.bf, Long.valueOf(j), FriendListType.SUGGESTIONS.name(), this.f20376f.name()), bundle);
    }

    public static void m20638a(ActionButtonsController actionButtonsController, long j, boolean z) {
        ListenableFuture a;
        GraphQLSubscribeStatus graphQLSubscribeStatus = z ? GraphQLSubscribeStatus.CAN_SUBSCRIBE : GraphQLSubscribeStatus.IS_SUBSCRIBED;
        final GraphQLSubscribeStatus graphQLSubscribeStatus2 = z ? GraphQLSubscribeStatus.IS_SUBSCRIBED : GraphQLSubscribeStatus.CAN_SUBSCRIBE;
        final GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus = GraphQLSecondarySubscribeStatus.REGULAR_FOLLOW;
        if (z) {
            a = actionButtonsController.a.a(String.valueOf(j), SubscribeLocation.PROFILE_FRIENDS_PAGE);
        } else {
            a = actionButtonsController.a.a(String.valueOf(j), ActorUnsubscribeInputData.SubscribeLocation.PROFILE_FRIENDS_PAGE);
        }
        actionButtonsController.m20639b(j, graphQLSubscribeStatus2, graphQLSecondarySubscribeStatus, true);
        final long j2 = j;
        final GraphQLSubscribeStatus graphQLSubscribeStatus3 = graphQLSubscribeStatus;
        actionButtonsController.f20378h.a(a, new AbstractDisposableFutureCallback<Void>(actionButtonsController) {
            final /* synthetic */ ActionButtonsController f20362e;

            protected final void m20625a(Object obj) {
                this.f20362e.m20639b(j2, graphQLSubscribeStatus2, graphQLSecondarySubscribeStatus, false);
            }

            protected final void m20626a(Throwable th) {
                this.f20362e.m20639b(j2, graphQLSubscribeStatus3, graphQLSecondarySubscribeStatus, false);
                this.f20362e.a(th);
            }
        });
    }

    private void m20639b(long j, GraphQLSubscribeStatus graphQLSubscribeStatus, GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus, boolean z) {
        final long j2 = j;
        final GraphQLSubscribeStatus graphQLSubscribeStatus2 = graphQLSubscribeStatus;
        final GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus2 = graphQLSecondarySubscribeStatus;
        final boolean z2 = z;
        this.f20378h.a(new Runnable(this) {
            final /* synthetic */ ActionButtonsController f20368e;

            public void run() {
                this.f20368e.a(j2, graphQLSubscribeStatus2, graphQLSecondarySubscribeStatus2, z2);
            }
        });
    }

    private String m20631a(int i, String str) {
        return StringLocaleUtil.a(this.f20374d.getResources().getString(i), new Object[]{str});
    }
}
