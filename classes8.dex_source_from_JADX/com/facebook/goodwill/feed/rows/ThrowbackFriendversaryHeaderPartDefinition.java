package com.facebook.goodwill.feed.rows;

import android.content.Context;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackFriendversaryStory;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fb4a_iab_open_url */
public class ThrowbackFriendversaryHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLGoodwillThrowbackFriendversaryStory>, State, HasPositionInformation, ThrowbackFriendversaryHeaderView> {
    private static final PaddingStyle f13723b;
    private static ThrowbackFriendversaryHeaderPartDefinition f13724c;
    private static final Object f13725d = new Object();
    private final BackgroundPartDefinition f13726a;

    /* compiled from: fb4a_iab_open_url */
    public class State {
        public final Spannable f13721a;
        public final Uri f13722b;

        public State(Spannable spannable, Uri uri) {
            this.f13721a = spannable;
            this.f13722b = uri;
        }
    }

    private static ThrowbackFriendversaryHeaderPartDefinition m15407b(InjectorLike injectorLike) {
        return new ThrowbackFriendversaryHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m15409a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Uri uri;
        Spannable spannable = null;
        GraphQLGoodwillThrowbackFriendversaryStory graphQLGoodwillThrowbackFriendversaryStory = (GraphQLGoodwillThrowbackFriendversaryStory) ((FeedProps) obj).a;
        subParts.a(this.f13726a, new StylingData(null, f13723b, Position.TOP));
        if (graphQLGoodwillThrowbackFriendversaryStory == null || graphQLGoodwillThrowbackFriendversaryStory.m() == null || graphQLGoodwillThrowbackFriendversaryStory.m().a() == null) {
            uri = null;
        } else {
            CharSequence spannableString = new SpannableString(graphQLGoodwillThrowbackFriendversaryStory.m().a());
            if (graphQLGoodwillThrowbackFriendversaryStory.k() != null) {
                uri = ImageUtil.a(graphQLGoodwillThrowbackFriendversaryStory.k());
                spannable = spannableString;
            } else {
                uri = null;
                CharSequence charSequence = spannableString;
            }
        }
        return new State(spannable, uri);
    }

    public final /* bridge */ /* synthetic */ void m15410a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1065983993);
        State state = (State) obj2;
        ThrowbackFriendversaryHeaderView throwbackFriendversaryHeaderView = (ThrowbackFriendversaryHeaderView) view;
        CharSequence charSequence = state.f13721a;
        if (charSequence != null) {
            throwbackFriendversaryHeaderView.f13730d.setText(charSequence);
            throwbackFriendversaryHeaderView.f13730d.setVisibility(0);
        } else {
            throwbackFriendversaryHeaderView.f13730d.setVisibility(8);
        }
        if (null != null) {
            throwbackFriendversaryHeaderView.f13731e.setText(null);
            throwbackFriendversaryHeaderView.f13731e.setVisibility(0);
        } else {
            throwbackFriendversaryHeaderView.f13731e.setVisibility(8);
        }
        throwbackFriendversaryHeaderView.f13729c.a(state.f13722b, ThrowbackFriendversaryHeaderView.f13728b);
        Logger.a(8, EntryType.MARK_POP, 2063028749, a);
    }

    public final boolean m15411a(Object obj) {
        GraphQLGoodwillThrowbackFriendversaryStory graphQLGoodwillThrowbackFriendversaryStory = (GraphQLGoodwillThrowbackFriendversaryStory) ((FeedProps) obj).a;
        return (graphQLGoodwillThrowbackFriendversaryStory.m() == null || TextUtils.isEmpty(graphQLGoodwillThrowbackFriendversaryStory.m().a())) ? false : true;
    }

    static {
        Builder a = Builder.a();
        a.b = 6.0f;
        f13723b = a.i();
    }

    @Inject
    public ThrowbackFriendversaryHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f13726a = backgroundPartDefinition;
    }

    public final ViewType m15408a() {
        return ThrowbackFriendversaryHeaderView.f13727a;
    }

    public static ThrowbackFriendversaryHeaderPartDefinition m15406a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFriendversaryHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13725d) {
                ThrowbackFriendversaryHeaderPartDefinition throwbackFriendversaryHeaderPartDefinition;
                if (a2 != null) {
                    throwbackFriendversaryHeaderPartDefinition = (ThrowbackFriendversaryHeaderPartDefinition) a2.a(f13725d);
                } else {
                    throwbackFriendversaryHeaderPartDefinition = f13724c;
                }
                if (throwbackFriendversaryHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15407b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13725d, b3);
                        } else {
                            f13724c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFriendversaryHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
