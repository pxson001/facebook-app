package com.facebook.feedplugins.pymk.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feedplugins.friendingcommon.SmartButtonPartDefinition;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.FriendshipPersistentState;
import com.facebook.feedplugins.pymk.PymkGatekeepers;
import com.facebook.feedplugins.pymk.rows.components.BlacklistClickListener;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnitItem;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.VisibilityPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TJ */
public class PeopleYouMayKnowBlacklistPartDefinition<E extends HasInvalidate & HasPersistentState> extends BaseSinglePartDefinition<Props, Void, E, View> {
    private static PeopleYouMayKnowBlacklistPartDefinition f24751h;
    private static final Object f24752i = new Object();
    private final AllCapsTransformationMethod f24753a;
    private final ClickListenerPartDefinition f24754b;
    private final PymkGatekeepers f24755c;
    private final Resources f24756d;
    private final SmartButtonPartDefinition f24757e;
    private final VisibilityPartDefinition<E> f24758f;
    public final BlacklistClickListener<E> f24759g;

    /* compiled from: TJ */
    public class Props {
        public final PeopleYouMayKnowFeedUnit f24748a;
        public final PeopleYouMayKnowFeedUnitItem f24749b;
        public final FriendshipPersistentState f24750c;

        public Props(PeopleYouMayKnowFeedUnit peopleYouMayKnowFeedUnit, PeopleYouMayKnowFeedUnitItem peopleYouMayKnowFeedUnitItem, FriendshipPersistentState friendshipPersistentState) {
            this.f24748a = peopleYouMayKnowFeedUnit;
            this.f24749b = peopleYouMayKnowFeedUnitItem;
            this.f24750c = friendshipPersistentState;
        }
    }

    private static PeopleYouMayKnowBlacklistPartDefinition m26606b(InjectorLike injectorLike) {
        return new PeopleYouMayKnowBlacklistPartDefinition(AllCapsTransformationMethod.b(injectorLike), ClickListenerPartDefinition.a(injectorLike), PymkGatekeepers.m26572a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), SmartButtonPartDefinition.m26544a(injectorLike), VisibilityPartDefinition.a(injectorLike), BlacklistClickListener.m26661a(injectorLike));
    }

    public final Object m26607a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        final HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        int i = 0;
        ClickListenerPartDefinition clickListenerPartDefinition = this.f24754b;
        final PeopleYouMayKnowFeedUnit peopleYouMayKnowFeedUnit = props.f24748a;
        final PeopleYouMayKnowFeedUnitItem peopleYouMayKnowFeedUnitItem = props.f24749b;
        subParts.a(clickListenerPartDefinition, new OnClickListener(this) {
            final /* synthetic */ PeopleYouMayKnowBlacklistPartDefinition f24747d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1831772023);
                this.f24747d.f24759g.m26663a(peopleYouMayKnowFeedUnit, peopleYouMayKnowFeedUnitItem, hasInvalidate);
                Logger.a(2, EntryType.UI_INPUT_END, 1569981800, a);
            }
        });
        if (this.f24755c.f24692a || this.f24755c.f24694c || this.f24755c.f24695d) {
            subParts.a(this.f24757e, new com.facebook.feedplugins.friendingcommon.SmartButtonPartDefinition.Props(this.f24753a.getTransformation(this.f24756d.getString(2131235588), null), null, 2130839818, Integer.valueOf(this.f24756d.getColor(2131362106)), 0, 2130840353));
        } else if (this.f24755c.f24693b) {
            subParts.a(this.f24757e, new com.facebook.feedplugins.friendingcommon.SmartButtonPartDefinition.Props(this.f24753a.getTransformation(this.f24756d.getString(2131235588), null), null, 2130839818, Integer.valueOf(this.f24756d.getColor(2131362107)), 0, 2130840351));
        }
        VisibilityPartDefinition visibilityPartDefinition = this.f24758f;
        if (props.f24750c.f24683a != GraphQLFriendshipStatus.CAN_REQUEST) {
            i = 8;
        }
        subParts.a(visibilityPartDefinition, Integer.valueOf(i));
        return null;
    }

    public static PeopleYouMayKnowBlacklistPartDefinition m26605a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowBlacklistPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24752i) {
                PeopleYouMayKnowBlacklistPartDefinition peopleYouMayKnowBlacklistPartDefinition;
                if (a2 != null) {
                    peopleYouMayKnowBlacklistPartDefinition = (PeopleYouMayKnowBlacklistPartDefinition) a2.a(f24752i);
                } else {
                    peopleYouMayKnowBlacklistPartDefinition = f24751h;
                }
                if (peopleYouMayKnowBlacklistPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26606b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24752i, b3);
                        } else {
                            f24751h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowBlacklistPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PeopleYouMayKnowBlacklistPartDefinition(AllCapsTransformationMethod allCapsTransformationMethod, ClickListenerPartDefinition clickListenerPartDefinition, PymkGatekeepers pymkGatekeepers, Resources resources, SmartButtonPartDefinition smartButtonPartDefinition, VisibilityPartDefinition visibilityPartDefinition, BlacklistClickListener blacklistClickListener) {
        this.f24753a = allCapsTransformationMethod;
        this.f24754b = clickListenerPartDefinition;
        this.f24755c = pymkGatekeepers;
        this.f24756d = resources;
        this.f24757e = smartButtonPartDefinition;
        this.f24758f = visibilityPartDefinition;
        this.f24759g = blacklistClickListener;
    }
}
