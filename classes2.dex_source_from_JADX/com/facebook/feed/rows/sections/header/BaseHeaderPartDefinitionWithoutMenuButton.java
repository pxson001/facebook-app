package com.facebook.feed.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.header.ProfilePhotoPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.BaseHeaderViewWithTextLayout;
import com.facebook.feed.rows.sections.header.ui.HeaderViewWithTextLayout;
import com.facebook.feedplugins.base.TextLinkPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.graphql.story.util.StoryUtilModelConverter;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: http2_weight */
public class BaseHeaderPartDefinitionWithoutMenuButton<E extends HasInvalidate & HasContext & HasMenuButtonProvider & HasRowKey & HasPersistentState & HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<Props, Void, E, BaseHeaderViewWithTextLayout> {
    private static BaseHeaderPartDefinitionWithoutMenuButton f20742f;
    private static final Object f20743g = new Object();
    private final TextLinkPartDefinition f20744a;
    private final ProfilePhotoPartDefinition<E> f20745b;
    private final HeaderTitleWithLayoutPartDefinition<E> f20746c;
    private final DefaultHeaderSubtitleWithLayoutPartDefinition<E> f20747d;
    private final StoryHeaderUtil f20748e;

    private static BaseHeaderPartDefinitionWithoutMenuButton m28466b(InjectorLike injectorLike) {
        return new BaseHeaderPartDefinitionWithoutMenuButton(TextLinkPartDefinition.m28402a(injectorLike), ProfilePhotoPartDefinition.m28424a(injectorLike), HeaderTitleWithLayoutPartDefinition.m28427a(injectorLike), DefaultHeaderSubtitleWithLayoutPartDefinition.m28432a(injectorLike), StoryHeaderUtil.m28330a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.mo2756a(this.f20744a, props.a);
        int c = this.f20748e.m28336c(props.a);
        subParts.mo2755a(2131562764, this.f20745b, new Props(props.a, this.f20748e.m28335b(props.a), c));
        subParts.mo2755a(2131562765, this.f20746c, new HeaderTitleWithLayoutPartDefinition.Props(props.a, true, props.b));
        subParts.mo2755a(2131562766, this.f20747d, new DefaultHeaderSubtitleWithLayoutPartDefinition.Props(props.a, props.b));
        return null;
    }

    public final boolean m28469a(Object obj) {
        Props props = (Props) obj;
        GraphQLStory graphQLStory = (GraphQLStory) props.a.f13444a;
        if (!StoryProps.m27464m(props.a)) {
            Object obj2 = null;
            if (StoryHierarchyHelper.m27437d(graphQLStory) && !GraphQLStoryUtil.m9570a(StoryUtilModelConverter.m28877a(graphQLStory))) {
                obj2 = 1;
            }
            if (obj2 == null) {
                return true;
            }
        }
        return false;
    }

    public static BaseHeaderPartDefinitionWithoutMenuButton m28465a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BaseHeaderPartDefinitionWithoutMenuButton b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20743g) {
                BaseHeaderPartDefinitionWithoutMenuButton baseHeaderPartDefinitionWithoutMenuButton;
                if (a2 != null) {
                    baseHeaderPartDefinitionWithoutMenuButton = (BaseHeaderPartDefinitionWithoutMenuButton) a2.mo818a(f20743g);
                } else {
                    baseHeaderPartDefinitionWithoutMenuButton = f20742f;
                }
                if (baseHeaderPartDefinitionWithoutMenuButton == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28466b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20743g, b3);
                        } else {
                            f20742f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = baseHeaderPartDefinitionWithoutMenuButton;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public BaseHeaderPartDefinitionWithoutMenuButton(TextLinkPartDefinition textLinkPartDefinition, ProfilePhotoPartDefinition profilePhotoPartDefinition, HeaderTitleWithLayoutPartDefinition headerTitleWithLayoutPartDefinition, DefaultHeaderSubtitleWithLayoutPartDefinition defaultHeaderSubtitleWithLayoutPartDefinition, StoryHeaderUtil storyHeaderUtil) {
        this.f20744a = textLinkPartDefinition;
        this.f20746c = headerTitleWithLayoutPartDefinition;
        this.f20747d = defaultHeaderSubtitleWithLayoutPartDefinition;
        this.f20745b = profilePhotoPartDefinition;
        this.f20748e = storyHeaderUtil;
    }

    public final ViewType mo2547a() {
        return HeaderViewWithTextLayout.f21710k;
    }
}
