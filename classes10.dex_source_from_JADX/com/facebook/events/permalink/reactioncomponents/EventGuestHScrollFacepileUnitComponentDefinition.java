package com.facebook.events.permalink.reactioncomponents;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.facepile.Face;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLReactionProfileBadgeType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.common.ReactionFacepilePartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionFacepileProfile;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitBadgedProfilesComponentFragment.BadgableProfiles;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitBadgedProfilesComponentFragmentModel.BadgableProfilesModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: background_location_settings_perf_render */
public class EventGuestHScrollFacepileUnitComponentDefinition<E extends HasReactionSession & CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, FacepileView> {
    public static final ViewType<FacepileView> f18818a = new C26731();
    private static EventGuestHScrollFacepileUnitComponentDefinition f18819d;
    private static final Object f18820e = new Object();
    private final ReactionFacepilePartDefinition f18821b;
    private final BasicReactionActionPartDefinition f18822c;

    /* compiled from: background_location_settings_perf_render */
    final class C26731 extends ViewType<FacepileView> {
        C26731() {
        }

        public final View m19116a(Context context) {
            return (FacepileView) LayoutInflater.from(context).inflate(2130906637, null);
        }
    }

    /* compiled from: background_location_settings_perf_render */
    public /* synthetic */ class C26742 {
        public static final /* synthetic */ int[] f18817a = new int[GraphQLReactionProfileBadgeType.values().length];

        static {
            try {
                f18817a[GraphQLReactionProfileBadgeType.GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18817a[GraphQLReactionProfileBadgeType.INTERESTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18817a[GraphQLReactionProfileBadgeType.MAYBE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static EventGuestHScrollFacepileUnitComponentDefinition m19119b(InjectorLike injectorLike) {
        return new EventGuestHScrollFacepileUnitComponentDefinition(ReactionFacepilePartDefinition.a(injectorLike), BasicReactionActionPartDefinition.a(injectorLike));
    }

    public final Object m19121a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        HasReactionSession hasReactionSession = (HasReactionSession) anyEnvironment;
        ReactionStoryAttachmentActionFragmentModel v = reactionUnitComponentNode.b.v();
        subParts.a(this.f18821b, m19118a(((HasContext) hasReactionSession).getContext().getResources(), reactionUnitComponentNode.b.I()));
        if (v != null) {
            subParts.a(this.f18822c, new Props(v, reactionUnitComponentNode.c, reactionUnitComponentNode.d));
        }
        return null;
    }

    public final boolean m19122a(Object obj) {
        ImmutableList I = ((ReactionUnitComponentNode) obj).b.I();
        boolean z = false;
        if (I.size() != 0) {
            for (int i = 0; i < Math.min(8, I.size()); i++) {
                ReactionFacepileProfile b = ((BadgableProfilesModel) I.get(i)).b();
                if (b == null || b.d() == null || Strings.isNullOrEmpty(b.d().b())) {
                    break;
                }
            }
            z = true;
        }
        return z;
    }

    public static EventGuestHScrollFacepileUnitComponentDefinition m19117a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventGuestHScrollFacepileUnitComponentDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18820e) {
                EventGuestHScrollFacepileUnitComponentDefinition eventGuestHScrollFacepileUnitComponentDefinition;
                if (a2 != null) {
                    eventGuestHScrollFacepileUnitComponentDefinition = (EventGuestHScrollFacepileUnitComponentDefinition) a2.a(f18820e);
                } else {
                    eventGuestHScrollFacepileUnitComponentDefinition = f18819d;
                }
                if (eventGuestHScrollFacepileUnitComponentDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m19119b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18820e, b3);
                        } else {
                            f18819d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = eventGuestHScrollFacepileUnitComponentDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public EventGuestHScrollFacepileUnitComponentDefinition(ReactionFacepilePartDefinition reactionFacepilePartDefinition, BasicReactionActionPartDefinition basicReactionActionPartDefinition) {
        this.f18821b = reactionFacepilePartDefinition;
        this.f18822c = basicReactionActionPartDefinition;
    }

    public final ViewType<FacepileView> m19120a() {
        return f18818a;
    }

    private static ImmutableList<Face> m19118a(Resources resources, ImmutableList<? extends BadgableProfiles> immutableList) {
        Builder builder = new Builder();
        int min = Math.min(8, immutableList.size());
        for (int i = 0; i < min; i++) {
            Drawable drawable;
            BadgableProfilesModel badgableProfilesModel = (BadgableProfilesModel) immutableList.get(i);
            Uri parse = Uri.parse(badgableProfilesModel.b().d().b());
            switch (C26742.f18817a[badgableProfilesModel.a().ordinal()]) {
                case 1:
                    drawable = resources.getDrawable(2130837772);
                    break;
                case 2:
                    drawable = resources.getDrawable(2130837773);
                    break;
                case 3:
                    drawable = resources.getDrawable(2130837774);
                    break;
                default:
                    drawable = null;
                    break;
            }
            builder.c(new Face(parse, drawable));
        }
        return builder.b();
    }
}
