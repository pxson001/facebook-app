package com.facebook.greetingcards.create;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ViewSwitcher;
import com.facebook.greetingcards.create.GreetingCardEditorActivity.C00103;
import com.facebook.greetingcards.model.CardPhoto;
import com.facebook.greetingcards.model.GreetingCard.Slide;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: {assetIDs} */
public class MomentSwitcher extends ViewSwitcher implements CanDisplayCardPhoto {
    public C00103 f129a;
    public View f130b = getChildAt(0);
    public MomentView f131c = ((MomentView) getChildAt(1));

    /* compiled from: {assetIDs} */
    public class C00231 implements OnClickListener {
        final /* synthetic */ MomentSwitcher f128a;

        public C00231(MomentSwitcher momentSwitcher) {
            this.f128a = momentSwitcher;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 772281184);
            this.f128a.f129a.m75a();
            Logger.a(2, EntryType.UI_INPUT_END, 1179367925, a);
        }
    }

    public MomentSwitcher(Context context) {
        super(context);
        setMeasureAllChildren(false);
        LayoutInflater.from(context).inflate(2130904782, this);
        this.f130b.setOnClickListener(new C00231(this));
    }

    public void setSlide(Slide slide) {
        m141c();
        this.f131c.setSlide(slide);
    }

    private void m141c() {
        if (getDisplayedChild() != 1) {
            showNext();
            this.f129a.m77c();
        }
    }

    public final void mo1a(CardPhoto cardPhoto) {
        m141c();
        this.f131c.m156a(cardPhoto);
    }

    public final boolean m143a() {
        return getDisplayedChild() == 1;
    }

    public final void m144b() {
        if (getDisplayedChild() == 1) {
            showPrevious();
        }
    }
}
