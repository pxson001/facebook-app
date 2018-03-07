package com.facebook.feedplugins.links;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.sections.header.ui.HasClickableProfileImage;
import com.facebook.feed.rows.util.ProfileLinkHandler;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
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
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: presence_lru_cache_inbox_threads_size */
public class ProfileLinkPartDefinition<T extends Flattenable, V extends View & HasClickableProfileImage> extends BaseSinglePartDefinition<Props<T>, OnClickListener, AnyEnvironment, V> {
    private static ProfileLinkPartDefinition f4294b;
    private static final Object f4295c = new Object();
    public final ProfileLinkHandler f4296a;

    private static ProfileLinkPartDefinition m4835b(InjectorLike injectorLike) {
        return new ProfileLinkPartDefinition(new ProfileLinkHandler((IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), GraphQLLinkExtractor.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), NavigationLogger.a(injectorLike)));
    }

    public final Object m4836a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return new 1(this, (Props) obj);
    }

    public final /* bridge */ /* synthetic */ void m4837a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -428660144);
        m4834a((OnClickListener) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -1636166755, a);
    }

    @Inject
    public ProfileLinkPartDefinition(ProfileLinkHandler profileLinkHandler) {
        this.f4296a = profileLinkHandler;
    }

    public static ProfileLinkPartDefinition m4833a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProfileLinkPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4295c) {
                ProfileLinkPartDefinition profileLinkPartDefinition;
                if (a2 != null) {
                    profileLinkPartDefinition = (ProfileLinkPartDefinition) a2.a(f4295c);
                } else {
                    profileLinkPartDefinition = f4294b;
                }
                if (profileLinkPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4835b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4295c, b3);
                        } else {
                            f4294b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = profileLinkPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static void m4834a(OnClickListener onClickListener, V v) {
        ((HasClickableProfileImage) v).setProfileImageOnClickListener(onClickListener);
    }

    public final void m4838b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((HasClickableProfileImage) view).setProfileImageOnClickListener(null);
    }
}
