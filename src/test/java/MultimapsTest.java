import com.google.common.base.Function;
import com.google.common.collect.*;
import org.junit.Test;

import java.util.Map;


/**
 * Created by huangdongliang on 2018/8/29.
 */
public class MultimapsTest {
    @Test
    public void index(){
        ImmutableSet digits = ImmutableSet.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        Function<String, Integer> lengthFunction = new Function<String, Integer>() {
            public Integer apply(String string) {
                return string.length();
            }
        };

        ImmutableListMultimap<Integer, String> digitsByLength= Multimaps.index(digits, lengthFunction);
        System.out.println(digitsByLength);
        System.out.println(digitsByLength.keySet());
        System.out.println(digitsByLength.values());
/*
*  digitsByLength maps:
*  3 => {"one", "two", "six"}
*  4 => {"zero", "four", "five", "nine"}
*  5 => {"three", "seven", "eight"}
*/
    }

    /**
     * 想在Map对象上使用Multimap的方法吗？forMap(Map)把Map包装成SetMultimap。这个方法特别有用，
     * .例如，与Multimaps.invertFrom结合使用，可以把多对一的Map反转为一对多的Multimap。
     */
    @Test
    public void forMap(){
        Map<String, Integer> map = ImmutableMap.of("a", 1, "b", 1, "c", 2);
        System.out.println(map);
        SetMultimap<String, Integer> multimap = Multimaps.forMap(map);
        System.out.println(multimap);
// multimap：["a" => {1}, "b" => {1}, "c" => {2}]
        Multimap<Integer, String> inverse = Multimaps.invertFrom(multimap, HashMultimap.create());
// inverse：[1 => {"a","b"}, 2 => {"c"}]
        System.out.println(inverse);
    }
}
