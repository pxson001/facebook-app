package com.facebook.feedplugins.findgroups;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLFindGroupsFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: downloadUrl */
public class FindGroupsPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLFindGroupsFeedUnit>, OnClickListener, HasPositionInformation, FindGroupsView> {
    public static final ViewType f7582a = new C09671();
    private static FindGroupsPartDefinition f7583e;
    private static final Object f7584f = new Object();
    public final IFeedIntentBuilder f7585b;
    private final BackgroundPartDefinition f7586c;
    private final ClickListenerPartDefinition f7587d;

    /* compiled from: downloadUrl */
    final class C09671 extends ViewType {
        C09671() {
        }

        public final View m8811a(Context context) {
            return new FindGroupsView(context);
        }
    }

    /* compiled from: downloadUrl */
    class C09682 implements OnClickListener {
        final /* synthetic */ FindGroupsPartDefinition f7581a;

        C09682(FindGroupsPartDefinition findGroupsPartDefinition) {
            this.f7581a = findGroupsPartDefinition;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 52252583);
            this.f7581a.f7585b.a(view.getContext(), FBLinks.w);
            Logger.a(2, EntryType.UI_INPUT_END, -380289053, a);
        }
    }

    private static FindGroupsPartDefinition m8813b(InjectorLike injectorLike) {
        return new FindGroupsPartDefinition(BackgroundPartDefinition.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m8815a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        C09682 c09682 = new C09682(this);
        subParts.a(this.f7586c, new StylingData(feedProps, PaddingStyle.o));
        subParts.a(this.f7587d, c09682);
        return c09682;
    }

    public final /* bridge */ /* synthetic */ void m8816a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -779207421);
        ((FindGroupsView) view).setButtonClickListener((OnClickListener) obj2);
        Logger.a(8, EntryType.MARK_POP, 14289044, a);
    }

    public final void m8818b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((FindGroupsView) view).setButtonClickListener(null);
    }

    @Inject
    public FindGroupsPartDefinition(BackgroundPartDefinition backgroundPartDefinition, IFeedIntentBuilder iFeedIntentBuilder, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f7585b = iFeedIntentBuilder;
        this.f7586c = backgroundPartDefinition;
        this.f7587d = clickListenerPartDefinition;
    }

    public final ViewType m8814a() {
        return f7582a;
    }

    public final boolean m8817a(Object obj) {
        return true;
    }

    public static FindGroupsPartDefinition m8812a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FindGroupsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7584f) {
                FindGroupsPartDefinition findGroupsPartDefinition;
                if (a2 != null) {
                    findGroupsPartDefinition = (FindGroupsPartDefinition) a2.a(f7584f);
                } else {
                    findGroupsPartDefinition = f7583e;
                }
                if (findGroupsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8813b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7584f, b3);
                        } else {
                            f7583e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = findGroupsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
