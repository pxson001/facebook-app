package com.facebook.timeline.aboutpage.views;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.graphql.calls.GroupLeaveInputData;
import com.facebook.graphql.calls.GroupLeaveInputData.ReaddPolicy;
import com.facebook.graphql.calls.GroupRequestToJoinInputData.Source;
import com.facebook.groups.mutations.GroupsClient;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.model.GroupJoinStatus;
import com.facebook.timeline.aboutpage.model.TimelineAppCollectionItemNode;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: Ljava/util/Set */
public class CollectionGroupJoinButton extends ImageView {
    private ListCollectionItemData f13732a;
    private ProfileViewerContext f13733b;
    public CollectionButtonStatusListener f13734c;
    private GroupsClient f13735d;
    public AbstractFbErrorReporter f13736e;

    public CollectionGroupJoinButton(Context context) {
        this(context, null);
    }

    public CollectionGroupJoinButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setImageResource(2130840161);
        setBackgroundResource(2130840164);
        setScaleType(ScaleType.CENTER_INSIDE);
        setClickable(true);
        setVisibility(8);
    }

    public final void m14913a(ProfileViewerContext profileViewerContext, ListCollectionItemData listCollectionItemData, CollectionButtonStatusListener collectionButtonStatusListener, GroupsClient groupsClient, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f13733b = profileViewerContext;
        this.f13732a = listCollectionItemData;
        this.f13734c = collectionButtonStatusListener;
        this.f13735d = groupsClient;
        this.f13736e = abstractFbErrorReporter;
        if (listCollectionItemData.f13844h == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        final TimelineAppCollectionItemNode timelineAppCollectionItemNode = this.f13732a.f13844h;
        this.f13736e;
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CollectionGroupJoinButton f13722b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -2089332406);
                switch (timelineAppCollectionItemNode.m13940i()) {
                    case CAN_REQUEST:
                    case CAN_JOIN:
                        this.f13722b.m14902a(timelineAppCollectionItemNode);
                        break;
                    case REQUESTED:
                        this.f13722b.m14905b(timelineAppCollectionItemNode);
                        break;
                    case MEMBER:
                        this.f13722b.m14909c(timelineAppCollectionItemNode);
                        break;
                    default:
                        this.f13722b.f13736e.b("ListCollectionItemView", "unknown group membership status");
                        break;
                }
                LogUtils.a(1393061746, a);
            }
        });
    }

    public static void m14903a(CollectionGroupJoinButton collectionGroupJoinButton) {
        switch (collectionGroupJoinButton.f13732a.f13844h.m13940i()) {
            case CAN_REQUEST:
            case CAN_JOIN:
                collectionGroupJoinButton.setImageResource(2130840161);
                collectionGroupJoinButton.setContentDescription(2131235004);
                return;
            case REQUESTED:
                collectionGroupJoinButton.setImageResource(2130840158);
                collectionGroupJoinButton.setContentDescription(2131235003);
                collectionGroupJoinButton.f13734c.K_(2131234942);
                return;
            case MEMBER:
                collectionGroupJoinButton.setImageResource(2130840158);
                collectionGroupJoinButton.setContentDescription(2131235007);
                return;
            case CANNOT_JOIN_OR_REQUEST:
                collectionGroupJoinButton.setVisibility(8);
                return;
            default:
                throw new IllegalArgumentException("Invalid group membership status");
        }
    }

    private void setContentDescription(int i) {
        setContentDescription(getContext().getResources().getString(i));
    }

    private void m14902a(final TimelineAppCollectionItemNode timelineAppCollectionItemNode) {
        ListenableFuture a = this.f13735d.a(timelineAppCollectionItemNode.f13151b, Source.MOBILE_GROUP_JOIN);
        timelineAppCollectionItemNode.m13935a(GroupJoinStatus.REQUESTED);
        this.f13736e;
        Futures.a(a, new FutureCallback<Void>(this) {
            final /* synthetic */ CollectionGroupJoinButton f13724b;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                timelineAppCollectionItemNode.m13935a(GroupJoinStatus.CAN_REQUEST);
                this.f13724b.f13736e;
                this.f13724b.f13734c.K_(2131234944);
            }
        });
    }

    private void m14905b(final TimelineAppCollectionItemNode timelineAppCollectionItemNode) {
        ListenableFuture a = this.f13735d.a(timelineAppCollectionItemNode.f13151b, GroupLeaveInputData.Source.MOBILE_GROUP_JOIN, ReaddPolicy.ALLOW_READD);
        timelineAppCollectionItemNode.m13935a(GroupJoinStatus.CAN_REQUEST);
        this.f13736e;
        this.f13734c.K_(2131234943);
        Futures.a(a, new FutureCallback<Void>(this) {
            final /* synthetic */ CollectionGroupJoinButton f13726b;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                timelineAppCollectionItemNode.m13935a(GroupJoinStatus.REQUESTED);
                this.f13726b.f13736e;
                this.f13726b.f13734c.K_(2131234945);
            }
        });
    }

    private void m14909c(final TimelineAppCollectionItemNode timelineAppCollectionItemNode) {
        new Builder(getContext()).b(StringLocaleUtil.a(getContext().getString(2131234946), new Object[]{this.f13732a.f13838b.a()})).a(2131234947, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ CollectionGroupJoinButton f13728b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f13728b.m14911d(timelineAppCollectionItemNode);
            }
        }).b(2131234960, null).b();
    }

    private void m14911d(final TimelineAppCollectionItemNode timelineAppCollectionItemNode) {
        ListenableFuture a = this.f13735d.a(timelineAppCollectionItemNode.f13151b, GroupLeaveInputData.Source.MOBILE_GROUP_JOIN, ReaddPolicy.ALLOW_READD);
        timelineAppCollectionItemNode.m13935a(GroupJoinStatus.CAN_REQUEST);
        this.f13736e;
        this.f13734c.K_(2131234948);
        Futures.a(a, new FutureCallback<Void>(this) {
            final /* synthetic */ CollectionGroupJoinButton f13730b;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                timelineAppCollectionItemNode.m13935a(GroupJoinStatus.MEMBER);
                this.f13730b.f13736e;
                this.f13730b.f13734c.K_(2131234949);
            }
        });
    }
}
