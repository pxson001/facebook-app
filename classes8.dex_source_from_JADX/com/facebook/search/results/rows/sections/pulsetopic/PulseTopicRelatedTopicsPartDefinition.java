package com.facebook.search.results.rows.sections.pulsetopic;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLNode;
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
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.results.environment.HasSearchResultsContext;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PRE_INSTALLED_FONT_SERIF */
public class PulseTopicRelatedTopicsPartDefinition<E extends HasPositionInformation & HasSearchResultsContext> extends MultiRowSinglePartDefinition<GraphQLNode, Void, E, ContentView> {
    public static final ViewType f24934a = ViewType.a(2130906520);
    private static PulseTopicRelatedTopicsPartDefinition f24935g;
    private static final Object f24936h = new Object();
    private final BackgroundPartDefinition f24937b;
    private final ClickListenerPartDefinition f24938c;
    public final SearchResultsIntentBuilder f24939d;
    public final SecureContextHelper f24940e;
    public final Context f24941f;

    private static PulseTopicRelatedTopicsPartDefinition m28288b(InjectorLike injectorLike) {
        return new PulseTopicRelatedTopicsPartDefinition(BackgroundPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), SearchResultsIntentBuilder.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object m28291a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final GraphQLNode graphQLNode = (GraphQLNode) obj;
        final HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        subParts.a(this.f24937b, new StylingData(PaddingStyle.a));
        subParts.a(this.f24938c, new OnClickListener(this) {
            final /* synthetic */ PulseTopicRelatedTopicsPartDefinition f24933c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -292984412);
                if (graphQLNode.dp() != null) {
                    this.f24933c.f24940e.a(this.f24933c.f24939d.c(((HasSearchResultsContext) hasPositionInformation).mo1248s().f23369d, graphQLNode.eP(), graphQLNode.dp(), SearchResultsSource.h), this.f24933c.f24941f);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1003060298, a);
            }
        });
        return null;
    }

    public final /* bridge */ /* synthetic */ void m28292a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1884916661);
        ((ContentView) view).setTitleText(((GraphQLNode) obj).eP());
        Logger.a(8, EntryType.MARK_POP, 1074074734, a);
    }

    @Inject
    public PulseTopicRelatedTopicsPartDefinition(BackgroundPartDefinition backgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, SearchResultsIntentBuilder searchResultsIntentBuilder, SecureContextHelper secureContextHelper, Context context) {
        this.f24937b = backgroundPartDefinition;
        this.f24938c = clickListenerPartDefinition;
        this.f24939d = searchResultsIntentBuilder;
        this.f24940e = secureContextHelper;
        this.f24941f = context;
    }

    public final ViewType m28290a() {
        return f24934a;
    }

    public static PulseTopicRelatedTopicsPartDefinition m28287a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseTopicRelatedTopicsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24936h) {
                PulseTopicRelatedTopicsPartDefinition pulseTopicRelatedTopicsPartDefinition;
                if (a2 != null) {
                    pulseTopicRelatedTopicsPartDefinition = (PulseTopicRelatedTopicsPartDefinition) a2.a(f24936h);
                } else {
                    pulseTopicRelatedTopicsPartDefinition = f24935g;
                }
                if (pulseTopicRelatedTopicsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28288b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24936h, b3);
                        } else {
                            f24935g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseTopicRelatedTopicsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static boolean m28289b() {
        return true;
    }

    public final /* synthetic */ boolean m28293a(Object obj) {
        return true;
    }
}
