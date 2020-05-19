package exercices.models;

import exercices.abstractions.IExercise;

public class ExerciseOne implements IExercise{

	@Override
	public String processRange(int startNumberIncluded, int endNumberIncluded) {
		if(startNumberIncluded > endNumberIncluded)
		{
			throw new IllegalArgumentException();
		}
		
		StringBuffer result = new StringBuffer();
		String output = null;
		
		int number = startNumberIncluded;
		output = process(number);
		result.append(output);
		number++;
		
		for(;number <= endNumberIncluded;number++) {
			result.append(' ');
			output = process(number);
			result.append(output);
			
		}
		return result.toString();
	}

	private final String ThreeMapWord = "CMAS";
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
		if ( number % 3 == 0) {
			return ThreeMapWord;
		}

		return number+"";
	}

}
