package turdle;
import java.util.Scanner;
import java.util.Random;


public class Turdle {


	static String[] Words = {"apple", "beach", "chair", "dream", "eager", "fable", "glide", "happy", "jolly", "kitty",
            "lemon", "music", "novel", "ocean", "pizza", "queen", "rover", "silly", "tulip", "umbra",
            "vixen", "water", "xenon", "yacht", "zebra", "bliss", "candy", "daisy", "fairy", "grape",
            "happy", "image", "juicy", "kings", "lucky", "mango", "navel", "olive", "peach", "quilt",
            "river", "satin", "tease", "uncle", "vocal", "whirl", "xerox", "young", "zesty", "bloom",
            "charm", "donut", "enjoy", "flute", "giant", "hatch", "igloo", "joust", "kudos", "lunar",
            "magic", "novel", "onion", "piano", "quiet", "rodeo", "sable", "thyme", "uncut", "valve",
            "wedge", "xylem", "yummy", "zebra", "blaze", "coast", "drape", "eagle", "flair", "graze",
            "hazel", "igloo", "jolly", "knock", "lemon", "melon", "nurse", "olive", "prize", "quilt",
            "risky", "shark", "tiger", "uncle", "voice", "waste", "xenon", "youth", "zebra", "poles",
            "river", "angel", "happy", "trees", "rices", "rotis", "buggu"};



	void ui(char[] Word) {
		
		System.out.println("Y O U R   G U E S S");
		System.out.println(""
				+ "╔═════════════════╗\r\n"
				+ "║                 ║\r\n"
				+ "║    "+Word[0]+" "+Word[1]+" "+Word[2]+" "+Word[3]+" "+Word[4]+ "    ║ \r\n"
				+ "║                 ║\r\n"
				+ "╚═════════════════╝");
	}


	char[] correctWordChooser() {
		Random rand = new Random();
		int randomIndex = rand.nextInt(Words.length);
		String randomWord = Words[randomIndex];

		char[] correctWordCharacters = new char[5];
		for(int i = 0; i<5; i++) {
			correctWordCharacters[i] = randomWord.charAt(i);
		}
		return correctWordCharacters;
	}	


	char[] enteredWord() {
		Scanner input = new Scanner(System.in);
		//string input
		String str = input.nextLine();
		char[] enteredWordCharacters = new char[5];
		for(int i = 0; i < 5 ; i++) {
			enteredWordCharacters[i] = str.charAt(i);
		}
		return enteredWordCharacters;
	}


	void guessChecker(char[] correctWord, char[] enteredWord) {
		int count = 0;
		for(int k = 0 ; k<5; k++) {
			if(correctWord[k] == enteredWord[k]) {
				count++;
			}
		}
		if(count==5) {
			System.out.println(""
					+ ""
					+ "██╗   ██╗ ██████╗ ██╗   ██╗    ██╗    ██╗██╗███╗   ██╗\r\n"
					+ "╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║    ██║██║████╗  ██║\r\n"
					+ " ╚████╔╝ ██║   ██║██║   ██║    ██║ █╗ ██║██║██╔██╗ ██║\r\n"
					+ "  ╚██╔╝  ██║   ██║██║   ██║    ██║███╗██║██║██║╚██╗██║\r\n"
					+ "   ██║   ╚██████╔╝╚██████╔╝    ╚███╔███╔╝██║██║ ╚████║\r\n"
					+ "   ╚═╝    ╚═════╝  ╚═════╝      ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝\r\n"
					+ "                                                      ");
		}
		else {
			System.out.println("Incorrect, try again!");
		}
	}


	void commonLetters(char[] word1, char[] word2) {
		//reffered code 
		String commonLetters = "";
		for (int i = 0; i < 5; i++) {
			char c1 = word1[i];
			for (int j = 0; j < 5; j++) {
				char c2 = word2[j];
				if (c1 == c2 && commonLetters.indexOf(c1) == -1) {
					commonLetters += c1;
				}
			}
		}
		System.out.println("Common letters: " + commonLetters); 
	}


	void beginGame(Turdle obj) {
		char[] correctWord = obj.correctWordChooser();
		for(int i = 0; i <6; i++) {
			int chances = 6-i;
			System.out.print("You have "+ chances + " chances remaining, guess a word : ");
//			System.out.print("Enter a word: ");
			char[] wordEntered = obj.enteredWord();
			obj.ui(wordEntered);
			obj.guessChecker(correctWord, wordEntered);
			if(wordEntered.toString() == correctWord.toString()) {
				break;
			}
			commonLetters(correctWord, wordEntered);
			if(wordEntered.toString() != correctWord.toString() && i == 5) {
				System.out.println(""
						+ " ██████╗  █████╗ ███╗   ███╗███████╗     ██████╗ ██╗   ██╗███████╗██████╗ \r\n"
						+ "██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██╔═══██╗██║   ██║██╔════╝██╔══██╗\r\n"
						+ "██║  ███╗███████║██╔████╔██║█████╗      ██║   ██║██║   ██║█████╗  ██████╔╝\r\n"
						+ "██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗\r\n"
						+ "╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║\r\n"
						+ " ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝     ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝\r\n"
						+ "                                                                          ");
			}
		}
		String str = new String(correctWord);
		System.out.println("The correct answer was  " + str.toUpperCase());
	}


	public static void main(String[] args) {
	
		Turdle player1 = new Turdle();
		player1.beginGame(player1);
	}
}