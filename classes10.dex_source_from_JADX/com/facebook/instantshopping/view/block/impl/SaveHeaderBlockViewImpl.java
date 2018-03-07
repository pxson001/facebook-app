package com.facebook.instantshopping.view.block.impl;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.facebook.inject.FbInjector;
import com.facebook.instantshopping.action.InstantShoppingActionUtils;
import com.facebook.instantshopping.event.InstantShoppingEvents.ProductSavedEvent;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingActionFragmentModel;
import com.facebook.instantshopping.presenter.HeaderBlockPresenter;
import com.facebook.instantshopping.view.block.HeaderBlockView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.view.block.impl.AbstractBlockView;
import java.util.HashMap;
import javax.inject.Inject;

/* compiled from: SSL_ERROR */
public class SaveHeaderBlockViewImpl extends AbstractBlockView<HeaderBlockPresenter> implements HeaderBlockView {
    @Inject
    public InstantShoppingActionUtils f23824a;
    @Inject
    public RichDocumentEventBus f23825b;
    public final View f23826c;
    private final FrameLayout f23827d;
    public boolean f23828e;
    public LoggingParams f23829f;

    public static void m25111a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SaveHeaderBlockViewImpl saveHeaderBlockViewImpl = (SaveHeaderBlockViewImpl) obj;
        InstantShoppingActionUtils a = InstantShoppingActionUtils.m24796a(fbInjector);
        RichDocumentEventBus a2 = RichDocumentEventBus.a(fbInjector);
        saveHeaderBlockViewImpl.f23824a = a;
        saveHeaderBlockViewImpl.f23825b = a2;
    }

    public SaveHeaderBlockViewImpl(View view) {
        super(view);
        Class cls = SaveHeaderBlockViewImpl.class;
        m25111a(this, getContext());
        this.f23826c = view.findViewById(2131563314);
        this.f23827d = (FrameLayout) view.findViewById(2131563313);
    }

    public final void m25113a(boolean z) {
        this.f23828e = z;
        this.f23826c.setActivated(this.f23828e);
    }

    public final void mo1028c() {
        this.f23826c.setVisibility(0);
        this.f23827d.setVisibility(0);
    }

    public final void mo1027a(final InstantShoppingActionFragmentModel instantShoppingActionFragmentModel) {
        this.f23827d.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SaveHeaderBlockViewImpl f23823b;

            /* compiled from: SSL_ERROR */
            class C34171 extends HashMap<String, Object> {
                C34171() {
                    put("is_on", Boolean.valueOf(C34181.this.f23823b.f23828e));
                }
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 841310527);
                SaveHeaderBlockViewImpl saveHeaderBlockViewImpl = this.f23823b;
                saveHeaderBlockViewImpl.f23828e = !saveHeaderBlockViewImpl.f23828e;
                this.f23823b.f23826c.setActivated(this.f23823b.f23828e);
                this.f23823b.f23824a.m24802a(this.f23823b.getContext(), instantShoppingActionFragmentModel, this.f23823b.f23829f, new C34171());
                this.f23823b.f23825b.a(new ProductSavedEvent(this.f23823b.f23828e));
                Logger.a(2, EntryType.UI_INPUT_END, -681314411, a);
            }
        });
    }
}
