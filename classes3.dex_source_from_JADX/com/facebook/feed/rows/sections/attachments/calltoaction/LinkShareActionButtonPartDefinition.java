package com.facebook.feed.rows.sections.attachments.calltoaction;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: VideoPartDefinition.bind */
public class LinkShareActionButtonPartDefinition extends BaseSinglePartDefinition<GraphQLStoryAttachment, CharSequence, AnyEnvironment, BetterTextView> {
    private static LinkShareActionButtonPartDefinition f326d;
    private static final Object f327e = new Object();
    public final Activity f328a;
    public final ComposerLauncher f329b;
    private final ClickListenerPartDefinition f330c;

    private static LinkShareActionButtonPartDefinition m290b(InjectorLike injectorLike) {
        return new LinkShareActionButtonPartDefinition(ActivityMethodAutoProvider.b(injectorLike), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    @Nullable
    public final Object m291a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStoryActionLink a = ActionLinkHelper.a((GraphQLStoryAttachment) obj, 41461717);
        if (a == null) {
            return null;
        }
        subParts.a(this.f330c, new 1(this, a));
        return a.aB();
    }

    public final /* bridge */ /* synthetic */ void m292a(Object obj, @Nullable Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -739099455);
        ((BetterTextView) view).setText((CharSequence) obj2);
        Logger.a(8, EntryType.MARK_POP, 220230107, a);
    }

    @Inject
    public LinkShareActionButtonPartDefinition(Activity activity, ComposerLauncher composerLauncher, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f328a = activity;
        this.f329b = composerLauncher;
        this.f330c = clickListenerPartDefinition;
    }

    public static LinkShareActionButtonPartDefinition m289a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LinkShareActionButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f327e) {
                LinkShareActionButtonPartDefinition linkShareActionButtonPartDefinition;
                if (a2 != null) {
                    linkShareActionButtonPartDefinition = (LinkShareActionButtonPartDefinition) a2.a(f327e);
                } else {
                    linkShareActionButtonPartDefinition = f326d;
                }
                if (linkShareActionButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m290b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f327e, b3);
                        } else {
                            f326d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = linkShareActionButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
