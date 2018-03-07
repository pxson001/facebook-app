package com.facebook.richdocument.linkcovers;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.richdocument.linkcovers.LinkCoverTypes.DescriptionConstraint;
import com.facebook.richdocument.linkcovers.LinkCoverTypes.ElementType;
import com.facebook.richdocument.linkcovers.LinkCoverTypes.HorizontalPosition;
import com.facebook.richdocument.linkcovers.LinkCoverTypes.MinimorphTextAlignment;
import com.facebook.richdocument.linkcovers.LinkCoverTypes.VerticalPosition;
import com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel;
import com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentTextConfigModel;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: place_to_people_consecutive_num_times_skipped */
public class LinkCoverDescriptors {

    /* compiled from: place_to_people_consecutive_num_times_skipped */
    public class IntermediatePositionDescriptor {
        String f5377a;
        String f5378b;
        String f5379c;

        public static IntermediatePositionDescriptor m5313a(String str) {
            return new IntermediatePositionDescriptor(str);
        }

        private IntermediatePositionDescriptor(String str) {
            if (str != null) {
                boolean z;
                List a = StringUtil.a(str, '+');
                List a2 = StringUtil.a(str, '-');
                if (a.size() > 1) {
                    this.f5379c = (String) a.get(1);
                }
                if (a2.size() > 1) {
                    this.f5379c = StringFormatUtil.a("-%s", new Object[]{a2.get(1)});
                }
                Preconditions.checkArgument(!a.isEmpty());
                a2 = StringUtil.a((String) a.get(0), ':');
                if (a2.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                Preconditions.checkArgument(z);
                this.f5377a = (String) a2.get(0);
                if (a2.size() > 1) {
                    this.f5378b = (String) StringUtil.a((String) a2.get(1), '-').get(0);
                } else {
                    this.f5377a = (String) StringUtil.a((String) a.get(0), '-').get(0);
                }
            }
        }
    }

    /* compiled from: place_to_people_consecutive_num_times_skipped */
    public class LinkCoverElementDescriptor {
        public String f5380c;
        ElementType f5381d;
        LinkCoverPositionDescriptor f5382e;
        public boolean f5383f;
        public String f5384g;

        protected LinkCoverElementDescriptor(ElementType elementType, @Nullable RichDocumentNonTextConfigModel richDocumentNonTextConfigModel) {
            this.f5381d = elementType;
            this.f5383f = richDocumentNonTextConfigModel != null;
            if (this.f5383f) {
                this.f5380c = richDocumentNonTextConfigModel.m6656j();
                if (this.f5380c == null || this.f5380c.isEmpty()) {
                    this.f5380c = this.f5381d.value;
                }
                this.f5382e = new LinkCoverPositionDescriptor(richDocumentNonTextConfigModel);
                this.f5384g = richDocumentNonTextConfigModel.m6660n();
            }
        }

        protected LinkCoverElementDescriptor(ElementType elementType, @Nullable RichDocumentTextConfigModel richDocumentTextConfigModel) {
            this.f5381d = elementType;
            this.f5383f = richDocumentTextConfigModel != null;
            if (this.f5383f) {
                this.f5380c = this.f5381d.value;
                this.f5382e = new LinkCoverPositionDescriptor(richDocumentTextConfigModel);
            }
        }
    }

    /* compiled from: place_to_people_consecutive_num_times_skipped */
    public class LinkCoverBarDescriptor extends LinkCoverElementDescriptor {
        public int f5385a;
        public int f5386b;

        public LinkCoverBarDescriptor(RichDocumentNonTextConfigModel richDocumentNonTextConfigModel, int i) {
            super(ElementType.BAR, richDocumentNonTextConfigModel);
            this.f5386b = i;
            this.f5385a = LinkCoverParsingUtils.m5323b(richDocumentNonTextConfigModel.m6654a());
        }
    }

    /* compiled from: place_to_people_consecutive_num_times_skipped */
    public class LinkCoverDescriptionConstraintDescriptor {
        DescriptionConstraint f5387a;
        IntermediatePositionDescriptor f5388b;

        public LinkCoverDescriptionConstraintDescriptor(DescriptionConstraint descriptionConstraint, IntermediatePositionDescriptor intermediatePositionDescriptor) {
            this.f5387a = descriptionConstraint;
            this.f5388b = intermediatePositionDescriptor;
        }

        public final String m5314a() {
            return this.f5388b.f5378b;
        }
    }

    /* compiled from: place_to_people_consecutive_num_times_skipped */
    public class LinkCoverPositionDescriptor {
        HorizontalPosition f5389a;
        float f5390b;
        int f5391c;
        String f5392d;
        VerticalPosition f5393e;
        float f5394f;
        int f5395g;
        String f5396h;
        boolean f5397i;
        LinkCoverDescriptionConstraintDescriptor f5398j;
        boolean f5399k;
        LinkCoverDescriptionConstraintDescriptor f5400l;

