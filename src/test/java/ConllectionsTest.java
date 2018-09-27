import com.google.common.collect.Iterables;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.List;

public class ConllectionsTest {
    @Test
    public void collection() {
        List<Integer> integers = Ints.asList(1, 2, 3);
        List<Integer> integers1 = Ints.asList(4, 5, 6);
        Iterable<Integer> concatenated = Iterables.concat(integers, integers1); // concatenated包括元素 1, 2, 3, 4, 5, 6
        Iterables.elementsEqual(integers1, integers);
        int lastAdded = Iterables.getLast(concatenated);//返回iterable的第一个元素，若iterable为空则返回默认值
        int theElement = Iterables.getOnlyElement(concatenated);//返回iterable的最后一个元素，若iterable为空则抛出NoSuchElementException
    }
}