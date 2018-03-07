package com.facebook.instantshopping.presenter;

import android.view.View.OnClickListener;
import com.facebook.instantshopping.model.data.ToggleButtonBlockData;
import com.facebook.instantshopping.model.data.impl.ToggleButtonBlockDataImpl;
import com.facebook.instantshopping.view.block.ToggleButtonBlockView;
import com.facebook.instantshopping.view.block.impl.ToggleButtonBlockViewImpl;
import com.facebook.instantshopping.view.block.impl.ToggleButtonBlockViewImpl.C34201;
import com.facebook.richdocument.model.block.RichText;
import com.facebook.richdocument.model.block.RichText.RichTextBuilder;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;

/* compiled from: STEP_VALIDATION_SUCCESS */
public class ToggleButtonBlockPresenter extends AbstractBlockPresenter<ToggleButtonBlockView, ToggleButtonBlockData> {
    public boolean f23694d;
    private RichDocumentText f23695e;
    private RichDocumentText f23696f;

    public final void m25028a(BlockData blockData) {
        boolean a;
        ToggleButtonBlockDataImpl toggleButtonBlockDataImpl = (ToggleButtonBlockDataImpl) blockData;
        ToggleButtonBlockViewImpl toggleButtonBlockViewImpl = (ToggleButtonBlockViewImpl) this.d;
        String str = toggleButtonBlockViewImpl.f23839d.a;
        if (toggleButtonBlockViewImpl.f23838c.b(str)) {
            a = toggleButtonBlockViewImpl.f23838c.a(str);
        } else {
            a = toggleButtonBlockDataImpl.f23659a.r();
        }
        this.f23694d = a;
        m25029a(this.f23694d);
        toggleButtonBlockViewImpl = (ToggleButtonBlockViewImpl) this.d;
        OnClickListener c34201 = new C34201(toggleButtonBlockViewImpl, toggleButtonBlockDataImpl.f23659a.u(), toggleButtonBlockDataImpl.f23659a.q(), toggleButtonBlockDataImpl.mo1008C());
        toggleButtonBlockViewImpl.f23843h.setOnClickListener(c34201);
        toggleButtonBlockViewImpl.f23844i.setOnClickListener(c34201);
        ((ToggleButtonBlockViewImpl) this.d).m25124a(toggleButtonBlockDataImpl.f23659a.d().iO_());
        toggleButtonBlockViewImpl = (ToggleButtonBlockViewImpl) this.d;
        toggleButtonBlockViewImpl.f23842g.m24856a(toggleButtonBlockDataImpl.mo1008C());
        this.f23695e = toggleButtonBlockDataImpl.f23659a.t();
        this.f23696f = toggleButtonBlockDataImpl.f23659a.s();
    }

    public ToggleButtonBlockPresenter(ToggleButtonBlockViewImpl toggleButtonBlockViewImpl) {
        super(toggleButtonBlockViewImpl);
    }

    public final void m25029a(boolean z) {
        this.f23694d = z;
        if (this.f23694d) {
            ((ToggleButtonBlockViewImpl) this.d).m25122a(m25027a(this.f23695e));
            ((ToggleButtonBlockViewImpl) this.d).m25120a(getContext().getResources().getColor(2131361917));
            ((ToggleButtonBlockViewImpl) this.d).m25125b(2130840977);
            return;
        }
        ((ToggleButtonBlockViewImpl) this.d).m25122a(m25027a(this.f23696f));
        ((ToggleButtonBlockViewImpl) this.d).m25120a(getContext().getResources().getColor(2131363670));
        ((ToggleButtonBlockViewImpl) this.d).m25125b(2130840976);
    }

    private RichText m25027a(RichDocumentText richDocumentText) {
        return new RichTextBuilder(getContext()).a(richDocumentText).a(2131626226).a();
    }
}