        public LinkCoverPositionDescriptor(RichDocumentNonTextConfigModel richDocumentNonTextConfigModel) {
            boolean z = true;
            IntermediatePositionDescriptor a = IntermediatePositionDescriptor.m5313a(richDocumentNonTextConfigModel.m6658l());
            IntermediatePositionDescriptor a2 = IntermediatePositionDescriptor.m5313a(richDocumentNonTextConfigModel.m6662p());
            this.f5397i = richDocumentNonTextConfigModel.m6657k() != null;
            if (richDocumentNonTextConfigModel.m6661o() == null) {
                z = false;
            }
            this.f5399k = z;
            this.f5389a = HorizontalPosition.fromString(a.f5377a);
            this.f5390b = LinkCoverParsingUtils.m5320a(a.f5379c);
            if (HorizontalPosition.hasElementArgument(this.f5389a)) {
                this.f5392d = a.f5378b;
            } else if (HorizontalPosition.hasGridArgument(this.f5389a)) {
                this.f5391c = Integer.parseInt(a.f5378b);
            }
            this.f5393e = VerticalPosition.fromString(a2.f5377a);
            this.f5394f = LinkCoverParsingUtils.m5320a(a2.f5379c);
            if (VerticalPosition.hasElementArgument(this.f5393e)) {
                this.f5396h = a2.f5378b;
            } else if (VerticalPosition.hasGridArgument(this.f5393e)) {
                this.f5395g = Integer.parseInt(a2.f5378b);
            }
            if (this.f5397i) {
                IntermediatePositionDescriptor a3 = IntermediatePositionDescriptor.m5313a(richDocumentNonTextConfigModel.m6657k());
                this.f5398j = new LinkCoverDescriptionConstraintDescriptor(DescriptionConstraint.fromString(a3.f5377a), a3);
            }
            if (this.f5399k) {
                a3 = IntermediatePositionDescriptor.m5313a(richDocumentNonTextConfigModel.m6661o());
                this.f5400l = new LinkCoverDescriptionConstraintDescriptor(DescriptionConstraint.fromString(a3.f5377a), a3);
            }
        }

        public LinkCoverPositionDescriptor(RichDocumentTextConfigModel richDocumentTextConfigModel) {
            boolean z = true;
            IntermediatePositionDescriptor a = IntermediatePositionDescriptor.m5313a(richDocumentTextConfigModel.m6670k());
            IntermediatePositionDescriptor a2 = IntermediatePositionDescriptor.m5313a(richDocumentTextConfigModel.m6681v());
            this.f5397i = richDocumentTextConfigModel.m6669j() != null;
            if (richDocumentTextConfigModel.m6680u() == null) {
                z = false;
            }
            this.f5399k = z;
            this.f5389a = HorizontalPosition.fromString(a.f5377a);
            this.f5390b = LinkCoverParsingUtils.m5320a(a.f5379c);
            if (HorizontalPosition.hasElementArgument(this.f5389a)) {
                this.f5392d = a.f5378b;
            } else if (HorizontalPosition.hasGridArgument(this.f5389a)) {
                this.f5391c = Integer.parseInt(a.f5378b);
            }
            this.f5393e = VerticalPosition.fromString(a2.f5377a);
            this.f5394f = LinkCoverParsingUtils.m5320a(a2.f5379c);
            if (VerticalPosition.hasElementArgument(this.f5393e)) {
                this.f5396h = a2.f5378b;
            } else if (VerticalPosition.hasGridArgument(this.f5393e)) {
                this.f5395g = Integer.parseInt(a2.f5378b);
            }
            if (this.f5397i) {
                IntermediatePositionDescriptor a3 = IntermediatePositionDescriptor.m5313a(richDocumentTextConfigModel.m6669j());
                this.f5398j = new LinkCoverDescriptionConstraintDescriptor(DescriptionConstraint.fromString(a3.f5377a), a3);
            }
            if (this.f5399k) {
                a3 = IntermediatePositionDescriptor.m5313a(richDocumentTextConfigModel.m6680u());
                this.f5400l = new LinkCoverDescriptionConstraintDescriptor(DescriptionConstraint.fromString(a3.f5377a), a3);
            }
        }
    }

    /* compiled from: place_to_people_consecutive_num_times_skipped */
    public class LinkCoverTextDescriptor extends LinkCoverElementDescriptor {
        public int f5401a;
        public TextMetrics f5402b;
        public TextMetrics f5403h;
        public MinimorphTextAlignment f5404i;

        protected LinkCoverTextDescriptor(ElementType elementType, RichDocumentTextConfigModel richDocumentTextConfigModel) {
            super(elementType, richDocumentTextConfigModel);
            if (richDocumentTextConfigModel != null) {
                this.f5401a = LinkCoverParsingUtils.m5323b(richDocumentTextConfigModel.m6675p());
                this.f5402b = new TextMetrics(false, richDocumentTextConfigModel);
                this.f5403h = new TextMetrics(true, richDocumentTextConfigModel);
                String t = richDocumentTextConfigModel.m6679t();
                if (t != null && t.equals("center")) {
                    this.f5404i = MinimorphTextAlignment.CENTER;
                } else if (t != null && t.equals("right")) {
                    this.f5404i = MinimorphTextAlignment.RIGHT;
                }
            }
        }
    }
}
