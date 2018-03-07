package com.facebook.feedplugins.pyml.rows.contentbased;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.base.footer.OneButtonFooterStylerPartDefinition;
import com.facebook.feedplugins.base.footer.ui.OneButtonFooterView;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
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
import com.facebook.multirow.parts.TextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android.permission.ACCESS_NETWORK_STATE */
public class ContentBasedPagesYouMayLikeFooterPartDefinition extends MultiRowSinglePartDefinition<GraphQLPagesYouMayLikeFeedUnit, Void, AnyEnvironment, OneButtonFooterView> {
    private static ContentBasedPagesYouMayLikeFooterPartDefinition f19842f;
    private static final Object f19843g = new Object();
    public final Context f19844a;
    public final IFeedIntentBuilder f19845b;
    private final OneButtonFooterStylerPartDefinition f19846c;
    private final TextPartDefinition f19847d;
    private final ClickListenerPartDefinition f19848e;

    private static ContentBasedPagesYouMayLikeFooterPartDefinition m20066b(InjectorLike injectorLike) {
        return new ContentBasedPagesYouMayLikeFooterPartDefinition((Context) injectorLike.getInstance(Context.class), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), OneButtonFooterStylerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m20068a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.aK, "top");
        subParts.a(this.f19848e, new OnClickListener(this) {
            final /* synthetic */ ContentBasedPagesYouMayLikeFooterPartDefinition f19841b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1341080481);
                this.f19841b.f19845b.a(this.f19841b.f19844a, formatStrLocaleSafe);
                Logger.a(2, EntryType.UI_INPUT_END, 677128078, a);
            }
        });
        subParts.a(this.f19846c, null);
        subParts.a(2131559974, this.f19847d, this.f19844a.getString(2131233488));
        return null;
    }

    @Inject
    public ContentBasedPagesYouMayLikeFooterPartDefinition(Context context, IFeedIntentBuilder iFeedIntentBuilder, OneButtonFooterStylerPartDefinition oneButtonFooterStylerPartDefinition, TextPartDefinition textPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f19844a = context;
        this.f19845b = iFeedIntentBuilder;
        this.f19846c = oneButtonFooterStylerPartDefinition;
        this.f19847d = textPartDefinition;
        this.f19848e = clickListenerPartDefinition;
    }

    public final ViewType m20067a() {
        return OneButtonFooterView.a;
    }

    public final boolean m20069a(Object obj) {
        return true;
    }

    public static ContentBasedPagesYouMayLikeFooterPartDefinition m20065a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContentBasedPagesYouMayLikeFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19843g) {
                ContentBasedPagesYouMayLikeFooterPartDefinition contentBasedPagesYouMayLikeFooterPartDefinition;
                if (a2 != null) {
                    contentBasedPagesYouMayLikeFooterPartDefinition = (ContentBasedPagesYouMayLikeFooterPartDefinition) a2.a(f19843g);
                } else {
                    contentBasedPagesYouMayLikeFooterPartDefinition = f19842f;
                }
                if (contentBasedPagesYouMayLikeFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20066b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19843g, b3);
                        } else {
                            f19842f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = contentBasedPagesYouMayLikeFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
