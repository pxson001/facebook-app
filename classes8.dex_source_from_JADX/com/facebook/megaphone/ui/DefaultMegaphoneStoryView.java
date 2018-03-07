package com.facebook.megaphone.ui;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.megaphone.Megaphone;
import com.facebook.fbui.widget.megaphone.Megaphone.OnDismissListener;
import com.facebook.graphql.model.GraphQLAggregatedEntitiesAtRange;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLMegaphone;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.megaphone.model.MegaphoneWithLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: try_another_captcha_clicked */
public class DefaultMegaphoneStoryView extends Megaphone implements MegaphoneStoryView {
    @Inject
    public MegaphoneBehavior f1315a;
    public GraphQLMegaphone f1316b;

    /* compiled from: try_another_captcha_clicked */
    class C01281 implements OnDismissListener {
        final /* synthetic */ DefaultMegaphoneStoryView f1312a;

        C01281(DefaultMegaphoneStoryView defaultMegaphoneStoryView) {
            this.f1312a = defaultMegaphoneStoryView;
        }

        public final void m1540a(Megaphone megaphone) {
            this.f1312a.f1315a.m1558c(this.f1312a.f1316b);
        }
    }

    /* compiled from: try_another_captcha_clicked */
    class C01292 implements OnClickListener {
        final /* synthetic */ DefaultMegaphoneStoryView f1313a;

        C01292(DefaultMegaphoneStoryView defaultMegaphoneStoryView) {
            this.f1313a = defaultMegaphoneStoryView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1643712666);
            this.f1313a.f1315a.m1558c(this.f1313a.f1316b);
            Logger.a(2, EntryType.UI_INPUT_END, -39163304, a);
        }
    }

    /* compiled from: try_another_captcha_clicked */
    class C01303 implements OnClickListener {
        final /* synthetic */ DefaultMegaphoneStoryView f1314a;

        C01303(DefaultMegaphoneStoryView defaultMegaphoneStoryView) {
            this.f1314a = defaultMegaphoneStoryView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1505706566);
            this.f1314a.f1315a.m1556a(this.f1314a.f1316b);
            Logger.a(2, EntryType.UI_INPUT_END, -928165695, a);
        }
    }

    public static void m1542a(Object obj, Context context) {
        ((DefaultMegaphoneStoryView) obj).f1315a = MegaphoneBehavior.m1555b(FbInjector.get(context));
    }

    public DefaultMegaphoneStoryView(Context context) {
        super(context);
        Class cls = DefaultMegaphoneStoryView.class;
        m1542a(this, getContext());
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -702061317);
        if (this.f1316b == null) {
            setVisibility(8);
        }
        super.onAttachedToWindow();
        if (this.f1316b != null) {
            this.f1315a.m1559d(this.f1316b);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1012457646, a);
    }

    protected void onMeasure(int i, int i2) {
        if (getVisibility() == 8) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(i, i2);
        }
    }

    public void setMegaphoneStory(MegaphoneWithLayout megaphoneWithLayout) {
        GraphQLMegaphone graphQLMegaphone;
        if (megaphoneWithLayout == null) {
            graphQLMegaphone = null;
        } else {
            graphQLMegaphone = megaphoneWithLayout.b;
        }
        setMegaphoneStory(graphQLMegaphone);
    }

    public void setMegaphoneStory(GraphQLMegaphone graphQLMegaphone) {
        this.f1316b = graphQLMegaphone;
        if (this.f1316b != null) {
            m1543i();
        } else {
            setVisibility(8);
        }
    }

    private void m1543i() {
        CharSequence a;
        if (this.f1316b.l() == null) {
            setShowCloseButton(true);
            setShowSecondaryButton(false);
            this.m = new C01281(this);
        } else {
            setShowCloseButton(false);
            setShowSecondaryButton(true);
            setSecondaryButtonText(this.f1316b.l());
            setOnSecondaryButtonClickListener(new C01292(this));
        }
        if (this.f1316b.n() == null || this.f1316b.n().b() == null) {
            setImageView(null);
        } else {
            setImageUri(Uri.parse(this.f1316b.n().b()));
        }
        if (this.f1316b.j() != null) {
            setShowPrimaryButton(true);
            setPrimaryButtonText(this.f1316b.j().j());
            setOnPrimaryButtonClickListener(new C01303(this));
        } else {
            setShowPrimaryButton(false);
        }
        setTitle(this.f1316b.s());
        setTitleMaxLines(2);
        if (this.f1316b.m() != null) {
            a = this.f1316b.m().a();
        } else {
            a = null;
        }
        setSubtitle(a);
        setSubtitleMaxLines(4);
        if (this.f1316b.r() != null) {
            int i;
            Uri a2;
            List list;
            setSocialContext(this.f1316b.r().a());
            setSocialContextMaxLines(3);
            List a3 = Lists.a();
            GraphQLTextWithEntities r = this.f1316b.r();
            ImmutableList b = r.b();
            if (b != null) {
                for (i = 0; i < b.size() && a3.size() < 3; i++) {
                    a2 = m1541a(((GraphQLEntityAtRange) b.get(i)).j());
                    if (a2 != null) {
                        a3.add(a2);
                    }
                }
            }
            if (r.c() == null || a3.size() >= 3) {
                list = a3;
            } else {
                b = r.c();
                int size = b.size();
                loop1:
                for (int i2 = 0; i2 < size; i2++) {
                    GraphQLAggregatedEntitiesAtRange graphQLAggregatedEntitiesAtRange = (GraphQLAggregatedEntitiesAtRange) b.get(i2);
                    if (graphQLAggregatedEntitiesAtRange.j() != null) {
                        ImmutableList j = graphQLAggregatedEntitiesAtRange.j();
                        int size2 = j.size();
                        for (i = 0; i < size2; i++) {
                            a2 = m1541a((GraphQLEntity) j.get(i));
                            if (a2 != null) {
                                a3.add(a2);
                            }
                            if (a3.size() >= 3) {
                                list = a3;
                                break loop1;
                            }
                        }
                        continue;
                    }
                }
                list = a3;
            }
            setFacepileUrls(list);
        } else {
            setSocialContext(null);
        }
        setVisibility(0);
    }

    @Nullable
    public static Uri m1541a(@Nullable GraphQLEntity graphQLEntity) {
        if (graphQLEntity == null || graphQLEntity.G() == null || graphQLEntity.G().b() == null) {
            return null;
        }
        return Uri.parse(graphQLEntity.G().b());
    }
}
