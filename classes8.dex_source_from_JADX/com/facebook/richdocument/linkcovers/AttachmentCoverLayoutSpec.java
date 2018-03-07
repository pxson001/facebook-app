package com.facebook.richdocument.linkcovers;

import android.graphics.PointF;
import android.graphics.RectF;
import com.facebook.richdocument.linkcovers.LinkCoverDescriptors.LinkCoverBarDescriptor;
import com.facebook.richdocument.linkcovers.LinkCoverDescriptors.LinkCoverDescriptionConstraintDescriptor;
import com.facebook.richdocument.linkcovers.LinkCoverDescriptors.LinkCoverElementDescriptor;
import com.facebook.richdocument.linkcovers.LinkCoverDescriptors.LinkCoverPositionDescriptor;
import com.facebook.richdocument.linkcovers.LinkCoverDescriptors.LinkCoverTextDescriptor;
import com.facebook.richdocument.linkcovers.LinkCoverTypes.DescriptionConstraint;
import com.facebook.richdocument.linkcovers.LinkCoverTypes.DimensionF;
import com.facebook.richdocument.linkcovers.LinkCoverTypes.ElementType;
import com.facebook.richdocument.linkcovers.LinkCoverTypes.HorizontalPosition;
import com.facebook.richdocument.linkcovers.LinkCoverTypes.OverlayImageType;
import com.facebook.richdocument.linkcovers.LinkCoverTypes.VerticalPosition;
import com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.InstantArticleLinkCoverConfigFragmentModel.LatestVersionModel.FeedCoverConfigModel;
import com.facebook.richdocument.model.graphql.RichDocumentLinkCoversGraphQLModels.RichDocumentNonTextConfigModel;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: place_to_people_time_of_last_skip */
public class AttachmentCoverLayoutSpec {
    DimensionF f5342A;
    DimensionF f5343B;
    DimensionF f5344C;
    DimensionF f5345D;
    DimensionF f5346E;
    DimensionF f5347F;
    DimensionF f5348G;
    DimensionF f5349H;
    DimensionF f5350I;
    boolean f5351a = true;
    int f5352b;
    int f5353c;
    boolean f5354d;
    boolean f5355e;
    boolean f5356f;
    boolean f5357g;
    LinkCoverMetrics f5358h;
    public String f5359i;
    public LinkCoverTextDescriptor f5360j;
    public LinkCoverTextDescriptor f5361k;
    public LinkCoverElementDescriptor f5362l;
    LinkCoverElementDescriptor f5363m;
    LinkCoverElementDescriptor f5364n;
    LinkCoverElementDescriptor f5365o;
    LinkCoverElementDescriptor f5366p;
    public List<LinkCoverBarDescriptor> f5367q = new ArrayList();
    Map<String, LinkCoverElementDescriptor> f5368r = new HashMap();
    boolean f5369s;
    public int f5370t = -1;
    public LinkCoverTextDescriptor f5371u;
    OverlayImageType f5372v;
    public float f5373w;
    public float f5374x;
    DimensionF f5375y;
    DimensionF f5376z;

