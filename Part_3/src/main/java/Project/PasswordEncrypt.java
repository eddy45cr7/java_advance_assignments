package Project;

import java.util.List;
import java.util.ArrayList;

public class PasswordEncrypt {
	public static String encryptor(String pass) {
		char[] chars = pass.toCharArray();
		int i,t;
		String tc;
		List<Integer> ascarr = new ArrayList<>();
		String encpass = "";
		
		for(int c=0;c<chars.length;c++) {
			i = (int) chars[c];
			ascarr.add(i);
		}
		
		for(int j=0;j<ascarr.size();j++) {
			t = ascarr.get(j)+2;
			ascarr.remove(j);
			ascarr.add(j,t);
		}
		
		for(int k=0;k<ascarr.size();k++) {
			tc = Character.toString(ascarr.get(k));
			encpass += tc;
		}
		
		return encpass;
	}
	
	public static void main(String[] args) {
		String str = "password";
		System.out.println(encryptor(encryptor(str)));
	}
	
}