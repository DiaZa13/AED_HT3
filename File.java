import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Diana Zaray Corado #191025
 * @author Adaptado de: Lectura_y_Escritura_de_Ficheros_en_Java, extraido de: http://chuwiki.chuidiang.org/index.php?
 * @version 11/2/2020
 *
 */
public class File {
	
	int number = 0;
	String linea, cadLista = " ";
	Integer[] numbers = new Integer[3000];

	public void messyNumbers()
	{
		for(int a = 0; a < 3000 ; a++) {
			number = (int)(Math.random()*3000+1);
			numbers[a] = number;}

		FileWriter fichero = null;
		PrintWriter pw = null;
		try
		{
			fichero = new FileWriter("Numeros.txt");
			pw = new PrintWriter(fichero);

			for (int i = 0; i < 3000; i++)
				pw.print(numbers[i]+ " ");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void orderNumbers()
	{
		for(int a = 0; a < 3000 ; a++) {
			numbers[a] = a;}

		FileWriter fichero = null;
		PrintWriter pw = null;
		try
		{
			fichero = new FileWriter("NumerosOrdenados.txt");
			pw = new PrintWriter(fichero);

			for (int i = 0; i < 3000; i++)
				pw.print(numbers[i]+ " ");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

    public String readFile(){
	File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;

		try {
        // Apertura del fichero y creacion de BufferedReader para poder
        // hacer una lectura comoda (disponer del metodo readLine()).
        //archivo = new File ("Numeros.txt");
        fr = new FileReader ("Numeros.txt");
        br = new BufferedReader(fr);

        // Lectura del fichero
        System.out.println("Leyendo el contendio del archivo.txt");

        while((linea = br.readLine())!=null)
            cadLista= linea;

        //System.out.println(linea);
        //cadLista = linea.split(" ");
    }
		catch(Exception e){
        e.printStackTrace();
    }finally{
        // En el finally cerramos el fichero, para asegurarnos
        // que se cierra tanto si todo va bien como si salta
        // una excepcion.
        try{
            if( null != fr ){
                fr.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

		}
		return cadLista;
	}
}