    public AttachmentCoverLayoutSpec(FeedCoverConfigModel feedCoverConfigModel, LinkCoverMetrics linkCoverMetrics, boolean z, int i, OverlayImageType overlayImageType) {
        boolean z2 = false;
        this.f5358h = linkCoverMetrics;
        this.f5360j = new LinkCoverTextDescriptor(ElementType.HEADLINE, feedCoverConfigModel.m6619o());
        this.f5361k = new LinkCoverTextDescriptor(ElementType.DESCRIPTION, feedCoverConfigModel.m6618n());
        this.f5371u = new LinkCoverTextDescriptor(ElementType.BYLINE, feedCoverConfigModel.m6616l());
        this.f5362l = new LinkCoverElementDescriptor(ElementType.SOURCE_IMAGE, feedCoverConfigModel.m6622r());
        this.f5363m = new LinkCoverElementDescriptor(ElementType.COVER_IMAGE, feedCoverConfigModel.m6617m());
        this.f5366p = new LinkCoverElementDescriptor(ElementType.BYLINE_AREA, feedCoverConfigModel.m6615k());
        this.f5364n = new LinkCoverElementDescriptor(ElementType.COVER_VIDEO, feedCoverConfigModel.m6617m());
        this.f5364n.f5380c = ElementType.COVER_VIDEO.value;
        this.f5368r.put(this.f5360j.f5380c, this.f5360j);
        this.f5368r.put(this.f5361k.f5380c, this.f5361k);
        this.f5368r.put(this.f5371u.f5380c, this.f5371u);
        this.f5368r.put(this.f5362l.f5380c, this.f5362l);
        this.f5368r.put(this.f5363m.f5380c, this.f5363m);
        this.f5368r.put(this.f5366p.f5380c, this.f5366p);
        this.f5368r.put(this.f5364n.f5380c, this.f5364n);
        ImmutableList a = feedCoverConfigModel.m6612a();
        int i2 = 0;
        while (a != null && i2 < a.size()) {
            LinkCoverElementDescriptor linkCoverBarDescriptor = new LinkCoverBarDescriptor((RichDocumentNonTextConfigModel) a.get(i2), i2);
            this.f5367q.add(linkCoverBarDescriptor);
            if (linkCoverBarDescriptor.f5380c != null) {
                this.f5368r.put(linkCoverBarDescriptor.f5380c, linkCoverBarDescriptor);
            }
            i2++;
        }
        this.f5369s = z;
        this.f5352b = feedCoverConfigModel.m6614j() != null ? LinkCoverParsingUtils.m5323b(feedCoverConfigModel.m6614j().m6654a()) : 0;
        this.f5353c = i;
        RichDocumentNonTextConfigModel m = feedCoverConfigModel.m6617m();
        if (m != null) {
            z2 = true;
        }
        this.f5354d = z2;
        if (this.f5354d) {
            this.f5355e = m.m6659m();
        }
        this.f5356f = feedCoverConfigModel.m6620p();
        this.f5357g = feedCoverConfigModel.m6621q();
        this.f5372v = overlayImageType;
    }

    public final void m5306a(int i, String str) {
        this.f5370t = i;
        this.f5359i = str;
        float f = (float) i;
        float f2 = f / AttachmentCoverDesignSpec.f5336a;
        float f3 = f2 / AttachmentCoverDesignSpec.f5337b;
        float f4 = f / AttachmentCoverDesignSpec.f5338c;
        float f5 = f2 - (AttachmentCoverDesignSpec.f5341f * f3);
        float f6 = (f - (AttachmentCoverDesignSpec.f5339d * f4)) / 2.0f;
        float f7 = (AttachmentCoverDesignSpec.f5340e * f3) + (f5 * 2.0f);
        this.f5373w = f;
        this.f5374x = f7;
        m5302a(ElementType.DESCRIPTION, AttachmentCoverDesignSpec.f5339d * f4, f3 * 2.0f);
        m5302a(ElementType.BYLINE, AttachmentCoverDesignSpec.f5339d * f4, f3);
        m5302a(ElementType.BYLINE_AREA, AttachmentCoverDesignSpec.f5339d * f4, f3);
        m5302a(ElementType.HEADLINE, AttachmentCoverDesignSpec.f5339d * f4, 2.0f * f3);
        m5302a(ElementType.OVERLAY, AttachmentCoverDesignSpec.f5339d * f4, f3);
        m5302a(ElementType.SOURCE_IMAGE, f4, f3);
        m5302a(ElementType.COVER_IMAGE, AttachmentCoverDesignSpec.f5339d * f4, f2);
        m5302a(ElementType.COVER_VIDEO, AttachmentCoverDesignSpec.f5339d * f4, f2);
        this.f5358h.f5413g = f4;
        this.f5358h.f5414h = f3;
        this.f5358h.f5407a = f5;
        this.f5358h.f5408b = f6;
    }

    private void m5302a(ElementType elementType, float f, float f2) {
        if (elementType == ElementType.DESCRIPTION) {
            this.f5376z = new DimensionF(f, f2);
        } else if (elementType == ElementType.BYLINE) {
            this.f5343B = new DimensionF(f, f2);
        } else if (elementType == ElementType.BYLINE_AREA) {
            this.f5345D = new DimensionF(f, f2);
        } else if (elementType == ElementType.HEADLINE) {
            this.f5347F = new DimensionF(f, f2);
        } else if (elementType == ElementType.COVER_IMAGE) {
            this.f5348G = new DimensionF(f, f2);
        } else if (elementType == ElementType.OVERLAY) {
            this.f5349H = new DimensionF(f, f2);
        } else if (elementType == ElementType.SOURCE_IMAGE) {
            this.f5350I = new DimensionF(f, f2);
        }
    }

