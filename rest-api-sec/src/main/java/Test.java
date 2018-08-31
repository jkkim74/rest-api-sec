import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String encodedPassword = new BCryptPasswordEncoder().encode("abcd");
		 System.out.println(encodedPassword);
	}

}
