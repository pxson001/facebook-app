package com.facebook.feed.rows.sections.attachments.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.sections.attachments.LifeEventAttachmentUtil;
import com.facebook.feed.rows.sections.attachments.components.LifeEventTitleTextComponent.Builder;
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feed.rows.sections.text.ContentTextComponentPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.ViewType;
import com.facebook.ufiservices.flyout.FlyoutClickSource;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Visual Feedback for impression logging */
public class LifeEventAttachmentHeaderTitleTextComponentPartDefinition<E extends HasContext & HasIsAsync & HasInvalidate & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<FeedProps<GraphQLStoryAttachment>, E> {
    private static LifeEventAttachmentHeaderTitleTextComponentPartDefinition f20921f;
    private static final Object f20922g = new Object();
    private final AndroidComponentsExperimentHelper f20923c;
    private final FeedBackgroundStylerComponentWrapper f20924d;
    private final LifeEventTitleTextComponent<E> f20925e;

    private static LifeEventAttachmentHeaderTitleTextComponentPartDefinition m23839b(InjectorLike injectorLike) {
        return new LifeEventAttachmentHeaderTitleTextComponentPartDefinition(AndroidComponentsExperimentHelper.a(injectorLike), (Context) injectorLike.getInstance(Context.class), FeedBackgroundStylerComponentWrapper.b(injectorLike), LifeEventTitleTextComponent.m23864a(injectorLike));
    }

    public final boolean m23843a(Object obj) {
        GraphQLTextWithEntities a = LifeEventAttachmentUtil.m23682a((GraphQLStoryAttachment) ((FeedProps) obj).a, "Title");
        return (a == null || Strings.isNullOrEmpty(a.a()) || !this.f20923c.g()) ? false : true;
    }

    public final CacheableEntity m23844b(Object obj) {
        return AttachmentProps.f((FeedProps) obj);
    }

    @Inject
    public LifeEventAttachmentHeaderTitleTextComponentPartDefinition(AndroidComponentsExperimentHelper androidComponentsExperimentHelper, Context context, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, LifeEventTitleTextComponent lifeEventTitleTextComponent) {
        super(context);
        this.f20923c = androidComponentsExperimentHelper;
        this.f20925e = lifeEventTitleTextComponent;
        this.f20924d = feedBackgroundStylerComponentWrapper;
    }

    public static LifeEventAttachmentHeaderTitleTextComponentPartDefinition m23838a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LifeEventAttachmentHeaderTitleTextComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20922g) {
                LifeEventAttachmentHeaderTitleTextComponentPartDefinition lifeEventAttachmentHeaderTitleTextComponentPartDefinition;
                if (a2 != null) {
                    lifeEventAttachmentHeaderTitleTextComponentPartDefinition = (LifeEventAttachmentHeaderTitleTextComponentPartDefinition) a2.a(f20922g);
                } else {
                    lifeEventAttachmentHeaderTitleTextComponentPartDefinition = f20921f;
                }
                if (lifeEventAttachmentHeaderTitleTextComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23839b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20922g, b3);
                        } else {
                            f20921f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = lifeEventAttachmentHeaderTitleTextComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23842a() {
        return ContentTextComponentPartDefinition.c;
    }

    private Component<?> m23837a(ComponentContext componentContext, FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        FeedProps e2 = AttachmentProps.e(feedProps);
        Builder h = this.f20925e.m23866a(componentContext).m23855a((FeedProps) feedProps).m23860b(e2).m23854a((HasInvalidate) e).m23856a(LifeEventAttachmentUtil.m23682a((GraphQLStoryAttachment) feedProps.a, "Title")).m23862h(2131427404);
        h.f20934a.f20946h = -16777216;
        h.f20938e.set(7);
        Component d = h.m23858a("Title").m23857a(FlyoutClickSource.TITLE).d();
        PaddingStyle.Builder g = PaddingStyle.Builder.g();
        g.b = 4.0f;
        g = g;
        g.c = 0.0f;
        return this.f20924d.b(componentContext, (HasPositionInformation) e, new StylingData(e2, g.i()), d);
    }
}
