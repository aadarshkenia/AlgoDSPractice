class _50 {
    public static void main(String args[]) {
        
    }

    public double myPow(double x, int n) {
        if(n == 0)
            return 1.0;
        int multiplier = x < 0 ? (n%2 == 0 ? 1 : -1) : 1; 
        double ans = findPower(x, Math.abs(n));
        if(n > 0)
            return ans*(double)multiplier;
        else
            return 1.0/(ans*(double)multiplier);
    }
    
    public double findPower(double x, int n){
        if(n==1)
            return x;
        double temp = findPower(x, n/2); 
        return n%2 == 0 ? temp*temp : temp*temp*x;
    }
}
    