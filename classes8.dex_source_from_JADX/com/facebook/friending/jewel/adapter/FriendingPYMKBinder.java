package com.facebook.friending.jewel.adapter;

import android.content.res.Resources;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.friending.common.list.FriendListItemView;
import com.facebook.friending.common.list.FriendListItemView.ActionButtonTheme;
import com.facebook.friending.common.list.FriendRequestItemView;
import com.facebook.friending.jewel.logging.FriendingJewelLogger;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.FriendingButtonControllerWithCallback;
import com.facebook.friends.controllers.interfaces.FriendingButtonControllerCallback;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.PYMKBlacklistedEvent;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableSet;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: filtered_query_arguments */
public class FriendingPYMKBinder {
    private static final CallerContext f13277a = CallerContext.a(FriendingPYMKBinder.class);
    private final Resources f13278b;
    private final AllCapsTransformationMethod f13279c;
    private final FriendingButtonControllerWithCallback f13280d;
    private final FriendingClient f13281e;
    private final FriendingEventBus f13282f;
    public final FriendingJewelLogger f13283g;
    private final GraphQLCacheManager f13284h;
    public final Map<Long, WeakReference<ContentView>> f13285i = new HashMap();
    public FriendingLocation f13286j;
    public OnResponseListener f13287k;

    /* compiled from: filtered_query_arguments */
    public interface OnResponseListener {
        void mo823a(long j);

        void mo824b(long j);

        void mo825c(long j);
    }

