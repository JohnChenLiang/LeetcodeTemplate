package com.example.leetcodetemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

@SpringBootApplication
public class LeetcodeTemplateApplication {

    public static void main(String[] args) {
        //ASCII码 '0'是48  'A' 是65，’a‘ 是97，相差32


        //当double类型小数点后超过3位就会按科学计数法显示：1.0E-4 ，即<=0.0001
        //小数点前 超过7位数 也会按科学计数法显示。10^7，7个0是8位数 即一千万 就科学技术法了。。9999999还能正常显示，
        //Java里科学计数法赋值写法：long r = (long) 1e18; //表示r赋值为10^18。1e1是计算机语言中的科学表示法，表示10，计算机中的e不是 数学里那个自然对数的底

        //int的范围是-2147483648~2147483647。//[-2^31 ~ 2^31-1] 即负21亿 到 正21亿, 大概是 2 * 10^9, 10的8次方是1亿， 10的9次方是10亿。
        //int最大是2^31 - 1，表明int取不到2^31，但能取2^30，即能是长度为30的二进制字符串。 2^30 = 1073741824 > 1.07 * 10^9 > 10^9

        /*  8种基本数据类型，4整数型：byte、short、int、long；2浮点型：float、double；1字符型：char；1布尔型：boolean
        基本类型	    位数	字节	    默认值	    取值范围
        byte	    8	    1	        0	        -128 ~ 127
        short	    16	    2	        0	        -32768 ~ 32767
        int	        32	    4	        0	        -2147483648 ~ 2147483647
        long	    64	    8	        0L	        -9223372036854775808 ~ 9223372036854775807
        float	    32	    4	        0f	        1.4E-45 ~ 3.4028235E38
        double	    64	    8	        0d	        4.9E-324 ~ 1.7976931348623157E308
        char	    16	    2	        'u0000'	    0 ~ 65535
        boolean	    1		未明确定义   false	    true、false
        */


        System.out.println("Hello world!");
        SpringApplication.run(LeetcodeTemplateApplication.class, args);
    }

    //求位数，可以转成字符数组 通过遍历减'0'来求。如果数字不是太长 也可以用除法取余加while循环来求,但这种方法要注意结果的顺序。

    //遇到要处理 前导零 的情况，可以考虑把字符串直接转为数字，这样字符串只能是数字 不能有其他的，不然没法转成数字，而且这样就可能要考虑新的问题 不能过超过所选数字类型的范围。

    //数据范围10^4 可以考虑暴力，中等题周赛时最后想不出来再用暴力，10^9范围 暴力肯定超时

    //周赛思路觉得正确且没法优化 可以试试用js

    //TreeMap自带有函数 从左或从右找 最接近给定值的key，能降低时间复杂度。
    //int smaller = treeMap.floorKey(n); //返回小于或等于给定键的最大键，如果没有这样的键，则null
    //int bigger =  reeMap.ceilingKey(n); //返回大于或等于给定键的最小键，如果没有这样的键，则null

    //TreeMap默认是对key从小到大排序，下面这写法可以建一个 key从大到小排序的TreeMap
    //TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(Comparator.reverseOrder()); //从大到小的

    //二维数组 按第二列降序，在第二列相同的情况按第一列升序。记忆方法是 小的在前面 中间用减号链接。
    //Arrays.sort(time, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o2[1] - o1[1]);

    //判断是否包含 Java用 字符串和集合的contains；JavaScrip用includes 都是返回true和false的

    //Arrays.binarySearch(nums, i) < 0; //看数组里有没有i，小于0 是没有，好像大于等于0 是有，返回值是下标值。这个数组要是排序的数组，底层是二分。
    //Arrays.equals(num1, num2) //判断两个数组是否相同的一行写法。底层也是通过一遍for循环实现的。

    //Java里 replace是替换全部，参数是字符串；replaceAll是替换全部，参数是正则；
    //JavaScript里 replace的参数是字符串 是替换找到的第一个；replace的参数是正则 是替换全部；replaceAll方法leetcode里支持，参数是字符串 是替换全部，但不知道其他地方js支不支持replaceAll

    //要连着写几行if判断，要确保第二个和之后的if的判断条件 不能被之前的if所改变。如果会被改变，那要用 else if 来写。

