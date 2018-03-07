package com.facebook.friending.center.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.friending.center.connectioncontroller.FriendsCenterConnectionControllerManager;
import com.facebook.friending.center.model.FriendRequestModel;
import com.facebook.friending.center.tabs.requests.FriendsCenterRequestsAdapter.C28191;
import com.facebook.friending.center.tabs.requests.items.FriendRequestItem;
import com.facebook.friending.common.list.FriendListItemView;
import com.facebook.friending.common.list.FriendListItemView.ActionButtonTheme;
import com.facebook.friending.common.list.FriendRequestItemView;
import com.facebook.friending.common.list.model.FriendListItemModel;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.controllers.FriendingButtonControllerWithCallback;
import com.facebook.friends.controllers.interfaces.FriendingButtonControllerCallback;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.PYMKBlacklistedEvent;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: adpreview_graphql_success */
public class FriendsCenterCommonBinder {
    private static final CallerContext f20157a = CallerContext.a(FriendsCenterCommonBinder.class);
    private static final Map<GraphQLFriendshipStatus, GraphQLFriendshipStatus> f20158b = ImmutableMap.of(GraphQLFriendshipStatus.ARE_FRIENDS, GraphQLFriendshipStatus.CAN_REQUEST, GraphQLFriendshipStatus.CAN_REQUEST, GraphQLFriendshipStatus.OUTGOING_REQUEST, GraphQLFriendshipStatus.INCOMING_REQUEST, GraphQLFriendshipStatus.ARE_FRIENDS, GraphQLFriendshipStatus.OUTGOING_REQUEST, GraphQLFriendshipStatus.CAN_REQUEST);
    public final Context f20159c;
    public final Resources f20160d;
    private final AllCapsTransformationMethod f20161e;
    public final FbUriIntentHandler f20162f;
    private final FriendingButtonControllerWithCallback f20163g;
    private final FriendingClient f20164h;
    private final FriendingEventBus f20165i;
    private final GraphQLCacheManager f20166j;
    private final FriendsCenterConnectionControllerManager f20167k;
    private final Map<Long, WeakReference<ContentView>> f20168l;
    @Nullable
    public OnPYMKResponseListener f20169m = new C28191(this);
    public boolean f20170n = false;

    /* compiled from: adpreview_graphql_success */
    public interface OnPYMKResponseListener {
        void mo895a(long j);
    }

    /* compiled from: adpreview_graphql_success */
    public class C28656 implements OnMenuItemClickListener {
        final /* synthetic */ FriendListItemView f20146a;
        final /* synthetic */ FriendListItemModel f20147b;
        final /* synthetic */ boolean f20148c;
        final /* synthetic */ FriendsCenterCommonBinder f20149d;

        public C28656(FriendsCenterCommonBinder friendsCenterCommonBinder, FriendListItemView friendListItemView, FriendListItemModel friendListItemModel, boolean z) {
            this.f20149d = friendsCenterCommonBinder;
            this.f20146a = friendListItemView;
            this.f20147b = friendListItemModel;
            this.f20148c = z;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            FriendsCenterCommonBinder friendsCenterCommonBinder = this.f20149d;
            FriendListItemView friendListItemView = this.f20146a;
            FriendListItemModel friendListItemModel = this.f20147b;
            boolean z = this.f20148c;
            new Builder(friendsCenterCommonBinder.f20159c).b(StringFormatUtil.a(friendsCenterCommonBinder.f20160d.getString(2131233233), new Object[]{friendListItemModel.b()})).a(2131230729, new C28678(friendsCenterCommonBinder, friendListItemView, friendListItemModel, z)).b(2131230727, null).b();
            return true;
        }
    }

    /* compiled from: adpreview_graphql_success */
    public class C28667 implements OnMenuItemClickListener {
        final /* synthetic */ FriendListItemModel f20150a;
        final /* synthetic */ FriendsCenterCommonBinder f20151b;

