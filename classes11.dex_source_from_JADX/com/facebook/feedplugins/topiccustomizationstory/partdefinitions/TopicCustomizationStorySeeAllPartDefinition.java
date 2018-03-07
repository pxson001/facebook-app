package com.facebook.feedplugins.topiccustomizationstory.partdefinitions;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.topicfeeds.customization.TopicFeedsIntentFactory;
import com.facebook.feedplugins.topiccustomizationstory.views.TopicCustomizationStorySeeAllView;
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
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android.webkit.BrowserFrame */
public class TopicCustomizationStorySeeAllPartDefinition extends BaseSinglePartDefinitionWithViewType<FeedProps<GraphQLTopicCustomizationStory>, State, AnyEnvironment, TopicCustomizationStorySeeAllView> {
    public static final ViewType<TopicCustomizationStorySeeAllView> f9962a = new C11521();
    private static TopicCustomizationStorySeeAllPartDefinition f9963e;
    private static final Object f9964f = new Object();
    private final TopicFeedsIntentFactory f9965b;
    private final SecureContextHelper f9966c;
    private final Context f9967d;

    /* compiled from: android.webkit.BrowserFrame */
    final class C11521 extends ViewType<TopicCustomizationStorySeeAllView> {
        C11521() {
        }

        public final View m10318a(Context context) {
            return new TopicCustomizationStorySeeAllView(context);
        }
    }

    /* compiled from: android.webkit.BrowserFrame */
    public class State {
        public final OnClickListener f9961a;

        public State(OnClickListener onClickListener) {
            this.f9961a = onClickListener;
        }
    }

    private static TopicCustomizationStorySeeAllPartDefinition m10320b(InjectorLike injectorLike) {
        return new TopicCustomizationStorySeeAllPartDefinition((Context) injectorLike.getInstance(Context.class), TopicFeedsIntentFactory.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    public final Object m10322a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return new State(TopicCustomizationStoryUtil.m10325a(this.f9965b, this.f9966c, this.f9967d, (GraphQLTopicCustomizationStory) ((FeedProps) obj).a));
    }

    public final /* bridge */ /* synthetic */ void m10323a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1815831197);
        State state = (State) obj2;
        TopicCustomizationStorySeeAllView topicCustomizationStorySeeAllView = (TopicCustomizationStorySeeAllView) view;
        topicCustomizationStorySeeAllView.f9990b.setText(((GraphQLTopicCustomizationStory) ((FeedProps) obj).a).A().a());
        topicCustomizationStorySeeAllView.setOnButtonClickListener(state.f9961a);
        Logger.a(8, EntryType.MARK_POP, -873515356, a);
    }

    public final void m10324b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((TopicCustomizationStorySeeAllView) view).setOnButtonClickListener(null);
    }

    @Inject
    public TopicCustomizationStorySeeAllPartDefinition(Context context, TopicFeedsIntentFactory topicFeedsIntentFactory, SecureContextHelper secureContextHelper) {
        this.f9967d = context;
        this.f9965b = topicFeedsIntentFactory;
        this.f9966c = secureContextHelper;
    }

    public final ViewType<TopicCustomizationStorySeeAllView> m10321a() {
        return f9962a;
    }

    public static TopicCustomizationStorySeeAllPartDefinition m10319a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TopicCustomizationStorySeeAllPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9964f) {
                TopicCustomizationStorySeeAllPartDefinition topicCustomizationStorySeeAllPartDefinition;
                if (a2 != null) {
                    topicCustomizationStorySeeAllPartDefinition = (TopicCustomizationStorySeeAllPartDefinition) a2.a(f9964f);
                } else {
                    topicCustomizationStorySeeAllPartDefinition = f9963e;
                }
                if (topicCustomizationStorySeeAllPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10320b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9964f, b3);
                        } else {
                            f9963e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = topicCustomizationStorySeeAllPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