    public final RectF m5307b() {
        return m5300a(this.f5363m.f5380c, this.f5348G, true);
    }

    public final RectF m5308c() {
        return m5300a(this.f5360j.f5380c, this.f5347F, true);
    }

    public final RectF m5309d() {
        return m5300a(this.f5366p.f5380c, this.f5345D, true);
    }

    public final RectF m5310e() {
        return m5300a(this.f5371u.f5380c, this.f5343B, true);
    }

    public final RectF m5311f() {
        return m5300a(this.f5361k.f5380c, this.f5376z, true);
    }

    public final RectF m5305a(int i) {
        if (i >= this.f5367q.size()) {
            return new RectF();
        }
        return m5300a(((LinkCoverBarDescriptor) this.f5367q.get(i)).f5380c, new DimensionF(this.f5373w, 0.0f), true);
    }

    private RectF m5300a(String str, DimensionF dimensionF, boolean z) {
        LinkCoverElementDescriptor linkCoverElementDescriptor = (LinkCoverElementDescriptor) this.f5368r.get(str);
        if (linkCoverElementDescriptor == null) {
            return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        }
        ElementType elementType = linkCoverElementDescriptor.f5381d;
        LinkCoverPositionDescriptor linkCoverPositionDescriptor = linkCoverElementDescriptor.f5382e;
        PointF pointF = new PointF(0.0f, 0.0f);
        if (linkCoverPositionDescriptor == null) {
            return new RectF(pointF.x, pointF.y, dimensionF.f5416a, dimensionF.f5417b);
        }
        RectF a;
        float f;
        if (linkCoverPositionDescriptor.f5397i && linkCoverPositionDescriptor.f5398j.f5387a == DescriptionConstraint.EXACT) {
            dimensionF.f5416a = m5298a(linkCoverPositionDescriptor.f5398j, this.f5358h, dimensionF);
        }
        if (linkCoverPositionDescriptor.f5399k && linkCoverPositionDescriptor.f5400l.f5387a == DescriptionConstraint.EXACT) {
            dimensionF.f5417b = m5303b(linkCoverPositionDescriptor.f5400l, this.f5358h, dimensionF);
        }
        if (linkCoverPositionDescriptor.f5389a == HorizontalPosition.LEFT) {
            pointF.set(this.f5358h.f5408b, pointF.y);
        } else if (linkCoverPositionDescriptor.f5389a == HorizontalPosition.RIGHT) {
            pointF.set((this.f5373w - this.f5358h.f5408b) - dimensionF.f5416a, pointF.y);
        } else if (linkCoverPositionDescriptor.f5389a == HorizontalPosition.LEFT_FLUSH) {
            pointF.set(0.0f, pointF.y);
        } else if (linkCoverPositionDescriptor.f5389a == HorizontalPosition.CENTER) {
            pointF.set((this.f5373w - dimensionF.f5416a) / 2.0f, pointF.y);
        } else if (HorizontalPosition.hasElementArgument(linkCoverPositionDescriptor.f5389a)) {
            RectF a2 = m5301a(linkCoverPositionDescriptor.f5392d, z);
            if (linkCoverPositionDescriptor.f5389a == HorizontalPosition.LEFT_OF) {
                pointF.set(a2.left - dimensionF.f5416a, pointF.y);
            } else if (linkCoverPositionDescriptor.f5389a == HorizontalPosition.RIGHT_OF) {
                pointF.set(a2.right, pointF.y);
            } else if (linkCoverPositionDescriptor.f5389a == HorizontalPosition.CENTER_IN) {
                pointF.set((a2.width() + a2.left) / 2.0f, pointF.y);
            }
        }
        boolean isTextElement = ElementType.isTextElement(elementType);
        boolean z2 = false;
        boolean z3 = false;
        if (linkCoverPositionDescriptor.f5393e == VerticalPosition.TOP) {
            pointF.set(pointF.x, this.f5358h.f5407a);
            z2 = isTextElement;
        } else if (linkCoverPositionDescriptor.f5393e == VerticalPosition.BOTTOM) {
            pointF.set(pointF.x, (this.f5374x - this.f5358h.f5407a) - dimensionF.f5417b);
            z3 = isTextElement;
        } else if (linkCoverPositionDescriptor.f5393e == VerticalPosition.TOP_FLUSH) {
            pointF.set(pointF.x, 0.0f);
        } else if (linkCoverPositionDescriptor.f5393e == VerticalPosition.BOTTOM_FLUSH) {
            pointF.set(pointF.x, this.f5374x - dimensionF.f5417b);
        } else if (VerticalPosition.hasElementArgument(linkCoverPositionDescriptor.f5393e)) {
            a = m5301a(linkCoverPositionDescriptor.f5396h, z);
            if (linkCoverPositionDescriptor.f5393e == VerticalPosition.ABOVE) {
                pointF.set(pointF.x, a.top - dimensionF.f5417b);
                z3 = isTextElement;
            } else if (linkCoverPositionDescriptor.f5393e == VerticalPosition.BELOW) {
                pointF.set(pointF.x, a.bottom);
                z2 = isTextElement;
            } else if (linkCoverPositionDescriptor.f5393e == VerticalPosition.CENTERED_IN) {
                if (isTextElement) {
                    pointF.set(pointF.x, TextMetrics.m5331b(a));
                } else {
                    pointF.set(pointF.x, ((a.height() - dimensionF.f5417b) / 2.0f) + a.top);
                }
            }
        } else if (VerticalPosition.hasGridArgument(linkCoverPositionDescriptor.f5393e)) {
            if (linkCoverPositionDescriptor.f5393e == VerticalPosition.BASE_ON_GRID_LINE) {
                pointF.set(pointF.x, (this.f5358h.f5407a + (((float) linkCoverPositionDescriptor.f5395g) * this.f5358h.f5414h)) - dimensionF.f5417b);
            } else if (linkCoverPositionDescriptor.f5393e == VerticalPosition.CENTERED_IN_GRID_LINE) {
                pointF.set(pointF.x, (this.f5358h.f5407a + ((((float) linkCoverPositionDescriptor.f5395g) - 0.5f) * this.f5358h.f5414h)) - (dimensionF.f5417b / 2.0f));
            }
        }
        if (z2) {
            pointF.set(pointF.x, TextMetrics.m5329a(pointF.y));
        }
        if (z3) {
            pointF.set(pointF.x, TextMetrics.m5330a(pointF.y + dimensionF.f5417b, dimensionF));
        }
        pointF.set(pointF.x + linkCoverPositionDescriptor.f5390b, pointF.y + linkCoverPositionDescriptor.f5394f);
        if (linkCoverPositionDescriptor.f5397i && linkCoverPositionDescriptor.f5398j.f5387a != DescriptionConstraint.EXACT) {
            if (linkCoverPositionDescriptor.f5398j.f5387a == DescriptionConstraint.MAX) {
                dimensionF.f5416a = Math.min(dimensionF.f5416a, m5298a(linkCoverPositionDescriptor.f5398j, this.f5358h, new DimensionF(this.f5373w, this.f5374x)));
            }
            if (DescriptionConstraint.hasElementArgument(linkCoverPositionDescriptor.f5398j.f5387a)) {
                float f2 = pointF.x;
                f = this.f5373w - this.f5358h.f5408b;
                String a3 = linkCoverPositionDescriptor.f5398j.m5314a();
                RectF a4 = m5301a(a3, z);
                if (a3 != null && linkCoverPositionDescriptor.f5398j.f5387a == DescriptionConstraint.BEFORE) {
                    f = m5298a(linkCoverPositionDescriptor.f5398j, this.f5358h, new DimensionF(this.f5373w, this.f5374x)) + a4.left;
                }
                if (a3 != null && linkCoverPositionDescriptor.f5398j.f5387a == DescriptionConstraint.AFTER) {
                    f2 = m5298a(linkCoverPositionDescriptor.f5398j, this.f5358h, new DimensionF(this.f5373w, this.f5374x)) + a4.right;
                }
                f -= f2;
                if (dimensionF.f5416a > f) {
                    dimensionF.f5416a = f;
                    pointF.set(f2, pointF.y);
                }
            }
        }
        z3 = false;
        if (linkCoverPositionDescriptor.f5399k && linkCoverPositionDescriptor.f5400l.f5387a != DescriptionConstraint.EXACT) {
            if (linkCoverPositionDescriptor.f5400l.f5387a == DescriptionConstraint.MAX) {
                f = m5303b(linkCoverPositionDescriptor.f5400l, this.f5358h, new DimensionF(this.f5373w, this.f5374x));
                if (dimensionF.f5417b > f) {
                    dimensionF.f5417b = f;
                    z3 = isTextElement;
                }
            } else {
                float f3 = pointF.y;
                float f4 = this.f5374x - this.f5358h.f5407a;
                if (linkCoverPositionDescriptor.f5400l.f5387a == DescriptionConstraint.AFTER) {
                    RectF a5 = m5301a(linkCoverPositionDescriptor.f5400l.m5314a(), z);
                    if (a5.bottom < this.f5374x) {
                        f = a5.bottom + m5303b(linkCoverPositionDescriptor.f5400l, this.f5358h, new DimensionF(this.f5373w, this.f5374x));
                        if (f3 < f) {
                            f3 = f - pointF.y;
                            this.f5374x -= f3;
                            pointF.set(pointF.x, f3 + pointF.y);
                            if (linkCoverPositionDescriptor.f5400l.f5387a == DescriptionConstraint.BEFORE) {
                                a = m5301a(linkCoverPositionDescriptor.f5400l.m5314a(), z);
                                if (a.top > 0.0f) {
                                    f3 = a.top + m5303b(linkCoverPositionDescriptor.f5400l, this.f5358h, new DimensionF(this.f5373w, this.f5374x));
                                    f = f3 - f;
                                    if (dimensionF.f5417b > f) {
                                        dimensionF.f5417b = Math.max(f, 0.0f);
                                        z3 = isTextElement;
                                    }
                                }
                            }
                            f3 = f4;
                            f = f3 - f;
                            if (dimensionF.f5417b > f) {
                                dimensionF.f5417b = Math.max(f, 0.0f);
                                z3 = isTextElement;
                            }
                        }
                    }
                }
                f = f3;
                if (linkCoverPositionDescriptor.f5400l.f5387a == DescriptionConstraint.BEFORE) {
                    a = m5301a(linkCoverPositionDescriptor.f5400l.m5314a(), z);
                    if (a.top > 0.0f) {
                        f3 = a.top + m5303b(linkCoverPositionDescriptor.f5400l, this.f5358h, new DimensionF(this.f5373w, this.f5374x));
                        f = f3 - f;
                        if (dimensionF.f5417b > f) {
                            dimensionF.f5417b = Math.max(f, 0.0f);
                            z3 = isTextElement;
                        }
                    }
                }
                f3 = f4;
                f = f3 - f;
                if (dimensionF.f5417b > f) {
                    dimensionF.f5417b = Math.max(f, 0.0f);
                    z3 = isTextElement;
                }
            }
            if (z3) {
                LinkCoverTextDescriptor linkCoverTextDescriptor = (LinkCoverTextDescriptor) linkCoverElementDescriptor;
                TextMetrics textMetrics = z ? linkCoverTextDescriptor.f5403h : linkCoverTextDescriptor.f5402b;
                dimensionF.f5417b = ((float) Math.floor((double) (dimensionF.f5417b / textMetrics.f5426c))) * textMetrics.f5426c;
                if (dimensionF.f5417b < textMetrics.f5426c) {
                    dimensionF.f5417b = 0.0f;
                }
            }
        }
        return new RectF(pointF.x, pointF.y, pointF.x + dimensionF.f5416a, pointF.y + dimensionF.f5417b);
    }

