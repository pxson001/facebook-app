package com.facebook.reaction.ui.util;

import android.view.View;
import android.widget.TextView;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: UnderlineStyleNone */
public class ReactionViewUtil {
    public static void m24825a(TextView textView, @Nullable String str) {
        if (Strings.isNullOrEmpty(str)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(str);
    }

    public static void m24824a(View view, int i, DefaultTextWithEntitiesFields defaultTextWithEntitiesFields) {
        m24825a((TextView) view.findViewById(i), defaultTextWithEntitiesFields != null ? defaultTextWithEntitiesFields.a() : null);
    }
}
