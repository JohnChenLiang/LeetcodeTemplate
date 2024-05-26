package com.example.leetcodetemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigInteger;
import java.util.*;

@SpringBootApplication
public class LeetcodeTemplateApplication {

    //周赛注意事项
    //1.正向思考难，就从尾巴开始思考
    //2.先用HashMap做出来再说，再考虑用数组优化
    //3.周赛思路觉得正确且没法优化 可以试试用js。第3、4题实在做不出 最后考虑用js暴力。
    //4.企业场且取很多人的情况下，为了好名次，可以先用小号做，不写思路，然后把代码复制过来提交，要改下变量 防止被抓到作弊。
    //5.注意数据范围，第2题可能可以用冒泡。数据范围小，O(1)、O(n)的解法麻烦想不出来，则看看能不能直接暴力。
    //6.第3、4题实在做不出 最后考虑用js暴力。
    //7.下标和对应元素有数学关系式的话，最好移动到同一侧，这样 下标和对应元素的关联 就可以再用个数组表示了。
    //8.数学关系式 最好把除法转成对应乘法，因为整数除法会有整数商精度的问题，乘法没有。
    //9.查询区间最值、区间和，以及进行区间更新, 用线段树解决。RMQ 的全称是 Range Minimum/Maximum Query，即区间最大/最小值问题。
    //   处理区间 要想到 滑动窗口、前缀和。
    //   如果 区域最优能通过删除点来维护，且这些点总数固定且只能被删一次，那区间可以用TreeMap来维护，然后删除key。
    //   树状数组能求区间和，还能求区间最值吗？
    //10.图论建图时 特别要注意 题目的描述和题目的注意，比如路径给的是双向的、重复路径且权值不同，这样建图时就要处理了。
    //11.同个题数据范围不同，可以先AC数据小的，然后用数据小的来测试数据大的代码。这样不会算罚时。
    //12.加法和乘法 好像可以处处取余(取模)。除法 好像就不行，除法最好从思路上转化为乘法。
    //   两数相减，结果本该是正数的，但取模后再相减的话，可能结果就是负数了，这种负数结果要先加个模再取个模，这样结果就是正数了。
    //13.int的乘法 很可能超int，要把第一个乘数转成long。乘法后取模，也要先保证乘法结果对，没溢出，取模的结果才会对。
    //    int是 2.1*10^9，两int相乘 最大是 4.41*10^18 < 9.22*10^18，所以int转成long做乘法正好没问题。
    //14.int数组的前缀和也可能超int，要注意数据范围，如果超int 那要转为long数组。
    //15.记忆化搜索数组里的 下标是关键参数 就行，只用来判断的、不会变的参数不用放。记忆化搜索的 前提是递归的输入输出能够记忆化。
    //16.前缀和。数组预处理 成0、1、-1、正数、负数，这几个思路想，然后前缀和 是0或正数或负数。然后前后有关系的话 也可以预处理。
    //17.dfs跟dp 一样能正向推 也能反向推，选好想好写的来。正向和逆向dfs 是根据递归终止条件来吗？
    //     正向dfs不断扩展开求所有的方案数，反向dfs求最优值？ 反向dfs是跟正向dp对应，正向dp 也是在当前 找前面的最优，反向dfs也是这样。

