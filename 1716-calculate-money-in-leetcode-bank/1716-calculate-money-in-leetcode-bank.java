class Solution {
    public int totalMoney(int n) {

        int total = 0;
        int monday = 1;

        while(n > 0){

            for(int day = 0; day < 7 && n > 0; day++){

                total += monday + day;
                n--;
            }

            monday++;
        }

        return total;
    }
}