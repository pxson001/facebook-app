package com.facebook.widget.text.textwithentitiesview;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.unicode.CodePointRange;
import com.facebook.common.unicode.CodePointRangeTarget;
import com.facebook.common.unicode.RangeConverter;
import com.facebook.common.unicode.UTF16Range;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.span.DraweeSpanTextView;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.GetEntityFbLinkGraphQL;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.LinkableTextWithEntities;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.LinkableTextWithEntitiesRange;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImageAtRange;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields.Ranges;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.text.imagerange.FrescoTextWithImageFetcher;
import com.facebook.text.imagerange.FrescoTextWithImageFetcher.DraweeSpanSpec;
import com.facebook.text.imagerange.TextWithImageFetcher;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.text.abtest.ExperimentsForWidgetTextAbTestModule;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import javax.inject.Inject;

/* compiled from: d6b6cc82c59ace6e59d46d77d56d6ac8 */
public class TextWithEntitiesView extends DraweeSpanTextView {
    public static final Comparator<LinkableTextWithEntitiesRange> f16180a = new C12781();
    private static final CallerContext f16181b = CallerContext.a(TextWithEntitiesView.class);
    private final int f16182c;
    private final int f16183d;
    @Inject
    public SecureContextHelper f16184e;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<TextWithImageFetcher> f16185f;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FrescoTextWithImageFetcher> f16186g;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<QeAccessor> f16187h;

