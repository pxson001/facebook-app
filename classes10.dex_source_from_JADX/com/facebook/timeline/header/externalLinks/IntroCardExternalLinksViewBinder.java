package com.facebook.timeline.header.externalLinks;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.inject.Assisted;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.ExternalLink;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.ExternalLinkModel;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: file_id */
public class IntroCardExternalLinksViewBinder {
    private final IntroCardExternalLinkViewBinder f11701a;
    private final QeAccessor f11702b;
    public final ProfileControllerDelegate f11703c;
    public final Provider<FbUriIntentHandler> f11704d;
    public final Provider<TimelineAnalyticsLogger> f11705e;
    public final TimelineContext f11706f;
    private ImmutableList<? extends ExternalLink> f11707g;
    private OnClickListener f11708h;

    /* compiled from: file_id */
    class C16721 implements OnClickListener {
        final /* synthetic */ IntroCardExternalLinksViewBinder f11700a;

        C16721(IntroCardExternalLinksViewBinder introCardExternalLinksViewBinder) {
            this.f11700a = introCardExternalLinksViewBinder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1993354984);
            ((TimelineAnalyticsLogger) this.f11700a.f11705e.get()).p(this.f11700a.f11706f.b);
            this.f11700a.f11703c.mn_();
            ((FbUriIntentHandler) this.f11700a.f11704d.get()).a(view.getContext(), FBLinks.bb);
            Logger.a(2, EntryType.UI_INPUT_END, 1920640570, a);
        }
    }

    @Inject
    public IntroCardExternalLinksViewBinder(Provider<IntroCardExternalLinkViewBinder> provider, QeAccessor qeAccessor, ProfileControllerDelegate profileControllerDelegate, Provider<FbUriIntentHandler> provider2, Provider<TimelineAnalyticsLogger> provider3, @Assisted TimelineContext timelineContext) {
        this.f11701a = (IntroCardExternalLinkViewBinder) provider.get();
        this.f11702b = qeAccessor;
        this.f11703c = profileControllerDelegate;
        this.f11704d = provider2;
        this.f11705e = provider3;
        this.f11706f = timelineContext;
    }

    public final void m11783a(IntroCardExternalLinksView introCardExternalLinksView, ImmutableList<? extends ExternalLink> immutableList) {
        if (!IntroCardExternalLinksHelper.m11769a(this.f11707g, immutableList)) {
            this.f11707g = immutableList;
            introCardExternalLinksView.m11774a();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                ExternalLinkModel externalLinkModel = (ExternalLinkModel) immutableList.get(i);
                IntroCardExternalLinkView introCardExternalLinkView = new IntroCardExternalLinkView(introCardExternalLinksView.getContext());
                this.f11701a.m11768a(introCardExternalLinkView, externalLinkModel);
                introCardExternalLinksView.m11776a(introCardExternalLinkView);
            }
            boolean a = this.f11702b.a(ExperimentsForTimelineAbTestModule.F, false);
            if (this.f11706f.i() && a) {
                introCardExternalLinksView.m11775a(m11778a());
            } else {
                introCardExternalLinksView.m11777b();
            }
        }
    }

    private OnClickListener m11778a() {
        if (this.f11708h == null) {
            this.f11708h = new C16721(this);
        }
        return this.f11708h;
    }
}
