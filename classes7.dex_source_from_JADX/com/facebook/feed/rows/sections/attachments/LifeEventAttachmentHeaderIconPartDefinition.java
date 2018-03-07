package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.ui.LifeEventHeaderIconView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ZZ)V */
public class LifeEventAttachmentHeaderIconPartDefinition<E extends HasPositionInformation & HasPrefetcher & HasRowKey> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, LifeEventHeaderIconView> {
    public static final ViewType f20642a = new C17721();
    private static final CallerContext f20643b = CallerContext.a(LifeEventAttachmentHeaderIconPartDefinition.class, "native_newsfeed");
    private static LifeEventAttachmentHeaderIconPartDefinition f20644f;
    private static final Object f20645g = new Object();
    private final BackgroundPartDefinition f20646c;
    private final FbDraweePartDefinition<E> f20647d;
    private final AbstractFbErrorReporter f20648e;

    /* compiled from: ZZ)V */
    final class C17721 extends ViewType {
        C17721() {
        }

        public final View m23667a(Context context) {
            return new LifeEventHeaderIconView(context);
        }
    }

    private static LifeEventAttachmentHeaderIconPartDefinition m23669b(InjectorLike injectorLike) {
        return new LifeEventAttachmentHeaderIconPartDefinition(BackgroundPartDefinition.a(injectorLike), FbDraweePartDefinition.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public final Object m23671a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String str;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        if (graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().dq() == null) {
            String str2;
            GraphQLTextWithEntities a = LifeEventAttachmentUtil.m23682a(graphQLStoryAttachment, "Icon");
            if (a == null || a.a() == null) {
                str2 = null;
            } else {
                str2 = a.a();
            }
            String str3 = str2;
            this.f20648e.a("life_event", "experience target/icon missing: " + Strings.nullToEmpty(graphQLStoryAttachment.A()));
            str = str3;
        } else {
            str = graphQLStoryAttachment.z().dq().b();
        }
        FbDraweePartDefinition fbDraweePartDefinition = this.f20647d;
        Builder a2 = FbDraweePartDefinition.a().a(str);
        a2.c = f20643b;
        subParts.a(2131560549, fbDraweePartDefinition, a2.a());
        subParts.a(this.f20646c, new StylingData(AttachmentProps.e(feedProps), PaddingStyle.o));
        return null;
    }

    public static LifeEventAttachmentHeaderIconPartDefinition m23668a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LifeEventAttachmentHeaderIconPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20645g) {
                LifeEventAttachmentHeaderIconPartDefinition lifeEventAttachmentHeaderIconPartDefinition;
                if (a2 != null) {
                    lifeEventAttachmentHeaderIconPartDefinition = (LifeEventAttachmentHeaderIconPartDefinition) a2.a(f20645g);
                } else {
                    lifeEventAttachmentHeaderIconPartDefinition = f20644f;
                }
                if (lifeEventAttachmentHeaderIconPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23669b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20645g, b3);
                        } else {
                            f20644f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = lifeEventAttachmentHeaderIconPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public LifeEventAttachmentHeaderIconPartDefinition(BackgroundPartDefinition backgroundPartDefinition, FbDraweePartDefinition fbDraweePartDefinition, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f20646c = backgroundPartDefinition;
        this.f20647d = fbDraweePartDefinition;
        this.f20648e = abstractFbErrorReporter;
    }

    public final ViewType m23670a() {
        return f20642a;
    }

    public final boolean m23672a(Object obj) {
        return true;
    }
}
