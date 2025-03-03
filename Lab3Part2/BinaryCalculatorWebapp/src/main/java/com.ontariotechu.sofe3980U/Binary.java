public class Binary
{
    private String number = "0";  // string containing the binary value '0' or '1'

    /**
     * A constructor that generates a binary object.
     * 
     * @param number a String of the binary values. It should contain only zeros or ones with any length and order. 
     *               Otherwise, the value of "0" will be stored. Trailing zeros will be excluded, and an empty string will be considered as zero.
     */
    public Binary(String number) {
        if (number == null || number.isEmpty()) {
            this.number = "0"; // Default to "0" for null or empty input
            return;
        }

        // Validate the binary string (only '0' or '1' allowed)
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch != '0' && ch != '1') {
                this.number = "0"; // Default to "0" for invalid input
                return;
            }
        }

        // Remove leading zeros
        int beg;
        for (beg = 0; beg < number.length(); beg++) {
            if (number.charAt(beg) != '0') {
                break;
            }
        }

        this.number = (beg == number.length()) ? "0" : number.substring(beg);

        // Ensure empty strings are replaced with "0"
        if (this.number.isEmpty()) {
            this.number = "0";
        }
    }

    /**
     * Return the binary value of the variable
     * 
     * @return the binary value in a string format.
     */
    public String getValue() {
        return this.number;
    }

    /**
     * Adding two binary variables.
     * 
     * @param num1 The first addend object
     * @param num2 The second addend object
     * @return A binary variable with a value of <i>num1 + num2</i>.
     */
    public static Binary add(Binary num1, Binary num2) {
        int ind1 = num1.number.length() - 1;
        int ind2 = num2.number.length() - 1;
        int carry = 0;
        String num3 = "";

        while (ind1 >= 0 || ind2 >= 0 || carry != 0) {
            int sum = carry;
            if (ind1 >= 0) {
                sum += (num1.number.charAt(ind1) == '1') ? 1 : 0;
                ind1--;
            }
            if (ind2 >= 0) {
                sum += (num2.number.charAt(ind2) == '1') ? 1 : 0;
                ind2--;
            }
            carry = sum / 2;
            sum = sum % 2;
            num3 = (sum == 0 ? "0" : "1") + num3;
        }
        return new Binary(num3);
    }

    // New operators

    /**
     * Multiplying two binary variables.
     * 
     * @param num1 The first multiplicand object
     * @param num2 The second multiplicand object
     * @return A binary variable with a value of <i>num1 * num2</i>.
     */
    public static Binary multiply(Binary num1, Binary num2) {
        int n1 = Integer.parseInt(num1.number, 2);
        int n2 = Integer.parseInt(num2.number, 2);
        int result = n1 * n2;
        return new Binary(Integer.toBinaryString(result));
    }

    /**
     * Performing bitwise AND between two binary variables.
     * 
     * @param num1 The first operand object
     * @param num2 The second operand object
     * @return A binary variable with the result of <i>num1 & num2</i>.
     */
    public static Binary bitwiseAnd(Binary num1, Binary num2) {
        int n1 = Integer.parseInt(num1.number, 2);
        int n2 = Integer.parseInt(num2.number, 2);
        int result = n1 & n2;
        return new Binary(Integer.toBinaryString(result));
    }

    /**
     * Performing bitwise OR between two binary variables.
     * 
     * @param num1 The first operand object
     * @param num2 The second operand object
     * @return A binary variable with the result of <i>num1 | num2</i>.
     */
    public static Binary bitwiseOr(Binary num1, Binary num2) {
        int n1 = Integer.parseInt(num1.number, 2);
        int n2 = Integer.parseInt(num2.number, 2);
        int result = n1 | n2;
        return new Binary(Integer.toBinaryString(result));
    }
}
