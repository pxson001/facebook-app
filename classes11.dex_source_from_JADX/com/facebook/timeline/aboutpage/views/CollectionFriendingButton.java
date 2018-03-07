package com.facebook.timeline.aboutpage.views;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendRequestCancelRef;
import com.facebook.friends.constants.FriendRequestHowFound;
import com.facebook.friends.constants.RemoveFriendRef;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.model.TimelineAppCollectionItemNode;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.friendshipbutton.FriendshipStatusButton;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: Ljava/util/TreeSet */
public class CollectionFriendingButton extends FriendshipStatusButton {
    private ListCollectionItemData f13717a;
    public CollectionButtonStatusListener f13718b;
    private FriendingClient f13719c;
    public AbstractFbErrorReporter f13720d;

    /* compiled from: Ljava/util/TreeSet */
    /* synthetic */ class C15876 {
        static final /* synthetic */ int[] f13716a = new int[GraphQLFriendshipStatus.values().length];

        static {
            try {
                f13716a[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13716a[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13716a[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f13716a[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f13716a[GraphQLFriendshipStatus.CANNOT_REQUEST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public CollectionFriendingButton(Context context) {
        this(context, null);
    }

    public CollectionFriendingButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setClickable(true);
        setVisibility(8);
    }

    public final void m14899a(ProfileViewerContext profileViewerContext, ListCollectionItemData listCollectionItemData, CollectionButtonStatusListener collectionButtonStatusListener, FriendingClient friendingClient, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f13717a = listCollectionItemData;
        this.f13718b = collectionButtonStatusListener;
        this.f13719c = friendingClient;
        this.f13720d = abstractFbErrorReporter;
        if (listCollectionItemData.f13844h == null || profileViewerContext.b.equals(listCollectionItemData.f13844h.f13151b)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        final TimelineAppCollectionItemNode timelineAppCollectionItemNode = this.f13717a.f13844h;
        this.f13720d;
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CollectionFriendingButton f13707b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -700435937);
                switch (C15876.f13716a[timelineAppCollectionItemNode.m13938f().ordinal()]) {
                    case 1:
                        this.f13707b.m14892b(timelineAppCollectionItemNode);
                        break;
                    case 2:
                        this.f13707b.m14896c(timelineAppCollectionItemNode);
                        break;
                    case 3:
                        CollectionFriendingButton.m14898d(this.f13707b, timelineAppCollectionItemNode);
                        break;
                    default:
                        this.f13707b.f13720d.b("ListCollectionItemView", "unknown friendship status");
                        break;
                }
                LogUtils.a(1099670333, a);
            }
        });
    }

    public static void m14890a(CollectionFriendingButton collectionFriendingButton) {
        GraphQLFriendshipStatus f = collectionFriendingButton.f13717a.f13844h.m13938f();
        collectionFriendingButton.setFriendshipStatus(f);
        if (f == GraphQLFriendshipStatus.OUTGOING_REQUEST) {
            collectionFriendingButton.f13718b.K_(2131234936);
        }
    }

    private void m14892b(final TimelineAppCollectionItemNode timelineAppCollectionItemNode) {
        ListenableFuture b = this.f13719c.b(Long.parseLong(timelineAppCollectionItemNode.f13151b), FriendRequestHowFound.TIMELINE_FRIENDS_COLLECTION, null, null);
        timelineAppCollectionItemNode.m13933a(GraphQLFriendshipStatus.OUTGOING_REQUEST);
        this.f13720d;
        Futures.a(b, new FutureCallback<GraphQLFriendshipStatus>(this) {
            final /* synthetic */ CollectionFriendingButton f13709b;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                timelineAppCollectionItemNode.m13933a(GraphQLFriendshipStatus.CAN_REQUEST);
                this.f13709b.f13720d;
                this.f13709b.f13718b.K_(2131234939);
            }
        });
    }

    private void m14896c(final TimelineAppCollectionItemNode timelineAppCollectionItemNode) {
        ListenableFuture a = this.f13719c.a(Long.parseLong(timelineAppCollectionItemNode.f13151b), FriendRequestCancelRef.TIMELINE_FRIENDS_COLLECTION);
        timelineAppCollectionItemNode.m13933a(GraphQLFriendshipStatus.CAN_REQUEST);
        this.f13720d;
        this.f13718b.K_(2131234937);
        Futures.a(a, new FutureCallback<GraphQLFriendshipStatus>(this) {
            final /* synthetic */ CollectionFriendingButton f13711b;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                timelineAppCollectionItemNode.m13933a(GraphQLFriendshipStatus.OUTGOING_REQUEST);
                this.f13711b.f13720d;
                this.f13711b.f13718b.K_(2131234940);
            }
        });
    }

    public static void m14898d(CollectionFriendingButton collectionFriendingButton, final TimelineAppCollectionItemNode timelineAppCollectionItemNode) {
        new Builder(collectionFriendingButton.getContext()).b(StringLocaleUtil.a(collectionFriendingButton.getContext().getString(2131233233), new Object[]{collectionFriendingButton.f13717a.f13838b.a()})).a(2131234930, new DialogInterface.OnClickListener(collectionFriendingButton) {
            final /* synthetic */ CollectionFriendingButton f13713b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f13713b.m14900a(timelineAppCollectionItemNode);
            }
        }).b(2131234960, null).b();
    }

    final void m14900a(final TimelineAppCollectionItemNode timelineAppCollectionItemNode) {
        timelineAppCollectionItemNode.m13933a(GraphQLFriendshipStatus.CAN_REQUEST);
        this.f13720d;
        this.f13718b.K_(2131234938);
        Futures.a(this.f13719c.a(Long.parseLong(timelineAppCollectionItemNode.f13151b), RemoveFriendRef.TIMELINE_FRIENDS_COLLECTION), new FutureCallback<GraphQLFriendshipStatus>(this) {
            final /* synthetic */ CollectionFriendingButton f13715b;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                timelineAppCollectionItemNode.m13933a(GraphQLFriendshipStatus.ARE_FRIENDS);
                this.f13715b.f13720d;
                this.f13715b.f13718b.K_(2131234941);
            }
        });
    }
}
