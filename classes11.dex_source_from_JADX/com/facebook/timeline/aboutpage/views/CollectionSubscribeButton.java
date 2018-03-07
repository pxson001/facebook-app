package com.facebook.timeline.aboutpage.views;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.FriendingStartOperationHelper;
import com.facebook.friends.protocol.SetNotificationPreferenceMethod.Params;
import com.facebook.graphql.calls.ActorSubscribeInputData.SubscribeLocation;
import com.facebook.graphql.calls.ActorUnsubscribeInputData;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.model.TimelineAppCollectionItemNode;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.dialogs.ActionSheetDialogBuilder;
import com.facebook.ui.dialogs.ActionSheetDialogBuilder.1;
import com.google.common.base.Functions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: Ljava/util/Map */
public class CollectionSubscribeButton extends ImageView {
    private ListCollectionItemData f13752a;
    public CollectionButtonStatusListener f13753b;
    private FriendingClient f13754c;
    public AbstractFbErrorReporter f13755d;
    private Executor f13756e;

    /* compiled from: Ljava/util/Map */
    /* synthetic */ class C16007 {
        static final /* synthetic */ int[] f13751a = new int[GraphQLSubscribeStatus.values().length];

        static {
            try {
                f13751a[GraphQLSubscribeStatus.CAN_SUBSCRIBE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13751a[GraphQLSubscribeStatus.IS_SUBSCRIBED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13751a[GraphQLSubscribeStatus.CANNOT_SUBSCRIBE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public CollectionSubscribeButton(Context context) {
        this(context, null);
    }

    public CollectionSubscribeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setImageResource(2130838108);
        setScaleType(ScaleType.CENTER_INSIDE);
        setClickable(true);
        setVisibility(8);
    }

    public final void m14925a(ProfileViewerContext profileViewerContext, ListCollectionItemData listCollectionItemData, CollectionButtonStatusListener collectionButtonStatusListener, FriendingClient friendingClient, AbstractFbErrorReporter abstractFbErrorReporter, Executor executor) {
        this.f13752a = listCollectionItemData;
        this.f13753b = collectionButtonStatusListener;
        this.f13754c = friendingClient;
        this.f13755d = abstractFbErrorReporter;
        this.f13756e = executor;
        if (listCollectionItemData.f13844h == null || profileViewerContext.b.equals(listCollectionItemData.f13844h.f13151b)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        final TimelineAppCollectionItemNode timelineAppCollectionItemNode = this.f13752a.f13844h;
        this.f13755d;
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CollectionSubscribeButton f13739b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1748331454);
                switch (C16007.f13751a[timelineAppCollectionItemNode.m13939g().ordinal()]) {
                    case 1:
                        CollectionSubscribeButton.m14923c(this.f13739b, timelineAppCollectionItemNode);
                        break;
                    case 2:
                        CollectionSubscribeButton.m14924d(this.f13739b, timelineAppCollectionItemNode);
                        break;
                    default:
                        this.f13739b.f13755d.b("ListCollectionItemView", "unknown subscribe status");
                        break;
                }
                LogUtils.a(1423619735, a);
            }
        });
    }

    public static void m14918a(CollectionSubscribeButton collectionSubscribeButton) {
        if (collectionSubscribeButton.f13752a.f13844h.f13157h == null || collectionSubscribeButton.f13752a.f13844h.f13157h.g() != 2645995) {
            collectionSubscribeButton.setVisibility(8);
            return;
        }
        switch (C16007.f13751a[collectionSubscribeButton.f13752a.f13844h.m13939g().ordinal()]) {
            case 1:
                collectionSubscribeButton.setImageResource(2130838108);
                collectionSubscribeButton.setContentDescription(2131235005);
                return;
            case 2:
                collectionSubscribeButton.setImageResource(2130838109);
                collectionSubscribeButton.setContentDescription(2131235006);
                return;
            case 3:
                collectionSubscribeButton.setVisibility(8);
                return;
            default:
                throw new IllegalArgumentException("Invalid subscribe status");
        }
    }

    private void setContentDescription(int i) {
        setContentDescription(getContext().getResources().getString(i));
    }

    public static void m14923c(CollectionSubscribeButton collectionSubscribeButton, final TimelineAppCollectionItemNode timelineAppCollectionItemNode) {
        ListenableFuture a = collectionSubscribeButton.f13754c.a(timelineAppCollectionItemNode.f13151b, SubscribeLocation.TIMELINE_COLLECTION);
        timelineAppCollectionItemNode.m13934a(GraphQLSubscribeStatus.IS_SUBSCRIBED);
        collectionSubscribeButton.f13753b.K_(2131234907);
        collectionSubscribeButton.f13755d;
        Futures.a(a, new FutureCallback<Void>(collectionSubscribeButton) {
            final /* synthetic */ CollectionSubscribeButton f13741b;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                timelineAppCollectionItemNode.m13934a(GraphQLSubscribeStatus.CAN_SUBSCRIBE);
                this.f13741b.f13755d;
                this.f13741b.f13753b.K_(2131234915);
            }
        }, collectionSubscribeButton.f13756e);
    }

    public static void m14924d(CollectionSubscribeButton collectionSubscribeButton, final TimelineAppCollectionItemNode timelineAppCollectionItemNode) {
        int i;
        Resources resources = collectionSubscribeButton.getContext().getResources();
        if (timelineAppCollectionItemNode.f13161l) {
            i = 2131234920;
        } else {
            i = 2131234919;
        }
        ActionSheetDialogBuilder a = new ActionSheetDialogBuilder(collectionSubscribeButton.getContext()).a(collectionSubscribeButton.getContext().getResources().getString(2131234904), new DialogInterface.OnClickListener(collectionSubscribeButton) {
            final /* synthetic */ CollectionSubscribeButton f13745b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f13745b.m14927b(timelineAppCollectionItemNode);
                dialogInterface.dismiss();
            }
        }).a(resources.getString(i), new DialogInterface.OnClickListener(collectionSubscribeButton) {
            final /* synthetic */ CollectionSubscribeButton f13743b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f13743b.m14926a(timelineAppCollectionItemNode);
                dialogInterface.dismiss();
            }
        });
        a.a(collectionSubscribeButton.getContext().getResources().getString(2131234960), new 1(a));
        a.show();
    }

    final void m14926a(final TimelineAppCollectionItemNode timelineAppCollectionItemNode) {
        boolean z;
        boolean z2 = true;
        final boolean z3 = timelineAppCollectionItemNode.f13161l;
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        timelineAppCollectionItemNode.f13161l = z;
        if (z3) {
            this.f13753b.K_(2131234922);
        } else {
            this.f13753b.K_(2131234921);
        }
        FriendingClient friendingClient = this.f13754c;
        long parseLong = Long.parseLong(timelineAppCollectionItemNode.f13151b);
        if (z3) {
            z2 = false;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("setNotificationPreference", new Params(parseLong, z2));
        Futures.a(Futures.a(FriendingStartOperationHelper.a(BlueServiceOperationFactoryDetour.a(friendingClient.f, "friending_set_notification_preference", bundle, 1406462612)), Functions.constant(null)), new FutureCallback<Void>(this) {
            final /* synthetic */ CollectionSubscribeButton f13748c;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                timelineAppCollectionItemNode.f13161l = z3;
                this.f13748c.f13753b.K_(2131234923);
            }
        });
    }

    final void m14927b(final TimelineAppCollectionItemNode timelineAppCollectionItemNode) {
        timelineAppCollectionItemNode.m13934a(GraphQLSubscribeStatus.CAN_SUBSCRIBE);
        this.f13755d;
        this.f13753b.K_(2131234908);
        Futures.a(this.f13754c.a(timelineAppCollectionItemNode.f13151b, ActorUnsubscribeInputData.SubscribeLocation.TIMELINE_COLLECTION), new FutureCallback<Void>(this) {
            final /* synthetic */ CollectionSubscribeButton f13750b;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                timelineAppCollectionItemNode.m13934a(GraphQLSubscribeStatus.IS_SUBSCRIBED);
                this.f13750b.f13755d;
                this.f13750b.f13753b.K_(2131234916);
            }
        }, this.f13756e);
    }
}
