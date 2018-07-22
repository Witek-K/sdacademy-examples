import java.util.ArrayList;
import java.util.List;


/* Reprezentuje rycerza
 */
class Knight{

	private String name;
	private int age;

	public Knight(int age, String name){

		this.name = name;
		this.age = age;

	}

	public int getAge(){

		return this.age;

	}

	public String getName(){

		return this.name;

	}


}
/* Interfejs validatora
 */
interface KnightValidator{

	boolean validate(Knight knight);

}

/* Przyjmuje tylko rycerzy w wieku ponad 60 lat
 */
class OldKnightsValidator implements KnightValidator{

	public boolean validate(Knight knight){

		return knight.getAge()>60;
	}

}

/* Przyjmuje tylko rycerzy o imionach brzmiących męsko
 * (pomijamy Barnabę itp.)
 */
class MaleKnightsValidator implements KnightValidator{

	public boolean validate(Knight knight){
		String name = knight.getName();
		return name.charAt(name.length()-1)!='a';
	}

}

/* Reprezentuje arenę
 */
class Arena{

	private List<Knight> knights;
	private KnightValidator validator;

	public Arena(KnightValidator validator){

		this.validator = validator;

		knights =  new ArrayList<Knight>();

	}

	public void addKnight(Knight knight){

		if(validator.validate(knight))
			knights.add(knight);

	}

	public String toString(){
		String out ="";
		for(Knight knight : knights)
			out += "Rycerz " +  knight.getName() + "\n";

		return out;

	}
}

public class StrategiaTest {


	public static void main(String[] args) {

		Knight anna = new Knight(20, "Anna");
		Knight zbyszko = new Knight(40, "Zbyszko");
		Knight dobromil = new Knight(70, "Dobromil");

		KnightValidator oldValid = new OldKnightsValidator();
		KnightValidator nameValid = new MaleKnightsValidator();

		Arena eldersArena = new Arena(oldValid);
		Arena malesArena = new Arena(nameValid);

		eldersArena.addKnight(anna);
		eldersArena.addKnight(zbyszko);
		eldersArena.addKnight(dobromil);

		malesArena.addKnight(anna);
		malesArena.addKnight(zbyszko);
		malesArena.addKnight(dobromil);

		System.out.println("=== Arena seniorow ===");
		System.out.println(eldersArena);

		System.out.println("=== Arena bez rownoupranienia ===");
		System.out.println(malesArena);


	}

}