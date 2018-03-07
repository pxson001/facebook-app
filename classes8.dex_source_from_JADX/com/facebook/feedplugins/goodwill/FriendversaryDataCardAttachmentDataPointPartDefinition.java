package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: graph_search_results_pull_to_refresh */
public class FriendversaryDataCardAttachmentDataPointPartDefinition extends MultiRowSinglePartDefinition<FriendversaryDataCardAttachmentDataPointProps, Void, HasPositionInformation, FriendversaryDataCardDataPointView> {
    public static final ViewType f12232a = new C13001();
    private static FriendversaryDataCardAttachmentDataPointPartDefinition f12233c;
    private static final Object f12234d = new Object();
    private final BackgroundPartDefinition f12235b;

    /* compiled from: graph_search_results_pull_to_refresh */
    final class C13001 extends ViewType {
        C13001() {
        }

        public final View m14199a(Context context) {
            return new FriendversaryDataCardDataPointView(context);
        }
    }

    private static FriendversaryDataCardAttachmentDataPointPartDefinition m14202b(InjectorLike injectorLike) {
        return new FriendversaryDataCardAttachmentDataPointPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m14204a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FriendversaryDataCardAttachmentDataPointProps friendversaryDataCardAttachmentDataPointProps = (FriendversaryDataCardAttachmentDataPointProps) obj;
        Builder f = Builder.f();
        f.d = friendversaryDataCardAttachmentDataPointProps.f12236a;
        f = f;
        f.c = 8.0f;
        subParts.a(this.f12235b, new StylingData(friendversaryDataCardAttachmentDataPointProps.f12240e, f.i(), friendversaryDataCardAttachmentDataPointProps.f12239d));
        return null;
    }

    public final boolean m14206a(Object obj) {
        FriendversaryDataCardAttachmentDataPointProps friendversaryDataCardAttachmentDataPointProps = (FriendversaryDataCardAttachmentDataPointProps) obj;
        return (friendversaryDataCardAttachmentDataPointProps.f12237b.j() == null || TextUtils.isEmpty(friendversaryDataCardAttachmentDataPointProps.f12237b.j().a()) || friendversaryDataCardAttachmentDataPointProps.f12237b.a() == null || friendversaryDataCardAttachmentDataPointProps.f12238c == null) ? false : true;
    }

    @Inject
    public FriendversaryDataCardAttachmentDataPointPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f12235b = backgroundPartDefinition;
    }

    public final ViewType m14203a() {
        return f12232a;
    }

    public static FriendversaryDataCardAttachmentDataPointPartDefinition m14200a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendversaryDataCardAttachmentDataPointPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12234d) {
                FriendversaryDataCardAttachmentDataPointPartDefinition friendversaryDataCardAttachmentDataPointPartDefinition;
                if (a2 != null) {
                    friendversaryDataCardAttachmentDataPointPartDefinition = (FriendversaryDataCardAttachmentDataPointPartDefinition) a2.a(f12234d);
                } else {
                    friendversaryDataCardAttachmentDataPointPartDefinition = f12233c;
                }
                if (friendversaryDataCardAttachmentDataPointPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14202b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12234d, b3);
                        } else {
                            f12233c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendversaryDataCardAttachmentDataPointPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m14201a(FriendversaryDataCardAttachmentDataPointProps friendversaryDataCardAttachmentDataPointProps, Void voidR, HasPositionInformation hasPositionInformation, FriendversaryDataCardDataPointView friendversaryDataCardDataPointView) {
        super.a(friendversaryDataCardAttachmentDataPointProps, voidR, hasPositionInformation, friendversaryDataCardDataPointView);
        friendversaryDataCardDataPointView.m14235a(friendversaryDataCardAttachmentDataPointProps.f12237b.j().a(), friendversaryDataCardAttachmentDataPointProps.f12237b.a().b());
    }
}
