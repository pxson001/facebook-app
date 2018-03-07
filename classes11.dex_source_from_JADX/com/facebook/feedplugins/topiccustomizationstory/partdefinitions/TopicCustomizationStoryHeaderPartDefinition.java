package com.facebook.feedplugins.topiccustomizationstory.partdefinitions;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderTitle.Sponsored;
import com.facebook.feed.rows.sections.header.ui.TextHeaderStyle;
import com.facebook.feed.rows.sections.header.ui.TextWithMenuButtonView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLTopicCustomizationStory;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: android.webkit.WebViewCore */
public class TopicCustomizationStoryHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLTopicCustomizationStory>, Void, HasPositionInformation, TextWithMenuButtonView> {
    private static TopicCustomizationStoryHeaderPartDefinition f9956b;
    private static final Object f9957c = new Object();
    private final BackgroundPartDefinition f9958a;

    private static TopicCustomizationStoryHeaderPartDefinition m10313b(InjectorLike injectorLike) {
        return new TopicCustomizationStoryHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike));
    }

    public final Object m10315a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f9958a, new StylingData((FeedProps) obj, PaddingStyle.j));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m10316a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 561559583);
        FeedProps feedProps = (FeedProps) obj;
        TextWithMenuButtonView textWithMenuButtonView = (TextWithMenuButtonView) view;
        textWithMenuButtonView.setStyle(TextHeaderStyle.STORY_HEADER);
        textWithMenuButtonView.a(((GraphQLTopicCustomizationStory) feedProps.a).m().a(), Sponsored.NOT_SPONSORED);
        textWithMenuButtonView.setMenuButtonActive(false);
        Logger.a(8, EntryType.MARK_POP, -1097893678, a);
    }

    public final boolean m10317a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (feedProps.a == null) {
            return false;
        }
        return CollectionUtil.b(((GraphQLTopicCustomizationStory) feedProps.a).o());
    }

    @Inject
    public TopicCustomizationStoryHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver) {
        this.f9958a = backgroundPartDefinition;
    }

    public final ViewType m10314a() {
        return TextWithMenuButtonView.b;
    }

    public static TopicCustomizationStoryHeaderPartDefinition m10312a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TopicCustomizationStoryHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9957c) {
                TopicCustomizationStoryHeaderPartDefinition topicCustomizationStoryHeaderPartDefinition;
                if (a2 != null) {
                    topicCustomizationStoryHeaderPartDefinition = (TopicCustomizationStoryHeaderPartDefinition) a2.a(f9957c);
                } else {
                    topicCustomizationStoryHeaderPartDefinition = f9956b;
                }
                if (topicCustomizationStoryHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10313b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9957c, b3);
                        } else {
                            f9956b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = topicCustomizationStoryHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
