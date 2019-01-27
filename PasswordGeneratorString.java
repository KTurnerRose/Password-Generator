import java.util.Random;

public class PasswordGeneratorString {
/*Specifications:
1.	The password must be 8 to 12 characters. The password should have an equal probability of being any length within the acceptable range of lengths. 
2.	The first character must be alphabetic (upper or lower case). Each of the 52 possible characters should have an equal probability of being selected.
3.	All other characters may be alphanumeric. Each of the 62 possible characters should have an equal probability of being selected.
4.	The password must contain:
•	at least one upper case letter
•	at least one lower case letter
•	at least one numeric
5.	At a randomly selected internal position (not the first or last character), the password must include one of the following:
a.	"_" (underscore) 31
b.	"-" (hyphen) 45
c.	"$" 36
d.	"%" 37
e.	"#" 35
f.	"@" 64
There should be an equal probability of selecting any of these six characters. Only one character in the password should be non-alphanumeric.
6.	In a test file, generate 1,000 passwords.
Extra Credit:
Store all generated passwords in a text file in your project.
The text file name should be named storedPasswords.txt
Before accepting a password, the program needs to check that the password has not been previously generated. Therefore the password should not in the text file of previously generated passwords.

Hint:	Read all the passwords from storedPasswords.txt into an ArrayList<String> instance variable.

ASCII:
A = 65
Z = 90
a = 97
z = 122
*
*
*/
	//randomly generating based on askii code!!
	//make int array ofthe askii values, then have function which converts each value into its char
	int length = generateLength();
	int[] passwordAscii = new int[length];//makes ascii array of random size
	makePassword(passwordAscii);
	public int generateLength()
	{
		Random generator = new Random();
		int length = generator.nextInt(12) + 8;
		return length;
	}
	public int[] makePassword(int[] asciiArray)
	{
		asciiArray.length = passwordAscii.length;
		firstChar(asciiArray); //entering first digit into asciiArray
		while(spacesEmpty(asciiArray) != 0)
		{
			if(!containsUpperCase(asciiArray))
				enterUpperCase(asciiArray); //PROBLEM: that method enters the value in another place in the array, and returns that array placement (not int, int[])
		
			if(!containsLowerCase(asciiArray))
				enterLowerCase(asciiArray);
		
			if(!containsNumeric(asciiArray))
				enterNumeric(asciiArray);
		
			if(!containsSymbol(asciiArray))
				enterSymbol(asciiArray);
		}
		
	}
	public int firstChar(int[] array)
	{
		Random generator = new Random();
		array[1] = generator.nextInt(122) + 65; //inserts appropriate first digit of password
	}
	public boolean containsUpperCase(int[] array)
	{
		for (int i = 0; i < array.length - 1; i++)
		{
			if(65 <= array[i] <= 90)
			{
				return true;
			}
		}
		return false;
	}
	public int[] enterUpperCase(int[] array)
	{
		for (int i = (int)(Math.random() * spacesEmpty(array) + 1); i > 0; i--)
		{
			//generate the number of spaces to enter in lower case numerics:
			int numSpaces = (int)(Math.random()* spacesEmpty(array)) + 1;
			//generate random lower case numeric:
			int randomLowerCase = (int)(Math.random()* 90) + 65;
			//add each random lower case to the random space
			if (!isSpaceFilled(numSpaces))
				array[numSpaces] = randomLowerCase;
		}
		return array;
	}
	public boolean containsLowerCase(int[] array)
	{
		for (int i = 0; i < array.length - 1; i++)
		{
			if(97 <= array[i] <= 122)
			{
				return true;
			}
		}
		return false;
	}
	public int[] enterLowerCase(int[] array)
	{
		for (int i = (int)(Math.random() * spacesEmpty(array) + 1); i > 0; i--)
		{
			//generate the number of spaces to enter in lower case numerics:
			int numSpaces = (int)(Math.random()* spacesEmpty(array)) + 1;
			//generate random lower case numeric:
			int randomLowerCase = (int)(Math.random()* 122) + 97;
			//add each random lower case to the random space
			if (!isSpaceFilled(numSpaces))
				array[numSpaces] = randomLowerCase;
		}
		return array;
	}
	public boolean containsNumeric(int[] array)
	{
		for (int i = 0; i < array.length - 1; i++)
		{
			if(48 <= array[i] <= 57)
			{
				return true;
			}
			
		}
		return false;
	}
	public int[] enterNumeric(int[] array)
	{
		for (int i = (int)(Math.random() * spacesEmpty(array) + 1); i > 0; i--)
		{
			//generate the number of spaces to enter in lower case numerics:
			int numSpaces = (int)(Math.random()* spacesEmpty(array)) + 1;
			//generate random lower case numeric:
			int randomNumeric = (int)(Math.random()* 48) + 57;
			//add each random lower case to the random space
			if (!isSpaceFilled(numSpaces))
				array[numSpaces] = randomNumeric;
		}
		return array;
	}
	public boolean containsSymbol(int[] array)
	{
		for (int i = 0; i < array.length - 1; i++)
		{
			if(array[i] == 31 || array[i] == 35 || array[i] == 36 || array[i] == 37 || array[i] == 45 || array[i] == 64)
			{
				return true;
			}
		}
		return false;
	}
	public int[] enterSymbol(int[] array)
	{
		int[] symbolArray = {31,35,36,37,45,64};
		for (int i = (int)(Math.random() * spacesEmpty(array) + 1); i > 0; i--)
		{
			//generate the number of spaces to enter in lower case numerics:
			int numSpaces = (int)(Math.random()* spacesEmpty(array)) + 1;
			//generate random lower case numeric:
			int randomNumeric = (int)(Math.random()* 48) + 57;
			//add each random lower case to the random space
			if (!isSpaceFilled(numSpaces))
				array[numSpaces] = randomNumeric;
		}
		return array;
	}
	public int spacesEmpty (int[] pwArray)
	{
		//returns number of empty spaces left
	}
	public boolean isSpaceFilled(int arrayIdx)
	{
		//determines if a specific space is filled or not
	}
	public int insertSymbol(int[] asciiArray)
	{
		//can't be first or last digit!!! random digit in pw that's not filled yet
		
	}
}
