import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * 
 * @author Diana Zaray Corado #191025
 * @version 11/2/2020
 *
 */
public class File {
	
	int number = 0;
	ArrayList<Integer> numbers = new ArrayList<Integer>();
	
	public ArrayList<Integer> randomNumbers() {
		
		for(int a = 0; a < 3000; a++) {
			number = (int)(Math.random()*3000);	
			numbers.add(number);}
		//System.out.println(numbers);
		
		return numbers;
	}
	
	public void saveNumbers() {
		try (
				FileOutputStream direccion = new FileOutputStream("Numeros.txt");
				ObjectOutputStream escritor = new ObjectOutputStream(direccion);
				)
			{
			for (int a = 0; a < numbers.size(); a++ ) {
					escritor.writeObject(numbers.get(a));
				}
			escritor.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}

}
