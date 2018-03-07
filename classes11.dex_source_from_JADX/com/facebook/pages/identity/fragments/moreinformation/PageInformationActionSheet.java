package com.facebook.pages.identity.fragments.moreinformation;

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
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLModels.PageInformationDataModel;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: pages_browser_like_failure */
public class PageInformationActionSheet extends CustomFrameLayout {
    public final View f3968a;
    public final View f3969b;
    @Inject
    public SecureContextHelper f3970c;

    private static <T extends View> void m4911a(Class<T> cls, T t) {
        m4912a((Object) t, t.getContext());
    }

    private static void m4912a(Object obj, Context context) {
        ((PageInformationActionSheet) obj).f3970c = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
    }

    public PageInformationActionSheet(Context context) {
        this(context, null);
    }

    public PageInformationActionSheet(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageInformationActionSheet(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130906046);
        this.f3968a = c(2131565561);
        this.f3969b = c(2131565562);
        m4911a(PageInformationActionSheet.class, (View) this);
    }

    public void setPageData(final PageInformationDataModel pageInformationDataModel) {
        if (pageInformationDataModel.l().size() > 0) {
            this.f3968a.setVisibility(0);
            this.f3968a.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ PageInformationActionSheet f3965b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -330308446);
                    Intent intent = new Intent("android.intent.action.SENDTO");
                    intent.setData(Uri.parse("mailto:" + Uri.encode((String) pageInformationDataModel.l().get(0))));
                    this.f3965b.f3970c.b(Intent.createChooser(intent, null), this.f3965b.getContext());
                    Logger.a(2, EntryType.UI_INPUT_END, 406869852, a);
                }
            });
        } else {
            this.f3968a.setVisibility(8);
        }
        if (pageInformationDataModel.y().size() > 0) {
            this.f3969b.setVisibility(0);
            this.f3969b.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ PageInformationActionSheet f3967b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -793865301);
                    this.f3967b.f3970c.b(new Intent("android.intent.action.VIEW", Uri.parse((String) pageInformationDataModel.y().get(0))), this.f3967b.getContext());
                    Logger.a(2, EntryType.UI_INPUT_END, -594252993, a);
                }
            });
            return;
        }
        this.f3969b.setVisibility(8);
    }

    private void m4910a(SecureContextHelper secureContextHelper) {
        this.f3970c = secureContextHelper;
    }
}
