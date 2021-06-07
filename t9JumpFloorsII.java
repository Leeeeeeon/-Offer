/**
 * Created by z47 on 2021/6/4.
 */
public class t9JumpFloorsII {
    public int jumpFloor(int target) {
        if(target<0){return 0;}
        if(target==0){return 0;}
        if(target==1){return 1;}
        if(target==2){return 2;}
        int sum = 1;
        for (int i = target; i >0 ; i--) {
            sum+=jumpFloor(target-i);
        }
        return sum;
    }

    public int jumpFloorII(int target) {
        if (target <= 0) return 0;
        else if (target == 1) return 1;
            /*
             * f(1) = 1，f(2) = f(2-1) + f(2-2)，其中f(2-2) 表示2阶一次跳2阶的次数。
             * n = 3时，会有三种跳得方式，1阶、2阶、3阶，
             * 那么若第一次跳出1阶后面剩下：f(3-1);若第一次跳出2阶，剩下f(3-2)；若第一次3阶，那么剩下f(3-3)，
             * 则f(3) = f(3-1) + f(3-2) + f(3-3)，因此f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-(n-1)) + f(n-n)。
             * 这里的f(n)代表的是n个台阶有一次1,2,...n阶的跳法数，跳1级，剩下n-1级，则剩下跳法是f(n-1)，跳2级，剩下n-2级，则剩下跳法是f(n-2)。
             * 继续简化可以得到，f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-1)。
             * 因为f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)，
             * 所以f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)，得到 f(n) = 2*f(n-1)。
             * */
        else return 2 * jumpFloorII(target - 1);
    }
}