    public static void main(String[] args) {
        //ASCII码 空格是32 '0'是48  'A' 是65，'a' 是97，相差32


        //当double类型小数点后超过3位就会按科学计数法显示：1.0E-4 ，即<=0.0001
        //小数点前 超过7位数 也会按科学计数法显示。10^7，7个0是8位数 即一千万 就科学技术法了。。9999999还能正常显示，
        //Java里科学计数法赋值写法：long r = (long) 1e18; //表示r赋值为10^18。1e1是计算机语言中的科学表示法，表示10，计算机中的e不是 数学里那个自然对数的底

        /*  8种基本数据类型，4整数型：byte、short、int、long；2浮点型：float、double；1字符型：char；1布尔型：boolean
        基本类型	    位数	字节	    默认值	    取值范围
        byte	    8	    1	        0	        [-2^7, 2^7-1] 即-128 ~ 127
        short	    16	    2	        0	        [-2^15, 2^15-1] 即 -32768 ~ 32767
        int	        32	    4	        0	        [-2^31, 2^31-1] 即 -2147483648 ~ 2147483647 即负21亿 到 正21亿, 大概是 2 * 10^9, 10的8次方是1亿， 10的9次方是10亿。
        long	    64	    8	        0L	        [-2^63, 2^63-1] 即 -9223372036854775808 ~ 9223372036854775807，数字长度为19，18位的999能保证。大约是922亿亿
        float	    32	    4	        0f	        [-2^127, 2^127-1] 即 -3.4028235E+38 ~ 3.4028235E+38
        double	    64	    8	        0d	        [-2^1023, 2^1023-1] 但太大有精度问题，绝对值小于 2^53 (约10^15) 的整数都是可以精确表达，这样说记整数double还不如long
        char	    16	    2	        'u0000'	    0 ~ 65535 即0 ~ 2^16-1
        boolean	    1		未明确定义   false	    true、false
        */

        //int的范围是-2147483648~2147483647。//[-2^31 ~ 2^31-1] 即负21亿 到 正21亿, 大概是 2 * 10^9, 10的8次方是1亿， 10的9次方是10亿。
        //int最大是2^31 - 1，表明int取不到2^31，但能取2^30，即能是长度为30的二进制字符串。 2^30 = 1073741824 > 1.07 * 10^9 > 10^9
        //   31个1转成十进制是  2147483647，正好是int上限 不会超int，即 2^31 - 1 = 2^30 * 2 - 1 = 1073741824 * 2 - 1 = 2147483648 - 1 = 2147483647
        //     所以建个长度为31的二进制数组 然后转成十进制是不会超int的。
        //2^10 ≈ 1000 = 10^3，一千；
        //2^20 = 2^10 * 2^10 ≈ 10^6，一百万；
        //2^30 = 1073741824 = 2^10 * 2^10 * 2^10 ≈ 10^9，十亿，没超int；
        //2^31 = 2^30 * 2 ≈ 2.0 * 10^9，二十亿；
        //2^31 是在从右往左算起的         第32个 那有个1，其他都是0，整个长度是32。2^31 = 2147483648 超int上限，比int上限大1。
        // 那2^31 - 1 就是 从右往左算起的 第31个处到最右端都是1， 然后整个长度是31，能填31个1，正好是int上限 没超int。

        // 0         0       5     101     10    1010   15    1111    20    10100    25   11001    30   11110
        // 1         1       6     110     11    1011   16   10000    21    10101    26   11010    31   11111
        // 2        10       7     111     12    1100   17   10001    22    10110    27   11011    32  100000
        // 3        11       8    1000     13    1101   18   10010    23    10111    28   11100    33  100001
        // 4       100       9    1001     14    1110   19   10011    24    11000    29   11101


        //二进制字符串 转 十进制。 Integer.parseInt("100", 2);//二进制100 对应的十进制是4。parseInt方法是 将字符串参数解析为第二个参数指定的基数中的有符号整数
        //十进制int 转 二进制字符串。Integer.toBinaryString(4);//十进制是4 对应的 二进制是100。
        //按位异或。式子 val ^ first 等于 second，知道其中两个能求出另外一个，val = first ^ second

        System.out.println("Hello world!");
        SpringApplication.run(LeetcodeTemplateApplication.class, args);
    }

    //Integer 超128的判断问题。用 orderDTO.getSpareMoney() != null && orderDTO.getSpareMoney().intValue() 或 避免麻烦 直接用for (int i : treeSet)
    //    //遍历第一个map的key 看两个map的 Integer类型的value 是否相等，要用equals判断。若不等 返回false，遍历完都没返回false 就返回true。
    //    //Integer 当值不在-128和127之间时，会创建一个新Integer对象，==判断的是内存地址是否一致。所以这里要用! 和 equals判断 不用!=判断。
    //    boolean check (HashMap<String, Integer> checkMap, HashMap<String, Integer> wordsMap){
    //        for (String i : checkMap.keySet()) {
    //            if (!checkMap.get(i).equals(wordsMap.get(i))) return false;
    //        }
    //        return true;
    //    }

    //求位数，可以转成字符数组 通过遍历减'0'来求。如果数字不是太长 也可以用除法取余加while循环来求,但这种方法要注意结果的顺序。

    //遇到要处理 前导零 的情况，可以考虑把字符串直接转为数字，这样字符串只能是数字 不能有其他的，不然没法转成数字，而且这样就可能要考虑新的问题 不能过超过所选数字类型的范围。

    //数据范围10^4 可以考虑暴力，中等题周赛时最后想不出来再用暴力，10^9范围 暴力肯定超时。
    //leetcode运行时间超过3000ms好像就判定为超时。
    //n = 10^7 时间复杂度最多O(n)
    //n = 10^5 时间复杂度最多0(nlogn)
    //n = 5000 时间复杂度最多O(n^2)
    //n = 1000 时间复杂度最多0(n^2logn)
    //n = 300  时间复杂度最多O(n^3)
    //n = 50   时间复杂度最多0(n^4)
    //n = 24   时间复杂度最多(2^n)
    //n = 9    时间复杂度最多O(n!)

    //单调栈里放 数组和放下标 性能好像差不多，一般放下标。我是用list当单调栈的。两种的区别如下：
    // 1.放数组。[0]是元素值，[1]是下标，代码可读性更好，但代码会长一点多一点。
    // 2.放下标。代码会短一点，但有的复杂的地方要写注释说明一下。

    //TreeMap自带4个二分找key函数，floorKey 找给定键左侧 最靠近给定键的，能取等号，记忆方法是 f是first 那就是找前面的，那就是左侧;
    //                          ceilingKey 找给定键右侧 最靠近给定键的，能取等号；
    //                          lowerKey 严格小于、higherKey 严格大于，这两个取不到等号
    //Integer floorKey = treeMap.floorKey(n); //floorKey返回小于或等于给定键的最大键，能取等号，如果没有这样的键，则null。lowerKey 是严格小于的，取不到等号。
    //Integer ceilingKey =  treeMap.ceilingKey(n); //ceilingKey返回大于或等于给定键的最小键，能取等号，如果没有这样的键，则null。higherKey 是严格大于的，取不到等号。

