package com.facebook.richdocument.presenter;

import android.content.Context;
import com.facebook.richdocument.model.block.RichDocumentTextType;
import com.facebook.richdocument.model.block.RichText;
import com.facebook.richdocument.model.block.RichText.RichTextBuilder;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.RelatedArticleBlockData;
import com.facebook.richdocument.model.data.RelatedArticleBlockData$Location;
import com.facebook.richdocument.model.data.impl.RelatedArticlesBlockDataImpl;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RelatedArticleGlobalShareModel;
import com.facebook.richdocument.view.block.RelatedArticleBlockView;
import com.facebook.richdocument.view.block.impl.RelatedArticleBlockViewImpl;

/* compiled from: percent_scrolled */
public class RelatedArticlePresenter extends AbstractBlockPresenter<RelatedArticleBlockView, RelatedArticleBlockData> {
    public final void mo366a(BlockData blockData) {
        String str;
        String str2;
        RelatedArticlesBlockDataImpl relatedArticlesBlockDataImpl = (RelatedArticlesBlockDataImpl) blockData;
        String str3 = null;
        ((RelatedArticleBlockViewImpl) this.f6382d).mo374a(null);
        RelatedArticleGlobalShareModel relatedArticleGlobalShareModel = relatedArticlesBlockDataImpl.f5744c;
        if (relatedArticleGlobalShareModel == null || relatedArticleGlobalShareModel.m5802d() == null) {
            str = null;
        } else {
            str = relatedArticleGlobalShareModel.m5802d().m5759b();
        }
        RelatedArticleBlockViewImpl relatedArticleBlockViewImpl = (RelatedArticleBlockViewImpl) this.f6382d;
        String b = relatedArticleGlobalShareModel.m5800b();
        if (relatedArticleGlobalShareModel.hW_() == null || relatedArticleGlobalShareModel.hW_().m5787a() == null) {
            str2 = null;
        } else {
            str2 = relatedArticleGlobalShareModel.hW_().m5787a().m5781a();
        }
        RichText a = m6824a(getContext(), relatedArticleGlobalShareModel.m5803g().m5793a(), RichDocumentTextType.RELATED_ARTICLES);
        Context context = getContext();
        if (relatedArticlesBlockDataImpl.f5745d != null) {
            str3 = relatedArticlesBlockDataImpl.f5745d.mo303d();
        }
        relatedArticleBlockViewImpl.m7086a(b, str2, a, m6824a(context, str3, RichDocumentTextType.KICKER), relatedArticlesBlockDataImpl.f5746e, str);
        ((RelatedArticleBlockViewImpl) this.f6382d).f6783m = getContext().getResources().getColor(2131363478);
        if (relatedArticlesBlockDataImpl.f5748g == RelatedArticleBlockData$Location.BOTTOM) {
            ((RelatedArticleBlockViewImpl) this.f6382d).f6784n = "bottom_related_articles";
        } else if (relatedArticlesBlockDataImpl.f5748g == RelatedArticleBlockData$Location.INLINE) {
            ((RelatedArticleBlockViewImpl) this.f6382d).f6784n = "inline_related_articles";
        }
        ((RelatedArticleBlockViewImpl) this.f6382d).f6786p = relatedArticleGlobalShareModel.m5801c();
        ((RelatedArticleBlockViewImpl) this.f6382d).f6785o = relatedArticlesBlockDataImpl.f5747f;
    }

    public RelatedArticlePresenter(RelatedArticleBlockViewImpl relatedArticleBlockViewImpl) {
        super(relatedArticleBlockViewImpl);
    }

    private static RichText m6824a(Context context, String str, RichDocumentTextType richDocumentTextType) {
        RichTextBuilder a = new RichTextBuilder(context).m5444a(richDocumentTextType);
        a.f5636d = str;
        return a.m5446a();
    }
}