    private static float m5298a(LinkCoverDescriptionConstraintDescriptor linkCoverDescriptionConstraintDescriptor, LinkCoverMetrics linkCoverMetrics, DimensionF dimensionF) {
        float a = LinkCoverParsingUtils.m5321a(linkCoverDescriptionConstraintDescriptor.f5388b.f5378b, linkCoverMetrics, dimensionF);
        if (linkCoverDescriptionConstraintDescriptor.f5388b.f5379c != null) {
            return a + LinkCoverParsingUtils.m5321a(linkCoverDescriptionConstraintDescriptor.f5388b.f5379c, linkCoverMetrics, dimensionF);
        }
        return a;
    }

    private static float m5303b(LinkCoverDescriptionConstraintDescriptor linkCoverDescriptionConstraintDescriptor, LinkCoverMetrics linkCoverMetrics, DimensionF dimensionF) {
        float b = LinkCoverParsingUtils.m5322b(linkCoverDescriptionConstraintDescriptor.f5388b.f5378b, linkCoverMetrics, dimensionF);
        if (linkCoverDescriptionConstraintDescriptor.f5388b.f5379c != null) {
            return b + LinkCoverParsingUtils.m5322b(linkCoverDescriptionConstraintDescriptor.f5388b.f5379c, linkCoverMetrics, dimensionF);
        }
        return b;
    }

