package com.facebook.events.create.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.create.EventCompositionModel;
import com.facebook.events.create.protocol.PageEventCreationGraphQLModels.PageEventCategoriesQueryModel.EventCategoryGroupsModel.NodesModel.CategoriesModel;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: confirmation_pre_title_text */
public class EventCategorySelector extends CustomFrameLayout implements OnClickListener {
    private EventCompositionModel f16318a;
    @Nullable
    private String f16319b;
    private int f16320c;
    private FbTextView f16321d;
    private Provider<ComponentName> f16322e;
    private SecureContextHelper f16323f;

    private static <T extends View> void m16798a(Class<T> cls, T t) {
        m16799a((Object) t, t.getContext());
    }

    private static void m16799a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventCategorySelector) obj).m16800a(IdBasedProvider.a(fbInjector, 12), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector));
    }

    public EventCategorySelector(Context context) {
        super(context);
        m16801b();
    }

    public EventCategorySelector(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m16801b();
    }

    public EventCategorySelector(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16801b();
    }

    @Inject
    private void m16800a(@FragmentChromeActivity Provider<ComponentName> provider, SecureContextHelper secureContextHelper) {
        this.f16322e = provider;
        this.f16323f = secureContextHelper;
    }

    public final void m16804a(EventCompositionModel eventCompositionModel, @Nullable String str, boolean z, int i) {
        this.f16318a = eventCompositionModel;
        this.f16319b = str;
        this.f16320c = i;
        m16797a();
        setVisibility(z ? 0 : 8);
    }

    private void m16797a() {
        String str = this.f16318a.f16053k.f16317b;
        if (StringUtil.a(str)) {
            setCategoryLabel("");
        } else {
            setCategoryLabel(str);
        }
    }

    private void m16801b() {
        m16798a(EventCategorySelector.class, (View) this);
        setContentView(2130904009);
        this.f16321d = (FbTextView) c(2131561230);
        setOnClickListener(this);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 24364629);
        m16802e();
        Logger.a(2, EntryType.UI_INPUT_END, -1543159516, a);
    }

    private void m16802e() {
        Intent component = new Intent().setComponent((ComponentName) this.f16322e.get());
        component.putExtra("target_fragment", ContentFragmentType.EVENT_CREATE_CATEGORY_SELECTION_FRAGMENT.ordinal());
        component.putExtra("extra_page_id", this.f16319b);
        component.putExtra("extra_title_bar_content", getResources().getString(2131236938));
        component.putExtra("extra_is_subcateory", false);
        this.f16323f.a(component, this.f16320c, (Activity) ContextUtils.a(getContext(), Activity.class));
    }

    private void setCategoryLabel(CharSequence charSequence) {
        if (StringUtil.a(charSequence)) {
            this.f16321d.setText("");
        } else {
            this.f16321d.setText(charSequence);
        }
    }

    public final void m16803a(Intent intent) {
        EventCategoryModel eventCategoryModel = this.f16318a.f16053k;
        if (intent.hasExtra("extra_selected_category")) {
            CategoriesModel categoriesModel = (CategoriesModel) FlatBufferModelHelper.a(intent, "extra_selected_category");
            if (categoriesModel != null) {
                eventCategoryModel.f16317b = categoriesModel.m16686j();
                eventCategoryModel.f16316a = categoriesModel.m16685a();
            }
        }
        m16797a();
    }
}