        public C28667(FriendsCenterCommonBinder friendsCenterCommonBinder, FriendListItemModel friendListItemModel) {
            this.f20151b = friendsCenterCommonBinder;
            this.f20150a = friendListItemModel;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            String a = StringFormatUtil.a(FBLinks.bh, new Object[]{String.valueOf(this.f20150a.a())});
            Bundle bundle = new Bundle();
            bundle.putBoolean("titlebar_with_modal_done", true);
            this.f20151b.f20162f.a(this.f20151b.f20159c, a, bundle);
            return true;
        }
    }

    /* compiled from: adpreview_graphql_success */
    public class C28678 implements OnClickListener {
        final /* synthetic */ FriendListItemView f20152a;
        final /* synthetic */ FriendListItemModel f20153b;
        final /* synthetic */ boolean f20154c;
        final /* synthetic */ FriendsCenterCommonBinder f20155d;

        public C28678(FriendsCenterCommonBinder friendsCenterCommonBinder, FriendListItemView friendListItemView, FriendListItemModel friendListItemModel, boolean z) {
            this.f20155d = friendsCenterCommonBinder;
            this.f20152a = friendListItemView;
            this.f20153b = friendListItemModel;
            this.f20154c = z;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            FriendsCenterCommonBinder.m20476c(this.f20155d, this.f20152a, this.f20153b, this.f20154c);
        }
    }

