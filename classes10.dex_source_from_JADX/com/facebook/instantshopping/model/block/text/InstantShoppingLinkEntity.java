package com.facebook.instantshopping.model.block.text;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.richdocument.model.block.entity.LinkEntity;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentStyleModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel;
import java.util.HashMap;
import javax.inject.Inject;

/* compiled from: SendViaMqttHandler.attemptSend */
public class InstantShoppingLinkEntity extends LinkEntity {
    @Inject
    public InstantShoppingAnalyticsLogger f23595e;
    public LoggingParams f23596f;

    /* compiled from: SendViaMqttHandler.attemptSend */
    class C33951 extends HashMap<String, Object> {
        C33951() {
            put("logging_token", InstantShoppingLinkEntity.this.f23596f.f23579b);
            put("element_type", InstantShoppingLinkEntity.this.f23596f.f23578a);
        }
    }

    public static void m24902a(Object obj, Context context) {
        ((InstantShoppingLinkEntity) obj).f23595e = InstantShoppingAnalyticsLogger.m24853a(FbInjector.get(context));
    }

    public InstantShoppingLinkEntity(RichDocumentStyleModel richDocumentStyleModel, EntityModel entityModel, Context context, LoggingParams loggingParams) {
        super(richDocumentStyleModel, entityModel, context);
        Class cls = InstantShoppingLinkEntity.class;
        m24902a(this, getContext());
        this.f23596f = loggingParams;
    }

    public void updateDrawState(TextPaint textPaint) {
    }

    public void onClick(View view) {
        super.onClick(view);
        this.f23595e.m24859a("instant_shopping_element_click", new C33951());
    }
}
