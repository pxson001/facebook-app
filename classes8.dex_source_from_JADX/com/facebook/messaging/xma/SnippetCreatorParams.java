package com.facebook.messaging.xma;

import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: title_date */
public class SnippetCreatorParams {
    @Nullable
    public final String f1558a;
    public final XMAModel f1559b;

    public static SnippetCreatorParams m1736a(XMAModel xMAModel) {
        return new SnippetCreatorParams(null, xMAModel);
    }

    public SnippetCreatorParams(@Nullable String str, XMAModel xMAModel) {
        this.f1558a = str;
        this.f1559b = xMAModel;
    }

    public final boolean m1737a() {
        return this.f1558a == null;
    }
}
