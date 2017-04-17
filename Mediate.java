import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang3.text.WordUtils;

public class Mediate {
	public static void main(String[] args) throws IOException{
		//IMDB, Rotton Tomatoes (users, critics), Metacritic, flixster
		//DISP: title, poster, date, 
		
		Scanner in=new Scanner(System.in); 
		String input_title, movie_title, year, rating, runtime, director, plot, box_office;
		int rotton_tomatoes, metascore, imdb;
		double avg;
		
		String[] info;
		while (true) {
			try{
				System.out.println("Enter a movie: ");
				input_title = in.nextLine().toLowerCase();
				
				URL url = new URL("http://www.omdbapi.com/?t="+input_title.replaceAll(" ", "+"));
				URLConnection con = url.openConnection();
				BufferedReader input = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
				String omdb_text = input.readLine();
		        info = omdb_text.split(",");
		        
				movie_title = parse(info[0]);
				year = parse(info[1]);
				rating = parse(info[2]);
				runtime = parse(info[4]);
				director = parse(omdb_text.split(",\"Director\"|,\"Writer\"")[1]);
				plot = parse(omdb_text.split(",\"Plot\"|,\"Language\"")[1]);
				box_office = parse(omdb_text.split(",\"BoxOffice\"|,\"Production\"")[1]);
				
				rotton_tomatoes = Integer.parseInt(parse(omdb_text.split("Rotten Tomatoes\",\"Value\"|\"\\},\\{\"Source\":\"Metacritic")[1]));
				metascore = Integer.parseInt(parse(omdb_text.split(",\"Metascore\"|,\"imdbRating")[1]));
				imdb = (int) (Double.parseDouble(parse(omdb_text.split(",\"imdbRating\"|,\"imdbVotes")[1]))*10);
				avg = (rotton_tomatoes+metascore+imdb)/3.0;
				
				System.out.println("\n\n"+movie_title+" // "+year+" // "+rating+" // "+runtime+" // "+director);
				System.out.printf("Score: %2.1f", avg);
			
			}catch(Exception e){
				System.out.println("\n\nINCORRECT INPUT: "+e.toString()+"\n\n");
				e.printStackTrace();
				continue;
			}
			

			System.out.println("\n");
			//Continue on keyclick
			System.in.read();
		}
		
	}
	
	public static String parse(String element){
		return element.split(":")[1].substring(1, element.split(":")[1].length()-1);
	}
}
