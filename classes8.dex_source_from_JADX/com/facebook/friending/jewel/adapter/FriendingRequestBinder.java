package com.facebook.friending.jewel.adapter;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.friending.common.list.FriendRequestItemView;
import com.facebook.friends.FriendingCacheHandler;
import com.facebook.friends.FriendingCacheHandlerProvider;
import com.facebook.friends.constants.FriendRequestResponse;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.FriendRequestController;
import com.facebook.friends.controllers.FriendRequestController.Callback;
import com.facebook.friends.model.FriendRequest;
import com.facebook.friends.model.FriendRequestState;
import com.facebook.friends.util.FriendRequestUtil;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.notificationsfriending.adapter.FriendRequestsAdapterSection.1;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: filtered query was null */
public class FriendingRequestBinder {
    private final AllCapsTransformationMethod f13299a;
    public final FriendingCacheHandler f13300b;
    public final FriendRequestController f13301c;
    public final FriendRequestUtil f13302d;
    public final Resources f13303e;
    public FriendingLocation f13304f;
    public 1 f13305g;

    /* compiled from: filtered query was null */
    public class C14054 implements Callback {
        final /* synthetic */ FriendRequest f13295a;
        final /* synthetic */ FriendRequestState f13296b;
        final /* synthetic */ FriendingRequestBinder f13297c;

        public C14054(FriendingRequestBinder friendingRequestBinder, FriendRequest friendRequest, FriendRequestState friendRequestState) {
            this.f13297c = friendingRequestBinder;
            this.f13295a = friendRequest;
            this.f13296b = friendRequestState;
        }

        public final void m14945a() {
        }

        public final void m14946a(boolean z) {
            this.f13295a.j = this.f13296b;
            this.f13297c.f13305g.a(this.f13295a.a(), z);
        }
    }

