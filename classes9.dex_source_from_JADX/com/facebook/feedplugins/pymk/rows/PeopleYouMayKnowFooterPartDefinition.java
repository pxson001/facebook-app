package com.facebook.feedplugins.pymk.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.base.footer.OneButtonFooterStylerPartDefinition;
import com.facebook.feedplugins.base.footer.ui.OneButtonFooterView;
import com.facebook.friending.center.constants.FriendsCenterSource;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.NeedsApplicationInjector;
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
import com.facebook.multirow.parts.ContentDescriptionPartDefinition;
import com.facebook.multirow.parts.ResourceIdTextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TItem;FFFZ)V */
public class PeopleYouMayKnowFooterPartDefinition<T extends ScrollableItemListFeedUnit> extends MultiRowSinglePartDefinition<FeedProps<T>, Void, HasPositionInformation, OneButtonFooterView> {
    private static final PaddingStyle f24761a;
    private static PeopleYouMayKnowFooterPartDefinition f24762i;
    private static final Object f24763j = new Object();
    private final Resources f24764b;
    public final IFeedIntentBuilder f24765c;
    private final OneButtonFooterStylerPartDefinition f24766d;
    private final BackgroundPartDefinition f24767e;
    private final ClickListenerPartDefinition f24768f;
    private final ResourceIdTextPartDefinition f24769g;
    private final ContentDescriptionPartDefinition f24770h;

    /* compiled from: TItem;FFFZ)V */
    public class C29851 implements OnClickListener {
        final /* synthetic */ PeopleYouMayKnowFooterPartDefinition f24760a;

        public C29851(PeopleYouMayKnowFooterPartDefinition peopleYouMayKnowFooterPartDefinition) {
            this.f24760a = peopleYouMayKnowFooterPartDefinition;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -317618497);
            this.f24760a.f24765c.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.cc, FriendsCenterSource.FEED_PYMK.name()));
            Logger.a(2, EntryType.UI_INPUT_END, 952928915, a);
        }
    }

    private static PeopleYouMayKnowFooterPartDefinition m26609b(InjectorLike injectorLike) {
        return new PeopleYouMayKnowFooterPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), OneButtonFooterStylerPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), ResourceIdTextPartDefinition.a(injectorLike), ContentDescriptionPartDefinition.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike.getApplicationInjector()));
    }

    public final Object m26611a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        if (((HasPositionInformation) anyEnvironment).h() == null) {
            subParts.a(this.f24766d, null);
        } else {
            subParts.a(this.f24767e, new StylingData(feedProps, f24761a));
        }
        subParts.a(2131559974, this.f24769g, Integer.valueOf(2131235585));
        subParts.a(2131559974, this.f24770h, this.f24764b.getString(2131235584));
        subParts.a(this.f24768f, new C29851(this));
        return null;
    }

    static {
        Builder a = Builder.a();
        a.c = -8.0f;
        f24761a = a.i();
    }

    @Inject
    public PeopleYouMayKnowFooterPartDefinition(Resources resources, ClickListenerPartDefinition clickListenerPartDefinition, OneButtonFooterStylerPartDefinition oneButtonFooterStylerPartDefinition, BackgroundPartDefinition backgroundPartDefinition, ResourceIdTextPartDefinition resourceIdTextPartDefinition, ContentDescriptionPartDefinition contentDescriptionPartDefinition, @NeedsApplicationInjector IFeedIntentBuilder iFeedIntentBuilder) {
        this.f24764b = resources;
        this.f24768f = clickListenerPartDefinition;
        this.f24766d = oneButtonFooterStylerPartDefinition;
        this.f24767e = backgroundPartDefinition;
        this.f24769g = resourceIdTextPartDefinition;
        this.f24770h = contentDescriptionPartDefinition;
        this.f24765c = iFeedIntentBuilder;
    }

    public static PeopleYouMayKnowFooterPartDefinition m26608a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24763j) {
                PeopleYouMayKnowFooterPartDefinition peopleYouMayKnowFooterPartDefinition;
                if (a2 != null) {
                    peopleYouMayKnowFooterPartDefinition = (PeopleYouMayKnowFooterPartDefinition) a2.a(f24763j);
                } else {
                    peopleYouMayKnowFooterPartDefinition = f24762i;
                }
                if (peopleYouMayKnowFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26609b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24763j, b3);
                        } else {
                            f24762i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m26610a() {
        return OneButtonFooterView.a;
    }

    public final boolean m26612a(Object obj) {
        return true;
    }
}
