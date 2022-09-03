public class B {

    // Function to calculate Bitwise
    // XOR of odd numbers in the range [1, N]
    static int findXOR(int n)
    {

        // N & 3 is equivalent to n % 4
        switch (n & 3)
        {

            // If n is multiple of 4
            case 0:
                return n;

            // If n % 4 gives remainder 1
            case 1:
                return 1;

            // If n % 4 gives remainder 2
            case 2:
                return n + 1;
        }
        // If n % 4 gives remainder 3
        return 0;

    }

    // Function to find the XOR of odd
    // numbers less than or equal to N
    static void findOddXOR(int n)
    {

        // If number is even
        if (n % 2 == 0)

            // Print the answer
            System.out.println(((findXOR(n))
                    ^ (2 * findXOR(n / 2))));

            // If number is odd
        else

            // Print the answer
            System.out.println(((findXOR(n))
                    ^ (2 * findXOR((n - 1) / 2))));
    }

    public static void main(String[] args) {
        int N = 8;

        // Function Call
        findOddXOR(N);
    }
}
