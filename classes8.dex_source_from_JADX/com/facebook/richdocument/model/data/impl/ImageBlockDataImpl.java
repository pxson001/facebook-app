package com.facebook.richdocument.model.data.impl;

import android.content.Context;
import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.fetcher.RichDocumentImagePrefetcher;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.ImageBlockData;
import com.facebook.richdocument.model.data.Preloadable;
import com.facebook.richdocument.model.data.impl.BaseAnnotableBlockData.BaseAnnotatableBlockBuilder;
import com.facebook.richdocument.model.data.impl.BaseBlockData.BaseBlockDataBuilder;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBPhoto;
import javax.inject.Inject;

/* compiled from: photo_tagged_set_modified */
public class ImageBlockDataImpl extends BaseAnnotableBlockData implements ImageBlockData, Preloadable {
    @Inject
    public RichDocumentImagePrefetcher f5709a;
    private final FBPhoto f5710b;
    private final GraphQLDocumentMediaPresentationStyle f5711c;
    private final GraphQLDocumentMediaPresentationStyle f5712d;
    private final boolean f5713e;
    private final boolean f5714f;
    private final String f5715g;
    private boolean f5716h = true;

    /* compiled from: photo_tagged_set_modified */
    public class ImageBlockDataBuilder extends BaseAnnotatableBlockBuilder<ImageBlockData> {
        public final FBPhoto f5702a;
        public final GraphQLDocumentMediaPresentationStyle f5703b;
        public GraphQLDocumentMediaPresentationStyle f5704c;
        private String f5705d;
        public boolean f5706e;
        public boolean f5707f;
        public String f5708g;

        public final /* synthetic */ BlockData mo288b() {
            return m5513c();
        }

        public ImageBlockDataBuilder(FBPhoto fBPhoto, GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle) {
            this(4, fBPhoto, graphQLDocumentMediaPresentationStyle);
        }

        private ImageBlockDataBuilder(int i, FBPhoto fBPhoto, GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle) {
            super(i);
            this.f5702a = fBPhoto;
            this.f5703b = graphQLDocumentMediaPresentationStyle;
        }

        public final String mo287a() {
            return this.f5705d;
        }

        public final BaseBlockDataBuilder mo286a(String str) {
            this.f5705d = str;
            return this;
        }

        public final ImageBlockData m5513c() {
            return new ImageBlockDataImpl(this);
        }
    }

    public static void m5514a(Object obj, Context context) {
        ((ImageBlockDataImpl) obj).f5709a = RichDocumentImagePrefetcher.a(FbInjector.get(context));
    }

    public ImageBlockDataImpl(ImageBlockDataBuilder imageBlockDataBuilder) {
        super(imageBlockDataBuilder);
        this.f5710b = imageBlockDataBuilder.f5702a;
        this.f5711c = imageBlockDataBuilder.f5703b;
        this.f5713e = imageBlockDataBuilder.f5706e;
        this.f5714f = imageBlockDataBuilder.f5707f;
        this.f5712d = imageBlockDataBuilder.f5704c;
        this.f5715g = imageBlockDataBuilder.f5708g;
    }

    public final GraphQLDocumentElementType iT_() {
        return GraphQLDocumentElementType.PHOTO;
    }

    public final boolean iS_() {
        return this.f5714f;
    }

    public final GraphQLDocumentMediaPresentationStyle mo293m() {
        return this.f5711c;
    }

    public final GraphQLDocumentMediaPresentationStyle mo294o() {
        return this.f5712d;
    }

    public final FBPhoto mo289a() {
        return this.f5710b;
    }

    public final boolean iR_() {
        return this.f5713e;
    }

    public final int mo284d() {
        return 5;
    }

    public final boolean iU_() {
        return this.f5716h && this.f5715g != null;
    }

    public final void mo283a(boolean z) {
        this.f5716h = z;
    }

    public final void mo282a(Context context) {
        Class cls = ImageBlockDataImpl.class;
        m5514a(this, context);
        this.f5709a.a(context, mo289a().mo316c().d(), this.f5715g);
    }
}