    /* compiled from: filtered query was null */
    public /* synthetic */ class C14065 {
        public static final /* synthetic */ int[] f13298a = new int[FriendRequestState.values().length];

        static {
            try {
                f13298a[FriendRequestState.ACCEPTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13298a[FriendRequestState.REJECTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @Inject
    public FriendingRequestBinder(AllCapsTransformationMethod allCapsTransformationMethod, FriendingCacheHandlerProvider friendingCacheHandlerProvider, FriendRequestController friendRequestController, FriendRequestUtil friendRequestUtil, Resources resources, TasksManager tasksManager, @Assisted FriendingLocation friendingLocation, @Assisted 1 1) {
        this.f13299a = allCapsTransformationMethod;
        this.f13300b = friendingCacheHandlerProvider.a(tasksManager);
        this.f13301c = friendRequestController;
        this.f13302d = friendRequestUtil;
        this.f13303e = resources;
        this.f13304f = friendingLocation;
        this.f13305g = 1;
    }

    public final void m14950a(FriendRequestItemView friendRequestItemView, FriendRequest friendRequest) {
        int i;
        CharSequence b = friendRequest.b();
        boolean l = friendRequest.l();
        CharSequence a = this.f13302d.a(friendRequest.j, l);
        if (StringUtil.a(a)) {
            if (!l || friendRequest.g.isEmpty()) {
                a = friendRequest.h();
            } else {
                a = this.f13303e.getString(2131233358, new Object[]{friendRequest.g.get(0)});
            }
        }
        if (a == null) {
            a = "";
        }
        CharSequence charSequence = a;
        friendRequestItemView.setThumbnailUri(friendRequest.d());
        friendRequestItemView.setTitleText(b);
        friendRequestItemView.setSubtitleText(charSequence);
        friendRequestItemView.setContentDescription(StringFormatUtil.formatStrLocaleSafe("%s %s", b, charSequence));
        switch (C14065.f13298a[friendRequest.j.ordinal()]) {
            case 1:
                i = 2131363701;
                break;
            case 2:
                i = 2131363702;
                break;
            default:
                if (!friendRequest.h) {
                    i = 2130840432;
                    break;
                } else {
                    i = 2131361871;
                    break;
                }
        }
        friendRequestItemView.setBackgroundResource(i);
        m14948b(friendRequestItemView, friendRequest);
    }

    private void m14948b(FriendRequestItemView friendRequestItemView, final FriendRequest friendRequest) {
        if (FriendRequestState.NEEDS_RESPONSE.equals(friendRequest.j)) {
            friendRequestItemView.setFriendRequestButtonsVisible(true);
            boolean l = friendRequest.l();
            friendRequestItemView.m14781a(m14947a(this.f13302d.a(l)), m14947a(this.f13302d.b(l)));
            friendRequestItemView.setNegativeButtonText(m14947a(this.f13302d.c(l)));
            friendRequestItemView.setPositiveButtonOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FriendingRequestBinder f13289b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 2097367622);
                    if (friendRequest.l()) {
                        FriendingRequestBinder friendingRequestBinder = this.f13289b;
                        FriendRequest friendRequest = friendRequest;
                        FriendRequestResponse friendRequestResponse = FriendRequestResponse.CONFIRM;
                        if (FriendRequestResponse.REJECT.equals(friendRequestResponse)) {
                            friendingRequestBinder.f13300b.b();
                        } else {
                            friendingRequestBinder.f13300b.c();
                        }
                        FriendRequestState friendRequestState = friendRequest.j;
                        friendRequest.j = FriendRequestUtil.a(friendRequestResponse);
                        friendingRequestBinder.f13305g.a(friendRequest.a(), false);
                        friendingRequestBinder.f13301c.a(friendRequest.a(), friendRequestResponse, new C14054(friendingRequestBinder, friendRequest, friendRequestState));
                    } else {
                        FriendingRequestBinder.m14949b(this.f13289b, friendRequest, FriendRequestResponse.CONFIRM);
                    }
                    LogUtils.a(-166983254, a);
                }
            });
            friendRequestItemView.setNegativeButtonOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FriendingRequestBinder f13291b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -2086950430);
                    if (friendRequest.l()) {
                        FriendingRequestBinder friendingRequestBinder = this.f13291b;
                        FriendRequest friendRequest = friendRequest;
                        FriendRequestResponse friendRequestResponse = FriendRequestResponse.REJECT;
                        if (FriendRequestResponse.REJECT.equals(friendRequestResponse)) {
                            friendingRequestBinder.f13300b.b();
                        } else {
                            friendingRequestBinder.f13300b.c();
                        }
                        FriendRequestState friendRequestState = friendRequest.j;
                        friendRequest.j = FriendRequestUtil.a(friendRequestResponse);
                        friendingRequestBinder.f13305g.a(friendRequest.a(), false);
                        friendingRequestBinder.f13301c.a(friendRequest.a(), friendRequestResponse, new C14054(friendingRequestBinder, friendRequest, friendRequestState));
                    } else {
                        FriendingRequestBinder.m14949b(this.f13291b, friendRequest, FriendRequestResponse.REJECT);
                    }
                    LogUtils.a(1919755638, a);
                }
            });
            return;
        }
        friendRequestItemView.setFriendRequestButtonsVisible(false);
    }

    static /* synthetic */ void m14949b(FriendingRequestBinder friendingRequestBinder, final FriendRequest friendRequest, FriendRequestResponse friendRequestResponse) {
        friendingRequestBinder.f13300b.c();
        final FriendRequestState friendRequestState = friendRequest.j;
        friendRequest.j = FriendRequestUtil.a(friendRequestResponse);
        friendingRequestBinder.f13305g.a(friendRequest.a(), false);
        friendingRequestBinder.f13301c.a(friendRequest.a(), friendingRequestBinder.f13304f, friendRequestResponse, new Callback(friendingRequestBinder) {
            final /* synthetic */ FriendingRequestBinder f13294c;

            public final void m14943a() {
            }

            public final void m14944a(boolean z) {
                friendRequest.j = friendRequestState;
                this.f13294c.f13305g.a(friendRequest.a(), z);
            }
        });
    }

    @Nullable
    private CharSequence m14947a(@Nullable CharSequence charSequence) {
        return StringUtil.a(charSequence) ? null : this.f13299a.getTransformation(charSequence, null);
    }
}
