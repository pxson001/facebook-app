package com.facebook.richdocument.fonts;

import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentElementStyle;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentLinkStyle;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentStyleModel;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: post_uri */
public class RichDocumentStyleFontHelper {
    public final RichDocumentStyleModel f5282a;

    public RichDocumentStyleFontHelper(@Nullable RichDocumentStyleModel richDocumentStyleModel) {
        this.f5282a = richDocumentStyleModel;
    }

    public final Set<String> m5219a() {
        Set hashSet = new HashSet();
        if (this.f5282a != null) {
            m5217a(hashSet, this.f5282a.m6364u());
            m5217a(hashSet, this.f5282a.m6344B());
            m5217a(hashSet, this.f5282a.m6343A());
            m5217a(hashSet, this.f5282a.m6351d());
            m5217a(hashSet, this.f5282a.m6349b());
            m5217a(hashSet, this.f5282a.m6361r());
            m5217a(hashSet, this.f5282a.m6362s());
            m5217a(hashSet, this.f5282a.m6368y());
            m5217a(hashSet, this.f5282a.m6367x());
            m5217a(hashSet, this.f5282a.m6369z());
            m5217a(hashSet, this.f5282a.m6357n());
            m5217a(hashSet, this.f5282a.m6356m());
            m5217a(hashSet, this.f5282a.m6355l());
            m5217a(hashSet, this.f5282a.m6354k());
            m5217a(hashSet, this.f5282a.m6353j());
            m5217a(hashSet, this.f5282a.io_());
            m5217a(hashSet, this.f5282a.ip_());
            m5217a(hashSet, this.f5282a.m6352g());
            m5217a(hashSet, this.f5282a.iq_());
            m5217a(hashSet, this.f5282a.m6359p());
            m5218a(hashSet, this.f5282a.m6365v());
        }
        return hashSet;
    }

    public static void m5217a(Set<String> set, RichDocumentElementStyle richDocumentElementStyle) {
        if (richDocumentElementStyle != null) {
            set.add(richDocumentElementStyle.m5925c());
        }
    }

    public static void m5218a(Set<String> set, RichDocumentLinkStyle richDocumentLinkStyle) {
        if (richDocumentLinkStyle != null) {
            set.add(richDocumentLinkStyle.m5965b());
        }
    }
}
