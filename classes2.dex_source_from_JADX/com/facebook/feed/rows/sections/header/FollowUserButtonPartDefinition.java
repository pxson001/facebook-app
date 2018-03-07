package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFollowUser;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.sections.header.SpringScaleButtonPartDefinition.Props;
import com.facebook.graphql.calls.ActorSubscribeInputData.SubscribeLocation;
import com.facebook.graphql.calls.ActorUnsubscribeInputData;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
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
import com.facebook.widget.springbutton.SpringScaleButton;
import javax.inject.Inject;

@ContextScoped
/* compiled from: http_code */
public class FollowUserButtonPartDefinition<E extends CanFollowUser & HasPersistentState> extends BaseSinglePartDefinition<Props, Boolean, E, SpringScaleButton> {
    private static FollowUserButtonPartDefinition f20736b;
    private static final Object f20737c = new Object();
    private final SpringScaleButtonPartDefinition f20738a;

    private static FollowUserButtonPartDefinition m28457b(InjectorLike injectorLike) {
        return new FollowUserButtonPartDefinition(SpringScaleButtonPartDefinition.m28460a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        CanFollowUser canFollowUser = (CanFollowUser) anyEnvironment;
        boolean z = props.b == GraphQLSubscribeStatus.IS_SUBSCRIBED;
        subParts.mo2756a(this.f20738a, new Props(props.a, props.c, m28455a(props.c, props.b, props.d, props.e, canFollowUser), z));
        return Boolean.valueOf(z);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1292115437);
        Props props = (Props) obj;
        ((SpringScaleButton) view).setImageResource(((Boolean) obj2).booleanValue() ? props.g : props.f);
        Logger.a(8, EntryType.MARK_POP, 1225894089, a);
    }

    public static FollowUserButtonPartDefinition m28456a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FollowUserButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20737c) {
                FollowUserButtonPartDefinition followUserButtonPartDefinition;
                if (a2 != null) {
                    followUserButtonPartDefinition = (FollowUserButtonPartDefinition) a2.mo818a(f20737c);
                } else {
                    followUserButtonPartDefinition = f20736b;
                }
                if (followUserButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28457b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20737c, b3);
                        } else {
                            f20736b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = followUserButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public FollowUserButtonPartDefinition(SpringScaleButtonPartDefinition springScaleButtonPartDefinition) {
        this.f20738a = springScaleButtonPartDefinition;
    }

    public static <E extends CanFollowUser> OnClickListener m28455a(String str, GraphQLSubscribeStatus graphQLSubscribeStatus, SubscribeLocation subscribeLocation, ActorUnsubscribeInputData.SubscribeLocation subscribeLocation2, E e) {
        return new 1(graphQLSubscribeStatus, e, str, subscribeLocation2, subscribeLocation);
    }
}