    private RectF m5301a(String str, boolean z) {
        LinkCoverElementDescriptor linkCoverElementDescriptor = (LinkCoverElementDescriptor) this.f5368r.get(str);
        RectF a = z ? m5299a(linkCoverElementDescriptor) : m5304b(linkCoverElementDescriptor);
        if (linkCoverElementDescriptor == null || !ElementType.isTextElement(linkCoverElementDescriptor.f5381d)) {
            return a;
        }
        return a;
    }

    private RectF m5299a(LinkCoverElementDescriptor linkCoverElementDescriptor) {
        if (linkCoverElementDescriptor == null) {
            return new RectF();
        }
        if (linkCoverElementDescriptor.f5381d == ElementType.BYLINE) {
            return m5300a(this.f5371u.f5380c, this.f5343B, true);
        }
        if (linkCoverElementDescriptor.f5381d == ElementType.BYLINE_AREA) {
            return m5300a(this.f5366p.f5380c, this.f5345D, true);
        }
        if (linkCoverElementDescriptor.f5381d == ElementType.DESCRIPTION) {
            return m5300a(this.f5361k.f5380c, this.f5376z, true);
        }
        if (linkCoverElementDescriptor.f5381d == ElementType.HEADLINE) {
            return m5300a(this.f5360j.f5380c, this.f5347F, true);
        }
        if (linkCoverElementDescriptor.f5381d == ElementType.COVER_IMAGE) {
            return m5307b();
        }
        if (linkCoverElementDescriptor.f5381d == ElementType.OVERLAY) {
            return m5300a(this.f5365o.f5380c, this.f5349H, true);
        }
        if (linkCoverElementDescriptor.f5381d == ElementType.SOURCE_IMAGE) {
            return m5312m();
        }
        if (linkCoverElementDescriptor.f5381d == ElementType.COVER_VIDEO) {
            return m5300a(this.f5364n.f5380c, this.f5348G, true);
        }
        if (linkCoverElementDescriptor.f5381d == ElementType.BAR) {
            return m5300a(linkCoverElementDescriptor.f5380c, new DimensionF(0.0f, 0.0f), true);
        }
        return new RectF();
    }