    //BigInteger有现成的求最大公因数的函数gcd，用法：a.gcd(b)。a、b都要是BigInteger
    // 用法：BigInteger a = new BigInteger("12");BigInteger b= new BigInteger("16");System.out.println(a.gcd(b)); //结果是4，最最大公因数是4


    //Deque 当队列用，主要是 addLast---加到队尾，pollFirst---获取队头并删除，peekFirst---获取队头但不删除，判断时用。
    //Deque 当栈用，有两种做法
    // 一种是 addLast---入栈，removeLast---出栈，peekLast---获取位于栈最上面的但不删除，判断时用。最好用这种，这样Deque可以用基于数组的，查询也快，不用基于链表的。
    // 另一种是 addFirst---入栈，removeFirst---出栈，peekFirst---获取位于栈最上面的但不删除，判断时用。这种Deque要基于链表的。两种方法速度都差不多，还是默认用上面这种基于数组的。

    // 0         0       5     101     10    1010
    // 1         1       6     110     11    1011
    // 2        10       7     111     12    1100
    // 3        11       8    1000
    // 4       100       9    1001


    //二进制字符串 转 十进制。 Integer.parseInt("100", 2);//二进制100 对应的十进制是4。parseInt方法是 将字符串参数解析为第二个参数指定的基数中的有符号整数
    //十进制int 转 二进制字符串。Integer.toBinaryString(4);//十进制是4 对应的 二进制是100。
    //按位异或。式子 val ^ first 等于 second，知道其中两个能求出另外一个，val = first ^ second


    //二分题 必写代码：
    //if () l = m + 1; //取右半边
    //else r = m; //取左半边，包含中值。

    //二分题模板.1.求要二分的范围。
    //          2.求范围的中值m = (l + r) >>> 1。
    //          3.把中值代入 根据结果 看取范围的左半部分 还是右半部分。
    //              常规的写法是if() l=m+1;else r=m;然后看符不符合题意。不符合要换写法，if() l=m;else r=m-1;然后对应中值求法也得换m = (l + r + 1) >>> 1，不然跳不出循环。
    //          4.继续不断二分 直到 范围只包含一个数，即l = r的情况，说明 找到唯一的数，退出循环。
    //            因为结果肯定在范围里，又找到唯一的数，那所求就是该数，返回该数。
    //875. 爱吃香蕉的珂珂
    //这题暴力超时，一定要二分做。
    //思路：piles数组的最大值为maxK， 结果就在[1, maxK]范围中，用二分来找符合题意的最小的。
    //      求出中值，用中值求出总共花的时间。
    //      所花时间比h长，说明效率低了，说明要从中值右边这块[k + 1, r]找；
    //      所花时间小于等于h，说明就要从中值左边这块[l, k]找。
    //      最后 l和r 重合，说明找到，退出循环，返回l或r都行 毕竟一样。
    //      要把区间收到 l=r，因为结果肯定在[1, maxK]范围中，把区间缩到l=r，即只有一个数，那这个数肯定是所求。
    //      不能直接二分的公式 找到sumH为h时就返回。因为sumH为 h时，k不一定是最小的，可能左边还有 符合的 更小的k，所以不能直接return。
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        Arrays.sort(piles);
        int maxK = piles[len - 1];

        //确定二分范围[1, maxK]
        int l = 1;
        int r = maxK;
        while (l < r){
            //求出范围的中值k。
//            int k = (l + r) / 2; //l+r结果数值过大会存在溢出，不推荐用
//            int k = l + (r - l) / 2; //小的 加上 差值的一半 也是中值,不会有 溢出风险。
//            int k = l / 2 + r / 2; //也不会有 溢出风险，但都是整数，我不知道结果对不对。
            int k  = (l + r) >>> 1; //正数右移运算相当于除以二，l + r超int范围也没关系，最后能得到正确的平均值，而且效率高很多
            double sumH = 0;
            for (int j = 0; j < len; j++) {
                sumH += (piles[j] - 1) / k + 1; //piles[j]/k 向上取整的值。 //这种向上取整更快。
            }
            //sumH为 h时，k不一定是最小的，可能左边还有 符合的 更小的k，所以不能直接return。
            //要把区间收到 l=r，因为结果肯定在[1, maxK]范围中，把区间缩到l=r，即只有一个数，那这个数肯定是所求。
            if (sumH > h) l = k + 1; //效率太低了，则要取右半边的，效率高点的，即[k + 1, r]
            else r = k; //sumH <= h,耗时小于等于 h，说明当前猜的这个速度k可能是符合题意的一个解（不能排除掉，后面的搜索表示找有没有更小的速度），所以搜索范围是 [l, k]，设置 r = k。
        }

