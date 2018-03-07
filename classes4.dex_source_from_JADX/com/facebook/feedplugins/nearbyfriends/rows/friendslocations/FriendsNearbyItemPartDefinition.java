package com.facebook.feedplugins.nearbyfriends.rows.friendslocations;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feedplugins.nearbyfriends.rows.ui.FriendsLocationsPageView;
import com.facebook.graphql.enums.GraphQLFriendLocationCategory;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.conversion.FeedUnitItemProfileHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: null_homestories */
public class FriendsNearbyItemPartDefinition extends BaseSinglePartDefinitionWithViewType<Props, State, AnyEnvironment, FriendsLocationsPageView> {
    public static final ViewType<FriendsLocationsPageView> f6649a = new C03041();
    public static final CallerContext f6650b = CallerContext.a(FriendsNearbyItemPartDefinition.class, "native_newsfeed");
    private static FriendsNearbyItemPartDefinition f6651g;
    private static final Object f6652h = new Object();
    private final FriendsLocationsProfilePagePartDefinition f6653c;
    private final FriendsLocationsAuraPagePartDefinition f6654d;
    private final FriendsLocationsCheckinPagePartDefinition f6655e;
    public final Provider<FbDraweeControllerBuilder> f6656f;

    /* compiled from: null_homestories */
    final class C03041 extends ViewType<FriendsLocationsPageView> {
        C03041() {
        }

        public final View m7058a(Context context) {
            return new FriendsLocationsPageView(context);
        }
    }

    private static FriendsNearbyItemPartDefinition m7053b(InjectorLike injectorLike) {
        return new FriendsNearbyItemPartDefinition(FriendsLocationsProfilePagePartDefinition.a(injectorLike), FriendsLocationsAuraPagePartDefinition.a(injectorLike), FriendsLocationsCheckinPagePartDefinition.a(injectorLike), IdBasedProvider.a(injectorLike, 1117));
    }

    public final Object m7055a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean z;
        Props props = (Props) obj;
        GraphQLFriendLocationCategory m = props.b.m();
        if (m == GraphQLFriendLocationCategory.CHECKIN) {
            subParts.a(this.f6655e, props);
        } else if (m == GraphQLFriendLocationCategory.APPROXIMATE_LOCATION || m == GraphQLFriendLocationCategory.CURRENT_CITY) {
            subParts.a(this.f6654d, props);
        } else {
            subParts.a(this.f6653c, props);
        }
        StaticMapOptions b = m7052b(props);
        FbPipelineDraweeController fbPipelineDraweeController = null;
        GraphQLFriendLocationCategory m2 = props.b.m();
        if (!(m2 == GraphQLFriendLocationCategory.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || m2 == GraphQLFriendLocationCategory.PRESENCE)) {
            GraphQLImage graphQLImage;
            GraphQLProfile a = FeedUnitItemProfileHelper.a(props.b);
            if (a == null || !GraphQLHelper.a(a)) {
                graphQLImage = null;
            } else {
                graphQLImage = a.ai();
            }
            GraphQLImage graphQLImage2 = graphQLImage;
            if (graphQLImage2 != null) {
                fbPipelineDraweeController = ((FbDraweeControllerBuilder) this.f6656f.get()).a(f6650b).b(Uri.parse(graphQLImage2.b())).s();
            }
        }
        DraweeController draweeController = fbPipelineDraweeController;
        if (props.b.m() == GraphQLFriendLocationCategory.APPROXIMATE_LOCATION) {
            z = true;
        } else {
            z = false;
        }
        return new State(b, draweeController, z);
    }

    public final /* bridge */ /* synthetic */ void m7056a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 593406195);
        State state = (State) obj2;
        FriendsLocationsPageView friendsLocationsPageView = (FriendsLocationsPageView) view;
        friendsLocationsPageView.setPageCoverMap(state.a);
        friendsLocationsPageView.setCenterImage(state.b);
        friendsLocationsPageView.c.setVisibility(state.c ? 0 : 8);
        Logger.a(8, EntryType.MARK_POP, -447579719, a);
    }

    public final void m7057b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        FriendsLocationsPageView friendsLocationsPageView = (FriendsLocationsPageView) view;
        friendsLocationsPageView.setPageCoverMap(null);
        friendsLocationsPageView.setCenterImage(null);
    }

    public static FriendsNearbyItemPartDefinition m7051a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendsNearbyItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6652h) {
                FriendsNearbyItemPartDefinition friendsNearbyItemPartDefinition;
                if (a2 != null) {
                    friendsNearbyItemPartDefinition = (FriendsNearbyItemPartDefinition) a2.a(f6652h);
                } else {
                    friendsNearbyItemPartDefinition = f6651g;
                }
                if (friendsNearbyItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7053b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6652h, b3);
                        } else {
                            f6651g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendsNearbyItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FriendsNearbyItemPartDefinition(FriendsLocationsProfilePagePartDefinition friendsLocationsProfilePagePartDefinition, FriendsLocationsAuraPagePartDefinition friendsLocationsAuraPagePartDefinition, FriendsLocationsCheckinPagePartDefinition friendsLocationsCheckinPagePartDefinition, Provider<FbDraweeControllerBuilder> provider) {
        this.f6653c = friendsLocationsProfilePagePartDefinition;
        this.f6654d = friendsLocationsAuraPagePartDefinition;
        this.f6655e = friendsLocationsCheckinPagePartDefinition;
        this.f6656f = provider;
    }

    public final ViewType<FriendsLocationsPageView> m7054a() {
        return f6649a;
    }

    private StaticMapOptions m7052b(Props props) {
        GraphQLFriendLocationCategory m = props.b.m();
        GraphQLLocation j = props.b.j();
        if (m == GraphQLFriendLocationCategory.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || m == GraphQLFriendLocationCategory.PRESENCE || j == null) {
            return null;
        }
        StaticMapOptions a = new StaticMapOptions("friends_nearby_ego_unit").m14294a(j.a(), j.b());
        int p = (int) props.b.p();
        int i = 10;
        int i2 = 11;
        while (i2 > 1) {
            if (p <= i) {
                break;
            }
            i2--;
            i *= 2;
        }
        i2 = 1;
        return a.m14296a(i2);
    }
}
