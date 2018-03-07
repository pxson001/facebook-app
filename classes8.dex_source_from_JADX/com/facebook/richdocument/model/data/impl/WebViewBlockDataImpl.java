package com.facebook.richdocument.model.data.impl;

import android.content.Context;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLDocumentElementMarginStyle;
import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.graphql.enums.GraphQLDocumentWebviewPresentationStyle;
import com.facebook.richdocument.model.data.AnnotatableBlock;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.OGBlock;
import com.facebook.richdocument.model.data.PreloadableBlock;
import com.facebook.richdocument.model.data.WebViewBlockData;
import com.facebook.richdocument.model.data.impl.BaseAnnotableBlockData.BaseAnnotatableBlockBuilder;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBPhoto;

/* compiled from: photo_picker_cancel */
public class WebViewBlockDataImpl extends BaseAnnotableBlockData implements AnnotatableBlock, BlockData, OGBlock, PreloadableBlock {
    public final String f5797a;
    public final String f5798b;
    public final String f5799c;
    public final int f5800d;
    public final int f5801e;
    private final FBPhoto f5802f;
    public final GraphQLDocumentWebviewPresentationStyle f5803g;
    public final GraphQLDocumentElementMarginStyle f5804h;
    public final boolean f5805i;

    /* compiled from: photo_picker_cancel */
    public class WebViewBlockDataBuilder extends BaseAnnotatableBlockBuilder<WebViewBlockData> {
        public String f5788a;
        public String f5789b;
        public String f5790c;
        public int f5791d;
        public int f5792e;
        public FBPhoto f5793f;
        public final GraphQLDocumentWebviewPresentationStyle f5794g;
        public final GraphQLDocumentElementMarginStyle f5795h;
        public boolean f5796i;

        public WebViewBlockDataBuilder(GraphQLDocumentWebviewPresentationStyle graphQLDocumentWebviewPresentationStyle, GraphQLDocumentElementMarginStyle graphQLDocumentElementMarginStyle) {
            this(8, graphQLDocumentWebviewPresentationStyle, graphQLDocumentElementMarginStyle);
        }

        private WebViewBlockDataBuilder(int i, GraphQLDocumentWebviewPresentationStyle graphQLDocumentWebviewPresentationStyle, GraphQLDocumentElementMarginStyle graphQLDocumentElementMarginStyle) {
            super(i);
            this.f5794g = graphQLDocumentWebviewPresentationStyle;
            this.f5795h = graphQLDocumentElementMarginStyle;
        }

        public final BlockData mo288b() {
            if (!StringUtil.c(this.f5788a) || !StringUtil.c(this.f5789b)) {
                return new WebViewBlockDataImpl(this);
            }
            throw new IllegalArgumentException("WebViewBlock must have either a non-null source or url");
        }
    }

    public WebViewBlockDataImpl(WebViewBlockDataBuilder webViewBlockDataBuilder) {
        super(webViewBlockDataBuilder);
        this.f5797a = webViewBlockDataBuilder.f5788a;
        this.f5798b = webViewBlockDataBuilder.f5789b;
        this.f5799c = webViewBlockDataBuilder.f5790c;
        this.f5801e = webViewBlockDataBuilder.f5792e;
        this.f5800d = webViewBlockDataBuilder.f5791d;
        this.f5802f = webViewBlockDataBuilder.f5793f;
        this.f5803g = webViewBlockDataBuilder.f5794g;
        this.f5804h = webViewBlockDataBuilder.f5795h;
        this.f5805i = webViewBlockDataBuilder.f5796i;
    }

    public final GraphQLDocumentElementType iT_() {
        return GraphQLDocumentElementType.WEBVIEW;
    }

    public final GraphQLDocumentMediaPresentationStyle mo293m() {
        return null;
    }

    public final int mo284d() {
        return this.f5803g == GraphQLDocumentWebviewPresentationStyle.AD ? 10000 : 10;
    }

    public final boolean iU_() {
        return true;
    }

    public final void mo283a(boolean z) {
    }

    public final void mo282a(Context context) {
    }
}
