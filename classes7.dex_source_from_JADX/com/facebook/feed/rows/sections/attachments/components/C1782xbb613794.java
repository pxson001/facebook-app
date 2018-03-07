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
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feed.rows.sections.text.ContentTextComponentPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
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
/* compiled from: Visa Debit 1111 */
public class C1782xbb613794<E extends HasContext & HasIsAsync & HasInvalidate & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<FeedProps<GraphQLStoryAttachment>, E> {
    private static C1782xbb613794 f20926f;
    private static final Object f20927g = new Object();
    private final AndroidComponentsExperimentHelper f20928c;
    private final FeedBackgroundStylerComponentWrapper f20929d;
    private final LifeEventTitleTextComponent<E> f20930e;

    private static C1782xbb613794 m23847b(InjectorLike injectorLike) {
        return new C1782xbb613794(AndroidComponentsExperimentHelper.a(injectorLike), (Context) injectorLike.getInstance(Context.class), FeedBackgroundStylerComponentWrapper.b(injectorLike), LifeEventTitleTextComponent.m23864a(injectorLike));
    }

    public final boolean m23851a(Object obj) {
        GraphQLTextWithEntities a = LifeEventAttachmentUtil.m23682a((GraphQLStoryAttachment) ((FeedProps) obj).a, "Under Subtitle");
        return (a == null || Strings.isNullOrEmpty(a.a()) || !this.f20928c.g()) ? false : true;
    }

    public final CacheableEntity m23852b(Object obj) {
        return AttachmentProps.f((FeedProps) obj);
    }

    @Inject
    public C1782xbb613794(AndroidComponentsExperimentHelper androidComponentsExperimentHelper, Context context, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, LifeEventTitleTextComponent lifeEventTitleTextComponent) {
        super(context);
        this.f20928c = androidComponentsExperimentHelper;
        this.f20930e = lifeEventTitleTextComponent;
        this.f20929d = feedBackgroundStylerComponentWrapper;
    }

    public static C1782xbb613794 m23846a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            C1782xbb613794 b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20927g) {
                C1782xbb613794 c1782xbb613794;
                if (a2 != null) {
                    c1782xbb613794 = (C1782xbb613794) a2.a(f20927g);
                } else {
                    c1782xbb613794 = f20926f;
                }
                if (c1782xbb613794 == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = C1782xbb613794.m23847b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20927g, b3);
                        } else {
                            f20926f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = c1782xbb613794;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23850a() {
        return ContentTextComponentPartDefinition.c;
    }

    private Component<?> m23845a(ComponentContext componentContext, FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        FeedProps e2 = AttachmentProps.e(feedProps);
        Component d = this.f20930e.m23866a(componentContext).m23855a((FeedProps) feedProps).m23860b(e2).m23854a((HasInvalidate) e).m23856a(LifeEventAttachmentUtil.m23682a((GraphQLStoryAttachment) feedProps.a, "Under Subtitle")).m23862h(2131427400).m23863j(2131362052).m23858a("Under Subtitle").m23857a(FlyoutClickSource.SUBTITLE).d();
        Builder g = Builder.g();
        g.b = 4.0f;
        g = g;
        g.c = 8.0f;
        return this.f20929d.b(componentContext, (HasPositionInformation) e, new StylingData(e2, g.i()), d);
    }
}
