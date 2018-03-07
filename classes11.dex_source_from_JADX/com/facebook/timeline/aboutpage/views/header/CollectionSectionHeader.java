package com.facebook.timeline.aboutpage.views.header;

import android.content.Context;
import android.net.Uri;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.CollectionsAppSection;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: Ljava/lang/Iterable */
public class CollectionSectionHeader extends CustomLinearLayout {
    private static final CallerContext f13960a = CallerContext.a(CollectionSectionHeader.class, "collections_collection");
    private final FbDraweeView f13961b = ((FbDraweeView) a(2131560395));
    private final TextView f13962c = ((TextView) a(2131560396));

    public CollectionSectionHeader(Context context) {
        super(context);
        setContentView(2130903601);
        setBackgroundResource(2131364003);
        setOrientation(0);
    }

    public final void m15080a(CollectionsAppSection collectionsAppSection) {
        if (collectionsAppSection != null) {
            if (collectionsAppSection.mo388b() == null || collectionsAppSection.mo388b().b() == null) {
                this.f13961b.a(null, f13960a);
                this.f13961b.setVisibility(8);
            } else {
                this.f13961b.a(Uri.parse(collectionsAppSection.mo388b().b()), f13960a);
                this.f13961b.setVisibility(0);
            }
            CharSequence charSequence = "";
            if (collectionsAppSection.mo390d() != null) {
                charSequence = collectionsAppSection.mo390d();
            }
            this.f13962c.setText(charSequence);
        }
    }
}
