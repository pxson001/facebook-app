package com.facebook.feedplugins.customizedstory;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.base.footer.DefaultFooterBackgroundPartDefinition;
import com.facebook.feedplugins.base.footer.DefaultFooterBackgroundPartDefinition.Props;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.rows.FooterButtonClickListenerPartDefinition;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.graphql.model.GraphQLCustomizedStory;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: presence_mqtt_receive_item_count */
public class CustomizedStoryFooterPartDefinition extends MultiRowSinglePartDefinition<GraphQLCustomizedStory, Void, AnyEnvironment, DefaultFooterView> {
    private static CustomizedStoryFooterPartDefinition f4283e;
    private static final Object f4284f = new Object();
    public final Activity f4285a;
    public final ComposerLauncher f4286b;
    private final DefaultFooterBackgroundPartDefinition<DefaultFooterView> f4287c;
    private final FooterButtonClickListenerPartDefinition f4288d;

    private static CustomizedStoryFooterPartDefinition m4814b(InjectorLike injectorLike) {
        return new CustomizedStoryFooterPartDefinition((ComposerLauncher) ComposerLauncherImpl.a(injectorLike), ActivityMethodAutoProvider.b(injectorLike), DefaultFooterBackgroundPartDefinition.a(injectorLike), FooterButtonClickListenerPartDefinition.m4821a(injectorLike));
    }

    public final Object m4817a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f4288d, new 1(this, (GraphQLCustomizedStory) obj));
        subParts.a(this.f4287c, new Props(false, false, true, FooterLevel.TOP, null));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m4818a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1937385109);
        ((DefaultFooterView) view).setButtons(ImmutableSet.of(FooterButtonId.SHARE));
        Logger.a(8, EntryType.MARK_POP, -1598112650, a);
    }

    public final boolean m4819a(Object obj) {
        return m4815d((GraphQLCustomizedStory) obj) != null;
    }

    @Inject
    public CustomizedStoryFooterPartDefinition(ComposerLauncher composerLauncher, Activity activity, DefaultFooterBackgroundPartDefinition defaultFooterBackgroundPartDefinition, FooterButtonClickListenerPartDefinition footerButtonClickListenerPartDefinition) {
        this.f4286b = composerLauncher;
        this.f4285a = activity;
        this.f4287c = defaultFooterBackgroundPartDefinition;
        this.f4288d = footerButtonClickListenerPartDefinition;
    }

    public final ViewType m4816a() {
        return DefaultFooterView.a;
    }

    public static CustomizedStoryFooterPartDefinition m4813a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CustomizedStoryFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4284f) {
                CustomizedStoryFooterPartDefinition customizedStoryFooterPartDefinition;
                if (a2 != null) {
                    customizedStoryFooterPartDefinition = (CustomizedStoryFooterPartDefinition) a2.a(f4284f);
                } else {
                    customizedStoryFooterPartDefinition = f4283e;
                }
                if (customizedStoryFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4814b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4284f, b3);
                        } else {
                            f4283e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = customizedStoryFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static GraphQLEntity m4815d(GraphQLCustomizedStory graphQLCustomizedStory) {
        return graphQLCustomizedStory.F();
    }
}
