package com.facebook.photos.upload.progresspage;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.inject.Assisted;
import com.facebook.photos.upload.progresspage.CompostRecyclerViewAdapter.CompostSectionType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

/* compiled from: giveupUpload / auto retry */
public class CompostHeaderViewHolder extends ViewHolder {
    private final FbNetworkManager f13852l;
    public final QeAccessor f13853m;
    public final LinearLayout f13854n;
    private final ImageWithTextView f13855o = ((ImageWithTextView) this.f13854n.findViewById(2131568188));
    private final FbTextView f13856p = ((FbTextView) this.f13854n.findViewById(2131568189));

    @Inject
    public CompostHeaderViewHolder(@Assisted View view, FbNetworkManager fbNetworkManager, QeAccessor qeAccessor) {
        super(view);
        this.f13852l = fbNetworkManager;
        this.f13853m = qeAccessor;
        this.f13854n = (LinearLayout) view;
    }

    public final void m21625a(CompostSectionType compostSectionType, boolean z) {
        if (z) {
            this.f13856p.setVisibility(0);
        } else {
            this.f13856p.setVisibility(8);
        }
        switch (compostSectionType) {
            case PENDING_SECTION:
                m21624w();
                return;
            case UPLOADED_SECTION:
                m21623c(2130838263);
                this.f13855o.setText(this.f13853m.a(ExperimentsForCompostAbTestModule.f8102u, this.f13854n.getContext().getString(2131236030)));
                this.f13856p.setText(this.f13853m.a(ExperimentsForCompostAbTestModule.f8101t, this.f13854n.getContext().getString(2131236031)));
                return;
            case DRAFT_SECTION:
                m21623c(2130838261);
                this.f13855o.setText(this.f13853m.a(ExperimentsForCompostAbTestModule.f8083b, this.f13854n.getContext().getString(2131236032)));
                this.f13856p.setText(this.f13853m.a(ExperimentsForCompostAbTestModule.f8082a, this.f13854n.getContext().getString(2131236033)));
                return;
            default:
                return;
        }
    }

    private void m21624w() {
        m21623c(2130838262);
        this.f13855o.setText(this.f13853m.a(ExperimentsForCompostAbTestModule.f8094m, this.f13854n.getContext().getString(2131236029)));
        if (this.f13852l.d()) {
            this.f13856p.setText(this.f13853m.a(ExperimentsForCompostAbTestModule.f8099r, this.f13854n.getContext().getString(2131236028)));
        } else {
            this.f13856p.setText(this.f13853m.a(ExperimentsForCompostAbTestModule.f8096o, this.f13854n.getContext().getString(2131236035)));
        }
    }

    private void m21623c(int i) {
        Drawable a = ContextCompat.a(this.f13854n.getContext(), i);
        int dimensionPixelSize = this.f13854n.getContext().getResources().getDimensionPixelSize(2131430726);
        a.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.f13855o.setCompoundDrawables(a, null, null, null);
    }
}
