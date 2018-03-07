package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.rows.sections.attachments.ui.ImageShareAttachmentView;
import com.facebook.graphql.model.GraphQLImage;
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
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: WavHeaderReader */
public class StaticImagePartDefinition extends BaseSinglePartDefinition<GraphQLStoryAttachment, State, AnyEnvironment, ImageShareAttachmentView> {
    private static StaticImagePartDefinition f20817b;
    private static final Object f20818c = new Object();
    private final FbDraweeControllerBuilder f20819a;

    /* compiled from: WavHeaderReader */
    public class State {
        public final DraweeController f20814a;
        public final float f20815b;
        public final boolean f20816c;

        public State(DraweeController draweeController, float f, boolean z) {
            this.f20814a = draweeController;
            this.f20815b = f;
            this.f20816c = z;
        }
    }

    private static StaticImagePartDefinition m23773b(InjectorLike injectorLike) {
        return new StaticImagePartDefinition(FbDraweeControllerBuilder.b(injectorLike));
    }

    public final Object m23774a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) obj;
        GraphQLImage a = ImageShareUtil.m23646a(graphQLStoryAttachment);
        return new State(ImageShareUtil.m23645a(this.f20819a, a), ImageShareUtil.m23644a(a), graphQLStoryAttachment.r().an());
    }

    public final /* bridge */ /* synthetic */ void m23775a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 265307023);
        State state = (State) obj2;
        ImageShareAttachmentView imageShareAttachmentView = (ImageShareAttachmentView) view;
        imageShareAttachmentView.setAspectRatio(state.f20815b);
        imageShareAttachmentView.setImageController(state.f20814a);
        imageShareAttachmentView.setPlayButtonState(state.f20816c ? com.facebook.gif.AnimatedImagePlayButtonView.State.READY_TO_PLAY : com.facebook.gif.AnimatedImagePlayButtonView.State.HIDDEN);
        Logger.a(8, EntryType.MARK_POP, -1026488516, a);
    }

    @Inject
    public StaticImagePartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f20819a = fbDraweeControllerBuilder;
    }

    public static StaticImagePartDefinition m23772a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StaticImagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20818c) {
                StaticImagePartDefinition staticImagePartDefinition;
                if (a2 != null) {
                    staticImagePartDefinition = (StaticImagePartDefinition) a2.a(f20818c);
                } else {
                    staticImagePartDefinition = f20817b;
                }
                if (staticImagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23773b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20818c, b3);
                        } else {
                            f20817b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = staticImagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
