package com.facebook.pages.fb4a.admin_activity.views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.deeplinking.PageAdminUtils;
import com.facebook.widget.CustomFrameLayout;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: queryFunctions */
public class PageAdminUpsellCardView extends CustomFrameLayout {
    public SecureContextHelper f2885a;
    private PageAdminUtils f2886b;

    private static <T extends View> void m3849a(Class<T> cls, T t) {
        m3850a((Object) t, t.getContext());
    }

    private static void m3850a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageAdminUpsellCardView) obj).m3848a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), PageAdminUtils.a(fbInjector));
    }

    public PageAdminUpsellCardView(Context context) {
        super(context);
        m3846a();
    }

    public PageAdminUpsellCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3846a();
    }

    public PageAdminUpsellCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3846a();
    }

    private void m3846a() {
        m3849a(PageAdminUpsellCardView.class, (View) this);
        setContentView(2130905961);
    }

    @Inject
    private void m3848a(SecureContextHelper secureContextHelper, PageAdminUtils pageAdminUtils) {
        this.f2885a = secureContextHelper;
        this.f2886b = pageAdminUtils;
    }

    public final void m3851a(long j, ImmutableList<String> immutableList) {
        if (PageAdminUtils.a(immutableList)) {
            m3847a(j);
        } else {
            setVisibility(8);
        }
    }

    private void m3847a(long j) {
        if (this.f2886b.a(j) != null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        final Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(GooglePlayServicesUtil.a(getContext()) == 0 ? "market://details?id=com.facebook.pages.app" : "https://play.google.com/store/apps/details?id=com.facebook.pages.app"));
        intent.setFlags(268435456);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageAdminUpsellCardView f2884b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 745622907);
                this.f2884b.f2885a.b(intent, this.f2884b.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, -1876090126, a);
            }
        });
    }
}