    /* compiled from: d6b6cc82c59ace6e59d46d77d56d6ac8 */
    final class C12781 implements Comparator<LinkableTextWithEntitiesRange> {
        C12781() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((LinkableTextWithEntitiesRange) obj).c() - ((LinkableTextWithEntitiesRange) obj2).c();
        }
    }

    /* compiled from: d6b6cc82c59ace6e59d46d77d56d6ac8 */
    public class C12792 implements FutureCallback<CharSequence> {
        final /* synthetic */ TextWithEntitiesView f16173a;

        public C12792(TextWithEntitiesView textWithEntitiesView) {
            this.f16173a = textWithEntitiesView;
        }

        public void onSuccess(Object obj) {
            this.f16173a.setText((CharSequence) obj);
        }

        public void onFailure(Throwable th) {
        }
    }

    @Deprecated
    /* compiled from: d6b6cc82c59ace6e59d46d77d56d6ac8 */
    public interface EntityListener {
        void mo1574a(Ranges ranges);
    }

    /* compiled from: d6b6cc82c59ace6e59d46d77d56d6ac8 */
    abstract class NoUnderlineClickableSpan extends ClickableSpan {
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    /* compiled from: d6b6cc82c59ace6e59d46d77d56d6ac8 */
    final class EntityListenerClickableSpan extends NoUnderlineClickableSpan {
        private final EntityListener f16174a;
        private final Ranges f16175b;

        public EntityListenerClickableSpan(EntityListener entityListener, Ranges ranges) {
            this.f16174a = entityListener;
            this.f16175b = ranges;
        }

        public final void onClick(View view) {
            this.f16174a.mo1574a(this.f16175b);
        }
    }

    /* compiled from: d6b6cc82c59ace6e59d46d77d56d6ac8 */
    public interface LinkableEntityListener {
        void m20228a(GetEntityFbLinkGraphQL getEntityFbLinkGraphQL);
    }

    /* compiled from: d6b6cc82c59ace6e59d46d77d56d6ac8 */
    final class LinkableEntityListenerClickableSpan extends NoUnderlineClickableSpan {
        private final LinkableEntityListener f16176a;
        private final GetEntityFbLinkGraphQL f16177b;

        public LinkableEntityListenerClickableSpan(LinkableEntityListener linkableEntityListener, GetEntityFbLinkGraphQL getEntityFbLinkGraphQL) {
            this.f16176a = linkableEntityListener;
            this.f16177b = getEntityFbLinkGraphQL;
        }

        public final void onClick(View view) {
            this.f16176a.m20228a(this.f16177b);
        }
    }

    /* compiled from: d6b6cc82c59ace6e59d46d77d56d6ac8 */
    final class UrlClickableSpan extends NoUnderlineClickableSpan {
        final /* synthetic */ TextWithEntitiesView f16178a;
        private final String f16179b;

        public UrlClickableSpan(TextWithEntitiesView textWithEntitiesView, String str) {
            this.f16178a = textWithEntitiesView;
            this.f16179b = str;
        }

        public final void onClick(View view) {
            this.f16178a.f16184e.b(new Intent("android.intent.action.VIEW").setData(Uri.parse(this.f16179b)), this.f16178a.getContext());
        }
    }

    private static <T extends View> void m20233a(Class<T> cls, T t) {
        m20234a((Object) t, t.getContext());
    }

    private static void m20234a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((TextWithEntitiesView) obj).m20232a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 3497), IdBasedSingletonScopeProvider.b(fbInjector, 11109), IdBasedSingletonScopeProvider.b(fbInjector, 3219));
    }

    public TextWithEntitiesView(Context context) {
        this(context, null, 0);
    }

    public TextWithEntitiesView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextWithEntitiesView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16185f = UltralightRuntime.b;
        this.f16186g = UltralightRuntime.b;
        this.f16187h = UltralightRuntime.b;
        m20233a(TextWithEntitiesView.class, (View) this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TextWithEntitiesView);
        this.f16182c = obtainStyledAttributes.getColor(0, getResources().getColor(2131361972));
        this.f16183d = obtainStyledAttributes.getInt(1, -1);
    }

    public final void m20240a(String str, ImmutableList<? extends LinkableTextWithEntitiesRange> immutableList) {
        Spannable spannableStringBuilder = new SpannableStringBuilder(str);
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            LinkableTextWithEntitiesRange linkableTextWithEntitiesRange = (LinkableTextWithEntitiesRange) immutableList.get(i);
            UTF16Range a = RangeConverter.a(str, linkableTextWithEntitiesRange.c(), linkableTextWithEntitiesRange.b());
            m20235b(spannableStringBuilder, a.a, a.c());
        }
        setText(spannableStringBuilder);
    }

    @Deprecated
    public final void m20241a(String str, List<CodePointRangeTarget<String>> list) {
        Preconditions.checkNotNull(str);
        Spannable spannableStringBuilder = new SpannableStringBuilder(str);
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CodePointRangeTarget codePointRangeTarget = (CodePointRangeTarget) it.next();
                UTF16Range a = RangeConverter.a(str, codePointRangeTarget.a);
                if (codePointRangeTarget.b != null) {
                    m20231a(spannableStringBuilder, a.a, a.c(), new UrlClickableSpan(this, (String) codePointRangeTarget.b));
                } else {
                    m20230a(spannableStringBuilder, a.a, a.c());
                }
            }
        }
        setText(spannableStringBuilder);
    }

    @Deprecated
    public void setTextWithEntities(DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields) {
        Preconditions.checkNotNull(defaultTextWithEntitiesLongFields);
        Preconditions.checkNotNull(defaultTextWithEntitiesLongFields.a());
        Spannable spannableStringBuilder = new SpannableStringBuilder(defaultTextWithEntitiesLongFields.a());
        if (!defaultTextWithEntitiesLongFields.b().isEmpty()) {
            ImmutableList b = defaultTextWithEntitiesLongFields.b();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                Ranges ranges = (Ranges) b.get(i);
                UTF16Range a = RangeConverter.a(defaultTextWithEntitiesLongFields.a(), new CodePointRange(ranges.c(), ranges.b()));
                if (ranges.a() == null || Strings.isNullOrEmpty(ranges.a().D_())) {
                    m20230a(spannableStringBuilder, a.a, a.c());
                } else {
                    m20231a(spannableStringBuilder, a.a, a.c(), new UrlClickableSpan(this, ranges.a().D_()));
                }
            }
        }
        setText(spannableStringBuilder);
    }

    public void setLinkableTextWithEntities(LinkableTextWithEntities linkableTextWithEntities) {
        Preconditions.checkNotNull(linkableTextWithEntities);
        Preconditions.checkNotNull(linkableTextWithEntities.a());
        Spannable spannableStringBuilder = new SpannableStringBuilder(linkableTextWithEntities.a());
        if (!linkableTextWithEntities.b().isEmpty()) {
            ImmutableList b = linkableTextWithEntities.b();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                LinkableTextWithEntitiesRange linkableTextWithEntitiesRange = (LinkableTextWithEntitiesRange) b.get(i);
                UTF16Range a = RangeConverter.a(linkableTextWithEntities.a(), new CodePointRange(linkableTextWithEntitiesRange.c(), linkableTextWithEntitiesRange.b()));
                if (linkableTextWithEntitiesRange.a() == null || Strings.isNullOrEmpty(linkableTextWithEntitiesRange.a().D_())) {
                    m20230a(spannableStringBuilder, a.a, a.c());
                } else {
                    m20231a(spannableStringBuilder, a.a, a.c(), new UrlClickableSpan(this, linkableTextWithEntitiesRange.a().D_()));
                }
            }
        }
        setText(spannableStringBuilder);
    }

    @Deprecated
    public final void m20239a(DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields, EntityListener entityListener) {
        if (defaultTextWithEntitiesLongFields.b().isEmpty()) {
            setText(defaultTextWithEntitiesLongFields.a());
            setMovementMethod(null);
            return;
        }
        Spannable valueOf = SpannableString.valueOf(defaultTextWithEntitiesLongFields.a());
        List<Ranges> arrayList = new ArrayList(defaultTextWithEntitiesLongFields.b());
        Collections.sort(arrayList, GraphQLHelper.j);
        for (Ranges ranges : arrayList) {
            if (!(ranges.a() == null || ranges.a().b() == null)) {
                UTF16Range a = RangeConverter.a(defaultTextWithEntitiesLongFields.a(), new CodePointRange(ranges.c(), ranges.b()));
                m20231a(valueOf, a.a, a.c(), new EntityListenerClickableSpan(entityListener, ranges));
            }
        }
        setText(valueOf);
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void m20237a(LinkableTextWithEntities linkableTextWithEntities, LinkableEntityListener linkableEntityListener) {
        if (linkableTextWithEntities.b().isEmpty()) {
            setText(linkableTextWithEntities.a());
            setMovementMethod(null);
            return;
        }
        Spannable valueOf = SpannableString.valueOf(linkableTextWithEntities.a());
        List<LinkableTextWithEntitiesRange> arrayList = new ArrayList(linkableTextWithEntities.b());
        Collections.sort(arrayList, f16180a);
        for (LinkableTextWithEntitiesRange linkableTextWithEntitiesRange : arrayList) {
            if (!(linkableTextWithEntitiesRange.a() == null || linkableTextWithEntitiesRange.a().b() == null)) {
                UTF16Range a = RangeConverter.a(linkableTextWithEntities.a(), new CodePointRange(linkableTextWithEntitiesRange.c(), linkableTextWithEntitiesRange.b()));
                m20231a(valueOf, a.a, a.c(), new LinkableEntityListenerClickableSpan(linkableEntityListener, linkableTextWithEntitiesRange.a()));
            }
        }
        setText(valueOf);
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void m20238a(GraphQLTextWithEntities graphQLTextWithEntities, float f, int i) {
        if (((QeAccessor) this.f16187h.get()).a(ExperimentsForWidgetTextAbTestModule.d, false)) {
            m20236b(graphQLTextWithEntities, f, i);
            return;
        }
        CharSequence a = graphQLTextWithEntities.a();
        setText(a);
        if (!(StringUtil.a(a) || graphQLTextWithEntities.d().isEmpty())) {
            List arrayList = new ArrayList();
            ImmutableList d = graphQLTextWithEntities.d();
            int size = d.size();
            for (int i2 = 0; i2 < size; i2++) {
                GraphQLImageAtRange graphQLImageAtRange = (GraphQLImageAtRange) d.get(i2);
                if (!(graphQLImageAtRange.a() == null || graphQLImageAtRange.a().b() == null || graphQLImageAtRange.a().b().b() == null)) {
                    arrayList.add(((TextWithImageFetcher) this.f16185f.get()).a(RangeConverter.a(a, graphQLImageAtRange.c(), graphQLImageAtRange.b()), Uri.parse(graphQLImageAtRange.a().b().b())));
                }
            }
            Futures.a(((TextWithImageFetcher) this.f16185f.get()).a(new SpannableStringBuilder(a), arrayList, f, i), new C12792(this), MoreExecutors.a());
        }
    }

    private void m20236b(GraphQLTextWithEntities graphQLTextWithEntities, float f, int i) {
        CharSequence a = graphQLTextWithEntities.a();
        if (StringUtil.a(a) || graphQLTextWithEntities.d().isEmpty()) {
            b();
            setText(a);
            return;
        }
        int i2 = (int) f;
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder(a);
        TreeSet treeSet = new TreeSet(FrescoTextWithImageFetcher.a);
        ImmutableList d = graphQLTextWithEntities.d();
        int size = d.size();
        for (int i3 = 0; i3 < size; i3++) {
            GraphQLImageAtRange graphQLImageAtRange = (GraphQLImageAtRange) d.get(i3);
            if (!(graphQLImageAtRange.a() == null || graphQLImageAtRange.a().b() == null || graphQLImageAtRange.a().b().b() == null)) {
                treeSet.add(new DraweeSpanSpec(Uri.parse(graphQLImageAtRange.a().b().b()), RangeConverter.a(a, graphQLImageAtRange.c(), graphQLImageAtRange.b())));
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            DraweeSpanSpec draweeSpanSpec = (DraweeSpanSpec) it.next();
            draweeSpanStringBuilder = ((FrescoTextWithImageFetcher) this.f16186g.get()).a(draweeSpanStringBuilder, draweeSpanSpec.a, -1, i2, draweeSpanSpec.b, i, f16181b);
        }
        setText(draweeSpanStringBuilder);
        this.a = draweeSpanStringBuilder;
        if (this.a != null && this.b) {
            this.a.a(this);
        }
    }

    private void m20231a(Spannable spannable, int i, int i2, ClickableSpan clickableSpan) {
        spannable.setSpan(clickableSpan, i, i2, 18);
        m20230a(spannable, i, i2);
    }

    private void m20230a(Spannable spannable, int i, int i2) {
        spannable.setSpan(new ForegroundColorSpan(this.f16182c), i, i2, 18);
        m20235b(spannable, i, i2);
    }

    private void m20235b(Spannable spannable, int i, int i2) {
        if (this.f16183d >= 0) {
            spannable.setSpan(new StyleSpan(this.f16183d), i, i2, 18);
        }
    }

    private void m20232a(SecureContextHelper secureContextHelper, com.facebook.inject.Lazy<TextWithImageFetcher> lazy, com.facebook.inject.Lazy<FrescoTextWithImageFetcher> lazy2, com.facebook.inject.Lazy<QeAccessor> lazy3) {
        this.f16184e = secureContextHelper;
        this.f16185f = lazy;
        this.f16186g = lazy2;
        this.f16187h = lazy3;
    }
}