    /* compiled from: filtered_query_arguments */
    /* synthetic */ class C14016 {
        static final /* synthetic */ int[] f13276a = new int[GraphQLFriendshipStatus.values().length];

        static {
            try {
                f13276a[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13276a[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13276a[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f13276a[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static FriendingPYMKBinder m14932b(InjectorLike injectorLike) {
        return new FriendingPYMKBinder(ResourcesMethodAutoProvider.a(injectorLike), AllCapsTransformationMethod.b(injectorLike), FriendingButtonControllerWithCallback.b(injectorLike), FriendingClient.b(injectorLike), FriendingEventBus.a(injectorLike), FriendingJewelLogger.m14972a(injectorLike), GraphQLCacheManager.a(injectorLike));
    }

    @Inject
    public FriendingPYMKBinder(Resources resources, AllCapsTransformationMethod allCapsTransformationMethod, FriendingButtonControllerWithCallback friendingButtonControllerWithCallback, FriendingClient friendingClient, FriendingEventBus friendingEventBus, FriendingJewelLogger friendingJewelLogger, GraphQLCacheManager graphQLCacheManager) {
        this.f13278b = resources;
        this.f13279c = allCapsTransformationMethod;
        this.f13280d = friendingButtonControllerWithCallback;
        this.f13281e = friendingClient;
        this.f13282f = friendingEventBus;
        this.f13283g = friendingJewelLogger;
        this.f13284h = graphQLCacheManager;
    }

    public final void m14941a(ContentView contentView, PersonYouMayKnow personYouMayKnow) {
        contentView.setThumbnailUri(personYouMayKnow.d());
        contentView.setTitleText(personYouMayKnow.b());
        m14934b(this, contentView, personYouMayKnow);
        if (contentView instanceof FriendRequestItemView) {
            m14929a((FriendRequestItemView) contentView, personYouMayKnow);
        } else if (contentView instanceof FriendListItemView) {
            m14930a(this, (FriendListItemView) contentView, personYouMayKnow);
        } else {
            throw new IllegalArgumentException("ContentView not an instance of FriendRequestItemView or FriendListItemView");
        }
        PersonYouMayKnow personYouMayKnow2 = (PersonYouMayKnow) contentView.getTag(2131558784);
        if (!(personYouMayKnow2 == null || personYouMayKnow2.a() == personYouMayKnow.a())) {
            this.f13285i.remove(Long.valueOf(personYouMayKnow2.a()));
        }
        contentView.setTag(2131558784, personYouMayKnow);
        this.f13285i.put(Long.valueOf(personYouMayKnow.a()), new WeakReference(contentView));
    }

    public static void m14934b(FriendingPYMKBinder friendingPYMKBinder, ContentView contentView, PersonYouMayKnow personYouMayKnow) {
        friendingPYMKBinder.m14938c(contentView, personYouMayKnow);
        contentView.setContentDescription(StringFormatUtil.formatStrLocaleSafe("%s %s", contentView.getTitleText(), contentView.getSubtitleText()));
    }

    private void m14938c(ContentView contentView, PersonYouMayKnow personYouMayKnow) {
        GraphQLFriendshipStatus f = personYouMayKnow.f();
        GraphQLFriendshipStatus graphQLFriendshipStatus = personYouMayKnow.f;
        switch (C14016.f13276a[f.ordinal()]) {
            case 1:
                if (graphQLFriendshipStatus != null) {
                    if (GraphQLFriendshipStatus.INCOMING_REQUEST.equals(graphQLFriendshipStatus)) {
                        contentView.setSubtitleText(2131233223);
                        return;
                    } else if (GraphQLFriendshipStatus.OUTGOING_REQUEST.equals(graphQLFriendshipStatus)) {
                        contentView.setSubtitleText(2131233220);
                        return;
                    } else if (GraphQLFriendshipStatus.ARE_FRIENDS.equals(graphQLFriendshipStatus)) {
                        contentView.setSubtitleText(2131233234);
                        return;
                    } else {
                        contentView.setSubtitleText(m14928a(personYouMayKnow.e()));
                        return;
                    }
                }
                break;
            case 2:
                contentView.setSubtitleText(m14928a(personYouMayKnow.e()));
                return;
            case 3:
                contentView.setSubtitleText(2131233219);
                return;
            case 4:
                if (GraphQLFriendshipStatus.INCOMING_REQUEST.equals(graphQLFriendshipStatus)) {
                    contentView.setSubtitleText(2131233222);
                    return;
                } else {
                    contentView.setSubtitleText(m14928a(personYouMayKnow.e()));
                    return;
                }
        }
        contentView.setSubtitleText(m14928a(personYouMayKnow.e()));
    }

    private void m14929a(FriendRequestItemView friendRequestItemView, final PersonYouMayKnow personYouMayKnow) {
        friendRequestItemView.m14781a(m14933b(2131233212), m14933b(2131233213));
        friendRequestItemView.setNegativeButtonText(m14933b(2131233211));
        GraphQLFriendshipStatus f = personYouMayKnow.f();
        if (GraphQLFriendshipStatus.CAN_REQUEST.equals(f) || GraphQLFriendshipStatus.INCOMING_REQUEST.equals(f)) {
            friendRequestItemView.setFriendRequestButtonsVisible(true);
            friendRequestItemView.setPositiveButtonOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FriendingPYMKBinder f13261b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -845262400);
                    this.f13261b.f13283g.m14976b(personYouMayKnow);
                    FriendingPYMKBinder.m14931a(this.f13261b, personYouMayKnow);
                    Logger.a(2, EntryType.UI_INPUT_END, 214685615, a);
                }
            });
            friendRequestItemView.setNegativeButtonOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FriendingPYMKBinder f13263b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1428927854);
                    FriendingPYMKBinder.m14935b(this.f13263b, personYouMayKnow);
                    Logger.a(2, EntryType.UI_INPUT_END, 676303919, a);
                }
            });
            return;
        }
        friendRequestItemView.setFriendRequestButtonsVisible(false);
        friendRequestItemView.setPositiveButtonOnClickListener(null);
        friendRequestItemView.setNegativeButtonOnClickListener(null);
    }

    public static void m14930a(FriendingPYMKBinder friendingPYMKBinder, FriendListItemView friendListItemView, final PersonYouMayKnow personYouMayKnow) {
        final GraphQLFriendshipStatus f = personYouMayKnow.f();
        switch (C14016.f13276a[f.ordinal()]) {
            case 1:
                friendListItemView.m14778a(ActionButtonTheme.PRIMARY, friendingPYMKBinder.f13278b.getDrawable(2130840448));
                friendListItemView.m14779a(friendingPYMKBinder.m14933b(2131233212), friendingPYMKBinder.m14933b(2131233213));
                friendListItemView.setActionButtonContentDescription(friendingPYMKBinder.f13278b.getString(2131233228));
                break;
            case 2:
                friendListItemView.m14778a(ActionButtonTheme.PRIMARY, friendingPYMKBinder.f13278b.getDrawable(2130840448));
                friendListItemView.m14779a(friendingPYMKBinder.m14933b(2131233212), friendingPYMKBinder.m14933b(2131233213));
                friendListItemView.setActionButtonContentDescription(friendingPYMKBinder.f13278b.getString(2131233231));
                break;
            case 3:
                friendListItemView.m14778a(ActionButtonTheme.SECONDARY, friendingPYMKBinder.f13278b.getDrawable(2130840450));
                friendListItemView.m14779a(friendingPYMKBinder.m14933b(2131230727), null);
                friendListItemView.setActionButtonContentDescription(friendingPYMKBinder.f13278b.getString(2131233230));
                break;
            case 4:
                friendListItemView.m14778a(ActionButtonTheme.SECONDARY, friendingPYMKBinder.f13278b.getDrawable(2130840454));
                friendListItemView.m14779a(friendingPYMKBinder.m14933b(2131233209), null);
                friendListItemView.setActionButtonContentDescription(friendingPYMKBinder.f13278b.getString(2131233229));
                break;
            default:
                friendListItemView.setActionButtonOnClickListener(null);
                friendListItemView.setShowActionButton(false);
                return;
        }
        friendListItemView.setShowActionButton(true);
        friendListItemView.setActionButtonOnClickListener(new OnClickListener(friendingPYMKBinder) {
            final /* synthetic */ FriendingPYMKBinder f13266c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1714609654);
                if (GraphQLFriendshipStatus.CAN_REQUEST.equals(f)) {
                    this.f13266c.f13283g.m14976b(personYouMayKnow);
                }
                FriendingPYMKBinder.m14939c(this.f13266c, personYouMayKnow);
                Logger.a(2, EntryType.UI_INPUT_END, -1685568741, a);
            }
        });
    }

    public static void m14931a(FriendingPYMKBinder friendingPYMKBinder, final PersonYouMayKnow personYouMayKnow) {
        friendingPYMKBinder.m14937c();
        final GraphQLFriendshipStatus graphQLFriendshipStatus = personYouMayKnow.f;
        final GraphQLFriendshipStatus f = personYouMayKnow.f();
        personYouMayKnow.f = f;
        personYouMayKnow.b(m14927a(f));
        friendingPYMKBinder.f13287k.mo823a(personYouMayKnow.a());
        FriendingButtonControllerWithCallback friendingButtonControllerWithCallback = friendingPYMKBinder.f13280d;
        long a = personYouMayKnow.a();
        personYouMayKnow.b();
        friendingButtonControllerWithCallback.a(a, friendingPYMKBinder.f13286j, f, new FriendingButtonControllerCallback(friendingPYMKBinder) {
            final /* synthetic */ FriendingPYMKBinder f13270d;

            public final void m14924a() {
                personYouMayKnow.f = graphQLFriendshipStatus;
                personYouMayKnow.b(f);
                if (FriendingPYMKBinder.m14936b(this.f13270d, personYouMayKnow.a())) {
                    this.f13270d.f13287k.mo825c(personYouMayKnow.a());
                }
            }
        });
    }

    public static void m14935b(FriendingPYMKBinder friendingPYMKBinder, PersonYouMayKnow personYouMayKnow) {
        friendingPYMKBinder.m14937c();
        friendingPYMKBinder.f13285i.remove(Long.valueOf(personYouMayKnow.a()));
        friendingPYMKBinder.f13287k.mo824b(personYouMayKnow.a());
        friendingPYMKBinder.f13281e.a(personYouMayKnow.a(), f13277a);
        friendingPYMKBinder.f13282f.a(new PYMKBlacklistedEvent(personYouMayKnow.a()));
    }

    public static void m14939c(FriendingPYMKBinder friendingPYMKBinder, PersonYouMayKnow personYouMayKnow) {
        friendingPYMKBinder.m14937c();
        final GraphQLFriendshipStatus graphQLFriendshipStatus = personYouMayKnow.f;
        final GraphQLFriendshipStatus f = personYouMayKnow.f();
        final GraphQLFriendshipStatus a = m14927a(f);
        personYouMayKnow.f = f;
        personYouMayKnow.b(a);
        if (GraphQLFriendshipStatus.CAN_REQUEST.equals(a) || GraphQLFriendshipStatus.INCOMING_REQUEST.equals(a)) {
            friendingPYMKBinder.f13287k.mo825c(personYouMayKnow.a());
        } else {
            ContentView a2 = m14926a(friendingPYMKBinder, personYouMayKnow.a());
            if (a2 instanceof FriendListItemView) {
                m14934b(friendingPYMKBinder, a2, personYouMayKnow);
                m14930a(friendingPYMKBinder, (FriendListItemView) a2, personYouMayKnow);
            }
        }
        FriendingButtonControllerWithCallback friendingButtonControllerWithCallback = friendingPYMKBinder.f13280d;
        long a3 = personYouMayKnow.a();
        personYouMayKnow.b();
        final PersonYouMayKnow personYouMayKnow2 = personYouMayKnow;
        friendingButtonControllerWithCallback.a(a3, friendingPYMKBinder.f13286j, f, new FriendingButtonControllerCallback(friendingPYMKBinder) {
            final /* synthetic */ FriendingPYMKBinder f13275e;

            public final void m14925a() {
                personYouMayKnow2.f = graphQLFriendshipStatus;
                personYouMayKnow2.b(f);
                if (!FriendingPYMKBinder.m14936b(this.f13275e, personYouMayKnow2.a())) {
                    return;
                }
                if (GraphQLFriendshipStatus.CAN_REQUEST.equals(a) || GraphQLFriendshipStatus.INCOMING_REQUEST.equals(a)) {
                    this.f13275e.f13287k.mo823a(personYouMayKnow2.a());
                    return;
                }
                ContentView a = FriendingPYMKBinder.m14926a(this.f13275e, personYouMayKnow2.a());
                if (a instanceof FriendListItemView) {
                    FriendingPYMKBinder.m14934b(this.f13275e, a, personYouMayKnow2);
                    FriendingPYMKBinder.m14930a(this.f13275e, (FriendListItemView) a, personYouMayKnow2);
                }
            }
        });
    }

    public final void m14940a() {
        this.f13280d.d = false;
    }

    public final void m14942b() {
        this.f13285i.clear();
        this.f13280d.d = true;
    }

    private String m14928a(int i) {
        if (i <= 0) {
            return "";
        }
        return this.f13278b.getQuantityString(2131689520, i, new Object[]{Integer.valueOf(i)});
    }

    private CharSequence m14933b(@StringRes int i) {
        return this.f13279c.getTransformation(this.f13278b.getString(i), null);
    }

    private static GraphQLFriendshipStatus m14927a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        switch (C14016.f13276a[graphQLFriendshipStatus.ordinal()]) {
            case 1:
                return GraphQLFriendshipStatus.OUTGOING_REQUEST;
            case 2:
                return GraphQLFriendshipStatus.ARE_FRIENDS;
            case 3:
                return GraphQLFriendshipStatus.CAN_REQUEST;
            case 4:
                return GraphQLFriendshipStatus.CAN_REQUEST;
            default:
                return GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
    }

    @Nullable
    public static ContentView m14926a(FriendingPYMKBinder friendingPYMKBinder, long j) {
        WeakReference weakReference = (WeakReference) friendingPYMKBinder.f13285i.get(Long.valueOf(j));
        return weakReference != null ? (ContentView) weakReference.get() : null;
    }

    public static boolean m14936b(FriendingPYMKBinder friendingPYMKBinder, long j) {
        ContentView a = m14926a(friendingPYMKBinder, j);
        if (a == null) {
            return false;
        }
        PersonYouMayKnow personYouMayKnow = (PersonYouMayKnow) a.getTag(2131558784);
        if (personYouMayKnow == null || personYouMayKnow.a() != j) {
            return false;
        }
        return true;
    }

    private void m14937c() {
        this.f13284h.a(ImmutableSet.of("REQUESTS_TAB_PYMK_QUERY_TAG"));
    }
}
