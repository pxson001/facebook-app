package com.facebook.heisman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.heisman.SingleCategoryFragment.SingleCategoryFragmentDelegate;
import com.facebook.heisman.intent.ProfilePictureOverlayPivotIntentData.Builder;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLModels.ProfileOverlayCategoryPageFieldsModel;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import javax.annotation.Nullable;

/* compiled from: video_play_report_url */
public class CategoryBrowserActivity extends FbFragmentActivity {
    private final FragmentDelegate f554p = new FragmentDelegate(this);
    public FbTitleBar f555q;
    @Nullable
    private String f556r;

    /* compiled from: video_play_report_url */
    class C00711 implements OnClickListener {
        final /* synthetic */ CategoryBrowserActivity f552a;

        C00711(CategoryBrowserActivity categoryBrowserActivity) {
            this.f552a = categoryBrowserActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -879746285);
            this.f552a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1086701945, a);
        }
    }

    /* compiled from: video_play_report_url */
    public class FragmentDelegate implements SingleCategoryFragmentDelegate {
        final /* synthetic */ CategoryBrowserActivity f553a;

        public FragmentDelegate(CategoryBrowserActivity categoryBrowserActivity) {
            this.f553a = categoryBrowserActivity;
        }

        public final void m613a(String str) {
            this.f553a.kO_().a().b(2131566378, SingleCategoryFragment.m810a(new Builder(CategoryBrowserActivity.m618j(this.f553a), "category_browser").d(str).a()), "single_category_fragment").a("single_category_transaction").c();
        }

        public final void mo17b(String str) {
            if (this.f553a.f555q != null) {
                this.f553a.f555q.setTitle(str);
            }
        }

        public final void mo16a(ProfileOverlayCategoryPageFieldsModel profileOverlayCategoryPageFieldsModel, int i) {
            Intent intent = new Intent();
            FlatBufferModelHelper.a(intent, "heisman_profile_overlay_page", profileOverlayCategoryPageFieldsModel);
            this.f553a.setResult(-1, intent);
            this.f553a.finish();
        }
    }

    public final void m620b(@Nullable Bundle bundle) {
        super.b(bundle);
        setContentView(2130906455);
        this.f555q = m617i();
        if (kO_().a("category_browser_fragment") == null) {
            kO_().a().b(2131566378, new CategoryBrowserFragment(), "category_browser_fragment").b();
        }
    }

    public final void m619a(Fragment fragment) {
        if (fragment instanceof CategoryBrowserFragment) {
            ((CategoryBrowserFragment) fragment).f591f = this.f554p;
        } else if (fragment instanceof SingleCategoryFragment) {
            ((SingleCategoryFragment) fragment).f773c = this.f554p;
        }
    }

    private FbTitleBar m617i() {
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
        fbTitleBar.a(new C00711(this));
        return fbTitleBar;
    }

    public static String m618j(CategoryBrowserActivity categoryBrowserActivity) {
        if (categoryBrowserActivity.f556r == null) {
            categoryBrowserActivity.f556r = SafeUUIDGenerator.a().toString();
        }
        return categoryBrowserActivity.f556r;
    }
}
