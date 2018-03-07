package com.facebook.feedplugins.fitness;

import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.MapOverlayMarker;
import com.facebook.maps.MapOverlayTextMarker;
import com.facebook.maps.MapWithOverlay;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: didCompleteNetworkResponse */
public class FitnessMapPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, HasPositionInformation, FitnessMapView> {
    public static final ViewType f7621a = new C09711();
    private static FitnessMapPartDefinition f7622e;
    private static final Object f7623f = new Object();
    private final BackgroundPartDefinition f7624b;
    private final Resources f7625c;
    private final FitnessAttachmentUtils f7626d;

    /* compiled from: didCompleteNetworkResponse */
    final class C09711 extends ViewType {
        C09711() {
        }

        public final View m8839a(Context context) {
            return new FitnessMapView(context);
        }
    }

    /* compiled from: didCompleteNetworkResponse */
    public class State {
        public final int f7612a;
        public final int f7613b;
        public final int f7614c;
        public final int f7615d;
        public final int f7616e;
        public final int f7617f;
        public final int f7618g;
        public final ImmutableList<Location> f7619h;
        public final ImmutableList<MapOverlayMarker> f7620i;

        public State(int i, int i2, int i3, int i4, int i5, int i6, int i7, ImmutableList<Location> immutableList, ImmutableList<MapOverlayMarker> immutableList2) {
            this.f7612a = i;
            this.f7613b = i2;
            this.f7614c = i3;
            this.f7615d = i4;
            this.f7616e = i5;
            this.f7617f = i6;
            this.f7618g = i7;
            this.f7619h = immutableList;
            this.f7620i = immutableList2;
        }
    }

    private static FitnessMapPartDefinition m8843b(InjectorLike injectorLike) {
        return new FitnessMapPartDefinition(BackgroundPartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), FitnessAttachmentUtils.m8837b(injectorLike));
    }

    public final Object m8845a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(this.f7624b, new StylingData(AttachmentProps.e(feedProps), PaddingStyle.a));
        int dimensionPixelSize = this.f7625c.getDimensionPixelSize(2131430249);
        String string = this.f7625c.getString(2131235576);
        String string2 = this.f7625c.getString(2131235577);
        String string3 = this.f7625c.getString(2131235578);
        ImmutableList a = FitnessAttachmentUtils.m8835a(graphQLStoryAttachment.z().fZ().eu(), 100);
        Location location = (Location) a.get(0);
        Location location2 = (Location) a.get(a.size() - 1);
        Builder builder = ImmutableList.builder();
        if (FitnessAttachmentUtils.m8836a(location, location2)) {
            builder.c(m8841a(location));
            builder.c(m8842a(location, string3, dimensionPixelSize));
        } else {
            builder.c(m8841a(location));
            builder.c(m8842a(location, string, dimensionPixelSize));
            builder.c(m8841a(location2));
            builder.c(m8842a(location2, string2, dimensionPixelSize));
        }
        return new State(this.f7625c.getColor(2131363070), this.f7625c.getDimensionPixelSize(2131430242), this.f7625c.getColor(2131363071), this.f7625c.getDimensionPixelSize(2131430243), this.f7625c.getDimensionPixelSize(2131430247), this.f7625c.getDimensionPixelSize(2131430248), dimensionPixelSize, a, builder.b());
    }

    public final /* bridge */ /* synthetic */ void m8846a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1021665019);
        State state = (State) obj2;
        MapWithOverlay mapWithOverlay = ((FitnessMapView) view).f7627a;
        mapWithOverlay.b();
        mapWithOverlay.setMapSurface("fitness_story");
        mapWithOverlay.a(state.f7616e, state.f7617f, state.f7616e, state.f7617f);
        mapWithOverlay.a(state.f7619h, state.f7612a, state.f7613b, state.f7614c, state.f7615d);
        mapWithOverlay.a(state.f7620i);
        Logger.a(8, EntryType.MARK_POP, 322638992, a);
    }

    public static FitnessMapPartDefinition m8840a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FitnessMapPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7623f) {
                FitnessMapPartDefinition fitnessMapPartDefinition;
                if (a2 != null) {
                    fitnessMapPartDefinition = (FitnessMapPartDefinition) a2.a(f7623f);
                } else {
                    fitnessMapPartDefinition = f7622e;
                }
                if (fitnessMapPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8843b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7623f, b3);
                        } else {
                            f7622e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = fitnessMapPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FitnessMapPartDefinition(BackgroundPartDefinition backgroundPartDefinition, Resources resources, FitnessAttachmentUtils fitnessAttachmentUtils) {
        this.f7624b = backgroundPartDefinition;
        this.f7625c = resources;
        this.f7626d = fitnessAttachmentUtils;
    }

    public final ViewType m8844a() {
        return f7621a;
    }

    public final boolean m8847a(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        boolean z = (graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().fZ() == null || graphQLStoryAttachment.z().fZ().eu() == null || graphQLStoryAttachment.z().fZ().eu().size() < 2) ? false : true;
        return z;
    }

    private MapOverlayTextMarker m8842a(Location location, String str, int i) {
        return new MapOverlayTextMarker(this.f7625c, location, str, i);
    }

    private MapOverlayCircularEndpointPinMarker m8841a(Location location) {
        return new MapOverlayCircularEndpointPinMarker(this.f7625c, location);
    }
}
