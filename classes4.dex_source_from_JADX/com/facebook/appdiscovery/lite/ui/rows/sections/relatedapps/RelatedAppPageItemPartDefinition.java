package com.facebook.appdiscovery.lite.ui.rows.sections.relatedapps;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.appdiscovery.lite.model.util.StoryUtil;
import com.facebook.appdiscovery.lite.model.util.StoryUtilProvider;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLInterfaces.ActorFacePileFragment;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLInterfaces.AppStoryQueryFragment;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: num_total_stories_in_cache */
public class RelatedAppPageItemPartDefinition extends MultiRowSinglePartDefinition<AppStoryQueryFragment, Void, AnyEnvironment, SmallPageItemView> {
    public static final ViewType<SmallPageItemView> f6533a = new C02951();
    private static RelatedAppPageItemPartDefinition f6534d;
    private static final Object f6535e = new Object();
    private final TextPartDefinition f6536b;
    private final StoryUtilProvider f6537c;

    /* compiled from: num_total_stories_in_cache */
    final class C02951 extends ViewType {
        C02951() {
        }

        public final View m6959a(Context context) {
            return new SmallPageItemView(context);
        }
    }

    private static RelatedAppPageItemPartDefinition m6955b(InjectorLike injectorLike) {
        return new RelatedAppPageItemPartDefinition(TextPartDefinition.a(injectorLike), (StoryUtilProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(StoryUtilProvider.class));
    }

    public final /* bridge */ /* synthetic */ void m6957a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2008151568);
        SmallPageItemView smallPageItemView = (SmallPageItemView) view;
        StoryUtil storyUtil = new StoryUtil((AppStoryQueryFragment) obj);
        if (storyUtil.d == null) {
            storyUtil.d = (ActorFacePileFragment) StoryUtil.a(storyUtil.a.kV_());
        }
        ActorFacePileFragment actorFacePileFragment = storyUtil.d;
        String str = null;
        if (!(actorFacePileFragment == null || StringUtil.a(actorFacePileFragment.b()))) {
            str = actorFacePileFragment.b();
        }
        smallPageItemView.d.setText(str);
        smallPageItemView.e.setText(storyUtil.a());
        Object b = storyUtil.b();
        if (!StringUtil.a(b)) {
            Uri parse = Uri.parse(b);
            if (parse != null) {
                smallPageItemView.c.a(parse, SmallPageItemView.a);
            }
        }
        Logger.a(8, EntryType.MARK_POP, -1286665326, a);
    }

    public final boolean m6958a(Object obj) {
        AppStoryQueryFragment appStoryQueryFragment = (AppStoryQueryFragment) obj;
        return (appStoryQueryFragment.kW_() == null || StringUtil.a(appStoryQueryFragment.kW_().a())) ? false : true;
    }

    @Inject
    public RelatedAppPageItemPartDefinition(TextPartDefinition textPartDefinition, StoryUtilProvider storyUtilProvider) {
        this.f6536b = textPartDefinition;
        this.f6537c = storyUtilProvider;
    }

    public final ViewType<SmallPageItemView> m6956a() {
        return f6533a;
    }

    public static RelatedAppPageItemPartDefinition m6954a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RelatedAppPageItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6535e) {
                RelatedAppPageItemPartDefinition relatedAppPageItemPartDefinition;
                if (a2 != null) {
                    relatedAppPageItemPartDefinition = (RelatedAppPageItemPartDefinition) a2.a(f6535e);
                } else {
                    relatedAppPageItemPartDefinition = f6534d;
                }
                if (relatedAppPageItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6955b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6535e, b3);
                        } else {
                            f6534d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = relatedAppPageItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
