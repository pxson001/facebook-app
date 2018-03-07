package com.facebook.richdocument.linkcovers;

import android.graphics.RectF;
import com.facebook.richdocument.linkcovers.LinkCoverTypes.DimensionF;
import com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentTextConfigModel;

/* compiled from: place_tip_welcome_header */
public class TextMetrics {
    String f5424a;
    float f5425b;
    float f5426c;
    float f5427d;
    int f5428e;
    CapitalizationStyle f5429f;
    int f5430g;
    UnderlineStyle f5431h;

    /* compiled from: place_tip_welcome_header */
    public enum CapitalizationStyle {
        StyleNone,
        StyleUppercase,
        StyleLowercase
    }

    /* compiled from: place_tip_welcome_header */
    public enum UnderlineStyle {
        UnderlineStyleNone,
        UnderlineStyleSingle
    }

    public TextMetrics(boolean z, RichDocumentTextConfigModel richDocumentTextConfigModel) {
        this.f5424a = richDocumentTextConfigModel.m6667a();
        this.f5425b = (float) (z ? richDocumentTextConfigModel.m6672m() : richDocumentTextConfigModel.m6676q());
        this.f5426c = (float) (z ? richDocumentTextConfigModel.m6673n() : richDocumentTextConfigModel.m6677r());
        this.f5427d = (float) (z ? richDocumentTextConfigModel.m6674o() : richDocumentTextConfigModel.m6678s());
        this.f5428e = LinkCoverParsingUtils.m5323b(z ? richDocumentTextConfigModel.m6671l() : richDocumentTextConfigModel.m6675p());
        this.f5429f = CapitalizationStyle.StyleNone;
        this.f5430g = -16777216;
        this.f5431h = UnderlineStyle.UnderlineStyleNone;
    }

    public static float m5331b(RectF rectF) {
        return rectF.top;
    }

    public static float m5329a(float f) {
        return f;
    }

    public static float m5330a(float f, DimensionF dimensionF) {
        return f - dimensionF.f5417b;
    }
}
