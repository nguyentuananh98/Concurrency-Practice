package algorithm;

public class EqualArray {public static void main(String args[]) {
    int[] num1 = new int[]{2,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int[] num2 = new int[]{1,4,0,0,0,0};
    System.out.println(calculateMinimumSum(num1, num2));
}

    public static int calculateMinimumSum(int[] num1, int[] num2) {

        Restriction restriction1 = calculateRestriction(num1);
        Restriction restriction2 = calculateRestriction(num2);
        if (restriction1.getMax() < restriction2.getMin() || restriction2.getMax() < restriction1.getMin()) {
            return -1;
        }
        return Math.max(restriction1.getMin(), restriction2.getMin());
    }

    public static Restriction calculateRestriction(int[] data) {
        int max = 0, min = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) {
                min += 1;
                max = Integer.MAX_VALUE;
            } else {
                min += data[i];
            }
        }
        return new Restriction(min, max == Integer.MAX_VALUE ? max : min);
    }

    private static class Restriction {
        int min;
        int max;

        public Restriction(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

}
