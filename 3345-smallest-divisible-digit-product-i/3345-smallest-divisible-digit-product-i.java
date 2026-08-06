class Solution {
    private int digitProduct(int x) {
        int product = 1;
        while (x > 0) {
            int d = x % 10;
            if (d == 0) return 0;
            product *= d;
            x /= 10;
        }
        return product;
    }

    public int smallestNumber(int n, int t) {
        int num = n;
        while (true) {
            int product = digitProduct(num);
            if (product % t == 0) {
                return num;
            }
            num++;
        }
    }
}
