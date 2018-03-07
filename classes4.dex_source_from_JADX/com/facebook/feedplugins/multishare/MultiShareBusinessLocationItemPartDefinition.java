package com.facebook.feedplugins.multishare;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.android.maps.StaticMapView.Marker;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.android.maps.model.LatLng;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.multishare.ui.MultiShareMapItemView;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentStyleInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.mappin.MapMarkerImagePostProcessor;
import com.facebook.maps.rows.MapPartDefinition;
import com.facebook.maps.rows.MapPartDefinition.Props;
import com.facebook.maps.rows.PrefetchMapPartDefinition;
import com.facebook.maps.rows.StaticMapOptionsHelper;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: networks */
public class MultiShareBusinessLocationItemPartDefinition<E extends HasInvalidate & HasPrefetcher> extends BaseSinglePartDefinitionWithViewType<MultiShareAttachmentItemViewModel, FbPipelineDraweeController, E, MultiShareMapItemView> {
    private static final ViewType<MultiShareMapItemView> f7188a = new C03421();
    private static final CallerContext f7189b = CallerContext.a(MultiShareBusinessLocationItemPartDefinition.class);
    private static MultiShareBusinessLocationItemPartDefinition f7190l;
    private static final Object f7191m = new Object();
    private final BusinessLocationActionLinkClickListenerProvider f7192c;
    private final ClickListenerPartDefinition f7193d;
    private final MapPartDefinition f7194e;
    private final PrefetchMapPartDefinition f7195f;
    private final TextPartDefinition f7196g;
    private final BusinessActionButtonPartDefinition f7197h;
    private final MapMarkerImagePostProcessor f7198i;
    private final FbDraweeControllerBuilder f7199j;
    private final Resources f7200k;

    /* compiled from: networks */
    final class C03421 extends ViewType<MultiShareMapItemView> {
        C03421() {
        }

        public final View m7518a(Context context) {
            return new MultiShareMapItemView(context);
        }
    }

