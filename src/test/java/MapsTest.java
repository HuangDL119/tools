
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by Huangdongliang on 2017/4/24.
 */
public class MapsTest {
    /**
     * Maps.uniqueIndex(Iterable,Function)通常针对的场景是：
     * 有一组对象，它们在某个属性上分别有独一无二的值，
     * 而我们希望能够按照这个属性值查找对象——
     * 这个方法返回一个Map，键为Function返回的属性值，值为Iterable中相应的元素，
     * 因此我们可以反复用这个Map进行查找操作。
     */
    @Test
    public void maps(){
        List<String> list = Lists.newArrayList("A","BA");
        Map<Integer, String> uniqueIndex = Maps.uniqueIndex(list, String -> String.length());
        System.out.println(uniqueIndex.keySet());
        System.out.println(uniqueIndex.get(1));
        System.out.println(uniqueIndex.get(2));
    }

    /**
     * Maps.difference(Map, Map)用来比较两个Map以获取所有不同点。
     * 该方法返回MapDifference对象，把不同点的维恩图分解为：
     */
    @Test
    public void difference(){
        Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
        Map<String, Integer> right = ImmutableMap.of( "b", 2, "c",3,"d", 5);
        MapDifference<String, Integer> diff = Maps.difference(left, right);
        diff.entriesInCommon(); // {"b" => 2}
        diff.entriesInCommon(); // {"b" => 2}
        diff.entriesOnlyOnLeft(); // {"a" => 1}
        System.out.println( diff.entriesOnlyOnLeft().keySet());
        System.out.println( diff.entriesOnlyOnLeft().values());
        diff.entriesOnlyOnRight(); // {"d" => 5}
        System.out.println( diff.entriesOnlyOnRight().keySet());
        System.out.println( diff.entriesOnlyOnRight().values());
    }
}