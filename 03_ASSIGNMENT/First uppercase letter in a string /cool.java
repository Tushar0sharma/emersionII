class GFG {
	
	static char first(String str, int i)
	{
		if(str.charAt(i)=='\0'){
			return 0;
		}
		if(Character.isUpperCase(str.charAt(i))) {
			return str.charAt(i);
		}
		try {
			return first(str, i + 1);
		}
		catch(Exception e){
			System.out.println("Exception occurs");
		}
		return 0;
	}
	public static void main(String args[])
	{
		String str = "geeksforGeeKS";
		char res = first(str,0);
		if (res == 0)
			System.out.println("No uppercase letter");
		else
			System.out.println (res );
	}
}


