
public class WordCounter {
	/**
	 * count syllable
	 * @param word
	 * @return syllable
	 */
	public static int countSyllables(String word){
		int syl = 0;
		char  c = ' ';
		State state = State.START;
		for (int i = 0 ; i < word.length() ; i++){
			c = word.charAt(i);
			if (c == '\'') continue;
			switch(state){
			case CONSONANT :
				if(isVowelOrY(c)){state = State.SINGLE_VOWEL; syl++;}
				else if (Character.isLetter(c));
				else if (c == '-') state = State.HYPHEN ;
				else state = State.NONWORD;
				break;
			case SINGLE_VOWEL :
				if(isVowel(c)) state = State.MULTIVOWEL;
				else if (c == '-') state = State.HYPHEN;
				else if (c == 'y') break;
				else if (Character.isLetter(c)){state = State.CONSONANT;}
				else state = State.NONWORD;
				break;
			case START :
				if (c == '-') state = State.NONWORD;
				else if(isVowelOrY(c)){state = State.SINGLE_VOWEL; syl++;}
				else if (Character.isLetter(c)) {state = State.CONSONANT;}
				else state = State.NONWORD;
				break;
			case MULTIVOWEL :
				if(c == '-'){state = State.HYPHEN;}
				else if(isVowel(c)){state = State.MULTIVOWEL;}
				else if(Character.isLetter(c)){state = State.CONSONANT;}
				else if (c == 'y') break;
				else state = State.NONWORD;
				break;
			case HYPHEN :
				if (c == '-'){state = State.NONWORD;}
				else if(isVowelOrY(c)){state = State.SINGLE_VOWEL; syl++;}
				else if (Character.isLetter(c)){state = State.CONSONANT;}
				else state = State.NONWORD;
				break;
			case NONWORD :
				if(isVowel(c)){state = State.SINGLE_VOWEL; syl++;}
				else if (Character.isLetter(c))state = State.CONSONANT;
				else state = State.NONWORD;
			
			}
		}
		return syl;
	}
	/**
	 * test if it is Vowel
	 * @param c
	 * @return
	 */
	public static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
	/**
	 * test if it is Vowel or Y
	 * @param c
	 * @return
	 */
	public static boolean isVowelOrY(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y';
	}
	
//	public void setState( State newstate ) {
//		
//		
//		if (newstate != state) newstate.enterState( );
//		state = newstate;
//		}

	
	
}
