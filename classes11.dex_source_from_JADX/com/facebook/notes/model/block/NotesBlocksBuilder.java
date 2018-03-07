package com.facebook.notes.model.block;

import android.content.Context;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.inject.FbInjector;
import com.facebook.instantarticles.model.data.RichDocumentBlocksBuilder;
import com.facebook.instantarticles.model.wrapper.InstantArticlesBlockDataHelper;
import com.facebook.notes.model.data.impl.FromAuthorDataBlockImpl;
import com.facebook.notes.model.data.impl.TimestampAndPrivacyBlockDataImpl;
import com.facebook.richdocument.model.block.RichDocumentTextType;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.impl.TextBlockDataImpl.TextBlockDataBuilder;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.FBProfileModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentSectionEdgeModel.RichDocumentSectionModel;
import com.facebook.richdocument.view.util.RichDocumentLayoutDirection;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;

/* compiled from: UNKNOWN_SECURE */
public class NotesBlocksBuilder extends RichDocumentBlocksBuilder {
    public FBProfileModel f10524A;
    public TimestampAndPrivacyInfoWrapper f10525B;
    @Inject
    public RichDocumentLayoutDirection f10526y;
    public BlockData f10527z;

    /* compiled from: UNKNOWN_SECURE */
    /* synthetic */ class C12321 {
        static final /* synthetic */ int[] f10523a = new int[GraphQLDocumentElementType.values().length];

        static {
            try {
                f10523a[GraphQLDocumentElementType.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10523a[GraphQLDocumentElementType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static void m11019a(Object obj, Context context) {
        ((NotesBlocksBuilder) obj).f10526y = RichDocumentLayoutDirection.a(FbInjector.get(context));
    }

    public final /* synthetic */ RichDocumentBlocksBuilder m11020a(int i) {
        return m11025b(i);
    }

    public final /* synthetic */ RichDocumentBlocksBuilder m11022a(String str) {
        return m11028e(str);
    }

    public final /* synthetic */ RichDocumentBlocksBuilder m11023b(RichDocumentText richDocumentText) {
        return m11029f(richDocumentText);
    }

    public final /* synthetic */ RichDocumentBlocksBuilder m11024b(String str) {
        return m11030f(str);
    }

    public final /* synthetic */ RichDocumentBlocksBuilder m11027c(String str) {
        return m11031g(str);
    }

    public NotesBlocksBuilder(Context context) {
        super(context);
        Class cls = NotesBlocksBuilder.class;
        m11019a((Object) this, this.i);
    }

    public final NotesBlocksBuilder m11028e(String str) {
        super.a(str);
        return this;
    }

    public final NotesBlocksBuilder m11030f(String str) {
        super.b(str);
        return this;
    }

    public final NotesBlocksBuilder m11025b(int i) {
        super.a(i);
        return this;
    }

    public final NotesBlocksBuilder m11031g(String str) {
        super.c(str);
        return this;
    }

    public final NotesBlocksBuilder m11029f(RichDocumentText richDocumentText) {
        super.b(richDocumentText);
        return this;
    }

    public final RichDocumentBlocksBuilder m11021a(RichDocumentSectionModel richDocumentSectionModel, Context context) {
        if (richDocumentSectionModel.k() == null) {
            return this;
        }
        switch (C12321.f10523a[richDocumentSectionModel.k().ordinal()]) {
            case 1:
                if (richDocumentSectionModel.n() == null || richDocumentSectionModel.n().c() == null) {
                    return this;
                }
                this.q.add(InstantArticlesBlockDataHelper.a(richDocumentSectionModel, this.j));
                return this;
            case 2:
                if (!RichDocumentBlocksBuilder.a(richDocumentSectionModel.ig_())) {
                    return this;
                }
                this.q.add(InstantArticlesBlockDataHelper.a(richDocumentSectionModel));
                return this;
            default:
                return super.a(richDocumentSectionModel, context);
        }
    }

    public final RichDocumentBlocksImpl m11026b() {
        Collection arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList();
        if (this.p != null) {
            arrayList.add(this.p);
        }
        if (this.f10524A != null) {
            arrayList.add(new FromAuthorDataBlockImpl(this.f10524A));
        }
        if (!(this.m == null || StringUtil.c(this.m.d()))) {
            TextBlockDataBuilder textBlockDataBuilder = new TextBlockDataBuilder(this.m);
            textBlockDataBuilder.b = RichDocumentTextType.TITLE;
            arrayList.add(textBlockDataBuilder.c());
        }
        if (this.f10525B != null) {
            arrayList.add(new TimestampAndPrivacyBlockDataImpl(this.f10525B.f10529b, this.f10525B.f10528a));
        }
        if (this.f10527z != null) {
            arrayList2.add(this.f10527z);
        }
        RichDocumentBlocksImpl richDocumentBlocksImpl = new RichDocumentBlocksImpl(this.j);
        richDocumentBlocksImpl.a(arrayList);
        richDocumentBlocksImpl.a(this.q);
        richDocumentBlocksImpl.a(arrayList2);
        richDocumentBlocksImpl.b.putAll(this.w);
        return richDocumentBlocksImpl;
    }
}