    public final RectF m5312m() {
        if (this.f5351a && (this.f5350I.f5417b > 80.0f || this.f5350I.f5416a > 40.0f)) {
            float f = 80.0f / this.f5350I.f5417b;
            if (this.f5350I.f5416a * f > 40.0f) {
                f = 40.0f / this.f5350I.f5416a;
            }
            this.f5350I = new DimensionF(this.f5350I.f5416a * f, f * this.f5350I.f5417b);
        }
        return m5300a(this.f5362l.f5380c, this.f5350I, true);
    }

    private RectF m5304b(LinkCoverElementDescriptor linkCoverElementDescriptor) {
        if (linkCoverElementDescriptor.f5381d == ElementType.BYLINE) {
            return m5300a(this.f5371u.f5380c, this.f5342A, false);
        }
        if (linkCoverElementDescriptor.f5381d == ElementType.BYLINE_AREA) {
            return m5300a(this.f5366p.f5380c, this.f5344C, false);
        }
        if (linkCoverElementDescriptor.f5381d == ElementType.DESCRIPTION) {
            if (this.f5361k.f5402b.f5425b == 0.0f) {
                return new RectF();
            }
            if (this.f5369s) {
                return m5300a(this.f5361k.f5380c, this.f5375y, false);
            }
            return new RectF();
        } else if (linkCoverElementDescriptor.f5381d == ElementType.HEADLINE) {
            return m5300a(this.f5360j.f5380c, this.f5346E, false);
        } else {
            if (linkCoverElementDescriptor.f5381d == ElementType.COVER_IMAGE) {
                return m5307b();
            }
            if (linkCoverElementDescriptor.f5381d == ElementType.OVERLAY) {
                return m5300a(this.f5365o.f5380c, this.f5349H, true);
            }
            if (linkCoverElementDescriptor.f5381d == ElementType.SOURCE_IMAGE) {
                return m5312m();
            }
            if (linkCoverElementDescriptor.f5381d == ElementType.COVER_VIDEO) {
                return m5300a(this.f5364n.f5380c, this.f5348G, true);
            }
            return new RectF();
        }
    }
}
