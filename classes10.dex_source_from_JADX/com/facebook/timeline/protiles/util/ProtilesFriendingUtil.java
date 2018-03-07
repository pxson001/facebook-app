package com.facebook.timeline.protiles.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.CanFriendPerson.FriendshipStatus;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.controllers.interfaces.FriendingButtonControllerCallback;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.protiles.model.ProtileModel;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileItemFieldsModel;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileItemFieldsModel.NodeModel;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fb4a_reg_name_locale_order */
public class ProtilesFriendingUtil {
    private static ProtilesFriendingUtil f12378c;
    private static final Object f12379d = new Object();
    public final Resources f12380a;
    private final FriendingEventBus f12381b;

    /* compiled from: fb4a_reg_name_locale_order */
    /* synthetic */ class C17542 {
        static final /* synthetic */ int[] f12377a = new int[GraphQLFriendshipStatus.values().length];

        static {
            try {
                f12377a[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12377a[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f12377a[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f12377a[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private static ProtilesFriendingUtil m12413b(InjectorLike injectorLike) {
        return new ProtilesFriendingUtil(ResourcesMethodAutoProvider.a(injectorLike), FriendingEventBus.a(injectorLike));
    }

    @Inject
    public ProtilesFriendingUtil(Resources resources, FriendingEventBus friendingEventBus) {
        this.f12380a = resources;
        this.f12381b = friendingEventBus;
    }

    @Nullable
    public final Drawable m12415a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        switch (C17542.f12377a[graphQLFriendshipStatus.ordinal()]) {
            case 1:
                return this.f12380a.getDrawable(2130840434);
            case 2:
                return this.f12380a.getDrawable(2130840419);
            case 3:
                Drawable drawable = this.f12380a.getDrawable(2130840439);
                if (drawable == null) {
                    return drawable;
                }
                drawable.setColorFilter(new PorterDuffColorFilter(this.f12380a.getColor(2131361917), Mode.SRC_IN));
                return drawable;
            default:
                return null;
        }
    }

    @Nullable
    public final Drawable m12417b(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        switch (C17542.f12377a[graphQLFriendshipStatus.ordinal()]) {
            case 1:
                return m12410a(this.f12380a.getDrawable(2130839879));
            case 2:
                return m12410a(this.f12380a.getDrawable(2130839877));
            case 3:
                return m12410a(this.f12380a.getDrawable(2130839892));
            case 4:
                Drawable drawable = this.f12380a.getDrawable(2130839882);
                drawable.setColorFilter(new PorterDuffColorFilter(this.f12380a.getColor(2131362104), Mode.SRC_IN));
                return drawable;
            default:
                return null;
        }
    }

    public static ProtilesFriendingUtil m12411a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesFriendingUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12379d) {
                ProtilesFriendingUtil protilesFriendingUtil;
                if (a2 != null) {
                    protilesFriendingUtil = (ProtilesFriendingUtil) a2.a(f12379d);
                } else {
                    protilesFriendingUtil = f12378c;
                }
                if (protilesFriendingUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12413b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12379d, b3);
                        } else {
                            f12378c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesFriendingUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private Drawable m12410a(Drawable drawable) {
        drawable.setColorFilter(new PorterDuffColorFilter(this.f12380a.getColor(2131361916), Mode.SRC_IN));
        return drawable;
    }

    public static int m12414c(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        switch (C17542.f12377a[graphQLFriendshipStatus.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return 0;
            default:
                return 8;
        }
    }

    public final String m12418d(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        switch (C17542.f12377a[graphQLFriendshipStatus.ordinal()]) {
            case 1:
                return this.f12380a.getString(2131241402);
            case 2:
                return this.f12380a.getString(2131241400);
            case 3:
                return this.f12380a.getString(2131241401);
            default:
                return "";
        }
    }

    public final OnClickListener m12416a(final ProtileModel protileModel, ProtileItemFieldsModel protileItemFieldsModel, final CanFriendPerson canFriendPerson) {
        final NodeModel b = protileItemFieldsModel.m12180b();
        if (b == null || b.m12151d() == null || b.m12156m() == null) {
            return null;
        }
        return new OnClickListener(this) {
            final /* synthetic */ ProtilesFriendingUtil f12376d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -854608408);
                final GraphQLFriendshipStatus m = b.m12156m();
                final String d = b.m12151d();
                FriendshipStatus a2 = canFriendPerson.a(d, protileModel.m12111d(), FriendingLocation.PROTILES, m, new FriendingButtonControllerCallback(this) {
                    final /* synthetic */ C17531 f12372c;

                    public final void m12409a() {
                        protileModel.m12108a(d, m);
                        ProtilesFriendingUtil.m12412a(this.f12372c.f12376d, Long.parseLong(d), m, false);
                    }
                });
                protileModel.m12108a(d, a2.a);
                ProtilesFriendingUtil.m12412a(this.f12376d, Long.parseLong(d), a2.a, true);
                Logger.a(2, EntryType.UI_INPUT_END, 599881515, a);
            }
        };
    }

    public static void m12412a(ProtilesFriendingUtil protilesFriendingUtil, long j, GraphQLFriendshipStatus graphQLFriendshipStatus, boolean z) {
        protilesFriendingUtil.f12381b.a(new FriendshipStatusChangedEvent(j, graphQLFriendshipStatus, z));
    }
}
