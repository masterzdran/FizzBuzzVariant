package exercise.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import exercices.abstractions.IExercise;
import exercices.models.ExerciseTwo;



public class ExerciseTwoTests extends ExerciseOneTests{

	protected final String HasThreeMapWord = "good";

	private final String expectedResult = "1 2 good 4 systems CMAS 7 8 CMAS systems 11 CMAS good 14 CMASsystems 16 17 CMAS 19 systems";
	
	@Override
	@ParameterizedTest
	@ValueSource(ints = { 0, -1, Integer.MIN_VALUE })
	public void Process_NonPositiveNumbers_Should_Throw_IllegalArgumentException(int number) 
	{
		IExercise exercise = new ExerciseTwo();
		assertThrows(
				IllegalArgumentException.class, 
				() -> exercise.process(number)
				);
	}
	
	@Override
	@ParameterizedTest
	@CsvSource({"1,20"})
	public void ProcessRange_Should_Return_Expected_String(int startNumberIncluded, int endNumberExcluded) 
	{
		IExercise exercise = new ExerciseTwo();
		String result = exercise.processRange(startNumberIncluded, endNumberExcluded);
		assertEquals(expectedResult, result);
	}
	@Override
	@ParameterizedTest
	@ValueSource(ints = { 6, 9,12,18,21,24,27 })
	public void Process_MultiplesOfThree_And_Not_MultipleOfFiftheen_Should_Return_CMAS(int number)
	{
		IExercise exercise = new ExerciseTwo();
		String result = exercise.process(number);
		assertEquals(ThreeMapWord, result);
	}
	
	@ParameterizedTest
	@ValueSource(ints = { 3, 23,23,33,43 })
	public void Process_ContainsThree_Should_Return_GOOD(int number)
	{
		IExercise exercise = new ExerciseTwo();
		String result = exercise.process(number);
		assertEquals(HasThreeMapWord, result);
	}	

}
