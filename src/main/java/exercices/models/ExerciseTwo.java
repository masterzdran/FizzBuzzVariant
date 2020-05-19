package exercices.models;

public class ExerciseTwo extends ExerciseOne {

	private final String ThreeMapWord = "CMAS";
	private final String HasThreeMapWord = "good";
	private final String FiveMapWord = "systems";
	private final String FiftheenMapWord = "CMASsystems";
	
	@Override
	public String process(int number) {
		if (number < 1) 
		{
			throw new IllegalArgumentException();
		}
		
		if ( number % 15 == 0) {
			return FiftheenMapWord;
		}
		
		if ( number % 5 == 0) {
			return FiveMapWord;
		}	
		if ( (number+"").indexOf('3') >= 0) {
			return HasThreeMapWord;
		}
		if ( number % 3 == 0) {
			return ThreeMapWord;
		}

		return number+"";
	}

}
