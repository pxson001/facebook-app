package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.ui.FlyoutLauncher$FlyoutContext;
import com.facebook.feedback.reactions.ui.PillsBlingBarPartDefinitionHelper;
import com.facebook.feedback.reactions.ui.PillsBlingBarView;
import com.facebook.graphql.model.GraphQLFeedback;
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
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import javax.inject.Inject;

@ContextScoped
/* compiled from: accessible */
public class PhotosFeedAttachmentPillsBlingBarPartDefinition<E extends CanLaunchPhotosFeedFlyout & HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<MediaMetadata, State, E, PillsBlingBarView> {
    private static PhotosFeedAttachmentPillsBlingBarPartDefinition f20078d;
    private static final Object f20079e = new Object();
    private final PillsBlingBarPartDefinitionHelper f20080a;
    private final BackgroundPartDefinition f20081b;
    private final ClickListenerPartDefinition f20082c;

    /* compiled from: accessible */
    public class State {
        public final GraphQLFeedback f20076a;
        public final Integer f20077b;

        public State(GraphQLFeedback graphQLFeedback, Integer num) {
            this.f20076a = graphQLFeedback;
            this.f20077b = num;
        }
    }

    private static PhotosFeedAttachmentPillsBlingBarPartDefinition m23257b(InjectorLike injectorLike) {
        return new PhotosFeedAttachmentPillsBlingBarPartDefinition(PillsBlingBarPartDefinitionHelper.a(injectorLike), BackgroundPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final ViewType m23258a() {
        return PillsBlingBarView.a;
    }

    public final Object m23259a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final CanLaunchPhotosFeedFlyout canLaunchPhotosFeedFlyout = (CanLaunchPhotosFeedFlyout) anyEnvironment;
        final GraphQLFeedback a = m23256a((MediaMetadata) obj);
        subParts.a(this.f20081b, new StylingData(PaddingStyle.o));
        subParts.a(this.f20082c, new OnClickListener(this) {
            final /* synthetic */ PhotosFeedAttachmentPillsBlingBarPartDefinition f20075c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1368710640);
                canLaunchPhotosFeedFlyout.mo1484a(a, view, FlyoutLauncher$FlyoutContext.PHOTOS_FEED_BLINGBAR);
                Logger.a(2, EntryType.UI_INPUT_END, -309147868, a);
            }
        });
        return new State(a, Integer.valueOf(0));
    }

    public final /* bridge */ /* synthetic */ void m23260a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -157756953);
        State state = (State) obj2;
        PillsBlingBarPartDefinitionHelper.a(state.f20076a, state.f20077b, (PillsBlingBarView) view);
        Logger.a(8, EntryType.MARK_POP, -1166483773, a);
    }

    public final boolean m23261a(Object obj) {
        return PillsBlingBarPartDefinitionHelper.a(m23256a((MediaMetadata) obj));
    }

    @Inject
    public PhotosFeedAttachmentPillsBlingBarPartDefinition(PillsBlingBarPartDefinitionHelper pillsBlingBarPartDefinitionHelper, BackgroundPartDefinition backgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f20080a = pillsBlingBarPartDefinitionHelper;
        this.f20081b = backgroundPartDefinition;
        this.f20082c = clickListenerPartDefinition;
    }

    public static PhotosFeedAttachmentPillsBlingBarPartDefinition m23255a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedAttachmentPillsBlingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20079e) {
                PhotosFeedAttachmentPillsBlingBarPartDefinition photosFeedAttachmentPillsBlingBarPartDefinition;
                if (a2 != null) {
                    photosFeedAttachmentPillsBlingBarPartDefinition = (PhotosFeedAttachmentPillsBlingBarPartDefinition) a2.a(f20079e);
                } else {
                    photosFeedAttachmentPillsBlingBarPartDefinition = f20078d;
                }
                if (photosFeedAttachmentPillsBlingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23257b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20079e, b3);
                        } else {
                            f20078d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedAttachmentPillsBlingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static GraphQLFeedback m23256a(MediaMetadata mediaMetadata) {
        return mediaMetadata != null ? PhotosMetadataConversionHelper.a(mediaMetadata.C()) : null;
    }
}
