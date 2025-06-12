package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(lowMark(new int[]{1, 2, 3, 40, 50, 60}, 150)));
        List<List<Integer>> moves = new ArrayList<>();
        moves.add(Arrays.asList(1));
        moves.add(Arrays.asList(1, 2));
        moves.add(Arrays.asList(1, 2, 3));
        moves.add(Arrays.asList(1, 2));
        moves.add(Arrays.asList(1, 2, 3));
        moves.add(Arrays.asList(1, 2));
        moves.add(Arrays.asList(1, 2, 3));
        moves.add(Arrays.asList(1, 2));
        moves.add(Arrays.asList(1, 2, 3));
        moves.add(Arrays.asList(1, 2));
        ex02(moves);
    }
    /* 1  2  3  4  5  6  7
       LL             LR RR
   1 + 6 + 7 < T
   yes
   LL -->>> + 1
   no
   LR <<-- -1
   когда я дойду до LL = LR + 1
   то начнем сдвигать RR
   пока LL != RR + 2

   так хорошо
   это случай оценки сверху да

   а если мне нужно оценить снизу
   1  2  3  4  5  6  7
   LL LR RR
   1 + 2 + 3 < t
   то я увеличу LR ->>= + 1
   RR = nums.length -> LR + 1
   AAAA нет зачем я же просто буду сдивгать ll
   ну кстати второй случай это не снизу оценка так просто типо быстрее будет если t ьаленькое
   нет наоборот первый случай дает нижнюю оценку

   так а как сделать сверху
 */

    /**
     * Дан массив из n элементов и число t. Найти три различных числа из массива,
     * которые в сумме ближе всего к t. Гарантируется, что такая тройка единственна. Сложность линейная.
     * @param nums
     */
    public static int[] lowMark(int[] nums, int t){
        Arrays.sort(nums);
        int ll = 0;
        int lr = nums.length - 2;
        int rr = nums.length - 1;
        //int lowMark = 1000000;
        int[] resel = new int[3];
        int lastSum = 10000000;

        while (ll <= lr && lr <= rr ){
            int sum = nums[ll] + nums[lr] + nums[rr];
            if (Math.abs(sum - t )< Math.abs(lastSum - t)){
                lastSum = sum;
                //System.out.println(nums[ll] + " " + nums[lr] + " " + nums[rr] + " " + ll + " " + lr + " " + rr);
                resel[0] = nums[ll];
                resel[1] = nums[lr];
                resel[2] = nums[rr];
            }
            if (sum > t && lr != ll + 1){
                lr--;

            } else if (sum > t && rr != ll + 2){
                rr--;

            } else{
                ll++;
                lr = nums.length - 2;
                rr = nums.length - 1;
            }
        }
        //System.out.println(lowMark);
        return resel;
    }
    /**
     * В наличии имеется n палочек. Играют двое. Делают ходы по очереди.
     * Для каждого числа палочек известно, сколько палочек можно
     * в этом случае взять. Данные задаются списком
     * ai,1,..., ai, ki это означает, что если на столе i палочек,
     * то тогда можно взять только один из указанных вариантов. кого нет возможности сходить,
     * тот проиграл. Нужно определить какой из двух
     * игроков выиграет в случае если оба игрока будут играть оптимальным образом.
     * Сложность O(k1+...+kn)
     */
    public static void ex02(List<List<Integer>> list){
        int n = list.size();
        boolean[] w = new boolean[n + 1];//сюда короче кидаем true или false в зависимости от выйгрышной позиции
        w[0] = false; //очев проиграем
        for(int i = 1; i <= n; i++){
            boolean win = false;//ну типа если не выполнится условие дальше которрые будут они определяют выиграшуную позицию
            for(Integer step: list.get(i - 1)){
                if(i - step >= 0 && !w[i - step]){
                    win = true;
                }
            }
            w[i] = win;
        }
        System.out.println(w[n] ? "1" : "2");


        for (int i = 0; i <= n; i++) {
            System.out.println(i + " палочек: " + (w[i] ? "Выигрышная" : "Проигрышная"));
        }
    }
}