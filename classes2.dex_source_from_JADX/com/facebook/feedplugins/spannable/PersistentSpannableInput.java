package com.facebook.feedplugins.spannable;

import android.text.Spannable;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import javax.annotation.Nullable;

/* compiled from: group/%s/yourposts */
public interface PersistentSpannableInput {
    int mo3192a(Spannable spannable);

    ContextStateKey<String, PersistentSpannable> mo3193a();

    @Nullable
    GraphQLTextWithEntities mo3194b();

    CacheableEntity mo3195c();

    @Nullable
    TextLayoutBuilder mo3196d();

    int mo3197e();
}
