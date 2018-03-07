package com.facebook.instantarticles.model.data;

import android.content.Context;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.model.block.RichDocumentLogoInfoWrapper;
import com.facebook.richdocument.model.block.RichDocumentTextType;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.richdocument.model.data.impl.ShareBlockDataImpl;
import com.facebook.richdocument.model.data.impl.TextBlockDataImpl.TextBlockDataBuilder;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentEdge;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentMaster;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentLogoModel;
import com.facebook.richdocument.view.widget.RichTextUtils;

/* compiled from: video_save_thread_view */
public class RichDocumentMasterAdapter {
    protected final Context f509a;
    protected final String f510b;

    public RichDocumentMasterAdapter(Context context) {
        this(context, null);
    }

    public RichDocumentMasterAdapter(Context context, String str) {
        this.f509a = context;
        this.f510b = str;
    }

    public final RichDocumentBlocksImpl m610a(RichDocumentMaster richDocumentMaster) {
        RichDocumentLogoModel richDocumentLogoModel;
        Object b;
        RichDocumentEdge g = richDocumentMaster.g();
        RichDocumentBlocksBuilder c = new RichDocumentBlocksBuilder(this.f509a).m605a(richDocumentMaster.c()).m607b(g.b()).m598a(g.c()).m609c(g.n().d());
        if (((RichDocumentInfo) c.f490f.get()).g.a() != null) {
            c.f507w.putInt("background_color", RichTextUtils.a(((RichDocumentInfo) c.f490f.get()).g.a()));
        }
        RichDocumentBlocksBuilder richDocumentBlocksBuilder = c;
        String o = g.o();
        if (g.l() == null) {
            richDocumentLogoModel = null;
        } else {
            richDocumentLogoModel = g.l().w();
        }
        richDocumentBlocksBuilder.f495k = new RichDocumentLogoInfoWrapper(o, richDocumentLogoModel, g.k());
        c = richDocumentBlocksBuilder;
        c.f496l = g.j();
        c = c.m606b(g.n());
        c.f498n = g.m();
        c.m602a(g.id_());
        richDocumentBlocksBuilder.m601a(g.ib_());
        RichDocumentText g2 = g.g();
        if (!(g2 == null || StringUtil.c(g2.d()))) {
            TextBlockDataBuilder textBlockDataBuilder = new TextBlockDataBuilder(g2);
            textBlockDataBuilder.b = RichDocumentTextType.CREDITS;
            richDocumentBlocksBuilder.f502r = textBlockDataBuilder.c();
        }
        c = richDocumentBlocksBuilder;
        RichDocumentText d = g.d();
        if (!(d == null || StringUtil.c(d.d()))) {
            textBlockDataBuilder = new TextBlockDataBuilder(d);
            textBlockDataBuilder.b = RichDocumentTextType.COPYRIGHT;
            c.f503s = textBlockDataBuilder.c();
        }
        RichDocumentBlocksBuilder richDocumentBlocksBuilder2 = c;
        if (StringUtil.c(this.f510b)) {
            b = g.b();
        } else {
            b = this.f510b;
        }
        if (!StringUtil.c(b)) {
            richDocumentBlocksBuilder2.f504t = new ShareBlockDataImpl(b);
        }
        richDocumentBlocksBuilder2.m599a(this.f509a.getResources(), g.ic_().a(), g.p()).m603a(richDocumentMaster.ij_(), g.k().hR_(), this.f509a.getResources()).m600a(GraphQLDocumentFeedbackOptions.LIKES_AND_COMMENTS, richDocumentMaster.b());
        return richDocumentBlocksBuilder.m608b();
    }
}
