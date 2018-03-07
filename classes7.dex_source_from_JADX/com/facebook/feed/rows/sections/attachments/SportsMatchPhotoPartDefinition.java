package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition.Props;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.ImageUtil;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: WrongConstant */
public class SportsMatchPhotoPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, DraweeController, E, FbDraweeView> {
    public static final ViewType f20793a = ViewType.a(2130907196);
    private static final CallerContext f20794b = CallerContext.a(SportsMatchPhotoPartDefinition.class, "photo");
    private static SportsMatchPhotoPartDefinition f20795g;
    private static final Object f20796h = new Object();
    private final Provider<FbDraweeControllerBuilder> f20797c;
    private final BackgroundPartDefinition f20798d;
    private final DefaultPaddingStyleResolver f20799e;
    private final AttachmentLinkPartDefinition<E> f20800f;

    private static SportsMatchPhotoPartDefinition m23759b(InjectorLike injectorLike) {
        return new SportsMatchPhotoPartDefinition(IdBasedProvider.a(injectorLike, 1117), BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike), AttachmentLinkPartDefinition.a(injectorLike));
    }

    public final Object m23761a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        Builder a = Builder.a();
        a.c = -this.f20799e.e();
        subParts.a(this.f20798d, new StylingData(AttachmentProps.e(feedProps), a.i()));
        subParts.a(this.f20800f, new Props(feedProps));
        return ((FbDraweeControllerBuilder) this.f20797c.get()).a(f20794b).b(ImageUtil.a(GraphQLStoryAttachmentUtil.n(graphQLStoryAttachment))).s();
    }

    public final /* bridge */ /* synthetic */ void m23762a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 88572088);
        FbDraweeView fbDraweeView = (FbDraweeView) view;
        fbDraweeView.setController((DraweeController) obj2);
        fbDraweeView.setAspectRatio(1.9318181f);
        Logger.a(8, EntryType.MARK_POP, 54326748, a);
    }

    public final boolean m23763a(Object obj) {
        return GraphQLStoryAttachmentUtil.m((GraphQLStoryAttachment) ((FeedProps) obj).a);
    }

    @Inject
    public SportsMatchPhotoPartDefinition(Provider<FbDraweeControllerBuilder> provider, BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver, AttachmentLinkPartDefinition attachmentLinkPartDefinition) {
        this.f20797c = provider;
        this.f20798d = backgroundPartDefinition;
        this.f20799e = defaultPaddingStyleResolver;
        this.f20800f = attachmentLinkPartDefinition;
    }

    public static SportsMatchPhotoPartDefinition m23758a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SportsMatchPhotoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20796h) {
                SportsMatchPhotoPartDefinition sportsMatchPhotoPartDefinition;
                if (a2 != null) {
                    sportsMatchPhotoPartDefinition = (SportsMatchPhotoPartDefinition) a2.a(f20796h);
                } else {
                    sportsMatchPhotoPartDefinition = f20795g;
                }
                if (sportsMatchPhotoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23759b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20796h, b3);
                        } else {
                            f20795g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = sportsMatchPhotoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23760a() {
        return f20793a;
    }
}
