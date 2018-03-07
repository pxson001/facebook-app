package com.facebook.richdocument.model.data.impl;

import android.content.Context;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentPrefetchRequest;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.OGBlock;
import com.facebook.richdocument.model.data.RelatedArticleBlockData$Location;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleEdgeModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentRelatedArticleModel;
import com.facebook.richdocument.utils.PrefetchUtils;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: photo_picker_open */
public class RelatedArticlesBlockDataImpl extends BasePreloadingBlockData implements BlockData, OGBlock {
    @Inject
    public PrefetchUtils f5742a;
    @Inject
    public RichDocumentEventBus f5743b;
    public final RelatedArticleGlobalShareModel f5744c;
    public final RichDocumentText f5745d;
    public final boolean f5746e;
    public final int f5747f;
    public final RelatedArticleBlockData$Location f5748g;

    public static void m5535a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RelatedArticlesBlockDataImpl relatedArticlesBlockDataImpl = (RelatedArticlesBlockDataImpl) obj;
        PrefetchUtils b = PrefetchUtils.b(fbInjector);
        RichDocumentEventBus a = RichDocumentEventBus.m5130a(fbInjector);
        relatedArticlesBlockDataImpl.f5742a = b;
        relatedArticlesBlockDataImpl.f5743b = a;
    }

    public RelatedArticlesBlockDataImpl(RichDocumentRelatedArticleModel richDocumentRelatedArticleModel, int i, String str) {
        super(str, 2);
        this.f5744c = richDocumentRelatedArticleModel.m6157a();
        this.f5746e = richDocumentRelatedArticleModel.m6159b();
        this.f5745d = m5534a(richDocumentRelatedArticleModel.m6157a());
        this.f5747f = i;
        this.f5748g = RelatedArticleBlockData$Location.BOTTOM;
    }

    public RelatedArticlesBlockDataImpl(RelatedArticleEdgeModel relatedArticleEdgeModel, int i, String str) {
        super(str, 2);
        this.f5744c = relatedArticleEdgeModel.m5774a().m5767a();
        this.f5746e = relatedArticleEdgeModel.m5774a().m5769b();
        this.f5745d = m5534a(relatedArticleEdgeModel.m5774a().m5767a());
        this.f5747f = i;
        this.f5748g = RelatedArticleBlockData$Location.INLINE;
    }

    @Nullable
    public final String mo271l() {
        return this.f5744c != null ? this.f5744c.m5801c() : null;
    }

    public final GraphQLDocumentElementType iT_() {
        return GraphQLDocumentElementType.RELATED_ARTICLES;
    }

    private static RichDocumentText m5534a(RelatedArticleGlobalShareModel relatedArticleGlobalShareModel) {
        if (relatedArticleGlobalShareModel != null || relatedArticleGlobalShareModel.m5802d() == null || relatedArticleGlobalShareModel.m5802d().m5760c() == null) {
            return null;
        }
        return relatedArticleGlobalShareModel.m5802d().m5760c().m5753b();
    }

    public final int mo284d() {
        return 10;
    }

    protected final void mo299b(Context context) {
        Class cls = RelatedArticlesBlockDataImpl.class;
        m5535a(this, context);
        if (this.f5744c != null) {
            if (!(this.f5744c.m5802d() == null || StringUtil.c(this.f5744c.m5802d().m5759b()) || this.f5743b == null)) {
                this.f5743b.a(new RichDocumentPrefetchRequest(this.f5744c.m5802d().m5759b()));
            }
            if (this.f5744c.hW_() != null && this.f5744c.hW_().m5787a() != null) {
                this.f5742a.a(this.f5744c.hW_().m5787a().m5781a());
            }
        }
    }
}