    //TreeMap默认是对key从小到大排序，下面这写法可以建一个 key从大到小排序的TreeMap
    //TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(Comparator.reverseOrder()); //从大到小的

    //二维数组 按第二列降序，在第二列相同的情况按第一列升序。记忆方法是 逗号，括号 然后放两数组即 o1 o2，再箭头，再三元，三元里放数组的值，小的在前面 中间用减号链接。
    //Arrays.sort(time, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o2[1] - o1[1]);

    //判断是否包含 Java用 字符串和集合的 contains；JavaScript 用 includes 都是返回true和false的

    //Java里 replace是替换全部，参数是字符串；replaceAll是替换全部，参数是正则；
    //JavaScript 里 replace的参数是字符串 是替换找到的第一个；replace的参数是正则 是替换全部；replaceAll方法leetcode里支持，参数是字符串 是替换全部，但不知道其他地方js支不支持replaceAll

    //要连着写几行if判断，要确保第二个和之后的if的判断条件 不能被之前的if所改变。如果会被改变，那要用 else if 来写。

    //BigInteger有现成的求最大公因数的函数gcd，用法：a.gcd(b)。a、b都要是BigInteger
    // 用法：BigInteger a = new BigInteger("12");BigInteger b= new BigInteger("16");System.out.println(a.gcd(b)); //结果是4，最最大公因数是4


    //Deque 当队列用，主要是 addLast---加到队尾，pollFirst---获取队头并删除，peekFirst---获取队头但不删除，判断时用。
    //Deque 当栈用，有两种做法
    // 一种是 addLast---入栈，removeLast---出栈，peekLast---获取位于栈最上面的但不删除，判断时用。最好用这种，这样Deque可以用基于数组的，查询也快，不用基于链表的。
    // 另一种是 addFirst---入栈，removeFirst---出栈，peekFirst---获取位于栈最上面的但不删除，判断时用。这种Deque要基于链表的。两种方法速度都差不多，还是默认用上面这种基于数组的。

    //LinkedList 是基于链表的list， 仅仅在头插入或者删除元素的时候 或在 前半部分增删元素时 比 ArrayList 性能要好，因为基于数组的ArrayList 插入删除时 都要把后面全部 往后或往前移一格。
    //LinkedList其他时候性能跟ArrayList一样 甚至还不如。所以绝大部分都用ArrayList，只有在 有个会对头操作的队列时 或 全是头插入或者删除元素的时候 或 全是在前半部分增删元素时 才会考虑用LinkedList。

    //二叉树遍历的递归写法，在确定递归函数的参数和返回值时，因为要不停地刨根问底 所以节点信息是要传进去的。
    // 不从结果推导 怎么想到要建个集合接受数值，然后写个无返回值的递归函数的？ 为什么不能用 带返回值的递归 解决？

    //排列组合里的阶乘很容易就超int、超long了，最好用 BigInteger，这样要导这个包 import java.math.BigInteger;
    //排列 A(n, m) = (n!)/(n - m)! 从n个不同元素中取出m个元素，按照一定的顺序排成一列；记忆方法是: A的大脚阶乘 上去，差的阶乘 下来。
    //例：A(3, 2) 2个人选3个座位的方法总数，第1个人选时有3个座位，第2个人选时剩2个座位，则2个人分步完成选成选座位这件事，先坐后坐也算不同 所以共有3×2=6种不同的方案。

    //组合 C(n, m) = (n!) / ((m!)*(n - m)!) 从n个不同元素中，不重复地选出m个元素的一个组合。记忆方法是: C的大脚阶乘 上去，差的阶乘 和 小头阶乘 相乘放下面。
    //例：C(3, 2)，从3个不同的元素中，不重复地选出2个元素成为一组，这样元素不同的小组共有3种。以ABC为例，从中不重复地选出2个元素成为一组，这样元素不重复的小组，枚举得出：(A,B)，(A,C)，(B,C)共3种。

    //二维数组斜线上的点。斜45°的，k为正负一，只要分别找到在斜线上的一个点的坐标，代入 y = 土x + b，求出对应的截距b，用 j == 土i + b 来判断遍历到的点是不是在这斜线上。
    //如果不是斜45°的，那就要找出在斜线上的两个点，分别求出k和b。

    //等差数列求和公式 S = n * (A1 + An) / 2 应该时不用改成除以2.0的吧，整数的情况应该不用吧，累加起来都是整数
    //等差数列求和公式  （首相加末项）* 项数 除以二。
    // 正整数等差数列求和公式 结果肯定是整数，因为都是一个个正整数累加出来的。
    // 数学证明是 当为偶数个时 即n为偶数时 除以2不会出问题；当为奇数个时 首项加末项 是 两个奇数相加 或 两个偶数相加，这个除以2也不会出问题。
    // 所以  正整数等差数列 公差为正整数 那它的求和公式直接用就行，不会有 类似3/2为1的问题。

