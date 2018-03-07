package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.feed.ComponentPartHelper;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.abtest.ExperimentsForMultipleRowsStoriesAbtestModule;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.sections.attachments.MinutiaeAttachmentTextPartDefinition.Props;
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feed.rows.sections.text.ContentTextComponent;
import com.facebook.feed.rows.sections.text.ContentTextComponent.Builder;
import com.facebook.feed.rows.sections.text.ContentTextComponentPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Z)T */
public class MinutiaeAttachmentTextComponentPartDefinition<E extends HasContext & HasInvalidate & HasIsAsync & HasPersistentState & HasPositionInformation> extends ComponentPartDefinition<Props, E> {
    private static MinutiaeAttachmentTextComponentPartDefinition f20693i;
    private static final Object f20694j = new Object();
    private final ContentTextComponent f20695c;
    private final FeedBackgroundStylerComponentWrapper f20696d;
    private final float f20697e;
    private final float f20698f;
    private final AndroidComponentsExperimentHelper f20699g;
    private final MinutiaeAttachmentHeaderTextPersistentSpannableInputProvider f20700h;

    private static MinutiaeAttachmentTextComponentPartDefinition m23701b(InjectorLike injectorLike) {
        return new MinutiaeAttachmentTextComponentPartDefinition((Context) injectorLike.getInstance(Context.class), ContentTextComponent.a(injectorLike), FeedBackgroundStylerComponentWrapper.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), AndroidComponentsExperimentHelper.a(injectorLike), (MinutiaeAttachmentHeaderTextPersistentSpannableInputProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MinutiaeAttachmentHeaderTextPersistentSpannableInputProvider.class));
    }

    public final boolean m23705a(Object obj) {
        return ((Props) obj).m23708a() && this.f20699g.g();
    }

    public final CacheableEntity m23706b(Object obj) {
        return ComponentPartHelper.a(((Props) obj).m23710f());
    }

    public static MinutiaeAttachmentTextComponentPartDefinition m23700a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MinutiaeAttachmentTextComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20694j) {
                MinutiaeAttachmentTextComponentPartDefinition minutiaeAttachmentTextComponentPartDefinition;
                if (a2 != null) {
                    minutiaeAttachmentTextComponentPartDefinition = (MinutiaeAttachmentTextComponentPartDefinition) a2.a(f20694j);
                } else {
                    minutiaeAttachmentTextComponentPartDefinition = f20693i;
                }
                if (minutiaeAttachmentTextComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23701b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20694j, b3);
                        } else {
                            f20693i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = minutiaeAttachmentTextComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public MinutiaeAttachmentTextComponentPartDefinition(Context context, ContentTextComponent contentTextComponent, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, QeAccessor qeAccessor, AndroidComponentsExperimentHelper androidComponentsExperimentHelper, MinutiaeAttachmentHeaderTextPersistentSpannableInputProvider minutiaeAttachmentHeaderTextPersistentSpannableInputProvider) {
        super(context);
        this.f20695c = contentTextComponent;
        this.f20696d = feedBackgroundStylerComponentWrapper;
        this.f20699g = androidComponentsExperimentHelper;
        this.f20700h = minutiaeAttachmentHeaderTextPersistentSpannableInputProvider;
        this.f20697e = qeAccessor.a(ExperimentsForMultipleRowsStoriesAbtestModule.k, 2.0f);
        this.f20698f = qeAccessor.a(ExperimentsForMultipleRowsStoriesAbtestModule.j, 8.0f);
    }

    public final ViewType m23704a() {
        return ContentTextComponentPartDefinition.c;
    }

    private Component<?> m23699a(ComponentContext componentContext, Props props, E e) {
        Builder a = this.f20695c.a(componentContext).a(props.m23710f()).a(e).h(2131427400).a(Typeface.DEFAULT_BOLD);
        a.a.h = this.f20700h.m23698a(props);
        Component d = a.a(Alignment.ALIGN_CENTER).d();
        FeedProps f = props.m23710f();
        PaddingStyle.Builder g = PaddingStyle.Builder.g();
        g.b = this.f20697e;
        g = g;
        g.c = this.f20698f;
        return this.f20696d.b(componentContext, (HasPositionInformation) e, new StylingData(f, g.i()), d);
    }
}
