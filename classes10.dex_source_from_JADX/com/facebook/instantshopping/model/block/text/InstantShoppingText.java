package com.facebook.instantshopping.model.block.text;

import android.content.Context;
import android.text.style.StrikethroughSpan;
import com.facebook.graphql.enums.GraphQLComposedEntityType;
import com.facebook.graphql.enums.GraphQLInlineStyle;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.richdocument.model.block.RichDocumentTextType;
import com.facebook.richdocument.model.block.RichText.RichTextBuilder;
import com.facebook.richdocument.model.block.entity.BaseEntity;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel;

/* compiled from: SendDataServiceHandler */
public class InstantShoppingText {

    /* compiled from: SendDataServiceHandler */
    /* synthetic */ class C33961 {
        static final /* synthetic */ int[] f23597a = new int[GraphQLInlineStyle.values().length];
        static final /* synthetic */ int[] f23598b = new int[RichDocumentTextType.values().length];
        static final /* synthetic */ int[] f23599c = new int[GraphQLComposedEntityType.values().length];

        static {
            try {
                f23599c[GraphQLComposedEntityType.LINK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23598b[RichDocumentTextType.BODY.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23598b[RichDocumentTextType.HEADER_ONE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23598b[RichDocumentTextType.HEADER_TWO.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f23597a[GraphQLInlineStyle.STRIKETHROUGH.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* compiled from: SendDataServiceHandler */
    public final class InstantShoppingTextBuilder extends RichTextBuilder {
        private final Context f23600c;
        private LoggingParams f23601d;

        public InstantShoppingTextBuilder(Context context, LoggingParams loggingParams) {
            super(context);
            this.f23600c = context;
            this.f23601d = loggingParams;
        }

        protected final Object m24905a(GraphQLInlineStyle graphQLInlineStyle) {
            switch (C33961.f23597a[graphQLInlineStyle.ordinal()]) {
                case 1:
                    return new StrikethroughSpan();
                default:
                    return super.a(graphQLInlineStyle);
            }
        }

        public final RichTextBuilder m24903a(RichDocumentTextType richDocumentTextType) {
            if (richDocumentTextType != null) {
                switch (C33961.f23598b[richDocumentTextType.ordinal()]) {
                    case 1:
                        a(2131626221);
                        break;
                    case 2:
                        a(2131626223);
                        break;
                    case 3:
                        a(2131626224);
                        break;
                    default:
                        break;
                }
            }
            return this;
        }

        protected final BaseEntity m24904a(EntityRangesModel entityRangesModel) {
            switch (C33961.f23599c[entityRangesModel.b().ordinal()]) {
                case 1:
                    return new InstantShoppingLinkEntity(this.a, entityRangesModel.a(), this.f23600c, this.f23601d);
                default:
                    return super.a(entityRangesModel);
            }
        }
    }
}