    private static MultiShareBusinessLocationItemPartDefinition m7513b(InjectorLike injectorLike) {
        return new MultiShareBusinessLocationItemPartDefinition((BusinessLocationActionLinkClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BusinessLocationActionLinkClickListenerProvider.class), ClickListenerPartDefinition.a(injectorLike), MapPartDefinition.m7476a(injectorLike), PrefetchMapPartDefinition.m7480a(injectorLike), TextPartDefinition.a(injectorLike), BusinessActionButtonPartDefinition.m7520a(injectorLike), MapMarkerImagePostProcessor.m7528b(injectorLike), FbDraweeControllerBuilder.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ Object m7515a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m7509a(subParts, (MultiShareAttachmentItemViewModel) obj);
    }

    public final /* bridge */ /* synthetic */ void m7516a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2112710466);
        FbPipelineDraweeController fbPipelineDraweeController = (FbPipelineDraweeController) obj2;
        MultiShareMapItemView multiShareMapItemView = (MultiShareMapItemView) view;
        int round = Math.round(((float) SizeUtil.a(multiShareMapItemView.getContext(), ((MultiShareAttachmentItemViewModel) obj).f13904h)) - (multiShareMapItemView.getResources().getDimension(2131429029) * 2.0f));
        LayoutParams layoutParams = multiShareMapItemView.b.getLayoutParams();
        layoutParams.width = round;
        layoutParams.height = round;
        multiShareMapItemView.b.setLayoutParams(layoutParams);
        multiShareMapItemView.setController(fbPipelineDraweeController);
        Logger.a(8, EntryType.MARK_POP, 1171280678, a);
    }

    public final void m7517b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((MultiShareMapItemView) view).setController(null);
    }

    public static MultiShareBusinessLocationItemPartDefinition m7510a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MultiShareBusinessLocationItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7191m) {
                MultiShareBusinessLocationItemPartDefinition multiShareBusinessLocationItemPartDefinition;
                if (a2 != null) {
                    multiShareBusinessLocationItemPartDefinition = (MultiShareBusinessLocationItemPartDefinition) a2.a(f7191m);
                } else {
                    multiShareBusinessLocationItemPartDefinition = f7190l;
                }
                if (multiShareBusinessLocationItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7513b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7191m, b3);
                        } else {
                            f7190l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = multiShareBusinessLocationItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public MultiShareBusinessLocationItemPartDefinition(BusinessLocationActionLinkClickListenerProvider businessLocationActionLinkClickListenerProvider, ClickListenerPartDefinition clickListenerPartDefinition, MapPartDefinition mapPartDefinition, PrefetchMapPartDefinition prefetchMapPartDefinition, TextPartDefinition textPartDefinition, BusinessActionButtonPartDefinition businessActionButtonPartDefinition, MapMarkerImagePostProcessor mapMarkerImagePostProcessor, FbDraweeControllerBuilder fbDraweeControllerBuilder, Resources resources) {
        this.f7192c = businessLocationActionLinkClickListenerProvider;
        this.f7193d = clickListenerPartDefinition;
        this.f7194e = mapPartDefinition;
        this.f7195f = prefetchMapPartDefinition;
        this.f7196g = textPartDefinition;
        this.f7197h = businessActionButtonPartDefinition;
        this.f7198i = mapMarkerImagePostProcessor;
        this.f7199j = fbDraweeControllerBuilder;
        this.f7200k = resources;
    }

    public final ViewType<MultiShareMapItemView> m7514a() {
        return f7188a;
    }

    private FbPipelineDraweeController m7509a(SubParts<E> subParts, MultiShareAttachmentItemViewModel multiShareAttachmentItemViewModel) {
        FeedProps feedProps = multiShareAttachmentItemViewModel.f13897a;
        FeedProps e = AttachmentProps.e(feedProps);
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a();
        GraphQLStoryActionLink a = ActionLinkHelper.a(graphQLStoryAttachment);
        GraphQLStoryAttachmentStyleInfo graphQLStoryAttachmentStyleInfo = (GraphQLStoryAttachmentStyleInfo) graphQLStoryAttachment.v().get(0);
        BusinessLocationActionLinkClickListener a2 = this.f7192c.m7519a(e, graphQLStoryAttachment.C(), multiShareAttachmentItemViewModel.m14695f());
        StaticMapOptions a3 = StaticMapOptionsHelper.m14455a(graphQLStoryAttachmentStyleInfo.j(), "business_location_story", graphQLStoryAttachmentStyleInfo.r());
        m7512a((SubParts) subParts, graphQLStoryAttachment);
        a3.m14300a(m7511a(graphQLStoryAttachmentStyleInfo));
        int a4 = SizeUtil.a(this.f7200k, multiShareAttachmentItemViewModel.m14696h());
        int a5 = SizeUtil.a(this.f7200k, multiShareAttachmentItemViewModel.m14696h());
        subParts.a(2131564018, this.f7194e, new Props(a3, false, a4, a5));
        subParts.a(2131564018, this.f7195f, new PrefetchMapPartDefinition.Props(e, a3, a4, a5));
        subParts.a(this.f7193d, a2);
        subParts.a(2131564018, this.f7193d, a2);
        subParts.a(2131564022, this.f7197h, new BusinessActionButtonPartDefinition.Props(2130839827, a, feedProps, multiShareAttachmentItemViewModel.m14695f()));
        FbDraweeControllerBuilder a6 = this.f7199j.a(f7189b);
        ImageRequestBuilder a7 = ImageRequestBuilder.a(Uri.parse(graphQLStoryAttachmentStyleInfo.u().b()));
        a7.j = this.f7198i;
        return ((FbDraweeControllerBuilder) a6.c(a7.m())).s();
    }

    @VisibleForTesting
    private static ImmutableList<Marker> m7511a(GraphQLStoryAttachmentStyleInfo graphQLStoryAttachmentStyleInfo) {
        Builder builder = new Builder();
        ImmutableList v = graphQLStoryAttachmentStyleInfo.v();
        int size = v.size();
        for (int i = 0; i < size; i++) {
            GraphQLLocation graphQLLocation = (GraphQLLocation) v.get(i);
            builder.c(new Marker(new LatLng(graphQLLocation.a(), graphQLLocation.b()), "images/ads/common/pins/map-card-pin-2x.png", 0.5f, 0.5f));
        }
        return builder.b();
    }

    private void m7512a(SubParts<E> subParts, GraphQLStoryAttachment graphQLStoryAttachment) {
        subParts.a(2131564020, this.f7196g, graphQLStoryAttachment.A());
        if (graphQLStoryAttachment.n() != null) {
            subParts.a(2131564021, this.f7196g, graphQLStoryAttachment.n().a());
        }
    }
}