    //红黑树是一种二叉搜索树，节点的值需要满足以下规则：
    //-  左子树上所有节点的值小于当前节点的值
    //-  右子树上所有节点的值大于当前节点的值

    //看是不是素数，小于2的都不是素数，2、3是素数 遍历 [2,sqr(num)),这样时间复杂度是O(sqr(n))。

    //char ccc = s.charAt(10); String sss = s.substring(10,11); 前一个是O(1)的，返回字符，后一个是O(n)的，返回字符串。

    //不是所有的递归都可以直接转换成动态规划。比如二叉树的前序遍历就得用递归写，没法用动态规划。递归能够被转换成动态规划的前提是满足「无后效性」和「最优子结构」的特点。
    //「无后效性」指的是在某个状态下，不管之前做了什么决策，只要当前状态确定，之后的决策和之前的决策路径不会相互影响。
    //「最优子结构」指的是当前问题的最优解包含了子问题的最优解，也就是当前问题可以通过子问题的最优解来决定。这个特点决定了我们可以通过分解问题成子问题来进行状态转移，这也是动态规划问题求解过程所依赖的核心思想。
    //因此，只有满足「无后效性」和「最优子结构」的特点的递归问题，才可以转化成动态规划问题来求解。

    //前序。中在前，就是中左右遍历。
    //递归：1.确定递归函数的参数和返回值。2.确定终止条件。3.确定单层递归的逻辑。
    //递归有返回值的 都要有最后的return来兜底。无返回值可以在 if后return，可以靠这个来终止。

    //字符串不是null 且不是空串 且是正整数。没lang3包 字符串判空得这样写。正整数正则：[1-9] 匹配第一个数字为1-9 中的任意一个；\\d* 匹配 0 个或多个数字，其中 \\d 表示匹配数字。
    //if (str != null && !str.isEmpty() && str.matches("[1-9]\\d*")) {

    //取list里的第一条，还是 if (list != null && list.size() >= 1) list.get(0);这样判断才严谨。
    //因为list有三种情况，为null；不为null但没值 即List 对象已经被实例化，但是没有包含任何元素；有正常值的情况。上面这样写 list有正常值的情况才会 true。
    //if (!CollectionUtils.isEmpty) 这个list判空的写法跟上面这个判断是等价的，推荐写上面这个，一眼能看懂

    //「二分」的本质是两段性，并非单调性。只要一段满足某个性质，另外一段不满足某个性质，就可以用「二分」。
    // 经常遇到的题是 所求的值是在一个范围内，这时可以用二分。因为范围内的元素都是单调递增的，单调肯定满足两段性。

    //数组和list 自带的二分查找 binarySearch 返回的是插入点，保证在这点插入后 还是有序的，但不能保证 遇到重复元素时返回的是第一个重复元素的下标。
    // 所以要 二分找 有序、未去重的第一个下标，要自己写二分，不能直接调自带函数 因为可能会不对。
    //Arrays.binarySearch(nums, i) < 0; //看数组里有没有i，小于0 是没有，好像大于等于0 是有，返回值是下标值。这个数组要是排序的数组，底层是二分。
    //Arrays.equals(num1, num2) //判断两个数组是否相同的一行写法。底层也是通过一遍for循环实现的。

    //Collections.binarySearch 方法会返回该元素在列表中的索引，如果找不到则返回 - (插入点 + 1)。求插入点index的代码是 if (index < 0) index = -index - 1;
    //List<Integer> list = Arrays.asList(1, 3, 4, 6, 8);
    //int index = Collections.binarySearch(list, 4); //结果index 的值为 2
    //int index = Collections.binarySearch(list, 5); //结果index 的值为 -4。可以根据 取负减一 得出 插入点为3

    //取窗口内的第x小的，可以用两个TreeMap，一个放前x个 另一个放剩下的。结果就是 前x个的那个的lastKey。
    //    也可以放list里，把初始 排序后 放进list，然后用Collections.binarySearch找到插入点，加一个减一个时把list维护成升序的，然后直接get要的顺序结果。

    //看别人说 可以二分 逼近到[lo, hi] 两个值，所以出来循环后只要判断一下 lo 和 hi 就行了。这样可以避免考虑 取中值时要不要加一。