        return l;
    }

    //背包dp的二维dp思路。
    //一个二维数组，其中一维代表当前「当前枚举到哪件物品」，另外一维「现在的剩余容量」，数组装的是「最大价值」。
    //选下一个数的时候 用得上 现在的剩余容量 这个条件。从选最后一个物品开始思考。即思考选不选i，但最终选不选i的结果 都是从 i-1的基础上再求出的。
    //根据 dp 数组不难得出状态定义：考虑前i件物品，使用容量不超过C的条件下的背包最大价值。
    //根据「最后一步」选择来推导「状态转移方程」
    //对于第i件物品，我们有「不选」和「选」两种决策。
    //dp[i][c] = max(dp[i - 1][c], dp[i - 1][c - v[i]] + w[i])
    //其中「选」的前提 要 满足 「当前剩余的背包容量」 >= 「物品的体积」。
    public int maxValue999(int N, int C, int[] v, int[] w) {
        //有N件物品和一个容量是C的背包。每件物品有且只有一件。第i件物品的体积是v[i] ，价值是w[i]。
        //求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
        int[][] dp = new int[N][C+1];

        //先处理「考虑第一件物品」的情况，然后 现在剩余的容量从0到C (即 枚举到第一个物品，遍历从 不装 到 装满的情况)。应该是 为了求 数学归纳法的第一项、
        //求下面会用到的dp[0][0~C]的值
        for (int i = 0; i <= C; i++) {
            //现在剩余的容量 大于等于 第一件物品的体积，则 dp的值都是 第一件物品的价值。如果 现在剩余的容量装不下 第一个 则dp值都是0。
            dp[0][i] = (i >= v[0] ? w[0] : 0);
        }
        //再处理「考虑其余物品」的情况
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < C + 1; j++) {
                // 不选该物品
                int no = dp[i - 1][j];
                // 选择该物品，前提「剩余容量」大于等于「物品体积」
                int yes = (j >= v[i] ? dp[i - 1][j - v[i]] + w[i] : 0);
                dp[i][j] = Math.max(no, yes);
            }
        }
        return dp[N-1][C];
    }

    //背包dp 二维优化成一维。
    //有N件物品和一个容量是C的背包。每件物品有且只有一件。第i件物品的体积是v[i] ，价值是w[i]。
    //求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
    //dp[i][c] = max(dp[i - 1][c], dp[i - 1][c - v[i]] + w[i])
    //观察上面二维的状态转移方程,
    //不难发现当求解第i行格子的值时，不仅是只依赖第i-1行，还明确只依赖第i-1行的第c个格子和第c-v[i]个格子（也就是对应着第i个物品不选和选的两种情况）。
    //    c-v[i]           c
    //                     c
    //换句话说，只依赖于「上一个格子的位置」以及「上一个格子的左边位置」。
    //可以优化成只保留代表「剩余容量」的维度的一维dp
    //dp[c] = max(dp[c], dp[c - v[i]] + w[i])
    public int maxValue888(int N, int C, int[] v, int[] w) {
        int[] dp = new int [C + 1];
        for (int i = 0; i < N; i++) { //从前i个物品中一次次选出来
            for (int j = C; j >= v[i]; j--) { //从C往前推 直到v[i],这样选该物品时 就不用 再加条件了。
                int no = dp[j]; //不选该物品，那dp值就是 上一行该列的值。
                int yes = dp[j - v[i]] + w[i]; //选该物品，那dp值就是 （上一行减去 该物品空间的值 的列 再加上 该物品的价值）
                dp[j] = Math.max(no, yes);
            }
        }

        //返回最大容量时的dp值。
        return dp[C];
    }
}
