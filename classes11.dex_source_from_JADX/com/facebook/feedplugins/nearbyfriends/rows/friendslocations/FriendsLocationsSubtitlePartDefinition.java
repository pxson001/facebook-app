package com.facebook.feedplugins.nearbyfriends.rows.friendslocations;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.nearbyfriends.rows.ui.FriendsNearbyFeedUnitSubtitleView;
import com.facebook.graphql.model.GraphQLFriendsLocationsFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: com.facebook.appmanager */
public class FriendsLocationsSubtitlePartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLFriendsLocationsFeedUnit>, String, HasPositionInformation, FriendsNearbyFeedUnitSubtitleView> {
    public static final ViewType f8543a = new C10561();
    private static FriendsLocationsSubtitlePartDefinition f8544d;
    private static final Object f8545e = new Object();
    private final BackgroundPartDefinition f8546b;
    private final DefaultPaddingStyleResolver f8547c;

    /* compiled from: com.facebook.appmanager */
    final class C10561 extends ViewType {
        C10561() {
        }

        public final View m9398a(Context context) {
            return new FriendsNearbyFeedUnitSubtitleView(context);
        }
    }

    private static FriendsLocationsSubtitlePartDefinition m9400b(InjectorLike injectorLike) {
        return new FriendsLocationsSubtitlePartDefinition(BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike));
    }

    public final Object m9402a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit = (GraphQLFriendsLocationsFeedUnit) feedProps.a;
        BackgroundPartDefinition backgroundPartDefinition = this.f8546b;
        DefaultPaddingStyleResolver defaultPaddingStyleResolver = this.f8547c;
        Builder a = Builder.a();
        a.b = -defaultPaddingStyleResolver.d();
        a = a;
        a.c = -defaultPaddingStyleResolver.e();
        subParts.a(backgroundPartDefinition, new StylingData(feedProps, a.i()));
        return graphQLFriendsLocationsFeedUnit.o() == null ? "" : graphQLFriendsLocationsFeedUnit.o().a();
    }

    public final /* bridge */ /* synthetic */ void m9403a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 2144323573);
        ((FriendsNearbyFeedUnitSubtitleView) view).f8568a.setText((String) obj2);
        Logger.a(8, EntryType.MARK_POP, 1555619778, a);
    }

    @Inject
    public FriendsLocationsSubtitlePartDefinition(BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver) {
        this.f8546b = backgroundPartDefinition;
        this.f8547c = defaultPaddingStyleResolver;
    }

    public final ViewType m9401a() {
        return f8543a;
    }

    public final boolean m9404a(Object obj) {
        return true;
    }

    public static FriendsLocationsSubtitlePartDefinition m9399a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendsLocationsSubtitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8545e) {
                FriendsLocationsSubtitlePartDefinition friendsLocationsSubtitlePartDefinition;
                if (a2 != null) {
                    friendsLocationsSubtitlePartDefinition = (FriendsLocationsSubtitlePartDefinition) a2.a(f8545e);
                } else {
                    friendsLocationsSubtitlePartDefinition = f8544d;
                }
                if (friendsLocationsSubtitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9400b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8545e, b3);
                        } else {
                            f8544d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendsLocationsSubtitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