    //二分取中值 没加一，那下面if-else判断就要加一;  //而且这样的二分查找 遇到数组里有重复值 返回的是第一个重复值的下标。
    //二分取中值 加一了，那下面if-else判断就要减一？而且中值加一了 也要注意会不会越界。 //而且这样的二分查找 遇到数组里有重复值 返回的是最后一个重复值的下标。

//    public int findPeakElement(int[] nums) {
//        int n = nums.length;
//        int l = 0, r = n - 1;
//        while (l < r) {
//            int mid = (l + r) >>> 1; //二分取中值 没加一
//            if (nums[mid] > nums[mid + 1]) r = mid; //二分取中值 没加一，那[2,3]、[3,4] 取中值取不到r，所以下标 mid+1 不会越界
//            else l = mid + 1; //二分取中值 没加一，那下面if-else判断就要加一;
//        }
//        return r;
//    }
//
//    public int findPeakElement(int[] nums) {
//        int n = nums.length;
//        if (n == 1) return 0;
//        int l = 0, r = n - 1;
//        while (l < r) {
//            int mid = (l + r + 1) >>> 1;  //二分取中值 加一了
//            if (nums[mid] > nums[mid - 1]) l = mid;  //二分取中值 加一了，那[2,3]、[3,4] 取中值取不到l，所以下标 mid-1 不会越界
//            else r = mid - 1; //二分取中值 加一了，那下面if-else判断就要减一
//        }
//        return r;
//    }

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

    // 从选最后一个物品开始思考。即思考选不选i，但最终选不选i的结果 都是从 i-1的基础上再求出的。
    // 不选是 dp[i - 1][c]
    // 选是 dp[i - 1][c - v[i]] + w[i]
    // dp[i][c] 是 选和不选中的最大值。
    //即 dp[i][c] = max(dp[i - 1][c], dp[i - 1][c - v[i]] + w[i])

    //01背包dp的二维dp思路。
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

    //取窗口内的第x小的，可以用两个TreeMap，一个放前x个 另一个放剩下的。结果就是 前x个的那个的lastKey。下面是 维护两个TreeMap的 两个函数，加一个数减一个数的。

    //一个升序的集合或数组，分成不一定等长但都升序的两部分 放到两个TreeMap里，前一部分放到 minMap里，剩下的放到maxMap里，Map里的value记元素个数。
    //然后往这个升序的集合或数组 里加一个数 减一个数，使两个TreeMap的含有的元素个数不变。
    public void addOneRemoveOneAndKeepTreeMap(TreeMap<Integer, Integer> minMap, TreeMap<Integer, Integer> maxMap, int add, int remove) {
        //加一个。先加到小的里，然后把小的最大的放到 大的里，然后小的里对应减一
        minMap.put(add, minMap.getOrDefault(add, 0) + 1);
        int minLastKey = minMap.lastKey();
        maxMap.put(minLastKey, maxMap.getOrDefault(minLastKey, 0) + 1);
        minusOneForMapValue(minMap, minLastKey);

        //减一个。看是不是在大的里，在大的里直接减一；不在大的里，那就是在小的里，小的里先减一，然后把大的里的最小的即firstKey 放到小的里，然后大的的firstKey的value减一
        if (maxMap.containsKey(remove)) minusOneForMapValue(maxMap, remove);
        else {
            minusOneForMapValue(minMap, remove);
            int maxFirstKey = maxMap.firstKey();
            minMap.put(maxFirstKey, minMap.getOrDefault(maxFirstKey, 0) + 1);
            minusOneForMapValue(maxMap, maxFirstKey);
        }
    }

    //map的某个key的value减一。当value为0时 删除。
    public void minusOneForMapValue(TreeMap<Integer, Integer> treeMap, int key) {
        int theValue = treeMap.get(key);
        if (theValue == 1) treeMap.remove(key);
        if (theValue >= 2) treeMap.put(key, theValue - 1);
    }

    //dp 要递推方向（例如左上到右下的递推顺序），如果 上下左右都能走，然后能回头的，就不能dp了。
    //这时 求最短路 可以用迪杰斯克拉。

    //优先队列的迪杰斯克拉，用list建邻接表。链式向前星存图 不好记，如果不是极致优化则不用，最好用list。
    // O(MlogM)。应该是通杀的，稠密图 M ≈ N^2，代入的话O(2N^2logN) = O(N^2logN)，也就比朴素版的O(N^2) 多个log，应该都通杀不影响的。
    public int networkDelayTime(int[][] times, int n, int k) {
        //邻接表。数组里放list，list里再放数组。
        List<int[]>[] g = new List[n + 1];
        //要初始化邻接表，因为到这点后 可能就没别的路走了，不能对null遍历 所以要初始化。
        for (int i = 0; i <= n; i++)
            g[i] =  new ArrayList<>();

        //建图
        for (int[] e : times) {
            g[e[0]].add(new int[]{e[1], e[2]});
        }

        boolean[] vis = new boolean[n + 1]; //记录点有没有被访问过。
        //记录源点到其他点的距离。要都初始化为 INF，然后自身到自身是0；
        int[] dist = new int[n + 1];
        int INF = Integer.MAX_VALUE / 2;
        for (int i = 0; i <= n; i++) dist[i] = INF;
        dist[k] = 0;

        //优先队列。放数组[点编号，到k的距离]，到k的距离最小的在最前。
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        q.add(new int[]{k, 0});
        while (q.size() >= 1) {
            int[] poll = q.poll();
            if (vis[poll[0]]) continue; //更新过就跳过

            vis[poll[0]] = true;

            //上面是 未遍历的最短边 k到poll[0]
            //遍历起点poll[0] 能到的点end，end[0]是点编号，end[1]是权值
            for (int[] end : g[poll[0]]) {
                //k到end[0] > k到poll[0] + poll[0]到end[0]。
                if (dist[end[0]] > poll[1] + end[1]) {
                    dist[end[0]] = poll[1] + end[1];
                    q.add(new int[]{end[0], dist[end[0]]});
                }
            }
        }

        int max = dist[1];
        for (int i = 1; i <= n; i++)
            max = Math.max(max, dist[i]);

        return max == INF ? -1 : max;
    }

