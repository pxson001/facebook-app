package com.facebook.feedplugins.findpages;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.findpages.ui.FindPagesView;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLFindPagesFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.pages.PageInfo;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.pages.data.cache.PagesInfoCache;
import javax.inject.Inject;

@ContextScoped
/* compiled from: donation_amount */
public class FindPagesPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLFindPagesFeedUnit>, Void, AnyEnvironment, FindPagesView> {
    public static final ViewType f7590a = new C09691();
    private static FindPagesPartDefinition f7591h;
    private static final Object f7592i = new Object();
    private final Context f7593b;
    private final ViewerContext f7594c;
    private final PagesInfoCache f7595d;
    public final IFeedIntentBuilder f7596e;
    private final ClickListenerPartDefinition f7597f;
    private final TextPartDefinition f7598g;

    /* compiled from: donation_amount */
    final class C09691 extends ViewType {
        C09691() {
        }

        public final View m8819a(Context context) {
            return new FindPagesView(context);
        }
    }

    /* compiled from: donation_amount */
    class C09702 implements OnClickListener {
        final /* synthetic */ FindPagesPartDefinition f7589a;

        C09702(FindPagesPartDefinition findPagesPartDefinition) {
            this.f7589a = findPagesPartDefinition;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1097269766);
            this.f7589a.f7596e.a(view.getContext(), "fb://faceweb/f?href=/pages?actAsPageID=%s");
            Logger.a(2, EntryType.UI_INPUT_END, -1981100883, a);
        }
    }

    private static FindPagesPartDefinition m8821b(InjectorLike injectorLike) {
        return new FindPagesPartDefinition((Context) injectorLike.getInstance(Context.class), ViewerContextMethodAutoProvider.b(injectorLike), PagesInfoCache.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m8823a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Flattenable flattenable = ((FeedProps) obj).a;
        PageInfo a = this.f7595d.a(this.f7594c.mUserId);
        subParts.a(2131562000, this.f7598g, StringFormatUtil.formatStrLocaleSafe(this.f7593b.getString(2131242481), a != null ? a.pageName : this.f7593b.getString(2131242479)));
        subParts.a(2131562001, this.f7597f, new C09702(this));
        return null;
    }

    @Inject
    public FindPagesPartDefinition(Context context, ViewerContext viewerContext, PagesInfoCache pagesInfoCache, IFeedIntentBuilder iFeedIntentBuilder, ClickListenerPartDefinition clickListenerPartDefinition, TextPartDefinition textPartDefinition) {
        this.f7593b = context;
        this.f7594c = viewerContext;
        this.f7595d = pagesInfoCache;
        this.f7596e = iFeedIntentBuilder;
        this.f7597f = clickListenerPartDefinition;
        this.f7598g = textPartDefinition;
    }

    public static FindPagesPartDefinition m8820a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FindPagesPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7592i) {
                FindPagesPartDefinition findPagesPartDefinition;
                if (a2 != null) {
                    findPagesPartDefinition = (FindPagesPartDefinition) a2.a(f7592i);
                } else {
                    findPagesPartDefinition = f7591h;
                }
                if (findPagesPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8821b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7592i, b3);
                        } else {
                            f7591h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = findPagesPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m8822a() {
        return f7590a;
    }

    public final boolean m8824a(Object obj) {
        return true;
    }
}
