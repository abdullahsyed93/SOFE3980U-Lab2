package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should contain only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0";
			return;
		}
	
		// Validate the binary string (only '0' or '1' allowed)
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0";
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
	
		// If all digits are '0'
		this.number = (beg == number.length()) ? "0" : number.substring(beg);
	
		if (this.number.isEmpty()) {
			this.number = "0";
		}
	}
	
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	
	/**
	* Adding two binary variables.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		int carry=0;
		String num3="";
		
		while(ind1>=0 ||  ind2>=0 || carry!=0)
		{
			int sum=carry;
			if(ind1>=0){
				sum += (num1.number.charAt(ind1)=='1')? 1:0;
				ind1--;
			}
			if(ind2>=0){
				sum += (num2.number.charAt(ind2)=='1')? 1:0;
				ind2--;
			}
			carry=sum/2;
			sum=sum%2;
			num3 =( (sum==0)? "0":"1")+num3;
		}
		return new Binary(num3);
	}

	/**
	* Bitwise AND operation
	*/
	public static Binary and(Binary num1, Binary num2)
	{
		String n1 = num1.getValue();
		String n2 = num2.getValue();

		int maxLen = Math.max(n1.length(), n2.length());
		n1 = String.format("%" + maxLen + "s", n1).replace(' ', '0');
		n2 = String.format("%" + maxLen + "s", n2).replace(' ', '0');

		String result = "";

		for(int i = 0; i < maxLen; i++) {
			if(n1.charAt(i) == '1' && n2.charAt(i) == '1')
				result += "1";
			else
				result += "0";
		}

		return new Binary(result);
	}

	/**
	* Bitwise OR operation
	*/
	public static Binary or(Binary num1, Binary num2)
	{
		String n1 = num1.getValue();
		String n2 = num2.getValue();

		int maxLen = Math.max(n1.length(), n2.length());
		n1 = String.format("%" + maxLen + "s", n1).replace(' ', '0');
		n2 = String.format("%" + maxLen + "s", n2).replace(' ', '0');

		String result = "";

		for(int i = 0; i < maxLen; i++) {
			if(n1.charAt(i) == '1' || n2.charAt(i) == '1')
				result += "1";
			else
				result += "0";
		}

		return new Binary(result);
	}

	/**
	* Multiplication of two binary variables
	*/
	public static Binary multiply(Binary num1, Binary num2)
	{
		Binary result = new Binary("0");
		String n2 = num2.getValue();
		int shift = 0;

		for(int i = n2.length() - 1; i >= 0; i--) {
			if(n2.charAt(i) == '1') {
				String shifted = num1.getValue();
				for(int j = 0; j < shift; j++) {
					shifted += "0";
				}
				result = add(result, new Binary(shifted));
			}
			shift++;
		}

		return result;
	}
}