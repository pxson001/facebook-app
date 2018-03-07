package com.facebook.today.ui.components.partdefinition;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.collage.CollageItem;
import com.facebook.feed.collage.CollageLayoutCalculator;
import com.facebook.feed.collage.CollageLayoutCalculatorProvider;
import com.facebook.feed.collage.StoryCollageItem;
import com.facebook.feed.collage.ui.CollageAttachmentView;
import com.facebook.feed.collage.ui.CollageAttachmentView.OnImageClickListener;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.ui.MultistoryCollageLayoutProperties;
import com.facebook.feed.rows.sections.attachments.ui.MultistoryCollageLayoutPropertiesProvider;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.ui.DefaultMediaGalleryLauncher;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: transport_type */
public class PhotoGridPartDefinition extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, AnyEnvironment, CollageAttachmentView> {
    public static final ViewType f1295a = new C01251();
    private static final CallerContext f1296b = CallerContext.b(PhotoGridPartDefinition.class, "reaction_photo_grid_view", "today");
    private static PhotoGridPartDefinition f1297i;
    private static final Object f1298j = new Object();
    private final CollageLayoutCalculatorProvider f1299c;
    private final MultistoryCollageLayoutPropertiesProvider f1300d;
    private final FbDraweeControllerBuilder f1301e;
    private final FeedImageLoader f1302f;
    public final MediaGalleryLauncher f1303g;
    private final MediaGalleryLauncherParamsFactory f1304h;

    /* compiled from: transport_type */
    final class C01251 extends ViewType {
        C01251() {
        }

        public final View m1447a(Context context) {
            CollageAttachmentView collageAttachmentView = new CollageAttachmentView(context);
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(2130773561, typedValue, true);
            CustomViewUtils.b(collageAttachmentView, new ColorDrawable(typedValue.data));
            return collageAttachmentView;
        }
    }

    /* compiled from: transport_type */
    public class State {
        public OnImageClickListener<StoryCollageItem> f1292a;
        public CollageLayoutCalculator<StoryCollageItem> f1293b;
        public DraweeController[] f1294c;

        public State(OnImageClickListener<StoryCollageItem> onImageClickListener, CollageLayoutCalculator<StoryCollageItem> collageLayoutCalculator, DraweeController[] draweeControllerArr) {
            this.f1292a = onImageClickListener;
            this.f1293b = collageLayoutCalculator;
            this.f1294c = draweeControllerArr;
        }
    }

    private static PhotoGridPartDefinition m1451b(InjectorLike injectorLike) {
        return new PhotoGridPartDefinition((CollageLayoutCalculatorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CollageLayoutCalculatorProvider.class), FbDraweeControllerBuilder.b(injectorLike), FeedImageLoader.a(injectorLike), (MediaGalleryLauncher) DefaultMediaGalleryLauncher.a(injectorLike), MediaGalleryLauncherParamsFactory.a(injectorLike), (MultistoryCollageLayoutPropertiesProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MultistoryCollageLayoutPropertiesProvider.class));
    }

    public final /* synthetic */ Object m1454a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m1450b((ReactionUnitComponentNode) obj);
    }

    public final /* bridge */ /* synthetic */ void m1455a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1293992050);
        State state = (State) obj2;
        CollageAttachmentView collageAttachmentView = (CollageAttachmentView) view;
        collageAttachmentView.a(state.f1293b, state.f1294c);
        collageAttachmentView.u = state.f1292a;
        Logger.a(8, EntryType.MARK_POP, -383217917, a);
    }

    public final boolean m1456a(Object obj) {
        return MultistoryCollageLayoutProperties.a(ImmutableList.copyOf(m1452c((ReactionUnitComponentNode) obj)));
    }

    public final void m1457b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        CollageAttachmentView collageAttachmentView = (CollageAttachmentView) view;
        collageAttachmentView.a();
        collageAttachmentView.u = null;
    }

    public static PhotoGridPartDefinition m1449a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotoGridPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1298j) {
                PhotoGridPartDefinition photoGridPartDefinition;
                if (a2 != null) {
                    photoGridPartDefinition = (PhotoGridPartDefinition) a2.a(f1298j);
                } else {
                    photoGridPartDefinition = f1297i;
                }
                if (photoGridPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1451b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1298j, b3);
                        } else {
                            f1297i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photoGridPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PhotoGridPartDefinition(CollageLayoutCalculatorProvider collageLayoutCalculatorProvider, FbDraweeControllerBuilder fbDraweeControllerBuilder, FeedImageLoader feedImageLoader, MediaGalleryLauncher mediaGalleryLauncher, MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory, MultistoryCollageLayoutPropertiesProvider multistoryCollageLayoutPropertiesProvider) {
        this.f1299c = collageLayoutCalculatorProvider;
        this.f1300d = multistoryCollageLayoutPropertiesProvider;
        this.f1302f = feedImageLoader;
        this.f1301e = fbDraweeControllerBuilder;
        this.f1303g = mediaGalleryLauncher;
        this.f1304h = mediaGalleryLauncherParamsFactory;
    }

    private State m1450b(ReactionUnitComponentNode reactionUnitComponentNode) {
        MultistoryCollageLayoutProperties a = this.f1300d.a(ImmutableList.copyOf(m1452c(reactionUnitComponentNode)));
        CollageLayoutCalculator a2 = this.f1299c.a(a);
        final ImmutableList a3 = a2.a();
        int size = a3.size();
        DraweeController[] draweeControllerArr = new DraweeController[size];
        FbDraweeControllerBuilder r = this.f1301e.a(f1296b).r();
        Builder builder = new Builder();
        for (int i = 0; i < size; i++) {
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((StoryCollageItem) a3.get(i)).a.a;
            r.c(this.f1302f.a(graphQLStoryAttachment.r(), a.a(graphQLStoryAttachment)));
            draweeControllerArr[i] = r.s();
            builder.c(graphQLStoryAttachment);
        }
        final ImmutableList b = builder.b();
        return new State(new OnImageClickListener<StoryCollageItem>(this) {
            final /* synthetic */ PhotoGridPartDefinition f1291c;

            public final void m1448a(CollageAttachmentView collageAttachmentView, CollageItem collageItem, int i) {
                PhotoGridPartDefinition photoGridPartDefinition = this.f1291c;
                GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((StoryCollageItem) a3.get(i)).a.a;
                ImmutableList immutableList = b;
                Preconditions.checkNotNull(graphQLStoryAttachment.r());
                photoGridPartDefinition.f1303g.a(collageAttachmentView.getContext(), MediaGalleryLauncherParamsFactory.a(immutableList, i).a(FullscreenGallerySource.REACTION_PHOTO_ITEM).b(), null);
            }
        }, a2, draweeControllerArr);
    }

    public final ViewType m1453a() {
        return f1295a;
    }

    private static ImmutableList<FeedProps<GraphQLStoryAttachment>> m1452c(ReactionUnitComponentNode reactionUnitComponentNode) {
        Builder builder = new Builder();
        FeedProps c = FeedProps.c(reactionUnitComponentNode);
        ImmutableList bN = reactionUnitComponentNode.b.bN();
        int size = bN.size();
        for (int i = 0; i < size; i++) {
            builder.c(c.a((GraphQLStoryAttachment) bN.get(i)));
        }
        return builder.b();
    }
}
