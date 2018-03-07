package com.facebook.ufiservices.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.content.event.FbEvent;
import com.facebook.friends.cache.FriendshipStatusCache;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.FriendingButtonController;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ufiservices.ui.ProfileListFriendingControllerGraphQLInterfaces.ProfileListFriendingControllerGraphQL;
import com.facebook.ufiservices.ui.ProfileListFriendingControllerGraphQLModels.ProfileListFriendingControllerGraphQLModel;
import com.facebook.ufiservices.ui.ProfileListFriendingControllerGraphQLModels.ProfileListFriendingControllerGraphQLModel.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: cubemap  */
public class ProfileListFriendingController {
    private final Context f18264a;
    private final Provider<String> f18265b;
    private final FriendshipStatusCache f18266c;
    public final FriendingButtonController f18267d;
    public ProfileListFriendingControllerGraphQL f18268e;
    public View f18269f;
    private TextView f18270g;
    private ProfileListFriendingButtonBinder f18271h;

    /* compiled from: cubemap  */
    class FriendshipStatusChangedEventSubscriber extends com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber {
        final /* synthetic */ ProfileListFriendingController f18263a;

        public FriendshipStatusChangedEventSubscriber(ProfileListFriendingController profileListFriendingController) {
            this.f18263a = profileListFriendingController;
        }

        public final void m26790b(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            if (friendshipStatusChangedEvent != null && this.f18263a.f18268e != null && friendshipStatusChangedEvent.f10629a == Long.parseLong(this.f18263a.f18268e.g())) {
                ProfileListFriendingController.m26791a(this.f18263a, friendshipStatusChangedEvent.f10630b, this.f18263a.f18268e.b() != null ? this.f18263a.f18268e.b().m26803a() : 0);
                if (!friendshipStatusChangedEvent.f10631c && this.f18263a.f18268e.d() != friendshipStatusChangedEvent.f10630b) {
                    Builder a = Builder.m26797a(ProfileListFriendingControllerGraphQLModel.m26808a(this.f18263a.f18268e));
                    a.f18272a = friendshipStatusChangedEvent.f10630b;
                    a.m26798a();
                }
            }
        }
    }

    public static ProfileListFriendingController m26792b(InjectorLike injectorLike) {
        return new ProfileListFriendingController((Context) injectorLike.getInstance(Context.class), FriendshipStatusCache.a(injectorLike), FriendingButtonController.m16732b(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    @Inject
    public ProfileListFriendingController(Context context, FriendshipStatusCache friendshipStatusCache, FriendingButtonController friendingButtonController, Provider<String> provider) {
        this.f18264a = context;
        this.f18266c = friendshipStatusCache;
        this.f18267d = friendingButtonController;
        this.f18265b = provider;
    }

    public final void m26794a(ProfileListFriendingButtonBinder profileListFriendingButtonBinder, View view, TextView textView) {
        this.f18271h = profileListFriendingButtonBinder;
        this.f18269f = view;
        this.f18270g = textView;
    }

    public final void m26795a(ProfileListFriendingControllerGraphQL profileListFriendingControllerGraphQL) {
        this.f18268e = profileListFriendingControllerGraphQL;
        if (this.f18268e == null || (this.f18265b.get() != null && ((String) this.f18265b.get()).equals(this.f18268e.g()))) {
            this.f18270g.setVisibility(8);
            this.f18269f.setVisibility(8);
            return;
        }
        GraphQLFriendshipStatus a = this.f18266c.a(this.f18268e.g());
        if (!(a == null || this.f18268e.d() == a)) {
            Builder a2 = Builder.m26797a(ProfileListFriendingControllerGraphQLModel.m26808a(this.f18268e));
            a2.f18272a = a;
            this.f18268e = a2.m26798a();
        }
        m26791a(this, this.f18268e.d(), this.f18268e.b() != null ? this.f18268e.b().m26803a() : 0);
    }

    public static void m26791a(@Nullable ProfileListFriendingController profileListFriendingController, final GraphQLFriendshipStatus graphQLFriendshipStatus, int i) {
        if (graphQLFriendshipStatus == null || GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.equals(graphQLFriendshipStatus)) {
            profileListFriendingController.f18270g.setVisibility(8);
            profileListFriendingController.f18269f.setVisibility(8);
            profileListFriendingController.f18269f.setFocusable(false);
            return;
        }
        Resources resources = profileListFriendingController.f18264a.getResources();
        profileListFriendingController.f18270g.setVisibility(0);
        if (GraphQLFriendshipStatus.OUTGOING_REQUEST.equals(graphQLFriendshipStatus)) {
            profileListFriendingController.f18270g.setText(resources.getString(2131233219));
        } else if (GraphQLFriendshipStatus.CAN_REQUEST.equals(graphQLFriendshipStatus) && GraphQLFriendshipStatus.OUTGOING_REQUEST.equals(graphQLFriendshipStatus)) {
            profileListFriendingController.f18270g.setText(resources.getString(2131233220));
        } else if (GraphQLFriendshipStatus.CAN_REQUEST.equals(graphQLFriendshipStatus) && GraphQLFriendshipStatus.ARE_FRIENDS.equals(graphQLFriendshipStatus)) {
            profileListFriendingController.f18270g.setText(resources.getString(2131233234));
        } else if (i > 0) {
            profileListFriendingController.f18270g.setText(resources.getQuantityString(2131689520, i, new Object[]{Integer.valueOf(i)}));
        } else {
            profileListFriendingController.f18270g.setVisibility(8);
        }
        profileListFriendingController.f18271h.mo1389a(profileListFriendingController.f18269f, graphQLFriendshipStatus);
        profileListFriendingController.f18269f.setEnabled(true);
        profileListFriendingController.f18269f.setOnClickListener(new OnClickListener(profileListFriendingController) {
            final /* synthetic */ ProfileListFriendingController f18262b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 120983424);
                this.f18262b.f18269f.setEnabled(false);
                this.f18262b.f18267d.m16736a(Long.parseLong(this.f18262b.f18268e.g()), this.f18262b.f18268e.C_(), FriendingLocation.PROFILE_BROWSER, graphQLFriendshipStatus);
                Logger.a(2, EntryType.UI_INPUT_END, -1290056737, a);
            }
        });
    }

    public final void m26796a(boolean z) {
        this.f18267d.f10563d = z;
    }

    public final FriendshipStatusChangedEventSubscriber m26793a() {
        return new FriendshipStatusChangedEventSubscriber(this);
    }
}
