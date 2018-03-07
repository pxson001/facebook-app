package com.facebook.messaging.events.banner;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.graphql.enums.GraphQLLightweightEventGuestStatus;
import com.facebook.messaging.photos.tiles.UserTileViewParamsFactory;
import com.facebook.user.model.User;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.tiles.TileBadge;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: specific_item_types */
public class EventReminderFacepileRecyclerViewAdapter extends Adapter<ViewHolder> {
    private UserTileViewParamsFactory f2302a;
    public int f2303b;
    public ImmutableList<User> f2304c;
    public ImmutableList<User> f2305d;
    public ImmutableList<User> f2306e;

    /* compiled from: specific_item_types */
    public /* synthetic */ class C03862 {
        public static final /* synthetic */ int[] f2299a = new int[GraphQLLightweightEventGuestStatus.values().length];

        static {
            try {
                f2299a[GraphQLLightweightEventGuestStatus.GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2299a[GraphQLLightweightEventGuestStatus.DECLINED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: specific_item_types */
    public class EventReminderMember {
        User f2300a;
        GraphQLLightweightEventGuestStatus f2301b;

        public EventReminderMember(User user, GraphQLLightweightEventGuestStatus graphQLLightweightEventGuestStatus) {
            this.f2300a = user;
            this.f2301b = graphQLLightweightEventGuestStatus;
        }
    }

    @Inject
    public EventReminderFacepileRecyclerViewAdapter(UserTileViewParamsFactory userTileViewParamsFactory) {
        this.f2302a = userTileViewParamsFactory;
    }

    public final ViewHolder m2167a(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130904091, viewGroup, false)) {
            final /* synthetic */ EventReminderFacepileRecyclerViewAdapter f2298l;
        };
    }

    public final void m2168a(ViewHolder viewHolder, int i) {
        if (i < aZ_()) {
            EventReminderMember eventReminderMember;
            if (i < this.f2304c.size()) {
                eventReminderMember = new EventReminderMember((User) this.f2304c.get(i), GraphQLLightweightEventGuestStatus.GOING);
            } else {
                int size = i - this.f2304c.size();
                if (size < this.f2305d.size()) {
                    eventReminderMember = new EventReminderMember((User) this.f2305d.get(size), GraphQLLightweightEventGuestStatus.DECLINED);
                } else {
                    size -= this.f2305d.size();
                    eventReminderMember = size < this.f2306e.size() ? new EventReminderMember((User) this.f2306e.get(size), GraphQLLightweightEventGuestStatus.INVITED) : null;
                }
            }
            EventReminderMember eventReminderMember2 = eventReminderMember;
            if (eventReminderMember2 != null) {
                TileBadge tileBadge;
                UserTileViewParams b;
                View view = viewHolder.a;
                UserTileView userTileView = (UserTileView) view.findViewById(2131561374);
                User user = eventReminderMember2.f2300a;
                switch (C03862.f2299a[eventReminderMember2.f2301b.ordinal()]) {
                    case 1:
                        tileBadge = TileBadge.EVENT_REMINDER_GOING;
                        break;
                    case 2:
                        tileBadge = TileBadge.EVENT_REMINDER_DECLINED;
                        break;
                    default:
                        tileBadge = TileBadge.NONE;
                        break;
                }
                TileBadge tileBadge2 = tileBadge;
                if (user.ao()) {
                    b = UserTileViewParams.b(user, tileBadge2);
                } else {
                    b = UserTileViewParams.a(user, tileBadge2);
                }
                userTileView.setParams(b);
                ((BetterTextView) view.findViewById(2131561375)).setText(eventReminderMember2.f2300a.h());
            }
        }
    }

    public final int aZ_() {
        return this.f2303b;
    }
}
