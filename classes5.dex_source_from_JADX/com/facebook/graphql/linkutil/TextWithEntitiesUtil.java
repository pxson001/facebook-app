package com.facebook.graphql.linkutil;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.common.unicode.RangeConverter;
import com.facebook.common.unicode.UTF16Range;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

@Deprecated
/* compiled from: WWW */
public class TextWithEntitiesUtil {
    public final DefaultAndroidThreadUtil f12398a;

    /* compiled from: WWW */
    public class SpannifyTask extends FbAsyncTask<Object, Void, Spannable> {
        final /* synthetic */ TextWithEntitiesUtil f12394a;
        private final int f12395b;
        private final GraphQLTextWithEntities f12396c;
        private final TextView f12397d;

        protected void onPostExecute(Object obj) {
            this.f12397d.setText((Spannable) obj);
        }

        public SpannifyTask(TextWithEntitiesUtil textWithEntitiesUtil, TextView textView, GraphQLTextWithEntities graphQLTextWithEntities, int i) {
            this.f12394a = textWithEntitiesUtil;
            this.f12397d = textView;
            this.f12396c = graphQLTextWithEntities;
            this.f12395b = i;
        }

        protected void onPreExecute() {
            this.f12397d.setText(this.f12396c.a());
        }

        protected final Object m20546a(Object[] objArr) {
            return this.f12394a.m20549a(this.f12396c, this.f12395b);
        }
    }

    public static TextWithEntitiesUtil m20548b(InjectorLike injectorLike) {
        return new TextWithEntitiesUtil(DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public TextWithEntitiesUtil(DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f12398a = defaultAndroidThreadUtil;
    }

    public static TextWithEntitiesUtil m20547a(InjectorLike injectorLike) {
        return m20548b(injectorLike);
    }

    public final Spannable m20549a(GraphQLTextWithEntities graphQLTextWithEntities, final int i) {
        CharSequence valueOf = SpannableString.valueOf(graphQLTextWithEntities.a());
        if (graphQLTextWithEntities.b() == null) {
            return valueOf;
        }
        List<GraphQLEntityAtRange> a = Lists.a(graphQLTextWithEntities.b());
        Collections.sort(a, GraphQLHelper.i);
        for (GraphQLEntityAtRange graphQLEntityAtRange : a) {
            if (!(graphQLEntityAtRange.j() == null || graphQLEntityAtRange.j().b() == null)) {
                UTF16Range a2 = RangeConverter.a(graphQLTextWithEntities.a(), GraphQLHelper.a(graphQLEntityAtRange));
                valueOf.setSpan(new StyleSpan(this, 1) {
                    final /* synthetic */ TextWithEntitiesUtil f12393b;

                    public void updateDrawState(TextPaint textPaint) {
                        TextWithEntitiesUtil textWithEntitiesUtil = this.f12393b;
                        int i = i;
                        textPaint.setUnderlineText(false);
                        if (i != -1) {
                            textPaint.setColor(i);
                        }
                        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
                    }
                }, a2.a, a2.c(), 33);
            }
        }
        return valueOf;
    }
}