    /* compiled from: adpreview_graphql_success */
    /* synthetic */ class C28689 {
        static final /* synthetic */ int[] f20156a = new int[GraphQLFriendshipStatus.values().length];

        static {
            try {
                f20156a[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20156a[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f20156a[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f20156a[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static FriendsCenterCommonBinder m20469b(InjectorLike injectorLike) {
        return new FriendsCenterCommonBinder((Context) injectorLike.getInstance(Context.class), AllCapsTransformationMethod.b(injectorLike), FbUriIntentHandler.a(injectorLike), FriendingButtonControllerWithCallback.b(injectorLike), FriendingClient.b(injectorLike), FriendingEventBus.a(injectorLike), GraphQLCacheManager.a(injectorLike), FriendsCenterConnectionControllerManager.m20129a(injectorLike));
    }

    @Inject
    public FriendsCenterCommonBinder(Context context, AllCapsTransformationMethod allCapsTransformationMethod, FbUriIntentHandler fbUriIntentHandler, FriendingButtonControllerWithCallback friendingButtonControllerWithCallback, FriendingClient friendingClient, FriendingEventBus friendingEventBus, GraphQLCacheManager graphQLCacheManager, FriendsCenterConnectionControllerManager friendsCenterConnectionControllerManager) {
        this.f20159c = context;
        this.f20160d = context.getResources();
        this.f20161e = allCapsTransformationMethod;
        this.f20162f = fbUriIntentHandler;
        this.f20163g = friendingButtonControllerWithCallback;
        this.f20164h = friendingClient;
        this.f20165i = friendingEventBus;
        this.f20166j = graphQLCacheManager;
        this.f20167k = friendsCenterConnectionControllerManager;
        this.f20168l = new HashMap();
    }

    public final void m20480a(FriendRequestItemView friendRequestItemView, FriendRequestItem friendRequestItem, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        int i;
        int i2;
        int i3;
        friendRequestItemView.setTitleText(friendRequestItem.m20174b());
        friendRequestItemView.setThumbnailUri(friendRequestItem.m20177d());
        friendRequestItemView.setSubtitleText("");
        if (friendRequestItem.f20010c) {
            i = 2131233212;
            i2 = 2131233213;
            i3 = 2131233216;
            if (StringUtil.a(friendRequestItem.f20009b)) {
                friendRequestItemView.setSubtitleText(friendRequestItem.mo894h());
            } else {
                friendRequestItemView.setSubtitleText(StringFormatUtil.a(this.f20160d.getString(2131233358), new Object[]{r4}));
            }
        } else {
            friendRequestItemView.setSubtitleText(friendRequestItem.mo894h());
            i = 2131233218;
            i3 = 2131233217;
            i2 = 0;
        }
        friendRequestItemView.a(m20470b(i), m20470b(i2));
        friendRequestItemView.setPositiveButtonOnClickListener(onClickListener);
        friendRequestItemView.setNegativeButtonText(m20470b(i3));
        friendRequestItemView.setNegativeButtonOnClickListener(onClickListener2);
        m20465a((ContentView) friendRequestItemView);
        m20475c(friendRequestItemView, friendRequestItem);
    }

    public final void m20481a(FriendRequestItemView friendRequestItemView, final FriendListItemModel friendListItemModel) {
        friendRequestItemView.setThumbnailUri(friendListItemModel.d());
        friendRequestItemView.setTitleText(friendListItemModel.b());
        m20466a(this, (ContentView) friendRequestItemView, friendListItemModel);
        friendRequestItemView.a(m20470b(2131233212), m20470b(2131233213));
        friendRequestItemView.setNegativeButtonText(m20470b(2131233211));
        GraphQLFriendshipStatus f = friendListItemModel.f();
        if (GraphQLFriendshipStatus.CAN_REQUEST.equals(f) || GraphQLFriendshipStatus.INCOMING_REQUEST.equals(f)) {
            friendRequestItemView.setFriendRequestButtonsVisible(true);
            friendRequestItemView.setPositiveButtonOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ FriendsCenterCommonBinder f20129b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -597736887);
                    FriendsCenterCommonBinder.m20467a(this.f20129b, friendListItemModel);
                    Logger.a(2, EntryType.UI_INPUT_END, 197359233, a);
                }
            });
            friendRequestItemView.setNegativeButtonOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ FriendsCenterCommonBinder f20131b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 479733830);
                    FriendsCenterCommonBinder.m20473b(this.f20131b, friendListItemModel);
                    Logger.a(2, EntryType.UI_INPUT_END, -1800653203, a);
                }
            });
            m20475c(friendRequestItemView, friendListItemModel);
            return;
        }
        friendRequestItemView.setFriendRequestButtonsVisible(false);
        friendRequestItemView.setPositiveButtonOnClickListener(null);
        friendRequestItemView.setNegativeButtonOnClickListener(null);
    }

    public final void m20478a(FriendListItemView friendListItemView, FriendListItemModel friendListItemModel) {
        m20479a(friendListItemView, friendListItemModel, false);
    }

    public final void m20479a(FriendListItemView friendListItemView, FriendListItemModel friendListItemModel, boolean z) {
        friendListItemView.setTitleText(friendListItemModel.b());
        friendListItemView.setThumbnailUri(friendListItemModel.d());
        m20466a(this, (ContentView) friendListItemView, friendListItemModel);
        m20472b(this, friendListItemView, friendListItemModel, z);
        m20475c(friendListItemView, friendListItemModel);
    }

    public static void m20466a(FriendsCenterCommonBinder friendsCenterCommonBinder, ContentView contentView, FriendListItemModel friendListItemModel) {
        friendsCenterCommonBinder.m20471b(contentView, friendListItemModel);
        m20465a(contentView);
    }

    private void m20471b(ContentView contentView, FriendListItemModel friendListItemModel) {
        GraphQLFriendshipStatus f = friendListItemModel.f();
        GraphQLFriendshipStatus c = friendListItemModel.c();
        switch (C28689.f20156a[f.ordinal()]) {
            case 1:
                Object obj;
                if ((friendListItemModel instanceof FriendRequestModel) && ((FriendRequestModel) friendListItemModel).f20010c) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (GraphQLFriendshipStatus.CAN_REQUEST.equals(c) && r0 != null) {
                    contentView.setSubtitleText(2131233357);
                    return;
                } else if (GraphQLFriendshipStatus.OUTGOING_REQUEST.equals(c)) {
                    contentView.setSubtitleText(2131233220);
                    return;
                } else if (GraphQLFriendshipStatus.INCOMING_REQUEST.equals(c)) {
                    contentView.setSubtitleText(2131233223);
                    return;
                } else if (GraphQLFriendshipStatus.ARE_FRIENDS.equals(c)) {
                    contentView.setSubtitleText(2131233234);
                    return;
                } else if (friendListItemModel instanceof FriendRequestModel) {
                    contentView.setSubtitleText(friendListItemModel.h());
                    return;
                } else {
                    contentView.setSubtitleText(m20464a(friendListItemModel.e()));
                    return;
                }
            case 2:
                if (friendListItemModel instanceof FriendRequestModel) {
                    contentView.setSubtitleText(friendListItemModel.h());
                    return;
                } else {
                    contentView.setSubtitleText(m20464a(friendListItemModel.e()));
                    return;
                }
            case 3:
                contentView.setSubtitleText(2131233219);
                return;
            case 4:
                if (GraphQLFriendshipStatus.INCOMING_REQUEST.equals(c)) {
                    contentView.setSubtitleText(2131233222);
                    return;
                } else if (friendListItemModel instanceof FriendRequestModel) {
                    contentView.setSubtitleText(friendListItemModel.h());
                    return;
                } else {
                    contentView.setSubtitleText(m20464a(friendListItemModel.e()));
                    return;
                }
            default:
                contentView.setSubtitleText(m20464a(friendListItemModel.e()));
                return;
        }
    }

    public static void m20472b(FriendsCenterCommonBinder friendsCenterCommonBinder, final FriendListItemView friendListItemView, final FriendListItemModel friendListItemModel, final boolean z) {
        switch (C28689.f20156a[friendListItemModel.f().ordinal()]) {
            case 1:
                friendListItemView.a(ActionButtonTheme.PRIMARY, friendsCenterCommonBinder.f20160d.getDrawable(2130840448));
                friendListItemView.a(friendsCenterCommonBinder.m20470b(2131233212), friendsCenterCommonBinder.m20470b(2131233213));
                friendListItemView.setActionButtonContentDescription(friendsCenterCommonBinder.f20160d.getString(2131233228));
                break;
            case 2:
                friendListItemView.a(ActionButtonTheme.PRIMARY, friendsCenterCommonBinder.f20160d.getDrawable(2130840448));
                friendListItemView.a(friendsCenterCommonBinder.m20470b(2131233212), friendsCenterCommonBinder.m20470b(2131233213));
                friendListItemView.setActionButtonContentDescription(friendsCenterCommonBinder.f20160d.getString(2131233231));
                break;
            case 3:
                friendListItemView.a(ActionButtonTheme.SECONDARY, friendsCenterCommonBinder.f20160d.getDrawable(2130840450));
                friendListItemView.a(friendsCenterCommonBinder.m20470b(2131230727), null);
                friendListItemView.setActionButtonContentDescription(friendsCenterCommonBinder.f20160d.getString(2131233230));
                break;
            case 4:
                friendListItemView.a(ActionButtonTheme.SECONDARY, friendsCenterCommonBinder.f20160d.getDrawable(2130840454));
                friendListItemView.a(friendsCenterCommonBinder.m20470b(2131233209), null);
                friendListItemView.setActionButtonContentDescription(friendsCenterCommonBinder.f20160d.getString(2131233229));
                break;
            default:
                friendListItemView.setActionButtonOnClickListener(null);
                friendListItemView.setShowActionButton(false);
                return;
        }
        friendListItemView.setShowActionButton(true);
        friendListItemView.setActionButtonOnClickListener(new View.OnClickListener(friendsCenterCommonBinder) {
            final /* synthetic */ FriendsCenterCommonBinder f20135d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 177692989);
                if (GraphQLFriendshipStatus.ARE_FRIENDS.equals(friendListItemModel.f())) {
                    FriendsCenterCommonBinder friendsCenterCommonBinder = this.f20135d;
                    FriendListItemView friendListItemView = friendListItemView;
                    FriendListItemModel friendListItemModel = friendListItemModel;
                    boolean z = z;
                    FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(friendsCenterCommonBinder.f20159c);
                    PopoverMenu c = figPopoverMenuWindow.c();
                    c.a(2131233232).setOnMenuItemClickListener(new C28656(friendsCenterCommonBinder, friendListItemView, friendListItemModel, z));
                    c.a(2131233235).setOnMenuItemClickListener(new C28667(friendsCenterCommonBinder, friendListItemModel));
                    figPopoverMenuWindow.a(view);
                    Logger.a(2, EntryType.UI_INPUT_END, 387324521, a);
                    return;
                }
                FriendsCenterCommonBinder.m20476c(this.f20135d, friendListItemView, friendListItemModel, z);
                LogUtils.a(886773151, a);
            }
        });
    }

    public static void m20467a(FriendsCenterCommonBinder friendsCenterCommonBinder, final FriendListItemModel friendListItemModel) {
        final GraphQLFriendshipStatus c = friendListItemModel.c();
        final GraphQLFriendshipStatus f = friendListItemModel.f();
        friendsCenterCommonBinder.m20468a(f);
        friendListItemModel.b((GraphQLFriendshipStatus) f20158b.get(f));
        if (friendsCenterCommonBinder.f20169m != null) {
            friendsCenterCommonBinder.f20169m.mo895a(friendListItemModel.a());
        }
        friendsCenterCommonBinder.f20163g.a(friendListItemModel.a(), friendListItemModel.g(), f, new FriendingButtonControllerCallback(friendsCenterCommonBinder) {
            final /* synthetic */ FriendsCenterCommonBinder f20139d;

            public final void m20461a() {
                friendListItemModel.b(f);
                friendListItemModel.a(c);
                if (FriendsCenterCommonBinder.m20474b(this.f20139d, friendListItemModel.a()) && this.f20139d.f20169m != null) {
                    this.f20139d.f20169m.mo895a(friendListItemModel.a());
                }
            }
        });
    }

    public static void m20473b(FriendsCenterCommonBinder friendsCenterCommonBinder, FriendListItemModel friendListItemModel) {
        friendsCenterCommonBinder.m20468a(friendListItemModel.f());
        friendsCenterCommonBinder.f20168l.remove(Long.valueOf(friendListItemModel.a()));
        friendsCenterCommonBinder.f20164h.a(friendListItemModel.a(), f20157a);
        friendsCenterCommonBinder.f20165i.a(new PYMKBlacklistedEvent(friendListItemModel.a()));
    }

    public static void m20476c(FriendsCenterCommonBinder friendsCenterCommonBinder, FriendListItemView friendListItemView, FriendListItemModel friendListItemModel, boolean z) {
        final GraphQLFriendshipStatus c = friendListItemModel.c();
        final GraphQLFriendshipStatus f = friendListItemModel.f();
        GraphQLFriendshipStatus graphQLFriendshipStatus = (GraphQLFriendshipStatus) f20158b.get(f);
        friendsCenterCommonBinder.m20468a(f);
        friendListItemModel.b(graphQLFriendshipStatus);
        final boolean z2 = GraphQLFriendshipStatus.CAN_REQUEST.equals(graphQLFriendshipStatus) || GraphQLFriendshipStatus.INCOMING_REQUEST.equals(graphQLFriendshipStatus);
        if (!z2 || !z) {
            m20466a(friendsCenterCommonBinder, (ContentView) friendListItemView, friendListItemModel);
            m20472b(friendsCenterCommonBinder, friendListItemView, friendListItemModel, z);
        } else if (friendsCenterCommonBinder.f20169m != null) {
            friendsCenterCommonBinder.f20169m.mo895a(friendListItemModel.a());
        }
        final FriendListItemModel friendListItemModel2 = friendListItemModel;
        final boolean z3 = z;
        friendsCenterCommonBinder.f20163g.a(friendListItemModel.a(), friendListItemModel.g(), f, new FriendingButtonControllerCallback(friendsCenterCommonBinder) {
            final /* synthetic */ FriendsCenterCommonBinder f20145f;

            public final void m20462a() {
                friendListItemModel2.b(f);
                friendListItemModel2.a(c);
                if (!FriendsCenterCommonBinder.m20474b(this.f20145f, friendListItemModel2.a())) {
                    return;
                }
                if (!z2 || !z3) {
                    ContentView a = FriendsCenterCommonBinder.m20463a(this.f20145f, friendListItemModel2.a());
                    if (a instanceof FriendListItemView) {
                        FriendsCenterCommonBinder.m20466a(this.f20145f, a, friendListItemModel2);
                        FriendsCenterCommonBinder.m20472b(this.f20145f, (FriendListItemView) a, friendListItemModel2, z3);
                    }
                } else if (this.f20145f.f20169m != null) {
                    this.f20145f.f20169m.mo895a(friendListItemModel2.a());
                }
            }
        });
    }

    public final void m20477a() {
        this.f20168l.clear();
        this.f20163g.d = true;
    }

    public static ContentView m20463a(FriendsCenterCommonBinder friendsCenterCommonBinder, long j) {
        WeakReference weakReference = (WeakReference) friendsCenterCommonBinder.f20168l.get(Long.valueOf(j));
        return weakReference != null ? (ContentView) weakReference.get() : null;
    }

    private void m20475c(ContentView contentView, FriendListItemModel friendListItemModel) {
        FriendListItemModel friendListItemModel2 = (FriendListItemModel) contentView.getTag(2131558774);
        if (!(friendListItemModel2 == null || friendListItemModel2.a() == friendListItemModel.a())) {
            this.f20168l.remove(Long.valueOf(friendListItemModel2.a()));
        }
        contentView.setTag(2131558774, friendListItemModel);
        this.f20168l.put(Long.valueOf(friendListItemModel.a()), new WeakReference(contentView));
    }

    public static boolean m20474b(FriendsCenterCommonBinder friendsCenterCommonBinder, long j) {
        ContentView a = m20463a(friendsCenterCommonBinder, j);
        if (a == null) {
            return false;
        }
        FriendListItemModel friendListItemModel = (FriendListItemModel) a.getTag(2131558774);
        if (friendListItemModel == null || friendListItemModel.a() != j) {
            return false;
        }
        return true;
    }

    private void m20468a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        switch (C28689.f20156a[graphQLFriendshipStatus.ordinal()]) {
            case 1:
                builder.c("FC_SUGGESTIONS_QUERY");
                break;
            case 2:
                builder.c("FC_REQUESTS_QUERY");
                builder.c("FC_FRIENDS_QUERY");
                builder.c("FC_SUGGESTIONS_QUERY");
                break;
            case 3:
                builder.c("FC_SUGGESTIONS_QUERY");
                break;
            case 4:
                builder.c("FC_FRIENDS_QUERY");
                builder.c("FC_SUGGESTIONS_QUERY");
                break;
        }
        ImmutableSet b = builder.b();
        this.f20166j.a(b);
        if (b.contains("FC_FRIENDS_QUERY")) {
            this.f20167k.m20133f();
        }
        if (b.contains("FC_SUGGESTIONS_QUERY")) {
            this.f20167k.m20132c();
        }
    }

    private String m20464a(int i) {
        if (i <= 0) {
            return "";
        }
        return this.f20160d.getQuantityString(2131689520, i, new Object[]{Integer.valueOf(i)});
    }

    @Nullable
    private CharSequence m20470b(@StringRes int i) {
        return i == 0 ? null : this.f20161e.getTransformation(this.f20160d.getString(i), null);
    }

    private static void m20465a(ContentView contentView) {
        contentView.setContentDescription(StringFormatUtil.formatStrLocaleSafe("%s %s", contentView.getTitleText(), contentView.getSubtitleText()));
    }
}
