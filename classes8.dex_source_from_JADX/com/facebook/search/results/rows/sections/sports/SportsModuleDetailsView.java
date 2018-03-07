package com.facebook.search.results.rows.sections.sports;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.results.model.unit.SearchResultsSportsUnit.Team;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: POST_CHECKIN */
public class SportsModuleDetailsView extends CustomRelativeLayout {
    public static final CallerContext f25060a = CallerContext.a(SportsModuleDetailsView.class, "graph_search_results_page");
    public FbUriIntentHandler f25061b;
    public GraphQLLinkExtractor f25062c;
    public Provider<FbDraweeControllerBuilder> f25063d;
    public TeamSubViews f25064e = new TeamSubViews(this, 2131564240, 2131564241, 2131564242, 2131564243);
    public TeamSubViews f25065f = new TeamSubViews(this, 2131564245, 2131564246, 2131564247, 2131564248);
    public BetterTextView f25066g = ((BetterTextView) a(2131563416));
    public BetterTextView f25067h = ((BetterTextView) a(2131564244));
    @Nullable
    public LinearLayout f25068i = null;

    /* compiled from: POST_CHECKIN */
    public class TeamSubViews {
        public FbDraweeView f25054a;
        public BetterTextView f25055b;
        public BetterTextView f25056c;
        public BetterTextView f25057d;
        public final /* synthetic */ SportsModuleDetailsView f25058e;
        public Team f25059f;

        public TeamSubViews(final SportsModuleDetailsView sportsModuleDetailsView, int i, int i2, int i3, int i4) {
            this.f25058e = sportsModuleDetailsView;
            this.f25054a = (FbDraweeView) sportsModuleDetailsView.a(i);
            this.f25055b = (BetterTextView) sportsModuleDetailsView.a(i2);
            this.f25056c = (BetterTextView) sportsModuleDetailsView.a(i3);
            this.f25057d = (BetterTextView) sportsModuleDetailsView.a(i4);
            this.f25054a.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ TeamSubViews f25053b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1406667959);
                    if (this.f25053b.f25059f != null) {
                        FbUriIntentHandler fbUriIntentHandler = this.f25053b.f25058e.f25061b;
                        Context context = view.getContext();
                        GraphQLLinkExtractor graphQLLinkExtractor = this.f25053b.f25058e.f25062c;
                        fbUriIntentHandler.a(context, GraphQLLinkExtractor.a(2479791, new Object[]{this.f25053b.f25059f.f23523a}));
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, -1909447505, a);
                }
            });
        }

        public final void m28376a(@Nullable Team team, boolean z) {
            if (team != null) {
                if (this.f25059f == null || this.f25059f.f23524b != team.f23524b) {
                    this.f25055b.setText(String.valueOf(team.f23524b));
                    this.f25055b.setTextAppearance(this.f25058e.getContext(), 2131626181);
                    this.f25055b.setVisibility(z ? 0 : 8);
                }
                if (this.f25059f == null || this.f25059f.f23525c != team.f23525c) {
                    this.f25054a.setController(((FbDraweeControllerBuilder) this.f25058e.f25063d.get()).a(SportsModuleDetailsView.f25060a).b(team.f23525c).s());
                }
                this.f25056c.setText(team.f23527e);
                this.f25057d.setText(team.f23528f);
            }
            this.f25059f = team;
        }
    }

    public static void m28377a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SportsModuleDetailsView sportsModuleDetailsView = (SportsModuleDetailsView) obj;
        FbUriIntentHandler a = FbUriIntentHandler.a(fbInjector);
        GraphQLLinkExtractor a2 = GraphQLLinkExtractor.a(fbInjector);
        Provider a3 = IdBasedProvider.a(fbInjector, 1117);
        sportsModuleDetailsView.f25061b = a;
        sportsModuleDetailsView.f25062c = a2;
        sportsModuleDetailsView.f25063d = a3;
    }

    public SportsModuleDetailsView(Context context) {
        super(context);
        Class cls = SportsModuleDetailsView.class;
        m28377a(this, getContext());
        setContentView(2130905455);
    }
}