    //优先队列的 迪杰斯克拉 + 基于数组的邻接表。链式向前星存图 不好记，如果不是极致优化则不用，最好用list。
    // O(m + n + (n + m)logm) 时间复杂度
    //743. 网络延迟时间。迪杰斯克拉 模板题。
    public static int networkDelayTime22222222222222222222222222222222222222222222(int[][] times, int n, int k) {
        int m = times.length;

        int[] he = new int[n + 1];
        int[] e = new int[m + 1];
        int[] w = new int[m + 1];
        int[] ne = new int[m + 1];
        int idx = 1; //从1开始的，这样就不用改初始的0了,但数组长度就要m+1了

        for (int[] arr : times) {
            e[idx] = arr[1];
            w[idx] = arr[2];
            ne[idx] = he[arr[0]]; //用这行保留原来的 链表。这里 边 是从0编号开始的，所以 head数组初始要置-1，不能都是0。
            he[arr[0]] = idx; //再更新头结点。
            idx++;
        }

        int INF = Integer.MAX_VALUE / 2;
        int[] dist = new int[n + 1]; //放k到i的最小距离，i是各点。初始都置为 int上限除以2，然后 dist[k] 为0，k到自身为0。
        for (int i = 0; i <= n; i++) dist[i] = INF;
        dist[k] = 0;
        boolean[] vis = new boolean[n + 1]; //看这个顶点有没有更新过

        //优先队列。放数组[点编号，到k的距离]，到k的距离最小的在最前。
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        q.add(new int[]{k, 0});
        while (q.size() >= 1) {
            int[] arr = q.poll();
            if (vis[arr[0]]) continue; //更新过就跳过

            vis[arr[0]] = true;

            //通过k到i的最小 即dist[arr[0]]，更新i能够到的点end的 k到end的最小 即dist[end]。
            // dist[end] = Math.min(dist[end], dist[arr[0]] + w[idx]); //这边更小的要入队，所以得写成if
            for (idx = he[arr[0]]; idx != 0; idx = ne[idx]) {
                int end = e[idx]; //i能到的点end
                if (dist[end] > dist[arr[0]] + w[idx]) { //k到end 大于 (k到i + i到end)
                    dist[end] = dist[arr[0]] + w[idx];
                    q.add(new int[] {end, dist[end]});
                }
            }
        }

        int res = 1; //初始置为最小的1，因为题目不会给到k自身的，所以不会为0，然后最小的就是1了，然后下面循环找最大的。
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        return res == INF ? -1 : res; //遍历里 最大时间是INF的话要返回-1 说明不可达
    }

    //朴素迪杰斯克拉 + 邻接矩阵。 单源最短路径问题，即从给定起点到图中所有其他顶点的最短路径。O(n^2),n是顶点数。
    //743. 网络延迟时间。迪杰斯克拉 模板题。
    public int networkDelayTime1111111111111111111111111111111111111111111(int[][] times, int n, int k) {
        int w[][] = new int[n + 1][101];
        int INF = Integer.MAX_VALUE / 2;
        //点到自身是0，点到另个点是 int上限除以2，防止直达和中间一站中转 作比较时 中间一站中转相加导致超int
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 101; j++) {
                w[i][j] = (i == j ? 0 : INF);
            }
        }

        for (int[]arr : times) w[arr[0]][arr[1]] = arr[2];

        int[] dist = new int[n + 1]; //放k到i的最小距离，i是各点。初始都置为 int上限除以2，然后 dist[k] 为0，k到自身为0。
        for (int i = 0; i <= n; i++) dist[i] = INF;
        dist[k] = 0;
        boolean vis[] = new boolean[n + 1]; //看这个顶点有没有更新过

        for (int p = 1; p <= n; p++) { //内层for是关键的 且代码多，最好用i 不容易写错，外层只是为了执行n次 用p好了
            int min = -1; //遍历找 没更新过的最近的顶点。置为负一是为了防止所有点都被遍历过吗？
            for (int i = 1; i <= n; i++) {
                if (vis[i] == false && (min == -1 || dist[min] > dist[i])) min = i;
            }

            vis[min] = true;
            for (int i = 1; i <= n; i++) {
                dist[i] = Math.min(dist[i], dist[min] + w[min][i]);
            }
        }

        int res = 1; //初始置为最小的1，因为题目不会给到k自身的，所以不会为0，然后最小的就是1了，然后下面循环找最大的。
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        return res == INF ? -1 : res; //遍历里 最大时间是INF的话要返回-1 说明不可达
    }


    //JavaScript 只用fori循环，因为其他的js的for跟java不一样，会出问题。
    //JavaScript 遍历map要这样写
