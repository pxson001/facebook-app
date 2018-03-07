package com.facebook.notes;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.instantarticles.BaseInstantArticlesDelegateImpl;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.notes.fetcher.NotesFetchParams;
import com.facebook.notes.fetcher.NotesFetcher;
import com.facebook.notes.graphql.NoteToRichDocumentWrapper;
import com.facebook.notes.graphql.NotesGraphQlModels.NoteMasterModel;
import com.facebook.notes.model.block.NotesMasterAdapter;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentBlocksAppendedEvent;
import com.facebook.richdocument.fetcher.RichDocumentFetchParams;
import com.facebook.richdocument.fetcher.RichDocumentFetcher;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: Unexpected child view type */
public class NotesDelegateImpl extends BaseInstantArticlesDelegateImpl<GraphQLRequest<NoteMasterModel>, GraphQLResult<NoteMasterModel>> {
    private static final String f10470O = NotesDelegateImpl.class.getSimpleName();
    @Inject
    public RichDocumentEventBus f10471K;
    @Inject
    public NotesFetcher f10472L;
    @Inject
    public AbstractFbErrorReporter f10473M;
    @Inject
    public IFeedIntentBuilder f10474N;

    public static void m10892a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        NotesDelegateImpl notesDelegateImpl = (NotesDelegateImpl) obj;
        RichDocumentEventBus a = RichDocumentEventBus.a(fbInjector);
        NotesFetcher a2 = NotesFetcher.m10911a(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        IFeedIntentBuilder iFeedIntentBuilder = (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(fbInjector);
        notesDelegateImpl.f10471K = a;
        notesDelegateImpl.f10472L = a2;
        notesDelegateImpl.f10473M = abstractFbErrorReporter;
        notesDelegateImpl.f10474N = iFeedIntentBuilder;
    }

    protected final RichDocumentBlocksImpl m10896a(Object obj) {
        final GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null || graphQLResult.e == null) {
            String str;
            AbstractFbErrorReporter abstractFbErrorReporter = this.f10473M;
            String str2 = f10470O + ".onParseModel";
            StringBuilder stringBuilder = new StringBuilder("Null GraphQLResult");
            if (graphQLResult == null) {
                str = " ";
            } else {
                str = ".getResult ";
            }
            abstractFbErrorReporter.a(SoftError.a(str2, stringBuilder.append(str).append("for note id(").append(m10893d(this.y)).append(")").toString()).g());
            return null;
        } else if (((NoteMasterModel) graphQLResult.e).m11005j() == null) {
            final Context context = getContext();
            HandlerDetour.b(this.J, new Runnable(this) {
                final /* synthetic */ NotesDelegateImpl f10469c;

                public void run() {
                    this.f10469c.f10474N.a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.aU, ((NoteMasterModel) graphQLResult.e).oe_()));
                }
            }, 1000, -338272970);
            return null;
        } else {
            RichDocumentBlocksImpl a = new NotesMasterAdapter(getContext()).m11032a(new NoteToRichDocumentWrapper((NoteMasterModel) graphQLResult.e));
            this.f10471K.a(new RichDocumentBlocksAppendedEvent(a, graphQLResult.freshness));
            return a;
        }
    }

    public final View m10898b(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Class cls = NotesDelegateImpl.class;
        m10892a(this, getContext());
        return super.b(layoutInflater, viewGroup, bundle);
    }

    protected final RichDocumentFetcher<GraphQLRequest<NoteMasterModel>, GraphQLResult<NoteMasterModel>> m10900u() {
        return this.f10472L;
    }

    public final AbstractSequenceDefinition m10894C() {
        return NotesSequences.f10477a;
    }

    protected final void m10897a(Throwable th) {
        AbstractFbErrorReporter abstractFbErrorReporter = this.f10473M;
        SoftErrorBuilder a = SoftError.a(f10470O + ".onFetchError", "Error attempting to fetch blocks. note id(" + m10893d(this.y) + ")");
        a.c = th;
        abstractFbErrorReporter.a(a.g());
    }

    public final Map<String, Object> m10899c() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("note_id", m10893d(this.y));
        return hashMap;
    }

    private static String m10893d(@javax.annotation.Nullable Bundle bundle) {
        if (bundle == null || !bundle.containsKey("extra_notes_id")) {
            return null;
        }
        return bundle.getString("extra_notes_id");
    }

    protected final String m10895E() {
        return m10893d(this.y);
    }

    protected final RichDocumentFetchParams<GraphQLRequest<NoteMasterModel>> m10901v() {
        return new NotesFetchParams(getContext(), m10893d(this.y));
    }
}
