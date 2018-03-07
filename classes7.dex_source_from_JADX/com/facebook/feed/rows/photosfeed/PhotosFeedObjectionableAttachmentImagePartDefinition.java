package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.photos.GraphQLMediaRequestHelper;
import com.facebook.attachments.photos.PhotoAttachmentInfo;
import com.facebook.attachments.photos.PhotoAttachmentLayoutHelper;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.imagepipeline.request.ImageRequest;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.multirow.parts.ViewDimensionsPartDefinition;
import com.facebook.multirow.parts.ViewDimensionsPartDefinition.DimensionData;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.warning.ObjectionableContentController;
import com.facebook.photos.warning.ObjectionableContentView;
import com.facebook.photos.warning.ObjectionableContentView.State;
import javax.inject.Inject;

@ContextScoped
/* compiled from: a520892b4998c33fdc0e6e26bad339be */
public class PhotosFeedObjectionableAttachmentImagePartDefinition<E extends HasPositionInformation & HasInvalidate & HasContext> extends MultiRowSinglePartDefinition<MediaMetadata, State, E, ObjectionableContentView> {
    public static final ViewType f20256a = new C17521();
    public static final CallerContext f20257b = CallerContext.a(PhotosFeedObjectionableAttachmentImagePartDefinition.class, "photos_feed");
    private static PhotosFeedObjectionableAttachmentImagePartDefinition f20258j;
    private static final Object f20259k = new Object();
    public final ObjectionableContentController f20260c;
    private final ViewDimensionsPartDefinition f20261d;
    private final ClickListenerPartDefinition f20262e;
    private final PhotoAttachmentLayoutHelper f20263f;
    public final FbDraweeControllerBuilder f20264g;
    private final BackgroundPartDefinition f20265h;
    private final TextPartDefinition f20266i;

    /* compiled from: a520892b4998c33fdc0e6e26bad339be */
    final class C17521 extends ViewType {
        C17521() {
        }

        public final View m23389a(Context context) {
            return new ObjectionableContentView(context);
        }
    }

    private static PhotosFeedObjectionableAttachmentImagePartDefinition m23391b(InjectorLike injectorLike) {
        return new PhotosFeedObjectionableAttachmentImagePartDefinition(ObjectionableContentController.a(injectorLike), ViewDimensionsPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), PhotoAttachmentLayoutHelper.a(injectorLike), FbDraweeControllerBuilder.b(injectorLike), BackgroundPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m23393a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLImage T;
        final MediaMetadata mediaMetadata = (MediaMetadata) obj;
        final HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        final GraphQLMedia a = PhotosMetadataConversionHelper.a(mediaMetadata);
        subParts.a(this.f20265h, new StylingData(null, Builder.f().b(1).i(), Position.MIDDLE));
        subParts.a(2131564316, this.f20266i, this.f20260c.a(((HasContext) hasPositionInformation).getContext()));
        subParts.a(2131564317, this.f20262e, new OnClickListener(this) {
            final /* synthetic */ PhotosFeedObjectionableAttachmentImagePartDefinition f20255d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1440828580);
                GraphQLStory a2 = PhotosMetadataConversionHelper.a(mediaMetadata.z());
                this.f20255d.f20260c.a(a.b());
                ((HasInvalidate) hasPositionInformation).a(new FeedProps[]{FeedProps.c(a2)});
                Logger.a(2, EntryType.UI_INPUT_END, 1345298557, a);
            }
        });
        PhotoAttachmentInfo c = this.f20263f.c(a);
        int i = c.g;
        int i2 = c.h;
        subParts.a(2131564312, this.f20261d, new DimensionData(i, i2));
        subParts.a(2131564311, this.f20261d, new DimensionData(i, i2));
        subParts.a(2131564313, this.f20261d, new DimensionData(i, i2));
        ((FbDraweeControllerBuilder) this.f20264g.a(f20257b).a(true)).r();
        if (a.T() != null) {
            T = a.T();
        } else {
            T = a.S();
        }
        ImageRequest a2 = GraphQLMediaRequestHelper.a(a, T, null, this.f20264g, this.f20260c.b());
        return new State(this.f20264g.s(), 2131361953);
    }

    public final /* bridge */ /* synthetic */ void m23394a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 393564382);
        ObjectionableContentView objectionableContentView = (ObjectionableContentView) view;
        this.f20260c.a(objectionableContentView, (State) obj2);
        Logger.a(8, EntryType.MARK_POP, -1063889469, a);
    }

    public final boolean m23395a(Object obj) {
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return !mediaMetadata.J() && mediaMetadata.T() && this.f20260c.a() && !this.f20260c.c(mediaMetadata.d());
    }

    public final void m23396b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ObjectionableContentController.a((ObjectionableContentView) view);
    }

    public static PhotosFeedObjectionableAttachmentImagePartDefinition m23390a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedObjectionableAttachmentImagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20259k) {
                PhotosFeedObjectionableAttachmentImagePartDefinition photosFeedObjectionableAttachmentImagePartDefinition;
                if (a2 != null) {
                    photosFeedObjectionableAttachmentImagePartDefinition = (PhotosFeedObjectionableAttachmentImagePartDefinition) a2.a(f20259k);
                } else {
                    photosFeedObjectionableAttachmentImagePartDefinition = f20258j;
                }
                if (photosFeedObjectionableAttachmentImagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23391b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20259k, b3);
                        } else {
                            f20258j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedObjectionableAttachmentImagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PhotosFeedObjectionableAttachmentImagePartDefinition(ObjectionableContentController objectionableContentController, ViewDimensionsPartDefinition viewDimensionsPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, PhotoAttachmentLayoutHelper photoAttachmentLayoutHelper, FbDraweeControllerBuilder fbDraweeControllerBuilder, BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition) {
        this.f20260c = objectionableContentController;
        this.f20262e = clickListenerPartDefinition;
        this.f20263f = photoAttachmentLayoutHelper;
        this.f20261d = viewDimensionsPartDefinition;
        this.f20264g = fbDraweeControllerBuilder;
        this.f20265h = backgroundPartDefinition;
        this.f20266i = textPartDefinition;
    }

    public final ViewType m23392a() {
        return f20256a;
    }
}