//    let map = new Map();
//    map.set('key1', 'value1');
//    map.set('key2', 'value2');
//    map.set('key3', 'value3');
//    for (let [key, value] of map.entries()) {
//        console.log(key + ': ' + value);
//    }

//    let set = new Set();
//    set.add('value1');
//    set.add('value2');
//    set.add('value3');
//
//    for (let value of set) {
//        console.log(value);
//    }

    //类似生成二叉树的算法题，递归套路是 递归求出左孩子 递归求出右孩子 然后合并返回

    //二叉树的题，做了几个都可以 从递归遍历的代码上改出来，所以先记录一下 二叉树的递归遍历的模板。
    //前序。中在前，就是中左右遍历。
    //递归：1.确定递归函数的参数和返回值。2.确定终止条件。3.确定单层递归的逻辑。
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }
    public void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }


    //102. 二叉树的层序遍历。
    //非递归的层序遍历。用了基于链表的队列。
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) deque.addLast(root);
        while (deque.size() >= 1) {
            int n = deque.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) { //把当前层的 都出队。
                TreeNode poll = deque.pollFirst();
                level.add(poll.val);
                if (poll.left != null) deque.addLast(poll.left);
                if (poll.right != null) deque.addLast(poll.right);
            }
            res.add(level);
        }
        return res;
    }

//    // //102. 二叉树的层序遍历。
//    // //递归法。进入一次递归，层数就加一。从 二叉树递归遍历 改的
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> list = new ArrayList<>();
//         int cnt = 0;
//         vis(root, list, cnt);
//         return list;
//     }
//     public void vis(TreeNode root, List<List<Integer>> list, int cnt) {
//         if (root == null) return;
//         if (list.size() == cnt) list.add(new ArrayList<>()); //list长度等于当前层数，那肯定不够，要再加一层。
//         list.get(cnt).add(root.val);
//
//         //传到下一层，层数要加一，但不能直接 ++，要写成 +1，因为++会改变 当前的层数，导致 left完了到right时 层数会错。
//         if (root.left != null) vis(root.left, list, cnt + 1);
//         if (root.right != null) vis(root.right, list, cnt + 1);
//     }

    //java的startWith底层好像不是字典树。

    //Z函数模板。灵神的。Z函数返回一个数组，数组里是每个位置跟原字符串的最长公共前缀长度。O(n)。
    static int[] zFunction(String a) {
        int n = a.length();
        char[] s = a.toCharArray();
        int[] z = new int[n];
        z[0] = n;
        int l = 0;
        int r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(z[i - l], r - i + 1);
            }
            while (i + z[i] < n && s[z[i]] == s[i + z[i]]) {
                l = i;
                r = i + z[i];
                z[i]++;
            }
        }
        return z;
    }


//    //Z函数模板。珂朵莉大佬的。Z函数返回一个数组，数组里是每个位置跟原字符串的最长公共前缀长度。O(n)。
//    static int[] zFunction(String a) {
//        char[] s = a.toCharArray();
//        int n = s.length;
//        int[] z = new int[n];
//        z[0] = n;
//        for (int i = 1, l = 0, r = 0; i < n; ++i) {
//            if (i <= r && z[i - l] < r - i + 1) {
//                z[i] = z[i - l];
//            } else {
//                z[i] = Math.max(0, r - i + 1);
//                while (i + z[i] < n && s[z[i]] == s[i + z[i]]) ++z[i];
//            }
//            if (i + z[i] - 1 > r) {
//                l = i;
//                r = i + z[i] - 1;
//            }
//        }
//        return z;
//    }

    //前缀和 求区间和是 O(1),单点更新是O(n),所以频繁单点更新会超时。
    // 给了前缀和 能干什么呢？
    // 1.单点修改 add(x, u)，查询前缀和 query(x)
    // 2.单点修改 add(x, u)，单点查询 query(x) - query(x - 1)
    // 3.单点修改 add(x, u)，区间查询 query(r) - query(l - 1)
    // 4.区间修改 add(l, d); add(r + 1, -d); 单点查询 a[x] + query(x)  a[x]是啥？这单点查询是不是应该跟上面的2一样？
    //树状数组 求区间和是 O(logn),单点更新是O(logn)。所以可以频繁单点更新。

    //307. 区域和检索 - 数组可修改。
    //树状数组模板
    // 上来先把三个方法写出来
