import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * MapのforEachループに上限をかける。
 * めちゃくちゃサイズの大きいMapのデバッグとかに使う
 */
class MapLimitation {
    private static final boolean IS_DEBUG = true;

    public static void main(String[] args) {
        // 適当にMapを生成する
        Map<Integer, Integer> hogeMap = new HashMap<>();
        for (int i = 0; i < 100; ++i) {
            hogeMap.put(new Random().nextInt(), new Random().nextInt());
        }

        // 移し替え用のMap
        Map<Integer, Integer> newMap = new HashMap<>();
        // entryでforループ
        for (Map.Entry<Integer, Integer> hoge : hogeMap.entrySet()) {
            if (IS_DEBUG) {
                // 制限をかける
                if (newMap.size() == 10) {
                    break;
                }
            }
            newMap.put(hoge.getKey(), hoge.getValue());
        }
        System.out.println(String.format("hogeMap.size():%s,newMap.size():%s", hogeMap.size(), newMap.size()));
    }
}