package com.facebook.feedplugins.pillsblingbar.ui;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedback.reactions.ui.PillsBlingBarPartDefinitionHelper;
import com.facebook.feedplugins.base.blingbar.BlingBarFlyoutAndVideoLauncherPartDefinition;
import com.facebook.feedplugins.base.blingbar.BlingBarFlyoutPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: hashed_uid */
public class PillsBlingBarPartDefinition<E extends CanShowVideoInFullScreen & HasPersistentState & HasPositionInformation> extends PillsBlingBarWithoutBackgroundPartDefinition<E> {
    private static PillsBlingBarPartDefinition f21217b;
    private static final Object f21218c = new Object();
    private final BackgroundPartDefinition f21219a;

    private static PillsBlingBarPartDefinition m28944c(InjectorLike injectorLike) {
        return new PillsBlingBarPartDefinition(BackgroundPartDefinition.m19135a(injectorLike), BlingBarFlyoutPartDefinition.m28929a(injectorLike), PillsBlingBarPartDefinitionHelper.m28925a(injectorLike), BlingBarFlyoutAndVideoLauncherPartDefinition.m28932a(injectorLike));
    }

    @Inject
    public PillsBlingBarPartDefinition(BackgroundPartDefinition backgroundPartDefinition, BlingBarFlyoutPartDefinition blingBarFlyoutPartDefinition, PillsBlingBarPartDefinitionHelper pillsBlingBarPartDefinitionHelper, BlingBarFlyoutAndVideoLauncherPartDefinition blingBarFlyoutAndVideoLauncherPartDefinition) {
        super(pillsBlingBarPartDefinitionHelper, blingBarFlyoutPartDefinition, blingBarFlyoutAndVideoLauncherPartDefinition);
        this.f21219a = backgroundPartDefinition;
    }

    public final Integer mo3155a(SubParts<E> subParts, FeedProps<GraphQLStory> feedProps, E e) {
        int intValue = super.mo3155a((SubParts) subParts, (FeedProps) feedProps, (CanShowVideoInFullScreen) e).intValue();
        subParts.mo2756a(this.f21219a, new StylingData(feedProps, PaddingStyle.f13085o));
        return Integer.valueOf(intValue);
    }

    public static PillsBlingBarPartDefinition m28943a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PillsBlingBarPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21218c) {
                PillsBlingBarPartDefinition pillsBlingBarPartDefinition;
                if (a2 != null) {
                    pillsBlingBarPartDefinition = (PillsBlingBarPartDefinition) a2.mo818a(f21218c);
                } else {
                    pillsBlingBarPartDefinition = f21217b;
                }
                if (pillsBlingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        c = m28944c(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21218c, c);
                        } else {
                            f21217b = c;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    c = pillsBlingBarPartDefinition;
                }
            }
            return c;
        } finally {
            a.m1505c(b);
        }
    }
}
