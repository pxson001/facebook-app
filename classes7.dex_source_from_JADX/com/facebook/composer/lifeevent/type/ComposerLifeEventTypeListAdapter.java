package com.facebook.composer.lifeevent.type;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.common.i18n.I18nJoiner;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.LifeEventFieldsModel;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.fbui.widget.header.SectionHeaderView;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.inject.Assisted;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: copyright_monitor_start */
public class ComposerLifeEventTypeListAdapter extends FbBaseAdapter {
    public final Context f16770a;
    private final I18nJoiner f16771b;
    public final ComposerLifeEventTypeSuggestionListModel f16772c;
    private final OnClickListener f16773d;
    private final OnClickListener f16774e;
    public ImmutableList f16775f = RegularImmutableList.a;

    @Inject
    public ComposerLifeEventTypeListAdapter(I18nJoiner i18nJoiner, @Assisted Context context, @Assisted ComposerLifeEventTypeSuggestionListModel composerLifeEventTypeSuggestionListModel, @Assisted OnClickListener onClickListener, @Assisted OnClickListener onClickListener2) {
        this.f16771b = i18nJoiner;
        this.f16770a = context;
        this.f16772c = composerLifeEventTypeSuggestionListModel;
        this.f16773d = onClickListener;
        this.f16774e = onClickListener2;
    }

    public final void m20797a(ImmutableList immutableList) {
        if (immutableList == null) {
            immutableList = RegularImmutableList.a;
        }
        this.f16775f = immutableList;
    }

    public final View m20795a(int i, ViewGroup viewGroup) {
        int a = m20793a(2131429329);
        if (i == 0) {
            SectionHeaderView sectionHeaderView = new SectionHeaderView(viewGroup.getContext());
            sectionHeaderView.setPadding(a, 0, a, 0);
            return sectionHeaderView;
        }
        View contentView = new ContentView(viewGroup.getContext());
        int a2 = m20793a(2131429328);
        contentView.setBackgroundResource(2130839798);
        contentView.setSubtitleTextAppearance(2131624222);
        contentView.setPadding(a2, a, a2, a);
        contentView.setThumbnailPadding(m20793a(2131429326));
        return contentView;
    }

    public final void m20796a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        if (i2 == 0) {
            ((SectionHeaderView) view).setTitleText((String) obj);
            return;
        }
        ContentView contentView = (ContentView) view;
        if (obj instanceof LifeEventFieldsModel) {
            boolean z;
            DefaultImageFieldsModel k;
            LifeEventFieldsModel lifeEventFieldsModel = (LifeEventFieldsModel) obj;
            contentView.setTitleText(lifeEventFieldsModel.a());
            contentView.setSubtitleText("");
            contentView.setTitleTextAppearance(2131624223);
            contentView.setTag(2131558565, lifeEventFieldsModel);
            if (this.f16772c != null) {
                Object obj2;
                ComposerLifeEventTypeSuggestionListModel composerLifeEventTypeSuggestionListModel = this.f16772c;
                if (composerLifeEventTypeSuggestionListModel.f16804d == null || composerLifeEventTypeSuggestionListModel.f16804d.k() == null || lifeEventFieldsModel == null || !composerLifeEventTypeSuggestionListModel.f16804d.k().equals(lifeEventFieldsModel.k())) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (obj2 != null) {
                    z = true;
                    contentView.setTag(2131558564, Boolean.valueOf(z));
                    contentView.setOnClickListener(this.f16774e);
                    contentView.setShowAuxView(false);
                    k = lifeEventFieldsModel.k();
                    contentView.setShowThumbnail(true);
                    if (k != null) {
                        contentView.setThumbnailUri(null);
                    }
                    contentView.setThumbnailUri(k.b());
                    contentView.setThumbnailSize(m20793a(2131429327));
                    return;
                }
            }
            z = false;
            contentView.setTag(2131558564, Boolean.valueOf(z));
            contentView.setOnClickListener(this.f16774e);
            contentView.setShowAuxView(false);
            k = lifeEventFieldsModel.k();
            contentView.setShowThumbnail(true);
            if (k != null) {
                contentView.setThumbnailUri(k.b());
                contentView.setThumbnailSize(m20793a(2131429327));
                return;
            }
            contentView.setThumbnailUri(null);
        } else if (obj instanceof ComposerLifeEventTypeSuggestionCategoryModel) {
            ComposerLifeEventTypeSuggestionCategoryModel composerLifeEventTypeSuggestionCategoryModel = (ComposerLifeEventTypeSuggestionCategoryModel) obj;
            contentView.setTitleText(composerLifeEventTypeSuggestionCategoryModel.f16797a);
            contentView.setSubtitleText(m20794a(composerLifeEventTypeSuggestionCategoryModel));
            contentView.setTitleTextAppearance(2131624220);
            contentView.setTag(2131558565, composerLifeEventTypeSuggestionCategoryModel);
            contentView.setOnClickListener(this.f16773d);
            View view2 = contentView.a;
            if (view2 == null) {
                LayoutInflater.from(viewGroup.getContext()).inflate(2130903689, contentView);
                view2 = contentView.a;
            }
            if (view2 != null) {
                ((ImageView) view2).setImageResource(2130838068);
            }
            contentView.setShowAuxView(true);
            contentView.setShowThumbnail(false);
            contentView.setThumbnailSize(ThumbnailSize.MEDIUM);
        }
    }

    public int getCount() {
        return this.f16775f.size();
    }

    public Object getItem(int i) {
        return this.f16775f.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        if (getItem(i) instanceof String) {
            return 0;
        }
        return 1;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public void notifyDataSetChanged() {
        if (this.f16772c == null) {
            this.f16775f = RegularImmutableList.a;
        } else {
            ImmutableList immutableList;
            Builder builder = new Builder();
            builder.c(this.f16770a.getString(2131234171));
            ComposerLifeEventTypeSuggestionListModel composerLifeEventTypeSuggestionListModel = this.f16772c;
            if (Strings.isNullOrEmpty(composerLifeEventTypeSuggestionListModel.f16806f)) {
                immutableList = composerLifeEventTypeSuggestionListModel.f16802b;
            } else {
                immutableList = new Builder().b(composerLifeEventTypeSuggestionListModel.f16807g).b();
            }
            builder.b(immutableList);
            builder.c(this.f16770a.getString(2131234172));
            builder.b(this.f16772c.f16803c);
            this.f16775f = builder.b();
        }
        super.notifyDataSetChanged();
    }

    private int m20793a(int i) {
        return this.f16770a.getResources().getDimensionPixelSize(i);
    }

    private String m20794a(ComposerLifeEventTypeSuggestionCategoryModel composerLifeEventTypeSuggestionCategoryModel) {
        ImmutableList immutableList = composerLifeEventTypeSuggestionCategoryModel.f16798b;
        if (immutableList.size() < 3) {
            return "";
        }
        ImmutableList subList = immutableList.subList(0, 3);
        List a = Lists.a();
        int size = subList.size();
        for (int i = 0; i < size; i++) {
            a.add(((LifeEventFieldsModel) subList.get(i)).a());
        }
        return this.f16771b.a(a);
    }
}
