package com.facebook.instantshopping.presenter;

import android.content.Context;
import android.os.Bundle;
import com.facebook.graphql.enums.GraphQLComposedEntityType;
import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentAlignmentDescriptorType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.logging.InstantShoppingElementDwellTimeLogger;
import com.facebook.instantshopping.logging.InstantShoppingLoggingUtils;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.block.text.InstantShoppingText.InstantShoppingTextBuilder;
import com.facebook.instantshopping.model.data.impl.InstantShoppingTextBlockDataImpl;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingTextMetricsDescriptorFragmentModel;
import com.facebook.instantshopping.view.block.InstantShoppingTextBlockView;
import com.facebook.instantshopping.view.block.impl.InstantShoppingTextBlockViewImpl;
import com.facebook.richdocument.model.block.RichText;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.TextBlockData;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: STORY_BASE */
public class InstantShoppingTextBlockPresenter extends AbstractBlockPresenter<InstantShoppingTextBlockView, TextBlockData> {
    @Inject
    public InstantShoppingLoggingUtils f23682d;
    @Inject
    public InstantShoppingElementDwellTimeLogger f23683e;
    public LoggingParams f23684f;

    /* compiled from: STORY_BASE */
    /* synthetic */ class C33981 {
        static final /* synthetic */ int[] f23681a = new int[GraphQLComposedEntityType.values().length];

        static {
            try {
                f23681a[GraphQLComposedEntityType.LINK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public static void m25009a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        InstantShoppingTextBlockPresenter instantShoppingTextBlockPresenter = (InstantShoppingTextBlockPresenter) obj;
        InstantShoppingLoggingUtils a = InstantShoppingLoggingUtils.m24879a(injectorLike);
        InstantShoppingElementDwellTimeLogger a2 = InstantShoppingElementDwellTimeLogger.m24873a(injectorLike);
        instantShoppingTextBlockPresenter.f23682d = a;
        instantShoppingTextBlockPresenter.f23683e = a2;
    }

    public final void m25011a(BlockData blockData) {
        InstantShoppingTextBlockDataImpl instantShoppingTextBlockDataImpl = (InstantShoppingTextBlockDataImpl) ((TextBlockData) blockData);
        ((InstantShoppingTextBlockViewImpl) this.d).a(null);
        InstantShoppingTextBlockViewImpl instantShoppingTextBlockViewImpl = (InstantShoppingTextBlockViewImpl) this.d;
        instantShoppingTextBlockViewImpl.f23789e.k = instantShoppingTextBlockDataImpl.f23653c;
        RichText a = new InstantShoppingTextBuilder(getContext(), this.f23684f).a(instantShoppingTextBlockDataImpl.f()).a();
        InstantShoppingTextMetricsDescriptorFragmentModel A = instantShoppingTextBlockDataImpl.mo1001A();
        GraphQLInstantShoppingDocumentAlignmentDescriptorType z = instantShoppingTextBlockDataImpl.mo1007z();
        instantShoppingTextBlockViewImpl.f23789e.d.setText(a);
        instantShoppingTextBlockViewImpl.f23789e.d.setMovementMethod(null);
        instantShoppingTextBlockViewImpl.f23787c.a(instantShoppingTextBlockViewImpl.f23789e.d, z, A);
        this.f23684f = instantShoppingTextBlockDataImpl.mo1008C();
        instantShoppingTextBlockViewImpl.f23785a.m24856a(this.f23684f);
        if (instantShoppingTextBlockDataImpl.f().b() == null || instantShoppingTextBlockDataImpl.f().b().isEmpty()) {
            instantShoppingTextBlockViewImpl.m25076a(this.f23684f, null);
            return;
        }
        ImmutableList b = instantShoppingTextBlockDataImpl.f().b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            EntityRangesModel entityRangesModel = (EntityRangesModel) b.get(i);
            switch (C33981.f23681a[entityRangesModel.b().ordinal()]) {
                case 1:
                    instantShoppingTextBlockViewImpl.m25076a(this.f23684f, entityRangesModel.a());
                    break;
                default:
                    break;
            }
        }
    }

    public InstantShoppingTextBlockPresenter(InstantShoppingTextBlockViewImpl instantShoppingTextBlockViewImpl) {
        super(instantShoppingTextBlockViewImpl);
        Class cls = InstantShoppingTextBlockPresenter.class;
        m25009a(this, getContext());
    }

    public final void m25010a(Bundle bundle) {
        super.a(bundle);
        this.f23682d.m24884b("richtext_element_start", this.f23684f.toString());
        this.f23683e.m24876a(this.f23684f.toString());
    }

    public final void m25012b(Bundle bundle) {
        super.b(bundle);
        this.f23682d.m24884b("richtext_element_end", this.f23684f.toString());
        this.f23683e.m24877b(this.f23684f.toString());
    }
}
