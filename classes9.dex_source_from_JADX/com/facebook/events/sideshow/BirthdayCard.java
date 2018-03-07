package com.facebook.events.sideshow;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.events.sideshow.graphql.SideshowEventsAndBirthdaysQueryModels.SideshowEventsBirthdaysQueryModel.BirthdayFriendsModel.BirthdayPersonModel;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;

/* compiled from: TYPE_UINT32 */
public class BirthdayCard extends FrameLayout {
    private static final CallerContext f24397a = CallerContext.a(EventsSideshowUnit.class);
    private FbDraweeView f24398b;
    private FbTextView f24399c;
    private FbTextView f24400d;
    private FbTextView f24401e;
    private Resources f24402f;
    public BirthdayCardController f24403g;
    public int f24404h;

    /* compiled from: TYPE_UINT32 */
    class C29271 implements OnClickListener {
        final /* synthetic */ BirthdayCard f24396a;

        C29271(BirthdayCard birthdayCard) {
            this.f24396a = birthdayCard;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1896814332);
            this.f24396a.f24403g.m26262a(this.f24396a.f24404h, this.f24396a);
            Logger.a(2, EntryType.UI_INPUT_END, -1340852716, a);
        }
    }

    public BirthdayCard(Context context) {
        this(context, null);
    }

    public BirthdayCard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BirthdayCard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24402f = context.getResources();
        LayoutInflater.from(context).inflate(2130907091, this);
        this.f24398b = (FbDraweeView) findViewById(2131559581);
        this.f24399c = (FbTextView) findViewById(2131559582);
        this.f24400d = (FbTextView) findViewById(2131559583);
        this.f24401e = (FbTextView) findViewById(2131559586);
    }

    public final void m26247a(BirthdayCardController birthdayCardController, BirthdayPersonModel birthdayPersonModel, int i) {
        this.f24404h = i;
        this.f24403g = birthdayCardController;
        if (!(birthdayPersonModel.m26328m() == null || birthdayPersonModel.m26328m().m26317a() == null)) {
            this.f24398b.a(Uri.parse(birthdayPersonModel.m26328m().m26317a()), f24397a);
        }
        if (birthdayPersonModel.m26325j() == null || !AgeCalculator.m26234a(birthdayPersonModel.m26325j())) {
            this.f24400d.setVisibility(4);
        } else {
            int b = AgeCalculator.m26235b(birthdayPersonModel.m26325j());
            this.f24400d.setVisibility(0);
            this.f24400d.setText(this.f24402f.getQuantityString(2131689797, b, new Object[]{Integer.valueOf(b)}));
        }
        if (birthdayPersonModel.m26327l() != null) {
            this.f24399c.setText(birthdayPersonModel.m26327l());
        }
        m26245b(birthdayCardController.m26265a(birthdayPersonModel.m26326k()));
    }

    private void m26245b(boolean z) {
        if (z) {
            this.f24401e.setOnClickListener(null);
            this.f24401e.setText(2131241415);
            this.f24401e.setTextColor(this.f24402f.getColor(2131361973));
            return;
        }
        this.f24401e.setOnClickListener(new C29271(this));
    }

    public final void m26246a() {
        this.f24401e.setOnClickListener(null);
    }

    public final void m26248a(boolean z) {
        setVisibility(0);
        m26245b(z);
    }

    public final void m26249b() {
        setVisibility(4);
    }
}
