package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.appads.analytics.AppFeedReferrer;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feedplugins.storyset.ExperimentsForStorySetModule;
import com.facebook.feedplugins.storyset.rows.ui.StoryPageAppInstallPromoCardView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: autoCapitalize */
public class StorySetPageAppInstallPartDefinition extends BaseSinglePartDefinition<StorySetPageProps, State, AnyEnvironment, StoryPageAppInstallPromoCardView> {
    private static StorySetPageAppInstallPartDefinition f9714e;
    private static final Object f9715f = new Object();
    public final Context f9716a;
    private final UriIntentMapper f9717b;
    public final SecureContextHelper f9718c;
    public final QeAccessor f9719d;

    /* compiled from: autoCapitalize */
    public class State {
        public OnClickListener f9713a;

        public State(OnClickListener onClickListener) {
            this.f9713a = onClickListener;
        }
    }

    private static StorySetPageAppInstallPartDefinition m10172b(InjectorLike injectorLike) {
        return new StorySetPageAppInstallPartDefinition((Context) injectorLike.getInstance(Context.class), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m10174a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1538136546);
        StorySetPageProps storySetPageProps = (StorySetPageProps) obj;
        State state = (State) obj2;
        StoryPageAppInstallPromoCardView storyPageAppInstallPromoCardView = (StoryPageAppInstallPromoCardView) view;
        storyPageAppInstallPromoCardView.f9847b.setText(this.f9719d.a(ExperimentsForStorySetModule.d, "See More Apps"));
        storyPageAppInstallPromoCardView.f9848c.setText(this.f9719d.a(ExperimentsForStorySetModule.a, "Discover new apps for your phone."));
        storyPageAppInstallPromoCardView.f9849d.setText(this.f9719d.a(ExperimentsForStorySetModule.c, "See More Apps"));
        storyPageAppInstallPromoCardView.setOnClickListener(state.f9713a);
        int i = storySetPageProps.f9735d;
        int dimensionPixelSize = storyPageAppInstallPromoCardView.getResources().getDimensionPixelSize(2131430232);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) storyPageAppInstallPromoCardView.f9850e.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = dimensionPixelSize;
            marginLayoutParams.bottomMargin = dimensionPixelSize;
        }
        if (storyPageAppInstallPromoCardView.f9851f.getLayoutParams() != null) {
            storyPageAppInstallPromoCardView.f9851f.getLayoutParams().width = i;
        }
        Logger.a(8, EntryType.MARK_POP, -1151542988, a);
    }

    public final void m10175b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((StoryPageAppInstallPromoCardView) view).setOnClickListener(null);
    }

    @Inject
    public StorySetPageAppInstallPartDefinition(Context context, UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper, QeAccessor qeAccessor) {
        this.f9716a = context;
        this.f9717b = uriIntentMapper;
        this.f9718c = secureContextHelper;
        this.f9719d = qeAccessor;
    }

    public static StorySetPageAppInstallPartDefinition m10171a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetPageAppInstallPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9715f) {
                StorySetPageAppInstallPartDefinition storySetPageAppInstallPartDefinition;
                if (a2 != null) {
                    storySetPageAppInstallPartDefinition = (StorySetPageAppInstallPartDefinition) a2.a(f9715f);
                } else {
                    storySetPageAppInstallPartDefinition = f9714e;
                }
                if (storySetPageAppInstallPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10172b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9715f, b3);
                        } else {
                            f9714e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetPageAppInstallPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m10173a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Intent putExtra = this.f9717b.a(this.f9716a, FBLinks.dN).addFlags(268435456).putExtra("referrer", AppFeedReferrer.END_OF_HSCROLL);
        return new State(new OnClickListener(this) {
            final /* synthetic */ StorySetPageAppInstallPartDefinition f9712b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1773717636);
                this.f9712b.f9718c.a(putExtra, this.f9712b.f9716a);
                Logger.a(2, EntryType.UI_INPUT_END, 390492901, a);
            }
        });
    }
}
