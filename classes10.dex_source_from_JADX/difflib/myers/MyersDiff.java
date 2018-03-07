package difflib.myers;

import difflib.ChangeDelta;
import difflib.Chunk;
import difflib.DeleteDelta;
import difflib.Delta;
import difflib.Differentiator;
import difflib.InsertDelta;
import difflib.Patch;
import java.lang.reflect.Array;
import java.util.List;

/* compiled from: event_change_story_pin_status */
public class MyersDiff<T> {
    public final Patch<T> m13872a(List<T> list, List<T> list2, Differentiator<T> differentiator) {
        try {
            Object[] toArray = list.toArray();
            Object[] toArray2 = list2.toArray();
            return m13868a(m13869a(toArray, toArray2, (Differentiator) differentiator), toArray, toArray2, (Differentiator) differentiator);
        } catch (DifferentiationFailedException e) {
            e.printStackTrace();
            return new Patch();
        }
    }

    private static <T> PathNode m13869a(T[] tArr, T[] tArr2, Differentiator<T> differentiator) {
        if (tArr == null) {
            throw new IllegalArgumentException("original sequence is null");
        } else if (tArr2 == null) {
            throw new IllegalArgumentException("revised sequence is null");
        } else {
            int length = tArr.length;
            int length2 = tArr2.length;
            int i = (length + length2) + 1;
            int i2 = (i * 2) + 1;
            int i3 = i2 / 2;
            PathNode[] pathNodeArr = new PathNode[i2];
            pathNodeArr[i3 + 1] = new Snake(0, -1, null);
            int i4 = 0;
            while (i4 < i) {
                int i5 = -i4;
                while (i5 <= i4) {
                    PathNode pathNode;
                    Snake snake;
                    int i6 = i3 + i5;
                    int i7 = i6 + 1;
                    int i8 = i6 - 1;
                    if (i5 == (-i4) || (i5 != i4 && pathNodeArr[i8].f13602a < pathNodeArr[i7].f13602a)) {
                        i2 = pathNodeArr[i7].f13602a;
                        pathNode = pathNodeArr[i7];
                    } else {
                        i2 = pathNodeArr[i8].f13602a + 1;
                        pathNode = pathNodeArr[i8];
                    }
                    pathNodeArr[i8] = null;
                    int i9 = i2 - i5;
                    PathNode diffNode = new DiffNode(i2, i9, pathNode);
                    i7 = i9;
                    i9 = i2;
                    while (i9 < length && i7 < length2 && !differentiator.mo308a(tArr[i9], tArr2[i7])) {
                        i9++;
                        i7++;
                    }
                    if (i9 > diffNode.f13602a) {
                        snake = new Snake(i9, i7, diffNode);
                    } else {
                        PathNode pathNode2 = diffNode;
                    }
                    pathNodeArr[i6] = snake;
                    if (i9 >= length && i7 >= length2) {
                        return pathNodeArr[i6];
                    }
                    i5 += 2;
                }
                pathNodeArr[(i3 + i4) - 1] = null;
                i4++;
            }
            throw new DifferentiationFailedException("could not find a diff path");
        }
    }

    private static <T> Patch<T> m13868a(PathNode pathNode, T[] tArr, T[] tArr2, Differentiator<T> differentiator) {
        if (pathNode == null) {
            throw new IllegalArgumentException("path is null");
        } else if (tArr == null) {
            throw new IllegalArgumentException("original sequence is null");
        } else if (tArr2 == null) {
            throw new IllegalArgumentException("revised sequence is null");
        } else {
            PathNode pathNode2;
            Patch<T> patch = new Patch();
            if (pathNode.mo684a()) {
                pathNode2 = pathNode.f13604c;
            } else {
                pathNode2 = pathNode;
            }
            while (pathNode2 != null && pathNode2.f13604c != null && pathNode2.f13604c.f13603b >= 0) {
                if (pathNode2.mo684a()) {
                    throw new IllegalStateException("bad diffpath: found snake when looking for diff");
                }
                Delta insertDelta;
                int i = pathNode2.f13602a;
                int i2 = pathNode2.f13603b;
                PathNode pathNode3 = pathNode2.f13604c;
                int i3 = pathNode3.f13602a;
                int i4 = pathNode3.f13603b;
                Chunk chunk = new Chunk(i3, m13870a((Object[]) tArr, i3, i), (Differentiator) differentiator);
                Chunk chunk2 = new Chunk(i4, m13870a((Object[]) tArr2, i4, i2), (Differentiator) differentiator);
                if (chunk.m13858c() == 0 && chunk2.m13858c() != 0) {
                    insertDelta = new InsertDelta(chunk, chunk2);
                } else if (chunk.m13858c() <= 0 || chunk2.m13858c() != 0) {
                    insertDelta = new ChangeDelta(chunk, chunk2);
                } else {
                    insertDelta = new DeleteDelta(chunk, chunk2);
                }
                patch.m13864a(insertDelta);
                if (pathNode3.mo684a()) {
                    pathNode2 = pathNode3.f13604c;
                } else {
                    pathNode2 = pathNode3;
                }
            }
            return patch;
        }
    }

    private static <T> T[] m13870a(T[] tArr, int i, int i2) {
        return m13871a((Object[]) tArr, i, i2, tArr.getClass());
    }

    private static <T, U> T[] m13871a(U[] uArr, int i, int i2, Class<? extends T[]> cls) {
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException(i + " > " + i2);
        }
        Object obj;
        if (cls == Object[].class) {
            obj = new Object[i3];
        } else {
            Object[] objArr = (Object[]) Array.newInstance(cls.getComponentType(), i3);
        }
        System.arraycopy(uArr, i, obj, 0, Math.min(uArr.length - i, i3));
        return obj;
    }
}
