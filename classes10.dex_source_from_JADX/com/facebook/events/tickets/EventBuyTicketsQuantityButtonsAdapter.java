package com.facebook.events.tickets;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.locale.Locales;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.text.NumberFormat;
import javax.inject.Inject;

/* compiled from: audio_clips_creation_failed */
public class EventBuyTicketsQuantityButtonsAdapter extends Adapter<ViewHolder> {
    private final NumberFormat f19165a;
    public OnQuantityChangeListener f19166b;
    private OnClickListener f19167c;
    private int f19168d = 10;
    public int f19169e = 1;

    /* compiled from: audio_clips_creation_failed */
    public interface OnQuantityChangeListener {
        void mo856a(int i);
    }

    /* compiled from: audio_clips_creation_failed */
    class C27171 implements OnClickListener {
        final /* synthetic */ EventBuyTicketsQuantityButtonsAdapter f19164a;

        C27171(EventBuyTicketsQuantityButtonsAdapter eventBuyTicketsQuantityButtonsAdapter) {
            this.f19164a = eventBuyTicketsQuantityButtonsAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1189408097);
            EventBuyTicketsQuantityButton eventBuyTicketsQuantityButton = (EventBuyTicketsQuantityButton) view;
            this.f19164a.f19169e = eventBuyTicketsQuantityButton.f19163a;
            if (this.f19164a.f19166b != null) {
                this.f19164a.f19166b.mo856a(this.f19164a.f19169e);
            }
            this.f19164a.notifyDataSetChanged();
            Logger.a(2, EntryType.UI_INPUT_END, -1330016531, a);
        }
    }

    /* compiled from: audio_clips_creation_failed */
    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    public static EventBuyTicketsQuantityButtonsAdapter m19341b(InjectorLike injectorLike) {
        return new EventBuyTicketsQuantityButtonsAdapter(Locales.a(injectorLike));
    }

    public final void m19343a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        super.a(viewHolder2);
        viewHolder2.a.setOnClickListener(null);
    }

    public final void m19344a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        int i2 = i + 1;
        CharSequence format = this.f19165a.format((long) i2);
        EventBuyTicketsQuantityButton eventBuyTicketsQuantityButton = (EventBuyTicketsQuantityButton) viewHolder2.a;
        eventBuyTicketsQuantityButton.f19163a = i2;
        eventBuyTicketsQuantityButton.setText(format);
        eventBuyTicketsQuantityButton.setChecked(i2 == this.f19169e);
        eventBuyTicketsQuantityButton.setOnClickListener(this.f19167c);
    }

    public final void m19346c(android.support.v7.widget.RecyclerView.ViewHolder viewHolder) {
        super.c((ViewHolder) viewHolder);
        this.f19167c = new C27171(this);
    }

    @Inject
    public EventBuyTicketsQuantityButtonsAdapter(Locales locales) {
        this.f19165a = NumberFormat.getNumberInstance(locales.a());
    }

    public static EventBuyTicketsQuantityButtonsAdapter m19339a(InjectorLike injectorLike) {
        return m19341b(injectorLike);
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder m19342a(ViewGroup viewGroup, int i) {
        return new ViewHolder((EventBuyTicketsQuantityButton) LayoutInflater.from(viewGroup.getContext()).inflate(2130904003, viewGroup, false));
    }

    public final int aZ_() {
        return this.f19168d;
    }

    public final void m19347e(int i, int i2) {
        this.f19168d = Math.min(10, i2);
        this.f19169e = i;
        notifyDataSetChanged();
    }

    public final void m19345a(OnQuantityChangeListener onQuantityChangeListener) {
        this.f19166b = onQuantityChangeListener;
    }
}
