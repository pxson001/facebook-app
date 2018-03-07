package com.facebook.timeline.protiles.rows;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLProfileTileSectionType;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
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
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.protiles.events.ProtilesActionEvent;
import com.facebook.timeline.protiles.model.ProtileModel;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileItemFieldsModel;
import com.facebook.timeline.protiles.util.ProtilesClickHandler;
import com.facebook.timeline.protiles.util.ProtilesFriendingUtil;
import com.facebook.timeline.protiles.util.ProtilesImageUtil;
import com.facebook.timeline.protiles.views.ProtilesFriendView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: fc_tab */
public class ProtilesGridPhotoHeaderPartDefinition<E extends CanFriendPerson & HasImageLoadListener & HasPrefetcher> extends BaseSinglePartDefinition<Props, State, E, CustomLinearLayout> {
    private static ProtilesGridPhotoHeaderPartDefinition f12239g;
    private static final Object f12240h = new Object();
    private final Resources f12241a;
    public final EventsStream f12242b;
    public final ProtilesClickHandler f12243c;
    private final ProtilesFriendingUtil f12244d;
    private final Provider<FbDraweeControllerBuilder> f12245e;
    private final QeAccessor f12246f;

    /* compiled from: fc_tab */
    /* synthetic */ class C17382 {
        static final /* synthetic */ int[] f12223a = new int[GraphQLProfileTileSectionType.values().length];

        static {
            try {
                f12223a[GraphQLProfileTileSectionType.PHOTOS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12223a[GraphQLProfileTileSectionType.FRIENDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: fc_tab */
    public class Props {
        public final ProtileModel f12224a;
        public final ProtileItemFieldsModel f12225b;
        public final int f12226c;
        public final int f12227d;
        public final CallerContext f12228e;

        public Props(ProtileModel protileModel, ProtileItemFieldsModel protileItemFieldsModel, int i, int i2, CallerContext callerContext) {
            this.f12224a = protileModel;
            this.f12225b = protileItemFieldsModel;
            this.f12226c = i;
            this.f12227d = i2;
            this.f12228e = callerContext;
        }
    }

    /* compiled from: fc_tab */
    public class State {
        public final DraweeController f12229a;
        public final PointF f12230b;
        public final String f12231c;
        public final GraphQLFriendshipStatus f12232d;
        public final Drawable f12233e;
        public final int f12234f;
        public final String f12235g;
        public final String f12236h;
        public final OnClickListener f12237i;
        public final OnClickListener f12238j;

        public State(DraweeController draweeController, PointF pointF, String str, GraphQLFriendshipStatus graphQLFriendshipStatus, Drawable drawable, int i, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
            this.f12229a = draweeController;
            this.f12230b = pointF;
            this.f12231c = str;
            this.f12232d = graphQLFriendshipStatus;
            this.f12233e = drawable;
            this.f12234f = i;
            this.f12235g = str2;
            this.f12236h = str3;
            this.f12237i = onClickListener;
            this.f12238j = onClickListener2;
        }
    }

    private static ProtilesGridPhotoHeaderPartDefinition m12314b(InjectorLike injectorLike) {
        return new ProtilesGridPhotoHeaderPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), EventsStream.a(injectorLike), ProtilesClickHandler.m12399a(injectorLike), ProtilesFriendingUtil.m12411a(injectorLike), IdBasedProvider.a(injectorLike, 1117), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m12316a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -275755473);
        Props props = (Props) obj;
        State state = (State) obj2;
        ProtilesFriendView protilesFriendView = (ProtilesFriendView) ((CustomLinearLayout) view).getChildAt(props.f12226c);
        protilesFriendView.setVisibility(0);
        int i = props.f12227d;
        LayoutParams layoutParams = protilesFriendView.f12409e.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        protilesFriendView.setProfilePictureController(state.f12229a);
        ((GenericDraweeHierarchy) protilesFriendView.f12407c.getHierarchy()).a(state.f12230b);
        protilesFriendView.f12408d.setImageDrawable(state.f12233e);
        protilesFriendView.f12408d.setVisibility(state.f12234f);
        protilesFriendView.f12407c.setContentDescription(state.f12235g);
        protilesFriendView.f12408d.setContentDescription(state.f12236h);
        protilesFriendView.setOnClickListener(state.f12237i);
        protilesFriendView.setOnAddFriendClickListener(state.f12238j);
        Logger.a(8, EntryType.MARK_POP, 1458267989, a);
    }

    public final void m12317b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ProtilesFriendView protilesFriendView = (ProtilesFriendView) ((CustomLinearLayout) view).getChildAt(((Props) obj).f12226c);
        protilesFriendView.setProfilePictureController(null);
        protilesFriendView.setOnClickListener(null);
        protilesFriendView.setOnAddFriendClickListener(null);
        protilesFriendView.setVisibility(8);
    }

    public static ProtilesGridPhotoHeaderPartDefinition m12312a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesGridPhotoHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12240h) {
                ProtilesGridPhotoHeaderPartDefinition protilesGridPhotoHeaderPartDefinition;
                if (a2 != null) {
                    protilesGridPhotoHeaderPartDefinition = (ProtilesGridPhotoHeaderPartDefinition) a2.a(f12240h);
                } else {
                    protilesGridPhotoHeaderPartDefinition = f12239g;
                }
                if (protilesGridPhotoHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12314b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12240h, b3);
                        } else {
                            f12239g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesGridPhotoHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ProtilesGridPhotoHeaderPartDefinition(Resources resources, EventsStream eventsStream, ProtilesClickHandler protilesClickHandler, ProtilesFriendingUtil protilesFriendingUtil, Provider<FbDraweeControllerBuilder> provider, QeAccessor qeAccessor) {
        this.f12241a = resources;
        this.f12242b = eventsStream;
        this.f12243c = protilesClickHandler;
        this.f12244d = protilesFriendingUtil;
        this.f12245e = provider;
        this.f12246f = qeAccessor;
    }

    private State m12311a(Props props, E e) {
        ImageRequest a;
        GraphQLFriendshipStatus graphQLFriendshipStatus;
        ImageRequest a2 = m12310a(props.f12225b);
        DefaultImageFields a3 = ProtilesImageUtil.m12422a(props.f12225b, props.f12224a.m12109b());
        if (a3 != null) {
            a = ImageRequest.a(a3.b());
        } else {
            a = null;
        }
        DraweeController a4 = m12309a(a2, a, props.f12228e);
        if (a != null) {
            ((HasImageLoadListener) e).a(a4, props.f12224a.m12107a(), a);
        }
        if (this.f12246f.a(ExperimentsForTimelineAbTestModule.aw, false)) {
            ((HasPrefetcher) e).a(a2, props.f12228e);
            ((HasPrefetcher) e).a(a, props.f12228e);
        }
        PointF a5 = ProtilesImageUtil.m12420a(props.f12225b);
        String a6 = props.f12225b.m12182d() != null ? props.f12225b.m12182d().m12176a() : null;
        String g = props.f12224a.m12114g();
        if (props.f12225b.m12180b() == null || props.f12225b.m12180b().m12156m() == null) {
            graphQLFriendshipStatus = GraphQLFriendshipStatus.CANNOT_REQUEST;
        } else {
            graphQLFriendshipStatus = props.f12225b.m12180b().m12156m();
        }
        Drawable a7 = this.f12244d.m12415a(graphQLFriendshipStatus);
        int c = ProtilesFriendingUtil.m12414c(graphQLFriendshipStatus);
        return new State(a4, a5, g, graphQLFriendshipStatus, a7, c, m12313a(props.f12224a.m12109b(), props.f12226c, a6), this.f12244d.m12418d(graphQLFriendshipStatus), m12308a(props.f12225b, props.f12224a, a3, a6, g), c == 8 ? null : this.f12244d.m12416a(props.f12224a, props.f12225b, e));
    }

    private DraweeController m12309a(ImageRequest imageRequest, ImageRequest imageRequest2, CallerContext callerContext) {
        return ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f12245e.get()).a(callerContext).d(imageRequest)).c(imageRequest2)).r().s();
    }

    @Nullable
    private static ImageRequest m12310a(ProtileItemFieldsModel protileItemFieldsModel) {
        if (protileItemFieldsModel.m12180b() == null || protileItemFieldsModel.m12180b().m12157n() == null || protileItemFieldsModel.m12180b().m12157n().b() == null) {
            return null;
        }
        ImageRequestBuilder a = ImageRequestBuilder.a(Uri.parse(protileItemFieldsModel.m12180b().m12157n().b()));
        a.b = RequestLevel.DISK_CACHE;
        return a.m();
    }

    private String m12313a(GraphQLProfileTileSectionType graphQLProfileTileSectionType, int i, String str) {
        if (graphQLProfileTileSectionType == GraphQLProfileTileSectionType.FRIENDS) {
            return str;
        }
        if (graphQLProfileTileSectionType != GraphQLProfileTileSectionType.PHOTOS) {
            return "";
        }
        return StringLocaleUtil.a(this.f12241a.getString(2131241408), new Object[]{Integer.valueOf(i + 1)});
    }

    private OnClickListener m12308a(ProtileItemFieldsModel protileItemFieldsModel, ProtileModel protileModel, @Nullable DefaultImageFields defaultImageFields, String str, String str2) {
        if (protileItemFieldsModel.m12180b() == null) {
            return null;
        }
        final ProtileItemFieldsModel protileItemFieldsModel2 = protileItemFieldsModel;
        final ProtileModel protileModel2 = protileModel;
        final DefaultImageFields defaultImageFields2 = defaultImageFields;
        final String str3 = str;
        final String str4 = str2;
        return new OnClickListener(this) {
            public final /* synthetic */ ProtilesGridPhotoHeaderPartDefinition f12222f;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -474674762);
                String d = protileItemFieldsModel2.m12180b().m12151d();
                switch (C17382.f12223a[protileModel2.m12109b().ordinal()]) {
                    case 1:
                        Preconditions.checkArgument(view instanceof FbDraweeView);
                        this.f12222f.f12243c.m12403a((FbDraweeView) view, d, defaultImageFields2, str4, protileModel2);
                        break;
                    case 2:
                        boolean z = protileItemFieldsModel2.m12180b() != null && protileItemFieldsModel2.m12180b().m12158o() > 0;
                        this.f12222f.f12243c.m12402a(view.getContext(), d, defaultImageFields2, str3, protileItemFieldsModel2.m12180b().m12156m(), z);
                        break;
                }
                this.f12222f.f12242b.a(ProtilesActionEvent.m12101a(protileModel2, protileItemFieldsModel2));
                LogUtils.a(1808083740, a);
            }
        };
    }
}
