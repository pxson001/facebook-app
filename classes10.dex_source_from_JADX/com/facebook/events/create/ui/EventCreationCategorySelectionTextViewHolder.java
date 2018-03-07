package com.facebook.events.create.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableStringBuilder;
import android.text.style.MetricAffectingSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.i18n.I18nJoiner;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.create.EventCreationCategorySelectionFragment.C22451;
import com.facebook.events.create.protocol.PageEventCreationGraphQLModels.PageEventCategoriesQueryModel.EventCategoryGroupsModel.NodesModel;
import com.facebook.events.create.protocol.PageEventCreationGraphQLModels.PageEventCategoriesQueryModel.EventCategoryGroupsModel.NodesModel.CategoriesModel;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: confirmation_change_number_link_text */
public class EventCreationCategorySelectionTextViewHolder extends ViewHolder {
    public FbTextView f16333l;
    public Context f16334m;
    public MetricAffectingSpan f16335n = new TextAppearanceSpan(this.f16334m, 2131625741);
    public MetricAffectingSpan f16336o = new TextAppearanceSpan(this.f16334m, 2131625742);
    public OnClickListener f16337p;
    public NodesModel f16338q;
    public CategoriesModel f16339r;
    public C22451 f16340s;
    public Provider<ComponentName> f16341t;
    public SecureContextHelper f16342u;
    public I18nJoiner f16343v;

    @Inject
    public EventCreationCategorySelectionTextViewHolder(@Assisted FbTextView fbTextView, @Assisted final Boolean bool, @FragmentChromeActivity Provider<ComponentName> provider, SecureContextHelper secureContextHelper, I18nJoiner i18nJoiner) {
        super(fbTextView);
        this.f16333l = fbTextView;
        this.f16341t = provider;
        this.f16342u = secureContextHelper;
        this.f16343v = i18nJoiner;
        this.f16334m = fbTextView.getContext();
        this.f16337p = new OnClickListener(this) {
            final /* synthetic */ EventCreationCategorySelectionTextViewHolder f16332b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1489765469);
                if (bool.booleanValue()) {
                    this.f16332b.f16340s.m16474a(this.f16332b.f16339r);
                } else {
                    EventCreationCategorySelectionTextViewHolder eventCreationCategorySelectionTextViewHolder = this.f16332b;
                    if (eventCreationCategorySelectionTextViewHolder.f16338q.m16691a().size() == 1) {
                        eventCreationCategorySelectionTextViewHolder.f16339r = (CategoriesModel) eventCreationCategorySelectionTextViewHolder.f16338q.m16691a().get(0);
                        eventCreationCategorySelectionTextViewHolder.f16340s.m16474a(eventCreationCategorySelectionTextViewHolder.f16339r);
                    } else {
                        Intent component = new Intent().setComponent((ComponentName) eventCreationCategorySelectionTextViewHolder.f16341t.get());
                        component.putExtra("target_fragment", ContentFragmentType.EVENT_CREATE_CATEGORY_SELECTION_FRAGMENT.ordinal());
                        component.putExtra("extra_title_bar_content", eventCreationCategorySelectionTextViewHolder.f16338q.m16692j());
                        component.putExtra("extra_is_subcateory", true);
                        FlatBufferModelHelper.a(component, "extra_category_group", eventCreationCategorySelectionTextViewHolder.f16338q);
                        eventCreationCategorySelectionTextViewHolder.f16342u.a(component, 110, (Activity) ContextUtils.a(eventCreationCategorySelectionTextViewHolder.f16334m, Activity.class));
                    }
                }
                LogUtils.a(891559959, a);
            }
        };
    }

    public final void m16813a(NodesModel nodesModel, C22451 c22451) {
        this.f16338q = nodesModel;
        if (this.f16338q == null) {
            this.f16333l.setVisibility(8);
            return;
        }
        CharSequence charSequence;
        this.f16340s = c22451;
        this.f16333l.setVisibility(0);
        FbTextView fbTextView = this.f16333l;
        CharSequence j = this.f16338q.m16692j();
        ImmutableList a = this.f16338q.m16691a();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!StringUtil.a(j)) {
            m16812a(spannableStringBuilder, j, this.f16335n, 17);
        }
        if (a == null || a.isEmpty()) {
            charSequence = null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < a.size(); i++) {
                CategoriesModel categoriesModel = (CategoriesModel) a.get(i);
                if (!(categoriesModel == null || StringUtil.a(categoriesModel.m16686j()))) {
                    stringBuilder.append(categoriesModel.m16686j());
                    if (i != a.size() - 1) {
                        stringBuilder.append(this.f16343v.b());
                    }
                }
            }
            Object obj = stringBuilder;
        }
        j = charSequence;
        if (!StringUtil.a(j)) {
            if (spannableStringBuilder.length() > 0) {
                spannableStringBuilder.append("\n");
            }
            m16812a(spannableStringBuilder, j, this.f16336o, 17);
        }
        fbTextView.setText(spannableStringBuilder);
        this.f16333l.setOnClickListener(this.f16337p);
    }

    public static void m16812a(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence, Object obj, int i) {
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), i);
    }
}
