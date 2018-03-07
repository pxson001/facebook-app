package com.facebook.greetingcards.verve.render;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.facebook.greetingcards.verve.VerveActionListener;
import com.facebook.greetingcards.verve.VerveMediaInfoSupplier;
import com.facebook.greetingcards.verve.VerveViewSupplier;
import com.facebook.greetingcards.verve.model.VMDeck;
import com.facebook.greetingcards.verve.model.VMSlide;
import com.facebook.greetingcards.verve.mutablemodel.DeckInfo;
import com.facebook.greetingcards.verve.render.RecyclerViewVisibilityDispatcher.C00422;
import com.google.common.base.Preconditions;

/* compiled from: view_type */
public class FlatVerveRecyclerView extends RecyclerView {
    private final RecyclerViewVisibilityDispatcher f384h;

    public FlatVerveRecyclerView(Context context) {
        this(context, null);
    }

    public FlatVerveRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.v = false;
        setLayoutManager(new LinearLayoutManager(1, false));
        this.f384h = new RecyclerViewVisibilityDispatcher(this);
    }

    public final void m357a(VMDeck vMDeck, VerveViewSupplier verveViewSupplier, VerveActionListener verveActionListener, VerveMediaInfoSupplier verveMediaInfoSupplier) {
        RecyclerViewVisibilityDispatcher recyclerViewVisibilityDispatcher = this.f384h;
        recyclerViewVisibilityDispatcher.f390d.clear();
        recyclerViewVisibilityDispatcher.f391e.clear();
        recyclerViewVisibilityDispatcher.f392f.clear();
        recyclerViewVisibilityDispatcher.f388b = verveActionListener;
        Preconditions.checkArgument(recyclerViewVisibilityDispatcher.f388b != null);
        recyclerViewVisibilityDispatcher.f387a.getViewTreeObserver().addOnGlobalLayoutListener(new C00422(recyclerViewVisibilityDispatcher));
        setAdapter(new FlatVerveAdapter(new DeckInfo(vMDeck, verveViewSupplier, verveActionListener, verveMediaInfoSupplier, ((float) getWidth()) / ((VMSlide) vMDeck.slides.get(TransitionUtil.m363a(vMDeck, vMDeck.initialSlide))).m275b())));
    }
}
