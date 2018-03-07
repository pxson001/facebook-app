package com.facebook.feedplugins.facebookvoice;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;

/* compiled from: SuggestEdits */
public abstract class FacebookVoiceBasePartDefinition<FeedUnit extends Flattenable, E extends AnyEnvironment> extends MultiRowSinglePartDefinition<FeedProps<FeedUnit>, State, E, FacebookVoiceHeaderView> {
    public static final ViewType f23077a = new C19961();
    public final CallerContext f23078b = CallerContext.a(getClass(), "native_newsfeed");

    /* compiled from: SuggestEdits */
    final class C19961 extends ViewType {
        C19961() {
        }

        public final View m25519a(Context context) {
            return new FacebookVoiceHeaderView(context);
        }
    }

    /* compiled from: SuggestEdits */
    public class State {
        public final String f23065a;
        public final CharSequence f23066b;
        public final GraphQLTextWithEntities f23067c;
        public final boolean f23068d;
        public final GraphQLImage f23069e;
        public final int f23070f;
        public final boolean f23071g;
        public final GraphQLImage f23072h;
        public final GraphQLImage f23073i;
        public final boolean f23074j;
        public final int f23075k;
        public final float f23076l;

        public State(String str, CharSequence charSequence, GraphQLTextWithEntities graphQLTextWithEntities, boolean z, GraphQLImage graphQLImage, int i, boolean z2, GraphQLImage graphQLImage2, boolean z3, GraphQLImage graphQLImage3, int i2, float f) {
            this.f23065a = str;
            this.f23066b = charSequence;
            this.f23067c = graphQLTextWithEntities;
            this.f23068d = z;
            this.f23069e = graphQLImage;
            this.f23070f = i;
            this.f23071g = z2;
            this.f23072h = graphQLImage2;
            this.f23074j = z3;
            this.f23073i = graphQLImage3;
            this.f23075k = i2;
            this.f23076l = f;
        }
    }

    public final /* bridge */ /* synthetic */ void m25521a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1400650095);
        State state = (State) obj2;
        FacebookVoiceHeaderView facebookVoiceHeaderView = (FacebookVoiceHeaderView) view;
        facebookVoiceHeaderView.setContentSummaryColor(state.f23070f);
        facebookVoiceHeaderView.m25530a(state.f23065a, state.f23066b, state.f23067c);
        float f = state.f23076l;
        if (f > 0.0f) {
            facebookVoiceHeaderView.f23084d.getLayoutParams().width = SizeUtil.a(facebookVoiceHeaderView.getContext(), f);
        }
        facebookVoiceHeaderView.setOverlapMode(state.f23074j);
        facebookVoiceHeaderView.setMenuButtonActive(state.f23068d);
        facebookVoiceHeaderView.m25529a(state.f23069e, state.f23071g, this.f23078b);
        facebookVoiceHeaderView.m25528a(state.f23072h, this.f23078b);
        facebookVoiceHeaderView.m25531b(state.f23073i, this.f23078b);
        int i = state.f23075k;
        int dimensionPixelSize = facebookVoiceHeaderView.getContext().getResources().getDimensionPixelSize(2131432747);
        if (i == 0) {
            dimensionPixelSize = 0;
        }
        facebookVoiceHeaderView.f23088h.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        facebookVoiceHeaderView.f23088h.setBackgroundResource(i);
        Logger.a(8, EntryType.MARK_POP, 924634198, a);
    }

    public final ViewType m25520a() {
        return f23077a;
    }
}