//    int[] tree;
//    int n;
//    int[] arr;
//    int lowbit(int x) {
//        return x & -x;
//    }
//    // 查询前缀和的方法
//    int query(int x) {
//        int ans = 0;
//        for (int i = x; i > 0; i -= lowbit(i)) ans += tree[i];
//        return ans;
//    }
//    // 在树状数组 x 位置中增加值 u
//    void add(int x, int u) {
//        for (int i = x; i <= n; i += lowbit(i)) tree[i] += u;
//    }
//
//
//    // 初始化「树状数组」，要默认数组是从 1 开始
//    public void numArray(int[] nums) { //要用这个模板的话 这里要改成函数形式。多个树状数组的话 直接到力扣307的网页 抄那个类。
//    //public NumArray(int[] nums) {
//        n = nums.length;
//        arr = nums;
//        tree = new int[n + 1];
//        for (int i = 0; i < n; i++) add(i + 1, nums[i]);
//    }
//
//    // 原有的值是 nums[index]，要使得修改为 val，需要增加 val - nums[index]
//    public void update(int index, int val) {
//        add(index + 1, val - arr[index]);
//        arr[index] = val;
//    }
//
//    //树状数组 默认数组是从 1 开始。所以返回的区间是 [left+1, right+1]
//    public int sumRange(int left, int right) {
//        return query(right + 1) - query(left);
//    }

    //引用当key 放到map里 也能正常get到。参考力扣662. 二叉树最大宽度。把节点当key放到map里 也能get到。
    // 因为比较的是地址，同个地址还是能get到的。但如果是两个同样组成的数组，那就get不到了，因为是两不同的地址。
    //担心 对象是引用，不好当map的key 可以用 Pair 类。
    // Pair 类，getKey、getValue。对象是引用，不好当map的key，然而又要用value 记录信息，那就要用 Pair 类了。



    /*
        曼哈顿坐标系是通过切比雪夫坐标系旋转 45度 后，再缩小到原来的一半得到的。
            将一个点 (x,y) 的坐标变为 (x + y, x - y) 后，原坐标系中的曼哈顿距离 等于 新坐标系中的切比雪夫距离。
            将一个点 (x,y) 的坐标变为 ((x+y)/2, (x-y)/2) 后，原坐标系中的切比雪夫距离 等于 新坐标系中的曼哈顿距离。
        曼哈顿距离 = |x1 - x2| + |y1 - y2|
        切比雪夫距离 = max(|x1 - x2|, |y1 - y2|)
        碰到求 切比雪夫距离 或 曼哈顿距离的题目时，我们往往可以相互转化来求解。两种距离在不同的题目中有不同的优缺点，应该灵活运用。
        原曼哈顿距离 = |x1 - x2| + |y1 - y2| 转化成 新坐标系中的切比雪夫距离 = max(|x1+y1 - (x2+y2)|, |x1-y1 - (x2-y2)|)
     */


    //并查集，把连通的点 归为同一个祖宗。
    // 通过数组来记录，下标是该点的编号，元素值是该点的祖宗。

    //题目的函数里 要放这些。
    //p放该编号的祖宗，初始祖宗默认为自身。
//    int[] p = new int[n];
//    for (int i = 0; i < n; i++) p[i] = i;

//    //先求出两个的祖宗的编号
//    int rootX = find(X, p);
//    int rootY = find(Y, p);
//
//    //如果祖宗相同，说明本来就在一块区域里。如果这种情况要处理，那要去掉注释写。
//    //if (rootX == rootY) {}
//
//    //把祖宗编号大的 合并到 祖宗编号小的上。
//    // 即把 对应祖宗更新为 编号小的祖宗。赋值的等号的右边是 编号小的祖宗。
//    if (rootX > rootY) p[rootX] = rootY;
//    if (rootX < rootY) p[rootY] = rootX;


    //并查集核心函数。用来找当前祖宗，并把过程中 一路上的点的祖宗 更新为最后找到的祖宗。
//    public static int find(int x, int[]p) {
//        if (x != p[x])
//            p[x] = find(p[x], p);
//
//        return p[x];
//    }



    //向量法 往各方向走的少代码量写法。 上下左右。
//    int[] x = new int[]{0, 0, -1, 1};
//    int[] y = new int[]{-1, 1, 0, 0};
//    for (int k = 0; k < 4; k++) {
//        //两下标 合法，不越界。
//        int iAdd = i + x[k];
//        int jAdd = j + y[k];
//        if (0 <= iAdd && iAdd < m && 0 <= jAdd && jAdd < n) {
//
//        }
//    }

//    //向量法 往各方向走的少代码量写法。 8个方向 米字。东，东南，南，西南，西，西北，北，东北
//    int[] x = new int[]{1, 1, 0, -1, -1, -1,  0,  1};
//    int[] y = new int[]{0, 1, 1, 1,   0, -1, -1, -1};
//    for (int k = 0; k < 8; k++) {
//        int iAdd = i + y[k]; //行变换是要加y的
//        int jAdd = j + x[k]; //列变换是要加x的
//        while (0 <= iAdd && iAdd < m && 0 <= jAdd && jAdd < n) {
//
//            //向量法 遍历向量数组时 累加元素值，方向不变，但能沿着方向走更远。
//            iAdd += y[k];
//            jAdd += x[k];
//        }
//    }

    //Python的 @cache 不能接收 可变对象。比如 列表list、字典dict(是java中的map)、集合set，因为他们是可变对象。
    //Python中，数值类型(int和float)、字符串str、元组tuple都是不可变对象。
    //Python 递归函数写在函数内部 是最佳实践，可以共享主函数里的东西。
    //听说 列表之类的@cache可以考虑用frozenlist frozenset

}
